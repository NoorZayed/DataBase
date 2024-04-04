
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Mixed2Tab {
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	private TableView<BuysTable> mixedTableView = new TableView<>();
	private TableColumn<BuysTable, String> custNameColumn = new TableColumn<>("Customer Name");
	private TableColumn<BuysTable, String> customerIdColumn = new TableColumn<>("Customer ID");
	private TableColumn<BuysTable, String> sellerIdColumn = new TableColumn<>("Seller ID");
	private TableColumn<BuysTable, String> serialNumColumn = new TableColumn<>("Serial Number");
	private TableColumn<BuysTable, String> sellerNameColumn = new TableColumn<>("Seller Name");
	private TableColumn<BuysTable, String> modelColumn = new TableColumn<>("Model");
	private TableColumn<BuysTable, Double> priceColumn = new TableColumn<>("Price");
	private VBox vbox = new VBox(mixedTableView);
	private Tab mixedTab = new Tab("Sold Computers");

	Mixed2Tab() {
		// Create TableView and columns for mixed data

		custNameColumn.setCellValueFactory(new PropertyValueFactory<>("custname"));
		customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("custid"));
		sellerIdColumn.setCellValueFactory(new PropertyValueFactory<>("sellid"));
		serialNumColumn.setCellValueFactory(new PropertyValueFactory<>("serialnum"));
		sellerNameColumn.setCellValueFactory(new PropertyValueFactory<>("sellname"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		mixedTableView.getColumns().addAll(custNameColumn, customerIdColumn, sellerIdColumn, serialNumColumn,
				sellerNameColumn, modelColumn, priceColumn);

		// Apply styling to the TableView
		mixedTableView.setStyle(cellStyle);
		mixedTableView.setSelectionModel(null);
		serialNumColumn.setPrefWidth(120);

		// Apply styling to the TableView columns
//		for (TableColumn<BuysTable, ?> column : mixedTableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: white;");
//		}

		// Create a VBox to hold the mixed TableView
		vbox.setSpacing(15);

		// Create a Tab and set its content
		mixedTab.setContent(vbox);

	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public TableView<BuysTable> getMixedTableView() {
		return mixedTableView;
	}

	public void setMixedTableView(TableView<BuysTable> mixedTableView) {
		this.mixedTableView = mixedTableView;
	}

	public TableColumn<BuysTable, String> getCustNameColumn() {
		return custNameColumn;
	}

	public void setCustNameColumn(TableColumn<BuysTable, String> custNameColumn) {
		this.custNameColumn = custNameColumn;
	}

	public TableColumn<BuysTable, String> getCustomerIdColumn() {
		return customerIdColumn;
	}

	public void setCustomerIdColumn(TableColumn<BuysTable, String> customerIdColumn) {
		this.customerIdColumn = customerIdColumn;
	}

	public TableColumn<BuysTable, String> getSellerIdColumn() {
		return sellerIdColumn;
	}

	public void setSellerIdColumn(TableColumn<BuysTable, String> sellerIdColumn) {
		this.sellerIdColumn = sellerIdColumn;
	}

	public TableColumn<BuysTable, String> getSerialNumColumn() {
		return serialNumColumn;
	}

	public void setSerialNumColumn(TableColumn<BuysTable, String> serialNumColumn) {
		this.serialNumColumn = serialNumColumn;
	}

	public TableColumn<BuysTable, String> getSellerNameColumn() {
		return sellerNameColumn;
	}

	public void setSellerNameColumn(TableColumn<BuysTable, String> sellerNameColumn) {
		this.sellerNameColumn = sellerNameColumn;
	}

	public TableColumn<BuysTable, String> getModelColumn() {
		return modelColumn;
	}

	public void setModelColumn(TableColumn<BuysTable, String> modelColumn) {
		this.modelColumn = modelColumn;
	}

	public TableColumn<BuysTable, Double> getPriceColumn() {
		return priceColumn;
	}

	public void setPriceColumn(TableColumn<BuysTable, Double> priceColumn) {
		this.priceColumn = priceColumn;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Tab getMixedTab() {
		return mixedTab;
	}

	public void setMixedTab(Tab mixedTab) {
		this.mixedTab = mixedTab;
	}
}
