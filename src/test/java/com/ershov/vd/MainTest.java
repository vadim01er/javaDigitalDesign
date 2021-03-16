package com.ershov.vd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main() {
        System.out.println("Main test start!");
        String main = Main.main(new String[]{"2[3[x]y]"});
        Assertions.assertEquals(main, "xxxyxxxy");
        main = Main.main(new String[]{"3[xyz]4[xy]z"});
        Assertions.assertEquals(main, "xyzxyzxyzxyxyxyxyz");
        main = Main.main(new String[]{"3[x2[yz]]4[xy]z"});
        Assertions.assertEquals(main, "xyzyzxyzyzxyzyzxyxyxyxyz");
        System.out.println("Main test completed!");
    }

    @Test
    void checkValid() {
        System.out.println("checkValid() test start!");
        String main = Main.main(new String[]{"23[x]y]"});
        Assertions.assertEquals(main, "-1");
        main = Main.main(new String[]{"3[xyz4[xy]z"});
        Assertions.assertEquals(main, "-1");
        main = Main.main(new String[]{"3[x2[yz]4[xy]z"});
        Assertions.assertEquals(main, "-1");
        System.out.println("checkValid() test completed!");
    }
}