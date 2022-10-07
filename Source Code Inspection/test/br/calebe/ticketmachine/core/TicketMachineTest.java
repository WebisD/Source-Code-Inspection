package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketMachineTest {

    @Test
    public void testarMaquinaVaziaRetornaSaldoZero(){
        TicketMachine tm = new TicketMachine(10);
        assertEquals("Saldo deve ser 0", 0, tm.getSaldo());
    }

    @Test
    public void testarMaquinaVaziaComValorNegativo(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    TicketMachine tm = new TicketMachine(-10);
                });
    }

    @Test
    public void testarInserir10ComSaldoZeroRetorna10() throws PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(0);
        tm.inserir(10);
        assertEquals("Saldo deve ser 10", 10, tm.getSaldo());
    }

    @Test
    public void testarInserir11RetornaException(){
        TicketMachine tm = new TicketMachine(0);

        assertThrows(PapelMoedaInvalidaException.class,
                () -> {
                    tm.inserir(11);
                });
    }

    @Test
    public void testarInserir2E10RetornaSaldoIgual12() throws PapelMoedaInvalidaException{
        TicketMachine tm = new TicketMachine(0);
        tm.inserir(2);
        tm.inserir(10);
        assertEquals("2+10 deve ser 12", 12, tm.getSaldo());
    }

    @Test
    public void testarImprimirSaldoAposInstanciarClasse() throws SaldoInsuficienteException {
        TicketMachine tm = new TicketMachine(0);
        String expected_result = "*****************\n*** R$ 0,00 ****\n*****************\n";
        assertEquals("Saldo deve ser 0", expected_result, tm.imprimir());
    }

    @Test
    public void testarImprimirSaldoAposInserir10() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine tm = new TicketMachine(0);
        tm.inserir(10);
        String expected_result = "*****************\n*** R$ 10,00 ****\n*****************\n";
        assertEquals("Saldo deve ser 0", expected_result, tm.imprimir());
    }
}