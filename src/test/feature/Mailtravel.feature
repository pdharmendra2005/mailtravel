@Test
Feature: Verify the Grand Total

    Scenario: As a user ,When I'm booking for holiday & booking details.
              I see the payment amount as per my selection

    Given I am on phptravel admin page
    Then I should navigate to admin page
    When I enter "UserName" and "Password" and click on LogOn button
    Then I should navigate to the Dashboard Page
    When I click on Hotels & Bookings to book Hotel
    When I am on Add booking Page
    Then I select Hotels from Services
