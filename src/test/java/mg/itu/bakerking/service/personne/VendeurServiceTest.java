package mg.itu.bakerking.service.personne;

import mg.itu.bakerking.entity.personne.Role;
import mg.itu.bakerking.entity.personne.Vendeur;
import mg.itu.bakerking.repository.transaction.vente.VendeurRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VendeurServiceTest {

    @Mock
    private VendeurRepo vendeurRepo;

    @InjectMocks
    private VendeurService vendeurService;

    private Vendeur vendeur;

    @BeforeEach
    void setUp() {
        vendeur = new Vendeur();
        vendeur.setIdVendeur("VND001");
        vendeur.setNom("Test Vendeur");
        vendeur.setRole(Role.USER);
    }

    @Test
    void testUpdateRole() {
        // Given
        when(vendeurRepo.findById("VND001")).thenReturn(Optional.of(vendeur));
        when(vendeurRepo.save(any(Vendeur.class))).thenReturn(vendeur);

        // When
        vendeurService.updateRole("VND001", Role.ADMIN);

        // Then
        assertEquals(Role.ADMIN, vendeur.getRole());
        verify(vendeurRepo).save(vendeur);
    }

    @Test
    void testIsAdmin() {
        // Given
        vendeur.setRole(Role.ADMIN);
        when(vendeurRepo.findById("VND001")).thenReturn(Optional.of(vendeur));

        // When
        boolean isAdmin = vendeurService.isAdmin("VND001");

        // Then
        assertTrue(isAdmin);
    }

    @Test
    void testIsNotAdmin() {
        // Given
        vendeur.setRole(Role.USER);
        when(vendeurRepo.findById("VND001")).thenReturn(Optional.of(vendeur));

        // When
        boolean isAdmin = vendeurService.isAdmin("VND001");

        // Then
        assertFalse(isAdmin);
    }
}