package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingNestingTeamDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesBuildingNestingTeamVO;
import java.util.List;

public interface MesBuildingNestingTeamService extends IService<MesBuildingNestingTeam> {
   PageVO<MesBuildingNestingTeamDTO> page(Integer pageNumber, Integer pageSize);

   List<MesBuildingNestingTeamDTO> allMesBuildingNestingTeam(Long workshopId);

   MesBuildingNestingTeamDTO getByIdMesBuildingNestingTeam(Long id);

   void save(MesBuildingNestingTeamVO vo);

   void update(MesBuildingNestingTeamVO vo);

   void delete(MesBuildingNestingTeamVO vo);
}
