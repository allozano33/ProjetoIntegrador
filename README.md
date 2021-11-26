# ProjetoIntegrador

## Grupo 5 Wave - 3


### Requisito 1


### POST 1.1 - InboundOrder - Insert

Para cadastrar o pedido de entrada no sistema é necessário efetuar uma requisição via postman

```
{
    "orderNumber": 45,
    "orderDate":"1998-07-23",
    "sectionCode": "SEC-126",
    "batchStockDto":[
        {
            "productSellerId": 1,
            "currentTemperature": 25,
            "minimumTemperature": 9.5,
            "initialQuantity": 100,
            "currentQuantity": 100,
            "manufacturingDate": "1998-07-23",
            "manufacturingTime": "2021-09-15T12:23:37.206794",
            "dueDate": "2021-11-23",
            "batchStockNumber": 77
        },
        {
            "productSellerId": 1,
            "currentTemperature": 25,
            "minimumTemperature": 9.5,
            "initialQuantity": 100,
            "currentQuantity": 100,
            "manufacturingDate": "1998-07-23",
            "manufacturingTime": "2021-09-15T12:23:37.206794",
            "dueDate": "2021-11-29",
            "batchStockNumber": 99
        }
    ]
}
```

***Link para uso:***

http://localhost:8090/api/v1/fresh-products/inboundorder/insert



### PUT 1.2 - InboundOrder - Update


Para atualizar o pedido de entrada no sistema é necessário efetuar uma requisição via postman

```
{
    "orderNumber": 40,
    "orderDate":"2021-07-23",
    "sectionCode": "SEC-125",
    "batchStockDto":[
        {
            "productSellerId": 1,
            "currentTemperature": 15,
            "minimumTemperature": 8,
            "initialQuantity": 40,
            "currentQuantity": 80,
            "manufacturingDate": "1998-07-23",
            "manufacturingTime": "2021-09-15T12:23:37.206794",
            "dueDate": "2021-11-23",
            "batchStockNumber": 1
        },
        {
            "productSellerId": 1,
            "currentTemperature": 20,
            "minimumTemperature": 9,
            "initialQuantity": 70,
            "currentQuantity": 90,
            "manufacturingDate": "1998-07-23",
            "manufacturingTime": "2021-09-15T12:23:37.206794",
            "dueDate": "2021-11-29",
            "batchStockNumber": 2
        }
    ]
}
```

***Link para uso:***

http://localhost:8090/api/v1/fresh-products/inboundorder/update/1

### GET 2.1 - Product - list all

Para obter uma lista de todos os produtos cadastrados

***Link para uso:***

http://localhost:8090/api/v1/product/list

Exemplo de lista de produtos

```
[
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-126",
            "name": "Uva",
            "description": "Caixa de Uva",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    },
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-127",
            "name": "Maca",
            "description": "Caixa de maca",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    },
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-129",
            "name": "Banana",
            "description": "Caixa de Banana",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    },
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-129",
            "name": "Banana",
            "description": "Caixa de Banana",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    },
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-129",
            "name": "Banana",
            "description": "Caixa de Banana",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    },
    {
        "volume": 80.0,
        "maximumTemperature": 23.0,
        "minimumTemperature": 9.5,
        "product": {
            "productId": "MLB-129",
            "name": "Banana",
            "description": "Caixa de Banana",
            "type": {
                "typeId": 1,
                "initials": "RF",
                "environmentType": "REFRIGERADOS"
            }
        }
    }
]
```


### GET 2.2 - InboundOrder - List Initials

Para obter uma lista ordenada pelo tipo do produto

***Link para uso:***

http://localhost:8090/api/v1/fresh-products/inboundorder/list/RF

Exemplo de lista

```
[
    {
        "productId": "MLB-126",
        "name": "Uva",
        "description": "Caixa de Uva",
        "type": {
            "typeId": 1,
            "initials": "RF",
            "environmentType": "REFRIGERADOS"
        }
    },
    {
        "productId": "MLB-127",
        "name": "Maca",
        "description": "Caixa de maca",
        "type": {
            "typeId": 1,
            "initials": "RF",
            "environmentType": "REFRIGERADOS"
        }
    },
    {
        "productId": "MLB-129",
        "name": "Banana",
        "description": "Caixa de Banana",
        "type": {
            "typeId": 1,
            "initials": "RF",
            "environmentType": "REFRIGERADOS"
        }
    }
