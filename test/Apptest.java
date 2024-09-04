import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.util.*;

public class AppTest {

    private double calcularMediana(List<Integer> numeros) {
        Collections.sort(numeros);
        int n = numeros.size();
        if (n % 2 == 0) {
            return (numeros.get(n / 2 - 1) + numeros.get(n / 2)) / 2.0;
        } else {
            return numeros.get(n / 2);
        }
    }

    private int encontrarNumeroMasFrecuente(List<Integer> numeros) {
        Map<Integer, Integer> frecuencia = new HashMap<>();
        for (int num : numeros) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }
        int maxFrecuencia = Collections.max(frecuencia.values());
        return numeros.stream().filter(num -> frecuencia.get(num) == maxFrecuencia).findFirst().orElse(-1);
    }

    private int[] encontrarNumeroMayorYPosicion(List<Integer> numerosOriginal) {
        int maxNumero = Collections.max(numerosOriginal);
        int posicion = numerosOriginal.indexOf(maxNumero) + 1;
        return new int[]{maxNumero, posicion};
    }

    @Test
    public void testCasoMinimo100Numeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numeros.add(i);
        }

        double mediana = calcularMediana(new ArrayList<>(numeros));
        assertEquals("La mediana para los primeros 100 números debe ser 50.5", 50.5, mediana, 0.001);

        int numeroMasFrecuente = encontrarNumeroMasFrecuente(numeros);
        assertTrue("El número más frecuente debería estar en la lista", numeros.contains(numeroMasFrecuente));

        int[] resultadoMayor = encontrarNumeroMayorYPosicion(numeros);
        assertEquals("El número mayor debería ser 100", 100, resultadoMayor[0]);
        assertEquals("La posición del número mayor debería ser 100", 100, resultadoMayor[1]);
    }

    @Test
    public void testCasoIntermedio500Numeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            numeros.add(i);
        }

        double mediana = calcularMediana(new ArrayList<>(numeros));
        assertEquals("La mediana para los primeros 500 números debe ser 250.5", 250.5, mediana, 0.001);

        int numeroMasFrecuente = encontrarNumeroMasFrecuente(numeros);
        assertTrue("El número más frecuente debería estar en la lista", numeros.contains(numeroMasFrecuente));

        int[] resultadoMayor = encontrarNumeroMayorYPosicion(numeros);
        assertEquals("El número mayor debería ser 500", 500, resultadoMayor[0]);
        assertEquals("La posición del número mayor debería ser 500", 500, resultadoMayor[1]);
    }

    @Test
    public void testCasoMaximo1000Numeros() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numeros.add(i);
        }

        double mediana = calcularMediana(new ArrayList<>(numeros));
        assertEquals("La mediana para los primeros 1000 números debe ser 500.5", 500.5, mediana, 0.001);

        int numeroMasFrecuente = encontrarNumeroMasFrecuente(numeros);
        assertTrue("El número más frecuente debería estar en la lista", numeros.contains(numeroMasFrecuente));

        int[] resultadoMayor = encontrarNumeroMayorYPosicion(numeros);
        assertEquals("El número mayor debería ser 1000", 1000, resultadoMayor[0]);
        assertEquals("La posición del número mayor debería ser 1000", 1000, resultadoMayor[1]);
    }
}
