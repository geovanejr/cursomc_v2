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
        Categoria cat8 = new Categoria(null, "Diversos");

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
        Produto prod12 = new Produto(null, "Produto12", 120.0);
        Produto prod13 = new Produto(null, "Produto13", 120.1);
        Produto prod14 = new Produto(null, "Produto14", 120.2);
        Produto prod15 = new Produto(null, "Produto15", 120.3);
        Produto prod16 = new Produto(null, "Produto16", 120.4);
        Produto prod17 = new Produto(null, "Produto17", 120.5);
        Produto prod18 = new Produto(null, "Produto18", 120.6);
        Produto prod19 = new Produto(null, "Produto19", 120.7);
        Produto prod20 = new Produto(null, "Produto20", 120.8);
        Produto prod21 = new Produto(null, "Produto21", 120.9);
        Produto prod22 = new Produto(null, "Produto22", 120.10);
        Produto prod23 = new Produto(null, "Produto23", 120.11);
        Produto prod24 = new Produto(null, "Produto24", 120.12);
        Produto prod25 = new Produto(null, "Produto25", 120.13);
        Produto prod26 = new Produto(null, "Produto26", 120.14);
        Produto prod27 = new Produto(null, "Produto27", 120.15);
        Produto prod28 = new Produto(null, "Produto28", 120.16);
        Produto prod29 = new Produto(null, "Produto29", 120.17);
        Produto prod30 = new Produto(null, "Produto30", 120.18);
        Produto prod31 = new Produto(null, "Produto31", 120.19);
        Produto prod32 = new Produto(null, "Produto32", 120.20);
        Produto prod33 = new Produto(null, "Produto33", 120.21);
        Produto prod34 = new Produto(null, "Produto34", 120.22);
        Produto prod35 = new Produto(null, "Produto35", 120.23);
        Produto prod36 = new Produto(null, "Produto36", 120.24);
        Produto prod37 = new Produto(null, "Produto37", 120.25);
        Produto prod38 = new Produto(null, "Produto38", 120.26);
        Produto prod39 = new Produto(null, "Produto39", 120.27);
        Produto prod40 = new Produto(null, "Produto40", 120.28);
        Produto prod41 = new Produto(null, "Produto41", 120.29);
        Produto prod42 = new Produto(null, "Produto42", 120.30);
        Produto prod43 = new Produto(null, "Produto43", 120.31);
        Produto prod44 = new Produto(null, "Produto44", 120.32);
        Produto prod45 = new Produto(null, "Produto45", 120.33);
        Produto prod46 = new Produto(null, "Produto46", 120.34);
        Produto prod47 = new Produto(null, "Produto47", 120.35);
        Produto prod48 = new Produto(null, "Produto48", 120.36);
        Produto prod49 = new Produto(null, "Produto49", 120.37);
        Produto prod50 = new Produto(null, "Produto50", 120.38);
        Produto prod51 = new Produto(null, "Produto51", 120.39);
        Produto prod52 = new Produto(null, "Produto52", 120.40);
        Produto prod53 = new Produto(null, "Produto53", 120.41);
        Produto prod54 = new Produto(null, "Produto54", 120.42);
        Produto prod55 = new Produto(null, "Produto55", 120.43);
        Produto prod56 = new Produto(null, "Produto56", 120.44);
        Produto prod57 = new Produto(null, "Produto57", 120.45);
        Produto prod58 = new Produto(null, "Produto58", 120.46);
        Produto prod59 = new Produto(null, "Produto59", 120.47);
        Produto prod60 = new Produto(null, "Produto60", 120.48);
        Produto prod61 = new Produto(null, "Produto61", 120.49);
        Produto prod62 = new Produto(null, "Produto62", 120.50);
        Produto prod63 = new Produto(null, "Produto63", 120.51);
        Produto prod64 = new Produto(null, "Produto64", 120.52);
        Produto prod65 = new Produto(null, "Produto65", 120.53);
        Produto prod66 = new Produto(null, "Produto66", 120.54);
        Produto prod67 = new Produto(null, "Produto67", 120.55);
        Produto prod68 = new Produto(null, "Produto68", 120.56);
        Produto prod69 = new Produto(null, "Produto69", 120.57);
        Produto prod70 = new Produto(null, "Produto70", 120.58);
        Produto prod71 = new Produto(null, "Produto71", 120.59);
        Produto prod72 = new Produto(null, "Produto72", 120.60);
        Produto prod73 = new Produto(null, "Produto73", 120.61);
        Produto prod74 = new Produto(null, "Produto74", 120.62);
        Produto prod75 = new Produto(null, "Produto75", 120.63);
        Produto prod76 = new Produto(null, "Produto76", 120.64);
        Produto prod77 = new Produto(null, "Produto77", 120.65);
        Produto prod78 = new Produto(null, "Produto78", 120.66);
        Produto prod79 = new Produto(null, "Produto79", 120.67);
        Produto prod80 = new Produto(null, "Produto80", 120.68);
        Produto prod81 = new Produto(null, "Produto81", 120.69);
        Produto prod82 = new Produto(null, "Produto82", 120.70);
        Produto prod83 = new Produto(null, "Produto83", 120.71);
        Produto prod84 = new Produto(null, "Produto84", 120.72);
        Produto prod85 = new Produto(null, "Produto85", 120.73);
        Produto prod86 = new Produto(null, "Produto86", 120.74);
        Produto prod87 = new Produto(null, "Produto87", 120.75);
        Produto prod88 = new Produto(null, "Produto88", 120.76);
        Produto prod89 = new Produto(null, "Produto89", 120.77);
        Produto prod90 = new Produto(null, "Produto90", 120.78);
        Produto prod91 = new Produto(null, "Produto91", 120.79);
        Produto prod92 = new Produto(null, "Produto92", 120.80);
        Produto prod93 = new Produto(null, "Produto93", 120.81);
        Produto prod94 = new Produto(null, "Produto94", 120.82);
        Produto prod95 = new Produto(null, "Produto95", 120.83);
        Produto prod96 = new Produto(null, "Produto96", 120.84);
        Produto prod97 = new Produto(null, "Produto97", 120.85);
        Produto prod98 = new Produto(null, "Produto98", 120.86);
        Produto prod99 = new Produto(null, "Produto99", 120.87);
        Produto prod100 = new Produto(null, "Produto100", 120.88);

        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2, prod4));
        cat3.getProdutos().addAll(Arrays.asList(prod5, prod6));
        cat4.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
        cat5.getProdutos().addAll(Arrays.asList(prod8));
        cat6.getProdutos().addAll(Arrays.asList(prod9, prod10));
        cat7.getProdutos().addAll(Arrays.asList(prod11));
        cat8.getProdutos().addAll(Arrays.asList(prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20, prod21,
                                                prod22, prod23, prod24, prod25, prod26, prod27, prod28, prod29, prod30, prod31,
                                                prod32, prod33, prod34, prod35, prod36, prod37, prod38, prod39, prod40, prod41,
                                                prod42, prod43, prod44, prod45, prod46, prod47, prod48, prod49, prod50, prod51,
                                                prod52, prod53, prod54, prod55, prod56, prod57, prod58, prod59, prod60, prod61,
                                                prod62, prod63, prod64, prod65));


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
        prod12.getCategorias().addAll(Arrays.asList(cat8));
        prod13.getCategorias().addAll(Arrays.asList(cat8));
        prod14.getCategorias().addAll(Arrays.asList(cat8));
        prod15.getCategorias().addAll(Arrays.asList(cat8));
        prod16.getCategorias().addAll(Arrays.asList(cat8));
        prod17.getCategorias().addAll(Arrays.asList(cat8));
        prod18.getCategorias().addAll(Arrays.asList(cat8));
        prod19.getCategorias().addAll(Arrays.asList(cat8));
        prod20.getCategorias().addAll(Arrays.asList(cat8));
        prod21.getCategorias().addAll(Arrays.asList(cat8));
        prod22.getCategorias().addAll(Arrays.asList(cat8));
        prod23.getCategorias().addAll(Arrays.asList(cat8));
        prod24.getCategorias().addAll(Arrays.asList(cat8));
        prod25.getCategorias().addAll(Arrays.asList(cat8));
        prod26.getCategorias().addAll(Arrays.asList(cat8));
        prod27.getCategorias().addAll(Arrays.asList(cat8));
        prod28.getCategorias().addAll(Arrays.asList(cat8));
        prod29.getCategorias().addAll(Arrays.asList(cat8));
        prod30.getCategorias().addAll(Arrays.asList(cat8));
        prod31.getCategorias().addAll(Arrays.asList(cat8));
        prod32.getCategorias().addAll(Arrays.asList(cat8));
        prod33.getCategorias().addAll(Arrays.asList(cat8));
        prod34.getCategorias().addAll(Arrays.asList(cat8));
        prod35.getCategorias().addAll(Arrays.asList(cat8));
        prod36.getCategorias().addAll(Arrays.asList(cat8));
        prod37.getCategorias().addAll(Arrays.asList(cat8));
        prod38.getCategorias().addAll(Arrays.asList(cat8));
        prod39.getCategorias().addAll(Arrays.asList(cat8));
        prod40.getCategorias().addAll(Arrays.asList(cat8));
        prod41.getCategorias().addAll(Arrays.asList(cat8));
        prod42.getCategorias().addAll(Arrays.asList(cat8));
        prod43.getCategorias().addAll(Arrays.asList(cat8));
        prod44.getCategorias().addAll(Arrays.asList(cat8));
        prod45.getCategorias().addAll(Arrays.asList(cat8));
        prod46.getCategorias().addAll(Arrays.asList(cat8));
        prod47.getCategorias().addAll(Arrays.asList(cat8));
        prod48.getCategorias().addAll(Arrays.asList(cat8));
        prod49.getCategorias().addAll(Arrays.asList(cat8));
        prod50.getCategorias().addAll(Arrays.asList(cat8));
        prod51.getCategorias().addAll(Arrays.asList(cat8));
        prod52.getCategorias().addAll(Arrays.asList(cat8));
        prod53.getCategorias().addAll(Arrays.asList(cat8));
        prod54.getCategorias().addAll(Arrays.asList(cat8));
        prod55.getCategorias().addAll(Arrays.asList(cat8));
        prod56.getCategorias().addAll(Arrays.asList(cat8));
        prod57.getCategorias().addAll(Arrays.asList(cat8));
        prod58.getCategorias().addAll(Arrays.asList(cat8));
        prod59.getCategorias().addAll(Arrays.asList(cat8));
        prod60.getCategorias().addAll(Arrays.asList(cat8));
        prod61.getCategorias().addAll(Arrays.asList(cat8));
        prod62.getCategorias().addAll(Arrays.asList(cat8));
        prod63.getCategorias().addAll(Arrays.asList(cat8));
        prod64.getCategorias().addAll(Arrays.asList(cat8));
        prod65.getCategorias().addAll(Arrays.asList(cat8));


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10,
                                                prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20,
                                                prod20, prod21, prod22, prod23, prod24, prod25, prod26, prod27, prod28, prod29,
                                                prod30, prod31, prod32, prod33, prod34, prod35, prod36, prod37, prod38, prod39,
                                                prod40, prod41, prod42, prod43, prod44, prod45, prod46, prod47, prod48, prod49,
                                                prod50, prod51, prod52, prod53, prod54, prod55, prod56, prod57, prod58, prod59,
                                                prod60, prod61, prod62, prod63, prod64, prod65));

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

        Cliente cli1 = new Cliente(null,"Geovane Soares Galvão Junior", "14856523830","geovane.gjunior@gmail.com", TipoCliente.PESSOAFISICA, bCryptPass.encode("123456"));
        cli1.getTelefones().addAll(Arrays.asList("11991231231"));

        Cliente cli2 = new Cliente(null,"Geovane Junior Curso","12345678909","geovane.gjunior.curso@gmail.com", TipoCliente.PESSOAFISICA, bCryptPass.encode("586467"));
        cli2.getTelefones().addAll(Arrays.asList("11999468056", "11982854499"));
        cli2.addPerfil(Perfil.ADMIN);

        Endereco e1 = new Endereco(null, "Rua Flores","300", "Apto 203", "Jardim", "38220834", cli1, cid13);
        Endereco e2 = new Endereco(null, "Av Mattos","105", "Sala 800", "Centro", "38777012", cli1, cid13);
        Endereco e3 = new Endereco(null, "Av João José Gomes","87", null, "Jd Antônio", "05376100", cli2, cid25);

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
