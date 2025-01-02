package dto;

public class GymClassDTO {
    private int trainerId;
    private String trainerName;
    private String specialization;
    private String phone;
    private String className;

    public GymClassDTO() {
    }

    public GymClassDTO(int trainerId, String trainerName, String specialization, String phone, String className) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.specialization = specialization;
        this.phone = phone;
        this.className = className;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
