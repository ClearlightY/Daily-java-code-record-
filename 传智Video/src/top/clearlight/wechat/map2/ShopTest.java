package top.clearlight.wechat.map2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ShopTest {
    private LinkedHashMap<Integer, ProductItem> lmp = new LinkedHashMap<>();

    public static void main(String[] args) {
        Product p1 = new Product(1, "ThinkPad", "笔记本电脑", 7000, "c://img1");
        Product p2 = new Product(2, "MacPro", "笔记本电脑", 10000, "c://img2");
        Product p3 = new Product(3, "Hp", "笔记本电脑", 5000, "c://img3");

        ShopTest st = new ShopTest();

        st.addProduct(p2, 2);
        st.addProduct(p1, 30);
        st.addProduct(p3, 10);
        st.showAll();

        st.modifyProduct(p1, 31);
        st.showAll();

        st.delProduct(p1);
        st.showAll();

        st.clearProduct();
        st.showAll();
    }

    public void addProduct(Product product, int num) {
        ProductItem proItem = new ProductItem(product, num);
        lmp.put(product.getProductId(), proItem);
    }

    public void showAll() {
        Iterator<Integer> it = lmp.keySet().iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            ProductItem item = lmp.get(next);
            Product pro = item.getProduct();
            System.out.println("名称:" + pro.getProductName() + " 单价:"
                    + pro.getPrice() + " 数量:" + item.getCount() + " 小计:"
                    + item.getTotalPrice());
        }
        System.out.println("总计:" + getTotalPrice());
    }

    public float getTotalPrice() {
        Set<Integer> id = lmp.keySet();
        float sum = 0;
        for (Integer i :
                id) {
            sum += lmp.get(i).getTotalPrice();
        }
        return sum;
    }

    public void modifyProduct(Product product, int count) {
        if (lmp.containsKey(product.getProductId())) {
            ProductItem item = lmp.get(product.getProductId());
            item.setCount(count);
            System.out.println("修改成功!");
        } else {
            System.out.println("不存在该商品!!");
        }
    }

    public void delProduct(Product product) {
        if (lmp.containsKey(product.getProductId())) {
            lmp.remove(product.getProductId());
            System.out.println("成功移除" + product.getProductName() + "商品");
        } else {
            System.out.println("抱歉, 无该商品, 删除失败");
        }
    }

    public void clearProduct() {
        lmp.clear();
        System.out.println("购物车已经清空!");
    }
}
