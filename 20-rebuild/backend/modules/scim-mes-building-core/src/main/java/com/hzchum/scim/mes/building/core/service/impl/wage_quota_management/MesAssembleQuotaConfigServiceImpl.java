package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesAssembleQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesAssembleQuotaConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesAssembleQuotaConfigServiceImpl
   extends ServiceImpl<MesAssembleQuotaConfigMapper, MesAssembleQuotaConfig>
   implements MesAssembleQuotaConfigService {
   @Autowired
   private MesAssembleQuotaConfigDetailService detailService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private SysAssembleConfigService assembleConfigService;

   @Override
   public List<MesAssembleQuotaConfigDTO> listInfo(MesQuotaConfigQuery query) {
      List<MesAssembleQuotaConfigDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .map(MesAssembleQuotaConfigDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIdList);
         List<Long> assembleClassIdList = list.stream()
            .map(MesAssembleQuotaConfigDTO::getAssembleClassIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<SysAssembleConfig> assembleConfigList = this.assembleConfigService.listByIds(assembleClassIdList);
         List<Long> idList = list.stream().map(MesAssembleQuotaConfig::getId).collect(Collectors.toList());
         Map<Long, List<MesAssembleQuotaConfigDetail>> detailGroup = this.detailService
            .list(Wrappers.lambdaQuery(MesAssembleQuotaConfigDetail.class).in(MesAssembleQuotaConfigDetail::getAssembleQuotaConfigId, idList))
            .stream()
            .collect(Collectors.groupingBy(MesAssembleQuotaConfigDetail::getAssembleQuotaConfigId));
         list.forEach(
            dto -> {
               List<String> workshopNameList = workshopList.stream()
                  .filter(workshop -> dto.getWorkshopIdList().contains(workshop.getId()))
                  .map(MesBuildingWorkshop::getName)
                  .collect(Collectors.toList());
               dto.setWorkshopNameList(workshopNameList);
               List<String> assembleClassNameList = assembleConfigList.stream()
                  .filter(structure -> dto.getAssembleClassIdList().contains(structure.getId()))
                  .map(SysAssembleConfig::getName)
                  .collect(Collectors.toList());
               dto.setAssembleClassNameList(assembleClassNameList);
               dto.setDetailList(detailGroup.get(dto.getId()));
            }
         );
      }

      return list;
   }

   private void verifyParam(MesAssembleQuotaConfigParam param) {
      if (param.getBoolSpecificationClass()) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailList()), "计算详情不能为空");
         List<MesAssembleQuotaConfigDetail> detailList = BeanUtil.copyToList(param.getDetailList(), MesAssembleQuotaConfigDetail.class);
         Preconditions.checkArgument(!this.detailService.isIntersection(detailList), "范围存在交集");
      } else {
         Preconditions.checkArgument(param.getPrice() != null, "单价不能为空");
      }

      LambdaQueryWrapper<MesAssembleQuotaConfig> qw = Wrappers.lambdaQuery(MesAssembleQuotaConfig.class);
      qw.ne(param.getId() != null, MesAssembleQuotaConfig::getId, param.getId());
      qw.eq(MesAssembleQuotaConfig::getStatus, Boolean.TRUE);
      qw.eq(MesAssembleQuotaConfig::getProcessId, param.getProcessId());
      qw.and(q -> param.getWorkshopIdList().forEach(workshopId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, workshop_ids) > 0", workshopId);
      })));
      qw.and(q -> param.getAssembleClassIdList().forEach(assembleClassId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, assemble_class_ids) > 0", assembleClassId);
      })));
      int count = this.baseMapper.selectCount(qw);
      Preconditions.checkArgument(count == 0, "车间+构件类型+工序重复或不存在, 请重新操作");
   }

   private String getQuotaNumber() {
      Integer maxNumber = this.baseMapper.getMaxNumber();
      return "B" + String.format("%03d", maxNumber + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesAssembleQuotaConfigParam param) {
      this.verifyParam(param);
      MesAssembleQuotaConfig quotaConfig = BeanUtil.toBean(param, MesAssembleQuotaConfig.class);
      quotaConfig.setQuotaNumber(this.getQuotaNumber());
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setAssembleClassIds(StrUtil.join(",", param.getAssembleClassIdList()));
      this.baseMapper.insert(quotaConfig);
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesAssembleQuotaConfigDetail> detailList = param.getDetailList().stream().map(detailParam -> {
            MesAssembleQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesAssembleQuotaConfigDetail.class);
            detail.setAssembleQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesAssembleQuotaConfigParam param) {
      MesAssembleQuotaConfig oldQuotaConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能修改");
      this.verifyParam(param);
      MesAssembleQuotaConfig quotaConfig = BeanUtil.toBean(param, MesAssembleQuotaConfig.class);
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setAssembleClassIds(StrUtil.join(",", param.getAssembleClassIdList()));
      this.baseMapper.updateById(quotaConfig);
      this.detailService
         .remove(Wrappers.lambdaQuery(MesAssembleQuotaConfigDetail.class).eq(MesAssembleQuotaConfigDetail::getAssembleQuotaConfigId, param.getId()));
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesAssembleQuotaConfigDetail> detailList = param.getDetailList().stream().map(detailParam -> {
            MesAssembleQuotaConfigDetail detail = BeanUtil.toBean(detailParam, MesAssembleQuotaConfigDetail.class);
            detail.setAssembleQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatus(Long id, Boolean status) {
      MesAssembleQuotaConfig oldQuotaConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能操作");
      this.update(Wrappers.lambdaUpdate(MesAssembleQuotaConfig.class).set(MesAssembleQuotaConfig::getStatus, status).eq(MesAssembleQuotaConfig::getId, id));
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesAssembleQuotaConfig oldQuotaConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能删除");
      this.removeById(id);
      this.detailService.remove(Wrappers.lambdaQuery(MesAssembleQuotaConfigDetail.class).eq(MesAssembleQuotaConfigDetail::getAssembleQuotaConfigId, id));
      return true;
   }
}
