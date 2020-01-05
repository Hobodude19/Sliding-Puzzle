package Logic;

import Graphics.Error;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {
    private Clip c;
    private FloatControl fc;
    private Error r = new Error();

    public Music() {
        try {
            c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(getClass().getResource("music.wav")));
            c.loop(Clip.LOOP_CONTINUOUSLY);
            fc = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            fc.setValue(0.5f);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startMusic() {
        if(c.isRunning()) {
            r.editText("Music already playing!");
            r.showError();
        }
        else {
            c.start();
        }
    }

    public void stopMusic(){
        c.stop();
        c.setFramePosition(0);
    }
}
