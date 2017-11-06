package com.leisure.forum.controller.user;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.leisure.forum.entity.TestTable;
import com.leisure.forum.mapper.TestTableMapper;

@RestController
@RequestMapping("/test")
public class IndexController {
	private static final Gson gson = new Gson();

	@Autowired
	private TestTableMapper testTableMapper;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index() {
		return gson.toJson(testTableMapper.selectAll());
	}
	@RequestMapping(value = { "/limit", "/limit/" }, method = RequestMethod.GET)
	public String index2(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "pageSize", defaultValue = "9999") Integer pageSize) {
		RowBounds rowBounds = new RowBounds((page - 1) * pageSize, pageSize);
		TestTable t = new TestTable();
		t.setName("23");
		List<TestTable> results = testTableMapper.selectByRowBounds(t, rowBounds);
		return gson.toJson(results);
	}

}
