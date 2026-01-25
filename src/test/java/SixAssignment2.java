import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class SixAssignment2 {

    public static void main(String[] args) {

        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("https://www.rahulshettyacademy.com/angularpractice/");

        chromeDriver.findElement(By.name("name")).sendKeys("Rahul Shetty");
        chromeDriver.findElement(By.name("email")).sendKeys("rahulshetty@gmail.com");
        chromeDriver.findElement(By.id("exampleInputPassword1")).sendKeys("123456789");
        chromeDriver.findElement(By.id("exampleCheck1")).click();

        WebElement staticDropdown = chromeDriver.findElement(By.id("exampleFormControlSelect1"));
        Select genderDropdown = new Select(staticDropdown);

        //Simple way
        //   genderDropdown.selectByVisibleText("female");

        // Covering smallcase largecase as well
        for(WebElement option : genderDropdown.getOptions()){
            if (option.getText().equalsIgnoreCase("female")){
                option.click();
                break;
            }
        }

        chromeDriver.findElement(By.cssSelector("input[id='inlineRadio2']")).click();

        chromeDriver.findElement(By.name("bday")).sendKeys("11/11/1994");

        chromeDriver.findElement(By.xpath("//input[@value='Submit']")).click();

        System.out.println(chromeDriver.findElement(By.cssSelector(".alert-success")).getText());






    }
}
