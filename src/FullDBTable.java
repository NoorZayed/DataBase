
import static javafx.stage.Modality.NONE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;

/**
 * A JavaFX ConnectDB Application
 */
public class FullDBTable extends Application {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	public ArrayList<Product> data;
	// public static ArrayList<Customer> custlist= new ArrayList<>();
	public static HashMap<String, Customer> cushash = new HashMap<>();
	public static HashMap<String, Computer> comphash = new HashMap<>();
	public static HashMap<String, Shop> shophash = new HashMap<>();
	public static HashMap<String, SellerEmp> sellemphash = new HashMap<>();
	public static HashMap<String, RepEmp> repemphash = new HashMap<>();
	public static HashMap<String, Buys> buyhash = new HashMap<>();
	public static HashMap<String, Services> servicehash = new HashMap<>();
	private ObservableList<Product> dataList;

	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "23Noor2003";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "sac";
	private Connection con;
	String passwordd = "enm";

	public static String CustomerID;
	public static String sellidrandom;
	public static ComputerTable comptable;
	public static String repidrandom;

	MainPage mainpage = new MainPage();
	Passwordscreen password = new Passwordscreen();
	signcust sign = new signcust();
	createaccount create = new createaccount();
	custidscreendelete deletecus = new custidscreendelete();
	customerdeleteinformation delinfo = new customerdeleteinformation();
	updatecustscreen custup = new updatecustscreen();
	customerupdateinformation custinfo = new customerupdateinformation();
	custchoose custchoose = new custchoose();
	BuyCustScreen buyscreen = new BuyCustScreen();
	RepCustScreen repscreen = new RepCustScreen();
	chooseaddemployee chooseaddemp = new chooseaddemployee();
	// addrepscreen addrepscr = new addrepscreen();
	// addsellempscreen addsellscr = new addsellempscreen();
	addcardsure addcard = new addcardsure();
	connectTabs connecttab = new connectTabs();
	AddShopPass addshoppass = new AddShopPass();
	AddShop addshop = new AddShop();
	DeleteShopPass deleteshoppass = new DeleteShopPass();
	DeleteShop deleteshop = new DeleteShop();
	UpdateShopPass updshoppass = new UpdateShopPass();
	UpdateShop updshop = new UpdateShop();
	chooseaddemployee chooseadd = new chooseaddemployee();
	addsellempscreen addsellemp = new addsellempscreen();
	addrepscreen addrepemp = new addrepscreen();
	updateempchoose chooseupd = new updateempchoose();
	sellerupdatepass sellupass = new sellerupdatepass();
	RepUpdatepass repupass = new RepUpdatepass();
	Sellerempdelete selldeletescr = new Sellerempdelete();
	AddComputer addcomp = new AddComputer();
	sellerEmpTab seltap = new sellerEmpTab();
//	Deletecompass delcomp = new Deletecompass();

	Stage stage1 = new Stage();
	Stage stage2 = new Stage();
	Stage stage3 = new Stage();
	Stage stage4 = new Stage();
	Stage stage5 = new Stage();
	Stage stage6 = new Stage();
	Stage stage7 = new Stage();
	Stage stage8 = new Stage();
	Stage stage9 = new Stage();
	Stage stage10 = new Stage();
	Stage stage11 = new Stage();
	Stage stage12 = new Stage();
	// Stage stage13 = new Stage();
	// Stage stage14 = new Stage();
	Stage stage15 = new Stage();
	Stage stage16 = new Stage();
	Stage stage17 = new Stage();
	Stage stage18 = new Stage();
	Stage stage19 = new Stage();
	Stage stage20 = new Stage();
	Stage stage21 = new Stage();
	Stage stage22 = new Stage();
	Stage stage23 = new Stage();
	Stage stage24 = new Stage();
	Stage stage25 = new Stage();
	Stage stage26 = new Stage();
	Stage stage27 = new Stage();
	Stage stage28 = new Stage();
	Stage stage29 = new Stage();
	Stage stage30 = new Stage();

	Scene scene1 = new Scene(mainpage.getGp(), 1250, 600);
	Scene scene2 = new Scene(password.getAdmingp(), 700, 300);
	Scene scene3 = new Scene(sign.getGp(), 1100, 400);
	Scene scene4 = new Scene(create.getBord(), 650, 400);
	Scene scene5 = new Scene(deletecus.getBorder(), 500, 200);
	Scene scene6 = new Scene(delinfo.getBord(), 650, 400);
	Scene scene7 = new Scene(custup.getBorder(), 500, 200);
	Scene scene8 = new Scene(custinfo.getBord(), 650, 400);
	Scene scene9 = new Scene(custchoose.getVbox(), 600, 380);
	Scene scene10 = new Scene(buyscreen.getBorderPane(), 1040, 650);
	Scene scene11 = new Scene(repscreen.getGridPane(), 620, 450);
	Scene scene12 = new Scene(chooseaddemp.getVbox(), 400, 300);
//	Scene scene13= new Scene(addrepscr.getGridPane(),500,450);
	// Scene scene14 = new Scene(addsellscr.getGridPane(),500,450);
	Scene scene15 = new Scene(addcard.getG(), 500, 200);
	Scene scene16 = new Scene(connecttab.getTabPane(), 700, 580);
	Scene scene17 = new Scene(addshoppass.getAddShopPane(), 600, 200);
	Scene scene18 = new Scene(addshop.getGridPane(), 420, 250);
	Scene scene19 = new Scene(deleteshoppass.getRemoveShopPane(), 420, 250);
	Scene scene20 = new Scene(deleteshop.getGridPane(), 420, 250);
	Scene scene21 = new Scene(updshoppass.getUpShopPane(), 420, 250);
	Scene scene22 = new Scene(updshop.getGridPane(), 420, 250);
	Scene scene23 = new Scene(chooseadd.getVbox(), 400, 300);
	Scene scene24 = new Scene(addsellemp.getGridPane(), 500, 450);
	Scene scene25 = new Scene(addrepemp.getGridPane(), 500, 450);
	Scene scene26 = new Scene(chooseupd.getVbox(), 400, 300);
	Scene scene27 = new Scene(sellupass.getG(), 500, 200);
	Scene scene28 = new Scene(repupass.getG(), 500, 200);
	Scene scene29 = new Scene(selldeletescr.getGridPane(), 400, 400);
	Scene scene30 = new Scene(addcomp.getGridPane(), 600, 380);

	public static ObservableList<ComputerTable> buycomplist = FXCollections.observableArrayList();
	public static ObservableList<ServicesTable> servicelist = FXCollections.observableArrayList();
	public static ObservableList<ShopTable> shoplist = FXCollections.observableArrayList();
	public static ObservableList<SellerEmpTable> selllist = FXCollections.observableArrayList();
	public static ObservableList<RepEmpTable> replist = FXCollections.observableArrayList();
	public static ObservableList<CustomerTable> custlist = FXCollections.observableArrayList();
	public static ObservableList<BuysTable> buylist = FXCollections.observableArrayList();
	public static ObservableList<ComputerTable2> computerlist = FXCollections.observableArrayList();
	ObservableList<String> colorfilter;
	ObservableList<String> cpufilter;
	ObservableList<String> ramfilter;
	ObservableList<String> modelfilter;
	ObservableList<String> pricefilter;
	ObservableList<String> storagefilter;
	Set<String> uniqueColors;
	Set<String> uniqueCPUs;
	Set<String> uniqueRAMs;
	Set<String> uniquemodel;
	Set<String> uniqueprice;
	Set<String> uniquestorage;

