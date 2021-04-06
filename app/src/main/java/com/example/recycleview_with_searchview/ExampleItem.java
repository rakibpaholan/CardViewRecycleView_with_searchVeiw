package com.example.recycleview_with_searchview;

public class ExampleItem {
    private int mImage;
    private String text1;
    private String text2;

    public ExampleItem(int mImage, String text1, String text2) {
        this.mImage = mImage;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getmImage() {
        return mImage;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
