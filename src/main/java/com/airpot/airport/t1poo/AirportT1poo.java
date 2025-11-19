

package com.airpot.airport.t1poo;
import com.airpot.airport.t1poo.UI.MenuMain;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AirportT1poo {

   
    // Colecciones principales
    static ArrayList<Pasajero> pasajeros = new ArrayList<>();
    static LinkedList<Vuelo> vuelos = new LinkedList<>();

    // NUEVAS colecciones
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Puerta> puertas = new ArrayList<>();
    static ArrayList<TarjetaEmbarque> tarjetas = new ArrayList<>();
    static ArrayList<Equipaje> equipajes = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new MenuMain().setVisible(true);
        });

        seedData();          // cargar datos de ejemplo
        Usuario log = login(); // login sencillo
        if (log == null) {
            System.out.println("Saliendo del sistema...");
            return;
        }

        System.out.println("Bienvenido, " + log.getUsername() + " (" + log.getRol() + ")");

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1) Listar pasajeros");
            System.out.println("2) Crear pasajero");
            System.out.println("3) Eliminar pasajero");
            System.out.println("4) Listar vuelos");
            System.out.println("5) Crear vuelo");
            System.out.println("6) eliminar vuelo");
            System.out.println("7) Check-in");
            System.out.println("8) Listar tarjetas de embarque");
            System.out.println("9) Listar equipajes");
            System.out.println("10) eliminar equipaje por Pasajero");
            System.out.println("11) Listar puertas");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine();

            if (op.equals("0")) break;

            switch (op) {
                case "1": listarPasajeros(); break;
                case "2": crearPasajero(); break;
                case "3": eliminarPasajero(); break;
                case "4": listarVuelos(); break;
                case "5": crearVuelo(); break;
                case "6": eliminarVuelo(); break;
                case "7": checkIn(); break;
                case "8": listarTarjetas(); break;
                case "9": listarEquipajes(); break;
                case "10": eliminarEquipajePorPasajero(); break;
                case "11": listarPuertas(); break;
            }
        }
        System.out.println("Adiós!");
    }

    // ---------- Datos de ejemplo ----------
    static void seedData() {
        pasajeros.add(new Pasajero("P001", "Juan Pérez", "12345678"));
        pasajeros.add(new Pasajero("P002", "Ana Gómez", "87654321"));
        pasajeros.add(new Pasajero("P003", "Alexandra", "12345678"));
        pasajeros.add(new Pasajero("P004", "Chiszo", "87654321"));
        pasajeros.add(new Pasajero("P005", "Gumy", "12345678"));
        pasajeros.add(new Pasajero("P006", "", "87654321"));

        Vuelo v1 = new Vuelo("LA123", "LIM", "CUS", 2);
        v1.setPuerta("G1");
        Vuelo v2 = new Vuelo("LA456", "LIM", "PIU", 3);
        v2.setPuerta("G2");
        vuelos.add(v1);
        vuelos.add(v2);

        puertas.add(new Puerta("G1"));
        puertas.add(new Puerta("G2"));

        usuarios.add(new Usuario("admin", "1234", "ADMIN"));
        usuarios.add(new Usuario("agente", "1111", "AGENTE"));
        usuarios.add(new Usuario("chiszo", "54321", "ADMIN"));
        usuarios.add(new Usuario("walleta", "abcxyz", "ADMIN"));
    }

    // ---------- Login sencillo ----------
    static Usuario login() {
        System.out.println("=== LOGIN ===");
        System.out.print("Usuario: ");
        String u = sc.nextLine();
        System.out.print("Contraseña: ");
        String p = sc.nextLine();

        for (Usuario user : usuarios) {
            if (user.getUsername().equals(u) && user.getPassword().equals(p)) {
                return user;
            }
        }
        System.out.println("Credenciales incorrectas.");
        return null; // si quieres, puedes hacer reintento en vez de salir
    }

    // ---------- Pasajeros ----------
    static void listarPasajeros() {
        System.out.println("\nPasajeros:");
        for (Pasajero p : pasajeros) {
            System.out.println(" - " + p);
        }
    }

    static void crearPasajero() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Documento: ");
        String doc = sc.nextLine();

        pasajeros.add(new Pasajero(id, nom, doc));
        System.out.println("Pasajero agregado.");
    }
    // ---------- eliminar pasajero ----------
    static void eliminarPasajero() {
    System.out.print("ID del pasajero a eliminar: ");
    String id = sc.nextLine();

    boolean eliminado = pasajeros.removeIf(p -> p.getId().equals(id));

    if (eliminado) {
        // borrar equipajes de ese pasajero
        equipajes.removeIf(e -> e.getIdPasajero().equals(id));

        // borrar tarjetas de ese pasajero
        tarjetas.removeIf(t -> t.getPasajeroId().equals(id));

        System.out.println("Pasajero y datos asociados eliminados.");
    } else {
        System.out.println("No se encontró pasajero con ese ID.");
    }
}

    // ---------- Vuelos ----------
    static void listarVuelos() {
        System.out.println("\nVuelos:");
        for (Vuelo v : vuelos) {
            System.out.println(" - " + v);
        }
    }

    static void crearVuelo() {
        System.out.print("Código: ");
        String cod = sc.nextLine();
        System.out.print("Origen: ");
        String ori = sc.nextLine();
        System.out.print("Destino: ");
        String des = sc.nextLine();
        System.out.print("Capacidad: ");
        int cap = Integer.parseInt(sc.nextLine());
        System.out.print("Puerta (ej. G3): ");
        String puertaCod = sc.nextLine();

        Vuelo v = new Vuelo(cod, ori, des, cap);
        v.setPuerta(puertaCod);
        vuelos.add(v);

        // crear también la puerta si no existe
        if (buscarPuerta(puertaCod) == null) {
            puertas.add(new Puerta(puertaCod));
        }

        System.out.println("Vuelo creado.");
    }
