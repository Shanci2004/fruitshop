package model;

public class Address {
    private int addressId;
    private String name;
    private String phone;
    private String region;
    private String area;
    private String label;

    private int userId;

    public Address() {

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Address(int addressId, String name, String phone, String region, String area, String label, int userId) {
        this.addressId = addressId;
        this.name = name;
        this.phone = phone;
        this.region = region;
        this.area = area;
        this.label = label;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", region='" + region + '\'' +
                ", area='" + area + '\'' +
                ", label='" + label + '\'' +
                ", userId=" + userId +
                '}';
    }
}
