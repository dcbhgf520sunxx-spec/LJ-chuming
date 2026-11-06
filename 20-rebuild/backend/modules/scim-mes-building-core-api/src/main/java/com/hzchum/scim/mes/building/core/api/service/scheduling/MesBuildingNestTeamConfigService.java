package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestTeamConfigDTO;
import java.util.List;

public interface MesBuildingNestTeamConfigService extends IService<MesBuildingNestTeamConfig> {
   PageVO<MesBuildingNestTeamConfigDTO> pageNestTeamConfig(Integer pageNumber, Integer pageSize);

   int addNestTeamConfig(MesBuildingNestTeamConfig mesBuildingNestTeamConfig);

   int updateNestTeamConfig(MesBuildingNestTeamConfig mesBuildingNestTeamConfig);

   boolean updateNestTeamConfigALL(Boolean codeRule, Boolean displayRule, Boolean teamDisplayRule);

   List<MesBuildingNestTeamConfigDTO> selectNeedNestTeamConfig(Long teamId);
}
