/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation.authz;

import eapli.base.app.common.console.utils.DateUtil;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.user.domain.TaxNumber;
import eapli.base.teacher.domain.Acronym;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.*;

/**
 * UI for adding a user to the application.
 * Created by nuno on 22/03/16.
 */
public class AddUserUI extends AbstractUI {

    private final AddUserController theController = new AddUserController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp

        System.out.println("User Information");

        final String email = Console.readLine("Write the E-Mail");
        final String password = Console.readLine("Write the Password");
        final String firstName = Console.readLine("Write the First Name");
        final String lastName = Console.readLine("Write the Last Name");

        System.out.println("\nRoles Selection:");
        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        if (!roleTypes.contains(BaseRoles.TEACHER) && !roleTypes.contains(BaseRoles.STUDENT)) {

            try {
                this.theController.addUser(email, password, firstName, lastName, email, roleTypes);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That username is already in use.");
            }

        } else {

            String rawTaxNumber;
            TaxNumber taxNumber = null;
            boolean flag;

            do {
                rawTaxNumber = Console.readLine("Write the Tax Number");
                try {
                    flag = true;
                    taxNumber = new TaxNumber(rawTaxNumber);
                } catch (IllegalArgumentException e) {
                    flag = false;
                    System.out.println(e.getMessage());
                }
            } while (!flag);

            String birthdate;
            Date date;

            do {
                birthdate = Console.readLine("Write the BirthDate");
                date = DateUtil.toDate(birthdate);
            } while (date == null);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            if (roleTypes.contains(BaseRoles.TEACHER)) {
                String rawAcronym;
                Acronym acronym = null;

                do {
                    rawAcronym = Console.readLine("Write the Acronym");
                    try {
                        flag = true;
                        acronym = new Acronym(rawAcronym);
                    } catch (IllegalArgumentException e) {
                        flag = false;
                        System.out.println(e.getMessage());
                    }
                } while (!flag);

                try {
                    this.theController.addTeacher(email, password, firstName, lastName, email, roleTypes, acronym, calendar, taxNumber);
                } catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (roleTypes.contains(BaseRoles.STUDENT)) {
                String rawMecanograficNumber;
                MecanographicNumber mecanographicNumber = null;

                do {
                    rawMecanograficNumber = Console.readLine("Write the mecanografic Number");
                    try {
                        flag = true;
                        mecanographicNumber = new MecanographicNumber(rawMecanograficNumber);
                    } catch (IllegalArgumentException e) {
                        flag = false;
                        System.out.println(e.getMessage());
                    }
                } while (!flag);

                try {
                    this.theController.addStudent(email, password, firstName, lastName, email, roleTypes, mecanographicNumber, calendar, taxNumber);
                } catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return false;
    }

    private boolean showRoles(final Set<Role> roleTypes) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 0;
        rolesMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final Role roleType : theController.getRoleTypes()) {
            rolesMenu.addItem(MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }

    @Override
    public String headline() {
        return "Add User";
    }
}
