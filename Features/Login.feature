@feature
Feature: Login functionality
Background: Below are the common steps for each scenario
Given User launches the browser
When User enters valid url "https://admin-demo.nopcommerce.com/"

@functional
Scenario: Login with valid creds
And User enters an email as "admin@yourstore.com" and password as "admin"
And User click on login button
Then User is navigated to Home page
And Close the browser

@datadriven
Scenario Outline: Login with valid creds
And User enters an email as "<email>" and password as "<password>"
And User click on login button
Then User is navigated to Home page
And Close the browser

Examples: 
| email | password |
| admin@yourstore.com | admin |
| abc | 123 |
