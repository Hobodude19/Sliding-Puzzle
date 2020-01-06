package Logic;

import Graphics.Window;

public class Main {
    public static void main(String[] args) {
        Window graphic = new Window();
        int frames = 0;
        long time = 0;
        for(;;) {
            try {
                frames++;
                if(System.currentTimeMillis() > time + 1000) {
                    time = System.currentTimeMillis();
                    frames = 0;
                    graphic.updateTiles();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
