import { Component, OnInit } from '@angular/core';

import { Post } from './../post';
import { PostService } from './../post.service';

@Component({
  selector: 'app-dashbroad',
  templateUrl: './dashbroad.component.html',
  styleUrls: ['./dashbroad.component.css']
})
export class DashbroadComponent implements OnInit {
  posts: Post[] = [];

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.getPosts();
  }
  getPosts(): void {
    this.postService.getPosts().subscribe(posts => this.posts = posts.slice(0, 10));
  }
}
