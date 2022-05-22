#Midterm Banking System


1.Description of the project

This project is based on a simple Banking System, where Account Holders can make transferences between eachother aswell as Third Parties.
<br>Both Account Holders and Third Parties must have the following conditions met to be able to carry out these transactions:
  
- For Account Holders:
The transfer should only be processed if the account has sufficient funds. The user must provide the Primary or Secondary owner's <br>name and the id of the account that should receive the transfer.
- For Third PArties: 
In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request.<br> They also must provide the amount, the Account id, and the account secret key

<br>The System has further features such as Pentaly Fees, Interest Rates, and Security implemetations as Authentication and Authorization.

2.Technologies Used

The project was developed using a Java/Spring Boot backend.
<br>All information is stored in MySQL database tables
<br>Authentication and authorization is implemented using Spring Security.
<br>Other thechnologies were Spring Data JPA, Spring Web and Lambok, between others.

3.Models

![image](https://user-images.githubusercontent.com/33453535/169715419-b64ead24-3c40-473e-ad25-093993ec83ab.png)


4.Server routes table(Method, Route or URL, Description as columns)

<br>Some of the System's Endpoints are:

- POST Petitions
  -/banking/login?username=john&password=1234
  <br>With Query Params username=john & password=1234
  
  - /banking/accounts/creditcards
  - /banking/accounts/savings
  - /banking/accounts/checkings
  <br>All with a similar raw Json body such as:
        {<br>
          "balance": {<br>
              "amount": 1000,<br>
              "currency": "EUR"<br>
          },<br>
          "primaryOwnerId": 2,<br>
          "secondaryOwnerId": 1,<br>
          "secretKey": 1234,<br>
          "minimumBalance": {<br>
              "amount": 123,<br>
              "currency": "EUR"<br>
          },<br>
          "monthlyMaintenanceFee": {<br>
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
  <br>All with a similar raw Json body such as:
       {
        "balance":{
            "amount": 1000,
            "currency": "EUR"
          }
      }
   


5.Future Work

The project can be improved by adding further validation and error handling with their proper testing.
Bonus features such as fraud detection could be implemented.
And an over all bettered architectural design.

As for continuing the project, further features could be implemented to resemble the banking systems we all know and use. 

6.Resources

Overall relied on previous teachings and projects. Aswell as web searches through Google, Baeldung, Oracle, StackOverflow and Thorben-Janssen mainly.
Learned a valuable lesson on relying more on my Mentors and Peers which I wish I reached out to earlier. I am greatfull for all the advice and gidance they shared with me.
