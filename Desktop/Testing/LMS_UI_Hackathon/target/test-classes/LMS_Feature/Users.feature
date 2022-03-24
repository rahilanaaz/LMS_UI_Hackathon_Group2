@Users
Feature: User modifications by Admin

  Background: Admin is logged in, Programs and Batches were created already

  @AdminSearch
  Scenario Outline: Check whether Admin can search users by giving Email or Batch or Skill or program
    Given Admin is on LMS Admin User Page, after clicking on User link
    When Admin clicks on search button after entering  "<Email>" or "<Batch>" or "<Skill>" or "<program>"
    Then Admin will be navigated to Manage users(admin) page and Registered User list will be displayed.

    Examples: 
      | Email            | Batch | Skill  | program |
      | dummy@gmail.com  |    01 | Python | SDET    |
      | dummy2@gmail.com |    02 | Java   | SDET    |

  @AdminEdit
  Scenario Outline: Check whether Admin can edit registered user in Manage users(admin) page
    Given Admin is on Manage users(admin) page, Registered Users list
    When Admin clicks on edit icon, admin will be navigated to Manage users(admin) page
    Then Admin able to edit User details like "<Timezone>" and "<Userrole>" and "<batch>" and"<Program>"

    Examples: 
      | Timezone | Userrole | batch  | program |
      | EST      | User     | SDET01 | SDET    |
      | PST      | User     | SDET02 | DML     |

  @AdminDelete
  Scenario: Check whether Admin can delete particular registered user in Manage users(admin) page
    Given Admin is on Manage users(admin) page, Registered Users list
    When Admin clicks on trash icon of particular registered user
    Then Deleted registered user will be removed from Registered users list

  @AdminNavigator
  Scenario: Check whether Admin will be navigated to manage users(admin) page when clicked on eye icon
    Given Admin is on Manage users(admin) page, Registered Users list
    When Admin clicks on eye icon for particular user
    Then Admin will be navigated to Admin Manage user page, view the User details only in read only format

  @AdminView
  Scenario: Check  whether Admin can be able  to view New Unassigned user
    Given Admin is on LMS Admin User Page
    When Admin clicks on New Unassigned User hyperlink
    Then Admin will be navigated to  Manage user(admin) page, Unregistered User list will be displayed

  @Admin_EditUnregisteredUser
  Scenario Outline: Check whether Admin can be able to edit Unregistered user
    Given Admin is on  Manage user(admin) page, Unregistered User list
    When Admin clicks on edit icon of particular unregistered user, admin will be navigated to manage users(admin) page
    Then Admin will be able to edit User details like "<Timezone>" and "<Userrole>" and "<batch>" and "<Program>"

    Examples: 
      | Timezone | Userrole | batch  | program |
      | EST      | User     | SDET01 | SDET    |
      | PST      | User     | SDET02 | DML     |

  @Admin_DeleteUnregisteredUser
  Scenario: Check whether Admin can be able to delete Unregistered user
    Given Admin is on  Manage user(admin) page, Unregistered User list
    When Admin clicks on trash icon of particular unregistered user
    Then Deleted unregistered user will be removed from Unregistered users list
