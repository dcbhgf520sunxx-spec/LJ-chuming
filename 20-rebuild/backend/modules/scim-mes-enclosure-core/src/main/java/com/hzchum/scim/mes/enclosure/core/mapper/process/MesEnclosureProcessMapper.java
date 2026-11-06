package com.hzchum.scim.mes.enclosure.core.mapper.process;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.MesEnclosureProcessDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesEnclosureProcessMapper extends BaseMapper<MesEnclosureProcess> {
   List<MesEnclosureProcess> listByUserId(@Param("type") Boolean type, @Param("userId") Long userId);

   List<MesEnclosureProcess> listByProductionLineId(@Param("productionLineId") Long productionLineId, @Param("productType") Integer productType);

   List<MesEnclosureProcess> selectProcessByLine(@Param("productionLineId") Long productionLineId);

   List<MesEnclosureProcessDTO> getWorkshopByProcessList(@Param("workshopId") Long workshopId);
}
