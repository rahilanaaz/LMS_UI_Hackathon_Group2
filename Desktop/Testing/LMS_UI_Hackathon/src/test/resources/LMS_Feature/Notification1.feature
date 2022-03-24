@Notification
Feature: Submit(send) notifcation by Admin
Background: Admin is logged in,Program Name were already created

  @CreateNotification
  Scenario Outline: Check whether Admin can create notification
    Given Admin is on  Notification page.
    When Admin clicks on submit button after selecting "<program_name>" from dropdown and enter details  "<hackathon_name>","<hackathon_description>","<Hackathon_date>" and "<hackathon_comments>"
    Then Notifications will be submitted successfully
    Examples:
      | program_name  | hackathon_name | hackathon_description  | Hackathon_date | hackathon_comments |
      | SDET31        |    LMS UI      | tdd                    | 3/21/2022      | In progress |
      | SDET32        |     API        | tdd                    | 3/21/2022      | In progress |