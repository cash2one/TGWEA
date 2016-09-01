package com.etaoguan.wea.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.CronScheduleBuilder;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.etaoguan.wea.common.WeaApplication;;

@DisallowConcurrentExecution
public class FileCacheQuartzJob implements Job {

	@SuppressWarnings("unused")
	private final static Log logger = LogFactory
			.getLog(FileCacheQuartzJob.class);
//	private static String expr1Hour = "0/3 * * * * ?";//3秒每次
	private static String expr1Hour = "0 0 0/1 * * ?";
	 
	@Override
	public void execute(JobExecutionContext jobContext) {
		
			try {
				WeaApplication.getInstance().getFileCacheService().saveProdDetailJSONFileCache();
				
			} catch (Exception e) {
				e.getMessage();
			}
			
		}
	
	// 设置调度任务及触发器，任务名及触发器名可用来停止任务或修改任务
	public static void startScheduler(){
		try{
		   
		   JobDetail jobDetail = JobBuilder
					.newJob(FileCacheQuartzJob.class)
					.withIdentity("fileCacheJob", "fileCacheJobGroup")
					.build();
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("fileCacheJobTrigger",
							"fileCacheJobTriggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule(expr1Hour))
					.build();
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
}
}
