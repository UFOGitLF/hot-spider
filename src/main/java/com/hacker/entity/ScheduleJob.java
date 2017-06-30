package com.hacker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 定时任务pojo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleJob implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name; // 任务名
	private String group; // 任务组
	private String cronExpression; // cron表达式
	private String status; // 状态
	private String description; // 描述
	private String className; // 要执行的任务类路径名(全路径)
}
