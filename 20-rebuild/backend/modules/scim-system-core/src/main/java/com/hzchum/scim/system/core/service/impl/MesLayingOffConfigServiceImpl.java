package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesLayingOffConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesLayingOffConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesLayingOffConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesLayingOffConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesLayingOffConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesLayingOffConfigMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesLayingOffConfigServiceImpl extends ServiceImpl<MesLayingOffConfigMapper, MesLayingOffConfig> implements MesLayingOffConfigService {
   @Autowired
   private MesLayingOffConfigDetailService layingOffConfigDetailService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public PageVO<MesLayingOffConfigDTO> pageInfo(Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize) {
      Page<MesLayingOffConfig> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesLayingOffConfig> list = this.baseMapper
         .selectList(Wrappers.lambdaQuery(MesLayingOffConfig.class).eq(MesLayingOffConfig::getStatisticsConfigStatisticsMode, statisticsConfigStatisticsMode));
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesLayingOffConfig::getId).collect(Collectors.toList());
      List<MesLayingOffConfigDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesLayingOffConfigDTO> listInfo(Integer statisticsConfigStatisticsMode) {
      return this.baseMapper.listInfo(statisticsConfigStatisticsMode);
   }

   @Override
   public MesLayingOffConfigDTO detailById(Long id) {
      MesLayingOffConfigDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前下料配置不存在");
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveLayingOffConfig(MesLayingOffConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesLayingOffConfig layingOffConfig = BeanUtil.toBean(param, MesLayingOffConfig.class);
      layingOffConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.insert(layingOffConfig);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesLayingOffConfigSaveDTOParam param) {
      Preconditions.checkArgument(
         CollUtil.newArrayList(ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
            .contains(param.getMachinePartType()),
         "零件类型不存在"
      );
      Preconditions.checkArgument(WageConfigStatisticsModeEnum.existEliminateAssemble(param.getStatisticsMode()), "统计模式不存在");
      List<MesLayingOffConfig> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesLayingOffConfig.class)
               .ne(param.getId() != null, MesLayingOffConfig::getId, param.getId())
               .eq(MesLayingOffConfig::getMachinePartType, param.getMachinePartType())
               .eq(param.getSteelClassificationId() != null, MesLayingOffConfig::getSteelClassificationId, param.getSteelClassificationId())
         );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "零件类型,零件分类重复");
      if (!param.getBoolFixedPrice()) {
         Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
         List<Long> processIdList = this.productProcessLinkService
            .getProcessListByTypeIdAndProductType(param.getSteelClassificationId(), ProductTypeEnum.MACHINE_PART.getType())
            .stream()
            .map(MesBuildingProductProcessLinkDO::getProcessId)
            .distinct()
            .collect(Collectors.toList());
         Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
         List<Long> existingProcessIdList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesLayingOffConfig.class)
                  .ne(param.getId() != null, MesLayingOffConfig::getId, param.getId())
                  .eq(MesLayingOffConfig::getMachinePartType, param.getMachinePartType())
                  .eq(MesLayingOffConfig::getSteelClassificationId, param.getSteelClassificationId())
            )
            .stream()
            .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "存在重复工序");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveLayingOffConfig(List<MesLayingOffConfigSaveDTOParam> paramList) {
      paramList.forEach(this::saveLayingOffConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateLayingOffConfig(MesLayingOffConfigSaveDTOParam param) {
      MesLayingOffConfig layingOffConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(layingOffConfigOld != null, "当前下料配置不存在");
      this.verifyParameters(param);
      MesLayingOffConfig layingOffConfig = BeanUtil.toBean(param, MesLayingOffConfig.class);
      layingOffConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.updateById(layingOffConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper.selectCount(Wrappers.lambdaQuery(MesLayingOffConfig.class).in(MesLayingOffConfig::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的下料配置");
      this.baseMapper.deleteBatchIds(idList);
      return Boolean.TRUE;
   }
}
