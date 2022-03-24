@Pagination
Feature: Pagination

  Background: Admin is logged in & Programs, Batches and Users(Registered and Unregistered) are created already

  @Pagination_User
  Scenario: Check functionality of Pagination at Manage user(Admin) page
    Given Admin is on Manage users(admin) page of User list(Unregistered)
    When result is containing many user records
    Then Arrow buttons will appear, large number of user records will be divided into smaller discrete pages

  @Pagination_Attendance
  Scenario: Check functionality of Pagination at Manage Attendance(Admin and Class Staff) page
    Given Admin is on  Manage Attendance(Admin and Class Staff) page of Manage Attendance(admin)
    When result is containing many  Student records
    Then Arrow buttons will appear, large number of Student records will be divided into smaller discrete pages
