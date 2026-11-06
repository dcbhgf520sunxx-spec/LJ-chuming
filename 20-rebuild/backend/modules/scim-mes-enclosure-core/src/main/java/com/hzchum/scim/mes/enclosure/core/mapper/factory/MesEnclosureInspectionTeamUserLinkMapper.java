package com.hzchum.scim.mes.enclosure.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeamUserLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureInspectionTeamUserLinkMapper extends BaseMapper<MesEnclosureInspectionTeamUserLink> {
   List<MesEnclosureInspectionTeamUserLink> selectByCondition(@Param("processId") Long processId);
}
