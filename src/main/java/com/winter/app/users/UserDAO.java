package com.winter.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;



public class UserDAO {
		public int join(UserDTO userDTO)throws Exception {
			Connection con = DBConnection.getConnection();
			
			String sql = "INSERT INTO USERS(USERNAME, PASSWORD, NAME, PHONE, EMAIL)"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement st =con.prepareStatement(sql);
			
			st.setString(1, userDTO.getUsername());
			st.setString(2, userDTO.getPassword());
			st.setString(3, userDTO.getName());
			st.setString(4, userDTO.getName());
			st.setString(5, userDTO.getEmail());
			
			int result = st.executeUpdate();
			
			DBConnection.disConnection( st, con);
			
			return result;
			
		}
		 	public UserDTO login(UserDTO userDTO)throws Exception {
		 		Connection con = DBConnection.getConnection();
		 		
		 		String sql ="SELECT USERNAME, PASSWORD,NAME FROM USERS"
		 				+ "WHERE USER_ID=? AND PASSWORD=?";
		 		PreparedStatement st = con.prepareStatement(sql);
		 		
		 		st.setString(1, userDTO.getUsername());
		 		st.setString(2, userDTO.getPassword());
		 		
		 		ResultSet rs = st.executeQuery();
		 		
		 		if(rs.next()) {
		 			userDTO.setUsername(rs.getString("username"));	
		 		}else {
		 			userDTO=null;
		 		}
		 		DBConnection.disConnection(rs, st, con);
		 		
		 		return userDTO;
		 		
				}
		 		public int add(UserDTO userDTO)throws Exception{
		 			Connection con = DBConnection.getConnection();
		 			
		 			String sql= "INSERT INTO USERS"
		 					+ "VALUES (USERS_SEQ.NEXTVAL,?,?,?,?,?)";
		 			PreparedStatement st = con.prepareStatement(sql);
		 			
		 			st.setString(1, userDTO.getUsername());
		 			st.setString(2, userDTO.getPassword());
		 			st.setString(3, userDTO.getName());
		 			st.setString(4, userDTO.getPhone());
		 			st.setString(5, userDTO.getEmail());
		 
		 			
		 			int result = st.executeUpdate();
		 			
		 			DBConnection.disConnection(st, con);
		 			
		 			return result;		
		 		}
		 	public int update(UserDTO userDTO)throws Exception {
		 		Connection con = DBConnection.getConnection();
		 		
		 		String sql = "UPDATE USERS SET USERNAME=? PASSWORD=? WHERE NAME=?";
		 		
		 		PreparedStatement st = con.prepareStatement(sql);
		 		
		 		st.setString(1, userDTO.getUsername());
		 		st.setString(2, userDTO.getPassword());
		 		st.setString(3, userDTO.getName());
		 		
		 		int result = st.executeUpdate();
		 		
		 		DBConnection.disConnection(st, con);
		 		
		 		return result;
		 	}
	
	
	
	
	
	
	
	
	

}
	