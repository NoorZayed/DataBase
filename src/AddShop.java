
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AddShop {
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";
	private Label name = new Label("Name :");
	private Label phone = new Label("Phone :");
	private Label address = new Label("Address :");
	private TextField textField1 = new TextField();
	private TextField textField2 = new TextField();
	private TextField textField3 = new TextField();
	private Button okButton = new Button("OK");
	private Button cancel = new Button("Cancel");
	
	private GridPane gridPane = new GridPane();

	AddShop() {
		// Create labels, text fields, and an "OK" button

		name.setFont(Font.font(20));
		name.setTextFill(Color.BLACK);

		phone.setFont(Font.font(20));
		phone.setTextFill(Color.BLACK);

		address.setFont(Font.font(20));
		address.setTextFill(Color.BLACK);

//		okButton.setOnAction(event -> handleOkButton());
		okButton.setStyle(style);
cancel.setStyle(style);
		// Create the additional pane (GridPane)
		gridPane.addRow(0, name, textField1);
		gridPane.addRow(1, phone, textField2);
		gridPane.addRow(2, address, textField3);
		gridPane.add(okButton, 0, 3, 2, 1);
		gridPane.add(cancel, 2, 3, 2, 1);// Span the "OK" button across two columns

		// Apply styling to the additional pane
		Image backgroundImage = new Image("shop.jpeg");
		BackgroundSize backgroundSize = new BackgroundSize(400, 250, false, false, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, backgroundSize);

		gridPane.setBackground(new Background(background));

		// Set padding and spacing
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);

	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public Label getName() {
		return name;
	}

	public void setName(Label name) {
		this.name = name;
	}

	public Label getPhone() {
		return phone;
	}

	public void setPhone(Label phone) {
		this.phone = phone;
	}

	public Label getAddress() {
		return address;
	}

	public void setAddress(Label address) {
		this.address = address;
	}

	public TextField getTextField1() {
		return textField1;
	}

	public void setTextField1(TextField textField1) {
		this.textField1 = textField1;
	}

	public TextField getTextField2() {
		return textField2;
	}

	public void setTextField2(TextField textField2) {
		this.textField2 = textField2;
	}

	public TextField getTextField3() {
		return textField3;
	}

	public void setTextField3(TextField textField3) {
		this.textField3 = textField3;
	}

	public Button getOkButton() {
		return okButton;
	}

	public void setOkButton(Button okButton) {
		this.okButton = okButton;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}
	
}

