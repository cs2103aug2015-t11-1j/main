// @@author A0125273L

package ui;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javafx.scene.image.Image;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
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
		stage.getIcons().add(new Image(getClass().getResourceAsStream("logo_v.png")));
		
		// Creating the GridPane
		GridPane grid = new GridPane();
		grid.getStyleClass().add("grid");

		// User input Text Field
		TextField commandInput = new TextField();
		commandInput.setId("commandInput");
		commandInput.setPromptText("Enter Command: ");
		GridPane.setConstraints(commandInput, 40, 50, 100, 1);

		// Results label
		Label lb_results = new Label();
		GridPane.setConstraints(lb_results, 40, 49, 100, 1);

		// Commands Label
		Label lb_commands = new Label("add/delete/update/search/undo/done/help/exit");
		lb_commands.setId("label_commands");
		GridPane.setConstraints(lb_commands, 40, 51, 100, 1);

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
		GridPane.setConstraints(lb_time, 72, 1, 70, 10);

		// Listview of items
		ListView<String> listView = new ListView<>();
		listView.autosize();
		listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(final ListView<String> list) {
				return new ListCell<String>() {
					{
						 Text text = new Text();
	                     text.wrappingWidthProperty().bind(list.widthProperty().subtract(15));
	                     text.textProperty().bind(itemProperty());

	                     setPrefWidth(0);
	                     setGraphic(text);
					}
				};
			}
		});
		listView.getItems().addAll(welcome.welcomeMessage());
		GridPane.setConstraints(listView, 40, 11, 100, 35);
		

		// Listview of today's to-do
		ListView<String> listToday = new ListView<>();
		listToday.setPrefHeight(433);
		listToday.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(final ListView<String> list) {
				return new ListCell<String>() {
					{
						 Text text = new Text();
	                     text.wrappingWidthProperty().bind(list.widthProperty().subtract(15));
	                     text.textProperty().bind(itemProperty());

	                     setPrefWidth(0);
	                     setGraphic(text);
					}
				};
			}
		});
		listToday.getItems().addAll(welcome.printToday());
		ObservableList<String> todayTasks = FXCollections.observableArrayList(Welcome.printMessageToday(welcome.session.getToday()));
		listToday.getItems().addAll(todayTasks);
		GridPane.setConstraints(listToday, 0, 11, 40, 35);

		commandInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				String message = "";
				String message1 = "";

				ObservableList<String> input;
				ObservableList<String> input1;

				//What happens when "ENTER" key is hit
				if (ke.getCode().equals(KeyCode.ENTER)) {
					try {
						Output op = welcome.initiateProg(commandInput.getText());
						//Results output
						if (op.getStatus()) {
							lb_results.setText("Success!");
						} else {
							lb_results.setText("Failure!");
						}
						
						listView.getItems().add(Welcome.printMessage(op));
						
						//Update today's tasks list view
						ObservableList<String> newTodayTasks = FXCollections.observableArrayList(Welcome.printMessageToday(welcome.session.getToday()));
						if(newTodayTasks.size() > todayTasks.size()) {
							listToday.getItems().add(null);
						} else {
							listToday.getItems().clear();
							listToday.getItems().addAll(welcome.printToday());
							listToday.getItems().add(newTodayTasks.get(newTodayTasks.size()-1));
						}
						
						//clears list view
						if(commandInput.getText().equals("clear")){
							lb_results.setText("Success!");
							listView.getItems().clear();
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					//Print list view
					input = listView.getSelectionModel().getSelectedItems();
					
					for (String i : input) {
						message += i + "\n";
					}
					
					commandInput.clear();
					
					//Print list today
					input1 = listToday.getSelectionModel().getSelectedItems();
					for(String i: input1) {
						message1 += i + "\n";
					}
					
					// What happens when 'ESC' key is pressed
				} else if (ke.getCode().equals(KeyCode.ESCAPE)) {
					commandInput.clear();
				}
				
				
				System.out.println(message);
				System.out.println(message1);

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