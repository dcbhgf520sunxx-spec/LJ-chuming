package com.hzchum.scim.mes.building.core.biz.impl.wage_manage;

import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.wage_manage.MesProductionWageBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesProductionWageReverseInferenceModeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesProductionWageReverseInferenceModeExcelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsMonthSummaryExcelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.MesProductionWageSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request.ReverseInferenceModeExportParam;
import com.hzchum.scim.mes.building.core.api.service.wage_manage.MesProductionWageService;
import com.hzchum.scim.mes.building.core.mapper.wage_manage.MesProductionWageMapper;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesProductionWageBizImpl extends IBizImpl<MesProductionWageService, MesProductionWageMapper, MesProductionWage> implements MesProductionWageBiz {
   @Autowired
   private MesContractProjectStatisticsConfigLinkService statisticsConfigLinkService;

   @Override
   public Map<String, LocalDate> dateRange(Integer year, Integer month, Long projectId) {
      MesContractProjectStatisticsConfigLink statisticsConfigLink = this.statisticsConfigLinkService
         .getOne(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      LocalDate startDate;
      LocalDate endDate;
      if (statisticsConfigLink != null && statisticsConfigLink.getStatisticsDeadline() != null) {
         int dayOfMonth = statisticsConfigLink.getStatisticsDeadline().getDayOfMonth();
         int lastDay = YearMonth.of(year, month).atEndOfMonth().getDayOfMonth();
         if (dayOfMonth > lastDay) {
            dayOfMonth = lastDay;
         }

         endDate = LocalDate.of(year, month, dayOfMonth);
         startDate = endDate.plusMonths(-1L).plusDays(1L);
      } else {
         startDate = YearMonth.of(year, month).atDay(1);
         endDate = YearMonth.of(year, month).atEndOfMonth();
      }

      return MapUtil.builder("startDate", startDate).put("endDate", endDate).build();
   }

   @Override
   public List<MesWageStatisticsYearSummaryDTO> yearSummaryList(Integer year, Long workshopId, Long projectId) {
      MesContractProjectStatisticsConfigLink statisticsConfigLink = this.statisticsConfigLinkService
         .getOne(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      LocalDate startDate;
      LocalDate endDate;
      if (statisticsConfigLink != null && statisticsConfigLink.getStatisticsDeadline() != null) {
         int dayOfMonth = statisticsConfigLink.getStatisticsDeadline().getDayOfMonth();
         startDate = LocalDate.of(year - 1, Month.DECEMBER, dayOfMonth).plusDays(1L);
         endDate = LocalDate.of(year, Month.DECEMBER, dayOfMonth);
      } else {
         startDate = Year.of(year).atDay(1);
         endDate = YearMonth.of(year, 12).atEndOfMonth();
      }

      List<MesWageStatisticsYearSummaryDTO> dtoList = new ArrayList<>();

      while (!startDate.isAfter(endDate)) {
         LocalDate nextMonthStart = startDate.plusMonths(1L);
         LocalDate endOfRange = nextMonthStart.plusDays(-1L);
         MesWageStatisticsYearSummaryDTO dto = this.baseMapper.dateRangeSummary(startDate, endOfRange, workshopId, projectId);
         if (ObjectUtil.isNotEmpty(dto)) {
            dto.setYearMonth(endOfRange.format(DateTimeFormatter.ofPattern("yyyy-MM")));
            dtoList.add(dto);
         }

         startDate = endOfRange.plusDays(1L);
      }

      return dtoList;
   }

   @Override
   public PageVO<MesWageStatisticsMonthSummaryDTO> monthSummaryPage(
      Integer year, Integer month, Long projectId, Long workshopId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      MesContractProjectStatisticsConfigLink statisticsConfigLink = this.statisticsConfigLinkService
         .getOne(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      LocalDate startDate;
      LocalDate endDate;
      LocalDate lastMonthStartDate;
      LocalDate lastMonthEndDate;
      if (statisticsConfigLink != null && statisticsConfigLink.getStatisticsDeadline() != null) {
         int dayOfMonth = statisticsConfigLink.getStatisticsDeadline().getDayOfMonth();
         int lastDay = YearMonth.of(year, month).atEndOfMonth().getDayOfMonth();
         if (dayOfMonth > lastDay) {
            dayOfMonth = lastDay;
         }

         endDate = LocalDate.of(year, month, dayOfMonth);
         startDate = endDate.plusMonths(-1L).plusDays(1L);
         lastMonthEndDate = endDate.plusMonths(-1L);
         lastMonthStartDate = startDate.plusMonths(-1L);
      } else {
         startDate = YearMonth.of(year, month).atDay(1);
         endDate = YearMonth.of(year, month).atEndOfMonth();
         lastMonthStartDate = startDate.plusMonths(-1L);
         lastMonthEndDate = endDate.plusMonths(-1L);
      }

      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesWageStatisticsMonthSummaryDTO> dtoList = this.baseMapper
         .monthSummaryList(startDate, endDate, workshopId, lastMonthStartDate, lastMonthEndDate, projectId);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public void monthSummaryExport(Integer year, Integer month, Long projectId, Long workshopId, HttpServletResponse response) {
      MesContractProjectStatisticsConfigLink statisticsConfigLink = this.statisticsConfigLinkService
         .getOne(Wrappers.lambdaQuery(MesContractProjectStatisticsConfigLink.class).eq(MesContractProjectStatisticsConfigLink::getContractProjectId, projectId));
      LocalDate startDate;
      LocalDate endDate;
      LocalDate lastMonthStartDate;
      LocalDate lastMonthEndDate;
      if (statisticsConfigLink != null && statisticsConfigLink.getStatisticsDeadline() != null) {
         int dayOfMonth = statisticsConfigLink.getStatisticsDeadline().getDayOfMonth();
         int lastDay = YearMonth.of(year, month).atEndOfMonth().getDayOfMonth();
         if (dayOfMonth > lastDay) {
            dayOfMonth = lastDay;
         }

         endDate = LocalDate.of(year, month, dayOfMonth);
         startDate = endDate.plusMonths(-1L).plusDays(1L);
         lastMonthEndDate = endDate.plusMonths(-1L);
         lastMonthStartDate = startDate.plusMonths(-1L);
      } else {
         startDate = YearMonth.of(year, month).atDay(1);
         endDate = YearMonth.of(year, month).atEndOfMonth();
         lastMonthStartDate = startDate.plusMonths(-1L);
         lastMonthEndDate = endDate.plusMonths(-1L);
      }

      List<MesWageStatisticsMonthSummaryDTO> dtoList = this.baseMapper
         .monthSummaryList(startDate, endDate, workshopId, lastMonthStartDate, lastMonthEndDate, projectId);
      AtomicInteger orderNo = new AtomicInteger(1);
      List<MesWageStatisticsMonthSummaryExcelDTO> excelDTOList = dtoList.stream().map(item -> {
         MesWageStatisticsMonthSummaryExcelDTO excelDTO = BeanUtil.toBean(item, MesWageStatisticsMonthSummaryExcelDTO.class);
         excelDTO.setOrderNo(orderNo.getAndIncrement());
         excelDTO.setTeamOrganizationTypeName(item.getTeamOrganizationType() ? "编制内" : "编制外");
         return excelDTO;
      }).collect(Collectors.toList());
      String title = "统计日期: " + year + "-" + month;
      String sheetName = year + "-" + month + "汇总表";
      String fileName = year + "-" + month + "汇总表.xlsx";
      PoiUtils.exportExcel(excelDTOList, title, sheetName, MesWageStatisticsMonthSummaryExcelDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Override
   public PageVO<MesProductionWageReverseInferenceModeDTO> reverseInferenceModePage(
      Long workshopId, Long processId, String teamLeaderName, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesProductionWageReverseInferenceModeDTO> dtoList = this.baseMapper
         .reverseInferenceModePage(workshopId, processId, teamLeaderName, startDate, endDate);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public void reverseInferenceModeExport(List<ReverseInferenceModeExportParam> paramList, HttpServletResponse response) {
      AtomicInteger orderNo = new AtomicInteger(1);
      List<MesProductionWageReverseInferenceModeExcelDTO> excelDTOList = paramList.stream()
         .map(
            item -> this.baseMapper
               .reverseInferenceModePage(item.getWorkshopId(), item.getProcessId(), item.getTeamLeaderName(), item.getStartDate(), item.getEndDate())
         )
         .flatMap(Collection::stream)
         .map(item -> {
            MesProductionWageReverseInferenceModeExcelDTO excelDTO = BeanUtil.toBean(item, MesProductionWageReverseInferenceModeExcelDTO.class);
            excelDTO.setOrderNo(orderNo.getAndIncrement());
            excelDTO.setWageStatisticsModeName(WageConfigStatisticsModeEnum.getNameByType(item.getWageStatisticsMode()));
            excelDTO.setMeasurementMannerName(getMeasurementMannerName(item.getMeasurementManner()));
            return excelDTO;
         })
         .collect(Collectors.toList());
      String title = "生产明细";
      String sheetName = "生产明细";
      String fileName = "生产明细.xlsx";
      PoiUtils.exportExcel(excelDTOList, title, sheetName, MesProductionWageReverseInferenceModeExcelDTO.class, fileName, ExcelType.XSSF, response);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approve(ValidList<MesProductionWageSaveParam> saveDTOParamList) {
      Long currentUserId = UserUtil.getCurrentUserId();
      List<Long> ids = saveDTOParamList.stream().map(MesProductionWageSaveParam::getId).distinct().collect(Collectors.toList());
      Map<Long, MesProductionWage> productionWageMap = this.baseMapper
         .selectBatchIds(ids)
         .stream()
         .collect(Collectors.toMap(MesProductionWage::getId, Function.identity()));
      List<MesProductionWage> productionWageList = saveDTOParamList.stream().map(e -> {
         MesProductionWage productionWage = productionWageMap.get(e.getId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(productionWage), "包含不存在的数据, 请刷新后重试");
         MesProductionWage newProductionWage = BeanUtil.toBean(e, MesProductionWage.class);
         BigDecimal totalWage = newProductionWage.getWage().multiply(newProductionWage.getMeasurementQuantity());
         newProductionWage.setTotalWage(totalWage);
         newProductionWage.setBoolConfirm(Boolean.TRUE);
         newProductionWage.setModifiedById(currentUserId);
         newProductionWage.setModifiedTime(LocalDateTime.now());
         return newProductionWage;
      }).collect(Collectors.toList());
      this.baseService.updateBatchById(productionWageList);
      return Boolean.TRUE;
   }

   private static String getMeasurementMannerName(Integer measurementManner) {
      if (measurementManner != null) {
         WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(measurementManner);
         if (typeEnum != null) {
            switch (typeEnum) {
               case WEIGHT_PRICE:
                  return "重量 (t) ";
               case LENGTH_PRICE:
                  return "长度 (m) ";
               case QUANTITY_PRICE:
                  return "数量";
            }
         }
      }

      return null;
   }
}
