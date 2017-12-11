package org.b3log.barcode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.b3log.utils.FileHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Zhang Yu
 */
public class Controller {
    public ListView<String> barCodeList;
    public Button barCodeSubmit;
    public TextField barCodeText;
    public ImageView barCodeImageView;

    /*public Controller() {
        List<String> names = FileHelper.getImageNames();
        if (names != null && names.size() > 0) {
            ObservableList<String> items = FXCollections.observableArrayList();
            items.addAll(names);
            barCodeList.setItems(items);
        }
    }*/

    public void initialize() {
        List<String> names = FileHelper.getImageNames();
        if (names != null && names.size() > 0) {
            ObservableList<String> items = FXCollections.observableArrayList();
            items.addAll(names);
            barCodeList.setItems(items);
        }
    }

    public void handleButtonAction(ActionEvent actionEvent) throws FileNotFoundException {
        String text = barCodeText.getText();
        OutputStream out = new FileOutputStream(FileHelper.getImagePath(text));
        BarCodeBuilder.buildBarCode(text, out);
        Image image = new Image("file://" + FileHelper.getImagePath(text));
        barCodeImageView.setImage(image);
        ObservableList<String> items = barCodeList.getItems();
        items.add(text);
        barCodeList.setItems(items);
    }

    public void handleTextAction(MouseEvent mouseEvent) {
        String item = barCodeList.getSelectionModel().getSelectedItem();
        Image image = new Image("file://" + FileHelper.getImagePath(item));
        barCodeImageView.setImage(image);
    }
}
