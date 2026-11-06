package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigTeamLinkDTO;
import java.util.List;

public interface MesInspectConfigTeamLinkService extends IService<MesInspectConfigTeamLink> {
   List<MesInspectConfigTeamLinkDTO> findInspectInfoByInspectId(List<Long> inspectId);
}
