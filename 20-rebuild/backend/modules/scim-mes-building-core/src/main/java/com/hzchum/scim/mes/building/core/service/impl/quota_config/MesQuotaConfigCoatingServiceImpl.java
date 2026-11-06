package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigCoating;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCoatingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigCoatingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigCoatingService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigCoatingMapper;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigCoatingServiceImpl extends ServiceImpl<MesQuotaConfigCoatingMapper, MesQuotaConfigCoating> implements MesQuotaConfigCoatingService {
   @Autowired
   private Validator validator;
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private SysStructureClassificationService artifactClassService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public List<MesQuotaConfigCoatingDTO> listInfo(MesQuotaConfigConditionQuery query) {
      List<MesQuotaConfigCoatingDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> branchCompanyId = list.stream()
            .map(MesQuotaConfigCoatingDTO::getBranchCompanyIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> branchCompanyList = Optional.ofNullable(branchCompanyId)
            .filter(CollUtil::isNotEmpty)
            .map(this.branchCompanyService::listByIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(i -> ShowInfo.builder().id(i.getId()).name(i.getName()).shortName(i.getShortName()).build())
            .collect(Collectors.toList());
         List<Long> workshopIdList = list.stream()
            .map(MesQuotaConfigCoatingDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> workshopList = Optional.ofNullable(workshopIdList)
            .filter(CollUtil::isNotEmpty)
            .map(this.workshopService::listByIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(i -> ShowInfo.builder().id(i.getId()).name(i.getName()).shortName(i.getShortName()).build())
            .collect(Collectors.toList());
         List<Long> artifactClassIdList = list.stream()
            .map(MesQuotaConfigCoatingDTO::getArtifactClassIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> artifactClassList = Optional.ofNullable(artifactClassIdList)
            .filter(CollUtil::isNotEmpty)
            .map(this.artifactClassService::listByIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(i -> ShowInfo.builder().id(i.getId()).name(i.getClassificationName()).build())
            .collect(Collectors.toList());
         list.forEach(
            i -> {
               if (CollUtil.isNotEmpty(i.getBranchCompanyIdList())) {
                  List<ShowInfo> nowBranchCompanyList = branchCompanyList.stream()
                     .filter(bc -> i.getBranchCompanyIdList().contains(bc.getId()))
                     .collect(Collectors.toList());
                  i.setBranchCompanyList(nowBranchCompanyList);
               }

               if (CollUtil.isNotEmpty(i.getWorkshopIdList())) {
                  List<ShowInfo> nowWorkshopList = workshopList.stream().filter(w -> i.getWorkshopIdList().contains(w.getId())).collect(Collectors.toList());
                  i.setWorkshopList(nowWorkshopList);
               }

               if (CollUtil.isNotEmpty(i.getArtifactClassIdList())) {
                  List<ShowInfo> nowArtifactClassList = artifactClassList.stream()
                     .filter(ac -> i.getArtifactClassIdList().contains(ac.getId()))
                     .collect(Collectors.toList());
                  i.setArtifactClassList(nowArtifactClassList);
               }
            }
         );
      }

      return list;
   }

   private void verifyParam(MesQuotaConfigCoatingParam param, Class<?>... var2) {
      Set<ConstraintViolation<MesQuotaConfigCoatingParam>> validate = this.validator.validate(param, var2);
      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<BranchCompany> branchCompanyList = this.branchCompanyService.listByIds(param.getBranchCompanyIdList());
      Preconditions.checkArgument(branchCompanyList.size() == param.getBranchCompanyIdList().size(), "包含不存在的机构, 请刷新后重试");
      List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(param.getWorkshopIdList());
      Preconditions.checkArgument(workshopList.size() == param.getWorkshopIdList().size(), "包含不存在的车间, 请刷新后重试");
      List<SysStructureClassification> artifactClassList = this.artifactClassService.listByIds(param.getArtifactClassIdList());
      Preconditions.checkArgument(artifactClassList.size() == param.getArtifactClassIdList().size(), "包含不存在的构件类型, 请刷新后重试");
      MesBuildingProcess process = this.processService.getById(param.getProcessId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(process), "工序不存在, 请刷新后重试");
      Preconditions.checkArgument(Objects.equals(process.getType(), ProcessTypeEnum.PAINT.getType()), "请选择油漆类工序");
      Preconditions.checkArgument(StrUtil.isNotBlank(process.getCodename()), "所选工序没有代号, 请先配置工序代号");
      param.setProcessCodename(process.getCodename());
      LambdaQueryWrapper<MesQuotaConfigCoating> qw = new LambdaQueryWrapper<>();
      qw.ne(param.getId() != null, MesQuotaConfigCoating::getId, param.getId());
      qw.eq(MesQuotaConfigCoating::getProcessId, param.getProcessId());
      qw.and(q -> param.getBranchCompanyIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, branch_company_ids) > 0", i)));
      qw.and(q -> param.getWorkshopIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, workshop_ids) > 0", i)));
      qw.and(q -> param.getArtifactClassIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, artifact_class_ids) > 0", i)));
      List<MesQuotaConfigCoating> list = this.list(qw);
      Preconditions.checkArgument(CollUtil.isEmpty(list), "机构+车间+构件类型+工序重复");
   }

   private String getSerialNumber(String processCodename) {
      String prefix = "T" + processCodename;
      int num = this.baseMapper.getMaxSerialNumber(prefix);
      return prefix + String.format("%02d", num + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigCoatingParam param) {
      this.verifyParam(param, Add.class);
      MesQuotaConfigCoating entity = BeanUtil.toBean(param, MesQuotaConfigCoating.class);
      String branchCompanyIds = CollUtil.join(param.getBranchCompanyIdList(), ",");
      entity.setBranchCompanyIds(StrUtil.blankToDefault(branchCompanyIds, null));
      String workshopIds = CollUtil.join(param.getWorkshopIdList(), ",");
      entity.setWorkshopIds(StrUtil.blankToDefault(workshopIds, null));
      String artifactClassIds = CollUtil.join(param.getArtifactClassIdList(), ",");
      entity.setArtifactClassIds(StrUtil.blankToDefault(artifactClassIds, null));
      entity.setSerialNumber(this.getSerialNumber(param.getProcessCodename()));
      this.save(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigCoatingParam param) {
      this.verifyParam(param, Update.class);
      MesQuotaConfigCoating oldEntity = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      MesQuotaConfigCoating entity = BeanUtil.toBean(param, MesQuotaConfigCoating.class);
      String branchCompanyIds = CollUtil.join(param.getBranchCompanyIdList(), ",");
      entity.setBranchCompanyIds(StrUtil.blankToDefault(branchCompanyIds, null));
      String workshopIds = CollUtil.join(param.getWorkshopIdList(), ",");
      entity.setWorkshopIds(StrUtil.blankToDefault(workshopIds, null));
      String artifactClassIds = CollUtil.join(param.getArtifactClassIdList(), ",");
      entity.setArtifactClassIds(StrUtil.blankToDefault(artifactClassIds, null));
      this.updateById(entity);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesQuotaConfigCoating oldEntity = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }
}
