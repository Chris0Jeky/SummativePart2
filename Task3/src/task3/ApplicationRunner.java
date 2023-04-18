package task3;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ApplicationRunner extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene mapScene;
    private Scene fitnessScene;
    private Scene dashboardScene;

    private double distance;
    private int timeInMinutes;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Cycling App");

        VBox mainScreen = createMainScreen();
        mainScene = new Scene(mainScreen, 300, 600);

        BorderPane mapScreen = createMapScreen();
        mapScene = new Scene(mapScreen, 300, 600);

        GridPane fitnessScreen = createFitnessScreen();
        fitnessScene = new Scene(fitnessScreen, 300, 600);

        VBox dashboardScreen = createDashboardScreen();
        dashboardScene = new Scene(dashboardScreen, 300, 600);

        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Update clock
        updateClock();
    }

    private void updateClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            ((ImageView) ((HBox) ((VBox) mainScene.getRoot()).getChildren().get(0)).getChildren().get(0)).setImage(new Image(new ByteArrayInputStream((LocalDateTime.now().format(formatter)).getBytes())));
        }), new KeyFrame(Duration.seconds(1)));

        clockTimeline.setCycleCount(Animation.INDEFINITE);
        clockTimeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private VBox createMainScreen() {
        VBox mainScreen = new VBox(10);
        mainScreen.setAlignment(Pos.CENTER);

        HBox topBar = createTopBar();
        mainScreen.getChildren().add(topBar);


        Button dashboardButton = createButton("Dashboard");
        Button navigateButton = createButton("Navigate");
        Button historyButton = createButton("History");
        Button mapButton = createButton("Map");
        Button fitnessButton = createButton("Fitness");
        Button settingsButton = createButton("Settings");

        // Add event handlers for interactive buttons
        dashboardButton.setOnAction(event -> handleDashboardSectionClick());
        mapButton.setOnAction(event -> handleMapSectionClick());
        fitnessButton.setOnAction(event -> handleFitnessSectionClick());

        VBox buttonsLayout = new VBox(10);
        buttonsLayout.setAlignment(Pos.CENTER);
        buttonsLayout.getChildren().addAll(dashboardButton, navigateButton, historyButton, mapButton, fitnessButton, settingsButton);
        mainScreen.getChildren().add(buttonsLayout);

        return mainScreen;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-font-size: 16; -fx-background-color: lightgray; -fx-padding: 10;");
        return button;
    }

    private HBox createTopBar() {
        HBox topBar = new HBox(10);
        topBar.setAlignment(Pos.CENTER);

        // Add clock, battery, and Wi-Fi icons to the topBar
        Image clockIcon = new Image(getClass().getResourceAsStream("images/clock-event-history.png"), 16, 16, true, true);
        ImageView clockView = new ImageView(clockIcon);

        Image batteryIcon = new Image(getClass().getResourceAsStream("images/battery-icon-6.png"), 16, 16, true, true);
        ImageView batteryView = new ImageView(batteryIcon);

        Image networkIcon = new Image(getClass().getResourceAsStream("images/network-icon.png"), 16, 16, true, true);
        ImageView networkView = new ImageView(networkIcon);

        topBar.getChildren().addAll(clockView, batteryView, networkView);

        return topBar;
    }

    private VBox createDashboardScreen() {
        VBox dashboardScreen = new VBox(10);
        dashboardScreen.setAlignment(Pos.CENTER);

        HBox topBar = createTopBar();
        dashboardScreen.getChildren().add(topBar);

        // Add images and labels for each section
        Image bikeImage = new Image(getClass().getResourceAsStream("images/blue-bike-on-white.png"), 100, 100, true, true);
        ImageView bikeView = new ImageView(bikeImage);
        Label bikeLabel = new Label("Bike Status");

        Image navImage = new Image(getClass().getResourceAsStream("images/nav-icon.png"), 100, 100, true, true);
        ImageView navView = new ImageView(navImage);
        Label navLabel = new Label("Navigation");

        Image historyImage = new Image(getClass().getResourceAsStream("images/clock-event-history.png"), 100, 100, true, true);
        ImageView historyView = new ImageView(historyImage);
        Label historyLabel = new Label("History");

        Image settingsImage = new Image(getClass().getResourceAsStream("images/gear-icon.png"), 100, 100, true, true);
        ImageView settingsView = new ImageView(settingsImage);
        Label settingsLabel = new Label("Settings");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(bikeView, 0, 0);
        grid.add(bikeLabel, 0, 1);
        grid.add(navView, 1, 0);
        grid.add(navLabel, 1, 1);
        grid.add(historyView, 0, 2);
        grid.add(historyLabel, 0, 3);
        grid.add(settingsView, 1, 2);
        grid.add(settingsLabel, 1, 3);

        // Add a back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> handleBackButtonClick());
        dashboardScreen.getChildren().addAll(grid, backButton);

        return dashboardScreen;
    }

    private void handleDashboardSectionClick() {
        // Change the scene to the dashboard screen
        primaryStage.setScene(dashboardScene);
    }

    private BorderPane createMapScreen() {
        BorderPane mapScreen = new BorderPane();
        // Load the map image and create an ImageView to display it
        Image mapImage = new Image(getClass().getResourceAsStream("images/hendon-area.png"), 300, 575, false, false);
        ImageView mapView = new ImageView(mapImage);
        mapScreen.setCenter(mapView);

        // Add a back button at the bottom left
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> handleBackButtonClick());
        mapScreen.setBottom(backButton);
        BorderPane.setAlignment(backButton, Pos.BOTTOM_LEFT);

        return mapScreen;
    }

    private void handleMapSectionClick() {
        // Change the scene to the map screen
        primaryStage.setScene(mapScene);
    }

    private void handleFitnessSectionClick() {
        // Change the scene to the fitness screen
        primaryStage.setScene(fitnessScene);
    }

    private void handleBackButtonClick() {
        // Change the scene back to the main screen
        primaryStage.setScene(mainScene);
    }

    private GridPane createFitnessScreen() {
        GridPane fitnessScreen = new GridPane();
        fitnessScreen.setAlignment(Pos.CENTER);
        fitnessScreen.setHgap(10);
        fitnessScreen.setVgap(10);

        // Create labels for each section
        Label distanceLabel = new Label("Distance: " + distance + " km");
        Label timeLabel = new Label("Time: " + timeInMinutes + " min");
        Label caloriesLabel = new Label("Calories: " + (int) (distance * 50) + " kcal");
        Label hrZoneLabel = new Label("HR Zone: 130-150 BPM");
        Label powerZoneLabel = new Label("Power Zone: 200-300 W");
        Label stopLabel = new Label("Stop");

        // Add event handlers for interactive sections (Distance and Time)
        distanceLabel.setOnMouseClicked(event -> handleDistanceClick());
        timeLabel.setOnMouseClicked(event -> handleTimeClick());

        // Add labels to the fitness screen
        fitnessScreen.add(distanceLabel, 0, 0);
        fitnessScreen.add(timeLabel, 1, 0);
        fitnessScreen.add(caloriesLabel, 0, 1);
        fitnessScreen.add(hrZoneLabel, 1, 1);
        fitnessScreen.add(powerZoneLabel, 0, 2);
        fitnessScreen.add(stopLabel, 1, 2);

        // Add a back button
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> handleBackButtonClick());
        fitnessScreen.add(backButton, 0, 3);
        GridPane.setColumnSpan(backButton, 2);
        GridPane.setHalignment(backButton, javafx.geometry.HPos.CENTER);

        return fitnessScreen;
    }

    private void handleDistanceClick() {
        TextInputDialog distanceInputDialog = new TextInputDialog();
        distanceInputDialog.setTitle("Distance");
        distanceInputDialog.setHeaderText("Enter the distance (km):");

        Optional<String> distanceInput = distanceInputDialog.showAndWait();
        distanceInput.ifPresent(input -> {
            try {
                distance = Double.parseDouble(input);
                ((Label) fitnessScene.lookup("#distanceLabel")).setText("Distance: " + distance + " km");
            } catch (NumberFormatException e) {
                showAlert("Invalid input", "Please enter a valid number for distance.");
            }
        });
    }

    private void handleTimeClick() {
        TextInputDialog timeInputDialog = new TextInputDialog();
        timeInputDialog.setTitle("Time");
        timeInputDialog.setHeaderText("Enter the time (minutes):");

        Optional<String> timeInput = timeInputDialog.showAndWait();
        timeInput.ifPresent(input -> {
            try {
                timeInMinutes = Integer.parseInt(input);
                ((Label) fitnessScene.lookup("#timeLabel")).setText("Time: " + timeInMinutes + " min");
            } catch (NumberFormatException e) {
                showAlert("Invalid input", "Please enter a valid number for time.");
            }
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

