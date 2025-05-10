package com.mycompany.dstracture_project;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLL implements ContainerOps {

    private Node head;
    private Node tail;
    public int size = 0;

    private class Node {

        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
            this.data = 0;
        }
    }

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void Addlate(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
            tail = n;

        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;

        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void deleteData(int data) {

        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        if (head.data == data) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Data not found in the list");
            return;
        }
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Integer next() {
                if (temp == null) {
                    throw new NoSuchElementException();
                }
                int data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    @Override
    public void insert(int d, int index) {
        Node n = new Node(d);

        if (index < 0 || index > size) {
            System.out.println("Index out of range.");
            return;
        }

        if (index == 0) { //check if an insert at first 
            if (isEmpty()) {  //check if it empty
                head = n;
                tail = n;
            } else { // if it not empty and index == 0
                n.next = head;
                head.prev = n;
                head = n;
            }
        } else if (index == size) { // check if the insert at last 
            tail.next = n;
            n.prev = tail;
            tail = n;
        } else { //if insert at anywhere   
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            n.next = temp.next;
            if (temp.next != null) { // to be sure temp not the last node 
                temp.next.prev = n;//
            }
            temp.next = n;
            n.prev = temp;
        }
        size++;
    }

    @Override
    public void deleteAt(int index) {

        if (index < 0) {
            System.out.println("The index is out of range.");
            return;
        }
        if (index == 0) { //delete first element 
            if (head == null) {
                System.out.println("The list is empty.");
                return;
            }
            if (head == tail) { //  if one element 
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            Node temp = head;

            for (int i = 0; temp != null && i < index; i++) { // to reached the indexwe wqnt to delete 
                temp = temp.next;
            }
            if (temp == null) {  //we entered number out of range 
                System.out.println("The index is out of range.");
                return;
            }

            if (temp.next == null) { // if we delete last index
                tail = temp.prev;
                tail.next = null;
            } else { // if index any where at middle
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
        size--;
    }

    @Override
    public void Frontdisplay() {
        Node t = head;
        while (t.next != null) {
            System.out.print(t.data + " " + "->" + " ");
            t = t.next;
        }
        System.out.println(t.data);
    }

    @Override
    public boolean search(int data) {
        Node temp = head;
        boolean srch = false;
        for (; temp != null && temp.data != data;) {
            temp = temp.next;
        }
        if (temp != null) {
            srch = true;
        }
        return srch;
    }

    @Override
    public int indexOf(int data) {
        Node temp = head;
        int in = 0;
        for (; temp != null && temp.data != data;) {
            temp = temp.next;
            in++;
        }
        if (temp.data == data) {
            return in;
        } else {
            return -1;
        }
    }

    @Override
    public int lastIndexOf(int data) {
        Node temp = head;
        int count = -1;
        int x = 0;
        while (temp != null) {
            count++;
            if (temp.data == data) {
                x = count;
            }
            temp = temp.next;
        }
        return x;

    }

    @Override
    public int get(int index) {
        Node temp = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of range.");
        }

        for (int i = 0; i < index; i++) {  //for Loop until the index is reached.
            temp = temp.next;
        }
        return temp.data;  // Return the data by given index.
    }

    @Override
    public void sort() {

        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            Node afterNode = temp.next;
            while (afterNode != null) {
                if (temp.data > afterNode.data) {
                    // create int variauble to sore the the temp DATA (the greater) then change the dats 
                    // the tempDATA will be the afterTemp DATA (the smaller ) then return the R into the 
                    // the afterNode 
                    int R = temp.data;
                    temp.data = afterNode.data;
                    afterNode.data = R;
                }
                afterNode = afterNode.next;
            }
            temp = temp.next;
        }
    }

    @Override
    public void growCapacity(int newCapacity) {
        System.out.println("Not Supported method ");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int lastData() {
        if (tail == null) {
            throw new IllegalStateException("The list is empty.");
        }
        return tail.data;
    }

    @Override
    public void DisPlayInfo() {
        Node t = head;
        System.out.println("");
        while (t.next != null) {
            System.out.print(t.data + " " + "->" + " ");
            t = t.next;
        }
        System.out.println(t.data);// return null
        System.out.println("The size : " + size());
        System.out.println("______________");
        System.out.println("The last data insert is : " + lastData());
        System.out.println("______________");
        System.out.println("This list is empty ? " + isEmpty());
    }

    @Override
    public void pointsContainer(int cap) {
        System.out.println("not available");
    }

}
