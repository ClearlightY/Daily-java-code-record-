package top.clearlight.wechat.map2;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private float price;
    private String picture;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Product(int productId, String productName, String category, float price, String picture) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.picture = picture;
    }

    public Product() {
    }
}
