import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CircularLinkedLists linkedList = new CircularLinkedLists();
        Scanner scanner = new Scanner(System.in);

        // Perform operations on the linked list
        int choice;
        System.out.println("Select an operation:");
        System.out.println("1. Display Menu.");
        System.out.println("2. Insert at the beginning");
        System.out.println("3. Insert at the end");
        System.out.println("4. Insert at a position");
        System.out.println("5. Traverse the linked list");
        System.out.println("6. Search for a value");
        System.out.println("7. Delete a node");
        System.out.println("8. Delete whole linked list");
        System.out.println("9. Exit");
    
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select an operation:");
                    System.out.println("1. Display Menu.");
                    System.out.println("2. Insert at the beginning");
                    System.out.println("3. Insert at the end");
                    System.out.println("4. Insert at a position");
                    System.out.println("5. Traverse the linked list");
                    System.out.println("6. Search for a value");
                    System.out.println("7. Delete a node");
                    System.out.println("8. Delete whole linked list");
                    System.out.println("9. Exit");
                    break;
                case 2:
                    linkedList.new InsertioninCll().atBeginning();
                    break;
                case 3:
                    linkedList.new InsertioninCll().atEnd();
                    break;
                case 4:
                    linkedList.new InsertioninCll().atPosition();
                    break;
                case 5:
                    linkedList.traversal();
                    break;
                case 6:
                    linkedList.toSearch();
                    break;
                case 7:
                    linkedList.deleteNode();
                    break;
                case 8:
                    linkedList.deleteWholell();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
