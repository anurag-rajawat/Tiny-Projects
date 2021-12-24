#!/bin/python3

import socket

port=3000

#Creating a socket object
soc=socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# some ip address that the server will listen to when message comes

hostname = "127.0.0.1"

# Binding the socket with the host machine on port 3000
soc.bind((hostname,port))

print(f"Server is live on {soc.getsockname()}")

# Run the server infinitely

#Receive at most these bytes of data at once
chunk_size=65535

while True:
	data,clientAdd= soc.recvfrom(chunk_size)
	message=data.decode("ascii")
	print(f"Your friend says, {message}")
	messge_send=input("Reply: ")
	data=messge_send.encode("ascii")
	soc.sendto(data,clientAdd)

