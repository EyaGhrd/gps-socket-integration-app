package eniso.gte3;

import eniso.gte3.packet.Packet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class PacketGenerator {
    private Random random = new Random();

    public Packet generatePacket() {
        Packet packet = new Packet();
        // Generate Random Data
        packet.setTemprature(random.nextInt(100));
        packet.setLongitude(random.nextInt(180) - 90);
        packet.setLatitude(random.nextInt(360) - 180);
        packet.setIdentNumber(random.nextLong());
        packet.setTimeFrame(System.currentTimeMillis());
        packet.setChecksum(calculateChecksum(packet));

        return packet;
    }

    private byte calculateChecksum(Packet packet) {
        int sum = packet.getTemprature() + packet.getLongitude() + packet.getLatitude();
        sum += (int) (packet.getIdentNumber() + packet.getTimeFrame());
        return (byte) (sum % 256);
    }

    public void sendPacket(DataOutputStream outputStream) throws IOException {
        Packet packet = generatePacket();

        byte[] packetBytes = convertPacketToBytes(packet);
        System.out.println("Données binaires envoyées : " + bytesToHex(packetBytes));
        sendPacketToServer(packet, outputStream);

        System.out.println("Paquet envoyé : " + packet);
    }

    private void sendPacketToServer(Packet packet, DataOutputStream outputStream) throws IOException {
        outputStream.writeInt(packet.getTemprature());
        outputStream.writeInt(packet.getLongitude());
        outputStream.writeInt(packet.getLatitude());
        outputStream.writeLong(packet.getIdentNumber());
        outputStream.writeLong(packet.getTimeFrame());
        outputStream.writeByte(packet.getChecksum());

        outputStream.flush();
    }

    private byte[] convertPacketToBytes(Packet packet) throws IOException {
        java.io.ByteArrayOutputStream byteStream = new java.io.ByteArrayOutputStream();
        java.io.DataOutputStream dataStream = new java.io.DataOutputStream(byteStream);

        dataStream.writeInt(packet.getTemprature());
        dataStream.writeInt(packet.getLongitude());
        dataStream.writeInt(packet.getLatitude());
        dataStream.writeLong(packet.getIdentNumber());
        dataStream.writeLong(packet.getTimeFrame());
        dataStream.writeByte(packet.getChecksum());

        return byteStream.toByteArray();
    }

    public String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X ", b));
        }
        return hexString.toString();
    }
}