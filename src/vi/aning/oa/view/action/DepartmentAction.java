package vi.aning.oa.view.action;

import java.sql.Driver;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import vi.aning.oa.domain.Department;
import vi.aning.oa.domain.Role;
import vi.aning.oa.service.DepartmentService;
import vi.aning.oa.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport  implements ModelDriven<Department>{
	@Resource
	private DepartmentService departmentService;
	private Department model = new Department();
	public Department getModel() {
		return model;
	}
	public String list() throws Exception {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	public String add() throws Exception {
		departmentService.save(model);
		return "toList";
	}
	public String addUI() throws Exception {
		return "saveUI";
	}
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);
		return "toList";
	}
	public String editUI() throws Exception {
		ActionContext.getContext().getValueStack().push(model);
		return "saveUI";
	}
	public RoleService getRoleService() {
		return null;
	}
	public void setRoleService(RoleService roleService) {
	}
}
