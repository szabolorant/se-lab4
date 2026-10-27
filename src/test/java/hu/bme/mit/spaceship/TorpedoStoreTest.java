package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; //in case of exception testing

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    void setUp() {
        store = new TorpedoStore(1);
    }

    @Test
    void fire_Success() {
        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_Empty_ThrowsException() {
        // Arrange: kiürítjük a tárolót az első lövéssel
        store.fire(1);

        // Act & Assert: ellenőrizzük, hogy hibát dob-e, ha üresből próbálunk lőni
        // Megjegyzés: Ha a TorpedoStore kódja nem kivételt dob, hanem csak `false` értékkel tér vissza, 
        // akkor az assertThrows helyett írd ezt: assertEquals(false, store.fire(1))
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }

    @Test
    void fire_InvalidParameter_ThrowsException() {
        // Act & Assert: ellenőrizzük, mi történik, ha több torpedót kérünk a fire() metódustól, mint amennyi van
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }
}
