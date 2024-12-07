package IoC;

public class Doctor implements Staff{
    private String qualification;
    private String name;

    Doctor(Nurse nurse) {
        nurse.assist();
    }

    @Override
    public void assist() {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
