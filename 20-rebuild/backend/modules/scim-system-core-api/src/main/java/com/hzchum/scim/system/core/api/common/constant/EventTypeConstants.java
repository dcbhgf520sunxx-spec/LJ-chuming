package com.hzchum.scim.system.core.api.common.constant;

import java.util.ArrayList;
import java.util.List;

public class EventTypeConstants {
   public static String BPMS_INSTANCE_CHANGE = "bpms_instance_change";
   public static String BPMS_TASK_CHANGE = "bpms_task_change";
   public static final String USER_ADD_ORG = "user_add_org";
   public static final String USER_MODIFY_ORG = "user_modify_org";
   public static final String USER_LEAVE_ORG = "user_leave_org";
   public static final List<String> eventList = new ArrayList<>();

   static {
      eventList.add(BPMS_TASK_CHANGE);
      eventList.add(BPMS_INSTANCE_CHANGE);
      eventList.add("user_add_org");
      eventList.add("user_modify_org");
      eventList.add("user_leave_org");
   }
}
