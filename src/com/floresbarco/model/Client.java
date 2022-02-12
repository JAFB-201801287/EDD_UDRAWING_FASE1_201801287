package com.floresbarco.model;

public class Cliente {
    private Integer id;
    private String name;
    private Integer colorImage;
    private Integer colorlessImage;
    private Integer steps;

    // CONSTRUCTOR
    public Cliente() {
        this.id = 0;
        this.name = "";
        this.colorImage = 0;
        this.colorlessImage = 0;
        this.steps = 0;
    }

    public Cliente(Integer id, String name, Integer colorImage, Integer colorlessImage, Integer steps) {
        this.id = id;
        this.name = name;
        this.colorImage = colorImage;
        this.colorlessImage = colorlessImage;
        this.steps = steps;
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
}
