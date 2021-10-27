package org.sel;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Testing extends BaseClass{

	public static void main(String[] args) throws IOException {
		
		launchUrl("https://adactinhotelapp.com/");
		Adactin a = new Adactin();
		WebElement txtUsername = a.getUsername();
		String text = excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 0);
		enterText(txtUsername, text);
		WebElement txtPassword = a.getPassword();
		enterText(txtPassword, excelRead("D:\\GREENS\\TRAINNING\\Practice2.xlsx", "abcd", 0, 1));
		buttonClick(a.getLogin());
		
	}
	
}
