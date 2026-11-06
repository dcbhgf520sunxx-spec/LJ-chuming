package com.hzchum.scim.mes.building.core.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesBuildingBoChuNestingResultInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesNestingResultSteelPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingBoChuNestingResultMapper extends BaseMapper<MesBuildingBoChuNestingResult> {
   String getMaxFileName(@Param("prefix") String prefix);

   List<MesNestingResultSteelPlateDTO> listInfo(NestingResultQuery query);

   List<MesBuildingBoChuNestingResultInfoDTO> listByQueryCondition(NestingResultQuery query);
}
