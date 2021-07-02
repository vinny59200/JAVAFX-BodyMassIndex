package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.shape.*;


public class Main extends Application {
    static double x = 0;
    static double y = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();


        ImageView image = new ImageView(new Image("file:src/resources/imc2.png"));
        root.getChildren().add(image);


        VBox vbox = new VBox();
        TextField weightTxt = new TextField();
        weightTxt.setMaxSize(935,20);
        weightTxt.setId("Weight");
        weightTxt.setPromptText("Weight");
        weightTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                String weight = newValue.replaceAll("[^\\d.]", "");
                System.out.println(weight);
                weightTxt.setText(weight);
                y = (130 - Double.parseDouble(weight)) * 492 / 90 - 10;
                System.out.println("changed weight :" + y + " (" + newValue + ")");
                Circle spot = new Circle(10);
                spot.setFill(Color.GREEN);
                spot.setCenterX(5.0f);
                spot.setCenterY(5.0f);
                spot.relocate(x, y);
                root.getChildren().clear();
                root.getChildren().add(image);
                root.getChildren().add(spot);
            }
        });
        TextField sizeTxt = new TextField();
        sizeTxt.setMaxSize(935,20);
        sizeTxt.setId("Size");
        sizeTxt.setPromptText("Size");
        sizeTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                String size = newValue.replaceAll("[^\\d.]", "");
                sizeTxt.setText(size);
                x = (210 - Double.parseDouble(size)) * 935 / 60 - 10;
                System.out.println("changed size :" + x + " (" + newValue + ")");
                Circle spot = new Circle(10);
                spot.setFill(Color.GREEN);
                spot.setCenterX(5.0f);
                spot.setCenterY(5.0f);
                spot.relocate(x, y);
                root.getChildren().clear();
                root.getChildren().add(image);
                root.getChildren().add(spot);
            }
        });
        vbox.getChildren().add(root);
        vbox.getChildren().add(weightTxt);
        vbox.getChildren().add(sizeTxt);

        Scene scene = new Scene(vbox, 935, 545);

        primaryStage.setTitle("Body Mass Index!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
