package com.hzchum.scim.mes.building.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingInspectionTeamUserLinkMapper extends BaseMapper<MesBuildingInspectionTeamUserLink> {
   List<MesBuildingInspectionTeamUserLink> selectByCondition(@Param("processId") Long processId);
}
