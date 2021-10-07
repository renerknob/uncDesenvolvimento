package br.unc.rener.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.unc.rener.Funcionario;
import br.unc.rener.database.MysqlSingleton;

public class FuncionarioDao {

	private Connection connection;
	public FuncionarioDao(){
		this.connection = MysqlSingleton.getConnection();
		
	}
	public boolean inserir(Funcionario funcionario) {
		String sql = "INSERT INTO farmacia.funcionario (nome, cpf, rg, endereco, pis, pasep, carteiratrabalho, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setString(3, funcionario.getRg());
			stmt.setString(4, funcionario.getEndereco());
			stmt.setString(5, funcionario.getPis());
			stmt.setString(6, funcionario.getPasep());
			stmt.setString(7, funcionario.getCarteiraTrabalho());
			stmt.setDouble(8, funcionario.getSalario());
			stmt.execute();
			return true;
		} catch (Exception e) {
			Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
	}
	
	public List<Funcionario> listar() {
		String sql = "SELECT * FROM  funcionario";
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setRg(resultado.getString("rg"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setEndereco(resultado.getString("endereco"));
				funcionario.setPis(resultado.getString("pis"));
				funcionario.setPasep(resultado.getString("pasep"));
				funcionario.setCarteiraTrabalho(resultado.getString("carteira trabalho"));
				funcionario.setSalario(resultado.getDouble("salario"));
				listaFuncionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaFuncionarios;
	}

public boolean alterar(Funcionario funcionario) {
		String sql = "UPDATE funcionario SET nome=?, rg=?, cpf=?, endereco=?, pis=?, pasep=?, carteiratrabalho=?, salario=?  WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getRg());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(5, funcionario.getEndereco());
			stmt.setString(4, funcionario.getPis());
			stmt.setString(4, funcionario.getPasep());
			stmt.setString(4, funcionario.getCarteiraTrabalho());
			stmt.setDouble(4, funcionario.getSalario());
			stmt.setInt(6, funcionario.getId());
			stmt.execute();
			return true;
	} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
		return false;
		}
	}



	public boolean remover(Funcionario funcionario) {
	String sql = "DELETE FROM funcionario WHERE id=?";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, funcionario.getId());
		stmt.execute();
		return true;
	} catch (SQLException ex) {
		Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
		return false;
	}	
}

	public Funcionario buscar(Integer id) {
		String sql = "SELECT * FROM funcionario WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet resultado = stmt.executeQuery();
			Funcionario funcionario = new Funcionario();
			if (resultado.next()) {
				funcionario.setId(resultado.getInt("id"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setRg(resultado.getString("rg"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setEndereco(resultado.getString("endereco"));
				funcionario.setPis(resultado.getString("pis"));
				funcionario.setPasep(resultado.getString("pasep"));
				funcionario.setCarteiraTrabalho(resultado.getString("carteiratrabalho"));
				funcionario.setSalario(resultado.getDouble("salario"));
				return funcionario;
			}
		} catch (SQLException ex) {
			Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
			}
		return null;
		}
}
