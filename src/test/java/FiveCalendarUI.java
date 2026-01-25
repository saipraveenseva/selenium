import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FiveCalendarUI {

    public static void main(String[] args) throws InterruptedException {

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Select "FROM"
        /*
            <input id="ctl00_mainContent_ddl_originStation1_CTXT" name="ctl00_mainContent_ddl_originStation1_CTXT" selectedtext="" selectedvalue="" value="" class="select_CTXT" menuselection="false" autocomplete="off" style="width: 237px; height: 43px; border: 1px solid rgb(153, 153, 153);">

         */

        chromeDriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // Finding "FROM" dropdown

        /*
                <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Hyderabad (HYD)" value="HYD"> Hyderabad (HYD)</a>
         */

        chromeDriver.findElement(By.cssSelector("a[value='HYD']")).click();

        /*
            <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Vijayawada (VGA)" value="VGA"> Vijayawada (VGA)</a>

         */

        Thread.sleep(2000);

        /* Selecting TO is tricky here. Locate the FROM dropdown and then select VGA

         */
            //Locating FROM <div id="glsctl00_mainContent_ddl_destinationStation1_CTNR"><a class="close-btn close" id="closebtn" href="#">X</a><table width="98%" border="0" cellpadding="0" cellspacing="0" id="citydropdown">                 <tbody><tr>                     <td class="left">                     </td>                     <td class="topbg">                     </td>                     <td class="right">                     </td>                 </tr>                 <tr>                     <td class="leftbg">                         &nbsp;                     </td>                     <td class="mapbg">                         <div class="btnrow">                             <a href="#" class="close"></a>                         </div><div class="heading"></div><div width="100%" border="0" align="center" class="search_options_menucontent"><div id="dropdownGroup1"><h3 class="title1">India</h3><div class="dropdownDiv"><ul><li class="city_selected "><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Adampur (AIP)" value="AIP"> Adampur (AIP)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Ahmedabad (AMD)" value="AMD"> Ahmedabad (AMD)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Amritsar (ATQ)" value="ATQ"> Amritsar (ATQ)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bagdogra (IXB)" value="IXB"> Bagdogra (IXB)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Belagavi (IXG)" value="IXG"> Belagavi (IXG)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bengaluru (BLR)" value="BLR"> Bengaluru (BLR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bhopal (BHO)" value="BHO"> Bhopal (BHO)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Chennai (MAA)" value="MAA"> Chennai (MAA)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Coimbatore (CJB)" value="CJB"> Coimbatore (CJB)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Dehradun (DED)" value="DED"> Dehradun (DED)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Delhi (DEL)" value="DEL"> Delhi (DEL)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Dharamshala (DHM)" value="DHM"> Dharamshala (DHM)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Dibrugarh (DIB)" value="DIB"> Dibrugarh (DIB)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Durgapur (RDP)" value="RDP"> Durgapur (RDP)</a></li></ul><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Goa (GOI)" value="GOI"> Goa (GOI)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Gorakhpur (GOP)" value="GOP"> Gorakhpur (GOP)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Guwahati (GAU)" value="GAU"> Guwahati (GAU)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Gwalior (GWL)" value="GWL"> Gwalior (GWL)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Hubli (HBX)" value="HBX"> Hubli (HBX)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jabalpur (JLR)" value="JLR"> Jabalpur (JLR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jaipur (JAI)" value="JAI"> Jaipur (JAI)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jaisalmer (JSA)" value="JSA"> Jaisalmer (JSA)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jammu (IXJ)" value="IXJ"> Jammu (IXJ)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jharsuguda (JRG)" value="JRG"> Jharsuguda (JRG)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jodhpur (JDH)" value="JDH"> Jodhpur (JDH)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kandla (IXY)" value="IXY"> Kandla (IXY)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kanpur (KNU)" value="KNU"> Kanpur (KNU)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kishangarh (KQH)" value="KQH"> Kishangarh (KQH)</a></li></ul><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kochi (COK)" value="COK"> Kochi (COK)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kolkata (CCU)" value="CCU"> Kolkata (CCU)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kozhikode (CCJ)" value="CCJ"> Kozhikode (CCJ)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Lakhimpur (IXI)" value="IXI"> Lakhimpur (IXI)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Leh (IXL)" value="IXL"> Leh (IXL)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Madurai (IXM)" value="IXM"> Madurai (IXM)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Mangaluru (IXE)" value="IXE"> Mangaluru (IXE)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Mumbai (BOM)" value="BOM"> Mumbai (BOM)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Pakyong (PYG)" value="PYG"> Pakyong (PYG)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Patna (PAT)" value="PAT"> Patna (PAT)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Pondicherry (PNY)" value="PNY"> Pondicherry (PNY)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Porbandar (PBD)" value="PBD"> Porbandar (PBD)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Port Blair (IXZ)" value="IXZ"> Port Blair (IXZ)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Pune (PNQ)" value="PNQ"> Pune (PNQ)</a></li></ul><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Shirdi (SAG)" value="SAG"> Shirdi (SAG)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Silchar (IXS)" value="IXS"> Silchar (IXS)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Srinagar (SXR)" value="SXR"> Srinagar (SXR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Surat (STV)" value="STV"> Surat (STV)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Thiruvananthapuram (TRV)" value="TRV"> Thiruvananthapuram (TRV)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Tirupati (TIR)" value="TIR"> Tirupati (TIR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Tuticorin (TCR)" value="TCR"> Tuticorin (TCR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Udaipur (UDR)" value="UDR"> Udaipur (UDR)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Varanasi (VNS)" value="VNS"> Varanasi (VNS)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Vijayawada (VGA)" value="VGA"> Vijayawada (VGA)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Vishakhapatnam (VTZ)" value="VTZ"> Vishakhapatnam (VTZ)</a></li></ul></div></div><div id="dropdownGroup2"><h3 class="title2">International</h3><div class="dropdownDiv"><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Bangkok (BKK)" value="BKK"> Bangkok (BKK)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Colombo (CMB)" value="CMB"> Colombo (CMB)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Dhaka (DAC)" value="DAC"> Dhaka (DAC)</a></li></ul><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Dubai, All Airports(DWC) (DXB)" value="DXB"> Dubai, All Airports(DWC) (DXB)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Hong Kong,Intl Apt, SAR China (HKG)" value="HKG"> Hong Kong,Intl Apt, SAR China (HKG)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jeddah (JED)" value="JED"> Jeddah (JED)</a></li></ul><ul><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Kabul (KBL)" value="KBL"> Kabul (KBL)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Male (MLE)" value="MLE"> Male (MLE)</a></li><li class=""><a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Muscat (MCT)" value="MCT"> Muscat (MCT)</a></li></ul><ul></ul></div></div></div>                    </td>                     <td class="rightbg">                         &nbsp;                     </td>                 </tr>                 <tr>                     <td class="btmleft">                     </td>                     <td class="btmbg">                         &nbsp;                     </td>                     <td class="btmright">                     </td>                 </tr>             </tbody></table></div>
            //Locating VGA <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Vijayawada (VGA)" value="VGA"> Vijayawada (VGA)</a>

        chromeDriver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='VGA']")).click();

        // Above approach is used when you are not interested in using indexes. If u wish to use indexes you can do it like below.

        //chromeDriver.findElement(By.xpath("(//a[@value='VGA'])[2]")).click();

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

    }
}
