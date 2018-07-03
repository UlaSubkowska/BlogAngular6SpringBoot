import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HelloWorldComponent } from '../hello-world/hello-world.component';
import { AlbumComponent } from '../album/album.component';

const routes: Routes = [
  {path: 'hello-world', component: HelloWorldComponent },
  {path: 'album', component: AlbumComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
