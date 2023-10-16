package com.human.view;

import com.human.dto.HumanDto;
import com.human.model.Model;
import com.human.util.UserInput;

public class MenuInsert1 implements IConsoleView {

	@Override
	public void execute(Model model) {
		System.out.println("------------------------------------------");
		System.out.println("입력할 Human데이터 입력");
		HumanDto dto = new HumanDto();
		dto.setName(UserInput.inputString("이름 입력"));
		dto.setAge(UserInput.inputInt("나이 입력"));
		dto.setHeight(UserInput.inputDouble("키 입력"));
		dto.setBirthday(UserInput.inputLocalDateTime("생일 입력"));
		
		model.setAttribute("dto", dto);

	}

}
