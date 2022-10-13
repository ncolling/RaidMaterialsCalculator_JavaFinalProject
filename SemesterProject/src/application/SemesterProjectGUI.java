/**
 * Raid Materials Generator
 * Nicholas Colling
 * A class for the GUI application of the Raid Materials Generator using JavaFX.
 * Requires MainMethods, CharacterClass, Dps, Heals, and Tank classes for functionality.
 */

package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SemesterProjectGUI extends Application
{
	//Textfield generations, static fields are used within MainMethods class
	private TextField tfRaidSize = new TextField();
	private TextField tfRaidNights = new TextField();
	private TextField tfBossPulls = new TextField();
	private TextField tfHealers = new TextField();
	private TextField tfCasterDps = new TextField();
	private TextField tfRangedDps = new TextField();
	private TextField tfMeleeAgiDps = new TextField();
	private TextField tf1HStrDps = new TextField();
	private TextField tf2HStrDps = new TextField();
	private TextField tfStrTank = new TextField();
	private TextField tfAgiTank = new TextField();
	protected static TextField tfDeathBlossom = new TextField();
	protected static TextField tfMarrowroot = new TextField();
	protected static TextField tfWidowbloom = new TextField();
	protected static TextField tfRisingGlory = new TextField();
	protected static TextField tfVigilsTorch = new TextField();
	protected static TextField tfNightshade = new TextField();
	protected static TextField tfShadestone = new TextField();
	protected static TextField tfShadedStone = new TextField();
	protected static TextField tfEmptyKettle = new TextField();
	protected static TextField tfSpringWater = new TextField();
	protected static TextField tfProtoFlesh = new TextField();
	protected static TextField tfLightlessSilk = new TextField();
	
	
	@Override
	public void start(Stage primaryStage)
	{
		//Sets the label text of the GUI
		Label title = new Label();
			title.setText("Welcome to the Raid Materials Generator.\n"+
				"Fill out the following forms and select Generate Mats.");
		
		//GridPane is used to set the formatted placements of all the textfields
		GridPane mainPane = new GridPane();
		mainPane.setHgap(5);
		mainPane.setVgap(5);
		mainPane.add(new Label("Enter the Raid Size:"), 0, 0);
		mainPane.add(tfRaidSize, 1, 0);
		mainPane.add(new Label("Enter number of Raid Nights:"), 0, 1);
		mainPane.add(tfRaidNights, 1, 1);
		mainPane.add(new Label("Enter number of Boss Pulls:"), 0, 2);
		mainPane.add(tfBossPulls, 1, 2);
		mainPane.add(new Label("Enter number of Healers:"), 0, 3);
		mainPane.add(tfHealers, 1, 3);
		mainPane.add(new Label("Enter number of Caster DPS:"), 0, 4);
		mainPane.add(tfCasterDps, 1, 4);
		mainPane.add(new Label("Enter number of Ranged DPS:"), 0, 5);
		mainPane.add(tfRangedDps, 1, 5);
		mainPane.add(new Label("Enter number of Melee Agi DPS:"), 0, 6);
		mainPane.add(tfMeleeAgiDps, 1, 6);
		mainPane.add(new Label("Enter number of 1H Str DPS:"), 0, 7);
		mainPane.add(tf1HStrDps, 1, 7);
		mainPane.add(new Label("Enter number of 2H Str DPS:"), 0, 8);
		mainPane.add(tf2HStrDps, 1, 8);
		mainPane.add(new Label("Enter number of Str Tanks:"), 0, 9);
		mainPane.add(tfStrTank, 1, 9);
		mainPane.add(new Label("Enter number of Agi Tanks:"), 0, 10);
		mainPane.add(tfAgiTank, 1, 10);
		
		//Variable declaration and initialization of starting condition
		final String DEFAULT = "0";
		tfRaidSize.setText(DEFAULT);
		tfRaidNights.setText(DEFAULT);
		tfBossPulls.setText(DEFAULT);
		tfHealers.setText(DEFAULT);
		tfCasterDps.setText(DEFAULT);
		tfRangedDps.setText(DEFAULT);
		tfMeleeAgiDps.setText(DEFAULT);
		tf1HStrDps.setText(DEFAULT);
		tf2HStrDps.setText(DEFAULT);
		tfStrTank.setText(DEFAULT);
		tfAgiTank.setText(DEFAULT);
		
		//Assigns the placement of the return textfields and whether editable
		mainPane.add(new Label("Deathblossom:"), 2, 0);
		mainPane.add(tfDeathBlossom, 3, 0);
		tfDeathBlossom.setEditable(false);
		mainPane.add(new Label("Marrowroot:"), 2, 1);
		mainPane.add(tfMarrowroot, 3, 1);
		tfMarrowroot.setEditable(false);
		mainPane.add(new Label("Widowbloom:"), 2, 2);
		mainPane.add(tfWidowbloom, 3, 2);
		tfWidowbloom.setEditable(false);
		mainPane.add(new Label("Rising Glory:"), 2, 3);
		mainPane.add(tfRisingGlory, 3, 3);
		tfRisingGlory.setEditable(false);
		mainPane.add(new Label("Vigils Torch:"), 2, 4);
		mainPane.add(tfVigilsTorch, 3, 4);
		tfVigilsTorch.setEditable(false);
		mainPane.add(new Label("Nightshade:"), 2, 5);
		mainPane.add(tfNightshade, 3, 5);
		tfNightshade.setEditable(false);
		mainPane.add(new Label("Shadestone:"), 2, 6);
		mainPane.add(tfShadestone, 3, 6);
		tfShadestone.setEditable(false);
		mainPane.add(new Label("Shaded Stone:"), 2, 7);
		mainPane.add(tfShadedStone, 3, 7);
		tfShadedStone.setEditable(false);
		mainPane.add(new Label("Empty Kettle:"), 2, 8);
		mainPane.add(tfEmptyKettle, 3, 8);
		tfEmptyKettle.setEditable(false);
		mainPane.add(new Label("Spring Water:"), 2, 9);
		mainPane.add(tfSpringWater, 3, 9);
		tfSpringWater.setEditable(false);
		mainPane.add(new Label("Protoflesh:"), 2, 10);
		mainPane.add(tfProtoFlesh, 3, 10);
		tfProtoFlesh.setEditable(false);
		mainPane.add(new Label("Lightless Silk:"), 2, 11);
		mainPane.add(tfLightlessSilk, 3, 11);
		tfLightlessSilk.setEditable(false);
		
		
		//Creates the buttons for calling MainMethods and Reset
		Button btGenerateMats = new Button("Generate Mats");
		Button btReset = new Button("Reset");
		
		
		mainPane.add(btGenerateMats, 1, 13);
		mainPane.add(btReset, 2, 13);
		
		//Creates border pane for formatting node positioning
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10,20,10,20));
		pane.setTop(title);
		pane.setCenter(mainPane);
		

		//Creates on click action for buttons
		btGenerateMats.setOnAction(e -> start());
		btReset.setOnAction(e -> reset());

		//Creates the Scene and places stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Raid Materials Generator"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
		
	}
	
	
	private void start()
	{
		//Variable Array declaration for holding inputs from user
		Integer[] userInput = new Integer[11];
		
		try 
		{
			
			userInput[0] = Integer.parseInt(tfRaidSize.getText());
			userInput[1] = Integer.parseInt(tfRaidNights.getText());
			userInput[2] = Integer.parseInt(tfBossPulls.getText());
			userInput[3] = Integer.parseInt(tfHealers.getText());
			userInput[4] = Integer.parseInt(tfCasterDps.getText());
			userInput[5] = Integer.parseInt(tfRangedDps.getText());
			userInput[6] = Integer.parseInt(tfMeleeAgiDps.getText());
			userInput[7] = Integer.parseInt(tf1HStrDps.getText());
			userInput[8] = Integer.parseInt(tf2HStrDps.getText());
			userInput[9] = Integer.parseInt(tfStrTank.getText());
			userInput[10] = Integer.parseInt(tfAgiTank.getText());
			
			//Calls MainMethods class to run the necessary computations
			MainMethods.MainMethod(userInput);
		}
		
		//Catches parseInt errors and triggers sendAlert method
		catch (NumberFormatException ex)
		{
			sendAlert();
		}
	}
	
	//Method for sending error alert to user for invalid inputs
	public void sendAlert()
	{
	 
		Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Error!");
	    alert.setHeaderText("An error occurred.");
	    String s = "Please enter only integer numbers.";
	    alert.setContentText(s);
	    alert.show();
	}
	
	//Method for resetting the GUI to default parameters
	public void reset()
	{
		//variable declaration and initialization
		final String RESET = "0";
		final String RESET2 = " ";
		
		//Field entry modifications
		//input
		tfRaidSize.setText(RESET);
		tfRaidNights.setText(RESET);
		tfBossPulls.setText(RESET);
		tfHealers.setText(RESET);
		tfCasterDps.setText(RESET);
		tfRangedDps.setText(RESET);
		tfMeleeAgiDps.setText(RESET);
		tf1HStrDps.setText(RESET);
		tf2HStrDps.setText(RESET);
		tfStrTank.setText(RESET);
		tfAgiTank.setText(RESET);
		
		//output
		tfDeathBlossom.setText(RESET2);
		tfMarrowroot.setText(RESET2);
		tfWidowbloom.setText(RESET2);
		tfRisingGlory.setText(RESET2);
		tfVigilsTorch.setText(RESET2);
		tfNightshade.setText(RESET2);
		tfShadestone.setText(RESET2);
		tfShadedStone.setText(RESET2);
		tfEmptyKettle.setText(RESET2);
		tfSpringWater.setText(RESET2);
		tfProtoFlesh.setText(RESET2);
		tfLightlessSilk.setText(RESET2);
	}
	
	//main method to launch primary stage
	public static void main(String[] args)
	{
		launch(args);
	}
}
