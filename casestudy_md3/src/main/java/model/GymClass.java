
package model;

import java.util.Objects;

public class GymClass {
    private int classId;
    private String className;
    private String classTime;
    private int maxCapacity;
    private int trainer;
    private int customer;

    public GymClass() {
    }

    public GymClass(int classId, String className, String classTime, int maxCapacity, int trainer) {
        this.classId = classId;
        this.className = className;
        this.classTime = classTime;
        this.maxCapacity = maxCapacity;
        this.trainer = trainer;
    }

    public GymClass(int classId, String className, String classTime, int maxCapacity, int trainer, int customer) {
        this.classId = classId;
        this.className = className;
        this.classTime = classTime;
        this.maxCapacity = maxCapacity;
        this.trainer = trainer;
        this.customer = customer;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymClass gymClass = (GymClass) o;
        return classId == gymClass.classId && maxCapacity == gymClass.maxCapacity && Objects.equals(className, gymClass.className) && Objects.equals(classTime, gymClass.classTime) && Objects.equals(trainer, gymClass.trainer) && Objects.equals(customer, gymClass.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className, classTime, maxCapacity, trainer, customer);
    }

    @Override
    public String toString() {
        return "GymClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classTime='" + classTime + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", trainer=" + trainer +
                ", customer=" + customer +
                '}';
    }
}
