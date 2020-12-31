package br.com.geovanejunior.cursomc.service;

import br.com.geovanejunior.cursomc.domain.*;
import br.com.geovanejunior.cursomc.domain.enums.EstadoPagamento;
import br.com.geovanejunior.cursomc.domain.enums.Perfil;
import br.com.geovanejunior.cursomc.domain.enums.TipoCliente;
import br.com.geovanejunior.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPass;

    public void instantiateTestDatabase() throws ParseException {

        // Instanciando Categoria

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama Mesa & Banho");
        Categoria cat4 = new Categoria(null, "Eletrônicos");
        Categoria cat5 = new Categoria(null, "Jardinagem");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Perfumaria");

        // Instanciando Produto

        Produto prod1 = new Produto(null, "Computador", 2000.0);
        Produto prod2 = new Produto(null, "Impressora", 800.0);
        Produto prod3 = new Produto(null, "Mouse", 80.0);
        Produto prod4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto prod5 = new Produto(null, "Toalha", 50.00);
        Produto prod6 = new Produto(null, "Colcha", 200.00);
        Produto prod7 = new Produto(null, "TV true color", 1200.00);
        Produto prod8 = new Produto(null, "Roçadeira", 800.00);
        Produto prod9 = new Produto(null, "Abajour", 100.00);
        Produto prod10 = new Produto(null, "Pendente", 180.00);
        Produto prod11 = new Produto(null, "Shampoo", 90.00);


        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
        cat3.getProdutos().addAll(Arrays.asList(prod5, prod6));
        cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
        cat5.getProdutos().addAll(Arrays.asList(prod8));
        cat6.getProdutos().addAll(Arrays.asList(prod9, prod10));
        cat7.getProdutos().addAll(Arrays.asList(prod11));


        prod1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        prod2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        prod3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        prod4.getCategorias().addAll(Arrays.asList(cat2));
        prod5.getCategorias().addAll(Arrays.asList(cat3));
        prod6.getCategorias().addAll(Arrays.asList(cat3));
        prod7.getCategorias().addAll(Arrays.asList(cat4));
        prod8.getCategorias().addAll(Arrays.asList(cat5));
        prod9.getCategorias().addAll(Arrays.asList(cat6));
        prod10.getCategorias().addAll(Arrays.asList(cat6));
        prod11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11));

        // Instanciando Estado

        Estado est1 = new Estado(null, "RO", "Rondônia");
        Estado est2 = new Estado(null, "AC", "Acre");
        Estado est3 = new Estado(null, "AM", "Amazonas");
        Estado est4 = new Estado(null, "RR", "Roraima");
        Estado est5 = new Estado(null, "PA", "Pará");
        Estado est6 = new Estado(null, "AP", "Amapá");
        Estado est7 = new Estado(null, "TO", "Tocantins");
        Estado est8 = new Estado(null, "MA", "Maranhão");
        Estado est9 = new Estado(null, "PI", "Piauí");
        Estado est10 = new Estado(null, "CE", "Ceará");
        Estado est11 = new Estado(null, "RN", "Rio Grande do Norte");
        Estado est12 = new Estado(null, "PB", "Paraíba");
        Estado est13 = new Estado(null, "PE", "Pernambuco");
        Estado est14 = new Estado(null, "AL", "Alagoas");
        Estado est15 = new Estado(null, "SE", "Sergipe");
        Estado est16 = new Estado(null, "BA", "Bahia");
        Estado est17 = new Estado(null, "MG", "Minas Gerais");
        Estado est18 = new Estado(null, "ES", "Espírito Santo");
        Estado est19 = new Estado(null, "RJ", "Rio de Janeiro");
        Estado est20 = new Estado(null, "SP", "São Paulo");
        Estado est21 = new Estado(null, "PR", "Paraná");
        Estado est22 = new Estado(null, "SC", "Santa Catarina");
        Estado est23 = new Estado(null, "RS", "Rio Grande do Sul");
        Estado est24 = new Estado(null, "MS", "Mato Grosso do Sul");
        Estado est25 = new Estado(null, "MT", "Mato Grosso");
        Estado est26 = new Estado(null, "GO", "Goiás");
        Estado est27 = new Estado(null, "DF", "Distrito Federal");

        Cidade cid1 = new Cidade(null, "Uberlândia", est17);
        Cidade cid2 = new Cidade(null, "São Paulo", est20);
        Cidade cid3 = new Cidade(null, "Campinas", est20);

        est20.getCidades().addAll(Arrays.asList(cid2, cid3));
        est17.getCidades().addAll(Arrays.asList(cid1));

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20, est21, est22, est23, est24, est25, est26, est27));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null,"Geovane Soares Galvão Junior", "14856523830","geovane.gjunior@gmail.com", TipoCliente.PESSOAFISICA, bCryptPass.encode("123456"));
        cli1.getTelefones().addAll(Arrays.asList("11991231231"));

        Cliente cli2 = new Cliente(null,"Geovane Junior Curso","12345678909","geovane.gjunior.curso@gmail.com", TipoCliente.PESSOAFISICA, bCryptPass.encode("586467"));
        cli2.getTelefones().addAll(Arrays.asList("11999468056", "11982854499"));
        cli2.addPerfil(Perfil.ADMIN);

        Endereco e1 = new Endereco(null, "Rua Flores","300", "Apto 203", "Jardim", "38220834", cli1, cid1);
        Endereco e2 = new Endereco(null, "Av Mattos","105", "Sala 800", "Centro", "38777012", cli1, cid2);
        Endereco e3 = new Endereco(null, "Av João José Gomes","87", null, "Jd Antônio", "05376100", cli2, cid2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 00:00"), cli1, e2);

        Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pgto1);

        Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pgto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

        ItemPedido ip1 = new ItemPedido(ped1, prod1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, prod3, 5.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, prod2, 10.00, 1, 800.00);
        ItemPedido ip4 = new ItemPedido(ped1, prod9, 20.00, 4, prod9.getPreco());

        ped1.getItens().addAll(Arrays.asList(ip1, ip2, ip4));
        ped2.getItens().addAll(Arrays.asList(ip3));

        prod1.getItens().addAll(Arrays.asList(ip1));
        prod2.getItens().addAll(Arrays.asList(ip3));
        prod3.getItens().addAll(Arrays.asList(ip2));
        prod9.getItens().addAll(Arrays.asList(ip4));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

    }
}
