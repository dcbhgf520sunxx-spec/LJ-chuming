package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesTeamSalaryBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesTeamSalaryTeamProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesTeamSalaryQuery;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesWageConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesTeamSalaryBizImpl implements MesTeamSalaryBiz {
   @Autowired
   private MesProductionReportingApprovalPassedService productionReportingApprovalPassedService;
   @Autowired
   private ConfigService configService;

   @Override
   public Map<String, Object> summary(MesTeamSalaryQuery query) {
      List<MesTeamSalaryDTO> list = this.productionReportingApprovalPassedService.teamSalaryList(query);
      BigDecimal totalSalary = list.stream().map(MesTeamSalaryDTO::getTotalSalary).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal productionVolume = list.stream().map(MesTeamSalaryDTO::getProductionVolume).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal averageLaborCost = productionVolume.compareTo(BigDecimal.ZERO) == 0
         ? BigDecimal.ZERO
         : totalSalary.divide(productionVolume, 8, RoundingMode.HALF_UP);
      Map<String, Object> map = new HashMap<>();
      map.put("totalSalary", totalSalary);
      map.put("productionVolume", productionVolume);
      map.put("averageLaborCost", averageLaborCost);
      return map;
   }

   @Override
   public PageVO<MesTeamSalaryDTO> pageInfo(MesTeamSalaryQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTeamSalaryDTO> list = this.productionReportingApprovalPassedService.teamSalaryList(query);
      return new PageVO<>(page, list);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> print(MesTeamSalaryQuery query) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<MesTeamSalaryDTO> list = this.productionReportingApprovalPassedService.teamSalaryList(query);
      MesWageConfigDTO wageConfigDTO = this.configService.wageConfigGet();
      if (BeanUtil.isNotEmpty(wageConfigDTO)) {
         list.forEach(i -> {
            if (i.getTotalSalary() != null) {
               BigDecimal totalSalary = i.getTotalSalary().setScale(wageConfigDTO.getWageDisplayPrecision(), RoundingMode.HALF_UP);
               i.setTotalSalary(totalSalary);
            }

            if (i.getAverageLaborCost() != null) {
               BigDecimal averageLaborCost = i.getAverageLaborCost().setScale(wageConfigDTO.getWageDisplayPrecision(), RoundingMode.HALF_UP);
               i.setAverageLaborCost(averageLaborCost);
            }
         });
      }

      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public List<MesTeamSalaryTeamProductionDTO> teamProductionList(MesTeamSalaryQuery query) {
      return this.productionReportingApprovalPassedService.teamProductionList(query);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> teamProductionListPrint(MesTeamSalaryQuery query) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<MesTeamSalaryTeamProductionDTO> list = this.productionReportingApprovalPassedService.teamProductionList(query);
      MesWageConfigDTO wageConfigDTO = this.configService.wageConfigGet();
      if (BeanUtil.isNotEmpty(wageConfigDTO)) {
         list.forEach(i -> {
            if (i.getAmount() != null) {
               BigDecimal amount = i.getAmount().setScale(wageConfigDTO.getWageDisplayPrecision(), RoundingMode.HALF_UP);
               i.setAmount(amount);
            }
         });
      }

      printVO.setTable(list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }
}
