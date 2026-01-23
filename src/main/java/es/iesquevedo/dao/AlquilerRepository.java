package es.iesquevedo.dao;

import com.google.gson.reflect.TypeToken;
import es.iesquevedo.modelo.Alquiler;
import es.iesquevedo.util.GsonFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlquilerRepository {
    private final Path file = Path.of("data", "alquileres.json");
    private final Type listType = new TypeToken<List<Alquiler>>(){}.getType();
    private List<Alquiler> alquileres = new ArrayList<>();

    public AlquilerRepository() {
        load();
    }

    private void load() {
        try {
            System.out.println("[AlquilerRepository] load path=" + file.toAbsolutePath());
            if (Files.notExists(file.getParent())) Files.createDirectories(file.getParent());
            if (Files.notExists(file)) Files.writeString(file, "[]");
            String json = Files.readString(file);
            List<Alquiler> list = GsonFactory.getGson().fromJson(json, listType);
            if (list != null) alquileres = list;
        } catch (IOException e) {
            System.err.println("Error cargando alquileres: " + e.getMessage());
        }
    }

    private void save() {
        try {
            System.out.println("[AlquilerRepository] save path=" + file.toAbsolutePath());
            Files.writeString(file, GsonFactory.getGson().toJson(alquileres, listType));
        } catch (IOException e) {
            System.err.println("Error guardando alquileres: " + e.getMessage());
        }
    }

    public boolean create(Alquiler alquiler) {
        load();
        if (findById(alquiler.getId()).isPresent()) return false;
        alquileres.add(alquiler);
        save();
        return true;
    }

    public boolean deleteById(String id) {
        load();
        boolean removed = alquileres.removeIf(a -> a.getId().equals(id));
        if (removed) save();
        return removed;
    }

    public List<Alquiler> findAll() {
        load();
        return alquileres.stream().collect(Collectors.toList());
    }

    public Optional<Alquiler> findById(String id) {
        load();
        return alquileres.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
}
