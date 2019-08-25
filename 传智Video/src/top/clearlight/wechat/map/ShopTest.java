package top.clearlight.wechat.map;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ShopTest {
    private LinkedHashMap<Integer, ProductItem> aa = new LinkedHashMap<Integer, ProductItem>();

    public static void main(String[] args) {
        Product p1 = new Product(101, "绿源电动车", "电动自行车", 1500, "img\\t1.jpg");
        Product p2 = new Product(102, "飞马电动车", "电动自行车", 2000, "img\\t2.jpg");
        Product p3 = new Product(103, "联想笔记本", "电脑", 3000, "img\\t3.jpg");

        ShopTest st = new ShopTest();

        st.addProduct(p1, 1);
        st.addProduct(p2, 1);
        st.addProduct(p3, 2);
        st.showAll();

        st.getTotalPrice();
        st.modifyProduct(p3, 4);

        st.delProduct(p3);
        st.showAll();

        st.clearProduct();
        st.showAll();
    }

    public void addProduct(Product product, int num) { // 添加商品
        ProductItem proItem = new ProductItem(product, num);
        aa.put(product.getProductId(), proItem);
    }

    @Test
    public void showAll() { // 显示所有商品
        Set<Integer> keySet = aa.keySet();
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            ProductItem productItem = aa.get(next);
            Product product = productItem.getProduct();
            System.out.println(product.getProductName() + "\t" + productItem.getCount()
                    + " 件, 单价: " + product.getPrice() + "\t 小计: " + productItem.getTotalPrice());
        }
    }

    @Test
    public void getTotalPrice() { // 显示商品数量,商品总价
        Set<Integer> keySet = aa.keySet();
        // 总价;
        float total = 0;
        // 总数量
        int totalNum = 0;
        for (Integer key :
                keySet) {
            // 商品小计相加
            total += aa.get(key).getTotalPrice();
            // 商品数量相加
            totalNum += aa.get(key).getCount();
        }
        System.out.println("\t已选择 " + totalNum + " 件商品" + "\t\t商品总价:" + total);
    }


    public void modifyProduct(Product product, int num) { // 修改购物车
        // 键里面含有商品的id
        if (aa.containsKey(product.getProductId())) {
            // 修改对应商品的数量
            aa.get(product.getProductId()).setCount(num);
            System.out.println("修改成功!!");
            showAll();
            getTotalPrice();
        } else {
            System.out.println("查询无此商品!!");
        }
    }

    @Test
    public void delProduct(Product product) {
        aa.remove(product.getProductId());
    }

    @Test
    public void clearProduct() {
        aa.clear();
        System.out.println("购物车已经清空!!");
    }
}
