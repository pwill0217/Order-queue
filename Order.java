import java.util.Date;
import java.util.*;

public class Order {
	private String item;
	private double price;
	private Date orderTime;

	public Order(String item, double price) {
		orderTime = new Date();
		this.item = item;
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public String toString() {
		return String.format("%s %.2f %s", item, price, orderTime);
	}

	public static void main(String[] args) {
		Queue<Order> item = new LinkedList<>();
		try (Scanner ordersc = new Scanner(System.in)) {
			while (true) {

				System.out.println("=====================================");
				System.out.println("1 = Enqueue an order for a taco");
				System.out.println("2 = Enqueue an order for a burrito");
				System.out.println("3 = Enqueue an order for a quesadilla");
				System.out.println("4 = List all items in queue");
				System.out.println("5 = Dequeue an order");
				System.out.println("6 = Exit");
				System.out.println("=====================================");
				System.out.print("Your Choice: ");
				int choice = ordersc.nextInt();

				if (choice == 1) {
					System.out.print("Enter taco price: ");
					double price = ordersc.nextDouble();
					ordersc.nextLine();
					item.offer(new Order("taco", price));
					System.out.println("taco ordered succesfully!");
				} else if (choice == 2) {
					System.out.print("Enter burrito price: ");
					double price = ordersc.nextDouble();
					item.offer(new Order("burrito", price));
					System.out.println("burrito ordered succesfully!");
				} else if (choice == 3) {
					System.out.print("Enter quesadilla price: ");
					double price = ordersc.nextDouble();
					item.offer(new Order("quesadilla", price));
					System.out.println("quesadilla ordered succesfully!");
				} else if (choice == 4) {
					System.out.println("List of orders: ");
					for (Order o : item)
						System.out.println(o);
				} else if (choice == 5) {
					System.out.println(item.poll().getItem() + " has been served succesfully!");
				} else if (choice == 6) {
					System.out.println("Thank you!");
					break;
				} else {
					System.out.println("Choice invalid. Please Try again");
				}

			}
		}

	}
}
