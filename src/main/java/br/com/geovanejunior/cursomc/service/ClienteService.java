package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.Cidade;
import br.com.geovanejunior.cursomc.domain.Cliente;
import br.com.geovanejunior.cursomc.domain.Endereco;
import br.com.geovanejunior.cursomc.domain.enums.Perfil;
import br.com.geovanejunior.cursomc.domain.enums.TipoCliente;
import br.com.geovanejunior.cursomc.dto.ClienteDTO;
import br.com.geovanejunior.cursomc.dto.ClienteNewDTO;
import br.com.geovanejunior.cursomc.repositories.ClienteRepository;
import br.com.geovanejunior.cursomc.repositories.EnderecoRepository;
import br.com.geovanejunior.cursomc.security.UserSS;
import br.com.geovanejunior.cursomc.service.exceptions.AutorizationException;
import br.com.geovanejunior.cursomc.service.exceptions.DataIntegrityException;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPass;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ImageService imageService;

    @Value("${img.prefix.client.profile}")
    private String prefix;

    @Value("${img.profile.size}")
    private Integer size;

    public Cliente findById(Long id) {

        UserSS user = UserService.authenticated();

        if (user == null || !user.hasHole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AutorizationException("Acesso Negado");
        }

        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insertCliente(Cliente cliente) {

        cliente.setId(null);

        cliente = clienteRepository.save(cliente);

        enderecoRepository.saveAll(cliente.getEnderecos());

        return cliente;

    }

    public Cliente updateCliente(Cliente cliente) {

        Cliente newObj = findById(cliente.getId());
        updateData(newObj, cliente);
        return clienteRepository.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente cliente) {

        newObj.setNome(cliente.getNome());
        newObj.setEmail(cliente.getEmail());
        newObj.setDataAtualizacao(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }

    public void deleteCliente(Long id) {

        findById(id);

        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas!");
        }
    }

    public List<Cliente> findAllCliente() {
        return clienteRepository.findAll();
    }

    public Cliente findByEmail(String email) {

        UserSS user = UserService.authenticated();

        if (user == null || !user.hasHole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
            throw new AutorizationException("Acesso Negado");
        }

        Cliente obj = clienteRepository.findByEmail(email);

        if (obj == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
        }

        return obj;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return clienteRepository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {

        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), null, clienteDTO.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {

        Cliente cliente = new Cliente(null, clienteNewDTO.getNome(),
                                               clienteNewDTO.getCpfOUCNPJ(),
                                               clienteNewDTO.getEmail(),
                                               TipoCliente.toEnum(clienteNewDTO.getTipoCliente()),
                                               bCryptPass.encode(clienteNewDTO.getSenha()));

        Cidade cidade = new Cidade(clienteNewDTO.getCidadeId(), null, null);

        Endereco endereco = new Endereco(null, clienteNewDTO.getLogradouro(),
                clienteNewDTO.getNumero(),
                clienteNewDTO.getComplemento(),
                clienteNewDTO.getBairro(),
                clienteNewDTO.getCep(),
                cliente,
                cidade);

        cliente.getEnderecos().add(endereco);

        cliente.getTelefones().add(clienteNewDTO.getTelefone1());

        if (clienteNewDTO.getTelefone2() != null) {
            cliente.getTelefones().add(clienteNewDTO.getTelefone2());
        }

        if (clienteNewDTO.getTelefone2() != null) {
            cliente.getTelefones().add(clienteNewDTO.getTelefone2());
        }

        return cliente;
    }

    public URI uploadProfilePicture(MultipartFile multipartFile) {

        UserSS user = UserService.authenticated();

        if (user == null) {
            throw new AutorizationException("Acesso Negado");
        }

        BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);

        jpgImage = imageService.cropSquare(jpgImage);
        jpgImage = imageService.resize(jpgImage, size);

        String fileName = prefix + user.getId() + ".jpg";

        return s3Service.uploadFile(imageService.getInputStrem(jpgImage, "jpg"), fileName, "image");
    }
}
