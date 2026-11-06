package com.hzchum.scim.contract.core.biz.impl.finance;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWageSummaryBiz;
import com.hzchum.scim.contract.core.api.enums.finance.WageTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageSummary;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageSummaryDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageSummaryDtoParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageSummaryService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWageSummaryMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWageSummaryBizImpl
   extends IBizImpl<ContractWageSummaryService, ContractWageSummaryMapper, ContractWageSummary>
   implements ContractWageSummaryBiz {
   @Resource
   private AttachmentService attachmentService;

   @Override
   public ListVO<ContractWageSummaryDTO> listByCondition(Integer year, Integer wageType) {
      List<ContractWageSummaryDTO> wageSummaryDTOList = this.baseService.listByCondition(year, wageType).stream().map(s -> {
         ContractWageSummaryDTO wageSummaryDTO = BeanUtil.copy(s, ContractWageSummaryDTO.class);
         wageSummaryDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return wageSummaryDTO;
      }).collect(Collectors.toList());
      return new ListVO<>(wageSummaryDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<ContractWageSummaryDtoParam> paramList) {
      paramList.forEach(
         param -> {
            if (param.getId() != null) {
               ContractWageSummary wageSummary = this.baseService.getById(param.getId());
               Preconditions.checkArgument(wageSummary != null, "工资记录不存在");
               Preconditions.checkArgument(wageSummary.getBoolConfirmStatus().equals(false), "修改失败,工资记录已确认!");
               Preconditions.checkArgument(
                  param.getWageType().equals(wageSummary.getWageType())
                     && param.getYear().equals(wageSummary.getYear())
                     && param.getMonth().equals(wageSummary.getMonth()),
                  "工资类型,年份和月份不能修改"
               );
               BeanUtil.copy(param, wageSummary);
               wageSummary.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
               this.baseService.updateById(wageSummary);
            } else {
               ContractWageSummary wageSummary = BeanUtil.copy(param, ContractWageSummary.class);
               Integer count = this.baseService.getCount(param.getWageType(), param.getYear(), param.getMonth());
               Preconditions.checkArgument(count == 0, "新增失败,工资记录已存在");
               wageSummary.setYearMonthValue(param.getYear() * 100 + param.getMonth());
               wageSummary.setUserId(UserUtil.getCurrentUserId());
               wageSummary.setBoolConfirmStatus(false);
               wageSummary.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
               this.baseService.save(wageSummary);
            }
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractWageSummary wageSummary = this.baseService.getById(id);
         Preconditions.checkArgument(wageSummary != null, "删除失败,记录不存在");
         Preconditions.checkArgument(wageSummary.getBoolConfirmStatus().equals(false), "删除失败,记录已确认");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(Integer year, Integer wageType) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      if (wageType != null) {
         Preconditions.checkArgument(WageTypeEnum.isExist(wageType), "工资类型错误");
         header.put("wageType", WageTypeEnum.getNameByType(wageType));
      }

      printVO.setHeader(header);
      List<ContractWageSummary> wageSummaryDTOList = this.baseService.listByCondition(year, wageType);
      List<Map<String, Object>> mapList = wageSummaryDTOList.stream().map(w -> {
         Map<String, Object> map = BeanUtil.beanToMap(w);
         map.put("averageWage", w.getTotalWage().divide(BigDecimal.valueOf(w.getEmployeeQuantity().intValue()), 2, RoundingMode.HALF_UP));
         return map;
      }).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
