package com.contactmagement.app;

import com.contactmagement.comparator.NameComparator;
import com.contactmagement.model.Contact;
import com.contactmagement.service.ContactService;
import com.contactmagement.service.ContactServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactService service = new ContactServiceImpl();
        Scanner input = new Scanner(System.in);
        service.loadFromFile();
        while (true) {

            print("\n1.Add 2.Remove 3.List 4.Search Phone 5.Search Name 6.Sort 7.Save 0.Exit");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    print("Name : ");
                    String name = input.nextLine();
                    print("Phone : ");
                    String phone = input.nextLine();
                    service.addContact(new Contact(name, phone));
                    break;

                case 2:
                    print("Phone : ");
                    String phoneNumber = input.nextLine();
                    service.removeContact(phoneNumber);
                    break;

                case 3:
                    service.getAllContact().forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Phone : ");
                    String phoneNum = input.nextLine();
                    Contact c = service.searchByPhone(phoneNum);
                    System.out.println(c != null ? c : "Not Found");
                    break;

                case 5:
                    print("Name : ");
                    String s = input.nextLine();
                    service.searchByName(s).forEach(System.out::println);
                    break;

                case 6:
                    service.getAllContact().sort(new NameComparator());
                    print("Sorted.");
                    break;

                case 7:
                    service.saveToFile();
                    break;

                case 0:
                    service.saveToFile();
                    System.exit(0);
            }
        }
    }

    public static void print(String massage) {
        System.out.println(massage);
    }
}
