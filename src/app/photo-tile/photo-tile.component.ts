import { Component, OnInit, Input } from '@angular/core';
import { Photo } from '../model/photo';
import { ImagePopupComponent } from '../image-popup/image-popup.component';

import {MatDialog, MatDialogConfig} from "@angular/material";

@Component({
  selector: 'app-photo-tile',
  templateUrl: './photo-tile.component.html',
  styleUrls: ['./photo-tile.component.css']
})
export class PhotoTileComponent implements OnInit {

  @Input() photoDetails: Photo;
  constructor(private dialog: MatDialog) {}

  ngOnInit() {
  }

  openFullImage(){

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    
    dialogConfig.data = {
      id: 1,
      title: 'Angular For Beginners'
    };
    this.dialog.open(ImagePopupComponent, dialogConfig);

    const dialogRef = this.dialog.open(ImagePopupComponent, dialogConfig);

  }
}
