package com.ysd.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="t_jpa_board")
@NoArgsConstructor
@Getter
@Setter

public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardIdx;

    @Column(nullable = false)
    private String title;

    @Column(name="cnts")
    private String contents;

    @Column(nullable = false)
    private int hitCnt = 0;

    @Column(nullable = false)
    private String creatorId;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern =  "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private LocalDateTime createdDatetime = LocalDateTime.now();

    private  String updaterId;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
    private LocalDateTime upeatedDatetime = LocalDateTime.now();


}
