package com.example.demo.Image;



import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity


@Table(name = "images")
public class ImageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
      
	 @Column(name = "name")
	    private String name;

//	    @Lob
//	    @Column(name = "image_data", columnDefinition = "BLOB")
//	    private byte[] imageData;
	 
	 @Lob
	 @Column(name = "image_data", columnDefinition = "MEDIUMBLOB")  // or LONGBLOB
	 private byte[] imageData;
	  
	    @Column(name = "description")
	    String description;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "ImageEntity [id=" + id + ", name=" + name + ", imageData=" + Arrays.toString(imageData)
					+ ", description=" + description + "]";
		}

		public ImageEntity(Long id, String name, byte[] imageData, String description) {
			super();
			this.id = id;
			this.name = name;
			this.imageData = imageData;
			this.description = description;
		}

		public ImageEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

		
	

}