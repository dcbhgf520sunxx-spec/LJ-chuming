package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmBiddingPlatformWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmGovernmentWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmNumberPrefixConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmSupplierWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmNumberPrefixConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmNumberPrefixConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmNumberPrefixConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmNumberPrefixConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmNumberPrefixConfigService;
import com.hzchum.scim.crm.core.mapper.CrmNumberPrefixConfigMapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmNumberPrefixConfigBizImpl
   extends IBizImpl<CrmNumberPrefixConfigService, CrmNumberPrefixConfigMapper, CrmNumberPrefixConfig>
   implements CrmNumberPrefixConfigBiz {
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmBiddingPlatformWarehousingBiz crmBiddingPlatformWarehousingBiz;
   @Resource
   private CrmSupplierWarehousingBiz crmSupplierWarehousingBiz;
   @Resource
   private CrmGovernmentWarehousingBiz crmGovernmentWarehousingBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;

   @Override
   public List<CrmNumberPrefixConfigDTO> getList() {
      List<CrmNumberPrefixConfigDTO> crmNumberPrefixConfigDTOS = new ArrayList<>();
      Map<Integer, CrmNumberPrefixConfig> integerCrmNumberPrefixConfigMap = this.baseService
         .list()
         .stream()
         .collect(Collectors.toMap(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, Function.identity()));
      CrmNumberPrefixConfigEnum[] values = CrmNumberPrefixConfigEnum.values();

      for (CrmNumberPrefixConfigEnum value : values) {
         CrmNumberPrefixConfigDTO crmNumberPrefixConfigDTO = CrmNumberPrefixConfigDTO.builder()
            .numberPrefixConfigEnum(value.getType())
            .numberPrefixConfigEnumName(value.getName())
            .build();
         CrmNumberPrefixConfig crmNumberPrefixConfig = integerCrmNumberPrefixConfigMap.get(value.getType());
         if (crmNumberPrefixConfig != null) {
            crmNumberPrefixConfigDTO.setPrefixNaming(crmNumberPrefixConfig.getPrefixNaming());
            crmNumberPrefixConfigDTO.setId(crmNumberPrefixConfig.getId());
         }

         crmNumberPrefixConfigDTOS.add(crmNumberPrefixConfigDTO);
      }

      return crmNumberPrefixConfigDTOS;
   }

   @Transactional
   @Override
   public Boolean updateByList(List<CrmNumberPrefixConfigUpdateParam> crmNumberPrefixConfigUpdateParamList) {
      List<CrmNumberPrefixConfig> updateList = new ArrayList<>();
      List<CrmNumberPrefixConfig> saveList = new ArrayList<>();
      crmNumberPrefixConfigUpdateParamList.forEach(
         item -> {
            Preconditions.checkArgument(StringUtils.isNotBlank(item.getPrefixNaming()), "请输入前缀命名");
            if (item.getId() != null) {
               updateList.add(
                  CrmNumberPrefixConfig.builder()
                     .id(item.getId())
                     .numberPrefixConfigEnum(item.getNumberPrefixConfigEnum())
                     .prefixNaming(item.getPrefixNaming())
                     .build()
               );
            } else {
               saveList.add(
                  CrmNumberPrefixConfig.builder().numberPrefixConfigEnum(item.getNumberPrefixConfigEnum()).prefixNaming(item.getPrefixNaming()).build()
               );
            }
         }
      );
      this.baseService.saveBatch(saveList);
      this.baseService.updateBatchById(updateList);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public String generateSerialNumber(Integer crmNumberPrefixConfigEnum) {
      CrmNumberPrefixConfigEnum[] values = CrmNumberPrefixConfigEnum.values();
      StringBuilder stringBuilder = new StringBuilder("");
      LocalDate now = LocalDate.now();
      if (crmNumberPrefixConfigEnum.equals(CrmNumberPrefixConfigEnum.ENTERPRISE_FILING.getType())) {
         CrmNumberPrefixConfig numberPrefixConfig = this.baseService
            .getOne(Wrappers.lambdaQuery(CrmNumberPrefixConfig.class).eq(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, crmNumberPrefixConfigEnum));
         Preconditions.checkArgument(numberPrefixConfig != null && StringUtils.isNotBlank(numberPrefixConfig.getPrefixNaming()), "企业备案编号前缀命名暂未设置");
         int size = this.crmEnterpriseWarehousingBiz.list().size();
         stringBuilder.append(numberPrefixConfig.getPrefixNaming())
            .append(now.getYear())
            .append("-")
            .append(now.getMonth().getValue())
            .append("-")
            .append(now.getDayOfMonth())
            .append("-")
            .append(++size);
      } else if (crmNumberPrefixConfigEnum.equals(CrmNumberPrefixConfigEnum.SUPPLIER_FILING.getType())) {
         CrmNumberPrefixConfig numberPrefixConfig = this.baseService
            .getOne(Wrappers.lambdaQuery(CrmNumberPrefixConfig.class).eq(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, crmNumberPrefixConfigEnum));
         Preconditions.checkArgument(numberPrefixConfig != null && StringUtils.isNotBlank(numberPrefixConfig.getPrefixNaming()), "供应商备案编号前缀命名暂未设置");
         int size = this.crmSupplierWarehousingBiz.list().size();
         stringBuilder.append(numberPrefixConfig.getPrefixNaming())
            .append(now.getYear())
            .append("-")
            .append(now.getMonth().getValue())
            .append("-")
            .append(now.getDayOfMonth())
            .append("-")
            .append(++size);
      } else if (crmNumberPrefixConfigEnum.equals(CrmNumberPrefixConfigEnum.BIDDING_PLATFORM_FILING.getType())) {
         CrmNumberPrefixConfig numberPrefixConfig = this.baseService
            .getOne(Wrappers.lambdaQuery(CrmNumberPrefixConfig.class).eq(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, crmNumberPrefixConfigEnum));
         Preconditions.checkArgument(numberPrefixConfig != null && StringUtils.isNotBlank(numberPrefixConfig.getPrefixNaming()), "招标平台备案编号前缀命名暂未设置");
         int size = this.crmBiddingPlatformWarehousingBiz.list().size();
         stringBuilder.append(numberPrefixConfig.getPrefixNaming())
            .append(now.getYear())
            .append("-")
            .append(now.getMonth().getValue())
            .append("-")
            .append(now.getDayOfMonth())
            .append("-")
            .append(++size);
      } else if (crmNumberPrefixConfigEnum.equals(CrmNumberPrefixConfigEnum.GOVERNMENT_FILING.getType())) {
         CrmNumberPrefixConfig numberPrefixConfig = this.baseService
            .getOne(Wrappers.lambdaQuery(CrmNumberPrefixConfig.class).eq(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, crmNumberPrefixConfigEnum));
         Preconditions.checkArgument(numberPrefixConfig != null && StringUtils.isNotBlank(numberPrefixConfig.getPrefixNaming()), "政府备案编号前缀命名暂未设置");
         int size = this.crmGovernmentWarehousingBiz.list().size();
         stringBuilder.append(numberPrefixConfig.getPrefixNaming())
            .append(now.getYear())
            .append("-")
            .append(now.getMonth().getValue())
            .append("-")
            .append(now.getDayOfMonth())
            .append("-")
            .append(++size);
      } else if (crmNumberPrefixConfigEnum.equals(CrmNumberPrefixConfigEnum.PROJECT_INFORMATION_REGISTRATION.getType())) {
         CrmNumberPrefixConfig numberPrefixConfig = this.baseService
            .getOne(Wrappers.lambdaQuery(CrmNumberPrefixConfig.class).eq(CrmNumberPrefixConfig::getNumberPrefixConfigEnum, crmNumberPrefixConfigEnum));
         Preconditions.checkArgument(numberPrefixConfig != null && StringUtils.isNotBlank(numberPrefixConfig.getPrefixNaming()), "项目信息登记备案编号前缀命名暂未设置");
         int size = this.crmProjectInformationWarehousingBiz.list().size();
         stringBuilder.append(numberPrefixConfig.getPrefixNaming())
            .append(now.getYear())
            .append("-")
            .append(now.getMonth().getValue())
            .append("-")
            .append(now.getDayOfMonth())
            .append("-")
            .append(++size);
      }

      return stringBuilder.toString();
   }
}
