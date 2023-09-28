# Validations API

API: https://validation-api-webservice.onrender.com

A Validations API é um serviço simples que permite validar endereços de e-mail e números de CPF (Cadastro de Pessoas Físicas). Esta API oferece uma maneira rápida e fácil de verificar se um endereço de e-mail ou CPF é válido.

### Recurso `/validations/email`

Este recurso permite a validação de endereços de e-mail.

Método: **POST**

Corpo da Requisição: **JSON**

```json
{
  "email": "user@example.com"
}

````

#### Exemplo de Requisição:

```bash
POST /validations/email
Content-Type: application/json

{
  "email": "user@example.com"
}
````


### Respostas:

| Status Code | Description | Response Body |
| --- | --- | --- |
| 200 | Validation is success | { "email": "string" }
| 400 | Validation is invalid | {"message": "string", "statusCode": "number"} |


<hr>

### Recurso `/validations/cpf`


Este recurso permite a validação de números de CPF (Cadastro de Pessoas Físicas).

**Método**: POST

Corpo da Requisição: **JSON**

````json
{
    "cpf": "123.456.789-09"
}
````

#### Exemplo de Requisição:

````bash

POST /validations/cpf
Content-Type: application/json

{
  "cpf": "123.456.789-09"
}
````

### Respostas:

| Status Code | Description | Response Body |
| --- | --- | --- |
| 200 | Validation is success | { "cpf": "string" }
| 400 | Validation is invalid | {"message": "string", "statusCode": "number"} |

<hr>

### Recurso `/validations/cnpj`

Este recurso permite a validação de números de CNPJ (Cadastro Nacional da Pessoa Jurídica).

Método: **POST**

Corpo da Requisição: **JSON**

````json
{
  "cnpj": "12.345.678/0001-01"
}
````

```` bash
POST /validations/cnpj
Content-Type: application/json

{
  "cnpj": "12.345.678/0001-01"
}
````

### Respostas:

| Status Code | Description | Response Body |
| --- | --- | --- |
| 200 | Validation is success | { "cnpj": "string" }
| 400 | Validation is invalid | {"message": "string", "statusCode": "number"} |

<hr>


Esta API simplifica a validação de endereços de e-mail, números de CPF e números de CNPJ, fornecendo uma resposta clara sobre a validade dos dados inseridos. Use-a para melhorar a qualidade dos dados em seus aplicativos e sistemas.

Para utilizar a API, siga as instruções fornecidas acima para cada recurso específico.