package vi.aning.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import vi.aning.oa.service.DepartmentService;
import vi.aning.oa.service.RoleService;
import vi.aning.oa.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	protected T model;
	
	public BaseAction() {
		try {
			//通过反射获得model真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public T getModel() {
		return model;
	}
}
