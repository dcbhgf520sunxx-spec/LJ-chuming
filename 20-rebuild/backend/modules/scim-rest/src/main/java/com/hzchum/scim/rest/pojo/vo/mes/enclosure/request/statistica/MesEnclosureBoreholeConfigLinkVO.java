package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.statistica;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureCoatingConfigVO", description = "钻孔配置关联VO ")
public class MesEnclosureBoreholeConfigLinkVO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "钻孔配置关联id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "boreholeConfigId", value = "钻孔配置id")
   @NotNull(message = "钻孔配置id不能为空", groups = Add.class)
   private Long boreholeConfigId;
   @ApiModelProperty(name = "minBoreDiameter", value = "最小孔径(毫米)")
   @NotNull(message = "最小孔径不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal minBoreDiameter;
   @ApiModelProperty(name = "maxBoreDiameter", value = "最大孔径(毫米)")
   @NotNull(message = "最大孔径不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal maxBoreDiameter;
   @ApiModelProperty(name = "unitPrice", value = "单价(元)")
   @NotNull(message = "单价不能为空", groups = AddBatch.class)
   private BigDecimal unitPrice;

   public static MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder builder() {
      return new MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder();
   }

   public MesEnclosureBoreholeConfigLinkVO() {
   }

   public MesEnclosureBoreholeConfigLinkVO(
      final Long id, final Long boreholeConfigId, final BigDecimal minBoreDiameter, final BigDecimal maxBoreDiameter, final BigDecimal unitPrice
   ) {
      this.id = id;
      this.boreholeConfigId = boreholeConfigId;
      this.minBoreDiameter = minBoreDiameter;
      this.maxBoreDiameter = maxBoreDiameter;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getBoreholeConfigId() {
      return this.boreholeConfigId;
   }

   public BigDecimal getMinBoreDiameter() {
      return this.minBoreDiameter;
   }

   public BigDecimal getMaxBoreDiameter() {
      return this.maxBoreDiameter;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoreholeConfigId(final Long boreholeConfigId) {
      this.boreholeConfigId = boreholeConfigId;
   }

   public void setMinBoreDiameter(final BigDecimal minBoreDiameter) {
      this.minBoreDiameter = minBoreDiameter;
   }

   public void setMaxBoreDiameter(final BigDecimal maxBoreDiameter) {
      this.maxBoreDiameter = maxBoreDiameter;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public String toString() {
      return "MesEnclosureBoreholeConfigLinkVO(id="
         + this.getId()
         + ", boreholeConfigId="
         + this.getBoreholeConfigId()
         + ", minBoreDiameter="
         + this.getMinBoreDiameter()
         + ", maxBoreDiameter="
         + this.getMaxBoreDiameter()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureBoreholeConfigLinkVO)) {
         return false;
      }

      MesEnclosureBoreholeConfigLinkVO other = (MesEnclosureBoreholeConfigLinkVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boreholeConfigId = this.getBoreholeConfigId();
         Object other$boreholeConfigId = other.getBoreholeConfigId();
         if (this$boreholeConfigId == null ? other$boreholeConfigId == null : this$boreholeConfigId.equals(other$boreholeConfigId)) {
            Object this$minBoreDiameter = this.getMinBoreDiameter();
            Object other$minBoreDiameter = other.getMinBoreDiameter();
            if (this$minBoreDiameter == null ? other$minBoreDiameter == null : this$minBoreDiameter.equals(other$minBoreDiameter)) {
               Object this$maxBoreDiameter = this.getMaxBoreDiameter();
               Object other$maxBoreDiameter = other.getMaxBoreDiameter();
               if (this$maxBoreDiameter == null ? other$maxBoreDiameter == null : this$maxBoreDiameter.equals(other$maxBoreDiameter)) {
                  Object this$unitPrice = this.getUnitPrice();
                  Object other$unitPrice = other.getUnitPrice();
                  return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof MesEnclosureBoreholeConfigLinkVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boreholeConfigId = this.getBoreholeConfigId();
      result = result * 59 + ($boreholeConfigId == null ? 43 : $boreholeConfigId.hashCode());
      Object $minBoreDiameter = this.getMinBoreDiameter();
      result = result * 59 + ($minBoreDiameter == null ? 43 : $minBoreDiameter.hashCode());
      Object $maxBoreDiameter = this.getMaxBoreDiameter();
      result = result * 59 + ($maxBoreDiameter == null ? 43 : $maxBoreDiameter.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesEnclosureBoreholeConfigLinkVOBuilder {
      private Long id;
      private Long boreholeConfigId;
      private BigDecimal minBoreDiameter;
      private BigDecimal maxBoreDiameter;
      private BigDecimal unitPrice;

      MesEnclosureBoreholeConfigLinkVOBuilder() {
      }

      public MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder boreholeConfigId(final Long boreholeConfigId) {
         this.boreholeConfigId = boreholeConfigId;
         return this;
      }

      public MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder minBoreDiameter(final BigDecimal minBoreDiameter) {
         this.minBoreDiameter = minBoreDiameter;
         return this;
      }

      public MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder maxBoreDiameter(final BigDecimal maxBoreDiameter) {
         this.maxBoreDiameter = maxBoreDiameter;
         return this;
      }

      public MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesEnclosureBoreholeConfigLinkVO build() {
         return new MesEnclosureBoreholeConfigLinkVO(this.id, this.boreholeConfigId, this.minBoreDiameter, this.maxBoreDiameter, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesEnclosureBoreholeConfigLinkVO.MesEnclosureBoreholeConfigLinkVOBuilder(id="
            + this.id
            + ", boreholeConfigId="
            + this.boreholeConfigId
            + ", minBoreDiameter="
            + this.minBoreDiameter
            + ", maxBoreDiameter="
            + this.maxBoreDiameter
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
