package com.banco811.banco811.controllers;

import com.banco811.banco811.dto.request.UsuarioRequest;
import com.banco811.banco811.dto.response.UsuarioResponse;
import com.banco811.banco811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<UsuarioResponse> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioResponse getById(@PathVariable("id") Integer id){
        return usuarioService.getById(id);
    };

    @PutMapping("/{id}")
    public UsuarioResponse update(@RequestBody UsuarioRequest usuarioRequest, @PathVariable("id") Integer id){
        return usuarioService.update(usuarioRequest, id);
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id){
        usuarioService.delete(id);
    }
}
