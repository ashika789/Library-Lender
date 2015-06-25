import java.util.Scanner;

public class Library {

	private static MediaItem[] items;
	public static int numberOfItems;

	public Library() {

		numberOfItems = 0;
		items = new MediaItem[10];

	}

	public static int displayMenu() {
		System.out.println("\n");
		System.out.println("Menu");
		System.out.println("1. Add new item");
		System.out.println("2. Mark an item as on loan");
		System.out.println("3. List all items");
		System.out.println("4. Mark an item as returned");
		System.out.println("5. Quit");
		return 0;
	}

	public static void addNewItem() {
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		System.out.println("Please enter the Title of the Item");
		String name = in.next();

		System.out.println("Please enter the format of the Item");
		String type = in.next();

		MediaItem myItem = new MediaItem(name, type);
		items[numberOfItems] = myItem;
		numberOfItems++;

	}

	public static void markItemOnLoan() {
		System.out.println("Which item (enter the title)? ");
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		String name = in.next();
		if (!contains(name)) {
			System.out.println("I'm sorry, I couldn't find " + name
					+ " in the library.");

		} else {
			System.out.println("Who are you loaning it to? ");
			String toWhom = in.next();
			System.out.println("When did you loan it to them? ");
			String dateLoan = in.next();

			int spot = findPosition(name);
			items[spot].markOnLoan(toWhom, dateLoan);
		}

	}

	public static boolean contains(String x) {
		for (MediaItem find : items) {
			if (find != null) {
				if (x.equals(find.getTitle())) {
					return true;
				}
			}
		}
		return false;
	}

	public static int findPosition(String x) {
		for (int i = 0; i < numberOfItems; i++) {
			if (x.equals(items[i].getTitle())) {
				return i;
			}
		}
		return -1;
	}

	public static void listAllItems() {
		System.out.println("Here is your current list of items: ");
		for (int x = 0; x < numberOfItems; x++) {
			System.out.println(items[x]);
		}

	}

	public static void listAllItems1() {

		System.out.println(items[0].toString());

	}

	public static void markItemReturned(String title) {
		if (!contains(title)) {

			System.out.println("I'm sorry, I couldn't find " + title
					+ " in the library.");

		} else {
			int spot = findPosition(title);
			items[spot].markReturned();

		}

	}
public static String returnItem() {
	
	Scanner in = new Scanner(System.in).useDelimiter("\\n");
	System.out.println("Which item (enter the title)? ");
	String r = in.next();
	return r;
}
	public static void main(String[] args) {
		Library one = new Library();

		Scanner in = new Scanner(System.in);
		String choice;

		boolean right = false;

		while (!right) {

			displayMenu();
			choice = in.next();

			if (choice.equals("1")) {

				one.addNewItem();
			}

			else if (choice.equals("2")) {
				markItemOnLoan();
			}

			else if (choice.equals("3")) {
				listAllItems();
			}

			else if (choice.equals("4")) {
				String r = returnItem();
				markItemReturned(r);

			}

			else if (choice.equals("5")) {
				right = true;
				System.out.println("Goodbye");
			}

			else {
				System.out.println("Invalid operation; please try again.");
			}

		}
	}

}
