package vi.aning.oa.view.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import vi.aning.oa.base.BaseAction;
import vi.aning.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	public String add() throws Exception {
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
}
