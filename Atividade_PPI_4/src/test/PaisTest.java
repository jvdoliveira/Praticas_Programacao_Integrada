package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	@Before
	public void setUp() throws Exception {
		pais = new Pais();
		pais.setId(id);
		pais.setNome("China");
		pais.setPopulacao(1379302771);
		pais.setArea(9596961);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("China");
		copia.setPopulacao(1379302771);
		copia.setArea(9596961);
		paisService = new PaisService();
		//System.out.println(pais);
		//System.out.println(copia);
		//System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("-------------------------Carregar-------------------------");
		Pais fixture = new Pais();
		fixture.setId(12);
		fixture.setNome("Australia");
		fixture.setPopulacao(23401892);
		fixture.setArea(7692024);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(12);
		System.out.println(novo+"\n");
		//assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("-------------------------Criar-------------------------");
		id = paisService.criar(pais);
		System.out.println(id+"\n");
		copia.setId(id);
		//assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("-------------------------Atualizar-------------------------");
		System.out.println(pais);
		pais.setPopulacao(555555555);
		copia.setPopulacao(555555555);		
		paisService.atualizar(pais);
		System.out.println("Atualizado com sucesso");
		pais = paisService.carregar(pais.getId());
		System.out.println(pais+"\n");
		//assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("-------------------------Excluir-------------------------");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		System.out.println(pais);
		paisService.excluir(id);
		System.out.println("Excluido com sucesso");
		pais = paisService.carregar(id);
		System.out.println(pais+"\n");
		//assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04CarregarMax() {
		System.out.println("-------------------------CarregarMAX-------------------------");
		Pais novo = paisService.carregarMax(12);
		System.out.println(novo+"\n");
	}
	
	@Test
	public void test05CarregarMin() {
		System.out.println("-------------------------CarregarMIN-------------------------");
		//PaisService novoService = new PaisService();
		Pais novo = paisService.carregarMin(12);
		System.out.println(novo+"\n");
	}

	@Test
	public void test06Carregar3() {
		System.out.println("-------------------------Carregar3-------------------------");
		//PaisService novoService = new PaisService();
		ArrayList<Pais> novo = paisService.carregar3();
		for(Pais pp: novo) {
			System.out.println(pp);
		}
	}
	
}