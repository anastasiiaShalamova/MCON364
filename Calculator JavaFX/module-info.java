module MCONJFXTest {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.xml;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;

	opens coverAppWithThumbsWithCSS to javafx.graphics, javafx.fxml;
	opens deitelColorChooser to javafx.graphics, javafx.fxml;
	opens deitelPainter to javafx.graphics, javafx.fxml;
	opens rectAnimation to javafx.graphics, javafx.fxml;
	opens bunnyAnimation to javafx.graphics, javafx.fxml;

	opens Calculator to javafx.graphics, javafx.fxml;
}
