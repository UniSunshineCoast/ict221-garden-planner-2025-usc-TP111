package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    GardenPlanner planner;

    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        root.setCenter(pane);
        root.setStyle("-fx-background-color: #007700;");

        HBox propertiesTab = new HBox();
        TextField widthField = new TextField();
        TextField heightField = new TextField();
        TextField leftField = new TextField();
        TextField topField = new TextField();

        propertiesTab.getChildren().addAll(
                new Label("  Width: "), widthField,
                new Label("  Height: "), heightField,
                new Label("  Left: "), leftField,
                new Label("  Top: "), topField
        );

        root.setBottom(propertiesTab);

        for (RectBed bed : planner.getBeds()) {
            Rectangle rect = new Rectangle(bed.getWidth() * 100, bed.getHeight() * 100);
            rect.setX(bed.getLeft() * 100);
            rect.setY(bed.getTop() * 100);
            rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    widthField.setText(Double.toString(bed.getWidth()));
                    heightField.setText(Double.toString(bed.getHeight()));
                    leftField.setText(Double.toString(bed.getLeft()));
                    topField.setText(Double.toString(bed.getTop()));
                    root.setBottom(propertiesTab);
                }
            });
            pane.getChildren().add(rect);
        }

        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
