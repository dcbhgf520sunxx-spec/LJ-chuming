package com.hzchum.scim.mes.building.core.service.impl.record;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingProductProductionSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProductAnalysisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryTaskDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductDetailsAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis.ProductGroupAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.mapper.record.MesBuildingProductProductionSummaryMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductProductionSummaryServiceImpl
   extends ServiceImpl<MesBuildingProductProductionSummaryMapper, MesBuildingProductProductionSummary>
   implements MesBuildingProductProductionSummaryService {
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;

   @Override
   @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
   public boolean updateRecord(ProductProductionSummaryDTOParam param) {
      return this.updateRecordForMonth(param, DateTimeUtil.getLocalMonthStr());
   }

   @Override
   @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
   public boolean updateRecordForMonth(ProductProductionSummaryDTOParam param, String month) {
      // Same increment rule as recovered MesBuildingTaskFastBizImpl.updateRecordFast.
      com.google.common.base.Preconditions.checkArgument(month != null && month.matches("[0-9]{4}-[0-9]{2}"), "生产汇总月份不正确");
      com.google.common.base.Preconditions.checkArgument(param != null && param.getProductId() != null && param.getProductType() != null,
         "生产汇总产品参数不能为空");
      MesBuildingProductProductionSummary summary = this.getSummaryByCondition(param.getProductId(), param.getProductType(), month);
      if (summary == null) {
         summary = MesBuildingProductProductionSummary.builder().build();
         summary.setProjectId(param.getProjectId());
         summary.setMonomerId(param.getMonomerId());
         summary.setProductId(param.getProductId());
         summary.setProductType(param.getProductType());
         summary.setTaskQuantity(param.getTaskQuantity());
         summary.setCompleteQuantity(param.getCompleteQuantity());
         summary.setInProductionQuantity(param.getInProductionQuantity());
         summary.setMonth(month);
         com.google.common.base.Preconditions.checkState(this.save(summary), "生产汇总写入失败，请刷新后重试");
         return true;
      }
      summary.setTaskQuantity(summary.getTaskQuantity() + param.getTaskQuantity());
      summary.setCompleteQuantity(summary.getCompleteQuantity() + param.getCompleteQuantity());
      summary.setInProductionQuantity(summary.getInProductionQuantity() + param.getInProductionQuantity());
      com.google.common.base.Preconditions.checkState(this.updateById(summary), "生产汇总更新失败，请刷新后重试");
      return true;
   }

   @Override
   public boolean updateTaskQuantity(ProductProductionSummaryTaskDTOParam param) {
      return false;
   }

   @Override
   @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
   public void statLastMonthProductionSummary() {
      String previousMonth = DateTimeUtil.getLastMonthStr();
      String month = DateTimeUtil.getLocalMonthStr();
      List<MesBuildingProductProductionSummary> summaries = this.baseMapper.selectList(
         Wrappers.lambdaQuery(MesBuildingProductProductionSummary.class)
            .eq(MesBuildingProductProductionSummary::getMonth, previousMonth)
            .orderByAsc(MesBuildingProductProductionSummary::getProductId)
            .orderByAsc(MesBuildingProductProductionSummary::getProductType).last("FOR UPDATE"));
      for (MesBuildingProductProductionSummary item : summaries) {
         int remaining = item.getBeginQuantity() + item.getTaskQuantity() - item.getCompleteQuantity();
         if (remaining <= 0) {
            continue;
         }
         int inProductionCarry = item.getInProductionQuantity() - item.getCompleteQuantity();
         MesBuildingProductProductionSummary current = this.getSummaryByCondition(item.getProductId(), item.getProductType(), month);
         if (current == null) {
            current = new MesBuildingProductProductionSummary();
            current.setProjectId(item.getProjectId());
            current.setMonomerId(item.getMonomerId());
            current.setProductId(item.getProductId());
            current.setProductType(item.getProductType());
            current.setBeginQuantity(remaining);
            current.setInProductionQuantity(inProductionCarry);
            current.setMonth(month);
            com.google.common.base.Preconditions.checkState(this.save(current), "生产月结写入失败");
         } else {
            // Do not infer whether an existing historical beginning balance was already carried.
            // The scheduler's same-transaction monthly ledger prevents repeat executions going forward.
            com.google.common.base.Preconditions.checkState(current.getBeginQuantity() == 0,
               "生产期初已存在，请核实原月结记录");
            current.setBeginQuantity(remaining);
            current.setInProductionQuantity(current.getInProductionQuantity() + inProductionCarry);
            com.google.common.base.Preconditions.checkState(this.updateById(current), "生产月结更新失败");
         }
      }
   }

   private MesBuildingProductProductionSummary getSummaryByCondition(Long productId, Integer productType, String month) {
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(MesBuildingProductProductionSummary.class)
         .eq(MesBuildingProductProductionSummary::getProductId, productId)
         .eq(MesBuildingProductProductionSummary::getProductType, productType)
         .eq(MesBuildingProductProductionSummary::getMonth, month).last("FOR UPDATE"));
   }

   @Override
   public ProductAnalysisDTO productionSummary(ProductAnalysisDOParam param) {
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ProductAnalysisDTO.builder().artifactAnalysis(this.baseMapper.productionArtifactSummary(param)).build();
      } else if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return ProductAnalysisDTO.builder().enclosureAnalysis(this.baseMapper.productionEnclosureSummary(param)).build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public ProductGroupAnalysisDTO productionGroup(ProductAnalysisDOParam param) {
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ProductGroupAnalysisDTO.builder().artifactAnalysisList(this.baseMapper.productionArtifactGroup(param)).build();
      } else if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return ProductGroupAnalysisDTO.builder().enclosureAnalysisList(this.baseMapper.productionEnclosureGroup(param)).build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productionGroupPrint(ProductAnalysisDOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getMonomerId() != null) {
         PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
         header.put("monomer", BeanUtil.copy(monomer, NameInfo.class));
      }

      header.put("date", param.getDateTime());
      printVO.setHeader(header);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         printVO.setTable(this.baseMapper.productionArtifactGroup(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      } else {
         if (!param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("操作失败：产品类型不正确");
         }

         printVO.setTable(this.baseMapper.productionEnclosureGroup(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public ProductDetailsAnalysisDTO productCompleteDetails(ProductAnalysisDOParam dtoParam) {
      dtoParam.setProjectIds(this.utilsBiz.getProjectIds());
      if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ProductDetailsAnalysisDTO.builder().artifactDetailsAnalysisDTOList(this.baseMapper.productionArtifactCompleteDetails(dtoParam)).build();
      } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return ProductDetailsAnalysisDTO.builder().enclosureDetailsAnalysisList(this.baseMapper.productionEnclosureCompleteDetails(dtoParam)).build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productCompleteDetailsPrint(ProductAnalysisDOParam param) {
      param.setProjectIds(this.utilsBiz.getProjectIds());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         printVO.setTable(this.baseMapper.productionArtifactCompleteDetails(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      } else {
         if (!param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("操作失败：产品类型不正确");
         }

         printVO.setTable(this.baseMapper.productionEnclosureCompleteDetails(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public ProductDetailsAnalysisDTO productInProductionDetails(ProductAnalysisDOParam dtoParam) {
      dtoParam.setProjectIds(this.utilsBiz.getProjectIds());
      if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ProductDetailsAnalysisDTO.builder()
            .artifactDetailsAnalysisDTOList(this.baseMapper.productionArtifactInProductionDetails(dtoParam).stream().peek(e -> {
               dtoParam.setProductId(e.getId());
               e.setProcessSummaryList(this.getProcessSummaryDetailsDO(dtoParam));
            }).collect(Collectors.toList()))
            .build();
      } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return ProductDetailsAnalysisDTO.builder()
            .enclosureDetailsAnalysisList(this.baseMapper.productionEnclosureInProductionDetails(dtoParam).stream().peek(e -> {
               dtoParam.setProductId(e.getId());
               e.setProcessSummaryList(this.getProcessSummaryDetailsDO(dtoParam));
            }).collect(Collectors.toList()))
            .build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productInProductionDetailsPrint(ProductAnalysisDOParam param) {
      param.setProjectIds(this.utilsBiz.getProjectIds());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         printVO.setTable(this.baseMapper.productionArtifactDetails(param).stream().map(item -> {
            param.setProductId(item.getId());
            item.setProcessSummaryList(this.getProcessSummaryDetailsDO(param));
            return BeanUtil.beanToMap(item);
         }).collect(Collectors.toList()));
      } else {
         if (!param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("操作失败：产品类型不正确");
         }

         printVO.setTable(this.baseMapper.productionEnclosureDetails(param).stream().map(item -> {
            param.setProductId(item.getId());
            item.setProcessSummaryList(this.getProcessSummaryDetailsDO(param));
            return BeanUtil.beanToMap(item);
         }).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public ProductDetailsAnalysisDTO productUnProductionDetails(ProductAnalysisDOParam dtoParam) {
      dtoParam.setProjectIds(this.utilsBiz.getProjectIds());
      if (dtoParam.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         return ProductDetailsAnalysisDTO.builder().artifactDetailsAnalysisDTOList(this.baseMapper.productionArtifactUnProductionDetails(dtoParam)).build();
      } else if (dtoParam.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return ProductDetailsAnalysisDTO.builder().enclosureDetailsAnalysisList(this.baseMapper.productionEnclosureUnProductionDetails(dtoParam)).build();
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> productUnProductionDetailsPrint(ProductAnalysisDOParam param) {
      param.setProjectIds(this.utilsBiz.getProjectIds());
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         printVO.setTable(this.baseMapper.productionArtifactUnProductionDetails(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      } else {
         if (!param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
            throw new IllegalArgumentException("操作失败：产品类型不正确");
         }

         printVO.setTable(this.baseMapper.productionEnclosureUnProductionDetails(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   private List<ProcessSummaryDetailsDO> getProcessSummaryDetailsDO(ProductAnalysisDOParam dtoParam) {
      List<ProcessSummaryDetailsDO> processSummaryDetailsDOS = this.baseMapper.processSummary(dtoParam);
      Integer quantity = this.baseMapper.getCompleteQuantity(dtoParam);
      processSummaryDetailsDOS = processSummaryDetailsDOS.stream()
         .map(e -> e.setInspectionQuantity(e.getInspectionQuantity() - quantity))
         .collect(Collectors.toList());

      for (int i = 0; i <= processSummaryDetailsDOS.size() - 2; i++) {
         processSummaryDetailsDOS.get(i)
            .setInspectionQuantity(processSummaryDetailsDOS.get(i).getInspectionQuantity() - processSummaryDetailsDOS.get(i + 1).getInspectionQuantity());
      }

      return processSummaryDetailsDOS.stream().filter(e -> e.getInspectionQuantity() > 0).collect(Collectors.toList());
   }
}
