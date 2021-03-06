package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.*;
import br.com.geovanejunior.cursomc.domain.enums.EstadoPagamento;
import br.com.geovanejunior.cursomc.repositories.ItemPedidoRepository;
import br.com.geovanejunior.cursomc.repositories.PagamentoRepository;
import br.com.geovanejunior.cursomc.repositories.PedidoRepository;
import br.com.geovanejunior.cursomc.security.UserSS;
import br.com.geovanejunior.cursomc.service.exceptions.AutorizationException;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmailService emailService;

    public Pedido buscarPorId(Long id) {

        Optional<Pedido> obj = pedidoRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Pedido insertPedido(Pedido pedido) {

        // instanciando os dados da classe Pedido

        pedido.setId(null);
        pedido.setInstante(new Date());

        // instanciando os dados da classe Pedido

        pedido.setCliente(clienteService.findById(pedido.getCliente().getId()));

        // instanciando os dados da Classe Pagamento

        pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);

        if (pedido.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagamentoComBoleto = (PagamentoComBoleto) pedido.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagamentoComBoleto, pedido.getInstante());
        }

        // salvando os dados do pedido e pagamento no BD de Pedido e Pagamento

        pedido = pedidoRepository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());

        // instanciando os dados da classe ItemPedido

        for (ItemPedido ip : pedido.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.buscarPorId(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(pedido);
        }

        itemPedidoRepository.saveAll(pedido.getItens());

        System.out.println(pedido);

//        emailService.sendOrderConfirmationEmail(pedido);

//        emailService.sendOrderConfirmationHTMLEmail(pedido);

        return  pedido;
    }

    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

        UserSS user = UserService.authenticated();

        if (user == null) {
            throw new AutorizationException("Acesso negado");
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Cliente cliente = clienteService.findById(user.getId());

        return pedidoRepository.findByCliente(cliente, pageRequest);
    }
}
