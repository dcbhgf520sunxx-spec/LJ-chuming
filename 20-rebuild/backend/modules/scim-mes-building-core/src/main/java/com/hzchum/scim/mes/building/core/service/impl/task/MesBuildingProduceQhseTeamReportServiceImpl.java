package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingInspectionTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.process.MesBuildingProcessBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProcessProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProduceQhseDo;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.ProductLineInspectionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.InspectionTeamReportSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProduceQhseTeamReportMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProduceQhseTeamReportServiceImpl
   extends ServiceImpl<MesBuildingProduceQhseTeamReportMapper, MesBuildingProduceQhseTeamReport>
   implements MesBuildingProduceQhseTeamReportService {
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingProcessBiz mesBuildingProcessBiz;
   @Autowired
   private MesBuildingProductionLineBiz mesBuildingProductionLineBiz;
   @Autowired
   private MesBuildingInspectionTeamBiz mesBuildingInspectionTeamBiz;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private SysDictionaryService sysDictionaryService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;

   @Override
   public List<InspectionTeamReportSummaryDO> inspectionTeamReportSummary(LocalDateTime startDate, LocalDateTime endDate, Long projectId, Integer productType) {
      return this.baseMapper.inspectionTeamReportSummary(startDate, endDate, projectId, this.utilsBiz.getProjectIds(), productType);
   }

   @Override
   public PageVO<InspectionTeamReportSummaryDO> inspectionTeamReportSummaryPage(
      LocalDateTime startDate, LocalDateTime endDate, Long projectId, Integer productType, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.utilsBiz.getProjectIds();
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize), this.baseMapper.inspectionTeamReportSummary(startDate, endDate, projectId, projectIds, productType)
      );
   }

   @Override
   public List<InspectionTeamReportSummaryDetailsDO> inspectionTeamReportSummaryDetails(
      Long userId, String projectName, String serialNumber, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   ) {
      return this.baseMapper
         .inspectionTeamReportSummaryDetails(userId, projectName, serialNumber, null, projectId, this.utilsBiz.getProjectIds(), startDate, endDate, productType);
   }

   @Override
   public PageVO<InspectionTeamReportSummaryDetailsDO> inspectionTeamReportSummaryDetailsPage(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productType,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> projectIds = this.utilsBiz.getProjectIds();
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.baseMapper.newInspectionTeamReportSummary(userId, projectName, serialNumber, processId, projectId, projectIds, startDate, endDate, productType)
      );
   }

   @Override
   public List<InspectionTeamReportSummaryDetailsDO> inspectionReportSummaryDetails(
      Long userId, String projectName, String serialNumber, Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   ) {
      return this.baseMapper
         .inspectionReportSummaryDetails(userId, projectName, serialNumber, projectId, type, this.utilsBiz.getProjectIds(), startDate, endDate, productType);
   }

   @Override
   public Boolean inspectionTeamReportSummaryDetailsPrint(
      Long userId,
      String projectName,
      String serialNumber,
      Long processId,
      Long projectId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productType,
      HttpServletResponse response
   ) {
      Map<String, Object> map = new HashMap<>(2);
      List<Long> projectIds = this.utilsBiz.getProjectIds();
      List<InspectionTeamReportSummaryDetailsDO> detailsDOS = this.baseMapper
         .newInspectionTeamReportSummary(userId, projectName, serialNumber, processId, projectId, projectIds, startDate, endDate, productType);
      String resourcePath = "template/InspectionTeamReportExportTemplate.xlsx";
      String tempFileName = "InspectionTeamReportExportTemplate";
      String exportFileName = "质检详情报表.xlsx";
      this.saveInspectionTeamReportDetails(map, detailsDOS);
      map.put("inspectionUserName", this.userService.getNameById(userId));
      ClassPathResource resource = new ClassPathResource(resourcePath);
      File file = null;

      try (InputStream inputStream = resource.getInputStream()) {
         file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
      } catch (IOException e) {
         e.printStackTrace();
      }

      TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
      Workbook workbook = ExcelExportUtil.exportExcel(params, map);
      PoiUtils.downLoadExcel(exportFileName, response, workbook);
      return Boolean.TRUE;
   }

   private void saveInspectionTeamReportDetails(Map<String, Object> map, List<InspectionTeamReportSummaryDetailsDO> detailsDOS) {
      List<Map<String, Object>> inspectionTeamReportList = new ArrayList<>();
      AtomicInteger id = new AtomicInteger(1);
      detailsDOS.forEach(s -> {
         HashMap<String, Object> planMap = new HashMap<>(16);
         planMap.put("id", id.getAndIncrement());
         planMap.put("project", s.getProject().getSerialNumber() + " " + s.getProject().getShortName());
         planMap.put("name", s.getName());
         planMap.put("serialNumber", s.getSerialNumber());
         planMap.put("processName", s.getProcessName());
         planMap.put("inspectionQuantity", s.getInspectionQuantity());
         planMap.put("qhseQuantity", s.getQhseQuantity());
         planMap.put("date", s.getDate());
         inspectionTeamReportList.add(planMap);
      });
      map.put("inspectionTeamReportList", inspectionTeamReportList);
   }

   @Override
   public Map<Long, String> inspectionTeamReportSummaryProcessList(
      Long userId, String projectName, String serialNumber, Long projectId, LocalDateTime startDate, LocalDateTime endDate, Integer productType
   ) {
      return this.inspectionTeamReportSummaryDetails(userId, projectName, serialNumber, projectId, startDate, endDate, productType)
         .stream()
         .collect(
            Collectors.toMap(
               InspectionTeamReportSummaryDetailsDO::getProcessId,
               InspectionTeamReportSummaryDetailsDO::getProcessName,
               (existingValue, newValue) -> existingValue
            )
         );
   }

   @Override
   public List<ProductLineInspectionDO> productLinePassRate(
      String factoryId,
      String productionLineId,
      Integer productType,
      String workShopId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new ArrayList<>();
   }

   @Override
   public List<ProduceQhseDo> unQualInformation(
      Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingTask> taskList = this.taskService
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getProductionLineId, productionLineId));
      List<ProduceQhseDo> produceQhseDos = this.baseMapper
         .selectQhseTeamReport(
            taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()),
            productType == null ? ProcessProductTypeEnum.ARTIFACT_PROCESS.getType() : productType,
            startDate,
            endDate,
            productionLineId,
            null
         );
      if (CollectionUtils.isEmpty(produceQhseDos)) {
         return produceQhseDos;
      }

      List<Long> reportNumbers = produceQhseDos.stream().map(s -> s.getReportNumber()).distinct().collect(Collectors.toList());
      List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
               .in(MesBuildingProduceInspectionTeamReport::getInspectReportNumber, reportNumbers)
         );
      Map<Long, Integer> reportNumbreMap = reports.stream().collect(Collectors.toMap(s -> s.getInspectReportNumber(), s -> s.getNumber(), (s1, s2) -> s1));
      if (CollectionUtils.isNotEmpty(produceQhseDos)) {
         for (ProduceQhseDo dto : produceQhseDos) {
            StringBuilder stringBuilder = new StringBuilder(dto.getArtifactSerialNumber());
            if (dto.getBoolOneCode().equals(1)) {
               Integer number = reportNumbreMap.get(dto.getReportNumber());
               stringBuilder.append(dto.getNumber() == null ? "" : "/" + number);
            }

            dto.setArtifactSerialNumber(stringBuilder + "");
            dto.setQualityType(this.changType(dto.getQualityType()));
         }
      }

      return produceQhseDos;
   }

   @Override
   public PrintVO unQualInformationPrint(Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticsDate", System.currentTimeMillis());
      header.put("productionLineName", this.mesBuildingProductionLineBiz.selectByid(productionLineId).getName());
      printVO.setHeader(header);
      List<ProduceQhseDo> tasblse = this.unQualInformation(productionLineId, productType, startDate, endDate, null, null);
      List<Map<String, Object>> mapList = tasblse.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PageVO<ProduceQhseDo> unQualInformationPage(
      Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   ) {
      List<MesBuildingTask> taskList = this.taskService
         .list(Wrappers.lambdaQuery(MesBuildingTask.class).eq(MesBuildingTask::getProductionLineId, productionLineId));
      if (CollectionUtils.isEmpty(taskList)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProduceQhseDo> produceQhseDos = this.baseMapper
         .selectQhseTeamReport(
            taskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()),
            productType == null ? ProcessProductTypeEnum.ARTIFACT_PROCESS.getType() : productType,
            startDate,
            endDate,
            productionLineId,
            null
         );
      PageVO<ProduceQhseDo> pageVO = new PageVO<>(produceQhseDos);
      if (CollectionUtils.isEmpty(produceQhseDos)) {
         return pageVO;
      }

      List<Long> reportNumbers = produceQhseDos.stream().map(s -> s.getReportNumber()).distinct().collect(Collectors.toList());
      List<MesBuildingProduceInspectionTeamReport> reports = this.inspectionTeamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceInspectionTeamReport.class)
               .in(MesBuildingProduceInspectionTeamReport::getInspectReportNumber, reportNumbers)
         );
      Map<Long, Integer> reportNumbreMap = reports.stream().collect(Collectors.toMap(s -> s.getInspectReportNumber(), s -> s.getNumber(), (s1, s2) -> s1));
      if (CollectionUtils.isNotEmpty(produceQhseDos)) {
         for (ProduceQhseDo dto : produceQhseDos) {
            StringBuilder stringBuilder = new StringBuilder(dto.getArtifactSerialNumber());
            if (dto.getBoolOneCode().equals(1)) {
               Integer number = reportNumbreMap.get(dto.getReportNumber());
               stringBuilder.append(dto.getNumber() == null ? "" : "/" + number);
            }

            dto.setArtifactSerialNumber(stringBuilder + "");
            dto.setQualityType(this.changType(dto.getQualityType()));
         }
      }

      return pageVO;
   }

   private String changType(String qualityType) {
      List<String> strings = null;
      StringBuilder sb = new StringBuilder();
      if (StrUtil.isNotBlank(qualityType)) {
         strings = Arrays.asList(qualityType.split(","));
      }

      if (strings != null && strings.size() != 0) {
         strings.forEach(s -> sb.append(this.sysDictionaryService.listLabelsByCondition("mes_qhse_product_problem_type", s)).append(","));
      }

      return sb + "";
   }
}
