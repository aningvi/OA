package vi.aning.oa.service;

import java.util.List;

import vi.aning.oa.base.DaoSupport;
import vi.aning.oa.domain.Department;


public interface DepartmentService extends DaoSupport<Department>{

//	List<Department> findAll();
//
//	void save(Department model);
//
//	Department getById(Long id);
//
//	void delete(Long id);
//
//	void update(Department department);

	List<Department> findTopList();

	List<Department> findChrldren(Long parentId);
}
