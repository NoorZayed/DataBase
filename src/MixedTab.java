
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MixedTab {
	String style = "-fx-background-radius: 10em; " + "-fx-min-width: 150px; " + "-fx-min-height: 15px; "
			+ "-fx-max-width: 150px; " + "-fx-max-height: 40px; " + "-fx-background-color: darkturquoise;";
	String cellStyle = "-fx-control-inner-background: darkblue; -fx-table-cell-border-color: black;-fx-table-cell-border-color: darkturquoise;";
	private TableView<ServicesTable> mixedTableView = new TableView<>();
	private TableColumn<ServicesTable, String> repNameColumn = new TableColumn<>("Rep Name");
	private TableColumn<ServicesTable, String> custNameColumn = new TableColumn<>("Cust Name");
	private TableColumn<ServicesTable, String> custIdColumn = new TableColumn<>("Cust ID");
	private TableColumn<ServicesTable, String> serialNumColumn = new TableColumn<>("Serial Number");
	private TableColumn<ServicesTable, String> repIdColumn = new TableColumn<>("Rep ID");
	private TableColumn<ServicesTable, String> modelColumn = new TableColumn<>("Comp-Model");
	private Label titleLabel;
	private Label subTitleLabel;
	private Label bottomLabel;
	public static Button rej = new Button("Reject Order");
	private HBox box = new HBox(20);
	private VBox labelsVBox = new VBox();
	private Tab mixedTab = new Tab(" Repair Employee Services");

	MixedTab() {
		// Create TableView and columns for mixed data

		repNameColumn.setCellValueFactory(new PropertyValueFactory<>("repname"));
		custNameColumn.setCellValueFactory(new PropertyValueFactory<>("custname"));
		custIdColumn.setCellValueFactory(new PropertyValueFactory<>("custid"));
		serialNumColumn.setCellValueFactory(new PropertyValueFactory<>("serialnum"));
		repIdColumn.setCellValueFactory(new PropertyValueFactory<>("repid"));
		modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

		mixedTableView.getColumns().addAll(repNameColumn, custNameColumn, custIdColumn, serialNumColumn, repIdColumn);

		// Apply styling to the TableView
		mixedTableView.setStyle(cellStyle);

		serialNumColumn.setPrefWidth(120);

		// Apply styling to the TableView columns
//		for (TableColumn<ServicesTable, ?> column : mixedTableView.getColumns()) {
//			column.setStyle("-fx-background-color: white; -fx-text-fill: black;");
//		}

		rej.setStyle(style);
		// Create labels
		titleLabel = createStyledLabel("Repair Employee Work List");
		subTitleLabel = createSubTitleLabel("These are the services which have to Repair");
		bottomLabel = createSubTitleLabel("Select the row you want to reject it");

		// Create a VBox to organize labels
		labelsVBox.setAlignment(Pos.CENTER_LEFT);
		labelsVBox.setSpacing(10);
		labelsVBox.getChildren().add(titleLabel);
		labelsVBox.getChildren().add(subTitleLabel);
		labelsVBox.getChildren().add(mixedTableView);
//		box.getChildren().addAll(bottomLabel, rej);
		box.getChildren().add(bottomLabel);
//		box.getChildren().add(rej);

		labelsVBox.getChildren().addAll(box,rej);

		// Create a Tab and set its content
		mixedTab.setContent(labelsVBox);

	}

	private Label createStyledLabel(String text) {
		Label label = new Label(text);
		label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		label.setStyle("-fx-text-fill: Black;");
		return label;
	}

	private Label createSubTitleLabel(String text) {
		Label label = new Label(text);
		label.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
		label.setStyle("-fx-text-fill: Black;");
		return label;
	}

	public String getStyle() {
		return style;
	}

	public Button getRej() {
		return rej;
	}

//	public HBox getHbox() {
//		return hbox;
//	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setRej(Button rej) {
		this.rej = rej;
	}

//	public void setHbox(HBox hbox) {
//		this.hbox = hbox;
//	}

	public String getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(String cellStyle) {
		this.cellStyle = cellStyle;
	}

	public TableView<ServicesTable> getMixedTableView() {
		return mixedTableView;
	}

	public void setMixedTableView(TableView<ServicesTable> mixedTableView) {
		this.mixedTableView = mixedTableView;
	}

	public TableColumn<ServicesTable, String> getRepNameColumn() {
		return repNameColumn;
	}

	public void setRepNameColumn(TableColumn<ServicesTable, String> repNameColumn) {
		this.repNameColumn = repNameColumn;
	}

	public TableColumn<ServicesTable, String> getCustNameColumn() {
		return custNameColumn;
	}

	public void setCustNameColumn(TableColumn<ServicesTable, String> custNameColumn) {
		this.custNameColumn = custNameColumn;
	}

	public TableColumn<ServicesTable, String> getCustIdColumn() {
		return custIdColumn;
	}

	public void setCustIdColumn(TableColumn<ServicesTable, String> custIdColumn) {
		this.custIdColumn = custIdColumn;
	}

	public TableColumn<ServicesTable, String> getSerialNumColumn() {
		return serialNumColumn;
	}

	public void setSerialNumColumn(TableColumn<ServicesTable, String> serialNumColumn) {
		this.serialNumColumn = serialNumColumn;
	}

	public TableColumn<ServicesTable, String> getRepIdColumn() {
		return repIdColumn;
	}

	public void setRepIdColumn(TableColumn<ServicesTable, String> repIdColumn) {
		this.repIdColumn = repIdColumn;
	}

	public Label getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
	}

	public Label getSubTitleLabel() {
		return subTitleLabel;
	}

	public void setSubTitleLabel(Label subTitleLabel) {
		this.subTitleLabel = subTitleLabel;
	}

	public Label getBottomLabel() {
		return bottomLabel;
	}

	public void setBottomLabel(Label bottomLabel) {
		this.bottomLabel = bottomLabel;
	}

	public VBox getLabelsVBox() {
		return labelsVBox;
	}

	public void setLabelsVBox(VBox labelsVBox) {
		this.labelsVBox = labelsVBox;
	}

	public Tab getMixedTab() {
		return mixedTab;
	}

	public void setMixedTab(Tab mixedTab) {
		this.mixedTab = mixedTab;
	}

}
