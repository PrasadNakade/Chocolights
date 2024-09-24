import { Component } from '@angular/core';
import { ImageService } from '../image.service';

// @Component({
//   selector: 'app-dashboard',
//   templateUrl: './dashboard.component.html',
//   styleUrls: ['./dashboard.component.css']  // Corrected to styleUrls
// })
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  selectFile!:File;
  customName: string = '';
  description: string = '';
  deom: string ='';
  images:any[]=[];

  constructor(public imageService:ImageService){}

  onFileChanged(event:any)
  {
         this.selectFile = event.target.files[0];
        // console.log("on changes")
         ///console.log("select files : ",this.selectFile)
  }
  demo(){
    console.log(this.customName);
    console.log(this.description);
  
   // console.log("check madhe")
  }

  onUpload(){
    //console.log("onUpload")
 //   console.log(this.customName)
   // console.log(this.description)
    this.imageService.uploadImage(this.selectFile,this.customName,this.description).subscribe((res =>{
      window.alert(res)
    }))
  }

  // ngOnInit(){
  //   this.getAllImages();
  // }

//   getAllImages() {
//   this.imageService.getAllImages().subscribe((data =>{
//     this.images=data
//   }))
// }

}