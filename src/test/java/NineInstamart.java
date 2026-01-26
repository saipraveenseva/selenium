import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NineInstamart {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot","Carrot"}; // Storing the itemsNeeded in a String array to find them using locators as there are multiple elements(Add to cart buttons) without any unique identity
        Thread.sleep(3000); // Waiting till all the products are loading onto the webpage

        // Command for browser console to find all occurences of "ADD TO CART
        // $x("//button[text()='ADD TO CART']")
        // $x("//button[normalize-space()='ADD TO CART']") -> This command ignores all leading and trailing spaces around "ADD TO CART" and considers just the text "ADD TO CART".

        addItems(driver, itemsNeeded); // calling addItems method


    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {


        /*
                <h4 class="product-name">Brocolli - 1 Kg</h4>
                <h4 class="product-name">Cauliflower - 1 Kg</h4>
                <h4 class="product-name">Cucumber - 1 Kg</h4>

         */
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); // Finding all the elements with h4 class=product-name and creating a List.

        // Converting the itemsNeeded array of required items that we got as a parameter input into a List for easy lookup
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);

// Counter to track how many required items have been added to cart
        int j = 0;

// Loop through all available products displayed on the page
        for (int i = 0; i < products.size(); i++) {

            // Get the full product text (example: "Brocolli - 1 Kg")
            // Split using "-" and take only the product name portion
            String formattedName =
                    products.get(i).getText().split("-")[0].trim();

            // Check whether this product is part of the required items list
            if (itemsNeededList.contains(formattedName)) {

                // Click the corresponding "Add to Cart" button
                // Index 'i' ensures product and button stay aligned

                //<div class="product-action"><button class="" type="button">ADD TO CART</button></div>
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Increment count of successfully added items
                j++;

                // If all required items are added, exit the loop early
                // Prevents unnecessary iteration and improves execution speed
                if (j == itemsNeededList.size()) {
                    break;
                }
            }
        }


    }


}

