package br.calebe.ticketmachine.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TrocoTest {
    @Rule
    public Timeout globalTimeout = Timeout.seconds(10);

    @Test
    public void testarTrocoComValorNegativo(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Troco tr = new Troco(-10);
                });
    }

    @Test
    public void testarTrocoComValor100RetornaValor100Quantidade1(){
        Troco tr = new Troco(100);

        Troco.TrocoIterator ti = (Troco.TrocoIterator) tr.getIterator();

        assertEquals("Troco deve ser 100", 100, ti.next().valor);
        assertEquals("Troco deve ser 1", 1, ti.next().quantidade);
    }

    @Test
    public void testarHasNextAoInserirValor10(){
        Troco tr = new Troco(100);

        Troco.TrocoIterator ti = (Troco.TrocoIterator) tr.getIterator();

        assertTrue("Tem proximo", ti.hasNext());
    }
}