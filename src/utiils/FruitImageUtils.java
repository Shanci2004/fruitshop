package utiils;

import javax.servlet.http.Part;
import java.io.IOException;

public class FruitImageUtils{

    public static String addImage(Part imagePart){
        String storePath = "C:\\Users\\29424\\Desktop\\小组实验\\FruitShop\\web\\show\\";
        String filename = imagePart.getSubmittedFileName();
        storePath += filename;
        try {
            imagePart.write(storePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String image = "show/" + filename;
        return image;
    }
}