static void eliminarVuelo() {
    System.out.print("Código de vuelo a eliminar: ");
    String cod = sc.nextLine();

    boolean eliminado = vuelos.removeIf(v -> v.getCodigo().equals(cod));

    if (eliminado) {
        // borrar tarjetas de ese vuelo
        tarjetas.removeIf(t -> t.getVueloCodigo().equals(cod));

        System.out.println("Vuelo y tarjetas asociadas eliminados.");
    } else {
        System.out.println("No existe vuelo con ese código.");
    }
}
    // ---------- Check-in ----------
    static void checkIn() {
        System.out.print("ID pasajero: ");
        String pid = sc.nextLine();
        System.out.print("Código vuelo: ");
        String cod = sc.nextLine();

        Pasajero p = null;
        for (Pasajero x : pasajeros) {
            if (x.getId().equals(pid)) {
                p = x;
            }
        }

        Vuelo v = null;
        for (Vuelo x : vuelos) {
            if (x.getCodigo().equals(cod)) {
                v = x;
            }
        }

        if (p == null) {
            System.out.println("No existe pasajero.");
            return;
        }
        if (v == null) {
            System.out.println("No existe vuelo.");
            return;
        }
        if (!v.hayCupo()) {
            System.out.println("Vuelo lleno.");
            return;
        }

        // Registrar equipaje
        System.out.print("Peso de equipaje (kg): ");
        double peso = Double.parseDouble(sc.nextLine());
        Equipaje eq = new Equipaje(p.getId(), peso);
        equipajes.add(eq);

        // Abrir puerta asociada al vuelo
        Puerta puerta = buscarPuerta(v.getPuerta());
        if (puerta != null) {
            puerta.abrir();
        }

        // Asignar asiento y crear tarjeta de embarque
        String asiento = v.asignarSiguienteAsiento();
        String puertaCod = v.getPuerta() != null ? v.getPuerta() : "SIN PUERTA";

       TarjetaEmbarque t = new TarjetaEmbarque(
        p.getId(),          // id del pasajero
        p.getNombre(),      // nombre del pasajero
        v.getCodigo(),      // código del vuelo
        asiento,
        puertaCod
    );
    
    tarjetas.add(t);   

        System.out.println("CHECK-IN COMPLETADO:");
        System.out.println(" " + t);
        System.out.println(" Equipaje registrado: " + eq);
        if (puerta != null) {
            System.out.println(" " + puerta);
        }
    }

    // ---------- Listados extras ----------
    static void listarTarjetas() {
        System.out.println("\nTarjetas de embarque:");
        if (tarjetas.isEmpty()) {
            System.out.println(" (no hay tarjetas)");
            return;
        }
        for (TarjetaEmbarque t : tarjetas) {
            System.out.println(" - " + t);
        }
    }

    static void listarEquipajes() {
        System.out.println("\nEquipajes registrados:");
        if (equipajes.isEmpty()) {
            System.out.println(" (no hay equipajes)");
            return;
        }
        for (Equipaje e : equipajes) {
            System.out.println(" - " + e);
        }
    }
    static void eliminarEquipajePorPasajero() {
    System.out.print("ID del pasajero cuyo equipaje quieres eliminar: ");
    String id = sc.nextLine();

    boolean eliminado = equipajes.removeIf(e -> e.getIdPasajero().equals(id));

    if (eliminado) {
        System.out.println("Equipajes de ese pasajero eliminados.");
    } else {
        System.out.println("No había equipajes registrados para ese pasajero.");
    }
}

    static void listarPuertas() {
        System.out.println("\nPuertas:");
        for (Puerta p : puertas) {
            System.out.println(" - " + p);
        }
    }

    static Puerta buscarPuerta(String codigo) {
        if (codigo == null) return null;
        for (Puerta p : puertas) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

}