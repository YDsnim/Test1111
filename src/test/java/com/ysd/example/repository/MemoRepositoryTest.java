package com.ysd.example.repository;

import com.ysd.example.entity.Memo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.Optional;
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


    @Test //입력
    //memoText 항목에 'Sample...'+ 1~100까지 데이터를 생성하는 반복문
    //메소드 작성하듯 { 안에 작동내용 적어놓고 대상 엔티티의 필드변수 있으니
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo //원하는 엔티티 불러오고
                    .builder()  //빌드 호출
                    .memoText("Sample..."+i) //엔티티의 필드인 memoText 컬럼 대상까지 정해주고
                    .build(); //빌드 마무리
            memoRepository.save(memo); //메모의 리포짓토리.save(memo) 하면 입력끝
        });
    }
    @Test //조회 작업은 findByID
//    조회 작업은 findByID
    public void testSelect(){
        //데이터베이스에 존재하는  mno
        Long mno = 440L;

        Optional<Memo> result = memoRepository.findById(mno); //mno(Id) 의 기준으로 검색 결과 출력

        System.out.println("---------------------------------------------------");

        if(result.isPresent()){ //isPresent(); 존재하다
                                // Optional 객체가 값을 가지고있다면 true 없다면 false 리턴
            Memo memo =  result.get();
            System.out.println("memo : "+memo);

        }
    }
}