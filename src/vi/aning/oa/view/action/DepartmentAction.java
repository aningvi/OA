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
	private Long parentId;
	
	
	public Department getModel() {
		return model;
	}
	public String list() throws Exception {
//		List<Department> departmentList = departmentService.findAll();
//		ActionContext.getContext().put("departmentList", departmentList);
		List<Department> departmentList = null;
		if(parentId == null) {
			departmentList = departmentService.findTopList();
		} else {
			departmentList = departmentService.findChrldren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	public String add() throws Exception {
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);
		departmentService.save(model);
		return "toList";
	}
	public String addUI() throws Exception {
		//准备数据，departmentList
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
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
		department.setParent(departmentService.getById(parentId));
		departmentService.update(department);
		return "toList";
	}
	public String editUI() throws Exception {
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);
		if(department.getParent() != null) {
			parentId = department.getParent().getId();
		}
		return "saveUI";
	}
	public RoleService getRoleService() {
		return null;
	}
	public void setRoleService(RoleService roleService) {
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
