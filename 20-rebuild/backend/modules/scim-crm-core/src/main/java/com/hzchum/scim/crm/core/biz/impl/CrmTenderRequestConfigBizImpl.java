package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequestConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderRequestConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmTenderRequestConfigEnumListDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmTenderRequestConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmTenderRequestConfigService;
import com.hzchum.scim.crm.core.mapper.CrmTenderRequestConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmTenderRequestConfigBizImpl
   extends IBizImpl<CrmTenderRequestConfigService, CrmTenderRequestConfigMapper, CrmTenderRequestConfig>
   implements CrmTenderRequestConfigBiz {
   @Resource
   private CrmApplyForBidRecordBiz crmApplyForBidRecordBiz;
   @Resource
   private SysDictionaryService sysDictionaryService;

   @Override
   public List<CrmTenderRequestConfigEnumListDTO> getList(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      List<CrmTenderRequestConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      CrmTenderRequestConfigEnumListDTO crmTenderRequestConfigEnumListDTO = CrmTenderRequestConfigEnumListDTO.builder()
         .crmTenderRequestConfigEnum(crmTenderRequestConfigEnum)
         .crmTenderRequestConfigEnumName(CrmTenderRequestConfigEnum.getNameByType(crmTenderRequestConfigEnum))
         .build();
      List<CrmTenderRequestConfig> crmTenderRequestConfigs = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
               .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, crmTenderRequestConfigEnum)
               .eq(crmSpecialBubmissionStatusEnum != null, CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
               .orderByAsc(CrmTenderRequestConfig::getSort)
         );
      if (CollectionUtils.isNotEmpty(crmTenderRequestConfigs)) {
         crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(
            crmTenderRequestConfigs.stream().map(item -> BeanUtil.copy(item, CrmTenderRequestConfigDTO.class)).collect(Collectors.toList())
         );
      } else {
         crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(new ArrayList<>());
      }

      crmBasicsConfigEnumListDTOS.add(crmTenderRequestConfigEnumListDTO);
      return crmBasicsConfigEnumListDTOS;
   }

   @Transactional
   @Override
   public Boolean updateByList(List<CrmTenderRequestConfigUpdateParam> collect, Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      Map<String, List<CrmTenderRequestConfigUpdateParam>> map = collect.stream().collect(Collectors.groupingBy(item -> item.getName()));
      map.forEach((k, v) -> Preconditions.checkArgument(v.size() == 1, k + "配置重复,请剔除!!!"));
      Preconditions.checkArgument(crmTenderRequestConfigEnum != null, "请先选择类型");
      if (crmTenderRequestConfigEnum.equals(CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())) {
         List<String> stringList = collect.stream().map(CrmTenderRequestConfigUpdateParam::getName).collect(Collectors.toList());
         Preconditions.checkArgument(stringList.contains("技术标"), "技术标不可删除或者修改");
         Preconditions.checkArgument(stringList.contains("措施标"), "措施标不可删除或者修改");
         Preconditions.checkArgument(crmSpecialBubmissionStatusEnum != null, "提报类型不能为空！");
      }

      new ArrayList();
      List<CrmTenderRequestConfig> updateList = new ArrayList<>();
      List<CrmTenderRequestConfig> deleteList = new ArrayList<>();
      Map<Long, CrmTenderRequestConfig> crmTenderRequestConfigMap = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
               .eq(crmSpecialBubmissionStatusEnum != null, CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
               .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, crmTenderRequestConfigEnum)
         )
         .stream()
         .collect(Collectors.toMap(CrmTenderRequestConfig::getId, Function.identity()));
      List<CrmTenderRequestConfigUpdateParam> configSaveParams = collect.stream().filter(item -> item.getId() == null).collect(Collectors.toList());
      List<CrmTenderRequestConfig> var14 = configSaveParams.stream()
         .map(
            item -> BeanUtil.copy(item, CrmTenderRequestConfig.class)
               .setCrmTenderRequestConfigEnum(crmTenderRequestConfigEnum)
               .setCrmSpecialBubmissionStatusEnum(crmSpecialBubmissionStatusEnum)
         )
         .collect(Collectors.toList());
      collect.forEach(
         item -> {
            if (item.getId() != null
               && (
                  !crmTenderRequestConfigMap.get(item.getId()).getName().equals(item.getName())
                     || !item.getSort().equals(crmTenderRequestConfigMap.get(item.getId()).getSort())
               )) {
               updateList.add(BeanUtil.copy(item, CrmTenderRequestConfig.class).setCrmTenderRequestConfigEnum(crmTenderRequestConfigEnum));
            }
         }
      );
      List<Long> newIds = collect.stream().filter(item -> item.getId() != null).map(CrmTenderRequestConfigUpdateParam::getId).collect(Collectors.toList());
      crmTenderRequestConfigMap.forEach((k, v) -> {
         if (!newIds.contains(k)) {
            deleteList.add(v);
         }
      });
      List<String> notModifiableAndDeleteList = new ArrayList<>();
      List<CrmApplyForBidRecord> crmApplyForBidRecordList = this.crmApplyForBidRecordBiz.list();
      List<Long> deleteIds = deleteList.stream().map(CrmTenderRequestConfig::getId).collect(Collectors.toList());
      crmApplyForBidRecordList.forEach(item -> {
         if (item.getBiddingMethodId() != null && deleteIds.contains(item.getBiddingMethodId())) {
            notModifiableAndDeleteList.add(crmTenderRequestConfigMap.get(item.getBiddingMethodId()).getName());
         }

         if (item.getBidEvaluationMethodId() != null && deleteIds.contains(item.getBidEvaluationMethodId())) {
            notModifiableAndDeleteList.add(crmTenderRequestConfigMap.get(item.getBidEvaluationMethodId()).getName());
         }

         if (item.getTenderSubmissionMethodId() != null && deleteIds.contains(item.getTenderSubmissionMethodId())) {
            notModifiableAndDeleteList.add(crmTenderRequestConfigMap.get(item.getTenderSubmissionMethodId()).getName());
         }

         if (item.getSettlementMethodId() != null && deleteIds.contains(item.getSettlementMethodId())) {
            notModifiableAndDeleteList.add(crmTenderRequestConfigMap.get(item.getSettlementMethodId()).getName());
         }

         if (item.getTypeOfPerformanceBondId() != null && deleteIds.contains(item.getTypeOfPerformanceBondId())) {
            notModifiableAndDeleteList.add(crmTenderRequestConfigMap.get(item.getTypeOfPerformanceBondId()).getName());
         }
      });
      Preconditions.checkArgument(CollectionUtils.isEmpty(notModifiableAndDeleteList), notModifiableAndDeleteList.toString() + "已被引用不可删除");
      this.baseService.updateBatchById(updateList);
      this.baseService.removeByIds(deleteList.stream().map(CrmTenderRequestConfig::getId).collect(Collectors.toList()));
      this.baseService.saveBatch(var14);
      return Boolean.TRUE;
   }

   @Override
   public List<CrmTenderRequestConfigEnumListDTO> getListSkipPermissions(Integer crmTenderRequestConfigEnum, Integer crmSpecialBubmissionStatusEnum) {
      List<CrmTenderRequestConfigEnumListDTO> crmBasicsConfigEnumListDTOS = new ArrayList<>();
      if (crmTenderRequestConfigEnum != null) {
         CrmTenderRequestConfigEnumListDTO crmTenderRequestConfigEnumListDTO = CrmTenderRequestConfigEnumListDTO.builder()
            .crmTenderRequestConfigEnum(crmTenderRequestConfigEnum)
            .crmTenderRequestConfigEnumName(CrmTenderRequestConfigEnum.getNameByType(crmTenderRequestConfigEnum))
            .build();
         List<CrmTenderRequestConfig> crmTenderRequestConfigs = this.baseService
            .list(
               Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
                  .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, crmTenderRequestConfigEnum)
                  .eq(crmSpecialBubmissionStatusEnum != null, CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum, crmSpecialBubmissionStatusEnum)
                  .orderByAsc(CrmTenderRequestConfig::getSort)
            );
         if (CollectionUtils.isNotEmpty(crmTenderRequestConfigs)) {
            crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(
               crmTenderRequestConfigs.stream().map(item -> BeanUtil.copy(item, CrmTenderRequestConfigDTO.class)).collect(Collectors.toList())
            );
         } else {
            crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(new ArrayList<>());
         }

         crmBasicsConfigEnumListDTOS.add(crmTenderRequestConfigEnumListDTO);
         return crmBasicsConfigEnumListDTOS;
      } else {
         CrmTenderRequestConfigEnum[] values = CrmTenderRequestConfigEnum.values();

         for (CrmTenderRequestConfigEnum value : values) {
            CrmTenderRequestConfigEnumListDTO crmTenderRequestConfigEnumListDTO = CrmTenderRequestConfigEnumListDTO.builder()
               .crmTenderRequestConfigEnum(value.getType())
               .crmTenderRequestConfigEnumName(value.getName())
               .build();
            List<CrmTenderRequestConfig> crmTenderRequestConfigs = this.baseService
               .list(
                  Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
                     .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, value.getType())
                     .orderByAsc(CrmTenderRequestConfig::getSort)
               );
            if (CollectionUtils.isNotEmpty(crmTenderRequestConfigs)) {
               crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(
                  crmTenderRequestConfigs.stream().map(item -> BeanUtil.copy(item, CrmTenderRequestConfigDTO.class)).collect(Collectors.toList())
               );
            } else {
               crmTenderRequestConfigEnumListDTO.setCrmTenderRequestConfigDTOS(new ArrayList<>());
            }

            crmBasicsConfigEnumListDTOS.add(crmTenderRequestConfigEnumListDTO);
         }

         return crmBasicsConfigEnumListDTOS;
      }
   }

   @Override
   public Boolean syncTenderRequestConfig(Integer crmTenderRequestConfigEnum, String name) {
      List<String> stringList = this.baseService
         .list(Wrappers.lambdaQuery(CrmTenderRequestConfig.class).eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, crmTenderRequestConfigEnum))
         .stream()
         .map(CrmTenderRequestConfig::getName)
         .collect(Collectors.toList());
      List<SysDictionary> sysDictionaryList = this.sysDictionaryService.listByName(name);
      sysDictionaryList.forEach(
         item -> {
            boolean contains = stringList.contains(item.getLabel());
            if (!contains) {
               this.baseService
                  .save(CrmTenderRequestConfig.builder().sort(1).crmTenderRequestConfigEnum(crmTenderRequestConfigEnum).name(item.getLabel()).build());
            }
         }
      );
      return Boolean.TRUE;
   }
}
