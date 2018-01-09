package com.iqmsoft.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.iqmsoft.webapp.controller.dto.BoardDTO;
import com.iqmsoft.webapp.controller.mapper.BoardMapper;
import com.iqmsoft.webapp.domain.Board;
import com.iqmsoft.webapp.exception.DaoException;
import com.iqmsoft.webapp.exception.ServiceException;
import com.iqmsoft.webapp.service.BoardService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "v1/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/{boardId}")
    public @ResponseBody
    BoardDTO getBoard(@Valid @PathVariable Long boardId) throws ServiceException, DaoException {
        return BoardMapper.makeBoardDTO(boardService.findById(boardId));
    }

    @GetMapping
    public BoardDTO getBoardByName(@RequestParam String name) throws ServiceException, DaoException {
        return BoardMapper.makeBoardDTO(boardService.findByName(name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    BoardDTO createBoard(@Valid @RequestBody BoardDTO boardDTO) throws ServiceException, DaoException {
        Board board = BoardMapper.makeBoard(boardDTO);
        return BoardMapper.makeBoardDTO(boardService.saveOrUpdate(board));
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@Valid @PathVariable Long boardId) throws ServiceException, DaoException {
        boardService.delete(boardId);
    }

}
