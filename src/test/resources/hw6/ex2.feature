Scenario: User Table Page Test
  Given I open JDI GitHub site
  And I login as user 'Roman Iovlev'
  When I click on 'Service' button in Header
  And I click on 'User Table' button in Service dropdown
  Then 'User Table' page shall be opened
  And 6 Number Type Dropdowns shall be displayed on Users Table on User Table Page
  And 6 Usernames shall be displayed on Users Table on User Table Page
  And 6 Description texts under images shall be displayed on Users Table on User Table Page
  And 6 checkboxes shall be displayed on Users Table on User Table Page
  And User Table shall contain following values:

  |Number |User             |Description                      |
  |1      |Roman            |Wolverine                        |
  |2      |Sergey Ivan      |Spider Man                       |
  |3      |Vladzimir        |Punisher                         |
  |4      |Helen Bennett    |Captain America some description |
  |5      |Yoshi Tannamuri  |Cyclope some description         |
  |6      |Giovanni Rovelli |Hulksome description             |

  And droplist shall contain values in column Type for user Roman

  |Dropdown Values|
  |Admin          |
  |User           |
  |Manager        |
