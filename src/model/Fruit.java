package model;

import dao.ClassifyDao;

import java.sql.SQLException;
import java.util.Arrays;

public class Fruit {
    private int fruitId;
    private String fruitName;
    private double price;   //价格
    private int stock;  //库存
    private int sales;  //销量
    //图片组
    private String cover;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String[] images;
    private String intro;   //介绍
    private int classifyId;
    private Classify classify;

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages() {
        this.images = new String[]{image1, image2, image3, image4};
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify() {
        try {
            this.classify = ClassifyDao.getClassify(classifyId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fruit(int fruitId, String fruitName, double price, int stock, int sales, String cover, String image1, String image2, String image3, String image4, String[] images, String intro, int classifyId, Classify classify) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.images = images;
        this.intro = intro;
        this.classifyId = classifyId;
        this.classify = classify;
    }

    public Fruit() {
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitId=" + fruitId +
                ", fruitName='" + fruitName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", cover='" + cover + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", images=" + Arrays.toString(images) +
                ", intro='" + intro + '\'' +
                ", classifyId=" + classifyId +
                ", classify=" + classify +
                '}';
    }
}
