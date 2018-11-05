package br.com.alura.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.alura.jumper.R;

public class Sound {

    private final SoundPool soundPool;
    public static int soundJump;
    public static int soundColision;
    public static int soundScore;

    public Sound(Context context) {
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        soundJump = soundPool.load(context, R.raw.pulo, 1);
        soundColision = soundPool.load(context, R.raw.colisao, 1);
        soundScore = soundPool.load(context, R.raw.pontos, 1);
    }

    public void playSound(int sound) {
        soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
