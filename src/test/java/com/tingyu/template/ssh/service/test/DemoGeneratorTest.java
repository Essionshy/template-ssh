package com.tingyu.template.ssh.service.test;

/**
 * 1、代码生成器测试类
 * @author Essionshy
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class DemoGeneratorTest {
	
	@Test
	public void executeGenerator() throws IOException {
		String entityName = "Customer";// 实体类名称
		oneKeyGenerate(entityName);
	}

	/**
	 * 1、一键生成实体类相关类
	 * 
	 * @param entityName
	 * @throws IOException
	 */
	public void oneKeyGenerate(String entityName) throws IOException {
		generateEntity(entityName); //1、通常情况下，实体类通过数据表逆向工程获得，因此不需要手动创建
		generateQuery(entityName);
		generateDao(entityName);
		generateDaoImpl(entityName);
		generateService(entityName);
		generateServiceImpl(entityName);
		generateController(entityName);
	}
	
	
	private void generateEntity(String entityName) throws IOException {
		System.out.println("****************** 准备生成Query查询对象 **********************");
		String sourcePath = "src/test/resources/templates/Demo.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/entities/";
		String suffixName = ".java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生成Query查询对象代码完成 **********************");
	}
	
	/**
	 * 1、生成Query查询对象
	 * @param entityName
	 * @throws IOException
	 */
	private void generateQuery(String entityName) throws IOException {
		System.out.println("****************** 准备生成Query查询对象 **********************");
		String sourcePath = "src/test/resources/templates/DemoQuery.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/query/";
		String suffixName = "Query.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生成Query查询对象代码完成 **********************");
	}

	/**
	 * 1、一键生成EntityDao
	 * 
	 * @throws IOException
	 */

	public void generateDao(String entityName) throws IOException {
		System.out.println("****************** 准备生成Dao接口 **********************");
		String sourcePath = "src/test/resources/templates/DemoDao.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/dao/";
		String suffixName = "Dao.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生成代码完成 **********************");
	}

	/**
	 * 1、一键生成EntityDaoImpl
	 * 
	 * @throws IOException
	 */

	public void generateDaoImpl(String entityName) throws IOException {
		System.out.println("****************** 准备生成DaoImpl实现类 **********************");
		String sourcePath = "src/test/resources/templates/DemoDaoImpl.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/dao/impl/";
		String suffixName = "DaoImpl.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生成代码完成 **********************");
	}

	/**
	 * 1、生成Service接口
	 * @param entityName
	 * @throws IOException
	 */
	public void generateService(String entityName) throws IOException {
		System.out.println("****************** 准备生成Service接口 **********************");
		String sourcePath = "src/test/resources/templates/DemoService.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/service/";
		String suffixName = "Service.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生成Service代码完成 **********************");
	}

	/**
	 * 1、生成ServiceImpl
	 * @param entityName
	 * @throws IOException
	 */
	public void generateServiceImpl(String entityName) throws IOException {
		System.out.println("****************** 准备生成ServiceImpl **********************");

		String sourcePath = "src/test/resources/templates/DemoServiceImpl.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/service/impl/";
		String suffixName = "ServiceImpl.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生ServiceImpl成代码完成 **********************");
	}
	
	/**
	 * 1、生成Controller
	 * @param entityName
	 * @throws IOException
	 */
	public void generateController(String entityName) throws IOException {
		System.out.println("****************** 准备生成Controller **********************");
		String sourcePath = "src/test/resources/templates/DemoController.tlf";
		String targetPath = "src/main/java/com/tingyu/template/ssh/controller/";
		String suffixName = "Controller.java";
		generate(entityName, sourcePath, targetPath, suffixName);
		System.out.println("****************** 自动生Controller成代码完成 **********************");
	}

	/**
	 * 
	 * @param entityName
	 * @param sourcePath
	 * @param targetPath
	 * @param suffixName
	 * @throws IOException
	 */
	public void generate(String entityName, String sourcePath, String targetPath, String suffixName)
			throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(sourcePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath + entityName + suffixName));
		String line = null;
		String newLine = null;
		while ((line = br.readLine()) != null) {
			newLine = line.replace("Demo", entityName);			
			bw.write(newLine);
			System.out.println(newLine);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
