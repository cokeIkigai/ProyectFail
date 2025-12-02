import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestar {

    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private boolean devuelto;

    public Prestar(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.devuelto = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void marcarDevuelto() {
        devuelto = true;
        libro.devolver();
    }


    public int calcularRetrasoEnDias(LocalDate hoy) {
        if (hoy == null) {
            return -1;
        }

        if (hoy.isAfter(fechaFinEstimada)) {
            return (int) ChronoUnit.DAYS.between(fechaFinEstimada, hoy);
        }

        return 0; // No hay retraso si la fecha es igual o antes
    }
}
