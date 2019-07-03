# coding-test
coding test for Java Developer position at Synthesis

# Rest API for Create User
http://localhost:8080/createUser

#Valid JSON Payload for Create User
{
	"userName" : "test123",
	"address" : "brampton",
	"emailAddress" : "ab@ccom"
}

# Rest API for Process Payment
http://localhost:8080/processPayment

# Valid JSON Payload for Process Payment
{
	"cardNumber" : "4567765445677654",
	"expiryDate": "01/22",
	"cvv" : "111",
	"paymentAddress" : ""
}

# Rest API for Orchestration (create user followed by process payment)
http://localhost:8080/performBothAction

# Valid JSON Payload for Orchestration
{
	"user" : {
		"userName" : "abc",
		"address" : "brampton",
		"emailAddress" : "ab@c"
	},
	"paymentCard" : {
		"cardNumber" : "4567765445677654",
		"expiryDate": "01/22",
		"cvv" : "111",
		"paymentAddress" : "Brampton"
	}
}

# MVN version used
Apache Maven 3.3.9

#JDK used 
jdk_1.8