	@Override
	public void start(Stage stage) {
		try {

			getDatasellemp();
			System.out.println("+++++++++++++++++++++Seller Employee++++++++++++++++++++++++++++");
			for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue().getEmpname());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

			getDatacomputer();
			System.out.println("+++++++++++++++++++++Computer ++++++++++++++++++++++++++++");
			for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
				System.out.println(entry.getValue().toString());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

			getDataBuys();
			System.out.println("++++++++++++++++++++Buy++++++++++++++++++++++++++++");
			for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
				System.out.println(entry.getValue().getSerialnum() + "  --> " + entry.getValue().getCustid());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

			getDataRepEmp();
			System.out.println("+++++++++++++++++++++Repeair++++++++++++++++++++++++++++");
			for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
				System.out.println(entry.getValue().getRepid() + "  --> " + entry.getValue().getEmpname());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
			getDataServices();
			System.out.println("+++++++++++++++++++++Services++++++++++++++++++++++++++++");
			for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
				System.out.println(entry.getValue().getRepid() + "  --> " + entry.getValue().getSerialnum());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
			getDatashop();
			System.out.println("+++++++++++++++++++++SHop++++++++++++++++++++++++++++");
			for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
				System.out.println(entry.getValue().getShopname() + "  --> " + entry.getValue().getPhonenum());
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
			UpdateComputer updatecomp = new UpdateComputer();
//			MixedTab mix = new MixedTab();
//			mix.rej.setOnAction(e -> {
//				System.out.println("Reject is clicked !!!!!!");
//				// Get the selected item from the TableView
//				ServicesTable selectedService = mix.getMixedTableView().getSelectionModel().getSelectedItem();
//
//				if (selectedService != null) {
//					// Call deleteservice method with the selected service
//					deleteservice(new Services(selectedService.getCustid(), selectedService.getRepid(),
//							selectedService.getSerialnum()));
//
//					// Remove the selected item from the TableView
//					servicelist.remove(selectedService);
//				} else {
//					// Display a message or handle the case where no item is selected
//					System.out.println("No service selected.");
//				}
//			});
			updatecomp.okButton.setOnAction(e -> {
				System.out.println("clicked");

				// Check if any required fields are empty
				if (updatecomp.idTextField.getText().trim().equals("")
						|| updatecomp.colorTextField.getText().trim().equals("")
						|| updatecomp.priceTextField.getText().trim().equals("")
						|| updatecomp.ramTextField.getText().trim().equals("")
						|| updatecomp.cpuTextField.getText().trim().equals("")
						|| updatecomp.modTextField.getText().trim().equals("")
						|| updatecomp.storTextField.getText().trim().equals("")) {
					showAlert("Please fill in all fields!");
				} else {
					// Validate input fields (you can add more validation as needed)
					if (!isOnlyCharacters(updatecomp.colorTextField.getText())) {
						showAlert("Please enter a valid color (characters only)!");
					} else if (!isOnlyDigits(updatecomp.priceTextField.getText())) {
						showAlert("Please enter a valid price (numbers only)!");
					} else if (!isOnlyDigits(updatecomp.ramTextField.getText())) {
						showAlert("Please enter a valid RAM value (numbers only)!");
					} else if (!isOnlyCharacters(updatecomp.cpuTextField.getText())) {
						showAlert("Please enter a valid CPU type (characters only)!");
					} else {
						
						// Fields are valid, proceed with update
						String serial = updatecomp.idTextField.getText().trim();
						String color = updatecomp.colorTextField.getText().trim();
						int ram = Integer.parseInt(updatecomp.ramTextField.getText().trim());
						String cpu = updatecomp.cpuTextField.getText().trim();
						String model = updatecomp.modTextField.getText().trim();
						int storage = Integer.parseInt(updatecomp.storTextField.getText().trim());
						double price = Double.parseDouble(updatecomp.priceTextField.getText().trim());

						// Check if the serial number exists in the hash map
						if (comphash.containsKey(serial)) {
							updatecomputercolor(serial, color);
							updatecomputerCPU(serial, cpu);
							updatecomputerRam(serial, ram);
							updatecomputermodel(serial, model);
							updatecomputerStorage(serial, storage);
							updatecomputerprice(serial, price);
//			                // Assuming you have a method to update data in the computer table
//			                updateComputerDetails(serial, color, cpu, ram, model, storage, price);
//
//			                // Assuming you have a method to update the hash map
//			                updateComputerInHashMap(serial, color, cpu, ram, model, storage, price);
//
//			                // Update the UI
//			                updateUI();
							computerlist.clear();
							connecttab.getComp().getComputerTableView().getItems().clear();
							for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
								if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
									computerlist.add(new ComputerTable2(entry.getValue().getColor(),
											entry.getValue().getCpu(), entry.getValue().getRam(),
											entry.getValue().getModel(), entry.getValue().getStorage(),
											entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Avilible"));
								} else if (entry.getValue().getIsbuy() == 1) {
									computerlist.add(new ComputerTable2(entry.getValue().getColor(),
											entry.getValue().getCpu(), entry.getValue().getRam(),
											entry.getValue().getModel(), entry.getValue().getStorage(),
											entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Buy"));
								} else if (entry.getValue().getIsrepair() == 1) {
									computerlist.add(new ComputerTable2(entry.getValue().getColor(),
											entry.getValue().getCpu(), entry.getValue().getRam(),
											entry.getValue().getModel(), entry.getValue().getStorage(),
											entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Repair"));
								}
							}
//							connecttab.getComp().getComputerTableView().setItems(computerlist);
//							connecttab.getComp().getComputerTableView().refresh();
							// Update the ObservableList that is bound to the TableView
							connecttab.getComp().getComputerTableView().getItems().setAll(computerlist);

							// Refresh the TableView
							connecttab.getComp().getComputerTableView().refresh();
							showAlert("Computer details updated successfully!");
						} else {
							showAlert("Computer with Serial Number " + serial + " not found.");
						}

						// Clear the text fields after update
						updatecomp.getIdTextField().clear();
						updatecomp.getColorTextField().clear();
						updatecomp.getRamTextField().clear();
						updatecomp.getCpuTextField().clear();
						updatecomp.getModTextField().clear();
						updatecomp.getStorTextField().clear();
						updatecomp.getPriceTextField().clear();
					}
				}
			});

//			updatecomp.okButton.setOnAction(e -> {
//				System.out.print("the ok button is clicked ");
//				if (updatecomp.getColorTextField().getText().equals("")) {
//					showAlert("Enter the computer Color is Empty !!");
//					updatecomp.getColorTextField().setText(null);
//
//				}
//
//				if (updatecomp.getCpuTextField().getText().equals("")) {
//					showAlert("Enter the computer CPU is Empty !!");
//					updatecomp.getCpuTextField().setText(null);
//
//				}
//				if (updatecomp.getIdTextField().getText().equals("")) {
//					showAlert("Enter the computer Serial Number is Empty !!");
//					updatecomp.getIdTextField().setText(null);
//
//				}
//				if (updatecomp.getModTextField().getText().equals("")) {
//					showAlert("Enter the computer Model is Empty !!");
//					updatecomp.getModTextField().setText(null);
//
//				}
//				if (updatecomp.getPriceTextField().getText().equals("")) {
//					showAlert("Enter the computer Price is Empty !!");
//					updatecomp.getPriceTextField().setText(null);
//
//				}
//				if (updatecomp.getRamTextField().getText().equals("")) {
//					showAlert("Enter the computer Rams is Empty !!");
//					updatecomp.getRamTextField().setText(null);
//
//				}
//				if (updatecomp.getStorTextField().getText().equals("")) {
//					showAlert("Enter the computer Storege is Empty !!");
//					updatecomp.getStorTextField().setText(null);
//
//				} else if (comphash.containsKey(updatecomp.getIdTextField().getText().trim()) == false) {
//					showAlert("Please The Computer  Serial number is Not Exist !!");
//					updatecomp.getIdTextField().setText(null);
//				} else {
//					Computer computer = comphash.get(updatecomp.getIdTextField().getText().trim());
////					stage32.close();
//					updatecomp.getColorTextField().setText(computer.getColor().trim());
//					updatecomp.getCpuTextField().setText(computer.getCpu().trim());
//					updatecomp.getIdTextField().setText(computer.getSerialnum().trim());
//					updatecomp.getModTextField().setText(computer.getModel().trim());
//					updatecomp.getPriceTextField().setText((computer.getPrice() + ""));
//					updatecomp.getRamTextField().setText(computer.getRam() + "");
//					updatecomp.getStorTextField().setText(computer.getStorage() + "");
//
//
//				}
//
////				 else {
////					Shop shops = shophash.get(updshoppass.getShopNameTextField().getText().trim());
////					updshoppass.getShopNameTextField().setText(null);
////					stage21.close();
////					updshop.getTextField1().setText(shops.getShopname().trim());
////					updshop.getTextField2().setText(shops.getPhonenum().trim());
////					updshop.getTextField3().setText(shops.getAddress().trim());
////					stage22.setScene(scene22);
////					stage22.show();
////				}
//			});
			addcomp.okButton.setOnAction(e -> {
				System.out.println("clicked");
				if (addcomp.idTextField.getText().trim().equals("")
						|| addcomp.colorTextField.getText().trim().equals("")
						|| addcomp.priceTextField.getText().trim().equals("") || addcomp.ramComboBox.getValue() == null
						|| addcomp.cpuComboBox.getValue() == null || addcomp.modelTextField.getValue() == null
						|| addcomp.storageComboBox.getValue() == null) {
					showAlert("Please fill in all fields!");
				} else if (!isOnlyCharacters(addcomp.colorTextField.getText())) {
					showAlert("Please enter a valid color (characters only)!");
				} else if (!isOnlyDigits(addcomp.priceTextField.getText())) {
					showAlert("Please enter a valid price (numbers only)!");
				} else if (comphash.containsKey(addcomp.idTextField.getText().trim())) {
					showAlert("This Serial-Number Is Already Exist. Please try again.");
				} else {
					String serial = addcomp.idTextField.getText().trim();
					String color = addcomp.colorTextField.getText().trim();
					int ram = extractNumericValue(addcomp.ramComboBox.getValue().trim());
					String cpu = addcomp.cpuComboBox.getValue().trim();
					String model = addcomp.modelTextField.getValue().trim();
					int storage = extractNumericValue(addcomp.storageComboBox.getValue().trim());
					double price = Double.parseDouble(addcomp.priceTextField.getText().trim());

					// Assuming you have a Computer class constructor
					Computer com = new Computer(color, cpu, ram, model, storage, serial, 0, price, 0);
					comphash.put(com.getSerialnum(), com);

					// Assuming you have a method to insert data into the computer table
					insertDatacomputer(com);

					computerlist.clear();
					connecttab.getComp().getComputerTableView().getItems().clear();
					for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
						if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Avilible"));
						} else if (entry.getValue().getIsbuy() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Buy"));
						} else if (entry.getValue().getIsrepair() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Repair"));
						}
					}
					connecttab.getComp().getComputerTableView().setItems(computerlist);
					connecttab.getComp().getComputerTableView().refresh();
//	                    connecttab
					// Clear the text fields and combo boxes after insertion
					addcomp.idTextField.clear();
					addcomp.colorTextField.clear();
					addcomp.ramComboBox.getSelectionModel().clearSelection();
					addcomp.cpuComboBox.getSelectionModel().clearSelection();
					addcomp.modelTextField.getSelectionModel().clearSelection();
					addcomp.storageComboBox.getSelectionModel().clearSelection();
					addcomp.priceTextField.clear();

					showAlert("The Computer Is Added Successfully!");
				}
			});
			Deletecompass deletecompass = new Deletecompass();

			// Assuming you have a remove button in your UI
			deletecompass.okB.setOnAction(e -> {
				System.out.println("clicked");

				// Get the serial number entered by the user
				String serialNumberToDelete = deletecompass.pass.getText().trim();

				// Check if the serial number exists in the hash map
				if (comphash.containsKey(serialNumberToDelete)) {
					Computer com = comphash.get(serialNumberToDelete);

					// Check if the Computer object is not null
					if (com != null) {
						// Assuming you have a method to remove data from the computer table
						deletecomputer(com);

						// Remove the computer from the hash map
						comphash.remove(serialNumberToDelete);

						// Update the UI
						computerlist.clear();
						for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
							if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
								computerlist.add(new ComputerTable2(entry.getValue().getColor(),
										entry.getValue().getCpu(), entry.getValue().getRam(),
										entry.getValue().getModel(), entry.getValue().getStorage(),
										entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Avilible"));
							} else if (entry.getValue().getIsbuy() == 1) {
								computerlist.add(new ComputerTable2(entry.getValue().getColor(),
										entry.getValue().getCpu(), entry.getValue().getRam(),
										entry.getValue().getModel(), entry.getValue().getStorage(),
										entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Buy"));
							} else if (entry.getValue().getIsrepair() == 1) {
								computerlist.add(new ComputerTable2(entry.getValue().getColor(),
										entry.getValue().getCpu(), entry.getValue().getRam(),
										entry.getValue().getModel(), entry.getValue().getStorage(),
										entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Repair"));
							}
						}
						connecttab.getComp().getComputerTableView().setItems(computerlist);
						connecttab.getComp().getComputerTableView().refresh();

						showAlert("Computer removed successfully!");
					} else {
						showAlert("Computer with Serial Number " + serialNumberToDelete + " not found.");
					}
				} else {
					showAlert("Computer with Serial Number " + serialNumberToDelete + " not found.");
				}
			});

			connecttab.getShop().getButton1().setOnAction(e -> {
				stage17.setScene(scene17);
				stage17.show();
			});
			addshoppass.getCancel().setOnAction(e -> {
				addshoppass.getShopaddpass().setText(null);
				stage17.close();
			});
			addshoppass.getAddShopOkButton().setOnAction(e -> {
				if (addshoppass.getShopaddpass().getText().equals(passwordd)) {
					stage17.close();
					addshoppass.getShopaddpass().setText(null);
					stage18.setScene(scene18);
					stage18.show();
				} else {
					addshoppass.getShopaddpass().setText(null);
					showAlert("Please The Password is Incorrect Try Again ! ");
				}
			});
			addshoppass.getShow().setOnAction(e -> {
				if (addshoppass.getShow().isSelected()) {
					addshoppass.getShopaddpass().setPromptText(addshoppass.getShopaddpass().getText());
					addshoppass.getShopaddpass().setText("");
				} else {
					addshoppass.getShopaddpass().setText(addshoppass.getShopaddpass().getPromptText());
					addshoppass.getShopaddpass().setPromptText("Password");

				}
			});
			addshop.getCancel().setOnAction(e -> {
				addshop.getTextField1().setText(null);
				addshop.getTextField2().setText(null);
				addshop.getTextField3().setText(null);
				stage18.close();
				stage17.close();
			});

			addshop.getOkButton().setOnAction(e -> {
				if (addshop.getTextField1().getText().equals("") || addshop.getTextField2().getText().equals("")
						|| addshop.getTextField3().getText().equals("")) {
					showAlert("Please There is Empty Fields !!");
					addshop.getTextField1().setText(null);
				} else if (shophash.containsKey(addshop.getTextField1().getText())) {
					showAlert("This Shop Is Already Exist Try Another Shop Name Please !!");
				} else if (isOnlyDigits(addshop.getTextField2().getText()) == false) {
					showAlert("Please The PhoneNumber Must Be Only Numbers !!" + "\n" + "Please Try Again !");
					addshop.getTextField2().setText(null);
				} else if (addshop.getTextField2().getText().length() > 10
						|| addshop.getTextField2().getText().length() < 10) {
					showAlert("Please The PhoneNumber Must Be Only 10 Numbers !!" + "\n" + "Please Try Again !");
					addshop.getTextField2().setText(null);
				} else {
					String shopname = addshop.getTextField1().getText().trim();
					String shopphone = addshop.getTextField2().getText().trim();
					String shopaddress = addshop.getTextField3().getText().trim();
					Shop shops = new Shop(shopname, shopphone, shopaddress);
					insertShop(shops);
					shophash.put(shopname, shops);
					shoplist.clear();
					connecttab.getShop().getTableView().getItems().clear();
					for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
						String name = entry.getValue().getShopname();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						shoplist.add(new ShopTable(name, phone, address));
					}
					connecttab.getShop().getTableView().setItems(shoplist);
					connecttab.getShop().getTableView().refresh();
					addshop.getTextField2().setText(null);
					addshop.getTextField1().setText(null);
					addshop.getTextField3().setText(null);
					showAlertsuc("The Shop Is Add Sucessfully !!");
					stage18.close();
					addshoppass.getShopaddpass().setText(null);
					stage17.close();
				}
			});

			connecttab.getShop().getButton2().setOnAction(e -> {
				stage19.setScene(scene19);
				stage19.show();
			});

			deleteshoppass.getCancel().setOnAction(e -> {
				deleteshoppass.getShopNameTextField().setText(null);
				stage19.close();
			});

			deleteshoppass.getRemoveShopOkButton().setOnAction(e -> {
				if (deleteshoppass.getShopNameTextField().getText().equals("")) {
					showAlert("Please The Shop Name is Empty !!");
					deleteshoppass.getShopNameTextField().setText(null);
				} else if (shophash.containsKey(deleteshoppass.getShopNameTextField().getText().trim()) == false) {
					showAlert("Please The Shop Name is Not Exist !!");
					deleteshoppass.getShopNameTextField().setText(null);
				} else {
					Shop shops = shophash.get(deleteshoppass.getShopNameTextField().getText().trim());
					deleteshoppass.getShopNameTextField().setText(null);
					stage19.close();
					deleteshop.getTextField1().setText(shops.getShopname().trim());
					deleteshop.getTextField2().setText(shops.getPhonenum().trim());
					deleteshop.getTextField3().setText(shops.getAddress().trim());
					stage20.setScene(scene20);
					stage20.show();
				}
			});

			deleteshop.getCancel().setOnAction(e -> {
				deleteshoppass.getShopNameTextField().setText(null);
				deleteshop.getTextField1().setText(null);
				deleteshop.getTextField2().setText(null);
				deleteshop.getTextField3().setText(null);
				stage20.close();
				stage19.close();
			});
			deleteshop.getOkButton().setOnAction(e -> {
				Shop shops = shophash.get(deleteshop.getTextField1().getText().trim());
				String shopnames = shops.getShopname();
				shophash.remove(shopnames);
				deleteshop(shops);
				deleteshop.getTextField1().setText(null);
				deleteshop.getTextField2().setText(null);
				deleteshop.getTextField3().setText(null);
				computerlist.clear();
				custlist.clear();
				servicelist.clear();
				shoplist.clear();
				selllist.clear();
				replist.clear();
				buylist.clear();
				connecttab.getM1().getMixedTableView().getItems().clear();
				connecttab.getM2().getMixedTableView().getItems().clear();
				connecttab.getShop().getTableView().getItems().clear();
				connecttab.getSell().getTableView().getItems().clear();
				connecttab.getRep().getTableView().getItems().clear();
				connecttab.getCus().getCustomerTableView().getItems().clear();
				connecttab.getComp().getComputerTableView().getItems().clear();
				for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
					if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "None"));
					} else if (entry.getValue().getIsbuy() == 1) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Buy"));
					} else if (entry.getValue().getIsrepair() == 1) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Repair"));
					}
				}
//					for (Map.Entry<String,Services> entry : servicehash.entrySet()) {
//					       String repname=repemphash.get(entry.getValue().getRepid()).getEmpname() ;
//					       String custname=cushash.get(entry.getValue().getCustid()).getName();
//                        String model =comphash.get(entry.getValue().getSerialnum()).getModel();
//						servicelist.add(new ServicesTable(repname,custname,entry.getValue().getCustid(),entry.getValue().getSerialnum(),entry.getValue().getRepid(),model));         
//					}
				for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
					String repId = entry.getValue().getRepid();
					String custId = entry.getValue().getCustid();
					String serialNum = entry.getValue().getSerialnum();

					String repname = "Unknown";
					if (repId != null && repemphash.containsKey(repId)) {
						RepEmp repEmp = repemphash.get(repId);
						if (repEmp != null) {
							repname = repEmp.getEmpname();
						}
					}

					String custname = "Unknown";
					if (custId != null && cushash.containsKey(custId)) {
						Customer customer = cushash.get(custId);
						if (customer != null) {
							custname = customer.getName();
						}
					}

					String model = "Unknown";
					if (serialNum != null && comphash.containsKey(serialNum)) {
						Computer computer = comphash.get(serialNum);
						if (computer != null) {
							model = computer.getModel();
						}
					}

					servicelist.add(new ServicesTable(repname, custname, custId, serialNum, repId, model));
				}

				for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
				    String custId = entry.getValue().getCustid();
				    String sellId = entry.getValue().getSellid();
				    String serialNum = entry.getValue().getSerialnum();

				    // Check if the customer with the given ID exists in the cushion
				    Customer customer = cushash.get(custId);
				    if (customer != null) {
				        String custname = customer.getName();

				        // Check if the employee with the given ID exists in the sellemphash
				        SellerEmp employee = sellemphash.get(sellId);
				        if (employee != null) {
				            String sellname = employee.getEmpname();

				            // Check if the computer with the given serial number exists in the comphash
				            Computer computer = comphash.get(serialNum);
				            if (computer != null) {
				                String model = computer.getModel();
				                double price = computer.getPrice();

				                // Add a new BuysTable object to buylist
				                buylist.add(new BuysTable(custname, custId, sellId, serialNum, sellname, model, price));
				            } else {
				                System.out.println("Computer with serial number " + serialNum + " not found in comphash.");
				            }
				        } else {
				            System.out.println("Employee with ID " + sellId + " not found in sellemphash.");
				        }
				    } else {
				        System.out.println("Customer with ID " + custId + " not found in cushash.");
				    }
				}


