package com.hzchum.scim.mes.building.core.api.service.attend;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import java.util.List;
import org.springframework.scheduling.annotation.Async;

public interface MesWxMsgService {
   void initToDaySendMsgTimers();

   @Async
   void initToDayUserSendMsgTimers(User user);

   void appendOverTimes(MesBuildingAttendanceOverConfig overConfig, List<Long> rosterIds);

   void removeOverTimers(MesBuildingAttendanceOverConfig overConfig, List<Long> tempRosterIds);
}
