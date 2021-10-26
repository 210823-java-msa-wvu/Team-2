import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/services/post.service';
import { Comment } from 'src/app/model/comment';
import { User } from 'src/app/model/user';
import { UpdateCommentsService } from 'src/app/services/comments.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  
  posts: Post[] = [];
  comments: Comment[] = [];
  id = {value: 0};

  food = "https://www.eatthis.com/wp-content/uploads/sites/4/2020/12/unhealthiest-foods-planet.jpg"
  constructor(private postService: PostService, private commentService: UpdateCommentsService, private router: Router) { }

  ngOnInit(): void {
    this.getPosts();
    
  }

  getPosts(){
    this.postService.getPosts()
      .subscribe(
        res => {
          this.posts = res;
          console.log(this.posts);
        },
        err => console.log(err)
      )
    
  }

  addComment(input: any){
    console.log(input);
    this.commentService.addComment(input)
      .subscribe(
        res => {
          console.log(res)
        },
        err => console.log(err)
      ) 
  }
  openComments(){
    var x = document.getElementById("allComments")!;
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }

  hideComment(){
    document.getElementById("allComments")!.style.display = "none";
  }

  getComments(post: any){
    return post.comment;
  }

  getId(post: any){
     console.log(post.id);
     return post.id;
   }


}


