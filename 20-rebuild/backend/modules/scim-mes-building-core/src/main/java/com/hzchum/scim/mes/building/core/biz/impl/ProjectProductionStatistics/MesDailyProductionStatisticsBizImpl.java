package com.hzchum.scim.mes.building.core.biz.impl.ProjectProductionStatistics;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz.MesDailyProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.MesDailyProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionArtifactSumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionArtifactSumDowloadDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDayProductionDetailClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class MesDailyProductionStatisticsBizImpl implements MesDailyProductionStatisticsBiz {
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingPackageLinkService packageLinkService;
   @Resource
   private SysStructureClassificationService classificationService;

   @Override
   public List<MesBuildingProjectWorkshopDTO> getWorkAndLineQueryCondition(ProjectProductionStatisticsDOParam param) {
      if (param.getProcessId() == null) {
         MesBuildingProcess process = this.mesBuildingProcessService
            .getOne(
               (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>()
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingProcess::getName, "焊接")
            );
         if (process == null) {
            return null;
         }

         param.setProcessId(process.getId());
      }

      List<MesBuildingTeam> teamList = this.teamService
         .list(new LambdaQueryWrapper<MesBuildingTeam>().eq(param.getProcessId() != null, MesBuildingTeam::getProcessId, param.getProcessId()));
      if (CollectionUtils.isEmpty(teamList)) {
         return new ArrayList<>();
      }

      List<Long> workshopIds = teamList.stream().map(MesBuildingTeam::getWorkshopId).distinct().collect(Collectors.toList());
      List<Long> productionLineIds = teamList.stream().map(MesBuildingTeam::getProductionLineId).distinct().collect(Collectors.toList());
      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).distinct().collect(Collectors.toList());
      List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIds);
      Map<Long, List<MesBuildingProductionLine>> productionLineMap = this.productionLineService
         .listByIds(productionLineIds)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductionLine::getWorkshopId));
      Map<Long, List<MesBuildingTeam>> teamMap = teamList.stream().collect(Collectors.groupingBy(MesBuildingTeam::getProductionLineId));
      List<MesBuildingProcess> mesBuildingProcesses = this.mesBuildingProcessService.listByIds(processIds);
      Map<Long, MesBuildingProcess> processMap = mesBuildingProcesses.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
         .list(
            (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>()
                  .in(MesBuildingTeamUserLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList())))
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
      return workshopList.stream()
         .map(
            workshop -> {
               MesBuildingProjectWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingProjectWorkshopDTO.class);
               List<MesBuildingProductionLine> productionLineList = productionLineMap.get(workshop.getId());
               List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
                  productionLineList, MesBuildingProjectProductionLineDTO.class
               );

               for (MesBuildingProjectProductionLineDTO projectProductionLineDTO : projectProductionLineDTOS) {
                  List<MesBuildingTeam> mesBuildingTeams = teamMap.get(projectProductionLineDTO.getId());
                  List<MesBuildingProjectTeamDTO> projectTeamDTOS = mesBuildingTeams.stream()
                     .map(
                        team -> {
                           MesBuildingTeamUserLink userLink = teamUserLinkMap.get(team.getId());
                           return MesBuildingProjectTeamDTO.builder()
                              .id(team.getId())
                              .userName(userLink.getUserName())
                              .userId(userLink.getUserId())
                              .processId(team.getProcessId())
                              .processName(processMap.get(team.getProcessId()).getName())
                              .build();
                        }
                     )
                     .collect(Collectors.toList());
                  projectProductionLineDTO.setProjectTeamDTOS(projectTeamDTOS);
               }

               workshopDTO.setProjectProductionLineDTOS(projectProductionLineDTOS);
               return workshopDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesDailyProductionArtifactSumDTO> getDayProductionTaskSum(MesDailyProductionTaskDOParam param) {
      if (param.getProcessId() == null) {
         MesBuildingProcess process = this.mesBuildingProcessService
            .getOne(
               (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>()
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingProcess::getName, "焊接")
            );
         if (process == null) {
            return null;
         }

         param.setProcessId(process.getId());
      }

      LocalDateTime dateTime = param.getDateTime();
      List<Long> productionLineIds = param.getProductionLineId() == null ? new ArrayList<>() : new ArrayList<>(Math.toIntExact(param.getProductionLineId()));
      if (param.getProductionLineId() == null && param.getTeamId() == null && param.getWorkShopId() != null) {
         List<MesBuildingProductionLine> lines = this.productionLineService
            .list(
               (Wrapper<MesBuildingProductionLine>)(new LambdaQueryWrapper<MesBuildingProductionLine>()
                     .eq(MesBuildingProductionLine::getWorkshopId, param.getWorkShopId()))
                  .eq(MesBuildingProductionLine::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         if (CollectionUtils.isEmpty(lines)) {
            return new ArrayList<>();
         }

         productionLineIds = lines.stream().map(MesBuildingProductionLine::getId).collect(Collectors.toList());
      }

      param.setProductionLineIds(productionLineIds);
      List<MesDailyProductionQuerySumDTO> mesDailyProductionTaskSumList = this.produceTeamReportService.getMesDailyProductionTaskSum(param);
      param.setDateTime(null);
      List<MesDailyProductionQuerySumDTO> mesProductionTaskSumList = this.produceTeamReportService.getMesDailyProductionTaskSum(param);
      if (CollectionUtils.isEmpty(mesProductionTaskSumList)) {
         return new ArrayList<>();
      }

      List<Long> workShopIds = mesProductionTaskSumList.stream().map(MesDailyProductionQuerySumDTO::getWorkShopId).collect(Collectors.toList());
      List<MesDailyProductionQuerySumDTO> dayArtifactPackSumMeteList = this.packageLinkService
         .getArtifactPackSumMete(workShopIds, param.getMeteUnitEnum(), param.getProjectId(), dateTime);
      List<MesDailyProductionQuerySumDTO> artifactPackSumMeteList = this.packageLinkService
         .getArtifactPackSumMete(workShopIds, param.getMeteUnitEnum(), param.getProjectId(), null);
      Map<Long, List<MesDailyProductionQuerySumDTO>> produceTeamReportMaps = mesProductionTaskSumList.stream()
         .collect(Collectors.groupingBy(MesDailyProductionQuerySumDTO::getWorkShopId));
      Map<Long, List<MesDailyProductionQuerySumDTO>> dailProduceTeamReportMaps = mesDailyProductionTaskSumList.stream()
         .collect(Collectors.groupingBy(MesDailyProductionQuerySumDTO::getWorkShopId));
      Map<Long, MesDailyProductionQuerySumDTO> packMeteMaps = artifactPackSumMeteList.stream()
         .collect(Collectors.toMap(MesDailyProductionQuerySumDTO::getWorkShopId, Function.identity()));
      Map<Long, MesDailyProductionQuerySumDTO> dayDailPackMeteMaps = dayArtifactPackSumMeteList.stream()
         .collect(Collectors.toMap(MesDailyProductionQuerySumDTO::getWorkShopId, Function.identity()));
      List<MesDailyProductionArtifactSumDTO> allArtifactSumDTOList = new ArrayList<>();
      produceTeamReportMaps.forEach(
         (workShopId, reports) -> {
            String workShopName = reports.get(0).getWorkShopName();
            int sum = reports.stream().mapToInt(MesDailyProductionQuerySumDTO::getTotalQuantity).sum();
            BigDecimal totalMete = reports.stream().map(MesDailyProductionQuerySumDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add);
            MesDailyProductionArtifactSumDTO build = MesDailyProductionArtifactSumDTO.builder()
               .id(workShopId)
               .name(workShopName)
               .totalQuantity(sum)
               .totalMete(totalMete)
               .build();
            MesDailyProductionQuerySumDTO packMete = packMeteMaps.get(workShopId);
            if (packMete != null) {
               build.setTotalPackMete(packMete.getTotalMete());
            }

            MesDailyProductionQuerySumDTO dayPackMete = dayDailPackMeteMaps.get(workShopId);
            if (dayPackMete != null) {
               build.setDayTotalPackMete(dayPackMete.getTotalMete());
            }

            List<MesDailyProductionQuerySumDTO> mesDailyProductionQuerySumDTOS = dailProduceTeamReportMaps.get(workShopId);
            Map<Long, MesDailyProductionQuerySumDTO> teamDayProductionQuerySumDTOMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(mesDailyProductionQuerySumDTOS)) {
               build.setDayTotalMete(
                  mesDailyProductionQuerySumDTOS.stream().map(MesDailyProductionQuerySumDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add)
               );
               build.setDayTotalQuantity(mesDailyProductionQuerySumDTOS.stream().mapToInt(MesDailyProductionQuerySumDTO::getTotalQuantity).sum());
               teamDayProductionQuerySumDTOMap = mesDailyProductionQuerySumDTOS.stream()
                  .collect(Collectors.toMap(MesDailyProductionQuerySumDTO::getTeamId, Function.identity()));
            }

            List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOList = new ArrayList<>();

            for (MesDailyProductionQuerySumDTO report : reports) {
               MesDailyProductionArtifactSumDTO dayBuild = MesDailyProductionArtifactSumDTO.builder()
                  .id(report.getTeamId())
                  .name(report.getUserName())
                  .totalMete(report.getTotalMete())
                  .totalQuantity(report.getTotalQuantity())
                  .build();
               MesDailyProductionQuerySumDTO mesDailyProductionQuerySumDTO = teamDayProductionQuerySumDTOMap.get(report.getTeamId());
               if (mesDailyProductionQuerySumDTO != null) {
                  dayBuild.setDayTotalQuantity(mesDailyProductionQuerySumDTO.getTotalQuantity());
                  dayBuild.setDayTotalMete(mesDailyProductionQuerySumDTO.getTotalMete());
               }

               teamArtifactSumDTOList.add(dayBuild);
            }

            build.setTeamArtifactSumDTOS(teamArtifactSumDTOList);
            allArtifactSumDTOList.add(build);
         }
      );
      return allArtifactSumDTOList;
   }

   @Override
   public void printDayProductionTaskSum(MesDailyProductionTaskDOParam param, HttpServletResponse response) {
      List<MesDailyProductionArtifactSumDTO> productionTaskSums = this.getDayProductionTaskSum(param);
      if (CollectionUtils.isNotEmpty(productionTaskSums)) {
         List<Map<String, Object>> typeList = new ArrayList<>();
         Map<String, Object> exportMap = new HashMap<>();
         AtomicInteger orderNumber = new AtomicInteger(1);
         AtomicInteger index = new AtomicInteger(1);
         List<Integer> indexList = new ArrayList<>();
         List<Integer> monomerIndexList = new ArrayList<>();
         List<MesDailyProductionArtifactSumDowloadDTO> typesettingExportDOS = new ArrayList<>();

         for (MesDailyProductionArtifactSumDTO countDTO : productionTaskSums) {
            index.getAndIncrement();
            MesDailyProductionArtifactSumDowloadDTO build = MesDailyProductionArtifactSumDowloadDTO.builder()
               .orderNumber(String.valueOf(orderNumber.getAndIncrement()))
               .name(countDTO.getName())
               .totalQuantityAndMete(
                  (countDTO.getTotalQuantity() == null ? 0 : countDTO.getTotalQuantity())
                     + "/"
                     + (countDTO.getTotalMete() == null ? 0 : countDTO.getTotalMete())
               )
               .dayTotalQuantityAndMete(
                  (countDTO.getDayTotalQuantity() == null ? 0 : countDTO.getDayTotalQuantity())
                     + "/"
                     + (countDTO.getDayTotalMete() == null ? 0 : countDTO.getDayTotalMete())
               )
               .totalPackMete(countDTO.getTotalPackMete() == null ? "0" : countDTO.getTotalPackMete().toString())
               .dayTotalPackMete(countDTO.getDayTotalPackMete() == null ? "0" : countDTO.getDayTotalPackMete().toString())
               .build();
            typesettingExportDOS.add(build);
            indexList.add(index.get());
            List<MesDailyProductionArtifactSumDTO> teamArtifactSumDTOS = countDTO.getTeamArtifactSumDTOS();
            if (CollectionUtils.isNotEmpty(teamArtifactSumDTOS)) {
               for (MesDailyProductionArtifactSumDTO teamProductionArtifactSumDTO : teamArtifactSumDTOS) {
                  index.getAndIncrement();
                  MesDailyProductionArtifactSumDowloadDTO teamBuild = MesDailyProductionArtifactSumDowloadDTO.builder()
                     .orderNumber(String.valueOf(orderNumber.getAndIncrement()))
                     .name(teamProductionArtifactSumDTO.getName())
                     .totalQuantityAndMete(
                        (teamProductionArtifactSumDTO.getTotalQuantity() == null ? 0 : teamProductionArtifactSumDTO.getTotalQuantity())
                           + "/"
                           + (teamProductionArtifactSumDTO.getTotalMete() == null ? 0 : teamProductionArtifactSumDTO.getTotalMete())
                     )
                     .dayTotalQuantityAndMete(
                        (teamProductionArtifactSumDTO.getDayTotalQuantity() == null ? 0 : teamProductionArtifactSumDTO.getDayTotalQuantity())
                           + "/"
                           + (teamProductionArtifactSumDTO.getDayTotalMete() == null ? 0 : teamProductionArtifactSumDTO.getDayTotalMete())
                     )
                     .dayTotalPackMete("0")
                     .totalPackMete("0")
                     .build();
                  typesettingExportDOS.add(teamBuild);
                  monomerIndexList.add(index.get());
               }
            }
         }

         for (MesDailyProductionArtifactSumDowloadDTO typesettingDO : typesettingExportDOS) {
            Map<String, Object> typesettingMap = BeanUtil.beanToMap(typesettingDO);
            typeList.add(typesettingMap);
         }

         exportMap.put("typeList", typeList);

         try {
            String tempFileName = "DayArtifactProductionTaskSum";
            String resourcePath = "files/DayArtifactProductionTaskSum.xlsx";
            String exportFileName = "当日产量统计.xlsx";
            org.springframework.core.io.Resource resource = new ClassPathResource(resourcePath);
            InputStream inputStream = resource.getInputStream();
            File file = File.createTempFile(tempFileName, "xlsx");
            FileUtil.copyInputStreamToFile(inputStream, file);
            TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
            params.setColForEach(true);
            Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
            Sheet sheetAt = workbook.getSheetAt(0);

            for (Integer indexNum : indexList) {
               for (Cell cell : sheetAt.getRow(indexNum)) {
                  Font font = workbook.createFont();
                  font.setFontName("宋体");
                  font.setFontHeightInPoints((short)12);
                  font.setBold(true);
                  CellStyle cellStyle = workbook.createCellStyle();
                  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                  cellStyle.setAlignment(HorizontalAlignment.CENTER);
                  cellStyle.setBorderBottom(BorderStyle.THIN);
                  cellStyle.setBorderTop(BorderStyle.THIN);
                  cellStyle.setBorderLeft(BorderStyle.THIN);
                  cellStyle.setBorderRight(BorderStyle.THIN);
                  cellStyle.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
                  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                  cell.setCellStyle(cellStyle);
                  cellStyle.setFont(font);
               }
            }

            if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(monomerIndexList)) {
               for (Integer indexNum : monomerIndexList) {
                  for (Cell cell : sheetAt.getRow(indexNum)) {
                     Font font = workbook.createFont();
                     font.setFontName("宋体");
                     font.setFontHeightInPoints((short)12);
                     font.setBold(false);
                     CellStyle cellStyle = workbook.createCellStyle();
                     cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                     cellStyle.setAlignment(HorizontalAlignment.CENTER);
                     cellStyle.setBorderBottom(BorderStyle.THIN);
                     cellStyle.setBorderTop(BorderStyle.THIN);
                     cellStyle.setBorderLeft(BorderStyle.THIN);
                     cellStyle.setBorderRight(BorderStyle.THIN);
                     cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                     cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                     cell.setCellStyle(cellStyle);
                     cellStyle.setFont(font);
                  }
               }
            }

            PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
         } catch (IOException e) {
            throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
         }
      }
   }

   @Override
   public PageVO getPackDateailList(Long projectId, Long workShopId, LocalDateTime dateTime, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactBaseInfo> artifactPackDetailMete = this.packageLinkService.getArtifactPackDetailMete(Arrays.asList(workShopId), projectId, dateTime);
      return new PageVO<>(artifactPackDetailMete);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printPackDateailList(Long projectId, Long workShopId, LocalDateTime dateTime, Integer pageNumber, Integer pageSize) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactBaseInfo> artifactPackDetailMete = this.packageLinkService.getArtifactPackDetailMete(Arrays.asList(workShopId), projectId, dateTime);
      if (CollectionUtils.isNotEmpty(artifactPackDetailMete)) {
         Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
         if (dateTime != null) {
            header.put("dateTime", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
         }

         printVO.setHeader(header);
         printVO.setTable(artifactPackDetailMete.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      }

      return printVO;
   }

   @Override
   public List<MesDayProductionDetailClassDTO> getProductionDetailList(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum
   ) {
      if (processId == null) {
         MesBuildingProcess process = this.mesBuildingProcessService
            .getOne(
               (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>()
                     .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingProcess::getName, "焊接")
            );
         if (process == null) {
            return null;
         }

         processId = process.getId();
      }

      List<Long> productionLineIds = new ArrayList<>();
      if (teamId == null && workShopId != null) {
         List<MesBuildingProductionLine> lines = this.productionLineService
            .list(
               (Wrapper<MesBuildingProductionLine>)(new LambdaQueryWrapper<MesBuildingProductionLine>().eq(MesBuildingProductionLine::getWorkshopId, workShopId))
                  .eq(MesBuildingProductionLine::getProductType, ProductTypeEnum.ARTIFACT.getType())
            );
         if (CollectionUtils.isEmpty(lines)) {
            return new ArrayList<>();
         }

         productionLineIds = lines.stream().map(MesBuildingProductionLine::getId).collect(Collectors.toList());
      }

      List<MesDailyProductionQuerySumDTO> productionDetailList = this.produceTeamReportService
         .getProductionDetail(projectId, workShopId, teamId, monomerId, null, processId, meteUnitEnum, productionLineIds);
      if (CollectionUtils.isEmpty(productionDetailList)) {
         return new ArrayList<>();
      }

      List<MesDailyProductionQuerySumDTO> dayProductionDetailList = this.produceTeamReportService
         .getProductionDetail(projectId, workShopId, teamId, monomerId, dateTime, processId, meteUnitEnum, productionLineIds);
      Map<Long, SysStructureClassification> classificationMap = this.classificationService
         .list()
         .stream()
         .collect(Collectors.toMap(SysStructureClassification::getId, Function.identity()));
      Map<String, List<MesDailyProductionQuerySumDTO>> artifactClassificationMapList = new HashMap<>();
      Map<String, List<MesDailyProductionQuerySumDTO>> dayArtifactClassificationMapList = new HashMap<>();

      for (MesDailyProductionQuerySumDTO productionQuerySumDTO : productionDetailList) {
         SysStructureClassification classification = classificationMap.get(productionQuerySumDTO.getStructureClassId());
         if (ArtifactTypeEnum.COMMON.getType().equals(classification.getArtifactType())) {
            String key = productionQuerySumDTO.getName().contains("柱") ? "柱" : "梁";
            List<MesDailyProductionQuerySumDTO> techArtifacts = artifactClassificationMapList.computeIfAbsent(key, k -> new ArrayList<>());
            techArtifacts.add(productionQuerySumDTO);
         }

         if (classification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
            String key = classification.getClassificationName().equals("配套件") ? "配套件" : "次构件";
            List<MesDailyProductionQuerySumDTO> techArtifacts = artifactClassificationMapList.computeIfAbsent(key, k -> new ArrayList<>());
            techArtifacts.add(productionQuerySumDTO);
         }
      }

      for (MesDailyProductionQuerySumDTO productionQuerySumDTO : dayProductionDetailList) {
         SysStructureClassification classification = classificationMap.get(productionQuerySumDTO.getStructureClassId());
         if (ArtifactTypeEnum.COMMON.getType().equals(classification.getArtifactType())) {
            String key = productionQuerySumDTO.getName().contains("柱") ? "柱" : "梁";
            List<MesDailyProductionQuerySumDTO> techArtifacts = dayArtifactClassificationMapList.computeIfAbsent(key, k -> new ArrayList<>());
            techArtifacts.add(productionQuerySumDTO);
         }

         if (classification.getArtifactType().equals(ArtifactTypeEnum.SMALL.getType())) {
            String key = classification.getClassificationName().equals("配套件") ? "配套件" : "次构件";
            List<MesDailyProductionQuerySumDTO> techArtifacts = dayArtifactClassificationMapList.computeIfAbsent(key, k -> new ArrayList<>());
            techArtifacts.add(productionQuerySumDTO);
         }
      }

      List<MesDayProductionDetailClassDTO> productionDetailClassDTOS = new ArrayList<>();
      artifactClassificationMapList.forEach(
         (className, classArtifactList) -> {
            MesDayProductionDetailClassDTO dto = MesDayProductionDetailClassDTO.builder()
               .classificationName(className)
               .totalMete(classArtifactList.stream().map(MesDailyProductionQuerySumDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add))
               .dayTotalMete(BigDecimal.ZERO)
               .build();
            List<MesDailyProductionQuerySumDTO> dailyProductionQuerySumDTOS = dayArtifactClassificationMapList.get(className);
            if (CollectionUtils.isNotEmpty(dailyProductionQuerySumDTOS)) {
               dto.setDayTotalMete(
                  dailyProductionQuerySumDTOS.stream().map(MesDailyProductionQuerySumDTO::getTotalMete).reduce(BigDecimal.ZERO, BigDecimal::add)
               );
            }

            productionDetailClassDTOS.add(dto);
         }
      );
      return productionDetailClassDTOS;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProductionDetailList(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      List<MesDayProductionDetailClassDTO> productionDetailList = this.getProductionDetailList(
         projectId, workShopId, teamId, monomerId, dateTime, processId, meteUnitEnum
      );
      if (CollectionUtils.isEmpty(productionDetailList)) {
         return null;
      }

      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (dateTime != null) {
         header.put("dateTime", dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      }

      printVO.setHeader(header);
      printVO.setTable(productionDetailList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }
}
