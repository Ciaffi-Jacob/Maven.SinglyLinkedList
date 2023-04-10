package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable>{
    Node<T> head;
    public SinglyLinkedList(){

    }
    public void add(T value){
        if(head == null){
            head = new Node<T>(value);
        } else {
            Node<T> current = head;
            while (current.getNext() != null){
                current = current.next;
            }
            current.setNext(new Node<T>(value));
        }
    }

    public void remove(T expected) {
        if(head.getData().equals(expected)){
            head = head.next;
            return;
        }

        Node<T> before = head;
        Node<T> after = head.next;

        while (after != null){
            if (after.getData().equals(expected)){
                after = after.next;
                before.next = after;
                return;
            } else {
                before = after;
                after = after.next;
            }
        }
    }

    public boolean contains(T expected) {
        Node<T> current = head;
        while(current != null){
            if(current.getData().equals(expected)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(T val) {
        if(head == null) {
            System.out.println("null");
            return -1;
        }
        Node<T> current = head;
        int count = 0;
        while (current != null){
            if (current.getData().equals(val)){
                return count;
            }
            count++;
            current = current.next;
        }
        return -1;
//        int num = 0;
//        Node<T> current = head;
//        while (current != null){
//            if(current.getData().equals(val)){
//                return num;
//            }
//            current = current.next;
//            num++;
//        }
//        return -1;
    }

    public int size() {
        int num = 0;
        Node<T> current = head;
        while (current != null){
            num++;
            current = current.next;
        }
        return num;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.getData();
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> current = head;
        while (current != null) {
            newList.add(current.getData());
            current = current.next;
        }
        return newList;
    }

    public void sort() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> min = head;
        Node<T> current = head;
        int startSize = this.size();
        for (int i = 0; i < startSize; i++){
            current = head;
            min = current;
            for (int j = 0; j < this.size(); j++) {
                if (current.getData().compareTo(min.getData()) < 0){
                    min = current;
                }
                current = current.next;
            }
            newList.add(min.getData());
            this.remove(min.getData());

            head = newList.head;
        }



    }
}
