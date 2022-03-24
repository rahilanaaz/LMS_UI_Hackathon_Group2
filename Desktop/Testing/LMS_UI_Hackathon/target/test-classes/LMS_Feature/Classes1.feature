@Classes
Feature: Different Classes Modifications By Admin
Background: Admin is logged in,Batches and Classes with exisiting ID

@AddNewClass
Scenario Outline: Check whether Admin can ADD New Class for Particular Batch

Given Admin is on Add tab by clicking on Add Class in Manage Classes page(admin)
When  Admin clicks on submit button after enters "<ClassTopic>" and "<StaffName>" and "<ClassDescrp>" and "<ClassComment>"
Then  Created Class will be displayed in Manage Classes Page(admin)

  Examples:
            | ClassTopic  | StaffName  | ClassDescp  | ClassComment|
            | Selenium    |  staff1    | MyClassTest | Upload      |


@EditClass
Scenario Outline: Check whether Admin can Edit existing Class for particular Batch
Given Admin is on Edit tab by cliking on Edit icon in Manage Classes page(admin)
When  Admin clicks on submit button after enters "<ClassTopic>" and "<StaffName>" and "<ClassDescrp>"
Then  Updated Class details will be displayed in Manage Classes Page(admin)

Examples:
                | ClassTopic | StaffName| ClassDescrp     |
                | SDET       | staff2   | MyClassTest     |

@DeleteClass
Scenario: Check whether Admin can Delete existing Class for particular Batch
Given Admin is on Manage Classes Page(admin) by clicking on Manage Classes tab
When  Admin clicks on Trash icon of existing Class for particular Batch
Then  Deleted Class will be removed from Manage Classes Page(admin)
