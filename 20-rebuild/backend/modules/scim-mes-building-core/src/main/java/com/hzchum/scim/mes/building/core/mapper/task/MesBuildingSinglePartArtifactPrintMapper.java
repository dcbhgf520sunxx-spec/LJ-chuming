package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartArtifactPrintDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.SinglePartReportDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingSinglePartArtifactPrintMapper extends BaseMapper<MesBuildingSinglePartArtifactPrint> {
   List<SinglePartArtifactPrintDTO> getPrintList(
      @Param("printType") Integer printType,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   List<SinglePartArtifactPrintDTO> record(
      @Param("singId") Long singId,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("userName") String userName
   );

   List<MesBuildingSinglePartArtifactPrint> listByProductIds(@Param("checks") List<SinglePartReportDTO> checks);

   List<MesBuildingSinglePartArtifactPrint> listBydata(@Param("numberInfos") List<NumberInfoDTO> numberInfoDTOS);
}
