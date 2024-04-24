package Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteService {
    private static WriteService instance;
    private FileWriter fileWriter;

    public WriteService() {
        try {
            this.fileWriter = new FileWriter("audit.csv", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized WriteService getInstance() {
        if (instance == null) {
            instance = new WriteService();
        }
        return instance;
    }

    public void write(String filename, String action) {
        try (FileWriter fileWriter = new FileWriter(filename, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            printWriter.println(action + "," + timestamp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
