package com.winter.app.tests.locations;

import java.util.List;

import com.winter.app.locations.LocationDAO;
import com.winter.app.locations.LocationDTO;

public class LocationDAOTest {

	public static void main(String[] args) {
		
		LocationDAO dao = new LocationDAO();
		try {
			int size = 0;
			List<LocationDTO> list = dao.getList();
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
