#Midterm Banking System


1.Description of the project

This project is based on a simple Banking System, where Account Holders can make transferences between eachother aswell as Third Parties.
Both Account Holders and Third Parties must have the following conditions met to be able to carry out these transactions:
  
- For Account Holders:
The transfer should only be processed if the account has sufficient funds. The user must provide the Primary or Secondary owner's name and the id of the account that should receive the transfer.
- For Third PArties: 
In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request. They also must provide the amount, the Account id, and the account secret key

The System has further features such as Pentaly Fees, Interest Rates, and Security implemetations as Authentication and Authorization.

4.Technologies Used

The project was developed using a Java/Spring Boot backend.
All information is stored in MySQL database tables
Authentication and authorization is implemented using Spring Security.
Other thechnologies were Spring Data JPA, Spring Web and Lambok, between others.

5.Models


6.Server routes table(Method, Route or URL, Description as columns)

Some of the System's Endpoints are:

- POST Petitions
  -/banking/login?username=john&password=1234
  With Query Params username=john & password=1234
  
  - /banking/accounts/creditcards
  - /banking/accounts/savings
  - /banking/accounts/checkings
  All with a similar raw Json body such as:
        {
          "balance": {
              "amount": 1000,
              "currency": "EUR"
          },
          "primaryOwnerId": 2,
          "secondaryOwnerId": 1,
          "secretKey": 1234,
          "minimumBalance": {
              "amount": 123,
              "currency": "EUR"
          },
          "monthlyMaintenanceFee": {
              "amount": 0,
              "currency": "EUR"
          }
      }


  - /banking/users/account-holder
  With a raw Json body such as:
       {
        "name": "Gilda Doe",
        "username": "gilda",
        "password": "imgilda",
        "roles": [
            {
                "id": 1,
                "name": "ROLE_USER"
            }
        ],
        "accounts": [],
        "dateOfBirth": "2001-02-27",
        "primaryAddress": {},
        "mailingAddress": {}
    }
    
  - /banking/third-party
  With a raw Json body such as:
  {
        "name": "Manuela Morales",
        "ashedKey": 1234
    }
  
  - /banking/third-party/send-transaction
  - /banking/third-party/receive-transaction
  - /banking/transactions
  All with a similar raw Json body such as:
    {
        "requesterAccountId": 3,
        "targetAccountId": 4,
        "amount":{
            "amount": 50,
            "currency":"EUR"
        }
    }
    
   - /banking/roles
   - /banking/roles/adduser
    
    

- GET Petitions.
  - /banking/accounts
  - /banking/checkings
  - /banking/creditcards
  - /banking/savings
  - /banking/student-checkings
  - /banking/checkings/balance/{id}
  - /banking/creditcards/balance/{id}
  - /banking/savings/balance/{id}
  - /banking/student-checkings/balance/{id}
  - /banking/users
  - /account-holders
  - /banking/third-party

- PATCH Petitions
  - /banking/checkings/balance/{id}
  - /banking/creditcards/balance/{id}
  - /banking/savings/balance/{id}
  - /banking/student-checkings/balance/{id}
  All with a similar raw Json body such as:
       {
        "balance":{
            "amount": 1000,
            "currency": "EUR"
          }
      }
   


7.Future Work

The project can be improved by adding further validation and error handling with their proper testing.
Bonus features such as fraud detection could be implemented.
And an over all bettered architectural design.

As for continuing the project, further features could be implemented to resemble the banking systems we all know and use. 

8.Resources

Overall relied on previous teachings and projects. Aswell as web searches through Google, Baeldung, Oracle, StackOverflow and Thorben-Janssen mainly.
Learned a valuable lesson on relying more on my Mentors and Peers which I wish I reached out to earlier. I am greatfull for all the advice and gidance they shared with me.
