
Upsert Product: 
Post /product

Request:

{
    "id": "5f8d260d100da40c73082148" //optional
	"name": "product1",
	"price": 50000
}

Response: 

{
    "errorMessage": null,
    "errorCode": null,
    "success": true,
    "value": {
        "id": "5f8d260d100da40c73082148",
        "name": "product1",
        "price": 50000
    }
}


Get Product By id: 
GET /product/{id}


Response: 

{
    "errorMessage": null,
    "errorCode": null,
    "success": true,
    "value": {
        "id": "5f8d260d100da40c73082148",
        "name": "product1",
        "price": 50000
    }
}


Get All product: 
GET /products


Response: 

{
    "errorMessage": null,
    "errorCode": null,
    "success": true,
    "content": [
        {
            "id": "5f8d260d100da40c73082148",
            "name": "product1",
            "price": 50000
        }
    ]
}


