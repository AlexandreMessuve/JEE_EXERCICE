package org.exercice07.entity;

public class Image {
    private String path;
    public Image(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "image{" +
                "path='" + path + '\'' +
                "}";
    }
}
