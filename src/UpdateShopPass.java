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

public class UpdateShopPass {
	private Label upShopLabel = new Label("Enter the shop name:");
	private TextField shopNameTextField = new TextField();
	private Button upShopOkButton = new Button("OK");
	private Button cancel = new Button("Cancel");
	
	private GridPane upShopPane = new GridPane();
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";

	UpdateShopPass() {

		// Create labels, text fields, and an "OK" button
		upShopLabel.setFont(Font.font(20));
		upShopLabel.setTextFill(Color.BLACK);

		upShopOkButton.setStyle(style);
		cancel.setStyle(style);
		// Create the additional pane (GridPane) for removing a shop
		upShopPane.addRow(0, upShopLabel, shopNameTextField);
		upShopPane.add(upShopOkButton, 0, 1, 2, 1);
		upShopPane.add(cancel, 1, 1, 2, 1);

		// Apply styling to the additional pane for removing a shop
//		upShopPane.setStyle("-fx-background-color: black; " + "-fx-text-fill: white; ");
		Image backgroundImage = new Image("shop.jpeg");
		BackgroundSize backgroundSize = new BackgroundSize(400, 250, false, false, false, false);
		BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, backgroundSize);

		upShopPane.setBackground(new Background(background));

		// Set padding and spacing
		upShopPane.setPadding(new Insets(10));
		upShopPane.setHgap(10);
		upShopPane.setVgap(10);

	}

	public Label getUpShopLabel() {
		return upShopLabel;
	}

	public TextField getShopNameTextField() {
		return shopNameTextField;
	}

	public Button getUpShopOkButton() {
		return upShopOkButton;
	}

	public Button getCancel() {
		return cancel;
	}

	public GridPane getUpShopPane() {
		return upShopPane;
	}

	public String getCellStyle() {
		return cellStyle;
	}

	public String getStyle() {
		return style;
	}

	public void setUpShopLabel(Label upShopLabel) {
		this.upShopLabel = upShopLabel;
	}

	public void setShopNameTextField(TextField shopNameTextField) {
		this.shopNameTextField = shopNameTextField;
	}

	public void setUpShopOkButton(Button upShopOkButton) {
		this.upShopOkButton = upShopOkButton;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public void setUpShopPane(GridPane upShopPane) {
		this.upShopPane = upShopPane;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	

	
}
