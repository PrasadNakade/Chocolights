import { Component } from '@angular/core';
import { ImageService } from '../image.service';

@Component({
  selector: 'app-userview',
  templateUrl: './userview.component.html',
  styleUrl: './userview.component.css'
})
export class UserviewComponent {

  images:any[]=[];

  whatToShow:number=0


  constructor(public imageService:ImageService){}


 
  orderParticularProduct(productName: string) {
    const phoneNumber = '+919146292750'; // Replace with the recipient's phone number (with country code)
    const message = encodeURIComponent(`Hello, I would like to order the ${productName} product.`);

   // const encodedImage = encodeURIComponent(imageData);
  
    // Construct the WhatsApp URL
    const whatsappUrl = `https://wa.me/${phoneNumber}?text=${message}`;
  
    // Open the WhatsApp URL in a new tab
    window.open(whatsappUrl, '_blank'); 
  }

  



ngOnInit(){
  this.getAllImages();
}

getAllImages() {
this.imageService.getAllImages().subscribe((data =>{
  this.images=data
  }))
}


adminView(){
  console.log("done")
  this.whatToShow=1
}

productName: string = ''; // Bind this to the input field

orderProduct() {
  this.whatToShow = 3; // Show the input box to enter the product name
}

sendToWhatsApp() {
  const phoneNumber = '+917066675555'; // Replace with the recipient's phone number (with country code)
  const message = encodeURIComponent(`Hello, I would like to order the ${this.productName} product.`);

  // Construct the WhatsApp URL
  const whatsappUrl = `https://wa.me/${phoneNumber}?text=${message}`;

  // Open the WhatsApp URL in a new tab
  window.open(whatsappUrl, '_blank');
}
}
