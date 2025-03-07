package game;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DialogRepository {

    private static final String FILE_PATH = "/karczmarz-dialogs.json";

    public List<Dialog> loadAllDialogs() {
        return loadDialogsFromFile();
    }

    private List<Dialog> loadDialogsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           Dialog[] dialogs =  objectMapper.readValue(new File(getClass().getResource(FILE_PATH)
                   .getFile()), Dialog[].class);
            return Arrays.stream(dialogs)
                    .filter(dialog -> !dialog.getText().isBlank())
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load dialogs");
        }
    }
}
