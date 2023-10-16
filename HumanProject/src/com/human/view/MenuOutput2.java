package com.human.view;

import java.util.ArrayList;

import com.human.dto.HumanDto;
import com.human.model.Model;

public class MenuOutput2 implements IConsoleView {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(Model model) {
		
		for (HumanDto dto : (ArrayList<HumanDto>)model.getAttribute("resultDtos")) {
			System.out.println(dto);
		}

	}

}
