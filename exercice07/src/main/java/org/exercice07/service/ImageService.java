package org.exercice07.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.exercice07.entity.Image;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ImageService {
    private static final List<Image> imageList = new ArrayList<>();
    public Image save(String path){
        Image image = new Image(path);
        imageList.add(image);
        return image;
    }

    public List<Image> getAll(){
        return imageList;
    }
}
