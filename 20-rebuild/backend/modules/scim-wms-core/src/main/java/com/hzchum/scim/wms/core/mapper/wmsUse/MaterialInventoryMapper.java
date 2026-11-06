package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.VirtualMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryStatisticsDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceQueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.ReturnableMaterialInventoryDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface MaterialInventoryMapper extends BaseMapper<MaterialInventory> {
   MaterialInventory getByInboundDetail(InboundDetail inboundDetail);

   MaterialInventory getByBeginInboundDetail(InboundDetail inboundDetail);

   MaterialInventory getByMoveOutboundDetail(MoveOutboundDetail moveOutboundDetail);

   MaterialInventory getByMaterial(MaterialInventory materialInventory);

   MaterialInventory getBySurplusDetail(WmsSurplusDetail WmsSurplusDetail);

   MaterialInventory getByMoveMaterialDetail(MoveMaterialDetail wmsMoveMaterialDetail);

   MaterialInventory getByTransfer(@Param("d") InboundDetail inboundDetail, @Param("m") Integer materialIsWhole);

   MaterialInventory getByMoveMaterial(@Param("d") InboundDetail inboundDetail, @Param("m") Integer materialIsWhole);

   List<MaterialInventory> getRejectMat(InboundDetail inboundDetail);

   MaterialInventory getByMi(MaterialInventory materialInventory);

   List<MaterialInventory> getReturnableMaterialInventory(ReturnableMaterialInventoryDTOParam param);

   List<MaterialInventory> listInfo(QueryByMaterialDTOParam param);

   List<MaterialInventory> getSteelPlateDetailGroupByClassifyName(Integer basicClass, List<String> classifyNames);

   List<MaterialInventory> listInfoForDevice(DeviceQueryByMaterialDTOParam param);

   List<MaterialInventory> listInfoV2(QueryByMaterialDTOParam param);

   List<MaterialInventory> listInfoForMes(QueryByMaterialDTOParam param);

   void updateBoolHasFrozen(@Param("id") Long id, @Param("bool") Boolean bool);

   List<Long> getWapId(QueryStatisticsDTOParam param);

   BigDecimal getMeteById(Long classifyId);

   List<MaterialInventory> getMaterialMatchInfo(
      @Param("basicClass") Integer basicClass,
      @Param("projectWarehouseType") Integer projectWarehouseType,
      @Param("classifyId") Long classifyId,
      @Param("specification") String specification,
      @Param("color") String color,
      @Param("brand") String brand,
      @Param("unitNet") BigDecimal unitNet
   );

   List<MaterialInventory> getMaterialMatchByParam(
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("classifyIds") List<Long> classifyIds,
      @Param("basicClass") Integer basicClass
   );

   Map<String, BigDecimal> getTotalQuantity(
      @Param("classificationId") Long classificationId, @Param("workshopId") Long workshopId, @Param("specification") String specification
   );

   List<VirtualMaterialDTO> getVirtual(QueryByMaterialDTOParam param);

   BigDecimal getTotalMete(
      @Param("classifyIds") List<Long> classifyIds, @Param("projectId") Long projectId, @Param("spec") String spec, @Param("thickness") BigDecimal thickness
   );

   List<MaterialInventoryDTO> getTotalInventory(Integer basicClass, List<Long> ids, Integer orderSupplyType, List<Long> workshopIds, String specification);

   List<MaterialInventoryDTO> getTotalInventoryNew(Integer basicClass, Long factoryId, Long workshopId);

   List<MaterialInventoryDTO> getPSIInventoryDetail(
      @Param("classifyId") Long classifyId,
      @Param("spec") String spec,
      @Param("width") BigDecimal width,
      @Param("length") BigDecimal length,
      @Param("thickness") BigDecimal thickness
   );

   List<MaterialInventoryDTO> getPSIInventoryDetailByClassifyIds(@Param("classifyIds") List<Long> classifyIds);

   List<MaterialInventoryDTO> getByCondition(
      @Param("warehouseType") Integer warehouseType,
      @Param("classifyId") Long classifyId,
      @Param("thickness") BigDecimal thickness,
      @Param("spec") String spec,
      @Param("basicClass") Integer basicClass
   );

   BigDecimal realtimeInventory(QueryByMaterialDTOParam param);

   List<MaterialInventory> nestingDockingList(QueryByMaterialDTOParam param);

   Integer getCount(LocalDateTime date);

   MaterialInventory selectByIdIncludeDel(Long id);

   List<MaterialInventory> selectAllByIds(List<Long> ids);
}
