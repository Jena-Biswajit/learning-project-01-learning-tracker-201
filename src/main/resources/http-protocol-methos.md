### http protocol

- HTTP (Hypertext Transfer Protocol) is a communication protocol used to transfer data over the web.
- It defines how messages are formatted and transmitted and how web servers and browsers should respond to various
  requests.

**Example**

- Think of HTTP as a waiter in a restaurant.
- You (the client) request a dish (a web page), and the waiter (HTTP) brings it from the kitchen (the server) to your
  table (browser).

### How Does HTTP Work?

- HTTP works as a request-response protocol:
- The client (browser) sends a request to the server.
- The server processes the request and sends back a response.

---
**Note**

- What is request-response protocol ?
- A request-response protocol is a communication model where one party (the client) sends a request to another party (
  the server), and the server processes that request and sends back a response.
- This model is the foundation of many communication protocols, including HTTP (Hypertext Transfer Protocol), which is
  used for web communication.

***How It Works:***

- **Client Sends a Request:**
- The client (e.g., a web browser, mobile app) initiates communication by sending a request to the server.
- The request specifies what the client wants (e.g., a webpage, data, or to perform an action).


- **Server Processes the Request:**
- The server receives the request, understands it, and performs the necessary action (e.g., fetching a file, querying a
  database, or running a computation).


- **Server Sends a Response:**
- After processing, the server sends a response back to the client.


- **The response includes:**
- Status code (e.g., 200 OK, 404 Not Found).
- Data (e.g., the content of a webpage or JSON data).
- Headers (additional information about the response).


- **Client Handles the Response:**
- The client receives the response and processes it (e.g., displays the webpage or shows a success message).

---

***Internally (Steps):***

- **DNS Lookup:** The browser resolves the domain name (e.g., www.example.com) to an IP address.


- **TCP Connection:** HTTP operates over TCP (Transmission Control Protocol).
- The client establishes a TCP connection to the server on port 80 (default for HTTP) or 443 (for HTTPS).

- **Request Sending:** The browser sends an HTTP request.

- **Server Processing:** The server processes the request and prepares a response.

- **Response Receiving:** The client receives the HTTP response.

- **Connection Closing:** Depending on the HTTP version, the connection may stay open (persistent connection) or close.

**When and Where Does HTTP Work?**

- **When:**
- Whenever you use the web, such as visiting a website, submitting a form, or downloading a file.


- **Where:**
- Between web browsers (clients) and web servers.
- Between two systems communicating over the web, e.g., APIs.


- **HTTP is Stateless**
- HTTP is stateless, meaning each request is independent and doesn’t retain memory of previous interactions.


- **Example:**
- Imagine a vending machine: each time you insert money, it has no memory of previous purchases.


- **Solution:**
- To handle sessions (e.g., keeping users logged in), websites use:
- Cookies: Small pieces of data stored in the browser.
- Sessions: Server-side storage tied to a unique session ID.


- **Use Cases of HTTP**
- Web Browsing:
- Accessing websites (e.g., example.com).


- **APIs:**
- Fetching weather data using an API (GET api.weather.com/current).


- **File Transfer:**
- Downloading images, videos, or PDFs.


- **Internally (How HTTP Uses Layers):**
- HTTP relies on the OSI Model and TCP/IP Model:


- **Application Layer:** HTTP operates here.
- **Transport Layer:** Uses TCP for reliable delivery.
- **Network Layer:** IP handles routing packets between client and server.
- **Physical/Data Link Layers:** Transmit raw data over cables, Wi-Fi, etc.


- **Real-life Example Walkthrough**
- Let’s say you visit https://www.example.com:

- **Request Creation:**
- The browser forms an HTTP GET request for index.html.


- **DNS Lookup:**
- Resolves www.example.com to its IP address.


- **Connection Establishment:**
- The browser establishes a TCP connection with the server.


- **Request Transmission:**
- The browser sends the GET request to the server.


- **Server Processing:**
- The server retrieves index.html and sends it back.


- **Response Rendering:**
- The browser renders index.html on your screen.

### HTTP METHODS

**GET**
- The GET method retrieves data from the server.
- It's used to request resources like HTML pages, images, or data in JSON format.
- To fetch data without making changes to the server.
- **Displaying a webpage.**
- Loading images, scripts, or stylesheets.

- **Fetching data in APIs.**

- Webpages, APIs, or any resource you can read.

**Request:**
```http
GET /users HTTP/1.1
Host: example.com
```

**Response:**
```http
json
[
{"id": 1, "name": "John"},
{"id": 2, "name": "Jane"}
]
```

**POST**

- The POST method sends data to the server to create or update a resource.
- To send user input or create new data in a database.

- **Submitting a form.**
- Creating a new user, post, or order.
- APIs, forms, or any system requiring data submission.

**Request:**
```http
POST /users HTTP/1.1
Type: application/json
{
"name": "Alice",
"email": "alice@example.com"
}
```

**Response:**
```http
HTTP/1.1 201 Created
```

**PUT**

- The PUT method updates or creates a resource.
- It replaces the resource entirely if it already exists.
- To make idempotent (same result no matter how many times) updates to a resource.
- Updating a user profile.
- Overwriting existing data.
- In RESTful APIs.

**Request:**

```http
PUT /users/1 HTTP/1.1
Type: application/json
{
"name": "Alice",
"email": "alice_new@example.com"
}
```

**Response:**
```http
HTTP/1.1 200 OK
```

**PATCH**

- The PATCH method partially updates a resource.
- To update specific fields without replacing the entire resource.
- Editing user information (e.g., just updating an email).
- APIs handling incremental updates.

**Request:**
```http
GET /users HTTP/1.1
Host: example.com
```
**Response:**
```http
HTTP/1.1 200 OK
```

