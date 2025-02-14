package com.winter.app.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;

public class UserService {

		private UserDAO userDAO;
		
		public UserService( ) {
			userDAO = new UserDAO();
		}		
		public void login(HttpServletRequest request, ActionForward actionForward) throws Exception{
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(request.getParameter("username"));
			userDTO.setPassword(request.getParameter("password"))	;
			userDTO = userDAO.login(userDTO);
			
			if(userDTO !=null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("user", userDTO);
				actionForward.setFlag(false);
				actionForward.setPath("../index.do");	
			}else {
				
				request.setAttribute("result", "로그인실패");
				request.setAttribute("path", "./login.do");
				actionForward.setFlag(true);
				actionForward.setPath(" /WEB-INF/views/users/join.jsp");
			}
		}
				public void add(HttpServletRequest request, ActionForward actionForward)throws Exception {
					UserDTO userDTO = new UserDTO();
					
					userDTO.setUsername(request.getParameter("username"));
					userDTO.setPassword(request.getParameter("password"))	;
					userDTO.setName(request.getParameter("name"));
					userDTO.setPhone(request.getParameter("phone"));
					userDTO.setEmail(request.getParameter("email"));
					
					int result  = userDAO.add(userDTO);
					actionForward.setFlag(false);
					actionForward.setPath("./index.do");				
				}
				public void update(HttpServletRequest request, ActionForward actionForward)throws Exception{
					UserDTO session = (UserDTO)request.getSession().getAttribute("user");
					UserDTO userDTO = new UserDTO();
					
					userDTO.setUsername(request.getParameter("username"));
					userDTO.setPassword(request.getParameter("password"))	;
					userDTO.setName(session.getName());
					
					int result = userDAO.update(userDTO);
					
					if(result>0) {
							session.setUsername(userDTO.getUsername());
					}
					actionForward.setFlag(false);
					actionForward.setPath("./mypage.do");
				}
		}

