package eapli.base.permission.repositories;

import eapli.base.permission.domain.Permission;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

/**
 * The interface Permission repository.
 */
public interface PermissionRepository extends DomainRepository<Long, Permission> {


    Permission hasPermissionByEmail(EmailAddress email);

    Permission hasBoardPermissionByEmail(EmailAddress email, Long id);

    Iterable<Permission>  findWriteAdmin(EmailAddress emailAddress);

}
