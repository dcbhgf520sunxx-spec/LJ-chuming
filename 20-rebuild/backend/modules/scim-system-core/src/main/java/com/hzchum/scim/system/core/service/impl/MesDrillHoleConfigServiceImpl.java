package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesDrillHoleConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesDrillHoleConfigDetail;
import com.hzchum.scim.system.core.api.pojo.dto.MesDrillHoleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesDrillHoleConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesDrillHoleConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesDrillHoleConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesDrillHoleConfigMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesDrillHoleConfigServiceImpl extends ServiceImpl<MesDrillHoleConfigMapper, MesDrillHoleConfig> implements MesDrillHoleConfigService {
   @Autowired
   private MesDrillHoleConfigDetailService drillHoleConfigDetailService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;

   @Override
   public PageVO<MesDrillHoleConfigDTO> pageInfo(Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize) {
      Page<MesDrillHoleConfig> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesDrillHoleConfig> list = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesDrillHoleConfig.class).eq(MesDrillHoleConfig::getStatisticsConfigStatisticsMode, statisticsConfigStatisticsMode));
      List<Long> idList = list.stream().map(MesDrillHoleConfig::getId).collect(Collectors.toList());
      List<MesDrillHoleConfigDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      if (CollUtil.isNotEmpty(dtoList)) {
         List<MesDrillHoleConfigDetail> detailList = this.drillHoleConfigDetailService
            .list(
               Wrappers.lambdaQuery(MesDrillHoleConfigDetail.class)
                  .in(MesDrillHoleConfigDetail::getDrillHoleConfigId, CollUtil.getFieldValues(dtoList, "id", Long.class))
            );
         Map<Long, List<MesDrillHoleConfigDetail>> detailMap = detailList.stream()
            .collect(Collectors.groupingBy(MesDrillHoleConfigDetail::getDrillHoleConfigId));
         dtoList.forEach(e -> e.setDetailList(detailMap.getOrDefault(e.getId(), new ArrayList<>())));
      }

      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesDrillHoleConfigDTO> listInfo(Integer statisticsConfigStatisticsMode) {
      List<MesDrillHoleConfigDTO> dtoList = this.baseMapper.listInfo(statisticsConfigStatisticsMode);
      if (CollUtil.isEmpty(dtoList)) {
         return new ArrayList<>();
      }

      List<MesDrillHoleConfigDetail> detailList = this.drillHoleConfigDetailService
         .list(
            Wrappers.lambdaQuery(MesDrillHoleConfigDetail.class)
               .in(MesDrillHoleConfigDetail::getDrillHoleConfigId, CollUtil.getFieldValues(dtoList, "id", Long.class))
         );
      Map<Long, List<MesDrillHoleConfigDetail>> detailMap = detailList.stream().collect(Collectors.groupingBy(MesDrillHoleConfigDetail::getDrillHoleConfigId));
      dtoList.forEach(e -> e.setDetailList(detailMap.getOrDefault(e.getId(), new ArrayList<>())));
      return dtoList;
   }

   @Override
   public MesDrillHoleConfigDTO detailById(Long id) {
      MesDrillHoleConfigDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前钻孔配置不存在");
      List<MesDrillHoleConfigDetail> detailList = this.drillHoleConfigDetailService
         .list(Wrappers.lambdaQuery(MesDrillHoleConfigDetail.class).eq(MesDrillHoleConfigDetail::getDrillHoleConfigId, id));
      dto.setDetailList(detailList);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveDrillHoleConfig(MesDrillHoleConfigSaveDTOParam param) {
      List<Integer> productClassificationEnum = CollUtil.newArrayList(
         ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType()
      );
      Preconditions.checkArgument(productClassificationEnum.contains(param.getMachinePartType()), "零件类型不存在");
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      List<MesDrillHoleConfig> drillHoleConfigList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesDrillHoleConfig.class).eq(MesDrillHoleConfig::getSteelClassificationId, param.getSteelClassificationId()));
      if (CollUtil.isNotEmpty(drillHoleConfigList)) {
         MesDrillHoleConfig drillHoleConfig = drillHoleConfigList.get(0);
         Preconditions.checkArgument(param.getStatisticsMode().equals(drillHoleConfig.getStatisticsMode()), "统计模式不一致");
      }

      if (WageConfigStatisticsModeEnum.ARTIFACT.getType().equals(param.getStatisticsMode())
         && StatisticsConfigStatisticsModeEnum.REAL_TIME_COMPUTING_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())) {
         Preconditions.checkArgument(param.getOrganizationInsidePrice() != null && param.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空");
      }

      if (StatisticsConfigStatisticsModeEnum.REAL_TIME_COMPUTING_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())
         && WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode())) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getProcessIdList()), "生产工序不能为空");
         Integer processCount = this.buildingProcessService
            .count(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .in(MesBuildingProcess::getId, param.getProcessIdList())
            );
         Preconditions.checkArgument(processCount.equals(param.getProcessIdList().size()), "包含不存在的工序");
         if (param.getPricingManner() != null) {
            Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailList()), "计价详情不能为空");
            param.getDetailList()
               .forEach(e -> Preconditions.checkArgument(e.getOrganizationInsidePrice() != null && e.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空"));
         } else {
            Preconditions.checkArgument(param.getOrganizationInsidePrice() != null && param.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空");
         }
      }

      if (StatisticsConfigStatisticsModeEnum.STORAGE_RETRODICT_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())) {
         Preconditions.checkArgument(param.getFixedPrice() != null, "一口价不能为空");
      }

      Preconditions.checkArgument(
         CollUtil.newArrayList(WageQuotaTypeEnum.LENGTH_PRICE.getType(), WageQuotaTypeEnum.WEIGHT_PRICE.getType(), WageQuotaTypeEnum.QUANTITY_PRICE.getType())
            .contains(param.getMeasurementManner()),
         "计量方式不存在"
      );
      MesDrillHoleConfig drillHoleConfig = BeanUtil.toBean(param, MesDrillHoleConfig.class);
      drillHoleConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.insert(drillHoleConfig);
      if (WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode()) && param.getPricingManner() != null) {
         List<MesDrillHoleConfigDetail> detailList = BeanUtil.copyToList(param.getDetailList(), MesDrillHoleConfigDetail.class);
         detailList.forEach(e -> {
            if (e.getNumberOne() != null && e.getNumberTwo() != null) {
               Preconditions.checkArgument(e.getNumberOne() < e.getNumberTwo(), "前面数字不能大于等于后面数字");
            }

            e.setDrillHoleConfigId(drillHoleConfig.getId());
         });
         Boolean intersection = this.drillHoleConfigDetailService.isIntersection(detailList);
         Preconditions.checkArgument(!intersection, "计价范围存在交集");
         this.drillHoleConfigDetailService.saveBatch(detailList);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveDrillHoleConfig(List<MesDrillHoleConfigSaveDTOParam> paramList) {
      paramList.forEach(this::saveDrillHoleConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateDrillHoleConfig(MesDrillHoleConfigSaveDTOParam param) {
      MesDrillHoleConfig drillHoleConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(drillHoleConfigOld != null, "当前钻孔配置不存在");
      List<Integer> productClassificationEnum = CollUtil.newArrayList(
         ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType()
      );
      Preconditions.checkArgument(productClassificationEnum.contains(param.getMachinePartType()), "零件类型不存在");
      List<MesDrillHoleConfig> drillHoleConfigList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesDrillHoleConfig.class).eq(MesDrillHoleConfig::getSteelClassificationId, param.getSteelClassificationId()));
      if (CollUtil.isNotEmpty(drillHoleConfigList)) {
         MesDrillHoleConfig drillHoleConfig = drillHoleConfigList.get(0);
         Preconditions.checkArgument(param.getStatisticsMode().equals(drillHoleConfig.getStatisticsMode()), "统计模式不一致");
      }

      if (WageConfigStatisticsModeEnum.ARTIFACT.getType().equals(param.getStatisticsMode())
         && StatisticsConfigStatisticsModeEnum.REAL_TIME_COMPUTING_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())) {
         Preconditions.checkArgument(param.getOrganizationInsidePrice() != null && param.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空");
      }

      if (StatisticsConfigStatisticsModeEnum.REAL_TIME_COMPUTING_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())
         && WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode())) {
         Preconditions.checkArgument(CollUtil.isNotEmpty(param.getProcessIdList()), "生产工序不能为空");
         Integer processCount = this.buildingProcessService
            .count(
               Wrappers.lambdaQuery(MesBuildingProcess.class)
                  .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
                  .eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType())
                  .in(MesBuildingProcess::getId, param.getProcessIdList())
            );
         Preconditions.checkArgument(processCount.equals(param.getProcessIdList().size()), "包含不存在的工序");
         if (param.getPricingManner() != null) {
            Preconditions.checkArgument(CollUtil.isNotEmpty(param.getDetailList()), "计价详情不能为空");
            param.getDetailList()
               .forEach(e -> Preconditions.checkArgument(e.getOrganizationInsidePrice() != null && e.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空"));
         } else {
            Preconditions.checkArgument(param.getOrganizationInsidePrice() != null && param.getOrganizationOutsidePrice() != null, "编制内/外单价不能为空");
         }
      }

      if (StatisticsConfigStatisticsModeEnum.STORAGE_RETRODICT_MODE.getType().equals(param.getStatisticsConfigStatisticsMode())) {
         Preconditions.checkArgument(param.getFixedPrice() != null, "一口价不能为空");
      }

      Preconditions.checkArgument(
         CollUtil.newArrayList(WageQuotaTypeEnum.LENGTH_PRICE.getType(), WageQuotaTypeEnum.WEIGHT_PRICE.getType(), WageQuotaTypeEnum.QUANTITY_PRICE.getType())
            .contains(param.getMeasurementManner()),
         "计量方式不存在"
      );
      MesDrillHoleConfig drillHoleConfig = BeanUtil.toBean(param, MesDrillHoleConfig.class);
      drillHoleConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.updateById(drillHoleConfig);
      if (WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode()) && param.getPricingManner() != null) {
         List<MesDrillHoleConfigDetail> detailList = BeanUtil.copyToList(param.getDetailList(), MesDrillHoleConfigDetail.class);
         detailList.forEach(e -> {
            if (e.getNumberOne() != null && e.getNumberTwo() != null) {
               Preconditions.checkArgument(e.getNumberOne() < e.getNumberTwo(), "前面数字不能大于等于后面数字");
            }

            e.setDrillHoleConfigId(drillHoleConfig.getId());
         });
         Boolean intersection = this.drillHoleConfigDetailService.isIntersection(detailList);
         Preconditions.checkArgument(!intersection, "计价范围存在交集");
         this.drillHoleConfigDetailService
            .remove(Wrappers.lambdaQuery(MesDrillHoleConfigDetail.class).in(MesDrillHoleConfigDetail::getDrillHoleConfigId, param.getId()));
         this.drillHoleConfigDetailService.saveBatch(detailList);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper.selectCount(Wrappers.lambdaQuery(MesDrillHoleConfig.class).in(MesDrillHoleConfig::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的钻孔配置");
      this.baseMapper.deleteBatchIds(idList);
      this.drillHoleConfigDetailService.remove(Wrappers.lambdaQuery(MesDrillHoleConfigDetail.class).in(MesDrillHoleConfigDetail::getDrillHoleConfigId, idList));
      return Boolean.TRUE;
   }
}
