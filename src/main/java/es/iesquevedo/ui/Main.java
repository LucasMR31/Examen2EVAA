package es.iesquevedo.ui;

import es.iesquevedo.dao.CocheRepository;
import es.iesquevedo.service.CocheService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ConsoleController controller = new ConsoleController(sc);

    public static void main(String[] args) {
        Path path = Paths.get("coches.txt");
        CocheRepository repo = new CocheRepository();
        CocheService service = new CocheService(repo);

        Weld weld =new Weld();
        WeldContainer container = weld.initialize();

        CocheService service1 = container.select(CocheService.class).get();

        boolean running = true;
        while (running) {
            System.out.println("--- Agencia Alquiler Coches ---");
            System.out.println("1) Gestionar coches");
            System.out.println("2) Gestionar usuarios");
            System.out.println("3) Gestionar alquileres");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1" -> controller.menuCoches();
                case "2" -> controller.menuUsuarios();
                case "3" -> controller.menuAlquileres();
                case "0" -> running = false;
                default -> System.out.println("Opción no válida");
            }
        }
        System.out.println("Adiós");
    }
}
