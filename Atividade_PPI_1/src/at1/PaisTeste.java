package at1;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, copia;
	static int id = 0;
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete.
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente.
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */

	@Before
	public void setUp() throws Exception {
		pais = new Pais(id, "China", 1379302771, 9596961);
		copia = new Pais(id, "China", 1379302771, 9596961);
		/*
		 * System.out.println(pais); System.out.println(copia); System.out.println(id);
		 */
	}
	@Test
	public void test00Carregar() {
		System.out.println("Carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(12, "Australia", 23401892, 7692024 );
		//Pais novo = new Pais(10, null, null, null);
		Pais novo = new Pais(12);
		novo.carregar();
		System.out.println(novo+"\n");
		//assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("Criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id+"\n");
		copia.setId(id);
		//assertEquals("testa criacao", pais, copia);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("Atualizar");
		System.out.println(pais);
		pais.setPopulacao(555555555);
		copia.setPopulacao(555555555);
		pais.atualizar();
		System.out.println("Atualizado com sucesso");
		pais.carregar();
		System.out.println(pais+"\n");
		//assertEquals("testa atualizacao", pais, copia);
	}

	@Test public void test03Excluir() { 
	System.out.println("Excluir");
	copia.setId(-1); 
	copia.setNome(null); 
	copia.setPopulacao(0);
	copia.setArea(0); 
	System.out.println(pais);
	pais.excluir(); 
	System.out.println("Excluido com sucesso");
	pais.carregar();
	System.out.println(pais+"\n");
	//assertEquals("testa exclusao", pais, copia); 
	}


	@Test
	public void test04CarregarMax() {
		System.out.println("CarregarMAX");
		Pais novo = new Pais();
		novo.carregarMax();
		System.out.println(novo+"\n");
		//assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test05CarregarMin() {
		System.out.println("CarregarMIN");
		Pais novo = new Pais();
		novo.carregarMin();
		System.out.println(novo+"\n");
		//assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test06Carregar3() {
		System.out.println("Vetor");
		Pais novo = new Pais();
		novo.carregar3();
		for(Pais pp: novo.listaPais) {
			System.out.println(pp);
		}
		//assertEquals("testa inclusao", novo, fixture);
	}
}