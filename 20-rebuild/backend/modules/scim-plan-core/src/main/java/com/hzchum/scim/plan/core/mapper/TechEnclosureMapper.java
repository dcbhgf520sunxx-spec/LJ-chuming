package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.ProjectSchedulingTreeDO;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureFreezeOrNotDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureListQueryDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureResponseDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSimpleSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.EnclosureSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProductDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectOverviewStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mes.enclosure.EnclosureProjectSchedulingStateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.EnclosureCategoryMeteDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.product.ProductMeteGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.ArtifactSimpleVO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechEnclosureMapper extends BaseMapper<TechEnclosure> {
   List<EnclosureResponseDTO> selectListByConditions(EnclosureListQueryDTOParam param);

   List<EnclosureSumDTO> selectSumTrussFloorPlate(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("category") Integer category);

   List<EnclosureSumDTO> selectSumPressurePlate(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("category") Integer category);

   List<EnclosureSumDTO> selectSumSandwich(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("category") Integer category);

   List<EnclosureSumDTO> selectSumFlangPiece(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("category") Integer category);

   EnclosureSimpleSumDTO selectSumLengthQuantity(EnclosureListQueryDTOParam param);

   EnclosureSimpleSumDTO selectSumLengthQuantity2(EnclosureListQueryDTOParam param);

   ProductMeteDTO sumMete(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<EnclosureCategoryMeteDTO> sumCategoryMete(@Param("projectId") Long projectId);

   List<EnclosureCategoryMeteDTO> sumCategoryByAreaId(Long areaId);

   BigDecimal getTotalArea(@Param("areaId") Long areaId, @Param("productType") Integer productType);

   List<ProductMeteGroupDTO> sumMeteGroupByMonomerId(
      @Param("projectId") Long projectId, @Param("category") Integer category, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   List<ProductMeteGroupDTO> sumMeteGroupByAreaId(
      @Param("monomerId") Long monomerId, @Param("category") Integer category, @Param("permissionCheck") Integer permissionCheck, @Param("userId") Long userId
   );

   TechEnclosure selectByIdIgnoreDelete(Long id);

   List<EnclosureProjectSchedulingStateDTO> listByType(@Param("year") Integer year, @Param("name") String name);

   List<EnclosureProjectOverviewStateDTO> getProjectOverview(@Param("projectIds") List<Long> projectIds);

   List<EnclosureProductDetailDTO> getproductDetaile(@Param("planIds") List<Long> planIds, @Param("status") Integer status, @Param("category") Integer category);

   List<EnclosureProductDetailDTO> getproductDetaileV2(
      @Param("areaIds") List<Long> areaIds, @Param("status") Integer status, @Param("dictionaryId") Long dictionaryId
   );

   List<EnclosureFreezeOrNotDTO> findFreezeStatusByOrder(@Param("orderIds") List<Long> orderIds);

   List<ProjectSchedulingTreeDO> getSchedulingTree(@Param("year") Integer year, @Param("name") String name);

   List<ArtifactSimpleVO> getEnclosure(
      @Param("serialNumber") String serialNumber, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );
}
