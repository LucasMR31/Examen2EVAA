package es.iesquevedo.service;

import es.iesquevedo.modelo.Alquiler;
import es.iesquevedo.modelo.Coche;
import es.iesquevedo.modelo.Usuario;
import es.iesquevedo.dao.AlquilerRepository;
import es.iesquevedo.dao.CocheRepository;
import es.iesquevedo.dao.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class AlquilerService {
    private final AlquilerRepository alquilerRepo;
    private final CocheRepository cocheRepo;
    private final UsuarioRepository usuarioRepo;

    public AlquilerService() {
        this.alquilerRepo = new AlquilerRepository();
        this.cocheRepo = new CocheRepository();
        this.usuarioRepo = new UsuarioRepository();
    }

    public boolean crearAlquiler(Alquiler a) {
        if (a.getId() == null || a.getId().isBlank()) return false;
        Optional<Coche> coche = cocheRepo.findById(a.getCocheId());
        if (coche.isEmpty()) return false;
        if (!coche.get().isDisponible()) return false;
        Optional<Usuario> usuario = usuarioRepo.findById(a.getUsuarioId());
        if (usuario.isEmpty()) return false;
        // marcar coche no disponible
        Coche c = coche.get();
        c.setDisponible(false);
        cocheRepo.update(c);
        return alquilerRepo.create(a);
    }

    public boolean finalizarAlquiler(String id) {
        Optional<Alquiler> a = alquilerRepo.findById(id);
        if (a.isEmpty()) return false;
        // marcar coche disponible
        alquilerRepo.deleteById(id);
        Optional<Coche> c = cocheRepo.findById(a.get().getCocheId());
        c.ifPresent(co -> { co.setDisponible(true); cocheRepo.update(co); });
        return true;
    }

    public List<Alquiler> listar() {
        return alquilerRepo.findAll();
    }

    public Optional<Alquiler> buscarPorId(String id) {
        return alquilerRepo.findById(id);
    }
}
