// Hannah Bernthal
import java.util.ArrayList;
import java.util.Scanner;


public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person other) {
        contacts.add(other);
    }

    // I would like to use this for a for each loop grade boost.
    public void printContacts() {
        for (Person currentContact : contacts) {
            System.out.println(currentContact);
        }
    }

    // These are the searching functions.
    // I would also like to use this for a for each loop grade boost.
    // This function searches through contacts for a first name that matches the passed in variable.
    public Person searchByFirstName(String firstName) {
        for (Person currentContact : contacts) {
            if (currentContact.getFirstName().equals(firstName)) {
                return currentContact;
            }
        }
        return null;
    }
    // This function searches through contacts for a last name that matches the passed in variable.
    public Person searchByLastName(String lastName) {
        for (Person currentContact : contacts) {
            if (currentContact.getLastName().equals(lastName)) {
                return currentContact;
            }
        }
        return null;
    }
    // This function searches through contacts for a phone number that matches the passed in variable.
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person currentContact : contacts) {
            if (currentContact.getPhoneNumber().equals(phoneNumber)) {
                return currentContact;
            }
        }
        return null;
    }

    // This method goes through contacts and prints out each person if they are a student.
    public void listStudents() {
        for (Person currentContact : contacts) {
            if (currentContact instanceof Student)  {
                System.out.println(currentContact);
            }
        }
    }

    // This sorts contacts using bubble sort based on what the user wants to search by.
    public void sort(int sortBy) {
        Person temp;
        int difference;
        // In all of these algorithms, the difference variable is set to either <0, 0, or >0.
        // <0 means that the first word comes before the second alphabetically
        // 0 means that the words are the same
        // >0 means that the first word comes after the second alphabetically
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // This line of code compares the first name of the first person to the first name of the second person.
                    difference = contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName());
                    if (difference > 0) {
                        // This swaps the two people using a temporary Person variable --> temp.
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        if (sortBy == 1) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // This line of code compares the last name of the first person to the last name of the second person.
                    difference = contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName());
                    if (difference > 0) {
                        // This swaps the two people using a temporary Person variable --> temp.
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        if (sortBy == 2) {
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // This line of code compares the phone number of the first person to the phone number of the second person.
                    difference = contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber());
                    if (difference > 0) {
                        // This swaps the two people using a temporary Person variable --> temp.
                        temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public void run() {
        int choice = 100;
        // The while loop makes it so that when the user types 0, the code stops running.
        while (choice != 0) {
            Scanner object = new Scanner(System.in);
            // These print statements print out the menu of possible actions.
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            // The integer that the user inputs becomes choice so that the code runs whichever method the user wants.
            choice = object.nextInt();
            object.nextLine();

            // This choice adds a contact.
            if (choice == 1) {
                System.out.println("Select a type of contact to add: ");
                System.out.println("1. Student ");
                System.out.println("2. Athlete ");
                int type = object.nextInt();
                object.nextLine();

                System.out.println("Please fill in the following information. ");
                System.out.println("First Name: ");
                String firstName = object.nextLine();
                System.out.println("Last Name: ");
                String lastName = object.nextLine();
                System.out.println("Phone Number: ");
                String phoneNumber = object.nextLine();

                // Type 1 is a student so we have the additional attribute of grade.
                if (type == 1) {
                    System.out.println("Grade: ");
                    int grade = object.nextInt();
                    addContact(new Student(firstName, lastName, phoneNumber, grade));
                }
                else
                {
                    // Type 2 is an athlete so we have the additional attributes of sport and level.
                    System.out.println("Sport: ");
                    String sport = object.nextLine();
                    System.out.println("Level: ");
                    String level = object.nextLine();
                    addContact(new Athlete(firstName, lastName, phoneNumber, sport, level));
                }
            }
            // This choice sorts by first name.
            else if (choice == 2) {
                sort(0);
                printContacts();
            }
            // This choice sorts by last name.
            else if (choice == 3) {
                sort(1);
                printContacts();
            }
            // This choice sorts by phone number.
            else if (choice == 4) {
                sort(2);
                printContacts();
            }
            // This lists all students.
            else if (choice == 5) {
                listStudents();
            }
            // This searches by first name.
            else if (choice == 6) {
                System.out.println("Enter a name: ");
                String firstName = object.nextLine();
                Person search = searchByFirstName(firstName);
                if (search != null) {
                    System.out.println(search);
                }
                else
                {
                    System.out.println(firstName + " is not in the list.");
                }
            }
            // This searches by last name.
            else if (choice == 7) {
                System.out.println("Enter a name: ");
                String lastName = object.nextLine();
                Person search = searchByLastName(lastName);
                if (search != null) {
                    System.out.println(search);
                }
                else
                {
                    System.out.println(lastName + " is not in the list.");
                }
            }
            // This searches by phone number.
            else if (choice == 8) {
                System.out.println("Enter a phone number: ");
                String phoneNumber = object.nextLine();
                Person search = searchByPhoneNumber(phoneNumber);
                if (search != null) {
                    System.out.println(search);
                }
                else
                {
                    System.out.println(phoneNumber + " is not in the list.");
                }
            }
            // This ends the loop because it measn that the choice == 0.
            else
            {
                break;
            }
        }
    }
}
