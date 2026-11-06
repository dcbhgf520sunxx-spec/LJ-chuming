package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.CommonDetailsDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ReturnDetailService;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ReturnDetailServiceImpl extends ServiceImpl<ReturnDetailMapper, ReturnDetail> implements ReturnDetailService {
   @Resource
   ClassificationService classificationService;

   @Override
   public List<BasicClassMeteAndAmountDTO> selectCountMeteAndAmount(
      List<Integer> basicClassList,
      List<Long> projectIds,
      Integer reviewStatus,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds
   ) {
      DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
      List<String> yearMonthListStr = new ArrayList<>();

      for (LocalDate localDate : yearMonthList) {
         yearMonthListStr.add(yyyyMM.format(localDate));
      }

      List<BasicClassMeteAndAmountDTO> basicClassMeteAndAmountDTOS = this.baseMapper
         .selectCountMeteAndAmount(basicClassList, projectIds, reviewStatus, yearMonthListStr, notClassifyIds, getClassifyIds);
      return basicClassMeteAndAmountDTOS;
   }

   @Override
   public List<CommonDetailsDO> groupReturnDetail(
      List<Integer> basicClassList,
      Long projectId,
      List<LocalDate> yearMonthList,
      List<Long> notClassifyIds,
      List<Long> getClassifyIds,
      List<String> notClassifyNameList,
      List<String> getClassifyNameList
   ) {
      List<Long> notClassifyIdsNew = this.classificationService.getClassifyIdsByName(notClassifyNameList);
      if (CollectionUtils.isEmpty(notClassifyIds)) {
         notClassifyIds = new ArrayList<>();
      }

      notClassifyIds.addAll(notClassifyIdsNew);
      List<Long> getClassifyIdsNew = this.classificationService.getClassifyIdsByName(getClassifyNameList);
      if (CollectionUtils.isEmpty(getClassifyIds)) {
         getClassifyIds = new ArrayList<>();
      }

      getClassifyIds.addAll(getClassifyIdsNew);
      DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
      List<String> yearMonthListStr = new ArrayList<>();

      for (LocalDate localDate : yearMonthList) {
         yearMonthListStr.add(yyyyMM.format(localDate));
      }

      List<CommonDetailsDO> returnDetailDOS = this.baseMapper
         .groupReturnDetail(basicClassList, projectId, ReviewStatusEnum.REVIEWED.getType(), yearMonthListStr, notClassifyIds, getClassifyIds);

      for (CommonDetailsDO returnDetailDO : returnDetailDOS) {
         DownLoadDetailDO detailDO = BeanUtil.toBean(returnDetailDO, DownLoadDetailDO.class);
         returnDetailDO.setBoolWeighting(ObjectUtil.isNotEmpty(detailDO.getUnitPrice()));
         ReceiptDownloadServiceImpl receiptDownloadService = new ReceiptDownloadServiceImpl();
         StringBuilder sb = new StringBuilder();
         StringBuilder lengths = new StringBuilder();
         StringBuilder material = new StringBuilder();
         receiptDownloadService.setSpecs(detailDO, sb, lengths, material);
         StringBuilder model = new StringBuilder();
         if (ObjectUtil.isNotEmpty(sb)) {
            model.append(sb);
         }

         if (ObjectUtil.isNotEmpty(lengths)) {
            model.append("*").append(lengths);
         }

         returnDetailDO.setSpecification(model.toString());
         returnDetailDO.setModel(material.toString());
      }

      return returnDetailDOS;
   }

   @Override
   public List<ReturnDetailDO> selectPassDetail(Long workshopId, LocalDateTime startDay, LocalDateTime endDay) {
      return this.baseMapper.selectPassDetail(workshopId, startDay, endDay);
   }
}
