import java.lang.reflect.Array;
import java.util.ArrayList;

public class HistoryTutor {
    private String[] dates;
    private Tutor tutor;

    public HistoryTutor(String[] dates, Tutor tutor) {
        this.dates = dates;
        this.tutor = tutor;
    }

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
