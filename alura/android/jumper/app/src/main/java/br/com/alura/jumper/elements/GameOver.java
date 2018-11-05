package br.com.alura.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.alura.jumper.graphics.Colors;
import br.com.alura.jumper.graphics.Screen;

public class GameOver {

    private final Screen screen;
    private static final Paint RED = Colors.getColorGameOver();

    public GameOver(Screen screen) {

        this.screen = screen;
    }

    public void drawIn(Canvas canvas) {
        String text = "Game Over";
        int centerHorizontal = centerText(text);
        canvas.drawText(text, centerHorizontal, screen.getHeight() / 2, RED);
    }

    public int centerText(String text) {
        Rect limitText = new Rect();
        RED.getTextBounds(text, 0, text.length(), limitText);
        int centerHorizontal = screen.getHeight()/2 - (limitText.right - limitText.left)/2;
        return centerHorizontal;
    }


}
