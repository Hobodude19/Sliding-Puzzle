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
                    graphic.frame.setTitle("Sliding Puzzle. Fps: " +frames);
                    time = System.currentTimeMillis();
                    frames = 0;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
