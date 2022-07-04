package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestCase {
  @Test (priority = 3)
  public void Test01() {
	  
	  System.out.println("Test01");
  }
  
  @Test (priority = 1, groups = "Regression", dependsOnMethods = {"Test04","Test05"})
  public void Test02()
  {
	  System.out.println("Test02");
  }
  
  @Test (priority = 2, groups = "Sanity")
  public void Test03()
  {
	  System.out.println("Test03");
  }
  
  @Test (groups = "depends")
  public void Test04()
  {
	  System.out.println("Test04");
  }
  
  @Test (groups = "depends")
  public void Test05()
  {
	  System.out.println("Test05");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Before Test Method");
  }

  @AfterMethod
  public void afterMethod() {

	  System.out.println("After Test Method");
  }

  @BeforeTest
  public void beforeTest() {

	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

}
