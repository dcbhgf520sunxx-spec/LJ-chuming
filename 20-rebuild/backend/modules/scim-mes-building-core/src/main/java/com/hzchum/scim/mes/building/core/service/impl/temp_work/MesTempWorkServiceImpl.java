package com.hzchum.scim.mes.building.core.service.impl.temp_work;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.mes.building.core.api.enums.temp_work.TempWorkReasonEnum;
import com.hzchum.scim.mes.building.core.api.enums.wage_quota.TempWorkQuotaConfigTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkQuery;
import com.hzchum.scim.mes.building.core.api.service.temp_work.MesTempWorkService;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesTempWorkQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.temp_work.MesTempWorkMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesTempWorkServiceImpl extends ServiceImpl<MesTempWorkMapper, MesTempWork> implements MesTempWorkService {
   @Autowired
   private MesTempWorkQuotaConfigService tempWorkQuotaConfigService;
   @Autowired
   private WmsApproveRecordService wmsApproveRecordService;

   @Override
   public List<MesTempWorkDTO> listInfo(MesTempWorkQuery query) {
      return this.baseMapper.listInfo(query);
   }

   @Override
   public MesTempWorkDTO detailById(Long id) {
      MesTempWorkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(dto), "数据不存在, 请刷新后重试");
      WmsApproveRecordFlowDTO approveRecord = this.wmsApproveRecordService.getApproveRecordDTO(dto.getApproveRecordId());
      dto.setApproveRecord(approveRecord);
      return dto;
   }

   @Override
   public PageVO<MesTempWorkDTO> myTempWork(LocalDate startDate, LocalDate endDate, Long reporterId, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTempWorkDTO> list = this.listInfo(MesTempWorkQuery.builder().startDate(startDate).endDate(endDate).reporterId(reporterId).build());
      return new PageVO<>(page, list);
   }

   @Override
   public MesTempWorkDTO tempWorkDetail(Long id) {
      return this.detailById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesTempWorkParam param) {
      if (TempWorkReasonEnum.PROJECT.getType().equals(param.getReason())) {
         Preconditions.checkArgument(param.getProjectId() != null, "项目不能为空");
      }

      MesTempWorkQuotaConfig quotaConfig = this.tempWorkQuotaConfigService.getById(param.getTempWorkQuotaConfigId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(quotaConfig), "点工类别不存在");
      MesTempWork tempWork = BeanUtil.toBean(param, MesTempWork.class);
      if (TempWorkQuotaConfigTypeEnum.HOURLY_WAGE.getType().equals(quotaConfig.getType())) {
         tempWork.setPrice(quotaConfig.getPrice());
         Duration duration = Duration.ofMillis(tempWork.getWorkMilliseconds());
         BigDecimal hours = BigDecimal.valueOf(duration.toHours()).add(BigDecimal.valueOf(duration.toMinutes() % 60L / 60.0));
         tempWork.setAmount(hours.multiply(tempWork.getPrice()));
      }

      this.save(tempWork);
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(tempWork.getId(), null, ApproveProcessTypeEnumV2.MES_TEMP_WORKER_MANAGE_ADD.getType(), null, null, null, true, null, null, null);
      tempWork.setApproveRecordId(wmsApproveRecord.getId());
      tempWork.setApproveRecordSerialNumber(wmsApproveRecord.getSerialNumber());
      tempWork.setApprovalStatus(wmsApproveRecord.getReviewStatus());
      this.updateById(tempWork);
      return true;
   }

   @Override
   public PageVO<MesTempWorkDTO> myTempWorkApproval(Long approverId, Integer pageNumber, Integer pageSize, List<String> sort) {
      List<Integer> approvalStatusList = Arrays.asList(ReviewStatusEnum.UN_REVIEWED.getType(), ReviewStatusEnum.AUDITING.getType());
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTempWorkDTO> list = this.listInfo(
         MesTempWorkQuery.builder()
            .approverId(approverId)
            .approvalStatusList(approvalStatusList)
            .approveRecordDetailStatus(ApproveRecordStatusEnum.UNDERWAY.getType())
            .build()
      );
      return new PageVO<>(page, list);
   }

   @Override
   public MesTempWorkDTO tempWorkApprovalDetail(Long id) {
      return this.detailById(id);
   }

   @Override
   public PageVO<MesTempWorkDTO> approvalRecord(Long approverId, Integer pageNumber, Integer pageSize, List<String> sort) {
      List<Integer> approvalStatusList = Arrays.asList(ReviewStatusEnum.REVIEWED.getType(), ReviewStatusEnum.RETURNED.getType());
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesTempWorkDTO> list = this.listInfo(MesTempWorkQuery.builder().approverId(approverId).approvalStatusList(approvalStatusList).build());
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(MesTempWorkApprovalParam param) {
      MesTempWork tempWork = this.getById(param.getTempWorkId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(tempWork), "数据不存在, 请刷新后重试");
      tempWork.setCalculateAmount(param.getCalculateAmount());
      Boolean approvalResult = this.wmsApproveRecordService
         .commonApproveStep(param.getTempWorkId(), param.getApprovalResult(), param.getRemark(), tempWork.getApproveRecordSerialNumber(), null);
      if (approvalResult) {
         tempWork.setApprovalStatus(param.getApprovalResult());
         tempWork.setApprovalUserId(UserUtil.getCurrentUserId());
         tempWork.setApprovalTime(LocalDateTime.now());
      }

      this.updateById(tempWork);
      return true;
   }
}
