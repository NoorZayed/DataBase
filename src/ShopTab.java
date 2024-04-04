
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShopTab {
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";

	private TableView<ShopTable> tableView = new TableView<>();
	private TableColumn<ShopTable, String> shopNameColumn = new TableColumn<>("Shop Name");
	private TableColumn<ShopTable, String> phoneNumberColumn = new TableColumn<>("Phone Number");
	private TableColumn<ShopTable, String> addressColumn = new TableColumn<>("Address");
	private Button button1 = new Button("Add Shop");
	private Button button2 = new Button("Remove Shop");
	private Button button3 = new Button("Update Shop");
	private Button button4 = new Button("Add Employee");
	private Button button5 = new Button("Remove Employee");
	private Button button6 = new Button("Update Employee");
	private Button backButton = new Button("Back");

	private HBox hbox1 = new HBox(button1, button2, button3);
	private HBox hbox2 = new HBox(button4, button5, button6);
	private VBox vbox = new VBox(tableView, hbox1, hbox2);
	private Tab shopTab = new Tab("Shop");

	ShopTab() {
		// Create TableView and columns

		shopNameColumn.setCellValueFactory(new PropertyValueFactory<>("shopname"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phonenum"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

		tableView.getColumns().addAll(shopNameColumn, phoneNumberColumn, addressColumn);
		shopNameColumn.setPrefWidth(150); // Adjust as needed
		phoneNumberColumn.setPrefWidth(150); // Adjust as needed
		addressColumn.setPrefWidth(150); // Adjust as needed

		tableView.setStyle(cellStyle);
        tableView.setSelectionModel(null);
		// Apply styling to the TableView columns
//		for (TableColumn<ShopTable, ?> column : tableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: white;");
//		}

		// Create buttons

		button1.setMinSize(150, 50);
		button1.setStyle(style);

		button2.setMinSize(150, 50);
		button2.setStyle(style);

		button3.setMinSize(150, 50);
		button3.setStyle(style);

		button6.setMinSize(150, 50);
		button6.setStyle(style);

		button4.setMinSize(150, 50);
		button4.setStyle(style);

		button5.setMinSize(150, 50);
		button5.setStyle(style);
		// Create HBoxes and VBox

		hbox1.setSpacing(10);
		hbox2.setSpacing(10);

		// Ensure additionalPane is initialized before adding it to the VBox
		vbox.setSpacing(15);

		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);

		// Create a Back button
		backButton.setAlignment(Pos.CENTER);
		// Add event handler for the Back button
		backButton.setOnAction(event -> {
			// Handle back button action (e.g., switch to another scene)
			System.out.println("Back button clicked");
		});
		backButton.setMinSize(150, 50);
		backButton.setStyle(style);
		// Add the Back button to the bottom of the VBox
		vbox.getChildren().add(backButton);

//		button1.setOnAction(event -> {
////			showAdditionalPane();
////			createAdditionalStage();
////			additionalStage.setTitle("Add A Shop");
//
//		});
//		button2.setOnAction(event -> {
//			createRemoveShopStage();
//		});
//
//		button3.setOnAction(event -> {
//			showAdditionalPane();
//			createAdditionalStage();
//			additionalStage.setTitle("Update A Shop");
//
//		});
		// Create a Tab and set its content
		shopTab.setContent(vbox);

	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public TableView<ShopTable> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<ShopTable> tableView) {
		this.tableView = tableView;
	}

	public TableColumn<ShopTable, String> getShopNameColumn() {
		return shopNameColumn;
	}

	public void setShopNameColumn(TableColumn<ShopTable, String> shopNameColumn) {
		this.shopNameColumn = shopNameColumn;
	}

	public TableColumn<ShopTable, String> getPhoneNumberColumn() {
		return phoneNumberColumn;
	}

	public void setPhoneNumberColumn(TableColumn<ShopTable, String> phoneNumberColumn) {
		this.phoneNumberColumn = phoneNumberColumn;
	}

	public TableColumn<ShopTable, String> getAddressColumn() {
		return addressColumn;
	}

	public void setAddressColumn(TableColumn<ShopTable, String> addressColumn) {
		this.addressColumn = addressColumn;
	}

	public Button getButton1() {
		return button1;
	}

	public void setButton1(Button button1) {
		this.button1 = button1;
	}

	public Button getButton2() {
		return button2;
	}

	public void setButton2(Button button2) {
		this.button2 = button2;
	}

	public Button getButton3() {
		return button3;
	}

	public void setButton3(Button button3) {
		this.button3 = button3;
	}

	public Button getButton4() {
		return button4;
	}

	public void setButton4(Button button4) {
		this.button4 = button4;
	}

	public Button getButton5() {
		return button5;
	}

	public void setButton5(Button button5) {
		this.button5 = button5;
	}

	public Button getButton6() {
		return button6;
	}

	public void setButton6(Button button6) {
		this.button6 = button6;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public HBox getHbox1() {
		return hbox1;
	}

	public void setHbox1(HBox hbox1) {
		this.hbox1 = hbox1;
	}

	public HBox getHbox2() {
		return hbox2;
	}

	public void setHbox2(HBox hbox2) {
		this.hbox2 = hbox2;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Tab getShopTab() {
		return shopTab;
	}

	public void setShopTab(Tab shopTab) {
		this.shopTab = shopTab;
	}

}