				for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
					String email = entry.getValue().getEmpemail();
					String phone = entry.getValue().getEmpphone();
					String repid = entry.getValue().getRepid();
					int age = entry.getValue().getEmpage();
					String address = entry.getValue().getEmpaddress();
					String name = entry.getValue().getEmpname();
					String shopname = entry.getValue().getShopname();
					String gender = entry.getValue().getEmpgender();
					replist.add(new RepEmpTable(email, phone, repid, age, address, name, shopname, gender));
				}

				for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
					String email = entry.getValue().getEmpemail();
					String phone = entry.getValue().getEmpphone();
					String repid = entry.getValue().getSellid();
					int age = entry.getValue().getEmpage();
					String address = entry.getValue().getEmpaddress();
					String name = entry.getValue().getEmpname();
					String shopname = entry.getValue().getShopname();
					String gender = entry.getValue().getEmpgender();
					selllist.add(new SellerEmpTable(email, phone, repid, age, address, name, shopname, gender));
				}

				for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
					String name = entry.getValue().getName();
					String address = entry.getValue().getAddress();
					String phone = entry.getValue().getPhonenum();
					String custid = entry.getValue().getCustid();
					String password = entry.getValue().getPassword();
					custlist.add(new CustomerTable(name, address, phone, custid, password));
				}
				for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
					String name = entry.getValue().getShopname();
					String address = entry.getValue().getAddress();
					String phone = entry.getValue().getPhonenum();
					shoplist.add(new ShopTable(name, phone, address));
				}
//									      
				connecttab.getComp().getComputerTableView().setItems(computerlist);
				connecttab.getComp().getComputerTableView().refresh();
				connecttab.getM1().getMixedTableView().setItems(servicelist);
				connecttab.getM1().getMixedTableView().refresh();
				connecttab.getM2().getMixedTableView().setItems(buylist);
				connecttab.getM2().getMixedTableView().refresh();
				connecttab.getRep().getTableView().setItems(replist);
				connecttab.getRep().getTableView().refresh();
				connecttab.getSell().getTableView().setItems(selllist);
				connecttab.getSell().getTableView().refresh();
				connecttab.getCus().getCustomerTableView().setItems(custlist);
				connecttab.getCus().getCustomerTableView().refresh();
				connecttab.getShop().getTableView().setItems(shoplist);
				connecttab.getShop().getTableView().refresh();
				showAlertsuc("The Shop Is Deleted SuccsessFully !");
				stage19.close();
				stage20.close();
			});
			connecttab.getShop().getButton3().setOnAction(e -> {
				stage21.setScene(scene21);
				stage21.show();
			});

			updshoppass.getCancel().setOnAction(e -> {
				updshoppass.getShopNameTextField().setText(null);
				stage21.close();
			});

			updshoppass.getUpShopOkButton().setOnAction(e -> {
				if (updshoppass.getShopNameTextField().getText().equals("")) {
					showAlert("Please The Shop Name is Empty !!");
					updshoppass.getShopNameTextField().setText(null);
				} else if (shophash.containsKey(updshoppass.getShopNameTextField().getText().trim()) == false) {
					showAlert("Please The Shop Name is Not Exist !!");
					updshoppass.getShopNameTextField().setText(null);
				} else {
					Shop shops = shophash.get(updshoppass.getShopNameTextField().getText().trim());
					updshoppass.getShopNameTextField().setText(null);
					stage21.close();
					updshop.getTextField1().setText(shops.getShopname().trim());
					updshop.getTextField2().setText(shops.getPhonenum().trim());
					updshop.getTextField3().setText(shops.getAddress().trim());
					stage22.setScene(scene22);
					stage22.show();
				}
			});

			updshop.getCancel().setOnAction(e -> {
				updshop.getTextField1().setText(null);
				updshop.getTextField2().setText(null);
				updshop.getTextField3().setText(null);
				updshoppass.getShopNameTextField().setText(null);
				stage21.close();
				stage22.close();
			});

			updshop.getOkButton().setOnAction(e -> {
				Shop shops = shophash.get(updshop.getTextField1().getText().trim());
				String shopesname = shops.getShopname();
				shops.setAddress(updshop.getTextField3().getText().trim());
				shops.setPhonenum(updshop.getTextField2().getText().trim());
				shophash.put(shopesname, shops);
				String add = updshop.getTextField3().getText().trim();
				String pho = updshop.getTextField2().getText().trim();
				updateShopaddress(shopesname, add);
				updateShopphone(shopesname, pho);
				computerlist.clear();
				custlist.clear();
				servicelist.clear();
				shoplist.clear();
				selllist.clear();
				replist.clear();
				buylist.clear();
				connecttab.getM1().getMixedTableView().getItems().clear();
				connecttab.getM2().getMixedTableView().getItems().clear();
				connecttab.getShop().getTableView().getItems().clear();
				connecttab.getSell().getTableView().getItems().clear();
				connecttab.getRep().getTableView().getItems().clear();
				connecttab.getCus().getCustomerTableView().getItems().clear();
				connecttab.getComp().getComputerTableView().getItems().clear();
				for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
					if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "None"));
					} else if (entry.getValue().getIsbuy() == 1) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Buy"));
					} else if (entry.getValue().getIsrepair() == 1) {
						computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice(), "Repair"));
					}
				}
//					for (Map.Entry<String,Services> entry : servicehash.entrySet()) {
//					       String repname=repemphash.get(entry.getValue().getRepid()).getEmpname() ;
//					       String custname=cushash.get(entry.getValue().getCustid()).getName();
//                     String model =comphash.get(entry.getValue().getSerialnum()).getModel();
//						servicelist.add(new ServicesTable(repname,custname,entry.getValue().getCustid(),entry.getValue().getSerialnum(),entry.getValue().getRepid(),model));         
//					}
				for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
					String repId = entry.getValue().getRepid();
					String custId = entry.getValue().getCustid();
					String serialNum = entry.getValue().getSerialnum();

					String repname = "Unknown";
					if (repId != null && repemphash.containsKey(repId)) {
						RepEmp repEmp = repemphash.get(repId);
						if (repEmp != null) {
							repname = repEmp.getEmpname();
						}
					}

					String custname = "Unknown";
					if (custId != null && cushash.containsKey(custId)) {
						Customer customer = cushash.get(custId);
						if (customer != null) {
							custname = customer.getName();
						}
					}

					String model = "Unknown";
					if (serialNum != null && comphash.containsKey(serialNum)) {
						Computer computer = comphash.get(serialNum);
						if (computer != null) {
							model = computer.getModel();
						}
					}

					servicelist.add(new ServicesTable(repname, custname, custId, serialNum, repId, model));
				}

//				for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
//					String custname = cushash.get(entry.getValue().getCustid()).getName();
//					String sellname = sellemphash.get(entry.getValue().getSellid()).getEmpname();
//					String model = comphash.get(entry.getValue().getSerialnum()).getModel();
//					double price = comphash.get(entry.getValue().getSerialnum()).getPrice();
//					buylist.add(new BuysTable(custname, entry.getValue().getCustid(), entry.getValue().getSellid(),
//							entry.getValue().getSerialnum(), sellname, model, price));
//				}
				for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
				    String custId = entry.getValue().getCustid();
				    String sellId = entry.getValue().getSellid();
				    String serialNum = entry.getValue().getSerialnum();

				    // Check if the customer with the given ID exists in the cushion
				    Customer customer = cushash.get(custId);
				    if (customer != null) {
				        String custname = customer.getName();

				        // Check if the employee with the given ID exists in the sellemphash
				       SellerEmp employee = sellemphash.get(sellId);
				        if (employee != null) {
				            String sellname = employee.getEmpname();

				            // Check if the computer with the given serial number exists in the comphash
				            Computer computer = comphash.get(serialNum);
				            if (computer != null) {
				                String model = computer.getModel();
				                double price = computer.getPrice();

				                // Add a new BuysTable object to buylist
				                buylist.add(new BuysTable(custname, custId, sellId, serialNum, sellname, model, price));
				            } else {
				                System.out.println("Computer with serial number " + serialNum + " not found in comphash.");
				            }
				        } else {
				            System.out.println("Employee with ID " + sellId + " not found in sellemphash.");
				        }
				    } else {
				        System.out.println("Customer with ID " + custId + " not found in cushash.");
				    }
				}

				for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
					String email = entry.getValue().getEmpemail();
					String phone = entry.getValue().getEmpphone();
					String repid = entry.getValue().getRepid();
					int age = entry.getValue().getEmpage();
					String address = entry.getValue().getEmpaddress();
					String name = entry.getValue().getEmpname();
					String shopname = entry.getValue().getShopname();
					String gender = entry.getValue().getEmpgender();
					replist.add(new RepEmpTable(email, phone, repid, age, address, name, shopname, gender));
				}

				for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
					String email = entry.getValue().getEmpemail();
					String phone = entry.getValue().getEmpphone();
					String repid = entry.getValue().getSellid();
					int age = entry.getValue().getEmpage();
					String address = entry.getValue().getEmpaddress();
					String name = entry.getValue().getEmpname();
					String shopname = entry.getValue().getShopname();
					String gender = entry.getValue().getEmpgender();
					selllist.add(new SellerEmpTable(email, phone, repid, age, address, name, shopname, gender));
				}

				for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
					String name = entry.getValue().getName();
					String address = entry.getValue().getAddress();
					String phone = entry.getValue().getPhonenum();
					String custid = entry.getValue().getCustid();
					String password = entry.getValue().getPassword();
					custlist.add(new CustomerTable(name, address, phone, custid, password));
				}
				for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
					String name = entry.getValue().getShopname();
					String address = entry.getValue().getAddress();
					String phone = entry.getValue().getPhonenum();
					shoplist.add(new ShopTable(name, phone, address));
				}
