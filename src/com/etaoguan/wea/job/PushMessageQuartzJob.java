package com.etaoguan.wea.job;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.etaoguan.wea.common.WeaApplication;
import com.etaoguan.wea.common.WeaDataCache;

public class PushMessageQuartzJob implements Job {

	private static String expr = "0/10 * * * * ?";
	 
	@Override
	public void execute(JobExecutionContext jobContext) {
		
			try {
				if(WeaDataCache.getCache().getAppSettingAllowPushMessage()){
				WeaApplication.getInstance().getPushMessageJobService().getNSendPushMessages();
				}
			} catch (Exception e) {
				e.getMessage();
			}
			
		}
	
	// 设置调度任务及触发器，任务名及触发器名可用来停止任务或修改任务
	public static void startScheduler(){
		try{
		   
		   JobDetail jobDetail = JobBuilder
					.newJob(PushMessageQuartzJob.class)
					.withIdentity("pushMessageJob", "pushMessageJobGroup")
					.build();
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity("pushMessageJobTrigger",
							"pushMessageJobTriggerGroup")
					.withSchedule(CronScheduleBuilder.cronSchedule(expr))
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
