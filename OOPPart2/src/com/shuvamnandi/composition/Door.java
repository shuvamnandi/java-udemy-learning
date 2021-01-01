package com.shuvamnandi.composition;

public class Door {
    private String woodType;
    private String colour;
    private int height;
    private int width;

    public Door(String woodType, String colour, int height, int width) {
        this.woodType = woodType;
        this.colour = colour;
        this.height = height;
        this.width = width;
    }

    public String getWoodType() {
        return woodType;
    }

    public String getColour() {
        return colour;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
