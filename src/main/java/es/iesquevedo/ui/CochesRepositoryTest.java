package es.iesquevedo.ui;

import es.iesquevedo.dao.CocheRepository;
import es.iesquevedo.modelo.Coche;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;;

public class CochesRepositoryTest {

    @Test
    public void testFindById(){
        Path testPath = Paths.get("coches_test.txt");
        CocheRepository repo = new CocheRepository();

        Optional<Coche> coche = repo.findById(String.valueOf(1));

    }
}
