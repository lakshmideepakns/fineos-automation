Exercise 2 Job Steps
1.Download Java and Eclipse from Google and install it.
2. Download apache maven zip file for Maven.
3. Set Environment and System variables.
4. Check java and Maven installation help of command prompt.
Commands
JAVA - java -version
Maven - mvn -version
6. Create Maven Project and add selenium, TestNG, WebDriverManager dependencies in pom.xml.
7. Install TestNG from Eclipse market place.
8. Followed Page Object Model Page Factory concept and POJO class to handle locators to avoid
StaleElementReferenceException.
9. Written class and methods and used TestNG annotations.
 @BeforeClass - set up the browser configuration
 @Test
 As per the requirement first 4 @Test methods I Navigate to www.demoblaze.com and click in
Phones, Laptops and Monitor menu then select one product add to cart and get the price each and
every time return to home page to select next menu in order.
5
th Test method navigate to cart page and remove the Phone from the list.
6
th Test method navigate to Place Order page by click the place order button in pop-up give all
required details.
7
th Test method Get the Success message, Purchase ID and Verified total amount displayed using
Assert.
Finally convert class into suite file auto named testing.xml Run all test methods by the help of suite
file and get default reports like index.html and emailablereports.html then customised Extent report
using ExtentReport dependencies.