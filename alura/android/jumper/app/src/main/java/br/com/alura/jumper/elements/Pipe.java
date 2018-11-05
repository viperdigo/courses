package br.com.alura.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.jumper.R;
import br.com.alura.jumper.graphics.Colors;
import br.com.alura.jumper.graphics.Screen;

public class Pipe {

    private final Screen screen;
    private static final int LENGTH_PIPE = 250;
    private static final Paint GREEN = Colors.getColorPipe();
    private static final int WIDTH_PIPE = 100;
    private final int heightPipeBottom;
    private final Bitmap pipeBottom;
    private final Bitmap pipeTop;
    private int position;
    private int heightPipeTop;

    public Pipe(Screen screen, int position, Context context) {
        this.screen = screen;
        this.position = position;
        heightPipeBottom = screen.getHeight() - LENGTH_PIPE - randonValue();
        heightPipeTop = 0 + LENGTH_PIPE + randonValue();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        pipeBottom = Bitmap.createScaledBitmap(bp, WIDTH_PIPE, heightPipeBottom, false);
        pipeTop = Bitmap.createScaledBitmap(bp, WIDTH_PIPE, heightPipeTop, false);
    }

    private int randonValue() {
        return (int) (Math.random() * 150);
    }

    public void drawIn(Canvas canvas) {
        drawTopPipe(canvas);
        drawBottomPipe(canvas);
    }

    private void drawTopPipe(Canvas canvas) {
        canvas.drawBitmap(pipeTop, position, 0, null);
    }

    private void drawBottomPipe(Canvas canvas) {
        canvas.drawBitmap(pipeBottom, position, heightPipeBottom, null);
    }

    public void move() {
        this.position -= 5;
    }

    public boolean leftScreen() {
        return position + WIDTH_PIPE < 0;
    }

    public int getPosition() {
        return position;
    }

    public boolean hasColisionHorizontalWith(Bird bird) {
        return this.position < bird.X + bird.RADIUS;
    }

    public boolean hasColisionVerticalWith(Bird bird) {
        return bird.getHeight() - bird.RADIUS < this.heightPipeTop
                || bird.getHeight() + bird.RADIUS > this.heightPipeBottom;
    }
}
