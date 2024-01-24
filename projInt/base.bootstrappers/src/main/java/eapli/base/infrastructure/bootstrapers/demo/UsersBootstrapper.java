package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.base.teacher.domain.Acronym;
import eapli.base.user.domain.TaxNumber;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsersBootstrapper extends UsersBootstrapperBase implements Action {
    private AddUserController addUserController;
    @Override
    public boolean execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        addUserController = new AddUserController();
        Set<Role> roles;
        try {
            cal.setTime(sdf.parse("27-11-2000"));
            roles = new HashSet<>();
            roles.add(BaseRoles.STUDENT);
            addUserController.addStudent("cunha7@me.com","Password1","Jorge","Cunha","cunha7@me.com",roles,new MecanographicNumber("1200618"),
               cal   ,new TaxNumber("123456789"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            cal.setTime(sdf.parse("10-01-2002"));
            roles = new HashSet<>();
            roles.add(BaseRoles.STUDENT);
            addUserController.addStudent("alves@me.com","Password1","Ines","Alves","alves@me.com",roles,new MecanographicNumber("123051"),
                    cal   ,new TaxNumber("123451234"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            cal.setTime(sdf.parse("15-06-1998"));
            roles = new HashSet<>();
            roles.add(BaseRoles.STUDENT);
            addUserController.addStudent("fabio@me.com","Password1","Fabio","Silva","fabio@me.com",roles,new MecanographicNumber("1201241"),
                    cal   ,new TaxNumber("987654321"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        try {
            cal.setTime(sdf.parse("15-06-1994"));
            roles = new HashSet<>();
            roles.add(BaseRoles.TEACHER);
            addUserController.addTeacher("fabioteacher@me.com","Password1","Fabio","Silva","fabioteacher@me.com",roles,new Acronym("FAB"),
                    cal   ,new TaxNumber("987654123"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            cal.setTime(sdf.parse("15-09-1996"));
            roles = new HashSet<>();
            roles.add(BaseRoles.TEACHER);
            addUserController.addTeacher("aliceteacher@me.com","Password1","Alice","Maria","aliceteacher@me.com",roles,new Acronym("ALI"),
                    cal   ,new TaxNumber("986754123"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        try {
            cal.setTime(sdf.parse("15-12-1988"));
            roles = new HashSet<>();
            roles.add(BaseRoles.TEACHER);
            addUserController.addTeacher("sampaioteacher@me.com","Password1","Francisco","Sampaio","sampaioteacher@me.com",roles,new Acronym("FSA"),
                    cal   ,new TaxNumber("897654423"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        return true;
    }
}
