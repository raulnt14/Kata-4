package software.ulpgc.kata4;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;

public class PanelHistogramDisplay extends JPanel implements HistogramDisplay {

    @Override
    public void show(Histogram histogram) {
        add(new ChartPanel(chartOf(histogram)));
    }

    private JFreeChart chartOf(Histogram histogram) {
        return ChartFactory.createHistogram(
                histogram.title(), histogram.xAxis(), histogram.yAxis(),
                dataset(histogram.data(), histogram.bins())
        );
    }

    private IntervalXYDataset dataset(double[] data, int bins) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("x", data, bins);
        return dataset;
    }
}
