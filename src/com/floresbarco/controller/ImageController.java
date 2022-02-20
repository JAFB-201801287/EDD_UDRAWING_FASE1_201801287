package com.floresbarco.controller;

import com.floresbarco.DataStructure.LinkedList;
import com.floresbarco.model.Image;

public class ImageController {
    private static ImageController instance;
    private Integer idImage;
    // COLA DE IMPRESORA A COLOR
    private LinkedList<Image> imageColorList;
    // COLA DE IMAGENES EN BLANCO Y NEGRO
    private LinkedList<Image> imageColorLessList;

    // CONSTRUCTOR
    public ImageController() {
        this.idImage = 0;
        this.imageColorList = new LinkedList<Image>();
        this.imageColorLessList = new LinkedList<Image>();
    }

    // SINGLETON
    public static synchronized ImageController getInstance() {
        if(instance == null) {
            instance = new ImageController();
        }
        return instance;
    }

    // GET
    public LinkedList<Image> getImageColorList() {
        return imageColorList;
    }

    public LinkedList<Image> getImageColorLessList() {
        return imageColorLessList;
    }

    // ADD
    public void addColor(Image image) {
        image.setId(idImage);
        imageColorList.add(image);
        idImage++;
    }

    public void addColorLess(Image image) {
        image.setId(idImage);
        imageColorLessList.add(image);
        idImage++;
    }

    // DEQUEUE
    public Image dequeueColor() {
        return imageColorList.dequeue();
    }

    public Image dequeueColorLess() {
        return imageColorLessList.dequeue();
    }
}
