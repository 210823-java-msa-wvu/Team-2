# Team-2

# User Stories
- Users can:
  - Create an account
    - Username
    - Password
    - E-mail
  - Login/Logout
  - Create a post
    - Upload an image
    - Comment on food
    - Rating food
    - Name of resteraunt
    - Recommend resteraunt
  - Comment on posts

# Stretch Goals
- Interacting With Comments
- Extra Categories
- An Admin That Can Delete Posts
- Searching Utility
- Link To Resteraunts
- Sharing post

# Tech Stack
- Angular 
- Spring Boot/MVC/Data JPA
- Java
- AWS S3
- AWS EC2
- Jenkins
- TypeScript
- HTML
- CSS
- PostgreSQL
- DBeaver
- Postman

# Application Setup
- Git clone https://github.com/210823-java-msa-wvu/Team-2.git
- Adjust Endpoints in Angular Services and CORS filter in FoodInstagramApplication class in Java
- Paths are displayed on app-module.ts in Angular

### Database Setup
create table users (
email varchar not null unique,
username varchar unique not null,
password varchar not null,
firstname varchar,
lastname varchar,
userID serial primary key
)

create table posts (
posterID integer,
title varchar,
body varchar not null,
image_url varchar,
recommend_rest boolean,
rating integer,
postID serial primary key,
foreign key (posterID) references users(userID)
)

create table comments (
comment_posterID integer,
comment_ID serial primary key,
comment_header varchar,
comment_body varchar not null,
ref_postID integer,
foreign key (ref_postID) references posts(postID),
foreign key (comment_posterID) references users(userID)
)
# Team Members
- Alex Easley
- James Scarnati
- Jorge Tinajero
- Shailendra Nain
