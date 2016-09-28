package com.demo.im.model.core.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.demo.im.entity.Role;
import com.demo.im.entity.TResource;
import com.demo.im.model.core.util.UrlPathMatcher;
import com.demo.im.model.dao.RoleMapper;
import com.demo.im.model.dao.TResourceMapper;

public class MyInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private UrlPathMatcher urlMatcher = new UrlPathMatcher();
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private TResourceMapper resDao;

	// 初始化函数
	public MyInvocationSecurityMetadataSource() {
		// 初始化，读取数据库所有的url、角色
		loadResourceDefine();
	}

	// 这个方法在url请求时才会调用，服务器启动时不会执行这个方法，前提是需要在<http>标签内设置 <custom-filter>标签
	// getAttributes这个方法会根据你的请求路径去获取这个路径应该是有哪些权限才可以去访问。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		// 是获取用户请求的url地址
		String url = ((FilterInvocation) object).getRequestUrl();
		// resourceMap保存了loadResourceDefine方法加载进来的数据
		Iterator<String> ite = resourceMap.keySet().iterator();

		while (ite.hasNext()) {
			// 取出resourceMap中读取数据库的url地址
			String resURL = ite.next();
			// 如果两个
			// url地址相同，那么将返回resourceMap中对应的权限集合，然后跳转到MyAccessDecisionManager类里的decide方法，再判断权限
			if (urlMatcher.pathMatchesUrl(url, resURL)) {
				return resourceMap.get(resURL); // 返回对应的url地址的权限
												// ，resourceMap是一个主键为地址，值为权限的集合对象
			}
		}
		// 如果上面的两个url地址没有匹配，返回return
		// null，不再调用MyAccessDecisionManager类里的decide方法进行权限验证，代表允许访问页面
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	private void loadResourceDefine() {
		// 提取系统中的所有权限。
		List<Role> auNames = roleDao.selectAllRoleByParam(new Role());
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		// 查出多有的资源
		List<TResource> resList = resDao.selectByParam(new TResource());

		for (TResource res : resList) {
			String url = res.getValue();
			
			List<Role> roles = res.getRoles();
			
			for(Role role:roles){
				ConfigAttribute ca = new SecurityConfig(role.getRolecode());
				
				// * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。                           
                if (resourceMap.containsKey(url)){
                	Collection<ConfigAttribute> value = resourceMap.get(url); //取出这个url的权限集合
                	value.add(ca);
                	resourceMap.put(url, value);
                } else{
                	Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                	atts.add(ca);
                    resourceMap.put(url, atts);
                }
			}
			
		}

	}
}
