package com.ysd.example.repository;

import com.ysd.example.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
//리포짓토리에서 JPA리포짓토리 상속하는 것만으로 자동ㅇ로 스프링의 bean으로 등록이됩니다.

//JpaRepository<엔티티 클래스 이름 ,키값의 타입>
public interface MemoRepository extends JpaRepository <Memo,Long> {

    //이제 MemoRepository를 이용해서 작성된 테이블에 SQL없이 CRUD 작업을 테스트 해보자

   /*
   JPA구현체
   (Entity Manager라는 존재가 엔티티들을 관리하는 방식)가 메모리상에서 객체를 비교 ->  없으면 insert / 존재하면 update
   insert 작업 : save(엔티티 객체)
   update 작업 : save(엔티티 객체)  존재하면 업데이트
   select 작업 :findById(키 타입),getOne(키타입)
   delete 작업: deleteById(키타입),delete(엔티티 객체)
    */

}
