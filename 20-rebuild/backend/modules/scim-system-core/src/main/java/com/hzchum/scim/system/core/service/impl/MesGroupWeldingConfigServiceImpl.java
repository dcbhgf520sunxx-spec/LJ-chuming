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
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesGroupWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesGroupWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesGroupWeldingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesGroupWeldingConfigMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesGroupWeldingConfigServiceImpl extends ServiceImpl<MesGroupWeldingConfigMapper, MesGroupWeldingConfig> implements MesGroupWeldingConfigService {
   @Autowired
   private MesGroupWeldingConfigDetailService groupWeldingConfigDetailService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public List<MesGroupWeldingConfigDTO> listInfo() {
      return this.baseMapper.listInfo();
   }

   @Override
   public PageVO<MesGroupWeldingConfigDTO> pageInfo(Integer pageNumber, Integer pageSize) {
      Page<MesGroupWeldingConfig> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesGroupWeldingConfig> list = this.baseMapper.selectList(Wrappers.emptyWrapper());
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesGroupWeldingConfig::getId).collect(Collectors.toList());
      List<MesGroupWeldingConfigDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public MesGroupWeldingConfigDTO detailById(Long id) {
      MesGroupWeldingConfigDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前组焊配置不存在");
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMesGroupWeldingConfig(MesGroupWeldingConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesGroupWeldingConfig groupWeldingConfig = BeanUtil.toBean(param, MesGroupWeldingConfig.class);
      groupWeldingConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      this.baseMapper.insert(groupWeldingConfig);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesGroupWeldingConfigSaveDTOParam param) {
      Preconditions.checkArgument(WageConfigStatisticsModeEnum.existEliminateMachinePart(param.getStatisticsMode()), "统计模式不存在");
      List<Long> processIdList = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(param.getAssembleConfigId(), ProductTypeEnum.ASSEMBLE.getType())
         .stream()
         .map(MesBuildingProductProcessLinkDO::getProcessId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
      Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
      List<Long> existingProcessIdList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesGroupWeldingConfig.class)
               .ne(param.getId() != null, MesGroupWeldingConfig::getId, param.getId())
               .eq(MesGroupWeldingConfig::getAssembleConfigId, param.getAssembleConfigId())
         )
         .stream()
         .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "存在重复工序");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveMesGroupWeldingConfig(List<MesGroupWeldingConfigSaveDTOParam> paramList) {
      paramList.forEach(this::saveMesGroupWeldingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateMesGroupWeldingConfig(MesGroupWeldingConfigSaveDTOParam param) {
      MesGroupWeldingConfig groupWeldingConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(groupWeldingConfigOld != null, "当前组焊配置不存在");
      this.verifyParameters(param);
      MesGroupWeldingConfig groupWeldingConfig = BeanUtil.toBean(param, MesGroupWeldingConfig.class);
      groupWeldingConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      this.baseMapper.updateById(groupWeldingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper.selectCount(Wrappers.lambdaQuery(MesGroupWeldingConfig.class).in(MesGroupWeldingConfig::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的组焊配置");
      this.baseMapper.deleteBatchIds(idList);
      return Boolean.TRUE;
   }
}
