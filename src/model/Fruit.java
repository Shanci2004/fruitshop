package model;

public class Fruit {
    private int fruitId;
    private String fruitName;
    private double price;   //价格
    private int stock;  //库存
    //图片组
    private String cover;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String intro;   //介绍
    private Classify classify;

    private boolean isHot;
    private boolean isNew;

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

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Fruit(int fruitId, String fruitName, double price, int stock, String cover, String image1, String image2, String image3, String image4, String intro, Classify classify, boolean isHot, boolean isNew) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.stock = stock;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.intro = intro;
        this.classify = classify;
        this.isHot = isHot;
        this.isNew = isNew;
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
                ", cover='" + cover + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", intro='" + intro + '\'' +
                ", classify=" + classify +
                ", isHot=" + isHot +
                ", isNew=" + isNew +
                '}';
    }
}