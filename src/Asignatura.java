import java.io.Serializable;

public class Asignatura implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombreasig;

    public Asignatura(int id, String nombreasig) {
        this.id = id;
        this.nombreasig = nombreasig;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAsig() {
        return nombreasig;
    }

    public void setNombreAsig(String nombreasig) {
        this.nombreasig = nombreasig;
    }
}
