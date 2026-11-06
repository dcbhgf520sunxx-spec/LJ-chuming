package com.hzchum.scim.mes.building.core.biz.impl.attend;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.attend.MesBuildingAttendanceOverConfigUserLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfigUserLink;
import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceOverConfigUserLinkService;
import com.hzchum.scim.mes.building.core.mapper.attend.MesBuildingAttendanceOverConfigUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAttendanceOverConfigUserLinkBizImpl
   extends IBizImpl<MesBuildingAttendanceOverConfigUserLinkService, MesBuildingAttendanceOverConfigUserLinkMapper, MesBuildingAttendanceOverConfigUserLink>
   implements MesBuildingAttendanceOverConfigUserLinkBiz {
}
