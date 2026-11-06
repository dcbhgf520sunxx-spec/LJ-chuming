package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CargoListCheckDTOParam extends CargoListLogisticsInfo {
   @ApiModelProperty("发货清单id")
   @NotNull(message = "发货清单id不能为空")
   public Long id;
   @ApiModelProperty(name = "actualWeight", value = "过磅净量", notes = "过磅净量")
   @NotNull(message = "过磅净量不能为空")
   @Min(value = 0L, message = "过磅净量必须大于0")
   private BigDecimal actualWeight;
   @ApiModelProperty(name = "actualWeight", value = "过磅毛重", notes = "过磅毛重")
   @NotNull(message = "过磅毛重不能为空")
   @Min(value = 0L, message = "过磅毛重须大于0")
   private BigDecimal actualGrossWeight;
   @ApiModelProperty("证据拍照附件id")
   private List<Long> attachmentIds;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public BigDecimal getActualGrossWeight() {
      return this.actualGrossWeight;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setActualGrossWeight(final BigDecimal actualGrossWeight) {
      this.actualGrossWeight = actualGrossWeight;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListCheckDTOParam)) {
         return false;
      }

      CargoListCheckDTOParam other = (CargoListCheckDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$actualWeight = this.getActualWeight();
         Object other$actualWeight = other.getActualWeight();
         if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
            Object this$actualGrossWeight = this.getActualGrossWeight();
            Object other$actualGrossWeight = other.getActualGrossWeight();
            if (this$actualGrossWeight == null ? other$actualGrossWeight == null : this$actualGrossWeight.equals(other$actualGrossWeight)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CargoListCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $actualGrossWeight = this.getActualGrossWeight();
      result = result * 59 + ($actualGrossWeight == null ? 43 : $actualGrossWeight.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListCheckDTOParam(id="
         + this.getId()
         + ", actualWeight="
         + this.getActualWeight()
         + ", actualGrossWeight="
         + this.getActualGrossWeight()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
