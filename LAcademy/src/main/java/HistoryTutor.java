import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class HistoryTutor {
    private Map< String, Object > dates;
    private ArrayList dateslist;
    private String tutorName;

    public HistoryTutor(Map< String, Object > dates, String tutorname) {
        this.dates = dates;
        this.tutorName = tutorname;
        dateslist = (ArrayList) dates.get("Date");
    }

    public ArrayList getDateslist() {return dateslist;};

    public Map< String, Object > getDates() {
        return dates;
    }

    public void setDates(Map< String, Object > dates) {
        this.dates = dates;
    }

    public String getTutor() {
        return tutorName;
    }

    public void setTutor(String tutor) {
        this.tutorName = tutor;
    }
}
