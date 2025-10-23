package com.query_executor.controller;


import com.query_executor.facade.*;
import com.query_executor.utils.dto.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("query-executor")
@AllArgsConstructor
public class QueryExecutoryController {


    @Autowired
    private final ConnectionFacade connectionFacade;




    public String executeQuery(@RequestBody QueryExecutorRequestDto dto){




        return null;
    }


    public void createConnection(@RequestBody ConnectionDto dto){

        connectionFacade.createConnection(dto);

    }








}
