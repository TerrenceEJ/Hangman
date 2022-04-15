import org.junit.jupiter.api.*;

import java.util.ArrayList;
import static org.junit.Assert.*;

@SuppressWarnings("ALL")
class MainTest {

    @Test
    public void letter() {
        assertTrue("Character is a letter", Character.isLetter(Main.test("s")));
    }

    @Test
    public void array(){
        ArrayList<String> list = new ArrayList(1);
        list.add("getting");
        System.out.println(list);

        Main.change(list);

        System.out.println(Main.change(list));
    }
}
