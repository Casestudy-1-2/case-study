package entity;

public class Enrollment {
        private int customerId;
        private int classId;
        private String registrationDate;

        public Enrollment(int customerId, int classId, String registrationDate) {
            this.customerId = customerId;
            this.classId = classId;
            this.registrationDate = registrationDate;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getRegistrationDate() {
            return registrationDate;
        }

        public void setRegistrationDate(String registrationDate) {
            this.registrationDate = registrationDate;
        }

        @Override
        public String toString() {
            return "Enrollment{" +
                    "customerId=" + customerId +
                    ", classId=" + classId +
                    ", registrationDate='" + registrationDate + '\'' +
                    '}';
        }

}
