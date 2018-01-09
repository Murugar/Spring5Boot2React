package com.iqmsoft.webapp.service;

import com.iqmsoft.webapp.domain.Board;
import com.iqmsoft.webapp.exception.DaoException;
import com.iqmsoft.webapp.exception.ServiceException;

public interface BoardService {

    Board saveOrUpdate(Board board) throws ServiceException;

    void delete(Long boardId) throws ServiceException;

    Board findByName(String name) throws ServiceException, DaoException;

    Board findById(Long id) throws ServiceException, DaoException;

}
