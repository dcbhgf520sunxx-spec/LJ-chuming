package com.hzchum.scim.mes.building.core.service.impl.warehouse;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseInboundIssuedDepositedEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskPartPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppDispatchSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportArtifactDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.WarehouseReportEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.AppShipTimeDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.AppWarehouseRecordDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseReportDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingProductBoolChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TaskConditionByDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.DeliverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseReportSumDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.mapper.warehouse.MesBuildingWarehouseRecordMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechArtifactChangeDTO;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesBuildingWarehouseRecordServiceImpl
   extends ServiceImpl<MesBuildingWarehouseRecordMapper, MesBuildingWarehouseRecord>
   implements MesBuildingWarehouseRecordService {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Resource
   private MesBuildingFactoryService mesBuildingFactoryService;

   @Override
   public List<WarehouseReportDTO> listReport(WarehouseReportDOParam param) {
      String factoryName = null;
      if (param.getFactoryId() != null) {
         MesBuildingFactory factory = this.mesBuildingFactoryService.getById(param.getFactoryId());
         Preconditions.checkArgument(factory != null, "所选工厂不存在");
         factoryName = factory.getName();
      }

      List<WarehouseReportDO> result = new ArrayList<>();
      if (param.getProductType() == null) {
         param.setProductType(ProductTypeEnum.ARTIFACT.getType());
         List<WarehouseReportDO> artifactReports = this.baseMapper.listReportByCondition(param);
         result.addAll(artifactReports);
         param.setProductType(ProductTypeEnum.ENCLOSURE.getType());
         List<WarehouseReportDO> enclosureReports = this.baseMapper.listReportByCondition(param);
         result.addAll(enclosureReports);
      } else {
         result = this.baseMapper.listReportByCondition(param);
      }

      String finalFactoryName = factoryName;
      return result.stream()
         .filter(e -> e.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) || e.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType()))
         .map(e -> {
            WarehouseReportDTO copy = BeanUtil.copy(e, WarehouseReportDTO.class);
            copy.setFactoryName(finalFactoryName);
            if (ProductTypeEnum.ARTIFACT.getType().equals(e.getProductType())) {
               copy.setUnit("kg");
            } else {
               if (!ProductTypeEnum.ENCLOSURE.getType().equals(e.getProductType())) {
                  return null;
               }

               copy.setUnit("m");
               copy.setBeginMete(e.getBeginMete().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
               copy.setInboundMete(e.getInboundMete().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
               copy.setOutboundMete(e.getOutboundMete().divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP));
            }

            copy.setEndMete(copy.getBeginMete().add(copy.getInboundMete()).subtract(copy.getOutboundMete()));
            return copy;
         })
         .filter(
            e -> e.getBeginMete().compareTo(BigDecimal.ZERO) != 0
               || e.getInboundMete().compareTo(BigDecimal.ZERO) != 0
               || e.getOutboundMete().compareTo(BigDecimal.ZERO) != 0
         )
         .sorted(Comparator.comparing(e -> e.getId()))
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printReport(WarehouseReportDOParam param) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getStartDate() != null && param.getEndDate() != null) {
         List<LocalDateTime> dateList = new ArrayList<>();
         dateList.add(param.getStartDate());
         dateList.add(param.getEndDate());
         header.put("statisticsDate", dateList);
      }

      printVO.setHeader(header);
      printVO.setTable(this.listReport(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public WarehouseReportSumDTO sumReport(WarehouseReportDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "产品类型不能为空");
      List<WarehouseReportDTO> reports = this.listReport(param);
      BigDecimal beginMete = reports.stream().map(WarehouseReportDTO::getBeginMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal inboundMete = reports.stream().map(WarehouseReportDTO::getInboundMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal outboundMete = reports.stream().map(WarehouseReportDTO::getOutboundMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal endMete = reports.stream().map(WarehouseReportDTO::getEndMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      return WarehouseReportSumDTO.builder().beginMete(beginMete).inboundMete(inboundMete).outboundMete(outboundMete).endMete(endMete).build();
   }

   @Override
   public PageVO listArtifactReportDetail(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目不能为空");
      Preconditions.checkArgument(param.getType() != null, "类型不能为空");
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<WarehouseReportArtifactDO> result = this.baseMapper.listArtifactReportByCondition(param);
      result.stream().map(e -> {
         e.setTotalNetWeight(e.getNetWeight().multiply(e.getQuantity()));
         e.setTotalGrossWeight(e.getGrossWeight().multiply(e.getQuantity()));
         return result;
      }).collect(Collectors.toList());
      return new PageVO<>(result);
   }

   @Override
   public PageVO listEnclosureReportDetail(WarehouseReportDetailDOParam param) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目不能为空");
      Preconditions.checkArgument(param.getType() != null, "类型不能为空");
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      List<WarehouseReportEnclosureDO> result = this.baseMapper.listEnclosureReportByCondition(param);
      return new PageVO<>(result);
   }

   @Override
   public ListVO listArtifactRecordDetail(AppWarehouseRecordDOParam param) {
      return new ListVO<>(this.baseMapper.listArtifactRecordDetail(param));
   }

   @Override
   public ListVO listEnclosureRecordDetail(AppWarehouseRecordDOParam param) {
      return new ListVO<>(this.baseMapper.listEnclosureRecordDetail(param));
   }

   @Override
   public ListVO<ProductProjectSumDO> sumGroupByProject(AppShipTimeDOParam param) {
      return new ListVO<>(this.baseMapper.sumGroupByProject(param));
   }

   @Override
   public ProductMeteDO sumMeteByCondition(Long projectId, Long factoryId, Integer productType, Integer type, LocalDateTime startDate, LocalDateTime endDate) {
      return this.baseMapper.sumMeteByCondition(projectId, this.utilsBiz.getProjectIds(), factoryId, productType, type, startDate, endDate);
   }

   @Override
   public List<DeliverDTO> DeliverGroupByMonth(LocalDateTime dateTime) {
      return this.baseMapper.DeliverGroupByMonth(dateTime);
   }

   @Override
   public List<AppDispatchSumDO> dispatchSum(Long projectId, Long monomerId, Integer productType) {
      return this.baseMapper.dispatchSum(projectId, monomerId, productType);
   }

   @Override
   public PageVO<ProductWarehouseDTO> getProductPage(
      LocalDateTime dateTime,
      String productionLineName,
      String productName,
      String serialNumber,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.<ProductWarehouseDTO>startPage(pageNumber, pageSize)
            .doSelectPage(() -> this.getProductList(dateTime, productionLineName, productName, serialNumber, projectId, monomerId, areaId, productType))
      );
   }

   @Override
   public List<ProductWarehouseDTO> getProductList(
      LocalDateTime dateTime,
      String productionLineName,
      String productName,
      String serialNumber,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType
   ) {
      return this.baseMapper.getProductList(dateTime, productionLineName, productName, serialNumber, projectId, monomerId, areaId, productType);
   }

   @Override
   public List<WarehouseReportArtifactDO> finishArtifactReport(WarehouseReportDetailDOParam param) {
      List<Integer> productTypeList = new ArrayList<>();
      if ((param.getProductType() & ProductTypeEnum.ARTIFACT.getType()) > 0) {
         productTypeList.add(ProductTypeEnum.ARTIFACT.getType());
      }

      if ((param.getProductType() & ProductTypeEnum.ASSEMBLE.getType()) > 0) {
         productTypeList.add(ProductTypeEnum.ASSEMBLE.getType());
      }

      if ((param.getProductType() & ProductTypeEnum.MACHINE_PART.getType()) > 0) {
         productTypeList.add(ProductTypeEnum.MACHINE_PART.getType());
      }

      param.setProductTypeList(ListUtil.toList(productTypeList));
      List<WarehouseReportArtifactDO> doList = new ArrayList<>();
      if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())
         || (ProductTypeEnum.MACHINE_PART.getType() & param.getProductType()) > 0 && (ProductTypeEnum.ASSEMBLE.getType() & param.getProductType()) > 0) {
         if (WarehouseInboundIssuedDepositedEnum.INBOUND.getType() == param.getType()
            || WarehouseInboundIssuedDepositedEnum.OUTBOUND.getType() == param.getType()) {
            doList = this.baseMapper
               .finishArtifactReport(param)
               .stream()
               .sorted(Comparator.comparing(ArtifactBaseInfo::getTypeName, Comparator.nullsFirst(String::compareTo)))
               .collect(Collectors.toList());
         }

         if (WarehouseInboundIssuedDepositedEnum.STOCK.getType() == param.getType()) {
            doList = this.baseMapper
               .finishArtifactReportStock(param)
               .stream()
               .sorted(Comparator.comparing(ArtifactBaseInfo::getTypeName, Comparator.nullsFirst(String::compareTo)))
               .collect(Collectors.toList());
         }

         if (WarehouseInboundIssuedDepositedEnum.BEGINNING.getType() == param.getType()) {
            doList = this.baseMapper
               .finishArtifactReportBeginning(param)
               .stream()
               .sorted(Comparator.comparing(ArtifactBaseInfo::getTypeName, Comparator.nullsFirst(String::compareTo)))
               .collect(Collectors.toList());
         }

         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
            doList = doList.stream().peek(s -> s.setBoolShowSign(false)).collect(Collectors.toList());
         } else {
            doList = doList.stream().peek(s -> s.setBoolShowSign(true)).collect(Collectors.toList());
         }

         if (param.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()) && WarehouseInboundIssuedDepositedEnum.PACKAGE.getType() == param.getType()) {
            doList = this.baseMapper
               .finishArtifactPackReport(param)
               .stream()
               .sorted(Comparator.comparing(ArtifactBaseInfo::getTypeName, Comparator.nullsFirst(String::compareTo)))
               .collect(Collectors.toList());
         }
      }

      return doList;
   }

   @Override
   public List<WarehouseReportEnclosureDO> finishEnclosureReport(WarehouseReportDetailDOParam param) {
      if (param.getProductType().equals(ProductTypeEnum.ENCLOSURE.getType())) {
         if (WarehouseInboundIssuedDepositedEnum.INBOUND.getType() == param.getType()
            || WarehouseInboundIssuedDepositedEnum.OUTBOUND.getType() == param.getType()) {
            return this.baseMapper.finishEnclosureReport(param);
         }

         if (WarehouseInboundIssuedDepositedEnum.STOCK.getType() == param.getType()) {
            return this.baseMapper.finishEnclosureReportStock(param);
         }

         if (WarehouseInboundIssuedDepositedEnum.BEGINNING.getType() == param.getType()) {
            return this.baseMapper.finishEnclosureReportBeginning(param);
         }
      }

      return new ArrayList<>();
   }

   @Override
   public List<TechArtifactChangeDTO> listQuantityChanges(List<Long> changeIds) {
      return this.baseMapper.listQuantityChanges(changeIds);
   }

   @Override
   public List<TechArtifactChangeDTO> listWeightChanges(List<Long> changeIds) {
      return this.baseMapper.listWeightChanges(changeIds);
   }

   @Override
   public List<TaskPartPrintDO> listSendUnProcess(Long areaId, String name, String material, Long lineId, String specification, String serialNumber) {
      return this.baseMapper.listSendUnProcess(areaId, name, material, lineId, specification, serialNumber);
   }

   @Override
   public List<MesBuildingWarehouseRecord> findWarehouseRecordByProjectId(Long projectId) {
      return this.baseMapper.findWarehouseRecordByProjectId(projectId);
   }

   @Override
   public List<MesBuildingProductBoolChangeDTO> listBoolArtInCargo(List<NumberInfoDTO> changeList) {
      return this.baseMapper.listBoolArtInCargo(changeList);
   }

   @Override
   public List<MesBuildingProductBoolChangeDTO> listBoolAssInCargo(List<NumberInfoDTO> assNumbers) {
      return this.baseMapper.listBoolAssInCargo(assNumbers);
   }

   @Override
   public List<TaskPartPrintDO> sumlistSendUnProcess(
      Long areaId, Long areaBatchId, String name, String material, Long lineId, String specification, String serialNumber
   ) {
      return this.baseMapper.sumlistSendUnProcess(areaId, areaBatchId, name, material, lineId, specification, serialNumber);
   }

   @Override
   public List<ProductionDetailDO> steelProduction(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId) {
      return this.baseMapper.steelProduction(year, startDate, endDate, projectId, workShopId);
   }

   @Override
   public BigDecimal recordTotalWeight(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId) {
      return this.baseMapper.recordTotalWeight(year, startDate, endDate, projectId, workShopId);
   }

   @Override
   public List<TaskConditionByDateDTO> getEachWorkShopWarehouseRecord(LocalDateTime date) {
      return this.baseMapper.getEachWorkShopWarehouseRecord(date);
   }

   @Override
   public List<WorkShopTaskCompleteDetailDTO> findWorkshopCompletePercentageDetail(LocalDateTime date, Long workShopId) {
      return this.baseMapper.findWorkshopCompletePercentageDetail(date, workShopId);
   }
}
