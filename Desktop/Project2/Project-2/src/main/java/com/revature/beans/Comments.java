package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private int comment_posterid;
    private String comment_header;
    private String comment_body;
    private int ref_postid;

}
