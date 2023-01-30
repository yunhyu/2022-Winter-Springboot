package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC2 {

	int year;
	int month; 
	int day;
	
	@RequestMapping("/getYoil2")
	public String main(String year, String month, String day, Model model) {
		
		if(!isValid(year, month, day)) return "failed";
		
		model.addAttribute("year", this.year);
		model.addAttribute("month", this.month);
		model.addAttribute("day", this.day);
		model.addAttribute("yoil",this.getYoil());
		
		return "yoil";
	}
	private boolean isValid(String year, String month, String day) {
		try {
			System.out.println(year);
			String DummyYear = (String)year;
			String DummyMonth = (String)month;
			String DummyDay = (String)day;
			
			this.year = Integer.parseInt(DummyYear);
			this.month = Integer.parseInt(DummyMonth);
			this.day = Integer.parseInt(DummyDay);
			
			return true;
		}catch(ClassCastException e) {
			e.printStackTrace();
			return false;
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}
	private char getYoil() {
		Calendar cal = Calendar.getInstance();
		cal.set(this.year, this.month-1, this.day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}
