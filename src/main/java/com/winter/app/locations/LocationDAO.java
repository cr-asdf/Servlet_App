package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.departments.DepartmentDTO;
import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	public int update(LocationDTO locationDTO)throws Exception{
		int result=0;
		Connection con = DBConnection.getConnection();
		
		String sql = "UPDATE LOCATIONS SET LOCATION_ID=?, CITY=?, STREET_ADDRESS=?,POSTAL_CODE "
				+ "WHERE LOCATION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, locationDTO.getLocation_id());
		st.setString(2, locationDTO.getCity());
		st.setString(3,locationDTO.getStreet_address());
		st.setString(4, locationDTO.getPostal_code());

		result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;	
	}
	
	public int add (LocationDTO locationDTO) throws Exception {
		int result=0;
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATION (LOCATION_ID,CITY,STREET_ADDRESS,POSTAL_CODE)"
		+ "VALUES(LOCATIONS_SEQ.NEXTVAL,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, locationDTO.getLocation_id());
		st.setString(3, locationDTO.getCity());
		st.setString(2, locationDTO.getStreet_address());
		
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	public int delete(LocationDTO locationDTO) throws Exception {
		int result=0;
		Connection con = DBConnection.getConnection();
		
		String sql="DELETE LOCATION WHERE LOCATION_ID=?";
		PreparedStatement st =con.prepareStatement(sql);
		
		st.setLong(1, locationDTO.getLocation_id());
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}

	public List<LocationDTO> getList() throws Exception {
		System.out.println("지역정보 리스트 조회");
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs =st.executeQuery();
		
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO  dto = new LocationDTO();
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
			list.add(dto);	
		}
		DBConnection.disConnection(rs, st, con);
		return list;
		
		
	}
	public LocationDTO getDetail(LocationDTO locationDTO) throws Exception {
		System.out.println("한 지역 정보 조회");
		Connection con = DBConnection.getConnection();
		String sql = "SELECT FROM LOCATIONS WHRER LOCATION_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, locationDTO.getLocation_id());
		
		ResultSet rs = st.executeQuery();
	
		
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		
		if (rs.next()) {
			LocationDTO dto = new LocationDTO();
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));		
		}else {
			locationDTO=null;
		}
		
		DBConnection.disConnection(rs, st, con);
		return locationDTO;
				
	}
}
