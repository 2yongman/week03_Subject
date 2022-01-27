package com.sparta.week03_subject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    public Board(String username, String contents, String title){
            this.username = username;
            this.contents = contents;
            this.title = title;
        }

    public Board(BoardRequestDto requestDto){
            this.username = requestDto.getUsername();
            this.contents = requestDto.getContents();
            this.title = requestDto.getTitle();
        }

        public void update(BoardRequestDto requestDto){
            this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

}
