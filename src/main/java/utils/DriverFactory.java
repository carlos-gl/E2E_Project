package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {
  private static WebDriver driver;

  // Método para iniciar o WebDriver com boas práticas
  public static WebDriver getDriver() {
    if (driver == null) {
      // Configurações de opções do Chrome
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      options.addArguments("--disable-infobars");
      options.addArguments("--headless");

      driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    return driver;
  }

  // Método para encerrar o WebDriver após os testes
  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
