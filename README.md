# bankSystem


#FOR GENERATING JWT TOKEN
 
curl -X POST \
  https://protected-crag-41968.herokuapp.com/login \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWsiLCJyb2xlcyI6InVzZXIiLCJpYXQiOjE1NjQ1MDQzOTN9.p_eG59glQss7IF22TYzpyvvuxfMX2AMFTBJmjjCpeiU' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 9331ceb7-c607-4eb3-a9a1-dc476b9bbfda' \
  -d '{
"username":"nik12",
"password":"nik"
}'

#FOR GETTING BANK DETAILS FROM CITY AND BANK NAME

curl -X GET \
  'https://protected-crag-41968.herokuapp.com/secure/bankDetailsFromCityAndName?name=ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED&city=MUMBAI&offset=1&limit=2' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWsxMiIsInJvbGVzIjoidXNlciIsImlhdCI6MTU2NDU5ODY2MywiZXhwIjoxNTY1MDMwNjYzfQ.3SLmnplL6wv84-nWOZ5-egVpVNX8sJSSsQXgqxbHek4' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 76bd2d11-cebf-4f2a-9ce9-0ee84f62952d' \
  -d '{

"username":"nik12",
"password":"nik"

}'

#FOR GETTING BANK DETAILS FROM IFSC CODE

curl -X GET \
  'https://protected-crag-41968.herokuapp.com/secure/bankDetails?ifsc=ABHY0065007' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaWsiLCJyb2xlcyI6InVzZXIiLCJpYXQiOjE1NjQ1MDQzOTN9.p_eG59glQss7IF22TYzpyvvuxfMX2AMFTBJmjjCpeiU' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 1d66e9a9-27e4-459c-b0ab-72ac8af21fe5' \
  -d '{

"username":"nik12",
"password":"nik"

}'
