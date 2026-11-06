package com.hzchum.scim.mes.building.core.biz.impl.report_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesReportWorkApprovedBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesReportWorkUnapprovedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesTeamWageSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkApprovedParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesReportWorkUnapprovedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesTeamWageSummaryQuery;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesReportWorkApprovedService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesReportWorkApprovedMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesReportWorkApprovedBizImpl
   extends IBizImpl<MesReportWorkApprovedService, MesReportWorkApprovedMapper, MesReportWorkApproved>
   implements MesReportWorkApprovedBiz {
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;

   @Override
   public PageVO<MesReportWorkUnapprovedDTO> unapprovedPage(MesReportWorkUnapprovedQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      List<MesReportWorkUnapprovedDTO> list = this.baseService.unapprovedList(query);
      List<MesReportWorkUnapprovedDTO> mergeList = new ArrayList<>();
      if (CollUtil.isNotEmpty(list)) {
         Map<String, List<MesReportWorkUnapprovedDTO>> group = list.stream()
            .collect(
               Collectors.groupingBy(
                  i -> ProductTypeEnum.MACHINE_PART.getType().equals(i.getProductTypeEnum())
                     ? i.getWorkshop().getId()
                        + "&"
                        + i.getProcess().getId()
                        + "&"
                        + i.getTeam().getId()
                        + "&"
                        + i.getTaskOrderId()
                        + "&"
                        + i.getQuotaConfigId()
                        + "&"
                        + i.getPrice()
                     : i.getWorkshop().getId()
                        + "&"
                        + i.getProject().getId()
                        + "&"
                        + i.getProcess().getId()
                        + "&"
                        + i.getTeam().getId()
                        + "&"
                        + i.getProduct().getSerialNumber()
                        + "&"
                        + i.getQuotaConfigNumber()
                        + "&"
                        + i.getPrice()
               )
            );
         group.forEach((k, v) -> {
            MesReportWorkUnapprovedDTO current = BeanUtil.toBean(v.get(0), MesReportWorkUnapprovedDTO.class);
            List<LocalDateTime> currentReportTimeList = v.stream().map(MesReportWorkUnapprovedDTO::getReportTime).sorted().collect(Collectors.toList());
            current.setMinReportTime(currentReportTimeList.get(0));
            current.setMaxReportTime(currentReportTimeList.get(currentReportTimeList.size() - 1));
            if (current.getQuotaConfigId() != null) {
               BigDecimal accountingQuantity = v.stream().map(MesReportWorkUnapprovedDTO::getAccountingQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
               current.setAccountingQuantity(accountingQuantity);
               BigDecimal totalPrice = accountingQuantity.multiply(current.getPrice());
               current.setTotalPrice(totalPrice);
            }

            BigDecimal totalWeight = v.stream().map(MesReportWorkUnapprovedDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
            current.setTotalWeight(totalWeight);
            current.setSubList(BeanUtil.copyToList(v, MesReportWorkUnapprovedDTO.class));
            mergeList.add(current);
         });
      }

      Page page = PageUtils.getPageVO(
         mergeList.stream().sorted(Comparator.comparingLong(MesReportWorkUnapprovedDTO::getProduceTeamReportId)).collect(Collectors.toList()),
         pageNumber,
         pageSize
      );
      return new PageVO<>(page);
   }

   @Override
   public Map<String, Object> statistics(Integer year) {
      return this.baseService.statistics(year);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean elimination(List<MesReportWorkApprovedParam> params) {
      List<MesBuildingProduceTeamReport> produceTeamReportList = params.stream()
         .map(i -> MesBuildingProduceTeamReport.builder().id(i.getProduceTeamReportId()).boolWageElimination(true).build())
         .collect(Collectors.toList());
      this.produceTeamReportService.updateBatchById(produceTeamReportList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approved(List<MesReportWorkApprovedParam> params) {
      return this.baseService.approved(params);
   }

   @Override
   public PageVO<MesTeamWageSummaryDTO> teamWageSummaryPage(MesTeamWageSummaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTeamWageSummaryDTO> list = this.baseService.teamWageSummary(query);
      return new PageVO<>(page, list);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamWageSummaryPrint(MesTeamWageSummaryQuery query) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> dataList = this.baseService.teamWageSummary(query).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(dataList);
      return printVO;
   }

   @Override
   public Map<String, Object> teamWageSummaryStatistics(MesTeamWageSummaryQuery query) {
      Map<String, Object> resultMap = new HashMap<>();
      List<MesTeamWageSummaryDTO> list = this.baseService.teamWageSummary(query);
      BigDecimal totalWage = list.stream().map(MesTeamWageSummaryDTO::getWage).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal totalProductionQuantity = list.stream()
         .map(MesTeamWageSummaryDTO::getProductionQuantity)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal averagePrice = BigDecimal.ZERO.compareTo(totalWage) == 0
         ? BigDecimal.ZERO
         : totalWage.divide(totalProductionQuantity, 8, RoundingMode.HALF_UP);
      resultMap.put("totalWage", totalWage);
      resultMap.put("totalProductionQuantity", totalProductionQuantity);
      resultMap.put("averagePrice", averagePrice);
      return resultMap;
   }

   @Override
   public PageVO<MesTeamProductionDTO> teamProductionPage(MesTeamWageSummaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTeamProductionDTO> list = this.baseService.teamProduction(query);
      return new PageVO<>(page, list);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamProductionPrint(MesTeamWageSummaryQuery query) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<Map<String, Object>> dataList = this.baseService.teamProduction(query).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(dataList);
      return printVO;
   }
}
