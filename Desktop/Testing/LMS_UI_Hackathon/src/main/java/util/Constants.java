package util;

import base.Base;

public class Constants  extends Base{
	
	
	
	//**********Numeric********************
		private static long pageLoadTimeOut = 20;
		private static long implicitWait = 10;
		
		//**********String*********************
		private static String notificationSuccessMsg = "Notification sent";
		private static String HomePage="HomePageTitle";
		private static String AnswerSecurityPage ="answerSecurityPage";
		
		//**********Getters*********************
		public static long getPageLoadTimeOut() {
			return pageLoadTimeOut;
		}
		
		public static long getimplicitWait() {
			return implicitWait;
		}
		public static String getNotificationSuccessMsg() {
			return notificationSuccessMsg;
		}
		
		
		
		public static String getHomePageConstant()
		{
			return HomePage;
		}
				
		public static String getAnswerSecurityPage() {
			return AnswerSecurityPage;
		}
	
	

}
