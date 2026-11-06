package com.hzchum.scim.mes.building.core.biz.impl.productionAnalysis;

import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.mes.building.core.api.biz.productionAnalysis.ProductionAnalysisBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.HysteresisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ArtifactAssembleHysteresisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ArtifactAssembleHysteresisDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.EnclosureHysteresisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.EnclosureHysteresisDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.HysteresisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.HysteresisDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionAnalysis.HysteresisDTOParam;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.enums.EnclosureCategoryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionAnalysisBizImpl implements ProductionAnalysisBiz {
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @Override
   public HysteresisDTO hysteresisSummaryList(HysteresisDTOParam dtoParam) {
      if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         || dtoParam.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())
         || dtoParam.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
         return HysteresisDTO.builder()
            .artifactAssembleList(
               this.taskService
                  .hysteresisSummaryList(BeanUtil.copy(dtoParam, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
                  .stream()
                  .map(e -> BeanUtil.copy(e, ArtifactAssembleHysteresisDTO.class))
                  .collect(Collectors.toList())
            )
            .build();
      } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return HysteresisDTO.builder()
            .enclosureList(
               this.taskService
                  .hysteresisSummaryList(BeanUtil.copy(dtoParam, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
                  .stream()
                  .map(e -> BeanUtil.copy(e, EnclosureHysteresisDTO.class))
                  .collect(Collectors.toList())
            )
            .build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public HysteresisDetailsDTO hysteresisList(HysteresisDTOParam dtoParam) {
      if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         || dtoParam.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())
         || dtoParam.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         return HysteresisDetailsDTO.builder()
            .artifactAssembleList(
               this.taskService
                  .hysteresisList(BeanUtil.copy(dtoParam, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
                  .stream()
                  .map(e -> BeanUtil.copy(e, ArtifactAssembleHysteresisDetailsDTO.class))
                  .collect(Collectors.toList())
            )
            .build();
      } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return HysteresisDetailsDTO.builder()
            .enclosureList(
               this.taskService
                  .hysteresisList(BeanUtil.copy(dtoParam, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds()))
                  .stream()
                  .map(e -> BeanUtil.copy(e, EnclosureHysteresisDetailsDTO.class))
                  .collect(Collectors.toList())
            )
            .build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> hysteresisListPrint(HysteresisDTOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getDateTime() != null) {
         header.put("date", DateTimeUtil.getLocalMonthStr(param.getDateTime()));
      }

      if (param.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         header.put("productType", "构件一次工序");
      } else if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         header.put("productType", "构件二次工序");
      } else if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         header.put("productType", ProductTypeEnum.getNameByType(param.getProductType()) + EnclosureCategoryEnum.getNameByCategory(param.getCategory()));
      }

      printVO.setHeader(header);
      if (!param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         && !param.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())
         && !param.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         if (!param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("操作失败：产品类型不正确");
         }

         printVO.setTable(
            this.taskService.hysteresisList(BeanUtil.copy(param, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds())).stream().map(e -> {
               Map<String, Object> result = BeanUtil.beanToMap(e);
               result.put("productType", param.getProductType());
               return result;
            }).collect(Collectors.toList())
         );
      } else {
         printVO.setTable(
            this.taskService.hysteresisList(BeanUtil.copy(param, HysteresisDOParam.class).setProjectIds(this.utilsBiz.getProjectIds())).stream().map(e -> {
               Map<String, Object> result = BeanUtil.beanToMap(e);
               result.put("productType", param.getProductType());
               return result;
            }).collect(Collectors.toList())
         );
      }

      return printVO;
   }
}
