package vi.aning.oa.service;

import java.util.List;

import vi.aning.oa.domain.Department;


public interface DepartmentService {

	List<Department> findAll();

	void save(Department model);

	Department getById(Long id);

	void delete(Long id);

	void update(Department department);
}
