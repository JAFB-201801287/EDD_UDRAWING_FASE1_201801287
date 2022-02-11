package com.floresbarco.DataStructure;

public class Node<T> {
    private Integer id;
    private T element;
    private Node<T> before;
    private Node<T> after;

    // CONSTRUCTORES
    public Node() {
        this.id = 0;
        this.before = null;
        this.after = null;
    }

    public Node(Integer id ,T element) {
        this.id = id;
        this.element = element;
        this.before = null;
        this.after = null;
    }

    public Node(Integer id, T element, Node<T> before, Node<T> after) {
        this.id = id;
        this.element = element;
        this.before = before;
        this.after = after;
    }

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getBefore() {
        return before;
    }

    public void setBefore(Node<T> before) {
        this.before = before;
    }

    public Node<T> getAfter() {
        return after;
    }

    public void setAfter(Node<T> after) {
        this.after = after;
    }
}
