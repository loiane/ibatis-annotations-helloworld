package com.loiane.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.loiane.mapper.ContactMapper;
import com.loiane.model.Contact;

/**
 * Contact DAO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class ContactDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public ContactDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * Returns the list of all Contact instances from the database.
	 * @return the list of all Contact instances from the database.
	 */
	public List<Contact> selectAll(){
		
		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			List<Contact> list = mapper.selectAll();
			
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Returns a Contact instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
	 */
	public Contact selectById(int id){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			Contact list = mapper.selectById(id);
			
			return list;
		} finally {
			session.close();
		}
	}

	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	public void update(Contact contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.update(contact);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**
	 * Updates an instance of Contact in the database.
	 * @param name name value to be updated.
	 * @param id primary key value used for lookup.
	 */
	public void updateName(String name, int id){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.updateName(name, id);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	public void insert(Contact contact){

		SqlSession session = sqlSessionFactory.openSession();

		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.insert(contact);
			
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	public void delete(int id){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			ContactMapper mapper = session.getMapper(ContactMapper.class);
			mapper.delete(id);
			
			session.commit();
		} finally {
			session.close();
		}
	}
}
