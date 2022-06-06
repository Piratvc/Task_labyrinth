import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSolution {
    @Test
    public void testExample() {
        Assertions.assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
    }

    @Test
    public void testExample2() {
        Assertions.assertEquals(6, Solution.getResult("PPPPPPPPPPPPPPPP", "Human"));
    }
}
