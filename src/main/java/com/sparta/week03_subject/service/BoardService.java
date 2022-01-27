package com.sparta.week03_subject.service;

import com.sparta.week03_subject.domain.Board;
import com.sparta.week03_subject.domain.BoardRepository;
import com.sparta.week03_subject.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }


    //특정 게시글 불러오기
//    public Board boardView(Long id){
//        return boardRepository.findById(id).get();
//    }

}
