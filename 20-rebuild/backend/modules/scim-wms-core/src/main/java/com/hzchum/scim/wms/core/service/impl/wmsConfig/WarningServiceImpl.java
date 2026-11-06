package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warning;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WarningNotifyConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WarningDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InventoryNotifyConfDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InventoryReminderDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarningDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InventoryNotifyConfDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SpecificationDetailsMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WarningMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WarningNotifyConfigMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarningServiceImpl extends ServiceImpl<WarningMapper, Warning> implements WarningService {
   @Resource
   WarningMapper warningMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   WarningNotifyConfigMapper warningNotifyConfigMapper;
   @Resource
   SpecificationDetailsMapper specificationDetailsMapper;
   @Resource
   MeasureService measureService;
   @Resource
   UserService userService;
   UserDetailsService userDetailsService;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Value("${wms.path-symbol}")
   private String pathSymbol;

   @Override
   public PageVO<WarningDTO> pageInfo(Long workshopId, Long classificationId, String spec, Integer page, Integer size, List<String> sorts) {
      String sort = StringUtils.analyzeSortConditions(sorts);
      PageHelper.startPage(page, size, sort);
      List<Long> ids = new ArrayList<>();
      if (classificationId != null) {
         Classification classification = this.classificationService.getById(classificationId);
         if (!classification.getBoolLastEnum()) {
            ids.addAll(this.classificationService.getLastSubject(classificationId).stream().map(Classification::getId).collect(Collectors.toList()));
         }
      }

      List<WarningDTO> warningDTOS;
      if (CollectionUtil.isNotEmpty(ids)) {
         warningDTOS = this.listInfo(workshopId, null, ids, spec);
      } else {
         warningDTOS = this.listInfo(workshopId, classificationId, null, spec);
      }

      return CollectionUtil.isEmpty(warningDTOS) ? new PageVO<>(new ArrayList<>()) : new PageVO<>(warningDTOS);
   }

   @Override
   public List<WarningDTO> listInfo(Long workshopId, Long classificationId, List<Long> ids, String specification) {
      return this.warningMapper.list(workshopId, classificationId, ids, specification);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean saveWarning(List<WarningDTOParam> dtoParams) {
      dtoParams.forEach(
         param -> {
            Classification classification = this.classificationService.getById(param.getClassifyId());
            Preconditions.checkArgument(classification != null, "当前科目不存在");
            Preconditions.checkArgument(classification.getBoolLastEnum(), "当前科目不属于末级科目");
            Measure measure = this.measureService.getMeasureByClassifyId(classification.getId());
            if (param.getUnitType().equals(MeasureTypeEnum.MEASURE.getType())) {
               Preconditions.checkArgument(StrUtil.isNotBlank(measure.getMeasureUnit()), "科目[" + classification.getName() + "]计量单位未配置,禁止使用");
               param.setUnit(measure.getMeasureUnit());
            } else {
               Preconditions.checkArgument(StrUtil.isNotBlank(measure.getAccountingUnit()), "科目[" + classification.getName() + "]核算单位未配置,禁止使用");
               param.setUnit(measure.getAccountingUnit());
            }

            Preconditions.checkArgument(
               CollectionUtils.isEmpty(
                  this.warningMapper
                     .selectList(
                        (Wrapper<Warning>)((Wrappers.<Warning>lambdaQuery()
                                 .eq(Warning::getClassificationId, param.getClassifyId()))
                              .eq(Warning::getSpecification, param.getSpecification()))
                           .eq(Warning::getWorkshopId, param.getWorkshopId())
                     )
               ),
               "添加失败,当前预警信息已存在"
            );
            Warning build = Warning.builder()
               .workshopId(param.getWorkshopId())
               .classificationId(param.getClassifyId())
               .specification(param.getSpecification())
               .unit(param.getUnit())
               .unitType(param.getUnitType())
               .minimumInventory(param.getMinimumInventory())
               .build();
            this.save(build);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      return this.removeByIds(ids);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateEnabled(Long id, Boolean enabled) {
      Warning warning = this.warningMapper.selectById(id);
      Preconditions.checkArgument(warning != null, "预警配置不存在");
      warning.setEnabled(enabled);
      warning.setUpdateTime(LocalDateTime.now());
      return this.warningMapper.updateById(warning) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateWarning(Long id, BigDecimal minimumInventory, Long workshopId) {
      Warning warning = this.warningMapper.selectById(id);
      Preconditions.checkArgument(warning != null, "修改失败,预警配置不存在");
      Preconditions.checkArgument(minimumInventory.compareTo(BigDecimal.ZERO) >= 0, "预警量不能小于零");
      Classification classification = this.classificationService.getById(warning.getClassificationId());
      if (BasicClassEnum.checkIsSteel(classification.getBasicClass())) {
         Preconditions.checkArgument(minimumInventory.divide(BigDecimal.valueOf(1000L)).compareTo(BigDecimal.valueOf(1000000L)) <= 0, "预警量不能大于1000000");
      } else {
         Preconditions.checkArgument(minimumInventory.compareTo(BigDecimal.valueOf(1000000L)) <= 0, "预警量不能大于1000000");
      }

      Preconditions.checkArgument(
         CollectionUtils.isEmpty(
            this.warningMapper
               .selectList(
                  (Wrapper<Warning>)(((Wrappers.<Warning>lambdaQuery()
                              .eq(Warning::getClassificationId, warning.getClassificationId()))
                           .eq(Warning::getSpecification, warning.getSpecification()))
                        .eq(Warning::getWorkshopId, workshopId))
                     .ne(Warning::getId, id)
               )
         ),
         "修改失败,当前预警信息已存在"
      );
      warning.setMinimumInventory(minimumInventory);
      warning.setUpdateTime(LocalDateTime.now());
      warning.setWorkshopId(workshopId);
      return this.warningMapper.updateById(warning) == 1;
   }

   @Override
   public ListVO<InventoryNotifyConfDTO> getInventoryNotifyConf() {
      List<WarningNotifyConfig> warningNotifyConfigs = this.warningNotifyConfigMapper.selectList(null);
      return new ListVO<>(
         warningNotifyConfigs.stream()
            .map(
               wnc -> InventoryNotifyConfDTO.builder()
                  .workshopId(wnc.getWorkshopId())
                  .userIds(wnc.getUserIds() != null ? CommonUtil.spilt(wnc.getUserIds(), ",") : null)
                  .deptIds(wnc.getDeptIds() != null ? CommonUtil.spilt(wnc.getDeptIds(), ",") : null)
                  .build()
            )
            .collect(Collectors.toList())
      );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean setInventoryNotifyConf(List<InventoryNotifyConfDTOParam> dtoParams) {
      this.userService.setInventoryNotifyPerm(null, false);
      List<Long> userIds = new ArrayList<>();

      for (InventoryNotifyConfDTOParam param : dtoParams) {
         if (CollectionUtil.isNotEmpty(param.getDeptIds())) {
            for (Long deptId : param.getDeptIds()) {
               userIds.addAll(this.userService.listByDeptId(deptId).stream().map(User::getId).collect(Collectors.toList()));
            }
         }

         if (CollectionUtil.isNotEmpty(param.getUserIds())) {
            userIds.removeAll(param.getUserIds());
            userIds.addAll(param.getUserIds());
         }

         WarningNotifyConfig notifyConfig = this.warningNotifyConfigMapper
            .selectOne((Wrapper<WarningNotifyConfig>)Wrappers.<WarningNotifyConfig>lambdaQuery().eq(WarningNotifyConfig::getWorkshopId, param.getWorkshopId()));
         if (notifyConfig != null) {
            this.warningNotifyConfigMapper.update(
               null,
               Wrappers.<WarningNotifyConfig>lambdaUpdate()
                  .eq(WarningNotifyConfig::getId, notifyConfig.getId())
                  .set(WarningNotifyConfig::getDeptIds, CollectionUtil.isNotEmpty(param.getDeptIds()) ? StrUtil.join(",", param.getDeptIds()) : null)
                  .set(WarningNotifyConfig::getUserIds, CollectionUtil.isNotEmpty(param.getUserIds()) ? StrUtil.join(",", param.getUserIds()) : null)
            );
         } else {
            WarningNotifyConfig warningNotifyConfig = WarningNotifyConfig.builder()
               .workshopId(param.getWorkshopId())
               .deptIds(CollectionUtil.isNotEmpty(param.getDeptIds()) ? StrUtil.join(",", param.getDeptIds()) : null)
               .userIds(CollectionUtil.isNotEmpty(param.getUserIds()) ? StrUtil.join(",", param.getUserIds()) : null)
               .build();
            this.warningNotifyConfigMapper.insert(warningNotifyConfig);
         }
      }

      if (CollectionUtil.isNotEmpty(userIds)) {
         this.userService.setInventoryNotifyPerm(userIds, true);
      }

      return true;
   }

   @Override
   public PageVO<InventoryReminderDTO> getReminder() {
      List<InventoryReminderDTO> reminderDTOS = this.warningMapper
         .selectList((Wrapper<Warning>)Wrappers.<Warning>lambdaQuery().eq(Warning::getStatus, true))
         .stream()
         .map(
            warning -> {
               Classification byId = this.classificationService.getById(warning.getClassificationId());
               Map<String, BigDecimal> map = this.materialInventoryMapper
                  .getTotalQuantity(warning.getClassificationId(), warning.getWorkshopId(), warning.getSpecification());
               List<MaterialInventory> materialInventories = this.materialInventoryMapper
                  .selectList(
                     ((new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getClassifyId, warning.getClassificationId()))
                           .eq(MaterialInventory::getWorkshopId, warning.getWorkshopId()))
                        .eq(ObjectUtil.isNotEmpty(warning.getSpecification()), MaterialInventory::getSpecification, warning.getSpecification())
                  );
               InventoryReminderDTO build = InventoryReminderDTO.builder()
                  .classifyId(warning.getClassificationId())
                  .specification(warning.getSpecification())
                  .minimumInventory(warning.getMinimumInventory())
                  .unitType(warning.getUnitType())
                  .workshopId(warning.getWorkshopId())
                  .classifyCode(byId.getSerialNumber())
                  .classifyName(byId.getName())
                  .basicClass(byId.getBasicClass())
                  .unit(warning.getUnit())
                  .build();
               if (MeasureTypeEnum.MEASURE.getType().equals(warning.getUnitType())) {
                  if (map != null && map.get("quantity") != null) {
                     build.setInventory(map.get("quantity"));
                  }
               } else if (map != null && map.get("mete") != null) {
                  build.setInventory(map.get("mete"));
               }

               return build;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(reminderDTOS);
   }

   @Override
   public void updateStatus(MaterialInventory materialInventory, int type) {
      Warning warning = this.warningMapper
         .selectOne(
            (((Wrappers.<Warning>lambdaQuery().eq(Warning::getEnabled, true))
                     .eq(Warning::getClassificationId, materialInventory.getClassifyId()))
                  .eq(Warning::getWorkshopId, materialInventory.getWorkshopId()))
               .eq(ObjectUtil.isNotEmpty(materialInventory.getSpecification()), Warning::getSpecification, materialInventory.getSpecification())
         );
      BigDecimal totalQuantity = null;
      if (warning != null) {
         Map<String, BigDecimal> map = this.materialInventoryMapper
            .getTotalQuantity(materialInventory.getClassifyId(), materialInventory.getWorkshopId(), materialInventory.getSpecification());
         boolean isWarning;
         if (MeasureTypeEnum.MEASURE.getType().equals(warning.getUnitType())) {
            isWarning = warning.getMinimumInventory().compareTo(map.get("quantity")) >= 0;
         } else {
            isWarning = warning.getMinimumInventory().compareTo(map.get("mete")) >= 0;
         }

         warning.setStatus(isWarning);
         this.warningMapper.updateById(warning);
      }
   }
}
