
import java.util.Scanner;

public class SimpleApplication{
    private SimpleMutableList<Contact> list;
    private Menu menu = new Menu("Address book");

    public SimpleApplication(){
        list = new SimpleAdressBook();
        list.load();
        System.out.println(list.numberOfEntries() +
                " items loaded from file.");
    }

    private void createMenu() {

        menu.addMenuItem("List", new MenuAction() {
            public void onItemSelected() {
                list.listEntries();
            }
        });

        menu.addMenuItem("Add", new MenuAction() {
            public void onItemSelected() {
                //Contact contact;
                Scanner sc = new Scanner(System.in);
                System.out.print("Name:");
                String name = sc.nextLine();
                System.out.print("Email:");
                String email = sc.nextLine();
                System.out.print("Phone:");
                String phone = sc.nextLine();
                list.addEntry(new Contact(name, email, phone));
                list.save();
            }
        });
    }

    public void start(){
        createMenu();
        menu.start();
    }
}

