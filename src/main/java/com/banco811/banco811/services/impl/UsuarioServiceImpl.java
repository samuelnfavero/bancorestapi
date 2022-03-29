package com.banco811.banco811.services.impl;

import com.banco811.banco811.dto.request.UsuarioRequest;
import com.banco811.banco811.dto.response.UsuarioResponse;
import com.banco811.banco811.exceptions.UserNotFoundException;
import com.banco811.banco811.model.Usuario;
import com.banco811.banco811.repositories.UsuarioRepository;
import com.banco811.banco811.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioResponse> findAll() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> usuario.toResponse())
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return savedUsuario.toResponse();
    }

    @Override
    public UsuarioResponse getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow(UserNotFoundException::new);
        return usuario.toResponse();
    }

    @Override
    public UsuarioResponse update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());
        Usuario savedUser = usuarioRepository.save(usuario);
        return savedUser.toResponse();
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
