# Meal Planet Restaurant Management System

This Spring Boot application  includes functionality for Menu Management, Order Management, and Revenue Calculation.

## Technical Decisions

- **Spring Boot**: Spring Boot is used to set up a production-ready Spring application.
- **H2 Database**: H2 in-memory database is used for storing menu items.
- **Map<RestId,Map<OrderId, Order>**: Map Data structure is used for storing orders at each restaurant
- **RESTful API**: RESTful endpoints are exposed for interacting with the system.

## Endpoints

### Menu Management

- `POST /menu/add`: Add a new menu item.
- `GET /menu/all`: Get all menu items.
- `GET /menu/all/{restId}`: Get all menu items for a specific restaurant.
- `DELTE /menu/remove/{menuId}`: To remove a menuItem.

### Order Management

- `POST /order/add`: Add a new item to the order.
- `DELETE /order/remove/{itemId}`: Remove an item from the order.
- `GET /order/summary`: Get the total ordered items for a particular order.

## Revenue Calculation
- `GET /revenue/{restId}`: To get the revenue generated per restaurant wise.
- `GET /revenue/all`: To get the total revenue generate from all the restaurant.

## How to Run

1. Navigate to the project directory
2. Build the project: `./gradlew build`
3. Run the application: `./gradlew bootRun`

The application will start on `http://localhost:8080`. Use Postman or curl to interact with the endpoints.
or use Swagger url to interact with the UI at: http://localhost:8080/swagger-ui/index.html#/
## Improvements

- Proper Database configuration can be done To Implement a persistent database to store orders and menu items permanently., something like this schema:
- Restaurant
  |   id (PK)    |   restaurantName    |   description    |   location   |

MenuItem
|   id (PK)    |   name    |   description    |   price   |   stock   |   restaurant_id (FK)   |

Order
|   id (PK)    |   restaurant_id (FK)   |

OrderItem
|   id (PK)    |   order_id (FK)   |   item_id (FK)   |   item_name   |   item_price   |   quantity   |


- robust error handling and validation for input data can be done


