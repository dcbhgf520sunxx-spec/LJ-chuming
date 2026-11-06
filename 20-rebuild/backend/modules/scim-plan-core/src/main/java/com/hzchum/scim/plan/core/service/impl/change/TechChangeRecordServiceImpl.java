package com.hzchum.scim.plan.core.service.impl.change;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.change.TechChangeRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.voParam.TechChangeRecordQueryVoParam;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordService;
import com.hzchum.scim.plan.core.mapper.change.TechChangeRecordMapper;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TechChangeRecordServiceImpl extends ServiceImpl<TechChangeRecordMapper, TechChangeRecord> implements TechChangeRecordService {
   @Override
   public List<TechChangeRecordDTO> listChangeRecord(TechChangeRecordQueryVoParam param) {
      return this.baseMapper.selectChangeRecord(param);
   }

   @Override
   public void checkChangeRecordByMonomerId(Long monomerId) {
      List<TechChangeRecord> techChangeRecords = this.baseMapper
         .selectList(
            (Wrapper<TechChangeRecord>)(new LambdaQueryWrapper<TechChangeRecord>().eq(TechChangeRecord::getMonomerId, monomerId))
               .eq(TechChangeRecord::getCheckStatus, CheckStatusEnum.PENDING.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(techChangeRecords), "操作失败,该单体下存在待审核的变更记录!");
   }

   @Override
   public int getSortNumber(Long projectId, String yearMonthDay) {
      List<TechChangeRecord> recordList = this.list(Wrappers.lambdaQuery(TechChangeRecord.builder().projectId(projectId).yearMonthDay(yearMonthDay).build()));
      int sortNumber = 1;
      if (CollectionUtils.isNotEmpty(recordList)) {
         List<Integer> sortNumberList = recordList.stream().map(TechChangeRecord::getSortNumber).collect(Collectors.toList());
         Integer max = Collections.max(sortNumberList);
         sortNumber = (max >= recordList.size() ? max : recordList.size()) + 1;
      }

      return sortNumber;
   }

   @Override
   public void checkExistsChangeRecord(Long monomerId) {
      List<TechChangeRecord> techChangeRecords = this.baseMapper
         .selectList(
            (Wrapper<TechChangeRecord>)(new LambdaQueryWrapper<TechChangeRecord>().eq(TechChangeRecord::getMonomerId, monomerId))
               .eq(TechChangeRecord::getCheckStatus, CheckStatusEnum.PENDING)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(techChangeRecords), "操作失败,该单体下存在未审核的变更记录!");
   }
}
