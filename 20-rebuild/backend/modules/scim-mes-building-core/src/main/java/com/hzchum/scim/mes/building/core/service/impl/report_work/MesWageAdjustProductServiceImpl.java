package com.hzchum.scim.mes.building.core.service.impl.report_work;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustProductQuery;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustProductService;
import com.hzchum.scim.mes.building.core.mapper.temp_work.MesWageAdjustProductMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesWageAdjustProductServiceImpl extends ServiceImpl<MesWageAdjustProductMapper, MesWageAdjustProduct> implements MesWageAdjustProductService {
   @Override
   public List<MesWageAdjustProductDTO> listInfoByWageAdjustId(Long wageAdjustId, Integer productTypeEnum) {
      return this.baseMapper.listInfoByWageAdjustId(wageAdjustId, productTypeEnum);
   }

   @Override
   public List<MesWageAdjustProductDTO> listInfo(MesWageAdjustProductQuery query) {
      return this.baseMapper.listInfo(query);
   }
}
