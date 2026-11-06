package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MachinePlateBindingSaveVORequest", description = "")
public class MachinePlateBindingSaveVORequest {
   @ApiModelProperty(name = "nestCutPlateId", notes = "nestCutPlateId")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @NotNull(message = "切割指令id不能为空")
   private Long nestCutPlateId;
   @ApiModelProperty(name = "barcode", notes = "钢板编号", value = "钢板编号")
   @JsonProperty("barcode")
   @JSONField(name = "barcode")
   @NotNull(message = "钢板编号不能为空")
   private String barcode;

   public MachinePlateBindingSaveVORequest(final Long nestCutPlateId, final String barcode) {
      this.nestCutPlateId = nestCutPlateId;
      this.barcode = barcode;
   }

   public MachinePlateBindingSaveVORequest() {
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public String getBarcode() {
      return this.barcode;
   }

   @JsonProperty("nestCutPlateId")
   public MachinePlateBindingSaveVORequest setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("barcode")
   public MachinePlateBindingSaveVORequest setBarcode(final String barcode) {
      this.barcode = barcode;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePlateBindingSaveVORequest(nestCutPlateId=" + this.getNestCutPlateId() + ", barcode=" + this.getBarcode() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MachinePlateBindingSaveVORequest)) {
         return false;
      } else {
         MachinePlateBindingSaveVORequest other = (MachinePlateBindingSaveVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$nestCutPlateId = this.getNestCutPlateId();
            Object other$nestCutPlateId = other.getNestCutPlateId();
            if (this$nestCutPlateId == null ? other$nestCutPlateId == null : this$nestCutPlateId.equals(other$nestCutPlateId)) {
               Object this$barcode = this.getBarcode();
               Object other$barcode = other.getBarcode();
               return this$barcode == null ? other$barcode == null : this$barcode.equals(other$barcode);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePlateBindingSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $barcode = this.getBarcode();
      return result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
   }
}
