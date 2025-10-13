import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

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


        //System.setProperty("webdriver.gecko.driver","C:\\Users\\saipr\\Downloads\\geckodriver.exe");
        //WebDriver chromeDriver = new FirefoxDriver();
       // chromeDriver.get("https://rahulshettyacademy.com");
//        System.out.println(firefoxDriver.getTitle());
//        System.out.println(firefoxDriver.getCurrentUrl());
//        firefoxDriver.close();


        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

      /* ELEMENTS(id, name, className)
        <input type="text" placeholder="Username" id="inputUsername" value="">
        <input type="password" placeholder="Password" name="inputPassword" value="">
        <button class="submit signInBtn" type="submit">Sign In</button>
         */

        chromeDriver.get("https://rahulshettyacademy.com/locatorspractice/");
        chromeDriver.findElement(By.id("inputUsername")).sendKeys("rahul");
        chromeDriver.findElement(By.name("inputPassword")).sendKeys("hello123");
        chromeDriver.findElement(By.className("signInBtn")).click();

        // We willingly gave a wrong password to display an error message.
        // We wish to retrieve the error message. The error message field can be located by using className locator
        // But for a change we are gonna use css selectors

      /* ELEMENTS(cssSelector)
            <p class="error">* Incorrect username or password </p>
      */

        System.out.println(chromeDriver.findElement(By.cssSelector("p.error")).getText());  // Gets the error message and prints it.

        // Another representation
        System.out.println(chromeDriver.findElement(By.cssSelector("p[class='error']")).getText());

        /*

        Used to locate any element using css selector in the browser console instead of using selectorsHub
        $('p.error')
        $("input[placeholder='Name']")

        Used to locate any element using Xpath in the browser console instead of using selectorsHub
        $("//input[@placeholder='Name']")

       */

        /* ELEMENTS(linkText)
            <a href="#">Forgot your password?</a>
         */

        chromeDriver.findElement(By.linkText("Forgot your password?")).click(); // Finds the hyperlinks that has text mentioned

        /* Syntax for selectorsHub

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

        /*ELEMENTS
            <input type="text" placeholder="Name">
            <input type="text" placeholder="Email">
            <input type="text" placeholder="Phone Number">
            // <button class="reset-pwd-btn">Reset Login</button>
         */

        chromeDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sai praveen");
        chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("xyz@gmail.com"); // Enters email ID in the email field
        //chromeDriver.findElement(By.cssSelector("input[placeholder='Email']")).clear(); // Clears the email id we entered above.
        //chromeDriver.findElement(By.cssSelector("input[type='text'][2]")).clear(); // Incase there is no unique attribute and all the field have input text then we can use index and locate a field.
        chromeDriver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("7894561230");


        // Three ways to click this button

        //chromeDriver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();

        //chromeDriver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        chromeDriver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        /* Demonstrating parent child locators. Ignore

        <form action="#">
            <h2>Forgot password</h2>
            <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
            <input type="text" placeholder="Name">
            <input type="text" placeholder="Email">
            <input type="text" placeholder="Phone Number">
            <br>
            <div class="forgot-pwd-btn-conainer"><button class="go-to-login-btn">Go to Login</button><button class="reset-pwd-btn">Reset Login</button></div>
         </form>

         Let's see parent child tag traverse techniques. In the above form element
         form is the parent
         h2, p, inputs tagnames are children

         ** All inputs here are text and not unique so we use indexes here which are not important.
         For time being we just wish to locate this text "Please use temporary password 'rahulshettyacademy' to Login."
         It belongs to "p" tagname. To locate that:

         By.cssSelector("form p")
         By.xpath("//form/p")

         */

        /* ELEMENT
            <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
         */

        System.out.println(chromeDriver.findElement(By.cssSelector("form p")).getText());

        // Now we got the password lets  go back to login page using "go to login button
        /*
                <div class="forgot-pwd-btn-container">
                    <button class="go-to-login-btn">Go to Login</button>
                    <button class="reset-pwd-btn">Reset Login</button>
                </div>

                Here we need to use parent child tagging along with indexes. div is the parent, both the buttons are children
         */

        chromeDriver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); // tapping on one button
        // the above line will change the page so we need to Thread.sleep(3000); as the page transitions to avoid misclicks

        Thread.sleep(3000);

        // Now we are on login page

        /*
            <input type="text" placeholder="Username" id="inputUsername" value="">
            <input type="password" placeholder="Password" name="inputPassword" value="">
            <input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername">
            <button class="submit signInBtn" type="submit">Sign In</button>
         */

        // lets use css selector and regex instead of By id
                                    // we can write as "input#inputUsername" as well
        String name="Sai";

        chromeDriver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        chromeDriver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
                                                // We used css REGEX here * indicates words starting with "pass"
        //chromeDriver.findElement(By.xpath("//input[contains(@type, 'pass')]")).sendKeys("rahulshettyacademy");
                                                // We used xpath REGEX here
        chromeDriver.findElement(By.id("chkboxOne")).click();
                                            // used conventional id instead of xpath or css
        chromeDriver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
                                            // // We used xpath REGEX classname here
        // username, password, checkbox and sign are done

        Thread.sleep(2000);

        System.out.println(chromeDriver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(chromeDriver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
            // Validating the successful login message

        // Getting welcome message

        Assert.assertEquals(chromeDriver.findElement(By.tagName("h2")).getText(),"Hello "+name+",");
        // Validating Welcome message

        // Clicking on logout button

        //<button class="logout-btn">Log Out</button>

        //chromeDriver.findElement(By.cssSelector("button[class='logout-btn']")).click();
                                        // using css selector

        chromeDriver.findElement(By.xpath("//button[text()='Log Out']")).click();
                                        // Another way of using xpath and text technique.


        // We are trying to retrieve a subtext from a string here.
        String passwordText="Use password 'rahulshettyacademy' to login";

        String password = passwordText.split("'")[1];
        System.out.println(password);   // rahulshettyacademy

        //------- WINDOW OPERATIONS

        chromeDriver.manage().window().maximize();

        chromeDriver.get("http://google.com");

        chromeDriver.navigate().to("https://rahulshettyacademy.com");

        chromeDriver.navigate().back();

        chromeDriver.navigate().forward();

    }
}
