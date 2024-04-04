import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//public class addcardsure {
	public class addcardsure  {
		private GridPane g = new GridPane();
		private Label re;

		private Button ok, no;
		private HBox passhbox = new HBox(15);

		public addcardsure() {
			Image backgroundImage = new Image("reject.png");
			BackgroundSize backgroundSize = new BackgroundSize(500, 200, false, false, false, false);
			BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, backgroundSize);
			g.setBackground(new Background(background));

			re = new Label(" ARE YOU SURE TO BUY ?? ");
			re.setTextFill(Color.BLACK);
			re.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));

			// Set background using CSS
			re.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 5;");

			ok = new Button("yes");
			ok.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 15));
			ok.setStyle(

					"-fx-background-radius: 10em; " + "-fx-min-width: 100px; " + "-fx-min-height: 20px; "
							+ "-fx-max-width: 250px; " + "-fx-max-height: 150px; " + "-fx-background-color: black;");
			ok.setTextFill(Color.WHITE);

			no = new Button("No");
			no.setFont(Font.font("BankGothic LT BT", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 15));
			no.setStyle(

					"-fx-background-radius: 10em; " + "-fx-min-width: 100px; " + "-fx-min-height: 20px; "
							+ "-fx-max-width: 250px; " + "-fx-max-height: 150px; " + "-fx-background-color: black;");
			no.setTextFill(Color.WHITE);


			g.setHgap(10);
			g.setVgap(10);

			g.add(re, 1, 0);
			g.add(ok, 2, 2);
			g.add(no, 2, 3);


			g.setAlignment(Pos.CENTER);

		}

//		public static void main(String[] args) {
//			launch(args);
//		}
//
//		@Override
//		public void start(Stage primaryStage) {
//			// Create an instance of the rejectorder class
//			addcardsure rejectOrder = new addcardsure();
//
//			// Create a Scene with the GridPane from rejectorder
//			Scene scene = new Scene(rejectOrder.getG(), 500, 200);
//
//			// Set the scene and show the stage
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("buy Order");
//			primaryStage.show();
//		}

		public GridPane getG() {
			return g;
		}

		public void setG(GridPane g) {
			this.g = g;
		}

		public Button getOk() {
			return ok;
		}

		public void setOk(Button ok) {
			this.ok = ok;
		}

		public Button getMain() {
			return no;
		}

		public void setMain(Button no) {
			this.no = no;
		}

		public HBox getPasshbox() {
			return passhbox;
		}

		public void setPasshbox(HBox passhbox) {
			this.passhbox = passhbox;
		}

//	}
}
