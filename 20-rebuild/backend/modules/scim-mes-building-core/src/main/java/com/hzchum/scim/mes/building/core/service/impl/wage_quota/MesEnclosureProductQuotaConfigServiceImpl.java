package com.hzchum.scim.mes.building.core.service.impl.wage_quota;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota.EnclosureProductQuotaConfigSpecificationClassEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesEnclosureProductQuotaConfigDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesEnclosureProductQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesEnclosureProductQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesEnclosureProductQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota.MesEnclosureProductQuotaConfigMapper;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureProductQuotaConfigServiceImpl
   extends ServiceImpl<MesEnclosureProductQuotaConfigMapper, MesEnclosureProductQuotaConfig>
   implements MesEnclosureProductQuotaConfigService {
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesEnclosureProductQuotaConfigDetailService detailService;

   @Override
   public List<MesEnclosureProductQuotaConfigDTO> listInfo(MesEnclosureProductQuotaConfigQuery query) {
      List<MesEnclosureProductQuotaConfigDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .map(MesEnclosureProductQuotaConfigDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIdList);
         List<Long> idList = list.stream().map(MesEnclosureProductQuotaConfig::getId).collect(Collectors.toList());
         Map<Long, List<MesEnclosureProductQuotaConfigDetailDTO>> detailGroup = this.detailService.groupByQuotaConfigIds(idList);
         list.forEach(
            i -> {
               if (CollUtil.isNotEmpty(i.getWorkshopIdList())) {
                  List<String> workshopNameList = workshopList.stream()
                     .filter(workshop -> i.getWorkshopIdList().contains(workshop.getId()))
                     .map(MesBuildingWorkshop::getName)
                     .distinct()
                     .collect(Collectors.toList());
                  i.setWorkshopNameList(workshopNameList);
               }

               if (i.getBoolSpecificationClass()) {
                  i.setDetailList(detailGroup.get(i.getId()));
               }
            }
         );
      }

      return list;
   }

   private String getQuotaNumber() {
      Integer maxNumber = this.baseMapper.getMaxNumber();
      return "W" + String.format("%03d", maxNumber + 1);
   }

   private void verifyParam(MesEnclosureProductQuotaConfigParam param) {
      if (param.getBoolSpecificationClass()) {
         Preconditions.checkArgument(EnclosureProductQuotaConfigSpecificationClassEnum.isExist(param.getSpecificationClassEnum()), "规格分类不存在");
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailParamList()), "规格分类明细不能为空");
         List<MesEnclosureProductQuotaConfigDetail> detailList = BeanUtil.copyToList(param.getDetailParamList(), MesEnclosureProductQuotaConfigDetail.class);
         Preconditions.checkArgument(!this.detailService.isIntersection(detailList), "范围存在交集");
      } else {
         Preconditions.checkArgument(param.getPrice() != null, "单价不能为空");
      }

      LambdaQueryWrapper<MesEnclosureProductQuotaConfig> qw = Wrappers.lambdaQuery(MesEnclosureProductQuotaConfig.class)
         .ne(param.getId() != null, MesEnclosureProductQuotaConfig::getId, param.getId())
         .eq(MesEnclosureProductQuotaConfig::getProductType, param.getProductType());
      qw.and(q -> param.getWorkshopIdList().forEach(workshopId -> (q.or()).apply("FIND_IN_SET({0}, workshop_ids) > 0", workshopId)));
      int count = this.count(qw);
      Preconditions.checkArgument(count == 0, "车间+产品类型重复, 请重新操作");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesEnclosureProductQuotaConfigParam param) {
      this.verifyParam(param);
      MesEnclosureProductQuotaConfig quotaConfig = BeanUtil.toBean(param, MesEnclosureProductQuotaConfig.class);
      quotaConfig.setQuotaNumber(this.getQuotaNumber());
      quotaConfig.setWorkshopIds(CollUtil.join(param.getWorkshopIdList(), ","));
      this.save(quotaConfig);
      if (quotaConfig.getBoolSpecificationClass()) {
         List<MesEnclosureProductQuotaConfigDetail> detailList = param.getDetailParamList().stream().map(detailParam -> {
            MesEnclosureProductQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesEnclosureProductQuotaConfigDetail.class);
            detail.setQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesEnclosureProductQuotaConfigParam param) {
      MesEnclosureProductQuotaConfig quotaConfigOld = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(quotaConfigOld), "数据不存在, 请刷新后重试");
      this.verifyParam(param);
      MesEnclosureProductQuotaConfig quotaConfig = BeanUtil.toBean(param, MesEnclosureProductQuotaConfig.class);
      quotaConfig.setWorkshopIds(CollUtil.join(param.getWorkshopIdList(), ","));
      this.updateById(quotaConfig);
      this.detailService
         .remove(
            Wrappers.lambdaQuery(MesEnclosureProductQuotaConfigDetail.class).eq(MesEnclosureProductQuotaConfigDetail::getQuotaConfigId, quotaConfig.getId())
         );
      if (quotaConfig.getBoolSpecificationClass()) {
         List<MesEnclosureProductQuotaConfigDetail> detailList = param.getDetailParamList().stream().map(detailParam -> {
            MesEnclosureProductQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesEnclosureProductQuotaConfigDetail.class);
            detail.setQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesEnclosureProductQuotaConfig quotaConfigOld = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(quotaConfigOld), "数据不存在, 请刷新后重试");
      this.removeById(id);
      this.detailService
         .remove(Wrappers.lambdaQuery(MesEnclosureProductQuotaConfigDetail.class).eq(MesEnclosureProductQuotaConfigDetail::getQuotaConfigId, id));
      return true;
   }
}
