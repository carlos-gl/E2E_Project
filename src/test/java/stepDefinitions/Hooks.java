package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
  private static WebDriver driver;

  @Before
  public void setUp() {
    driver = DriverFactory.getDriver();
    driver.get("https://www.saucedemo.com"); // URL da aplicação
  }

  @After
  public void tearDown() {
    DriverFactory.quitDriver();
  }
}
