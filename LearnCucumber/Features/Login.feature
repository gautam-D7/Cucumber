Feature: Login
Scenario: Successfull Login with Valid credentials
 Given User Launch Chrome browser
   When User open URL "https://admin-demo.nopcommerce.com/login"
   And User Enter Email As "h" and Password as "admin"
   And Click on Login
   Then Page Title should be "Dashboard / nopCommerce administration"
   When User Click on Log out link
   Then Page Title should be "Your store. Login"
   And close Browser
 