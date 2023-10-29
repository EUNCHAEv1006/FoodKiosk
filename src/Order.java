import java.util.ArrayList;
import java.util.List;

// 주문 클래스
class Order {
    public List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    // 주문에 상품 추가
    public void addProduct(Product product) {
        products.add(product);
    }

    // 주문 취소
    public void cancelOrder() {
        products.clear();
    }
}
