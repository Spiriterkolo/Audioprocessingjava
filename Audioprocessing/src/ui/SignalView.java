package ui;

import audio.effect.AudioSignal;
import javafx.scene.chart.*;
import javafx.scene.chart.Axis;
import javafx.animation.AnimationTimer;

public class SignalView extends LineChart<Number,Number> {

    public SignalView(Axis<Number> axisX, Axis<Number> axisY) {
        super(axisX, axisY);
        super.setTitle("Graphe de l'audio");
    }

    public void updateData(AudioSignal signal, SignalView view){
        new AnimationTimer(){
            @Override
            public void handle (long l){
                XYChart.Series data=new XYChart.Series();
                for (int i=0; i<signal.getFrameSize(); i++){
                    data.getData().add(new XYChart.Data(i, signal.getSample(i)));
                }
                view.getData().add(data);
            }
        };
    }
}