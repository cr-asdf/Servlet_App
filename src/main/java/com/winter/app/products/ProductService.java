package com.winter.app.products;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;
import com.winter.app.users.UserDAO;
import com.winter.app.users.UserDTO;

public class ProductService {

		private ProductDAO productDAO;
		
		public ProductService() {
			this.productDAO = new ProductDAO();
			
		}
		public ActionForward getLlist(HttpServletRequest request, ActionForward actionForward)throws Exception {
			List<ProductDTO> ar = productDAO.getList();
			request.setAttribute("list", ar);
			
			actionForward.setFlag(true);
			actionForward.setPath("/Web-INF/views/products/list.jsp");
			return actionForward;		
}
		public ActionForward detail(HttpServletRequest request, ActionForward actionForward)throws Exception {
			String num=request.getParameter("productnum");
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductnum(Long.parseLong(num));
			productDTO= productDAO.detail(productDTO);
			request.setAttribute("dto", productDTO);
			
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/products/detail.jsp");
			return actionForward;
		}
		public void update(HttpServletRequest request, ActionForward actionForward)throws Exception {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductname(request.getParameter("productname"));
			productDTO=productDAO.detail(productDTO);
			request.setAttribute("dto", productDTO);
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/products/update.jsp");
		}
		public void add(HttpServletRequest request, ActionForward actionForward) throws Exception {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductnum(Long.parseLong(request.getParameter("productnum")));
			productDTO.setProductname(request.getParameter("productname"));
			productDTO.setProductdetail(Long.parseLong(request.getParameter("productdetail")));
			productDTO.setProductrate(Double.parseDouble(request.getParameter("productrate")));
			productDTO.setProductdetail(Long.parseLong(request.getParameter("productdetail")));
		
			int result= productDAO.add(productDTO);
			actionForward.setFlag(false);
			actionForward.setPath("../index.do");
			
		}
}