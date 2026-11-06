package com.hzchum.scim.mes.building.core.service.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.enums.PartProdModeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductCategoryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfigDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesMachinePartQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesMachinePartQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigDetailService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesMachinePartQuotaConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMachinePartQuotaConfigServiceImpl
   extends ServiceImpl<MesMachinePartQuotaConfigMapper, MesMachinePartQuotaConfig>
   implements MesMachinePartQuotaConfigService {
   @Autowired
   private MesMachinePartQuotaConfigDetailService detailService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private SysSteelClassificationService steelClassificationService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public PageVO<MesMachinePartQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesMachinePartQuotaConfigDTO> list = this.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesMachinePartQuotaConfigDTO> listInfo(MesQuotaConfigQuery query) {
      List<MesMachinePartQuotaConfigDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .map(MesMachinePartQuotaConfigDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIdList);
         List<Long> machinePartClassIdList = list.stream()
            .map(MesMachinePartQuotaConfigDTO::getMachinePartClassIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<SysSteelClassification> steelClassificationList = this.steelClassificationService.listByIds(machinePartClassIdList);
         List<Long> idList = list.stream().map(MesMachinePartQuotaConfig::getId).collect(Collectors.toList());
         Map<Long, List<MesMachinePartQuotaConfigDetail>> detailGroup = this.detailService
            .list(Wrappers.lambdaQuery(MesMachinePartQuotaConfigDetail.class).in(MesMachinePartQuotaConfigDetail::getMachinePartQuotaConfigId, idList))
            .stream()
            .collect(Collectors.groupingBy(MesMachinePartQuotaConfigDetail::getMachinePartQuotaConfigId));
         list.forEach(
            dto -> {
               List<String> workshopNameList = workshopList.stream()
                  .filter(workshop -> dto.getWorkshopIdList().contains(workshop.getId()))
                  .map(MesBuildingWorkshop::getName)
                  .collect(Collectors.toList());
               dto.setWorkshopNameList(workshopNameList);
               List<String> machinePartClassNameList = steelClassificationList.stream()
                  .filter(structure -> dto.getMachinePartClassIdList().contains(structure.getId()))
                  .map(SysSteelClassification::getName)
                  .collect(Collectors.toList());
               dto.setMachinePartClassNameList(machinePartClassNameList);
               dto.setDetailList(detailGroup.get(dto.getId()));
            }
         );
      }

      return list;
   }

   private void verifyParam(MesMachinePartQuotaConfigParam param) {
      if (param.getBoolSpecificationClass()) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailList()), "计算详情不能为空");
         List<MesMachinePartQuotaConfigDetail> detailList = BeanUtil.copyToList(param.getDetailList(), MesMachinePartQuotaConfigDetail.class);
         Preconditions.checkArgument(!this.detailService.isIntersection(detailList), "范围存在交集");
      } else {
         Preconditions.checkArgument(param.getPrice() != null, "单价不能为空");
      }

      LambdaQueryWrapper<MesMachinePartQuotaConfig> qw = Wrappers.lambdaQuery(MesMachinePartQuotaConfig.class);
      qw.ne(param.getId() != null, MesMachinePartQuotaConfig::getId, param.getId());
      qw.eq(MesMachinePartQuotaConfig::getMachinePartType, param.getMachinePartType());
      qw.eq(MesMachinePartQuotaConfig::getStatus, Boolean.TRUE);
      qw.eq(MesMachinePartQuotaConfig::getProcessId, param.getProcessId());
      qw.and(q -> param.getWorkshopIdList().forEach(workshopId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, workshop_ids) > 0", workshopId);
      })));
      qw.and(q -> param.getMachinePartClassIdList().forEach(classId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, machine_part_class_ids) > 0", classId);
      })));
      int count = this.baseMapper.selectCount(qw);
      Preconditions.checkArgument(count == 0, "车间+零件分类+零件类型+工序重复或不存在, 请重新操作");
   }

   private String getQuotaNumber() {
      Integer maxNumber = this.baseMapper.getMaxNumber();
      return "L" + String.format("%03d", maxNumber + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesMachinePartQuotaConfigParam param) {
      this.verifyParam(param);
      MesMachinePartQuotaConfig quotaConfig = BeanUtil.toBean(param, MesMachinePartQuotaConfig.class);
      quotaConfig.setQuotaNumber(this.getQuotaNumber());
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setMachinePartClassIds(StrUtil.join(",", param.getMachinePartClassIdList()));
      this.save(quotaConfig);
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesMachinePartQuotaConfigDetail> detailList = param.getDetailList().stream().map(dp -> {
            MesMachinePartQuotaConfigDetail detail = BeanUtil.toBean(dp, MesMachinePartQuotaConfigDetail.class);
            detail.setMachinePartQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesMachinePartQuotaConfigParam param) {
      MesMachinePartQuotaConfig oldQuotaConfig = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能修改");
      this.verifyParam(param);
      MesMachinePartQuotaConfig quotaConfig = BeanUtil.toBean(param, MesMachinePartQuotaConfig.class);
      quotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      quotaConfig.setMachinePartClassIds(StrUtil.join(",", param.getMachinePartClassIdList()));
      this.updateById(quotaConfig);
      this.detailService
         .remove(Wrappers.lambdaQuery(MesMachinePartQuotaConfigDetail.class).eq(MesMachinePartQuotaConfigDetail::getMachinePartQuotaConfigId, param.getId()));
      if (CollUtil.isNotEmpty(param.getDetailList())) {
         List<MesMachinePartQuotaConfigDetail> detailList = param.getDetailList().stream().map(dp -> {
            MesMachinePartQuotaConfigDetail detail = BeanUtil.toBean(dp, MesMachinePartQuotaConfigDetail.class);
            detail.setMachinePartQuotaConfigId(quotaConfig.getId());
            return detail;
         }).collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatus(Long id, Boolean status) {
      MesMachinePartQuotaConfig oldQuotaConfig = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能操作");
      this.update(
         Wrappers.lambdaUpdate(MesMachinePartQuotaConfig.class).eq(MesMachinePartQuotaConfig::getId, id).set(MesMachinePartQuotaConfig::getStatus, status)
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesMachinePartQuotaConfig oldQuotaConfig = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldQuotaConfig), "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldQuotaConfig.getStatus(), "当前数据已禁用, 禁用数据不能删除");
      this.removeById(id);
      this.detailService
         .remove(Wrappers.lambdaQuery(MesMachinePartQuotaConfigDetail.class).eq(MesMachinePartQuotaConfigDetail::getMachinePartQuotaConfigId, id));
      return true;
   }

   @Override
   public List<NameInfo> machinePartProcessSelect() {
      Map<Integer, Map<Integer, Map<Integer, List<NameInfo>>>> machinePartProcessSelect = this.processService
         .list(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
               .eq(MesBuildingProcess::getBoolFixedProcess, Boolean.TRUE)
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               MesBuildingProcess::getProductCategoryType,
               Collectors.groupingBy(
                  MesBuildingProcess::getPartProdMode,
                  Collectors.groupingBy(
                     MesBuildingProcess::getType, Collectors.mapping(process -> BeanUtil.toBean(process, NameInfo.class), Collectors.toList())
                  )
               )
            )
         );
      return Stream.of(ProductCategoryTypeEnum.SHEET_PART, ProductCategoryTypeEnum.PROFILE_PART).map(productCategoryType -> {
         NameInfo productCategoryTypeInfo = new NameInfo();
         productCategoryTypeInfo.setId((long)productCategoryType.getType());
         productCategoryTypeInfo.setName(productCategoryType.getName());
         Map<Integer, Map<Integer, List<NameInfo>>> partProdModeMap = machinePartProcessSelect.getOrDefault(productCategoryType.getType(), new HashMap<>());
         List<NameInfo> partProdModeInfoList = Stream.of(PartProdModeEnum.values()).map(partProdMode -> {
            NameInfo partProdModeInfo = new NameInfo();
            partProdModeInfo.setId((long)partProdMode.getType());
            partProdModeInfo.setName(partProdMode.getName());
            Map<Integer, List<NameInfo>> typeMap = partProdModeMap.getOrDefault(partProdMode.getType(), new HashMap<>());
            List<NameInfo> typeInfoList = Stream.of(ProcessTypeEnum.MAKINGS, ProcessTypeEnum.DRILL_HOLE).map(type -> {
               NameInfo typeInfo = new NameInfo();
               typeInfo.setId((long)type.getType().intValue());
               typeInfo.setName(type.getName());
               List<NameInfo> currentProcessList = typeMap.getOrDefault(type.getType(), new ArrayList<>());
               typeInfo.setNameInfos(currentProcessList);
               return typeInfo;
            }).collect(Collectors.toList());
            partProdModeInfo.setNameInfos(typeInfoList);
            return partProdModeInfo;
         }).collect(Collectors.toList());
         productCategoryTypeInfo.setNameInfos(partProdModeInfoList);
         return productCategoryTypeInfo;
      }).collect(Collectors.toList());
   }
}
