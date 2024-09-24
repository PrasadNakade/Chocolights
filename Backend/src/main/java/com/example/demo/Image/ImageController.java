package com.example.demo.Image;


import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/imagecurd")
public class ImageController {
	
	@Autowired
	ImageService imageService;

	
//	@PostMapping("/upload")
//	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,
//	                                     @RequestParam("name") String customName,
//	                                     @RequestParam("description") String description) {
//	    try {
//	        System.out.println("Backend: Received file: " + file.getOriginalFilename());
//	        System.out.println("Description: " + description);
//
//	        // Save the image and its metadata in the database
//	        ImageEntity imageEntity = imageService.saveImage(file, customName, description);
//	        return ResponseEntity.ok("Image uploaded successfully: " + imageEntity.getId());
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return ResponseEntity.status(500).body("Failed to upload image");
//	    }
//	}
	

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@RequestParam("name") String customName , @RequestParam("description") String description )
	{
		try {
			System.out.println("backend");
			System.out.println(file);
			System.out.println(description);
			
            ImageEntity imageEntity = imageService.saveImage(file, customName, description);
            return ResponseEntity.ok("Image uploaded successfully: " + imageEntity.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload image");
        }
	}

	
//	@PostMapping("/upload-multiple") 
//	public ResponseEntity<String> uploadMultiple(@RequestParam("files") MultipartFile[] files,
//	                                             @RequestParam("name") String customName,
//	                                             @RequestParam("description") String description) {
//	    try {
//	        for (MultipartFile file : files) {
//	            System.out.println("Backend: Received file: " + file.getOriginalFilename());
//	            System.out.println("Description: " + description);
//
//	            // Save the image and its metadata in the database
//	            imageService.saveImage(file, customName, description);
//	        }
//	        return ResponseEntity.ok("Images uploaded successfully.");
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return ResponseEntity.status(500).body("Failed to upload images");
//	    }
//	}
//	
	@GetMapping("/all")
	public ResponseEntity<List<Map<String, String>>> getAllImages(){
		System.out.println("get image");
		List<ImageEntity> images = imageService.getAllImages();
	    List<Map<String, String>> response = new ArrayList<>();
	    
	    
	    for (ImageEntity image : images) {
	        Map<String, String> imageMap = new HashMap<>();
	        imageMap.put("id", image.getId().toString());
	        imageMap.put("name", image.getName());
	        imageMap.put("description", image.getDescription());
	        imageMap.put("imageData", Base64.getEncoder().encodeToString(image.getImageData()));
	        response.add(imageMap);
	    }

	    return ResponseEntity.ok(response);
	}

}