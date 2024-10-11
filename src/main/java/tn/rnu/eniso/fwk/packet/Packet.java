package tn.rnu.eniso.fwk.packet;

public class Packet {
    private int temprature ;
    private int longitude ;
    private int latitude;
    private long identNumber;
    private long timeFrame;
    private byte checksum;

    public int getTemprature() {
        return temprature;
    }

    public void setTemprature(int temprature) {
        this.temprature = temprature;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public long getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(long identNumber) {
        this.identNumber = identNumber;
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
    }

    public byte getChecksum() {
        return checksum;
    }

    public void setChecksum(byte checksum) {
        this.checksum = checksum;
    }
    @Override
    public String toString() {
        return "Packet{" +
                "temprature=" + temprature +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", identNumber=" + identNumber +
                ", timeFrame=" + timeFrame +
                ", checksum=" + checksum +
                '}';
    }
}
