Feature: Different Elements Page

  Scenario: select elements on Different Element Page
    Given I'm logged in as user 'Roman Iovlev'
    And I'm on Different Elements Page
    When I select checkbox 'Water'
    And I select checkbox 'Wind'
    And I select radio 'Selen'
    And I select dropdown 'Yellow'
    Then Log row #1 shall contain record with 'Yellow'
    And Log row #2 shall contain record with 'Selen'
    And Log row #3 shall contain record with 'Wind'
    And Log row #4 shall contain record with 'Water'
