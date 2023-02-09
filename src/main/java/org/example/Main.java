package org.example;
import java.util.*;
import java.util.logging.*;

class Node{
    String name;
    String phoneno;
    String email;
    Node ref;
    public Node(String name,String phoneno, String email){
        this.name=name;
        this.phoneno=phoneno;
        this.email=email;
    }
}
class LinkedList{
    String x="com.api.jar";
    Logger l= Logger.getLogger(x);
    Node head=null;
    Node temp=null;
    Node prev=null;
    public void addElement(String name, String phoneno, String email){
        Node newcontact=new Node(name,phoneno,email);
        if(this.head==null){
            this.head=newcontact;

        }
        else{
            this.temp=this.head;
            while(this.temp.ref!=null){
                this.temp=this.temp.ref;
            }
            this.temp.ref=newcontact;
        }
    }
    public void deleteElement(String phoneno){
        int flag=0;
        if(this.head==null){
            l.info("Contacts is Empty");
        }
        else if(this.head.phoneno.equals(phoneno)){
            this.head=this.head.ref;
            flag=1;
            return;
        }
        this.temp=this.head;
        this.prev=null;
        while(this.temp!=null){
            if(this.temp.phoneno.equals(phoneno)){
                this.prev.ref=temp.ref;
                flag=1;
            }
            this.prev=this.temp;
            this.temp=this.temp.ref;
        }
        if(flag==0){
            l.info("element is not found");
        }
        else{
            l.info("Element is deleted successfully");
        }
    }
    public void searchElement(String phoneno){
        int flag=0;
        if(this.head==null){
            l.info("Contacts is empty");
            return;
        }
        this.temp=this.head;
        while(this.temp!=null){
            if(this.temp.phoneno.equals(phoneno)){
                flag=1;
                l.info("Name :"+this.temp.name+" Phone No:"+this.temp.phoneno+" Email No:"+this.temp.email);
            }
            this.temp=this.temp.ref;
        }
        if(flag==0){
            l.info("element is not found");
        }
    }
    public void printElement(){
        if(this.head==null){
            l.info("contacts is Empty");
            return;
        }
        this.temp=this.head;
        while(this.temp!=null){
            l.info("Name :"+this.temp.name+" Phone No:"+this.temp.phoneno+" Email No:"+this.temp.email);
            this.temp=this.temp.ref;
        }
    }
}
class ContactsOp{
    String y="com.api.jar";
    Logger l= Logger.getLogger(y);
    LinkedList[] a=new LinkedList[20];
    public void addContact(String name, String phoneno, String email){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            a[index]=new LinkedList();
        }
        a[index].addElement(name, phoneno, email);
    }
    public void deleteContact(String phoneno){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            l.info("element is not found");
        }
        else{
            a[index].deleteElement(phoneno);
        }
    }
    public void searchContact(String phoneno){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            l.info("element is not found");
        }
        else{
            a[index].searchElement(phoneno);
        }
    }
    public void printContact(){
        for(int i=0; i<10; i++){
            if(a[i]!=null){
                a[i].printElement();
            }
        }
    }
}
class Contacts{
    public static void main(String[] args){
        Logger l= Logger.getLogger("com.api.jar");
        Scanner sc=new Scanner(System.in);
        ContactsOp op=new ContactsOp();
        boolean k=true;
        while(k){
            l.info("1.AddContact\n2.DeleteContact\n3.SearchContact\n4.PrintContact\n5.Exit");
            l.info("Enter your choice:");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    l.info("Enter your name");
                    String name=sc.next();
                    l.info("Enter your Phonenumber");
                    String phoneno=sc.next();
                    l.info("Enter your email");
                    String email=sc.next();
                    op.addContact(name,phoneno,email);
                    break;
                case 2:
                    l.info("Enter your Phonenumber to delete");
                    String phoneNo=sc.next();
                    op.deleteContact(phoneNo);
                    break;
                case 3:
                    l.info("Enter your Phonenumber to search");
                    String phoneNO=sc.next();
                    op.searchContact(phoneNO);
                    break;
                case 4:
                    op.printContact();
                    break;
                case 5:
                    l.info("Exit");
                    k=false;
                    break;
                default:
                    l.info("invalid choice");

            }
        }
        sc.close();

    }
}