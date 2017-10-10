Feature: Notes test
    In order to value
    As a role
    I want feature

Scenario: Create a Note 

* def user =
"""
{
  "id": 0,
  "date": "string",
  "notes": "string"
}
"""

Scenario: Save a Notes

Given url 'http://localhost:8080/Note/save'
And request user
When method post
Then status 201


Scenario: Get all Notes

Given url 'http://localhost:8080/Note/get'
When method get
Then status 200

Scenario: Delete a Notes

* def val = '1'
Given url 'http://localhost:8080/Note/delete/1'
And request val
When method delete
Then status 500

Scenario: update the Notes

* def u23 =
"""
{
  "id": 2,
  "date": "13.09.2017",
  "notes": "Hai"
}
"""
Given url 'http://localhost:8080/Note/update/2'
And request u23 
When method put
Then status 200


