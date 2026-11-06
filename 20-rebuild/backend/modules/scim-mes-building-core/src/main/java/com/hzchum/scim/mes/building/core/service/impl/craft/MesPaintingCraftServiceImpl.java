package com.hzchum.scim.mes.building.core.service.impl.craft;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveFlowStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.ApprovalParam;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraftDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintingCraftDetailService;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintingCraftService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesPaintingCraftMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesPaintingCraftServiceImpl extends ServiceImpl<MesPaintingCraftMapper, MesPaintingCraft> implements MesPaintingCraftService {
   @Autowired
   private WmsApproveRecordService approveRecordService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private PlanMonomerService monomerService;
   @Autowired
   private MesPaintingCraftDetailService detailService;

   @Override
   public List<MesPaintingCraftDTO> listInfo(MesPaintingCraftQuery query) {
      List<MesPaintingCraftDTO> list = this.baseMapper.listInfo(query);
      if (CollUtil.isNotEmpty(list)) {
         List<Long> monomerIdList = list.stream()
            .map(MesPaintingCraftDTO::getMonomerIdList)
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         List<PlanMonomer> monomerList = CollUtil.isNotEmpty(monomerIdList) ? this.monomerService.listByIds(monomerIdList) : Collections.emptyList();
         List<Long> idList = list.stream().map(MesPaintingCraft::getId).collect(Collectors.toList());
         Map<Long, List<MesPaintingCraftDetail>> detailGroup = this.detailService
            .list((Wrapper<MesPaintingCraftDetail>)new LambdaQueryWrapper<MesPaintingCraftDetail>().in(MesPaintingCraftDetail::getPaintingCraftId, idList))
            .stream()
            .collect(Collectors.groupingBy(MesPaintingCraftDetail::getPaintingCraftId));
         list.forEach(
            i -> {
               if (CollUtil.isNotEmpty(i.getMonomerIdList())) {
                  List<NameInfo> nowMonomerList = monomerList.stream()
                     .filter(monomer -> i.getMonomerIdList().contains(monomer.getId()))
                     .map(monomer -> BeanUtil.toBean(monomer, NameInfo.class))
                     .collect(Collectors.toList());
                  i.setMonomerList(nowMonomerList);
               }

               i.setDetailList(detailGroup.getOrDefault(i.getId(), Collections.emptyList()));
            }
         );
      }

      return list;
   }

   private String getSerialNumber(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在, 请刷新后重试");
      LocalDate now = LocalDate.now();
      String prefix = project.getName() + now.getMonthValue() + now.getDayOfMonth() + "-";
      Integer maxDigit = this.baseMapper.getMaxDigit(prefix);
      return prefix + (maxDigit + 1);
   }

   private void verifyParam(MesPaintingCraftParam param) {
      List<MesPaintingCraft> list = this.list(
         (Wrapper<MesPaintingCraft>)(new LambdaQueryWrapper<MesPaintingCraft>().ne(param.getId() != null, MesPaintingCraft::getId, param.getId()))
            .eq(MesPaintingCraft::getSerialNumber, param.getSerialNumber())
      );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "编号已存在");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesPaintingCraftParam param) {
      this.verifyParam(param);
      MesPaintingCraft paintingCraft = BeanUtil.toBean(param, MesPaintingCraft.class);
      paintingCraft.setMonomerIds(CollUtil.join(param.getMonomerIdList(), ","));
      paintingCraft.setCreateUserId(UserUtil.getCurrentUserId());
      paintingCraft.setCreateDate(LocalDateTime.now());
      this.save(paintingCraft);
      if (CollUtil.isNotEmpty(param.getDetailParamList())) {
         List<MesPaintingCraftDetail> detailList = param.getDetailParamList()
            .stream()
            .map(
               detailParam -> {
                  List<Integer> paintingTypeList = CollUtil.newArrayList(
                     PaintingTypeEnum.PRIMER.getType(), PaintingTypeEnum.INTERMEDIATE_PAINT.getType(), PaintingTypeEnum.TOPCOAT.getType()
                  );
                  Preconditions.checkArgument(paintingTypeList.contains(detailParam.getPaintingTypeEnum()), "涂料类型不存在");
                  MesPaintingCraftDetail detail = BeanUtil.toBean(detailParam, MesPaintingCraftDetail.class);
                  detail.setPaintingCraftId(paintingCraft.getId());
                  detail.setPaintingCraftSerialNumber(paintingCraft.getSerialNumber());
                  return detail;
               }
            )
            .collect(Collectors.toList());
         this.detailService.saveBatch(detailList);
      }

      WmsApproveRecord approveRecord = this.approveRecordService
         .createRecord(
            paintingCraft.getId(),
            paintingCraft.getSerialNumber(),
            ApproveProcessTypeEnumV2.MES_PAINTING_CRAFT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      paintingCraft.setApproveRecordId(approveRecord.getId());
      paintingCraft.setApproveRecordSerialNumber(approveRecord.getSerialNumber());
      paintingCraft.setApprovalStatus(approveRecord.getReviewStatus());
      paintingCraft.setBoolInApproval(true);
      this.updateById(paintingCraft);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesPaintingCraftParam param) {
      MesPaintingCraft oldPaintingCraft = this.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldPaintingCraft), "数据不存在, 请刷新后重试");
      this.verifyParam(param);
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime now = LocalDateTime.now();
      if (ReviewStatusEnum.REVIEWED.getType().equals(oldPaintingCraft.getApprovalStatus())) {
         if (oldPaintingCraft.getBoolInApproval()) {
            MesPaintingCraft paintingCraft = this.baseMapper.selectApprovalDataByOldId(oldPaintingCraft.getId());
            if (BeanUtil.isNotEmpty(paintingCraft)) {
               this.approveRecordService.revocation(paintingCraft.getApproveRecordId());
               this.detailService
                  .remove((Wrapper<MesPaintingCraftDetail>)new LambdaUpdateWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, paintingCraft.getId()));
            }
         }

         MesPaintingCraft paintingCraft = BeanUtil.toBean(param, MesPaintingCraft.class);
         paintingCraft.setMonomerIds(CollUtil.join(param.getMonomerIdList(), ","));
         paintingCraft.setCreateUserId(currentUserId);
         paintingCraft.setCreateDate(now);
         this.save(paintingCraft);
         if (CollUtil.isNotEmpty(param.getDetailParamList())) {
            List<MesPaintingCraftDetail> detailList = param.getDetailParamList()
               .stream()
               .map(
                  detailParam -> {
                     List<Integer> paintingTypeList = CollUtil.newArrayList(
                        PaintingTypeEnum.PRIMER.getType(), PaintingTypeEnum.INTERMEDIATE_PAINT.getType(), PaintingTypeEnum.TOPCOAT.getType()
                     );
                     Preconditions.checkArgument(paintingTypeList.contains(detailParam.getPaintingTypeEnum()), "涂料类型不存在");
                     MesPaintingCraftDetail detail = BeanUtil.toBean(detailParam, MesPaintingCraftDetail.class);
                     detail.setPaintingCraftId(paintingCraft.getId());
                     detail.setPaintingCraftSerialNumber(paintingCraft.getSerialNumber());
                     return detail;
                  }
               )
               .collect(Collectors.toList());
            this.detailService.saveBatch(detailList);
         }

         WmsApproveRecord approveRecord = this.approveRecordService
            .createRecord(
               paintingCraft.getId(),
               paintingCraft.getSerialNumber(),
               ApproveProcessTypeEnumV2.MES_PAINTING_CRAFT.getType(),
               null,
               null,
               null,
               true,
               null,
               null,
               null
            );
         this.update(
            (Wrapper<MesPaintingCraft>)((((((new LambdaUpdateWrapper<MesPaintingCraft>()
                                 .eq(MesPaintingCraft::getId, paintingCraft.getId()))
                              .set(MesPaintingCraft::getApproveRecordId, approveRecord.getId()))
                           .set(MesPaintingCraft::getApproveRecordSerialNumber, approveRecord.getSerialNumber()))
                        .set(MesPaintingCraft::getApprovalStatus, approveRecord.getReviewStatus()))
                     .set(MesPaintingCraft::getOldId, oldPaintingCraft.getId()))
                  .set(MesPaintingCraft::getBoolInApproval, true))
               .set(BaseEntity::getBoolDeleteEnum, true)
         );
         this.update(
            (Wrapper<MesPaintingCraft>)(new LambdaUpdateWrapper<MesPaintingCraft>().eq(MesPaintingCraft::getId, oldPaintingCraft.getId()))
               .set(MesPaintingCraft::getBoolInApproval, true)
         );
      } else {
         MesPaintingCraft paintingCraft = BeanUtil.toBean(param, MesPaintingCraft.class);
         paintingCraft.setMonomerIds(CollUtil.join(param.getMonomerIdList(), ","));
         paintingCraft.setCreateUserId(currentUserId);
         paintingCraft.setCreateDate(now);
         WmsApproveRecord approveRecord = this.approveRecordService
            .createRecord(
               paintingCraft.getId(),
               paintingCraft.getSerialNumber(),
               ApproveProcessTypeEnumV2.MES_PAINTING_CRAFT.getType(),
               null,
               null,
               null,
               true,
               null,
               null,
               null
            );
         paintingCraft.setApproveRecordId(approveRecord.getId());
         paintingCraft.setApproveRecordSerialNumber(approveRecord.getSerialNumber());
         paintingCraft.setApprovalStatus(approveRecord.getReviewStatus());
         paintingCraft.setBoolInApproval(true);
         this.updateById(paintingCraft);
         this.detailService
            .remove((Wrapper<MesPaintingCraftDetail>)new LambdaUpdateWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, paintingCraft.getId()));
         if (CollUtil.isNotEmpty(param.getDetailParamList())) {
            List<MesPaintingCraftDetail> detailList = param.getDetailParamList()
               .stream()
               .map(
                  detailParam -> {
                     List<Integer> paintingTypeList = CollUtil.newArrayList(
                        PaintingTypeEnum.PRIMER.getType(), PaintingTypeEnum.INTERMEDIATE_PAINT.getType(), PaintingTypeEnum.TOPCOAT.getType()
                     );
                     Preconditions.checkArgument(paintingTypeList.contains(detailParam.getPaintingTypeEnum()), "涂料类型不存在");
                     MesPaintingCraftDetail detail = BeanUtil.toBean(detailParam, MesPaintingCraftDetail.class);
                     detail.setPaintingCraftId(paintingCraft.getId());
                     detail.setPaintingCraftSerialNumber(paintingCraft.getSerialNumber());
                     return detail;
                  }
               )
               .collect(Collectors.toList());
            this.detailService.saveBatch(detailList);
         }

         if (ReviewStatusEnum.AUDITING.getType().equals(oldPaintingCraft.getApprovalStatus())) {
            this.approveRecordService.revocation(oldPaintingCraft.getApproveRecordId());
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(ApprovalParam param) {
      MesPaintingCraft paintingCraft = this.baseMapper.selectApprovalDataById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(paintingCraft), "数据不存在, 请刷新后重试");
      Long currentUserId = UserUtil.getCurrentUserId();
      LocalDateTime now = LocalDateTime.now();
      Boolean boolLastStep = this.approveRecordService
         .commonApproveStep(paintingCraft.getId(), param.getStatus(), param.getOpinion(), paintingCraft.getApproveRecordSerialNumber(), null);
      if (boolLastStep) {
         if (paintingCraft.getOldId() != null) {
            if (ApproveFlowStatusEnum.FAIL.getType().equals(param.getStatus())) {
               this.removeById(paintingCraft.getId());
               this.detailService
                  .remove((Wrapper<MesPaintingCraftDetail>)new LambdaUpdateWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, paintingCraft.getId()));
               this.update(
                  (Wrapper<MesPaintingCraft>)(new LambdaUpdateWrapper<MesPaintingCraft>().set(MesPaintingCraft::getBoolInApproval, false))
                     .eq(MesPaintingCraft::getId, paintingCraft.getOldId())
               );
            } else {
               this.removeById(paintingCraft.getOldId());
               this.detailService
                  .remove((Wrapper<MesPaintingCraftDetail>)new LambdaUpdateWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, paintingCraft.getOldId()));
               this.baseMapper.approvalDataUpdateById(paintingCraft.getId(), param.getStatus(), currentUserId, now, false);
            }
         } else if (paintingCraft.getBoolInvalid()) {
            if (ApproveFlowStatusEnum.FAIL.getType().equals(param.getStatus())) {
               paintingCraft.setBoolInvalid(false);
               if (StrUtil.isNotBlank(paintingCraft.getOldData())) {
                  MesPaintingCraft paintingCraftOld = JSONUtil.toBean(paintingCraft.getOldData(), MesPaintingCraft.class);
                  paintingCraft.setApprovalUserId(paintingCraftOld.getApprovalUserId());
                  paintingCraft.setApprovalTime(paintingCraftOld.getApprovalTime());
                  paintingCraft.setApprovalStatus(paintingCraftOld.getApprovalStatus());
                  paintingCraft.setApproveRecordId(paintingCraftOld.getApproveRecordId());
                  paintingCraft.setApproveRecordSerialNumber(paintingCraftOld.getApproveRecordSerialNumber());
                  paintingCraft.setOldData(null);
               }

               paintingCraft.setBoolInApproval(false);
               this.updateById(paintingCraft);
            } else {
               this.baseMapper.approvalDataUpdateById(paintingCraft.getId(), param.getStatus(), currentUserId, now, false);
            }
         } else {
            this.baseMapper.approvalDataUpdateById(paintingCraft.getId(), param.getStatus(), currentUserId, now, false);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean cancelApproval(Long id) {
      MesPaintingCraft paintingCraft = this.baseMapper.selectApprovalDataById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(paintingCraft), "数据不存在, 请刷新后重试");
      Long currentUserId = UserUtil.getCurrentUserId();
      Preconditions.checkArgument(currentUserId.equals(paintingCraft.getCreateUserId()), "仅创建人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(paintingCraft.getApprovalStatus()), "当前状态不可撤销");
      this.approveRecordService.revocation(paintingCraft.getApproveRecordId());
      if (paintingCraft.getOldId() != null) {
         this.removeById(paintingCraft.getId());
         this.detailService
            .remove((Wrapper<MesPaintingCraftDetail>)new LambdaUpdateWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, paintingCraft.getId()));
         this.update(
            (Wrapper<MesPaintingCraft>)(new LambdaUpdateWrapper<MesPaintingCraft>().set(MesPaintingCraft::getBoolInApproval, false))
               .eq(MesPaintingCraft::getId, paintingCraft.getOldId())
         );
      } else {
         if (paintingCraft.getBoolInvalid()) {
            paintingCraft.setBoolInvalid(false);
            if (StrUtil.isNotBlank(paintingCraft.getOldData())) {
               MesPaintingCraft paintingCraftOld = JSONUtil.toBean(paintingCraft.getOldData(), MesPaintingCraft.class);
               paintingCraft.setApprovalUserId(paintingCraftOld.getApprovalUserId());
               paintingCraft.setApprovalTime(paintingCraftOld.getApprovalTime());
               paintingCraft.setApprovalStatus(paintingCraftOld.getApprovalStatus());
               paintingCraft.setApproveRecordId(paintingCraftOld.getApproveRecordId());
               paintingCraft.setApproveRecordSerialNumber(paintingCraftOld.getApproveRecordSerialNumber());
               paintingCraft.setOldData(null);
            }
         } else {
            paintingCraft.setApprovalStatus(ReviewStatusEnum.CANCEL.getType());
         }

         paintingCraft.setBoolInApproval(false);
         this.updateById(paintingCraft);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean invalid(Long id) {
      MesPaintingCraft paintingCraftOld = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(paintingCraftOld), "数据不存在, 请刷新后重试");
      Preconditions.checkArgument(ReviewStatusEnum.REVIEWED.getType().equals(paintingCraftOld.getApprovalStatus()), "当前状态不可作废");
      String oldData = JSONUtil.toJsonStr(paintingCraftOld);
      paintingCraftOld.setOldData(oldData);
      WmsApproveRecord approveRecord = this.approveRecordService
         .createRecord(
            paintingCraftOld.getId(),
            paintingCraftOld.getSerialNumber(),
            ApproveProcessTypeEnumV2.MES_PAINTING_CRAFT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      paintingCraftOld.setApproveRecordId(approveRecord.getId());
      paintingCraftOld.setApproveRecordSerialNumber(approveRecord.getSerialNumber());
      paintingCraftOld.setApprovalStatus(approveRecord.getReviewStatus());
      paintingCraftOld.setApprovalUserId(null);
      paintingCraftOld.setApprovalTime(null);
      paintingCraftOld.setBoolInvalid(true);
      paintingCraftOld.setBoolInApproval(true);
      this.updateById(paintingCraftOld);
      return true;
   }

   @Override
   public MesPaintingCraftDTO detailById(Long id, Boolean boolApprovalQuery) {
      MesPaintingCraftDTO paintingCraft = boolApprovalQuery != null && boolApprovalQuery
         ? this.baseMapper.approvalDataDetailById(id)
         : this.baseMapper.detailById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(paintingCraft), "数据不存在, 请刷新后重试");
      if (StrUtil.isNotBlank(paintingCraft.getMonomerIds())) {
         List<Long> monomerIdList = Convert.toList(Long.class, paintingCraft.getMonomerIds().split(","));
         List<PlanMonomer> monomerList = this.monomerService.listByIds(monomerIdList);
         paintingCraft.setMonomerList(BeanUtil.copyToList(monomerList, NameInfo.class));
      }

      List<MesPaintingCraftDetail> detailList = this.detailService
         .list((Wrapper<MesPaintingCraftDetail>)new LambdaQueryWrapper<MesPaintingCraftDetail>().eq(MesPaintingCraftDetail::getPaintingCraftId, id));
      paintingCraft.setDetailList(detailList);
      WmsApproveRecordFlowDTO approveRecord = this.approveRecordService.getApproveRecordDTO(paintingCraft.getApproveRecordId());
      paintingCraft.setApproveRecord(approveRecord);
      return paintingCraft;
   }
}
