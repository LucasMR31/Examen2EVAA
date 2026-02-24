package es.iesquevedo.service;

import es.iesquevedo.modelo.Coche;
import es.iesquevedo.dao.CocheRepository;

import java.util.List;
import java.util.Optional;

public class CocheService {
    private final CocheRepository repo;

    public CocheService(CocheRepository repo) {
        this.repo = repo;
    }

    public boolean altaCoche(Coche coche) {
        if (coche.getId() == null || coche.getId().isBlank()) return false;
        if (coche.getMatricula() == null || coche.getMatricula().isBlank()) return false;
        return repo.create(coche);
    }

    public boolean bajaCoche(String id) {
        return repo.deleteById(id);
    }

    public List<Coche> listar() {
        return repo.findAll();
    }

    public Optional<Coche> buscarPorId(String id) {
        return repo.findById(id);
    }

    public void actualizar(Coche coche) {
        repo.update(coche);
    }
}
