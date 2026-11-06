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

@ApiModel(value = "MesBuildingAssembleProcessPrice对象", description = "部件组铆焊价格表")
@Entity
@TableName("mes_building_assemble_process_price")
@Table(name = "mes_building_assemble_process_price")
public class MesBuildingAssembleProcessPrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleLinkId", value = "部件组铆焊关联表Id")
   @JsonProperty("assembleLinkId")
   @JSONField(name = "assembleLinkId")
   @TableField("assemble_link_id")
   @Column(name = "assemble_link_id", columnDefinition = "bigint(20)  COMMENT '部件组铆焊关联表Id'", nullable = false)
   private Long assembleLinkId;
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

   public static MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder builder() {
      return new MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder();
   }

   public MesBuildingAssembleProcessPrice() {
   }

   public MesBuildingAssembleProcessPrice(final Long id, final Long assembleLinkId, final Long processId, final Integer wageQuotaType, final BigDecimal price) {
      this.id = id;
      this.assembleLinkId = assembleLinkId;
      this.processId = processId;
      this.wageQuotaType = wageQuotaType;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleLinkId() {
      return this.assembleLinkId;
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
   public MesBuildingAssembleProcessPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleLinkId")
   public MesBuildingAssembleProcessPrice setAssembleLinkId(final Long assembleLinkId) {
      this.assembleLinkId = assembleLinkId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingAssembleProcessPrice setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingAssembleProcessPrice setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingAssembleProcessPrice setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleProcessPrice(id="
         + this.getId()
         + ", assembleLinkId="
         + this.getAssembleLinkId()
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

      if (!(o instanceof MesBuildingAssembleProcessPrice)) {
         return false;
      }

      MesBuildingAssembleProcessPrice other = (MesBuildingAssembleProcessPrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleLinkId = this.getAssembleLinkId();
         Object other$assembleLinkId = other.getAssembleLinkId();
         if (this$assembleLinkId == null ? other$assembleLinkId == null : this$assembleLinkId.equals(other$assembleLinkId)) {
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
      return other instanceof MesBuildingAssembleProcessPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleLinkId = this.getAssembleLinkId();
      result = result * 59 + ($assembleLinkId == null ? 43 : $assembleLinkId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingAssembleProcessPriceBuilder {
      private Long id;
      private Long assembleLinkId;
      private Long processId;
      private Integer wageQuotaType;
      private BigDecimal price;

      MesBuildingAssembleProcessPriceBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleLinkId")
      public MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder assembleLinkId(final Long assembleLinkId) {
         this.assembleLinkId = assembleLinkId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBuildingAssembleProcessPrice build() {
         return new MesBuildingAssembleProcessPrice(this.id, this.assembleLinkId, this.processId, this.wageQuotaType, this.price);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleProcessPrice.MesBuildingAssembleProcessPriceBuilder(id="
            + this.id
            + ", assembleLinkId="
            + this.assembleLinkId
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
