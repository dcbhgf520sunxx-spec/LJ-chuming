package com.hzchum.scim.mes.building.core.api.service.report_work;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustProductQuery;
import java.util.List;

public interface MesWageAdjustProductService extends IService<MesWageAdjustProduct> {
   List<MesWageAdjustProductDTO> listInfoByWageAdjustId(Long wageAdjustId, Integer productTypeEnum);

   List<MesWageAdjustProductDTO> listInfo(MesWageAdjustProductQuery query);
}
