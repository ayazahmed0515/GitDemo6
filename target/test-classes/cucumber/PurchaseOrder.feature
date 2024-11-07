
@tag
Feature: Purchase the order from website
  I want to use this template for my feature file

Background:	
Given i landed on ecommerce page

  @tag2
  Scenario Outline: positive test of submitting an order
    Given logged in with username <name> and password <pwd> 
    When I add a product <productName> to cart
    And Checkout <productName> and submit order
    Then verify "THANK YOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      | name  										| pwd | productName  |
      | ayaz.ahmed0515@gmail.com |     Passw0rd | ZARA COAT 3 |
     
