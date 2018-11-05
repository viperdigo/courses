package br.com.alura.jumper.engine;

import br.com.alura.jumper.elements.Bird;
import br.com.alura.jumper.elements.Pipes;

class checkerColision {

    private final Bird bird;
    private final Pipes pipes;

    public checkerColision(Bird bird, Pipes pipes) {

        this.bird = bird;
        this.pipes = pipes;
    }


    public boolean hasColision() {
        return pipes.hasColisionWith(bird);
    }
}
