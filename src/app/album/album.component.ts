import { Component, OnInit } from '@angular/core';
import {AlbumService} from '../album-service/album-service.service';
import {Router} from "@angular/router";

import {Album} from '../model/album';
import { UserService } from '../user-service/user-service.service';

import {User} from '../model/user';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {

  albums: Album[];
  title = "album";

  constructor(private router: Router, private albumService: AlbumService, private userService: UserService) { 
    
  }

  ngOnInit() {
    this.albumService.getAllAlbums().subscribe(data => {
      this.albums = data;
      this.setUserNames(this.albums);
    });
  }


  setUserNames(albums: Album[]){
    albums.forEach(album => {
      this.userService.getUser(parseInt(album.userId)).subscribe(data =>{
        album.userId = data.username;
      });
    });
  }



}
