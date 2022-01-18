#!/bin/bash
echo "testing the basic command crud of Prodcut API in gateway API project"
echo "set your local host port"
read port
localhost="http://locahost:$port"
echo $localhost

GET_RESULT="$(curl -X GET http://localhost:8081/Product)"

POST_RESULAT="$(curl -i -X POST http://localhost:8081/Product/empty)"
