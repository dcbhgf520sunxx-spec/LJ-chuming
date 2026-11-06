package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestTeamConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestTeamConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestTeamConfigService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestTeamConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestTeamConfigServiceImpl
   extends ServiceImpl<MesBuildingNestTeamConfigMapper, MesBuildingNestTeamConfig>
   implements MesBuildingNestTeamConfigService {
   @Override
   public PageVO<MesBuildingNestTeamConfigDTO> pageNestTeamConfig(Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingNestTeamConfigDTO> mesBuildingNestTeamConfigDTOList = this.baseMapper.selectNestTeamConfigList();
      return new PageVO<>(mesBuildingNestTeamConfigDTOList);
   }

   @Override
   public List<MesBuildingNestTeamConfigDTO> selectNeedNestTeamConfig(Long teamId) {
      return this.baseMapper.selectNeedNestTeamConfig(teamId);
   }

   @Override
   public int addNestTeamConfig(MesBuildingNestTeamConfig mesBuildingNestTeamConfig) {
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigListOne = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestTeamConfig>)new LambdaQueryWrapper<MesBuildingNestTeamConfig>().eq(MesBuildingNestTeamConfig::getTeamId, mesBuildingNestTeamConfig.getTeamId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingNestTeamConfigListOne), "该班组已经添加过代号!");
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigListTwo = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestTeamConfig>)new LambdaQueryWrapper<MesBuildingNestTeamConfig>().eq(MesBuildingNestTeamConfig::getCodeName, mesBuildingNestTeamConfig.getCodeName())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingNestTeamConfigListTwo), "该代号已经被使用!");
      return this.baseMapper.insert(mesBuildingNestTeamConfig);
   }

   @Override
   public int updateNestTeamConfig(MesBuildingNestTeamConfig mesBuildingNestTeamConfig) {
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigListOne = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestTeamConfig>)(new LambdaQueryWrapper<MesBuildingNestTeamConfig>()
                  .eq(MesBuildingNestTeamConfig::getTeamId, mesBuildingNestTeamConfig.getTeamId()))
               .ne(MesBuildingNestTeamConfig::getId, mesBuildingNestTeamConfig.getId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingNestTeamConfigListOne), "该班组已经添加过代号!");
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigListTwo = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestTeamConfig>)(new LambdaQueryWrapper<MesBuildingNestTeamConfig>()
                  .eq(MesBuildingNestTeamConfig::getCodeName, mesBuildingNestTeamConfig.getCodeName()))
               .ne(MesBuildingNestTeamConfig::getId, mesBuildingNestTeamConfig.getId())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingNestTeamConfigListTwo), "该代号已经被使用!");
      return this.baseMapper.updateById(mesBuildingNestTeamConfig);
   }

   @Override
   public boolean updateNestTeamConfigALL(Boolean codeRule, Boolean displayRule, Boolean teamDisplayRule) {
      List<MesBuildingNestTeamConfig> mesBuildingNestTeamConfigList = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      mesBuildingNestTeamConfigList.forEach(mesBuildingNestTeamConfig -> {
         mesBuildingNestTeamConfig.setCodeRule(codeRule);
         mesBuildingNestTeamConfig.setDisplayRule(displayRule);
         mesBuildingNestTeamConfig.setTeamDisplayRule(teamDisplayRule);
         this.baseMapper.updateById(mesBuildingNestTeamConfig);
      });
      return true;
   }
}
