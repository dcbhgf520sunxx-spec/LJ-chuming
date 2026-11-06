package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.enums.quota_config.QuotaConfigMachinePartConditionEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePartCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCondition;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartConditionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigMachinePartParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartConditionService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartService;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigMachinePartMapper;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
public class MesQuotaConfigMachinePartServiceImpl
   extends ServiceImpl<MesQuotaConfigMachinePartMapper, MesQuotaConfigMachinePart>
   implements MesQuotaConfigMachinePartService {
   @Autowired
   private Validator validator;
   @Autowired
   private MesQuotaConfigMachinePartConditionService conditionService;
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private SysSteelClassificationService machinePartClassService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public List<MesQuotaConfigMachinePartDTO> listInfo(MesQuotaConfigConditionQuery query) {
      List<MesQuotaConfigMachinePartDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> idList = list.stream().map(MesQuotaConfigMachinePart::getId).collect(Collectors.toList());
         List<Long> branchCompanyId = list.stream()
            .map(MesQuotaConfigMachinePartDTO::getBranchCompanyIdList)
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
            .map(MesQuotaConfigMachinePartDTO::getWorkshopIdList)
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
         List<Long> machinePartClassIdList = list.stream()
            .map(MesQuotaConfigMachinePartDTO::getMachinePartClassIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> machinePartClassList = Optional.ofNullable(machinePartClassIdList)
            .filter(CollUtil::isNotEmpty)
            .map(this.machinePartClassService::listByIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(i -> ShowInfo.builder().id(i.getId()).name(i.getName()).build())
            .collect(Collectors.toList());
         List<MesQuotaConfigMachinePartConditionDTO> conditionList = this.conditionService.listByQuotaConfigIdList(idList);
         Map<Long, List<MesQuotaConfigMachinePartConditionDTO>> conditionGroup = conditionList.stream()
            .collect(Collectors.groupingBy(MesQuotaConfigMachinePartCondition::getQuotaConfigId));
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

               if (CollUtil.isNotEmpty(i.getMachinePartClassIdList())) {
                  List<ShowInfo> nowMachinePartClassList = machinePartClassList.stream()
                     .filter(ac -> i.getMachinePartClassIdList().contains(ac.getId()))
                     .collect(Collectors.toList());
                  i.setMachinePartClassList(nowMachinePartClassList);
               }

               if (Objects.equals(i.getQuotaType(), 2)) {
                  i.setConditionList(conditionGroup.get(i.getId()));
               }
            }
         );
      }

      return list;
   }

   private void verifyParam(MesQuotaConfigMachinePartParam param, Class<?>... var2) {
      Set<ConstraintViolation<MesQuotaConfigMachinePartParam>> validate = this.validator.validate(param, var2);
      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<BranchCompany> branchCompanyList = this.branchCompanyService.listByIds(param.getBranchCompanyIdList());
      Preconditions.checkArgument(branchCompanyList.size() == param.getBranchCompanyIdList().size(), "包含不存在的机构, 请刷新后重试");
      List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(param.getWorkshopIdList());
      Preconditions.checkArgument(workshopList.size() == param.getWorkshopIdList().size(), "包含不存在的车间, 请刷新后重试");
      List<SysSteelClassification> machinePartClassList = this.machinePartClassService.listByIds(param.getMachinePartClassIdList());
      Preconditions.checkArgument(machinePartClassList.size() == param.getMachinePartClassIdList().size(), "包含不存在的零件类型, 请刷新后重试");
      MesBuildingProcess process = this.processService.getById(param.getProcessId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(process), "工序不存在, 请刷新后重试");
      Preconditions.checkArgument(StrUtil.isNotBlank(process.getCodename()), "所选工序没有代号, 请先配置工序代号");
      param.setProcessCodename(process.getCodename());
      LambdaQueryWrapper<MesQuotaConfigMachinePart> qw = new LambdaQueryWrapper<>();
      qw.ne(param.getId() != null, MesQuotaConfigMachinePart::getId, param.getId());
      qw.eq(MesQuotaConfigMachinePart::getProductClassificationEnum, param.getProductClassificationEnum());
      qw.eq(MesQuotaConfigMachinePart::getProcessId, param.getProcessId());
      qw.and(q -> param.getBranchCompanyIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, branch_company_ids) > 0", i)));
      qw.and(q -> param.getWorkshopIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, workshop_ids) > 0", i)));
      qw.and(q -> param.getMachinePartClassIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, machine_part_class_ids) > 0", i)));
      List<MesQuotaConfigMachinePart> list = this.list(qw);
      if (Objects.equals(param.getQuotaType(), 1)) {
         Preconditions.checkArgument(CollUtil.isEmpty(list), "机构+车间+零件类型+零件类型+工序相同, 定额类型为恒量定额, 只能有一条数据");
      }

      if (Objects.equals(param.getQuotaType(), 2)) {
         if (CollUtil.isNotEmpty(list)) {
            Preconditions.checkArgument(
               list.stream().map(MesQuotaConfigMachinePart::getQuotaType).noneMatch(qt -> Objects.equals(qt, 1)), "机构+车间+零件类型+零件类型+工序相同, 定额类型为恒量定额, 只能有一条数据"
            );
            List<Long> idList = list.stream().map(MesQuotaConfigMachinePart::getId).collect(Collectors.toList());
            String measureUnit = list.stream()
               .map(MesQuotaConfigMachinePart::getMeasureUnit)
               .findFirst()
               .orElseThrow(() -> new BusinessException("数据错误, 请联系管理员"));
            Preconditions.checkArgument(Objects.equals(measureUnit, param.getMeasureUnit()), "已存在相同的机构+车间+零件类型+零件类型+工序, 计量单位必须相同");
            List<MesQuotaConfigMachinePartCondition> alreadyExistsConditionlist = this.conditionService
               .list((Wrapper<MesQuotaConfigMachinePartCondition>)new LambdaQueryWrapper<MesQuotaConfigMachinePartCondition>().in(MesQuotaConfigMachinePartCondition::getQuotaConfigId, idList));
            Map<Integer, List<MesQuotaConfigMachinePartCondition>> conditionGroup = alreadyExistsConditionlist.stream()
               .collect(Collectors.groupingBy(MesQuotaConfigMachinePartCondition::getConditionEnum));
            param.getConditionParamList()
               .forEach(
                  cParam -> {
                     List<MesQuotaConfigMachinePartCondition> conditionList = conditionGroup.getOrDefault(cParam.getConditionEnum(), new ArrayList<>());
                     List<MesQuotaConfigCondition> configConditionList = BeanUtil.copyToList(conditionList, MesQuotaConfigCondition.class);
                     configConditionList.add(BeanUtil.toBean(cParam, MesQuotaConfigCondition.class));
                     Preconditions.checkArgument(
                        !MesQuotaConfigCondition.isIntersection(configConditionList),
                        QuotaConfigMachinePartConditionEnum.getName(cParam.getConditionEnum()) + "范围存在交集"
                     );
                  }
               );
         } else {
            param.getConditionParamList()
               .forEach(
                  cParam -> MaxAndMin.getMaxAndMin(
                     cParam.getComparisonOperatorOne(), cParam.getNumberOne(), cParam.getComparisonOperatorTwo(), cParam.getNumberTwo()
                  )
               );
         }
      }
   }

   private String getSerialNumber(String processCodename) {
      String prefix = "L" + processCodename;
      int num = this.baseMapper.getMaxSerialNumber(prefix);
      return prefix + String.format("%02d", num + 1);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigMachinePartParam param) {
      this.verifyParam(param, Add.class);
      MesQuotaConfigMachinePart configMachinePart = BeanUtil.toBean(param, MesQuotaConfigMachinePart.class);
      String branchCompanyIds = CollUtil.join(param.getBranchCompanyIdList(), ",");
      configMachinePart.setBranchCompanyIds(StrUtil.blankToDefault(branchCompanyIds, null));
      String workshopIds = CollUtil.join(param.getWorkshopIdList(), ",");
      configMachinePart.setWorkshopIds(StrUtil.blankToDefault(workshopIds, null));
      String machinePartClassIds = CollUtil.join(param.getMachinePartClassIdList(), ",");
      configMachinePart.setMachinePartClassIds(StrUtil.blankToDefault(machinePartClassIds, null));
      configMachinePart.setSerialNumber(this.getSerialNumber(param.getProcessCodename()));
      this.save(configMachinePart);
      if (Objects.equals(param.getQuotaType(), 2)) {
         param.getConditionParamList().forEach(conditionParam -> {
            MesQuotaConfigMachinePartCondition condition = BeanUtil.toBean(conditionParam, MesQuotaConfigMachinePartCondition.class);
            condition.setQuotaConfigId(configMachinePart.getId());
            condition.setSerialNumber(configMachinePart.getSerialNumber());
            this.conditionService.save(condition);
         });
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigMachinePartParam param) {
      this.verifyParam(param, Update.class);
      MesQuotaConfigMachinePart configMachinePartOld = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(configMachinePartOld), "数据不存在, 请刷新后重试");
      MesQuotaConfigMachinePart configMachinePart = BeanUtil.toBean(param, MesQuotaConfigMachinePart.class);
      String branchCompanyIds = CollUtil.join(param.getBranchCompanyIdList(), ",");
      configMachinePart.setBranchCompanyIds(StrUtil.blankToDefault(branchCompanyIds, null));
      String workshopIds = CollUtil.join(param.getWorkshopIdList(), ",");
      configMachinePart.setWorkshopIds(StrUtil.blankToDefault(workshopIds, null));
      String machinePartClassIds = CollUtil.join(param.getMachinePartClassIdList(), ",");
      configMachinePart.setMachinePartClassIds(StrUtil.blankToDefault(machinePartClassIds, null));
      this.updateById(configMachinePart);
      this.conditionService.deteleByQuotaConfigId(configMachinePart.getId());
      if (Objects.equals(param.getQuotaType(), 2)) {
         param.getConditionParamList().forEach(conditionParam -> {
            MesQuotaConfigMachinePartCondition condition = BeanUtil.toBean(conditionParam, MesQuotaConfigMachinePartCondition.class);
            condition.setQuotaConfigId(configMachinePart.getId());
            condition.setSerialNumber(configMachinePart.getSerialNumber());
            this.conditionService.save(condition);
         });
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      MesQuotaConfigMachinePart configMachinePartOld = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(configMachinePartOld), "数据不存在, 请刷新后重试");
      this.removeById(id);
      this.conditionService
         .remove((Wrapper<MesQuotaConfigMachinePartCondition>)new LambdaQueryWrapper<MesQuotaConfigMachinePartCondition>().eq(MesQuotaConfigMachinePartCondition::getQuotaConfigId, id));
      return true;
   }
}
