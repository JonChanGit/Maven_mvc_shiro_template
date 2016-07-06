package com.jon.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.jon.web.dao.imp.IUserDAO;
import com.jon.web.entity.SysUser;

public class UserDAO implements IUserDAO {

	private SessionFactory sessionFactory;
 

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(SysUser user) {
	 sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<SysUser> getAllUser() {
		
		String hql = "from User ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	/**
	 * 使用 HQL 语句操作， 简单方便
	 * 含有参数传递示例
	 */
	@Override
	public boolean deleteUser(long userId) {
		String hql = "delete User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, userId);//设置 参数
		
		int affectedRowsCount = query.executeUpdate();//Execute the update or delete statement.

		return affectedRowsCount > 0;//大于0说明有数据被删除
	}

	@Override
	public SysUser getUser(long id) {
		String hql = "from User where id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, id);//设置 参数
		return (SysUser)query.uniqueResult();//返回匹配的查询或返回 null，如果查询不返回任何结果的单一实例的便捷方法。 @return the single result or <tt>null</tt>
	}

	@Override
	public boolean updateUser(SysUser user) {
		
		String hql = "update User u set u.email=?,u.pwd=? where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getEmail());
		query.setString(1, user.getPwd());
		query.setLong(2, user.getId());
		
		int affectedRowsCount = query.executeUpdate();//Execute the update or delete statement.
		return affectedRowsCount > 0;//大于0说明有数据被删除
	}

	 

}
