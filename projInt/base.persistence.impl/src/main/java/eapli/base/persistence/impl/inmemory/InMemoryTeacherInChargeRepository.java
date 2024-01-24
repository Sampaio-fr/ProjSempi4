package eapli.base.persistence.impl.inmemory;


import eapli.base.teacherInCharge.domain.TeacherInCharge;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeacherInChargeRepository  extends InMemoryDomainRepository<TeacherInCharge, Long> implements TeacherInChargeRepository {
}
