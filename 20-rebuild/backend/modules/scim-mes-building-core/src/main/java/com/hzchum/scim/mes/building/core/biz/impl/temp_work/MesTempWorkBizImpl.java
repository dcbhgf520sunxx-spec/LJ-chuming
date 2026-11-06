package com.hzchum.scim.mes.building.core.biz.impl.temp_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.temp_work.MesTempWorkBiz;
import com.hzchum.scim.mes.building.core.api.enums.temp_work.TempWorkReasonEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkRecordExcelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkRecordQuery;
import com.hzchum.scim.mes.building.core.api.service.temp_work.MesTempWorkService;
import com.hzchum.scim.mes.building.core.mapper.temp_work.MesTempWorkMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesTempWorkBizImpl extends IBizImpl<MesTempWorkService, MesTempWorkMapper, MesTempWork> implements MesTempWorkBiz {
   @Autowired
   private WmsApproveRecordService wmsApproveRecordService;

   @Override
   public PageVO<MesTempWorkDTO> myTempWork(LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.baseService.myTempWork(startDate, endDate, UserUtil.getCurrentUserId(), pageNumber, pageSize, sort);
   }

   @Override
   public MesTempWorkDTO tempWorkDetail(Long id) {
      return this.baseService.tempWorkDetail(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesTempWorkParam param) {
      return this.baseService.add(param);
   }

   @Override
   public PageVO<MesTempWorkDTO> myTempWorkApproval(Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.baseService.myTempWorkApproval(UserUtil.getCurrentUserId(), pageNumber, pageSize, sort);
   }

   @Override
   public MesTempWorkDTO tempWorkApprovalDetail(Long id) {
      return this.baseService.tempWorkApprovalDetail(id);
   }

   @Override
   public PageVO<MesTempWorkDTO> approvalRecord(Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.baseService.approvalRecord(UserUtil.getCurrentUserId(), pageNumber, pageSize, sort);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(MesTempWorkApprovalParam param) {
      return this.baseService.approval(param);
   }

   @Override
   public PageVO<MesTempWorkRecordDTO> recordPage(MesTempWorkRecordQuery query, Integer pageNumber, Integer pageSize, List<String> sortList) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sortList));
      List<MesTempWorkRecordDTO> list = this.baseMapper.recordList(query);
      if (CollUtil.isNotEmpty(list)) {
         list.forEach(
            i -> {
               WmsApproveRecordFlowDTO approveRecord = this.wmsApproveRecordService.getApproveRecordDTO(i.getApproveRecordId());
               String approvalRemark = approveRecord.getWmsApproveFlowDTOS()
                  .stream()
                  .map(
                     af -> af.getWmsApproveRecordDetailDTOS()
                        .stream()
                        .map(WmsApproveRecordDetailDTO::getOpinion)
                        .filter(CharSequenceUtil::isNotBlank)
                        .collect(Collectors.toList())
                  )
                  .flatMap(Collection::stream)
                  .filter(CharSequenceUtil::isNotBlank)
                  .collect(Collectors.joining(","));
               i.setApprovalRemark(approvalRemark);
            }
         );
      }

      return new PageVO<>(page, list);
   }

   @Override
   public Map<String, Object> recordSummary(MesTempWorkRecordQuery query) {
      query.setApprovalStatus(ReviewStatusEnum.REVIEWED.getType());
      List<MesTempWorkRecordDTO> list = this.baseMapper.recordList(query);
      BigDecimal workHour = list.stream().map(MesTempWorkRecordDTO::getWorkHour).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal calculateAmount = list.stream()
         .map(MesTempWorkRecordDTO::getCalculateAmount)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("workHour", workHour);
      resultMap.put("calculateAmount", calculateAmount);
      return resultMap;
   }

   @Override
   public Map<String, Object> recordCumulativeSummary() {
      List<MesTempWorkRecordDTO> list = this.baseMapper
         .recordList(MesTempWorkRecordQuery.builder().approvalStatus(ReviewStatusEnum.REVIEWED.getType()).build());
      BigDecimal workHour = list.stream().map(MesTempWorkRecordDTO::getWorkHour).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal calculateAmount = list.stream()
         .map(MesTempWorkRecordDTO::getCalculateAmount)
         .filter(Objects::nonNull)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Map<String, Object> resultMap = new HashMap<>();
      resultMap.put("workHour", workHour);
      resultMap.put("calculateAmount", calculateAmount);
      return resultMap;
   }

   @Override
   public void recordDownload(MesTempWorkRecordQuery query, HttpServletResponse response) {
      List<MesTempWorkRecordDTO> list = this.baseMapper.recordList(query);
      Preconditions.checkArgument(CollUtil.isNotEmpty(list), "无数据下载");
      AtomicInteger serialNumber = new AtomicInteger();
      List<MesTempWorkRecordExcelDTO> excelDTOList = list.stream()
         .map(
            i -> {
               WmsApproveRecordFlowDTO approveRecord = this.wmsApproveRecordService.getApproveRecordDTO(i.getApproveRecordId());
               String approvalRemark = approveRecord.getWmsApproveFlowDTOS()
                  .stream()
                  .map(
                     af -> af.getWmsApproveRecordDetailDTOS()
                        .stream()
                        .map(WmsApproveRecordDetailDTO::getOpinion)
                        .filter(CharSequenceUtil::isNotBlank)
                        .collect(Collectors.toList())
                  )
                  .flatMap(Collection::stream)
                  .filter(CharSequenceUtil::isNotBlank)
                  .collect(Collectors.joining(","));
               i.setApprovalRemark(approvalRemark);
               MesTempWorkRecordExcelDTO excelDTO = BeanUtil.toBean(i, MesTempWorkRecordExcelDTO.class);
               excelDTO.setSerialNumber(serialNumber.incrementAndGet());
               excelDTO.setReporterName(i.getReporter().getName());
               excelDTO.setTeamName(i.getTeam().getName());
               String tempWorkQuotaConfigName = i.getTempWorkQuotaConfig() != null ? i.getTempWorkQuotaConfig().getName() : null;
               excelDTO.setTempWorkQuotaConfigName(tempWorkQuotaConfigName);
               excelDTO.setReasonName(TempWorkReasonEnum.getName(i.getReason()));
               excelDTO.setProjectShow(StrUtil.format("{} {}", i.getProject().getSerialNumber(), i.getProject().getShortName()));
               excelDTO.setApprovalStatusName(ReviewStatusEnum.getName(i.getApprovalStatus()));
               return excelDTO;
            }
         )
         .collect(Collectors.toList());
      String title = "点工记录";
      String fileName = title + System.currentTimeMillis() + ".xlsx";
      PoiUtils.exportExcel(excelDTOList, title, title, MesTempWorkRecordExcelDTO.class, fileName, response);
   }
}
