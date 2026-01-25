import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FourAssignment1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");

        chromeDriver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(chromeDriver.findElement(By.id("checkBoxOption1")).isSelected());

        Thread.sleep(3000);

        chromeDriver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(chromeDriver.findElement(By.id("checkBoxOption1")).isSelected());


        // <input id="checkBoxOption1" value="option1" name="checkBoxOption1" type="checkbox">

        System.out.println(chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }
}
