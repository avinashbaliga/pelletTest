Feature: To test the creation(create), modification(edit), Filtration(filter) and deletion of leads

  Scenario: Create a Lead
    Given I'm logged in to Zoho CRM
    When I click on Leads
    And I click on create a lead
    Then I should be able to create a lead with given details
      | FirstName | LastName   | Company |
      | Avinash   | PalletTest | Company |


  Scenario: Modify a Lead
    Given I'm logged in to Zoho CRM
    When I click on Leads
    Then I should be able to view existing leads
    And I should be able to modify the existing lead
      | FirstName     | LastName    | Company |
      | AvinashPallet | SecondRound | Company |


  Scenario: Delete a Lead
    Given I'm logged in to Zoho CRM
    When I click on Leads
    Then I should be able to view existing leads
    And I should be able to delete lead with index
      | 1                   |
