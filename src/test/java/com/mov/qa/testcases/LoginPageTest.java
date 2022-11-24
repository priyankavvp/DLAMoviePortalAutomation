package com.mov.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mov.qa.base.TestBase;
import com.mov.qa.pages.HomePage;
import com.mov.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
		 
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		System.out.println("====="+title+"=====");
		Assert.assertEquals(title.trim(), "Sign in with IMDb - IMDb");
		 loginPage.navigateToSigneIn();
		Assert.assertTrue(true);
		loginPage.sleep(1000);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.sleep(1000);
		loginPage.searchMovie("Pushpa");
		loginPage.sleep(10000);
		loginPage.selectMovie();
		loginPage.sleep(10000);
		loginPage.captureMovieDetails();
		loginPage.navigateToWiky();
		loginPage.searchMovieWiki("Pushpa");
		loginPage.captureWikiMovieDetails();			
		
		Assert.assertEquals(true, true);
		
	}

	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
