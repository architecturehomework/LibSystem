package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Literature;
import model.Reader.Reader;
import model.Reader.ReaderFactory;
import service.LiteratureService;
import service.ServiceFactory;

import java.io.IOException;

public class ReaderController {

    @FXML
    private Label lname;

    @FXML
    private Label lid;

    @FXML
    private Label author;

    @FXML
    private Button backButton;

    @FXML
    private Label description;

    @FXML
    private TextArea contentArea;

    private LiteratureService literatureService = ServiceFactory.getLiteratureService();

    @FXML
    void Back(ActionEvent event) {

    }

    @FXML
    void initialize() {
        Literature literature = new Literature();
        lid.setText(literature.getId());
        lname.setText(literature.getId());
        author.setText(literature.getAuthor());
        description.setText(literature.getDescription());
        Reader reader = ReaderFactory.getReaderFactory(literature.getPath());
        try {
            contentArea.setText(reader.getText(literature.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
