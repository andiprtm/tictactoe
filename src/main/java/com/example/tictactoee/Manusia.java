package com.example.tictactoee;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Manusia implements Initializable {
    public Button btn_to_home;
    public Label tv_score_manusia1;
    public Label tv_score_manusia2;
    public Button btn_next_game;
    public Label tv_player2;
    public Label tv_player1;
    public Button imgv_00;
    public Button imgv_01;
    public Button imgv_02;
    public Button imgv_10;
    public Button imgv_11;
    public Button imgv_12;
    public Button imgv_20;
    public Button imgv_21;
    public Button imgv_22;
    public Button[] btns;
    public boolean player1=true;
    public int count = 0;
    private boolean gameEnd = false;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToHome(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage) btn_to_home.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIC TAC TOE V1.0");
        stage.show();
    }

    public void switchToManusia(ActionEvent event) throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("manusia.fxml")));
        stage = (Stage) btn_next_game.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TIC TAC TOE V1.0");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        btn_to_home.setOnAction(event -> {
            try {
                switchToHome(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btn_next_game.setOnAction(event -> {
            try {
                switchToManusia(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btns = new Button[]{imgv_00, imgv_01, imgv_02, imgv_10, imgv_11, imgv_12, imgv_20, imgv_21, imgv_22};
        setFirstTurn();

        for (int i = 0; i < btns.length; i++) {
            int finalI = i;

            if((count == 0 && !player1)|| count == 9) {
                computerTurn();
            }
            btns[i].setOnAction(event -> {
                if (player1) {
                    btns[finalI].setText("X");
                    btns[finalI].setDisable(true);
                    player1 = false;
                    tv_player1.setTextFill(Color.BLACK);
                    tv_player1.setPadding(new javafx.geometry.Insets(10,10,10,10));
                    tv_player1.setBackground(new Background(new BackgroundFill(null, null, null)));

                    tv_player2.setTextFill(Color.WHITE);
                    tv_player2.setPadding(new javafx.geometry.Insets(10,10,10,10));
                    tv_player2.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
                    count++;
                    check();
                    computerTurn();

                } else {
                    btns[finalI].setText("O");
                    btns[finalI].setDisable(true);
                    player1 = true;
                    tv_player2.setTextFill(Color.BLACK);
                    tv_player2.setPadding(new javafx.geometry.Insets(10,10,10,10));
                    tv_player2.setBackground(new Background(new BackgroundFill(null, null, null)));

                    tv_player1.setTextFill(Color.WHITE);
                    tv_player1.setPadding(new javafx.geometry.Insets(10,10,10,10));
                    tv_player1.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
                    count++;
                    check();

                }
            });
        }
    }

    public void setFirstTurn(){
        if(player1){
            player1 = true;
            tv_player1.setTextFill(Color.WHITE);
            tv_player1.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player1.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        }else{
            player1 = false;
            tv_player2.setTextFill(Color.WHITE);
            tv_player2.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player2.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
        }
    }

    public void check(){
        if((btns[0].getText() == "X" && btns[1].getText() == "X" && btns[2].getText() == "X") ||
                (btns[3].getText() == "X" && btns[4].getText() == "X" && btns[5].getText() == "X") ||
                (btns[6].getText() == "X" && btns[7].getText() == "X" && btns[8].getText() == "X") ||
                (btns[0].getText() == "X" && btns[3].getText() == "X" && btns[6].getText() == "X") ||
                (btns[1].getText() == "X" && btns[4].getText() == "X" && btns[7].getText() == "X") ||
                (btns[2].getText() == "X" && btns[5].getText() == "X" && btns[8].getText() == "X") ||
                (btns[0].getText() == "X" && btns[4].getText() == "X" && btns[8].getText() == "X") ||
                (btns[2].getText() == "X" && btns[4].getText() == "X" && btns[6].getText() == "X")){

            tv_score_manusia1.setText("WIN");
            tv_score_manusia1.setTextFill(Color.GREEN);
            tv_score_manusia2.setText("LOSE");
            tv_score_manusia2.setTextFill(Color.RED);

            tv_player1.setTextFill(Color.WHITE);
            tv_player1.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player1.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

            tv_player2.setTextFill(Color.WHITE);
            tv_player2.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player2.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

            for (int i = 0; i < btns.length; i++) {
                btns[i].setDisable(true);
                gameEnd = true;
            }

        }else if(count == 9 && !gameEnd) {
            tv_score_manusia1.setText("DRAW");
            tv_score_manusia1.setTextFill(Color.YELLOW);
            tv_score_manusia2.setText("DRAW");
            tv_score_manusia2.setTextFill(Color.YELLOW);

            tv_player1.setTextFill(Color.WHITE);
            tv_player1.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
            tv_player1.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));

            tv_player2.setTextFill(Color.WHITE);
            tv_player2.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
            tv_player2.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));

            for (int i = 0; i < btns.length; i++) {
                btns[i].setDisable(true);
            }
        }

        if((btns[0].getText() == "O" && btns[1].getText() == "O" && btns[2].getText() == "O") ||
                (btns[3].getText() == "O" && btns[4].getText() == "O" && btns[5].getText() == "O") ||
                (btns[6].getText() == "O" && btns[7].getText() == "O" && btns[8].getText() == "O") ||
                (btns[0].getText() == "O" && btns[3].getText() == "O" && btns[6].getText() == "O") ||
                (btns[1].getText() == "O" && btns[4].getText() == "O" && btns[7].getText() == "O") ||
                (btns[2].getText() == "O" && btns[5].getText() == "O" && btns[8].getText() == "O") ||
                (btns[0].getText() == "O" && btns[4].getText() == "O" && btns[8].getText() == "O") ||
                (btns[2].getText() == "O" && btns[4].getText() == "O" && btns[6].getText() == "O")){

            tv_score_manusia2.setText("WIN");
            tv_score_manusia2.setTextFill(Color.GREEN);
            tv_score_manusia1.setText("LOSE");
            tv_score_manusia1.setTextFill(Color.RED);

            tv_player2.setTextFill(Color.WHITE);
            tv_player2.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player2.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

            tv_player1.setTextFill(Color.WHITE);
            tv_player1.setPadding(new javafx.geometry.Insets(10,10,10,10));
            tv_player1.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

            for (int i = 0; i < btns.length; i++) {
                btns[i].setDisable(true);
                gameEnd = true;
            }
        }else if(count == 9 && !gameEnd) {
            tv_score_manusia1.setText("DRAW");
            tv_score_manusia1.setTextFill(Color.YELLOW);
            tv_score_manusia2.setText("DRAW");
            tv_score_manusia2.setTextFill(Color.YELLOW);

            tv_player1.setTextFill(Color.WHITE);
            tv_player1.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
            tv_player1.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));

            tv_player2.setTextFill(Color.WHITE);
            tv_player2.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
            tv_player2.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));

            for (int i = 0; i < btns.length; i++) {
                btns[i].setDisable(true);
            }
        }
    }

    public void computerTurn() {
        boolean turnDone = false;
        while (!turnDone) {
            int rand = (int) (Math.random() * 9);
            if (btns[rand].getText() == "") {
                btns[rand].arm();
                btns[rand].fire();
                turnDone = true;
            }
        }
    }
}
