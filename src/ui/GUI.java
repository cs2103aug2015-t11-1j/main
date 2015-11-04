package ui;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
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
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Task;
import storage.Output;

public class GUI extends Application {
	private static Welcome welcome = new Welcome();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// Title of window
		stage.setTitle("planIt!");

		// Creating the GridPane
		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");

		// User input Text Field
		TextField commandInput = new TextField();
		commandInput.setId("commandInput");
		commandInput.setPromptText("Enter Command: ");
		GridPane.setConstraints(commandInput, 0, 50, 140, 1);

		// Results Text Field
		Label lb_results = new Label();
		GridPane.setConstraints(lb_results, 0, 48, 100, 1);

		// Commands Label
		Label lb_commands = new Label("add/delete/update/search/undo/done/help/exit");
		lb_commands.setId("label_commands");
		lb_commands.getStyleClass().add("lb_commands");
		lb_commands.setFont(Font.font(java.awt.Font.SANS_SERIF));
		lb_commands.setTextFill(javafx.scene.paint.Color.BLUE);
		GridPane.setConstraints(lb_commands, 0, 51, 100, 1);

		// Time Label
		Label lb_time = new Label();
		lb_time.setId("label_time");
		DateTimeFormatter format = DateTimeFormat.forPattern("EEEE, dd MMMM yyyy HH:mm:ss");
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				DateTime dt = new DateTime();
				lb_time.setText(format.print(dt));
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		GridPane.setConstraints(lb_time, 0, 5, 100, 1);

		// Listview of items
		ListView<String> listView = new ListView<>();
		listView.autosize();
		listView.getItems().addAll(welcome.welcomeMessage());
		GridPane.setConstraints(listView, 40, 6, 100, 42);
		// 30,6,70,43
		// ObservableList<String> input;
		// input = listView.getSelectionModel().getSelectedItems();

		// Listview of today's to-do
		ListView<String> listToday = new ListView<>();
		listToday.setPrefHeight(433);
		listToday.getItems().addAll(welcome.printToday());
		ObservableList<String> todayTasks = FXCollections.observableArrayList(Welcome.printMessage(welcome.session.getToday()));
		listToday.getItems().addAll(todayTasks);
		GridPane.setConstraints(listToday, 0, 6, 40, 42);

		// What happens when "ENTER" is hit
		commandInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				String message = "";
				ObservableList<String> input;
				// Task task = new Task();
				// DateTime dt = new DateTime();

				if (ke.getCode().equals(KeyCode.ENTER)) {
					try {
						// listView.getItems().addAll(Welcome.initiateProg(commandInput.getText()));
						Output op = welcome.initiateProg(commandInput.getText());
						if (op.getStatus()) {
							lb_results.setText("Success!");

						} else {
							lb_results.setText("Failure!");
						}
						listView.getItems().add(Welcome.printMessage(op));
						// listToday.getSelectionModel().selectedItemProperty().addListener((observable,
						// oldValue, newValue) -> {
						// listToday.setItems(todayTasks);
						// });

					} catch (IOException e) {
						e.printStackTrace();
					}
					input = listView.getSelectionModel().getSelectedItems();

					for (String i : input) {
						message += i + "\n";
					}

					commandInput.clear();
					/**
					 * if(task.getDate().equals(dt.toString())) { ObservableList
					 * <String> todayTasks = null; try { todayTasks =
					 * FXCollections.observableArrayList(Welcome.showToday(
					 * "show today")); } catch (IOException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); }
					 * listToday.getItems().addAll(todayTasks); }
					 **/
					// What happens when 'ESC' key is pressed
				} else if (ke.getCode().equals(KeyCode.ESCAPE)) {
					commandInput.clear();
				}
				System.out.println(message);

			}
		});

		// Size of scene and what to display
		grid.getChildren().addAll(commandInput, lb_commands, lb_results, listView, lb_time, listToday);

		Scene scene = new Scene(grid, 770, 550);
		scene.getStylesheets().add(GUI.class.getResource("GUIstyle.css").toExternalForm());
		stage.setScene(scene);

		stage.show();
	}

}