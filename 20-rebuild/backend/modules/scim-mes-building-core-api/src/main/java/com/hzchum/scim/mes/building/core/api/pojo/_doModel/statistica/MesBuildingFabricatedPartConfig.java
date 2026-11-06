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

@ApiModel(value = "MesBuildingFabricatedPartConfig对象", description = "配套件单价(栓钉套筒)配置")
@Entity
@TableName("mes_building_fabricated_part_config")
@Table(name = "mes_building_fabricated_part_config")
public class MesBuildingFabricatedPartConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "auxiliaryId", value = "配套件分类id")
   @JsonProperty("auxiliaryId")
   @JSONField(name = "auxiliaryId")
   @TableField("auxiliary_id")
   @Column(name = "auxiliary_id", columnDefinition = "bigint(20)  COMMENT '配套件分类id'", nullable = false)
   private Long auxiliaryId;
   @ApiModelProperty(name = "auxiliaryName", value = "配套件种类名称")
   @JsonProperty("auxiliaryName")
   @JSONField(name = "auxiliaryName")
   @TableField("auxiliary_name")
   @Column(name = "auxiliary_name", columnDefinition = "varchar(64)  COMMENT '配套件种类名称'", nullable = false)
   private String auxiliaryName;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(2)  COMMENT '物料基础分类'", nullable = false)
   private Integer basicClass;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2) COMMENT '单价'", nullable = false)
   private BigDecimal unitPrice;

   public static MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder builder() {
      return new MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder();
   }

   public MesBuildingFabricatedPartConfig() {
   }

   public MesBuildingFabricatedPartConfig(
      final Long id, final Long auxiliaryId, final String auxiliaryName, final Integer basicClass, final BigDecimal unitPrice
   ) {
      this.id = id;
      this.auxiliaryId = auxiliaryId;
      this.auxiliaryName = auxiliaryName;
      this.basicClass = basicClass;
      this.unitPrice = unitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAuxiliaryId() {
      return this.auxiliaryId;
   }

   public String getAuxiliaryName() {
      return this.auxiliaryName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   @JsonProperty("id")
   public MesBuildingFabricatedPartConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("auxiliaryId")
   public MesBuildingFabricatedPartConfig setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
      return this;
   }

   @JsonProperty("auxiliaryName")
   public MesBuildingFabricatedPartConfig setAuxiliaryName(final String auxiliaryName) {
      this.auxiliaryName = auxiliaryName;
      return this;
   }

   @JsonProperty("basicClass")
   public MesBuildingFabricatedPartConfig setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesBuildingFabricatedPartConfig setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingFabricatedPartConfig(id="
         + this.getId()
         + ", auxiliaryId="
         + this.getAuxiliaryId()
         + ", auxiliaryName="
         + this.getAuxiliaryName()
         + ", basicClass="
         + this.getBasicClass()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingFabricatedPartConfig)) {
         return false;
      }

      MesBuildingFabricatedPartConfig other = (MesBuildingFabricatedPartConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryId = this.getAuxiliaryId();
         Object other$auxiliaryId = other.getAuxiliaryId();
         if (this$auxiliaryId == null ? other$auxiliaryId == null : this$auxiliaryId.equals(other$auxiliaryId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$auxiliaryName = this.getAuxiliaryName();
               Object other$auxiliaryName = other.getAuxiliaryName();
               if (this$auxiliaryName == null ? other$auxiliaryName == null : this$auxiliaryName.equals(other$auxiliaryName)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingFabricatedPartConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryId = this.getAuxiliaryId();
      result = result * 59 + ($auxiliaryId == null ? 43 : $auxiliaryId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $auxiliaryName = this.getAuxiliaryName();
      result = result * 59 + ($auxiliaryName == null ? 43 : $auxiliaryName.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   public static class MesBuildingFabricatedPartConfigBuilder {
      private Long id;
      private Long auxiliaryId;
      private String auxiliaryName;
      private Integer basicClass;
      private BigDecimal unitPrice;

      MesBuildingFabricatedPartConfigBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("auxiliaryId")
      public MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      @JsonProperty("auxiliaryName")
      public MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder auxiliaryName(final String auxiliaryName) {
         this.auxiliaryName = auxiliaryName;
         return this;
      }

      @JsonProperty("basicClass")
      public MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingFabricatedPartConfig build() {
         return new MesBuildingFabricatedPartConfig(this.id, this.auxiliaryId, this.auxiliaryName, this.basicClass, this.unitPrice);
      }

      @Override
      public String toString() {
         return "MesBuildingFabricatedPartConfig.MesBuildingFabricatedPartConfigBuilder(id="
            + this.id
            + ", auxiliaryId="
            + this.auxiliaryId
            + ", auxiliaryName="
            + this.auxiliaryName
            + ", basicClass="
            + this.basicClass
            + ", unitPrice="
            + this.unitPrice
            + ")";
      }
   }
}
