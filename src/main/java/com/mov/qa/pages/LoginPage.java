package com.mov.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mov.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//span[contains(text(),'Sign in with IMDb')]")
	WebElement signinIMDB;
	
	@FindBy(id="suggestion-search")
	WebElement searchBox;
	
	@FindBy(xpath="//div[contains(text(),'Pushpa: The Rise - Part 1')]")
	WebElement pushpaMovielistItem;
	
	
	@FindBy(xpath="//*[@id=\"react-autowhatever-1--item-0\"]")
	WebElement MovielistItem;
	
	@FindBy(xpath="//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li")
	List<WebElement> movieDetailsList;
	
	@FindBy(name="search")
	WebElement searchBoxWiki;
	
	
	@FindBy(xpath="//*[@class=\"infobox vevent\"]/tbody/tr")
	List<WebElement> movieWikiDetailsList;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void  navigateToSigneIn(){
		signinIMDB.click();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
		
	}
	
	public void searchMovie(String movieName)
	{
		searchBox.sendKeys(movieName);
		sleep(10000);	
	}
	
	public void  selectMovie(){
		pushpaMovielistItem.click();
	}
	
	public void captureMovieDetails()
	{
		
		List<WebElement> items = movieDetailsList;
		for(WebElement e: items)
		{
		    System.out.print(e.getText());
		    if(e.getText().startsWith("Country of origin"))
		    {
		        System.out.println("ttttt"+e.getText());
		    }
		    else
		    {
		        System.out.println("  ");
		    }
		}
	}
	
	
	public void navigateToWiky()
	{
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		sleep(10000);	
	}
	
	public void searchMovieWiki(String movieName)
	{
		searchBoxWiki.sendKeys(movieName);
		searchBoxWiki.sendKeys(Keys.ENTER);
		sleep(10000);	
	}
	

	public void captureWikiMovieDetails()
	{
		
		List<WebElement> items = movieWikiDetailsList;
		for(WebElement e: items)
		{
		    System.out.print(e.getText());
		    if(e.getText().startsWith("Country"))
		    {
		        System.out.println("ttttt"+e.getText());
		    }
		    else
		    {
		        System.out.println("  ");
		    }
		}
	}
	
	
	
	
	public void sleep(int mSec)
	{	
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
