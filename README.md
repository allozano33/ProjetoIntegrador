# ProjetoIntegrador

## Grupo 5 Wave - 3


### Requisito 6


### POST 1.1 - History buyer - List

Para consultar o pedido anterior no sistema é necessário efetuar uma requisição via postman

```
[
    {
        "historyListId": 7,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 8,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 9,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 10,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 11,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 12,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 13,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    },
    {
        "historyListId": 14,
        "date": "2021-10-31",
        "buyer": {
            "buyerId": 1,
            "cpf": "150.895.993-099",
            "name": "Alessandro",
            "address": {
                "street": "Rua das Bananeiras",
                "number": "80",
                "postalCode": "123455000",
                "city": "Mogi das Cruzes",
                "state": "São Paulo",
                "complement": "Casa"
            }
        },
        "orderStatus": {
            "orderStatusId": 1,
            "statusCode": "cart"
        },
        "historyItems": []
    }
]
```

***Link para uso:***

http://localhost:8080/api/v1/product/history/buyer/1



### PUT 1.2 - History buyer- Update


Para atualizar o pedido de entrada no sistema é necessário efetuar uma requisição via postman

```
{
    "date": "2021-10-31",
    "buyerId": 1,
    "orderStatus": {
        "orderStatusId": 1,
        "statusCode": "cart"
    },
    "historyItemDto": [
        {
            "productId": "MLB-499",
            "quantity": 1
        }
    ]
}
```

***Link para uso:***

 http://localhost:8080/api/v1/product/hystory/insert

### GET 1.3 - History buyer - Delete

Para obter uma lista de todos os produtos cadastrados

***Link para uso:***

http://localhost:8080/api/v1/product/delete/1


Exemplo de lista de produtos

```
{
    "date": "2021-10-31",
    "buyerId": 1,
    "orderStatus": {
        "orderStatusId": 1,
        "statusCode": "cart"
    },
    "historyItemDto": [
        {
            "productId": "MLB-499",
            "quantity": 1
        }
    ]
}

