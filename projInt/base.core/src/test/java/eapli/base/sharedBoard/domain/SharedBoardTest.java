package eapli.base.sharedBoard.domain;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharedBoardTest {
    private SystemUser owner;

    @BeforeEach
    void setUp() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.nonUserValues());
         owner = userBuilder.build();
    }

    @Test
    void testCreateSharedBoard() {
        // Act
        SharedBoard sharedBoard = new SharedBoard(Designation.valueOf("Shared Board Title"), owner);

        // Assert
        assertNotNull(sharedBoard);
        assertEquals(Designation.valueOf("Shared Board Title"), sharedBoard.sharedBoardTitle());
        assertEquals(owner, sharedBoard.ownerSharedBoard());
    }

    @Test
    void testSameAs() {
        SharedBoard sharedBoard1 = new SharedBoard(Designation.valueOf("Shared Board Title"), owner);
        SharedBoard sharedBoard2 = new SharedBoard(Designation.valueOf("Shared Board Title"), owner);

        // Act & Assert
        assertTrue(sharedBoard1.sameAs(sharedBoard2));
    }
}
