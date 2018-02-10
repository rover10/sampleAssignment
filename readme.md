This is a spring boot application without using any Inmemory database.
The expiration time is 5 second now witch can be changed by changing a constant value RESET_LIMIT  in UserService class.

APIs

GET   
http://localhost:8080/users

POST 
1. Reset through Email
   http://localhost:8080/user/resetpassword?email=rakesh.r1303@gmail.com


2. Reset through Mobile otp
   http://localhost:8080/user/resetpassword?mobile=9971588951

 
