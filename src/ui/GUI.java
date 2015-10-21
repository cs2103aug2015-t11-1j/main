package ui;

import java.awt.Color;
import java.text.DateFormat;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// Title of window
		stage.setTitle("planIt!");

		// Creating the GridPane
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(5);

		// Command input Text Field
		TextField commandInput = new TextField();
		commandInput.setPromptText("ENTER COMMAND: ");
		commandInput.autosize();
		GridPane.setConstraints(commandInput, 30, 50);

		// Commands Label
		Label lb_commands = new Label("add/delete/update/search/undo/done/help/exit");
		lb_commands.setFont(Font.font(java.awt.Font.SANS_SERIF));
		lb_commands.setTextFill(javafx.scene.paint.Color.RED);
		GridPane.setConstraints(lb_commands, 30, 51);

		// Time Label
		Label lb_time = new Label();
		DateFormat format = DateFormat.getInstance();
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				lb_time.setText(format.format(cal.getTime()));
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		GridPane.setConstraints(lb_time, 30, 12);

		// Listview of items
		ListView<String> listView = new ListView<>();
		listView.autosize();
		listView.getItems().addAll(Welcome.welcomeMessage());
		GridPane.setConstraints(listView, 30, 13, 70, 37);
		// ObservableList<String> input;
		// input = listView.getSelectionModel().getSelectedItems();
		
		//Listview of today's to-do
		ListView<String> listToday = new ListView<>();
		listToday.setPrefHeight(433);
		listToday.getItems().addAll(Welcome.printToday());
		GridPane.setConstraints(listToday, 0, 13, 30, 30);

		// What happens when "ENTER" is hit
		commandInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				String message = "";
				ObservableList<String> input;
				if (ke.getCode().equals(KeyCode.ENTER)) {
					listView.getItems().addAll(commandInput.getText());
					input = listView.getSelectionModel().getSelectedItems();

					for (String i : input) {
						message += i + "\n";
					}

					commandInput.clear();
				}
				System.out.println(message);
			}
		});
		
		// Size of scene and what to display
		grid.getChildren().addAll(commandInput, lb_commands, listView, lb_time, listToday);
		Scene scene = new Scene(grid, 1000, 600);
		stage.setScene(scene);

		stage.show();
	}

}