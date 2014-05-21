package com.aehp.template.dao.jpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aehp.template.dao.IStudentDao;
import com.aehp.template.domain.Student;

@Repository
@Transactional(
    readOnly = true,
        propagation = Propagation.SUPPORTS)
public class StudentJpaDao implements IStudentDao {

	@Override
	public List<Student> getStudents()
	        throws Exception {
//		try {
//            final CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();
//            final CriteriaQuery<Student> c = cb.createQuery(Student.class);
//            final Root<Student> root = c.from(Student.class);
////            c.select(root).where(
////        		cb.and(cb.equal(root.get(PrmPnd_.cityCode), cityCode),
////        				cb.equal(root.get(PrmPnd_.pndZone), pndZone)));
//            final TypedQuery<Student> q = this.getEntityManager().createQuery(c);
//            return q.getResultList();
//        } catch (NoResultException e) {
//            return null;
//        } catch (PersistenceException e) {
//            //throw new JpaDaoException(e);
//        }
		return null;
	}

	@Override
    @Transactional(
        readOnly = false,
            propagation = Propagation.MANDATORY)
	public void createStudent(Student student)
		throws Exception {
    	try {
//            getEntityManager().persist(student);
//            getEntityManager().flush();
        } catch (PersistenceException e) {
            //throw new JpaDaoException(e);
        }
	}
	
    @Override
    @Transactional(
        readOnly = false,
            propagation = Propagation.MANDATORY)
	public void updateStudent(Student student)
		throws Exception {
    	try {
//            getEntityManager().merge(student);
//            getEntityManager().flush();
        } catch (PersistenceException e) {
            //throw new JpaDaoException(e);
        }
	}
	
}
