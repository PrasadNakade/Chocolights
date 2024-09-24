package com.example.demo.Image;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepository;
	
       public ImageEntity saveImage(MultipartFile file , String customName , String description) throws IOException
       {
    	   ImageEntity imageEntity = new ImageEntity();
//           imageEntity.setName(file.getOriginalFilename());
    	   imageEntity.setName(customName.isEmpty() ? file.getOriginalFilename() : customName);
           imageEntity.setImageData(file.getBytes());
//           imageEntity.setDescription(description);
           imageEntity.setDescription(description);
           return imageRepository.save(imageEntity);
       }
       
       public List<ImageEntity> getAllImages() {
   	    return imageRepository.findAll();
   	}
}
