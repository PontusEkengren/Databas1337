import java.io.IOException;

import Controller.Controller;
import Model.Dmm;
import View.View;

public class Main {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Main main = new Main();
		main.init();
	}

	private void init() throws IOException, ClassNotFoundException {

		Dmm theModel = new Dmm();
		View theView = new View();
		Controller theController = new Controller(theView, theModel);
		theView.setVisible(true);

	}
}