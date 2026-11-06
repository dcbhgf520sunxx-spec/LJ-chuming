package com.hzchum.scim.plan.core.api.service.check;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import java.util.List;

public interface MesTechInventoryOperationService extends IService<MesTechInventoryOperation> {
   void checkInventoryOperationByMonomerId(Long monomerId, List<Integer> inventoryReviewedEnumList);

   void checkInventoryOperationByAreaId(Long areaId, List<Integer> inventoryReviewedEnumList);

   void checkInventoryOperationByAreaBatchId(Long areaBatchId, List<Integer> inventoryReviewedEnumList);
}
