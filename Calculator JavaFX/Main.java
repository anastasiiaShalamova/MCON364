package Calculator;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\student\\eclipse-workspace\\MCONJFXTest\\src\\Calculator\\main.fxml"));
			Scene mainScene = new Scene(root,300,350);
			primaryStage.setTitle("Demo CalculatorT");
			primaryStage.setScene(mainScene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

