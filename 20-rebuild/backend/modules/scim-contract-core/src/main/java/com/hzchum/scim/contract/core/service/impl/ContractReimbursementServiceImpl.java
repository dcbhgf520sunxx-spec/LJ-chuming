package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.enums.ConfirmStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursement;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursementDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDetailClassifyDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementConfirmDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementDetailConfirmDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementDetailSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ReimbursementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ReimbursementDetailEditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ReimbursementEditDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractReimbursementService;
import com.hzchum.scim.contract.core.mapper.ContractProjectMapper;
import com.hzchum.scim.contract.core.mapper.ContractReimbursementDetailMapper;
import com.hzchum.scim.contract.core.mapper.ContractReimbursementMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractReimbursementServiceImpl extends ServiceImpl<ContractReimbursementMapper, ContractReimbursement> implements ContractReimbursementService {
   @Resource
   private ContractProjectMapper projectMapper;
   @Resource
   private ContractReimbursementDetailMapper reimbursementDetailMapper;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private UserService userService;

   @Override
   public PageVO<ReimbursementDTO> listReimbursements(
      Integer dateType,
      LocalDate startDate,
      LocalDate endDate,
      Long projectId,
      Integer type,
      String applyDepartName,
      String applyUserName,
      String writtenByName,
      Integer confirmStatus,
      Integer pageNumber,
      Integer pageSize,
      List<String> sort
   ) {
      String orderBy = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, orderBy);
      List<ReimbursementDTO> reimbursementDTOS = this.baseMapper
         .listByConditions(dateType, startDate, endDate, projectId, type, applyDepartName, applyUserName, writtenByName, confirmStatus);
      if (reimbursementDTOS.isEmpty()) {
         return new PageVO<>();
      }

      reimbursementDTOS.forEach(
         r -> {
            List<ReimbursementDetailClassifyDTO> classifyDTOList = this.reimbursementDetailMapper.selectDetailClassify(r.getId());
            if (classifyDTOList.isEmpty()) {
               r.setDetailClassifyList(new ArrayList<>());
            } else {
               classifyDTOList.forEach(
                  c -> {
                     List<ContractReimbursementDetail> reimbursementDetails = this.reimbursementDetailMapper
                        .selectList(
                           Wrappers.lambdaQuery(ContractReimbursementDetail.class)
                              .eq(ContractReimbursementDetail::getReimbursementId, r.getId())
                              .eq(ContractReimbursementDetail::getExpenseTypeId, c.getExpenseTypeId())
                        );
                     List<ReimbursementDetailDTO> detailDTOList = reimbursementDetails.stream().map(s -> {
                        ReimbursementDetailDTO detailDTO = BeanUtil.copy(s, ReimbursementDetailDTO.class);
                        SysDictionary dictionary = this.dictionaryService.getById(s.getDictionaryId());
                        detailDTO.setDictionaryLabel(dictionary != null ? dictionary.getLabel() : null);
                        return detailDTO;
                     }).collect(Collectors.toList());
                     c.setReimbursementDetailList(detailDTOList);
                  }
               );
               r.setDetailClassifyList(classifyDTOList);
            }
         }
      );
      return new PageVO<>(reimbursementDTOS);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printReimbursements(
      Integer dateType,
      LocalDate startDate,
      LocalDate endDate,
      Long projectId,
      Integer type,
      String applyDepartName,
      String applyUserName,
      String writtenByName,
      Integer confirmStatus
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      printVO.setHeader(header);
      List<ReimbursementDTO> reimbursementDTOS = this.baseMapper
         .listByConditions(dateType, startDate, endDate, projectId, type, applyDepartName, applyUserName, writtenByName, confirmStatus);
      printVO.setTable(reimbursementDTOS.stream().map(r -> BeanUtil.beanToMap(r)).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public BigDecimal getSumActuallyPayAmount(Long projectId) {
      return this.baseMapper.selectActuallyPayAmountSum(projectId, ConfirmStatusEnum.SUCCEED.getType());
   }

   @Transactional
   @Override
   public Boolean saveReimbursement(ReimbursementSaveDTOParam saveDTOParam) {
      ContractProject project = this.projectMapper.selectById(saveDTOParam.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      List<ReimbursementDetailSaveDTOParam> detailList = saveDTOParam.getDetailList();
      BigDecimal sum = BigDecimal.ZERO;

      for (ReimbursementDetailSaveDTOParam save : detailList) {
         sum = sum.add(save.getApplyAmount());
      }

      Preconditions.checkArgument(saveDTOParam.getApplyAmount().compareTo(sum) == 0, "报销申请金额与明细申请报销金额之和不相等!");
      ContractReimbursement reimbursement = ContractReimbursement.builder()
         .writtenById(UserUtil.getCurrentUserId())
         .writtenByName(UserUtil.getCurrentName())
         .confirmStatus(ConfirmStatusEnum.CONFIRMING.getType())
         .projectName(project.getName())
         .applyUserName(this.userService.getById(saveDTOParam.getApplyUserId()).getName())
         .applyDepartName(this.departmentService.getById(saveDTOParam.getApplyDepartId()).getName())
         .collectionUserName(this.userService.getById(saveDTOParam.getCollectionUserId()).getName())
         .build();
      BeanUtil.copy(saveDTOParam, reimbursement);
      this.baseMapper.insert(reimbursement);

      for (ReimbursementDetailSaveDTOParam save : detailList) {
         ContractReimbursementDetail detail = BeanUtil.copy(save, ContractReimbursementDetail.class);
         detail.setReimbursementId(reimbursement.getId());
         this.reimbursementDetailMapper.insert(detail);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateReimbursement(ReimbursementEditDTOParam editDTOParam) {
      ContractReimbursement reimbursement = this.baseMapper.selectById(editDTOParam.getId());
      Preconditions.checkArgument(reimbursement != null, "报销信息不存在");
      Preconditions.checkArgument(reimbursement.getConfirmStatus().equals(ConfirmStatusEnum.FAILED.getType()), "报销填报仅被确认驳回后,才能重新编辑!");
      List<ReimbursementDetailEditDTOParam> detailList = editDTOParam.getDetailList();
      if (CollectionUtils.isNotEmpty(detailList)) {
         BigDecimal sum = BigDecimal.ZERO;

         for (ReimbursementDetailEditDTOParam detailEditDTOParam : detailList) {
            sum = sum.add(detailEditDTOParam.getApplyAmount());
         }

         Preconditions.checkArgument(editDTOParam.getApplyAmount().compareTo(sum) == 0, "报销申请金额与明细申请报销金额之和不相等!");
      }

      BeanUtil.copy(editDTOParam, reimbursement);
      reimbursement.setLastEditorUserId(UserUtil.getCurrentUserId());
      reimbursement.setConfirmStatus(ConfirmStatusEnum.CONFIRMING.getType());
      reimbursement.setApplyUserName(this.userService.getById(editDTOParam.getApplyUserId()).getName());
      reimbursement.setApplyDepartName(this.departmentService.getById(editDTOParam.getApplyDepartId()).getName());
      reimbursement.setCollectionUserName(this.userService.getById(editDTOParam.getCollectionUserId()).getName());
      this.baseMapper.updateById(reimbursement);
      List<ContractReimbursementDetail> reimbursementDetailList = this.reimbursementDetailMapper
         .selectList(Wrappers.lambdaQuery(ContractReimbursementDetail.class).eq(ContractReimbursementDetail::getReimbursementId, editDTOParam.getId()));
      List<Long> oldDetailIdList = reimbursementDetailList.stream().map(ContractReimbursementDetail::getId).collect(Collectors.toList());
      List<Long> list = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(detailList)) {
         detailList.forEach(detail -> {
            if (detail.getId() == null) {
               ContractReimbursementDetail copy = BeanUtil.copy(detail, ContractReimbursementDetail.class);
               copy.setReimbursementId(editDTOParam.getId());
               this.reimbursementDetailMapper.insert(copy);
            } else {
               list.add(detail.getId());
               ContractReimbursementDetail reimbursementDetail = this.reimbursementDetailMapper.selectById(detail.getId());
               Preconditions.checkArgument(reimbursementDetail != null, "报销明细不存在!");
               BeanUtil.copy(detail, reimbursementDetail);
               this.reimbursementDetailMapper.updateById(reimbursementDetail);
            }
         });
      }

      oldDetailIdList.forEach(id -> {
         if (!list.contains(id)) {
            this.reimbursementDetailMapper.deleteById(id);
         }
      });
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean confirmReimbursement(ReimbursementConfirmDTOParam confirmDTOParam) {
      Preconditions.checkArgument(ConfirmStatusEnum.isExist(confirmDTOParam.getConfirmStatus()), "确认状态传值有误!");
      ContractReimbursement reimbursement = this.baseMapper.selectById(confirmDTOParam.getId());
      Preconditions.checkArgument(reimbursement != null, "报销单信息不存在");
      Preconditions.checkArgument(reimbursement.getConfirmStatus().equals(ConfirmStatusEnum.CONFIRMING.getType()), "该报销单已确认完毕,不允许本操作!");
      if (confirmDTOParam.getConfirmStatus().equals(ConfirmStatusEnum.SUCCEED.getType())) {
         this.checkReimbursement(confirmDTOParam);
         List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList = confirmDTOParam.getDetailConfirmDTOParamList();
         BigDecimal sum = BigDecimal.ZERO;

         for (ReimbursementDetailConfirmDTOParam detail : detailConfirmDTOParamList) {
            ContractReimbursementDetail reimbursementDetail = this.reimbursementDetailMapper.selectById(detail.getId());
            Preconditions.checkArgument(reimbursementDetail != null, "明细数据不存在");
            Preconditions.checkArgument(detail.getActuallyPayAmount() != null, "明细实付金额不存在!");
            reimbursementDetail.setActuallyPayAmount(detail.getActuallyPayAmount());
            this.reimbursementDetailMapper.updateById(reimbursementDetail);
            sum = sum.add(detail.getActuallyPayAmount());
         }

         Preconditions.checkArgument(sum.compareTo(confirmDTOParam.getActuallyPayAmount()) == 0, "报销实付金额与明细实付金额之和不相等!");
         BeanUtil.copy(confirmDTOParam, reimbursement);
      } else {
         reimbursement.setConfirmStatus(ConfirmStatusEnum.FAILED.getType());
      }

      reimbursement.setConfirmUserId(UserUtil.getCurrentUserId());
      reimbursement.setConfirmUserName(UserUtil.getCurrentName());
      reimbursement.setConfirmTime(LocalDateTime.now());
      return this.baseMapper.updateById(reimbursement) == 1;
   }

   private void checkReimbursement(ReimbursementConfirmDTOParam confirmDTOParam) {
      List<ContractReimbursementDetail> detailList = this.reimbursementDetailMapper
         .selectList(Wrappers.lambdaQuery(ContractReimbursementDetail.class).eq(ContractReimbursementDetail::getReimbursementId, confirmDTOParam.getId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailList), "报销明细列表不能为空!");
      Preconditions.checkArgument(
         confirmDTOParam.getActuallyPayAmount() != null && confirmDTOParam.getActuallyPayAmount().compareTo(BigDecimal.ZERO) >= 0, "实付金额必须存在且不能为负数!"
      );
      Preconditions.checkArgument(confirmDTOParam.getPaymentUnitId() != null, "付款单位id不能为空!");
      Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotBlank(confirmDTOParam.getPaymentUnit()), "付款单位不能为空!");
      List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList = confirmDTOParam.getDetailConfirmDTOParamList();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailConfirmDTOParamList), "确认明细列表不能为空");
      Preconditions.checkArgument(detailList.size() == detailConfirmDTOParamList.size(), "确认明细列表数据有误!");
   }
}
