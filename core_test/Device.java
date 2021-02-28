package core_test;

public class Device {
    private long serialNumber;
    private String brand;
    private String info;
    private int price;

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Device(long serialNumber, String brand, String info, int price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.info = info;
        this.price = price;
    }
}
