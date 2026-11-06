package com.hzchum.scim.mes.building.core.api.pojo._do.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingStructureProcessPriceDTO", description = "组铆焊工序单价关联表DTO ")
public class MesBuildingStructureProcessPriceDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "processId", value = "工序Id", notes = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "processLinkId", value = "工序关联Id", notes = "工序Id")
   private Long processLinkId;
   @ApiModelProperty(name = "name", value = "工序名称", notes = "工序名称")
   private String name;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式 [1 重量, 2 长度]", notes = "计价方式 [1 重量, 2 长度]")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "price", value = "价格/元", notes = "价格/元")
   private BigDecimal price;

   public static MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder builder() {
      return new MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder();
   }

   public MesBuildingStructureProcessPriceDO() {
   }

   public MesBuildingStructureProcessPriceDO(
      final Long id, final Long processId, final Long processLinkId, final String name, final Integer wageQuotaType, final BigDecimal price
   ) {
      this.id = id;
      this.processId = processId;
      this.processLinkId = processLinkId;
      this.name = name;
      this.wageQuotaType = wageQuotaType;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProcessLinkId() {
      return this.processLinkId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesBuildingStructureProcessPriceDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingStructureProcessPriceDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingStructureProcessPriceDO setProcessLinkId(final Long processLinkId) {
      this.processLinkId = processLinkId;
      return this;
   }

   public MesBuildingStructureProcessPriceDO setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingStructureProcessPriceDO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   public MesBuildingStructureProcessPriceDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureProcessPriceDO(id="
         + this.getId()
         + ", processId="
         + this.getProcessId()
         + ", processLinkId="
         + this.getProcessLinkId()
         + ", name="
         + this.getName()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingStructureProcessPriceDO)) {
         return false;
      }

      MesBuildingStructureProcessPriceDO other = (MesBuildingStructureProcessPriceDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$processLinkId = this.getProcessLinkId();
            Object other$processLinkId = other.getProcessLinkId();
            if (this$processLinkId == null ? other$processLinkId == null : this$processLinkId.equals(other$processLinkId)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesBuildingStructureProcessPriceDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $processLinkId = this.getProcessLinkId();
      result = result * 59 + ($processLinkId == null ? 43 : $processLinkId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingStructureProcessPriceDOBuilder {
      private Long id;
      private Long processId;
      private Long processLinkId;
      private String name;
      private Integer wageQuotaType;
      private BigDecimal price;

      MesBuildingStructureProcessPriceDOBuilder() {
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder processLinkId(final Long processLinkId) {
         this.processLinkId = processLinkId;
         return this;
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBuildingStructureProcessPriceDO build() {
         return new MesBuildingStructureProcessPriceDO(this.id, this.processId, this.processLinkId, this.name, this.wageQuotaType, this.price);
      }

      @Override
      public String toString() {
         return "MesBuildingStructureProcessPriceDO.MesBuildingStructureProcessPriceDOBuilder(id="
            + this.id
            + ", processId="
            + this.processId
            + ", processLinkId="
            + this.processLinkId
            + ", name="
            + this.name
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", price="
            + this.price
            + ")";
      }
   }
}
