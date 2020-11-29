package dad.javafx.ventanamemoria;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

private Stage stage;
	
	//view
    @FXML
    private GridPane view;

    @FXML
    private Slider redSl;

    @FXML
    private Slider greenSl;

    @FXML
    private Slider blueSl;

    //model
    private Model model = new Model();
    
	public Controller(Properties properties) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		
		model.setColorRed(Integer.valueOf((String) properties.get("background.red")));
		model.setColorGreen(Integer.valueOf((String) properties.get("background.green")));
		model.setColorBlue(Integer.valueOf((String) properties.get("background.blue")));
		model.setWidth(Double.valueOf((String) properties.get("size.width")));
		model.setHeight(Double.valueOf((String) properties.get("size.height")));
		model.setLocationX(Double.valueOf((String) properties.get("location.x")));
		model.setLocationY(Double.valueOf((String) properties.get("location.y")));
	}
    
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(redSl.valueProperty(), model.colorRedProperty());
		redSl.valueProperty().addListener(e -> cambiarValor(e));
		Bindings.bindBidirectional(greenSl.valueProperty(), model.colorGreenProperty());
		greenSl.valueProperty().addListener(e -> cambiarValor(e));
		Bindings.bindBidirectional(blueSl.valueProperty(), model.colorBlueProperty());
		blueSl.valueProperty().addListener(e -> cambiarValor(e));
		
		view.setStyle("-fx-background-color: rgb(" + model.getColorRed() 
		+ "," + model.getColorGreen() + "," + model.getColorBlue() + ");");
	}
	
	public void ListenerStage (Stage primaryStage) {
		stage = primaryStage;
		
		stage.widthProperty().addListener(e -> cambiarTamaño(e));
		stage.heightProperty().addListener(e -> cambiarTamaño(e));
		stage.xProperty().addListener(e -> cambiarPosicion(e));
		stage.yProperty().addListener(e -> cambiarPosicion(e));
	}
	
	private void cambiarValor(Observable e) {
		view.setStyle("-fx-background-color: rgb(" + model.getColorRed() 
		+ "," + model.getColorGreen() + "," + model.getColorBlue() + ");");
	}
	
	private void cambiarPosicion(Observable e) {
		model.setLocationX(stage.getX());
		model.setLocationY(stage.getY());
	}
	
	private void cambiarTamaño(Observable e) {
		model.setHeight(stage.getHeight());
		model.setWidth(stage.getWidth());
	}

	public GridPane getView() {
		return view;
	}

	public void setView(GridPane view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
}
