import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Prestamo {  // Mejor nombre: Prestamo (sustantivo, no verbo)

    private Biblioteca biblioteca;  // minúscula
    private Libro libro;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinEstimada;
    private boolean devuelto;

    public Prestamo(Biblioteca biblioteca, Libro libro, LocalDateTime fechaInicio, LocalDateTime fechaFinEstimada) {
        this.biblioteca = biblioteca;
        this.libro = libro;
        this.fechaInicio = fechaInicio;  // Con this
        this.fechaFinEstimada = fechaFinEstimada;
        this.devuelto = false;
    }

    // Getters (omitiendo setters por inmutabilidad parcial)
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void marcarDevuelto() {
        this.devuelto = true;
        // Asumimos que Libro tiene método devolverEjemplar()
        // Si no existe, habría que crearlo o quitar esta línea
        if (libro != null) {
            libro.devolverEjemplar();
        }
    }

    public int calcularRetrasoEnDias(LocalDateTime hoy) {
        if (hoy == null || fechaFinEstimada == null) {
            return 0;
        }

        // Solo hay retraso si hoy es DESPUÉS de la fecha estimada
        if (hoy.isAfter(fechaFinEstimada)) {
            // Calcula diferencia en días usando ChronoUnit
            return (int) ChronoUnit.DAYS.between(fechaFinEstimada, hoy);
        }

        return 0;  // No hay retraso
    }

    // Método alternativo que considera la hora del día
    public int calcularRetrasoEnDiasConsiderandoHoras(LocalDateTime hoy) {
        if (hoy == null || fechaFinEstimada == null) {
            return 0;
        }

        // Si hoy es después de la fecha estimada
        if (hoy.isAfter(fechaFinEstimada)) {
            // Convierte a LocalDate para comparar solo fechas
            LocalDateTime finDelDia = fechaFinEstimada.toLocalDate().atTime(23, 59, 59);

            // Si hoy es después del final del día de vencimiento, calcula retraso
            if (hoy.isAfter(finDelDia)) {
                // Diferencia en días naturales
                long dias = ChronoUnit.DAYS.between(
                        fechaFinEstimada.toLocalDate(),
                        hoy.toLocalDate()
                );
                return (int) dias;
            }
        }

        return 0;
    }
}