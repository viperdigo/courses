package br.com.alura.jumper.graphics;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Colors {

    public static Paint getColorBird() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getColorPipe() {
        Paint green = new Paint();
        green.setColor(0xFF00FF00);
        return green;
    }

    public static Paint getColorScore() {
        Paint white = new Paint();
        white.setColor(0xFFFFFFFF);
        white.setTextSize(80);
        white.setTypeface(Typeface.DEFAULT_BOLD);
        white.setShadowLayer(3,5,5,0xFF000000);
        return white;
    }

    public static Paint getColorGameOver() {
        Paint red = new Paint();
        red.setColor(0xFFFF0000);
        red.setTextSize(50);
        red.setTypeface(Typeface.DEFAULT_BOLD);
        red.setShadowLayer(2, 3, 3, 0xFF000000);
        return red;
    }
}
