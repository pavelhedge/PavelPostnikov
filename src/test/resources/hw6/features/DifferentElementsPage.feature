Feature: Different Elements Page

  Scenario: select elements on Different Element Page
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    And I select checkbox 'Water'
    And I select checkbox 'Wind'
    And I select radio 'Selen'
    And I select dropdown 'Yellow'
    Then 1 log row has 'Yellow' text in log section
    And 2 log row has 'Selen' text in log section
    And 3 log row has 'Wind' text in log section
    And 4 log row has 'Water' text in log section
