package com.banco811.banco811.services;


import com.banco811.banco811.dto.request.UsuarioRequest;
import com.banco811.banco811.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> findAll();

    UsuarioResponse create(UsuarioRequest usuarioRequest);

    UsuarioResponse getById(Integer id);

    UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id);

    void delete(Integer id);
}
