package com.hzchum.scim.rest.runner.onecode;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfigDetail;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
public class MesSectionWarehouseConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesSectionWarehouseConfigRunner.class);
   @Resource
   private MesSectionWarehouseConfigDetailService warehouseConfigDetailService;
   @Resource
   private SysStructureClassificationService classificationService;

   @Override
   public void run(String... args) throws Exception {
      List<String> productTypeList = Arrays.asList("预埋件", "埋件", "平台板", "直发件", "钢板墙", "异型构件", "定位板", "折弯件", "檩托板,檩托", "直发件类", "钢板制品");
      List<MesSectionWarehouseConfigDetail> warehouseConfigDetailList = this.warehouseConfigDetailService
         .list(
            (Wrapper<MesSectionWarehouseConfigDetail>)(new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>()
                  .eq(MesSectionWarehouseConfigDetail::getProductType, ProductTypeEnum.ARTIFACT.getType()))
               .eq(MesSectionWarehouseConfigDetail::getProductSectionNameEnum, ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         );
      if (CollectionUtils.isNotEmpty(warehouseConfigDetailList)) {
         for (MesSectionWarehouseConfigDetail detail : warehouseConfigDetailList) {
            if (productTypeList.contains(detail.getName()) && detail.getBoolComposeAssemble()) {
               detail.setBoolComposeAssemble(Boolean.FALSE);
               this.warehouseConfigDetailService.updateById(detail);
            }
         }
      }

      List<SysStructureClassification> structureClassifications = this.classificationService
         .list(
            (Wrapper<SysStructureClassification>)new LambdaQueryWrapper<SysStructureClassification>().eq(SysStructureClassification::getMesProductEnum, MesProductEnum.BUILDING.getType())
         );
      if (CollectionUtils.isNotEmpty(structureClassifications)) {
         for (SysStructureClassification classification : structureClassifications) {
            if (productTypeList.contains(classification.getClassificationName()) && classification.getBoolComposeAssemble()) {
               classification.setBoolComposeAssemble(Boolean.FALSE);
               this.classificationService.updateById(classification);
            }
         }
      }
   }

   public MesSectionWarehouseConfigRunner(
      final MesSectionWarehouseConfigDetailService warehouseConfigDetailService, final SysStructureClassificationService classificationService
   ) {
      this.warehouseConfigDetailService = warehouseConfigDetailService;
      this.classificationService = classificationService;
   }
}
