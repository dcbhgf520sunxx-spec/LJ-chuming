package com.hzchum.scim.plan.core.service.impl.check;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import com.hzchum.scim.plan.core.mapper.check.MesTechInventoryOperationMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesTechInventoryOperationServiceImpl
   extends ServiceImpl<MesTechInventoryOperationMapper, MesTechInventoryOperation>
   implements MesTechInventoryOperationService {
   @Override
   public void checkInventoryOperationByMonomerId(Long monomerId, List<Integer> inventoryReviewedEnumList) {
      List<MesTechInventoryOperation> mesTechInventoryOperationList = this.baseMapper
         .selectList(
            (Wrapper<MesTechInventoryOperation>)(new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getMonomerId, monomerId))
               .in(MesTechInventoryOperation::getInventoryReviewedEnum, inventoryReviewedEnumList)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesTechInventoryOperationList), "操作失败,该单体下存在未审核/待确认的清单导入记录!");
   }

   @Override
   public void checkInventoryOperationByAreaId(Long areaId, List<Integer> inventoryReviewedEnumList) {
      List<MesTechInventoryOperation> mesTechInventoryOperationList = this.baseMapper
         .selectList(
            (Wrapper<MesTechInventoryOperation>)(new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getAreaId, areaId))
               .in(MesTechInventoryOperation::getInventoryReviewedEnum, inventoryReviewedEnumList)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesTechInventoryOperationList), "操作失败,该区域下存在未审核/待确认的清单导入记录!");
   }

   @Override
   public void checkInventoryOperationByAreaBatchId(Long areaBatchId, List<Integer> inventoryReviewedEnumList) {
      List<MesTechInventoryOperation> mesTechInventoryOperationList = this.baseMapper
         .selectList(
            (Wrapper<MesTechInventoryOperation>)(new LambdaQueryWrapper<MesTechInventoryOperation>().eq(MesTechInventoryOperation::getAreaBatchId, areaBatchId))
               .in(MesTechInventoryOperation::getInventoryReviewedEnum, inventoryReviewedEnumList)
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesTechInventoryOperationList), "操作失败,该批次下存在未审核/待确认的清单导入记录!");
   }
}
