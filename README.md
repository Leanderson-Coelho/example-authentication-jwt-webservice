# Example Authentication JWT Webservice
## Font 
https://blog.totalcross.com/pt/seguranca-com-jwt-e-java/

## API 
(Leanderson Coelho)[leanderson.coelhoif@gmail.com]

## How to use
create a new user on database for use login.
Use authentication token in request header after run login, for new requests.  

### Tests
##### POST localhost:8080/api/clients/ -> create user ( necessary login )

##### GET localhost:8080/api/clients/{email} -> find user ( necessary login )

##### POST localhost:8080/api/clients/login -> login (token generated)


