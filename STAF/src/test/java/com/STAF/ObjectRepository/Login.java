package com.STAF.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

		@FindBy(xpath="/html/frameset/frame[1]")
		public WebElement wfm_frameone;
		
		@FindBy(name="username")
		public WebElement wtb_userName;
}
