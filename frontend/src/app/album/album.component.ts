import { Component, OnInit } from '@angular/core';
import {AlbumService} from '../album-service/album-service.service';
import {Router} from "@angular/router";

import {Album} from '../model/album';
import { UserService } from '../user-service/user-service.service';

import {User} from '../model/user';
import { Observable } from 'rxjs';

export class AlbumContainer{
  albums: Album[] = [];
  username: string;
  userid: number;
}
@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  albumContainer: AlbumContainer[] = [];
  public isLoading: boolean;

  constructor(private router: Router, private albumService: AlbumService, private userService: UserService) { 
    
  }

  async ngOnInit() {
    this.isLoading = true;
    let result = await this.albumService.getAllAlbums();
    await this.setUserNames(result);
    this.setContainer(result);

    this.isLoading = false;
  }

  setContainer(albums: Album[]){
    albums.forEach(album => {
      this.addAlbumToContainer(album)
    });
  }

  addAlbumToContainer(album: Album){
    let added:boolean = false;
      this.albumContainer.forEach(item=>{
        if(item.username === album.username){
          item.albums.push(album);
          added = true;
        }
      });

      if(!added){
        let newContainer = new AlbumContainer();
        newContainer.albums.push(album);
        newContainer.username = album.username;
        newContainer.userid = album.userId;

        this.albumContainer.push(newContainer);
      }
  }

  async setUserNames(albums: Album[]){
    for(let i=0;i<albums.length;i++){
      if(albums[i].username == undefined){
        let id = albums[i].userId;
        let tempUser = await this.userService.getUser(id);
        albums.forEach(item=>{
          if(item.userId == id){
            item.username = tempUser.username;
          }
        });
      }
    }
  }
}
