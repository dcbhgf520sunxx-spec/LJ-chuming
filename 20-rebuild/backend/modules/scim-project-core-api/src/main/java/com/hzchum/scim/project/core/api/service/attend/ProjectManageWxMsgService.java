package com.hzchum.scim.project.core.api.service.attend;

import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.system.core.api.pojo._do.User;
import org.springframework.scheduling.annotation.Async;

public interface ProjectManageWxMsgService {
   void initToDaySendMsgTimers();

   @Async
   void initToDayUserSendMsgTimers(User user);

   void saveSendMsgByRoster(ProjectManageRoster roster);

   void removeSendMsgByRoster(ProjectManageRoster roster);
}
