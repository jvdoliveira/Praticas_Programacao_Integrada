package test;

import org.junit.jupiter.api.Test;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioTest {
     
	UsuarioDAO dao = new UsuarioDAO();
	
	@Test
	public void test00Carregar() {
		System.out.println("-------------------------Carregar-------------------------");
		Usuario novo = dao.carregar(1);
		System.out.println(novo+"\n");
		//assertEquals("testa inclusao", novo, fixture);
	}
}