//									      
				connecttab.getComp().getComputerTableView().setItems(computerlist);
				connecttab.getComp().getComputerTableView().refresh();
				connecttab.getM1().getMixedTableView().setItems(servicelist);
				connecttab.getM1().getMixedTableView().refresh();
				connecttab.getM2().getMixedTableView().setItems(buylist);
				connecttab.getM2().getMixedTableView().refresh();
				connecttab.getRep().getTableView().setItems(replist);
				connecttab.getRep().getTableView().refresh();
				connecttab.getSell().getTableView().setItems(selllist);
				connecttab.getSell().getTableView().refresh();
				connecttab.getCus().getCustomerTableView().setItems(custlist);
				connecttab.getCus().getCustomerTableView().refresh();
				connecttab.getShop().getTableView().setItems(shoplist);
				connecttab.getShop().getTableView().refresh();
				showAlertsuc("The Shop Is Updated SuccsessFully !");
				stage21.close();
				stage22.close();
			});

			connecttab.getShop().getButton4().setOnAction(e -> {
				stage23.setScene(scene23);
				stage23.show();
			});

			chooseadd.getOk().setOnAction(e -> {
				if (chooseadd.getSellerRadio().isSelected() == true) {
					stage24.setScene(scene24);
					stage24.show();
					stage23.close();
					chooseadd.getRepairRadio().setSelected(false);
					chooseadd.getSellerRadio().setSelected(false);
				} else {

					stage25.setScene(scene25);
					stage25.show();
					stage23.close();
					chooseadd.getRepairRadio().setSelected(false);
					chooseadd.getSellerRadio().setSelected(false);
				}
			});
			chooseadd.getBack().setOnAction(e -> {
				stage23.close();
			});

			addsellemp.getCloseButton().setOnAction(e -> {
				addsellemp.getNameTextField().setText(null);
				addsellemp.getAddressTextField().setText(null);
				addsellemp.getEmailTextField().setText(null);
				addsellemp.getAgeTextField().setText(null);
				addsellemp.getFemaleRadioButton().setSelected(false);
				addsellemp.getMaleRadioButton().setSelected(false);
				addsellemp.getIdTextField().setText(null);
				addsellemp.getPhoneTextField().setText(null);
				addsellemp.getShopTextField().setText(null);
				chooseadd.getRepairRadio().setSelected(false);
				chooseadd.getSellerRadio().setSelected(false);
				stage24.close();
				stage23.close();
			});

			addsellemp.getOkButton().setOnAction(e -> {
				if (addsellemp.getIdTextField().getText().equals("")
						|| addsellemp.getNameTextField().getText().equals("")
						|| addsellemp.getAgeTextField().getText().equals("")
						|| addsellemp.getEmailTextField().getText().equals("")
						|| (addsellemp.getMaleRadioButton().isSelected() == false
								&& addsellemp.getFemaleRadioButton().isSelected() == false)
						|| addsellemp.getAddressTextField().getText().equals("")
						|| addsellemp.getPhoneTextField().getText().equals("")
						|| addsellemp.getShopTextField().getText().equals("")) {
					showAlert("Please Theres Some Fields Empty !! " + "\n" + "Please Fill Them !!");
				} else if (isOnlyDigits(addsellemp.getIdTextField().getText()) == false) {
					showAlert("Please The Seller-ID Must Be Only Numbers !");
				} else if (addsellemp.getIdTextField().getText().length() > 7
						|| addsellemp.getIdTextField().getText().length() < 7) {
					showAlert("Please The Seller-ID Must Be Only 7 Numbers !");
				} else if (sellemphash.containsKey(addsellemp.getIdTextField().getText().trim()) == true
						|| repemphash.containsKey(addsellemp.getIdTextField().getText().trim()) == true) {
					showAlert("Please The Seller-ID Is Already Exists !");
				} else if (containsGmailOrHotmail(addsellemp.getEmailTextField().getText().trim()) == false) {
					showAlert(" Incorrect Email Please The Seller-Email must contains :  !" + "\n"
							+ " @gmail or @hotmail !");
				} else if (isOnlyDigits(addsellemp.getPhoneTextField().getText().trim()) == false) {
					showAlert("Please The Seller-ID PhoneNumber Must Be Only Numbers !");
				} else if (addsellemp.getPhoneTextField().getText().length() > 10
						|| addsellemp.getPhoneTextField().getText().length() < 10) {
					showAlert("Please The Seller-ID PhoneNumber Must Be 10 Numbers !");
				} else if (shophash.containsKey(addsellemp.getShopTextField().getText().trim()) == false) {
					showAlert("Please The ShopName is Not Exist TryAgain !!");
				} else if (isOnlyDigits(addsellemp.getAgeTextField().getText().trim()) == false) {
					showAlert("Please The Seller Age Must Only Number !!");
				} else {
					String sellid = addsellemp.getIdTextField().getText().trim();
					String sellname = addsellemp.getNameTextField().getText().trim();
					String selladdress = addsellemp.getAddressTextField().getText().trim();
					int sellage = Integer.parseInt(addsellemp.getAgeTextField().getText().trim());
					String sellemail = addsellemp.getEmailTextField().getText().trim();
					String sgender;
					if (addsellemp.getMaleRadioButton().isSelected() == true) {
						sgender = "Male";
					} else {
						sgender = "Female";
					}

					String shopselln = addsellemp.getShopTextField().getText().trim();
					String sellphone = addsellemp.getPhoneTextField().getText().trim();
					SellerEmp sellemp = new SellerEmp(sellid, sellname, sellage, sellemail, sellphone, selladdress,
							sgender, shopselln);
					sellemphash.put(sellid, sellemp);
					insertDataSelleremp(sellemp);
					computerlist.clear();
					custlist.clear();
					servicelist.clear();
					shoplist.clear();
					selllist.clear();
					replist.clear();
					buylist.clear();
					connecttab.getM1().getMixedTableView().getItems().clear();
					connecttab.getM2().getMixedTableView().getItems().clear();
					connecttab.getShop().getTableView().getItems().clear();
					connecttab.getSell().getTableView().getItems().clear();
					connecttab.getRep().getTableView().getItems().clear();
					connecttab.getCus().getCustomerTableView().getItems().clear();
					connecttab.getComp().getComputerTableView().getItems().clear();
					for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
						if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "None"));
						} else if (entry.getValue().getIsbuy() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Buy"));
						} else if (entry.getValue().getIsrepair() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Repair"));
						}
					}
					for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
						String repname = repemphash.get(entry.getValue().getRepid()).getEmpname();
						String custname = cushash.get(entry.getValue().getCustid()).getName();
						String model = comphash.get(entry.getValue().getSerialnum()).getModel();
						servicelist.add(new ServicesTable(repname, custname, entry.getValue().getCustid(),
								entry.getValue().getSerialnum(), entry.getValue().getRepid(), model));
					}

					for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
						String custname = cushash.get(entry.getValue().getCustid()).getName();
						String ssellname = sellemphash.get(entry.getValue().getSellid()).getEmpname();
						String model = comphash.get(entry.getValue().getSerialnum()).getModel();
						double price = comphash.get(entry.getValue().getSerialnum()).getPrice();
						buylist.add(new BuysTable(custname, entry.getValue().getCustid(), entry.getValue().getSellid(),
								entry.getValue().getSerialnum(), ssellname, model, price));
					}

					for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getRepid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						replist.add(new RepEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}

					for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getSellid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						selllist.add(new SellerEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}

					for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
						String name = entry.getValue().getName();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						String custid = entry.getValue().getCustid();
						String password = entry.getValue().getPassword();
						custlist.add(new CustomerTable(name, address, phone, custid, password));
					}
					for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
						String name = entry.getValue().getShopname();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						shoplist.add(new ShopTable(name, phone, address));
					}
//										      
					connecttab.getComp().getComputerTableView().setItems(computerlist);
					connecttab.getComp().getComputerTableView().refresh();
					connecttab.getM1().getMixedTableView().setItems(servicelist);
					connecttab.getM1().getMixedTableView().refresh();
					connecttab.getM2().getMixedTableView().setItems(buylist);
					connecttab.getM2().getMixedTableView().refresh();
					connecttab.getRep().getTableView().setItems(replist);
					connecttab.getRep().getTableView().refresh();
					connecttab.getSell().getTableView().setItems(selllist);
					connecttab.getSell().getTableView().refresh();
					connecttab.getCus().getCustomerTableView().setItems(custlist);
					connecttab.getCus().getCustomerTableView().refresh();
					connecttab.getShop().getTableView().setItems(shoplist);
					connecttab.getShop().getTableView().refresh();

					addsellemp.getNameTextField().setText(null);
					addsellemp.getAddressTextField().setText(null);
					addsellemp.getEmailTextField().setText(null);
					addsellemp.getAgeTextField().setText(null);
					addsellemp.getFemaleRadioButton().setSelected(false);
					addsellemp.getMaleRadioButton().setSelected(false);
					addsellemp.getIdTextField().setText(null);
					addsellemp.getPhoneTextField().setText(null);
					addsellemp.getShopTextField().setText(null);
					chooseadd.getRepairRadio().setSelected(false);
					chooseadd.getSellerRadio().setSelected(false);
					stage24.close();
					stage23.close();
				}
			});

			addrepemp.getOkButton().setOnAction(e -> {
				if (addrepemp.getIdTextField().getText().equals("") || addrepemp.getNameTextField().getText().equals("")
						|| addrepemp.getAgeTextField().getText().equals("")
						|| addrepemp.getEmailTextField().getText().equals("")
						|| (addrepemp.getMaleRadioButton().isSelected() == false
								&& addrepemp.getFemaleRadioButton().isSelected() == false)
						|| addrepemp.getAddressTextField().getText().equals("")
						|| addrepemp.getPhoneTextField().getText().equals("")
						|| addrepemp.getShopTextField().getText().equals("")) {
					showAlert("Please Theres Some Fields Empty !! " + "\n" + "Please Fill Them !!");
				} else if (isOnlyDigits(addrepemp.getIdTextField().getText()) == false) {
					showAlert("Please The Seller-ID Must Be Only Numbers !");
				} else if (addrepemp.getIdTextField().getText().length() > 7
						|| addrepemp.getIdTextField().getText().length() < 7) {
					showAlert("Please The Seller-ID Must Be Only 7 Numbers !");
				} else if (sellemphash.containsKey(addrepemp.getIdTextField().getText().trim()) == true
						|| repemphash.containsKey(addsellemp.getIdTextField().getText().trim()) == true) {
					showAlert("Please The Seller-ID Is Already Exists !");
				} else if (containsGmailOrHotmail(addrepemp.getEmailTextField().getText().trim()) == false) {
					showAlert(" Incorrect Email Please The Seller-Email must contains :  !" + "\n"
							+ " @gmail or @hotmail !");
				} else if (isOnlyDigits(addrepemp.getPhoneTextField().getText().trim()) == false) {
					showAlert("Please The Seller-ID PhoneNumber Must Be Only Numbers !");
				} else if (addrepemp.getPhoneTextField().getText().length() > 10
						|| addrepemp.getPhoneTextField().getText().length() < 10) {
					showAlert("Please The Seller-ID PhoneNumber Must Be 10 Numbers !");
				} else if (shophash.containsKey(addrepemp.getShopTextField().getText().trim()) == false) {
					showAlert("Please The ShopName is Not Exist TryAgain !!");
				} else if (isOnlyDigits(addrepemp.getAgeTextField().getText().trim()) == false) {
					showAlert("Please The Seller Age Must Only Number !!");
				} else {
					String rid = addrepemp.getIdTextField().getText().trim();
					String rname = addrepemp.getNameTextField().getText().trim();
					String raddress = addrepemp.getAddressTextField().getText().trim();
					int rage = Integer.parseInt(addrepemp.getAgeTextField().getText().trim());
					String remail = addrepemp.getEmailTextField().getText().trim();
					String rgender;
					if (addrepemp.getMaleRadioButton().isSelected() == true) {
						rgender = "Male";
					} else {
						rgender = "Female";
					}

					String shoprn = addrepemp.getShopTextField().getText().trim();
					String rphone = addrepemp.getPhoneTextField().getText().trim();
					RepEmp remp = new RepEmp(rid, rname, rage, remail, rphone, raddress, rgender, shoprn);
					repemphash.put(rid, remp);
					insertDataRepEmp(remp);
					computerlist.clear();
					custlist.clear();
					servicelist.clear();
					shoplist.clear();
					selllist.clear();
					replist.clear();
					buylist.clear();
					connecttab.getM1().getMixedTableView().getItems().clear();
					connecttab.getM2().getMixedTableView().getItems().clear();
					connecttab.getShop().getTableView().getItems().clear();
					connecttab.getSell().getTableView().getItems().clear();
					connecttab.getRep().getTableView().getItems().clear();
					connecttab.getCus().getCustomerTableView().getItems().clear();
					connecttab.getComp().getComputerTableView().getItems().clear();
					for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
						if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "None"));
						} else if (entry.getValue().getIsbuy() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Buy"));
						} else if (entry.getValue().getIsrepair() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Repair"));
						}
					}
//						for (Map.Entry<String,Services> entry : servicehash.entrySet()) {
//						       String repname=repemphash.get(entry.getValue().getRepid()).getEmpname() ;
//						       String custname=cushash.get(entry.getValue().getCustid()).getName();
//	                     String model =comphash.get(entry.getValue().getSerialnum()).getModel();
//							servicelist.add(new ServicesTable(repname,custname,entry.getValue().getCustid(),entry.getValue().getSerialnum(),entry.getValue().getRepid(),model));         
//						}
					for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
						String repname = repemphash.get(entry.getValue().getRepid()).getEmpname();

						String custname = "Unknown";
						Customer customer = cushash.get(entry.getValue().getCustid());
						if (customer != null) {
							custname = customer.getName();
						}

						String model = "Unknown";
						Computer computer = comphash.get(entry.getValue().getSerialnum());
						if (computer != null) {
							model = computer.getModel();
						}

						servicelist.add(new ServicesTable(repname, custname, entry.getValue().getCustid(),
								entry.getValue().getSerialnum(), entry.getValue().getRepid(), model));
					}

					for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
						String custname = cushash.get(entry.getValue().getCustid()).getName();
						String ssellname = sellemphash.get(entry.getValue().getSellid()).getEmpname();
						String model = comphash.get(entry.getValue().getSerialnum()).getModel();
						double price = comphash.get(entry.getValue().getSerialnum()).getPrice();
						buylist.add(new BuysTable(custname, entry.getValue().getCustid(), entry.getValue().getSellid(),
								entry.getValue().getSerialnum(), ssellname, model, price));
					}

					for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getRepid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						replist.add(new RepEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}

					for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getSellid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						selllist.add(new SellerEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}

					for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
						String name = entry.getValue().getName();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						String custid = entry.getValue().getCustid();
						String password = entry.getValue().getPassword();
						custlist.add(new CustomerTable(name, address, phone, custid, password));
					}
					for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
						String name = entry.getValue().getShopname();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						shoplist.add(new ShopTable(name, phone, address));
					}
