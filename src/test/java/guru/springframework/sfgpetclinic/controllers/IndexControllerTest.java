package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.assertj.core.api.Assertions.assertThat;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong message Returned");
        assertEquals("index", controller.index(), ()-> "Another expensive message");

        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, ()->{
            controller.oupsHandler();
        });
//        assertTrue("notimplemented".equals(controller.oupsHandler()), () -> "This is some expensive "+
//                "Message to build for my test");
    }

    @Disabled("Demo of time out")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100),() ->{
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of time out")
    @Test
    void testTimeOutPrempt() {
        assertTimeout(Duration.ofMillis(100),() ->{
            Thread.sleep(5000);

            System.out.println("I got here 234563");
        });
    }

    /*This teste verify the enviroment*/
    @Test
    void testeAssumptionTrue() {

        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testeAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named ="USERNAME", matches="SYSTEM")
    @Test
    void testeIfUserSystem() {
    }

    @EnabledIfEnvironmentVariable(named ="USERNAME", matches="fred")
    @Test
    void testeIfUserFred() {
    }
}