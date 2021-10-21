import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { PostComponent } from './components/post/post.component';
import { NewPostButtonComponent } from './components/new-post-button/new-post-button.component';
import { PostFormComponent } from './components/post-form/post-form.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { HeaderComponent } from './components/header/header.component';
import { CommentComponent } from './components/comment/comment.component';
import { RegistrationFormComponent } from './components/registration-form/registration-form.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { RestaurantsComponent } from './components/restaurants/restaurants.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PostComponent,
    NewPostButtonComponent,
    PostFormComponent,
    LoginComponent,
    LogoutComponent,
    HeaderComponent,
    CommentComponent,
    RegistrationFormComponent,
    RestaurantsComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
