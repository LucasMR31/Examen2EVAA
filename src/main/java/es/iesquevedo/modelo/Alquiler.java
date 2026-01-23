package es.iesquevedo.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Alquiler {
    private String id;
    private String cocheId;
    private String usuarioId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Alquiler() {
    }

    public Alquiler(String id, String cocheId, String usuarioId, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.cocheId = cocheId;
        this.usuarioId = usuarioId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCocheId() {
        return cocheId;
    }

    public void setCocheId(String cocheId) {
        this.cocheId = cocheId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id='" + id + '\'' +
                ", cocheId='" + cocheId + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alquiler)) return false;
        Alquiler alquiler = (Alquiler) o;
        return Objects.equals(id, alquiler.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

