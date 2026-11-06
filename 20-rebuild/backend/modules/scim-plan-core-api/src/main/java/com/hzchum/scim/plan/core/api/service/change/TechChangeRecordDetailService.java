package com.hzchum.scim.plan.core.api.service.change;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import java.util.List;

public interface TechChangeRecordDetailService extends IService<TechChangeRecordDetail> {
   List<TechChangeRecordDetail> listChangeRecordDetailList(List<Long> artifactIds, Integer checkStats);
}
