<?php

interface Aves
{
    public function andar();
}

interface AvesQueVoam extends Aves
{
    public function voar();
}

interface AvesQueNadam extends Aves
{
    public function nadar();
}

class Pato implements AvesQueVoam, AvesQueNadam
{
    public function voar()
    {
        //lógica
    }

    public function nadar()
    {
        //lógica
    }

    public function andar()
    {
        //lógica
    }
}

class Pinguim implements AvesQueNadam
{
    public function nadar()
    {
        //lógica
    }

    public function andar()
    {
        //lógica
    }
}

class Andorinha implements AvesQueVoam
{
    public function andar()
    {
        //lógica
    }

    public function voar()
    {
        //lógica
    }
}

class AmbienteAviario
{
    /**
     * Pinguim
     * Pato
     * Andorinha
     */
    public function __construct(Aves $ave)
    {
        $ave->andar();
    }
}

class AmbienteAgua
{
    /**
     * Pinguim
     * Pato
     */
    public function __construct(Aves $ave)
    {
        $ave->nada();
    }
}
