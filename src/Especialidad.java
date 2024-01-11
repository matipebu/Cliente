import java.io.Serializable;

public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nombreespe;

    public Especialidad(int id, String nombreespe) {
        this.id = id;
        this.nombreespe = nombreespe;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEspe() {
        return nombreespe;
    }

    public void setNombreEspe(String nombreespe) {
        this.nombreespe = nombreespe;
    }
}
