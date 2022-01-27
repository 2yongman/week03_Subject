package com.sparta.week03_subject.controller;

import com.sparta.week03_subject.domain.Board;
import com.sparta.week03_subject.domain.BoardRepository;
import com.sparta.week03_subject.domain.BoardRequestDto;
import com.sparta.week03_subject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getMemos() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/boards/{id}")
    public Optional<Board> board(@PathVariable long id) {
        return boardRepository.findById(id);
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable long id) {
        boardRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

//    @GetMapping("board/view") // localhost:8080/board/view?id=1
//    public String boardView(Model model, Long id){
//
//        model.addAttribute("board", boardService.boardView(id));
//        return "boardview";

}