**DELETE**
- The DELETE method removes a resource from the server.
- To free up space or remove unwanted data.
- Deleting a user account.
- Removing an article or comment.
- RESTful APIs or admin systems.

**Request:**
```http
DELETE /users/1 HTTP/1.1
```

**Response:**
```http
HTTP/1.1 204 No Content
```

**OPTIONS**
- The OPTIONS method describes the communication options available for a resource.
- To understand the supported HTTP methods of a resource.
- Before making a cross-origin request.
- API exploration tools like Postman.
- Debugging or configuring API requests.

**Request:**
```http
OPTIONS /users HTTP/1.1
```

**Response:**
```http
Allow: GET, POST, PUT, DELETE
```

** HEAD**
- The HEAD method retrieves headers of a resource without the body.
- To check if a resource exists or verify its metadata.
- Checking if an image URL is valid.
- Verifying content type or cache status.
- APIs or websites.

**Request:**
```http
HEAD /users HTTP/1.1
```

**Response:**
```http
HTTP/1.1 200 OK
```
**TRACE**
- The TRACE method echoes the received request for debugging purposes.
- To debug connection issues.
- Debugging intermediaries like proxies.

**Request:**
```http
TRACE /users HTTP/1.1
```

**Response:**
```http
HTTP/1.1 200 OK
TRACE /users HTTP/1.1 
```

**CONNECT**
- The CONNECT method establishes a tunnel to the server for communication.
- To set up a secure HTTPS connection.
- During TLS handshakes.
- Proxy servers or HTTPS connections.

**Request:**
```http
CONNECT example.com:443 HTTP/1.1
```

**Response:**
```http
HTTP/1.1 200 Connection Established
```

**Summary Table**

| Method   | Description                     | Cacheable | Idempotent | Safe |
|----------|---------------------------------|-----------|------------|------|
| GET      | Fetch data                      | Yes       | Yes        | Yes  |
| POST     | Submit data to server           | No        | No         | No   |
| PUT      | Replace/Update a resource       | No        | Yes        | No   |
| PATCH    | Partial update of a resource    | No        | No         | No   |
| DELETE   | Delete a resource               | No        | Yes        | No   |
| OPTIONS  | Retrieve allowed methods        | Yes       | Yes        | No   |
| HEAD     | Retrieve headers only           | Yes       | Yes        | Yes  |
| TRACE    | Echo request for debugging      | No        | Yes        | No   |
| CONNECT  | Establish tunnel for HTTPS      | No        | No         | No   |


### What is cURL?
- cURL (Client URL) is a command-line tool and library for transferring data with URLs.
- It supports multiple protocols, including HTTP, HTTPS, FTP, and more. cURL is widely used for making requests to servers to fetch resources or interact with APIs.

## Understanding cURL Endpoints
- In the context of web APIs, **endpoints** are specific URLs (or paths) that allow you to interact with resources on the server.
- A **cURL endpoint** is simply an endpoint accessed using the `curl` command, which is used to make HTTP requests to APIs.

### Basic cURL Command

The general syntax for a cURL command is:

```
curl [options] [URL]
```

- **[options]**: Options control the behavior of the request (e.g., `-X` for HTTP methods, `-d` for data).
- **[URL]**: The URL of the endpoint you want to interact with.

---

## Common cURL Methods and Options

### 1. **GET Request** - Retrieving Data
The `GET` method is used to fetch data from a specified endpoint.

Example:
```
curl -X GET https://jsonplaceholder.typicode.com/posts
```

### 2. **POST Request** - Sending Data
The `POST` method is used to send data to the server. For example, submitting a form or sending data to an API.

Example:
```
curl -X POST https://jsonplaceholder.typicode.com/posts -d '{"title": "Hello", "body": "World"}' -H "Content-Type: application/json"
```

### 3. **PUT Request** - Updating Data
The `PUT` method is used to update an existing resource on the server.

Example:
```
curl -X PUT https://jsonplaceholder.typicode.com/posts/1 -d '{"id": 1, "title": "Updated Title", "body": "Updated Body"}' -H "Content-Type: application/json"
```

### 4. **DELETE Request** - Deleting Data
The `DELETE` method is used to remove a resource from the server.

Example:
```
curl -X DELETE https://jsonplaceholder.typicode.com/posts/1
```

---

## Common cURL Options

- `-X <METHOD>`: Specify the HTTP method (GET, POST, PUT, DELETE, etc.).
- `-d <DATA>`: Send data with the request (used with POST and PUT).
- `-H <HEADER>`: Set request headers (e.g., `Content-Type`).
- `-u <USER:PASS>`: Send authentication information (username:password).
- `-i`: Include the response headers in the output.
- `-v`: Make the operation more verbose for debugging.

---

## Example: Interacting with a REST API

### 1. **GET Request** (Fetch data)
```
curl -X GET https://jsonplaceholder.typicode.com/posts
```

### 2. **POST Request** (Create a new resource)
```
curl -X POST https://jsonplaceholder.typicode.com/posts -d '{"title": "New Post", "body": "Post content"}' -H "Content-Type: application/json"
```

### 3. **PUT Request** (Update an existing resource)
```
curl -X PUT https://jsonplaceholder.typicode.com/posts/1 -d '{"title": "Updated Post", "body": "Updated content"}' -H "Content-Type: application/json"
```

### 4. **DELETE Request** (Delete a resource)
```
curl -X DELETE https://jsonplaceholder.typicode.com/posts/1
```

---

## Conclusion
- cURL is a versatile tool that is widely used in web development and API testing.
- By interacting with endpoints, you can send requests and process the responses from web servers.
- Learning cURL endpoints and understanding HTTP methods will help you efficiently work with web APIs.
