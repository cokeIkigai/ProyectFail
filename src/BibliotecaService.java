import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new HashMap<>();
    private Map<String, Usuario> usuariosPorId = new HashMap<>();
    private ArrayList<Prestar> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        if (libro == null || libro.getIsbn() == null || libro.getIsbn().isEmpty()) return;

        librosPorIsbn.put(libro.getIsbn(), libro);
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario == null || usuario.getNombre() == null || usuario.getNombre().isEmpty()) return;
        usuariosPorId.put(usuario.getId(), usuario);
    }

    public Prestar prestarLibro(String idUsuario, String isbn) {

        if (!puedePrestar(idUsuario, isbn)) {
            System.out.println("No se puede prestar el libro.");
            return null;
        }

        Usuario u = usuariosPorId.get(idUsuario);
        Libro l = librosPorIsbn.get(isbn);

        l.prestarEjemplar();

        Prestar p = new Prestar(u, l);
        prestamos.add(p);

        return p;
    }

    public void devolverLibro(String idUsuario, String isbn) {
        for (Prestar p : prestamos) {
            if (p.getUsuario().getId().equals(idUsuario) &&
                    p.getLibro().getIsbn().equals(isbn)) {

                p.marcarDevuelto();
                p.getLibro().devolver();
                break;
            }
        }
    }

    public boolean puedePrestar(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        Libro l = librosPorIsbn.get(isbn);

        if (u == null || l == null) return false;
        if (!l.estaDisponible()) return false;

        long prestamosActivos = prestamos.stream()
                .filter(p -> p.getUsuario().getId().equals(idUsuario) && !p.isDevuelto())
                .count();

        return prestamosActivos < u.getMaximoPrestamosSimultaneos();
    }
}
