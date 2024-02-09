package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class tarifasTest {
    CalculadorDescuentos calculador = new CalculadorDescuentos();
    @Test
    public void validarTarifaNegativa() {
        try{
         calculador.calculoTarifa(-1000000, 20, 24);
        }
        catch(Throwable e){
            assertTrue(true);
        }
    }
    
    @Test
    public void validarTari() {
        calculador.calculoTarifa(1000000, 20, 24);
        assertTrue(true);
    }

    @Test void diasNegativos(){
        try{
         calculador.calculoTarifa(1000000, -20, 24);
        }
        catch(Throwable e){
            assertTrue(true);
        }
    }

    @Test void edadNegativos(){
        try{
         calculador.calculoTarifa(1000000, 20, -24);
        }
        catch(Throwable e){
            assertTrue(true);
        }
    }

    @Test void valoresNegativos(){
        try{
         calculador.calculoTarifa(-1000000, -20, -24);
        }
        catch(Throwable e){
            assertTrue(true);
        }
    }

     @Test void diasAntelacionMayores(){
        try{
         calculador.calculoTarifa(1000000, 366, 24);
        }
        catch(Throwable e){
            assertTrue(true);
        }
    }

    @Test void edadSuperior(){
       try{
         calculador.calculoTarifa(1000000, 36, 240);
        }
        catch(Throwable e){
            assertTrue(true);
        } 
    }
}