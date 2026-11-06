package com.hzchum.scim.mes.building.core.mapper.report_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesWageAdjustMapper extends BaseMapper<MesWageAdjust> {
   List<MesWageAdjustDTO> listInfo(MesWageAdjustQuery query);

   MesWageAdjustDTO detailById(@Param("id") Long id);
}
