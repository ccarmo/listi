package com.dev.listi.domain.vo;

import com.dev.listi.exceptions.AddressNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AddressTest {

    @Test
    public void testValidAddress() {
        // Arrange
        String street = "Main St";
        String country = "USA";
        String streetNumber = "123";

        // Act
        Address address = new Address(street, country, streetNumber);

        // Assert
        assertNotNull(address);
        assertEquals(street, address.getStreet());
        assertEquals(country, address.getCountry());
        assertEquals(streetNumber, address.getStreetNumber());
    }

    @Test
    public void testInvalidStreetNumber() {
        // Arrange
        String street = "MainSt";
        String country = "USA";
        String streetNumber = "abc";

        // Act & Assert
        assertThrows(AddressNotValidException.class, () -> new Address(street, country, streetNumber));
    }

    @Test
    public void testInvalidStreet() {
        // Arrange
        String street = "123"; // Invalid street containing numbers
        String country = "USA";
        String streetNumber = "123";

        // Act & Assert
        assertThrows(AddressNotValidException.class, () -> new Address(street, country, streetNumber));
    }

    @Test
    public void testInvalidCountry() {
        // Arrange
        String street = "Main St";
        String country = "123"; // Invalid country containing numbers
        String streetNumber = "123";

        // Act & Assert
        assertThrows(AddressNotValidException.class, () -> new Address(street, country, streetNumber));
    }
}
