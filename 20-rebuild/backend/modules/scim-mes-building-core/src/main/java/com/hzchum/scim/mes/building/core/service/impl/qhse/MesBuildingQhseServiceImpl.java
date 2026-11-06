package com.hzchum.scim.mes.building.core.service.impl.qhse;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.FileUtil;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.enums.QhseSimpleStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.QueryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MesBuildingQhseDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseRectify;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseAlertDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseGroupMonthByYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseWarnToDayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityInspectionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseRankingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.DateAndCount;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtNotRectifiedInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingInspectCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseRectifyDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.QhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseRectifyService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.qhse.MesBuildingQhseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesInspectUserInfoDTO;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingQhseServiceImpl extends ServiceImpl<MesBuildingQhseMapper, MesBuildingQhse> implements MesBuildingQhseService {
   @Autowired
   private SysDictionaryService sysDictionaryService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService mesBuildingProduceInspectionTeamReportService;
   @Autowired
   private MesBuildingTaskService mesBuildingTaskService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingQhseRectifyService qhseRectifyService;
   @Autowired
   private AttachmentService attachmentService;
   @Autowired
   private MesInspectConfigUserLinkService mesInspectConfigUserLinkService;
   @Autowired
   private MesInspectConfigService inspectConfigService;
   @Autowired
   private UserService userService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingCompleteService completeService;

   @Override
   public List<MesBuildingQhseDO> selectListByCondition(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Integer noStatus,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   ) {
      return this.baseMapper
         .selectListByCondition(
            qhseId,
            projectId,
            userName,
            dutyName,
            rectifyName,
            serialNumber,
            type,
            status,
            boolApp,
            userId,
            startDate,
            endDate,
            specifiedDate,
            qhseIds,
            noStatus,
            processId,
            levelOneType,
            levelTwoType
         );
   }

   @Override
   public MesBuildingQhseDetailDTO findQhseDetailList(Long qhseId) {
      return this.baseMapper.findQhseDetailList(qhseId);
   }

   @Override
   public MesBuildingQhseDTO selectQhseById(Long id, Long userId) {
      return BeanUtil.copy(this.baseMapper.selectQhseById(id, userId), MesBuildingQhseDTO.class);
   }

   @Override
   public Map<String, Object> report(String year) {
      Map<String, Object> result = new HashMap<>();
      result.put("summary", this.baseMapper.listGroupByType(year));
      Map<String, Object> details = new HashMap<>();

      for (QhseTypeEnum value : QhseTypeEnum.values()) {
         Map<String, Integer> items = new HashMap<>();
         this.baseMapper.listGroupByMonth(year, value.getType()).forEach(item -> {
            Integer var10000 = items.put(item.getMonth(), item.getQuantity());
         });
         details.put(value.getValue(), items);
      }

      result.put("details", details);
      return result;
   }

   @Override
   public List<QhseDetailsDTO> qhseSummaryList(LocalDateTime dateTime, Integer type, Long workShopId) {
      return this.baseMapper.qhseSummaryList(dateTime, type, workShopId);
   }

   @Override
   public Integer getQuantityType(LocalDateTime dateTime, Integer type) {
      return this.baseMapper.getQuantityType(dateTime, type);
   }

   @Override
   public List<MesBuildingQhse> getListByTimeAndType(LocalDateTime dateTime, Integer type) {
      return this.baseMapper.getListByTimeAndType(dateTime, type);
   }

   @Override
   public List<QhseDTOParam> getListTo() {
      return this.baseMapper.getListTo();
   }

   @Override
   public List<MesBuildingQhse> getListByTimesAndType(LocalDateTime time, Long workShopId, Integer type) {
      return this.baseMapper.getListByTimesAndType(time, workShopId, type);
   }

   @Override
   public List<ResponseVO> productionQualityAnalysis(String type, String projectId) {
      if (StrUtil.isBlank(projectId)) {
         if (StrUtil.isBlank(type)) {
            type = QueryTypeEnum.MONTH.getTypeEn();
         }
      } else {
         boolean isNum = NumberUtil.isNumber(projectId);
         if (!isNum) {
            return new ArrayList<>();
         }

         type = null;
      }

      List<ResponseVO> list = new ArrayList<>();

      for (SysDictionary dict : this.sysDictionaryService
         .list((Wrapper<SysDictionary>)new LambdaQueryWrapper<SysDictionary>().eq(SysDictionary::getName, DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName()))) {
         ResponseVO vo = new ResponseVO();
         vo.setVal(BigDecimal.valueOf(this.baseMapper.productionQuality(type, dict.getValue(), Long.valueOf(projectId)).intValue()));
         vo.setKey(dict.getLabel());
         list.add(vo);
      }

      return list;
   }

   @Override
   public Double firstPassRateOfQualityInspection(Long projectId) {
      List<Long> taskIds = new ArrayList<>();
      if (Objects.nonNull(projectId)) {
         taskIds = this.mesBuildingTaskService
            .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProjectId, projectId))
            .stream()
            .map(MesBuildingTask::getId)
            .collect(Collectors.toList());
      }

      double inspectionQuantity = this.mesBuildingProduceInspectionTeamReportService
         .list(
            (new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>().eq(MesBuildingProduceInspectionTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .in(CollectionUtils.isNotEmpty(taskIds), MesBuildingProduceInspectionTeamReport::getTaskId, taskIds)
         )
         .stream()
         .mapToDouble(MesBuildingProduceInspectionTeamReport::getInspectionQuantity)
         .sum();
      double problemQuantity = this.list(
            (Wrapper<MesBuildingQhse>)(new LambdaQueryWrapper<MesBuildingQhse>().eq(MesBuildingQhse::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .eq(MesBuildingQhse::getType, QhseTypeEnum.QUALITY.getType())
         )
         .stream()
         .mapToDouble(MesBuildingQhse::getProblemQuantity)
         .sum();
      double rate = 0.0;
      if (problemQuantity > 0.0 && inspectionQuantity > 0.0) {
         rate = NumberUtil.sub(1, NumberUtil.round(NumberUtil.div(problemQuantity, inspectionQuantity), 2)).doubleValue();
      }

      return rate;
   }

   @Override
   public List<DateAndCount> getQhseCountByYear(int year, Long processId, Long userId) {
      return this.baseMapper.getQhseCountByYear(year, processId, userId);
   }

   @Override
   public List<MesBuildingQhse> getQhseAnalyseByYear(int year, Long processId, Long userId) {
      return this.baseMapper.getQhseAnalyseByYear(year, processId, userId);
   }

   @Override
   public List<MesBuildingQhse> listByData(List<NumberInfoDTO> numberInfors, Integer taskType) {
      return this.baseMapper.listByData(numberInfors, taskType);
   }

   @Override
   public List<ArtNotRectifiedInfo> findInPackageNotRectifiedInfo(Set<Long> packageIds) {
      return this.baseMapper.findInPackageNotRectifiedInfo(packageIds);
   }

   @Override
   public List<ArtNotRectifiedInfo> findProductNotRectifiedInfo(Map<Long, List<Integer>> productMap) {
      Map<Long, List<Integer>> numberedProducts = new HashMap<>();
      if (productMap != null) {
         productMap.forEach((id, numbers) -> {
            if (CollectionUtils.isNotEmpty(numbers)) {
               numberedProducts.put(id, numbers);
            }
         });
      }
      return numberedProducts.isEmpty() ? Collections.emptyList() : this.baseMapper.findProductNotRectifiedInfo(numberedProducts);
   }

   @Override
   public void updateSql(String sql) {
      this.baseMapper.updateSql(sql);
   }

   @Override
   public QhseReportSummaryDTO findQhseReportSummary(Integer type) {
      List<MesBuildingQhse> qhses = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesBuildingQhse.class).last("and Year(create_time) = " + LocalDate.now().getYear() + " and type & " + type));
      int passType = QhseStatusEnum.ADOPT.getType() | QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType();
      int rectifiedQuantity = (int)qhses.stream().filter(e -> (e.getStatus() & passType) != 0 && (e.getType() & type) != 0).count();
      int concessionType = QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType()
         | QhseStatusEnum.CONCESSION_ACCEPTED.getType()
         | QhseStatusEnum.CONCESSION_ACCEPTED_UN_APPROVED.getType();
      int concessionQuantity = (int)qhses.stream().filter(e -> (e.getStatus() & concessionType) != 0 && (e.getType() & type) != 0).count();
      return QhseReportSummaryDTO.builder()
         .totalQualityCurrentYear(qhses.size())
         .rectifiedQuantity(rectifiedQuantity)
         .concessionQuantity(concessionQuantity)
         .build();
   }

   @Override
   public List<QhseReportDetailDTO> findQhseReportList(Long userId, LocalDate date) {
      List<QhseReportDetailDTO> dtos = this.baseMapper.selectQualityTypeQhseDetails(userId, date);
      dtos.forEach(
         e -> {
            List<MesBuildingQhseRectifyDTO> rectifyDTOS = this.qhseRectifyService
               .list((Wrapper<MesBuildingQhseRectify>)Wrappers.<MesBuildingQhseRectify>lambdaQuery().in(MesBuildingQhseRectify::getQhseId, e.getId()))
               .stream()
               .map(copy -> BeanUtil.copy(copy, MesBuildingQhseRectifyDTO.class))
               .collect(Collectors.toList());
            rectifyDTOS.forEach(temp -> {
               temp.setAttachmentDTOS(this.attachmentService.listByIds(temp.getRectifyDrawing()));
               temp.setName(this.userService.getById(temp.getUserId()).getName());
            });
            e.setQhseRectifyDTOS(rectifyDTOS);
         }
      );
      return dtos;
   }

   @Override
   public InspectRealtimeInfoSummary findInspectRealtimeSummary(LocalDateTime date, Long workShopId, Long insepectUserId) {
      Integer toBeInspected = this.produceTeamReportService
         .list(
            (new LambdaQueryWrapper<MesBuildingProduceTeamReport>().apply("quantity > inspection_quantity"))
               .select(MesBuildingProduceTeamReport::getQuantity, MesBuildingProduceTeamReport::getInspectionQuantity)
         )
         .stream()
         .map(e -> e.getQuantity() - e.getInspectionQuantity())
         .reduce(0, Integer::sum);
      List<MesBuildingQhse> qhses = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingQhse.class)
               .in(MesBuildingQhse::getType, Arrays.asList(QhseTypeEnum.QUALITY.getType(), QhseTypeEnum.SPECIAL_QUALITY.getType()))
         );
      Integer unstatus = QhseStatusEnum.UN_RECTIFIED.getType() | QhseStatusEnum.RECTIFIED.getType() | QhseStatusEnum.UN_ADOPT.getType();
      Integer toBeRectifiedCount = Math.toIntExact(qhses.stream().filter(s -> (s.getStatus() & unstatus) != 0).count());
      Integer passedCount = Math.toIntExact(qhses.stream().filter(s -> s.getStatus() == QhseStatusEnum.ADOPT.getType()).count());
      Integer conce = QhseStatusEnum.CONCESSION_ACCEPTED.getType()
         | QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType()
         | QhseStatusEnum.CONCESSION_ACCEPTED_UN_APPROVED.getType();
      Integer concessionReceivingCount = qhses.stream()
         .filter(s -> (s.getStatus() & conce) != 0)
         .map(s -> s.getProblemQuantity() != null ? s.getProblemQuantity() : 1)
         .reduce(0, Integer::sum);
      return InspectRealtimeInfoSummary.builder()
         .toBeInspectedCount(toBeInspected)
         .toBeRectifiedCount(toBeRectifiedCount)
         .passedCount(passedCount)
         .concessionReceivingCount(concessionReceivingCount)
         .build();
   }

   @Override
   public StatisticsPageVO findInspectRealtimeInfos(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long projectId,
      Long workShopId,
      Long insepectUserId,
      Integer status,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (endDate != null) {
         endDate = LocalDateTime.of(endDate.toLocalDate(), LocalTime.MAX);
      }

      List<InsepctUserConditionDTO> treeCondition = null;
      if (insepectUserId != null) {
         treeCondition = this.mesInspectConfigUserLinkService.findInspectUserReturnConditions(insepectUserId);
      }

      List<InspectRealtimeInfoDTO> info = this.taskProcessService.findToBeInspectedInfo(treeCondition, startDate, endDate, projectId, workShopId, serialNumber);
      info = info.stream().map(e -> e.setStatus(1)).collect(Collectors.toList());
      List<MesInspectUserInfoDTO> userAttribute = this.inspectConfigService.findInspectUserAttribute();

      for (InspectRealtimeInfoDTO dto : info) {
         if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<Long> inspectUserIds = userAttribute.stream()
               .filter(
                  e -> e.getArtifactType().equals(dto.getArtifactType())
                        && e.getWorkshopId().equals(dto.getWorkshop().getId())
                        && e.getClassificationIdLinks().contains(dto.getClassificationId())
                        && e.getTeamIdLinks().contains(dto.getTeam().getId())
                     || e.getArtifactType().equals(dto.getArtifactType())
                        && e.getWorkshopId().equals(dto.getTeam().getWorkshopId())
                        && e.getClassificationIdLinks().contains(dto.getClassificationId())
                        && e.getTeamIdLinks().contains(dto.getTeam().getId())
               )
               .flatMap(s -> s.getInspectUsers().stream())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(inspectUserIds)) {
               dto.setInspectUserNames(this.userService.listByIds(inspectUserIds).stream().map(e -> e.getName()).collect(Collectors.toList()));
            }
         } else if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<Long> inspectUserIds = userAttribute.stream()
               .filter(
                  e -> e.getWorkshopId().equals(dto.getWorkshop().getId())
                        && e.getClassificationIdLinks().contains(dto.getClassificationId())
                        && e.getTeamIdLinks().contains(dto.getTeam().getId())
                     || e.getArtifactType().equals(dto.getArtifactType())
                        && e.getWorkshopId().equals(dto.getTeam().getWorkshopId())
                        && e.getClassificationIdLinks().contains(dto.getClassificationId())
                        && e.getTeamIdLinks().contains(dto.getTeam().getId())
               )
               .flatMap(s -> s.getInspectUsers().stream())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(inspectUserIds)) {
               dto.setInspectUserNames(this.userService.listByIds(inspectUserIds).stream().map(e -> e.getName()).collect(Collectors.toList()));
            }
         }
      }

      if (status != null && status != 1) {
         List<InspectRealtimeInfoDTO> realtimeInfoDTOS = this.baseMapper
            .findQhseRealtimeList(treeCondition, startDate, endDate, projectId, workShopId, serialNumber);
         realtimeInfoDTOS = realtimeInfoDTOS.stream().map(e -> e.setInspectUserNames(Collections.singletonList(e.getName()))).collect(Collectors.toList());
         if (insepectUserId != null) {
            realtimeInfoDTOS = realtimeInfoDTOS.stream().filter(e -> e.getInspectUserId().equals(insepectUserId)).collect(Collectors.toList());
         }

         realtimeInfoDTOS = this.setInspectStatuses(realtimeInfoDTOS);
         info.addAll(realtimeInfoDTOS);
      }

      if (status != null) {
         info = info.stream().filter(e -> e.getStatus().equals(status)).collect(Collectors.toList());
      }

      Page<InspectRealtimeInfoDTO> page1 = CommonUtil.getPage(pageNumber, pageSize, info);
      return new StatisticsPageVO<>(page1, page1.getResult());
   }

   public List<InspectRealtimeInfoDTO> setInspectStatuses(List<InspectRealtimeInfoDTO> dtos) {
      for (InspectRealtimeInfoDTO dto : dtos) {
         switch (dto.getStatus()) {
            case 1:
               dto.setStatus(QhseSimpleStatusEnum.TO_BE_RECTIFIED.getType());
               break;
            case 2:
               dto.setStatus(QhseSimpleStatusEnum.TO_BE_RECTIFIED.getType());
               break;
            case 4:
               dto.setStatus(QhseSimpleStatusEnum.PASSED.getType());
               break;
            case 8:
               dto.setStatus(QhseSimpleStatusEnum.TO_BE_RECTIFIED.getType());
               break;
            case 16:
               dto.setStatus(QhseSimpleStatusEnum.CONCESSION_ACCEPTED.getType());
               break;
            case 32:
               dto.setStatus(QhseSimpleStatusEnum.CONCESSION_ACCEPTED.getType());
               break;
            case 64:
               dto.setStatus(QhseSimpleStatusEnum.TO_BE_RECTIFIED.getType());
         }
      }

      return dtos;
   }

   @Override
   public PageVO<MesBuildingInspectCountDTO> findInspectCountDTO(MesBuildingQhseCountParam qhseCountParam, Integer pageNumber, Integer pageSize) {
      if (qhseCountParam.getStartDate() == null && qhseCountParam.getEndDate() == null) {
         LocalDateTime dateTime = LocalDateTime.now();
         qhseCountParam.setStartDate(dateTime.minusDays(30L));
         qhseCountParam.setEndDate(dateTime);
      }

      qhseCountParam.setEndDate(LocalDateTime.of(qhseCountParam.getEndDate().toLocalDate(), LocalTime.MAX));
      List<MesBuildingInspectCountDTO> dtos = null;
      PageVO<MesBuildingInspectCountDTO> vo = null;
      PageHelper.startPage(pageNumber, pageSize);
      if (qhseCountParam.getStatus() != 2 && qhseCountParam.getStatus() != 0) {
         if (qhseCountParam.getStatus() == 1) {
            List<MesBuildingInspectCountDTO> inspectDtos = this.inspectionTeamReportService.findInspectCountByParam(qhseCountParam);
            if (CollectionUtils.isEmpty(inspectDtos)) {
               return vo;
            }

            vo = new PageVO<>(inspectDtos);
         }
      } else {
         dtos = this.baseMapper.findAllInspectCount(qhseCountParam);
         if (CollectionUtils.isEmpty(dtos)) {
            return vo;
         }

         vo = new PageVO<>(dtos);
         Map<Long, List<Integer>> conditionalMap = dtos.stream()
            .collect(Collectors.groupingBy(e -> e.getTaskProcessId(), Collectors.mapping(s -> s.getNumber(), Collectors.toList())));
         List<MesBuildingInspectCountDTO> inspectCount = this.inspectionTeamReportService.findInspectCount(conditionalMap);
         Map<String, List<MesBuildingInspectCountDTO>> dtoMap = inspectCount.stream()
            .collect(Collectors.groupingBy(e -> e.getTaskProcessId() + "-" + e.getNumber()));
         dtos.stream().forEach(s -> {
            List<MesBuildingInspectCountDTO> dtoList = dtoMap.get(s.getTaskProcessId() + "-" + s.getNumber());
            if (CollectionUtils.isNotEmpty(dtoList)) {
               s.setInspectUserName(dtoList.get(0).getInspectUserName());
               s.setPassageTime(dtoList.get(0).getPassageTime());
            }
         });
      }

      List<MesBuildingInspectCountDTO> content = vo.getContent();
      List<Long> productIds = content.stream().map(e -> e.getProductId()).collect(Collectors.toList());
      List<TechAssembleDetail> detailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, productIds));
      Map<Long, Map<Long, String>> detailLinkMap;
      if (CollectionUtils.isNotEmpty(detailList)) {
         Map<Long, List<TechAssembleDetail>> detailMap = detailList.stream().collect(Collectors.groupingBy(e -> e.getArtifactId()));
         Map<Long, String> assembleMap = this.assembleService
            .listByIds(detailList.stream().map(e -> e.getAssembleId()).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(e -> e.getId(), e -> e.getSerialNumber()));
         detailLinkMap = detailMap.entrySet()
            .stream()
            .collect(
               Collectors.toMap(
                  Entry::getKey,
                  entry -> entry.getValue().stream().collect(Collectors.toMap(TechAssembleDetail::getAssembleId, e -> assembleMap.get(e.getAssembleId())))
               )
            );
      } else {
         detailLinkMap = Collections.emptyMap();
      }

      List<MesBuildingQhse> qhseList = this.list(Wrappers.lambdaQuery(MesBuildingQhse.class).in(MesBuildingQhse::getProductId, productIds));
      Map<String, List<MesBuildingQhse>> qhseMap = qhseList.stream().collect(Collectors.groupingBy(s -> s.getTaskTypeEnum() + "-" + s.getProductId()));
      content.forEach(e -> {
         Map<Long, String> detailMaps = detailLinkMap.get(e.getProductId());
         if (CollectionUtils.isNotEmpty(detailMaps)) {
            e.setAssMap(detailLinkMap.get(e.getProductId()));
         }

         List<MesBuildingQhse> qhse = qhseMap.get(e.getTaskTypeEnum() + "-" + e.getProductId());
         if (CollectionUtils.isNotEmpty(qhse)) {
            e.setQhseMap(qhse.stream().collect(Collectors.toMap(b -> b.getId(), s -> s.getQhseNumber())));
         }
      });
      return vo;
   }

   @Override
   public Integer findInspectTotalCount(MesBuildingQhseCountParam qhseCountParam) {
      if (qhseCountParam.getStartDate() == null && qhseCountParam.getEndDate() == null) {
         LocalDateTime dateTime = LocalDateTime.now();
         qhseCountParam.setStartDate(dateTime.minusDays(30L));
         qhseCountParam.setEndDate(dateTime);
      }

      Integer allQuantity = this.baseMapper.findAllInspectQuantity(qhseCountParam);
      return allQuantity;
   }

   @Override
   public List<TeamQhseQuantityDTO> findTeamQhseQuantity(Long workShopId, LocalDate date) {
      return this.baseMapper.findTeamQhseQuantity(workShopId, date);
   }

   @Override
   public List<QhseQuantitySummaryDTO> findQhseQuantityGroupQhseType(Long workShopId, LocalDate date) {
      return this.baseMapper.findQhseQuantityGroupQhseType(workShopId, date);
   }

   @Override
   public List<QhseWarnToDayDTO> findQhseWarnToDay(Long workShopId) {
      return this.baseMapper.findQhseWarnToDay(workShopId);
   }

   @Override
   public List<QualityGroupSummaryDTO> findQualityGroupSummary(Integer year) {
      return this.baseMapper.findQualityGroupSummary(year);
   }

   @Override
   public List<QhseGroupMonthByYearSummaryDTO> findQualityGroupMonthByYear(Integer year) {
      return this.baseMapper.findQualityGroupMonthByYear(year);
   }

   @Override
   public List<MonthlyFirstPassRateDTO> findQhseCountGroupMonth(Integer year) {
      return this.baseMapper.findQhseCountGroupMonth(year);
   }

   @Override
   public List<QhseAlertDTO> findQuailyQhseAlert(Integer type, List<Integer> statuses) {
      return this.baseMapper.findQuailyQhseAlert(type, statuses);
   }

   @Override
   public List<QualityInspectionStatisticsDTO> findQualityInspectionStatistics(Integer year) {
      List<QualityInspectionStatisticsDTO> qhseList = this.baseMapper.findQualityStatistics(year);
      List<QualityInspectionStatisticsDTO> inspectList = this.baseMapper.findInspectionStatistics(year);
      Map<String, Integer> qhseMap = qhseList.stream().collect(Collectors.toMap(s -> s.getTeamName(), s -> s.getQhseQuantity()));
      Map<String, Integer> inspectMap = inspectList.stream().collect(Collectors.toMap(s -> s.getTeamName(), s -> s.getInspectQuantity()));
      Stream<QualityInspectionStatisticsDTO> combinedStream = Stream.concat(qhseList.stream(), inspectList.stream());
      List<String> namesList = combinedStream.map(QualityInspectionStatisticsDTO::getTeamName).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<QualityInspectionStatisticsDTO> dtos = new ArrayList<>();
      namesList.forEach(s -> {
         Integer qhseQuantity = qhseMap.get(s) == null ? 0 : qhseMap.get(s);
         Integer inspectQuantity = inspectMap.get(s) == null ? 0 : inspectMap.get(s);
         dtos.add(QualityInspectionStatisticsDTO.builder().teamName(s).qhseQuantity(qhseQuantity).inspectQuantity(inspectQuantity + qhseQuantity).build());
      });
      return dtos;
   }

   @Override
   public List<TeamQhseRankingDTO> findTeamQhseRanking(Integer year) {
      return this.baseMapper.findTeamQhseRanking(year);
   }

   @Override
   public Boolean findInspectCountDTODownload(MesBuildingQhseCountParam qhseCountParam, HttpServletResponse response) {
      List<MesBuildingInspectCountDTO> content = this.findInspectCountDTO(qhseCountParam, 1, 100000).getContent();
      AtomicInteger index = new AtomicInteger(0);
      List<Integer> indexList = new ArrayList<>();
      List<Map<String, Object>> typeList = new ArrayList<>();
      Map<String, Object> exportMap = new HashMap<>();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      for (MesBuildingInspectCountDTO dto : content) {
         index.getAndIncrement();
         dto.setOrderNumber(index.get());
         dto.setReportDateStr(df.format(dto.getReportDate()));
         dto.setPassageTimeStr(df.format(dto.getPassageTime()));
         dto.setProjectMonomerArea(dto.getProject().getShortName() + "/" + dto.getMonomerName() + "/" + dto.getAreaName());
         Map<String, Object> typesettingMap = BeanUtil.beanToMap(dto);
         typeList.add(typesettingMap);
         indexList.add(index.get());
      }

      exportMap.put("typeList", typeList);

      try {
         String tempFileName = "FindInspectCountList";
         String resourcePath = "files/FindInspectCountList.xlsx";
         String exportFileName = "质检统计.xlsx";
         Resource resource = new ClassPathResource(resourcePath);
         InputStream inputStream = resource.getInputStream();
         File file = File.createTempFile(tempFileName, "xlsx");
         FileUtil.copyInputStreamToFile(inputStream, file);
         TemplateExportParams params = new TemplateExportParams(file.getAbsolutePath(), true);
         params.setColForEach(true);
         Workbook workbook = ExcelExportUtil.exportExcel(params, exportMap);
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         PoiUtils.downNoBuildCellLoadExcel(exportFileName, response, workbook);
      } catch (IOException e) {
         throw new BusinessException(ResultCodeEnum.ERROR, e.getMessage());
      }

      return true;
   }

   @Override
   public List<InspectRealtimeInfoDTO> productionKanbanRealtimeInfo(
      List<Long> projectIdList, Long workshopId, LocalDateTime startTime, LocalDateTime endTime, Integer status
   ) {
      if (endTime != null) {
         endTime = LocalDateTime.of(endTime.toLocalDate(), LocalTime.MAX);
      }

      List<InsepctUserConditionDTO> treeCondition = null;
      List<InspectRealtimeInfoDTO> info = this.taskProcessService.findToBeInspectedInfoV2(treeCondition, startTime, endTime, projectIdList, workshopId);
      info = info.stream().map(e -> e.setStatus(1)).collect(Collectors.toList());
      List<MesInspectUserInfoDTO> userAttribute = this.inspectConfigService.findInspectUserAttribute();

      for (InspectRealtimeInfoDTO dto : info) {
         if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<Long> inspectUserIds = userAttribute.stream()
               .filter(
                  e -> e.getArtifactType().equals(dto.getArtifactType())
                     && e.getWorkshopId().equals(dto.getWorkshop().getId())
                     && e.getClassificationIdLinks().contains(dto.getClassificationId())
                     && e.getTeamIdLinks().contains(dto.getTeam().getId())
               )
               .flatMap(s -> s.getInspectUsers().stream())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(inspectUserIds)) {
               dto.setInspectUserNames(this.userService.listByIds(inspectUserIds).stream().map(User::getName).collect(Collectors.toList()));
            }
         } else if (dto.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            List<Long> inspectUserIds = userAttribute.stream()
               .filter(
                  e -> e.getWorkshopId().equals(dto.getWorkshop().getId())
                     && e.getClassificationIdLinks().contains(dto.getClassificationId())
                     && e.getTeamIdLinks().contains(dto.getTeam().getId())
               )
               .flatMap(s -> s.getInspectUsers().stream())
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(inspectUserIds)) {
               dto.setInspectUserNames(this.userService.listByIds(inspectUserIds).stream().map(User::getName).collect(Collectors.toList()));
            }
         }
      }

      if (status != null && status != 1) {
         List<InspectRealtimeInfoDTO> realtimeInfoDTOS = this.baseMapper.findQhseRealtimeListV2(treeCondition, startTime, endTime, projectIdList, workshopId);
         realtimeInfoDTOS = realtimeInfoDTOS.stream().map(e -> e.setInspectUserNames(Collections.singletonList(e.getName()))).collect(Collectors.toList());
         realtimeInfoDTOS = this.setInspectStatuses(realtimeInfoDTOS);
         info.addAll(realtimeInfoDTOS);
      }

      if (status != null) {
         info = info.stream().filter(e -> e.getStatus().equals(status)).collect(Collectors.toList());
      }

      return info;
   }

   @Override
   public Integer getProblemQuantity(Long workshopId, Long teamId) {
      return this.baseMapper.getProblemQuantity(workshopId, teamId);
   }
}
