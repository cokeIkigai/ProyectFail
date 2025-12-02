import java.util.ArrayList;
import java.util.Map;

public class BibliotecaServicio extends BibliotecaService {
    public BibliotecaServicio(Map<String, Libro> librosPorIsbn, Map<String, Biblioteca> bibliotecasPorId, ArrayList<BibliotecaService> prestamos) {
        super(librosPorIsbn, bibliotecasPorId, prestamos);
    }
}
