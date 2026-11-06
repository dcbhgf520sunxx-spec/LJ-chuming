package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingArtifactSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesBuildingTypesettingAssembleTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingAssembleTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProductMonitorKanbanByGroupDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.GroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingSurplusAssembleDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingAssembleSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingSurplusAssembleMatchingArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanByGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingAssembleSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingArtifactSchedulingMapper;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._doModel.MesBuildingAssembleScheduling;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.service.MesBuildingAssembleSchedulingService;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesBuildingArtifactSchedulingBizImpl
   extends IBizImpl<MesBuildingArtifactSchedulingService, MesBuildingArtifactSchedulingMapper, MesBuildingArtifactScheduling>
   implements MesBuildingArtifactSchedulingBiz {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingArtifactSchedulingBizImpl.class);
   @Autowired
   MesBuildingGroupsBiz groupsBiz;
   @Autowired
   TechArtifactService artifactService;
   @Autowired
   TechAssembleDetailService assembleDetailService;
   @Autowired
   TechAssembleService assembleService;
   @Autowired
   MesBuildingAssembleSchedulingService assembleSchedulingService;
   @Autowired
   MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   MesBuildingTaskBiz taskBiz;
   @Autowired
   TechAssembleExtService assembleExtService;
   @Resource
   private ConfigProperties configProperties;
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Autowired
   private PlanAreaService planAreaService;
   @Autowired
   private PlanMonomerService planMonomerService;
   @Autowired
   private TechDrawingService drawingService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz groupsTeamLinkBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingTeamService buildingTeamService;
   @Autowired
   private TechArtifactExtService techArtifactExtService;
   @Autowired
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private PlanAreaBatchService planAreaBatchService;
   @Resource
   private SysStructureClassificationService classificationService;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private TechCappCraftProductTaskBiz cappCraftProductTaskBiz;
   @Resource
   private ConfigService configService;

   @Override
   public PageVO<MesBuildingArtifactSchedulingDTO> artifactByConditionList(MesBuildingArtifactSchedulingDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingArtifactSchedulingDTO> artifactSchedulingDTOList = this.baseService
         .artifactByConditionList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingDTO.class))
         .collect(Collectors.toList());
      PageVO<MesBuildingArtifactSchedulingDTO> pageVO = new PageVO<>(page, artifactSchedulingDTOList);
      if (CollectionUtils.isNotEmpty(artifactSchedulingDTOList)) {
         Comparator<MesBuildingArtifactSchedulingDTO> comparator = Comparator.<MesBuildingArtifactSchedulingDTO, String>comparing(e -> {
            int lastDashIndex = e.getSerialNumber().lastIndexOf("-");
            return lastDashIndex != -1 ? e.getSerialNumber().substring(0, lastDashIndex) : e.getSerialNumber();
         }).thenComparingInt(e -> {
            int lastDashIndex = e.getSerialNumber().lastIndexOf("-");
            String numberPart = lastDashIndex != -1 ? e.getSerialNumber().substring(lastDashIndex + 1) : e.getSerialNumber();
            if (numberPart.contains("*")) {
               numberPart = numberPart.replace("*", "");
            }

            try {
               return Integer.parseInt(numberPart);
            } catch (NumberFormatException ex) {
               return 0;
            }
         });
         artifactSchedulingDTOList.sort(comparator);
         Map<MonomerDetailDO, List<MesBuildingArtifactSchedulingDTO>> doListMap = artifactSchedulingDTOList.stream()
            .collect(Collectors.groupingBy(MesBuildingArtifactSchedulingDO::getMonomer));
         doListMap.forEach(
            (monomer, artifactDTOList) -> {
               List<String> serialNumberList = artifactDTOList.stream().map(MesBuildingArtifactSchedulingDO::getSerialNumber).collect(Collectors.toList());
               Map<String, List<TechDrawing>> drawingListMap = this.drawingService
                  .list(
                     (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                                 .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                              .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                           .in(TechDrawing::getSerialNumber, serialNumberList))
                        .eq(TechDrawing::getMonomerId, monomer.getId())
                  )
                  .stream()
                  .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
               artifactDTOList.forEach(
                  e -> {
                     if (drawingListMap.containsKey(e.getSerialNumber())) {
                        e.setNumbers(drawingListMap.get(e.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
                        e.setDrawingAndSerialNumber(
                           drawingListMap.get(e.getSerialNumber())
                              .stream()
                              .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
                              .collect(Collectors.toList())
                        );
                     }
                  }
               );
               artifactDTOList.sort(Comparator.comparing(this::extractSortingKey));
               doListMap.put(monomer, (List<MesBuildingArtifactSchedulingDTO>)artifactDTOList);
            }
         );
         artifactSchedulingDTOList = doListMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      }

      pageVO.setContent(artifactSchedulingDTOList);
      return pageVO;
   }

   private String extractSortingKey(MesBuildingArtifactSchedulingDTO artifactDTO) {
      String serialNumber = artifactDTO.getSerialNumber();
      if (!serialNumber.contains("-") && !serialNumber.contains("*")) {
         int lastLetterIndex = serialNumber.length() - 1;

         while (lastLetterIndex >= 0 && !Character.isLetter(serialNumber.charAt(lastLetterIndex))) {
            lastLetterIndex--;
         }

         if (lastLetterIndex >= 0) {
            String beforeLastLetter = serialNumber.substring(0, lastLetterIndex + 1);
            String afterLastLetter = serialNumber.substring(lastLetterIndex + 1);

            try {
               int numericValue = Integer.parseInt(afterLastLetter);
               return beforeLastLetter + "-" + String.format("%04d", numericValue);
            } catch (NumberFormatException e) {
               return serialNumber;
            }
         }
      } else {
         String[] parts = serialNumber.split("[-*]");
         if (parts.length >= 2) {
            StringBuilder alphabetPartBuilder = new StringBuilder();

            for (int i = 0; i < parts.length - 1; i++) {
               alphabetPartBuilder.append(parts[i]);
               alphabetPartBuilder.append("-");
            }

            String lastPart = parts[parts.length - 1];

            try {
               int numericValue = Integer.parseInt(lastPart);
               return alphabetPartBuilder.toString() + "-" + String.format("%04d", numericValue);
            } catch (NumberFormatException e) {
               int lastLetterIndex = serialNumber.length() - 1;

               while (lastLetterIndex >= 0 && !Character.isLetter(serialNumber.charAt(lastLetterIndex))) {
                  lastLetterIndex--;
               }

               if (lastLetterIndex >= 0) {
                  String beforeLastLetter = serialNumber.substring(0, lastLetterIndex + 1);
                  String afterLastLetter = serialNumber.substring(lastLetterIndex + 1);

                  try {
                     int numericValue = Integer.parseInt(afterLastLetter);
                     return beforeLastLetter + "-" + String.format("%04d", numericValue);
                  } catch (NumberFormatException a) {
                     return serialNumber;
                  }
               }

               return serialNumber;
            }
         }
      }

      return serialNumber;
   }

   @Override
   public PageVO<MesBuildingArtifactSchedulingDTO> artifactByConditionPage(
      MesBuildingArtifactSchedulingDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize
   ) {
      return this.artifactByConditionList(dtoParam, pageNumber, pageSize);
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDTO artifactByConditionSummary(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getAreaIdList()), "区域id不能为空");
      MesBuildingArtifactSchedulingSummaryDTO copy = BeanUtil.copy(
         this.baseService.artifactByConditionSummary(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class)),
         MesBuildingArtifactSchedulingSummaryDTO.class
      );
      if (copy == null) {
         return MesBuildingArtifactSchedulingSummaryDTO.builder().build();
      }

      List<PlanAreaBatch> areaBatchList = this.planAreaBatchService.listByIds(dtoParam.getAreaIdList());
      List<PlanArea> planAreas = this.planAreaService.listByIds(areaBatchList.stream().map(PlanAreaBatch::getAreaId).collect(Collectors.toList()));
      List<LocalDate> collect = planAreas.stream().map(PlanArea::getDate).collect(Collectors.toList());
      LocalDate time = collect.get(0);
      copy.setCompletionTime(time);
      return copy;
   }

   @Override
   public List<Integer> getProductionLineTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService.getProductionLineTypeList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class));
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getArtifactTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactTypeList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .sorted(Comparator.comparingInt(MesBuildingArtifactTypeDO::getArtifactType))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getArtifactNameList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactNameList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public synchronized Boolean saveArtifactSchedulingList(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> groupIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getGroupsId).distinct().collect(Collectors.toList());
      List<MesBuildingGroups> mesBuildingGroups = this.groupsBiz.listByIds(groupIds);
      Preconditions.checkArgument(groupIds.size() == mesBuildingGroups.size(), "操作失败所选生产组不存在!!!请刷新页面后重试!!!");
      Map<Long, MesBuildingGroups> groupsMap = mesBuildingGroups.stream().collect(Collectors.toMap(MesBuildingGroups::getId, Function.identity()));
      List<Long> lineIds = mesBuildingGroups.stream().map(MesBuildingGroups::getProductionLineId).collect(Collectors.toList());
      List<MesBuildingProductionLine> lines = this.productionLineBiz.listByIds(lineIds);
      Map<Long, MesBuildingProductionLine> productionLineMap = lines.stream().collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      List<Long> artIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artIds);
      List<Long> areaIds = artifacts.stream().map(TechArtifact::getAreaId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(areaIds.size() == 1, "操作失败!!构件不支持跨区域排产!!!");
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<MesBuildingArtifactScheduling> schedulingList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, artIds));
      Map<Long, Integer> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getProductId, MesBuildingArtifactScheduling::getQuantity, Integer::sum));
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(
            Wrappers.lambdaQuery(TechArtifactExt.class)
               .in(TechArtifactExt::getArtifactId, artIds)
               .eq(TechArtifactExt::getBoolSubscription, Boolean.FALSE)
               .eq(TechArtifactExt::getBoolScheduling, false)
         );
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> needUpdateExts = new ArrayList<>();

      for (MesBuildingArtifactSchedulingDTOParam dtoParam : dtoParamList) {
         TechArtifact artifact = artifactMap.get(dtoParam.getProductId());
         Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败!!构件:" + artifact.getSerialNumber() + "处于冻结中!!!");
         Integer lastScheduling = schedulingMap.get(dtoParam.getProductId()) == null ? 0 : schedulingMap.get(dtoParam.getProductId());
         Integer schdulingQuantity = dtoParam.getQuantity();
         MesBuildingGroups group = groupsMap.get(dtoParam.getGroupsId());
         MesBuildingArtifactScheduling artifactScheduling = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                  .eq(MesBuildingArtifactScheduling::getProductId, dtoParam.getProductId())
                  .eq(MesBuildingArtifactScheduling::getProductionLineId, group.getProductionLineId())
                  .eq(dtoParam.getGroupsId() != null, MesBuildingArtifactScheduling::getGroupsId, dtoParam.getGroupsId())
            );
         if (artifactScheduling != null) {
            LocalDateTime askCompleteTime = artifactScheduling.getAskCompleteTime().isAfter(dtoParam.getAskCompleteTime())
               ? artifactScheduling.getAskCompleteTime()
               : dtoParam.getAskCompleteTime();
            artifactScheduling.setAskCompleteTime(askCompleteTime);
            artifactScheduling.setUserId(UserUtil.getCurrentUserId());
            artifactScheduling.setQuantity(artifactScheduling.getQuantity() + schdulingQuantity);
            this.baseService.updateById(artifactScheduling);
         } else {
            artifactScheduling = MesBuildingArtifactScheduling.builder()
               .productId(artifact.getId())
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .areaBatchId(artifact.getAreaBatchId())
               .factoryId(group.getFactoryId())
               .workshopId(group.getWorkshopId())
               .productionLineId(group.getProductionLineId())
               .productionLineTypeEnum(productionLineMap.get(group.getProductionLineId()).getProductionLineTypeEnum())
               .groupsId(dtoParam.getGroupsId())
               .askCompleteTime(dtoParam.getAskCompleteTime())
               .status(Boolean.TRUE)
               .issueStatus(Boolean.FALSE)
               .quantity(schdulingQuantity)
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.baseService.save(artifactScheduling);
         }

         Preconditions.checkArgument(schdulingQuantity + lastScheduling <= artifact.getQuantity() - artifact.getSubscriptionQuantity(), "错误,排产总数量不能大于清单数量!!!");
         List<Long> allartIds = dtoParamList.stream().map(s -> s.getProductId()).distinct().collect(Collectors.toList());
         List<MesBuildingArtifactScheduling> allschedulingList = this.baseService
            .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, allartIds));
         Map<Long, List<MesBuildingArtifactScheduling>> allSchedulingMap = allschedulingList.stream().collect(Collectors.groupingBy(s -> s.getProductId()));

         for (Long artId : allSchedulingMap.keySet()) {
            List<MesBuildingArtifactScheduling> schedulings = allSchedulingMap.get(artId);
            int sum = schedulings.stream().mapToInt(s -> s.getQuantity()).sum();
            TechArtifact techArtifact = artifactMap.get(artId);
            Preconditions.checkArgument(sum <= techArtifact.getQuantity() - techArtifact.getSubscriptionQuantity(), "操作失败!!!排产数不可大于清单数!!!");
         }

         List<TechArtifactExt> exts = artExtMap.get(dtoParam.getProductId());
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber));
         List<TechArtifactExt> extList = exts.stream().filter(s -> !s.getBoolScheduling()).limit(schdulingQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(schdulingQuantity <= extList.size(), "操作失败!!!刷新后重试!!!");
         MesBuildingArtifactScheduling finalArtifactScheduling = artifactScheduling;
         extList.forEach(s -> s.setBoolScheduling(Boolean.TRUE).setSchedulingId(finalArtifactScheduling.getId()));
         needUpdateExts.addAll(extList);
      }

      this.techArtifactExtService.updateBatchById(needUpdateExts);
      Object hget = this.redisUtils.hmget("scheduling_overweight:");
      HashMap hashMap = new HashMap();
      if (hget != null && !((Map)hget).isEmpty()) {
         hashMap = (HashMap)hget;
      }

      hashMap.put(
         artifacts.get(0).getProjectId() + "_" + dtoParamList.get(0).getProductionLineId(),
         dtoParamList.get(0).getAskCompleteTime().toInstant(ZoneOffset.of("+8")).toEpochMilli()
      );
      this.redisUtils.hmset("scheduling_overweight:", hashMap);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
   @Override
   public synchronized Boolean saveArtifactSchedulingList2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> lineIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductionLineId).collect(Collectors.toList());
      List<MesBuildingProductionLine> lines = this.productionLineBiz.listByIds(lineIds);
      Map<Long, MesBuildingProductionLine> productionLineMap = lines.stream().collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      List<Long> artIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artIds);
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<MesBuildingArtifactScheduling> schedulingList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, artIds));
      Map<Long, Integer> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getProductId, MesBuildingArtifactScheduling::getQuantity, Integer::sum));
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getArtifactId, artIds).eq(TechArtifactExt::getBoolScheduling, false));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> needUpdateExts = new ArrayList<>();

      for (MesBuildingArtifactSchedulingDTOParam dtoParam : dtoParamList) {
         TechArtifact artifact = artifactMap.get(dtoParam.getProductId());
         Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败!!构件:" + artifact.getSerialNumber() + "处于冻结中!!!");
         Integer schdulingQuantity = dtoParam.getQuantity();
         MesBuildingProductionLine productionLine = productionLineMap.get(dtoParam.getProductionLineId());
         MesBuildingArtifactScheduling artifactScheduling = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                  .eq(MesBuildingArtifactScheduling::getProductId, dtoParam.getProductId())
                  .eq(MesBuildingArtifactScheduling::getProductionLineId, productionLine.getId())
            );
         if (artifactScheduling != null) {
            LocalDateTime askCompleteTime = artifactScheduling.getAskCompleteTime().isAfter(dtoParam.getAskCompleteTime())
               ? artifactScheduling.getAskCompleteTime()
               : dtoParam.getAskCompleteTime();
            artifactScheduling.setAskCompleteTime(askCompleteTime);
            artifactScheduling.setUserId(UserUtil.getCurrentUserId());
            artifactScheduling.setQuantity(artifactScheduling.getQuantity() + schdulingQuantity);
            artifactScheduling.setIssueStatus(Boolean.FALSE);
            this.baseService.updateById(artifactScheduling);
         } else {
            artifactScheduling = MesBuildingArtifactScheduling.builder()
               .productId(artifact.getId())
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .areaBatchId(artifact.getAreaBatchId())
               .factoryId(productionLine.getFactoryId())
               .workshopId(productionLine.getWorkshopId())
               .productionLineId(productionLine.getId())
               .askCompleteTime(dtoParam.getAskCompleteTime())
               .status(Boolean.TRUE)
               .issueStatus(Boolean.FALSE)
               .quantity(schdulingQuantity)
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.baseService.save(artifactScheduling);
         }

         this.updateArtifactExt(dtoParam, artifactMap, schedulingMap, artExtMap, needUpdateExts, artifactScheduling);
      }

      this.techArtifactExtService.updateBatchById(needUpdateExts);
      Object hget = this.redisUtils.hmget("scheduling_overweight:");
      HashMap hashMap = new HashMap();
      if (hget != null && !((Map)hget).isEmpty()) {
         hashMap = (HashMap)hget;
      }

      hashMap.put(
         artifacts.get(0).getProjectId() + "_" + dtoParamList.get(0).getProductionLineId(),
         dtoParamList.get(0).getAskCompleteTime().toInstant(ZoneOffset.of("+8")).toEpochMilli()
      );
      this.redisUtils.hmset("scheduling_overweight:", hashMap);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
   @Override
   public synchronized Boolean saveArtifactSchedulingListV8(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> lineIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductionLineId).collect(Collectors.toList());
      List<MesBuildingProductionLine> lines = this.productionLineBiz.listByIds(lineIds);
      Map<Long, MesBuildingProductionLine> productionLineMap = lines.stream().collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      List<Long> artIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artIds);
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<MesBuildingArtifactScheduling> schedulingList = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, artIds));
      Map<Long, Integer> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getProductId, MesBuildingArtifactScheduling::getQuantity, Integer::sum));
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getArtifactId, artIds).eq(TechArtifactExt::getBoolScheduling, false));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      List<TechArtifactExt> needUpdateExts = new ArrayList<>();

      for (MesBuildingArtifactSchedulingDTOParam dtoParam : dtoParamList) {
         TechArtifact artifact = artifactMap.get(dtoParam.getProductId());
         Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
         Preconditions.checkArgument(artifact.getBoolStatusEnum(), "操作失败!!构件:" + artifact.getSerialNumber() + "处于冻结中!!!");
         Integer schdulingQuantity = dtoParam.getQuantity();
         MesBuildingProductionLine productionLine = productionLineMap.get(dtoParam.getProductionLineId());
         MesBuildingArtifactScheduling artifactScheduling = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                  .eq(MesBuildingArtifactScheduling::getProductId, dtoParam.getProductId())
                  .eq(MesBuildingArtifactScheduling::getProductionLineId, productionLine.getId())
            );
         if (artifactScheduling != null) {
            artifactScheduling.setUserId(UserUtil.getCurrentUserId());
            artifactScheduling.setQuantity(artifactScheduling.getQuantity() + schdulingQuantity);
            artifactScheduling.setIssueStatus(Boolean.FALSE);
            this.baseService.updateById(artifactScheduling);
         } else {
            artifactScheduling = MesBuildingArtifactScheduling.builder()
               .productId(artifact.getId())
               .projectId(artifact.getProjectId())
               .monomerId(artifact.getMonomerId())
               .areaId(artifact.getAreaId())
               .factoryId(productionLine.getFactoryId())
               .workshopId(productionLine.getWorkshopId())
               .productionLineId(productionLine.getId())
               .status(Boolean.TRUE)
               .issueStatus(Boolean.FALSE)
               .quantity(schdulingQuantity)
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.baseService.save(artifactScheduling);
         }

         this.updateArtifactExtV8(dtoParam, artifactMap, schedulingMap, artExtMap, needUpdateExts, artifactScheduling);
      }

      this.techArtifactExtService.updateBatchById(needUpdateExts);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
   @Override
   public synchronized Boolean saveAssembleSchedulingListV8(List<MesBuildingAssembleSchedulingDTOParam> dtoParamList) {
      List<Long> lineIds = dtoParamList.stream().map(MesBuildingAssembleSchedulingDTOParam::getProductionLineId).collect(Collectors.toList());
      List<MesBuildingProductionLine> lines = this.productionLineBiz.listByIds(lineIds);
      Map<Long, MesBuildingProductionLine> productionLineMap = lines.stream().collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      List<Long> assIds = dtoParamList.stream().map(MesBuildingAssembleSchedulingDTOParam::getProductId).collect(Collectors.toList());
      List<TechAssemble> assembles = this.assembleService.listByIds(assIds);
      Map<Long, TechAssemble> assembleMap = assembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      List<MesBuildingAssembleScheduling> schedulingList = this.assembleSchedulingService
         .list(Wrappers.lambdaQuery(MesBuildingAssembleScheduling.class).in(MesBuildingAssembleScheduling::getProductId, assIds));
      Map<Long, Integer> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingAssembleScheduling::getProductId, MesBuildingAssembleScheduling::getQuantity, Integer::sum));
      List<TechAssembleExt> assembleExts = this.assembleExtService
         .list(Wrappers.lambdaQuery(TechAssembleExt.class).in(TechAssembleExt::getAssembleId, assIds).eq(TechAssembleExt::getBoolTask, false));
      Map<Long, List<TechAssembleExt>> artExtMap = assembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
      List<TechAssembleExt> needUpdateExts = new ArrayList<>();

      for (MesBuildingAssembleSchedulingDTOParam dtoParam : dtoParamList) {
         TechAssemble assemble = assembleMap.get(dtoParam.getProductId());
         Preconditions.checkArgument(assemble != null, "错误，产品id不正确");
         Preconditions.checkArgument(assemble.getBoolStatusEnum(), "操作失败!!部件:" + assemble.getSerialNumber() + "处于冻结中!!!");
         Integer schdulingQuantity = dtoParam.getQuantity();
         MesBuildingProductionLine productionLine = productionLineMap.get(dtoParam.getProductionLineId());
         MesBuildingAssembleScheduling assembleScheduling = this.assembleSchedulingService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingAssembleScheduling.class)
                  .eq(MesBuildingAssembleScheduling::getProductId, dtoParam.getProductId())
                  .eq(MesBuildingAssembleScheduling::getProductionLineId, productionLine.getId())
            );
         if (assembleScheduling != null) {
            assembleScheduling.setUserId(UserUtil.getCurrentUserId());
            assembleScheduling.setQuantity(assembleScheduling.getQuantity() + schdulingQuantity);
            assembleScheduling.setIssueStatus(Boolean.FALSE);
            this.assembleSchedulingService.updateById(assembleScheduling);
         } else {
            assembleScheduling = MesBuildingAssembleScheduling.builder()
               .productId(assemble.getId())
               .projectId(assemble.getProjectId())
               .monomerId(assemble.getMonomerId())
               .areaId(assemble.getAreaId())
               .factoryId(productionLine.getFactoryId())
               .workshopId(productionLine.getWorkshopId())
               .productionLineId(productionLine.getId())
               .askCompleteTime(dtoParam.getAskCompleteTime())
               .status(Boolean.TRUE)
               .issueStatus(Boolean.FALSE)
               .quantity(schdulingQuantity)
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.assembleSchedulingService.save(assembleScheduling);
         }

         this.updateAssembleExtV8(dtoParam, assembleMap, schedulingMap, artExtMap, needUpdateExts, assembleScheduling);
      }

      this.assembleExtService.updateBatchById(needUpdateExts);
      return Boolean.TRUE;
   }

   private void updateArtifactExt(
      MesBuildingArtifactSchedulingDTOParam dtoParam,
      Map<Long, TechArtifact> artifactMap,
      Map<Long, Integer> schedulingMap,
      Map<Long, List<TechArtifactExt>> artExtMap,
      List<TechArtifactExt> needUpdateExts,
      MesBuildingArtifactScheduling artifactScheduling
   ) {
      TechArtifact artifact = artifactMap.get(dtoParam.getProductId());
      Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
      Integer lastScheduling = schedulingMap.getOrDefault(dtoParam.getProductId(), 0);
      Integer schedulingQuantity = dtoParam.getQuantity();
      Preconditions.checkArgument(schedulingQuantity + lastScheduling <= artifact.getQuantity(), "错误,排产总数量不能大于清单数量!!!");
      List<TechArtifactExt> exts = artExtMap.get(dtoParam.getProductId());
      if (exts != null) {
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber));
         List<TechArtifactExt> extList = exts.stream().filter(s -> !s.getBoolScheduling()).limit(schedulingQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(schedulingQuantity <= extList.size(), "操作失败!!!刷新后重试!!!");
         extList.forEach(s -> {
            s.setBoolScheduling(Boolean.TRUE);
            s.setSchedulingId(artifactScheduling.getId());
         });
         needUpdateExts.addAll(extList);
      }
   }

   private void updateArtifactExtV8(
      MesBuildingArtifactSchedulingDTOParam dtoParam,
      Map<Long, TechArtifact> artifactMap,
      Map<Long, Integer> schedulingMap,
      Map<Long, List<TechArtifactExt>> artExtMap,
      List<TechArtifactExt> needUpdateExts,
      MesBuildingArtifactScheduling artifactScheduling
   ) {
      TechArtifact artifact = artifactMap.get(dtoParam.getProductId());
      Preconditions.checkArgument(artifact != null, "错误，产品id不正确");
      Integer lastScheduling = schedulingMap.getOrDefault(dtoParam.getProductId(), 0);
      Integer schedulingQuantity = dtoParam.getQuantity();
      Preconditions.checkArgument(schedulingQuantity + lastScheduling <= artifact.getQuantity(), "错误,排产总数量不能大于清单数量!!!");
      List<TechArtifactExt> exts = artExtMap.get(dtoParam.getProductId());
      if (exts != null) {
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber));
         List<TechArtifactExt> extList = exts.stream().filter(s -> !s.getBoolScheduling()).limit(schedulingQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(schedulingQuantity <= extList.size(), "操作失败!!!刷新后重试!!!");
         extList.forEach(s -> {
            s.setBoolScheduling(Boolean.TRUE);
            s.setSchedulingId(artifactScheduling.getId());
         });
         needUpdateExts.addAll(extList);
      }
   }

   private void updateAssembleExtV8(
      MesBuildingAssembleSchedulingDTOParam dtoParam,
      Map<Long, TechAssemble> assembleMap,
      Map<Long, Integer> schedulingMap,
      Map<Long, List<TechAssembleExt>> assExtMap,
      List<TechAssembleExt> needUpdateExts,
      MesBuildingAssembleScheduling assembleScheduling
   ) {
      TechAssemble assemble = assembleMap.get(dtoParam.getProductId());
      Preconditions.checkArgument(assemble != null, "错误，产品id不正确");
      Integer lastScheduling = schedulingMap.getOrDefault(dtoParam.getProductId(), 0);
      Integer schedulingQuantity = dtoParam.getQuantity();
      Preconditions.checkArgument(schedulingQuantity + lastScheduling <= assemble.getQuantity(), "错误,排产总数量不能大于清单数量!!!");
      List<TechAssembleExt> exts = assExtMap.get(dtoParam.getProductId());
      if (exts != null) {
         exts.sort(Comparator.comparingInt(TechAssembleExt::getSortNumber));
         List<TechAssembleExt> extList = exts.stream().filter(s -> !s.getBoolTask()).limit(schedulingQuantity.intValue()).collect(Collectors.toList());
         Preconditions.checkArgument(schedulingQuantity <= extList.size(), "操作失败!!!刷新后重试!!!");
         extList.forEach(s -> {
            s.setBoolTask(Boolean.TRUE);
            s.setSchedulingId(assembleScheduling.getId());
         });
         needUpdateExts.addAll(extList);
      }
   }

   @Override
   public List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactSchedulingRecordList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordList2(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactSchedulingRecordList2(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordListV8(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactSchedulingRecordListV8(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingArtifactSchedulingDTO> getArtifactSchedulingRecordPage(
      MesBuildingArtifactSchedulingDTOParam dtoParam, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getArtifactSchedulingRecordList(dtoParam));
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDTO getArtifactSchedulingRecordSummary(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return BeanUtil.copy(
         this.baseService.getArtifactSchedulingRecordSummary(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class)),
         MesBuildingArtifactSchedulingSummaryDTO.class
      );
   }

   @Override
   public MesBuildingArtifactSchedulingSummaryDTO getArtifactSchedulingRecordSummary2(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return BeanUtil.copy(
         this.baseService.getArtifactSchedulingRecordSummary2(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class)),
         MesBuildingArtifactSchedulingSummaryDTO.class
      );
   }

   @Override
   public List<MesBuildingArtifactSchedulingGroupSummaryDTO> getGroupsRecordSummary(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getGroupsRecordSummary(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactSchedulingGroupSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getArtifactRecordTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactRecordTypeList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getArtifactRecordTypeListV8(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactRecordTypeListV8(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingAssembleTypeDO> getAssembleRecordTypeListV8(Long areaId) {
      Map<Long, List<MesBuildingAssembleSchedulingDTO>> assembleSchedulingMap = this.getArtifactSchedulingAssembleV8(areaId)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingAssembleSchedulingDTO::getAssembleConfigId));
      List<MesBuildingAssembleTypeDO> dtos = new ArrayList<>();
      assembleSchedulingMap.forEach(
         (k, v) -> dtos.add(
            new MesBuildingAssembleTypeDO()
               .setAssembleConfigId(k)
               .setName(v.get(0).getAssembleConfigName())
               .setQuantity(v.stream().map(e -> e.getQuantity()).reduce(Integer::sum).orElse(0))
               .setNetWeight(v.get(0).getNetWeight())
               .setTotalNetWeight(v.stream().map(e -> e.getTotalNetWeight()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO))
               .setMesProductEnum(v.get(0).getMesProductEnum())
         )
      );
      return dtos;
   }

   @Override
   public List<MesBuildingArtifactTypeDTO> getArtifactRecordNameList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService
         .getArtifactRecordNameList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingArtifactTypeDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<Long> getRecordProductionLineTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService.getRecordProductionLineTypeList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class));
   }

   @Override
   public List<Boolean> getArtifactRecordProductionTypeList(MesBuildingArtifactSchedulingDTOParam dtoParam) {
      return this.baseService.getArtifactRecordProductionTypeList(BeanUtil.copy(dtoParam, MesBuildingArtifactSchedulingDOParam.class));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateArtifactScheduling(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> changeSchedulingIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> oldSchedulings = this.baseService.listByIds(changeSchedulingIds);
      Map<Long, MesBuildingArtifactScheduling> oldArtifactSchedulingMap = oldSchedulings.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
      Preconditions.checkArgument(oldArtifactSchedulingMap.size() == dtoParamList.size(), "操作失败：参数id不正确");
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, changeSchedulingIds));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));
      List<TechArtifactExt> needUpdateExts = new ArrayList<>();
      dtoParamList.forEach(dtoParam -> {
         MesBuildingArtifactScheduling oldScheduling = oldArtifactSchedulingMap.get(dtoParam.getId());
         dtoParam.setAskCompleteTime(oldScheduling.getAskCompleteTime());
         dtoParam.setProductId(oldScheduling.getProductId());
         if (dtoParam.getGroupsId() != null) {
            Preconditions.checkArgument(!dtoParam.getGroupsId().equals(oldScheduling.getGroupsId()), "操作失败，不能分配到原生产组");
         }

         oldScheduling.setQuantity(oldScheduling.getQuantity() - dtoParam.getQuantity());
         List<TechArtifactExt> exts = artExtMap.get(oldScheduling.getId());
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber).reversed());
         List<TechArtifactExt> extList = exts.stream().limit(dtoParam.getQuantity().intValue()).collect(Collectors.toList());
         extList.forEach(s -> s.setBoolScheduling(Boolean.FALSE).setSchedulingId(0L));
         needUpdateExts.addAll(extList);
         if (oldScheduling.getQuantity() == 0) {
            this.baseService.removeById(oldScheduling);
         } else {
            oldScheduling.setUserId(UserUtil.getCurrentUserId());
            this.baseService.updateById(oldScheduling);
         }
      });
      this.techArtifactExtService.updateBatchById(needUpdateExts);
      this.saveArtifactSchedulingList(dtoParamList);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateArtifactScheduling2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> changeSchedulingIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> oldSchedulings = this.baseService.listByIds(changeSchedulingIds);
      Map<Long, MesBuildingArtifactScheduling> oldArtifactSchedulingMap = oldSchedulings.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
      Preconditions.checkArgument(oldArtifactSchedulingMap.size() == dtoParamList.size(), "操作失败：参数id不正确");
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, changeSchedulingIds));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));
      List<TechArtifactExt> needUpdateExts = new ArrayList<>();
      dtoParamList.forEach(dtoParam -> {
         MesBuildingArtifactScheduling oldScheduling = oldArtifactSchedulingMap.get(dtoParam.getId());
         dtoParam.setAskCompleteTime(oldScheduling.getAskCompleteTime());
         dtoParam.setProductId(oldScheduling.getProductId());
         oldScheduling.setQuantity(oldScheduling.getQuantity() - dtoParam.getQuantity());
         List<TechArtifactExt> exts = artExtMap.get(oldScheduling.getId());
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber).reversed());
         List<TechArtifactExt> extList = exts.stream().limit(dtoParam.getQuantity().intValue()).collect(Collectors.toList());
         extList.forEach(s -> s.setBoolScheduling(Boolean.FALSE).setSchedulingId(0L));
         needUpdateExts.addAll(extList);
         if (oldScheduling.getQuantity() == 0) {
            this.baseService.removeById(oldScheduling);
         } else {
            oldScheduling.setUserId(UserUtil.getCurrentUserId());
            this.baseService.updateById(oldScheduling);
         }
      });
      this.techArtifactExtService.updateBatchById(needUpdateExts);
      this.saveArtifactSchedulingList2(dtoParamList);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteArtifactScheduling(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> schedulingIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> schedulingList = this.baseService.listByIds(schedulingIds);
      Preconditions.checkArgument(schedulingList.stream().noneMatch(MesBuildingArtifactScheduling::getIssueStatus), "操作失败：排产已下发");
      Map<Long, MesBuildingArtifactScheduling> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, schedulingIds));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));
      List<TechArtifactExt> needUpadte = new ArrayList<>();
      dtoParamList.forEach(dtoParam -> {
         List<TechArtifactExt> exts = artExtMap.get(dtoParam.getId());
         Preconditions.checkArgument(exts.size() >= dtoParam.getQuantity(), "操作失败：数量有误");
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber).reversed());
         exts.forEach(s -> s.setBoolScheduling(Boolean.FALSE).setSchedulingId(0L));
         exts = exts.stream().limit(dtoParam.getQuantity().intValue()).collect(Collectors.toList());
         needUpadte.addAll(exts);
         MesBuildingArtifactScheduling artifactScheduling = schedulingMap.get(dtoParam.getId());
         Preconditions.checkArgument(artifactScheduling != null, "操作失败：id有误");
         Preconditions.checkArgument(artifactScheduling.getQuantity() >= dtoParam.getQuantity(), "操作失败：数量有误");
         artifactScheduling.setQuantity(artifactScheduling.getQuantity() - dtoParam.getQuantity());
      });
      List<MesBuildingArtifactScheduling> schedulings = new ArrayList<>(schedulingMap.values());
      this.baseService.updateBatchById(schedulings);
      List<Long> needRemoveIds = schedulings.stream()
         .filter(s -> s.getQuantity().equals(0))
         .map(MesBuildingArtifactScheduling::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needRemoveIds)) {
         this.baseService.removeByIds(needRemoveIds);
      }

      this.techArtifactExtService.updateBatchById(needUpadte);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteArtifactSchedulingV8(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<Long> schedulingIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> schedulingList = this.baseService.listByIds(schedulingIds);
      Preconditions.checkArgument(schedulingList.stream().noneMatch(MesBuildingArtifactScheduling::getIssueStatus), "操作失败：排产已下发");
      Map<Long, MesBuildingArtifactScheduling> schedulingMap = schedulingList.stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
      List<TechArtifactExt> artifactExts = this.techArtifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).in(TechArtifactExt::getSchedulingId, schedulingIds));
      Map<Long, List<TechArtifactExt>> artExtMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));
      List<TechArtifactExt> needUpadte = new ArrayList<>();
      dtoParamList.forEach(dtoParam -> {
         List<TechArtifactExt> exts = artExtMap.get(dtoParam.getId());
         Preconditions.checkArgument(exts.size() >= dtoParam.getQuantity(), "操作失败：数量有误");
         exts.sort(Comparator.comparingInt(TechArtifactExt::getSortNumber).reversed());
         exts.forEach(s -> s.setBoolScheduling(Boolean.FALSE).setSchedulingId(0L));
         exts = exts.stream().limit(dtoParam.getQuantity().intValue()).collect(Collectors.toList());
         needUpadte.addAll(exts);
         MesBuildingArtifactScheduling artifactScheduling = schedulingMap.get(dtoParam.getId());
         Preconditions.checkArgument(artifactScheduling != null, "操作失败：id有误");
         Preconditions.checkArgument(artifactScheduling.getQuantity() >= dtoParam.getQuantity(), "操作失败：数量有误");
         artifactScheduling.setQuantity(artifactScheduling.getQuantity() - dtoParam.getQuantity());
      });
      List<MesBuildingArtifactScheduling> schedulings = new ArrayList<>(schedulingMap.values());
      this.baseService.updateBatchById(schedulings);
      List<Long> needRemoveIds = schedulings.stream()
         .filter(s -> s.getQuantity().equals(0))
         .map(MesBuildingArtifactScheduling::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needRemoveIds)) {
         this.baseService.removeByIds(needRemoveIds);
      }

      this.techArtifactExtService.updateBatchById(needUpadte);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssemble(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      Map<Long, SysAssembleConfig> assembleConfigMap = this.assembleConfigService
         .list()
         .stream()
         .collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
      List<MesBuildingArtifactScheduling> schedulingList = this.listByIds(
         dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList())
      );
      List<Long> groupIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getGroupsId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(groupIds.size() == 1, "操作失败!!!构件不支持跨生产组任务下发!!!!");
      Map<Long, Map<Long, List<MesBuildingArtifactScheduling>>> groupsArtifactMap = schedulingList.stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactScheduling::getGroupsId, Collectors.groupingBy(MesBuildingArtifactScheduling::getProductId)));
      List<Long> artifactIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
      Map<Long, List<TechAssembleDetail>> artLinkMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<String, MesBuildingAssembleSchedulingDTO> assSchedulingMap = new HashMap<>();
      if (assembleDetailList.size() > 0) {
         List<Long> assembleIdList = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> techAssembles = this.assembleService.listByIds(assembleIdList);
         Map<Long, TechAssemble> techAssembleMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));

         for (MesBuildingArtifactScheduling artScheduling : schedulingList) {
            List<TechAssembleDetail> details = artLinkMap.getOrDefault(artScheduling.getProductId(), new ArrayList<>());
            TechArtifact artifact = artifactMap.get(artScheduling.getProductId());
            Boolean booleOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());

            for (TechAssembleDetail detail : details) {
               TechAssemble assemble = techAssembleMap.get(detail.getAssembleId());
               Boolean boolSectionSteel = assemble.getBoolSectionSteel();
               Integer typesettingAssembleTypeEnum = boolSectionSteel
                  ? MesBuildingTypesettingAssembleTypeEnum.FINISHED.getType()
                  : MesBuildingTypesettingAssembleTypeEnum.WELDING.getType();
               MesBuildingAssembleSchedulingDTO dto = assSchedulingMap.get(assemble.getId() + "_" + booleOneCode);
               int appendQuantity = (artScheduling.getQuantity() - artScheduling.getTaskQuantity()) * detail.getQuantity();
               BigDecimal appendWeight = assemble.getNetWeight().multiply(new BigDecimal(appendQuantity));
               if (dto == null) {
                  MesBuildingAssembleSchedulingDTO build = MesBuildingAssembleSchedulingDTO.builder()
                     .projectId(assemble.getProjectId())
                     .productId(assemble.getId())
                     .serialNumber(assemble.getSerialNumber())
                     .material(assemble.getMaterial())
                     .specification(assemble.getSpecification())
                     .length(assemble.getLength())
                     .quantity(appendQuantity)
                     .netWeight(assemble.getNetWeight())
                     .totalNetWeight(appendWeight)
                     .boolProcess(assemble.getBoolProcess())
                     .boolSectionSteel(boolSectionSteel)
                     .assembleConfigId(assemble.getAssembleConfigId())
                     .typesettingAssembleTypeEnum(typesettingAssembleTypeEnum)
                     .boolOneCode(booleOneCode)
                     .build();
                  assSchedulingMap.put(assemble.getId() + "_" + booleOneCode, build);
               } else {
                  dto.setQuantity(dto.getQuantity() + appendQuantity);
                  dto.setTotalNetWeight(dto.getTotalNetWeight().add(appendWeight));
               }
            }
         }
      }

      List<MesBuildingAssembleSchedulingDTO> assembleList = new ArrayList<>(assSchedulingMap.values());
      if (CollectionUtils.isNotEmpty(assembleList)) {
         assembleList = assembleList.stream()
            .sorted(Comparator.comparing(MesBuildingAssembleSchedulingDTO::getSpecification).thenComparing(MesBuildingAssembleSchedulingDTO::getLength))
            .collect(Collectors.toList());
      }

      return assembleList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssembleV8(Long areaId) {
      List<MesBuildingArtifactScheduling> schedulingList = this.list(
         Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).eq(MesBuildingArtifactScheduling::getAreaId, areaId)
      );
      List<Long> artifactIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
      Map<Long, List<TechAssembleDetail>> artLinkMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<String, MesBuildingAssembleSchedulingDTO> assSchedulingMap = new HashMap<>();
      if (assembleDetailList.size() > 0) {
         List<Long> assembleIdList = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> techAssembles = this.assembleService.listByIds(assembleIdList);
         List<SysAssembleConfig> sysAssembleConfigs = this.assembleConfigService
            .listByIds(techAssembles.stream().map(TechAssemble::getAssembleConfigId).distinct().collect(Collectors.toList()));
         Map<Long, SysAssembleConfig> configMap = sysAssembleConfigs.stream().collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
         Map<Long, TechAssemble> techAssembleMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         Map<Long, String> workShopMap = this.workshopService
            .list()
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, MesBuildingWorkshop::getName));
         MesBuildingTeamDOParam teamDOParam = MesBuildingTeamDOParam.builder().productType(ProductTypeEnum.ASSEMBLE.getType()).build();
         List<MesBuildingFactoryDTO> schedulingLineTree = this.productionLineService
            .getSchedulingLineTree(teamDOParam, sysAssembleConfigs.get(0).getMesProductEnum());
         List<MesBuildingProductProcess> mesBuildingProductProcessList = this.productProcessService
            .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
         mesBuildingProductProcessList = mesBuildingProductProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
         Map<String, MesBuildingProductProcess> productProcessMap = mesBuildingProductProcessList.stream()
            .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));

         for (MesBuildingArtifactScheduling artScheduling : schedulingList) {
            List<TechAssembleDetail> details = artLinkMap.getOrDefault(artScheduling.getProductId(), new ArrayList<>());
            TechArtifact artifact = artifactMap.get(artScheduling.getProductId());
            Boolean booleOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());

            for (TechAssembleDetail detail : details) {
               TechAssemble assemble = techAssembleMap.get(detail.getAssembleId());
               Boolean boolSectionSteel = assemble.getBoolSectionSteel();
               Integer typesettingAssembleTypeEnum = boolSectionSteel
                  ? MesBuildingTypesettingAssembleTypeEnum.FINISHED.getType()
                  : MesBuildingTypesettingAssembleTypeEnum.WELDING.getType();
               MesBuildingAssembleSchedulingDTO dto = assSchedulingMap.get(assemble.getId() + "_" + booleOneCode);
               int appendQuantity = (artScheduling.getQuantity() - artScheduling.getTaskQuantity()) * detail.getQuantity();
               BigDecimal appendWeight = assemble.getNetWeight().multiply(new BigDecimal(appendQuantity));
               SysAssembleConfig sysAssembleConfig = configMap.get(assemble.getAssembleConfigId());
               if (dto == null) {
                  MesBuildingAssembleSchedulingDTO build = MesBuildingAssembleSchedulingDTO.builder()
                     .workShopId(artScheduling.getWorkshopId())
                     .workShopName(workShopMap.get(artScheduling.getWorkshopId()))
                     .projectId(assemble.getProjectId())
                     .productId(assemble.getId())
                     .serialNumber(assemble.getSerialNumber())
                     .material(assemble.getMaterial())
                     .specification(assemble.getSpecification())
                     .length(assemble.getLength())
                     .quantity(appendQuantity)
                     .netWeight(assemble.getNetWeight())
                     .totalNetWeight(appendWeight)
                     .boolProcess(assemble.getBoolProcess())
                     .boolSectionSteel(boolSectionSteel)
                     .assembleConfigId(assemble.getAssembleConfigId())
                     .assembleConfigName(sysAssembleConfig == null ? null : sysAssembleConfig.getName())
                     .mesProductEnum(configMap.get(assemble.getAssembleConfigId()).getMesProductEnum())
                     .typesettingAssembleTypeEnum(typesettingAssembleTypeEnum)
                     .boolMainAssemble(assemble.getBoolMainAssemble())
                     .boolOneCode(booleOneCode)
                     .artifactAskCompleteTime(artScheduling.getAskCompleteTime())
                     .build();
                  if (CollectionUtils.isNotEmpty(schedulingLineTree)) {
                     schedulingLineTree.forEach(
                        e -> {
                           if (e.getWorkshopList() != null) {
                              e.getWorkshopList()
                                 .forEach(
                                    w -> {
                                       if (w.getProductionLineList() != null) {
                                          w.getProductionLineList()
                                             .forEach(
                                                p -> p.setHasProcess(
                                                   productProcessMap.containsKey(
                                                      p.getId() + "_" + ProductTypeEnum.ASSEMBLE.getType() + "_" + assemble.getAssembleConfigId()
                                                   )
                                                )
                                             );
                                       }
                                    }
                                 );
                           }
                        }
                     );
                     build.setSchedulingLineTree(schedulingLineTree);
                  }

                  assSchedulingMap.put(assemble.getId() + "_" + booleOneCode, build);
               } else {
                  dto.setQuantity(dto.getQuantity() + appendQuantity);
                  dto.setTotalNetWeight(dto.getTotalNetWeight().add(appendWeight));
                  dto.setAssembleConfigName(sysAssembleConfig == null ? null : sysAssembleConfig.getName());
               }
            }
         }
      }

      List<MesBuildingAssembleSchedulingDTO> assembleList = new ArrayList<>(assSchedulingMap.values());
      if (CollectionUtils.isNotEmpty(assembleList)) {
         assembleList = assembleList.stream()
            .sorted(Comparator.comparing(MesBuildingAssembleSchedulingDTO::getSpecification).thenComparing(MesBuildingAssembleSchedulingDTO::getSerialNumber))
            .collect(Collectors.toList());
      }

      return assembleList;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public List<MesBuildingAssembleSchedulingDTO> getArtifactSchedulingAssemble2(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      List<MesBuildingArtifactScheduling> schedulingList = this.listByIds(
         dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList())
      );
      List<Long> lineIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductionLineId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(lineIds.size() == 1, "操作失败!!!构件不支持跨生产线任务下发!!!!");
      List<Long> artifactIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductId).collect(Collectors.toList());
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      Map<Long, TechArtifact> artifactMap = artifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
      Map<Long, List<TechAssembleDetail>> artLinkMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
      Map<String, MesBuildingAssembleSchedulingDTO> assSchedulingMap = new HashMap<>();
      if (assembleDetailList.size() > 0) {
         List<Long> assembleIdList = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> techAssembles = this.assembleService.listByIds(assembleIdList);
         List<SysAssembleConfig> sysAssembleConfigs = this.assembleConfigService
            .listByIds(techAssembles.stream().map(TechAssemble::getAssembleConfigId).distinct().collect(Collectors.toList()));
         Map<Long, SysAssembleConfig> configMap = sysAssembleConfigs.stream().collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
         Map<Long, TechAssemble> techAssembleMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         Map<Long, String> workShopMap = this.workshopService
            .list()
            .stream()
            .collect(Collectors.toMap(MesBuildingWorkshop::getId, MesBuildingWorkshop::getName));
         MesBuildingTeamDOParam teamDOParam = MesBuildingTeamDOParam.builder().productType(ProductTypeEnum.ASSEMBLE.getType()).build();
         List<MesBuildingFactoryDTO> schedulingLineTree = this.productionLineService
            .getSchedulingLineTree(teamDOParam, sysAssembleConfigs.get(0).getMesProductEnum());
         List<MesBuildingProductProcess> mesBuildingProductProcessList = this.productProcessService
            .list((Wrapper<MesBuildingProductProcess>)new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE));
         mesBuildingProductProcessList = mesBuildingProductProcessList.stream().filter(item -> item.getPartType() == null).collect(Collectors.toList());
         Map<String, MesBuildingProductProcess> productProcessMap = mesBuildingProductProcessList.stream()
            .collect(Collectors.toMap(s -> s.getProductionLineId() + "_" + s.getProductType() + "_" + s.getTypeId(), Function.identity()));

         for (MesBuildingArtifactScheduling artScheduling : schedulingList) {
            List<TechAssembleDetail> details = artLinkMap.getOrDefault(artScheduling.getProductId(), new ArrayList<>());
            TechArtifact artifact = artifactMap.get(artScheduling.getProductId());
            Boolean booleOneCode = artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType());

            for (TechAssembleDetail detail : details) {
               TechAssemble assemble = techAssembleMap.get(detail.getAssembleId());
               Boolean boolSectionSteel = assemble.getBoolSectionSteel();
               Integer typesettingAssembleTypeEnum = boolSectionSteel
                  ? MesBuildingTypesettingAssembleTypeEnum.FINISHED.getType()
                  : MesBuildingTypesettingAssembleTypeEnum.WELDING.getType();
               MesBuildingAssembleSchedulingDTO dto = assSchedulingMap.get(assemble.getId() + "_" + booleOneCode);
               int appendQuantity = (artScheduling.getQuantity() - artScheduling.getTaskQuantity()) * detail.getQuantity();
               BigDecimal appendWeight = assemble.getNetWeight().multiply(new BigDecimal(appendQuantity));
               SysAssembleConfig sysAssembleConfig = configMap.get(assemble.getAssembleConfigId());
               if (dto == null) {
                  MesBuildingAssembleSchedulingDTO build = MesBuildingAssembleSchedulingDTO.builder()
                     .workShopId(artScheduling.getWorkshopId())
                     .workShopName(workShopMap.get(artScheduling.getWorkshopId()))
                     .projectId(assemble.getProjectId())
                     .productId(assemble.getId())
                     .serialNumber(assemble.getSerialNumber())
                     .material(assemble.getMaterial())
                     .specification(assemble.getSpecification())
                     .length(assemble.getLength())
                     .quantity(appendQuantity)
                     .netWeight(assemble.getNetWeight())
                     .totalNetWeight(appendWeight)
                     .boolProcess(assemble.getBoolProcess())
                     .boolSectionSteel(boolSectionSteel)
                     .assembleConfigId(assemble.getAssembleConfigId())
                     .assembleConfigName(sysAssembleConfig == null ? null : sysAssembleConfig.getName())
                     .mesProductEnum(configMap.get(assemble.getAssembleConfigId()).getMesProductEnum())
                     .typesettingAssembleTypeEnum(typesettingAssembleTypeEnum)
                     .boolMainAssemble(assemble.getBoolMainAssemble())
                     .boolOneCode(booleOneCode)
                     .artifactAskCompleteTime(artScheduling.getAskCompleteTime())
                     .build();
                  if (CollectionUtils.isNotEmpty(schedulingLineTree)) {
                     schedulingLineTree.forEach(
                        e -> {
                           if (e.getWorkshopList() != null) {
                              e.getWorkshopList()
                                 .forEach(
                                    w -> {
                                       if (w.getProductionLineList() != null) {
                                          w.getProductionLineList()
                                             .forEach(
                                                p -> p.setHasProcess(
                                                   productProcessMap.containsKey(
                                                      p.getId() + "_" + ProductTypeEnum.ASSEMBLE.getType() + "_" + assemble.getAssembleConfigId()
                                                   )
                                                )
                                             );
                                       }
                                    }
                                 );
                           }
                        }
                     );
                     build.setSchedulingLineTree(schedulingLineTree);
                  }

                  assSchedulingMap.put(assemble.getId() + "_" + booleOneCode, build);
               } else {
                  dto.setQuantity(dto.getQuantity() + appendQuantity);
                  dto.setTotalNetWeight(dto.getTotalNetWeight().add(appendWeight));
                  dto.setAssembleConfigName(sysAssembleConfig == null ? null : sysAssembleConfig.getName());
               }
            }
         }
      }

      List<MesBuildingAssembleSchedulingDTO> assembleList = new ArrayList<>(assSchedulingMap.values());
      if (CollectionUtils.isNotEmpty(assembleList)) {
         assembleList = assembleList.stream()
            .sorted(Comparator.comparing(MesBuildingAssembleSchedulingDTO::getSpecification).thenComparing(MesBuildingAssembleSchedulingDTO::getSerialNumber))
            .collect(Collectors.toList());
      }

      return assembleList;
   }

   @Override
   public Map<String, List<String>> getArtifactSchedulingAssembleFilterCriteria(List<MesBuildingArtifactSchedulingDTOParam> dtoParamList) {
      Map<String, List<String>> resultMap = new HashMap<>();
      List<MesBuildingArtifactScheduling> schedulingList = this.listByIds(
         dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getId).collect(Collectors.toList())
      );
      List<Long> lineIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductionLineId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(lineIds.size() == 1, "操作失败!!!构件不支持跨生产线任务下发!!!!");
      List<Long> artifactIds = schedulingList.stream().map(MesBuildingArtifactScheduling::getProductId).collect(Collectors.toList());
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, artifactIds));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<TechAssemble> techAssembles = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         List<SysAssembleConfig> sysAssembleConfigs = this.assembleConfigService
            .listByIds(techAssembles.stream().map(TechAssemble::getAssembleConfigId).distinct().collect(Collectors.toList()));
         Map<Long, SysAssembleConfig> configMap = sysAssembleConfigs.stream().collect(Collectors.toMap(SysAssembleConfig::getId, Function.identity()));
         List<String> assembleNameList = techAssembles.stream().map(TechAssemble::getName).distinct().collect(Collectors.toList());
         List<String> specificationList = techAssembles.stream().map(TechAssemble::getSpecification).distinct().collect(Collectors.toList());
         List<String> assembleConfigNameList = techAssembles.stream()
            .map(e -> configMap.get(e.getAssembleConfigId()).getName())
            .distinct()
            .collect(Collectors.toList());
         resultMap.put("name", assembleNameList);
         resultMap.put("specification", specificationList);
         resultMap.put("assembleConfigName", assembleConfigNameList);
      }

      return resultMap;
   }

   @Override
   public Integer getArtifactSchedulingRecordCount(List<Long> areaIdList) {
      MesBuildingArtifactSchedulingDTOParam dtoParam = MesBuildingArtifactSchedulingDTOParam.builder().areaIdList(areaIdList).build();
      return this.getArtifactSchedulingRecordList(dtoParam).size();
   }

   @Override
   public Integer getArtifactSchedulingRecordCount2(List<Long> areaIdList) {
      MesBuildingArtifactSchedulingDTOParam dtoParam = MesBuildingArtifactSchedulingDTOParam.builder().areaIdList(areaIdList).build();
      return this.getArtifactSchedulingRecordList2(dtoParam).size();
   }

   @Override
   public Integer getArtifactSchedulingRecordCountV8(List<Long> areaIdList) {
      MesBuildingArtifactSchedulingDTOParam dtoParam = MesBuildingArtifactSchedulingDTOParam.builder().areaIdList(areaIdList).build();
      return this.getArtifactSchedulingRecordListV8(dtoParam).size();
   }

   @Override
   public PageVO<ProductMonitorKanbanDTO> getProductMonitorKanbanPage(
      Long workshopId, Integer status, String name, Integer projectType, Integer lumpSumSystemType, Integer pageNumber, Integer pageSize
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new PageVO<>();
      }

      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ProductMonitorKanbanDTO> productMonitorKanban = this.taskBiz.getProductMonitorKanban(workshopId, status, name, projectIds);
      return new PageVO<>(page, productMonitorKanban);
   }

   @Override
   public List<ProductMonitorKanbanDTO> getProductMonitorKanbanList(
      Long workshopId, Integer status, String name, Integer projectType, Integer lumpSumSystemType
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return projectIds.size() == 0 ? new ArrayList<>() : this.taskBiz.getProductMonitorKanban(workshopId, status, name, projectIds);
   }

   @Override
   public PageVO<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingProductionTaskDTO> dtoList = this.taskBiz.getProductMonitorKanbanDetail(workshopId, projectId, monomerId, areaId);
      return new PageVO<>(dtoList);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDTO> getProductMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum) {
      List<MesBuildingTeam> teamList = this.buildingTeamService.list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getProcessId, processId));
      if (teamList.size() == 0) {
         return new ArrayList<>();
      }

      List<Long> teamIds = teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList());
      List<MesBuildingGroupsTeamLink> groupsTeamLinkList = this.groupsTeamLinkBiz
         .list(Wrappers.lambdaQuery(MesBuildingGroupsTeamLink.class).in(MesBuildingGroupsTeamLink::getTeamId, teamIds));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineBiz
         .listByIds(teamList.stream().map(e -> e.getProductionLineId()).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      List<MesBuildingTeamUserLink> userLinkList = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, teamIds)
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
         );
      Map<Long, String> map = userLinkList.stream().collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, MesBuildingTeamUserLink::getUserName));
      Map<Long, List<ProductMonitorKanbanByGroupDO>> lastMonthMete = this.taskProcessBiz
         .getProductByLastMonth(workshopId, processId, taskTypeEnum)
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProductionLine().getId()));
      Map<Long, List<ProductMonitorKanbanByGroupDO>> yearmete = this.taskProcessBiz
         .getProductByYear(workshopId, processId, taskTypeEnum)
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProductionLine().getId()));
      Map<Long, List<ProductMonitorKanbanByGroupDO>> quantityAndWeightDetailDO = this.taskProcessBiz
         .getProductByUnComplete(workshopId, processId, taskTypeEnum)
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProductionLine().getId()));
      return teamList.stream()
         .map(
            e -> ProductMonitorKanbanByGroupDTO.builder()
               .team(IdAndNameDO.builder().id(e.getId()).name(map.get(e.getId())).build())
               .productionLine(
                  ProductionLineDetailDO.builder().id(e.getProductionLineId()).name(productionLineMap.get(e.getProductionLineId()).getName()).build()
               )
               .taskTypeEnum(productionLineMap.get(e.getProductionLineId()).getProductType())
               .lastMonthQuantity(
                  lastMonthMete.get(e.getProductionLineId()) == null
                     ? 0
                     : lastMonthMete.get(e.getProductionLineId()).stream().mapToInt(ProductMonitorKanbanByGroupDO::getQuantity).sum()
               )
               .lastMonthNetWeight(
                  lastMonthMete.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : lastMonthMete.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .lastMonthGrossWeight(
                  lastMonthMete.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : lastMonthMete.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalGrossWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .yearQuantity(
                  yearmete.get(e.getProductionLineId()) == null
                     ? 0
                     : yearmete.get(e.getProductionLineId()).stream().mapToInt(ProductMonitorKanbanByGroupDO::getQuantity).sum()
               )
               .yearNetWeight(
                  yearmete.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : yearmete.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .yearGrossWeight(
                  yearmete.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : yearmete.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalGrossWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .unQuantity(
                  quantityAndWeightDetailDO.get(e.getProductionLineId()) == null
                     ? 0
                     : quantityAndWeightDetailDO.get(e.getProductionLineId()).stream().mapToInt(ProductMonitorKanbanByGroupDO::getQuantity).sum()
               )
               .unNetWeight(
                  quantityAndWeightDetailDO.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : quantityAndWeightDetailDO.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalNetWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .unGrossWeight(
                  quantityAndWeightDetailDO.get(e.getProductionLineId()) == null
                     ? BigDecimal.ZERO
                     : quantityAndWeightDetailDO.get(e.getProductionLineId())
                        .stream()
                        .map(ProductMonitorKanbanByGroupDO::getTotalGrossWeight)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .build()
         )
         .filter(e -> e.getUnQuantity() > 0 || e.getLastMonthQuantity() > 0 || e.getYearQuantity() > 0)
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProductMonitorByGroupDetailDTO> dtoList = this.taskProcessBiz
         .getProductMonitorKanbanByGroupDetail(
            workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber
         );
      return new PageVO<>(dtoList);
   }

   @Override
   public ProductMonitorKanbanBySummaryDTO getProductMonitorKanbanSummary(Long workshopId, Integer projectType, Integer lumpSumSystemType) {
      List<ProductMonitorKanbanDTO> productMonitorKanbanList = this.getProductMonitorKanbanList(workshopId, null, null, projectType, lumpSumSystemType);
      BigDecimal yearTotalNetWeight = this.artifactSchedulingList(LocalDateTime.now(), workshopId, 1, projectType, lumpSumSystemType)
         .stream()
         .map(ArtifactSchedulingDTO::getSchedulingTotalNetWeight)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal capacityNetWeight = this.productionLineBiz
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLine.class)
               .eq(workshopId != null, MesBuildingProductionLine::getWorkshopId, workshopId)
               .eq(MesBuildingProductionLine::getProductType, TaskTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .map(MesBuildingProductionLine::getTargetProduction)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .multiply(new BigDecimal(12));
      BigDecimal capacityRatio = BigDecimal.ZERO;
      if (capacityNetWeight.compareTo(yearTotalNetWeight) > 0 && capacityNetWeight.compareTo(BigDecimal.ZERO) != 0) {
         capacityRatio = capacityNetWeight.subtract(yearTotalNetWeight).divide(capacityNetWeight, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
      }

      return ProductMonitorKanbanBySummaryDTO.builder()
         .orderQuantity(productMonitorKanbanList.stream().map(ProductMonitorKanbanDTO::getProject).distinct().collect(Collectors.toList()).size())
         .taskNetWeight(yearTotalNetWeight)
         .yearAvgNetWeight(yearTotalNetWeight.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP))
         .capacityNetWeight(capacityNetWeight)
         .capacityRatio(capacityRatio)
         .unNetWeight(
            productMonitorKanbanList.stream()
               .map(ProductMonitorKanbanDTO::getTaskNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .subtract(productMonitorKanbanList.stream().map(ProductMonitorKanbanDTO::getCompleteNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         )
         .build();
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProductMonitorKanbanDetailPrint(Long workshopId, Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.taskBiz.getProductMonitorKanbanDetail(workshopId, projectId, monomerId, areaId).stream().map(BeanUtil::beanToMap).collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> getProductMonitorKanbanByGroupDetailPrint(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      printVO.setTable(
         this.taskProcessBiz
            .getProductMonitorKanbanByGroupDetail(
               workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber
            )
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public void exportArtifactSchedulingTemplate(HttpServletResponse response, Long areaId, Integer productType, Long structureClassId) {
      ServletOutputStream out = null;
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("files/ArtifactSchedule.xlsx");
      String fileName = "构件工单排产清单.xlsx";

      try {
         response.setContentType("application/vnd.ms-excel;charset=UTF-8");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("utf-8");
         out = response.getOutputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(inputStream).build();
      WriteSheet writeSheet = EasyExcel.writerSheet().build();
      FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
      List<GroupDetailDTO> productLine = this.getProductionLineAndGroupsList(productType, structureClassId);
      productLine.add(
         GroupDetailDTO.builder()
            .productionLineId(Long.valueOf("-1"))
            .productionLineName("完成日期")
            .groupId(Long.valueOf("-1"))
            .groupName("(例如:2023-01-01)")
            .build()
      );
      excelWriter.fill(new FillWrapper("data", productLine), fillConfig, writeSheet);
      excelWriter.finish();
   }

   @Override
   public void exportArtifactSchedulingTemplateAV2(
      HttpServletResponse response, Long areaId, Integer productType, Long structureClassId, Integer mesProductEnum
   ) {
      ServletOutputStream out = null;
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("files/ArtifactSchedule.xlsx");
      String fileName = "构件工单排产清单(仅已配置工序产线).xlsx";

      try {
         response.setContentType("application/vnd.ms-excel;charset=UTF-8");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("utf-8");
         out = response.getOutputStream();
      } catch (IOException e) {
         e.printStackTrace();
      }

      ExcelWriter excelWriter = EasyExcel.write(out).withTemplate(inputStream).build();
      WriteSheet writeSheet = EasyExcel.writerSheet().build();
      FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
      List<GroupDetailDTO> productLine = this.productionLineBiz.getWorkShopAndProductionLineList(productType, structureClassId, mesProductEnum);
      List<Long> prodLineIdList = this.productProcessService
         .list(
            ((new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
                  .eq(MesBuildingProductProcess::getTypeId, structureClassId))
               .select(MesBuildingProductProcess::getProductionLineId)
         )
         .stream()
         .map(MesBuildingProductProcess::getProductionLineId)
         .distinct()
         .collect(Collectors.toList());
      productLine = productLine.stream().filter(s -> prodLineIdList.contains(s.getProductionLineId())).collect(Collectors.toList());
      productLine.add(
         GroupDetailDTO.builder()
            .workshopId(Long.valueOf("-1"))
            .workshopName("完成日期")
            .productionLineId(Long.valueOf("-1"))
            .productionLineName("(例如:2023-01-01)")
            .build()
      );
      excelWriter.fill(new FillWrapper("data", productLine), fillConfig, writeSheet);
      excelWriter.finish();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public synchronized Boolean importArtifactScheduling(MultipartFile file, Long areaId, Integer productType) {
      List<Map<String, String>> importDTOS = new ArrayList<>();
      XSSFWorkbook wb = null;

      try {
         InputStream inputStream = file.getInputStream();
         String path = this.configProperties.getFilePath() + "excelScheduling" + File.separator;
         String fileName = file.getOriginalFilename();
         FileUtil.mkdirs(path);
         File file1 = new File(path + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + fileName);
         file.transferTo(file1);
         if (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls")) {
            throw new IllegalArgumentException("文件格式不正确！");
         }

         if (file.isEmpty()) {
            throw new Exception("文件为空！");
         }

         wb = new XSSFWorkbook(inputStream);
      } catch (Exception e) {
         e.printStackTrace();
      }

      Sheet sheet = wb.getSheetAt(0);
      int totalRow = 0;
      List<Integer> rowList = new ArrayList<>();
      int allcell = sheet.getRow(1).getLastCellNum();

      for (int num = 1; num <= sheet.getLastRowNum(); num++) {
         Row row = sheet.getRow(num);
         if (isRowEmpty(row, allcell)) {
            Preconditions.checkArgument(false, "第" + (num + 1) + "行存在空格!!请检查表格");
         } else {
            rowList.add(num);
            totalRow++;
         }
      }

      List<String> headList = new ArrayList<>();

      for (Integer rowNum : rowList) {
         List<String> dataList = new ArrayList<>();
         Map<String, String> map = new HashMap<>();
         if (rowNum == 1) {
            Row row = sheet.getRow(rowNum);
            int totalCellNum = row.getLastCellNum();

            for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
               String cell = String.valueOf(row.getCell(cellNum));
               headList.add(cell);
            }
         } else {
            Row rowData = sheet.getRow(rowNum);
            int totalCellNum = rowData.getLastCellNum();

            for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
               Cell cell = rowData.getCell(cellNum);
               String cellValue = null;
               Preconditions.checkArgument(cell != null, "生产线数据不能为空");
               if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                  if (!DateUtil.isCellDateFormatted(cell)) {
                     cell.setCellType(CellType.STRING);
                     cellValue = cell.getStringCellValue();
                  } else {
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                     Date date = cell.getDateCellValue();
                     cellValue = sdf.format(date);
                  }
               } else {
                  cell.setCellType(CellType.STRING);
                  cellValue = cell.getStringCellValue();
               }

               Preconditions.checkArgument(!"".equals(cellValue) && cellValue != null, "第" + (rowNum + 1) + "行 第" + (cellNum + 1) + "列 数据为空");
               dataList.add(cellValue);
            }

            for (int i = 0; i < headList.size(); i++) {
               if (dataList.size() > i) {
                  map.put(headList.get(i), dataList.get(i));
               } else {
                  map.put(headList.get(i), "0");
               }
            }

            importDTOS.add(map);
         }
      }

      Preconditions.checkArgument(headList.contains("完成日期*(例如:2023-01-01)") || headList.contains("完成日期"), "完成日期列丢失，请重新下载模板");
      Preconditions.checkArgument(headList.size() > 3, "至少有一条生产线");
      PlanArea area = this.planAreaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不能为空");
      List<String> notNumberList = new ArrayList<>();
      List<TechArtifact> artifactList = this.artifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getAreaId, areaId)
               .in(TechArtifact::getSerialNumber, importDTOS.stream().map(s -> s.get(headList.get(1).trim()).trim()).collect(Collectors.toList()))
         );
      Map<String, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getSerialNumber, Function.identity()));
      List<MesBuildingArtifactSchedulingDTOParam> dtoParamList = new ArrayList<>();

      for (int i = 0; i < importDTOS.size(); i++) {
         String serialNumber = importDTOS.get(i).get(headList.get(1)).trim();
         TechArtifact artifact = artifactMap.get(serialNumber);
         Preconditions.checkArgument(artifact != null, "编号为" + serialNumber + "的构件不存在");
         if (artifact.getStructureClassId() == null) {
            notNumberList.add(artifact.getSerialNumber());
         }

         Integer sum0 = 0;

         for (int j = 3; j < headList.size() - 1; j++) {
            String quantity = importDTOS.get(i).get(headList.get(j));
            if (!quantity.isEmpty()) {
               sum0 = sum0 + Integer.parseInt(quantity);
            }
         }

         Preconditions.checkArgument(sum0 == Integer.parseInt(importDTOS.get(i).get(headList.get(2))), "编号为" + serialNumber + "排产数量不等于汇总数量");
         Preconditions.checkArgument(sum0 <= artifact.getQuantity(), "编号为" + serialNumber + "排产数量不能大于清单量");
         Long productId = artifact.getId();

         for (int j = 3; j < headList.size() - 1; j++) {
            int sum = Integer.parseInt(importDTOS.get(i).get(headList.get(j)));
            String name = headList.get(j);
            String productionLineName = name.substring(0, name.lastIndexOf("*"));
            String groupsName = name.substring(name.lastIndexOf("*") + 1);
            MesBuildingGroups buildingGroups = this.groupsBiz.selectgroupByproductionLine(productionLineName, groupsName, productType);
            Preconditions.checkArgument(buildingGroups != null, name + "不存在");
            if (sum != 0) {
               String date = importDTOS.get(i).get(headList.get(headList.size() - 1));
               Boolean aBoolean = this.isDate(date);
               Preconditions.checkArgument(aBoolean.equals(true), "日期格式不正确(例:2023-01-01)");
               LocalDateTime localDateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
               Preconditions.checkArgument(LocalDateTime.now().isBefore(localDateTime), serialNumber + "完成日期不能为过去时间");
               MesBuildingArtifactSchedulingDTOParam dtoParam = MesBuildingArtifactSchedulingDTOParam.builder()
                  .factoryId(buildingGroups.getFactoryId())
                  .workshopId(buildingGroups.getWorkshopId())
                  .productionLineId(buildingGroups.getProductionLineId())
                  .groupsId(buildingGroups.getId())
                  .productId(productId)
                  .quantity(sum)
                  .askCompleteTime(localDateTime)
                  .build();
               dtoParamList.add(dtoParam);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(notNumberList) && CollectionUtils.isNotEmpty(notNumberList)) {
         StringBuilder s = new StringBuilder();
         int i = 0;

         for (String serialNumber : notNumberList) {
            i++;
            s.append(serialNumber).append(",");
            if (i % 15 == 0) {
               s.append("\n");
            }
         }

         Preconditions.checkArgument(false, s + "构件未修正，不允许导入");
      }

      Map<Long, List<MesBuildingArtifactSchedulingDTOParam>> dtoParamMap = dtoParamList.stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactSchedulingDTOParam::getProductId));
      List<Long> allArtIds = dtoParamList.stream().map(MesBuildingArtifactSchedulingDTOParam::getProductId).distinct().collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> allSchedulinged = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, allArtIds));
      Map<Long, List<MesBuildingArtifactScheduling>> artSchedulingMap = allSchedulinged.stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactScheduling::getProductId));
      dtoParamMap.forEach(
         (productIdx, list) -> {
            TechArtifact artifact = this.artifactService.getById(productIdx);
            int sumx = dtoParamMap.get(productIdx).stream().mapToInt(MesBuildingArtifactSchedulingDTOParam::getQuantity).sum();
            int sumed = artSchedulingMap.get(productIdx) == null
               ? 0
               : artSchedulingMap.get(productIdx).stream().mapToInt(MesBuildingArtifactScheduling::getQuantity).sum();
            Preconditions.checkArgument(sumx + sumed <= artifact.getQuantity(), artifact.getSerialNumber() + "排产总数量不能大于清单数量!!!");
         }
      );
      this.saveArtifactSchedulingList(dtoParamList);
      return true;
   }

   public static int getNumberOfNonEmptyCells(Row row) {
      int nonEmptyCellCount = 0;
      if (row != null) {
         for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
               nonEmptyCellCount++;
            } else if ((cell == null || cell.getCellType() == CellType.BLANK) && cellNum > 2 && cellNum < row.getLastCellNum() - 1) {
               row.createCell(cellNum).setCellValue("0");
               nonEmptyCellCount++;
            }
         }
      }

      return nonEmptyCellCount;
   }

   private static int getActualRowCount(Sheet sheet) {
      int actualRowCount = 0;

      for (Row row : sheet) {
         if (!isRowEmpty(row)) {
            actualRowCount++;
         }
      }

      return actualRowCount;
   }

   private static boolean isRowEmpty(Row row) {
      for (Cell cell : row) {
         if (cell.getCellType() != CellType.BLANK) {
            return false;
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public synchronized Boolean importArtifactSchedulingAV2(MultipartFile file, Long areaId, Integer productType) {
      PlanArea area = this.planAreaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不能为空");

      List<Map<String, String>> importDataList;
      List<String> headerList;
      try {
         importDataList = this.parseExcelFile(file);
         headerList = this.extractHeaderList(importDataList, file.getOriginalFilename());
      } catch (Exception e) {
         throw new BusinessException("文件解析失败: " + e.getMessage());
      }

      this.validateHeader(headerList);
      Map<String, TechArtifact> artifactMap = this.prepareArtifactData(importDataList, headerList, areaId);
      Map<String, MesBuildingWorkshop> workshopMap = this.workshopService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getName, Function.identity()));
      Map<String, MesBuildingProductionLine> productionLineMap = this.validateProductionLineConfig(headerList, workshopMap, productType);
      Map<Long, List<Long>> typeIdLineIdMap = this.prepareProductProcessData(artifactMap);
      Map<Long, String> classNameMap = this.prepareClassificationData(artifactMap);
      List<MesBuildingArtifactSchedulingDTOParam> schedulingParams = this.buildSchedulingParams(
         importDataList, headerList, artifactMap, workshopMap, productionLineMap, typeIdLineIdMap, classNameMap
      );
      this.validateTotalSchedulingQuantity(schedulingParams, artifactMap);
      return this.saveArtifactSchedulingList2(schedulingParams);
   }

   private List<Map<String, String>> parseExcelFile(MultipartFile file) throws IOException {
      String fileName = file.getOriginalFilename();
      Preconditions.checkArgument(fileName != null && (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")), "文件格式不正确！");
      Preconditions.checkArgument(!file.isEmpty(), "文件为空！");

      try (
         InputStream inputStream = file.getInputStream();
         XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
      ) {
         Sheet sheet = workbook.getSheetAt(0);
         int rowCount = getActualRowCount(sheet);
         Preconditions.checkArgument(rowCount > 2, "请导入有效清单");
         return this.extractDataFromSheet(sheet, rowCount);
      }
   }

   private void saveUploadedFile(MultipartFile file, String fileName) throws IOException {
      String path = this.configProperties.getFilePath() + "excelScheduling" + File.separator;
      FileUtil.mkdirs(path);
      String timestampFileName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + fileName;
      File savedFile = new File(path + timestampFileName);
      Files.copy(file.getInputStream(), savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
   }

   private List<Map<String, String>> extractDataFromSheet(Sheet sheet, int rowCount) {
      List<Map<String, String>> dataList = new ArrayList<>();
      List<Integer> validRowList = new ArrayList<>();
      int totalColumns = sheet.getRow(1).getLastCellNum();

      for (int rowNum = 1; rowNum < rowCount; rowNum++) {
         Row row = sheet.getRow(rowNum);
         Preconditions.checkArgument(!isRowEmpty(row, totalColumns), "第" + (rowNum + 1) + "行存在空格，请检查表格");
         validRowList.add(rowNum);
      }

      List<String> headerList = new ArrayList<>();

      for (Integer rowNum : validRowList) {
         if (rowNum == 1) {
            this.extractHeaderFromRow(sheet.getRow(rowNum), headerList);
         } else {
            Map<String, String> rowData = this.processDataRow(sheet.getRow(rowNum), headerList);
            dataList.add(rowData);
         }
      }

      return dataList;
   }

   private void extractHeaderFromRow(Row headerRow, List<String> headerList) {
      int totalCellNum = getNumberOfNonEmptyCells(headerRow);

      for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
         String cellValue = String.valueOf(headerRow.getCell(cellNum));
         headerList.add(cellValue);
      }
   }

   private Map<String, String> processDataRow(Row dataRow, List<String> headerList) {
      Map<String, String> rowData = new LinkedHashMap<>();
      List<String> cellValues = new ArrayList<>();
      int totalCellNum = getNumberOfNonEmptyCells(dataRow);

      for (int cellNum = 0; cellNum < totalCellNum; cellNum++) {
         Cell cell = dataRow.getCell(cellNum);
         Preconditions.checkArgument(cell != null, "生产线数据不能为空");
         String cellValue = this.getCellValueAsString(cell);
         Preconditions.checkArgument(StringUtils.isNotBlank(cellValue), "第" + (dataRow.getRowNum() + 1) + "行 第" + (cellNum + 1) + "列 数据为空");
         cellValues.add(cellValue);
      }

      for (int i = 0; i < headerList.size(); i++) {
         String value = i < cellValues.size() ? cellValues.get(i) : "0";
         rowData.put(headerList.get(i), value);
      }

      return rowData;
   }

   private String getCellValueAsString(Cell cell) {
      if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
         if (DateUtil.isCellDateFormatted(cell)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(cell.getDateCellValue());
         } else {
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
         }
      } else {
         cell.setCellType(CellType.STRING);
         return cell.getStringCellValue();
      }
   }

   private List<String> extractHeaderList(List<Map<String, String>> dataList, String fileName) {
      if (CollectionUtils.isEmpty(dataList)) {
         throw new BusinessException("Excel文件中没有数据");
      } else {
         return new ArrayList<>(dataList.get(0).keySet());
      }
   }

   private void validateHeader(List<String> headerList) {
      Preconditions.checkArgument(headerList.size() > 3, "至少需要一条生产线数据");
      Preconditions.checkArgument(headerList.contains("完成日期*(例如:2023-01-01)") || headerList.contains("完成日期"), "完成日期列丢失，请重新下载模板");
   }

   private Map<String, TechArtifact> prepareArtifactData(List<Map<String, String>> dataList, List<String> headerList, Long areaId) {
      List<String> serialNumbers = dataList.stream().map(row -> row.get(headerList.get(1)).trim()).collect(Collectors.toList());
      PlanArea area = this.planAreaService.getById(areaId);
      Preconditions.checkArgument(area != null, "区域不能为空");
      List<TechArtifact> artifactList = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).eq(TechArtifact::getAreaId, areaId).in(TechArtifact::getSerialNumber, serialNumbers));
      Preconditions.checkArgument(
         CollectionUtils.isNotEmpty(artifactList),
         "任务清单导入无有效[" + String.join(",", artifactList.stream().map(TechArtifact::getSerialNumber).collect(Collectors.toList())) + "]构件"
      );
      this.checkUncorrectedArtifacts(artifactList);
      return artifactList.stream().collect(Collectors.toMap(TechArtifact::getSerialNumber, Function.identity()));
   }

   private void checkUncorrectedArtifacts(List<TechArtifact> artifactList) {
      List<String> uncorrectedArtifacts = artifactList.stream()
         .filter(artifact -> artifact.getStructureClassId() == null)
         .map(TechArtifact::getSerialNumber)
         .collect(Collectors.toList());
      if (!uncorrectedArtifacts.isEmpty()) {
         StringBuilder errorMessage = new StringBuilder();

         for (int i = 0; i < uncorrectedArtifacts.size(); i++) {
            errorMessage.append(uncorrectedArtifacts.get(i)).append(",");
            if ((i + 1) % 15 == 0) {
               errorMessage.append("\n");
            }
         }

         throw new BusinessException(errorMessage + "构件未修正，不允许导入");
      }
   }

   private Map<String, MesBuildingProductionLine> validateProductionLineConfig(
      List<String> headerList, Map<String, MesBuildingWorkshop> workshopMap, Integer productType
   ) {
      LambdaQueryWrapper<MesBuildingProductionLine> queryWrapper = Wrappers.lambdaQuery(MesBuildingProductionLine.class);
      headerList.subList(3, headerList.size() - 1)
         .stream()
         .map(header -> {
            String workshopName = header.substring(0, header.indexOf("*"));
            String lineName = header.substring(header.lastIndexOf("*") + 1);
            Long workshopId = workshopMap.get(workshopName).getId();
            return new SimpleEntry<>(workshopId, lineName);
         })
         .forEach(
            entry -> {
               LambdaQueryWrapper var10000 = queryWrapper.or(
                  wrapper -> {
                     LambdaQueryWrapper var10000x = wrapper.eq(MesBuildingProductionLine::getName, entry.getValue())
                        .eq(MesBuildingProductionLine::getWorkshopId, entry.getKey());
                  }
               );
            }
         );
      List<MesBuildingProductionLine> productionLines = this.productionLineService.list(queryWrapper);
      Set<Long> configuredLineIds = this.productProcessService
         .list(
            (new LambdaQueryWrapper<MesBuildingProductProcess>().eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE))
               .select(MesBuildingProductProcess::getProductionLineId)
         )
         .stream()
         .map(MesBuildingProductProcess::getProductionLineId)
         .collect(Collectors.toSet());
      List<MesBuildingProductionLine> unconfiguredLines = productionLines.stream()
         .filter(line -> !configuredLineIds.contains(line.getId()))
         .collect(Collectors.toList());
      Preconditions.checkArgument(
         unconfiguredLines.isEmpty(), "操作失败，存在未配置工序的产线:" + unconfiguredLines.stream().map(MesBuildingProductionLine::getName).collect(Collectors.joining(","))
      );
      return productionLines.stream().collect(Collectors.toMap(e -> e.getWorkshopId() + "_" + e.getName(), Function.identity()));
   }

   private Map<Long, String> prepareClassificationData(Map<String, TechArtifact> artifactMap) {
      List<Long> classIds = artifactMap.values().stream().map(TechArtifact::getStructureClassId).distinct().collect(Collectors.toList());
      return this.classificationService.listByIds(classIds).stream().collect(Collectors.toMap(s -> s.getId(), s -> s.getClassificationName()));
   }

   private Map<Long, List<Long>> prepareProductProcessData(Map<String, TechArtifact> artifactMap) {
      List<Long> classIds = artifactMap.values().stream().map(TechArtifact::getStructureClassId).distinct().collect(Collectors.toList());
      List<MesBuildingProductProcess> productProcessList = this.productProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductProcess.class)
               .eq(MesBuildingProductProcess::getBoolHistory, Boolean.FALSE)
               .in(MesBuildingProductProcess::getTypeId, classIds)
               .eq(MesBuildingProductProcess::getProductType, TaskTypeEnum.ARTIFACT.getType())
         );
      return productProcessList.stream()
         .collect(
            Collectors.groupingBy(MesBuildingProductProcess::getTypeId, Collectors.mapping(MesBuildingProductProcess::getProductionLineId, Collectors.toList()))
         );
   }

   private List<MesBuildingArtifactSchedulingDTOParam> buildSchedulingParams(
      List<Map<String, String>> dataList,
      List<String> headerList,
      Map<String, TechArtifact> artifactMap,
      Map<String, MesBuildingWorkshop> workshopMap,
      Map<String, MesBuildingProductionLine> productionLineMap,
      Map<Long, List<Long>> typeIdLineIdMap,
      Map<Long, String> classNameMap
   ) {
      List<MesBuildingArtifactSchedulingDTOParam> schedulingParams = new ArrayList<>();

      for (Map<String, String> rowData : dataList) {
         String serialNumber = rowData.get(headerList.get(1)).trim();
         TechArtifact artifact = artifactMap.get(serialNumber);
         Preconditions.checkArgument(artifact != null, "编号为" + serialNumber + "的构件不存在");
         this.validateSchedulingQuantity(rowData, headerList, serialNumber, artifact.getQuantity());

         for (int j = 3; j < headerList.size() - 1; j++) {
            String quantityStr = rowData.get(headerList.get(j));
            if (!StringUtils.isBlank(quantityStr) && !"0".equals(quantityStr)) {
               int quantity = Integer.parseInt(quantityStr);
               String productionLineName = headerList.get(j).substring(headerList.get(j).lastIndexOf("*") + 1);
               String workshopName = headerList.get(j).substring(0, headerList.get(j).lastIndexOf("*"));
               MesBuildingWorkshop workshop = workshopMap.get(workshopName);
               Preconditions.checkArgument(workshop != null, workshopName + "不存在");
               MesBuildingProductionLine productionLine = productionLineMap.get(workshop.getId() + "_" + productionLineName);
               Preconditions.checkArgument(productionLine != null && productionLine.getWorkshopId().equals(workshop.getId()), headerList.get(j) + "不存在");
               List<Long> configuredLineIds = typeIdLineIdMap.get(artifact.getStructureClassId());
               Preconditions.checkArgument(
                  CollectionUtils.isNotEmpty(configuredLineIds) && configuredLineIds.contains(productionLine.getId()),
                  "产线名：" + productionLine.getName() + classNameMap.get(artifact.getStructureClassId()) + "未配置工序"
               );
               String dateStr = rowData.get(headerList.get(headerList.size() - 1));
               Preconditions.checkArgument(this.isDate(dateStr), "日期格式不正确(例:2023-01-01)");
               LocalDateTime completeTime = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
               Preconditions.checkArgument(LocalDateTime.now().isBefore(completeTime), serialNumber + "完成日期不能为过去时间");
               MesBuildingArtifactSchedulingDTOParam param = MesBuildingArtifactSchedulingDTOParam.builder()
                  .factoryId(productionLine.getFactoryId())
                  .workshopId(productionLine.getWorkshopId())
                  .productionLineId(productionLine.getId())
                  .productId(artifact.getId())
                  .quantity(quantity)
                  .askCompleteTime(completeTime)
                  .build();
               schedulingParams.add(param);
            }
         }
      }

      return schedulingParams;
   }

   private void validateSchedulingQuantity(Map<String, String> rowData, List<String> headerList, String serialNumber, int artifactQuantity) {
      int sumQuantity = 0;

      for (int j = 3; j < headerList.size() - 1; j++) {
         String quantityStr = rowData.get(headerList.get(j));
         if (StringUtils.isNotBlank(quantityStr)) {
            sumQuantity += Integer.parseInt(quantityStr);
         }
      }

      int scheduledQuantity = Integer.parseInt(rowData.get(headerList.get(2)));
      Preconditions.checkArgument(sumQuantity == scheduledQuantity, "编号为" + serialNumber + "排产数量不等于汇总数量");
      Preconditions.checkArgument(scheduledQuantity <= artifactQuantity, "编号为" + serialNumber + "排产数量不能大于清单量");
   }

   private void validateTotalSchedulingQuantity(List<MesBuildingArtifactSchedulingDTOParam> schedulingParams, Map<String, TechArtifact> artifactMap) {
      Map<Long, List<MesBuildingArtifactSchedulingDTOParam>> byProductId = schedulingParams.stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactSchedulingDTOParam::getProductId));
      List<Long> allArtifactIds = byProductId.keySet().stream().collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> existingSchedules = this.baseService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, allArtifactIds));
      Map<Long, Integer> existingSchedulingQuantity = existingSchedules.stream()
         .collect(Collectors.groupingBy(MesBuildingArtifactScheduling::getProductId, Collectors.summingInt(MesBuildingArtifactScheduling::getQuantity)));
      List<String> verifyArtifacts = new ArrayList<>();
      byProductId.forEach(
         (productId, params) -> {
            TechArtifact artifact = artifactMap.values()
               .stream()
               .filter(a -> a.getId().equals(productId))
               .findFirst()
               .orElseThrow(() -> new BusinessException("构件信息不存在: " + productId));
            int newQuantity = params.stream().mapToInt(MesBuildingArtifactSchedulingDTOParam::getQuantity).sum();
            int existingQuantity = existingSchedulingQuantity.getOrDefault(productId, 0);
            if (newQuantity + existingQuantity > artifact.getQuantity()) {
               verifyArtifacts.add(artifact.getSerialNumber());
            }
         }
      );
      if (!verifyArtifacts.isEmpty()) {
         StringBuilder errorMessage = new StringBuilder("编号为");

         for (int i = 0; i < verifyArtifacts.size(); i++) {
            errorMessage.append(verifyArtifacts.get(i));
            if (i < verifyArtifacts.size() - 1) {
               errorMessage.append(",");
               if ((i + 1) % 15 == 0) {
                  errorMessage.append("\n");
               }
            }
         }

         errorMessage.append("排产总数量不能大于清单数量");
         throw new BusinessException(errorMessage.toString());
      }
   }

   public static boolean isRowEmpty(Row row, Integer cellQuantity) {
      int cells = getNumberOfNonEmptyCells(row);
      if (cells != cellQuantity) {
         return true;
      }

      for (int i = row.getFirstCellNum(); i < cells; i++) {
         Cell cell = row.getCell(i);
         if (cell == null || cell.getCellType() == CellType.BLANK) {
            return true;
         }
      }

      return false;
   }

   @Override
   public List<ArtifactSchedulingDTO> artifactSchedulingList(
      LocalDateTime dateTime, Long workshopId, Integer type, Integer projectType, Integer lumpSumSystemType
   ) {
      List<ArtifactSchedulingDTO> dtoList = new ArrayList<>();
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      List<ArtifactSchedulingDO> artifactSchedulingDTOS = this.taskBiz.artifactSchedulingProjectList(dateTime, workshopId, projectIds);
      if (CollectionUtils.isEmpty(artifactSchedulingDTOS)) {
         return new ArrayList<>();
      }

      List<Long> monomerIds = artifactSchedulingDTOS.stream().map(ArtifactSchedulingDO::getMonomerId).distinct().collect(Collectors.toList());
      List<PlanMonomer> planMonomers = this.planMonomerService.listByIds(monomerIds);
      Map<Long, PlanMonomer> monomer = planMonomers.stream().collect(Collectors.toMap(PlanMonomer::getId, Function.identity()));
      Map<Long, List<ArtifactSchedulingDO>> monomerMap = artifactSchedulingDTOS.stream().collect(Collectors.groupingBy(ArtifactSchedulingDO::getMonomerId));

      for (Long monomerId : monomerMap.keySet()) {
         PlanMonomer planMonomer = monomer.get(monomerId);
         ContractProject project = this.projectService.getById(planMonomer.getProjectId());
         List<ArtifactSchedulingDO> list = monomerMap.get(monomerId);
         if (type == 1) {
            Map<String, List<ArtifactSchedulingDO>> collect = list.stream().collect(Collectors.groupingBy(s -> s.getDate().split("-")[1]));
            ArtifactSchedulingDTO dto = ArtifactSchedulingDTO.builder()
               .project(
                  ProjectDetailDO.builder()
                     .id(project.getId())
                     .serialNumber(project.getSerialNumber())
                     .name(project.getName())
                     .shortName(project.getShortName())
                     .build()
               )
               .monomer(MonomerDetailDO.builder().id(monomerId).name(planMonomer.getName()).build())
               .schedulingTotalNetWeight(list.stream().map(ArtifactSchedulingDO::getSchedulingTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .schedulingTotalGrossWeight(list.stream().map(ArtifactSchedulingDO::getSchedulingTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .completeTotalNetWeight(list.stream().map(ArtifactSchedulingDO::getCompleteTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .completeTotalGrossWeight(list.stream().map(ArtifactSchedulingDO::getCompleteTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
               .build();
            List<YearQuantityAndMeteDTO> mete = new ArrayList<>();

            for (String month : collect.keySet()) {
               List<ArtifactSchedulingDO> artifactSchedulingDOS = collect.get(month);
               mete.add(
                  YearQuantityAndMeteDTO.builder()
                     .date(month)
                     .totalNetWeight(
                        artifactSchedulingDOS.stream().map(ArtifactSchedulingDO::getSchedulingTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                     )
                     .totalGrossWeight(
                        artifactSchedulingDOS.stream().map(ArtifactSchedulingDO::getSchedulingTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                     )
                     .completeNetWeight(
                        artifactSchedulingDOS.stream().map(ArtifactSchedulingDO::getCompleteTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                     )
                     .completeGrossWeight(
                        artifactSchedulingDOS.stream().map(ArtifactSchedulingDO::getCompleteTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
                     )
                     .build()
               );
            }

            dto.setMete(mete);
            dtoList.add(dto);
         } else {
            ArtifactSchedulingDTO dto = ArtifactSchedulingDTO.builder()
               .project(
                  ProjectDetailDO.builder()
                     .id(project.getId())
                     .serialNumber(project.getSerialNumber())
                     .name(project.getName())
                     .shortName(project.getShortName())
                     .build()
               )
               .monomer(MonomerDetailDO.builder().id(monomerId).name(planMonomer.getName()).build())
               .build();
            List<Map<String, Object>> mapList = this.getScope(dateTime);
            List<YearQuantityAndMeteDTO> mete = new ArrayList<>();

            for (Map<String, Object> map : mapList) {
               String startDate = (String)map.get("start");
               String endDate = (String)map.get("end");
               long startTime = new SimpleDateFormat("yyyy-MM-dd").parse(startDate, new ParsePosition(0)).getTime();
               long endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endDate, new ParsePosition(0)).getTime();
               List<ArtifactSchedulingDO> collect = list.stream()
                  .filter(
                     s -> new SimpleDateFormat("yyyy-MM-dd").parse(s.getDate(), new ParsePosition(0)).getTime() >= startTime
                        && new SimpleDateFormat("yyyy-MM-dd").parse(s.getDate(), new ParsePosition(0)).getTime() <= endTime
                  )
                  .collect(Collectors.toList());
               mete.add(
                  YearQuantityAndMeteDTO.builder()
                     .date(startDate + "/" + endDate)
                     .totalNetWeight(collect.stream().map(ArtifactSchedulingDO::getSchedulingTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                     .totalGrossWeight(collect.stream().map(ArtifactSchedulingDO::getSchedulingTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                     .completeNetWeight(collect.stream().map(ArtifactSchedulingDO::getCompleteTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                     .completeGrossWeight(collect.stream().map(ArtifactSchedulingDO::getCompleteTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                     .build()
               );
            }

            dto.setMete(mete);
            dto.setSchedulingTotalNetWeight(mete.stream().map(YearQuantityAndMeteDTO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            dto.setSchedulingTotalGrossWeight(mete.stream().map(YearQuantityAndMeteDTO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            dto.setCompleteTotalNetWeight(mete.stream().map(YearQuantityAndMeteDTO::getCompleteNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            dto.setCompleteTotalGrossWeight(mete.stream().map(YearQuantityAndMeteDTO::getCompleteGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            dtoList.add(dto);
         }
      }

      return dtoList;
   }

   private List<Map<String, Object>> getScope(LocalDateTime dateTime) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String date = dateTime.format(dateTimeFormatter);
      String[] timeStrs = date.split("-");
      Calendar c = Calendar.getInstance();
      c.set(1, Integer.parseInt(timeStrs[0]));
      c.set(2, Integer.parseInt(timeStrs[1]) - 1);
      c.setFirstDayOfWeek(2);
      int weeks = c.getActualMaximum(4);
      LocalDate localDateate = LocalDate.parse(date, dateTimeFormatter);
      LocalDate firstDay = localDateate.with(TemporalAdjusters.firstDayOfMonth());
      String firstDayStr = firstDay.format(dateTimeFormatter);
      String sunStr = this.getSunOfWeek(firstDayStr, dateTimeFormatter);
      List<Map<String, Object>> weekInfos = new ArrayList<>();

      for (int i = 1; i <= weeks; i++) {
         Map<String, Object> weekInfo = new HashMap<>();
         if (i == 1) {
            weekInfo.put("start", firstDayStr);
            weekInfo.put("end", sunStr);
            weekInfo.put("order", i);
         } else if (i < weeks) {
            String monDay = this.getLastMonOfWeek(sunStr, dateTimeFormatter);
            sunStr = this.getSunOfWeek(monDay, dateTimeFormatter);
            weekInfo.put("start", monDay);
            weekInfo.put("end", sunStr);
            weekInfo.put("order", i);
         } else {
            String monDay = this.getLastMonOfWeek(sunStr, dateTimeFormatter);
            LocalDate lastDay = localDateate.with(TemporalAdjusters.lastDayOfMonth());
            String endDay = lastDay.format(dateTimeFormatter);
            weekInfo.put("start", monDay);
            weekInfo.put("end", endDay);
            weekInfo.put("order", i);
         }

         weekInfos.add(weekInfo);
      }

      return weekInfos;
   }

   private String getSunOfWeek(String time, DateTimeFormatter dateTimeFormatter) {
      LocalDate localDateate = LocalDate.parse(time, dateTimeFormatter);
      LocalDate endday = localDateate.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1L);
      return endday.format(dateTimeFormatter);
   }

   private String getLastMonOfWeek(String time, DateTimeFormatter dateTimeFormatter) {
      LocalDate localDateate = LocalDate.parse(time, dateTimeFormatter);
      LocalDate endday = localDateate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
      return endday.format(dateTimeFormatter);
   }

   @Override
   public PageVO<ArtifactSchedulingDetailDTO> artifactSchedulingDetailPage(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
      List<ArtifactSchedulingDetailDTO> detailDTOS = this.artifactSchedulingDetailList(dateTime, workshopId, projectId, monomerId, areaId, serialNumber);
      return new PageVO<>(page, detailDTOS);
   }

   @Override
   public List<ArtifactSchedulingDetailDTO> artifactSchedulingDetailList(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.taskBiz.artifactSchedulingDetail(dateTime, workshopId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public ArtifactSchedulingSummaryDTO artifactSchedulingSummary(
      LocalDateTime dateTime, Long workshopId, Integer type, Integer projectType, Integer lumpSumSystemType
   ) {
      List<ArtifactSchedulingDTO> dtoList = this.artifactSchedulingList(dateTime, workshopId, type, projectType, lumpSumSystemType);
      return ArtifactSchedulingSummaryDTO.builder()
         .projectQuantity(dtoList.stream().map(ArtifactSchedulingDTO::getProject).distinct().collect(Collectors.toList()).size())
         .schedulingTotalNetWeight(dtoList.stream().map(ArtifactSchedulingDTO::getSchedulingTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .schedulingTotalGrossWeight(dtoList.stream().map(ArtifactSchedulingDTO::getSchedulingTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeTotalNetWeight(dtoList.stream().map(ArtifactSchedulingDTO::getCompleteTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .completeTotalGrossWeight(dtoList.stream().map(ArtifactSchedulingDTO::getCompleteTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
         .build();
   }

   @Override
   public PrintVO<List<Map<String, Object>>> artifactSchedulingDetailPrint(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("date", LocalDateTime.now());
      printVO.setHeader(header);
      printVO.setTable(
         this.artifactSchedulingDetailList(dateTime, workshopId, projectId, monomerId, areaId, serialNumber)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   private List<GroupDetailDTO> getProductionLineAndGroupsList(Integer productType, Long structureClassId) {
      return this.groupsBiz.getProductionLineAndGroupsList(productType, structureClassId);
   }

   private Boolean isDate(String sDate) {
      String simpleDateFormat = "yyyy-MM-dd";
      if (sDate == null) {
         return false;
      }

      DateFormat formatter = new SimpleDateFormat(simpleDateFormat);

      try {
         Date date = formatter.parse(sDate);
         return sDate.equals(formatter.format(date));
      } catch (Exception e) {
         return false;
      }
   }

   private List<MesBuildingArtifactSchedulingSurplusAssembleDTO> calculationMatchingArtifact(Map<Long, Integer> unMtchingAssembleMap, List<Long> schedulingIds) {
      if (unMtchingAssembleMap.size() == 0) {
         return null;
      }

      List<TechAssemble> assembleList = this.assembleService.listByIds(unMtchingAssembleMap.keySet());
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(
            Wrappers.lambdaQuery(TechAssembleDetail.class)
               .in(TechAssembleDetail::getAssembleId, assembleList.stream().map(TechAssemble::getId).collect(Collectors.toList()))
         );
      Map<Long, List<TechAssembleDetail>> assembleDetailMap = assembleDetailList.stream().collect(Collectors.groupingBy(TechAssembleDetail::getAssembleId));
      List<TechArtifact> artifactList = this.artifactService
         .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()));
      List<MesBuildingArtifactScheduling> schedulingList = this.list(
         Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
            .in(MesBuildingArtifactScheduling::getProductId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
      );
      Map<Long, MesBuildingGroups> groupsMap = new HashMap<>();
      if (schedulingList.size() > 0) {
         this.groupsBiz.listByIds(schedulingList.stream().map(MesBuildingArtifactScheduling::getGroupsId).collect(Collectors.toList())).forEach(e -> {
            MesBuildingGroups var10000 = groupsMap.put(e.getId(), e);
         });
      }

      return assembleList.stream()
         .map(
            e -> {
               MesBuildingArtifactSchedulingSurplusAssembleDTO dto = BeanUtil.copy(e, MesBuildingArtifactSchedulingSurplusAssembleDTO.class);
               List<MesBuildingSurplusAssembleMatchingArtifactDTO> matchingArtifactList = artifactList.stream()
                  .filter(
                     item -> assembleDetailMap.get(e.getId())
                           .stream()
                           .map(TechAssembleDetail::getArtifactId)
                           .collect(Collectors.toList())
                           .contains(item.getId())
                        && item.getQuantity()
                              - schedulingList.stream()
                                 .filter(scheduling -> scheduling.getProductId().equals(item.getId()))
                                 .mapToInt(MesBuildingArtifactScheduling::getTaskQuantity)
                                 .sum()
                           > 0
                  )
                  .map(
                     item -> {
                        MesBuildingSurplusAssembleMatchingArtifactDTO artifactDTO = BeanUtil.copy(item, MesBuildingSurplusAssembleMatchingArtifactDTO.class);
                        artifactDTO.setQuantity(
                           item.getQuantity()
                              - schedulingList.stream()
                                 .filter(scheduling -> scheduling.getProductId().equals(item.getId()))
                                 .mapToInt(scheduling -> schedulingIds.contains(scheduling.getId()) ? scheduling.getQuantity() : scheduling.getTaskQuantity())
                                 .sum()
                        );
                        artifactDTO.setArtifactSchedulingList(
                           schedulingList.stream()
                              .filter(
                                 scheduling -> scheduling.getQuantity() - scheduling.getTaskQuantity() > 0
                                    && scheduling.getProductId().equals(artifactDTO.getId())
                                    && !schedulingIds.contains(scheduling.getId())
                              )
                              .map(
                                 scheduling -> {
                                    MesBuildingArtifactSchedulingDTO artifactSchedulingDTO = BeanUtil.copy(scheduling, MesBuildingArtifactSchedulingDTO.class);
                                    artifactSchedulingDTO.setQuantity(scheduling.getQuantity() - scheduling.getTaskQuantity());
                                    artifactSchedulingDTO.setGroups(
                                       GroupsCurrencyDO.builder().name(groupsMap.get(scheduling.getGroupsId()).getName()).id(scheduling.getGroupsId()).build()
                                    );
                                    return artifactSchedulingDTO;
                                 }
                              )
                              .collect(Collectors.toList())
                        );
                        return artifactDTO;
                     }
                  )
                  .collect(Collectors.toList());
               dto.setArtifactList(matchingArtifactList);
               dto.setQuantity(unMtchingAssembleMap.get(dto.getId()));
               return dto;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public TeamScheduledSummaryDTO findTeamScheduledSummary(Long workshopId, Long projectId) {
      TeamScheduledSummaryDTO teamScheduledSummaryDTO = new TeamScheduledSummaryDTO();
      List<TeamScheduledInfoDTO> scheduledList = this.baseMapper.findTeamScheduledQuantity(workshopId, projectId);
      teamScheduledSummaryDTO.setTeamScheduledInfo(scheduledList);
      teamScheduledSummaryDTO.setTotalScheduledWeight(
         scheduledList.stream().map(TeamScheduledInfoDTO::getScheduledWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
      );
      return teamScheduledSummaryDTO;
   }
}
