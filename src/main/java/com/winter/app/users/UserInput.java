package com.winter.app.users;

import java.util.Scanner;

public class UserInput {

		public UserDTO join(Scanner sc) {
			UserDTO userDTO = new UserDTO();
			System.out.println("ID를 입력하세요");
			userDTO.setUsername(sc.next());
			System.out.println("PW를 입력하세요");
			userDTO.setPassword(sc.next());
			System.out.println("이름을 입력하세요");
			userDTO.setPhone(sc.next());
			System.out.println("전화번호를 입력하세요");
			userDTO.setPhone(sc.next());
			System.out.println("이메일을 입력하세요");
			userDTO.setEmail(sc.next());
			
			return userDTO;
		}
		
		public UserDTO login(Scanner sc) {
			UserDTO userDTO = new UserDTO();
			System.out.println("ID를 입력하세요");
			userDTO.setUsername(sc.next());
			System.out.println("PW를 입력하세요");
			userDTO.setPassword(sc.next());
			
			return userDTO;
		}
}
