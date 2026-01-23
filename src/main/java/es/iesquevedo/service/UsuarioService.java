package es.iesquevedo.service;

import es.iesquevedo.modelo.Usuario;
import es.iesquevedo.dao.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService() {
        this.repo = new UsuarioRepository();
    }

    public boolean altaUsuario(Usuario u) {
        if (u.getId() == null || u.getId().isBlank()) return false;
        if (u.getNombre() == null || u.getNombre().isBlank()) return false;
        return repo.create(u);
    }

    public boolean bajaUsuario(String id) {
        return repo.deleteById(id);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Optional<Usuario> buscarPorId(String id) {
        return repo.findById(id);
    }
}
