package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuCutFileConfigDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuPartDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuPartDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateDetailDTO.PartDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO.ResultInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO.TotalInfoDTO.PartInfoDTO;
import com.hzchum.scim.common.core.api.third_party_api.BoChuNesting;
import com.hzchum.scim.common.core.api.utils.HttpUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingCutConfigBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutSendEnum;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.IssuedToNestingSoftwareStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingCutConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingProductInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesBuildingBoChuNestingResultInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesJobMachinePartSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting_result.MesNestingResultSteelPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CreateDto;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.CutTaskRequestData;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingPartCheckDrillDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.NestResultDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.JobSteelPlateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.nesting_result.NestingResultQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.client.CutTaskClient;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingBoChuNestingResultMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartInfoDTO;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingBoChuNestingResultServiceImpl
   extends ServiceImpl<MesBuildingBoChuNestingResultMapper, MesBuildingBoChuNestingResult>
   implements MesBuildingBoChuNestingResultService {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingBoChuNestingResultServiceImpl.class);
   @Value("${chum.bochuNestingDiagramPath}")
   private String bochuNestingDiagramPath;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService taskNeedMachinePartSchedulingService;
   @Autowired
   private MesBuildingBoChuJobDirectoryService boChuJobDirectoryService;
   @Autowired
   private MesBuildingNestingTeamService nestingTeamService;
   @Autowired
   private NestBiz nestBiz;
   @Autowired
   private MesBuildingMachinePartTeamDetailService machinePartTeamDetailService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingCutConfigBiz cutConfigBiz;
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private CutTaskClient cutTaskClient;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingTeamService teamService;

   @Transactional(rollbackFor = Exception.class)
   public byte[] unzipSingleFile(byte[] zipFileBytes, String fileName, String childGuid) throws IOException {
      try (
         InputStream zipInputStream = new ByteArrayInputStream(zipFileBytes);
         ZipInputStream zis = new ZipInputStream(zipInputStream);
      ) {
         ZipEntry entry = zis.getNextEntry();
         if (entry == null) {
            throw new IOException("ZIP 文件为空或没有文件");
         }

         String fileNameNest = entry.getName();
         List<MesBuildingBoChuNestingResult> mesBuildingBoChuNestingResultList = this.lambdaQuery()
            .eq(MesBuildingBoChuNestingResult::getChildGuid, childGuid)
            .list();
         if (CollectionUtil.isNotEmpty(mesBuildingBoChuNestingResultList)) {
            for (MesBuildingBoChuNestingResult mesBuildingBoChuNestingResult : mesBuildingBoChuNestingResultList) {
               mesBuildingBoChuNestingResult.setFileName(fileName);
               mesBuildingBoChuNestingResult.setFileNameNest(fileNameNest);
            }

            this.updateBatchById(mesBuildingBoChuNestingResultList);
         }

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         byte[] buffer = new byte[1024];

         int bytesRead;
         while ((bytesRead = zis.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
         }

         return byteArrayOutputStream.toByteArray();
      }
   }

   @Override
   public String getMaxFileName(String prefix) {
      return this.baseMapper.getMaxFileName(prefix);
   }

   @Override
   public MesJobMachinePartSummaryDTO jobMachinePartSummary(Integer jobId) {
      return jobId == null ? null : this.jobMachinePartSummaryList(ListUtil.toList(jobId)).get(0);
   }

   @Override
   public List<MesJobMachinePartSummaryDTO> jobMachinePartSummaryList(List<Integer> jobIdList) {
      if (CollUtil.isEmpty(jobIdList)) {
         return Collections.emptyList();
      }

      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = Optional.of(jobIdList)
         .filter(CollUtil::isNotEmpty)
         .map(m -> this.taskNeedMachinePartSchedulingService.lambdaQuery().in(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, m).list())
         .orElseGet(Collections::emptyList);
      Map<Integer, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingGroup = taskNeedMachinePartSchedulingList.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId));
      List<MesBuildingBoChuJobDirectory> boChuJobDirectoryList = Optional.of(jobIdList)
         .filter(CollUtil::isNotEmpty)
         .map(m -> this.boChuJobDirectoryService.lambdaQuery().in(MesBuildingBoChuJobDirectory::getJobId, m).list())
         .orElseGet(Collections::emptyList);
      Map<Integer, MesBuildingBoChuJobDirectory> boChuJobDirectoryMap = boChuJobDirectoryList.stream()
         .collect(Collectors.toMap(MesBuildingBoChuJobDirectory::getJobId, Function.identity()));
      List<Long> nestingTeamIdList = boChuJobDirectoryList.stream().map(MesBuildingBoChuJobDirectory::getTeamCodeId).collect(Collectors.toList());
      List<MesBuildingNestingTeam> nestingTeamList = Optional.of(nestingTeamIdList)
         .filter(CollUtil::isNotEmpty)
         .map(m -> this.nestingTeamService.lambdaQuery().in(MesBuildingNestingTeam::getId, m).list())
         .orElseGet(Collections::emptyList);
      Map<Long, MesBuildingNestingTeam> nestingTeamMap = nestingTeamList.stream().collect(Collectors.toMap(MesBuildingNestingTeam::getId, Function.identity()));
      List<MesBuildingBoChuNestingResult> nestingResultList = Optional.of(jobIdList).filter(CollUtil::isNotEmpty).map(m -> {
         LambdaQueryWrapper<MesBuildingBoChuNestingResult> qw = new LambdaQueryWrapper<>();
         qw.and(q -> m.forEach(jobId -> (q.or()).apply("FIND_IN_SET({0}, mixed_job_ids) > 0", jobId)));
         return this.list(qw);
      }).orElseGet(Collections::emptyList);
      return jobIdList.parallelStream()
         .map(
            jobId -> {
               Map<Long, Integer> nestingQuantityMap = new ConcurrentHashMap<>();
               Map<Long, Integer> cutQuantityMap = new ConcurrentHashMap<>();
               return this.getMesJobMachinePartSummaryDTO(
                  jobId,
                  Collections.unmodifiableMap(taskNeedMachinePartSchedulingGroup),
                  Collections.unmodifiableMap(boChuJobDirectoryMap),
                  Collections.unmodifiableMap(nestingTeamMap),
                  Collections.unmodifiableList(nestingResultList),
                  nestingQuantityMap,
                  cutQuantityMap
               );
            }
         )
         .collect(Collectors.toList());
   }

   private MesJobMachinePartSummaryDTO getMesJobMachinePartSummaryDTO(
      Integer jobId,
      Map<Integer, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingGroup,
      Map<Integer, MesBuildingBoChuJobDirectory> boChuJobDirectoryMap,
      Map<Long, MesBuildingNestingTeam> nestingTeamMap,
      List<MesBuildingBoChuNestingResult> nestingResultList,
      Map<Long, Integer> nestingQuantityMap,
      Map<Long, Integer> cutQuantityMap
   ) {
      MesBuildingBoChuJobDirectory jobDirectory = boChuJobDirectoryMap.get(jobId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory, "作业不存在, 请刷新后重试"));
      MesBuildingNestingTeam nestingTeam = nestingTeamMap.get(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingTeam), "该工单没有指定团队");
      MesJobMachinePartSummaryDTO result = MesJobMachinePartSummaryDTO.builder()
         .jobId(jobId)
         .totalQuantity(BigDecimal.ZERO)
         .nestedTotalQuantity(BigDecimal.ZERO)
         .reportedTotalQuantity(BigDecimal.ZERO)
         .build();
      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = taskNeedMachinePartSchedulingGroup.getOrDefault(
         jobId, Collections.emptyList()
      );
      if (CollUtil.isEmpty(taskNeedMachinePartSchedulingList)) {
         return result;
      }

      BigDecimal totalQuantity = taskNeedMachinePartSchedulingList.stream()
         .map(ntnmps -> BigDecimal.valueOf(ntnmps.getNeedQuantity().intValue()))
         .reduce(BigDecimal::add)
         .orElse(BigDecimal.ZERO);
      int nestedTotalQuantity = 0;
      int reportedTotalQuantity = 0;
      List<Long> masterTaskOrderIdList = taskNeedMachinePartSchedulingList.stream()
         .map(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, Integer> partNeedQuantityMap = taskNeedMachinePartSchedulingList.stream()
         .collect(
            Collectors.toMap(MesBuildingTaskNeedMachinePartScheduling::getProductId, MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity, Integer::sum)
         );
      List<MesBuildingBoChuNestingResult> cNestingResultList = nestingResultList.stream().filter(nr -> {
         List<Integer> cMixedJobIdList = Convert.toList(Integer.class, StrUtil.split(nr.getMixedJobIds(), ","));
         return cMixedJobIdList.contains(jobId);
      }).collect(Collectors.toList());
      List<String> distinctGuidList = cNestingResultList.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
         nestingTeam.getTeamCode(), ListUtil.toList(jobId), distinctGuidList
      );
      Map<String, BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOMap = machinePartNestingGuidDetailDTOList.stream()
         .collect(Collectors.toMap(BoChuNestedPlateDetailDTO::getGuid, Function.identity()));

      for (MesBuildingBoChuNestingResult nestingResult : cNestingResultList) {
         BoChuNestedPlateDetailDTO machinePartNestingGuidDetailDTO = machinePartNestingGuidDetailDTOMap.get(nestingResult.getGuid());
         if (!BeanUtil.isEmpty(machinePartNestingGuidDetailDTO) && !CollUtil.isEmpty(machinePartNestingGuidDetailDTO.getPartList())) {
            for (PartDTO part : machinePartNestingGuidDetailDTO.getPartList()) {
               if (!CollUtil.isEmpty(part.getPropMap())) {
                  Long productId = MapUtil.getLong(part.getPropMap(), "productId");
                  Long taskOrderId = MapUtil.getLong(part.getPropMap(), "taskOrderId");
                  if (masterTaskOrderIdList.contains(taskOrderId)) {
                     Integer cNeedQuantity = partNeedQuantityMap.get(productId);
                     if (cNeedQuantity != null) {
                        if (nestingQuantityMap.containsKey(productId)) {
                           Integer recordedQuantity = nestingQuantityMap.get(productId);
                           if (recordedQuantity < cNeedQuantity) {
                              int newRecordedQuantity = recordedQuantity + part.getAmount();
                              if (newRecordedQuantity >= cNeedQuantity) {
                                 nestedTotalQuantity += part.getAmount() - (newRecordedQuantity - cNeedQuantity);
                                 nestingQuantityMap.put(productId, cNeedQuantity);
                              } else {
                                 nestedTotalQuantity += part.getAmount();
                                 nestingQuantityMap.put(productId, newRecordedQuantity);
                              }
                           }
                        } else if (part.getAmount() <= cNeedQuantity) {
                           nestedTotalQuantity += part.getAmount();
                           nestingQuantityMap.put(productId, part.getAmount());
                        } else {
                           nestedTotalQuantity += cNeedQuantity;
                           nestingQuantityMap.put(productId, cNeedQuantity);
                        }

                        if (nestingResult.getCutStatus() == CutStatusEnum.CUT_COMPLETED.getCode()) {
                           if (cutQuantityMap.containsKey(productId)) {
                              Integer recordedQuantity = cutQuantityMap.get(productId);
                              if (recordedQuantity < cNeedQuantity) {
                                 int newRecordedQuantity = recordedQuantity + part.getAmount();
                                 if (newRecordedQuantity >= cNeedQuantity) {
                                    reportedTotalQuantity += part.getAmount() - (newRecordedQuantity - cNeedQuantity);
                                    cutQuantityMap.put(productId, cNeedQuantity);
                                 } else {
                                    reportedTotalQuantity += part.getAmount();
                                    cutQuantityMap.put(productId, newRecordedQuantity);
                                 }
                              }
                           } else if (part.getAmount() <= cNeedQuantity) {
                              reportedTotalQuantity += part.getAmount();
                              cutQuantityMap.put(productId, part.getAmount());
                           } else {
                              reportedTotalQuantity += cNeedQuantity;
                              cutQuantityMap.put(productId, cNeedQuantity);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      result.setTotalQuantity(totalQuantity);
      result.setNestedTotalQuantity(BigDecimal.valueOf(nestedTotalQuantity));
      result.setReportedTotalQuantity(BigDecimal.valueOf(reportedTotalQuantity));
      return result;
   }

   @Override
   public PageVO<MesNestingResultSteelPlateDTO> pageInfo(NestingResultQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesNestingResultSteelPlateDTO> list = this.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesNestingResultSteelPlateDTO> listInfo(NestingResultQuery query) {
      List<MesNestingResultSteelPlateDTO> list = this.baseMapper.listInfo(query);
      List<String> guidList = list.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, query.getJobId())
         .one();
      MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(nestingTeam != null, "该工单没有指定团队");
      List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
         nestingTeam.getTeamCode(), CollUtil.newArrayList(query.getJobId()), guidList
      );
      Map<String, BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOMap = machinePartNestingGuidDetailDTOList.stream()
         .collect(Collectors.toMap(BoChuNestedPlateDetailDTO::getGuid, Function.identity()));
      Map<Long, TechMachinePart> techMachinePartMap = this.machinePartService
         .lambdaQuery()
         .eq(TechMachinePart::getProjectId, Long.valueOf(jobDirectory.getProjectId()))
         .list()
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));

      for (MesNestingResultSteelPlateDTO steelPlateDTO : list) {
         BoChuNestedPlateDetailDTO machinePartNestingGuidDetailDTO = machinePartNestingGuidDetailDTOMap.get(steelPlateDTO.getGuid());
         if (BeanUtil.isNotEmpty(machinePartNestingGuidDetailDTO)) {
            List<PartDTO> parts = machinePartNestingGuidDetailDTO.getPartList();
            List<MesBuildingPartCheckDrillDTO> partList = new ArrayList<>();

            for (PartDTO part : parts) {
               if (!CollUtil.isEmpty(part.getPropMap())) {
                  Long productId = MapUtil.getLong(part.getPropMap(), "productId");
                  Long taskOrderId = MapUtil.getLong(part.getPropMap(), "taskOrderId");
                  Integer amount = part.getAmount();
                  TechMachinePart techMachinePart = techMachinePartMap.get(productId);
                  if (techMachinePart == null) {
                     techMachinePart = this.machinePartService.getById(productId);
                  }

                  MesBuildingPartCheckDrillDTO mesBuildingPartCheckDrillDTO = new MesBuildingPartCheckDrillDTO();
                  mesBuildingPartCheckDrillDTO.setId(productId);
                  mesBuildingPartCheckDrillDTO.setQuantity(amount);
                  mesBuildingPartCheckDrillDTO.setThick(techMachinePart.getThick());
                  mesBuildingPartCheckDrillDTO.setTaskOrderId(taskOrderId);
                  mesBuildingPartCheckDrillDTO.setNetWeight(techMachinePart.getNetWeight());
                  mesBuildingPartCheckDrillDTO.setGrossWeight(techMachinePart.getGrossWeight());
                  partList.add(mesBuildingPartCheckDrillDTO);
               }
            }

            steelPlateDTO.setPartList(partList);
         }
      }

      return list.stream().sorted(Comparator.comparing(MesBuildingBoChuNestingResult::getThickness)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean jobSteelPlateDelete(JobSteelPlateParam param) {
      Preconditions.checkArgument(param.getJobId() != null, "作业不能为空");
      Preconditions.checkArgument(CollUtil.isNotEmpty(param.getNestingResultIdList()), "未选择钢板");
      Preconditions.checkArgument(param.getDeleteScope() != null, "删除范围不能为空");
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, param.getJobId())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory), "作业不存在, 请刷新后重试");
      List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(param.getNestingResultIdList());
      Preconditions.checkArgument(CollUtil.isNotEmpty(nestingResultList), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(ObjectUtil.equal(param.getNestingResultIdList().size(), nestingResultList.size()), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(
         nestingResultList.stream().allMatch(nr -> Objects.equals(CutSendEnum.NOT_DISPATCHED.getCode(), nr.getCutSendStatus())), "存在已下发钢板, 请刷新后重试"
      );
      List<String> guidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      List<MesBuildingBoChuNestingResult> nestingResultListByGuid = this.lambdaQuery().in(MesBuildingBoChuNestingResult::getGuid, guidList).list();
      Preconditions.checkArgument(ObjectUtil.equal(nestingResultList.size(), nestingResultListByGuid.size()), "所选钢板中存在关联钢板未选中, 无法删除");
      Preconditions.checkArgument(
         nestingResultListByGuid.stream().allMatch(nr -> Objects.equals(CutSendEnum.NOT_DISPATCHED.getCode(), nr.getCutSendStatus())), "所选钢板中存在关联钢板已下发情况, 无法删除"
      );
      MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingTeam), "所选作业未获取到对应的套料团队信息, 请刷新后重试");
      List<Integer> jobIdList = nestingResultList.stream()
         .map(nr -> Convert.toList(Integer.class, StrUtil.split(nr.getMixedJobIds(), ",")))
         .filter(CollUtil::isNotEmpty)
         .flatMap(Collection::stream)
         .filter(ObjectUtil::isNotNull)
         .distinct()
         .collect(Collectors.toList());
      this.removeByIds(param.getNestingResultIdList());
      guidList.forEach(this.nestBiz::deleteNesting);
      Map<String, Integer> boChuPartUpdateParamMap = new HashMap<>();
      if (param.getDeleteScope().equals(1)) {
         Map<String, Integer> boChuPartParamMap = new HashMap<>();
         List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
            nestingTeam.getTeamCode(), ListUtil.toList(param.getJobId()), guidList
         );
         if (CollUtil.isNotEmpty(machinePartNestingGuidDetailDTOList)) {
            Map<String, List<BoChuNestedPlateDetailDTO>> machinePartNestingGuidDetailDTOGroup = machinePartNestingGuidDetailDTOList.stream()
               .collect(Collectors.groupingBy(BoChuNestedPlateDetailDTO::getGuid));

            for (String guid : guidList) {
               List<BoChuNestedPlateDetailDTO> cMachinePartNestingGuidDetailDTOList = machinePartNestingGuidDetailDTOGroup.get(guid);
               if (CollUtil.isNotEmpty(cMachinePartNestingGuidDetailDTOList)) {
                  for (BoChuNestedPlateDetailDTO machinePartNestingGuidDetailDTO : cMachinePartNestingGuidDetailDTOList) {
                     Integer amount = machinePartNestingGuidDetailDTO.getAmount();

                     for (PartDTO part : machinePartNestingGuidDetailDTO.getPartList()) {
                        String partGuid = part.getGuid();
                        Integer needDeletedAmount = part.getAmount() * amount;
                        boChuPartParamMap.merge(partGuid, needDeletedAmount, Integer::sum);
                     }
                  }
               }
            }
         }

         Map<String, BoChuPartDTO> jobPartMap = BoChuNesting.getPartList(nestingTeam.getTeamCode(), jobIdList)
            .stream()
            .collect(Collectors.toMap(BoChuPartDTO::getGuid, Function.identity()));
         List<String> quantityIsZeroPartGuidList = new ArrayList<>();
         List<String> quantityIsNotZeroPartGuidList = new ArrayList<>();
         boChuPartParamMap.forEach((partGuidx, partAmount) -> {
            BoChuPartDTO jp = jobPartMap.get(partGuidx);
            if (BeanUtil.isNotEmpty(jp)) {
               int residualAmount = jp.getAmount() - partAmount;
               Preconditions.checkArgument(residualAmount >= 0, "零件数量错误, 请联系管理员");
               boChuPartUpdateParamMap.put(partGuidx, residualAmount);
               if (ObjectUtil.equal(residualAmount, 0)) {
                  quantityIsZeroPartGuidList.add(partGuidx);
               } else {
                  quantityIsNotZeroPartGuidList.add(partGuidx);
               }
            }
         });
         List<BoChuPartDetailDTO> nestingJobPartList = BoChuNesting.getPartDetailList(nestingTeam.getTeamCode(), ListUtil.toList(jobIdList));
         Set<Long> zeroTaskNeedMachinePartSchedulingIdList = new HashSet<>();
         nestingJobPartList.stream()
            .filter(njp -> quantityIsZeroPartGuidList.contains(njp.getGuid()) || quantityIsNotZeroPartGuidList.contains(njp.getGuid()))
            .filter(njp -> CollUtil.isNotEmpty(njp.getPropMap()))
            .filter(njp -> njp.getPropMap().containsKey("productId") && njp.getPropMap().containsKey("taskOrderId"))
            .forEach(
               njp -> {
                  Preconditions.checkArgument(boChuPartParamMap.containsKey(njp.getGuid()), "数据异常, 请联系管理员");
                  Integer partAmount = boChuPartParamMap.get(njp.getGuid());
                  Long productId = MapUtil.getLong(njp.getPropMap(), "productId");
                  Long taskOrderId = MapUtil.getLong(njp.getPropMap(), "taskOrderId");

                  for (MesBuildingTaskNeedMachinePartScheduling tnmps : this.taskNeedMachinePartSchedulingService
                     .lambdaQuery()
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, njp.getJobId())
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId)
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productId)
                     .eq(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.ISSUED.getType())
                     .list()) {
                     if (partAmount == 0) {
                        break;
                     }

                     int unscheduledQuantity = tnmps.getNeedQuantity() - tnmps.getSchedulingQuantity();
                     Preconditions.checkArgument(unscheduledQuantity >= 0, "数据异常, 请联系管理员");
                     if (partAmount >= unscheduledQuantity) {
                        if (unscheduledQuantity == tnmps.getNeedQuantity()) {
                           zeroTaskNeedMachinePartSchedulingIdList.add(tnmps.getId());
                           partAmount = partAmount - tnmps.getNeedQuantity();
                        } else if (unscheduledQuantity > 0) {
                           tnmps.setNeedQuantity(tnmps.getSchedulingQuantity());
                           this.taskNeedMachinePartSchedulingService.updateById(tnmps);
                           MesBuildingTaskNeedMachinePartScheduling addTaskNeedMachinePartScheduling = BeanUtil.copyProperties(
                              tnmps, MesBuildingTaskNeedMachinePartScheduling.class
                           );
                           addTaskNeedMachinePartScheduling.setNeedQuantity(unscheduledQuantity);
                           addTaskNeedMachinePartScheduling.setSchedulingQuantity(0);
                           addTaskNeedMachinePartScheduling.setNestingJobId(null);
                           addTaskNeedMachinePartScheduling.setSendNestingStatus(false);
                           addTaskNeedMachinePartScheduling.setSchedulingUserId(null);
                           addTaskNeedMachinePartScheduling.setSchedulingDate(null);
                           addTaskNeedMachinePartScheduling.setNestTeamConfigId(null);
                           addTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
                           addTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareOperationTime(null);
                           this.taskNeedMachinePartSchedulingService.save(addTaskNeedMachinePartScheduling);
                           partAmount = partAmount - unscheduledQuantity;
                        }
                     } else {
                        tnmps.setNeedQuantity(tnmps.getNeedQuantity() - partAmount);
                        this.taskNeedMachinePartSchedulingService.updateById(tnmps);
                        MesBuildingTaskNeedMachinePartScheduling addTaskNeedMachinePartScheduling = BeanUtil.copyProperties(
                           tnmps, MesBuildingTaskNeedMachinePartScheduling.class
                        );
                        addTaskNeedMachinePartScheduling.setNeedQuantity(partAmount);
                        addTaskNeedMachinePartScheduling.setSchedulingQuantity(0);
                        addTaskNeedMachinePartScheduling.setNestingJobId(null);
                        addTaskNeedMachinePartScheduling.setSendNestingStatus(false);
                        addTaskNeedMachinePartScheduling.setSchedulingUserId(null);
                        addTaskNeedMachinePartScheduling.setSchedulingDate(null);
                        addTaskNeedMachinePartScheduling.setNestTeamConfigId(null);
                        addTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareStatus(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType());
                        addTaskNeedMachinePartScheduling.setIssuedToNestingSoftwareOperationTime(null);
                        this.taskNeedMachinePartSchedulingService.save(addTaskNeedMachinePartScheduling);
                        partAmount = 0;
                     }
                  }
               }
            );
         if (CollUtil.isNotEmpty(zeroTaskNeedMachinePartSchedulingIdList)) {
            List<MesBuildingTaskNeedMachinePartScheduling> zeroTaskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
               .listByIds(zeroTaskNeedMachinePartSchedulingIdList);
            Preconditions.checkArgument(zeroTaskNeedMachinePartSchedulingList.size() == zeroTaskNeedMachinePartSchedulingIdList.size(), "数据异常, 请联系管理员");
            this.taskNeedMachinePartSchedulingService
               .lambdaUpdate()
               .in(MesBuildingTaskNeedMachinePartScheduling::getId, zeroTaskNeedMachinePartSchedulingIdList)
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getSchedulingDate, null)
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus, false)
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getNestingJobId, null)
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getSchedulingQuantity, 0)
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getSchedulingUserId, null)
               .set(
                  true, MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus, IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType()
               )
               .set(true, MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareOperationTime, null)
               .update();
         }
      }

      BoChuNesting.deleteNestedPlate(nestingTeam.getTeamCode(), guidList);
      if (param.getDeleteScope().equals(1)) {
         BoChuNesting.partUpdateQuantityOrDelete(nestingTeam.getTeamCode(), boChuPartUpdateParamMap);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean jobSteelPlateScheduling(JobSteelPlateParam param) {
      Preconditions.checkArgument(param.getJobId() != null, "作业不能为空");
      Preconditions.checkArgument(param.getMachinePartCuttingConfigId() != null, "未选择机床");
      Preconditions.checkArgument(param.getFinishDate() != null, "完成日期不能为空");
      Preconditions.checkArgument(CollUtil.isNotEmpty(param.getNestingResultIdList()), "未选择钢板");
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, param.getJobId())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory), "作业不存在, 请刷新后重试");
      MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingTeam), "所选作业未获取到对应的套料团队信息, 请刷新后重试");
      MesBuildingMachinePartTeamDetail machinePartTeamDetail = this.machinePartTeamDetailService.getById(param.getMachinePartCuttingConfigId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(machinePartTeamDetail), "零件切割配置不存在, 请刷新后重试");
      MesBuildingProductionLine productionLine = this.productionLineService.getById(machinePartTeamDetail.getProductionLineId());
      List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(param.getNestingResultIdList());
      Preconditions.checkArgument(CollUtil.isNotEmpty(nestingResultList), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(nestingResultList.size() == param.getNestingResultIdList().size(), "所选钢板不存在, 请刷新后重试");
      if (!BooleanUtil.isTrue(param.getBoolSecondaryScheduling())) {
         Preconditions.checkArgument(
            nestingResultList.stream().allMatch(nr -> Objects.equals(CutSendEnum.NOT_DISPATCHED.getCode(), nr.getCutSendStatus())), "存在已下发钢板, 请刷新后重试"
         );
      }

      List<String> childGuidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getChildGuid).collect(Collectors.toList());
      this.nestBiz.generateSurplus(childGuidList);
      MesBuildingBoChuJobDirectory projectJobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, jobDirectory.getParentId())
         .one();
      MesBuildingBoChuJobDirectory workshopJobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, projectJobDirectory.getParentId())
         .one();
      MesBuildingCutConfig cutConfig = this.cutConfigBiz.lambdaQuery().eq(MesBuildingCutConfig::getName, machinePartTeamDetail.getDeviceType()).one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(cutConfig), "所选切割方式的钻孔工艺配置不存在");
      BigDecimal minThickness = new BigDecimal(cutConfig.getMinThickness());
      BigDecimal maxThickness = new BigDecimal(cutConfig.getMaxThickness());
      nestingResultList.forEach(
         nr -> Preconditions.checkArgument(
            nr.getThickness().compareTo(minThickness) >= 0 && nr.getThickness().compareTo(maxThickness) <= 0,
            "操作失败,厚度" + nr.getThickness() + "不在" + minThickness + "-" + maxThickness + "的厚度范围中"
         )
      );
      SysDictionary ncFileTypeDictionary = this.dictionaryService
         .lambdaQuery()
         .eq(SysDictionary::getName, "nc_file_type")
         .eq(SysDictionary::getValue, machinePartTeamDetail.getNcFileFormat())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(ncFileTypeDictionary), "数控文件格式类型不存在");
      String ncFileTitleType = ncFileTypeDictionary.getLabel();
      String ncFileTitle = StrUtil.subBefore(ncFileTitleType, ".", true);
      String ncFileType = StrUtil.concat(true, ".", StrUtil.subAfter(ncFileTitleType, ".", true));
      SysDictionary deviceTypeDictionary = this.dictionaryService
         .lambdaQuery()
         .eq(SysDictionary::getName, "device_type")
         .eq(SysDictionary::getValue, machinePartTeamDetail.getDeviceType())
         .one();
      String deviceType = BeanUtil.isNotEmpty(deviceTypeDictionary) ? deviceTypeDictionary.getLabel() : null;
      List<BoChuCutFileConfigDTO> nestCutFileTypeDTOList = BoChuNesting.getNestCutFileConfig(nestingTeam.getTeamCode());
      List<String> extensionList = nestCutFileTypeDTOList.stream().map(BoChuCutFileConfigDTO::getExtension).collect(Collectors.toList());
      if (!".LXDS".equalsIgnoreCase(ncFileType) && !".SLP".equalsIgnoreCase(ncFileType)) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(nestCutFileTypeDTOList), nestingTeam.getTeamCode() + "团队未配置除.LXDS/.SLP类型外的其他套料切割文件导出");
         Preconditions.checkArgument(
            extensionList.contains(ncFileType), nestingTeam.getTeamCode() + "团队未配置该类型套料切割文件导出目前支持的切割文件格式后缀有:" + CollUtil.join(extensionList, ",")
         );
      }

      List<String> guidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
         nestingTeam.getTeamCode(), ListUtil.toList(param.getJobId()), guidList
      );
      Map<String, BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOMap = machinePartNestingGuidDetailDTOList.stream()
         .collect(Collectors.toMap(BoChuNestedPlateDetailDTO::getGuid, Function.identity(), (existing, replacement) -> existing));
      CutTaskRequestData cutTaskRequestData = new CutTaskRequestData();
      cutTaskRequestData.setOrderType(1L);
      cutTaskRequestData.setWorkshopLevelName(workshopJobDirectory.getJobName());
      cutTaskRequestData.setProjectLevelName(projectJobDirectory.getJobName());
      cutTaskRequestData.setGroupTaskLevelName(jobDirectory.getJobName());
      cutTaskRequestData.setCode(param.getJobId().toString());
      cutTaskRequestData.setWorkshopId(productionLine.getWorkshopId().toString());
      cutTaskRequestData.setMid(machinePartTeamDetail.getMID());
      List<CreateDto> createDtos = new ArrayList<>();
      List<MesBuildingTaskNeedMachinePartScheduling> allTaskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
         .lambdaQuery()
         .eq(MesBuildingTaskNeedMachinePartScheduling::getProjectId, jobDirectory.getProjectId())
         .apply("need_quantity - scheduling_quantity > 0")
         .list();
      Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingGroup = allTaskNeedMachinePartSchedulingList.stream()
         .collect(Collectors.groupingBy(ex -> ex.getTaskOrderId() + "-" + ex.getProductId()));
      List<Long> scheduleIds = new ArrayList<>();
      nestingResultList.forEach(
         nr -> {
            String childGuid = nr.getChildGuid();
            BoChuNestedPlateDetailDTO machinePartNestingGuidDetailDTO = machinePartNestingGuidDetailDTOMap.get(nr.getGuid());
            if (BeanUtil.isNotEmpty(machinePartNestingGuidDetailDTO)) {
               List<PartDTO> parts = machinePartNestingGuidDetailDTO.getPartList();
               MesBuildingMachinePartSchedulingDTOParam machinePartSchedulingDTOParam = new MesBuildingMachinePartSchedulingDTOParam();
               machinePartSchedulingDTOParam.setCutConfigId(param.getMachinePartCuttingConfigId());
               machinePartSchedulingDTOParam.setBcGuid(childGuid);
               machinePartSchedulingDTOParam.setGroupsId(machinePartTeamDetail.getGroupsId());
               machinePartSchedulingDTOParam.setSaveType(1);
               machinePartSchedulingDTOParam.setChildOrderNumber(nr.getChildOrderNumber());
               machinePartSchedulingDTOParam.setJobId(param.getJobId());
               machinePartSchedulingDTOParam.setAskCompleteTime(param.getFinishDate());
               machinePartSchedulingDTOParam.setDrillCutConfigId(param.getDrillCutConfigId());
               machinePartSchedulingDTOParam.setDrillGroupsId(param.getDrillGroupsId());
               machinePartSchedulingDTOParam.setDrillAskCompleteTime(param.getDrillAskCompleteTime());
               machinePartSchedulingDTOParam.setBoolOffLine(false);
               machinePartSchedulingDTOParam.setProductionLineId(machinePartTeamDetail.getProductionLineId());
               machinePartSchedulingDTOParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
               List<Long> duplicatePartIdList = new ArrayList<>();
               parts.stream()
                  .filter(part -> CollUtil.isNotEmpty(part.getPropMap()))
                  .map(part -> MapUtil.getLong(part.getPropMap(), "productId"))
                  .filter(ObjectUtil::isNotNull)
                  .collect(Collectors.groupingBy(key -> (Long)key, Collectors.counting()))
                  .forEach((productId, count) -> {
                     if (count > 1L) {
                        duplicatePartIdList.add(productId);
                     }
                  });
               List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList = new ArrayList<>();

               for (PartDTO part : parts) {
                  if (!CollUtil.isEmpty(part.getPropMap())) {
                     Integer amount = part.getAmount();
                     Long productId = MapUtil.getLong(part.getPropMap(), "productId");
                     Long taskOrderId = MapUtil.getLong(part.getPropMap(), "taskOrderId");
                     if (productId != null) {
                        List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = taskNeedMachinePartSchedulingGroup.get(
                           taskOrderId + "-" + productId
                        );
                        if (CollectionUtils.isEmpty(taskNeedMachinePartSchedulingList)) {
                           taskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
                              .lambdaQuery()
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId)
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productId)
                              .list();
                        }

                        int sum = taskNeedMachinePartSchedulingList.stream().mapToInt(exx -> exx.getNeedQuantity() - exx.getSchedulingQuantity()).sum();
                        if (!duplicatePartIdList.contains(productId)) {
                           Preconditions.checkArgument(sum >= amount, "套料可排产数量不足，请联系管理员");
                        }

                        if (CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulingList)) {
                           for (MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling : taskNeedMachinePartSchedulingList) {
                              if (amount == 0) {
                                 break;
                              }

                              MesBuildingMachinePartSchedulingLinkDTOParam machinePartSchedulingLinkDTOParam = new MesBuildingMachinePartSchedulingLinkDTOParam();
                              machinePartSchedulingLinkDTOParam.setId(taskNeedMachinePartScheduling.getId());
                              machinePartSchedulingLinkDTOParam.setProjectId(Long.valueOf(jobDirectory.getProjectId()));
                              machinePartSchedulingLinkDTOParam.setProductId(productId);
                              machinePartSchedulingLinkDTOParam.setOrderId(taskNeedMachinePartScheduling.getTaskOrderId().toString());
                              machinePartSchedulingLinkDTOParam.setNeedSchedulingMonth(param.getFinishDate());
                              int remainingNeedQuantity = taskNeedMachinePartScheduling.getNeedQuantity()
                                 - taskNeedMachinePartScheduling.getSchedulingQuantity();
                              if (amount >= remainingNeedQuantity) {
                                 machinePartSchedulingLinkDTOParam.setQuantity(remainingNeedQuantity);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(taskNeedMachinePartScheduling.getNeedQuantity());
                                 this.taskNeedMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                                 linkList.add(machinePartSchedulingLinkDTOParam);
                                 amount = amount - remainingNeedQuantity;
                              } else if (amount - remainingNeedQuantity < 0) {
                                 machinePartSchedulingLinkDTOParam.setQuantity(amount);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(taskNeedMachinePartScheduling.getSchedulingQuantity() + amount);
                                 this.taskNeedMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                                 linkList.add(machinePartSchedulingLinkDTOParam);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               machinePartSchedulingDTOParam.setLinkList(linkList);
               if (CollectionUtil.isNotEmpty(linkList)) {
                  Long aLong = this.machinePartSchedulingBiz.saveMachinePartNestCutNew(machinePartSchedulingDTOParam);
                  scheduleIds.add(aLong);
                  CreateDto createDto = new CreateDto();
                  createDto.setCuttingWay(deviceType);
                  createDto.setTexture(nr.getMaterial());
                  createDto.setPartNum(nr.getPartAmount().intValue());
                  createDto.setNum(nr.getAmount().intValue());
                  createDto.setLength(nr.getPlateHeight().toPlainString());
                  createDto.setIdNumber(nr.getChildGuid());
                  createDto.setBreadth(nr.getPlateWidth().toPlainString());
                  createDto.setThickness(nr.getThickness().toPlainString());
                  byte[] zipFileBytes = Optional.of(ncFileType)
                     .filter(o -> ".LXDS".equalsIgnoreCase(ncFileType) || ".SLP".equalsIgnoreCase(ncFileType))
                     .map(o -> BoChuNesting.getNestCutFileLXDS(nestingTeam.getTeamCode(), param.getJobId(), nr.getGuid()))
                     .orElseGet(
                        () -> {
                           Preconditions.checkArgument(
                              extensionList.contains(ncFileType), "团队码：" + nestingTeam.getTeamCode() + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType
                           );
                           AtomicReference<String> type = new AtomicReference<>();
                           if (StrUtil.isNotBlank(ncFileTitle)) {
                              nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                                 if (Objects.equals(nestCutFileTypeDTO.getExtension(), ncFileType)
                                    && Objects.equals(nestCutFileTypeDTO.getTitle(), ncFileTitle)) {
                                    type.set(nestCutFileTypeDTO.getTitle());
                                 }
                              });
                           } else {
                              nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                                 if (nestCutFileTypeDTO.getExtension().equals(ncFileType)) {
                                    type.set(nestCutFileTypeDTO.getTitle());
                                 }
                              });
                           }

                           Preconditions.checkArgument(
                              StrUtil.isNotBlank(type.get()), "团队码：" + nestingTeam.getTeamCode() + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType
                           );
                           return BoChuNesting.getNestCutFileNC(nestingTeam.getTeamCode(), param.getJobId(), nr.getGuid(), type.get());
                        }
                     );

                  try (
                     ByteArrayInputStream bais = new ByteArrayInputStream(zipFileBytes);
                     ZipInputStream zis = new ZipInputStream(bais);
                  ) {
                     ZipEntry entry = zis.getNextEntry();
                     Preconditions.checkArgument(entry != null, "ZIP文件为空或没有文件");
                     createDto.setFile(IoUtil.readBytes(zis));
                     String fileNameNest = entry.getName();
                     String extension = StrUtil.subAfter(fileNameNest, ".", true);
                     String fileName = this.getFilename() + "." + extension;
                     createDto.setFileName(fileName);
                     nr.setFileNameNest(fileNameNest);
                     nr.setFileName(fileName);
                  } catch (Exception e) {
                     throw new RuntimeException("下发物联时柏楚切割文件解析出错：" + e.getMessage());
                  }

                  createDtos.add(createDto);
                  nr.setCutSendStatus(CutSendEnum.DISPATCHED.getCode());
                  nr.setCutSendTime(LocalDateTime.now());
                  nr.setMachineToolId(param.getMachinePartCuttingConfigId());
                  nr.setCutSendUserId(UserUtil.getCurrentUserId());
                  nr.setCutSendUserName(UserUtil.getCurrentName());
                  nr.setCutStatus(CutStatusEnum.NOT_CUT.getCode());
                  this.updateById(nr);
               }
            }
         }
      );
      cutTaskRequestData.setCreateDtos(createDtos);

      try {
         NestResultDTO nestResultDTO = this.cutTaskClient.insertCuttingOrder(cutTaskRequestData);
         log.info("套料下发调用物联接口返回结果：{}", nestResultDTO);
         Preconditions.checkArgument(nestResultDTO.getCode().equals("000000"), "切割任务下发失败,调用物联接口异常");
      } catch (Exception e) {
         log.info("物联接口调用异常");
         throw new RuntimeException("调用物联接口异常:" + e.getMessage());
      }

      return true;
   }

   private Long getFilename() {
      String toDay = LocalDate.now().format(DatePattern.PURE_DATE_FORMATTER);
      if (!this.redisUtils.hasKey("program_name_serial_no" + toDay)) {
         List<MesBuildingBoChuNestingResult> list = this.lambdaQuery().like(MesBuildingBoChuNestingResult::getFileName, toDay).list();
         Integer serialNo = list.stream().map(i -> {
            String name = StrUtil.subBefore(i.getFileName(), ".", true);
            return StrUtil.subAfter(name, toDay, true);
         }).filter(NumberUtil::isNumber).map(Integer::parseInt).max(Integer::compareTo).orElse(0);
         this.redisUtils.set("program_name_serial_no" + toDay, Long.valueOf(toDay + String.format("%03d", serialNo)), 86400L);
      }

      return this.redisUtils.incr("program_name_serial_no" + toDay, 1L);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean jobSteelPlateSecondaryScheduling(JobSteelPlateParam param) {
      Preconditions.checkArgument(param.getJobId() != null, "作业不能为空");
      Preconditions.checkArgument(param.getMachinePartCuttingConfigId() != null, "未选择机床");
      Preconditions.checkArgument(param.getFinishDate() != null, "完成日期不能为空");
      Preconditions.checkArgument(CollUtil.isNotEmpty(param.getNestingResultIdList()), "未选择钢板");
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, param.getJobId())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory), "作业不存在, 请刷新后重试");
      MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingTeam), "所选作业未获取到对应的套料团队信息, 请刷新后重试");
      MesBuildingMachinePartTeamDetail machinePartTeamDetail = this.machinePartTeamDetailService.getById(param.getMachinePartCuttingConfigId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(machinePartTeamDetail), "零件切割配置不存在, 请刷新后重试");
      MesBuildingProductionLine productionLine = this.productionLineService.getById(machinePartTeamDetail.getProductionLineId());
      List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(param.getNestingResultIdList());
      Preconditions.checkArgument(CollUtil.isNotEmpty(nestingResultList), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(nestingResultList.size() == param.getNestingResultIdList().size(), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(
         nestingResultList.stream()
            .allMatch(
               nr -> Objects.equals(CutSendEnum.DISPATCHED.getCode(), nr.getCutSendStatus())
                  && Objects.equals(CutStatusEnum.NOT_CUT.getCode(), nr.getCutStatus())
            ),
         "存在已切割钢板, 请刷新后重试"
      );
      long machineToolCount = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getMachineToolId).distinct().count();
      Preconditions.checkArgument(machineToolCount == 1L, "所选钢板不属于同一个机床, 请刷新后重试");
      this.lambdaUpdate()
         .in(MesBuildingBoChuNestingResult::getId, param.getNestingResultIdList())
         .set(true, MesBuildingBoChuNestingResult::getMachineToolId, param.getMachinePartCuttingConfigId())
         .set(true, MesBuildingBoChuNestingResult::getCutSendTime, LocalDateTime.now())
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserId, UserUtil.getCurrentUserId())
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserName, UserUtil.getCurrentName())
         .update();
      List<String> childGuidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getChildGuid).collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = this.taskOrderService
         .lambdaQuery()
         .in(MesBuildingTaskOrder::getChildGuid, childGuidList)
         .eq(MesBuildingTaskOrder::getTaskTypeEnum, ProductTypeEnum.MACHINE_PART.getType())
         .list();
      taskOrderList.forEach(taskOrder -> this.machinePartSchedulingBiz.partTaskOrderRevokeV2(taskOrder.getId()));

      try {
         NestResultDTO nestResultDTO = this.cutTaskClient.deleteDeviceByChildGuidList(childGuidList);
         log.info("套料下发调用物联接口返回结果：{}", nestResultDTO);
         Preconditions.checkArgument(nestResultDTO.getCode().equals("000000"), "调用物联接口异常");
      } catch (Exception e) {
         log.info("物联接口调用异常");
         throw new BusinessException("调用物联接口异常:" + e.getMessage());
      }

      param.setBoolSecondaryScheduling(true);
      this.jobSteelPlateScheduling(param);
      return true;
   }

   @Override
   public Boolean jobSteelPlateSecondarySchedulingV2(JobSteelPlateParam param) {
      Preconditions.checkArgument(param.getJobId() != null, "作业不能为空");
      Preconditions.checkArgument(param.getMachinePartCuttingConfigId() != null, "未选择机床");
      Preconditions.checkArgument(param.getFinishDate() != null, "完成日期不能为空");
      Preconditions.checkArgument(CollUtil.isNotEmpty(param.getNestingResultIdList()), "未选择钢板");
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, param.getJobId())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory), "作业不存在, 请刷新后重试");
      MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingTeam), "所选作业未获取到对应的套料团队信息, 请刷新后重试");
      MesBuildingMachinePartTeamDetail machinePartTeamDetail = this.machinePartTeamDetailService.getById(param.getMachinePartCuttingConfigId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(machinePartTeamDetail), "零件切割配置不存在, 请刷新后重试");
      MesBuildingProductionLine productionLine = this.productionLineService.getById(machinePartTeamDetail.getProductionLineId());
      List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(param.getNestingResultIdList());
      Preconditions.checkArgument(CollUtil.isNotEmpty(nestingResultList), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(nestingResultList.size() == param.getNestingResultIdList().size(), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(
         nestingResultList.stream()
            .allMatch(
               nr -> Objects.equals(CutSendEnum.DISPATCHED.getCode(), nr.getCutSendStatus())
                  && Objects.equals(CutStatusEnum.NOT_CUT.getCode(), nr.getCutStatus())
            ),
         "存在已切割钢板, 请刷新后重试"
      );
      long machineToolCount = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getMachineToolId).distinct().count();
      Preconditions.checkArgument(machineToolCount == 1L, "所选钢板不属于同一个机床, 请刷新后重试");
      this.lambdaUpdate()
         .in(MesBuildingBoChuNestingResult::getId, param.getNestingResultIdList())
         .set(true, MesBuildingBoChuNestingResult::getMachineToolId, param.getMachinePartCuttingConfigId())
         .set(true, MesBuildingBoChuNestingResult::getCutSendTime, LocalDateTime.now())
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserId, UserUtil.getCurrentUserId())
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserName, UserUtil.getCurrentName())
         .update();
      List<String> childGuidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getChildGuid).collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = this.taskOrderService
         .lambdaQuery()
         .in(MesBuildingTaskOrder::getChildGuid, childGuidList)
         .eq(MesBuildingTaskOrder::getTaskTypeEnum, ProductTypeEnum.MACHINE_PART.getType())
         .list();
      taskOrderList.forEach(taskOrder -> this.machinePartSchedulingBiz.partTaskOrderRevokeV2(taskOrder.getId()));
      this.nestBiz.generateSurplus(childGuidList);
      MesBuildingBoChuJobDirectory projectJobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, jobDirectory.getParentId())
         .one();
      MesBuildingBoChuJobDirectory workshopJobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, projectJobDirectory.getParentId())
         .one();
      MesBuildingCutConfig cutConfig = this.cutConfigBiz.lambdaQuery().eq(MesBuildingCutConfig::getName, machinePartTeamDetail.getDeviceType()).one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(cutConfig), "所选切割方式的钻孔工艺配置不存在");
      BigDecimal minThickness = new BigDecimal(cutConfig.getMinThickness());
      BigDecimal maxThickness = new BigDecimal(cutConfig.getMaxThickness());
      nestingResultList.forEach(
         nr -> Preconditions.checkArgument(
            nr.getThickness().compareTo(minThickness) >= 0 && nr.getThickness().compareTo(maxThickness) <= 0,
            "操作失败,厚度" + nr.getThickness() + "不在" + minThickness + "-" + maxThickness + "的厚度范围中"
         )
      );
      SysDictionary ncFileTypeDictionary = this.dictionaryService
         .lambdaQuery()
         .eq(SysDictionary::getName, "nc_file_type")
         .eq(SysDictionary::getValue, machinePartTeamDetail.getNcFileFormat())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(ncFileTypeDictionary), "数控文件格式类型不存在");
      String ncFileTitleType = ncFileTypeDictionary.getLabel();
      String ncFileTitle = StrUtil.subBefore(ncFileTitleType, ".", true);
      String ncFileType = StrUtil.concat(true, ".", StrUtil.subAfter(ncFileTitleType, ".", true));
      SysDictionary deviceTypeDictionary = this.dictionaryService
         .lambdaQuery()
         .eq(SysDictionary::getName, "device_type")
         .eq(SysDictionary::getValue, machinePartTeamDetail.getDeviceType())
         .one();
      String deviceType = BeanUtil.isNotEmpty(deviceTypeDictionary) ? deviceTypeDictionary.getLabel() : null;
      List<BoChuCutFileConfigDTO> nestCutFileTypeDTOList = BoChuNesting.getNestCutFileConfig(nestingTeam.getTeamCode());
      List<String> extensionList = nestCutFileTypeDTOList.stream().map(BoChuCutFileConfigDTO::getExtension).collect(Collectors.toList());
      if (!".LXDS".equalsIgnoreCase(ncFileType) && !".SLP".equalsIgnoreCase(ncFileType)) {
         Preconditions.checkArgument(CollectionUtil.isNotEmpty(nestCutFileTypeDTOList), nestingTeam.getTeamCode() + "团队未配置除.LXDS/.SLP类型外的其他套料切割文件导出");
         Preconditions.checkArgument(
            extensionList.contains(ncFileType), nestingTeam.getTeamCode() + "团队未配置该类型套料切割文件导出目前支持的切割文件格式后缀有:" + CollUtil.join(extensionList, ",")
         );
      }

      List<String> guidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getGuid).distinct().collect(Collectors.toList());
      List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
         nestingTeam.getTeamCode(), ListUtil.toList(param.getJobId()), guidList
      );
      Map<String, BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOMap = machinePartNestingGuidDetailDTOList.stream()
         .collect(Collectors.toMap(BoChuNestedPlateDetailDTO::getGuid, Function.identity(), (existing, replacement) -> existing));
      CutTaskRequestData cutTaskRequestData = new CutTaskRequestData();
      cutTaskRequestData.setOrderType(1L);
      cutTaskRequestData.setWorkshopLevelName(workshopJobDirectory.getJobName());
      cutTaskRequestData.setProjectLevelName(projectJobDirectory.getJobName());
      cutTaskRequestData.setGroupTaskLevelName(jobDirectory.getJobName());
      cutTaskRequestData.setCode(param.getJobId().toString());
      cutTaskRequestData.setWorkshopId(productionLine.getWorkshopId().toString());
      cutTaskRequestData.setMid(machinePartTeamDetail.getMID());
      List<CreateDto> createDtos = new ArrayList<>();
      List<MesBuildingTaskNeedMachinePartScheduling> allTaskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
         .lambdaQuery()
         .eq(MesBuildingTaskNeedMachinePartScheduling::getProjectId, jobDirectory.getProjectId())
         .apply("need_quantity - scheduling_quantity > 0")
         .list();
      Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingGroup = allTaskNeedMachinePartSchedulingList.stream()
         .collect(Collectors.groupingBy(ex -> ex.getTaskOrderId() + "-" + ex.getProductId()));
      List<Long> scheduleIds = new ArrayList<>();
      nestingResultList.forEach(
         nr -> {
            String childGuid = nr.getChildGuid();
            BoChuNestedPlateDetailDTO machinePartNestingGuidDetailDTO = machinePartNestingGuidDetailDTOMap.get(nr.getGuid());
            if (BeanUtil.isNotEmpty(machinePartNestingGuidDetailDTO)) {
               List<PartDTO> parts = machinePartNestingGuidDetailDTO.getPartList();
               MesBuildingMachinePartSchedulingDTOParam machinePartSchedulingDTOParam = new MesBuildingMachinePartSchedulingDTOParam();
               machinePartSchedulingDTOParam.setCutConfigId(param.getMachinePartCuttingConfigId());
               machinePartSchedulingDTOParam.setBcGuid(childGuid);
               machinePartSchedulingDTOParam.setGroupsId(machinePartTeamDetail.getGroupsId());
               machinePartSchedulingDTOParam.setSaveType(1);
               machinePartSchedulingDTOParam.setChildOrderNumber(nr.getChildOrderNumber());
               machinePartSchedulingDTOParam.setJobId(param.getJobId());
               machinePartSchedulingDTOParam.setAskCompleteTime(param.getFinishDate());
               machinePartSchedulingDTOParam.setDrillCutConfigId(param.getDrillCutConfigId());
               machinePartSchedulingDTOParam.setDrillGroupsId(param.getDrillGroupsId());
               machinePartSchedulingDTOParam.setDrillAskCompleteTime(param.getDrillAskCompleteTime());
               machinePartSchedulingDTOParam.setBoolOffLine(false);
               machinePartSchedulingDTOParam.setProductionLineId(machinePartTeamDetail.getProductionLineId());
               machinePartSchedulingDTOParam.setProductClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType());
               List<Long> duplicatePartIdList = new ArrayList<>();
               parts.stream()
                  .filter(part -> CollUtil.isNotEmpty(part.getPropMap()))
                  .map(part -> MapUtil.getLong(part.getPropMap(), "productId"))
                  .filter(ObjectUtil::isNotNull)
                  .collect(Collectors.groupingBy(key -> (Long)key, Collectors.counting()))
                  .forEach((productId, count) -> {
                     if (count > 1L) {
                        duplicatePartIdList.add(productId);
                     }
                  });
               List<MesBuildingMachinePartSchedulingLinkDTOParam> linkList = new ArrayList<>();

               for (PartDTO part : parts) {
                  if (!CollUtil.isEmpty(part.getPropMap())) {
                     Integer amount = part.getAmount();
                     Long productId = MapUtil.getLong(part.getPropMap(), "productId");
                     Long taskOrderId = MapUtil.getLong(part.getPropMap(), "taskOrderId");
                     if (productId != null) {
                        List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulingList = taskNeedMachinePartSchedulingGroup.get(
                           taskOrderId + "-" + productId
                        );
                        if (CollectionUtils.isEmpty(taskNeedMachinePartSchedulingList)) {
                           taskNeedMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
                              .lambdaQuery()
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getTaskOrderId, taskOrderId)
                              .eq(MesBuildingTaskNeedMachinePartScheduling::getProductId, productId)
                              .list();
                        }

                        int sum = taskNeedMachinePartSchedulingList.stream().mapToInt(exx -> exx.getNeedQuantity() - exx.getSchedulingQuantity()).sum();
                        if (!duplicatePartIdList.contains(productId)) {
                           Preconditions.checkArgument(sum >= amount, "套料可排产数量不足，请联系管理员");
                        }

                        if (CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulingList)) {
                           for (MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling : taskNeedMachinePartSchedulingList) {
                              if (amount == 0) {
                                 break;
                              }

                              MesBuildingMachinePartSchedulingLinkDTOParam machinePartSchedulingLinkDTOParam = new MesBuildingMachinePartSchedulingLinkDTOParam();
                              machinePartSchedulingLinkDTOParam.setId(taskNeedMachinePartScheduling.getId());
                              machinePartSchedulingLinkDTOParam.setProjectId(Long.valueOf(jobDirectory.getProjectId()));
                              machinePartSchedulingLinkDTOParam.setProductId(productId);
                              machinePartSchedulingLinkDTOParam.setOrderId(taskNeedMachinePartScheduling.getTaskOrderId().toString());
                              machinePartSchedulingLinkDTOParam.setNeedSchedulingMonth(param.getFinishDate());
                              int remainingNeedQuantity = taskNeedMachinePartScheduling.getNeedQuantity()
                                 - taskNeedMachinePartScheduling.getSchedulingQuantity();
                              if (amount >= remainingNeedQuantity) {
                                 machinePartSchedulingLinkDTOParam.setQuantity(remainingNeedQuantity);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(taskNeedMachinePartScheduling.getNeedQuantity());
                                 this.taskNeedMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                                 linkList.add(machinePartSchedulingLinkDTOParam);
                                 amount = amount - remainingNeedQuantity;
                              } else if (amount - remainingNeedQuantity < 0) {
                                 machinePartSchedulingLinkDTOParam.setQuantity(amount);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(taskNeedMachinePartScheduling.getSchedulingQuantity() + amount);
                                 this.taskNeedMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                                 linkList.add(machinePartSchedulingLinkDTOParam);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               machinePartSchedulingDTOParam.setLinkList(linkList);
               if (CollectionUtil.isNotEmpty(linkList)) {
                  Long aLong = this.machinePartSchedulingBiz.saveMachinePartNestCutNew(machinePartSchedulingDTOParam);
                  scheduleIds.add(aLong);
                  CreateDto createDto = new CreateDto();
                  createDto.setCuttingWay(deviceType);
                  createDto.setTexture(nr.getMaterial());
                  createDto.setPartNum(nr.getPartAmount().intValue());
                  createDto.setNum(nr.getAmount().intValue());
                  createDto.setLength(nr.getPlateHeight().toPlainString());
                  createDto.setIdNumber(nr.getChildGuid());
                  createDto.setBreadth(nr.getPlateWidth().toPlainString());
                  createDto.setThickness(nr.getThickness().toPlainString());
                  byte[] zipFileBytes = Optional.of(ncFileType)
                     .filter(o -> ".LXDS".equalsIgnoreCase(ncFileType) || ".SLP".equalsIgnoreCase(ncFileType))
                     .map(o -> BoChuNesting.getNestCutFileLXDS(nestingTeam.getTeamCode(), param.getJobId(), nr.getGuid()))
                     .orElseGet(
                        () -> {
                           Preconditions.checkArgument(
                              extensionList.contains(ncFileType), "团队码：" + nestingTeam.getTeamCode() + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType
                           );
                           AtomicReference<String> type = new AtomicReference<>();
                           if (StrUtil.isNotBlank(ncFileTitle)) {
                              nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                                 if (Objects.equals(nestCutFileTypeDTO.getExtension(), ncFileType)
                                    && Objects.equals(nestCutFileTypeDTO.getTitle(), ncFileTitle)) {
                                    type.set(nestCutFileTypeDTO.getTitle());
                                 }
                              });
                           } else {
                              nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                                 if (nestCutFileTypeDTO.getExtension().equals(ncFileType)) {
                                    type.set(nestCutFileTypeDTO.getTitle());
                                 }
                              });
                           }

                           Preconditions.checkArgument(
                              StrUtil.isNotBlank(type.get()), "团队码：" + nestingTeam.getTeamCode() + " 未配置柏楚切割配置文件未配置，需要的文件类型为：" + ncFileTitleType
                           );
                           return BoChuNesting.getNestCutFileNC(nestingTeam.getTeamCode(), param.getJobId(), nr.getGuid(), type.get());
                        }
                     );

                  try (
                     ByteArrayInputStream bais = new ByteArrayInputStream(zipFileBytes);
                     ZipInputStream zis = new ZipInputStream(bais);
                  ) {
                     ZipEntry entry = zis.getNextEntry();
                     Preconditions.checkArgument(entry != null, "ZIP文件为空或没有文件");
                     createDto.setFile(IoUtil.readBytes(zis));
                     String fileNameNest = entry.getName();
                     String extension = StrUtil.subAfter(fileNameNest, ".", true);
                     String fileName = this.getFilename() + "." + extension;
                     createDto.setFileName(fileName);
                     nr.setFileNameNest(fileNameNest);
                     nr.setFileName(fileName);
                  } catch (Exception e) {
                     throw new RuntimeException("下发物联时柏楚切割文件解析出错：" + e.getMessage());
                  }

                  createDtos.add(createDto);
                  nr.setCutSendStatus(CutSendEnum.DISPATCHED.getCode());
                  nr.setCutSendTime(LocalDateTime.now());
                  nr.setMachineToolId(param.getMachinePartCuttingConfigId());
                  nr.setCutSendUserId(UserUtil.getCurrentUserId());
                  nr.setCutSendUserName(UserUtil.getCurrentName());
                  nr.setCutStatus(CutStatusEnum.NOT_CUT.getCode());
                  this.updateById(nr);
               }
            }
         }
      );
      cutTaskRequestData.setCreateDtos(createDtos);

      try {
         Map<String, Object> paramMap = new HashMap<>();
         paramMap.put("guids", childGuidList);
         paramMap.put("createDto", cutTaskRequestData);
         NestResultDTO nestResultDTO = this.cutTaskClient.deleteAndInsertCuttingOrder(paramMap);
         log.info("调用物联接口返回结果：{}", nestResultDTO);
         Preconditions.checkArgument(nestResultDTO.getCode().equals("000000"), "调用物联接口异常");
      } catch (Exception e) {
         log.info("物联接口调用异常");
         throw new BusinessException("调用物联接口异常:" + e.getMessage());
      }

      return true;
   }

   public String secondValueToHourMinuteSecond(String secondStr) {
      BigDecimal secondValue = new BigDecimal(secondStr);
      BigDecimal hour = secondValue.divideToIntegralValue(BigDecimal.valueOf(3600L));
      BigDecimal remainingSecondValue = secondValue.subtract(hour.multiply(BigDecimal.valueOf(3600L)));
      BigDecimal minute = remainingSecondValue.divideToIntegralValue(BigDecimal.valueOf(60L));
      remainingSecondValue = remainingSecondValue.subtract(minute.multiply(BigDecimal.valueOf(60L)));
      BigDecimal second = remainingSecondValue.remainder(BigDecimal.valueOf(60L));
      return hour.intValue() + "时" + minute.intValue() + "分" + second.intValue() + "秒";
   }

   @Override
   public void jobSteelPlateBatchDownloadReportForm(NestingResultQuery query, HttpServletResponse response) {
      if (query.getJobId() == null) {
         HttpUtils.abnormalResponse(response, "作业不能为空");
      } else {
         MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
            .lambdaQuery()
            .eq(MesBuildingBoChuJobDirectory::getJobId, query.getJobId())
            .one();
         if (BeanUtil.isEmpty(jobDirectory)) {
            HttpUtils.abnormalResponse(response, "作业不存在, 请刷新后重试");
         } else {
            MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
            if (BeanUtil.isEmpty(nestingTeam)) {
               HttpUtils.abnormalResponse(response, "所选作业未获取到对应的套料团队信息, 请刷新后重试");
            } else if (CollUtil.isEmpty(query.getNestingResultIdList())) {
               HttpUtils.abnormalResponse(response, "请选择数据");
            } else {
               List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(query.getNestingResultIdList());
               if (CollUtil.isNotEmpty(nestingResultList) && ObjectUtil.equal(query.getNestingResultIdList().size(), nestingResultList.size())) {
                  Map<Long, ContractProject> projectMap = this.projectService
                     .list()
                     .stream()
                     .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
                  ContractProject project = projectMap.get(Long.valueOf(jobDirectory.getProjectId()));
                  if (BeanUtil.isEmpty(project)) {
                     HttpUtils.abnormalResponse(response, "项目不存在, 请刷新后重试");
                  } else {
                     List<Long> machineToolIdList = nestingResultList.stream()
                        .map(MesBuildingBoChuNestingResult::getMachineToolId)
                        .filter(ObjectUtil::isNotNull)
                        .distinct()
                        .collect(Collectors.toList());
                     Map<Long, MesBuildingMachinePartTeamDetail> machineToolMap = Optional.of(machineToolIdList)
                        .filter(CollUtil::isNotEmpty)
                        .map(this.machinePartTeamDetailService::listByIds)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .collect(Collectors.toMap(MesBuildingMachinePartTeamDetail::getId, Function.identity()));
                     List<Long> teamIdList = machineToolMap.values()
                        .stream()
                        .map(MesBuildingMachinePartTeamDetail::getGroupsId)
                        .filter(ObjectUtil::isNotNull)
                        .distinct()
                        .collect(Collectors.toList());
                     Map<Long, String> teamNameMap = Optional.of(teamIdList)
                        .filter(CollUtil::isNotEmpty)
                        .map(this.teamService::listInfoByIds)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .collect(Collectors.toMap(ShowInfo::getId, ShowInfo::getName));
                     List<MachinePartNestingProductInfoDTO> jobInfoByJobId = this.taskNeedMachinePartSchedulingService
                        .getJobInfoByJobId(jobDirectory.getJobId());
                     File tempDir;
                     try {
                        tempDir = Files.createTempDirectory("ljaps-nesting-report-").toFile();
                     } catch (IOException e) {
                        log.error("创建套料报告临时目录失败", e);
                        HttpUtils.abnormalResponse(response, "报告单下载失败");
                        return;
                     }

                     try {
                        int threadPoolSize = Math.min(nestingResultList.size(), Runtime.getRuntime().availableProcessors() * 2);
                        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
                        AtomicBoolean hasError = new AtomicBoolean(false);
                        List<File> generatedPdfFileList = Collections.synchronizedList(new ArrayList<>());
                        List<CompletableFuture<File>> futures = nestingResultList.stream()
                           .map(
                              nestingResult -> CompletableFuture.supplyAsync(
                                 () -> {
                                    if (hasError.get()) {
                                       return null;
                                    }

                                    try {
                                       MesBuildingMachinePartTeamDetail machineTool = machineToolMap.getOrDefault(
                                          nestingResult.getMachineToolId(), new MesBuildingMachinePartTeamDetail()
                                       );
                                       Long teamId = Optional.of(machineTool)
                                          .filter(x$0 -> BeanUtil.isNotEmpty(x$0))
                                          .map(MesBuildingMachinePartTeamDetail::getGroupsId)
                                          .orElse(null);
                                       BoChuNestedPlateReportDTO nestingReportData = BoChuNesting.getNestedPlateReport(
                                          nestingTeam.getTeamCode(), ListUtil.toList(nestingResult.getGuid())
                                       );
                                       Preconditions.checkArgument(BeanUtil.isNotEmpty(nestingReportData, "获取套料报告数据失败, 请刷新后重试"));
                                       File pdfFile = this.getPdfFile(
                                          nestingResult,
                                          tempDir,
                                          project,
                                          jobDirectory,
                                          machineTool,
                                          teamNameMap,
                                          teamId,
                                          jobInfoByJobId,
                                          nestingReportData,
                                          projectMap
                                       );
                                       if (pdfFile == null) {
                                          hasError.set(true);
                                       }

                                       return pdfFile;
                                    } catch (Exception e) {
                                       hasError.set(true);
                                       log.error("处理套料报告单时发生错误: {}", nestingResult.getGuid(), e);
                                       return null;
                                    }
                                 },
                                 executor
                              )
                           )
                           .collect(Collectors.toList());

                        try {
                           CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
                           allFutures.get();

                           for (CompletableFuture<File> future : futures) {
                              File pdfFile = future.get();
                              if (pdfFile != null) {
                                 generatedPdfFileList.add(pdfFile);
                              }
                           }
                        } catch (Exception e) {
                           log.error("多线程处理失败", e);
                           hasError.set(true);
                        } finally {
                           executor.shutdown();
                        }

                        if (hasError.get() || generatedPdfFileList.size() != nestingResultList.size()) {
                           HttpUtils.abnormalResponse(response, "报告单下载失败");
                        } else {
                           if (CollUtil.isNotEmpty(generatedPdfFileList)) {
                              if (ObjectUtil.equal(generatedPdfFileList.size(), 1)) {
                                 String encodedPdfName;
                                 try {
                                    encodedPdfName = URLEncoder.encode("套料报告单.pdf", StandardCharsets.UTF_8.toString());
                                    response.setHeader(
                                       "Result",
                                       "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
                                    );
                                 } catch (UnsupportedEncodingException e) {
                                    log.error("报告单下载失败", e);
                                    HttpUtils.abnormalResponse(response, "报告单下载失败");
                                    return;
                                 }

                                 response.setHeader("Access-Control-Expose-Headers", "*");
                                 response.setHeader("Access-Control-Allow-Origin", "*");
                                 response.setContentType("application/octet-stream; charset=UTF-8");
                                 response.setHeader("Content-Disposition", "attachment; filename=" + encodedPdfName);

                                 try (
                                    InputStream is = Files.newInputStream(generatedPdfFileList.get(0).toPath());
                                    OutputStream os = response.getOutputStream();
                                 ) {
                                    byte[] buffer = new byte[4096];

                                    int bytesRead;
                                    while ((bytesRead = is.read(buffer)) != -1) {
                                       os.write(buffer, 0, bytesRead);
                                    }

                                    os.flush();
                                 } catch (Exception e) {
                                    log.error("报告单下载失败", e);
                                    HttpUtils.abnormalResponse(response, "报告单下载失败");
                                 }
                              } else {
                                 File zipFile = new File(tempDir, "reports.zip");
                                 ZipUtil.zip(zipFile, CharsetUtil.CHARSET_UTF_8, false, generatedPdfFileList.toArray(new File[0]));

                                 String encodedZipName;
                                 try {
                                    encodedZipName = URLEncoder.encode(jobDirectory.getJobName() + "_套料报告单.zip", StandardCharsets.UTF_8.toString());
                                    response.setHeader(
                                       "Result",
                                       "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + URLEncoder.encode(ResultCodeEnum.SUCCESS.getMessage(), "UTF-8")
                                    );
                                 } catch (UnsupportedEncodingException e) {
                                    log.error("报告单下载失败", e);
                                    HttpUtils.abnormalResponse(response, "报告单下载失败");
                                    return;
                                 }

                                 response.setHeader("Access-Control-Expose-Headers", "*");
                                 response.setHeader("Access-Control-Allow-Origin", "*");
                                 response.setContentType("application/octet-stream; charset=UTF-8");
                                 response.setHeader("Content-Disposition", "attachment; filename=" + encodedZipName);

                                 try (
                                    InputStream is = Files.newInputStream(zipFile.toPath());
                                    OutputStream os = response.getOutputStream();
                                 ) {
                                    byte[] buffer = new byte[4096];

                                    int bytesRead;
                                    while ((bytesRead = is.read(buffer)) != -1) {
                                       os.write(buffer, 0, bytesRead);
                                    }

                                    os.flush();
                                 } catch (Exception e) {
                                    log.error("报告单下载失败", e);
                                    HttpUtils.abnormalResponse(response, "报告单下载失败");
                                 }
                              }
                           } else {
                              HttpUtils.abnormalResponse(response, "无报告单下载");
                           }
                        }
                     } finally {
                        FileUtil.del(tempDir);
                     }
                  }
               } else {
                  HttpUtils.abnormalResponse(response, "包含不存在数据, 请刷新后重试");
               }
            }
         }
      }
   }

   private File getPdfFile(
      MesBuildingBoChuNestingResult nestingResult,
      File tempDir,
      ContractProject project,
      MesBuildingBoChuJobDirectory jobDirectory,
      MesBuildingMachinePartTeamDetail machineTool,
      Map<Long, String> teamNameMap,
      Long teamId,
      List<MachinePartNestingProductInfoDTO> jobInfoByJobId,
      BoChuNestedPlateReportDTO nestingReportData,
      Map<Long, ContractProject> projectMap
   ) {
      String pdfFileName = StrUtil.concat(
         true,
         project.getShortName(),
         "_",
         StrUtil.subBefore(nestingResult.getFileName(), ".", true),
         "_",
         nestingResult.getMaterial(),
         "_",
         nestingResult.getThickness().stripTrailingZeros().toPlainString(),
         ".pdf"
      );
      File pdfFile = new File(tempDir, pdfFileName);

      try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
         PdfWriter writer = new PdfWriter(fos);
         PdfDocument pdfDoc = new PdfDocument(writer);
         pdfDoc.setDefaultPageSize(PageSize.A4);
         Document document = new Document(pdfDoc);
         PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
         document.setFont(font);
         Optional.ofNullable(this.getClass().getResource("/img/logo.png")).map(logoImageUrl -> {
            Image logoImg = null;

            try {
               logoImg = new Image(ImageDataFactory.create(logoImageUrl));
               logoImg.setHorizontalAlignment(HorizontalAlignment.LEFT);
               logoImg.setWidth(50.0F);
               logoImg.setHeight(50.0F);
            } catch (Exception e) {
               log.warn("logo not found");
            }

            return logoImg;
         }).ifPresent(document::add);
         document.add(new Paragraph("套料文件").setFont(font).setFontSize(16.0F).setTextAlignment(TextAlignment.CENTER));
         document.add(new Paragraph("项目信息"));
         Table table1 = new Table(4).useAllAvailableWidth();
         table1.addCell(new Cell(1, 1).add(new Paragraph("项目")));
         table1.addCell(new Cell(1, 3).add(new Paragraph(project.getShortName())));
         table1.addCell(new Cell().add(new Paragraph("任务")));
         table1.addCell(new Cell().add(new Paragraph(jobDirectory.getJobName())));
         table1.addCell(new Cell().add(new Paragraph("设备名称")));
         table1.addCell(new Cell().add(new Paragraph(StrUtil.blankToDefault(machineTool.getDeviceName(), ""))));
         table1.addCell(new Cell(1, 1).add(new Paragraph("程序名")));
         String programName = "";
         if (StrUtil.isNotBlank(nestingResult.getFileName())) {
            programName = nestingResult.getFileName();
            if (StrUtil.isNotBlank(nestingResult.getFileNameNest())) {
               programName = StrUtil.concat(
                  true,
                  programName,
                  "(",
                  StrUtil.subBefore(nestingResult.getFileNameNest(), ".", true),
                  "_",
                  nestingResult.getMaterial(),
                  "_",
                  nestingResult.getThickness().stripTrailingZeros().toPlainString(),
                  ")"
               );
            }
         }

         table1.addCell(new Cell(1, 3).add(new Paragraph(programName)));
         table1.addCell(new Cell(1, 1).add(new Paragraph("班组信息")));
         table1.addCell(new Cell(1, 3).add(new Paragraph(teamNameMap.getOrDefault(teamId, ""))));
         table1.addCell(new Cell().add(new Paragraph("排产日期")));
         table1.addCell(new Cell().add(new Paragraph(jobInfoByJobId.get(0).getSchedulingDate())));
         table1.addCell(new Cell().add(new Paragraph("排产人")));
         table1.addCell(new Cell().add(new Paragraph(jobInfoByJobId.get(0).getSchedulingUserName())));
         ResultInfoDTO resultInfoNestingDTO = nestingReportData.getResultInfoList().get(0);
         table1.addCell(new Cell().add(new Paragraph("厚度（mm）")));
         table1.addCell(new Cell().add(new Paragraph(resultInfoNestingDTO.getThickness().stripTrailingZeros().toPlainString())));
         table1.addCell(new Cell().add(new Paragraph("材质")));
         table1.addCell(new Cell().add(new Paragraph(resultInfoNestingDTO.getMaterial())));
         table1.addCell(new Cell().add(new Paragraph("规格（mm）")));
         table1.addCell(new Cell().add(new Paragraph(resultInfoNestingDTO.getWidth() + "*" + resultInfoNestingDTO.getHeight())));
         table1.addCell(new Cell().add(new Paragraph("利用率")));
         table1.addCell(
            new Cell().add(new Paragraph(nestingResult.getUtilization().setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString() + "%"))
         );
         table1.addCell(new Cell().add(new Paragraph("切割长度（mm）")));
         table1.addCell(new Cell().add(new Paragraph(resultInfoNestingDTO.getCurveLength().stripTrailingZeros().toPlainString())));
         table1.addCell(new Cell().add(new Paragraph("切割时长")));
         table1.addCell(new Cell().add(new Paragraph(this.secondValueToHourMinuteSecond(resultInfoNestingDTO.getCurveTime()))));
         document.add(table1);
         String layoutPath = StrUtil.indexedFormat(this.bochuNestingDiagramPath, nestingResult.getGuid());
         Image layoutImg = new Image(ImageDataFactory.create(layoutPath));
         layoutImg.setHorizontalAlignment(HorizontalAlignment.LEFT);
         layoutImg.setWidth(525.0F);
         layoutImg.setHeight(180.0F);
         document.add(new Paragraph("排样图"));
         document.add(layoutImg);
         document.add(new Paragraph("零件列表"));
         float[] columnWidths2 = new float[]{20.0F, 50.0F, 90.0F, 48.0F, 42.0F, 35.0F, 35.0F};
         Table table2 = new Table(UnitValue.createPercentArray(columnWidths2)).useAllAvailableWidth();
         table2.addHeaderCell("序号");
         table2.addHeaderCell("要求完成日期");
         table2.addHeaderCell("项目");
         table2.addHeaderCell("零件编号");
         table2.addHeaderCell("规格");
         table2.addHeaderCell("零件数量");
         table2.addHeaderCell("重量(kg)");
         List<PartInfoDTO> partInfo = nestingReportData.getTotalInfo().getPartInfoList();
         Map<String, BigDecimal> partAmountMap = resultInfoNestingDTO.getPartInfoList()
            .stream()
            .collect(
               Collectors.toMap(
                  com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO::getGuid,
                  com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO.ResultInfoDTO.PartInfoDTO::getAmount
               )
            );
         List<List<String>> dataList2 = new ArrayList<>();

         for (int i = 0; i < partInfo.size(); i++) {
            List<String> valueList2 = new ArrayList<>();
            Map<String, Object> propMap = partInfo.get(i).getPropMap();
            valueList2.add(String.valueOf(i + 1));
            if (CollUtil.isEmpty(propMap)) {
               valueList2.add("");
            } else {
               String requiredCompletionDate = MapUtil.getStr(propMap, "要求完成日期");
               valueList2.add(StrUtil.blankToDefault(requiredCompletionDate, ""));
            }

            if (CollUtil.isNotEmpty(propMap)) {
               Long projectId = MapUtil.getLong(propMap, "projectId");
               if (null != projectId) {
                  ContractProject cProject = projectMap.get(projectId);
                  valueList2.add(cProject.getShortName());
               } else {
                  valueList2.add("");
               }
            } else {
               valueList2.add("");
            }

            valueList2.add(partInfo.get(i).getName());
            String width = partInfo.get(i).getWidth().setScale(0, RoundingMode.HALF_UP).toPlainString();
            String height = partInfo.get(i).getHeight().setScale(0, RoundingMode.HALF_UP).toPlainString();
            valueList2.add(width + "*" + height);
            valueList2.add(partAmountMap.getOrDefault(partInfo.get(i).getGuid(), BigDecimal.ZERO).stripTrailingZeros().toPlainString());
            String weight = partInfo.get(i)
               .getWeightExcludeComp()
               .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP)
               .stripTrailingZeros()
               .toPlainString();
            valueList2.add(weight);
            dataList2.add(valueList2);
         }

         for (List<String> row : dataList2) {
            for (String cellValue : row) {
               table2.addCell(new Cell().add(new Paragraph(cellValue).setFont(font)));
            }
         }

         document.add(table2);
         document.close();
         return pdfFile;
      } catch (Exception e) {
         log.error("报告单下载失败", e);
         return null;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean jobSteelPlateSchedulingRevoke(JobSteelPlateParam param) {
      Preconditions.checkArgument(param.getJobId() != null, "作业不能为空");
      Preconditions.checkArgument(CollUtil.isNotEmpty(param.getNestingResultIdList()), "未选择钢板");
      MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService
         .lambdaQuery()
         .eq(MesBuildingBoChuJobDirectory::getJobId, param.getJobId())
         .one();
      Preconditions.checkArgument(BeanUtil.isNotEmpty(jobDirectory), "作业不存在, 请刷新后重试");
      List<MesBuildingBoChuNestingResult> nestingResultList = this.listByIds(param.getNestingResultIdList());
      Preconditions.checkArgument(CollUtil.isNotEmpty(nestingResultList), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(nestingResultList.size() == param.getNestingResultIdList().size(), "所选钢板不存在, 请刷新后重试");
      Preconditions.checkArgument(
         nestingResultList.stream()
            .allMatch(
               nr -> Objects.equals(CutSendEnum.DISPATCHED.getCode(), nr.getCutSendStatus())
                  && Objects.equals(CutStatusEnum.NOT_CUT.getCode(), nr.getCutStatus())
            ),
         "存在已切割钢板, 请刷新后重试"
      );
      this.lambdaUpdate()
         .in(MesBuildingBoChuNestingResult::getId, param.getNestingResultIdList())
         .set(true, MesBuildingBoChuNestingResult::getMachineToolId, null)
         .set(true, MesBuildingBoChuNestingResult::getCutSendStatus, CutSendEnum.NOT_DISPATCHED.getCode())
         .set(true, MesBuildingBoChuNestingResult::getCutSendTime, null)
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserId, null)
         .set(true, MesBuildingBoChuNestingResult::getCutSendUserName, null)
         .set(true, MesBuildingBoChuNestingResult::getFileName, null)
         .set(true, MesBuildingBoChuNestingResult::getFileNameNest, null)
         .update();
      List<String> childGuidList = nestingResultList.stream().map(MesBuildingBoChuNestingResult::getChildGuid).collect(Collectors.toList());
      List<MesBuildingTaskOrder> taskOrderList = this.taskOrderService
         .lambdaQuery()
         .in(MesBuildingTaskOrder::getChildGuid, childGuidList)
         .eq(MesBuildingTaskOrder::getTaskTypeEnum, ProductTypeEnum.MACHINE_PART.getType())
         .list();
      taskOrderList.forEach(taskOrder -> this.machinePartSchedulingBiz.partTaskOrderRevokeV2(taskOrder.getId()));

      try {
         NestResultDTO nestResultDTO = this.cutTaskClient.deleteDeviceByChildGuidList(childGuidList);
         log.info("套料下发调用物联接口返回结果：{}", nestResultDTO);
         Preconditions.checkArgument(nestResultDTO.getCode().equals("000000"), "调用物联接口异常");
      } catch (Exception e) {
         log.info("物联接口调用异常");
         throw new BusinessException("调用物联接口异常:" + e.getMessage());
      }

      return true;
   }

   @Override
   public void jobSteelPlateCuttingCodeDownload(Integer jobId, Long nestingResultId, HttpServletResponse response) {
      if (jobId == null) {
         HttpUtils.abnormalResponse(response, "作业不能为空");
      } else if (nestingResultId == null) {
         HttpUtils.abnormalResponse(response, "未选择钢板");
      } else {
         MesBuildingBoChuJobDirectory jobDirectory = this.boChuJobDirectoryService.lambdaQuery().eq(MesBuildingBoChuJobDirectory::getJobId, jobId).one();
         if (BeanUtil.isEmpty(jobDirectory)) {
            HttpUtils.abnormalResponse(response, "作业不存在, 请刷新后重试");
         } else {
            MesBuildingBoChuNestingResult nestingResult = this.getById(nestingResultId);
            if (BeanUtil.isEmpty(nestingResult)) {
               HttpUtils.abnormalResponse(response, "所选钢板不存在, 请刷新后重试");
            } else {
               MesBuildingNestingTeam nestingTeam = this.nestingTeamService.getById(jobDirectory.getTeamCodeId());
               if (BeanUtil.isEmpty(nestingTeam)) {
                  HttpUtils.abnormalResponse(response, "所选作业未获取到对应的套料团队信息, 请刷新后重试");
               } else {
                  MesBuildingMachinePartTeamDetail machinePartTeamDetail = this.machinePartTeamDetailService.getById(nestingResult.getMachineToolId());
                  if (BeanUtil.isEmpty(machinePartTeamDetail)) {
                     HttpUtils.abnormalResponse(response, "零件切割配置不存在, 请刷新后重试");
                  } else {
                     SysDictionary ncFileTypeDictionary = this.dictionaryService
                        .lambdaQuery()
                        .eq(SysDictionary::getName, "nc_file_type")
                        .eq(SysDictionary::getValue, machinePartTeamDetail.getNcFileFormat())
                        .one();
                     if (BeanUtil.isEmpty(ncFileTypeDictionary)) {
                        HttpUtils.abnormalResponse(response, "数控文件格式不存在, 请刷新后重试");
                     } else {
                        String ncFileTitleType = ncFileTypeDictionary.getLabel();
                        String ncFileTitle = StrUtil.subBefore(ncFileTitleType, ".", true);
                        String ncFileType = StrUtil.concat(true, ".", StrUtil.subAfter(ncFileTitleType, ".", true));

                        List<BoChuCutFileConfigDTO> nestCutFileTypeDTOList;
                        try {
                           nestCutFileTypeDTOList = BoChuNesting.getNestCutFileConfig(nestingTeam.getTeamCode());
                        } catch (Exception e) {
                           HttpUtils.abnormalResponse(response, nestingTeam.getTeamCode() + "获取套料软件切割文件类型失败, 请刷新后重试");
                           return;
                        }

                        List<String> extensionList = nestCutFileTypeDTOList.stream().map(BoChuCutFileConfigDTO::getExtension).collect(Collectors.toList());
                        if (!".LXDS".equalsIgnoreCase(ncFileType) && !".SLP".equalsIgnoreCase(ncFileType)) {
                           if (CollUtil.isEmpty(nestCutFileTypeDTOList)) {
                              HttpUtils.abnormalResponse(response, nestingTeam.getTeamCode() + "团队未配置除.LXDS/.SLP类型外的其他套料切割文件导出");
                              return;
                           }

                           if (!extensionList.contains(ncFileType)) {
                              HttpUtils.abnormalResponse(
                                 response, nestingTeam.getTeamCode() + "团队未配置该类型套料切割文件导出目前支持的切割文件格式后缀有:" + CollUtil.join(extensionList, ",")
                              );
                              return;
                           }
                        }

                        byte[] zipFileBytes = Optional.of(ncFileType)
                           .filter(o -> ".LXDS".equalsIgnoreCase(ncFileType) || ".SLP".equalsIgnoreCase(ncFileType))
                           .map(o -> BoChuNesting.getNestCutFileLXDS(nestingTeam.getTeamCode(), jobId, nestingResult.getGuid()))
                           .orElseGet(
                              () -> {
                                 if (!extensionList.contains(ncFileType)) {
                                    return null;
                                 }

                                 AtomicReference<String> type = new AtomicReference<>();
                                 if (StrUtil.isNotBlank(ncFileTitle)) {
                                    nestCutFileTypeDTOList.forEach(
                                       nestCutFileTypeDTO -> {
                                          if (Objects.equals(nestCutFileTypeDTO.getExtension(), ncFileType)
                                             && Objects.equals(nestCutFileTypeDTO.getTitle(), ncFileTitle)) {
                                             type.set(nestCutFileTypeDTO.getTitle());
                                          }
                                       }
                                    );
                                 } else {
                                    nestCutFileTypeDTOList.forEach(nestCutFileTypeDTO -> {
                                       if (nestCutFileTypeDTO.getExtension().equals(ncFileType)) {
                                          type.set(nestCutFileTypeDTO.getTitle());
                                       }
                                    });
                                 }

                                 return StrUtil.isBlank(type.get())
                                    ? null
                                    : BoChuNesting.getNestCutFileNC(nestingTeam.getTeamCode(), jobId, nestingResult.getGuid(), type.get());
                              }
                           );
                        if (zipFileBytes == null) {
                           HttpUtils.abnormalResponse(response, "未获取到数控文件, 请刷新后重试");
                        } else {
                           response.setContentType("apply/octet-stream;charset=UTF-8");
                           response.setContentType("application/zip");
                           response.setHeader("Access-Control-Expose-Headers", "*");

                           try {
                              response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("数控文件.zip", "UTF-8"));

                              try (OutputStream out = response.getOutputStream()) {
                                 out.write(zipFileBytes);
                              }
                           } catch (Exception e) {
                              HttpUtils.abnormalResponse(response, "下载失败, 请刷新后重试");
                              throw new RuntimeException(e);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public List<MesBuildingBoChuNestingResultInfoDTO> listByQueryCondition(NestingResultQuery query) {
      List<MesBuildingBoChuNestingResultInfoDTO> list = this.baseMapper.listByQueryCondition(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Integer> jobIdList = list.stream().map(MesBuildingBoChuNestingResult::getJobId).distinct().collect(Collectors.toList());
         Map<Integer, MesBuildingBoChuJobDirectory> jobMap = Optional.of(jobIdList)
            .filter(CollUtil::isNotEmpty)
            .map(o -> this.boChuJobDirectoryService.lambdaQuery().in(MesBuildingBoChuJobDirectory::getJobId, o).list())
            .orElseGet(Collections::emptyList)
            .stream()
            .collect(Collectors.toMap(MesBuildingBoChuJobDirectory::getJobId, Function.identity()));
         List<Long> teamCodeIdList = jobMap.values().stream().map(MesBuildingBoChuJobDirectory::getTeamCodeId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingNestingTeam> nestingTeamMap = Optional.of(teamCodeIdList)
            .filter(CollUtil::isNotEmpty)
            .map(this.nestingTeamService::listByIds)
            .orElseGet(Collections::emptyList)
            .stream()
            .collect(Collectors.toMap(MesBuildingNestingTeam::getId, Function.identity()));
         list.parallelStream().forEach(i -> this.fillValue(i, Collections.unmodifiableMap(jobMap), Collections.unmodifiableMap(nestingTeamMap)));
      }

      return list;
   }

   private void fillValue(
      MesBuildingBoChuNestingResultInfoDTO i, Map<Integer, MesBuildingBoChuJobDirectory> jobMap, Map<Long, MesBuildingNestingTeam> nestingTeamMap
   ) {
      MesBuildingBoChuJobDirectory job = jobMap.get(i.getJobId());
      if (!BeanUtil.isEmpty(job)) {
         i.setProjectId(Long.valueOf(job.getProjectId()));
         MesBuildingNestingTeam nestingTeam = nestingTeamMap.get(job.getTeamCodeId());
         if (!BeanUtil.isEmpty(nestingTeam)) {
            List<BoChuNestedPlateDetailDTO> machinePartNestingGuidDetailDTOList = BoChuNesting.getNestedPlateDetail(
               nestingTeam.getTeamCode(), Collections.singletonList(i.getJobId()), Collections.singletonList(i.getGuid())
            );
            List<TechMachinePartInfoDTO> partList = machinePartNestingGuidDetailDTOList.stream()
               .filter(ObjectUtil::isNotNull)
               .findFirst()
               .map(BoChuNestedPlateDetailDTO::getPartList)
               .filter(CollUtil::isNotEmpty)
               .orElseGet(Collections::emptyList)
               .stream()
               .map(part -> {
                  if (CollUtil.isEmpty(part.getPropMap())) {
                     return null;
                  }

                  Long productId = MapUtil.getLong(part.getPropMap(), "productId");
                  Long taskOrderId = MapUtil.getLong(part.getPropMap(), "taskOrderId");
                  Integer amount = part.getAmount();
                  TechMachinePart machinePart = this.machinePartService.getById(productId);
                  TechMachinePartInfoDTO partInfoDTO = new TechMachinePartInfoDTO();
                  partInfoDTO.setId(productId);
                  partInfoDTO.setQuantity(amount);
                  partInfoDTO.setThick(machinePart.getThick());
                  partInfoDTO.setTaskOrderId(taskOrderId);
                  partInfoDTO.setNetWeight(machinePart.getNetWeight());
                  partInfoDTO.setGrossWeight(machinePart.getGrossWeight());
                  return partInfoDTO;
               })
               .filter(ObjectUtil::isNotNull)
               .collect(Collectors.toList());
            i.setPartList(partList);
         }
      }
   }
}
