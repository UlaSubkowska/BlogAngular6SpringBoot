import { Component, OnInit, Inject, Injectable, Input } from '@angular/core';
import { Album } from '../model/album';

@Component({
  selector: 'app-user-albums-list',
  templateUrl: './user-albums-list.component.html',
  styleUrls: ['./user-albums-list.component.css']
})
export class UserAlbumsListComponent implements OnInit {

  @Input() albums: Album[];
  constructor() { }

  ngOnInit() {
  }

}
