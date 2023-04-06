/**
 * 
 */
package com.aiglesiasp.junit.JavaModC4JUnit.dto;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author aitor Unit Test for Geometria Class
 */
public class GeometriaTest {

	private Geometria geo;

	@BeforeEach
	public void before() {
		geo = new Geometria();
	}

	@AfterEach
	public void after() {
		geo = new Geometria();

	}

	// TEST CONSTRUCTOR VACIO
	@Test
	public void testGettersSetters() {
		geo.setId(0);
		int id = geo.getId();
		geo.setNom("Rectangulo");
		String figura = geo.getNom();
		geo.setArea(22.55);
		double area = geo.getArea();
		assertEquals(id, 0);
		assertEquals(figura, "Rectangulo");
		assertEquals(area, 22.55, 0.00001);
	}

	//TEST AREAS
	@Test
	public void testAreaCuadrado() {
		int lado = 2;
		int resultado = geo.areacuadrado(lado);
		int esperado = 4;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaCirculo() {
		int radio = 2;
		double resultado = geo.areaCirculo(radio);
		double esperado = 12.5664;
		assertEquals(esperado, resultado, 0.001);
	}

	@Test
	public void testAreaTriangulo() {
		int altura = 10;
		int base = 4;
		int resultado = geo.areatriangulo(altura, base);
		int esperado = 20;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaRectangulo() {
		int altura = 4;
		int base = 10;
		int resultado = geo.arearectangulo(altura, base);
		int esperado = 40;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaPentagono() {
		int perimetro = 36;
		int distanceCentro = 5;
		int resultado = geo.areapentagono(perimetro, distanceCentro);
		int esperado = 90;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaRombo() {
		int diagonalMenor = 6;
		int diagonalmayor = 8;
		int resultado = geo.arearombo(diagonalmayor, diagonalMenor);
		int esperado = 24;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaRomboide() {
		int base = 6;
		int altura = 8;
		int resultado = geo.arearomboide(base, altura);
		int esperado = 48;
		assertEquals(esperado, resultado);
	}

	@Test
	public void testAreaTrapecio() {
		int baseMayor = 10;
		int baseMenor = 8;
		int altura = 4;
		int resultado = geo.areatrapecio(baseMayor, baseMenor, altura);
		int esperado = 36;
		assertEquals(esperado, resultado);
	}

	
	// COMPROBAR CONSTRUCTOR
	private static Stream<Arguments> getTypeGeo() {
		return Stream.of(Arguments.of(1, "cuadrado"), Arguments.of(2, "Circulo"), Arguments.of(3, "Triangulo"),
				Arguments.of(4, "Rectangulo"), Arguments.of(5, "Pentagono"), Arguments.of(6, "Rombo"),
				Arguments.of(7, "Romboide"), Arguments.of(8, "Trapecio"), Arguments.of(9, "Default"));
	}

	@ParameterizedTest
	@MethodSource("getTypeGeo")
	public void testCheckConstructor(int id, String esperado) {
		geo = new Geometria(id);
		String resultado = geo.getNom();
		int idRes = geo.getId();
		assertEquals(idRes, id);
		assertEquals(resultado, esperado);
	}

	//TEST TO STRING
	@Test
	public void testToString() {
		geo.setId(1);
		geo.setNom("Circulo");
		geo.setArea(22.5);
		String esperado = "Geometria [id=1, nom=Circulo, area=22.5]";
		assertEquals(geo.toString(), esperado);
	}

}
