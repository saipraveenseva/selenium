import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // CURRENCY Dropdown with select tag

        WebElement staticDropdown = chromeDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown1 = new Select(staticDropdown);

        dropdown1.selectByIndex(3); // Currency dropdown has INR, AED, USD. USD is selected.
        System.out.println(dropdown1.getFirstSelectedOption().getText()); // Displays the selected option in the console USD

        dropdown1.selectByVisibleText("AED"); // Selects by using text "AED"
        System.out.println(dropdown1.getFirstSelectedOption().getText()); // Displays the selected option in the console AED

        dropdown1.selectByValue("INR"); // <option value="INR">INR</option> Selects the Value in the element INR
        System.out.println(dropdown1.getFirstSelectedOption().getText());

        // PASSENGERS DROPDOWN

        chromeDriver.findElement(By.id("divpaxinfo")).click(); // Clicking on the Passengers dropdown. Now further options are displayed.
        Thread.sleep(2000); // Waiting for the dropdown to open

        int adultCount=1; //initially. Readability recommended.
        while(adultCount<5){
            chromeDriver.findElement(By.id("hrefIncAdt")).click(); // Clicks on Adult increment "+". By default Adult is 1. It becomes 5 now.
            adultCount++;
        }

        // Writing assertion to make sure correct number of adults are added. <div id="divpaxinfo" class="paxinfo">1 Adult</div>

        Assert.assertEquals(chromeDriver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        chromeDriver.findElement(By.id("hrefIncChd")).click(); // Clicks on Child increment "+".
        chromeDriver.findElement(By.id("btnclosepaxoption")).click(); // Click on Done button


        // FROM-TO DYNAMIC DROPDOWNS

        // Select a city from FROM dropdown, the TO dropdown opens itself. Now selecting something from TO dropdown might select a destination from the FROM dropdown
        // THis is how Selenium handles this. It throws an error "element not visible" as it inside FROM dropdown and TO dropdown is opened on the screen.
        // TO resolve this we use indexes in Xpath

        chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // Opening the FROM dropdown first. List of Source cities are displayed.

        // <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bengaluru (BLR)" value="BLR"> Bengaluru (BLR)</a>
        chromeDriver.findElement(By.xpath("//a[@value='BLR']")).click();  //Selecting Bangalore(BLR) from the list using Xpath

        // TO dropdown opens automatically. If we locate Chennai and click on it, As Selenium scans from top left it searches in FROM dropdown and tries to select it.
        // But the element is not visible on screen so it throws error

        //Thread.sleep(2000); // Waiting for the TO dropdown to open.

        //<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Chennai (MAA)" value="MAA"> Chennai (MAA)</a>
        //chromeDriver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // Index 2 becoz its the second occurence of Chennai in the webpage. We have to make sure its the second occurence using SelectorsHub or Chropath or console.


        // Using Indexes is not ideal. With constant CI/CD the page changes quite often and sticking to Indexes is a bad idea. This can be overcome by Parent-child relationship

        // THis is the element of the TO dropdown <div id="glsctl00_mainContent_ddl_destinationStation1_CTNR">
        // THis is the element of Vijayawada destination <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Vijayawada (VGA)" value="VGA"> Vijayawada (VGA)</a>

        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VGA']")).click();
                                                                                                                // Doing a parent child interaction by placing both Xpaths side by side





    }

}
