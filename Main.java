import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderHash orderHash = new OrderHash();

        Order order1 = new Order("1", Arrays.asList("Клавиатура", "Мышь"), "Ленина 274, к-3", 21.300);
        Order order2 = new Order("2", Arrays.asList("Монитор", "Видеокарта", "Процессор"), "Новыхино 121, к-6", 121.640);
    
        orderHash.addOrder(order1);
        orderHash.addOrder(order2);

        System.out.println("Кол-во заказов: " + orderHash.size());
        System.out.println("Первый заказ: " + orderHash.getOrder("1"));

        orderHash.removeOrder("1");
        System.out.println("Первый заказ: " + orderHash.getOrder("1"));
        System.out.println("Кол-во заказов: " + orderHash.size());
        System.out.println("Второй заказ: " + orderHash.getOrder("2"));

    }
}

class Order{
    private String orderNumber;
    private List<String> products;
    private String address;
    private double amount;

    public Order(String orderNumber, List<String> products, String address, double amount){
        this.orderNumber = orderNumber;
        this.products = products;
        this.address = address;
        this.amount = amount;
    }

    public String getNumber(){
        return orderNumber;
    }

    public List<String> getProducts(){
        return products;
    }
    
    public String getAddress(){
        return address;
    }
    public double getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Номер заказа='" + orderNumber + '\'' +
                ", Товары=" + products +
                ", Адрес='" + address + '\'' +
                ", Стоимость=" + amount +
                '}';
    }
}

class OrderHash{
    private HashMap<String, Order> orders;
    
    public OrderHash(){
        orders = new HashMap<>();
    }
    public void addOrder(Order order){
        orders.put(order.getNumber(), order);
    }
    public Order getOrder(String orderNumber){
        return orders.get(orderNumber);
    }
    public void removeOrder(String orderNumber){
        orders.remove(orderNumber);
    }
    public int size(){
        return orders.size();
    }
    public boolean isEmpty(){
        return orders.isEmpty();
    }
}