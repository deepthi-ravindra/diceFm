Feature: Creation of live event

  Background:
    Given I am on the event creation login page

  @test
  Scenario Outline: Create an event that is on sale
    And I login to MIO as MIO user
    And I create new event
    When I select Basics eventType "<eventType>", Artist "<artist>", Title "<title>", Genre "<genre>", Venue name "<venue name>"
    And I fill in Timeline details timeZone "<timezone>"
    And I fill in Information details timeZone
    And I click on Add Tickets button
    And I create ticket type "<ticketType1>"
    And I create ticket type "<ticketType2>"
    And I fill in Settings details
    And I save draft
#    And I open the created event in web
#    Then I should successfully see the event is created and on sale that should contain 2 tickets

    Examples:
      | artist  | eventType | title        | genre      | venue name | timezone                        | ticketType1 | ticketType2        |
      | Rhianna | Gigs      | Rhianna Live | deep house | DICE VENUE | (GMT+01:00) British Summer Time | Standing    | Unreserved Seating |