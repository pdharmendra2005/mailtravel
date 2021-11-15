@Test
Feature: Verify the Grand Total

    Scenario Outline: As a user ,When I'm booking for holiday & booking details.
              I see the payment amount as per my selection

    Given I am on phptravel admin page
    Then I should navigate to admin page
    When I enter "UserName" and "Password" and click on LogOn button
    Then I should navigate to the Dashboard Page
    And  I click on Hotels & Bookings to book Hotel
    And  I am on Add booking Page
    And  I select Hotels from Services
    And  I enter Customer as "<Guest>", "<First Name>", "<Last Name>", "<Mobile>","<Email>" and enter next item
    And  I enter ITEM detail "<Check in>","<Check Out>","<Room Quantity>" enter next item
#    Then I should get "<Total Room Price>" as per my selection
#        And I enter "<>"


    Examples:
        | Guest | First Name    | Last Name    | Mobile   | Email                 | Check in   | Check Out  | Room Quantity |
        | Guest | firstnametest | lastnametest | 09999999 | hello_auto9@gmail.com | 16/11/2021 | 01/12/2021 | Room Quantity |

