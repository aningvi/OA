package vi.aning.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vi.aning.oa.dao.RoleDao;
import vi.aning.oa.domain.Role;
import vi.aning.oa.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	
	public List<Role> findAll() {
		return roleDao.findAll();
	}
	
	public void delete(Long id) {
		roleDao.delete(id);
	}

	public void save(Role role) {
		roleDao.save(role);
	}

	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	public void update(Role role) {
		roleDao.edit(role);
	}
}
