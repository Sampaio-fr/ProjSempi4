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
package eapli.base.sharedBoard.application;


import eapli.base.sharedBoard.service.SharedBoardService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

/**
 * The type Create shared board controller.
 */
public class CreateSharedBoardController {

    private final SharedBoardService boardManagementService;

    private final SystemUser systemUser;
    /**
     * Instantiates a new Create shared board controller.
     */
    public CreateSharedBoardController(SystemUser systemUser) {
        this.boardManagementService = new SharedBoardService(systemUser);
        this.systemUser = systemUser;
    }

    public void createSharedBoard(String title, List<String> rowTitle, List<String> columnTitle) {
        boardManagementService.createSharedBoard(title, rowTitle, columnTitle);
        System.out.println(systemUser.email());;
    }

}

