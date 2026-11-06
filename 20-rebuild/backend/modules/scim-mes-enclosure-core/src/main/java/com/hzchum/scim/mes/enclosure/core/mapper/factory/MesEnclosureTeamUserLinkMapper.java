package com.hzchum.scim.mes.enclosure.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeamUserLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureTeamUserLinkMapper extends BaseMapper<MesEnclosureTeamUserLink> {
   List<MesEnclosureTeamUserLink> selectByCondition(@Param("processId") Long processId, @Param("teamId") Long teamId);
}
