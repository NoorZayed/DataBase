import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class RepairEmpTab {
	private TableView<RepEmpTable> tableView = new TableView<>();
	private TableColumn<RepEmpTable, String> empeemailColumn = new TableColumn<>("Email");
	private TableColumn<RepEmpTable, String> empphoneColumn = new TableColumn<>("Phone Number");
	private TableColumn<RepEmpTable, String> repidColumn = new TableColumn<>("Repair ID");
	private TableColumn<RepEmpTable, Integer> empageColumn = new TableColumn<>("Age");
	private TableColumn<RepEmpTable, String> empaddressColumn = new TableColumn<>("Address");
	private TableColumn<RepEmpTable, String> empnameColumn = new TableColumn<>("Name");
	private TableColumn<RepEmpTable, String> ShopnameColumn = new TableColumn<>("Shop Name");
	private TableColumn<RepEmpTable, String> empgenderColumn = new TableColumn<>("Gender");
	private VBox vbox = new VBox(tableView);
	private Tab repairEmp = new Tab(" Repair ");

	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";

	RepairEmpTab() {

		empeemailColumn.setCellValueFactory(new PropertyValueFactory<>("empeemail"));
		empphoneColumn.setCellValueFactory(new PropertyValueFactory<>("empphone"));
		repidColumn.setCellValueFactory(new PropertyValueFactory<>("repid"));
		empageColumn.setCellValueFactory(new PropertyValueFactory<>("empage"));
		empaddressColumn.setCellValueFactory(new PropertyValueFactory<>("empaddress"));
		empnameColumn.setCellValueFactory(new PropertyValueFactory<>("empname"));
		ShopnameColumn.setCellValueFactory(new PropertyValueFactory<>("shopname"));
		empgenderColumn.setCellValueFactory(new PropertyValueFactory<>("empgender"));

		tableView.getColumns().addAll(empeemailColumn, empphoneColumn, repidColumn, empageColumn, empaddressColumn,
				empnameColumn, ShopnameColumn, empgenderColumn);
		empphoneColumn.setPrefWidth(150);
		// Apply styling to the TableView
		tableView.setStyle(cellStyle);

		// Apply styling to the TableView columns
//		for (TableColumn<RepEmpTable, ?> column : tableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: white;");
//		}

		// Ensure additionalPane is initialized before adding it to the VBox
		vbox.setSpacing(15);

		// Create a Back button
//		backButton.setAlignment(Pos.CENTER);
		// Add event handler for the Back button
//		backButton.setOnAction(event -> {
//			// Handle back button action (e.g., switch to another scene)
//			System.out.println("Back button clicked");
//		});

//		backButton.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
//		backButton.setMinSize(150, 50);
//		backButton.setStyle(style);
//		backButton.setTextFill(Color.WHITE);
//		// Add the Back button to the bottom of the VBox
//		vbox.getChildren().add(backButton);
		repairEmp.setContent(vbox);

	}

	public TableView<RepEmpTable> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<RepEmpTable> tableView) {
		this.tableView = tableView;
	}

	public TableColumn<RepEmpTable, String> getEmpeemailColumn() {
		return empeemailColumn;
	}

	public void setEmpeemailColumn(TableColumn<RepEmpTable, String> empeemailColumn) {
		this.empeemailColumn = empeemailColumn;
	}

	public TableColumn<RepEmpTable, String> getEmpphoneColumn() {
		return empphoneColumn;
	}

	public void setEmpphoneColumn(TableColumn<RepEmpTable, String> empphoneColumn) {
		this.empphoneColumn = empphoneColumn;
	}

	public TableColumn<RepEmpTable, String> getrepidColumn() {
		return repidColumn;
	}

	public void setrepidColumn(TableColumn<RepEmpTable, String> sellidColumn) {
		this.repidColumn = sellidColumn;
	}

	public TableColumn<RepEmpTable, Integer> getEmpageColumn() {
		return empageColumn;
	}

	public void setEmpageColumn(TableColumn<RepEmpTable, Integer> empageColumn) {
		this.empageColumn = empageColumn;
	}

	public TableColumn<RepEmpTable, String> getEmpaddressColumn() {
		return empaddressColumn;
	}

	public void setEmpaddressColumn(TableColumn<RepEmpTable, String> empaddressColumn) {
		this.empaddressColumn = empaddressColumn;
	}

	public TableColumn<RepEmpTable, String> getEmpnameColumn() {
		return empnameColumn;
	}

	public void setEmpnameColumn(TableColumn<RepEmpTable, String> empnameColumn) {
		this.empnameColumn = empnameColumn;
	}

	public TableColumn<RepEmpTable, String> getShopnameColumn() {
		return ShopnameColumn;
	}

	public void setShopnameColumn(TableColumn<RepEmpTable, String> shopnameColumn) {
		ShopnameColumn = shopnameColumn;
	}

	public TableColumn<RepEmpTable, String> getEmpgenderColumn() {
		return empgenderColumn;
	}

	public void setEmpgenderColumn(TableColumn<RepEmpTable, String> empgenderColumn) {
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

	public Tab getRepairEmp() {
		return repairEmp;
	}

	public void setRepairEmp(Tab repairEmp) {
		this.repairEmp = repairEmp;
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
}
