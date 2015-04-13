package vi.aning.oa.view.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import vi.aning.oa.base.BaseAction;
import vi.aning.oa.domain.Department;
import vi.aning.oa.domain.Role;
import vi.aning.oa.domain.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private Long departmentId;
	private Long[] roleIds;

	public String list() throws Exception {
		List<User> userList = userService.findAll();
		ActionContext.getContext().put("userList", userList);
		return "list";
	}

	public String add() throws Exception {
		model.setDepartment(departmentService.getById(departmentId));
		if (roleIds != null) {
			List<Role> roles = roleService.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roles));
		}
		String initPassword = DigestUtils.md5Hex("12345");
		model.setPassword(initPassword);
		System.out.println(initPassword);
		userService.save(model);
		return "toList";
	}

	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtil
				.getAllDepartments(topList);
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}

	public String delete() throws Exception {
		userService.delete(model.getId());
		return "toList";
	}

	public String edit() throws Exception {
		// 获取原对象
		User user = userService.getById(model.getId());
		// 更新数据
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		user.setDepartment(departmentService.getById(departmentId));

		if (roleIds != null) {
			List<Role> roles = roleService.getByIds(roleIds);
			user.setRoles(new HashSet<Role>(roles));
		}
		userService.update(user);
		return "toList";
	}

	public String editUI() throws Exception {
		// 准备数据departmentList
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtil
				.getAllDepartments(topList);
		// 准备数据roleList
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		ActionContext.getContext().put("roleList", roleList);
		// 设置回显
		User user = userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if (user.getDepartment() != null) {
			departmentId = user.getDepartment().getId();
		}
		if (user.getRoles() != null) {
			roleIds = new Long[user.getRoles().size()];
			int index = 0;
			for (Role role : user.getRoles()) {
				roleIds[index++] = role.getId();
			}
		}
		return "saveUI";
	}

	public String initPassword() throws Exception {
		//获取原始数据
		User user = userService.getById(model.getId());
		//更改数据
		String initPassword = DigestUtils.md5Hex("12345");
		user.setPassword(initPassword);
		//保存数据
		userService.update(user);
		return "toList";
	}
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
}
