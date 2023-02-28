package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Contacts {
    public static void main(String[] args) {
        Logger l = Logger.getLogger("com.api.jar");
        Scanner sc = new Scanner(System.in);
        ContactsOp op = new ContactsOp();
        try {
            boolean k = true;
            while (k) {
                l.info("1.AddContact\n2.DeleteContact\n3.SearchContact\n4.PrintContact\n5.Exit");
                l.info("Enter your choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        l.info("Enter your name");
                        String name = sc.next();
                        l.info("Enter your Phonenumber");
                        String phoneno = sc.next();
                        l.info("Enter your email");
                        String email = sc.next();
                        op.addingContact(name, phoneno, email);
                        break;
                    case 2:
                        l.info("Enter your Phonenumber to delete");
                        String phoneNo = sc.next();
                        op.deletingContact(phoneNo);
                        break;
                    case 3:
                        l.info("Enter your Phonenumber to search");
                        String phoneNO = sc.next();
                        op.searchingContact(phoneNO);
                        break;
                    case 4:
                        op.printingContact();
                        break;
                    case 5:
                        l.info("Exit");
                        k = false;
                        break;
                    default:
                        l.info("invalid choice");

                }
            }
        }
        catch(Exception e){
            l.info(""+e);
        }
        sc.close();
    }
}
