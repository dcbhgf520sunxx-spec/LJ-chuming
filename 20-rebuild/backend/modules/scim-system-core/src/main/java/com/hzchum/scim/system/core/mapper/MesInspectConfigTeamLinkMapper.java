package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigTeamLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspectConfigTeamLinkMapper extends BaseMapper<MesInspectConfigTeamLink> {
   List<MesInspectConfigTeamLinkDTO> findInspectInfoByInspectId(@Param("inspectId") List<Long> inspectId);
}
