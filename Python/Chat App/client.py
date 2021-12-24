import socket

port=3000

soc=socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Instead of explicitly binding this object, let the OS do it.
# OS will bind this itself.

hostname="127.0.0.1"

chunk_size=65535

while True:
	soc.connect((hostname, port))
	message = input("Type message: ")
	data = message.encode("ascii")
	soc.send(data)
	
	# Data received
	data = soc.recv(chunk_size)
	text=data.decode("ascii")
	print(f"Jamura says, {text}")

