package com.floresbarco.controller;

import com.floresbarco.DataStructure.LinkedList;
import com.floresbarco.model.Window;

public class WindowController {
    private static WindowController instance;
    private LinkedList<Window> windowList;

    // Controller
    public WindowController() {
        instance = null;
        this.windowList = new LinkedList<Window>();
    }

    // SINGLETON
    public static synchronized WindowController getInstance() {
        if(instance == null) {
            instance = new WindowController();
        }
        return instance;
    }

    // GET
    public LinkedList<Window> getWindowList() {
        return windowList;
    }

    // ADD
    public void add(Integer n) {
        for (int x=0; x<n ; x++) {
            Window window = new Window(x+1);
            windowList.add(window);
        }
    }
}
