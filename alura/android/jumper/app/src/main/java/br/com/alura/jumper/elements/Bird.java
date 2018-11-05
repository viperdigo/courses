package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.R;
import br.com.alura.jumper.engine.Sound;
import br.com.alura.jumper.graphics.Colors;
import br.com.alura.jumper.graphics.Screen;

public class Bird {

    public static final float X = 100;
    public static final int RADIUS = 50;
    private static final Paint RED = Colors.getColorBird();
    private final Screen screen;
    private Sound sound;
    private final Bitmap bird;
    private float height;

    public Bird(Screen screen, Context context, Sound sound) {
        this.screen = screen;
        this.sound = sound;
        this.height = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.bird = Bitmap.createScaledBitmap(bp, RADIUS * 2, RADIUS * 2, false);
    }

    public void drawIn(Canvas canvas) {
        canvas.drawBitmap(bird, X - RADIUS, height - RADIUS, null);
    }

    public void drop() {
        boolean goInTheGround = height + RADIUS > screen.getHeight();

        if (!goInTheGround) {
            this.height += 5;
        }
    }

    public void jump() {
        if (height - RADIUS > 0) {
            sound.playSound(Sound.soundJump);
            this.height -= 150;
        }
    }

    public float getHeight() {
        return this.height;
    }
}
