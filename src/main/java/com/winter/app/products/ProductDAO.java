package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.users.UserDTO;
import com.winter.app.utils.DBConnection;

import oracle.jdbc.proxy.annotation.Pre;

public class ProductDAO {

		public ProductDTO detail(ProductDTO productDTO) throws Exception {
			
			Connection con = DBConnection.getConnection();
			
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NUM =?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setLong(1, productDTO.getProductnum());
			
			ResultSet rs = st.executeQuery();
			ProductDTO result=null;
			if(rs.next()) {
				result = new ProductDTO();
				result.setProductnum(rs.getLong("PRODUCT_NUM"));
				result.setProductname(rs.getString("PRODUCT_NAME"));
				result.setProductdate(rs.getDate("PRODUCT_DATE"));
				result.setProductdetail(rs.getLong("PRODUCT_DETAIL"));
				result.setProductrate(rs.getDouble("PRODUCT_RATE"));
				
			}
			DBConnection.disConnection(rs, st, con);
			
			return result;
		
		}
			public int add(ProductDTO productDTO)throws Exception {
				Connection con = DBConnection.getConnection();
				
				String sql = "INSERT INTO PRODUCTS"
						+"VALUES (PRODUCT_SEQ.NEXTVAL,?,?,?,?,?)";
				
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setLong(1, productDTO.getProductnum());
				st.setString(2, productDTO.getProductname());
				st.setDate(3, productDTO.getProductdate());		
				st.setLong(4, productDTO.getProductdetail());
				st.setDouble(5, productDTO.getProductrate());
				
				int result = st.executeUpdate();
				
				DBConnection.disConnection(st, con);
				
				return result;
						
			}
			public int update(ProductDTO productDTO)throws Exception {
				Connection con = DBConnection.getConnection();
				
				String sql = "UPDATE PRODUCTS SET PRODUCT NUM=? ,PRODUCT_NAME=?";
				
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setLong(1, productDTO.getProductnum());
				st.setString(2, productDTO.getProductname());
				
				int result = st.executeUpdate();
				
				DBConnection.disConnection(st, con);
				
				return result;	
			}
			public List<ProductDTO> getList() throws Exception {
				Connection con = DBConnection.getConnection();
				
				String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCT_NUM DESC";
				
				PreparedStatement st = con.prepareStatement(sql);
				
				List<ProductDTO> ar = new ArrayList<ProductDTO>();
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					ProductDTO productDTO = new ProductDTO();
					productDTO.setProductnum(rs.getLong("PRODUCTNUM"));
					productDTO.setProductname(rs.getString("PRODUCTNAME"));
					productDTO.setProductdate(rs.getDate("PRODUCTDATE"));
					productDTO.setProductdetail(rs.getLong("PRODUCTDETAIL"));
					productDTO.setProductrate(rs.getDouble("PRODUCTRATE"));
					ar.add(productDTO);
				}
				DBConnection.disConnection(rs, st, con);
				
				return ar;
			}
}
