package br.com.alura.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.alura.jumper.R;
import br.com.alura.jumper.elements.Bird;
import br.com.alura.jumper.elements.GameOver;
import br.com.alura.jumper.elements.Pipes;
import br.com.alura.jumper.elements.Score;
import br.com.alura.jumper.graphics.Screen;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Context context;
    private final Sound sound;
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private Screen screen;
    private Bitmap background;
    private Pipes pipes;
    private Score score;

    public Game(Context context) {
        super(context);
        this.context = context;
        screen = new Screen(context);
        sound = new Sound(context);
        initializeElements();
        setOnTouchListener(this);
    }

    private void initializeElements() {
        bird = new Bird(screen, context, sound);
        score = new Score(sound);
        pipes = new Pipes(screen, score, context, sound);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), screen.getHeight(), false);
    }

    @Override
    public void run() {
        while (isRunning) {
            if(!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0,0,null);
            bird.drawIn(canvas);
            bird.drop();

            pipes.drawIn(canvas);
            score.drawIn(canvas);

            pipes.move();

            if(new checkerColision(bird, pipes).hasColision()) {
                new GameOver(screen).drawIn(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        bird.jump();
        return false;
    }
}
