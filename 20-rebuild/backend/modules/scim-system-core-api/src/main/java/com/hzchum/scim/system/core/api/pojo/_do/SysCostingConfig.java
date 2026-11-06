package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysCostingConfig对象", description = "")
@Entity
@TableName("sys_costing_config")
@Table(name = "sys_costing_config")
public class SysCostingConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "errorPercentage")
   @JsonProperty("errorPercentage")
   @JSONField(name = "errorPercentage")
   @TableField("error_percentage")
   @Column(name = "error_percentage")
   private Double errorPercentage;
   @ApiModelProperty(name = "errorValue")
   @JsonProperty("errorValue")
   @JSONField(name = "errorValue")
   @TableField("error_value")
   @Column(name = "error_value")
   private Double errorValue;
   @ApiModelProperty(name = "fillAmountMethod")
   @JsonProperty("fillAmountMethod")
   @JSONField(name = "fillAmountMethod")
   @TableField("fill_amount_method")
   @Column(name = "fill_amount_method")
   private Integer fillAmountMethod;
   @ApiModelProperty(name = "fillFactoryMethod")
   @JsonProperty("fillFactoryMethod")
   @JSONField(name = "fillFactoryMethod")
   @TableField("fill_factory_method")
   @Column(name = "fill_factory_method")
   private Integer fillFactoryMethod;
   @ApiModelProperty(name = "meteredMethod")
   @JsonProperty("meteredMethod")
   @JSONField(name = "meteredMethod")
   @TableField("metered_method")
   @Column(name = "metered_method")
   private Integer meteredMethod;
   @ApiModelProperty(name = "taxType")
   @JsonProperty("taxType")
   @JSONField(name = "taxType")
   @TableField("tax_type")
   @Column(name = "tax_type")
   private Integer taxType;

   public static SysCostingConfig.SysCostingConfigBuilder builder() {
      return new SysCostingConfig.SysCostingConfigBuilder();
   }

   public SysCostingConfig() {
   }

   public SysCostingConfig(
      final Long id,
      final Double errorPercentage,
      final Double errorValue,
      final Integer fillAmountMethod,
      final Integer fillFactoryMethod,
      final Integer meteredMethod,
      final Integer taxType
   ) {
      this.id = id;
      this.errorPercentage = errorPercentage;
      this.errorValue = errorValue;
      this.fillAmountMethod = fillAmountMethod;
      this.fillFactoryMethod = fillFactoryMethod;
      this.meteredMethod = meteredMethod;
      this.taxType = taxType;
   }

   public Long getId() {
      return this.id;
   }

   public Double getErrorPercentage() {
      return this.errorPercentage;
   }

   public Double getErrorValue() {
      return this.errorValue;
   }

   public Integer getFillAmountMethod() {
      return this.fillAmountMethod;
   }

   public Integer getFillFactoryMethod() {
      return this.fillFactoryMethod;
   }

   public Integer getMeteredMethod() {
      return this.meteredMethod;
   }

   public Integer getTaxType() {
      return this.taxType;
   }

   @JsonProperty("id")
   public SysCostingConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("errorPercentage")
   public SysCostingConfig setErrorPercentage(final Double errorPercentage) {
      this.errorPercentage = errorPercentage;
      return this;
   }

   @JsonProperty("errorValue")
   public SysCostingConfig setErrorValue(final Double errorValue) {
      this.errorValue = errorValue;
      return this;
   }

   @JsonProperty("fillAmountMethod")
   public SysCostingConfig setFillAmountMethod(final Integer fillAmountMethod) {
      this.fillAmountMethod = fillAmountMethod;
      return this;
   }

   @JsonProperty("fillFactoryMethod")
   public SysCostingConfig setFillFactoryMethod(final Integer fillFactoryMethod) {
      this.fillFactoryMethod = fillFactoryMethod;
      return this;
   }

   @JsonProperty("meteredMethod")
   public SysCostingConfig setMeteredMethod(final Integer meteredMethod) {
      this.meteredMethod = meteredMethod;
      return this;
   }

   @JsonProperty("taxType")
   public SysCostingConfig setTaxType(final Integer taxType) {
      this.taxType = taxType;
      return this;
   }

   @Override
   public String toString() {
      return "SysCostingConfig(id="
         + this.getId()
         + ", errorPercentage="
         + this.getErrorPercentage()
         + ", errorValue="
         + this.getErrorValue()
         + ", fillAmountMethod="
         + this.getFillAmountMethod()
         + ", fillFactoryMethod="
         + this.getFillFactoryMethod()
         + ", meteredMethod="
         + this.getMeteredMethod()
         + ", taxType="
         + this.getTaxType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysCostingConfig)) {
         return false;
      }

      SysCostingConfig other = (SysCostingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$errorPercentage = this.getErrorPercentage();
         Object other$errorPercentage = other.getErrorPercentage();
         if (this$errorPercentage == null ? other$errorPercentage == null : this$errorPercentage.equals(other$errorPercentage)) {
            Object this$errorValue = this.getErrorValue();
            Object other$errorValue = other.getErrorValue();
            if (this$errorValue == null ? other$errorValue == null : this$errorValue.equals(other$errorValue)) {
               Object this$fillAmountMethod = this.getFillAmountMethod();
               Object other$fillAmountMethod = other.getFillAmountMethod();
               if (this$fillAmountMethod == null ? other$fillAmountMethod == null : this$fillAmountMethod.equals(other$fillAmountMethod)) {
                  Object this$fillFactoryMethod = this.getFillFactoryMethod();
                  Object other$fillFactoryMethod = other.getFillFactoryMethod();
                  if (this$fillFactoryMethod == null ? other$fillFactoryMethod == null : this$fillFactoryMethod.equals(other$fillFactoryMethod)) {
                     Object this$meteredMethod = this.getMeteredMethod();
                     Object other$meteredMethod = other.getMeteredMethod();
                     if (this$meteredMethod == null ? other$meteredMethod == null : this$meteredMethod.equals(other$meteredMethod)) {
                        Object this$taxType = this.getTaxType();
                        Object other$taxType = other.getTaxType();
                        return this$taxType == null ? other$taxType == null : this$taxType.equals(other$taxType);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysCostingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $errorPercentage = this.getErrorPercentage();
      result = result * 59 + ($errorPercentage == null ? 43 : $errorPercentage.hashCode());
      Object $errorValue = this.getErrorValue();
      result = result * 59 + ($errorValue == null ? 43 : $errorValue.hashCode());
      Object $fillAmountMethod = this.getFillAmountMethod();
      result = result * 59 + ($fillAmountMethod == null ? 43 : $fillAmountMethod.hashCode());
      Object $fillFactoryMethod = this.getFillFactoryMethod();
      result = result * 59 + ($fillFactoryMethod == null ? 43 : $fillFactoryMethod.hashCode());
      Object $meteredMethod = this.getMeteredMethod();
      result = result * 59 + ($meteredMethod == null ? 43 : $meteredMethod.hashCode());
      Object $taxType = this.getTaxType();
      return result * 59 + ($taxType == null ? 43 : $taxType.hashCode());
   }

   public static class SysCostingConfigBuilder {
      private Long id;
      private Double errorPercentage;
      private Double errorValue;
      private Integer fillAmountMethod;
      private Integer fillFactoryMethod;
      private Integer meteredMethod;
      private Integer taxType;

      SysCostingConfigBuilder() {
      }

      @JsonProperty("id")
      public SysCostingConfig.SysCostingConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("errorPercentage")
      public SysCostingConfig.SysCostingConfigBuilder errorPercentage(final Double errorPercentage) {
         this.errorPercentage = errorPercentage;
         return this;
      }

      @JsonProperty("errorValue")
      public SysCostingConfig.SysCostingConfigBuilder errorValue(final Double errorValue) {
         this.errorValue = errorValue;
         return this;
      }

      @JsonProperty("fillAmountMethod")
      public SysCostingConfig.SysCostingConfigBuilder fillAmountMethod(final Integer fillAmountMethod) {
         this.fillAmountMethod = fillAmountMethod;
         return this;
      }

      @JsonProperty("fillFactoryMethod")
      public SysCostingConfig.SysCostingConfigBuilder fillFactoryMethod(final Integer fillFactoryMethod) {
         this.fillFactoryMethod = fillFactoryMethod;
         return this;
      }

      @JsonProperty("meteredMethod")
      public SysCostingConfig.SysCostingConfigBuilder meteredMethod(final Integer meteredMethod) {
         this.meteredMethod = meteredMethod;
         return this;
      }

      @JsonProperty("taxType")
      public SysCostingConfig.SysCostingConfigBuilder taxType(final Integer taxType) {
         this.taxType = taxType;
         return this;
      }

      public SysCostingConfig build() {
         return new SysCostingConfig(
            this.id, this.errorPercentage, this.errorValue, this.fillAmountMethod, this.fillFactoryMethod, this.meteredMethod, this.taxType
         );
      }

      @Override
      public String toString() {
         return "SysCostingConfig.SysCostingConfigBuilder(id="
            + this.id
            + ", errorPercentage="
            + this.errorPercentage
            + ", errorValue="
            + this.errorValue
            + ", fillAmountMethod="
            + this.fillAmountMethod
            + ", fillFactoryMethod="
            + this.fillFactoryMethod
            + ", meteredMethod="
            + this.meteredMethod
            + ", taxType="
            + this.taxType
            + ")";
      }
   }
}
