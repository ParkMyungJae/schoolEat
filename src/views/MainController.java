package views;

import java.io.File;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import lunch.Parser;

public class MainController {
	@FXML
	private DatePicker picDate;
	
	@FXML
	private Label menuLabel;
	
	private Parser parser;
	
	private Image good;
	private Image bad;
	
	public MainController() {
		parser = new Parser();
		
		File goodFile = new File("src/img/happy.png");
		File badFile = new File("src/img/sad.png");
		
//		good = new Image(goodFile.toURL().toString());
//		bad = new Image(badFile.toURL().toString());
	}
	
	public void getMenu() {
		LocalDate date = picDate.getValue();
		
		if(date == null) {
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("알림창");
			a.setHeaderText(null);
			a.setContentText("날짜를 입력하세요");
			
			a.show();
			return;
		}
		
		String menu = parser.getMenu(date);
		String result = "";
		
		String[] arrMenu = menu.split("\\.");
		
		for(int i = 0; i < arrMenu.length; i++) {
			result += arrMenu[i] + "\n";
		}
		
		menuLabel.setText(result);
	}
	
}
