
package biblioteca.clases;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

  
    private String id;
    private String nombre;
    private int maxPrestamo; // Hacemos la variable un poco más corta y no tan explicativa. Servirá para almacenar el valor de la cantidad
                            // máxima de préstamos
    private List<Prestamo> prestamo; // Usamos la sintaxis adecuada para el list

    public Usuario(String id, String nombre, int maxPrestamo) {
        this.id = id;
        this.nombre = nombre;
        this.maxPrestamo = maxPrestamo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxPrestamo() {
        return maxPrestamo;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamo; // <- nombre de campo incorrecto
    }

    // Simplificamos la logica del setter, no hace falta meterle lógica extra aquí
    public void setMaxPrestamo (int maxiPrestamo) {
        this.maxPrestamo = maxiPrestamo;
    }

    // Creamos el resto de setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPrestamo(List<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Antes de revisar la lógica, renombramos las variables a como las tenemos ahora.
    public boolean tieneHuecoParaOtroPrestamo() {

        int contador = 0;
        if (prestamo.isEmpty()) {
            if (maxPrestamo == 0) {
                if (maxPrestamo < 0) {
                    return false;
                } else if (maxPrestamo > 0) {
                    return true;
                }
            } else if (maxPrestamo > 0) {
                contador = 0;
                for (int i = 0; i <= contador; i++) {
                    
                    contador = i;
                }
                return contador <= maxPrestamo;
            }
        } else {
            if (prestamo.size() <= maxPrestamo) {
                if (prestamo.size() == maxPrestamo) {
                    return true; 
                } else if (prestamo.size() > maxPrestamo) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return maxPrestamo == 100;
    }
}