//										      
					connecttab.getComp().getComputerTableView().setItems(computerlist);
					connecttab.getComp().getComputerTableView().refresh();
					connecttab.getM1().getMixedTableView().setItems(servicelist);
					connecttab.getM1().getMixedTableView().refresh();
					connecttab.getM2().getMixedTableView().setItems(buylist);
					connecttab.getM2().getMixedTableView().refresh();
					connecttab.getRep().getTableView().setItems(replist);
					connecttab.getRep().getTableView().refresh();
					connecttab.getSell().getTableView().setItems(selllist);
					connecttab.getSell().getTableView().refresh();
					connecttab.getCus().getCustomerTableView().setItems(custlist);
					connecttab.getCus().getCustomerTableView().refresh();
					connecttab.getShop().getTableView().setItems(shoplist);
					connecttab.getShop().getTableView().refresh();

					addrepemp.getNameTextField().setText(null);
					addrepemp.getAddressTextField().setText(null);
					addrepemp.getEmailTextField().setText(null);
					addrepemp.getAgeTextField().setText(null);
					addrepemp.getFemaleRadioButton().setSelected(false);
					addrepemp.getMaleRadioButton().setSelected(false);
					addrepemp.getIdTextField().setText(null);
					addrepemp.getPhoneTextField().setText(null);
					addrepemp.getShopTextField().setText(null);
					chooseadd.getRepairRadio().setSelected(false);
					chooseadd.getSellerRadio().setSelected(false);
					stage25.close();
					stage23.close();
				}
			});
			addrepemp.getCloseButton().setOnAction(e -> {
				addrepemp.getNameTextField().setText(null);
				addrepemp.getAddressTextField().setText(null);
				addrepemp.getEmailTextField().setText(null);
				addrepemp.getAgeTextField().setText(null);
				addrepemp.getFemaleRadioButton().setSelected(false);
				addrepemp.getMaleRadioButton().setSelected(false);
				addrepemp.getIdTextField().setText(null);
				addrepemp.getPhoneTextField().setText(null);
				addrepemp.getShopTextField().setText(null);
				chooseadd.getRepairRadio().setSelected(false);
				chooseadd.getSellerRadio().setSelected(false);
				stage25.close();
				stage23.close();
			});

			connecttab.getShop().getButton5().setOnAction(e -> {
				stage26.setScene(scene26);
				stage26.show();
			});

			chooseupd.getBack().setOnAction(e -> {
				chooseupd.getRepairRadio().setSelected(false);
				chooseupd.getSellerRadio().setSelected(false);
				stage26.close();
			});

			chooseupd.getOk().setOnAction(e -> {
				if (chooseupd.getSellerRadio().isSelected() == true) {
					stage27.setScene(scene27);
					stage27.show();
					chooseupd.getRepairRadio().setSelected(false);
					chooseupd.getSellerRadio().setSelected(false);
					stage26.close();
				} else {
					stage28.setScene(scene28);
					stage28.show();
					chooseupd.getRepairRadio().setSelected(false);
					chooseupd.getSellerRadio().setSelected(false);
					stage26.close();
				}
			});

			sellupass.getShow().setOnAction(e -> {
				if (sellupass.getShow().isSelected()) {
					sellupass.getPass().setPromptText(sellupass.getPass().getText());
					sellupass.getPass().setText("");
				} else {
					sellupass.getPass().setText(sellupass.getPass().getPromptText());
					sellupass.getPass().setPromptText("Password");
				}
			});

			sellupass.getMain().setOnAction(e -> {
				sellupass.getPass().setText(null);
				chooseupd.getRepairRadio().setSelected(false);
				chooseupd.getSellerRadio().setSelected(false);
				stage26.close();
				stage27.close();
			});

			sellupass.getOk().setOnAction(e -> {
				if (sellemphash.containsKey(sellupass.getPass().getText().trim()) == false) {
					showAlert("Please This Seller-ID Is Not Exists Please Try Again !");
					sellupass.getPass().setText(null);
				} else {
					stage29.setScene(scene29);
					stage29.show();

				}
			});

			password.getOk().setOnAction(e -> {
				if (password.getPass().getText().equals(passwordd)) {
					password.getPass().setText(null);
					password.getMassg().setText(null);
					showAlertsuc("Welcome Admin to Your Shop !");
					stage2.close();
					stage16.setScene(scene16);
					stage16.show();
					computerlist.clear();
					custlist.clear();
					servicelist.clear();
					shoplist.clear();
					selllist.clear();
					replist.clear();
					buylist.clear();
					connecttab.getM1().getMixedTableView().getItems().clear();
					connecttab.getM2().getMixedTableView().getItems().clear();
					connecttab.getShop().getTableView().getItems().clear();
					connecttab.getSell().getTableView().getItems().clear();
					connecttab.getRep().getTableView().getItems().clear();
					connecttab.getCus().getCustomerTableView().getItems().clear();
					connecttab.getComp().getComputerTableView().getItems().clear();
					for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
						if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "None"));
						} else if (entry.getValue().getIsbuy() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Buy"));
						} else if (entry.getValue().getIsrepair() == 1) {
							computerlist.add(new ComputerTable2(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice(), "Repair"));
						}
					}
//						for (Map.Entry<String,Services> entry : servicehash.entrySet()) {
////							for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
//							    String repId = entry.getValue().getRepid();
//							    String custId = entry.getValue().getCustid();
//							    String serialNum = entry.getValue().getSerialnum();
//
//
//							    servicelist.add(new ServicesTable(repname, custname, custId, serialNum, repId, model));
////							}
////
//						}
					for (Map.Entry<String, Services> entry : servicehash.entrySet()) {
						String repId = entry.getValue().getRepid();
						String custId = entry.getValue().getCustid();
						String serialNum = entry.getValue().getSerialnum();

						String repname = "Unknown";
						if (repId != null && repemphash.containsKey(repId)) {
							RepEmp repEmp = repemphash.get(repId);
							if (repEmp != null) {
								repname = repEmp.getEmpname();
							}
						}

						String custname = "Unknown";
						if (custId != null && cushash.containsKey(custId)) {
							Customer customer = cushash.get(custId);
							if (customer != null) {
								custname = customer.getName();
							}
						}

						String model = "Unknown";
						if (serialNum != null && comphash.containsKey(serialNum)) {
							Computer computer = comphash.get(serialNum);
							if (computer != null) {
								model = computer.getModel();
							}
						}

						servicelist.add(new ServicesTable(repname, custname, custId, serialNum, repId, model));
					}

//						       String repname=repemphash.get(entry.getValue().getRepid()).getEmpname() ;
//						       String custname=cushash.get(entry.getValue().getCustid()).getName();
//                               String model =comphash.get(entry.getValue().getSerialnum()).getModel();
//							servicelist.add(new ServicesTable(repname,custname,entry.getValue().getCustid(),entry.getValue().getSerialnum(),entry.getValue().getRepid(),model));         
//						}

//						        for (Map.Entry<String,Buys> entry : buyhash.entrySet()) {
//						        	String custname= cushash.get(entry.getValue().getCustid()).getName();
//						        	String sellname=sellemphash.get(entry.getValue().getSellid()).getEmpname();
//						        	String model=comphash.get(entry.getValue().getSerialnum()).getModel();
//						        	double price=comphash.get(entry.getValue().getSerialnum()).getPrice();
//							   buylist.add(new BuysTable(custname,entry.getValue().getCustid(),entry.getValue().getSellid(),entry.getValue().getSerialnum(),sellname,model,price));
//							        }
//						        
					for (Map.Entry<String, Buys> entry : buyhash.entrySet()) {
						String custId = entry.getValue().getCustid();
						String sellId = entry.getValue().getSellid();
						String serialNum = entry.getValue().getSerialnum();

						String custname = "Unknown";
						if (custId != null && cushash.containsKey(custId)) {
							Customer customer = cushash.get(custId);
							if (customer != null) {
								custname = customer.getName();
							}
						}

						String sellname = "Unknown";
						if (sellId != null && sellemphash.containsKey(sellId)) {
							SellerEmp sellerEmp = sellemphash.get(sellId);
							if (sellerEmp != null) {
								sellname = sellerEmp.getEmpname();
							}
						}

						String model = "Unknown";
						double price = 0.0;
						if (serialNum != null && comphash.containsKey(serialNum)) {
							Computer computer = comphash.get(serialNum);
							if (computer != null) {
								model = computer.getModel();
								price = computer.getPrice();
							}
						}

						buylist.add(new BuysTable(custname, custId, sellId, serialNum, sellname, model, price));
					}

					for (Map.Entry<String, RepEmp> entry : repemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getRepid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						replist.add(new RepEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}

					for (Map.Entry<String, SellerEmp> entry : sellemphash.entrySet()) {
						String email = entry.getValue().getEmpemail();
						String phone = entry.getValue().getEmpphone();
						String repid = entry.getValue().getSellid();
						int age = entry.getValue().getEmpage();
						String address = entry.getValue().getEmpaddress();
						String name = entry.getValue().getEmpname();
						String shopname = entry.getValue().getShopname();
						String gender = entry.getValue().getEmpgender();
						selllist.add(new SellerEmpTable(email, phone, repid, age, address, name, shopname, gender));
					}
					// }
					for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
						String name = entry.getValue().getName();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						String custid = entry.getValue().getCustid();
						String password = entry.getValue().getPassword();
						custlist.add(new CustomerTable(name, address, phone, custid, password));
					}
					for (Map.Entry<String, Shop> entry : shophash.entrySet()) {
						String name = entry.getValue().getShopname();
						String address = entry.getValue().getAddress();
						String phone = entry.getValue().getPhonenum();
						shoplist.add(new ShopTable(name, phone, address));
					}
