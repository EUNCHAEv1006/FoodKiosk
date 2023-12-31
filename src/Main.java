import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu("\"SHAKESHACK BURGER에 오신걸 환영합니다.\"", "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        Product burger1 = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9);
        Product burger2 = new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9);
        Product burger3 = new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4);
        Product burger4 = new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9);
        Product burger5 = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4);

        Product drink1 = new Product("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3.9);
        Product drink2 = new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4);
        Product drink3 = new Product("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5);
        Product drink4 = new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7);
        Product drink5 = new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4);
        Product drink6 = new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0);

        Product beer1 = new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8);
        Product beer2 = new Product("Magpie Brewing Co.", "한국 수제맥주 붐의 시작", 6.8);

        Product shake1 = new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피", 5.9);
        Product shake2 = new Product("Shake of the Week", "특별한 커스터드 플레이버", 6.5);
        Product shake3 = new Product("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5);
        Product shake4 = new Product("Floats", "루트 비어, 퍼플 카우, 크림시클", 5.9);
        Product cupAndCones = new Product("Cup & Cones", "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림", 5.4);
        Product concretes = new Product("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스=인의 조합", 5.9);

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        int choice;
        int orderNumber = 0;

        do {
            System.out.println(mainMenu.getName());
            System.out.println(mainMenu.getDescription());
            System.out.println();

            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
            System.out.println("2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림");
            System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
            System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
            System.out.println();

            System.out.println("[ ORDER MENU ]");
            System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");
            System.out.println();

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBurgersMenu(burger1, burger2, burger3, burger4, burger5, order); // Burgers 메뉴 출력
                    break; // Burgers 메뉴 추가
                case 2:
                    showFrozenCustardMenu(shake1, shake2, shake3, shake4, cupAndCones, concretes, order); // Frozen Custard 메뉴 출력
                    break; // Frozen Custard 메뉴 추가
                case 3:
                    showDrinksMenu(drink1, drink2, drink3, drink3, drink4, drink5, drink6, order); // Drinks 메뉴 출력
                    break; // Drinks 메뉴 추가

                case 4:
                    showBeerMenu(beer1, beer2, order); // Beer 메뉴 출력
                    break; // Beer 메뉴 추가
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

    private static void showBurgersMenu(Product burger1, Product burger2, Product burger3, Product burger4, Product burger5, Order order) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            System.out.println();

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
    private static void showFrozenCustardMenu(Product shake1, Product shake2, Product shake3, Product shake4,
                                              Product cupAndCones,
                                              Product concretes,
                                              Order order) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            System.out.println();

            System.out.println("[ FrozenCustard MENU ]");
            System.out.println("1. " + shake1.getName() + " | W " + shake1.getPrice() + " | " + shake1.getDescription());
            System.out.println("2. " + shake2.getName() + " | W " + shake2.getPrice() + " | " + shake2.getDescription());
            System.out.println("3. " + shake3.getName() + " | W " + shake3.getPrice() + " | " + shake3.getDescription());
            System.out.println("4. " + shake4.getName() + " | W " + shake4.getPrice() + " | " + shake4.getDescription());
            System.out.println("5. " + cupAndCones.getName() + " | W " + cupAndCones.getPrice() + " | " + cupAndCones.getDescription());
            System.out.println("6. " + concretes.getName() + " | W " + concretes.getPrice() + " | " + concretes.getDescription());
            System.out.println("7. 메인 메뉴로 돌아가기");
            System.out.println();

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToCart(shake1, order);
                    break;
                case 2:
                    addToCart(shake2, order);
                    break;
                case 3:
                    addToCart(shake3, order);
                    break;
                case 4:
                    addToCart(shake4, order);
                    break;
                case 5:
                    addToCart(cupAndCones, order);
                    break;
                case 6:
                    addToCart(concretes, order);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        } while (choice != 7);
    }

    private static void showDrinksMenu(Product drink1, Product drink2, Product drink3, Product drink31, Product drink4, Product drink5, Product drink6, Order order) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            System.out.println();

            System.out.println("[ Drinks MENU ]");
            System.out.println("1. " + drink1.getName() + " | W " + drink1.getPrice() + " | " + drink1.getDescription());
            System.out.println("2. " + drink2.getName() + " | W " + drink2.getPrice() + " | " + drink2.getDescription());
            System.out.println("3. " + drink3.getName() + " | W " + drink3.getPrice() + " | " + drink3.getDescription());
            System.out.println("4. " + drink4.getName() + " | W " + drink4.getPrice() + " | " + drink4.getDescription());
            System.out.println("5. " + drink5.getName() + " | W " + drink5.getPrice() + " | " + drink5.getDescription());
            System.out.println("6. " + drink6.getName() + " | W " + drink6.getPrice() + " | " + drink6.getDescription());
            System.out.println("7. 메인 메뉴로 돌아가기");
            System.out.println();

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToCart(drink1, order);
                    break;
                case 2:
                    addToCart(drink2, order);
                    break;
                case 3:
                    addToCart(drink3, order);
                    break;
                case 4:
                    addToCart(drink4, order);
                    break;
                case 5:
                    addToCart(drink5, order);
                    break;
                case 6:
                    addToCart(drink6, order);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        } while (choice != 7);
    }

    private static void showBeerMenu(Product beer1, Product beer2, Order order) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
            System.out.println();

            System.out.println("[ Beer MENU ]");
            System.out.println("1. " + beer1.getName() + " | W " + beer1.getPrice() + " | " + beer1.getDescription());
            System.out.println("2. " + beer2.getName() + " | W " + beer2.getPrice() + " | " + beer2.getDescription());
            System.out.println("3. 메인 메뉴로 돌아가기");
            System.out.println();

            System.out.print("선택: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addToCart(beer1, order);
                    break;
                case 2:
                    addToCart(beer2, order);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }
        } while (choice != 3);
    }


    // 장바구니에 상품 추가
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
        for (int i = 3; i<=1; i--){
            System.out.println(i + "(초 후 메뉴판으로 돌아갑니다.)");
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
