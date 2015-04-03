package vi.aning.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vi.aning.oa.base.DaoSupportImpl;
import vi.aning.oa.domain.Privilege;
import vi.aning.oa.service.PrivilegeService;
@Service
@Transactional
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService {

}
