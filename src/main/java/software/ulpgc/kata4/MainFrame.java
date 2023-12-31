package software.ulpgc.kata4;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HistogramDisplay histogramDisplay;

    public MainFrame() throws HeadlessException{
        setTitle("Histogram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        add(createHistogramDisplay());
    }

    public HistogramDisplay histogramDisplay() {
        return histogramDisplay;
    }

    private Component createHistogramDisplay() {
        PanelHistogramDisplay display = new PanelHistogramDisplay();
        histogramDisplay = display;
        return display;
    }
}
