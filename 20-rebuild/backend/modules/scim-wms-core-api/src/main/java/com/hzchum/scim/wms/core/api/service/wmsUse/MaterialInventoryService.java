package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveMaterialDetail;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplusDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.MaterialInventoryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelWeightDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.VirtualMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.DeviceQueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialIdsDTOParam;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MaterialInventoryService extends IService<MaterialInventory> {
   PageVO<MaterialInventoryDTO> pageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<MaterialInventoryDTO> devicePageInfo(DeviceQueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MaterialInventoryDTO> getSteelPlateDetail(QueryByMaterialDTOParam param);

   Map<String, List<MaterialInventoryDTO>> getSteelPlateDetailGroupByClassifyName(Integer basicClass, List<String> classifyNames);

   List<MaterialInventory> listInfo(QueryByMaterialDTOParam param);

   List<MaterialInventory> deviceListInfo(DeviceQueryByMaterialDTOParam param);

   MaterialInventory getByInboundDetail(InboundDetail inboundDetail);

   MaterialInventory getByBeginInboundDetail(InboundDetail inboundDetail);

   MaterialInventory getBySurplusDetail(WmsSurplusDetail WmsSurplusDetail);

   MaterialInventory getByMaterial(MaterialInventory materialInventory);

   MaterialInventory getByMoveMaterialDetail(MoveMaterialDetail wmsMoveMaterialDetail);

   MaterialInventoryDTO getMatById(Long id);

   ListVO<MaterialInventoryDTO> getByClassIds(QueryByMaterialIdsDTOParam param);

   ListVO<MaterialInventoryDTO> getMatByIds(QueryByMaterialIdsDTOParam param);

   void updateBoolHasFrozen(Long id, Boolean bool);

   BigDecimal getMeteById(Long classifyId);

   void materialMonthSummary();

   void materialMonthSummaryUser(WmsClosingTime build);

   PageVO<VirtualMaterialDTO> getVirtual(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO getInventoryDetails(Long projectId, List<Long> classifyIds, BigDecimal thickness, String spec);

   List<MaterialInventory> getInventoryDetails(Integer basicClass);

   ListVO<BriefIdAndNameDTO> getClassifyIdByPid(Integer warehouseType, Long projectId);

   ListVO<MaterialInventoryDTO> getByCondition(
      Integer warehouseType, Long classifyId, Integer basicClass, BigDecimal thickness, BigDecimal width, BigDecimal length, String spec
   );

   PageVO<MaterialInventoryDTO> pageInfoV2(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   PageVO<MaterialInventoryDTO> getMaterialList(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MaterialInventory> listInfoV2(QueryByMaterialDTOParam param);

   BigDecimal realtimeInventory(QueryByMaterialDTOParam param);

   void exportSteelMaterialsList(QueryByMaterialDTOParam param, HttpServletResponse response);

   void exportOtherMaterialsList(QueryByMaterialDTOParam param, HttpServletResponse response);

   SteelWeightDTO objectRealtimeInventory(QueryByMaterialDTOParam param);

   PageVO<MaterialInventoryDTO> nestingDockingPageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   List<MaterialInventory> nestingDockingList(QueryByMaterialDTOParam param);

   PageVO<MaterialInventoryDTO> sectionSteelNestingDockingPageInfo(QueryByMaterialDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort);

   MaterialInventory selectById(Long materialInventoryId);

   Integer getCount(LocalDateTime date);

   BigDecimal getCountLength(QueryByMaterialDTOParam param);

   List<MaterialInventoryDTO> getNumericalControlDetail(List<String> guids);

   List<MaterialInventoryDTO> getMaterialInventoryDTO1(List<MaterialInventory> materialInventories);
}
