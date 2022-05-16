import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DolloarCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }
    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();


        Caculator calculator = new Caculator(dollarCalculator);
        Assertions.assertEquals(22000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));

    }

    @Test
    public void MockTest(){
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();


        Caculator calculator = new Caculator(dollarCalculator);
        Assertions.assertEquals(60000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));

    }
}
