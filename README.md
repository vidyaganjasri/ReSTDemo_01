# Product Management API

## REST Endpoints

### Get All Products
- **Endpoint:** `GET /products`
- **Description:** Retrieves all products from the database
- **Response:** List of Product objects
- **Status Code:** 200 OK

### Create Product
- **Endpoint:** `POST /products`
- **Description:** Creates a new product
- **Request Body:** Product object (JSON)
- **Response:** Success message
- **Status Code:** 201 Created

## Entity Structure

### Product Entity
```json
{
  "id": "integer",
  "name": "string",
  "description": "string",
  "price": "decimal",
  "quantity": "integer"
}
