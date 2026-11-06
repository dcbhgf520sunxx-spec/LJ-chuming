package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TaxRate对象", description = "常用税率表 ")
@Entity
@TableName("wms_tax_rate")
@Table(name = "wms_tax_rate")
public class TaxRate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classification", value = "", notes = "")
   @JsonProperty("classification")
   @JSONField(name = "classification")
   @TableField("classification")
   @Column(name = "classification", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer classification;
   @ApiModelProperty(name = "taxRateList", value = "税率集", notes = "税率集")
   @JsonProperty("taxRateList")
   @JSONField(name = "taxRateList")
   @TableField("tax_rate_list")
   @Column(name = "tax_rate_list", columnDefinition = "varchar(128)  COMMENT '税率集'", nullable = true)
   private String taxRateList;
   @ApiModelProperty(name = "userUpdateTime", value = "编辑时间", notes = "编辑时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '编辑时间'", nullable = true)
   private LocalDateTime userUpdateTime;

   public static TaxRate.TaxRateBuilder builder() {
      return new TaxRate.TaxRateBuilder();
   }

   public TaxRate() {
   }

   public TaxRate(final Long id, final Integer classification, final String taxRateList, final LocalDateTime userUpdateTime) {
      this.id = id;
      this.classification = classification;
      this.taxRateList = taxRateList;
      this.userUpdateTime = userUpdateTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getClassification() {
      return this.classification;
   }

   public String getTaxRateList() {
      return this.taxRateList;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   @JsonProperty("id")
   public TaxRate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classification")
   public TaxRate setClassification(final Integer classification) {
      this.classification = classification;
      return this;
   }

   @JsonProperty("taxRateList")
   public TaxRate setTaxRateList(final String taxRateList) {
      this.taxRateList = taxRateList;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public TaxRate setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @Override
   public String toString() {
      return "TaxRate(id="
         + this.getId()
         + ", classification="
         + this.getClassification()
         + ", taxRateList="
         + this.getTaxRateList()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaxRate)) {
         return false;
      }

      TaxRate other = (TaxRate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classification = this.getClassification();
         Object other$classification = other.getClassification();
         if (this$classification == null ? other$classification == null : this$classification.equals(other$classification)) {
            Object this$taxRateList = this.getTaxRateList();
            Object other$taxRateList = other.getTaxRateList();
            if (this$taxRateList == null ? other$taxRateList == null : this$taxRateList.equals(other$taxRateList)) {
               Object this$userUpdateTime = this.getUserUpdateTime();
               Object other$userUpdateTime = other.getUserUpdateTime();
               return this$userUpdateTime == null ? other$userUpdateTime == null : this$userUpdateTime.equals(other$userUpdateTime);
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
      return other instanceof TaxRate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classification = this.getClassification();
      result = result * 59 + ($classification == null ? 43 : $classification.hashCode());
      Object $taxRateList = this.getTaxRateList();
      result = result * 59 + ($taxRateList == null ? 43 : $taxRateList.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      return result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
   }

   public static class TaxRateBuilder {
      private Long id;
      private Integer classification;
      private String taxRateList;
      private LocalDateTime userUpdateTime;

      TaxRateBuilder() {
      }

      @JsonProperty("id")
      public TaxRate.TaxRateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classification")
      public TaxRate.TaxRateBuilder classification(final Integer classification) {
         this.classification = classification;
         return this;
      }

      @JsonProperty("taxRateList")
      public TaxRate.TaxRateBuilder taxRateList(final String taxRateList) {
         this.taxRateList = taxRateList;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public TaxRate.TaxRateBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public TaxRate build() {
         return new TaxRate(this.id, this.classification, this.taxRateList, this.userUpdateTime);
      }

      @Override
      public String toString() {
         return "TaxRate.TaxRateBuilder(id="
            + this.id
            + ", classification="
            + this.classification
            + ", taxRateList="
            + this.taxRateList
            + ", userUpdateTime="
            + this.userUpdateTime
            + ")";
      }
   }
}
