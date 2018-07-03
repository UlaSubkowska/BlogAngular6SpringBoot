import { Component, OnInit } from '@angular/core';
import {Photo} from '../model/photo';
import { PhotoService } from '../photo-service/photo.service';
import { ActivatedRoute } from '@angular/router';
import { PhotoTileComponent } from '../photo-tile/photo-tile.component';

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent implements OnInit {

  photoTiles: PhotoTileComponent[];
  photos: Photo[];
  constructor(private route: ActivatedRoute, private photoService: PhotoService) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.photoService.getPhotoAlbum(id).subscribe(data =>{
      this.photos = data;
    })
  }

  

}
