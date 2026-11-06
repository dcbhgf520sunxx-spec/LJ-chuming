package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechProductSummary;
import com.hzchum.scim.plan.core.api.pojo.dto.record.ProductSummaryDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechProductSummaryMapper extends BaseMapper<TechProductSummary> {
   List<ProductSummaryDTO> listByProjectId(@Param("projectId") Long projectId, @Param("productType") Integer productType, @Param("category") Integer category);

   List<ProductSummaryDTO> listByMonomerId(@Param("monomerId") Long monomerId, @Param("productType") Integer productType, @Param("category") Integer category);
}
