package com.neu.edu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	
    private static SqlSessionFactory sqlSessionFactory = null;
	
	static
	{
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static SqlSession getSession()
	{
		return sqlSessionFactory.openSession();
	}
	
	

}
