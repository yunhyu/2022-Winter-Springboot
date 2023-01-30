package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC1 {

	@RequestMapping("/getYoil1")
	public String main(int year, int month, int day, Model model) {
		
		if(!isValid(year, month, day)) return "failed";
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil",this.getYoil(year, month, day));
		
		model.addAttribute(int.class);
		
		return "yoil";
	}
	private boolean isValid(int year, int month, int day) {
		return true;
	}
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
