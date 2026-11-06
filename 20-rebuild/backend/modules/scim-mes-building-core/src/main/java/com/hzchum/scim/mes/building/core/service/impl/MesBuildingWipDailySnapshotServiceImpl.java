package com.hzchum.scim.mes.building.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.common.core.api.utils.JsonCompressionUtil;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.record.MesBuildingWipDailySnapshot;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingWipDailySnapshotService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.mapper.MesBuildingWipDailySnapshotMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingWipDailySnapshotServiceImpl
   extends ServiceImpl<MesBuildingWipDailySnapshotMapper, MesBuildingWipDailySnapshot>
   implements MesBuildingWipDailySnapshotService {
   private static Logger logger = LoggerFactory.getLogger(MesBuildingWipDailySnapshotServiceImpl.class);
   @Resource
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Autowired
   private ObjectMapper objectMapper;
   @Autowired
   private ProjectBranchCompanyLinkService branchCompanyLinkService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private RedisTemplate<String, Object> redisTemplate;
   private static final String SNAPSHOT_CACHE_KEY = "wip_snapshot:";
   private static final long CACHE_EXPIRE_HOURS = 24L;
   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public void createSnapshot() throws JsonProcessingException {
      List<MesBuildingWipDailySnapshotProcessDTO> processList = this.taskProcessBiz.findWipStatisticsProcessList(new MesBuildingWIPStatisticsVO());
      List<MesBuildingWIPStatisticsDTO> statisticsList = this.taskProcessBiz.findWipStatisticsList(new MesBuildingWIPStatisticsVO());
      List<MesBuildingWIPStatisticsDetailDTO> wipStatisticsDetail = this.taskProcessBiz.findWipStatisticsDetail(new MesBuildingWIPStatisticsVO());
      if (wipStatisticsDetail.size() < 1000) {
         MesBuildingWipDailySnapshot snapshot = new MesBuildingWipDailySnapshot();
         snapshot.setProcessList(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(processList)));
         snapshot.setTaskLists(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(statisticsList)));
         snapshot.setTaskDetails(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(wipStatisticsDetail)));
         this.baseMapper.insert(snapshot);
      } else {
         int batchSize = 10;

         for (int i = 0; i < statisticsList.size(); i += batchSize) {
            int endIndex = Math.min(i + batchSize, statisticsList.size());
            MesBuildingWipDailySnapshot snapshot = new MesBuildingWipDailySnapshot();
            snapshot.setProcessList(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(processList)));
            List<MesBuildingWIPStatisticsDTO> batchStatistics = statisticsList.subList(i, endIndex);
            snapshot.setTaskLists(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(batchStatistics)));
            List<Long> batchProjectIds = batchStatistics.stream().map(MesBuildingWIPStatisticsDTO::getProjectId).distinct().collect(Collectors.toList());
            List<MesBuildingWIPStatisticsDetailDTO> batchDetails = wipStatisticsDetail.stream()
               .filter(detail -> batchProjectIds.contains(detail.getProjectId()))
               .collect(Collectors.toList());
            snapshot.setTaskDetails(JsonCompressionUtil.compressJson(this.objectMapper.writeValueAsString(batchDetails)));
            this.baseMapper.insert(snapshot);
         }
      }
   }

   @Override
   public MesBuildingWipDailySnapshotDTO findWipStatisticsList(MesBuildingWIPStatisticsVO query) throws IOException {
      if (query.getDate() == null) {
         query.setDate(LocalDate.now().plusDays(-1L));
      }

      List<MesBuildingWipDailySnapshot> snapshots = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingWipDailySnapshot.class)
               .between(BaseEntity::getCreateTime, query.getDate().atStartOfDay(), query.getDate().atTime(23, 59, 59))
         );
      if (snapshots != null && !snapshots.isEmpty()) {
         MesBuildingWipDailySnapshotDTO dto = this.mergeSnapshots(snapshots);
         if (dto == null) {
            return MesBuildingWipDailySnapshotDTO.builder().build();
         }

         if (query.getWorkShopId() != null) {
            dto.setStatisticsList(
               dto.getStatisticsList()
                  .stream()
                  .filter(e -> e.getWorkShopId() != null && e.getWorkShopId().equals(query.getWorkShopId()))
                  .collect(Collectors.toList())
            );
         }

         if (query.getBranchCompanyId() != null) {
            dto.setStatisticsList(
               dto.getStatisticsList()
                  .stream()
                  .filter(e -> matchesBranch(e.getBranchCompanyIds(), query.getBranchCompanyId()))
                  .collect(Collectors.toList())
            );
         }

         if (query.getProjectSerialNumber() != null) {
            dto.setStatisticsList(
               dto.getStatisticsList()
                  .stream()
                  .filter(
                     e -> e.getProjectName() != null && e.getProjectName().contains(query.getProjectSerialNumber())
                        || e.getSerialNumber() != null && e.getSerialNumber().contains(query.getProjectSerialNumber())
                  )
                  .collect(Collectors.toList())
            );
         }

         if (CollectionUtils.isNotEmpty(dto.getStatisticsList())) {
            dto.setStatisticsList(this.groupByProjectIdAndProcessId(dto.getStatisticsList()));
         }

         dto.setDetailList(null);
         LocalDate yesterday = query.getDate().plusDays(-1L);
         List<MesBuildingWipDailySnapshot> yesterdaySnapshots = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesBuildingWipDailySnapshot.class)
                  .between(BaseEntity::getCreateTime, yesterday.atStartOfDay(), yesterday.atTime(23, 59, 59))
            );
         if (!yesterdaySnapshots.isEmpty()) {
            MesBuildingWipDailySnapshotDTO yesterdayDto = this.mergeSnapshots(yesterdaySnapshots);
            if (query.getWorkShopId() != null && yesterdayDto != null && CollectionUtils.isNotEmpty(yesterdayDto.getStatisticsList())) {
               yesterdayDto.setStatisticsList(
                  yesterdayDto.getStatisticsList()
                     .stream()
                     .filter(e -> e.getWorkShopId() != null && e.getWorkShopId().equals(query.getWorkShopId()))
                     .collect(Collectors.toList())
               );
            }

            if (CollectionUtils.isNotEmpty(yesterdayDto.getStatisticsList())) {
               if (query.getBranchCompanyId() != null) {
                  yesterdayDto.setStatisticsList(yesterdayDto.getStatisticsList().stream()
                     .filter(e -> matchesBranch(e.getBranchCompanyIds(), query.getBranchCompanyId()))
                     .collect(Collectors.toList()));
               }
               if (query.getProjectSerialNumber() != null) {
                  yesterdayDto.setStatisticsList(yesterdayDto.getStatisticsList().stream()
                     .filter(e -> e.getProjectName() != null && e.getProjectName().contains(query.getProjectSerialNumber())
                        || e.getSerialNumber() != null && e.getSerialNumber().contains(query.getProjectSerialNumber()))
                     .collect(Collectors.toList()));
               }
               yesterdayDto.setStatisticsList(this.groupByProjectIdAndProcessId(yesterdayDto.getStatisticsList()));
            }

            Integer quantity = dto.getStatisticsList()
               .stream()
               .flatMap(e -> e.getProcessWipList().stream())
               .map(ProcessAndQuantityDTO::getQuantity)
               .reduce(0, Integer::sum);
            BigDecimal weight = dto.getStatisticsList()
               .stream()
               .flatMap(e -> e.getProcessWipList().stream())
               .map(ProcessAndQuantityDTO::getWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4);
            Integer yesterdayQuantity = yesterdayDto.getStatisticsList()
               .stream()
               .flatMap(e -> e.getProcessWipList().stream())
               .map(ProcessAndQuantityDTO::getQuantity)
               .reduce(0, Integer::sum);
            BigDecimal yesterdayWeight = yesterdayDto.getStatisticsList()
               .stream()
               .flatMap(e -> e.getProcessWipList().stream())
               .map(ProcessAndQuantityDTO::getWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4);
            BigDecimal growthWeight = weight.subtract(yesterdayWeight);
            dto.setGrowthWeight(growthWeight);
            boolean yesterZero = yesterdayQuantity.equals(0);
            BigDecimal rate = BigDecimal.ZERO;
            if (!yesterZero) {
               rate = BigDecimal.valueOf(quantity.intValue())
                  .divide(BigDecimal.valueOf(yesterdayQuantity.intValue()), 4, RoundingMode.HALF_UP)
                  .subtract(BigDecimal.ONE)
                  .multiply(BigDecimal.valueOf(100L));
            }

            dto.setRate(rate);
            dto.setYesterdaySInventory(yesterdayWeight);
         } else {
            dto.setRate(BigDecimal.valueOf(100L));
            dto.setGrowthWeight(BigDecimal.ZERO);
            dto.setYesterdaySInventory(BigDecimal.ZERO);
         }

         return dto;
      } else {
         return MesBuildingWipDailySnapshotDTO.builder().build();
      }
   }

   private static boolean matchesBranch(String ids, Long id) {
      return ids != null && Arrays.stream(ids.split(",")).anyMatch(value -> value.trim().equals(id.toString()));
   }

   public List<MesBuildingWIPStatisticsDTO> groupByProjectIdAndProcessId(List<MesBuildingWIPStatisticsDTO> originalList) {
      Map<Long, List<MesBuildingWIPStatisticsDTO>> groupedByProject = originalList.stream()
         .collect(Collectors.groupingBy(MesBuildingWIPStatisticsDTO::getProjectId));
      return groupedByProject.entrySet()
         .stream()
         .map(
            entry -> {
               Long projectId = entry.getKey();
               List<MesBuildingWIPStatisticsDTO> groupItems = entry.getValue();
               String projectName = groupItems.stream().findFirst().map(MesBuildingWIPStatisticsDTO::getProjectName).orElse(null);
               Map<Long, ProcessAndQuantityDTO> processQuantityMap = groupItems.stream()
                  .flatMap(item -> item.getProcessWipList().stream())
                  .collect(
                     Collectors.toMap(
                        ProcessAndQuantityDTO::getProcessId,
                        dto -> ProcessAndQuantityDTO.builder()
                           .processId(dto.getProcessId())
                           .processName(dto.getProcessName())
                           .quantity(dto.getQuantity())
                           .weight(dto.getWeight())
                           .taskTypeEnum(dto.getTaskTypeEnum())
                           .build(),
                        (dto1, dto2) -> ProcessAndQuantityDTO.builder()
                           .processId(dto1.getProcessId())
                           .processName(dto1.getProcessName())
                           .quantity(dto1.getQuantity() + dto2.getQuantity())
                           .weight(
                              dto1.getWeight() != null && dto2.getWeight() != null
                                 ? dto1.getWeight().add(dto2.getWeight())
                                 : (dto1.getWeight() != null ? dto1.getWeight() : dto2.getWeight())
                           )
                           .taskTypeEnum(dto1.getTaskTypeEnum())
                           .build()
                     )
                  );
               List<ProcessAndQuantityDTO> mergedProcessWipList = processQuantityMap.values().stream().collect(Collectors.toList());
               return MesBuildingWIPStatisticsDTO.builder()
                  .projectId(projectId)
                  .projectName(projectName)
                  .workShopId(null)
                  .processWipList(mergedProcessWipList)
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   public MesBuildingWipDailySnapshotDTO parseDetails(MesBuildingWipDailySnapshot snapshot) throws IOException {
      String cacheKey = "wip_snapshot:" + snapshot.getId();
      MesBuildingWipDailySnapshotDTO cachedDto = (MesBuildingWipDailySnapshotDTO)this.redisTemplate.opsForValue().get(cacheKey);
      if (cachedDto != null) {
         return cachedDto;
      }

      List<MesBuildingWipDailySnapshotProcessDTO> processList = this.objectMapper
         .readValue(JsonCompressionUtil.decompressJson(snapshot.getProcessList()), new TypeReference<List<MesBuildingWipDailySnapshotProcessDTO>>() {});
      List<MesBuildingWIPStatisticsDTO> statisticsList = this.objectMapper
         .readValue(JsonCompressionUtil.decompressJson(snapshot.getTaskLists()), new TypeReference<List<MesBuildingWIPStatisticsDTO>>() {});
      List<MesBuildingWIPStatisticsDetailDTO> detailList = this.objectMapper
         .readValue(JsonCompressionUtil.decompressJson(snapshot.getTaskDetails()), new TypeReference<List<MesBuildingWIPStatisticsDetailDTO>>() {});
      List<MesBuildingWipDailySnapshotProcessDTO> extractprocess = extractprocess(statisticsList, Arrays.asList(1, 16, 2));
      MesBuildingWipDailySnapshotDTO dto = MesBuildingWipDailySnapshotDTO.builder()
         .processList(extractprocess)
         .detailList(detailList)
         .statisticsList(statisticsList)
         .build();
      this.redisTemplate.opsForValue().set(cacheKey, dto, 24L, TimeUnit.HOURS);
      return dto;
   }

   @Override
   public PageVO<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query, Integer pageNumber, Integer pageSize) throws IOException {
      if (query.getDate() == null) {
         query.setDate(LocalDate.now().plusDays(-1L));
      }

      List<MesBuildingWipDailySnapshot> snapshotList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingWipDailySnapshot.class)
               .between(BaseEntity::getCreateTime, query.getDate().atStartOfDay(), query.getDate().atTime(23, 59, 59))
         );
      if (CollectionUtils.isEmpty(snapshotList)) {
         return new PageVO<>();
      }

      if (query.getTaskTypeEnum() == null && query.getProcessId() != null && query.getProcessId() < 999L) {
         query.setTaskTypeEnum(this.processService.getById(query.getProcessId()).getProductType());
      }

      MesBuildingWipDailySnapshotDTO dto = this.mergeSnapshots(snapshotList);
      List<MesBuildingWIPStatisticsDetailDTO> detailDTOS = dto.getDetailList()
         .stream()
         .filter(
            e -> query.getProcessId() == null
               ? true
               : e.getProcessId().equals(query.getProcessId())
                  || e.getProcessId().equals(0L)
                     && query.getProcessId() < 1000L
                     && (e.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType()) || e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()))
         )
         .filter(e -> query.getWorkShopId() != null ? e.getWorkShopId().equals(query.getWorkShopId()) : true)
         .filter(e -> query.getProjectId() != null ? e.getProjectId().equals(query.getProjectId()) : true)
         .filter(e -> query.getTaskTypeEnum() != null ? e.getTaskTypeEnum().equals(query.getTaskTypeEnum()) : true)
         .collect(Collectors.toList());
      return PageUtil.listPage(pageNumber, pageSize, detailDTOS);
   }

   @Override
   public List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query) throws IOException {
      if (query.getDate() == null) {
         query.setDate(LocalDate.now().plusDays(-1L));
      }

      List<MesBuildingWipDailySnapshot> snapshots = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingWipDailySnapshot.class)
               .between(BaseEntity::getCreateTime, query.getDate().atStartOfDay(), query.getDate().atTime(23, 59, 59))
         );
      if (snapshots != null && !snapshots.isEmpty()) {
         MesBuildingWipDailySnapshotDTO dto = this.mergeSnapshots(snapshots);
         return dto.getProcessList();
      } else {
         return new ArrayList<>();
      }
   }

   private MesBuildingWipDailySnapshotDTO mergeSnapshots(List<MesBuildingWipDailySnapshot> snapshots) throws IOException {
      if (snapshots != null && !snapshots.isEmpty()) {
         List<MesBuildingWIPStatisticsDTO> allStatisticsList = new ArrayList<>();
         List<MesBuildingWIPStatisticsDetailDTO> allDetailList = new ArrayList<>();

         for (MesBuildingWipDailySnapshot snapshot : snapshots) {
            List<MesBuildingWIPStatisticsDTO> statisticsList = this.objectMapper
               .readValue(JsonCompressionUtil.decompressJson(snapshot.getTaskLists()), new TypeReference<List<MesBuildingWIPStatisticsDTO>>() {});
            List<MesBuildingWIPStatisticsDetailDTO> detailList = this.objectMapper
               .readValue(JsonCompressionUtil.decompressJson(snapshot.getTaskDetails()), new TypeReference<List<MesBuildingWIPStatisticsDetailDTO>>() {});
            allStatisticsList.addAll(statisticsList);
            allDetailList.addAll(detailList);
         }

         List<MesBuildingWipDailySnapshotProcessDTO> extractprocess = extractprocess(allStatisticsList, Arrays.asList(1, 16, 2));
         return MesBuildingWipDailySnapshotDTO.builder().processList(extractprocess).detailList(allDetailList).statisticsList(allStatisticsList).build();
      } else {
         return null;
      }
   }

   @Override
   public void findWipStatisticsListDownload(MesBuildingWIPStatisticsVO query, HttpServletResponse response) throws IOException {
      List<MesBuildingWIPStatisticsDTO> statisticsList = this.findWipStatisticsList(query).getStatisticsList();
      this.exportToExcel(statisticsList, response);
   }

   private static List<MesBuildingWipDailySnapshotProcessDTO> extractprocess(List<MesBuildingWIPStatisticsDTO> dataList, List<Integer> sortList) {
      return dataList.stream()
         .flatMap(e -> e.getProcessWipList().stream())
         .collect(Collectors.toMap(e -> e.getProcessId(), Function.identity(), (old, newVal) -> old))
         .values()
         .stream()
         .sorted(
            (s1, s2) -> {
               if (sortList.contains(s1.getTaskTypeEnum())) {
                  return s1.getTaskTypeEnum().equals(s2.getTaskTypeEnum())
                     ? sortList.indexOf(s1.getTaskTypeEnum()) - sortList.indexOf(s2.getTaskTypeEnum())
                     : s1.getProcessId().compareTo(s2.getProcessId());
               } else {
                  return 1;
               }
            }
         )
         .map(e -> BeanUtil.copy(e, MesBuildingWipDailySnapshotProcessDTO.class))
         .collect(Collectors.toList());
   }

   public void exportToExcel(List<MesBuildingWIPStatisticsDTO> dataList, HttpServletResponse response) throws IOException {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("在制品统计");
      CellStyle cellStyle = workbook.createCellStyle();
      cellStyle.setAlignment(HorizontalAlignment.CENTER);
      cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
      cellStyle.setBorderTop(BorderStyle.THIN);
      cellStyle.setBorderBottom(BorderStyle.THIN);
      cellStyle.setBorderLeft(BorderStyle.THIN);
      cellStyle.setBorderRight(BorderStyle.THIN);
      cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
      cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
      cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
      Font font = workbook.createFont();
      font.setFontName("宋体");
      font.setFontHeightInPoints((short)12);
      cellStyle.setFont(font);
      Row headerRow = sheet.createRow(0);
      String[] staticHeaders = new String[]{"序号", "项目"};

      for (int i = 0; i < staticHeaders.length; i++) {
         Cell cell = headerRow.createCell(i);
         cell.setCellValue(staticHeaders[i]);
      }

      int dynamicColumnStartIndex = staticHeaders.length;
      List<Integer> sortList = Arrays.asList(1, 16, 2);
      List<MesBuildingWipDailySnapshotProcessDTO> extractprocess = extractprocess(dataList, sortList);
      if (CollectionUtils.isNotEmpty(extractprocess)) {
         for (int i = 0; i < extractprocess.size(); i++) {
            Cell cell = headerRow.createCell(dynamicColumnStartIndex + i * 2);
            cell.setCellValue(extractprocess.get(i).getProcessName() + "(数量)");
            Cell cell1 = headerRow.createCell(dynamicColumnStartIndex + i * 2 + 1);
            cell1.setCellValue("重量(kg)");
         }
      }

      int rowNum = 1;

      for (MesBuildingWIPStatisticsDTO data : dataList) {
         Row row = sheet.createRow(rowNum++);
         row.createCell(0).setCellValue(rowNum - 1);
         row.createCell(1).setCellValue(data.getProjectName());
         List<ProcessAndQuantityDTO> processes = data.getProcessWipList();
         Map<Long, ProcessAndQuantityDTO> processMap = processes.stream().collect(Collectors.toMap(s -> s.getProcessId(), Function.identity()));

         for (int i = 0; i < extractprocess.size(); i++) {
            ProcessAndQuantityDTO processDTO = processMap.get(extractprocess.get(i).getProcessId());
            if (processDTO != null) {
               row.createCell(dynamicColumnStartIndex + i * 2).setCellValue(processDTO.getQuantity().intValue());
               row.createCell(dynamicColumnStartIndex + i * 2 + 1).setCellValue(processDTO.getWeight().toString());
            } else {
               row.createCell(dynamicColumnStartIndex + i * 2).setCellValue("-");
               row.createCell(dynamicColumnStartIndex + i * 2 + 1).setCellValue("-");
            }
         }
      }

      for (int i = 0; i < staticHeaders.length + extractprocess.size() * 2; i++) {
         sheet.autoSizeColumn(i);
      }

      response.setCharacterEncoding("UTF-8");
      response.setHeader("content-Type", "application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("在制品统计.xlsx", "UTF-8"));
      response.setHeader("Access-Control-Expose-Headers", "*");
      response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
      workbook.write(response.getOutputStream());
      workbook.close();
   }
}
