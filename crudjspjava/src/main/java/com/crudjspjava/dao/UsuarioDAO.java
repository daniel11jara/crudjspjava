package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;
public class UsuarioDAO {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava", "root", "admin");
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return conn;
	}
	
	
	//aula 06
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into usuario (nome, password, email, sexo, pais) values (?,?,?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	
	
	
	//aula 04
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usuario where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	
	//aula 05
	public static int updateUsuario(Usuario u) {
		
		int status = 0;
		
		try {
			
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update usuario set nome=?, password=?, email=?, sexo=?, pais=? where id=?");
			
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getId());;
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	
	
	
	
	
	//aula 02
	public static List<Usuario> getAllUsuarios() {
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usuario");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				list.add(usuario);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
	}
	

}
