package org.b3log.barcode;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author Zhang Yu
 */
public class Controller {
    public ListView<String> barCodeList;
    public Button barCodeSubmit;
    public TextField barCodeText;
    public ImageView barCodeImageView;
    private static String path;
    static {
        path = System.getProperty("user.dir");
    }

    public void handleButtonAction(ActionEvent actionEvent) throws FileNotFoundException {
        String text = barCodeText.getText();

        OutputStream out = new FileOutputStream(path+ File.separator+text+".png");
        BarCodeBuilder.buildBarCode(text,out);
        Image image = new Image("file://"+path+ File.separator+text+".png");
        barCodeImageView.setImage(image);
        ObservableList<String> items = barCodeList.getItems();
        items.add(text);
        barCodeList.setItems(items);
    }

    public void handleTextAction(MouseEvent mouseEvent) {
        String item = barCodeList.getSelectionModel().getSelectedItem();
        Image image = new Image("file://"+path+ File.separator+item+".png");
        barCodeImageView.setImage(image);
    }
}
