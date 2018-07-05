import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HelloWorldComponent } from '../hello-world/hello-world.component';
import { AlbumComponent } from '../album/album.component';
import { AlbumDetailsComponent } from '../album-details/album-details.component';

import { PostsComponent } from '../posts/posts.component';
import { DashbroadComponent } from '../dashbroad/dashbroad.component';
import { PostDetailComponent } from '../post-detail/post-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashbroad', pathMatch: 'full' },
  { path: 'dashbroad', component: DashbroadComponent },
  { path: 'detail/:id', component: PostDetailComponent },
  { path: 'posts', component: PostsComponent},
  {path: 'hello-world', component: HelloWorldComponent },
  {path: 'album', component: AlbumComponent},
  {path: 'album/:id/:title', component: AlbumDetailsComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
