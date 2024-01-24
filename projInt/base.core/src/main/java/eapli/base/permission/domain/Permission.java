package eapli.base.permission.domain;

import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

/**
 * The type Permission.
 */
@Entity
@Table
public class Permission implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long idPermission;

    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

    @OneToOne(cascade = CascadeType.ALL)
    private SharedBoard sharedBoard;

    @OneToOne(cascade = CascadeType.ALL)
    private SystemUser user;

    /**
     * Instantiates a new Permission.
     *
     * @param accessLevel  the access level
     * @param sharedBoard  the shared Board
     * @param user  the eCourse User
     */
    public Permission(AccessLevel accessLevel, SharedBoard sharedBoard, SystemUser user) {
        this.accessLevel = accessLevel;
        this.sharedBoard = sharedBoard;
        this.user = user;
    }

    public Permission(SharedBoard sharedBoard, SystemUser user) {
        this.sharedBoard = sharedBoard;
        this.user = user;
    }

    /**
     * Instantiates a new Permission.
     */
    protected Permission() {
    }


    public SharedBoard SharedBoard(){return sharedBoard;}

    public SystemUser ECourseUser(){return user;}

    public AccessLevel AccessLevel(){return this.accessLevel;}

    public void changeAccessLevel(AccessLevel accessLevel){this.accessLevel=accessLevel;}

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Permission)) {
            return false;
        }

        final Permission that = (Permission) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && accessLevel == that.accessLevel;
    }


    public void readPermission() {
        this.accessLevel = AccessLevel.READ;
    }
    public void writePermission() {
        this.accessLevel = AccessLevel.WRITE;
    }

    @Override
    public Long identity() {
        return this.idPermission;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "idPermission=" + idPermission + "\n" +
                "User : " + user.identity() +
                ", accessLevel=" + accessLevel +
                '}';
    }
}
