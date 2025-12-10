
package biblioteca.clases;

public class Libro {

    // Representa un libro físico en la biblioteca
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion, int ejemplaresTotales, int ejemplaresDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion; // <- variable mal escrita
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles; // ejemplaresDisponibles no puede ser = ejemplaresTotales
    }

    public String getIsbn() {
        return isbn; // el punto y coma
    }

    public String getTitulo() {
        return titulo; // El getter tiene que devolver el mismo tipo de variable, String, y con el mismo nombre,
                        // titulo y no title
    }

    private String getAutor() {
        return autor; // Igual que arriba, nos tiene que devolver el mismo tipo de variable
    }

    public int getAnioPublicacion() {
        return anioPublicacion; // Un getter por definición no puede ser un método vacío, tiene que devovlernos
                                // una variable.
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    //Para poder operar correctamente con los libros, lo más seguro es que necesitemos unos setters, así que los dejamos creados

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setEjemplaresTotales(int ejemplaresTotales) {
        this.ejemplaresTotales = ejemplaresTotales;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public boolean estaDisponible() {
        return ejemplaresDisponibles >= 0;
    }

    public void prestarEjemplar() {
        ejemplaresDisponibles--; 
    }

    public void devolver() {
        ejemplaresDisponibles = ejemplaresDisponibles + 1;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", ejemplaresTotales=" + ejemplaresTotales +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}'; // el punto y coma
    } 
}
