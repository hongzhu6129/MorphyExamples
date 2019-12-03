package morphy.examples;

import java.util.List;
import javax.swing.JFrame;
import morphy.annotations.TestCase;

public class VisualizeTrignometricalFunctions extends JFrame {
	public List<TestCase<Double, Trigonometrics>> testSet;
	public VisualizeTrignometricalFunctions(List<TestCase<Double, Trigonometrics>> tests) {
		testSet = tests;
		setSize(800,400);
		setTitle("Visualization of Test Results");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(new FigurePanelTrigonometrical(testSet));
		setVisible(true);
	}
}
