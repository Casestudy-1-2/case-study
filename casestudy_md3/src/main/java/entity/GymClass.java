package entity;

public class GymClass {
    private int id;
    private String className;
    private String classTime;
    private int maxCapacity;
    private int trainerId;
    private int gymId;

    public GymClass(int id, String className, String classTime, int maxCapacity, int trainerId, int gymId) {
        this.id = id;
        this.className = className;
        this.classTime = classTime;
        this.maxCapacity = maxCapacity;
        this.trainerId = trainerId;
        this.gymId = gymId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "GymClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classTime='" + classTime + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", trainerId=" + trainerId +
                ", gymId=" + gymId +
                '}';
    }
}
