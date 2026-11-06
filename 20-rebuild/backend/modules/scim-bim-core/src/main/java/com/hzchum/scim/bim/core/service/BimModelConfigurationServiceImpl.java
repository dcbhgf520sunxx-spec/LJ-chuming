package com.hzchum.scim.bim.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.dto.BimModelConfigurationDTO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelConfigurationVO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.bim.core.mapper.BimModelConfigurationMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MonomerUserLink;
import com.hzchum.scim.system.core.api.service.MonomerUserLinkService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BimModelConfigurationServiceImpl extends ServiceImpl<BimModelConfigurationMapper, BimModelConfigurationDO> implements BimModelConfigurationService {
   private static final Logger log = LoggerFactory.getLogger(BimModelConfigurationServiceImpl.class);
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private BimModelCommonService bimModelCommonService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private MonomerUserLinkService monomerUserLinkService;

   @Override
   public BimModelConfigurationVO getModelConfigure(Long monomerId) {
      PlanMonomer monomer = this.planMonomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "选择的单体不存在");
      BimModelConfigurationDO bimModelConfigurationDO = this.baseMapper
         .selectOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      return bimModelConfigurationDO == null ? null : BeanUtil.copy(bimModelConfigurationDO, BimModelConfigurationVO.class);
   }

   @Override
   public Boolean setModelConfigure(BimModelConfigurationDTO configurationDTO) {
      PlanMonomer monomer = this.planMonomerService.getById(configurationDTO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "选择的单体不存在");
      if (configurationDTO.getMonomerId() != null && !UserUtil.getCurrentUser().isAdmin()) {
         List<MonomerUserLink> monomerUserLinkList = this.monomerUserLinkService
            .list(Wrappers.lambdaQuery(MonomerUserLink.class).eq(MonomerUserLink::getMonomerId, configurationDTO.getMonomerId()));
         Preconditions.checkArgument(
            CollectionUtils.isNotEmpty(monomerUserLinkList)
               && monomerUserLinkList.stream().map(MonomerUserLink::getDeepenedPersonId).collect(Collectors.toList()).contains(UserUtil.getCurrentUserId()),
            "您不是该单体深化负责人,不允许导入模型配置!"
         );
      }

      BimModelConfigurationDO bimModelConfigurationDO = this.baseMapper
         .selectOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, configurationDTO.getMonomerId()));
      if (bimModelConfigurationDO == null) {
         BimModelConfigurationDO build = BimModelConfigurationDO.builder()
            .projectId(monomer.getProjectId())
            .monomerId(configurationDTO.getMonomerId())
            .edition(configurationDTO.getEdition())
            .importMode(configurationDTO.getImportMode())
            .build();
         this.baseMapper.insert(build);
      }

      Boolean flag = false;
      if (bimModelConfigurationDO != null) {
         if (!bimModelConfigurationDO.getImportMode().equals(configurationDTO.getImportMode())) {
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomer.getId()))
                     .eq(BimModelCommonDO::getImportMode, bimModelConfigurationDO.getImportMode())
               );
            Preconditions.checkArgument(org.apache.commons.collections4.CollectionUtils.isEmpty(bimModelCommonDOS), "当前导入模式下存在对应的模型!!!");
            bimModelConfigurationDO.setImportMode(configurationDTO.getImportMode());
            flag = true;
         }

         if (!bimModelConfigurationDO.getEdition().equals(configurationDTO.getEdition())) {
            bimModelConfigurationDO.setEdition(configurationDTO.getEdition());
            flag = true;
         }

         if (flag) {
            this.redisUtils.expire("MONOMER_MODEL:" + configurationDTO.getMonomerId(), 1L);
            List<PlanArea> areaList = this.planAreaService
               .list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, configurationDTO.getMonomerId()));
            areaList.forEach(area -> this.redisUtils.expire("AREA_MODEL:" + area.getId(), 1L));
            this.baseMapper.updateById(bimModelConfigurationDO);
         }
      }

      return true;
   }
}
