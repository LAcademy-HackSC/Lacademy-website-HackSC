public class Search {
    private String subject;
    private String location;
    private String subject_location;

    public Search(String subject_location) {
        this.subject_location = subject_location;
    }

    public Search(String subject, String location) {
        this.subject = subject;
        this.location = location;
    }

    public Search() {

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubject_location() {
        return subject_location;
    }

    public void setSubject_location(String subject_location) {
        this.subject_location = subject_location;
    }
}
