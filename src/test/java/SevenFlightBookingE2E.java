import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class SevenFlightBookingE2E {

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

        // cssSelector equivalent ****
        // By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='VGA']")


        // FROM and TO are selected now lets select date of journey from the calendar UI

        // Lets say I wanna book ticket for today. When I open the calendar, today's date is highlighted in the UI

        // For a highlighted date the element is shown as below.

        //<a class="ui-state-default ui-state-active" href="#">5</a>
        // Selecting date

        chromeDriver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();


        // We selected FROM, TO, Current journey date from booking Now we select ROUND TRIP radio button

        // <input id="ctl00_mainContent_rbtnl_Trip_1" type="radio" name="ctl00$mainContent$rbtnl_Trip" value="RoundTrip" checked="checked">

        chromeDriver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        // WHen the user clicks on ROUND TRIP, the return date box gets enabled. We need to write an assertion to validate if its enabled.

        // RETURN DATE Element <input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick">

        Assert.assertTrue(chromeDriver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        // THe Above method is not working in current day modern website so we validate using an opacity element. When its disabled the opacity is 0.5 and 1 when its enabled.


        /* Entire div element
        <div id="Div1" class="picker-second" style="display: block; opacity: 1;">
                                <div class="left">
                                    <label>
                                        Return date</label>
                                    <span id="spclearDate" class="date-close" style="display: block;">X</span>
                                </div>
                                <input name="ctl00$mainContent$view_date2" type="text" readonly="readonly" id="ctl00_mainContent_view_date2" class="custom_date_pic required home-date-pick">
                                <input name="ctl00$mainContent$txt_Todate" type="text" value="12-05-2019" readonly="readonly" id="ctl00_mainContent_txt_Todate" class="custom_date_pic required home-date-pick home-internal-fulldate hasDatepicker"><button type="button" class="ui-datepicker-trigger"></button>
                                <span id="view_fulldate_id_2">Sun, May 12 2019</span>
                            </div>

         */

        if(chromeDriver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")){
            System.out.println("Its enabled");
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }

        chromeDriver.findElement(By.cssSelector("input[type='submit']")).click();



    }
}
