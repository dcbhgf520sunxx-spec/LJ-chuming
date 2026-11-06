package com.hzchum.scim.crm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface CrmProjectInformationWarehousingMapper extends BaseMapper<CrmProjectInformationWarehousing> {
   CrmProjectInformationWarehousing getDetailByDelete(Long id);

   Integer getNonDirectProjectSerialNumberCount();

   List<CrmProjectInformationWarehousing> getListByUser(
      @Param("crmProjectInformationWarehousingIds") List<Long> crmProjectInformationWarehousingIds, @Param("userId") Long userId
   );

   List<CrmProjectInformationWarehousing> getListByDeptIds(
      @Param("crmProjectInformationWarehousingIds") List<Long> crmProjectInformationWarehousingIds,
      @Param("deptSet") Set<Long> deptSet,
      @Param("userId") Long userId
   );

   List<CrmProjectInformationWarehousing> listByDelete(List<Long> collect);
}
