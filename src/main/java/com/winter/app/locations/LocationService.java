package com.winter.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class LocationService {

	private LocationDAO locationDAO;
	
	public LocationService() {
		this.locationDAO = new LocationDAO();
	}
	
	public ActionForward getList(HttpServletRequest request, ActionForward actionForward)throws Exception {
		List<LocationDTO> ar = locationDAO.getList();
		request.setAttribute("list", ar);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/list.jsp");
		return actionForward;
	}
	public ActionForward getDetail(HttpServletRequest request,ActionForward actionForward)throws Exception{
		String id=request.getParameter("location_id");
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(id));
		request.setAttribute("dto", locationDTO);
		
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/detail.jsp");
		return actionForward;
	}
	public void add(HttpServletRequest request,ActionForward actionForward)throws Exception{
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(request.getParameter("location_id")));
		locationDTO.setCity(request.getParameter("city"));
		locationDTO.setStreet_address(request.getParameter("street_address"));
		int result = locationDAO.add(locationDTO);
		String str = "지역 등록 실패";
		if(result>0) {
			str = "지역 등록 성공";	
		}
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/result.jsp");
	}
	public void update(HttpServletRequest request,ActionForward actionForward)throws Exception {
		LocationDTO locationDTO = new LocationDTO();
		locationDTO.setLocation_id(Long.parseLong(request.getParameter("location_id")));
		locationDTO = locationDAO.getDetail(locationDTO);
		request.setAttribute("dto", locationDTO);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/locations/update.jsp");
		
	}
		
		public void updateProcess(HttpServletRequest request, ActionForward actionForward)throws Exception{
			String id = request.getParameter("location_id");
			String ad = request.getParameter("street_address");
			String p = request.getParameter("postal_code");
			String c = request.getParameter("city");
			
			
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(Long.parseLong(id));
			locationDTO.setStreet_address(ad);
			locationDTO.setPostal_code(p);
			locationDTO.setCity(c);
			
			int result =locationDAO.update(locationDTO);

			String str = "지역 등록 실패";
			if(result>0) {
				str="지역 등록 성공";			
			}
			request.setAttribute("result", str);
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/locations/result.jsp");
			
		}
		public void delete(HttpServletRequest request,ActionForward actionForward)throws Exception {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(Long.parseLong(request.getParameter("location_id")));
			
			int result =locationDAO.update(locationDTO);

			String str = "지역 등록 실패";
			if(result>0) {
				str="지역 등록 성공";			
			}
			request.setAttribute("result", str);
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/locations/result.jsp");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
