import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumIntroduction{

    public static void main(String[] args) throws InterruptedException {

        //Invoking browser
        //Chrome - Chrome WebDriver ->Methods close get
        //Firefox - FirefoxDriver->Methods close get

        WebDriver chromeDriver = new ChromeDriver();

//        chromeDriver.get("https://rahulshettyacademy.com");
//        System.out.println(chromeDriver.getTitle());
//        System.out.println(chromeDriver.getCurrentUrl());
//        chromeDriver.close();


 //       System.setProperty("webdriver.gecko.driver","C:\\Users\\saipr\\Downloads\\geckodriver.exe");
//        WebDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://rahulshettyacademy.com");
//        System.out.println(firefoxDriver.getTitle());
//        System.out.println(firefoxDriver.getCurrentUrl());
//        firefoxDriver.close();


        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
        chromeDriver.findElement(By.name("inputPassword")).sendKeys("hello123");
        chromeDriver.findElement(By.className("signInBtn")).click();

        // We willingly gave a wrong password to display an error message.
        // We wish to retrieve the error message. The error message field can be located by using className locator
        // But for a change we are gonna use css selectors

        //System.out.println(chromeDriver.findElement(By.cssSelector("p.error")).getText());  // Gets the error message and prints it.

        // Another representation
        System.out.println(chromeDriver.findElement(By.cssSelector("p[class='error']")).getText());

        /*

        Used to locate any element using css selector in the browser console instead of using selectorsHub
        $("input[placeholder='Name']")

        Used to locate any element using Xpath in the browser console instead of using selectorsHub
        $("//input[@placeholder='Name']")


         */

        chromeDriver.findElement(By.linkText("Forgot your password?")).click(); // Finds the hyperlinks that has text mentioned

        /* Syntax

            CSS:   tagname[attribute='value'];
            Xpath: //tagname[@attribute='value']
         */

        Thread.sleep(3000); // After tapping on forgot password the page transitions to the next page
        // To avoid misclicks we apply a delay and then let the program enter the inputs and click the buttons.

        /*


            - **`Thread.sleep(ms)`**:
              ➤ Pauses execution for a fixed time **regardless** of whether the element is ready or not.
              ➤ It's a **hard wait**. Always waits the full time.

            - **`Implicit Wait`**:
              ➤ Tells WebDriver to **poll the DOM** for a set time when trying to find elements.
              ➤ It's a **dynamic wait**. Proceeds as soon as the element is found.


         */

        chromeDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sai praveen");
        chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("xyz@gmail.com"); // Enters email ID in the email field
        //chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).clear(); // Clears the email id we entered above.
        //chromeDriver.findElement(By.cssSelector("input[type='text'][2]")).clear(); // Incase there is no unique attribute and all the field have input text then we can use index and locate a field.
        chromeDriver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("7894561230");


        // Three ways to click this button

        // <button class="reset-pwd-btn">Reset Login</button>

        //chromeDriver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();

        //chromeDriver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        System.out.println(chromeDriver.findElement(By.cssSelector("form p")).getText());



    }
}
