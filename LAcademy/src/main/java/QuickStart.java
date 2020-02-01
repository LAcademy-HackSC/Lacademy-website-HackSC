import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class QuickStart {
    private Firestore db;

    public QuickStart(String projectId) throws IOException {
        FileInputStream input = new FileInputStream("C:\\Users\\Alex\\Desktop\\LAcademy-11261bcdb733.json");

        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setCredentials(GoogleCredentials.fromStream(input))
                        .setProjectId(projectId)
                        .build();

        Firestore db = firestoreOptions.getService();
        this.db = db;
    }
}
