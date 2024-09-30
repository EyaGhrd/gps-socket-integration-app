package eniso.gte3;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    private Socket socket;
    private DataOutputStream outputStream;
    private PacketGenerator packetGenerator = new PacketGenerator();

    public void init(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        outputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Connecté au serveur " + serverAddress + " sur le port " + port);
    }
    public void listen() {
        try {
            while (!socket.isClosed()) {
                try {
                    packetGenerator.sendPacket(outputStream);
                    Thread.sleep(1000);
                } catch (SocketException e) {
                    System.err.println("Erreur de connexion : " + e.getMessage());
                    break;
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connexion fermée proprement.");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.init("localhost", 12345);
            client.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
