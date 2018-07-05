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

  photos: Photo[];
  title: string;
  constructor(private route: ActivatedRoute, private photoService: PhotoService) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.title = this.route.snapshot.paramMap.get('title');
    this.photoService.getPhotoAlbum(id).subscribe(data =>{
      this.photos = data;
    })
  }

  

}
