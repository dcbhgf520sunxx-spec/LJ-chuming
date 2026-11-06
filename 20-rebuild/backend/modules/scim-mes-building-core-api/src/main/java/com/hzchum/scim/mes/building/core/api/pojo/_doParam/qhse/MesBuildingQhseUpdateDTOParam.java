package com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingQhseUpdateRequest", description = "修改qhse")
public class MesBuildingQhseUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "status", value = "status")
   @JsonProperty("status")
   @JSONField(name = "status")
   @NotNull(message = "状态不能为空")
   private Long status;
   @ApiModelProperty(name = "refuseRemark", value = "拒绝备注")
   @JsonProperty("refuseRemark")
   @JSONField(name = "refuseRemark")
   private String refuseRemark;

   public static MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder builder() {
      return new MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder();
   }

   public MesBuildingQhseUpdateDTOParam(final Long id, final Long status, final String refuseRemark) {
      this.id = id;
      this.status = status;
      this.refuseRemark = refuseRemark;
   }

   public MesBuildingQhseUpdateDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getStatus() {
      return this.status;
   }

   public String getRefuseRemark() {
      return this.refuseRemark;
   }

   @JsonProperty("id")
   public MesBuildingQhseUpdateDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhseUpdateDTOParam setStatus(final Long status) {
      this.status = status;
      return this;
   }

   @JsonProperty("refuseRemark")
   public MesBuildingQhseUpdateDTOParam setRefuseRemark(final String refuseRemark) {
      this.refuseRemark = refuseRemark;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseUpdateDTOParam(id=" + this.getId() + ", status=" + this.getStatus() + ", refuseRemark=" + this.getRefuseRemark() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseUpdateDTOParam)) {
         return false;
      }

      MesBuildingQhseUpdateDTOParam other = (MesBuildingQhseUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$refuseRemark = this.getRefuseRemark();
            Object other$refuseRemark = other.getRefuseRemark();
            return this$refuseRemark == null ? other$refuseRemark == null : this$refuseRemark.equals(other$refuseRemark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingQhseUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $refuseRemark = this.getRefuseRemark();
      return result * 59 + ($refuseRemark == null ? 43 : $refuseRemark.hashCode());
   }

   public static class MesBuildingQhseUpdateDTOParamBuilder {
      private Long id;
      private Long status;
      private String refuseRemark;

      MesBuildingQhseUpdateDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder status(final Long status) {
         this.status = status;
         return this;
      }

      @JsonProperty("refuseRemark")
      public MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder refuseRemark(final String refuseRemark) {
         this.refuseRemark = refuseRemark;
         return this;
      }

      public MesBuildingQhseUpdateDTOParam build() {
         return new MesBuildingQhseUpdateDTOParam(this.id, this.status, this.refuseRemark);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseUpdateDTOParam.MesBuildingQhseUpdateDTOParamBuilder(id="
            + this.id
            + ", status="
            + this.status
            + ", refuseRemark="
            + this.refuseRemark
            + ")";
      }
   }
}
