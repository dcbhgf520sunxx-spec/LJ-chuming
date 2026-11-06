package com.hzchum.scim.mes.building.core.api.biz.quota_config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import java.util.List;
import java.util.Map;

public interface MesTeamSalaryBiz {
   Map<String, Object> summary(MesTeamSalaryQuery query);

   PageVO<MesTeamSalaryDTO> pageInfo(MesTeamSalaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   PrintVO<List<Map<String, Object>>> print(MesTeamSalaryQuery query);

   List<MesTeamSalaryTeamProductionDTO> teamProductionList(MesTeamSalaryQuery query);

   PrintVO<List<Map<String, Object>>> teamProductionListPrint(MesTeamSalaryQuery query);
}
