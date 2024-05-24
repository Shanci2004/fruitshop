package model;

public class User {
    private int id;
    private String name;
    private String userName;
    private String account;
    private String password;
    private String avatar;
    private String phone;
    private String address;
    private boolean isadmin = false;

    public User() {
        avatar = "D:\\idea-java\\FruitShop\\web\\avatar\\avatar1.jpeg";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public User(int id, String name, String userName, String account, String password, String avatar, String phone, String address, boolean isadmin) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.account = account;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", isadmin=" + isadmin +
                '}';
    }
}
