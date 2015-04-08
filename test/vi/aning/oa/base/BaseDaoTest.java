package vi.aning.oa.base;

import org.junit.Test;

import vi.aning.oa.dao.RoleDao;
import vi.aning.oa.dao.UserDao;
import vi.aning.oa.dao.impl.RoleDaoImpl;
import vi.aning.oa.dao.impl.UserDaoImpl;

public class BaseDaoTest {

	@Test
	public void testSave() {
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();
	}

}
