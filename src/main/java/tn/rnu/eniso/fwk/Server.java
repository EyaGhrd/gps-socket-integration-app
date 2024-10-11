package tn.rnu.eniso.fwk;

import tn.rnu.eniso.fwk.packet.Packet;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private CardReader cardReader = new CardReader();

    public void init(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serveur en écoute sur le port " + port);
    }

    public void listen() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté.");
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());

            try {
                while (!clientSocket.isClosed()) {
                    Packet packet = cardReader.readPacket(inputStream);
                    System.out.println("Paquet lu : " + packet);
                }
            } catch (EOFException e) {
                System.out.println("Fin de connexion du client ou paquet incomplet.");
            } finally {
                clientSocket.close();
                System.out.println("Connexion avec le client fermée.");
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.init(12345);
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}