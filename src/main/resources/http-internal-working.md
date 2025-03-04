### DNS Lookup Process

DNS Lookup is the process where the browser resolves a human-readable domain name into its corresponding IP address, allowing the browser to locate the web server.

---

## Types of DNS Lookups
1. **Recursive Lookup**:
    - The DNS resolver does all the work, querying multiple DNS servers on behalf of the client and returning the final result.
2. **Iterative Lookup**:
    - The DNS resolver queries one server at a time and gets referred to the next server if needed.

---

## Step-by-Step DNS Lookup Process
When you enter a URL (e.g., `www.example.com`) in your browser, the following steps occur:

---

### **1. Check Browser Cache**
- **What happens?**
    - The browser first checks its local DNS cache to see if the domain name has been recently resolved.
- **Example**:
    - You visited `www.example.com` 10 minutes ago, and the browser cached the IP address. It will use the cached IP address to skip further DNS queries.

---

### **2. Check OS-Level DNS Cache**
- **What happens?**
    - If the browser cache doesn’t have the IP address, the operating system (OS) checks its DNS cache.
- **Example**:
    - The OS stores recently resolved domains in a cache (e.g., `nslookup` results). If found, it uses this IP address.

---

### **3. Query Local DNS Resolver (ISP)**
- **What happens?**
    - If the OS cache doesn’t contain the IP, the request is sent to the DNS resolver, typically provided by your Internet Service Provider (ISP).
- **Example**:
    - The ISP resolver starts querying external DNS servers if it doesn’t have the IP address.

---

### **4. Query the Root DNS Server**
- **What happens?**
    - The resolver contacts one of the root DNS servers, which are the highest level in the DNS hierarchy.
- **Role of Root Server**:
    - The root server doesn’t provide the IP address directly. Instead, it points to the appropriate **TLD server** based on the domain extension (e.g., `.com`, `.org`).
- **Example**:
    - Query: “Where is `www.example.com`?”
    - Response: “Check the `.com` TLD server.”

---

### **5. Query the TLD DNS Server**
- **What happens?**
    - The resolver contacts the TLD server for the domain extension (e.g., `.com`).
- **Role of TLD Server**:
    - The TLD server doesn’t have the exact IP address but points to the authoritative name server for the requested domain.
- **Example**:
    - Query: “Where is `www.example.com`?”
    - Response: “Check the authoritative server for `example.com`.”

---

### **6. Query the Authoritative DNS Server**
- **What happens?**
    - The resolver contacts the authoritative name server for the domain (`example.com`).
- **Role of Authoritative Server**:
    - It has the actual DNS records and returns the IP address for the requested domain.
- **Example**:
    - Query: “What is the IP for `www.example.com`?”
    - Response: “192.168.1.100”

---

### **7. Return the IP Address to the Browser**
- **What happens?**
    - The resolver sends the IP address back to the browser.
- **Example**:
    - The browser now knows that `www.example.com` corresponds to `192.168.1.100`.

---

### **8. Browser Caches the Result**
- **What happens?**
    - To improve performance for future requests, the browser caches the resolved IP address.
- **Example**:
    - The next time you visit `www.example.com`, the browser uses the cached IP address.

---

## Example
Let’s resolve `www.google.com` step-by-step:

1. **Browser Cache**: Not found.
2. **OS Cache**: Not found.
3. **Resolver queries Root Server**: “Where is `www.google.com`?”
    - Response: “Check the `.com` TLD server.”
4. **Resolver queries `.com` TLD Server**: “Where is `www.google.com`?”
    - Response: “Check Google’s authoritative server.”
5. **Resolver queries Google’s Authoritative Server**: “What is the IP for `www.google.com`?”
    - Response: “142.250.190.206”
6. **Resolver sends `142.250.190.206` to the browser.”

---
**Note**

# Step 1: DNS (Domain Name System)

## What is DNS?
DNS (Domain Name System) is a hierarchical naming system used to identify computers, services, and other resources on the internet or private networks. It acts as the internet's phonebook, allowing humans to use readable domain names (like www.example.com) instead of numerical IP addresses (like 192.168.1.1) to access resources.

## Why is DNS Important?
- **Human-Friendly Names:** Instead of memorizing IP addresses, you can simply remember domain names like www.google.com.
- **Scalability:** It organizes and distributes the process of resolving billions of domain names across the internet efficiently.
- **Dynamic Updates:** DNS allows for dynamic updates of IP addresses, ensuring websites can change servers without disrupting user access.

## How DNS Works in General
DNS translates domain names into IP addresses. Every device connected to the internet, whether a server, computer, or smartphone, is assigned an IP address. DNS ensures that when you type a domain name, it resolves to the correct IP address.

## DNS Structure
DNS is structured as a hierarchy:

### Root Level:
- The top level of the DNS hierarchy. Represented by the `.` (dot).
- **Example:** For `www.example.com`, the root level is the last `.` (implicit in most cases).

