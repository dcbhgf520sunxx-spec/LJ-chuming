package com.hzchum.scim.mes.building.core.service.impl.wages;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.AuditDetailsListDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductClassifyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingWagesChange;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.PriceDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.ProductClassifyDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.ProductDOParam;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingWagesChangeService;
import com.hzchum.scim.mes.building.core.mapper.wages.MesBuildingWagesChangeMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWagesChangeServiceImpl
   extends ServiceImpl<MesBuildingWagesChangeMapper, MesBuildingWagesChange>
   implements MesBuildingWagesChangeService {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @Override
   public List<DistributionProductDO> distributionComplete(PriceDOParam copy) {
      return this.baseMapper.distributionComplete(copy);
   }

   @Override
   public List<ProductClassifyDO> productClassifyList(ProductClassifyDOParam doParam) {
      return this.baseMapper.productClassifyList(doParam);
   }

   @Override
   public List<ProductDO> productList(ProductDOParam doParam) {
      return this.baseMapper.productList(doParam);
   }

   @Override
   public List<AuditDetailsListDO> auditDetailsList(Long id) {
      return this.baseMapper.auditDetailsList(id);
   }

   @Override
   public List<ProcessPriceDO> processPriceCount(PriceDOParam doParam) {
      return this.baseMapper.processPriceCount(doParam);
   }

   @Override
   public BigDecimal reckonSummary(Long projectId, Long factoryId, Integer productType, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.reckonSummary(projectId, this.utilsBiz.getProjectIds(), factoryId, productType, startDate, endDate);
   }
}
