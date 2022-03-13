package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;

class OwnerTest {
    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("123456");

        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        ()-> assertEquals("Joe", owner.getFirstName(), "First name Did not Match"),
                        ()-> assertEquals("Buck", owner.getLastName())),
                ()-> assertAll("Owner Properties",
                        ()-> assertEquals("Key West", owner.getCity(), "City Did not Match"),
                        ()-> assertEquals("123456", owner.getTelephone()))
        );

        assertThat(owner.getCity(), is("Key West"));
    }
}