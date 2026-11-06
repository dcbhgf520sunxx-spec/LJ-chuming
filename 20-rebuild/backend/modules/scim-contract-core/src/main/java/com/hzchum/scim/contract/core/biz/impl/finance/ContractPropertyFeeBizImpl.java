package com.hzchum.scim.contract.core.biz.impl.finance;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractPropertyFeeBiz;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractPropertyFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractPropertyFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractPropertyFeeDtoParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractPropertyFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractPropertyFeeMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ContractPropertyFeeBizImpl
   extends IBizImpl<ContractPropertyFeeService, ContractPropertyFeeMapper, ContractPropertyFee>
   implements ContractPropertyFeeBiz {
   @Resource
   private AttachmentService attachmentService;

   @Override
   public ListVO<ContractPropertyFeeDTO> listByCondition(Integer year) {
      List<ContractPropertyFeeDTO> propertyFeeDTOList = this.baseService.listByCondition(year).stream().map(s -> {
         ContractPropertyFeeDTO propertyFeeDTO = BeanUtil.copy(s, ContractPropertyFeeDTO.class);
         propertyFeeDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return propertyFeeDTO;
      }).collect(Collectors.toList());
      return new ListVO<>(propertyFeeDTOList);
   }

   @Override
   public Boolean saveList(List<ContractPropertyFeeDtoParam> paramList) {
      paramList.forEach(param -> {
         if (param.getId() != null) {
            ContractPropertyFee propertyFee = this.baseService.getById(param.getId());
            Preconditions.checkArgument(propertyFee != null, "记录不存在");
            Preconditions.checkArgument(propertyFee.getBoolConfirmStatus().equals(false), "记录已确认,不能修改");
            Preconditions.checkArgument(param.getYear().equals(propertyFee.getYear()) && param.getMonth().equals(propertyFee.getMonth()), "年份和月份不能修改!");
            BeanUtil.copy(param, propertyFee);
            propertyFee.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            this.baseService.updateById(propertyFee);
         } else {
            Preconditions.checkArgument(!this.baseService.isExist(param.getYear(), param.getMonth()), "该年份和月份的记录已存在!");
            ContractPropertyFee propertyFee = BeanUtil.copy(param, ContractPropertyFee.class);
            propertyFee.setYearMonthValue(param.getYear() * 100 + param.getMonth());
            propertyFee.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            propertyFee.setBoolConfirmStatus(false);
            propertyFee.setUserId(UserUtil.getCurrentUserId());
            this.baseService.save(propertyFee);
         }
      });
      return true;
   }

   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractPropertyFee propertyFee = this.baseService.getById(id);
         Preconditions.checkArgument(propertyFee != null, "记录不存在");
         Preconditions.checkArgument(propertyFee.getBoolConfirmStatus().equals(false), "删除失败,记录已确认");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(Integer year) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.baseService.listByCondition(year).stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
