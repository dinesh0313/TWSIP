
package com.example.onlinevotingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class ONLINE_VOTING_SYSTEM extends Application {

    int OJP=0;
    int None=0;
    int ABC=0;
    int MNO=0;

    @Override
    public void start(Stage stage) throws IOException {


        VBox ma=new VBox();


        Label t1=new Label("ONLINE VOTING SYSTEM");
        t1.setFont(Font.font ("vedanta ",FontWeight.BOLD ,40));
        t1.setTextFill(Color.BLACK);
        t1.setMaxWidth(Double.MAX_VALUE);
        t1.setAlignment(Pos.CENTER);

        //user verification

        // Create the login form layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add the login form elements


        Label Name = new Label("ENTER NAME :");
        grid.add(Name, 0, 1);

        TextField NameTextField = new TextField();
        grid.add(NameTextField, 1, 1);


        Label phone= new Label("ENTER PHONE :");
        grid.add(phone, 0, 2);

        TextField PhoneNo = new TextField();
        grid.add(PhoneNo, 1, 2);

        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(200);


        //Choice
        //Hbox
        Label Vote =new Label("      CAST YOUR VOTE HERE");
        Vote.setAlignment(Pos.BASELINE_LEFT);
        Vote.setFont(Font.font("vedanta", FontWeight.BOLD, 16));
        HBox hb1=new HBox();
        RadioButton r1 = new RadioButton("OJP");
        r1.setSelected(true);
        RadioButton r2=new RadioButton("MNO");
        RadioButton r3 =new RadioButton("ABC");
        RadioButton r4 =new RadioButton("None");
        VBox Bv1=new VBox();
        ToggleGroup tg1 = new ToggleGroup();
        r1.setToggleGroup(tg1);
        r2.setToggleGroup(tg1);
        r3.setToggleGroup(tg1);
        r4.setToggleGroup(tg1);
        Bv1.setPadding(new Insets(10,10,10,30));
        Bv1.setAlignment(Pos.BASELINE_LEFT);
        Bv1.getChildren().addAll(r1,r2,r3,r4);


        //----Submit vote button Start----//
        Button btn1 = new Button("SUBMIT VOTE ");
        btn1.setOnMousePressed(e -> {
            btn1.setScaleX(0.9);
            btn1.setScaleY(0.9);
        });

        btn1.setOnMouseReleased(e -> {
            btn1.setScaleX(1);
            btn1.setScaleY(1);
        });

        btn1.setOnAction(e -> {
                if (NameTextField.getCharacters().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR, "Please enter a Name");
                    alert1.showAndWait();
                }
                if (PhoneNo.getCharacters().isEmpty()) {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR, "Please enter a Phone number");
                    alert2.showAndWait();

                }
                else {

                    // Perform some action when button1 is clicked
                    if (r1.isSelected()) {
                        OJP += 1;
                    } else if (r2.isSelected()) {
                        ABC += 1;
                    } else if (r3.isSelected()) {
                        MNO += 1;
                    } else {
                        None += 1;
                    }

                    // Do some processing and set the result label text
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Conform your vote");
                    a1.show();
                    // Reset the label after processing is complete
                    NameTextField.setText(null);
                    PhoneNo.setText(null);

                }

        });

        //----Submit vote button end----//


        //----Check result  button Start----//
        Button btn2 = new Button("CHECK RESULT");

        btn2.setOnMousePressed(e -> {
            btn2.setScaleX(0.9);
            btn2.setScaleY(0.9);
        });

        btn2.setOnMouseReleased(e -> {
            btn2.setScaleX(1);
            btn2.setScaleY(1);
        });

        btn2.setOnAction(e -> {

            //----part Label--//
            VBox v1=new VBox();
            Label l1=new Label("OPJ GET : "+OJP+"VOTES");
            Label l2=new Label("ABC GET : "+ABC+"VOTES");
            Label l3=new Label("MNO GET : "+MNO+"VOTES");

            //----add Label in in Vbox----//
            v1.getChildren().addAll(l1,l2,l3);


            //----Wining part Label----//
            Label rl1=new Label();
            rl1.setPadding(new Insets(20));
            rl1.setFont(Font.font("vedanta", FontWeight.BOLD, 20));


            //----party winning condition check----//
            if (None>OJP  && None>ABC && None>MNO){
                rl1.setText("No any party is win");

            }
            else if(OJP>ABC && OJP>MNO){

                rl1.setText("OJP party win");
            }
            else if(ABC>OJP && ABC>MNO){
                rl1.setText("ABC party win");
            }else if(MNO>ABC && MNO>OJP){
                rl1.setText("MNO party win");
            }
            else{
                rl1.setText("No any party is win");
            }

            //----set Vbox for scene----//
            v1.getChildren().add(rl1);
            v1.setAlignment(Pos.CENTER);

            //----Set scene----//
            Scene sc2=new Scene(v1,400,400);
            Stage st=new Stage();
            st.setScene(sc2);
            st.show();
            st.setResizable(false);
        });
        //----end of CHECK RESULT BUTTON event----//


        //----add both Submit vote and check result button in vbox----//
        VBox hb2 =new VBox();
        hb2.getChildren().addAll(btn1,btn2);
        hb2.setAlignment(Pos.BASELINE_RIGHT);
        hb1.getChildren().addAll(Bv1,hb2);


        //----Date----//
        Label L1=new Label();
        LocalDate currentDate = LocalDate.now();
        L1.setAlignment(Pos.CENTER);
        L1.setPadding(new Insets(40));
        L1.setText("Date: " + currentDate.toString());
        ma.getChildren().add(t1);
        ma.getChildren().addAll(grid,Vote,hb1,L1);
        Scene sc=new Scene(ma,500,500);
        stage.setTitle("VOTING SYSTEM");
        stage.setScene(sc);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
