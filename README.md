 # Basic description
RESTful API that interacts with a PostgreSQL database. Implemented in Java with Spring Boot and Mavenized. Edited in eclipse. Pushed to heroku.  
  
 # Example HTTP requests via cURL (be sure to update as needed)
 ## Create a product
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"lookupCode":"lookupcode4","count":175}' https://uarkregserv.herokuapp.com/api/product/`  
 ## Update an existing product by record ID
`curl -i -s -H "Content-Type: application/json" -X PUT -d '{"id":"bee20aed-5245-46a7-b19c-9ef6abd4ca5c","lookupCode":"lookupcode4","count":200}' https://uarkregserv.herokuapp.com/api/product/bee20aed-5245-46a7-b19c-9ef6abd4ca5c`  
 ## Delete an existing product by record ID
`curl -i -s -X DELETE https://uarkregserv.herokuapp.com/api/product/bee20aed-5245-46a7-b19c-9ef6abd4ca5c`  

## Create an Employee
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"employeeID":"72736","firstName":"Steven","lastName":"Thomas", "active":"", "role":"worker", "manage":"34526", "password":"8960"}' https://team-placeholder.herokuapp.com/api/employee/`

## Employee login
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"employeeID":"72731", "password":"heythere"}' https://team-placeholder.herokuapp.com/api/employee/login/`

## Create New Transaction
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"transactionId": 3, "cashierId": "3","totalSales": 57}' https://team-placeholder.herokuapp.com/api/employee/login/`

## Create New Item bought
`curl -i -s -H "Content-Type: application/json" -X POST -d '{"transactionId":"3","productName":"kiwi,oranges", "quantity":"3,5", "total":575}' https://team-placeholder.herokuapp.com/api/item/`