//										      
					connecttab.getComp().getComputerTableView().setItems(computerlist);
					connecttab.getComp().getComputerTableView().refresh();
					connecttab.getM1().getMixedTableView().setItems(servicelist);
					connecttab.getM1().getMixedTableView().refresh();
					connecttab.getM2().getMixedTableView().setItems(buylist);
					connecttab.getM2().getMixedTableView().refresh();
					connecttab.getRep().getTableView().setItems(replist);
					connecttab.getRep().getTableView().refresh();
					connecttab.getSell().getTableView().setItems(selllist);
					connecttab.getSell().getTableView().refresh();
					connecttab.getCus().getCustomerTableView().setItems(custlist);
					connecttab.getCus().getCustomerTableView().refresh();
					connecttab.getShop().getTableView().setItems(shoplist);
					connecttab.getShop().getTableView().refresh();
				} else {
					showAlert(" Please The Password is wrong please try again!!! ");
					password.getPass().setText(null);
				}
			});

			repscreen.getClearbutton().setOnAction(e -> {
				repscreen.getserialTextField().setText(null);
				repscreen.getColorTextField().setText(null);
				repscreen.getStorageComboBox().setValue(null);
				repscreen.getRamComboBox().setValue(null);
				repscreen.getModelTextField().setValue(null);
				repscreen.getCpuComboBox().setValue(null);
				repscreen.getPriceTextField().setText(null);
			});
			repscreen.getOkButton().setOnAction(e -> {
				if (repscreen.getserialTextField().getText().equals("")
						|| repscreen.getColorTextField().getText().equals("")
						|| repscreen.getPriceTextField().getText().equals("")
						|| repscreen.getCpuComboBox().getValue() == null
						|| repscreen.getRamComboBox().getValue() == null || repscreen.getStorageComboBox() == null
						|| repscreen.getModelTextField().getValue() == null) {
					showAlert("Please There is a Empty Fields !!! ");
				} else if (isOnlyCharacters(repscreen.getColorTextField().getText()) == false) {
					showAlert("Please The Color Must be Known not Number !!!");

				} else if (isOnlyDigits(repscreen.getPriceTextField().getText()) == false) {
					showAlert("Please The Price Must Be Only Numbers not Character !!!");
				} else if (comphash.containsKey(repscreen.getserialTextField().getText()) == true) {
					showAlert("This Serial-Number Is Already Exist Please Try Again");
				} else {
					String serial = repscreen.getserialTextField().getText().trim();
					String color = repscreen.getColorTextField().getText().trim();
					int ram = extractNumericValue(repscreen.getRamComboBox().getValue().trim());
					String cpu = repscreen.getCpuComboBox().getValue().trim();
					String model = repscreen.getModelTextField().getValue().trim();
					int storage = extractNumericValue(repscreen.getStorageComboBox().getValue().trim());
					double price = Double.parseDouble(repscreen.getPriceTextField().getText().trim());
					Computer com = new Computer(color, cpu, ram, model, storage, serial, 0, price, 1);
					comphash.put(com.getSerialnum(), com);
					insertDatacomputer(com);
					Services servi = new Services(CustomerID, repscreen.getRepidtxt().getText().trim(),
							com.getSerialnum());
					insertDataServices(servi);
					servicehash.put(com.getSerialnum(), servi);
					repscreen.getserialTextField().setText(null);
					repscreen.getColorTextField().setText(null);
					repscreen.getStorageComboBox().setValue(null);
					repscreen.getRamComboBox().setValue(null);
					repscreen.getModelTextField().setValue(null);
					repscreen.getCpuComboBox().setValue(null);
					repscreen.getPriceTextField().setText(null);
					showAlert("The Computer Is Add To Repair it Successfully! " + "\n"
							+ "Thank You For Choosing ENM Company !");
				}

			});
			repscreen.getCloseButton().setOnAction(e -> {
				repscreen.getserialTextField().setText(null);
				repscreen.getColorTextField().setText(null);
				repscreen.getStorageComboBox().setValue(null);
				repscreen.getRamComboBox().setValue(null);
				repscreen.getModelTextField().setValue(null);
				repscreen.getCpuComboBox().setValue(null);
				repscreen.getPriceTextField().setText(null);
				stage9.show();
				stage11.close();
			});

			custchoose.getBuyRadio().setOnAction(e -> {
				custchoose.getBuyRadio().setTextFill(Color.RED);
				custchoose.getRepairaRadio().setTextFill(Color.WHITE);
			});
			custchoose.getRepairaRadio().setOnAction(e -> {
				custchoose.getRepairaRadio().setTextFill(Color.RED);
				custchoose.getBuyRadio().setTextFill(Color.WHITE);
			});
			custchoose.getOk().setOnAction(e -> {
				if (custchoose.getBuyRadio().isSelected() == true) {
					sellidrandom = getRandomKey(sellemphash);
					buyscreen.getEmp().setText(sellidrandom);
					uniqueColors = getUniquePropertyValues(comphash, "color");
					uniqueCPUs = getUniquePropertyValues(comphash, "cpu");
					uniqueRAMs = getUniquePropertyValues(comphash, "ram");
					uniquemodel = getUniquePropertyValues(comphash, "model");
					uniqueprice = getUniquePropertyValues(comphash, "price");
					uniquestorage = getUniquePropertyValues(comphash, "storage");
					colorfilter = FXCollections.observableArrayList(uniqueColors);
					cpufilter = FXCollections.observableArrayList(uniqueCPUs);
					ramfilter = FXCollections.observableArrayList(uniqueRAMs);
					modelfilter = FXCollections.observableArrayList(uniquemodel);
					pricefilter = FXCollections.observableArrayList(uniqueprice);
					storagefilter = FXCollections.observableArrayList(uniquestorage);
					buyscreen.getColorFilter().setItems(colorfilter);
					buyscreen.getCpuFilter().setItems(cpufilter);
					buyscreen.getRamFilter().setItems(ramfilter);
					buyscreen.getModelfilter().setItems(modelfilter);
					buyscreen.getPricec().setItems(pricefilter);
					buyscreen.getStorageFilter().setItems(storagefilter);
					// System.out.println("The Value of the combo is
					// "+buyscreen.getColorFilter().getValue());
					buycomplist.clear();
					buyscreen.getTableView().getItems().clear();

					for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
						if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
							buycomplist.add(new ComputerTable(entry.getValue().getColor(), entry.getValue().getCpu(),
									entry.getValue().getRam(), entry.getValue().getModel(),
									entry.getValue().getStorage(), entry.getValue().getSerialnum(),
									entry.getValue().getPrice()));
						}
					}
					buyscreen.getTableView().setItems(buycomplist);
					buyscreen.getTableView().refresh();

					stage10.setScene(scene10);
					stage10.show();
					custchoose.getBuyRadio().setTextFill(Color.WHITE);
					custchoose.getRepairaRadio().setTextFill(Color.WHITE);
					custchoose.getBuyRadio().setSelected(false);
					custchoose.getRepairaRadio().setSelected(false);

				} else {
					repidrandom = getRandomrepKey(repemphash);
					repscreen.getRepidtxt().setText(repidrandom);
					stage11.setScene(scene11);
					stage11.show();
					custchoose.getBuyRadio().setTextFill(Color.WHITE);
					custchoose.getRepairaRadio().setTextFill(Color.WHITE);
					custchoose.getBuyRadio().setSelected(false);
					custchoose.getRepairaRadio().setSelected(false);
				}
			});
			buyscreen.getFilternow().setOnAction(e -> {
				String color = buyscreen.getColorFilter().getValue();
//			Integer ram= Integer.parseInt(buyscreen.getRamFilter().getValue());
				Integer ram = null;
				String ramValue = buyscreen.getRamFilter().getValue();
				if (ramValue != null && !ramValue.isEmpty()) {
					try {
						ram = Integer.parseInt(ramValue);
					} catch (NumberFormatException ex) {
						// Handle the case where ramValue is not a valid integer
						ex.printStackTrace(); // Log the exception or take appropriate action
					}
				}

				// Parse storage with null check
				Integer storage = null;
				String storageValue = buyscreen.getStorageFilter().getValue();
				if (storageValue != null && !storageValue.isEmpty()) {
					try {
						storage = Integer.parseInt(storageValue);
					} catch (NumberFormatException ex) {
						// Handle the case where storageValue is not a valid integer
						ex.printStackTrace(); // Log the exception or take appropriate action
					}
				}
				String cpu = buyscreen.getCpuFilter().getValue();
				String model = buyscreen.getModelfilter().getValue();
				Double price = null;
				String priceValue = buyscreen.getPricec().getValue();
				if (priceValue != null && !priceValue.isEmpty()) {
					try {
						price = Double.parseDouble(priceValue);
					} catch (NumberFormatException ex) {
						// Handle the case where storageValue is not a valid integer
						ex.printStackTrace(); // Log the exception or take appropriate action
					}
				}

				buyscreen.getTableView().getItems().clear();
				buyscreen.getTableView().refresh();
				// int ram = (ramString != null && !ramString.trim().isEmpty()) ?
				// Integer.parseInt(ramString.trim()) : 0;
				// int storage = (storageString != null && !storageString.trim().isEmpty()) ?
				// Integer.parseInt(storageString.trim()) : 0;
				// double price = (priceString != null && !priceString.trim().isEmpty()) ?
				// Double.parseDouble(priceString.trim()) : 0.0;

				executeQuery(color, cpu, ram, model, storage, price);
				buyscreen.getTableView().setItems(buycomplist);
				buyscreen.getTableView().refresh();

			});

			buyscreen.getCloseButton().setOnAction(e -> {
				stage10.close();
				stage9.setScene(scene9);
				stage9.show();
			});
			addcard.getMain().setOnAction(e -> {
				stage15.close();
				comptable = null;
				buyscreen.getTableView().getSelectionModel().clearSelection();
			});
			buyscreen.getAddToCartButton().setOnAction(e -> {
				comptable = buyscreen.getTableView().getSelectionModel().getSelectedItem();
				if (comptable == null) {
					showAlert("Please Choose Computer To Buy It !!!");
				} else {
					stage15.setScene(scene15);
					stage15.show();
				}
			});

			addcard.getOk().setOnAction(e -> {
				Buys bu = new Buys(CustomerID, buyscreen.getEmp().getText().trim(), comptable.getSerialnum().trim());
				insertDataBuys(bu);
				buyscreen.getTableView().getSelectionModel().clearSelection();
				// String color=comptable.getColor();
				// String cputype=comptable.getCpu();
				// int ram=comptable.getRam();
				// String model=comptable.getModel();
				String serial = comptable.getSerialnum().trim();
				// double price=comptable.getPrice();
				// int stg=comptable.getStorage();
				updatecomputerIsBuy(serial, 1);
				Computer compuup = comphash.get(serial);
				compuup.setIsbuy(1);
				comphash.put(serial, compuup);
				buycomplist.clear();
				buyscreen.getTableView().getItems().clear();
				for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
					if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
						buycomplist.add(new ComputerTable(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice()));
					}
				}

				buyscreen.getTableView().setItems(buycomplist);
				buyscreen.getTableView().refresh();

			});

			buyscreen.getCancelfilter().setOnAction(e -> {
				colorfilter.clear();
				cpufilter.clear();
				ramfilter.clear();
				modelfilter.clear();
				pricefilter.clear();
				storagefilter.clear();
				uniqueColors.clear();
				uniqueCPUs.clear();
				uniqueRAMs.clear();
				uniquemodel.clear();
				uniqueprice.clear();
				uniquestorage.clear();
				uniqueColors = getUniquePropertyValues(comphash, "color");
				uniqueCPUs = getUniquePropertyValues(comphash, "cpu");
				uniqueRAMs = getUniquePropertyValues(comphash, "ram");
				uniquemodel = getUniquePropertyValues(comphash, "model");
				uniqueprice = getUniquePropertyValues(comphash, "price");
				uniquestorage = getUniquePropertyValues(comphash, "storage");
				colorfilter = FXCollections.observableArrayList(uniqueColors);
				cpufilter = FXCollections.observableArrayList(uniqueCPUs);
				ramfilter = FXCollections.observableArrayList(uniqueRAMs);
				modelfilter = FXCollections.observableArrayList(uniquemodel);
				pricefilter = FXCollections.observableArrayList(uniqueprice);
				storagefilter = FXCollections.observableArrayList(uniquestorage);
				buyscreen.getColorFilter().setItems(colorfilter);
				buyscreen.getCpuFilter().setItems(cpufilter);
				buyscreen.getRamFilter().setItems(ramfilter);
				buyscreen.getModelfilter().setItems(modelfilter);
				buyscreen.getPricec().setItems(pricefilter);
				buyscreen.getStorageFilter().setItems(storagefilter);
				buyscreen.getColorFilter().setPromptText("Color");
				buyscreen.getCpuFilter().setPromptText("CPU");
				buyscreen.getRamFilter().setPromptText("RAMs");
				buyscreen.getModelfilter().setPromptText("Model");
				buyscreen.getPricec().setAccessibleText("price");
				buyscreen.getStorageFilter().setPromptText("Storage");
				buycomplist.clear();
				buyscreen.getTableView().getItems().clear();
				for (Map.Entry<String, Computer> entry : comphash.entrySet()) {
					if (entry.getValue().getIsbuy() == 0 && entry.getValue().getIsrepair() == 0) {
						buycomplist.add(new ComputerTable(entry.getValue().getColor(), entry.getValue().getCpu(),
								entry.getValue().getRam(), entry.getValue().getModel(), entry.getValue().getStorage(),
								entry.getValue().getSerialnum(), entry.getValue().getPrice()));
					}
				}
				buyscreen.getTableView().setItems(buycomplist);
				buyscreen.getTableView().refresh();

			});

			custchoose.getBack().setOnAction(e -> {
				custchoose.getBuyRadio().setSelected(false);
				custchoose.getRepairaRadio().setSelected(false);
				custchoose.getBuyRadio().setTextFill(Color.WHITE);
				custchoose.getRepairaRadio().setTextFill(Color.WHITE);
				stage9.close();
				stage1.show();
			});

			getDatacustomer();

			// getDatacomputer();

			for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue().getName());
			}

			// data = new ArrayList<>();
			stage1.setScene(scene1);
			stage1.show();
			password.getMassg().setText(null);
			mainpage.getAdminbutton().setOnAction(e -> {
				stage2.setScene(scene2);
				stage2.show();
			});

			sign.getBack().setOnAction(e -> {
				sign.getPassword().setText(null);
				sign.getUseridpass().setText(null);
				stage3.close();
			});

			password.getPass().setOnMouseClicked(e -> {
				password.getPass().setText(null);
				password.getMassg().setText(null);
			});

			password.getMain().setOnAction(e -> {
				stage2.close();
			});

			mainpage.getCusserbutton().setOnAction(e -> {
				sign.getUseridpass().setText(null);
				sign.getPassword().setText(null);
				stage3.setScene(scene3);
				stage3.show();
			});

			sign.getShow1().setOnAction(e -> {
				if (sign.getShow1().isSelected()) {
					sign.getUseridpass().setPromptText(sign.getUseridpass().getText());
					sign.getUseridpass().setText("");
				} else {
					sign.getUseridpass().setText(sign.getUseridpass().getPromptText());
					sign.getUseridpass().setPromptText("Password");
				}
			});

			sign.getShow2().setOnAction(e -> {
				if (sign.getShow2().isSelected()) {
					sign.getPassword().setPromptText(sign.getPassword().getText());
					sign.getPassword().setText("");
				} else {
					sign.getPassword().setText(sign.getPassword().getPromptText());
					sign.getPassword().setPromptText("Password");
				}
			});

			sign.getSignin().setOnAction(e -> {
				stage3.close();
				sign.getPassword().setText(null);
				sign.getUseridpass().setText(null);
				stage4.setScene(scene4);
				stage4.show();
			});
			create.getOk().setOnAction(e -> {
				if (create.getNametxt().getText().equals("") || create.getAddtxt().getText().equals("")
						|| create.getIdtxt().getText().equals("") || create.getPhonetxt().getText().equals("")
						|| create.getPass().getText().equals("")) {
					showAlert(" Theres is Empty Feilds !");
				} else if (create.getIdtxt().getText().length() > 7 || create.getIdtxt().getText().length() < 7) {
					showAlert("The Id Number Must Be 7 Number !");
				} else if (create.getPhonetxt().getText().length() < 10
						|| create.getPhonetxt().getText().length() > 10) {
					showAlert("The PhoneNumber Must Be 10 numbers only ! ");
				} else if (isOnlyDigits(create.getIdtxt().getText()) == false
						|| isOnlyDigits(create.getPhonetxt().getText()) == false) {
					showAlert("The ID Number Must Be Only Digit !");
				} else if (isOnlyDigits(create.getPass().getText()) == true
						|| isOnlyCharacters(create.getPass().getText())) {
					showAlert("The Password Must Contains Letters And Numbers !");
				} else if (cushash.containsKey(create.getIdtxt().getText()) == true) {
					showAlert("This ID is Already Exist Please Enter It Again");
				} else {
					String cname = create.getNametxt().getText().trim();
					String caddress = create.getAddtxt().getText().trim();
					String cid = create.getIdtxt().getText().trim();
					String cphone = create.getPhonetxt().getText().trim();
					String cpassword = create.getPass().getText().trim();
					Customer c = new Customer(cname, caddress, cid, cphone, cpassword);
					insertDatacustomer(c);
					cushash.put(c.getCustid(), c);
					showAlertsuc("The Account Create Successfully");
					create.getNametxt().setText(null);
					create.getAddtxt().setText(null);
					create.getIdtxt().setText(null);
					create.getPhonetxt().setText(null);
					create.getPass().setText(null);
					stage4.close();
				}
			});
			create.getShow().setOnAction(e -> {
				if (create.getShow().isSelected()) {
					create.getPass().setPromptText(create.getPass().getText());
					create.getPass().setText("");
				} else {
					create.getPass().setText(create.getPass().getPromptText());
					create.getPass().setPromptText("Password");
				}
			});
			custup.getShow().setOnAction(e -> {
				if (custup.getShow().isSelected()) {
					custup.getPassid().setPromptText(custup.getPassid().getText());
					custup.getPassid().setText("");
				} else {
					custup.getPassid().setText(custup.getPassid().getPromptText());
					custup.getPassid().setPromptText("Password");
				}
			});

			create.getClear().setOnAction(e -> {
				create.getNametxt().setText(null);
				create.getAddtxt().setText(null);
				create.getIdtxt().setText(null);
				create.getPhonetxt().setText(null);
				create.getPass().setText(null);
			});
			create.getBack().setOnAction(e -> {
				create.getNametxt().setText(null);
				create.getAddtxt().setText(null);
				create.getIdtxt().setText(null);
				create.getPhonetxt().setText(null);
				create.getPass().setText(null);
				sign.getUseridpass().setText(null);
				sign.getPassword().setText(null);
				stage4.close();
				stage3.show();
			});

			sign.getDelete().setOnAction(e -> {
				stage5.setScene(scene5);
				stage5.show();
			});
			deletecus.getShow().setOnAction(e -> {
				if (deletecus.getShow().isSelected()) {
					deletecus.getPassid().setPromptText(deletecus.getPassid().getText());
					deletecus.getPassid().setText("");
				} else {
					deletecus.getPassid().setText(deletecus.getPassid().getPromptText());
					deletecus.getPassid().setPromptText("Password");
				}
			});
			deletecus.getCancel().setOnAction(e -> {
				deletecus.getPassid().setText(null);
				stage5.close();
			});

			deletecus.getOk().setOnAction(e -> {
				if (cushash.containsKey(deletecus.getPassid().getText().trim())) {
					Customer c = cushash.get(deletecus.getPassid().getText().trim());
					delinfo.getNametxt().setText(c.getName());
					delinfo.getAddtxt().setText(c.getAddress());
					delinfo.getIdtxt().setText(c.getCustid());
					delinfo.getPhonetxt().setText(c.getPhonenum());
					delinfo.getPassword().setText(c.getPassword());
					stage6.setScene(scene6);
					stage6.show();
				} else {
					showAlert("Please This Id Does not exist please try again !");
					deletecus.getPassid().setText(null);
					delinfo.getNametxt().setText(null);
					delinfo.getAddtxt().setText(null);
					delinfo.getIdtxt().setText(null);
					delinfo.getPhonetxt().setText(null);
					delinfo.getPassword().setText(null);
				}
			});

			delinfo.getYes().setOnAction(e -> {
				Customer c = cushash.get(deletecus.getPassid().getText().trim());
				String id = c.getCustid();
				cushash.remove(id);
				deletecustomer(c);
				delinfo.getNametxt().setText(null);
				delinfo.getAddtxt().setText(null);
				delinfo.getIdtxt().setText(null);
				delinfo.getPhonetxt().setText(null);
				delinfo.getPassword().setText(null);
				deletecus.getPassid().setText(null);
				showAlert("The Customer is Deleted Successfully");
				stage5.close();
				stage6.close();
			});

			delinfo.getNo().setOnAction(e -> {
				delinfo.getNametxt().setText(null);
				delinfo.getAddtxt().setText(null);
				delinfo.getIdtxt().setText(null);
				delinfo.getPhonetxt().setText(null);
				delinfo.getPassword().setText(null);
				deletecus.getPassid().setText(null);
				stage5.close();
				stage6.close();
			});

			sign.getUpdatebutton().setOnAction(e -> {
				stage7.setScene(scene7);
				stage7.show();
			});
			custup.getCancel().setOnAction(e -> {
				custup.getPassid().setText(null);
				stage7.close();
			});
			custup.getOk().setOnAction(e -> {
				if (cushash.containsKey(custup.getPassid().getText().trim())) {
					Customer c = cushash.get(custup.getPassid().getText().trim());
					custinfo.getNametxt().setText(c.getName());
					custinfo.getAddtxt().setText(c.getAddress());
					custinfo.getIdtxt().setText(c.getCustid());
					custinfo.getPhonetxt().setText(c.getPhonenum());
					custinfo.getPassword().setText(c.getPassword());
					stage8.setScene(scene8);
					stage8.show();
				} else {
					showAlert("Please This Id Does not exist please try again !");
					custup.getPassid().setText(null);
					custinfo.getNametxt().setText(null);
					custinfo.getAddtxt().setText(null);
					custinfo.getIdtxt().setText(null);
					custinfo.getPhonetxt().setText(null);
					custinfo.getPassword().setText(null);
				}
			});

			custinfo.getDone().setOnAction(e -> {
				if (custinfo.getNametxt().getText().equals("") || custinfo.getAddtxt().getText().equals("")
						|| custinfo.getIdtxt().getText().equals("") || custinfo.getPhonetxt().getText().equals("")
						|| custinfo.getPassword().getText().equals("")) {
					showAlert(" Theres is Empty Feilds !");
				} else if (custinfo.getPhonetxt().getText().length() < 10
						|| custinfo.getPhonetxt().getText().length() > 10) {
					showAlert("The PhoneNumber  Must Be 10 numbers only ! ");

				} else if (isOnlyDigits(custinfo.getPassword().getText()) == true
						|| isOnlyCharacters(custinfo.getPassword().getText())) {
					showAlert("The Password Must Contains letters and Numbers !");
				} else {
					String cname = custinfo.getNametxt().getText().trim();
					String caddress = custinfo.getAddtxt().getText().trim();
					String cid = custinfo.getIdtxt().getText().trim();
					String cphone = custinfo.getPhonetxt().getText().trim();
					String cpassword = custinfo.getPassword().getText().trim();
					Customer c = cushash.get(cid);
					c.setName(cname);
					c.setAddress(caddress);
					c.setPhonenum(cphone);
					c.setPassword(cpassword);
					cushash.put(cid, c);
					updatecustname(cid, cname);
					updatecustaddress(cid, caddress);
					updatecustphone(cid, cphone);
					updatecustpassword(cid, cpassword);
					custinfo.getNametxt().setText(null);
					custinfo.getAddtxt().setText(null);
					custinfo.getIdtxt().setText(null);
					custinfo.getPhonetxt().setText(null);
					custinfo.getPassword().setText(null);
					custup.getPassid().setText(null);
					showAlertsuc("The Customer Information Updates Successfully !");
					stage8.close();
					stage7.close();
				}

			});
			custinfo.getNo().setOnAction(e -> {
				custup.getPassid().setText(null);
				custinfo.getNametxt().setText(null);
				custinfo.getAddtxt().setText(null);
				custinfo.getIdtxt().setText(null);
				custinfo.getPhonetxt().setText(null);
				custinfo.getPassword().setText(null);
				custup.getPassid().setText(null);
				stage8.close();
				stage7.close();
			});

			sign.getLoginbutton().setOnAction(e -> {
				if (sign.getUseridpass().getText() == null || sign.getPassword().getText() == null) {
					showAlert("Please Theres an Empty Feilds !");
				} else if (cushash.containsKey(sign.getUseridpass().getText()) == false) {
					showAlert("Please This Customer ID Does Not Exists Try Again");
					sign.getPassword().setText(null);
					sign.getUseridpass().setText(null);
				} else {
					Customer c = cushash.get(sign.getUseridpass().getText());
					if (c.getPassword().equals(sign.getPassword().getText())) {
						stage9.setScene(scene9);
						stage9.show();
						stage1.close();
						stage3.close();

						CustomerID = c.getCustid();
						System.out.println("The customer is after click is " + CustomerID);
						System.out.println("The Customer Name is " + c.getName());
						sign.getPassword().setText(null);
						sign.getUseridpass().setText(null);
					} else {
						sign.getPassword().setText(null);
						showAlert("InCorrect Password Please Try Again !");
					}
				}
			});

			// getData();

