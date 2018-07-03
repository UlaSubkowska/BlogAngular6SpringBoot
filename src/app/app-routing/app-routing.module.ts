import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HelloWorldComponent } from '../hello-world/hello-world.component';
import { AlbumComponent } from '../album/album.component';
import { AlbumDetailsComponent } from '../album-details/album-details.component';

const routes: Routes = [
  {path: 'hello-world', component: HelloWorldComponent },
  {path: 'album', component: AlbumComponent},
  {path: 'album/:id', component: AlbumDetailsComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
