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
        Produto prod10 = new Produto(null, "Sabonete", 2.89);
        Produto prod11 = new Produto(null, "Shampoo", 90.00);

        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
        cat3.getProdutos().addAll(Arrays.asList(prod5, prod6));
        cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
        cat5.getProdutos().addAll(Arrays.asList(prod8));
        cat6.getProdutos().addAll(Arrays.asList(prod9));
        cat7.getProdutos().addAll(Arrays.asList(prod10, prod11));

        prod1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        prod2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        prod3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        prod4.getCategorias().addAll(Arrays.asList(cat2));
        prod5.getCategorias().addAll(Arrays.asList(cat3));
        prod6.getCategorias().addAll(Arrays.asList(cat3));
        prod7.getCategorias().addAll(Arrays.asList(cat4));
        prod8.getCategorias().addAll(Arrays.asList(cat5));
        prod9.getCategorias().addAll(Arrays.asList(cat6));
        prod10.getCategorias().addAll(Arrays.asList(cat7));
        prod11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10,
                                                prod11));

        // Instanciando Estado

        Estado est1 = new Estado(null, "AC", "Acre");
        Estado est2 = new Estado(null, "AL", "Alagoas");
        Estado est3 = new Estado(null, "AP", "Amapá");
        Estado est4 = new Estado(null, "AM", "Amazonas");
        Estado est5 = new Estado(null, "BA", "Bahia");
        Estado est6 = new Estado(null, "CE", "Ceará");
        Estado est7 = new Estado(null, "DF", "Distrito Federal");
        Estado est8 = new Estado(null, "ES", "Espírito Santo");
        Estado est9 = new Estado(null, "GO", "Goiás");
        Estado est10 = new Estado(null, "MA", "Maranhão");
        Estado est11 = new Estado(null, "MT", "Mato Grosso");
        Estado est12 = new Estado(null, "MS", "Mato Grosso do Sul");
        Estado est13 = new Estado(null, "MG", "Minas Gerais");
        Estado est14 = new Estado(null, "PA", "Pará");
        Estado est15 = new Estado(null, "PB", "Paraíba");
        Estado est16 = new Estado(null, "PR", "Paraná");
        Estado est17 = new Estado(null, "PE", "Pernambuco");
        Estado est18 = new Estado(null, "PI", "Piauí");
        Estado est19 = new Estado(null, "RJ", "Rio de Janeiro");
        Estado est20 = new Estado(null, "RN", "Rio Grande do Norte");
        Estado est21 = new Estado(null, "RS", "Rio Grande do Sul");
        Estado est22 = new Estado(null, "RO", "Rondônia");
        Estado est23 = new Estado(null, "RR", "Roraima");
        Estado est24 = new Estado(null, "SC", "Santa Catarina");
        Estado est25 = new Estado(null, "SP", "São Paulo");
        Estado est26 = new Estado(null, "SE", "Sergipe");
        Estado est27 = new Estado(null, "TO", "Tocantins");


        Cidade cid1 = new Cidade(null, "Rio Branco", est1);
        Cidade cid2 = new Cidade(null, "Maceió", est2);
        Cidade cid3 = new Cidade(null, "Macapá", est3);
        Cidade cid4 = new Cidade(null, "Manaus", est4);
        Cidade cid5 = new Cidade(null, "Salvador", est5);
        Cidade cid6 = new Cidade(null, "Fortaleza", est6);
        Cidade cid7 = new Cidade(null, "Brasília", est7);
        Cidade cid8 = new Cidade(null, "Vitória", est8);
        Cidade cid9  = new Cidade(null, "Goiânia", est9);
        Cidade cid10 = new Cidade(null, "São Luís", est10);
        Cidade cid11 = new Cidade(null, "Cuiabá", est11);
        Cidade cid12 = new Cidade(null, "Campo Grande", est12);
        Cidade cid13 = new Cidade(null, "Belo Horizonte", est13);
        Cidade cid14 = new Cidade(null, "Belém", est14);
        Cidade cid15 = new Cidade(null, "João Pessoa", est15);
        Cidade cid16 = new Cidade(null, "Curitiba", est16);
        Cidade cid17 = new Cidade(null, "Recife", est17);
        Cidade cid18 = new Cidade(null, "Teresina", est18);
        Cidade cid19 = new Cidade(null, "Rio de Janeiro", est19);
        Cidade cid20 = new Cidade(null, "Natal", est20);
        Cidade cid21 = new Cidade(null, "Porto Alegre", est21);
        Cidade cid22 = new Cidade(null, "Porto Velho", est22);
        Cidade cid23 = new Cidade(null, "Boa Vista", est23);
        Cidade cid24 = new Cidade(null, "Florianópolis", est24);
        Cidade cid25 = new Cidade(null, "São Paulo", est25);
        Cidade cid26 = new Cidade(null, "Aracaju", est26);
        Cidade cid27 = new Cidade(null, "Palmas", est27);

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2));
        est3.getCidades().addAll(Arrays.asList(cid3));
        est4.getCidades().addAll(Arrays.asList(cid4));
        est5.getCidades().addAll(Arrays.asList(cid5));
        est6.getCidades().addAll(Arrays.asList(cid6));
        est7.getCidades().addAll(Arrays.asList(cid7));
        est8.getCidades().addAll(Arrays.asList(cid8));
        est9.getCidades().addAll(Arrays.asList(cid9));
        est10.getCidades().addAll(Arrays.asList(cid10));
        est11.getCidades().addAll(Arrays.asList(cid11));
        est12.getCidades().addAll(Arrays.asList(cid12));
        est13.getCidades().addAll(Arrays.asList(cid13));
        est14.getCidades().addAll(Arrays.asList(cid14));
        est15.getCidades().addAll(Arrays.asList(cid15));
        est16.getCidades().addAll(Arrays.asList(cid16));
        est17.getCidades().addAll(Arrays.asList(cid17));
        est18.getCidades().addAll(Arrays.asList(cid18));
        est19.getCidades().addAll(Arrays.asList(cid19));
        est20.getCidades().addAll(Arrays.asList(cid20));
        est21.getCidades().addAll(Arrays.asList(cid21));
        est22.getCidades().addAll(Arrays.asList(cid22));
        est23.getCidades().addAll(Arrays.asList(cid23));
        est24.getCidades().addAll(Arrays.asList(cid24));
        est25.getCidades().addAll(Arrays.asList(cid25));
        est26.getCidades().addAll(Arrays.asList(cid26));
        est27.getCidades().addAll(Arrays.asList(cid27));

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20, est21, est22, est23, est24, est25, est26, est27));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6, cid7, cid8, cid9, cid10, cid11, cid12, cid13, cid14, cid15, cid16, cid17, cid18, cid19, cid20, cid21, cid22, cid23, cid24, cid25, cid26, cid27));

        Cliente cli1 = new Cliente(null,"Geovane Soares Galvão Junior", "14856523830","geovane.gjunior@gmail.com", TipoCliente.PESSOAFISICA, bCryptPass.encode("586467"));
        cli1.getTelefones().addAll(Arrays.asList("11991231231"));
        cli1.addPerfil(Perfil.ADMIN);

        Endereco e1 = new Endereco(null, "Av João José Gomes","87", null, "Jd Antônio", "05376100", cli1, cid25);

        cli1.getEnderecos().addAll(Arrays.asList(e1));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 00:00"), cli1, e1);

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
