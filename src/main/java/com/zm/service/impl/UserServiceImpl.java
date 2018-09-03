package com.zm.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.entity.User;
import com.zm.mapper.interfaces.UserMapper;
import com.zm.service.UserService;
import com.zm.tools.DBTools;

@Service("userservice")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	SqlSessionTemplate sqlsession;

	@Override
	public void save(User u) {
		// UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
		sqlsession.insert("UserMapper.insertUser", u);

	}

	@Override
	public void delete(int id) {
		int g = sqlsession.delete("UserMapper.deleteUser", id);
		System.out.println(g);
	}

	@Override
	public int update(User user, int id) {
		int g = sqlsession.update("UserMapper.updateUser", user);
		System.out.println(g);
		return g;
	}

	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectTwoArg(HashMap<String, String> map) {
		User u = sqlsession.selectOne("UserMapper.updateUser", map);
		return u;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	public static void main(String[] args) {
		insertUser();
		// deleteUser(1);
		// selectUserById(2);
		// selectAllUser();
	}

	/**
	 * 新增用户
	 */
	private static boolean insertUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		try {
			int index = mapper.insertUser(user);
			boolean bool = index > 0 ? true : false;
			logger.error("新增用户user对象:{},操作状态:{}", new Object[] { user, bool });
			session.commit();
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param id 用户ID
	 */
	@SuppressWarnings("unused")
	private static boolean deleteUser(int id) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			int index = mapper.deleteUser(id);
			boolean bool = index > 0 ? true : false;
			logger.debug("根据用户id:{},操作状态{}", new Object[] { id, bool });
			session.commit();
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 */
	@SuppressWarnings("unused")
	private static void selectUserById(int id) {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			User user = mapper.selectUserById(id);
			logger.debug("根据用户Id:{},查询用户信息:{}", new Object[] { id, user });
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 查询所有的用户
	 */
	@SuppressWarnings("unused")
	private static void selectAllUser() {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<User> user = mapper.selectAllUser();
			logger.debug("获取所用的用户:{}", user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}

}
