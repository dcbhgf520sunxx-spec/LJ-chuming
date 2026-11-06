package com.hzchum.scim.mes.enclosure.core.mapper.factory;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.product.ProductProcessDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory.MesEnclosureTeamDOParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureTeamMapper extends BaseMapper<MesEnclosureTeam> {
   List<MesEnclosureTeam> getTeamByProductionLineIdAndProcessIdAndUserId(
      @Param("productionLineId") Long productionLineId, @Param("processId") Long processId, @Param("userId") Long userId, @Param("ids") List<Long> ids
   );

   List<ProductProcessDO> listTeamSimple(Long productionLineId);

   List<ProductProcessDO> listTeamUser(@Param("productionLineId") Long productionLineId, @Param("currentUserId") Long currentUserId);

   List<MesEnclosureTeam> listByCondition(MesEnclosureTeamDOParam doParam);

   List<IdAndNameDO> listNameByIds(@Param("teamIds") List<Long> teamIds);
}
