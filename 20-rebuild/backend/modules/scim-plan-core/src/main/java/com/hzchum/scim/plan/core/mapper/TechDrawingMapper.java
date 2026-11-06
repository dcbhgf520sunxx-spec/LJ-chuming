package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.PicturePathDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechCappCraftCardProductWeldingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechCappCraftCardProductWeldingMapDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechDrawingDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.WeldMapDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.AreaDrawingDetailsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.InstructionLinkDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.drawing.ProductDrawingsSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.mark.WeldDetailsDTO;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechDrawingMapper extends BaseMapper<TechDrawing> {
   List<TechDrawing> getByMonomerIdAndTypeAndSerialNumber(
      @Param("monomerId") Long monomerId,
      @Param("dataType") Integer dataType,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("number") Integer number,
      @Param("areaId") Long areaId
   );

   List<DrawingDTO> listByConditions(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("serialNumber") String serialNumber,
      @Param("fileName") String fileName,
      @Param("projectType") Integer projectType,
      @Param("dataType") Integer dataType,
      @Param("productType") Integer productType
   );

   List<ProductDrawingsSummaryDTO> getArtifactDwg(
      @Param("projectId") Long projectId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("dataType") Integer dataType,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("monomerId") Long monomerId
   );

   List<ProductDrawingsSummaryDTO> getArtifactV2Dwg(
      @Param("projectId") Long projectId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("dataType") Integer dataType,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId
   );

   List<String> findDwg(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("dataType") Integer dataType,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );

   List<AreaDrawingDetailsDTO> contrast(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("dataType") Integer dataType,
      @Param("sign") Boolean sign,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("userName") String userName,
      @Param("drawingMatchRange") Integer drawingMatchRange
   );

   List<ProductDrawingsSummaryDTO> getArtifactDeepDwg(
      @Param("projectId") Long projectId, @Param("productType") Integer productType, @Param("dataType") Integer dataType
   );

   List<TechDrawingDTO> selectByType(
      @Param("monomerId") Long monomerId,
      @Param("serialNumbers") List<String> serialNumbers,
      @Param("dataType") Integer dataType,
      @Param("productType") Integer productType,
      @Param("drawingMatchRange") Integer drawingMatchRange,
      @Param("areaId") Long areaId
   );

   List<InstructionLinkDTO> InstructionLink(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("dataType") Integer dataType,
      @Param("drawingid") Integer drawingid
   );

   List<PicturePathDTO> selectMachDrawing(@Param("machinePartIds") List<Long> machinePartIds, @Param("drawingMatchRange") Integer drawingMatchRange);

   List<PicturePathDTO> bridgeSelectMachDrawing(List<Long> machinePartIds);

   List<WeldDetailsDTO> weldContrast(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("dataType") Integer dataType,
      @Param("sign") Boolean sign,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("userName") String userName,
      @Param("drawingMatchRange") Integer drawingMatchRange
   );

   List<TechCappCraftCardProductWeldingDTO> selectWeldByType(
      Long monomerId, ArrayList<String> serialNumbers, Integer dataType, Integer productType, Integer drawingMatchRange, Long areaId
   );

   List<String> findWeld(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("dataType") Integer dataType,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum
   );

   List<String> findWeldMap(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("dataType") Integer dataType,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("serialNumbers") List<String> serialNumbers
   );

   List<WeldMapDetailsDTO> weldMapContrast(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("projectType") Integer projectType,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("dataType") Integer dataType,
      @Param("sign") Boolean sign,
      @Param("steelPlateTypeEnum") Integer steelPlateTypeEnum,
      @Param("userName") String userName,
      @Param("drawingMatchRange") Integer drawingMatchRange
   );

   List<TechCappCraftCardProductWeldingMapDTO> selectWeldMapByType(
      Long monomerId, ArrayList<String> serialNumbers, Integer dataType, Integer productType, Integer drawingMatchRange, Long areaId
   );
}