### TLD (Top-Level Domain):
- Represents domain extensions like `.com`, `.org`, `.net`, etc.
- **Example:** For `www.example.com`, the TLD is `.com`.

### Second-Level Domain:
- The main part of the domain name.
- **Example:** For `www.example.com`, the second-level domain is `example`.

### Subdomain:
- An optional prefix that organizes resources.
- **Example:** In `www.example.com`, `www` is a subdomain.

### Host:
- Identifies the specific server or service (e.g., `www`, `mail`, or `api`).

## DNS Records
When a DNS query is made, the system retrieves specific DNS records:

- **A Record:** Maps a domain to an IPv4 address.  
  **Example:** `www.example.com → 192.168.1.1`
- **AAAA Record:** Maps a domain to an IPv6 address.  
  **Example:** `www.example.com → 2001:0db8::1`
- **CNAME Record:** Aliases one domain to another.  
  **Example:** `blog.example.com → www.example.com`
- **MX Record:** Specifies mail servers for a domain.  
  **Example:** `example.com → mail.example.com`
- **TXT Record:** Contains text information, often for security or verification.
- **NS Record:** Specifies the authoritative name servers for a domain.

## DNS vs IP Address
DNS is user-friendly and dynamic, while IP addresses are machine-readable and static or dynamic.

| **DNS**               | **IP Address**                       |
|-----------------------|--------------------------------------|
| Human-readable names  | Numerical addresses                  |
| Example: `www.google.com` | Example: `142.250.190.206`       |
| Can be updated dynamically | May be static or dynamic        |

---

### Step 2: TCP Connection

The **Transmission Control Protocol (TCP)** is the foundational protocol that HTTP relies on to transfer data reliably over the internet. When you initiate a request to access a website, the browser establishes a **TCP connection** with the server hosting the website.

---

#### **What is TCP?**
TCP (Transmission Control Protocol) is a transport-layer protocol in the **TCP/IP stack**. It ensures that data is transmitted reliably, in the correct order, and without loss or duplication.

---

#### **Why is TCP Important for HTTP?**
- **Reliable Delivery:** TCP ensures that all packets of data arrive intact and in the correct order.
- **Error Checking:** TCP verifies the integrity of transmitted data.
- **Flow Control:** TCP manages the rate of data transfer to prevent overwhelming the receiving device.
- **Connection-Oriented:** Before transmitting data, TCP establishes a connection, ensuring both client and server are ready for communication.

---

#### **How TCP Works in General**
TCP establishes a connection using a process called the **three-way handshake**, ensuring both the client and server are ready to send and receive data.

---

#### **Steps in the TCP Connection Process**
1. **SYN (Synchronize):**
  - The client sends a synchronization request (SYN) packet to the server, indicating it wants to establish a connection.

   **Example Packet:**
   ```
   Source IP: 192.168.1.10
   Destination IP: 142.250.190.206
   Flags: SYN
   Sequence Number: 1000
   ```

2. **SYN-ACK (Synchronize-Acknowledge):**
  - The server responds with a synchronization acknowledgment (SYN-ACK) packet, indicating it received the client's request and is ready to establish a connection.

   **Example Packet:**
   ```
   Source IP: 142.250.190.206
   Destination IP: 192.168.1.10
   Flags: SYN-ACK
   Sequence Number: 5000
   Acknowledgment Number: 1001
   ```

3. **ACK (Acknowledge):**
  - The client sends an acknowledgment (ACK) packet to confirm the connection is established. At this point, the connection is ready for data transmission.

   **Example Packet:**
   ```
   Source IP: 192.168.1.10
   Destination IP: 142.250.190.206
   Flags: ACK
   Sequence Number: 1001
   Acknowledgment Number: 5001
   ```

---

#### **How TCP Works with HTTP**
Once the TCP connection is established:
1. The browser sends the **HTTP request** (e.g., `GET /index.html`).
2. The server processes the request and sends the **HTTP response** (e.g., the HTML content of the webpage).
3. The connection remains open (persistent) or is closed based on the HTTP version.

---

#### **Persistent Connections (HTTP/1.1 and Above)**
- **HTTP/1.1:** Connections remain open for multiple requests and responses.
- **HTTP/2:** Enhances efficiency with multiplexing, allowing multiple requests and responses to occur over a single connection.

---

#### **When Does TCP Connection Occur?**
- **Always:** Every time you access a web resource (unless using a cached connection).
- **Before HTTP:** TCP ensures the underlying transport is ready for HTTP communication.

---

#### **Example of TCP Connection in a Browser**
1. You type `www.example.com` in your browser.
2. DNS resolves the domain to an IP address (e.g., `142.250.190.206`).
3. The browser opens a TCP connection to `142.250.190.206` on port 80 (HTTP) or 443 (HTTPS) using the three-way handshake.

---
