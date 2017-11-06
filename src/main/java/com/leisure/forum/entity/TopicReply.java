package com.leisure.forum.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "topic_reply")
public class TopicReply {

	public TopicReply(Long id) {
		super();
		this.id = id;
	}

	public TopicReply() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 帖子id
	 */
	@Column(name = "topic_id")
	private Long topicId;

	/**
	 * 回复时间
	 */
	@Column(name = "reply_time")
	private Date replyTime;

	/**
	 * -1=删除,1=有效.
	 */
	private Integer status;

	/**
	 * 赞同人数，可用于排序。
	 */
	@Column(name = "agree_count")
	private Integer agreeCount;

	/**
	 * 回复内容
	 */
	private String content;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取用户id
	 *
	 * @return user_id - 用户id
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置用户id
	 *
	 * @param userId
	 *            用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取帖子id
	 *
	 * @return topic_id - 帖子id
	 */
	public Long getTopicId() {
		return topicId;
	}

	/**
	 * 设置帖子id
	 *
	 * @param topicId
	 *            帖子id
	 */
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	/**
	 * 获取回复时间
	 *
	 * @return reply_time - 回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}

	/**
	 * 设置回复时间
	 *
	 * @param replyTime
	 *            回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	/**
	 * 获取-1=删除,1=有效.
	 *
	 * @return status - -1=删除,1=有效.
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置-1=删除,1=有效.
	 *
	 * @param status
	 *            -1=删除,1=有效.
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取赞同人数，可用于排序。
	 *
	 * @return agree_count - 赞同人数，可用于排序。
	 */
	public Integer getAgreeCount() {
		return agreeCount;
	}

	/**
	 * 设置赞同人数，可用于排序。
	 *
	 * @param agreeCount
	 *            赞同人数，可用于排序。
	 */
	public void setAgreeCount(Integer agreeCount) {
		this.agreeCount = agreeCount;
	}

	/**
	 * 获取回复内容
	 *
	 * @return content - 回复内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置回复内容
	 *
	 * @param content
	 *            回复内容
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}