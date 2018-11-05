package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.alura.jumper.engine.Sound;
import br.com.alura.jumper.graphics.Screen;

public class Pipes {

    private static final int QTY_PIPES = 5;
    private final List<Pipe> pipes = new ArrayList<Pipe>();
    private static final int DISTANCE_BETWEEN_PIPES = 200;
    private final Screen screen;
    private Score score;
    private Context context;
    private Sound sound;

    public Pipes(Screen screen, Score score, Context context, Sound sound) {
        this.screen = screen;
        this.score = score;
        this.context = context;
        this.sound = sound;
        int position = 400;

        for (int i = 0; i < QTY_PIPES; i++) {
            position += DISTANCE_BETWEEN_PIPES;
            Pipe pipe = new Pipe(screen, position, context);
            pipes.add(pipe);
        }
    }

    public void drawIn(Canvas canvas) {
        for (Pipe pipe : pipes) {
            pipe.drawIn(canvas);
        }
    }

    public void move() {
        ListIterator<Pipe> iterator = pipes.listIterator();
        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();
            if (pipe.leftScreen()) {
                score.increase();
                iterator.remove();
                Pipe otherPipe = new Pipe(screen, getMax() + DISTANCE_BETWEEN_PIPES, context);
                iterator.add(otherPipe);
            }
        }
    }

    private int getMax() {
        int max = 0;
        for (Pipe pipe : pipes) {
            max = Math.max(pipe.getPosition(), max);
        }

        return max;
    }

    public boolean hasColisionWith(Bird bird) {
        for (Pipe pipe : pipes) {
            if (pipe.hasColisionHorizontalWith(bird)
                    && pipe.hasColisionVerticalWith(bird)) {
                sound.playSound(Sound.soundColision);
                return true;
            }
        }
        return false;
    }
}
