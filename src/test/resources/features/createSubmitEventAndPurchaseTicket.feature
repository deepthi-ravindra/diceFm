@test
Feature: Creation and submission of new event on sale, register new user and purchase ticket

  As an Quality Assurance automation engineer, I want to create and submit an event with 2 ticket types(Standing and Unreserved seating) through the MIO Dashboard successfully and purchase an unreserved seating ticket successfully through the Dice Web for the event.
  As an event creator, I want to create and submit an event on sale, publish on the Dice Web for the customers to purchase tickets for the event successfully.
  As a new Dice FM customer and music lover, I want to purchase unreserved seating ticket for the event successfully

  Background:
    Given I am on the event creation login page
    And I login to MIO as MIO user
    And I click create new event button

  Scenario Outline: Create and Submit an event that is on sale, view event on web, purchase 2nd type of ticket as new user
    When I select Basics eventType "<eventType>", Artist "<artist>", Genre "<genre>", Venue name "<venue name>"
    And I fill in Timeline details with timeZone "<timezone>"
    And I fill in Information details
    And I click on Add Tickets button
    And I create ticket type "<ticketType1>"
    And I create ticket type "<ticketType2>"
    And I fill in Settings details
    And I save event and continue
    And I submit the event details
    Then I verify the event creation are successful
    And I can successfully preview the event
    And I am able to view the event on the web
    When I click on Buy Now button on Dice home page
    And I purchase ticket type "<ticketType2>"
    And I register as new user by entering authentication details
    And I successfully make payment using credit card
    Then I verify the Order Confirmation success parameters

    Examples:
      | artist  | eventType | genre      | venue name | timezone                        | ticketType1 | ticketType2        |
      | Rihanna | Gigs      | deep house | DICE VENUE | (GMT+01:00) British Summer Time | Standing    | Unreserved Seating |

  Scenario Outline: Verify error message is displayed with unexpected actions
    When I select Basics eventType "<eventType>", Artist "<artist>", Genre "<genre>", Venue name "<venue name>"
    And I fill in incorrect Timeline details with timeZone "<timezone>"
    And I verify error message is displayed

    Examples:
      | artist  | eventType | genre      | venue name | timezone                        |
      | Rihanna | Gigs      | deep house | DICE VENUE | (GMT+01:00) British Summer Time |