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
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.system.core.api.pojo._do.MesAssemblingWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesAssemblingWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesAssemblingWeldingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationDetailService;
import com.hzchum.scim.system.core.api.service.MesAssemblingWeldingConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesAssemblingWeldingConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesAssemblingWeldingConfigMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesAssemblingWeldingConfigServiceImpl
   extends ServiceImpl<MesAssemblingWeldingConfigMapper, MesAssemblingWeldingConfig>
   implements MesAssemblingWeldingConfigService {
   @Autowired
   private MesAssemblingWeldingConfigDetailService assemblingWeldingConfigDetailService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesArtifactClassificationDetailService artifactClassificationDetailService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public List<MesAssemblingWeldingConfigDTO> listInfo() {
      return this.baseMapper.listInfo();
   }

   @Override
   public PageVO<MesAssemblingWeldingConfigDTO> pageInfo(Integer pageNumber, Integer pageSize) {
      Page<MesAssemblingWeldingConfig> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesAssemblingWeldingConfig> list = this.baseMapper.selectList(Wrappers.emptyWrapper());
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesAssemblingWeldingConfig::getId).collect(Collectors.toList());
      List<MesAssemblingWeldingConfigDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public MesAssemblingWeldingConfigDTO detailById(Long id) {
      MesAssemblingWeldingConfigDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前装焊配置不存在");
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveAssemblingWeldingConfig(MesAssemblingWeldingConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesAssemblingWeldingConfig assemblingWeldingConfig = BeanUtil.toBean(param, MesAssemblingWeldingConfig.class);
      assemblingWeldingConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      assemblingWeldingConfig.setArtifact(StrUtil.join(",", param.getArtifactNameList()));
      this.baseMapper.insert(assemblingWeldingConfig);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesAssemblingWeldingConfigSaveDTOParam param) {
      List<Long> processIdList = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(param.getArtifactTypeId(), ProductTypeEnum.ARTIFACT.getType())
         .stream()
         .map(MesBuildingProductProcessLinkDO::getProcessId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
      Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
      List<MesAssemblingWeldingConfig> configList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesAssemblingWeldingConfig.class)
               .ne(param.getId() != null, MesAssemblingWeldingConfig::getId, param.getId())
               .eq(MesAssemblingWeldingConfig::getArtifactTypeId, param.getArtifactTypeId())
         );
      List<Long> existingProcessIdList = configList.stream()
         .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<String> existingArtifactNameList = configList.stream()
         .map(config -> StrUtil.split(config.getArtifact(), ","))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(param.getArtifactNameList())) {
         Preconditions.checkArgument(
            param.getArtifactNameList().stream().noneMatch(existingArtifactNameList::contains)
               || param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains),
            "构件名称或工序配置错误"
         );
      } else {
         Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "工序配置错误");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveAssemblingWeldingConfig(List<MesAssemblingWeldingConfigSaveDTOParam> params) {
      params.forEach(this::saveAssemblingWeldingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAssemblingWeldingConfig(MesAssemblingWeldingConfigSaveDTOParam param) {
      MesAssemblingWeldingConfig assemblingWeldingConfigOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(assemblingWeldingConfigOld != null, "当前装焊配置不存在");
      this.verifyParameters(param);
      MesAssemblingWeldingConfig assemblingWeldingConfig = BeanUtil.toBean(param, MesAssemblingWeldingConfig.class);
      assemblingWeldingConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      assemblingWeldingConfig.setArtifact(StrUtil.join(",", param.getArtifactNameList()));
      this.baseMapper.updateById(assemblingWeldingConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesAssemblingWeldingConfig assemblingWeldingConfigOld = this.baseMapper.selectById(id);
      Preconditions.checkArgument(assemblingWeldingConfigOld != null, "当前装焊配置不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
