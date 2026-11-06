package com.hzchum.scim.mes.building.core.mapper.wage_manage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesCoatingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesCoatingProcessDTO;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesCoatingProcessMapper extends BaseMapper<MesCoatingProcess> {
   List<MesCoatingProcessDTO> listInfo(@Param("contractProjectId") Long contractProjectId);

   List<MesCoatingProcessDTO> listInfoByContractProjectIds(@Param("contractProjectIds") List<Long> contractProjectIds);

   MesCoatingProcessDTO detailById(@Param("id") Long id);

   Integer getMaxSerialNumber();

   List<MesCoatingProcessArtifactTypeDTO> artifactTypeList(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<MesCoatingProcessArtifactDTO> artifactList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("artifactTypeId") Long artifactTypeId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material
   );

   List<MesCoatingProcessArtifactDTO> coatingProcessArtifactList(
      @Param("id") Long id,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material
   );

   List<MesCoatingProcessArtifactDTO> coatingProcessArtifactDetailList(
      @Param("id") Long id, @Param("artifactId") Long artifactId, @Param("area") BigDecimal area, @Param("boolProduced") Boolean boolProduced
   );
}
