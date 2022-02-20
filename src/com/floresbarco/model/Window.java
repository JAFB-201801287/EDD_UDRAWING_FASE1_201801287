package com.floresbarco.model;

import com.floresbarco.DataStructure.Stack;

public class Window {
    private Integer id;
    private Client client;
    private Stack<Image> images;
    private Integer colorImage;
    private Integer colorlessImage;

    // CONTROLLER
    public Window() {
        this.id = 0;
        this.client = null;
        this.images = new Stack<Image>();
        this.colorImage = 0;
        this.colorlessImage = 0;
    }

    public Window(Integer id) {
        this.id = id;
        this.client = null;
        this.images = new Stack<Image>();
        this.colorImage = 0;
        this.colorlessImage = 0;
    }

    public Window(Integer id, Client client, Stack<Image> images) {
        this.id = id;
        this.client = client;
        this.images = images;
        this.colorImage = 0;
        this.colorlessImage = 0;
    }

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stack<Image> getImages() {
        return images;
    }

    public void setImages(Stack<Image> images) {
        this.images = images;
    }

    public Integer getColorImage() {
        return colorImage;
    }

    public void setColorImage(Integer colorImage) {
        this.colorImage = colorImage;
    }

    public Integer getColorlessImage() {
        return colorlessImage;
    }

    public void setColorlessImage(Integer colorlessImage) {
        this.colorlessImage = colorlessImage;
    }

}
