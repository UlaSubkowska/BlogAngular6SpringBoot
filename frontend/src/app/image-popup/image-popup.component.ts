import { Component, OnInit, Inject } from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-image-popup',
  templateUrl: './image-popup.component.html',
  styleUrls: ['./image-popup.component.css']
})
export class ImagePopupComponent implements OnInit {

  photoUrl:string;
  title: string;

  constructor(
    public dialogRef: MatDialogRef<ImagePopupComponent>,
      @Inject(MAT_DIALOG_DATA) data) {

      this.photoUrl = data.url;
      this.title = data.title;
  }

  ngOnInit() {
      
  }

  onNoClick() {
    this.dialogRef.close();
  }
}
