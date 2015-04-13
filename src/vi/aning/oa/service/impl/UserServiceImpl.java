package vi.aning.oa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vi.aning.oa.base.DaoSupportImpl;
import vi.aning.oa.domain.User;
import vi.aning.oa.service.UserService;
@Service
@Transactional
public class UserServiceImpl extends DaoSupportImpl<User> implements UserService {

}
