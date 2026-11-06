package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureProduceInspectionTeamReportSaveVORequest", description = "")
public class MesEnclosureProduceInspectionTeamReportSaveVORequest {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "teamId", value = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "生产班组id不能为空")
   private Long teamId;
   @ApiModelProperty(name = "reportQuantity", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @NotNull(message = "上报数量不能为空")
   private Integer reportQuantity;

   public MesEnclosureProduceInspectionTeamReportSaveVORequest(final Long id, final Long teamId, final Integer reportQuantity) {
      this.id = id;
      this.teamId = teamId;
      this.reportQuantity = reportQuantity;
   }

   public MesEnclosureProduceInspectionTeamReportSaveVORequest() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   @JsonProperty("id")
   public MesEnclosureProduceInspectionTeamReportSaveVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureProduceInspectionTeamReportSaveVORequest setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("reportQuantity")
   public MesEnclosureProduceInspectionTeamReportSaveVORequest setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProduceInspectionTeamReportSaveVORequest(id="
         + this.getId()
         + ", teamId="
         + this.getTeamId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProduceInspectionTeamReportSaveVORequest)) {
         return false;
      }

      MesEnclosureProduceInspectionTeamReportSaveVORequest other = (MesEnclosureProduceInspectionTeamReportSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamId = this.getTeamId();
         Object other$teamId = other.getTeamId();
         if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
            Object this$reportQuantity = this.getReportQuantity();
            Object other$reportQuantity = other.getReportQuantity();
            return this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProduceInspectionTeamReportSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      return result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
   }
}
