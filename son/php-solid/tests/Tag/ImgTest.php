<?php

namespace Solid\Html\Tag;

use Solid\Html\Attributes;

class ImgTests extends \PHPUnit_Framework_TestCase
{
    public function testCriarTagImgComSrc()
    {
        $img = new Img(new Attributes, 'img/photo.png');

        $this->assertEquals('<img src="img/photo.png">', $img);
    }

    public function testCriarTagImgComSrcEAtributosHtmlAdicionais()
    {
        $attributes = [
            'class'=>'image-responsive'
        ];

        $img = new Img(new Attributes, 'img/photo.png');
        $img->attributes($attributes);

        $this->assertEquals('<img src="img/photo.png">', $img);
    }
}
