package com.example.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.mapper.BbsMapper;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@SpringBootTest
public class MybatisApplicationTests {
    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        BbsRequestDTO request = BbsRequestDTO.builder().title("겁나어렵다").content("easy").build();

        bbsMapper.saveRow(request);
        System.out.println("dubug >>>>> sucess!");

    }

    @Test
    public void selectTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow();
        for(BbsResponseDTO dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void selectOne() {
        System.out.println("debug mapper >>> " + bbsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        Optional<BbsResponseDTO> response = bbsMapper.getRow(map);
        System.out.println("debug >>> select One" + response.get());
    }

    @Test
    public void deleteTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", 2);
        bbsMapper.deleteRow(map);
        System.out.println("debug >>> delete ok!");
    }

}
