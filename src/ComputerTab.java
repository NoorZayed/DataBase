import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ComputerTab {
	
	private String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	private TableView<ComputerTable2> computerTableView = new TableView<>();
	private TableColumn<ComputerTable2, String> colorColumn = new TableColumn<>("Color");
	private TableColumn<ComputerTable2, String> cpuColumn = new TableColumn<>("CPU");
	private TableColumn<ComputerTable2, Integer> ramColumn = new TableColumn<>("RAM");
	private TableColumn<ComputerTable2, String> modelColumn = new TableColumn<>("Model");
	private TableColumn<ComputerTable2, Integer> storageColumn = new TableColumn<>("Storage");
	private TableColumn<ComputerTable2, String> serialNumColumn = new TableColumn<>("Serial Number");
	private TableColumn<ComputerTable2, Double> priceColumn = new TableColumn<>("Price");
	private TableColumn<ComputerTable2, String> statusColumn = new TableColumn<>("Status");
	private VBox vbox = new VBox(computerTableView);
	private Tab computerTab = new Tab("Computer");

	ComputerTab() {
		// Create TableView and columns for computers

		colorColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, String>("color"));
		cpuColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, String>("cpu"));
		ramColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, Integer>("ram"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, String>("model"));
		storageColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, Integer>("storage"));
		serialNumColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, String>("serialnum"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, Double>("price"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<ComputerTable2, String>("status"));

		computerTableView.getColumns().addAll(colorColumn, cpuColumn, ramColumn, modelColumn, storageColumn,
				serialNumColumn, priceColumn,statusColumn);

		// Apply styling to the TableView
		computerTableView.setStyle(cellStyle);

		serialNumColumn.setPrefWidth(120);
		computerTableView.setSelectionModel(null);
		// Apply styling to the TableView columns
//		for (TableColumn<ComputerTable2, ?> column : computerTableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: white;");
//		}

		// Create a VBox to hold the computer TableView
		vbox.setSpacing(15);

		// Create a Tab and set its content
		computerTab.setContent(vbox);

	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public TableView<ComputerTable2> getComputerTableView() {
		return computerTableView;
	}

	public void setComputerTableView(TableView<ComputerTable2> computerTableView) {
		this.computerTableView = computerTableView;
	}

	public TableColumn<ComputerTable2, String> getColorColumn() {
		return colorColumn;
	}

	public void setColorColumn(TableColumn<ComputerTable2, String> colorColumn) {
		this.colorColumn = colorColumn;
	}

	public TableColumn<ComputerTable2, String> getCpuColumn() {
		return cpuColumn;
	}

	public void setCpuColumn(TableColumn<ComputerTable2, String> cpuColumn) {
		this.cpuColumn = cpuColumn;
	}

	public TableColumn<ComputerTable2, Integer> getRamColumn() {
		return ramColumn;
	}

	public void setRamColumn(TableColumn<ComputerTable2, Integer> ramColumn) {
		this.ramColumn = ramColumn;
	}

	public TableColumn<ComputerTable2, String> getModelColumn() {
		return modelColumn;
	}

	public void setModelColumn(TableColumn<ComputerTable2, String> modelColumn) {
		this.modelColumn = modelColumn;
	}

	public TableColumn<ComputerTable2, Integer> getStorageColumn() {
		return storageColumn;
	}

	public void setStorageColumn(TableColumn<ComputerTable2, Integer> storageColumn) {
		this.storageColumn = storageColumn;
	}

	public TableColumn<ComputerTable2, String> getSerialNumColumn() {
		return serialNumColumn;
	}

	public void setSerialNumColumn(TableColumn<ComputerTable2, String> serialNumColumn) {
		this.serialNumColumn = serialNumColumn;
	}

	public TableColumn<ComputerTable2, Double> getPriceColumn() {
		return priceColumn;
	}

	public void setPriceColumn(TableColumn<ComputerTable2, Double> priceColumn) {
		this.priceColumn = priceColumn;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public Tab getComputerTab() {
		return computerTab;
	}

	public void setComputerTab(Tab computerTab) {
		this.computerTab = computerTab;
	}
}
