package com.sparta.springcrud0.repository;

import com.sparta.springcrud0.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByModifiedAtAsc();
}
