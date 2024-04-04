import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class connectTabs {
	//Stage stage = new Stage();
	private Tab shopTab, customerTab, sellerEmp, repairEmp, order, Services, computerTab;

	private TabPane tabPane = new TabPane();

	//private Stage removeComputerStage = new Stage();
	private ShopTab shop = new ShopTab();
	private CustomerTab cus = new CustomerTab();
	private sellerEmpTab sell = new sellerEmpTab();
	private RepairEmpTab rep = new RepairEmpTab();
	private Mixed2Tab m2 = new Mixed2Tab();
	private MixedTab m1 = new MixedTab();
	private ComputerTab comp = new ComputerTab();

	connectTabs() {

		// Create three tabs
		shopTab = shop.getShopTab();
		customerTab = cus.getCustomerTab();
		sellerEmp = sell.getSellerEmp();
		repairEmp = rep.getRepairEmp();
		order = m2.getMixedTab();
		Services = m1.getMixedTab();
		computerTab = comp.getComputerTab();

		// Apply styling to the TabPane
		tabPane.setStyle("-fx-background-color: white; " + "-fx-text-fill: white; ");
		// Add tabs to the TabPane
		tabPane.getTabs().addAll(shopTab, customerTab, computerTab, sellerEmp, repairEmp, order, Services);

		// Create a scene and set it on the stage
//		Scene scene = new Scene(tabPane, 700, 580);
//		stage.setTitle("Shop Interface");
//		stage.setScene(scene);
//		stage.show();
	}

//	public Stage getStage() {
//		return stage;
//	}
//
//	public void setStage(Stage stage) {
//		this.stage = stage;
//	}

	public Tab getShopTab() {
		return shopTab;
	}

	public void setShopTab(Tab shopTab) {
		this.shopTab = shopTab;
	}

	public Tab getCustomerTab() {
		return customerTab;
	}

	public void setCustomerTab(Tab customerTab) {
		this.customerTab = customerTab;
	}

	public Tab getSellerEmp() {
		return sellerEmp;
	}

	public void setSellerEmp(Tab sellerEmp) {
		this.sellerEmp = sellerEmp;
	}

	public Tab getRepairEmp() {
		return repairEmp;
	}

	public void setRepairEmp(Tab repairEmp) {
		this.repairEmp = repairEmp;
	}

	public Tab getOrder() {
		return order;
	}

	public void setOrder(Tab order) {
		this.order = order;
	}

	public Tab getServices() {
		return Services;
	}

	public void setServices(Tab services) {
		Services = services;
	}

	public Tab getComputerTab() {
		return computerTab;
	}

	public void setComputerTab(Tab computerTab) {
		this.computerTab = computerTab;
	}

	public TabPane getTabPane() {
		return tabPane;
	}

	public void setTabPane(TabPane tabPane) {
		this.tabPane = tabPane;
	}



	public ShopTab getShop() {
		return shop;
	}

	public void setShop(ShopTab shop) {
		this.shop = shop;
	}

	public CustomerTab getCus() {
		return cus;
	}

	public void setCus(CustomerTab cus) {
		this.cus = cus;
	}

	public sellerEmpTab getSell() {
		return sell;
	}

	public void setSell(sellerEmpTab sell) {
		this.sell = sell;
	}

	public RepairEmpTab getRep() {
		return rep;
	}

	public void setRep(RepairEmpTab rep) {
		this.rep = rep;
	}

	public Mixed2Tab getM2() {
		return m2;
	}

	public void setM2(Mixed2Tab m2) {
		this.m2 = m2;
	}

	public MixedTab getM1() {
		return m1;
	}

	public void setM1(MixedTab m1) {
		this.m1 = m1;
	}

	public ComputerTab getComp() {
		return comp;
	}

	public void setComp(ComputerTab comp) {
		this.comp = comp;
	}
}
