package com.floresbarco.model;

import com.floresbarco.DataStructure.Stack;

public class Client {
    private Integer id;
    private String name;
    private Integer colorImage;
    private Integer colorlessImage;
    private Integer steps;
    private Integer windowNumber;
    private Stack<Image> images;

    // CONSTRUCTOR
    public Client() {
        this.id = 0;
        this.name = "";
        this.colorImage = 0;
        this.colorlessImage = 0;
        this.steps = 0;
        this.windowNumber = 0;
        this.images = new Stack<Image>();
    }

    public Client(Integer id, String name, Integer colorImage, Integer colorlessImage) {
        this.id = id;
        this.name = name;
        this.colorImage = colorImage;
        this.colorlessImage = colorlessImage;
        this.steps = 0;
        this.windowNumber = 0;
        this.images = new Stack<Image>();
    }

    public Client(Integer id, String name, Integer colorImage, Integer colorlessImage, Integer steps, Integer windowNumber, Stack<Image> images) {
        this.id = id;
        this.name = name;
        this.colorImage = colorImage;
        this.colorlessImage = colorlessImage;
        this.steps = steps;
        this.windowNumber = windowNumber;
        this.images = images;
    }


    // GETTER AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getWindowNumber() {
        return windowNumber;
    }

    public void setWindowNumber(Integer windowNumber) {
        this.windowNumber = windowNumber;
    }

    public Stack<Image> getImages() {
        return images;
    }

    public void setImages(Stack<Image> images) {
        this.images = images;
    }
}
