package top.clearlight.wechat.map2;

public class ProductItem {
    private Product product;
    private int count;

    @Override
    public String toString() {
        return "ProductItem{" +
                "product=" + product +
                ", count=" + count +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public float getTotalPrice() {
        return this.product.getPrice() * count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public ProductItem() {
    }
}
