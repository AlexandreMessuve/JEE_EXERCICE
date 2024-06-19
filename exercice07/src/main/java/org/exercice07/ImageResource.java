package org.exercice07;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.EntityPart;
import jakarta.ws.rs.core.MediaType;
import org.exercice07.entity.Image;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.File;
import java.io.InputStream;

@Path("/image")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ImageResource {
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public void postImage(@FormDataParam("image") Part imagePart) {
        if (imagePart != null) {
            String fileName = imagePart.getName();
            System.out.println(fileName);
        }else{
            System.out.println("file is null");
        }


    }
}