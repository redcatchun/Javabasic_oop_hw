package bai1;

/**
 * Cac kieu nhan vien
 */
public enum TypeOfOfficer {
    WORKER(1,"level"),
    ENGINEER(2,"branch"),
    STAFF(3,"task");

    private final int numberOfJob;
    private final String specialAttribute;

    TypeOfOfficer(int numberOfJob, String specialAttribute){
        this.numberOfJob = numberOfJob;
        this.specialAttribute=specialAttribute;
    }

    public int getNumberOfJob() {
        return numberOfJob;
    }

    public String getSpecialAttribute() {
        return specialAttribute;
    }
}
