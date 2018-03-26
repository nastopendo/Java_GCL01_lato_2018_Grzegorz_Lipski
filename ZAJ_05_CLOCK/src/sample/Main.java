package sample;

import java.sql.Time;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.text.Font;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Analogowy zegar z alarmami");
        AnchorPane anchorPane = new AnchorPane();

        Scene scene = new Scene(anchorPane, 800, 500, Color.BLUE);


        ResizableCanvas canvas = new ResizableCanvas();
        canvas.widthProperty().bind(anchorPane.widthProperty());
        canvas.heightProperty().bind(anchorPane.heightProperty());

        anchorPane.getChildren().add(canvas);
        AnchorPane.setLeftAnchor(canvas,0.0);
        AnchorPane.setTopAnchor(canvas,28.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);


        Label alarmLabel = new Label("Lista alarmów:");

        Time time0 = new Time(7,10,0);
        Time time1 = new Time(10,53,21);
        Time time2 = new Time(6,10,0);
        ListView<Time> listView = new ListView<Time>();
        listView.getItems().addAll(time0, time1, time2);
        Collections.sort(listView.getItems());


        ContextMenu contextMenu = new ContextMenu();
        MenuItem deleteItem = new MenuItem("Delete");
        contextMenu.getItems().add(deleteItem);
        listView.setContextMenu(contextMenu);

        deleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                listView.getItems().remove(selectedIdx);
            }
        });

        anchorPane.getChildren().addAll(listView, alarmLabel);
        AnchorPane.setRightAnchor(alarmLabel,30.0);
        AnchorPane.setTopAnchor(alarmLabel,38.0);
        AnchorPane.setRightAnchor(listView,30.0);
        AnchorPane.setTopAnchor(listView,55.0);
        AnchorPane.setBottomAnchor(listView, 20.0);


        MenuBar menu = new MenuBar();
        Menu menuProgram = new Menu("Program");
        menuProgram.getItems().add(new MenuItem("Zamknij"));
        Menu menuAlarm = new Menu("Budzik");
        MenuItem addAlarm = new MenuItem("Dodaj alarm");
        MenuItem clearAlarms = new MenuItem("Wyczyść alarmy");
        menuAlarm.getItems().add(addAlarm);
        menuAlarm.getItems().add(clearAlarms);

        Label menuAboutLabel = new Label("O autorze");
        Menu menuAbout = new Menu();
        menuAbout.setGraphic(menuAboutLabel);
        menu.getMenus().addAll(menuProgram, menuAlarm, menuAbout);
        anchorPane.getChildren().add(menu);
        AnchorPane.setTopAnchor(menu, 0.0);
        AnchorPane.setLeftAnchor(menu,0.0);
        AnchorPane.setRightAnchor(menu,0.0);

        Calendar c = Calendar.getInstance();
        Alarm alarm = new Alarm();

        menuProgram.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("Calling Platform.exit():");
                Platform.exit();
                System.out.println("Calling System.exit(0):");
                System.exit(0);
            }
        });


        addAlarm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage alarmStage = new Stage();
                alarmStage.setTitle("Panel dodawania alarmów");

                GridPane gridAlarmPane = new GridPane();

                Label hourError = new Label("");
                Label minuteError = new Label("");
                Label secondError = new Label("");
                Label hourLabel = new Label("Godzina: ");
                Label minuteLabel = new Label("Minuta: ");
                Label secondLabel = new Label("Sekunda: ");
                TextField hourField = new TextField();
                TextField minuteField = new TextField();
                TextField secondField = new TextField();
                Button clearButton = new Button("Wyczyść");
                Button addAlarmButton = new Button("Dodaj alarm");

                gridAlarmPane.setHgap(10.0);
                gridAlarmPane.setVgap(10.0);
                gridAlarmPane.add(hourError,2, 1);
                gridAlarmPane.add(minuteError,2, 3);
                gridAlarmPane.add(secondError,2, 5);
                gridAlarmPane.add(hourLabel,1,2);
                gridAlarmPane.add(minuteLabel,1,4);
                gridAlarmPane.add(secondLabel,1,6);
                gridAlarmPane.add(hourField,2,2);
                gridAlarmPane.add(minuteField,2,4);
                gridAlarmPane.add(secondField,2,6);
                gridAlarmPane.add(clearButton,1,8);
                gridAlarmPane.add(addAlarmButton,2,8);

                addAlarmButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        hourError.setText("");
                        minuteError.setText("");
                        secondError.setText("");

                        int h=0, m=0, s=0;
                        try{
                            h=Integer.parseInt(hourField.getText());
                        } catch (Exception ex) {
                            hourError.setText("Niepoprawny format");
                        }
                        try{
                            m=Integer.parseInt(minuteField.getText());
                        } catch (Exception ex) {
                            minuteError.setText("Niepoprawny format");
                        }
                        try{
                            s=Integer.parseInt(secondField.getText());
                        } catch (Exception ex) {
                            secondError.setText("Niepoprawny format");
                        }
                        if (hourError.getText() == "" && ((h<0 || h>24))) hourError.setText("Niepoprawna wartość");
                        if (minuteError.getText() == "" && ((h<0 || h>60))) minuteError.setText("Niepoprawna wartość");
                        if (secondError.getText() == "" && ((h<0 || h>60))) secondError.setText("Niepoprawna wartość");

                            if(hourError.getText() == "" && minuteError.getText() == "" && secondError.getText() == ""){
                            Time time = new Time(h,m,s);
                            listView.getItems().add(time);
                            Collections.sort(listView.getItems());
                        }

                    }
                });

                clearButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        hourError.setText("");
                        hourField.setText("");
                        minuteError.setText("");
                        minuteField.setText("");
                        secondError.setText("");
                        secondField.setText("");
                    }
                });

                Scene scene = new Scene(gridAlarmPane, 300, 250, Color.WHITE);
                alarmStage.setScene(scene);
                alarmStage.show();
            }

        });

        clearAlarms.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listView.getItems().clear();
            }
        });

        menuAboutLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage aboutStage = new Stage();
                aboutStage.setTitle("O autorze");

                // load the image
                Image image = new Image("profilePhoto.png");

                // simple displays ImageView the image as is
                ImageView imageView = new ImageView();
                imageView.setImage(image);

                GridPane gridPane = new GridPane();
                gridPane.add(imageView,1,1);

                Label autorName = new Label("Grzegorz Lipski");
                Label autorAddress = new Label("Leszczków 9, 27-540 Lipnik");
                Label autorPhoneNumber = new Label("+48 678 567 312");

                autorName.setFont(new Font("Arial", 20));
                autorAddress.setFont(new Font("Arial", 15));
                autorPhoneNumber.setFont(new Font("Arial", 15));

                VBox autorInfoBox = new VBox(8);
                autorInfoBox.getChildren().addAll(autorName,autorAddress,autorPhoneNumber);

                gridPane.add(autorInfoBox,2,1);
                gridPane.setVgap(15);
                gridPane.setHgap(15);
                Scene scene = new Scene(gridPane, 550, 430, Color.WHITE);
                aboutStage.setScene(scene);
                aboutStage.show();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                canvas.onDraw();

            }
        },0, 1000);

        Timer alarmTimer = new Timer();
        alarmTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Time time : listView.getItems()) {
                    if(time.getHours() == c.get(Calendar.HOUR_OF_DAY) && time.getMinutes() == c.get(Calendar.MINUTE)) alarm.playAlarm();
                }
            }
        },0, 60000);
    }

    public static void main(String[] args) {
        launch(args);
    }

}