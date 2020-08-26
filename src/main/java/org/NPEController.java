package org;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class NPEController implements Initializable {

  @FXML
  ListView<String> listView;

  @Override
  public void initialize(final URL location, final ResourceBundle resources) {
    ObservableList<String> list = FXCollections.observableArrayList();
    list.addAll("11", "22", "33");
    listView.setItems(list);
    listView.setCellFactory(v -> new TestListCell(this));
  }

  public void delete(String name) {
    listView.getItems().remove(name);
  }
}
