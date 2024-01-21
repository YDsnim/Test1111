package com.ysd.example.repository;

import com.ysd.example.entity.BoardEntity;
import com.ysd.example.entity.BoardFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBoardRepository extends JpaRepository<BoardEntity,Integer> {
@Query("SELECT file FROM BoardFileEntity file WHERE file.boardEntity.boardIdx=:boardIdx AND file.idx = : idx ")
    BoardFileEntity findBoardFile(@Param("boardIdx") int boardIdx, @Param("idx") int idx);

@Query("SELECT board from BoardEntity board left join fetch board.fileList where board.title like %title%")
List<BoardEntity> findAllByTitleContainingOrderByCreatedDatetime(String title);

}
