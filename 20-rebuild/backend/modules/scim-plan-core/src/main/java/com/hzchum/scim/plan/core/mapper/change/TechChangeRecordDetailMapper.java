package com.hzchum.scim.plan.core.mapper.change;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechChangeRecordDetailMapper extends BaseMapper<TechChangeRecordDetail> {
   List<TechChangeRecordDetail> listChangeRecordDetailList(@Param("artifactIds") List<Long> artifactIds, @Param("checkStatus") Integer checkStatus);
}
