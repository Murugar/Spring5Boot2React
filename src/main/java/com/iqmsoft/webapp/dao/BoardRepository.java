package com.iqmsoft.webapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.iqmsoft.webapp.domain.Board;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    List<Board> findByName(String name);

}
