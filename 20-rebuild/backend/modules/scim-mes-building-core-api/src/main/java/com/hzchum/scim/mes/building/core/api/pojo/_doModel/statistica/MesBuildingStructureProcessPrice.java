package com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingStructureProcessPrice对象", description = "构件类型与工序单价关联表")
@Entity
@TableName("mes_building_structure_process_price")
@Table(name = "mes_building_structure_process_price")
public class MesBuildingStructureProcessPrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "structureTypeLinkId", value = "构件种类与类型关联表id")
   @JsonProperty("structureTypeLinkId")
   @JSONField(name = "structure_type_link_id")
   @TableField("structure_type_link_id")
   @Column(name = "structure_type_link_id", columnDefinition = "bigint(20)  COMMENT '构件种类与类型关联表id'", nullable = false)
   private Long structureTypeLinkId;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "process_id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式 [1 重量, 2 长度，4 面积, 8 数量]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(20) default '1' COMMENT '计价方式 [1 重量, 2 长度，4 面积, 8 数量]'", nullable = false)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "price", value = "价格/元", notes = "价格/元")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '价格/元'", nullable = false)
   private BigDecimal price;

   public static MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder builder() {
      return new MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder();
   }

   public MesBuildingStructureProcessPrice() {
   }

   public MesBuildingStructureProcessPrice(
      final Long id, final Long structureTypeLinkId, final Long processId, final Integer wageQuotaType, final BigDecimal price
   ) {
      this.id = id;
      this.structureTypeLinkId = structureTypeLinkId;
      this.processId = processId;
      this.wageQuotaType = wageQuotaType;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStructureTypeLinkId() {
      return this.structureTypeLinkId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesBuildingStructureProcessPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("structureTypeLinkId")
   public MesBuildingStructureProcessPrice setStructureTypeLinkId(final Long structureTypeLinkId) {
      this.structureTypeLinkId = structureTypeLinkId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingStructureProcessPrice setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingStructureProcessPrice setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingStructureProcessPrice setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureProcessPrice(id="
         + this.getId()
         + ", structureTypeLinkId="
         + this.getStructureTypeLinkId()
         + ", processId="
         + this.getProcessId()
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

      if (!(o instanceof MesBuildingStructureProcessPrice)) {
         return false;
      }

      MesBuildingStructureProcessPrice other = (MesBuildingStructureProcessPrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$structureTypeLinkId = this.getStructureTypeLinkId();
         Object other$structureTypeLinkId = other.getStructureTypeLinkId();
         if (this$structureTypeLinkId == null ? other$structureTypeLinkId == null : this$structureTypeLinkId.equals(other$structureTypeLinkId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingStructureProcessPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureTypeLinkId = this.getStructureTypeLinkId();
      result = result * 59 + ($structureTypeLinkId == null ? 43 : $structureTypeLinkId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingStructureProcessPriceBuilder {
      private Long id;
      private Long structureTypeLinkId;
      private Long processId;
      private Integer wageQuotaType;
      private BigDecimal price;

      MesBuildingStructureProcessPriceBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("structureTypeLinkId")
      public MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder structureTypeLinkId(final Long structureTypeLinkId) {
         this.structureTypeLinkId = structureTypeLinkId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBuildingStructureProcessPrice build() {
         return new MesBuildingStructureProcessPrice(this.id, this.structureTypeLinkId, this.processId, this.wageQuotaType, this.price);
      }

      @Override
      public String toString() {
         return "MesBuildingStructureProcessPrice.MesBuildingStructureProcessPriceBuilder(id="
            + this.id
            + ", structureTypeLinkId="
            + this.structureTypeLinkId
            + ", processId="
            + this.processId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", price="
            + this.price
            + ")";
      }
   }
}
