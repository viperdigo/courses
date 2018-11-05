<?php

namespace Solid\Html\Tag;

use Solid\Html\Attributes;

class ATests extends \PHPUnit_Framework_TestCase
{
    public function testCriarTagAcomHrefEAncora()
    {
        $a = new A(new Attributes, 'http://www.example.com.br', 'meu site');

        $this->assertEquals('<a href="http://www.example.com.br">meu site</a>', $a);
    }

    public function testCriarTagAcomHrefEAncoraEAtributosHtmlAdicionais()
    {
        $attribute = [
            'class'=>'btn btn-default',
            'data-modal'=>'#login',
            'id'=>'login'
        ];

        $a = new A(new Attributes, '#', 'login');
        $a->attributes($attribute);

        $this->assertEquals('<a href="#" class="btn btn-default" data-modal="#login" id="login">login</a>', $a);
    }
}
