import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MetroServiceTest {
    
    public MetroServiceTest() {
        DoublyLinkedList<Estacao> estacoes = new DoublyLinkedList();
        List<Bilhete> bilhetes = new ArrayList();
        MetroService metroService = new MetroService(estacoes, bilhetes);
        
        metroService.readEstacoesFromFile("./src/fx_estacoes.txt");
        metroService.readBilhetesFromFile("./src/fx_viagens.txt");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testReadEstacoesFromFile() {
        // Arrange
        DoublyLinkedList<Estacao> estacoes = new DoublyLinkedList();
        List<Bilhete> bilhetes = new ArrayList();
        MetroService expected = new MetroService(estacoes, bilhetes);
        expected.addEstacao(new Estacao(1, "Estação A", "C1"));
        expected.addEstacao(new Estacao(2, "Estação B", "C2"));
        expected.addEstacao(new Estacao(3, "Estação C", "C3"));

        // Act
        MetroService result = new MetroService(new DoublyLinkedList(), new ArrayList());
        result.readEstacoesFromFile("./test/fx_estacoes_test.txt");
        
        // Assert
        ListIterator<Estacao> expectedIt = expected.getEstacoes().listIterator();
        ListIterator<Estacao> resultIt = result.getEstacoes().listIterator();
        while (expectedIt.hasNext()) {
            assertEquals(expectedIt.next().getNumEstacao(), resultIt.next().getNumEstacao());
        }
    }
    
    @Test
    public void testReadBilhetesFromFile() {
        // Arrange
        DoublyLinkedList<Estacao> estacoes = new DoublyLinkedList();
        List<Bilhete> bilhetes = new ArrayList();
        MetroService expected = new MetroService(estacoes, bilhetes);
        bilhetes.add(new Bilhete(11111111, "Z1", new Estacao(1, "Estação A", "C1"), new Estacao(2, "Estação B", "C2")));
        bilhetes.add(new Bilhete(22222222, "Z2", new Estacao(1, "Estação A", "C1"), new Estacao(3, "Estação C", "C3")));
        bilhetes.add(new Bilhete(33333333, "Z3", new Estacao(1, "Estação A", "C1"), new Estacao(4, "Estação D", "C4")));
        
        // Act
        MetroService result = new MetroService(new DoublyLinkedList(), new ArrayList());
        result.readBilhetesFromFile("./test/fx_viagens_test.txt");
        
        // Assert
        for(int i = 0; i < expected.getBilhetes().size(); i++) {
            assertEquals(expected.getBilhetes().get(i).getNumBilhete(), result.getBilhetes().get(i).getNumBilhete());
        }
    }
    
    @Test
    public void testGetBilhetesEmTransgressao() {
        // Arrange
        DoublyLinkedList<Estacao> estacoes = new DoublyLinkedList();
        List<Bilhete> bilhetes = new ArrayList();
        MetroService metroService = new MetroService(estacoes, bilhetes);
        Estacao e1 = new Estacao(1, "Estação A", "C1");
        Estacao e2 = new Estacao(2, "Estação B", "C2");
        Estacao e3 = new Estacao(3, "Estação C", "C3");
        Estacao e4 = new Estacao(4, "Estação D", "C4");
        Bilhete b1 = new Bilhete(11111111, "Z1", e1, e3);
        Bilhete b2 = new Bilhete(22222222, "Z2", e1, e3);
        Bilhete b3 = new Bilhete(33333333, "Z3", e1, e3);
        Bilhete b4 = new Bilhete(44444444, "Z4", e1, e3);
        metroService.addEstacao(e1);
        metroService.addEstacao(e2);
        metroService.addEstacao(e3);
        metroService.addEstacao(e4);
        bilhetes.add(b1);
        bilhetes.add(b2);
        bilhetes.add(b3);
        bilhetes.add(b4);
        List<Bilhete> expected = new ArrayList();
        expected.add(b1);
        expected.add(b2);
        
        // Act
        List<Bilhete> result = metroService.getBilhetesEmTransgressao();
        
        // Assert
        for(int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getNumBilhete(), result.get(i).getNumBilhete());
        }
    }
    
    @Test
    public void testGetNumeroUtilizadoresQuePassouPorCadaEstacao() {
        // Arrange
        DoublyLinkedList<Estacao> estacoes = new DoublyLinkedList();
        List<Bilhete> bilhetes = new ArrayList();
        MetroService metroService = new MetroService(estacoes, bilhetes);
        Estacao e1 = new Estacao(1, "Estação A", "C1");
        Estacao e2 = new Estacao(2, "Estação B", "C2");
        Estacao e3 = new Estacao(3, "Estação C", "C3");
        Estacao e4 = new Estacao(4, "Estação D", "C4");
        Bilhete b1 = new Bilhete(11111111, "Z1", e1, e3);
        Bilhete b2 = new Bilhete(22222222, "Z2", e1, e3);
        Bilhete b3 = new Bilhete(33333333, "Z3", e1, e3);
        Bilhete b4 = new Bilhete(44444444, "Z4", e1, e3);
        metroService.addEstacao(e1);
        metroService.addEstacao(e2);
        metroService.addEstacao(e3);
        metroService.addEstacao(e4);
        bilhetes.add(b1);
        bilhetes.add(b2);
        bilhetes.add(b3);
        bilhetes.add(b4);
        Map<Estacao, Integer> expected = new HashMap<>();
        expected.put(e1, 4);
        expected.put(e2, 4);
        expected.put(e3, 4);

        // Act
        Map<Estacao, Integer> result = metroService.getNumeroUtilizadoresQuePassouPorCadaEstacao();
        
        // Assert
        for(int i = 0; i < 3; i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

}
