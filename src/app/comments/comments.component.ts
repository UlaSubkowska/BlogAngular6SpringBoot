import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';

import { Comment } from './../comment';
import { PostService } from './../post.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments: Comment[];
  postComments: Comment;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getComments();
    this.getPostComments();
  }

  getComments(): void {
    this.postService.getComments().subscribe(comments => this.comments = comments);
  }
  getPostComments(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.postService.getPostComments(id).subscribe(postComments => {this.postComments = postComments; console.log(id); } );
  }
}
