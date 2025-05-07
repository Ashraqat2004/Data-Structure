package datastructurefinal;

import java.util.Scanner;

public class DataStructureFinal {

    public static void main(String[] args) {
     try{   Scanner cs = new Scanner(System.in);
        DoublyLinkedList a = new DoublyLinkedList();
             
            a.Addlate(1);
            a.Addlate(11);
            a.Addlate(6);
            a.Addlate(9);
            a.Addlate(4);
            a.Addlate(8);
            a.Addlate(5);
            a.Addlate(4);
            a.Addlate(3);
            a.Addlate(7);
        
        
        for(int x = 0;x!=6;){
            
        System.out.println("Our Linked list is:\n");
        System.out.println("**********************************************************");
                  var it = a.iterator();
    while (it.hasNext()) {
        System.out.print(it.next()+" -> ");
    } System.out.println("null");

        System.out.println("**********************************************************\n"); 
        
        
        System.out.println("Choose what you want:\n1_Add to it:\n2_Search\n3_Delete:\n4_Arrange it in an ascending order:\n5_Show info\n6_Quit");
        x = cs.nextInt();
        
            
            if(x==1){ System.out.println("Enter:\n1_To Add Last\n2_To Insert");
                int y = cs.nextInt();    
                    if(y==1){ 
                        System.out.println("Add your data: ");
                        int x12 = cs.nextInt();
                        a.Addlate(x12);}
                    else if(y==2){
                        System.out.println("Add your data: ");
                        int x12 = cs.nextInt();
                        System.out.println("Add the index: ");
                        int x13= cs.nextInt();
                        a.insert(x12, x13);
                    }
                else System.out.println("No such thing.1\n");
             }
            
            
            else if(x==2){
                System.out.println("Enter:\n1_Search whether The data exists in the list or not: \n2_To find the index of a certain data: \n3_To find the last index of a certain data: ");
                int y = cs.nextInt();
                    if(y==1){
                        System.out.println("Enter the data you want to search: ");
                        int x22 =cs.nextInt();
                        System.out.println( a.search(x22));}
                    else if( y ==2 ){
                        System.out.println("Enter the index you want to detect it's data: ");    
                        int x22 =cs.nextInt();
                        System.out.println(a.get(x22));
                    }
                    else if( y ==3 ){
                        System.out.println("Enter the data you want to detect it's last index: ");    
                        int x22 =cs.nextInt();
                        System.out.println(a.lastIndexOf(x22));
                    }
                    else System.out.println("No such thing\n");}
            
            
            else if(x==3){
                System.out.println("Enter:\n1_Delete data: \n2_Delete at certain index: ");
                int y = cs.nextInt();
                    if(y==1){
                        System.out.println("Enter the data you want to delete: ");
                        int x22 =cs.nextInt();
                        a.deleteData(x22);}
                    else if( y ==2 ){
                        System.out.println("Enter the index you want to delete: ");    
                        int x22 =cs.nextInt();
                        a.deleteAt(x22);
                    }
                    else System.out.println("No such thing\n");}
            
            else if(x==4){ 
               a.sort();}
            else if(x==5){
            a.DisPlayInfo();}
            else {System.out.println("No such thing\n");}

}}  catch (Exception e) 
{System.out.println("Wrong input");}
}}
