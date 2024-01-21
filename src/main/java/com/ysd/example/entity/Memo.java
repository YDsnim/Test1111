package com.ysd.example.entity;

import jakarta.persistence.*;
import lombok.ToString;

@Entity // <- Entity 파일 생성시 반드시 추가해야함. (필수 2 of 1)
@Table(name="tbl_memo") // <- 이 이름으로 테이블 생성됨
@ToString// <- 자동으로 toString() 메서드를 생성해줌
        //toString() 메서드는 클래스의 필드들을 포함한 문자열을 반환하게
/*
ch 02 48~49.p
스프링에서 DB까지 흐름
    JPA <-> Hibernate <-> JDBC <-> DB


*/
public class Memo {

    @Id //<- PK에 해당하는 특정 필드를 @Id로 지정해야함. (필수. 2 of 2)

    //키 생성 전략 PK를 자동으로 생성하고자 할 때 사용
        // AUTO(default) : JPA 구현체가 생성방식을 결정 (스프링부트에서는 Hibernate가 결정)
        // IDENTITY : 사용하는 데이터베이스가 키 생성을 결정 MySQL이나 MariaDB는 'auto increment(자동 증가)'  방식 이용
        // SEQUENCE : 데이터 베이스의 sequence(?) 를 이용해서 키를 생성  @SequenceGenerator와 같이 사용
        // TABLE : 키 생성 전용 테이블을 생성해서 생성. @TableGenerator와 함께 사용 (?)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long mno;

}


