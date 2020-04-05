import socket #importa modulo socket
 
TCP_IP = '192.168.15.13' # endereço IP do servidor 
TCP_PORTA = 31824        # porta disponibilizada pelo servidor
TAMANHO_BUFFER = 1024    # definição do tamanho do buffer
 
# Criação de socket TCP
# SOCK_STREAM, indica que será TCP.
servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# IP e porta que o servidor deve aguardar a conexão
servidor.bind((TCP_IP, TCP_PORTA))

#Define o limite de conexões. 
servidor.listen(1)
print("Servidor dispoivel na porta %d e escutando..." %TCP_PORTA) 

data = None
while 1:
    # Aceita conexão caso o servidor nunca foi acessado ou um cliente se desconectou
    if data == None or data.decode('UTF-8') == "QUIT":
        conn, addr = servidor.accept()
        print ('Endereço conectado:', addr)

    #dados retirados da mensagem recebida
    data = conn.recv(TAMANHO_BUFFER)
    if data.decode('UTF-8') == "QUIT":
        print ('O cliente foi desconectado, liberando o socket...')
        continue
    
    print("\nMensagem do Cliente: ", data.decode('UTF-8'))

    if data: 
        MENSAGEM  = input("\nDigite sua mensagem para o cliente: ")
        conn.send(MENSAGEM.encode('UTF-8'))
        if MENSAGEM == "QUIT":
            print ('Encerrando a comunicação com o cliente, liberando o socket...')
            data = "QUIT".encode('UTF-8')
        continue

