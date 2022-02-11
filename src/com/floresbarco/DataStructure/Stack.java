package com.floresbarco.DataStructure;

public class Stack<T> {
    private Integer index;
    private Integer count;
    private Node<T> head;

    // CONSTRUCTOR
    public Stack() {
        this.index = 1;
        this.count = 0;
        this.head = null;
    }

    // GET
    public Node<T> get() {
        return this.head;
    }

    public Integer getCount() { return count; }

    // ADD
    public void add(T element) {
        Node<T> newNode = new Node<>(this.index, element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.setAfter(this.head);
            this.head = newNode;
        }
        this.index++;
        this.count++;
    }

    // POP
    public T pop() {
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
