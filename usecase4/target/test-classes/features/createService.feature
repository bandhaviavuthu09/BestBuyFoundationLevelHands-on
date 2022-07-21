Feature: Validate Create Service API

Scenario: Verify if Service is Created Succesfully by using CreateServiceAPI
    Given Create Service Payload with name
    When user calls "CreateServiceAPI" with "POST" http request
    Then the API call got success with status code 201