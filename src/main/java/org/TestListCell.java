package org;


import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;

public class TestListCell extends ListCell<String> {

    static URL fxmlUrl = TestListCell.class.getResource("test_list_cell.fxml");

    @FXML
    Label label;
    @FXML
    MenuItem delete;

    final NPEController npeController;

    public TestListCell(final NPEController npeController) {
        loadFXML();
        this.npeController = npeController;
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(fxmlUrl);
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void updateItem(String name, boolean empty) {
        super.updateItem(name, empty);

        if (empty || name == null) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            label.setText(name);
            delete.setOnAction(e -> {
                npeController.delete(name);
            });
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }
}
