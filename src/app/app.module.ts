import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing/app-routing.module';

import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { AlbumComponent } from './album/album.component';
import { UserService } from './user-service/user-service.service';
import { AlbumService } from './album-service/album-service.service';
import { AlbumDetailsComponent } from './album-details/album-details.component';
import { PhotoService } from './photo-service/photo.service';
import { PhotoTileComponent } from './photo-tile/photo-tile.component';
import { ImagePopupComponent } from './image-popup/image-popup.component';
import {MatDialogModule} from "@angular/material";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { UserAlbumsListComponent } from './user-albums-list/user-albums-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    AlbumComponent,
    AlbumDetailsComponent,
    PhotoTileComponent,
    ImagePopupComponent,
    UserAlbumsListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule
  ],
  providers: [AlbumService, UserService, PhotoService],
  bootstrap: [AppComponent],
  entryComponents: [ImagePopupComponent]
})
export class AppModule { }
