package com.hzchum.scim.mes.enclosure.core.server.impl.check;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecord;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.check.TechEnclosureChangeRecordDetail;
import com.hzchum.scim.mes.enclosure.core.api.service.check.MesTechEnclosureInventoryOperationService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordDetailService;
import com.hzchum.scim.mes.enclosure.core.api.service.check.TechEnclosureChangeRecordService;
import com.hzchum.scim.mes.enclosure.core.mapper.check.TechEnclosureChangeRecordMapper;
import com.hzchum.scim.plan.core.api.biz.check.TechEnclosureChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TechEnclosureChangeRecordServiceImpl
   extends ServiceImpl<TechEnclosureChangeRecordMapper, TechEnclosureChangeRecord>
   implements TechEnclosureChangeRecordService {
   @Resource
   private MesTechEnclosureInventoryOperationService enclosureInventoryOperationService;
   @Resource
   private TechEnclosureChangeRecordDetailService techEnclosureChangeRecordDetailService;

   @Override
   public void checkChangeRecordByAreaId(Long areaId) {
      List<TechEnclosureChangeRecord> techChangeRecords = this.baseMapper
         .selectList(
            (Wrapper<TechEnclosureChangeRecord>)(new LambdaQueryWrapper<TechEnclosureChangeRecord>().eq(TechEnclosureChangeRecord::getAreaId, areaId))
               .eq(TechEnclosureChangeRecord::getCheckStatus, CheckStatusEnum.PENDING.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(techChangeRecords), "操作失败,该区域下存在待审核的变更记录!");
   }

   @Override
   public void checkChangeRecordByEnclosureId(Long enclosureId) {
      List<TechEnclosureChangeRecordDetail> details = this.techEnclosureChangeRecordDetailService
         .list(Wrappers.lambdaQuery(TechEnclosureChangeRecordDetail.class).eq(TechEnclosureChangeRecordDetail::getEnclosureId, enclosureId));
      if (CollectionUtils.isNotEmpty(details)) {
         List<TechEnclosureChangeRecord> techChangeRecords = this.baseMapper
            .selectBatchIds(details.stream().map(e -> e.getChangeRecordId()).collect(Collectors.toList()));
         techChangeRecords = techChangeRecords.stream().filter(e -> e.getCheckStatus().equals(CheckStatusEnum.PENDING.getType())).collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(techChangeRecords), "操作失败,该构件存在待审核的变更记录!");
      }
   }

   @Override
   public int getSortNumber(Long projectId, String yearMonthDay) {
      List<TechEnclosureChangeRecord> recordList = this.list(
         Wrappers.lambdaQuery(TechEnclosureChangeRecord.builder().projectId(projectId).yearMonthDay(yearMonthDay).build())
      );
      int sortNumber = 1;
      if (CollectionUtils.isNotEmpty(recordList)) {
         List<Integer> sortNumberList = recordList.stream().map(TechEnclosureChangeRecord::getSortNumber).collect(Collectors.toList());
         Integer max = Collections.max(sortNumberList);
         sortNumber = (max >= recordList.size() ? max : recordList.size()) + 1;
      }

      return sortNumber;
   }

   @Override
   public List<TechEnclosureChangeRecordDTO> listChangeRecord(TechChangeRecordQueryVoParam param) {
      return this.baseMapper.selectChangeRecord(param);
   }
}
