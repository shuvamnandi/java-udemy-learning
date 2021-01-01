package com.shuvamnandi.composition;

public class Bed {
    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;

    public Bed(String style, int pillows, int quilt, int sheets, int height) {
        this.style = style;
        this.pillows = pillows;
        this.quilt = quilt;
        this.sheets = sheets;
        this.height = height;
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuilt() {
        return quilt;
    }

    public void make(){
        System.out.println("Bed.make -> making bed");
    }
}
