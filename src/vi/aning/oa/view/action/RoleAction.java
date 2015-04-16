package vi.aning.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import vi.aning.oa.dao.RoleDao;
import vi.aning.oa.domain.Role;
import vi.aning.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{
	@Resource
	private RoleService roleService;
	private Role model = new Role();
	
	public Role getModel() {
		System.out.println("------------------");
		return model;
	}
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	public String add() throws Exception {
//		Role role = new Role();
//		role.setName(model.getName());
//		role.setDescription(model.getDescription());
//		roleService.save(role);
		roleService.save(model);
		return "toList";
	}
	public String addUI() throws Exception {
		return "saveUI";
	}
	public String delete() throws Exception {
		roleService.delete(model.getId());
		return "toList";
	}
	public String edit() throws Exception {
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	public String editUI() throws Exception {
		Role role = roleService.getById(model.getId());
//		this.name = role.getName();
//		this.description = role.getDescription();
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
