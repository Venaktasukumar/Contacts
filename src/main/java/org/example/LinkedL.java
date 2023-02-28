package org.example;

import java.util.logging.Logger;

class LinkedL {
    Logger l = Logger.getLogger("com");
    Node head = null;
    Node temp = null;
    Node prev = null;

    public void addingelement(String name, String phoneno, String email) {
        Node newcontact = new Node(name, phoneno, email);
        if (this.head == null) {
            this.head = newcontact;

        } else {
            this.temp = this.head;
            while (this.temp.ref != null) {
                this.temp = this.temp.ref;
            }
            this.temp.ref = newcontact;
        }
    }

    public void deletingelement(String phoneno) {
        int flag = 0;
        if (this.head == null) {
            l.info("Contacts is Empty");
        } else if (this.head.phoneno.equals(phoneno)) {
            this.head = this.head.ref;
            flag = 1;
            return;
        }
        this.temp = this.head;
        this.prev = null;
        while (this.temp != null) {
            if (this.temp.phoneno.equals(phoneno)) {
                this.prev.ref = temp.ref;
                flag = 1;
            }
            this.prev = this.temp;
            this.temp = this.temp.ref;
        }
        if (flag == 0) {
            l.info("Element is not found");
        } else {
            l.info("Element is deleted successfully");
        }
    }

    public void searchingelement(String phoneno) {
        int flag = 0;
        if (this.head == null) {
            l.info("Contacts is empty");
            return;
        }
        this.temp = this.head;
        while (this.temp != null) {
            if (this.temp.phoneno.equals(phoneno)) {
                flag = 1;
                String z = "Name :" + this.temp.name + " Phone No:" + this.temp.phoneno + " Email No:" + this.temp.email;
                l.info(z);
            }
            this.temp = this.temp.ref;
        }
        if (flag == 0) {
            l.info("element is not Found");
        }
    }

    public void printingelement() {
        if (this.head == null) {
            l.info("contacts is Empty");
            return;
        }
        this.temp = this.head;
        while (this.temp != null) {
            String q = "name: " + this.temp.name + " Phone no: " + this.temp.phoneno + " email: " + this.temp.email;
            l.info(q);
            this.temp = this.temp.ref;
        }
    }
}
