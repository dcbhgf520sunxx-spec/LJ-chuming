package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MainMaterialTrackingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ArtifactProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportWastageDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.SteelReceiveRecordDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.WastageDO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.SysSteelAnalysisBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dto.steel.SteelAnalysisDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveDateDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveOutboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ReceiveReturnDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReceiveDateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainMaterialTrackingBizImpl implements MainMaterialTrackingBiz {
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private SysSteelAnalysisBiz sysSteelAnalysisBiz;
   @Autowired
   private MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   @Autowired
   private TechArtifactService techArtifactService;
   @Autowired
   private OutboundService outboundService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private ReportService reportService;

   @Override
   public Map<String, BigDecimal> summary(Long projectId) {
      Map<String, BigDecimal> result = new HashMap<>();
      List<Long> projectIds = new ArrayList<>();
      projectIds.add(projectId);
      List<SteelAnalysisDTO> analysis = this.sysSteelAnalysisBiz.analysis(projectId, null, null, null).getContent();
      BigDecimal reduce = analysis.stream().map(SteelAnalysisDTO::getUseMete).reduce(BigDecimal.ZERO, BigDecimal::add);
      result.put("plates", reduce);
      BigDecimal reduce1 = this.techArtifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getProjectId, projectId))
         .stream()
         .map(s -> s.getNetWeight().multiply(BigDecimal.valueOf(s.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      result.put("artifacts", reduce1);
      return result;
   }

   @Override
   public ListVO<KevMeteDO> artifactRecord(Long projectId, String year) {
      List<KevMeteDO> kevMeteDOS = this.completeService.listArtifactGroupByDate(year, projectId);
      Map<Integer, BigDecimal> map = new HashMap<>();

      for (KevMeteDO kevMeteDO : kevMeteDOS) {
         map.put(Integer.valueOf(kevMeteDO.getGroupKey() + ""), kevMeteDO.getMete());
      }

      for (int i = 1; i < 13; i++) {
         BigDecimal outMete = map.get(i);
         if (outMete == null) {
            map.put(i, BigDecimal.ZERO);
         }
      }

      List<KevMeteDO> collect = map.keySet().stream().map(s -> KevMeteDO.builder().mete(map.get(s)).groupKey(s + "").build()).collect(Collectors.toList());
      return new ListVO<>(collect);
   }

   @Override
   public ListVO<KevMeteDO> plateRecord(Long projectId, String year) {
      Preconditions.checkArgument(year != null && year != "", "请选择年份");
      LocalDateTime date = LocalDateTime.of(Integer.valueOf(year), 1, 1, 0, 0, 0, 0);
      Map<Integer, BigDecimal> meteByProjectId = this.outboundService.getMeteByProjectId(projectId, date);
      List<KevMeteDO> collect = new ArrayList<>();

      for (Integer key : meteByProjectId.keySet()) {
         KevMeteDO build = KevMeteDO.builder().groupKey(key + "").build();
         if (meteByProjectId.get(key).equals(BigDecimal.ZERO)) {
            build.setMete(BigDecimal.ZERO);
         } else {
            build.setMete(meteByProjectId.get(key).divide(BigDecimal.valueOf(1000L).setScale(4, RoundingMode.HALF_UP)));
         }

         collect.add(build);
      }

      return new ListVO<>(collect);
   }

   @Override
   public PageVO<ArtifactProductionDetailDO> artifactRecordDetail(Long projectId, String month, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactProductionDetailDO> artifacts = this.completeService.listArtifactByProjectIdAndMonth(projectId, month);
      return new PageVO<>(artifacts);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> artifactRecordDetailPrint(Long projectId, String month) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(this.completeService.listArtifactByProjectIdAndMonth(projectId, month).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<Object> plateRecordDetail(Long projectId, String month, Integer pageNumber, Integer pageSize) {
      return null;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> plateRecordDetailPrint(Long projectId, String month) {
      return null;
   }

   @Override
   public PageVO<WastageDO> wastage(Integer year, Integer status, List<Long> projectIds, List<Long> workShopIds, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(year != null, "请选择年份");
      PageHelper.startPage(pageNumber, pageSize);
      PageVO<ContractProject> pageVO = new PageVO<>(this.projectService.listWastage(null, status, projectIds));
      List<ContractProject> contractProjectList = pageVO.getContent();
      List<WastageDO> wastageDOList = new ArrayList<>();
      PageVO result = new PageVO<>(wastageDOList);
      result.setHasNextPage(pageVO.isHasNextPage());
      result.setHasPreviousPage(pageVO.isHasPreviousPage());
      result.setTotalElements(pageVO.getTotalElements());
      wastageDOList = this.getWastageDOList(year, workShopIds, contractProjectList, wastageDOList);
      result.setContent(wastageDOList);
      return result;
   }

   private List<WastageDO> getWastageDOList(Integer year, List<Long> workShopIds, List<ContractProject> contractProjectList, List<WastageDO> wastageDOList) {
      if (CollectionUtils.isNotEmpty(contractProjectList)) {
         for (ContractProject contractProject : contractProjectList) {
            WastageDO wastageDO = new WastageDO();
            Long projectId = contractProject.getId();
            List<Long> projectIds = new ArrayList<>();
            projectIds.add(projectId);
            QueryReceiveDateDTOParam queryReceiveDateDTOParam = new QueryReceiveDateDTOParam();
            queryReceiveDateDTOParam.setProjectIds(projectIds);
            queryReceiveDateDTOParam.setWorkShopIds(workShopIds);
            queryReceiveDateDTOParam.setYear(year);
            ReceiveDateDTO receiveDateDTO = this.reportService.getReceiveDate(queryReceiveDateDTOParam);
            List<ReceiveOutboundDetailDTO> plantOutboundDetailList = receiveDateDTO.getPlantOutboundDetailList();
            List<ReceiveOutboundDetailDTO> sectionOutboundDetailList = receiveDateDTO.getSectionOutboundDetailList();
            List<ReceiveReturnDetailDTO> plantReturnDetailList = receiveDateDTO.getPlantReturnDetailList();
            List<ReceiveReturnDetailDTO> sectionReturnDetailList = receiveDateDTO.getSectionReturnDetailList();
            plantOutboundDetailList.stream()
               .filter(s -> s.getProjectId().equals(contractProject.getId()))
               .forEach(s -> wastageDO.setSteelPicking(wastageDO.getSteelPicking().add(s.getMete())));
            sectionOutboundDetailList.stream()
               .filter(s -> s.getProjectId().equals(contractProject.getId()))
               .forEach(s -> wastageDO.setSectionPicking(wastageDO.getSectionPicking().add(s.getMete())));
            plantReturnDetailList.stream()
               .filter(s -> s.getProjectId().equals(contractProject.getId()))
               .forEach(s -> wastageDO.setSteelPlateReturn(wastageDO.getSteelPlateReturn().add(s.getMete())));
            sectionReturnDetailList.stream()
               .filter(s -> s.getProjectId().equals(contractProject.getId()))
               .forEach(s -> wastageDO.setSectionReturn(wastageDO.getSectionReturn().add(s.getMete())));
            BigDecimal listQuantity = this.techArtifactService.selectListQuantity(contractProject.getId());
            BigDecimal totalReceive = this.mesBuildingWarehouseSummaryService.selectTotalReceive(null, contractProject.getId(), workShopIds, year);
            if (null != totalReceive) {
               totalReceive = totalReceive.divide(new BigDecimal(1000), 5, 4);
               wastageDO.setTotalProduction(totalReceive);
            }

            if (null != listQuantity) {
               listQuantity = listQuantity.divide(new BigDecimal(1000), 5, 4);
               wastageDO.setListQuantity(listQuantity);
            }

            wastageDO.setProjectId(contractProject.getId());
            wastageDO.setCreateTime(contractProject.getCreateTime());
            wastageDO.setCreateTimeStr(DateUtil.format(contractProject.getCreateTime(), "yyyy-MM-dd"));
            wastageDO.setStatus(contractProject.getStatus());
            wastageDO.setProjectName(contractProject.getSerialNumber() + " " + contractProject.getShortName());
            wastageDO.setSteelPicking(wastageDO.getSteelPicking().divide(new BigDecimal(1000000), 5, 4));
            wastageDO.setSectionPicking(wastageDO.getSectionPicking().divide(new BigDecimal(1000000), 5, 4));
            wastageDO.setSteelPlateReturn(wastageDO.getSteelPlateReturn().divide(new BigDecimal(1000000), 5, 4));
            wastageDO.setSectionReturn(wastageDO.getSectionReturn().divide(new BigDecimal(1000000), 5, 4));
            wastageDO.setTotalReceive(
               wastageDO.getSteelPicking().subtract(wastageDO.getSteelPlateReturn()).add(wastageDO.getSectionPicking()).subtract(wastageDO.getSectionReturn())
            );
            wastageDO.setTotalWastage(wastageDO.getTotalProduction().subtract(wastageDO.getTotalReceive()));
            if (wastageDO.getTotalProduction().compareTo(BigDecimal.ZERO) == 0) {
               wastageDO.setWastageRate(BigDecimal.ZERO);
            } else {
               wastageDO.setWastageRate(
                  wastageDO.getTotalWastage().divide(wastageDO.getTotalProduction(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
               );
            }

            wastageDOList.add(wastageDO);
            Collections.sort(wastageDOList, Comparator.comparing(WastageDO::getSteelPicking).reversed());
         }
      }

      return wastageDOList;
   }

   @Override
   public void wastageExport(Integer year, Integer status, List<Long> projectIds, List<Long> workShopIds, HttpServletResponse response) {
      PageVO<ContractProject> pageVO = new PageVO<>(this.projectService.listWastage(null, status, projectIds));
      List<ContractProject> contractProjectList = pageVO.getContent();
      List<WastageDO> wastageDOList = new ArrayList<>();
      wastageDOList = this.getWastageDOList(year, workShopIds, contractProjectList, wastageDOList);
      String sheetName = "损耗统计";
      String fileName = "损耗统计.xlsx";
      String title = year + "年损耗统计";
      PoiUtils.exportExcel(wastageDOList, title, sheetName, WastageDO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public ReportWastageDO wastageCollect(Integer year, String status, List<Long> projectIds, List<Long> workShopIds) {
      Preconditions.checkArgument(year != null, "请选择年份");
      ReportWastageDO reportWastageDO = new ReportWastageDO();
      if (null != status) {
         projectIds = this.projectService
            .list((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().eq(ContractProject::getStatus, status))
            .stream()
            .map(ContractProject::getId)
            .collect(Collectors.toList());
         if (projectIds.size() == 0) {
            return reportWastageDO;
         }
      }

      BigDecimal totalYearProduction = this.mesBuildingWarehouseSummaryService.selectTotalReceive(projectIds, null, workShopIds, year);
      if (null != totalYearProduction) {
         totalYearProduction = totalYearProduction.divide(new BigDecimal(1000), 5, 4);
         reportWastageDO.setTotalYearProduction(totalYearProduction);
      }

      QueryReceiveDateDTOParam queryReceiveDateDTOParamYear = new QueryReceiveDateDTOParam();
      queryReceiveDateDTOParamYear.setYear(year);
      queryReceiveDateDTOParamYear.setProjectIds(projectIds);
      queryReceiveDateDTOParamYear.setWorkShopIds(workShopIds);
      ReceiveDateDTO receiveDateDTOYear = this.reportService.getReceiveDate(queryReceiveDateDTOParamYear);
      List<ReceiveOutboundDetailDTO> plantOutboundDetailYearList = receiveDateDTOYear.getPlantOutboundDetailList();
      plantOutboundDetailYearList.stream().forEach(s -> reportWastageDO.setTotalYearSteelPicking(reportWastageDO.getTotalYearSteelPicking().add(s.getMete())));
      List<ReceiveOutboundDetailDTO> sectionOutboundDetailYearList = receiveDateDTOYear.getSectionOutboundDetailList();
      sectionOutboundDetailYearList.stream()
         .forEach(s -> reportWastageDO.setTotalYearSteelPicking(reportWastageDO.getTotalYearSteelPicking().add(s.getMete())));
      reportWastageDO.setTotalYearSteelPicking(reportWastageDO.getTotalYearSteelPicking().divide(new BigDecimal(1000000), 5, 4));
      reportWastageDO.setTotalYearWastage(reportWastageDO.getTotalYearProduction().subtract(reportWastageDO.getTotalYearSteelPicking()));
      if (reportWastageDO.getTotalYearProduction().compareTo(BigDecimal.ZERO) == 0) {
         reportWastageDO.setTotalYearWastageRate(BigDecimal.ZERO);
      } else {
         reportWastageDO.setTotalYearWastageRate(
            reportWastageDO.getTotalYearWastage().divide(reportWastageDO.getTotalYearProduction(), 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
         );
      }

      return reportWastageDO;
   }

   @Override
   public PageVO<SteelReceiveRecordDO> steelReceive(Integer year, String status, List<Long> projectIds, List<Long> workShopIds) {
      QueryReceiveDateDTOParam queryReceiveDateDTOParamYear = new QueryReceiveDateDTOParam();
      queryReceiveDateDTOParamYear.setYear(year);
      queryReceiveDateDTOParamYear.setProjectIds(projectIds);
      queryReceiveDateDTOParamYear.setWorkShopIds(workShopIds);
      ReceiveDateDTO receiveDateDTO = this.reportService.getReceiveDate(queryReceiveDateDTOParamYear);
      if (null != receiveDateDTO) {
         List<ReceiveOutboundDetailDTO> plantOutboundDetailYearList = receiveDateDTO.getPlantOutboundDetailList();
         List<ReceiveOutboundDetailDTO> sectionOutboundDetailYearList = receiveDateDTO.getSectionOutboundDetailList();
         List<ReceiveReturnDetailDTO> plantReturnDetailYearList = receiveDateDTO.getPlantReturnDetailList();
         List<ReceiveReturnDetailDTO> sectionReturnDetailYearList = receiveDateDTO.getSectionReturnDetailList();
         List<SteelReceiveRecordDO> steelReceiveRecordDOList = new ArrayList<>();
         plantOutboundDetailYearList.stream().map(s -> {
            SteelReceiveRecordDO steelReceiveRecordDO = new SteelReceiveRecordDO();
            steelReceiveRecordDO.setType("出库");
            steelReceiveRecordDO.setSpecification(s.getSpecification());
            steelReceiveRecordDO.setTotal(s.getMete());
            steelReceiveRecordDO.setReceivePerson(s.getRecipientName());
            steelReceiveRecordDO.setHandlePerson(s.getApplicantName());
            steelReceiveRecordDO.setUseWorkshop(s.getWorkShop());
            steelReceiveRecordDO.setOutDate(DateUtil.format(s.getCreateTime(), "yyyy-MM-dd"));
            steelReceiveRecordDOList.add(steelReceiveRecordDO);
            return null;
         });
         sectionOutboundDetailYearList.stream().forEach(s -> {
            SteelReceiveRecordDO steelReceiveRecordDO = new SteelReceiveRecordDO();
            steelReceiveRecordDO.setType("出库");
            steelReceiveRecordDO.setSpecification(s.getSpecification());
            steelReceiveRecordDO.setTotal(s.getMete());
            steelReceiveRecordDO.setReceivePerson(s.getRecipientName());
            steelReceiveRecordDO.setHandlePerson(s.getApplicantName());
            steelReceiveRecordDO.setUseWorkshop(s.getWorkShop());
            steelReceiveRecordDO.setOutDate(DateUtil.format(s.getCreateTime(), "yyyy-MM-dd"));
            steelReceiveRecordDOList.add(steelReceiveRecordDO);
         });
         plantReturnDetailYearList.stream().forEach(s -> {
            SteelReceiveRecordDO steelReceiveRecordDO = new SteelReceiveRecordDO();
            steelReceiveRecordDO.setType("退库");
            steelReceiveRecordDO.setSpecification(s.getSpecification());
            steelReceiveRecordDO.setTotal(s.getMete());
            steelReceiveRecordDO.setHandlePerson(s.getApplicantName());
            steelReceiveRecordDO.setOutDate(DateUtil.format(s.getCreateTime(), "yyyy-MM-dd"));
            steelReceiveRecordDOList.add(steelReceiveRecordDO);
         });
         sectionReturnDetailYearList.stream().forEach(s -> {
            SteelReceiveRecordDO steelReceiveRecordDO = new SteelReceiveRecordDO();
            steelReceiveRecordDO.setType("退库");
            steelReceiveRecordDO.setSpecification(s.getSpecification());
            steelReceiveRecordDO.setTotal(s.getMete());
            steelReceiveRecordDO.setHandlePerson(s.getApplicantName());
            steelReceiveRecordDO.setOutDate(DateUtil.format(s.getCreateTime(), "yyyy-MM-dd"));
         });
      }

      return null;
   }

   @Override
   public PageVO<ProductionDetailDO> steelProduction(
      Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProductionDetailDO> productionDetailDOList = this.warehouseRecordService.steelProduction(year, startDate, endDate, projectId, workShopId);
      return new PageVO<>(productionDetailDOList);
   }

   @Override
   public BigDecimal recordTotalWeight(Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId) {
      BigDecimal totalWeight = this.warehouseRecordService.recordTotalWeight(year, startDate, endDate, projectId, workShopId);
      return totalWeight != null && totalWeight.compareTo(BigDecimal.ZERO) > 0 ? totalWeight.divide(new BigDecimal(1000), 5, 4) : new BigDecimal(0);
   }

   @Override
   public void exportSteelProduction(
      Integer year, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, HttpServletResponse response
   ) {
      List<ProductionDetailDO> productionDetailDOList = this.warehouseRecordService.steelProduction(year, startDate, endDate, projectId, workShopId);
      String sheetName = "钢材生产明细";
      String fileName = "钢材生产明细.xlsx";
      String title = "钢材生产明细";
      PoiUtils.exportExcel(productionDetailDOList, title, sheetName, ProductionDetailDO.class, fileName, ExcelType.XSSF, response);
   }
}
