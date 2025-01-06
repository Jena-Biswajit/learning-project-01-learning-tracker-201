### HTTP HEARDER
- HTTP headers are a fundamental part of the HTTP protocol, enabling the transfer of additional information between clients (browsers or applications) and servers in HTTP requests and responses.
- They are key-value pairs that convey metadata about the request or response.
- Here is an in-depth explanation of HTTP headers, categorized and explained with examples:

**Why HTTP Headers Exist?**
- HTTP headers provide the context and control information required for clients and servers to communicate effectively. They allow:
- **Customization:** Indicate content type, length, encoding, or accepted formats.
- **Caching:** Enable efficient resource caching and reuse.
- **Authentication and Security:** Carry tokens or cookies for authentication and session tracking.
- **Content Negotiation:** Specify preferred data formats (e.g., JSON, XML).
- **Performance Optimization:** Use features like compression, keep-alive connections, and prefetching.

**Structure of HTTP Headers**
- An HTTP header follows this syntax:
```
Header-Name: Header-Value
```
**Example**
```
Content-Type: application/json
```

- Categories of HTTP Headers
- General Headers
- Provide general information about the HTTP message, applicable to both requests and responses.
- **Cache-Control:** Controls caching behavior.
- **Example:** Cache-Control: no-cache (Do not use cached data.)
- **Connection:** Controls connection behavior.
- **Example:** Connection: keep-alive (Keep the connection open for future requests.)
- **Date:** Indicates the date and time the message was sent.
- **Example:** Date: Mon, 06 Jan 2025 12:00:00 GMT
- **Upgrade:** Signals the client or server to switch protocols.
- **Example:** Upgrade: HTTP/2.0

2. Request Headers
- Sent by the client to provide information about the request.
- **Accept:** Indicates acceptable response media types.
- **Example:** Accept: application/json
- **Accept-Encoding:** Indicates supported content encoding (compression).
- **Example:** Accept-Encoding: gzip, deflate
- **Authorization:** Contains credentials for authentication.
- **Example:** Authorization: Bearer <token>
- **Host:** Specifies the domain name of the server.
- **Example:** Host: www.example.com 
- **User-Agent:** Contains information about the client software.  
- **Example:** User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)

### What is a Cookie?
- A cookie is a key-value pair of information that a server sends to the browser. The browser stores the cookie and sends it back with each subsequent request to the same server, allowing the server to identify or track the user.

- **Cookie Structure**
- When a server sends a cookie, it includes the following attributes:
- **Name:** The key or identifier of the cookie.
- **Value:** The data or value associated with the cookie.
- **Domain:** Specifies the domain for which the cookie is valid.
- **Path:** Specifies the path or directory for which the cookie is valid.
- **Expires or Max-Age:** Determines when the cookie will expire.
- **Secure:** Indicates that the cookie should only be sent over HTTPS connections.
- **HttpOnly:** Ensures that the cookie is accessible only by the server and not by JavaScript.
- **SameSite:** Restricts how cookies are sent with cross-site requests to prevent cross-site request forgery (CSRF).





