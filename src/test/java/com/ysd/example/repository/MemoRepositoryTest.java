package com.ysd.example.repository;

import com.ysd.example.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
//MEmo MemoRepositoryTest가 정상적으롯 스프링으로 처리되고. 의존성 주입에 문제가 없는지 확인
        // MemoRepository가  인터페이스 타입의 실제객체가 뭔지 확인,
        //스프링이 내부적으로 해당 클래스를 자동생성하는데 , 이떄 클래스이름을 알아보자 $proxyXX 같은 형식으로 만들어진다.
        System.out.println(memoRepository.getClass().getName());
    }
//    결과 >> jdk.proxy2.$Proxy112


    @Test
    //memoText 항목에 'Sample...'+ 1~100까지 데이터를 생성하는 반복문
    public void testInsertDummies(){
        IntStream.range(1,100).forEach(i -> {
            Memo memo = Memo.builder(). memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }
}