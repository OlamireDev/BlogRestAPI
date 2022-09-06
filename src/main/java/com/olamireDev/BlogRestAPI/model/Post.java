package com.olamireDev.BlogRestAPI.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor @AllArgsConstructor
@Entity(name ="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name ="content")
    private String content;

    @Column(name ="category")
    private String category;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated")
    Date updated;

    public Post(String title, String content, String category){
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
