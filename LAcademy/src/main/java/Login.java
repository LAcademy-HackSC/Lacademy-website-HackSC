import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {

    }

    public boolean checkLogin() throws ExecutionException, InterruptedException {
        DocumentReference dbPasswordRef =  QuickStart.db.collection("Login").document(username);
        ApiFuture<DocumentSnapshot> future = dbPasswordRef.get();
        DocumentSnapshot doc = future.get();
        String dbPassword = doc.getData().toString();
        String[] temp = dbPassword.split("=");
        String ans = temp[1].substring(0, temp[1].length()-1);
        System.out.println(ans);
        if(ans.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void parseLoginJson(String path) throws IOException, ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Login test = mapper.readValue(new File(path), Login.class);
        System.out.println(test.username);
        System.out.println(test.checkLogin());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
