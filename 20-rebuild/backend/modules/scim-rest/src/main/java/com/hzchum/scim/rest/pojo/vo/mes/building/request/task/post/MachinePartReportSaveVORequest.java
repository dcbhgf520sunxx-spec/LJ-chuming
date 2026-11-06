package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.machine_part_raw_material.MachinePartReportRawMaterialFeedingRecordParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ReportSaveVORequest", description = "")
public class MachinePartReportSaveVORequest {
   @ApiModelProperty(name = "nestCutPlateId", notes = "nestCutPlateId")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   private Long nestCutPlateId;
   @ApiModelProperty(name = "ncCode", notes = "ncCode")
   @JsonProperty("ncCode")
   @JSONField(name = "ncCode")
   private String ncCode;
   @ApiModelProperty(name = "reportType", notes = "上报类型 0正常上报 1异常上报", value = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Boolean reportType;
   @ApiModelProperty(name = "partIds", notes = "上报零件id", value = "上报零件id")
   @JsonProperty("partIds")
   @JSONField(name = "partIds")
   private List<Long> partIds;
   @ApiModelProperty(name = "parts", notes = "上报零件详细信息", value = "上报零件详细信息")
   @JsonProperty("parts")
   @JSONField(name = "parts")
   private List<IdAndRecelveQuantityDTO> parts;
   @ApiModelProperty("零件原料List")
   private List<MachinePartReportRawMaterialFeedingRecordParam> rawMaterialList;

   public MachinePartReportSaveVORequest(
      final Long nestCutPlateId,
      final String ncCode,
      final Boolean reportType,
      final List<Long> partIds,
      final List<IdAndRecelveQuantityDTO> parts,
      final List<MachinePartReportRawMaterialFeedingRecordParam> rawMaterialList
   ) {
      this.nestCutPlateId = nestCutPlateId;
      this.ncCode = ncCode;
      this.reportType = reportType;
      this.partIds = partIds;
      this.parts = parts;
      this.rawMaterialList = rawMaterialList;
   }

   public MachinePartReportSaveVORequest() {
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public String getNcCode() {
      return this.ncCode;
   }

   public Boolean getReportType() {
      return this.reportType;
   }

   public List<Long> getPartIds() {
      return this.partIds;
   }

   public List<IdAndRecelveQuantityDTO> getParts() {
      return this.parts;
   }

   public List<MachinePartReportRawMaterialFeedingRecordParam> getRawMaterialList() {
      return this.rawMaterialList;
   }

   @JsonProperty("nestCutPlateId")
   public MachinePartReportSaveVORequest setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("ncCode")
   public MachinePartReportSaveVORequest setNcCode(final String ncCode) {
      this.ncCode = ncCode;
      return this;
   }

   @JsonProperty("reportType")
   public MachinePartReportSaveVORequest setReportType(final Boolean reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("partIds")
   public MachinePartReportSaveVORequest setPartIds(final List<Long> partIds) {
      this.partIds = partIds;
      return this;
   }

   @JsonProperty("parts")
   public MachinePartReportSaveVORequest setParts(final List<IdAndRecelveQuantityDTO> parts) {
      this.parts = parts;
      return this;
   }

   public MachinePartReportSaveVORequest setRawMaterialList(final List<MachinePartReportRawMaterialFeedingRecordParam> rawMaterialList) {
      this.rawMaterialList = rawMaterialList;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartReportSaveVORequest(nestCutPlateId="
         + this.getNestCutPlateId()
         + ", ncCode="
         + this.getNcCode()
         + ", reportType="
         + this.getReportType()
         + ", partIds="
         + this.getPartIds()
         + ", parts="
         + this.getParts()
         + ", rawMaterialList="
         + this.getRawMaterialList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartReportSaveVORequest)) {
         return false;
      }

      MachinePartReportSaveVORequest other = (MachinePartReportSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$nestCutPlateId = this.getNestCutPlateId();
      Object other$nestCutPlateId = other.getNestCutPlateId();
      if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
         Object this$reportType = this.getReportType();
         Object other$reportType = other.getReportType();
         if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
            Object this$ncCode = this.getNcCode();
            Object other$ncCode = other.getNcCode();
            if (this$ncCode == null ? other$ncCode == null : this$ncCode.equals(other$ncCode)) {
               Object this$partIds = this.getPartIds();
               Object other$partIds = other.getPartIds();
               if (this$partIds == null ? other$partIds == null : this$partIds.equals(other$partIds)) {
                  Object this$parts = this.getParts();
                  Object other$parts = other.getParts();
                  if (this$parts == null ? other$parts == null : this$parts.equals(other$parts)) {
                     Object this$rawMaterialList = this.getRawMaterialList();
                     Object other$rawMaterialList = other.getRawMaterialList();
                     return this$rawMaterialList == null ? other$rawMaterialList == null : this$rawMaterialList.equals(other$rawMaterialList);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $ncCode = this.getNcCode();
      result = result * 59 + ($ncCode == null ? 43 : $ncCode.hashCode());
      Object $partIds = this.getPartIds();
      result = result * 59 + ($partIds == null ? 43 : $partIds.hashCode());
      Object $parts = this.getParts();
      result = result * 59 + ($parts == null ? 43 : $parts.hashCode());
      Object $rawMaterialList = this.getRawMaterialList();
      return result * 59 + ($rawMaterialList == null ? 43 : $rawMaterialList.hashCode());
   }
}
