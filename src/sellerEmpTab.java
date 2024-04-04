
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class sellerEmpTab {
	String style2 = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";
	private TableView<SellerEmpTable> tableView = new TableView<>();
	private TableColumn<SellerEmpTable, String> empeemailColumn = new TableColumn<>("Email");
	private TableColumn<SellerEmpTable, String> empphoneColumn = new TableColumn<>("Phone Number");
	private TableColumn<SellerEmpTable, String> sellidColumn = new TableColumn<>("Seller ID");
	private TableColumn<SellerEmpTable, Integer> empageColumn = new TableColumn<>("Age");
	private TableColumn<SellerEmpTable, String> empaddressColumn = new TableColumn<>("Address");
	private TableColumn<SellerEmpTable, String> empnameColumn = new TableColumn<>("Name");
	private TableColumn<SellerEmpTable, String> ShopnameColumn = new TableColumn<>("Shop Name");
	private TableColumn<SellerEmpTable, String> empgenderColumn = new TableColumn<>("Gender");

	// private Button backButton = new Button("Back");
	private Button addcomputer = new Button("Add Computer");
	private Button removecomputer = new Button("Remove Computer");
	private Button updatecomputer = new Button("Update Computer");
	private HBox hb = new HBox(addcomputer, removecomputer, updatecomputer);
	private VBox vbox = new VBox(tableView, hb);
	private Tab sellerEmp = new Tab(" Seller ");// done
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";

	sellerEmpTab() {
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER);

		empeemailColumn.setCellValueFactory(new PropertyValueFactory<>("empeemail"));
		empphoneColumn.setCellValueFactory(new PropertyValueFactory<>("empphone"));
		sellidColumn.setCellValueFactory(new PropertyValueFactory<>("sellid"));
		empageColumn.setCellValueFactory(new PropertyValueFactory<>("empage"));
		empaddressColumn.setCellValueFactory(new PropertyValueFactory<>("empaddress"));
		empnameColumn.setCellValueFactory(new PropertyValueFactory<>("empname"));
		ShopnameColumn.setCellValueFactory(new PropertyValueFactory<>("shopname"));
		empgenderColumn.setCellValueFactory(new PropertyValueFactory<>("empgender"));

		tableView.getColumns().addAll(empeemailColumn, empphoneColumn, sellidColumn, empageColumn, empaddressColumn,
				empnameColumn, ShopnameColumn, empgenderColumn);
		empphoneColumn.setPrefWidth(150);
		// Apply styling to the TableView
		tableView.setStyle(cellStyle);
		tableView.setSelectionModel(null);
		// Apply styling to the TableView columns
//		for (TableColumn<SellerEmpTable, ?> column : tableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: white;");
//		}

		// Ensure additionalPane is initialized before adding it to the VBox
		vbox.setSpacing(15);
		addcomputer.setOnAction(e -> {
			AddComputer add = new AddComputer();
			add.AddComputere();
		});
		removecomputer.setOnAction(e -> {
			Deletecompass delcomp = new Deletecompass();
			delcomp.detailsStage.show();
		});
		updatecomputer.setOnAction(e -> {
			UpdateComputer update = new UpdateComputer();
			update.UpdateCompuere();
		});
		// Create a Back button
		// backButton.setAlignment(Pos.CENTER);
		// Add event handler for the Back button
//		backButton.setOnAction(event -> {
//			// Handle back button action (e.g., switch to another scene)
//			System.out.println("Back button clicked");
//		});

//		backButton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
//		backButton.setMinSize(150, 50);
//		backButton.setStyle(style);
//		backButton.setTextFill(Color.WHITE);

//		addcomputer.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
//		addcomputer.setMinSize(150, 50);
//		addcomputer.setStyle(style);
//		addcomputer.setTextFill(Color.WHITE);
//		
//		removecomputer.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
//		removecomputer.setMinSize(150, 50);
//		removecomputer.setStyle(style);
//		removecomputer.setTextFill(Color.WHITE);
//		
//		updatecomputer.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
//		updatecomputer.setMinSize(150, 50);
//		updatecomputer.setStyle(style);
//		updatecomputer.setTextFill(Color.WHITE);

		addcomputer.setStyle(style2);
		removecomputer.setStyle(style2);
		updatecomputer.setStyle(style2);

		// Add the Back button to the bottom of the VBox
		// vbox.getChildren().add(backButton);
		sellerEmp.setContent(vbox);
	}

	public TableView<SellerEmpTable> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<SellerEmpTable> tableView) {
		this.tableView = tableView;
	}

	public TableColumn<SellerEmpTable, String> getEmpeemailColumn() {
		return empeemailColumn;
	}

	public void setEmpeemailColumn(TableColumn<SellerEmpTable, String> empeemailColumn) {
		this.empeemailColumn = empeemailColumn;
	}

	public TableColumn<SellerEmpTable, String> getEmpphoneColumn() {
		return empphoneColumn;
	}

	public void setEmpphoneColumn(TableColumn<SellerEmpTable, String> empphoneColumn) {
		this.empphoneColumn = empphoneColumn;
	}

	public TableColumn<SellerEmpTable, String> getSellidColumn() {
		return sellidColumn;
	}

	public void setSellidColumn(TableColumn<SellerEmpTable, String> sellidColumn) {
		this.sellidColumn = sellidColumn;
	}

	public TableColumn<SellerEmpTable, Integer> getEmpageColumn() {
		return empageColumn;
	}

	public void setEmpageColumn(TableColumn<SellerEmpTable, Integer> empageColumn) {
		this.empageColumn = empageColumn;
	}

	public TableColumn<SellerEmpTable, String> getEmpaddressColumn() {
		return empaddressColumn;
	}

	public void setEmpaddressColumn(TableColumn<SellerEmpTable, String> empaddressColumn) {
		this.empaddressColumn = empaddressColumn;
	}

	public TableColumn<SellerEmpTable, String> getEmpnameColumn() {
		return empnameColumn;
	}

	public void setEmpnameColumn(TableColumn<SellerEmpTable, String> empnameColumn) {
		this.empnameColumn = empnameColumn;
	}

	public TableColumn<SellerEmpTable, String> getShopnameColumn() {
		return ShopnameColumn;
	}

	public void setShopnameColumn(TableColumn<SellerEmpTable, String> shopnameColumn) {
		ShopnameColumn = shopnameColumn;
	}

	public TableColumn<SellerEmpTable, String> getEmpgenderColumn() {
		return empgenderColumn;
	}

	public void setEmpgenderColumn(TableColumn<SellerEmpTable, String> empgenderColumn) {
		this.empgenderColumn = empgenderColumn;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

//	public Button getBackButton() {
//		return backButton;
//	}
//
//	public void setBackButton(Button backButton) {
//		this.backButton = backButton;
//	}

	public Tab getSellerEmp() {
		return sellerEmp;
	}

	public void setSellerEmp(Tab sellerEmp) {
		this.sellerEmp = sellerEmp;
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

	public Button getAddcomputer() {
		return addcomputer;
	}

	public Button getRemovecomputer() {
		return removecomputer;
	}

	public Button getUpdatecomputer() {
		return updatecomputer;
	}

	public HBox getHb() {
		return hb;
	}

	public void setAddcomputer(Button addcomputer) {
		this.addcomputer = addcomputer;
	}

	public void setRemovecomputer(Button removecomputer) {
		this.removecomputer = removecomputer;
	}

	public void setUpdatecomputer(Button updatecomputer) {
		this.updatecomputer = updatecomputer;
	}

	public void setHb(HBox hb) {
		this.hb = hb;
	}

}
