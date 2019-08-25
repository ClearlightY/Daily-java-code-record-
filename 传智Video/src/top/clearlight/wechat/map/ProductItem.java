package top.clearlight.wechat.map;

public class ProductItem {
    private Product product;
    // 商品数量
    private int count;

    public float getTotalPrice() {
        return count * product.getPrice();
    }

    public ProductItem() {
    }

    public ProductItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

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

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
