package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void varastoTesti1() {
        Varasto uusiVarasto = new Varasto(5,1);
        assertEquals(5, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastoTesti2() {
        Varasto uusiVarasto = new Varasto(0,1);
        assertEquals(0, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastoTesti3() {
        Varasto uusiVarasto = new Varasto(-1,-1);
        assertEquals(0, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastoTesti4() {
        Varasto uusiVarasto = new Varasto(-5);
        assertEquals(0, uusiVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaaTesti1() {
        varasto.lisaaVarastoon(-1);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaaTesti2() {
        varasto.lisaaVarastoon(1000);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void otaTesti1() {
        varasto.otaVarastosta(-1);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void otaTesti2() {
        varasto.otaVarastosta(1000);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void tekstiTesti() {
        assertEquals("saldo = "+ varasto.getSaldo() +", vielä tilaa " + varasto.paljonkoMahtuu(), varasto.toString());
    }
}