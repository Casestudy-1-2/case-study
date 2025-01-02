package entity;

public class GymClass {
    private int classId;
    private String className;
    private String classTime;
    private int maxCapacity;
    private int trainerId;
    private int gymId;

    public GymClass(int classId, String className, String classTime, int maxCapacity, int trainerId, int gymId) {
        this.classId = classId;
        this.className = className;
        this.classTime = classTime;
        this.maxCapacity = maxCapacity;
        this.trainerId = trainerId;
        this.gymId = gymId;
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
    public int getTrainerId() {
        return trainerId;
    }
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }
    public int getGymId() {
        return gymId;
    }
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

}
