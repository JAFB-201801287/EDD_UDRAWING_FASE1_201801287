package com.floresbarco.DataStructure;

public class LinkedList<T> {
    private Integer index;
    private Integer count;
    private Node<T> head;
    private Node<T> last;

    // CONTRUCTORES
    public LinkedList() {
        this.index = 1;
        this.count = 0;
        this.head = null;
        this.last = null;
    }

    // GET
    public Node<T> get() {
        return this.head;
    }

    public Integer getCount() { return count; }

    // ADD
    public void add(T element) {
        Node<T> newNode = new Node<T>(this.index, element);
        if (this.head == null) {
            this.head = newNode;
            this.last = this.head;
        } else {
            this.last.setAfter(newNode);
            this.last = newNode;
        }
        this.index++;
        this.count++;
    }

    // DEQUEUE
    public T dequeue() {
        Node<T> temp = new Node<T>();
        if(this.head != null) {
            temp = this.head;
            this.head = this.head.getAfter();
            this.count--;
            return temp.getElement();
        }
        return null;
    }
}
