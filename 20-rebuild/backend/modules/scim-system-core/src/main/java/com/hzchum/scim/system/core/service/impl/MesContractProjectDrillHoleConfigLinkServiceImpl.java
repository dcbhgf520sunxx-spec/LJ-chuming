package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectDrillHoleConfigLinkDetail;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectDrillHoleConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesDrillHoleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectDrillHoleConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectDrillHoleConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectDrillHoleConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesDrillHoleConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectDrillHoleConfigLinkMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectDrillHoleConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectDrillHoleConfigLinkMapper, MesContractProjectDrillHoleConfigLink>
   implements MesContractProjectDrillHoleConfigLinkService {
   @Autowired
   private MesContractProjectDrillHoleConfigLinkDetailService detailService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesDrillHoleConfigService drillHoleConfigService;

   @Override
   public PageVO<MesContractProjectDrillHoleConfigLinkDTO> pageInfo(
      Long projectId, Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<MesContractProjectDrillHoleConfigLink> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesContractProjectDrillHoleConfigLink> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class)
               .eq(MesContractProjectDrillHoleConfigLink::getContractProjectId, projectId)
               .eq(MesContractProjectDrillHoleConfigLink::getStatisticsConfigStatisticsMode, statisticsConfigStatisticsMode)
         );
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesContractProjectDrillHoleConfigLink::getId).collect(Collectors.toList());
      List<MesContractProjectDrillHoleConfigLinkDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      if (CollUtil.isNotEmpty(dtoList)) {
         List<MesContractProjectDrillHoleConfigLinkDetail> detailList = this.detailService
            .list(
               Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
                  .in(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, CollUtil.getFieldValues(dtoList, "id", Long.class))
            );
         Map<Long, List<MesContractProjectDrillHoleConfigLinkDetail>> detailMap = detailList.stream()
            .collect(Collectors.groupingBy(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId));
         dtoList.forEach(e -> e.setDetailList(detailMap.getOrDefault(e.getId(), new ArrayList<>())));
      }

      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesContractProjectDrillHoleConfigLinkDTO> listInfo(Long projectId, Integer statisticsConfigStatisticsMode) {
      List<MesContractProjectDrillHoleConfigLinkDTO> dtoList = this.baseMapper.listInfo(projectId, statisticsConfigStatisticsMode);
      if (CollUtil.isEmpty(dtoList)) {
         return new ArrayList<>();
      }

      List<MesContractProjectDrillHoleConfigLinkDetail> detailList = this.detailService
         .list(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
               .in(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, CollUtil.getFieldValues(dtoList, "id", Long.class))
         );
      Map<Long, List<MesContractProjectDrillHoleConfigLinkDetail>> detailMap = detailList.stream()
         .collect(Collectors.groupingBy(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId));
      dtoList.forEach(e -> e.setDetailList(detailMap.getOrDefault(e.getId(), new ArrayList<>())));
      return dtoList;
   }

   @Override
   public MesContractProjectDrillHoleConfigLinkDTO detailById(Long id) {
      MesContractProjectDrillHoleConfigLinkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前钻孔配置不存在");
      List<MesContractProjectDrillHoleConfigLinkDetail> detailList = this.detailService
         .list(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
               .eq(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, id)
         );
      dto.setDetailList(detailList);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectDrillHoleConfigLinkSaveDTOParam param) {
      List<Integer> productClassificationEnum = CollUtil.newArrayList(
         ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType()
      );
      Preconditions.checkArgument(productClassificationEnum.contains(param.getMachinePartType()), "零件类型不存在");
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      List<MesContractProjectDrillHoleConfigLink> List = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class)
               .eq(MesContractProjectDrillHoleConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectDrillHoleConfigLink::getSteelClassificationId, param.getSteelClassificationId())
         );
      if (CollUtil.isNotEmpty(List)) {
         MesContractProjectDrillHoleConfigLink drillHoleConfig = List.get(0);
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
      MesContractProjectDrillHoleConfigLink config = BeanUtil.toBean(param, MesContractProjectDrillHoleConfigLink.class);
      config.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.insert(config);
      if (WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode()) && param.getPricingManner() != null) {
         List<MesContractProjectDrillHoleConfigLinkDetail> detailList = BeanUtil.copyToList(
            param.getDetailList(), MesContractProjectDrillHoleConfigLinkDetail.class
         );
         detailList.forEach(e -> {
            if (e.getNumberOne() != null && e.getNumberTwo() != null) {
               Preconditions.checkArgument(e.getNumberOne() < e.getNumberTwo(), "前面数字不能大于等于后面数字");
            }

            e.setContractProjectDrillHoleConfigLinkId(config.getId());
         });
         Boolean intersection = this.detailService.isIntersection(detailList);
         Preconditions.checkArgument(!intersection, "计价范围存在交集");
         this.detailService.saveBatch(detailList);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveConfig(List<MesContractProjectDrillHoleConfigLinkSaveDTOParam> paramList) {
      paramList.forEach(this::saveConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConfig(MesContractProjectDrillHoleConfigLinkSaveDTOParam param) {
      MesContractProjectDrillHoleConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前钻孔配置不存在");
      List<Integer> productClassificationEnum = CollUtil.newArrayList(
         ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType()
      );
      Preconditions.checkArgument(productClassificationEnum.contains(param.getMachinePartType()), "零件类型不存在");
      List<MesContractProjectDrillHoleConfigLink> List = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class)
               .eq(MesContractProjectDrillHoleConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectDrillHoleConfigLink::getSteelClassificationId, param.getSteelClassificationId())
         );
      if (CollUtil.isNotEmpty(List)) {
         MesContractProjectDrillHoleConfigLink drillHoleConfig = List.get(0);
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
      MesContractProjectDrillHoleConfigLink newConfig = BeanUtil.toBean(param, MesContractProjectDrillHoleConfigLink.class);
      newConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.updateById(newConfig);
      if (WageConfigStatisticsModeEnum.MACHINE_PART.getType().equals(param.getStatisticsMode()) && param.getPricingManner() != null) {
         List<MesContractProjectDrillHoleConfigLinkDetail> detailList = BeanUtil.copyToList(
            param.getDetailList(), MesContractProjectDrillHoleConfigLinkDetail.class
         );
         detailList.forEach(e -> {
            if (e.getNumberOne() != null && e.getNumberTwo() != null) {
               Preconditions.checkArgument(e.getNumberOne() < e.getNumberTwo(), "前面数字不能大于等于后面数字");
            }

            e.setContractProjectDrillHoleConfigLinkId(newConfig.getId());
         });
         Boolean intersection = this.detailService.isIntersection(detailList);
         Preconditions.checkArgument(!intersection, "计价范围存在交集");
         this.detailService
            .remove(
               Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
                  .in(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, param.getId())
            );
         this.detailService.saveBatch(detailList);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper
         .selectCount(Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLink.class).in(MesContractProjectDrillHoleConfigLink::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的钻孔配置");
      this.baseMapper.deleteBatchIds(idList);
      this.detailService
         .remove(
            Wrappers.lambdaQuery(MesContractProjectDrillHoleConfigLinkDetail.class)
               .in(MesContractProjectDrillHoleConfigLinkDetail::getContractProjectDrillHoleConfigLinkId, idList)
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectDrillHoleConfigLink(Long contractProjectId, Integer contractProjectStatisticsMode) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesDrillHoleConfigDTO> drillHoleConfigDTOList = this.drillHoleConfigService.listInfo(contractProjectStatisticsMode);
      if (CollUtil.isEmpty(drillHoleConfigDTOList)) {
         return Boolean.TRUE;
      }

      List<MesContractProjectDrillHoleConfigLinkDetail> drillHoleConfigLinkDetailList = new ArrayList<>();
      drillHoleConfigDTOList.forEach(
         loc -> {
            MesContractProjectDrillHoleConfigLink drillHoleConfigLink = BeanUtil.toBean(loc, MesContractProjectDrillHoleConfigLink.class);
            drillHoleConfigLink.setContractProjectId(contractProjectId);
            this.baseMapper.insert(drillHoleConfigLink);
            List<MesContractProjectDrillHoleConfigLinkDetail> drillHoleConfigLinkDetails = BeanUtil.copyToList(
               loc.getDetailList(), MesContractProjectDrillHoleConfigLinkDetail.class
            );
            drillHoleConfigLinkDetails.forEach(dhcld -> dhcld.setContractProjectDrillHoleConfigLinkId(drillHoleConfigLink.getId()));
            drillHoleConfigLinkDetailList.addAll(drillHoleConfigLinkDetails);
         }
      );
      if (CollUtil.isNotEmpty(drillHoleConfigLinkDetailList)) {
         this.detailService.saveBatch(drillHoleConfigLinkDetailList, drillHoleConfigLinkDetailList.size());
      }

      return Boolean.TRUE;
   }
}
