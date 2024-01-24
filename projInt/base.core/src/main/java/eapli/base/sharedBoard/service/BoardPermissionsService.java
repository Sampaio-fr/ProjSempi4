package eapli.base.sharedBoard.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.permission.domain.AccessLevel;
import eapli.base.permission.domain.Permission;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class BoardPermissionsService {

    private final PermissionRepository permRepo;
    private final SharedBoardRepository boardRepo;
    private final ECourseUserRepository eCourseUserRepo;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    private final UserRepository userRepository;
    public BoardPermissionsService() {
        RepositoryFactory rep = PersistenceContext.repositories();
        this.permRepo = rep.permissionRepository();
        this.boardRepo = rep.sharedBoardRepository();
        this.eCourseUserRepo = rep.eCourseUserRepository();
        this.userRepository = rep.users();
        this.teacherRepository = rep.teacherRepository();
        this.studentRepository = rep.studentRepository();
    }

    public List<String> listOwnedBoards(EmailAddress email) {

        Iterable<SharedBoard> ownedBoards = null;
        try {
            ownedBoards = this.boardRepo.listOwnedBoards(email);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(ownedBoards);
        List<String> ownedBoardList = new ArrayList<String>();
        for (SharedBoard board :ownedBoards) {
            ownedBoardList.add(board.sharedBoardTitle().toString());
            System.out.println(board.sharedBoardTitle().toString());
        }
        return ownedBoardList;

    }


    public boolean readPermission(String boardName, EmailAddress email){
        boolean flag;
        SharedBoard board = null;
        try{
            board =  boardRepo.findSharedBoardByTitle(Designation.valueOf(boardName));
            flag = true;
        }catch (Exception e){
            flag = false;
        }

        if (flag){
            ECourseUser eUser = eCourseUserRepo.eCourseUserByEmail(email);
            SystemUser user = validateUser(eUser);
            if(user == null){
                return false;
            }

            //pela board
            Permission hasPerm = permRepo.hasPermissionByEmail(email);

            if(hasPerm != null){
                if (hasPerm.AccessLevel() == AccessLevel.WRITE && board != null){
                    hasPerm.readPermission();
                    permRepo.save(hasPerm);
                }else{
                    System.out.println("User already has READ permission for that board OR Board NULL");
                }
            }else{
                Permission perm = new Permission(board, user);
                perm.readPermission();
                permRepo.save(perm);
            }

            return true;
        }
        return false;
    }

    private SystemUser validateUser(ECourseUser eUser){

        SystemUser user = null;

        Teacher teacher = teacherRepository.findTeacherByEmail(eUser.email());
        if (teacher != null) {
            user = teacher.systemUser();
        }else{
            Student student = studentRepository.findStudentByEmail(eUser.email());
            if (student != null){
                user = student.systemUser();
            }
        }

        return user;
    }
    public boolean writePermission(String boardName, EmailAddress email){
        boolean flag;
        SharedBoard board = null;
        try{
            board =  boardRepo.findSharedBoardByTitle(Designation.valueOf(boardName));
            flag = true;
        }catch (Exception e){
            flag = false;
        }

        if (flag){
            ECourseUser eUser = eCourseUserRepo.eCourseUserByEmail(email);
            SystemUser user = validateUser(eUser);
            if(user == null){
                return false;
            }

            //pela board
            Permission hasPerm = permRepo.hasBoardPermissionByEmail(email, board.identity());

            if(hasPerm != null){
                if (hasPerm.AccessLevel() == AccessLevel.WRITE && board != null){
                    hasPerm.writePermission();
                    permRepo.save(hasPerm);
                }else{
                    System.out.println("User already has READ permission for that board OR Board NULL");
                }
            }else{
                Permission perm = new Permission(board, user);
                perm.writePermission();
                permRepo.save(perm);
            }

            return true;
        }
        return false;
    }
}
