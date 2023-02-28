package org.example;
import java.util.logging.*;

class ContactsOp{
    Logger l= Logger.getLogger("com.api");
    LinkedL[] a=new LinkedL[20];
    public void addingContact(String name, String phoneno, String email){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            a[index]=new LinkedL();
        }
        a[index].addingelement(name, phoneno, email);
    }
    public void deletingContact(String phoneno){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            l.info("Element is not Found");
        }
        else{
            a[index].deletingelement(phoneno);
        }
    }
    public void searchingContact(String phoneno){
        int index=(Integer.parseInt(String.valueOf(phoneno.charAt(0)))+Integer.parseInt(String.valueOf(phoneno.charAt(phoneno.length()/2))))%10;
        if(a[index]==null){
            l.info("element is not found");
        }
        else{
            a[index].searchingelement(phoneno);
        }
    }
    public void printingContact(){
        for(int i=0; i<20; i++){
            if(a[i]!=null){
                a[i].printingelement();
            }
        }
    }
}
