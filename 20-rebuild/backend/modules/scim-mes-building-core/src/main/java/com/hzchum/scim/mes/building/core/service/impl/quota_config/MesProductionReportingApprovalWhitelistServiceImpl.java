package com.hzchum.scim.mes.building.core.service.impl.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalWhitelist;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalWhitelistDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalWhitelistParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalWhitelistService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesProductionReportingApprovalWhitelistMapper;
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
public class MesProductionReportingApprovalWhitelistServiceImpl
   extends ServiceImpl<MesProductionReportingApprovalWhitelistMapper, MesProductionReportingApprovalWhitelist>
   implements MesProductionReportingApprovalWhitelistService {
   @Autowired
   private Validator validator;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTeamService teamService;

   @Override
   public List<MesProductionReportingApprovalWhitelistDTO> listInfo() {
      List<MesProductionReportingApprovalWhitelistDTO> list = this.baseMapper.listInfo();
      if (CollUtil.isNotEmpty(list)) {
         List<Long> workshopIdList = list.stream()
            .map(MesProductionReportingApprovalWhitelistDTO::getWorkshopIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> workshopList = Optional.of(workshopIdList)
            .filter(CollUtil::isNotEmpty)
            .map(this.workshopService::listByIds)
            .orElse(Collections.emptyList())
            .stream()
            .map(i -> ShowInfo.builder().id(i.getId()).name(i.getName()).shortName(i.getShortName()).build())
            .collect(Collectors.toList());
         List<Long> teamIdList = list.stream()
            .map(MesProductionReportingApprovalWhitelistDTO::getTeamIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         List<ShowInfo> teamList = Optional.of(teamIdList).filter(CollUtil::isNotEmpty).map(this.teamService::listInfoByIds).orElse(Collections.emptyList());
         list.forEach(i -> {
            if (CollUtil.isNotEmpty(i.getWorkshopIdList())) {
               List<ShowInfo> nowWorkshopList = workshopList.stream().filter(w -> i.getWorkshopIdList().contains(w.getId())).collect(Collectors.toList());
               i.setWorkshopList(nowWorkshopList);
            }

            if (CollUtil.isNotEmpty(i.getTeamIdList())) {
               List<ShowInfo> nowTeamList = teamList.stream().filter(t -> i.getTeamIdList().contains(t.getId())).collect(Collectors.toList());
               i.setTeamList(nowTeamList);
            }
         });
      }

      return list;
   }

   private void verifyParam(MesProductionReportingApprovalWhitelistParam param) {
      if (param.getId() != null) {
         MesProductionReportingApprovalWhitelist oldEntity = this.getById(param.getId());
         Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      }

      Set<ConstraintViolation<MesProductionReportingApprovalWhitelistParam>> validate = this.validator.validate(param);
      Preconditions.checkArgument(CollUtil.isEmpty(validate), validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n")));
      List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(param.getWorkshopIdList());
      Preconditions.checkArgument(workshopList.size() == param.getWorkshopIdList().size(), "包含不存在的车间, 请刷新后重试");
      MesBuildingProcess process = this.processService.getById(param.getProcessId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(process), "工序不存在, 请刷新后重试");
      List<MesBuildingTeam> teamList = this.teamService.listByIds(param.getTeamIdList());
      Preconditions.checkArgument(teamList.size() == param.getTeamIdList().size(), "包含不存在的班组, 请刷新后重试");
      LambdaQueryWrapper<MesProductionReportingApprovalWhitelist> qw = new LambdaQueryWrapper<>();
      qw.ne(param.getId() != null, MesProductionReportingApprovalWhitelist::getId, param.getId());
      qw.eq(MesProductionReportingApprovalWhitelist::getProcessId, param.getProcessId());
      qw.and(q -> param.getWorkshopIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, workshop_ids) > 0", i)));
      qw.and(q -> param.getTeamIdList().forEach(i -> (q.or()).apply("FIND_IN_SET({0}, team_ids) > 0", i)));
      List<MesProductionReportingApprovalWhitelist> list = this.list(qw);
      Preconditions.checkArgument(CollUtil.isEmpty(list), "车间+工序+班组重复, 请重新操作");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addOrEdit(MesProductionReportingApprovalWhitelistParam param) {
      this.verifyParam(param);
      MesProductionReportingApprovalWhitelist entity = BeanUtil.toBean(param, MesProductionReportingApprovalWhitelist.class);
      this.saveOrUpdate(entity);
      return true;
   }

   @Override
   public Boolean deleteByid(Long id) {
      MesProductionReportingApprovalWhitelist oldEntity = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldEntity), "数据不存在, 请刷新后重试");
      this.removeById(id);
      return true;
   }
}
