package com.loiane.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.loiane.model.Contact;

/**
 * Contact Mapper contains all the myBatis/iBatis annotations
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public interface ContactMapper {

	final String SELECT_ALL = "SELECT * FROM CONTACT";
	final String SELECT_BY_ID = "SELECT * FROM CONTACT WHERE CONTACT_ID = #{id}";
	final String UPDATE = "UPDATE CONTACT SET CONTACT_EMAIL = #{email}, CONTACT_NAME = #{name}, CONTACT_PHONE = #{phone} WHERE CONTACT_ID = #{id}";
	final String UPDATE_NAME = "UPDATE CONTACT SET CONTACT_NAME = #{name} WHERE CONTACT_ID = #{id}";
	final String DELETE = "DELETE FROM CONTACT WHERE CONTACT_ID = #{id}";
	final String INSERT = "INSERT INTO CONTACT (CONTACT_EMAIL, CONTACT_NAME, CONTACT_PHONE) VALUES (#{name}, #{phone}, #{email})";
		
	/**
	 * Returns the list of all Contact instances from the database.
	 * @return the list of all Contact instances from the database.
	 */
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="CONTACT_ID"),
		@Result(property="name", column="CONTACT_NAME"),
		@Result(property="phone", column="CONTACT_PHONE"),
		@Result(property="email", column="CONTACT_EMAIL")
	})
	List<Contact> selectAll();
	
	/**
	 * Returns a Contact instance from the database.
	 * @param id primary key value used for lookup.
	 * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
	 */
	@Select(SELECT_BY_ID)
	@Results(value = {
		@Result(property="id"),
		@Result(property="name", column="CONTACT_NAME"),
		@Result(property="phone", column="CONTACT_PHONE"),
		@Result(property="email", column="CONTACT_EMAIL")
	})
	Contact selectById(int id);
	
	/**
	 * Updates an instance of Contact in the database.
	 * @param contact the instance to be updated.
	 */
	@Update(UPDATE)
	void update(Contact contact);
	
	/**
	 * Updates an instance of Contact in the database.
	 * @param name name value to be updated.
	 * @param id primary key value used for lookup.
	 */
	void updateName(@Param("name") String name, @Param("id") int id);
	
	/**
	 * Delete an instance of Contact from the database.
	 * @param id primary key value of the instance to be deleted.
	 */
	@Delete(DELETE)
	void delete(int id);
	
	/**
	 * Insert an instance of Contact into the database.
	 * @param contact the instance to be persisted.
	 */
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Contact contact);
}
