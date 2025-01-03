package model;

import java.util.Objects;

public class Trainer extends Person{
    private String specialization;
    private Integer idClass;

    public Trainer(int id, String name, String phone, String specialization, Integer idClass) {
        super(id, name, phone);
        this.specialization = specialization;
        this.idClass = idClass;
    }

    public Trainer( String name, String specialization, String phone, Integer idClass) {
        super( name, phone);
        this.specialization = specialization;
        this.idClass = idClass;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(specialization, trainer.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialization);
    }
}
