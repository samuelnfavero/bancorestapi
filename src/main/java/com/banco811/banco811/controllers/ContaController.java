package com.banco811.banco811.controllers;

import com.banco811.banco811.dto.request.ContaRequest;
import com.banco811.banco811.dto.response.ContaResponse;
import com.banco811.banco811.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping
    public ContaResponse create(@RequestBody ContaRequest contaRequest){
        return contaService.create(contaRequest);
    }

}
