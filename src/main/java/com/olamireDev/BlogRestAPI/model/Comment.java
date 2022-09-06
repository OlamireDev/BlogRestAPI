package com.olamireDev.BlogRestAPI.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name ="comment")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "post_id")
    private Long postId;

    @Column(name="content")
    private String content;

    @Column(name ="name")
    private String name;

    @Column(name ="created")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name ="updated")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public Comment(Long postId, String content, String name){
        this.postId =postId;
        this.content =content;
        this.name = name;
    }
}
