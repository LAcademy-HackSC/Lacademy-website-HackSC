import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SearchReturn {
    private Search search;

    public SearchReturn(Search search) {
        this.search = search;
    }

    public void search() throws ExecutionException, InterruptedException {
        if(search.getSubject() != null && search.getLocation() == null) {
            CollectionReference col = QuickStart.db.collection("Tutor");
            Query query = col.whereEqualTo("subject", search.getSubject());
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                System.out.println(document.getData());
            }
        } else if (search.getSubject() == null && search.getLocation() != null) {
            CollectionReference col = QuickStart.db.collection("Tutor");
            Query query = col.whereEqualTo("location", search.getLocation());
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                System.out.println(document.getId() + document.getData());
            }
        } else {
            CollectionReference col = QuickStart.db.collection("Tutor");
            search.setSubject_location(search.getSubject() + "_" + search.getLocation());
            Query query = col.whereEqualTo("subject", search.getSubject())
                    .whereEqualTo("location", search.getLocation());
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                System.out.println(document.getData());
            }
        }

    }
}
