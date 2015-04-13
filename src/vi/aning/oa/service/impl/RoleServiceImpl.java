package vi.aning.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vi.aning.oa.base.DaoSupportImpl;
import vi.aning.oa.dao.RoleDao;
import vi.aning.oa.domain.Role;
import vi.aning.oa.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

	
}
