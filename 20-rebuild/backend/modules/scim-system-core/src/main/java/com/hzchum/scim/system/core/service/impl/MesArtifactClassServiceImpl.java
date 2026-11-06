package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.pojo._do.MesArtifactClass;
import com.hzchum.scim.system.core.api.pojo._do.MesProcessConversionRate;
import com.hzchum.scim.system.core.api.pojo.request.MesArtifactClassDTO;
import com.hzchum.scim.system.core.api.service.MesArtifactClassService;
import com.hzchum.scim.system.core.api.service.MesProcessConversionRateService;
import com.hzchum.scim.system.core.mapper.MesArtifactClassMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesArtifactClassServiceImpl extends ServiceImpl<MesArtifactClassMapper, MesArtifactClass> implements MesArtifactClassService {
   @Resource
   private MesProcessConversionRateService processConversionRateService;
   @Resource
   private TechArtifactService techArtifactService;

   @Override
   public Boolean saveMesArtifactClass(MesArtifactClassDTO mesArtifactClassDTO) {
      List<MesArtifactClass> mesArtifactClassList = mesArtifactClassDTO.getMesArtifactClassList();
      List<String> nameList = mesArtifactClassList.stream().map(MesArtifactClass::getName).collect(Collectors.toList());
      List<MesArtifactClass> mesArtifactClassHaveList = this.list((Wrapper<MesArtifactClass>)new LambdaQueryWrapper<MesArtifactClass>().in(MesArtifactClass::getName, nameList));
      Preconditions.checkArgument(mesArtifactClassHaveList.isEmpty(), "构件类别名称重复");
      return this.saveBatch(mesArtifactClassList);
   }

   @Override
   public Boolean updateMesArtifactClass(MesArtifactClass mesArtifactClass) {
      mesArtifactClass.getName();
      List<MesArtifactClass> mesArtifactClasses = this.getBaseMapper()
         .selectList(
            (Wrapper<MesArtifactClass>)(new LambdaQueryWrapper<MesArtifactClass>().eq(MesArtifactClass::getName, mesArtifactClass.getName()))
               .ne(MesArtifactClass::getId, mesArtifactClass.getId())
         );
      Preconditions.checkArgument(mesArtifactClasses.isEmpty(), "构件类别名称重复");
      return this.updateById(mesArtifactClass);
   }

   @Override
   public Boolean deleteMesArtifactClassByIds(List<Long> idList) {
      List<String> nameList = this.list((Wrapper<MesArtifactClass>)new LambdaQueryWrapper<MesArtifactClass>().in(MesArtifactClass::getId, idList))
         .stream()
         .map(MesArtifactClass::getName)
         .collect(Collectors.toList());
      List<TechArtifact> techArtifactList = this.techArtifactService
         .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getStructureType, nameList));
      Preconditions.checkArgument(techArtifactList.isEmpty(), "构件类别已被使用，不能删除");
      List<MesProcessConversionRate> processConversionRates = this.processConversionRateService
         .list((Wrapper<MesProcessConversionRate>)new LambdaQueryWrapper<MesProcessConversionRate>().in(MesProcessConversionRate::getArtifactClassId, idList));
      Preconditions.checkArgument(CollectionUtils.isEmpty(processConversionRates), "构件类别已配置工序折合完工率,不可删除!");
      return this.removeByIds(idList);
   }

   public MesArtifactClassServiceImpl(final MesProcessConversionRateService processConversionRateService, final TechArtifactService techArtifactService) {
      this.processConversionRateService = processConversionRateService;
      this.techArtifactService = techArtifactService;
   }
}
