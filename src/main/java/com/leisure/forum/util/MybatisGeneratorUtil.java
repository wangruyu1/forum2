package com.leisure.forum.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.Configuration;

public class MybatisGeneratorUtil {
	public static void main(String[] args) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
//		ConfigurationParser cp = new ConfigurationParser(warnings);
//		Configuration config = cp
//				.parseConfiguration(Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
//		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//		myBatisGenerator.generate(null);
	}
}
