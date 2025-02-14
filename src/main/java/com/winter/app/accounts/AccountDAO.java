package com.winter.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.winter.app.utils.DBConnection;

public class AccountDAO {

	private int join(AccountDTO accountDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO ACCOUNTS(ACCOUNTNUM, USERNAME, PRODUCTNUM, ACCOUNTBALANCE, ACCOUNTDATE"
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getAccountnum());
		st.setString(2, accountDTO.getUsername());
		st.setLong(3, accountDTO.getProductnum());
		st.setLong(4, accountDTO.getAccountbalance());
		st.setDate(5, accountDTO.getAccoutdate());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
	}
}
