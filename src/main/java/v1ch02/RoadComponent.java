package v1ch02;

import javax.swing.*;
import java.awt.*;

/**
 * @author: lijinhao
 * @date: 2021/10/27 20:38
 */
public class RoadComponent extends JComponent{
    private final int XDOTDIST = 1;
    private Road freeway;

}

class Road{
    public static final int LENGTH = 400;
    public static final int MAXSPEED = 5;

    private  int[] speed;
    private Color[] colors;
    private int count;

    public Road(){
        speed = new int[LENGTH];
        colors = new Color[LENGTH];

        // 初始化为-1
        for(int i = 0;i < LENGTH; i++){
            speed[i] = -1;
        }
    }

//    public void update(double prob_slowdown, )


}
