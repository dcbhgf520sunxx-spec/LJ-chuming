package com.hzchum.scim.mes.building.core.mapper.temp_work;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustProductQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesWageAdjustProductMapper extends BaseMapper<MesWageAdjustProduct> {
   List<MesWageAdjustProductDTO> listInfoByWageAdjustId(@Param("wageAdjustId") Long wageAdjustId, @Param("productTypeEnum") Integer productTypeEnum);

   List<MesWageAdjustProductDTO> listInfo(MesWageAdjustProductQuery query);
}
