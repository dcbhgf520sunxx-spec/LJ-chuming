package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseDetailService;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliaryRelevancyWmsClass;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryRelevancyWmsClassService;
import com.hzchum.scim.wms.core.api.enums.MeasureTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.MeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureImportDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MeasureDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.UnitMapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class MeasureServiceImpl extends ServiceImpl<MeasureMapper, Measure> implements MeasureService {
   @Resource
   private ClassificationMapper classificationMapper;
   @Resource
   private InboundDetailService inboundDetailService;
   @Resource
   private PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   private ApplyPurchaseDetailService applyPurchaseDetailService;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private MeasureMapper measureMapper;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private UnitMapper unitMapper;
   @Resource
   private MesAuxiliaryRelevancyWmsClassService mesAuxiliaryRelevancyWmsClassService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateMeasure(List<MeasureDTOParam> measureDTOParams) {
      for (MeasureDTOParam param : measureDTOParams) {
         if (param.getMeasureUnit() == null && param.getMeasurePrecision() != null || param.getMeasureUnit() != null && param.getMeasurePrecision() == null) {
            Preconditions.checkArgument(false, "计量单位和计量精度需同时配置");
         }

         if (param.getAccountingUnit() == null && param.getAccountingPrecision() != null
            || param.getAccountingUnit() != null && param.getAccountingPrecision() == null) {
            Preconditions.checkArgument(false, "核算单位和核算精度需同时配置");
         }

         if (ObjectUtil.isNotEmpty(param.getMeasurePrecision()) && param.getMeasurePrecision() < 0
            || ObjectUtil.isNotEmpty(param.getAccountingPrecision()) && param.getAccountingPrecision() < 0) {
            Preconditions.checkArgument(false, "精度配置不能小于0");
         }

         if (ObjectUtil.isNotEmpty(param.getMeasureUnit()) || ObjectUtil.isNotEmpty(param.getAccountingUnit())) {
            Preconditions.checkArgument(ObjectUtil.notEqual(param.getMeasureUnit(), param.getAccountingUnit()), "计量单位和核算单位不能相同！！！");
         }

         Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getId, param.getId()));
         Preconditions.checkArgument(measure != null, "当前计量配置不存在");
         this.checkUpdateMeasure(measure, param, Boolean.TRUE);
         BeanUtils.copyProperties(param, measure);
         measure.setUpdateTime(LocalDateTime.now());
         measure.setOutboundUnitType(StrUtil.isNotBlank(param.getMeasureUnit()) ? MeasureTypeEnum.MEASURE.getType() : MeasureTypeEnum.ACCOUNTING.getType());
         this.measureMapper
            .update(
               null,
               (Wrapper<Measure>)(((((((new LambdaUpdateWrapper<Measure>()
                                       .set(Measure::getAccountingUnit, measure.getAccountingUnit()))
                                    .set(Measure::getAccountingPrecision, measure.getAccountingPrecision()))
                                 .set(Measure::getMeasureUnit, measure.getMeasureUnit()))
                              .set(Measure::getMeasurePrecision, measure.getMeasurePrecision()))
                           .set(BaseEntity::getUpdateTime, measure.getUpdateTime()))
                        .set(Measure::getOutboundUnitType, measure.getOutboundUnitType()))
                     .set(Measure::getUseParentId, null))
                  .eq(Measure::getId, measure.getId())
            );

         for (Measure measure1 : this.measureMapper.selectSonList(measure.getClassificationId())) {
            Boolean b = this.checkUpdateMeasure(measure1, param, Boolean.FALSE);
            if (!b) {
               this.measureMapper
                  .update(
                     null,
                     (Wrapper<Measure>)(((((((new LambdaUpdateWrapper<Measure>()
                                             .set(Measure::getAccountingUnit, measure.getAccountingUnit()))
                                          .set(Measure::getAccountingPrecision, measure.getAccountingPrecision()))
                                       .set(Measure::getMeasureUnit, measure.getMeasureUnit()))
                                    .set(Measure::getMeasurePrecision, measure.getMeasurePrecision()))
                                 .set(Measure::getOutboundUnitType, measure.getOutboundUnitType()))
                              .set(BaseEntity::getUpdateTime, measure.getUpdateTime()))
                           .set(Measure::getUseParentId, measure.getId()))
                        .eq(Measure::getId, measure1.getId())
                  );
            }
         }
      }

      this.updateRedisTree();
      return true;
   }

   private Boolean checkUpdateMeasure(Measure measure, MeasureDTOParam param, Boolean boolError) {
      if ((measure.getBasicClass() & 7) > 0) {
         Unit unit = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, param.getAccountingUnit()));
         Preconditions.checkArgument(unit != null, "单位不存在");
         Preconditions.checkArgument(unit.getType().equals(UnitEnum.WEIGHT.getType()), "钢材核算单位必须为重量单位");
      }

      StringBuilder stringBuilder = new StringBuilder();
      List<InboundDetail> list = this.inboundDetailService
         .list((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getClassifyId, measure.getClassificationId()));
      if (CollectionUtil.isNotEmpty(list)) {
         stringBuilder.append("（入库）-");
      }

      int applyCount = this.applyPurchaseDetailService
         .count((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getClassifyId, measure.getClassificationId()));
      int applyCount1 = this.applyPurchaseService
         .count((Wrapper<ApplyPurchase>)new LambdaQueryWrapper<ApplyPurchase>().last("and find_in_set(" + measure.getClassificationId() + ",classify_ids)"));
      if (applyCount > 0 || applyCount1 > 0) {
         stringBuilder.append("（申购）-");
      }

      int purchaseCount = this.purchaseOrderDetailService
         .count((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getClassifyId, measure.getClassificationId()));
      if (purchaseCount > 0) {
         stringBuilder.append("（采购）");
      }

      if (!boolError) {
         return stringBuilder.length() > 0 ? true : false;
      }

      if (stringBuilder.length() > 0) {
         if (measure.getMeasureUnit() != null) {
            Preconditions.checkArgument(param.getMeasureUnit() != null, "修改失败,科目已产生" + stringBuilder + "记录,不能修改为空");
         } else {
            Preconditions.checkArgument(param.getMeasureUnit() == null, "修改失败,科目已产生" + stringBuilder + "记录,不能添加单位");
         }

         if (param.getMeasureUnit() != null && !param.getMeasureUnit().equals(measure.getMeasureUnit())) {
            Unit unit = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, param.getMeasureUnit()));
            Unit me = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getMeasureUnit()));
            if (me != null) {
               Preconditions.checkArgument(me.getType().equals(unit.getType()), "修改失败,修改后单位类型与原单位类型不一致");
            }
         }

         if (!param.getAccountingUnit().equals(measure.getAccountingUnit())) {
            Unit unit = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, param.getAccountingUnit()));
            Unit me = this.unitMapper.selectOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, measure.getAccountingUnit()));
            if (me != null) {
               Preconditions.checkArgument(me.getType().equals(unit.getType()), "修改失败,修改后单位类型与原单位类型不一致");
            }
         }
      }

      if (!param.getAccountingUnit().equals(measure.getAccountingUnit())) {
         List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList = this.mesAuxiliaryRelevancyWmsClassService
            .list(
               (Wrapper<MesAuxiliaryRelevancyWmsClass>)new LambdaQueryWrapper<MesAuxiliaryRelevancyWmsClass>().eq(MesAuxiliaryRelevancyWmsClass::getClassifyId, measure.getClassificationId())
            );
         Preconditions.checkArgument(CollectionUtil.isEmpty(mesAuxiliaryRelevancyWmsClassList), "修改核算单位,该科目已绑定配套件对照表信息");
      }

      return true;
   }

   @Override
   public ListVO<SubjectMeasureDTO> listTree(int type) {
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getParentId))
               .orderByAsc(Classification::getBasicClass)
         );
      if (type == 2) {
         Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
         List<SubjectMeasureDTO> build = this.build(0L, subjectMap, type);
         return new ListVO<>(build);
      }

      if (this.redisUtils.hasKey("subjectMeasureDTO")) {
         return new ListVO<>((List<SubjectMeasureDTO>)this.redisUtils.get("subjectMeasureDTO"));
      }

      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      List<SubjectMeasureDTO> build = this.build(0L, subjectMap, type);
      this.redisUtils.set("subjectMeasureDTO", build);
      return new ListVO<>(build);
   }

   @Override
   public void exportMeasureList(HttpServletResponse response) {
      String title = "计量配置清单";
      String sheetName = "计量配置清单";
      String fileName = "计量配置清单.xlsx";
      int orderNo = 1;
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getParentId))
               .orderByAsc(Classification::getBasicClass)
         );
      List<SubjectMeasureImportDTO> subjectMeasureImportDTOS = new ArrayList<>();
      if (this.redisUtils.hasKey("subjectMeasureDTO")) {
         for (SubjectMeasureDTO measureDTO : (List<SubjectMeasureDTO>)this.redisUtils.get("subjectMeasureDTO")) {
            SubjectMeasureImportDTO copy = BeanUtil.copy(measureDTO, SubjectMeasureImportDTO.class);
            copy.setAccountingPrecision(String.valueOf(measureDTO.getAccountingPrecision()));
            copy.setMeasurePrecision(String.valueOf(measureDTO.getMeasurePrecision()));
            copy.setOutboundUnitType(String.valueOf(measureDTO.getOutboundUnitType()));
            copy.setOrderNo(orderNo++);
            copy.setNameA(measureDTO.getName());
            if (measureDTO.getChildren().size() != 0) {
               copy.setMeasureUnit("-");
               copy.setMeasurePrecision("-");
               copy.setAccountingUnit("-");
               copy.setAccountingPrecision("-");
               copy.setOutboundUnitType("-");
            } else {
               if (measureDTO.getMeasureUnit() == null) {
                  copy.setMeasureUnit("-");
               }

               if (measureDTO.getMeasurePrecision() == null) {
                  copy.setMeasurePrecision("-");
               }

               if (measureDTO.getAccountingUnit() == null) {
                  copy.setAccountingUnit("-");
               }

               if (measureDTO.getAccountingPrecision() == null) {
                  copy.setAccountingPrecision("-");
               }

               if (measureDTO.getOutboundUnitType() == null) {
                  copy.setOutboundUnitType("-");
               } else if (measureDTO.getOutboundUnitType() == 1) {
                  copy.setOutboundUnitType("计量");
               } else {
                  copy.setOutboundUnitType("核算");
               }
            }

            subjectMeasureImportDTOS.add(copy);

            for (SubjectMeasureDTO child : measureDTO.getChildren()) {
               SubjectMeasureImportDTO copy1 = BeanUtil.copy(child, SubjectMeasureImportDTO.class);
               copy1.setNameB(child.getName());
               copy1.setAccountingPrecision(String.valueOf(child.getAccountingPrecision()));
               copy1.setMeasurePrecision(String.valueOf(child.getMeasurePrecision()));
               copy1.setOutboundUnitType(String.valueOf(child.getOutboundUnitType()));
               if (child.getChildren().size() != 0) {
                  copy1.setMeasureUnit("-");
                  copy1.setMeasurePrecision("-");
                  copy1.setAccountingUnit("-");
                  copy1.setAccountingPrecision("-");
                  copy1.setOutboundUnitType("-");
               } else {
                  if (child.getMeasureUnit() == null) {
                     copy1.setMeasureUnit("-");
                  }

                  if (child.getMeasurePrecision() == null) {
                     copy1.setMeasurePrecision("-");
                  }

                  if (child.getAccountingUnit() == null) {
                     copy1.setAccountingUnit("-");
                  }

                  if (child.getAccountingPrecision() == null) {
                     copy1.setAccountingPrecision("-");
                  }

                  if (child.getOutboundUnitType() == null) {
                     copy1.setOutboundUnitType("-");
                  } else if (child.getOutboundUnitType() == 1) {
                     copy1.setOutboundUnitType("计量");
                  } else {
                     copy1.setOutboundUnitType("核算");
                  }
               }

               subjectMeasureImportDTOS.add(copy1);

               for (SubjectMeasureDTO childChild : child.getChildren()) {
                  SubjectMeasureImportDTO copy2 = BeanUtil.copy(childChild, SubjectMeasureImportDTO.class);
                  copy2.setNameC(childChild.getName());
                  copy2.setAccountingPrecision(String.valueOf(childChild.getAccountingPrecision()));
                  copy2.setMeasurePrecision(String.valueOf(childChild.getMeasurePrecision()));
                  copy2.setOutboundUnitType(String.valueOf(childChild.getOutboundUnitType()));
                  if (childChild.getMeasureUnit() == null) {
                     copy2.setMeasureUnit("-");
                  }

                  if (childChild.getMeasurePrecision() == null) {
                     copy2.setMeasurePrecision("-");
                  }

                  if (childChild.getAccountingUnit() == null) {
                     copy2.setAccountingUnit("-");
                  }

                  if (childChild.getAccountingPrecision() == null) {
                     copy2.setAccountingPrecision("-");
                  }

                  if (childChild.getOutboundUnitType() == null) {
                     copy2.setOutboundUnitType("-");
                  } else if (childChild.getOutboundUnitType() == 1) {
                     copy2.setOutboundUnitType("计量");
                  } else {
                     copy2.setOutboundUnitType("核算");
                  }

                  subjectMeasureImportDTOS.add(copy2);
               }
            }
         }
      }

      PoiUtils.wmsExportExcel(subjectMeasureImportDTOS, title, sheetName, SubjectMeasureImportDTO.class, fileName, response);
   }

   @Override
   public void updateRedisTree() {
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getParentId))
               .orderByAsc(Classification::getBasicClass)
         );
      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      List<SubjectMeasureDTO> build = this.build(0L, subjectMap, 1);
      this.redisUtils.set("subjectMeasureDTO", build);
   }

   private List<SubjectMeasureDTO> build(Long pid, Map<Long, List<Classification>> subjectMap, int type) {
      List<Classification> classifications = subjectMap.get(pid);
      if (CollectionUtils.isEmpty(classifications)) {
         return new ArrayList<>();
      } else if (type == 1) {
         return classifications.stream().map(c -> {
            SubjectMeasureDTO tree = SubjectMeasureDTO.builder().build();
            BeanUtil.copy(c, tree);
            Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, c.getId()));
            if (measure != null) {
               BeanUtil.copy(measure, tree);
               if (StrUtil.isBlank(measure.getMeasureUnit()) && StrUtil.isBlank(measure.getAccountingUnit())) {
                  this.getClassifyMeasureById(measure, c.getParentId());
                  BeanUtil.copy(measure, tree);
               }
            }

            tree.setChildren(this.build(c.getId(), subjectMap, 1));
            return tree;
         }).collect(Collectors.toList());
      } else {
         return type == 2 ? classifications.stream().map(c -> {
            SubjectMeasureDTO tree = SubjectMeasureDTO.builder().build();
            BeanUtil.copy(c, tree);
            Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, c.getId()));
            if (measure != null) {
               if (c.getBoolLastEnum()) {
                  if (measure.getBoolQualityTesting()) {
                     BeanUtil.copy(measure, tree, "id");
                  } else {
                     tree = null;
                  }
               } else {
                  BeanUtil.copy(measure, tree, "id");
                  tree.setChildren(this.build(c.getId(), subjectMap, 2));
                  if (CollectionUtil.isNotEmpty(subjectMap.get(c.getId()))) {
                     tree.setClassifyQuantity(subjectMap.get(c.getId()).size());
                  }

                  if (CollectionUtil.isEmpty(tree.getChildren())) {
                     tree = null;
                  }
               }
            }

            return tree;
         }).filter(Objects::nonNull).collect(Collectors.toList()) : new ArrayList<>();
      }
   }

   @Override
   public Measure getMeasureByClassifyId(Long id) {
      Classification classification = this.classificationMapper.selectById(id);
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, classification.getId()));
      if (StrUtil.isBlank(measure.getMeasureUnit()) && StrUtil.isBlank(measure.getAccountingUnit()) && classification.getParentId() != 0L) {
         this.getClassifyMeasureById(measure, classification.getParentId());
      }

      return measure;
   }

   @Override
   public ListVO<SubjectMeasureDTO> getSteelConfig() {
      List<SubjectMeasureDTO> list = this.listTree(2).getContent().stream().filter(Objects::nonNull).collect(Collectors.toList());

      for (SubjectMeasureDTO dto : list) {
         List<SubjectMeasureDTO> dtoList = dto.getChildren();
         if (CollectionUtil.isNotEmpty(dtoList)) {
            dto.setChildren(this.filter(dtoList));
         }
      }

      return new ListVO<>(list);
   }

   public List<SubjectMeasureDTO> filter(List<SubjectMeasureDTO> list) {
      return list.stream().filter(Objects::nonNull).peek(l -> {
         List<SubjectMeasureDTO> children = l.getChildren();
         if (CollectionUtil.isNotEmpty(children)) {
            l.setChildren(this.filter(children));
         }
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateQualityTesting(List<Long> ids) {
      for (Long id : ids) {
         Classification classify = this.classificationMapper.selectById(id);
         this.measureMapper.updateSteel(id);
         if (!classify.getBoolLastEnum()) {
            List<Long> list = this.classificationMapper
               .selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().eq(Classification::getParentId, id))
               .stream()
               .map(Classification::getId)
               .collect(Collectors.toList());
            this.updateQualityTesting(list);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delQualityTesting(List<Long> ids) {
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(ids), "删除失败");
      this.measureMapper.deleteTestingClassify(ids);
      return true;
   }

   @Override
   public List<SubjectMeasureDTO> measureListByIds(List<Long> classificationIds) {
      List<Classification> classifications = this.classificationMapper.selectBatchIds(classificationIds);
      List<Measure> measures = this.measureMapper.selectList((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getClassificationId, classificationIds));
      if (CollectionUtil.isEmpty(measures)) {
         return new ArrayList<>();
      }

      List<SubjectMeasureDTO> subjectMeasureDTOS = new ArrayList<>();

      for (Measure measure : measures) {
         Classification classification = classifications.stream().filter(c -> c.getId().equals(measure.getClassificationId())).findAny().orElse(null);
         SubjectMeasureDTO subjectMeasureDTO = SubjectMeasureDTO.builder().build();
         BeanUtil.copy(classification, subjectMeasureDTO);
         if (StrUtil.isBlank(measure.getMeasureUnit()) && StrUtil.isBlank(measure.getAccountingUnit())) {
            this.getClassifyMeasureById(measure, classification.getParentId());
         }

         BeanUtil.copy(measure, subjectMeasureDTO);
         subjectMeasureDTOS.add(subjectMeasureDTO);
      }

      return subjectMeasureDTOS;
   }

   @Override
   public SubjectMeasureDTO measureListById(Long classificationId) {
      Classification classification = this.classificationMapper.selectById(classificationId);
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().in(Measure::getClassificationId, classificationId));
      if (ObjectUtil.isEmpty(measure)) {
         return null;
      }

      SubjectMeasureDTO subjectMeasureDTO = SubjectMeasureDTO.builder().build();
      BeanUtil.copy(classification, subjectMeasureDTO);
      if (StrUtil.isBlank(measure.getMeasureUnit()) && StrUtil.isBlank(measure.getAccountingUnit())) {
         this.getClassifyMeasureById(measure, classification.getParentId());
      }

      BeanUtil.copy(measure, subjectMeasureDTO);
      return subjectMeasureDTO;
   }

   @Override
   public List<Measure> initGetMeasure() {
      return this.baseMapper.initGetMeasure();
   }

   @Override
   public List<MeasureDTO> getMeasureDTO(Collection<Long> classifyIds) {
      return CollectionUtil.isEmpty(classifyIds) ? new ArrayList<>() : this.baseMapper.getMeasureDTO(classifyIds);
   }

   public void getClassifyMeasureById(Measure measure, Long parentId) {
      Measure parentMeasure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, parentId));
      if (parentMeasure != null) {
         if (StrUtil.isBlank(parentMeasure.getMeasureUnit()) && StrUtil.isBlank(parentMeasure.getAccountingUnit())) {
            Classification classification = this.classificationMapper.selectById(parentMeasure.getClassificationId());
            this.getClassifyMeasureById(measure, classification.getParentId());
         } else {
            if (StrUtil.isNotBlank(parentMeasure.getMeasureUnit())) {
               measure.setMeasureUnit(parentMeasure.getMeasureUnit());
            }

            if (StrUtil.isNotBlank(parentMeasure.getAccountingUnit())) {
               measure.setAccountingUnit(parentMeasure.getAccountingUnit());
            }

            measure.setMeasurePrecision(parentMeasure.getMeasurePrecision() != null ? parentMeasure.getMeasurePrecision() : null);
            measure.setAccountingPrecision(parentMeasure.getAccountingPrecision() != null ? parentMeasure.getAccountingPrecision() : null);
         }
      }
   }
}
