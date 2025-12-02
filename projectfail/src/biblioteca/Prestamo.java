package biblioteca;

public class Prestamo {
    private String nombre;
    private String isbn;
    private int id;
    boolean devuelto;

    public Prestamo(String nombre, String libro, int id) {
        this.nombre = nombre;
        this.isbn = libro;
        this.id = id;
        this.devuelto = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public int getId() {
        return id;
    }
}
