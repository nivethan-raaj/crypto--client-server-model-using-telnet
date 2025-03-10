# Secure Communication and Packet Analysis Project

## Overview
This project demonstrates secure and non-secure communication protocols, including Telnet and SSH, along with packet capturing and analysis. It includes:
- A **Telnet Client-Server model** for unsecured communication.
- **SSH-based Secure Communication**.
- **Packet Capturing and Analysis** using JNetPcap.
- **Message Authentication using MD5-HMAC**.

## Project Structure
```
cryptoproject/
│-- TelnetServer.java     # Telnet Server Implementation
│-- TelnetClient.java     # Telnet Client Implementation
│-- SSHClient.java        # Secure SSH Client Implementation
│-- PacketCapture.java    # Packet Sniffing and Analysis
│-- README.md             # Project Documentation
```

## Prerequisites
- **Java Development Kit (JDK) 8+**
- **JSch Library** (for SSH communication)
- **JNetPcap Library** (for packet capturing)
- **Wireshark** (optional, for packet analysis)

## Setup Instructions
### 1. Download Dependencies
- **JSch**: [Download](http://www.jcraft.com/jsch/)
- **JNetPcap**: [Download](https://sourceforge.net/projects/jnetpcap/)

Move the JAR files to the project directory.

### 2. Compile the Project
Run the following commands to compile the files:
```sh
javac -cp ".;jsch-0.1.55.jar;jnetpcap.jar" TelnetServer.java TelnetClient.java SSHClient.java PacketCapture.java
```

### 3. Running the Programs
#### Run Telnet Server
```sh
java -cp "." TelnetServer
```
#### Run Telnet Client
```sh
java -cp "." TelnetClient
```
#### Run SSH Client
```sh
java -cp ".;jsch-0.1.55.jar" SSHClient
```
#### Run Packet Capture
```sh
java -cp ".;jnetpcap.jar" PacketCapture
```

## Sample I/O
### Telnet Communication
#### Server Output:
```
Telnet Server started on port 8080...
Client connected: 127.0.0.1
Received: Hello
Received: exit
```
#### Client Output:
```
Connected to Telnet Server
Welcome to Telnet Server! Type 'exit' to quit.
> Hello
Server: Echo: Hello
> exit
```

### SSH Communication
```
Connecting to SSH Server...
Enter commands: ls, pwd, etc.
```

### Packet Capturing
```
Packet captured from: 192.168.1.10
Packet captured from: 192.168.1.11
```

## Observations
1. **Telnet** transmits data in plaintext, making it vulnerable to sniffing.
2. **SSH** encrypts communication, preventing unauthorized access.
3. **Packet Capture** allows us to analyze network traffic.

## Future Enhancements
- Implement a secure **Diffie-Hellman Key Exchange**.
- Use **AES Encryption** for better security.

## Contributors
- **Your Name** (replace with your actual name)

## License
This project is open-source and available under the MIT License.

