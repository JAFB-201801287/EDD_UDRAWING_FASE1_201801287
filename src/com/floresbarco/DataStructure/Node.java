package com.floresbarco.DataStructure;

public class Node<T> {
    private Integer id;
    private T before;
    private T after;

    public Node() {
    }

    public Node(Integer id, T before, T after) {
        this.id = id;
        this.before = before;
        this.after = after;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getBefore() {
        return before;
    }

    public void setBefore(T before) {
        this.before = before;
    }

    public T getAfter() {
        return after;
    }

    public void setAfter(T after) {
        this.after = after;
    }
}
