package model;
import java.util.*;

public class Order {
    private String orderId;
    private int userId;
    private int addressId;
    private String orderDate;
    private int status;//1未付款/2已付款/3已发货/4已完成
    private int paytype;//1在线/2微信/3支付宝/4货到支付
    private double total;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Order(String orderId, int userId, int addressId, String orderDate, int status, int paytype, double total) {
        this.orderId = orderId;
        this.userId = userId;
        this.addressId = addressId;
        this.orderDate = orderDate;
        this.status = status;
        this.paytype = paytype;
        this.total = total;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", orderDate='" + orderDate + '\'' +
                ", status=" + status +
                ", paytype=" + paytype +
                ", total=" + total +
                '}';
    }
}