//			Customer c= new Customer("Eliana","AlQuds","1202825","0568722661","elianpass");
//			deletecustomer(c);

			for (int i = 0; i < custlist.size(); i++) {
				System.out.println("The cus name in arr: " + custlist.get(i).getName() + " The Id :"
						+ custlist.get(i).getCustid());
			}

//			for (Map.Entry<String, Customer> entry : cushash.entrySet()) {
//	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//	        }

			// convert data from arraylist to observable arraylist
			// dataList = FXCollections.observableArrayList(data);

			// really bad method
			// tableView(stage);
			// stage.show();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void executeQuery(String color, String cpu, Integer ram, String model, Integer storage, Double price) {
		List<String> conditions = new ArrayList<>();

		addCondition(conditions, "compcolor", color);
		addCondition(conditions, "cputype", cpu);
		addCondition(conditions, "compram", ram);
		addCondition(conditions, "compmodel", model);
		addCondition(conditions, "compstorage", storage);
		addCondition(conditions, "compprice", price);

		// Combine conditions into a WHERE clause
		String whereClause = buildWhereClause(conditions);

		// Construct the complete SQL query
		String sqlQuery = buildFullQuery(whereClause);

		// Execute the query and return the resultList
		executeSQLQuery(sqlQuery);
	}

	private static void addCondition(List<String> conditions, String column, Object value) {
		if (value != null) {
			conditions.add(column + " = " + getFormattedValue(value));
		}
	}

	private static String buildWhereClause(List<String> conditions) {
		return conditions.isEmpty() ? "" : " WHERE " + String.join(" AND ", conditions);
	}

	private static String buildFullQuery(String whereClause) {
		return "SELECT compcolor,cputype,compram,compmodel,compstorage,serialnum,compprice from Computer" + whereClause;
	}

	private static String getFormattedValue(Object value) {
		if (value instanceof String) {
			return "'" + value + "'";
		} else {
			return value.toString();
		}
	}

	private void executeSQLQuery(String sqlQuery) {
		try {

			connectDB();

			System.out.println(sqlQuery);

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				ComputerTable comp = new ComputerTable(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getDouble(7));
				buycomplist.add(comp);
				System.out.println("1");

			}
			con.close();
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public static void showAlertsuc(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	@SuppressWarnings("unchecked")

//	private void tableView(Stage stage) {
//
//		TableView<Product> myDataTable = new TableView<Product>();
//
//		Scene scene = new Scene(new Group());
//		stage.setTitle("Product Table");
//		stage.setWidth(550);
//		stage.setHeight(500);
//
//
//		myDataTable.setEditable(true);
//		myDataTable.setMaxHeight(200);
//		myDataTable.setMaxWidth(408);
//
//		// name of column for display
//		TableColumn<Product, Integer> pidCol = new TableColumn<Product, Integer>("pid");
//		pidCol.setMinWidth(50);
//
//		// to get the data from specific column
//		pidCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("pid"));
//
//		TableColumn<Product, String> pnameCol = new TableColumn<Product, String>("pname");
//		pnameCol.setMinWidth(100);
//		pnameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("pname"));
//
//		pnameCol.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
//		pnameCol.setOnEditCommit((CellEditEvent<Product, String> t) -> {
//		((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPname(t.getNewValue()); // display                                                                                   // only
//		updateName(t.getRowValue().getPid(), t.getNewValue());
//		});
//
//		TableColumn<Product, Integer> priceCol = new TableColumn<Product, Integer>("price");
//		priceCol.setMinWidth(50);
//		priceCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
//
//		priceCol.setCellFactory(TextFieldTableCell.<Product, Integer>forTableColumn(new IntegerStringConverter()));
//
//		priceCol.setOnEditCommit((CellEditEvent<Product, Integer> t) -> {
//			((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
//			updatePrice(t.getRowValue().getPid(), t.getNewValue());
//		});
//		TableColumn<Product, Integer> stockCol = new TableColumn<Product, Integer>("stockQuantity");
//		stockCol.setMinWidth(50);
//		stockCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stockQuantity"));
//		
//		stockCol.setCellFactory(TextFieldTableCell.<Product, Integer>forTableColumn(new IntegerStringConverter()));
//
//		stockCol.setOnEditCommit((CellEditEvent<Product, Integer> t) -> {
//			((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStockQuantity(t.getNewValue());
//			updateQuantity(t.getRowValue().getPid(), t.getNewValue());
//		});
//		TableColumn<Product, String> descriptionCol = new TableColumn<Product, String>("description");
//		descriptionCol.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
//
//		descriptionCol.setMinWidth(100);
//		descriptionCol.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
//
//		descriptionCol.setOnEditCommit((CellEditEvent<Product, String> t) -> {
//			((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(t.getNewValue());
//			updateDescription(t.getRowValue().getPid(), t.getNewValue());
//		});
//
//		myDataTable.setItems(dataList);
//
//		myDataTable.getColumns().addAll(pidCol, pnameCol, priceCol, stockCol, descriptionCol);
//
//		final TextField addPid = new TextField();
//		addPid.setPromptText("Pid");
//		addPid.setMaxWidth(pidCol.getPrefWidth());
//
//		final TextField addPname = new TextField();
//		addPname.setMaxWidth(pnameCol.getPrefWidth());
//		addPname.setPromptText("Pname");
//
//		final TextField addPrice = new TextField();
//		addPrice.setMaxWidth(priceCol.getPrefWidth());
//		addPrice.setPromptText("Price");
//
//		final TextField addStock = new TextField();
//		addStock.setMaxWidth(stockCol.getPrefWidth());
//		addStock.setPromptText("Stock Quantity");
//
//		final TextField addDescription = new TextField();
//		addDescription.setMaxWidth(descriptionCol.getPrefWidth());
//		addDescription.setPromptText("Description");
//
//		final Button addButton = new Button("Add");
//		addButton.setOnAction((ActionEvent e) -> {
//			Product rc;
//			rc = new Product(Integer.valueOf(addPid.getText()), addPname.getText(), Integer.valueOf(addPrice.getText()),
//					Integer.valueOf(addStock.getText()), addDescription.getText());
//			dataList.add(rc);
//			insertData(rc);
//			addPid.clear();
//			addPname.clear();
//			addPrice.clear();
//			addStock.clear();
//			addDescription.clear();
//		});
//
//		final HBox hb = new HBox();
//
//		final Button deleteButton = new Button("Delete");
//	deleteButton.setOnAction((ActionEvent e) -> {
//			ObservableList<Product> selectedRows = myDataTable.getSelectionModel().getSelectedItems();
//		ArrayList<Product> rows = new ArrayList<>(selectedRows);
//			rows.forEach(row -> {
//				myDataTable.getItems().remove(row);
//				deleteRow(row);
//				myDataTable.refresh();
//			});
//		});
//
//		hb.getChildren().addAll(addPid, addPname, addPrice, addStock, addDescription, addButton, deleteButton);
//		hb.setSpacing(3);
//
//		final Button refreshButton = new Button("Refresh");
//		refreshButton.setOnAction((ActionEvent e) -> {
//			myDataTable.refresh();
//		});
//
////		Button ownedNoneButton = new Button("Owned None");
////		ownedNoneButton.setOnAction(c -> );
//
//		final Button clearButton = new Button("Clear All");
//		clearButton.setOnAction((ActionEvent e) -> {
//			showDialog(stage, NONE, myDataTable);
//
//		});
//
//		final HBox hb2 = new HBox();
//		hb2.getChildren().addAll(clearButton, refreshButton);
//		hb2.setAlignment(Pos.CENTER_RIGHT);
//		hb2.setSpacing(3);
//
//		final VBox vbox = new VBox();
//		vbox.setSpacing(5);
//		vbox.setPadding(new Insets(10, 0, 0, 10));
//		vbox.setAlignment(Pos.CENTER);
//		vbox.getChildren().addAll(myDataTable, hb, hb2);
//		// vbox.getChildren().addAll(label, myDataTable);
//		((Group) scene.getRoot()).getChildren().addAll(vbox);
//		stage.setScene(scene);
//	}

	private void insertShop(Shop shop) {

		try {
			// System.out.println("The name : "+com.getModel());

			connectDB();
			ExecuteStatement("INSERT INTO Shop (shopname,shopphone,shopaddress) VALUES ('" + shop.getShopname() + "','"
					+ shop.getPhonenum() + "','" + shop.getAddress() + "')");
			con.close();
			// System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDatacomputer(Computer com) {

		try {
			System.out.println("The name : " + com.getModel());

			connectDB();
			ExecuteStatement(
					"INSERT INTO Computer (compcolor, cputype, compram, compmodel, compstorage, serialnum, isbuy, compprice,isrepair) VALUES ('"
							+ com.getColor() + "','" + com.getCpu() + "','" + com.getRam() + "','" + com.getModel()
							+ "', '" + com.getStorage() + "', '" + com.getSerialnum() + "', '" + com.getIsbuy() + "', '"
							+ com.getPrice() + "', '" + com.getIsrepair() + "')");
			con.close();
			// System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDatacustomer(Customer cus) {

		try {
			System.out.println("The name : " + cus.getName() + "The address: " + cus.getAddress() + "The cusid "
					+ cus.getCustid() + " The phone " + cus.getPhonenum() + " pass" + cus.getPassword());

			connectDB();
			ExecuteStatement("INSERT INTO Customer (custname, address, custid, custphone, custpassword) VALUES ('"
					+ cus.getName() + "','" + cus.getAddress() + "','" + cus.getCustid() + "','" + cus.getPhonenum()
					+ "', '" + cus.getPassword() + "')");
			con.close();
			// System.out.println("Connection closed" + data.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataBuys(Buys buy) {

		try {
			// System.out.println("The name : "+cus.getName()+"The address:
			// "+cus.getAddress()+"The cusid "+cus.getCustid()+" The phone
			// "+cus.getPhonenum()+" pass"+cus.getPassword());

			connectDB();
			ExecuteStatement("INSERT INTO buys(custid,sellid,serialnum) VALUES ('" + buy.getCustid() + "','"
					+ buy.getSellid() + "','" + buy.getSerialnum() + "')");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataSelleremp(SellerEmp emp) {

		try {
			// System.out.println("The name : "+cus.getName()+"The address:
			// "+cus.getAddress()+"The cusid "+cus.getCustid()+" The phone
			// "+cus.getPhonenum()+" pass"+cus.getPassword());

			connectDB();
			ExecuteStatement(
					"INSERT INTO SellEmp(sellid,empname,empage,empemail, empphone, empaddress, empgender,shopname) VALUES ('"
							+ emp.getSellid() + "','" + emp.getEmpname() + "','" + emp.getEmpage() + "','"
							+ emp.getEmpemail() + "','" + emp.getEmpphone() + "', '" + emp.getEmpaddress() + "', '"
							+ emp.getEmpgender() + "', '" + emp.getShopname() + "')");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataRepEmp(RepEmp emp) {
		try {
			// System.out.println("The name : "+cus.getName()+"The address:
			// "+cus.getAddress()+"The cusid "+cus.getCustid()+" The phone
			// "+cus.getPhonenum()+" pass"+cus.getPassword());

			connectDB();
			ExecuteStatement(
					"INSERT INTO RepEmp(repid,empname,empage,empemail, empphone, empaddress, empgender,shopname) VALUES ('"
							+ emp.getRepid() + "','" + emp.getEmpname() + "','" + emp.getEmpage() + "','"
							+ emp.getEmpemail() + "','" + emp.getEmpphone() + "', '" + emp.getEmpaddress() + "', '"
							+ emp.getEmpgender() + "', '" + emp.getShopname() + "')");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDataServices(Services ser) {
		try {
			// System.out.println("The name : "+cus.getName()+"The address:
			// "+cus.getAddress()+"The cusid "+cus.getCustid()+" The phone
			// "+cus.getPhonenum()+" pass"+cus.getPassword());

			connectDB();
			ExecuteStatement("INSERT INTO service(custid,repid,serialnum) VALUES ('" + ser.getCustid() + "','"
					+ ser.getRepid() + "','" + ser.getSerialnum() + "')");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void getDatacomputer() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select compcolor,cputype,compram,compmodel,compstorage,serialnum,isbuy,compprice,isrepair from Computer ORDER BY compprice";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			Computer comp = new Computer(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getInt(9));
			comphash.put(rs.getString(6), comp);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void getDatashop() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select shopname,shopphone,shopaddress from Shop";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			Shop shop = new Shop(rs.getString(1), rs.getString(2), rs.getString(3));
			shophash.put(rs.getString(1), shop);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void getDataBuys() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select custid,sellid,serialnum from buys";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			Buys buy = new Buys(rs.getString(1), rs.getString(2), rs.getString(3));
			buyhash.put(rs.getString(3), buy);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void getDataServices() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select custid,repid,serialnum from service";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			Services service = new Services(rs.getString(1), rs.getString(2), rs.getString(3));
			servicehash.put(rs.getString(3), service);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void getDataRepEmp() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select repid,empname,empage,empemail,empphone,empaddress,empgender,shopname from RepEmp";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			RepEmp rep = new RepEmp(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getNString(6), rs.getString(7), rs.getString(8));
			repemphash.put(rs.getString(1), rep);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void getDatacustomer() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select custname,address,custid,custphone,custpassword from Customer ORDER BY custid";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			Customer customer = new Customer(rs.getString(1), // custname
					rs.getString(2), // address
					rs.getString(3), // custid
					rs.getString(4), // custphone
					rs.getString(5) // custpassword
			);
			// custlist.add(customer);
			cushash.put(rs.getString(3), customer);
		}

		rs.close();
		stmt.close();

		con.close();
		System.out.println("Connection closed" + custlist.size());

	}

	private void getDatasellemp() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection customer");
		SQL = "select sellid,empname,empage,empemail,empphone,empaddress,empgender,shopname from SellEmp";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			SellerEmp sells = new SellerEmp(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4),
					rs.getString(5), rs.getNString(6), rs.getString(7), rs.getString(8));
			sellemphash.put(rs.getString(1), sells);
		}

		rs.close();
		stmt.close();

		con.close();
		// System.out.println("Connection closed" + custlist.size());

	}

	private void deletecomputer(Computer com) {
		// TODO Auto-generated method stub
		try {
			connectDB();
			ExecuteStatement("DELETE FROM Computer WHERE serialnum = '" + com.getSerialnum() + "';");
			con.close();
			System.out.println("Connection closed comp delete method");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteshop(Shop shop) {
		// TODO Auto-generated method stub

		try {
			// System.out.println("delete from Customer where custid=" + cust.getCustid() +
			// ";");
			connectDB();
			ExecuteStatement("DELETE FROM Shop WHERE shopname = '" + shop.getShopname() + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteSelleremp(SellerEmp sellemp) {
		// TODO Auto-generated method stub

		try {
			// System.out.println("delete from Customer where custid=" + cust.getCustid() +
			// ";");
			connectDB();
			ExecuteStatement("DELETE FROM SellEmp WHERE sellid = '" + sellemp.getSellid() + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteSelleremp(RepEmp repemp) {
		// TODO Auto-generated method stub

		try {
			// System.out.println("delete from Customer where custid=" + cust.getCustid() +
			// ";");
			connectDB();
			ExecuteStatement("DELETE FROM RepEmp WHERE repid = '" + repemp.getRepid() + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteservice(Services ser) {
		// TODO Auto-generated method stub

		try {
			// System.out.println("delete from Customer where custid=" + cust.getCustid() +
			// ";");
			connectDB();
			ExecuteStatement("DELETE FROM service WHERE serialnum = '" + ser.getSerialnum() + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteBuy(Buys b) {
		// TODO Auto-generated method stub

		try {
			// System.out.println("delete from Customer where custid=" + cust.getCustid() +
			// ";");
			connectDB();
			ExecuteStatement("DELETE FROM buys WHERE serialnum = '" + b.getSerialnum() + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deletecustomer(Customer cust) {
		// TODO Auto-generated method stub

		try {
			System.out.println("delete from  Customer where custid=" + cust.getCustid() + ";");
			connectDB();
			ExecuteStatement("delete from  Customer where custid=" + cust.getCustid() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, p);

	}

	public void ExecuteStatement(String SQL) throws SQLException {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	public void updateSellEmpage(String sellid, int empage) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empage = '" + empage + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepempage(String repid, int empage) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empage = '" + empage + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateSellEmpphone(String sellid, String phonenum) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empphone = '" + phonenum + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepphone(String repid, String phonenum) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empphone = '" + phonenum + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateSellEmpemail(String sellid, String email) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empemail = '" + email + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepEmail(String repid, String email) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empemail = '" + email + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateSellEmpaddress(String sellid, String address) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empaddress = '" + address + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepaddress(String repid, String address) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empaddress = '" + address + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateSellEmpgender(String sellid, String gender) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empgender = '" + gender + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepEmpgender(String repid, String gender) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empgender = '" + gender + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateSellEmpname(String sellid, String name) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE SellEmp SET empname = '" + name + "' WHERE sellid = '" + sellid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateRepEmpname(String repid, String name) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE RepEmp SET empname = '" + name + "' WHERE repid = '" + repid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateShopphone(String shopname, String shopphone) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Shop SET shopphone = '" + shopphone + "' WHERE shopname = '" + shopname + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateShopaddress(String shopname, String shopaddress) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement(
					"UPDATE Shop SET shopaddress = '" + shopaddress + "' WHERE shopname = '" + shopname + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputercolor(String serial, String color) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET compcolor = '" + color + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerCPU(String serial, String cputype) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET cputype = '" + cputype + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerRam(String serial, int compram) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET compram = '" + compram + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputermodel(String serial, String compmodel) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET compmodel = '" + compmodel + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerStorage(String serial, int compstorage) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement(
					"UPDATE Computer SET compstorage = '" + compstorage + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerIsBuy(String serial, int isbuy) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET isbuy = '" + isbuy + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerprice(String serial, double compprice) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET compprice = '" + compprice + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecomputerisrepair(String serial, int isrepair) {
		try {
			// System.out.println("update product set pname = '" + name + "' where pid = " +
			// custid);
			connectDB();
			ExecuteStatement("UPDATE Computer SET isrepair = '" + isrepair + "' WHERE serialnum = '" + serial + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecustname(String custid, String name) {
		try {
			System.out.println("update  product set pname = '" + name + "' where pid = " + custid);
			connectDB();
			ExecuteStatement("update  Customer set custname = '" + name + "' where custid = " + custid + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecustaddress(String custid, String address) {

		try {
			System.out.println("update  product set price = " + address + " where pid = " + custid);
			connectDB();
			ExecuteStatement("UPDATE Customer SET address = '" + address + "' WHERE custid = '" + custid + "';");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	public void updatecustid(String custid, String newcustid) {
//
//		try {
//			System.out.println("update  product set stock_quantity = '" + custid + "' where pid = " + newcustid);
//			connectDB();
//			ExecuteStatement("update  Customer set custid = '" + newcustid + "' where custid = " + custid + ";");
//			con.close();
//			System.out.println("Connection closed");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	public void updatecustphone(String custid, String phonenum) {

		try {
			System.out.println("update  product set `description` = '" + custid + "' where pid = " + phonenum);
			connectDB();
			ExecuteStatement("update  Customer set custphone = '" + phonenum + "' where custid = " + custid + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatecustpassword(String custid, String password) {

		try {
			// System.out.println("update product set `description` = '" + custid + "' where
			// pid = " + password);
			connectDB();
			ExecuteStatement("update  Customer set custpassword = '" + password + "' where custid = " + custid + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteRow(Product row) {
		// TODO Auto-generated method stub

		try {
			System.out.println("delete from  product where pid=" + row.getPid() + ";");
			connectDB();
			ExecuteStatement("delete from  product where pid=" + row.getPid() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private void showDialog(Window owner, Modality modality, TableView<Product> table) {
//		// Create a Stage with specified owner and modality
//		Stage stage = new Stage();
//		stage.initOwner(owner);
//		stage.initModality(modality);
//		// Label modalityLabel = new Label(modality.toString());
//
//		Button yesButton = new Button("Confirm");
//		yesButton.setOnAction(e -> {
//			for (Product row : dataList) {
//				deleteRow(row);
//				table.refresh();
//			}
//			table.getItems().removeAll(dataList);
//			stage.close();
//
//		});

//		Button noButton = new Button("Cancel");
//		noButton.setOnAction(e -> stage.close());
//
//		HBox root = new HBox();
//		root.setPadding(new Insets(10, 10, 10, 10));
//		root.setAlignment(Pos.CENTER);
//		root.setSpacing(10);
//
//		root.getChildren().addAll(yesButton, noButton);
//		Scene scene = new Scene(root, 200, 100);
//		stage.setScene(scene);
//		stage.setTitle("Confirm Delete?");
//		stage.show();
//	}

	public static boolean isOnlyDigits(String input) {
		return input.matches("\\d+");
	}

	public static boolean isOnlyCharacters(String input) {
		return input.matches("[a-zA-Z]+");
	}

	private static String getRandomKey(Map<String, SellerEmp> map) {
		if (map.isEmpty()) {
			return null; // Return null or throw an exception based on your requirements
		}
		List<String> keyList = List.copyOf(map.keySet());
		Random random = new Random();
		int randomIndex = random.nextInt(keyList.size());
		return keyList.get(randomIndex);
	}

	private static String getRandomrepKey(Map<String, RepEmp> map) {
		if (map.isEmpty()) {
			return null; // Return null or throw an exception based on your requirements
		}
		List<String> keyList = List.copyOf(map.keySet());
		Random random = new Random();
		int randomIndex = random.nextInt(keyList.size());
		return keyList.get(randomIndex);
	}

	private static Set<String> getUniquePropertyValues(Map<String, Computer> computerMap, String propertyName) {
		Set<String> uniqueValues = new HashSet<>();
		// Iterate through the values of the HashMap
		for (Computer computer : computerMap.values()) {
			switch (propertyName) {
			case "color":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(computer.getColor());
				}
				break;
			case "cpu":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(computer.getCpu());
				}
				break;
			case "ram":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(String.valueOf(computer.getRam()));
				}
				break;
			case "model":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(computer.getModel());
				}
				break;
			case "price":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(String.valueOf(String.valueOf(computer.getPrice())));
				}

				break;
			case "storage":
				if (computer.getIsbuy() == 0 && computer.getIsrepair() == 0) {
					uniqueValues.add(String.valueOf(String.valueOf(computer.getStorage())));
				}

				break;
			}
		}

		return uniqueValues;
	}

	private static int extractNumericValue(String inputString) {
		// Remove non-numeric characters using regular expression
		String numericString = inputString.replaceAll("[^\\d]", "");

		// Convert the result to an integer
		try {
			return Integer.parseInt(numericString);
		} catch (NumberFormatException e) {
			return -1; // Return -1 to indicate no valid numeric value
		}
	}

	public static boolean containsGmailOrHotmail(String email) {
		// Convert the email and target substrings to lowercase
		String lowercasedEmail = email.toLowerCase();
		String gmailSubstring = "@gmail";
		String hotmailSubstring = "@hotmail";

		// Check if the lowercased email contains either "@gmail" or "@hotmail"
		return lowercasedEmail.contains(gmailSubstring) || lowercasedEmail.contains(hotmailSubstring);
	}

	public static void main(String[] args) {

		Application.launch(args);
	}

}
