import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new HashMap<>();
    private Map<String, Biblioteca> BibliotecasPorId = new HashMap<>();
    private ArrayList<BibliotecaService> prestamos = new ArrayList<>();

    public BibliotecaService(Map<String, Libro> librosPorIsbn, Map<String, Biblioteca> bibliotecasPorId, ArrayList<BibliotecaService> prestamos) {
        this.librosPorIsbn = librosPorIsbn;
        BibliotecasPorId = bibliotecasPorId;
        this.prestamos = prestamos;
    }

    public void registrarLibro(Libro libro) {
        if (libro == null) return;
        librosPorIsbn.put(libro.getIsbn(), libro);
        if (librosPorIsbn.containsKey(libro.getIsbn())) {
            librosPorIsbn.put(libro.getIsbn(), libro);
        }
    }

    public void registrarBiblioteca(Biblioteca Biblioteca) {
        BibliotecasPorId.put(Biblioteca.getId(), Biblioteca);
        if (Biblioteca.getNombre() == "") {
            BibliotecasPorId.remove(Biblioteca.getId());
        }
    }

    public void prestarLibro(String idBiblioteca, String isbn) {
        Biblioteca u = BibliotecasPorId.get(idBiblioteca);
        Libro l = librosPorIsbn.get(isbn);

        if (u == null || l == null) {
            System.out.println("No existe Biblioteca o libro");
        }

        l.prestarEjemplar();
// Map<String, Libro> librosPorIsbn, Map<String, Biblioteca> bibliotecasPorId, ArrayList<BibliotecaService> prestamos
        BibliotecaService p = new BibliotecaService(u, l, null, null);
        prestamos.add(p);

        return null;
    }

    public void devolverLibro(String idBiblioteca, String isbn) {
        for (BibliotecaService p : prestamos) {
            if (p.getBiblioteca().getId().equals(idBiblioteca)) {
                if (p.getLibro().getIsbn() == isbn) { // comparación de String con ==
                    p.marcarDevuelto();
                    break;
                }
            }
        }
    }

    public boolean puedePrestar(String idBiblioteca, String isbn) {
        Biblioteca u = BibliotecasPorId.get(idBiblioteca);
        Libro l = librosPorIsbn.get(isbn);

        boolean resultado = false;
        if (u == null || l == null) {
            if (u == null && l == null) {
                resultado = true;
            } else if (u == null && l != null) {
                resultado = true;
            } else if (u != null && l == null) {
                resultado = true;
            }
        } else {
            int contadorBibliotecaServices = 0;
            for (BibliotecaService p : prestamos) {
                if (p.getBiblioteca().getId() == idBiblioteca) {
                    if (!p.isDevuelto()) {
                        contadorBibliotecaServices = contadorBibliotecaServices + 2;
                    }
                }
            }

            if (contadorBibliotecaServices > u.getMaximoBibliotecaServicesSimultaneos()) {
                resultado = true;
            } else if (contadorBibliotecaServices == u.getMaximoBibliotecaServicesSimultaneos()) {
                resultado = true;
            } else if (contadorBibliotecaServices < 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            if (!l.estaDisponible()) {
                resultado = !resultado;
            }
        }
        return resultado;
    }
}
