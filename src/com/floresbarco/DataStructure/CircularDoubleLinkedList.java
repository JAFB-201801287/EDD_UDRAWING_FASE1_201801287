package com.floresbarco.DataStructure;

public class CircularDoubleLinkedList<T> {
    private Integer index;
    private Integer count;
    private Node<T> head;
    private Node<T> last;

    // CONSTRUCTOR
    public CircularDoubleLinkedList() {
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
            newNode.setBefore(newNode);
            newNode.setAfter(newNode);
            this.head = newNode;
            this.last = this.head;
        } else {
            newNode.setBefore(this.last);
            newNode.setAfter(this.head);
            this.last.setAfter(newNode);
            this.last = newNode;
            this.head.setBefore(this.last);
        }
        this.index++;
        this.count++;
    }

    // DEQUEUE
    public T dequeue() {
        Node<T> temp = new Node<T>();
        if(this.head != null) {
            temp = this.head;
            if (this.head == this.head.getAfter()) {
                this.head = null;
            } else {
                this.head = this.head.getAfter();
                this.head.setBefore(this.last);
                this.last.setAfter(this.head);
                this.count--;
                return temp.getElement();
            }
        }
        return null;
    }

}
