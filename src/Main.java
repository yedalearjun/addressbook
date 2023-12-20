import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "Press \n1:Adding A contact\n2: Displaying All Contact\n3: Search by first name\n4: Search by Phone number\n5: Delete by USer First name\n6: Update phone Number";
        Scanner sc = new Scanner(System.in);
        ArrayList aList = new ArrayList<>();

        //creating an instance of AddressBook
        //creating multiple instance of AddressBook
        AddressBook a = new AddressBook("Book1");
        AddressBook b = new AddressBook("Book2");
        AddressBook c = new AddressBook("Book3");
        aList.add(a);
        aList.add(b);
        aList.add(c);
        int z = 1;
        do {
            System.out.println("Enter 1 : Select Address Book\n2: Display all the address book");
            int inp = sc.nextInt();
            switch (inp) {
                case 1 -> {
                    System.out.println("Enter the address book you want to search");
                    String searchAddressBook = sc.next();
                    for (AddressBook a1 : aList) {
                        if (a1.Name.equalsIgnoreCase(searchAddressBook)) {
                            //Menu based programming
                            int choice;
                            do {
                                System.out.println("Welcome to AddressBook");
                                System.out.println(menu);
                                CrudOperation c1 = new CrudOperation();
                                int input = sc.nextInt();
                                switch (input) {
                                    //adding the contact in The current address book instance using addContact method
                                    case 1 -> c1.AddContact(a1);
                                    //printing the current address book contact list
                                    case 2 -> System.out.println(a1.contactList);
                                    //Searching a name in the addressbook
                                    case 3 -> {
                                        System.out.println("Enter the name you want to search");
                                        String s1 = sc.next();
                                        c1.searchByFirstName(a1, s1);
                                    }
                                    case 4 -> {
                                        System.out.println("Enter the Phone Number you want to search");
                                        String s1 = sc.next();
                                        c1.searchByPhoneNumber(a1, s1);
                                    }
                                    case 5 -> {
                                        System.out.println("Enter the Name you want to delete");
                                        String s1 = sc.next();
                                        c1.deleteContactByfName(a1, s1);
                                    }
                                    case 6 -> {
                                        System.out.println("Enter the Name you want to update the phone number");
                                        String s1 = sc.next();
                                        c1.updatePhoneNumberByName(a1, s1);
                                    }
                                    default -> System.out.println("Enter valid option");
                                }
                                System.out.println("Enter 0 to exit");
                                choice = sc.nextInt();
                            } while (choice != 0);
                        }
                    }
                }
                case 2 -> {
                    for (AddressBook x1 : aList) {
                        System.out.println(x1.Name + "  : " + x1.contactList);
                    }
                }
                default -> z = 0;
            }
        } while (z != 0);
    }
}