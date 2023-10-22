import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// 메뉴 클래스
class Menu {
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

// 상품 클래스 (메뉴 클래스를 상속)
class Product extends Menu {
    private double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// 주문 클래스
class Order {
    public List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    // 상품을 주문에 추가
    public void addProduct(Product product) {
        products.add(product);
    }

    // 주문 취소
    public void cancelOrder() {
        products.clear();
    }

    // 주문 내역을 반환하는 메소드
    public List<Product> getProducts() {
        return products;
    }
}


public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("SHAKESHACK BURGER 에 오신걸 환영합니다.", "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        Product burger1 = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9);
        Product burger2 = new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9);
        Product burger3 = new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4);
        Product burger4 = new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9);
        Product burger5 = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4);

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        int choice;
        int orderNumber = 0;

        do {
            System.out.println(mainMenu.getName());
            System.out.println(mainMenu.getDescription());

            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
            System.out.println("2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림");
            System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
            System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");

            System.out.println("[ ORDER MENU ]");
            System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBurgersMenu(burger1, burger2, burger3, burger4, burger5, order);
                    break;
                case 2:
                    // Frozen Custard 메뉴 출력
                    // Frozen Custard 메뉴 추가
                    break;
                case 3:
                    // Drinks 메뉴 출력
                    // Drinks 메뉴 추가
                    break;
                case 4:
                    // Beer 메뉴 출력
                    // Beer 메뉴 추가
                    break;
                case 5:
                    if (order.products.isEmpty()) {
                        System.out.println("장바구니가 비어 있습니다. 주문할 상품을 추가해주세요.");
                    } else {
                        orderNumber++;
                        completeOrder(order, orderNumber);
                        order = new Order();
                    }
                    break;
                case 6:
                    if (!order.products.isEmpty()) {
                        System.out.println("주문을 취소하시겠습니까? (1. 확인, 2. 취소)");
                        int cancelChoice = scanner.nextInt();
                        if (cancelChoice == 1) {
                            order.cancelOrder();
                            System.out.println("주문이 취소되었습니다.");
                        }
                    } else {
                        System.out.println("진행 중인 주문이 없습니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        } while (choice != 6);
    }

    // 상품 메뉴 출력
    private static void showBurgersMenu(Product burger1, Product burger2, Product burger3, Product burger4, Product burger5, Order order) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            System.out.println("[ Burgers MENU ]");
            System.out.println("1. " + burger1.getName() + " | W " + burger1.getPrice() + " | " + burger1.getDescription());
            System.out.println("2. " + burger2.getName() + " | W " + burger2.getPrice() + " | " + burger2.getDescription());
            System.out.println("3. " + burger3.getName() + " | W " + burger3.getPrice() + " | " + burger3.getDescription());
            System.out.println("4. " + burger4.getName() + " | W " + burger4.getPrice() + " | " + burger4.getDescription());
            System.out.println("5. " + burger5.getName() + " | W " + burger5.getPrice() + " | " + burger5.getDescription());
            System.out.println("6. 메인 메뉴로 돌아가기");

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToCart(burger1, order);
                    break;
                case 2:
                    addToCart(burger2, order);
                    break;
                case 3:
                    addToCart(burger3, order);
                    break;
                case 4:
                    addToCart(burger4, order);
                    break;
                case 5:
                    addToCart(burger5, order);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        } while (choice != 6);
    }

    // 상품을 장바구니에 추가
    private static void addToCart(Product product, Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(product.getName() + " | W " + product.getPrice() + " | " + product.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int choice = scanner.nextInt();
        if (choice == 1) {
            order.addProduct(product);
            System.out.println(product.getName() + " 가 장바구니에 추가되었습니다.");
        }
    }

    // 주문을 완료하고 대기번호 발급
    private static void completeOrder(Order order, int orderNumber) {
        System.out.println("주문이 완료되었습니다!");
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
