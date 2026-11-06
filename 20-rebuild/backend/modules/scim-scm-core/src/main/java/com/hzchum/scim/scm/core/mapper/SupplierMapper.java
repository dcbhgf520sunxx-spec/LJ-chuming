package com.hzchum.scim.scm.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper extends BaseMapper<Supplier> {
   Integer getCountByDate();

   List<SupplierPayableSummaryDTO> selectPayableOnSupplier(
      @Param("supplierName") String supplierName, @Param("supplierClassification") Integer supplierClassification
   );

   List<Supplier> getList(Integer basicClass);
}
