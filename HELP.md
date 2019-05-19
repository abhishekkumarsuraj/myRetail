# Getting Started

Technical Stack :
1) Spring Boot (with Java 8)
2) Data Source (H2 Run Time Data base Sql Script is provided for initial referece data)
3) Junit with Mockito is used for TestCase design
### Guides
The following guides illustrate how to use some features concretely:

Test case are designed:
myRetail\src\test\java\com\myRetail\myRetail\controller
 ==> ApiControllerGetProductsTest : Has One Tests which is for getting All the Product and able to test it,
                                    Change the temp value at all the places as per testing record ID.

 ==> ApiControllerTest : Has Two test cases
            1) addProduct() : for POST call .
            2) getProduct() : for Single Record retrieval

## Data Source
we can access the Data Source At Run Time

In Case We are running in Local Host then
web URL : http://localhost:8080/h2

jdbc URL : jdbc:h2:mem:testdb
password : not required

# data.sql : can be found in resource path, Used for initial data insertion.

### Important URL's For Rest Call :

GET Call To retrieve all Products : http://localhost:8080/api/products
GET Call To retrieve one Products as per ID : http://localhost:8080/api/products/{id}
POST Call to insert record in H2 DB : http://localhost:8080/api/addProduct
Content Format :

{"id":0,"name":"The Black Suite ","current_price":{"value":15.05,"currency_code":"USD"}}

Content type : JSON(application/json)

NOTE : if id = 0 in provided content then API will generate ID stating from "15117729" will get incremented by 1 in every
       record insertion .
       if id = nonZero will insert the same ID.

No Password required .

Update ia Possible only for Available record(if known otherwise it will add new record )
through POST call with Above format of Content .




