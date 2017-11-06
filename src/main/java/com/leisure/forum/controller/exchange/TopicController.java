package com.leisure.forum.controller.exchange;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leisure.forum.constant.AppConstant;
import com.leisure.forum.dto.BaseMessage;
import com.leisure.forum.entity.Topic;
import com.leisure.forum.exception.HttpException;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.servie.exchange.TopicService;
import com.leisure.forum.type.CodeType;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午3:23:53
 */
@RestController
@RequestMapping(value = "/${app.version}/exchange")
public class TopicController {
	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topic/{id}", method = RequestMethod.GET)
	public Topic queryTopic(@PathVariable(value = "id") Long id) throws ServiceException {
		return topicService.queryById(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.GET)
	public List<Topic> queryTopicsByUpdateTimeAndPage(HttpServletRequest request, @RequestParam("page") Integer page,
			@RequestParam("pageSize") Integer pageSize) throws ServiceException {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = AppConstant.EXCHAGE_TOPIC_PAGE_SIZE;
		}
		String updateTimestr = request.getParameter("updateTime");
		Topic topic = null;
		// 根据时间查询
		if (updateTimestr != null) {
			topic = new Topic(DateUtil.parse(updateTimestr));
		}
		return topicService.queryListByEntityAndPage(topic, page, pageSize);
	}

	@RequestMapping(value = "/topic", method = RequestMethod.POST)
	public BaseMessage addTopic(@RequestBody Topic topic) throws HttpException, ServiceException {
		if ("".equals(topic.getContent().trim()) || "".equals(topic.getTitle())) {
			throw new HttpException("参数错误.");
		}
		BaseMessage baseMessage;
		if (topicService.add(topic)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "添加成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "添加失败");
		}
		return baseMessage;
	}

	@RequestMapping(value = "/topic/{id}", method = RequestMethod.PUT)
	public BaseMessage modifyTopic(@PathVariable("id") Long id, @RequestBody Topic topic)
			throws HttpException, ServiceException {
		if (id == null || "".equals(topic.getContent().trim()) || "".equals(topic.getTitle())) {
			throw new HttpException("参数错误.");
		}
		BaseMessage baseMessage;
		if (topicService.update(topic)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "修改成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "修改失败");
		}
		return baseMessage;
	}

	@RequestMapping(value = "/topic/{id}", method = RequestMethod.DELETE)
	public BaseMessage deleteTopic(@PathVariable("id") Long id) throws HttpException, ServiceException {
		if (id == null) {
			throw new HttpException("参数错误.");
		}
		BaseMessage baseMessage;
		if (topicService.delete(id)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "修改成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "修改失败");
		}
		return baseMessage;
	}

}
