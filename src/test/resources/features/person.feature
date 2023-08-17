Feature: Person
    A person represents a real person of the system, but without opinions as to their role in the system.


  Scenario: A test can be executed
    Given a first name "John"
    Given a last name "Doe"
    Given an email "john.doe@review.community"
    When a new user is created
    Then the person's id is 1
    Then the person's first name is "John"
    Then the person's last name is "Doe"
    Then the person's email is "john.doe@review.community"
