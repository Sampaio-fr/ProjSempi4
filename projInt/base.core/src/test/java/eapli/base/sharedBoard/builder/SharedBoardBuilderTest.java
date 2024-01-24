package eapli.base.sharedBoard.builder;

import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SharedBoardBuilderTest {

    @Test
    void testBuildSharedBoard() {
        // Arrange
        Designation sharedBoardTitle  = Designation.valueOf("Shared Board Title");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser ownerSharedBoard = userBuilder.build();

        // Act
        SharedBoard sharedBoard = new SharedBoardBuilder()
                .withBoardTitle(sharedBoardTitle)
                .withOwnerBoard(ownerSharedBoard)
                .build();

        // Assert
        assertNotNull(sharedBoard);
        assertEquals(sharedBoardTitle, sharedBoard.sharedBoardTitle());
        assertEquals(ownerSharedBoard, sharedBoard.ownerSharedBoard());
    }

    @Test
    void testBuildSharedBoardWithoutTitle() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser ownerSharedBoard = userBuilder.build();
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> new SharedBoardBuilder()
                .withOwnerBoard(ownerSharedBoard)
                .build());
    }

    @Test
    void testBuildSharedBoardWithoutOwner() {
        // Arrange
        Designation sharedBoardTitle =Designation.valueOf("Shared Board Title");

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> new SharedBoardBuilder()
                .withBoardTitle(sharedBoardTitle)
                .build());
    }
}