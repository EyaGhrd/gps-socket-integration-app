package eniso.gte3;

import eniso.gte3.packet.Packet;

import java.io.DataInputStream;
import java.io.IOException;

public class CardReader {

    public Packet readPacket(DataInputStream inputStream) throws IOException {
        StringBuilder hexString = new StringBuilder();


        Packet packet = new Packet();

        int temperature = inputStream.readInt();
        packet.setTemprature(temperature);
        appendBytesToHexString(hexString, temperature, 4);

        int longitude = inputStream.readInt();
        packet.setLongitude(longitude);
        appendBytesToHexString(hexString, longitude, 4);

        int latitude = inputStream.readInt();
        packet.setLatitude(latitude);
        appendBytesToHexString(hexString, latitude, 4);

        long identNumber = inputStream.readLong();
        packet.setIdentNumber(identNumber);
        appendBytesToHexString(hexString, identNumber, 8);

        long timeFrame = inputStream.readLong();
        packet.setTimeFrame(timeFrame);
        appendBytesToHexString(hexString, timeFrame, 8);

        byte checksum = inputStream.readByte();
        packet.setChecksum(checksum);
        appendBytesToHexString(hexString, checksum, 1);

        System.out.println("Paquet reçu en hexadécimal : " + hexString.toString());

        return packet;
    }

    private void appendBytesToHexString(StringBuilder hexString, long value, int byteCount) {
        for (int i = byteCount - 1; i >= 0; i--) {
            hexString.append(String.format("%02X ", (value >> (i * 8)) & 0xFF));
        }
    }

    private void appendBytesToHexString(StringBuilder hexString, int value, int byteCount) {
        for (int i = byteCount - 1; i >= 0; i--) {
            hexString.append(String.format("%02X ", (value >> (i * 8)) & 0xFF));
        }
    }

    private void appendBytesToHexString(StringBuilder hexString, byte value, int byteCount) {
        hexString.append(String.format("%02X ", value & 0xFF));
    }
}
