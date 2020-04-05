import socket #importa modulo socket

TCP_IP = '192.168.15.13' # endereço IP do servidor 
TCP_PORTA = 31824        # porta disponibilizada pelo servidor
TAMANHO_BUFFER = 1024

# Criação de socket TCP do cliente
cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Conecta ao servidor em IP e porta especifica 
cliente.connect((TCP_IP, TCP_PORTA))

data = 'null'
# Encerra o chat caso o servidor envie o comando QUIT
while data != 'QUIT': 
    MENSAGEM  = input("\nDigite sua mensagem para o servidor: ")

    # envia mensagem para servidor 
    cliente.send(MENSAGEM.encode('UTF-8'))

    # Encerra o chat caso o cliente digite o comando QUIT
    if MENSAGEM == 'QUIT':
        break

    # recebe dados do servidor 
    data, addr = cliente.recvfrom(1024)
    data = data.decode('UTF-8')
    # Encerra o chat caso o cliente digite o comando QUIT
    if data == 'QUIT':
        print("O servidor encerrou a conexão")
        break

    print ("\nMensagem do servidor: ", data)

# fecha conexão com servidor
cliente.close()
input('Pressione ENTER para encerrar...')



