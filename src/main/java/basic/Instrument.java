package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lijinhao
 * @date: 2021/11/24 10:21
 * 重写父类方法
 */


public class Instrument {
    public void play(){
        System.out.println("Instument is playing……");
    }


}

class Wind extends Instrument{
    @Override
    public void play(){
        System.out.println("Wind is playing……");
    }
}
class Percussion extends Instrument{
    @Override
    public void play(){
        System.out.println("Percussion is playing……");
    }
}

class Music{
    public static void main(String[] args) {
        List<Instrument> instruments = new ArrayList<>();

        instruments.add(new Wind());
        instruments.add(new Percussion());
        for(Instrument instrument: instruments){
            instrument.play();
        }
    }
}
