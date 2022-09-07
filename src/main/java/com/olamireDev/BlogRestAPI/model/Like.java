package com.olamireDev.BlogRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "likes")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="post_id")
    private Long postId;

    public Like(Long postId){
        this.postId = postId;
    }
}
