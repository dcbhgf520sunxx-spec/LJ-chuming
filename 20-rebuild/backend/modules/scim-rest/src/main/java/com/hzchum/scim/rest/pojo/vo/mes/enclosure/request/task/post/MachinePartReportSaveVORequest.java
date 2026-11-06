package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
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

   public MachinePartReportSaveVORequest(final Long nestCutPlateId, final String ncCode, final Boolean reportType, final List<Long> partIds) {
      this.nestCutPlateId = nestCutPlateId;
      this.ncCode = ncCode;
      this.reportType = reportType;
      this.partIds = partIds;
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
               return this$partIds == null ? other$partIds == null : this$partIds.equals(other$partIds);
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
      return result * 59 + ($partIds == null ? 43 : $partIds.hashCode());
   }
}
