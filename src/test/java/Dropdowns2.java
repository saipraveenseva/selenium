import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Dropdowns2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // AUTO_SUGGESTIVE DROPDOWNS
        // These are the dropdowns where we enter text and a list of options are displayed. We have to pick from those

        // dropdown element <input type="text" id="autosuggest" class="inputs ui-autocomplete-input" placeholder="Type to Select" autocomplete="off">
        // First we findElement and then send keys. Lets say we are entering "Aus"
        // Australia and Austria are 2 options suggested and we have to select austria

        chromeDriver.findElement(By.id("autosuggest")).sendKeys("aus");

        /* Elements
                <li class="ui-menu-item" role="presentation"><a id="ui-id-39" class="ui-corner-all" tabindex="-1">Australia</a></li>
                <li class="ui-menu-item" role="presentation"><a id="ui-id-40" class="ui-corner-all" tabindex="-1">Austria</a></li>
         */

        Thread.sleep(3000);
        List<WebElement> options = chromeDriver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
                                                                            // li is parent and a is child

        // Now we iterate this List and select "Austria"

        for(WebElement i : options ){
            if(i.getText().equalsIgnoreCase("Austria")){
                i.click();
                break;
            }
        }

        // CHECKBOXES
        /*
                <input id="ctl00_mainContent_chk_friendsandfamily" type="checkbox" name="ctl00$mainContent$chk_friendsandfamily">
         */
                                                        //using regex instead of entire ID.
        chromeDriver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click(); // Selecting the checkbox
        System.out.println(chromeDriver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected()); // true /Making sure it is selected
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected()); // Writing an assertion instead of printing.

        // Find the number of checkboxes in the web page.
        // Inorder to do that we need to find a common locator for all the checkboxes.
        // <input id="ctl00_mainContent_chk_friendsandfamily" type="checkbox" name="ctl00$mainContent$chk_friendsandfamily">
        // In all the checkboxes the common locator is type="checkbox"

        System.out.println(chromeDriver.findElements(By.cssSelector("input[type='checkbox']")).size()); // Finding all the elements and then .size();

    }

}
