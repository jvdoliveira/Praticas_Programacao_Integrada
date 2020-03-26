package at1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pais {
	
	private int id;
	private String nome;
	private long populacao;
	private double area;
	public Pais[] vetor = new Pais[3];
	public ArrayList< Pais > listaPais = new ArrayList< Pais >();
	public Pais(int id, String nome, long populacao, double area) {
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	public Pais (int id) {
		this.id = id;
	}
	public Pais() {}
	static {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
		}
    }
	
	public Connection obtemConexao() throws SQLException {
		return DriverManager
		.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=America/Sao_Paulo&user=Alunos&password=alunos&useSSL=false");
		}
	
	
	public void criar() {
		String sqlInsert = "INSERT INTO pais(Nome, Populacao, Area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setString(1, getNome());
		stm.setLong(2, getPopulacao());
		stm.setDouble(3, getArea());
		stm.execute();
		String sqlQuery = "SELECT LAST_INSERT_ID()";
		try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
		ResultSet rs = stm2.executeQuery();) {
		if(rs.next()){
		setId(rs.getInt(1));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	
		public void atualizar() {
		String sqlUpdate = "UPDATE Pais SET Nome=?, Populacao=?, Area=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setString(1, getNome());
		stm.setLong(2, getPopulacao());
		stm.setDouble(3, getArea());
		stm.setInt(4, getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		
		public void excluir() {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
		stm.setInt(1, getId());
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		
		public void carregar() {
		String sqlSelect = "SELECT Nome, Populacao, Area FROM pais WHERE pais.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
		stm.setInt(1, getId());
		try (ResultSet rs = stm.executeQuery();) {
		if (rs.next()) {
		setNome(rs.getString("Nome"));
		setPopulacao(rs.getLong("Populacao"));
		setArea(rs.getDouble("Area"));
		} else {
		setId(-1);
		setNome(null);
		setPopulacao(0);
		setArea(0);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} catch (SQLException e1) {
		System.out.print(e1.getStackTrace());
		}
		}

		public void carregarMax() {
			String sqlSelect = "select Nome,Populacao,Area from pais where Populacao = (select max(populacao) from pais);";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
			setNome(rs.getString("Nome"));
			setPopulacao(rs.getLong("Populacao"));
			setArea(rs.getDouble("Area"));
			} else {
			setId(-1);
			setNome(null);
			setPopulacao(0);
			setArea(0);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			}
			}
	
		
		public void carregarMin() {
			String sqlSelect = "select Nome,Populacao,Area from pais where Area = (select min(area) from pais);";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
			setNome(rs.getString("Nome"));
			setPopulacao(rs.getLong("Populacao"));
			setArea(rs.getDouble("Area"));
			} else {
			setId(-1);
			setNome(null);
			setPopulacao(0);
			setArea(0);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			}
			}
	
		public Pais carregar3() {
			Pais pais =new Pais();
			String sqlSelect = "SELECT nome, populacao, area FROM pais limit 3";
			// usando o try with resources do Java 7, quefecha o queabriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						pais = new Pais();
						setNome(rs.getString("Nome"));
						setPopulacao(rs.getLong("Populacao"));
						setArea(rs.getDouble("Area"));
						listaPais.add(pais);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return pais;
		}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	public String toString() {
		return "Pais =" + getNome() + ", Populacao =" + getPopulacao() + ", Area = " + getArea() + "";
	}


}
