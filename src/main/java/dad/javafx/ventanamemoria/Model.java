package dad.javafx.ventanamemoria;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {

	private IntegerProperty colorRed = new SimpleIntegerProperty();
	private IntegerProperty colorBlue = new SimpleIntegerProperty();
	private IntegerProperty colorGreen = new SimpleIntegerProperty();
	private DoubleProperty width = new SimpleDoubleProperty();
	private DoubleProperty height = new SimpleDoubleProperty();
	private DoubleProperty locationX = new SimpleDoubleProperty();
	private DoubleProperty locationY = new SimpleDoubleProperty();
	
	
	public final IntegerProperty colorRedProperty() {
		return this.colorRed;
	}
	
	public final int getColorRed() {
		return this.colorRedProperty().get();
	}
	
	public final void setColorRed(final int colorRed) {
		this.colorRedProperty().set(colorRed);
	}
	
	public final IntegerProperty colorBlueProperty() {
		return this.colorBlue;
	}
	
	public final int getColorBlue() {
		return this.colorBlueProperty().get();
	}
	
	public final void setColorBlue(final int colorBlue) {
		this.colorBlueProperty().set(colorBlue);
	}
	
	public final IntegerProperty colorGreenProperty() {
		return this.colorGreen;
	}
	
	public final int getColorGreen() {
		return this.colorGreenProperty().get();
	}
	
	public final void setColorGreen(final int colorGreen) {
		this.colorGreenProperty().set(colorGreen);
	}
	
	public final DoubleProperty widthProperty() {
		return this.width;
	}
	
	public final double getWidth() {
		return this.widthProperty().get();
	}
	
	public final void setWidth(final double width) {
		this.widthProperty().set(width);
	}
	
	public final DoubleProperty heightProperty() {
		return this.height;
	}
	
	public final double getHeight() {
		return this.heightProperty().get();
	}
	
	public final void setHeight(final double height) {
		this.heightProperty().set(height);
	}
	
	public final DoubleProperty locationXProperty() {
		return this.locationX;
	}
	
	public final double getLocationX() {
		return this.locationXProperty().get();
	}
	
	public final void setLocationX(final double locationX) {
		this.locationXProperty().set(locationX);
	}
	
	public final DoubleProperty locationYProperty() {
		return this.locationY;
	}
	
	public final double getLocationY() {
		return this.locationYProperty().get();
	}
	
	public final void setLocationY(final double locationY) {
		this.locationYProperty().set(locationY);
	}
	
}
