package com.floresbarco.model;

public class Image {
    private Integer id;
    private String type;
    private Client client;


    // CONSTRUCTOR
    public Image() {
        this.id = 0;
        this.type = "";
        this.client = null;
    }

    public Image(Integer id, String type, Client client) {
        this.id = id;
        this.type = type;
        this.client = client;
    }

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
