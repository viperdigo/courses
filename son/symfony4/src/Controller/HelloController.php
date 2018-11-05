<?php

namespace App\Controller;

use App\Entity\Produto;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;

/**
 * Class HelloController
 * @package App\Controller
 * @author Rodrigo Alfieri <viperdigo@gmail.com>
 */
class HelloController extends Controller
{
	/**
	 * @return Response
	 * @Route("hello-world")
	 */
	public function world()
	{
		return new Response(
			"<html><body><h1>Hello World!</h1></body></html>"
		);
	}

	/**
	 * @return Response
	 * @Route("mostrar-mensagem")
	 */
	public function mensagem()
	{
		return $this->render("hello/mensagem.html.twig");
	}

	/**
	 * @return Response
	 * @Route("cadastrar-produto")
	 */
	public function produto()
	{
		$entityManager = $this->getDoctrine()->getManager();

		$produto = new Produto();
		$produto->setNome("NoteBook")->setPreco(1800.00);

		$entityManager->persist($produto);
		$entityManager->flush();

		return new Response("O produto ". $produto->getId(). " foi criado.");
	}
}