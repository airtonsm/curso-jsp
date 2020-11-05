package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCusdoJsp;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(BeanCusdoJsp usuario) {
		
		try {
		String sql = "insert into usuario(login, senha, nome, telefone) values (?, ?, ?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		insert.setString(3, usuario.getNome());
		insert.setString(4, usuario.getTelefone());
		insert.execute();
		connection.commit();
		
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public List<BeanCusdoJsp> listar() throws Exception{
		List<BeanCusdoJsp> listar = new ArrayList<BeanCusdoJsp>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			
			BeanCusdoJsp beanCusdoJsp = new BeanCusdoJsp();
			beanCusdoJsp.setId(resultSet.getLong("id"));
			beanCusdoJsp.setLogin(resultSet.getString("login"));
			beanCusdoJsp.setSenha(resultSet.getString("senha"));
			beanCusdoJsp.setNome(resultSet.getString("nome"));
			beanCusdoJsp.setTelefone(resultSet.getString("telefone"));
			
			listar.add(beanCusdoJsp);
		}
		
		return listar;
	}
	
	public void delete(String id) {
		
		try {
		String sql = "delete from usuario where id = '" + id + "'";
		PreparedStatement statement = connection
				.prepareStatement(sql);
		statement.execute();
		connection.commit();
		
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public BeanCusdoJsp consultar(String id) throws Exception{
		String sql = "select * from usuario where id  = '" + id + "'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		if(resultSet.next()) {			
			BeanCusdoJsp beanCusdoJsp = new BeanCusdoJsp();
			beanCusdoJsp.setId(resultSet.getLong("id"));
			beanCusdoJsp.setLogin(resultSet.getString("login"));
			beanCusdoJsp.setSenha(resultSet.getString("senha"));
			beanCusdoJsp.setNome(resultSet.getString("nome"));
			beanCusdoJsp.setTelefone(resultSet.getString("telefone"));
			
			return beanCusdoJsp;
		}
		return null;
	}
	
	public boolean validarLogin(String login) throws Exception{
		String sql = "select count(1) as qtd from usuario where login  = '" + login + "'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		if(resultSet.next()) {	
			
			return resultSet.getInt("qtd") <=0;
		}
		
		return false;
	}
	
	public boolean validarSenha(String senha) throws Exception{
		String sql = "select count(1) as qtd from usuario where senha = '" + senha + "'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		if(resultSet.next()) {					
			
			return resultSet.getInt("qtd") <=0;
		}
		
		return false;
	}
	
	public boolean validarLoginUpdate(String login, String id) throws Exception{
		String sql = "select count(1) as qtd from usuario where login  = '" + login + "' and id <> " + id;
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		if(resultSet.next()) {					
			
			return resultSet.getInt("qtd") <=0;
		}
		
		return false;
	}


	public void atualizar(BeanCusdoJsp usuario) {
		
		
		String sql = "update usuario set login = ?, senha = ?, nome = ?, telefone = ? where id =" +  usuario.getId();
		
		try {
		PreparedStatement statement = connection.prepareStatement(sql);		
		statement.setString(1, usuario.getLogin());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getNome());
		statement.setString(4, usuario.getTelefone());
		statement.executeUpdate();
		connection.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}		
		
	}

}
