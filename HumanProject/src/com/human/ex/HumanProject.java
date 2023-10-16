package com.human.ex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.human.dto.HumanDto;
import com.human.model.Model;
import com.human.service.HumanService;
import com.human.util.DBConn;
import com.human.util.UserInput;
import com.human.view.IConsoleView;
import com.human.view.MenuInsert1;
import com.human.view.MenuOutput1;
import com.human.view.MenuOutput2;

public class HumanProject {
//	public static Scanner sc =new Scanner(System.in);
//	public static int inputInt(String st) {
//		System.out.println(st+" 정수입력>>");
//		return Integer.parseInt(sc.nextLine());
//	}
//
//	public static void main(String[] args) {
//	
//		String st="나이";
//		System.out.println(st+" 정수입력>>");
//		System.out.println(Integer.parseInt(sc.nextLine()));
//		
//		System.out.println(HumanProject.inputInt("나이"));
//		
//		st="키";
//		System.out.println(st+" 정수입력>>");
//		System.out.println(Integer.parseInt(sc.nextLine()));
//		
//		System.out.println(HumanProject.inputInt("키"));
//
//	}

	public static void main(String[] args) {
		 HumanService humanService=new HumanService();
		 IConsoleView view=null;
		 Model m=new Model();
		int input = 0;
		String strMainMenu = "-HumanTable 관리 프로그램------------------------\n";
		strMainMenu += "| 1.출력 | 2.입력 | 3.삭제 | 4.수정 | 5.종료 |\n";
		strMainMenu += "메뉴 번호 ";
		while (input != 5) {
			input = UserInput.inputInt(strMainMenu);
			switch (input) {
			case 1:
				m=new Model();
				view = new MenuOutput1();
				view.execute(m);
				
				// 1.Select
				ArrayList<HumanDto> resultDtos = humanService.select();
				m=new Model();
				
				view = new MenuOutput2();
				m.setAttribute("resultDtos", resultDtos);
				view.execute(m);
				
				break;
			case 2:
				// 2. insert
				m=new Model();
				view = new MenuInsert1();
				view.execute(m);
				
				humanService.insert((HumanDto)m.getAttribute("dto"));
				System.out.println("[입력 완료]");
				break;
			case 3:
				// 3.Delete
				System.out.println("------------------------------------------");
				System.out.println("삭제할 데이터 입력");
				int age=UserInput.inputInt("나이 ");

				
				humanService.delete(age);
				
				System.out.println("[삭제 완료]");
				break;
			case 4:
				// 4.Update
			
				break;
			case 5:
				System.out.println("------------------------------------------");
				System.out.println("프로그램을 종료합니다.");
				input = 5;
				break;
			default:
				System.out.println("보기에 있는 숫자를 입력하세요");
				break;
			}

		}
	}
}
