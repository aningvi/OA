package vi.aning.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vi.aning.oa.dao.DepartmentDao;
import vi.aning.oa.domain.Department;
import vi.aning.oa.service.DepartmentService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentDao departmentDao;
	@Resource
	SessionFactory sf;
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	public void save(Department model) {
		departmentDao.save(model);
	}

	public Department getById(Long id) {
		return departmentDao.getById(id);
	}

	public void delete(Long id) {
		departmentDao.delete(id);
	}

	public void update(Department department) {
		departmentDao.edit(department);
	}


	public List<Department> findTopList() {
		List<Department> l = sf.getCurrentSession().createQuery(
				"FROM Department d WHERE d.parent IS NULL").list();
		System.out.println(l.size());
		return l;
	}

	public List<Department> findChrldren(Long parentId) {
		return sf.getCurrentSession().createQuery(
					"FROM Department d WHERE d.parent.id=?")
					.setParameter(0, parentId).list();
	}
}
