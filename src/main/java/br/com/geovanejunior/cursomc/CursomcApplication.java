package br.com.geovanejunior.cursomc;

import br.com.geovanejunior.cursomc.domain.Categoria;
import br.com.geovanejunior.cursomc.domain.Cidade;
import br.com.geovanejunior.cursomc.domain.Estado;
import br.com.geovanejunior.cursomc.domain.Produto;
import br.com.geovanejunior.cursomc.repositories.CategoriaRepository;
import br.com.geovanejunior.cursomc.repositories.CidadeRepository;
import br.com.geovanejunior.cursomc.repositories.EstadoRepository;
import br.com.geovanejunior.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Instanciando Categoria

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Jardinagem");

		Thread.sleep(1800);

		// Instanciando Produto

		Produto prod1 = new Produto(null, "Computador", 2000.0);
		Produto prod2 = new Produto(null, "Impressora", 800.0);
		Produto prod3 = new Produto(null, "Mouse", 80.0);
		Produto prod4 = new Produto(null, "Terra para adubar", 120.0);

		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod3));
		cat3.getProdutos().addAll(Arrays.asList(prod4));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod4.getCategorias().addAll(Arrays.asList(cat3));

		// Instanciando Estado

		Estado est1 = new Estado(null, "São Paulo", "SP");
		Estado est2 = new Estado(null, "Minas Gerais", "MG");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

		Cidade cid1 = new Cidade(null, "Uberlândia", est2);
		Cidade cid2 = new Cidade(null, "São Paulo", est1);
		Cidade cid3 = new Cidade(null, "Campinas", est1);

		est1.getCidades().addAll(Arrays.asList(cid2, cid3));
		est2.getCidades().addAll(Arrays.asList(cid1));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

	}
}
