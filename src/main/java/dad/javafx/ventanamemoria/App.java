package dad.javafx.ventanamemoria;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

private Controller c;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(c.getView(), 250, 200);
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.setX(c.getModel().getLocationX());
		primaryStage.setY(c.getModel().getLocationY());
		primaryStage.show();
		c.ListenerStage(primaryStage);
	}

	@Override
	public void init() throws Exception {
		String rutaPerfil = System.getProperty("user.home");
		Properties properties = new Properties();
		File ficheroConfig = new File(rutaPerfil + "\\.VentanaConMemoria\\ventana.config");
		
		if (!ficheroConfig.getParentFile().exists() && !ficheroConfig.getParentFile().mkdirs())
			throw new IllegalStateException("No se pudo crear la carpeta .VentanaConMemoria");
		
		if (ficheroConfig.createNewFile()) {
			configInicial(ficheroConfig);
		}
		
		properties.load(new FileInputStream(ficheroConfig));
		c = new Controller(properties);
	}

	private void configInicial(File ficheroConfig) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(ficheroConfig));
		String configuracionInicial = "";
		configuracionInicial += "background.red=206\n";
		configuracionInicial += "background.green=60\n";
		configuracionInicial += "background.blue=63\n";
		configuracionInicial += "size.width=428\n";
		configuracionInicial += "size.height=278\n";
		configuracionInicial += "location.x=440\n";
		configuracionInicial += "location.y=244";
		
		bWriter.write(configuracionInicial);
		bWriter.close();
	}
	
	@Override
	public void stop() throws Exception {
		String rutaPerfil = System.getProperty("user.home");
		Properties properties = new Properties();
		File ficheroConfig = new File(rutaPerfil + "\\.VentanaConMemoria\\ventana.config");
		Model model = c.getModel();
		
		if (!ficheroConfig.getParentFile().exists() && !ficheroConfig.getParentFile().mkdirs())
			throw new IllegalStateException("No se pudo crear la carpeta .VentanaConMemoria");
		
		// Creamos el fichero en caso de no existir
		ficheroConfig.createNewFile();
		
		properties.setProperty("background.red", String.valueOf(model.getColorRed()));
		properties.setProperty("background.green", String.valueOf(model.getColorGreen()));
		properties.setProperty("background.blue", String.valueOf(model.getColorBlue()));
		properties.setProperty("size.width", String.valueOf(model.getWidth()));
		properties.setProperty("size.height", String.valueOf(model.getHeight()));
		properties.setProperty("location.x", String.valueOf(model.getLocationX()));
		properties.setProperty("location.y", String.valueOf(model.getLocationY()));
		
		properties.store(new FileWriter(ficheroConfig), null);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
