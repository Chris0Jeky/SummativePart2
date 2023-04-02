
package task3;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ApplicationRunner extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene mapScene;
    private Scene fitnessScene;

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

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



    private VBox createMainScreen() {
        VBox mainScreen = new VBox();

        HBox topBar = createTopBar();
        mainScreen.getChildren().add(topBar);

        Button dashboardButton = createButton("Dashboard");
        Button navigateButton = createButton("Navigate");
        Button historyButton = createButton("History");
        Button mapButton = createButton("Map");
        Button fitnessButton = createButton("Fitness");
        Button settingsButton = createButton("Settings");

        // Add event handlers for interactive buttons
        mapButton.setOnAction(event -> handleMapSectionClick());
        fitnessButton.setOnAction(event -> handleFitnessSectionClick());
        historyButton.setOnAction(event -> handleHistorySectionClick());

        VBox buttonsLayout = new VBox();
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
        HBox topBar = new HBox();
        // Add clock, battery, and Wi-Fi icons to the topBar
        return topBar;
    }




    private BorderPane createMapScreen() {
        BorderPane mapScreen = new BorderPane();

        // Load the map image and create an ImageView to display it
        Image mapImage = new Image("com/yourname/cyclingapp/images/map_image.png");
        ImageView mapView = new ImageView(mapImage);
        mapScreen.setCenter(mapView);

        // Add a back button at the bottom left
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> handleBackButtonClick());
        mapScreen.setBottom(backButton);

        return mapScreen;
    }


    private BorderPane createMapScreen() {
        BorderPane mapScreen = new BorderPane();

        // Load the map image and create an ImageView to display it
        Image mapImage = new Image("com/yourname/cyclingapp/images/map_image.png");
        ImageView mapView = new ImageView(mapImage);
        mapScreen.setCenter(mapView);

        // Add a back button at the bottom left
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> handleBackButtonClick());
        mapScreen.setBottom(backButton);

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


    private void handleHistorySectionClick() {
        // Display stored ride data
    }

    private void updateClock(Label clockLabel) {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            clockLabel.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));

        clockTimeline.setCycleCount(Animation.INDEFINITE);
        clockTimeline.play();
    }


    private void handleBackButtonClick() {
        // Change the scene back to the main screen
        primaryStage.setScene(mainScene);
    }


}
