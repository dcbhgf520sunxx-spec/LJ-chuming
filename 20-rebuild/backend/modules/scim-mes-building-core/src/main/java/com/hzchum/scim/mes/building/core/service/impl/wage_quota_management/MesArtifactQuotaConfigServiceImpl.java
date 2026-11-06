package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesArtifactQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesArtifactQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesArtifactQuotaConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesArtifactQuotaConfigServiceImpl
   extends ServiceImpl<MesArtifactQuotaConfigMapper, MesArtifactQuotaConfig>
   implements MesArtifactQuotaConfigService {
   @Autowired
   private MesArtifactQuotaConfigDetailService detailService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private SysStructureClassificationService structureClassificationService;

   @Override
   public List<MesArtifactQuotaConfigDTO> listInfo(MesQuotaConfigQuery query) {
      List<MesArtifactQuotaConfigDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .map(MesArtifactQuotaConfigDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIdList);
         List<Long> artifactClassIdList = list.stream()
            .map(MesArtifactQuotaConfigDTO::getArtifactClassIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<SysStructureClassification> structureClassificationList = this.structureClassificationService.listByIds(artifactClassIdList);
         List<Long> idList = list.stream().map(MesArtifactQuotaConfig::getId).collect(Collectors.toList());
         Map<Long, List<MesArtifactQuotaConfigDetail>> detailGroup = this.detailService
            .list(Wrappers.lambdaQuery(MesArtifactQuotaConfigDetail.class).in(MesArtifactQuotaConfigDetail::getArtifactQuotaConfigId, idList))
            .stream()
            .collect(Collectors.groupingBy(MesArtifactQuotaConfigDetail::getArtifactQuotaConfigId));
         list.forEach(
            dto -> {
               List<String> workshopNameList = workshopList.stream()
                  .filter(workshop -> dto.getWorkshopIdList().contains(workshop.getId()))
                  .map(MesBuildingWorkshop::getName)
                  .collect(Collectors.toList());
               dto.setWorkshopNameList(workshopNameList);
               List<String> artifactClassNameList = structureClassificationList.stream()
                  .filter(structure -> dto.getArtifactClassIdList().contains(structure.getId()))
                  .map(SysStructureClassification::getClassificationName)
                  .collect(Collectors.toList());
               dto.setArtifactClassNameList(artifactClassNameList);
               dto.setDetailList(detailGroup.get(dto.getId()));
            }
         );
      }

      return list;
   }

   private void verifyParam(MesArtifactQuotaConfigParam param) {
      if (param.getBoolSpecificationClass()) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailList()), "计算详情不能为空");
         List<MesArtifactQuotaConfigDetail> detailList = BeanUtil.copyToList(param.getDetailList(), MesArtifactQuotaConfigDetail.class);
         Preconditions.checkArgument(!this.detailService.isIntersection(detailList), "范围存在交集");
      } else {
         Preconditions.checkArgument(param.getPrice() != null, "单价不能为空");
      }

      LambdaQueryWrapper<MesArtifactQuotaConfig> qw = Wrappers.lambdaQuery(MesArtifactQuotaConfig.class);
      qw.ne(param.getId() != null, MesArtifactQuotaConfig::getId, param.getId());
      qw.eq(MesArtifactQuotaConfig::getStatus, Boolean.TRUE);
      qw.eq(MesArtifactQuotaConfig::getProcessId, param.getProcessId());
      qw.and(q -> param.getWorkshopIdList().forEach(workshopId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, workshop_ids) > 0", workshopId);
      })));
      qw.and(q -> param.getArtifactClassIdList().forEach(artifactClassId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, artifact_class_ids) > 0", artifactClassId);
      })));
      int count = this.baseMapper.selectCount(qw);
      Preconditions.checkArgument(count == 0, "车间+构件类型+工序重复或不存在, 请重新操作");
   }

   private String getQuotaNumber() {
      Integer maxNumber = this.baseMapper.getMaxNumber();
      return "G" + String.format("%03d", maxNumber + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesArtifactQuotaConfigParam param) {
      this.verifyParam(param);
      MesArtifactQuotaConfig quotaConfig = BeanUtil.toBean(param, MesArtifactQuotaConfig.class);
      quotaConfig.setQuotaNumber(this.getQuotaNumber());
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setArtifactClassIds(StrUtil.join(",", param.getArtifactClassIdList()));
      this.baseMapper.insert(quotaConfig);
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesArtifactQuotaConfigDetail> detailList = param.getDetailList().stream().map(detailParam -> {
            MesArtifactQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesArtifactQuotaConfigDetail.class);
            detail.setArtifactQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesArtifactQuotaConfigParam param) {
      MesArtifactQuotaConfig oldQuotaConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能修改");
      this.verifyParam(param);
      MesArtifactQuotaConfig quotaConfig = BeanUtil.toBean(param, MesArtifactQuotaConfig.class);
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setArtifactClassIds(StrUtil.join(",", param.getArtifactClassIdList()));
      this.baseMapper.updateById(quotaConfig);
      this.detailService
         .remove(Wrappers.lambdaQuery(MesArtifactQuotaConfigDetail.class).eq(MesArtifactQuotaConfigDetail::getArtifactQuotaConfigId, param.getId()));
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesArtifactQuotaConfigDetail> detailList = param.getDetailList().stream().map(detailParam -> {
            MesArtifactQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesArtifactQuotaConfigDetail.class);
            detail.setArtifactQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatus(Long id, Boolean status) {
      MesArtifactQuotaConfig oldQuotaConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能操作");
      this.update(Wrappers.lambdaUpdate(MesArtifactQuotaConfig.class).set(MesArtifactQuotaConfig::getStatus, status).eq(MesArtifactQuotaConfig::getId, id));
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesArtifactQuotaConfig oldQuotaConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能删除");
      this.removeById(id);
      this.detailService.remove(Wrappers.lambdaQuery(MesArtifactQuotaConfigDetail.class).eq(MesArtifactQuotaConfigDetail::getArtifactQuotaConfigId, id));
      return true;
   }
}
