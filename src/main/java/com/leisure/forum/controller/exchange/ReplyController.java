package com.leisure.forum.controller.exchange;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.leisure.forum.entity.TopicReply;
import com.leisure.forum.exception.HttpException;
import com.leisure.forum.exception.ServiceException;
import com.leisure.forum.servie.exchange.ReplyService;
import com.leisure.forum.type.CodeType;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午7:30:37
 */
@RestController
@RequestMapping(value = "/${app.version}/exchange")
public class ReplyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplyController.class);
	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = "/reply/{id}", method = RequestMethod.GET)
	public TopicReply query(@PathVariable("id") Long id) throws HttpException, ServiceException {
		if (id == null) {
			throw new HttpException("参数错误");
		}
		return replyService.queryById(id);
	}

	@RequestMapping(value = "/{topicId}/replys", method = RequestMethod.GET)
	public List<TopicReply> queryReplysByTopicIdAndPage(@PathVariable("topicId") Long topicId,
			@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize) throws HttpException {
		if (topicId == null) {
			throw new HttpException("参数错误");
		}
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = AppConstant.EXCHANGE_REPLY_PAGE_SIZE;
		}
		return replyService.queryReplysByTopicIdAndPage(topicId, page, pageSize);
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public BaseMessage add(@RequestBody TopicReply reply) throws HttpException, ServiceException {
		if (reply == null || "".equals(reply.getContent().trim())) {
			throw new HttpException("参数错误");
		}
		BaseMessage baseMessage;
		if (replyService.add(reply)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "添加成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "添加失败");
		}
		return baseMessage;
	}

	@RequestMapping(value = "/reply/{id}", method = RequestMethod.POST)
	public BaseMessage update(@PathVariable("id") Long id, @RequestBody TopicReply reply)
			throws HttpException, ServiceException {
		if (id == null || "".equals(reply.getContent().trim())) {
			throw new HttpException("参数错误");
		}
		BaseMessage baseMessage;
		if (replyService.update(reply)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "更新成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "更新失败");
		}
		return baseMessage;
	}

	@RequestMapping(value = "/reply/{id}", method = RequestMethod.POST)
	public BaseMessage delete(@PathVariable("id") Long id) throws HttpException, ServiceException {
		if (id == null) {
			throw new HttpException("参数错误");
		}
		BaseMessage baseMessage;
		if (replyService.delete(id)) {
			baseMessage = new BaseMessage(CodeType.OPERATION_SUCCESS, HttpStatus.OK.value(), "删除成功");
		} else {
			baseMessage = new BaseMessage(CodeType.OPERATION_FAILED, HttpStatus.OK.value(), "删除失败");
		}
		return baseMessage;
	}

}
