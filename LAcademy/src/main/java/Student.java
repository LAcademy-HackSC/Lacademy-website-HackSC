import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Student {
    private String name;
    private String id;
    private String age;
    private String grade;
    private String school;
    private String gender;
    private History history;
    private String[] reports;
    private String[] logs;

    public ArrayList<HistoryTutor> getHistory(String studentid) throws ExecutionException, InterruptedException {
        ArrayList<HistoryTutor> returnList = new ArrayList<HistoryTutor>();
        ApiFuture<QuerySnapshot> future = QuickStart.db.collection("Student").document(studentid).collection("History").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            HistoryTutor temp = new HistoryTutor(document.getData(), document.getId());
            returnList.add(temp);
        }
        return returnList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setHistory(History history) {
        this.history = history;
    }

    public String[] getReports() {
        return reports;
    }

    public void setReports(String[] reports) {
        this.reports = reports;
    }

    public String[] getLogs() {
        return logs;
    }

    public void setLogs(String[] logs) {
        this.logs = logs;
    }
}
