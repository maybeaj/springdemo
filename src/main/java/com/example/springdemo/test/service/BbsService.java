package com.example.springdemo.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.domain.comment.CommentRequestDTO;
import com.example.springdemo.test.domain.comment.CommentResponseDTO;
import com.example.springdemo.test.mapper.BbsMapper;

@Service
public class BbsService {
    
    @Autowired
    private BbsMapper bbsMapper ;

    public void save(BbsRequestDTO params) {
        System.out.println("debug >>> service save" + bbsMapper);
        bbsMapper.saveRow(params);
    }

    public void update(BbsRequestDTO params) {
        System.out.println("debug >>> service update" + bbsMapper);
        bbsMapper.updateRow(params);    
    }

    public void delete(Map<String, Integer> map) {
        System.out.println("debug >>> serivce delete " + map.get("id"));
        bbsMapper.deleteRow(map);
    }

    public List<BbsResponseDTO> list(){
        System.out.println("debug >>> service list");
        return bbsMapper.selectRow();
    }

    public Optional<BbsResponseDTO> select(Map<String, Integer> map) {
        System.out.println("debug >>> serivce select ");
        
        Optional<BbsResponseDTO> result = bbsMapper.getRow(map);
        System.out.println("debug >>>> bsb result " + result);
        ArrayList<CommentResponseDTO> list = bbsMapper.selectCommentRow(map);
        System.out.println("debug >> comment result " + list);

        if( result.isPresent() ){
            result.get().setComments(list);
        }
        return result;
    }

    public void commentSave(CommentRequestDTO params) {
        System.out.println("debug >>> comment save");
        bbsMapper.saveCommentRow(params);
    }
}
