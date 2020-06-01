package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {

	public UsuarioDAO() {
		
	}
	
	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT senha FROM usuario WHERE usuario.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setSenha(rs.getString("senha"));
				} else {
					usuario.setId(-1);
					usuario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
	
	
	public Usuario logar(String user) {
		String sqlSelect = "SELECT * FROM usuario where nome = ?";
		Usuario login = new Usuario();
		login.setLogin(user);
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, login.getLogin());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					login.setId(rs.getInt("id"));
					login.setNome(rs.getString("nome"));
					login.setSenha(rs.getString("senha"));
				} else {
					login.setId(0);
					login.setLogin(null);
					login.setNome(null);
					login.setSenha(null);
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return login;
	}
	
}
