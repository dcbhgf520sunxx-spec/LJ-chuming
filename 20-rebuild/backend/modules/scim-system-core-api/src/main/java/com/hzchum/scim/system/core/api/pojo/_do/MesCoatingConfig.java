package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "MesCoatingConfig对象", description = "涂装配置表")
@Entity
@TableName("mes_coating_config")
@Table(name = "mes_coating_config")
@org.hibernate.annotations.Table(appliesTo = "mes_coating_config", comment = "涂装配置表")
public class MesCoatingConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactClassification", value = "构件分类", notes = "构件分类")
   @TableField("artifact_classification")
   @Column(name = "artifact_classification", columnDefinition = "varchar(500)  COMMENT '构件分类'", nullable = true)
   private String artifactClassification;
   @ApiModelProperty(name = "paintType", value = "油漆类型(1: 底漆, 3: 底+中, 7: 底+中+面)", notes = "油漆类型(1: 底漆, 3: 底+中, 7: 底+中+面)")
   @TableField("paint_type")
   @Column(name = "paint_type", columnDefinition = "int(11)  COMMENT '油漆类型(1: 底漆, 3: 底+中, 7: 底+中+面)'", nullable = true)
   private Integer paintType;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   @TableField("measurement_manner")
   @Column(name = "measurement_manner", columnDefinition = "int(11)  COMMENT '计量方式'", nullable = true)
   private Integer measurementManner;
   @ApiModelProperty(name = "price", value = "单价(元/吨)", notes = "单价(元/吨)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元/吨)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态(0: 关闭, 1: 开启)", notes = "状态(0: 关闭, 1: 开启)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) DEFAULT 1 COMMENT '状态(0: 关闭, 1: 开启)'", nullable = true)
   private Boolean status;

   public static MesCoatingConfig.MesCoatingConfigBuilder builder() {
      return new MesCoatingConfig.MesCoatingConfigBuilder();
   }

   public MesCoatingConfig() {
   }

   public MesCoatingConfig(
      final Long id,
      final String artifactClassification,
      final Integer paintType,
      final Integer measurementManner,
      final BigDecimal price,
      final Boolean status
   ) {
      this.id = id;
      this.artifactClassification = artifactClassification;
      this.paintType = paintType;
      this.measurementManner = measurementManner;
      this.price = price;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getArtifactClassification() {
      return this.artifactClassification;
   }

   public Integer getPaintType() {
      return this.paintType;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public MesCoatingConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesCoatingConfig setArtifactClassification(final String artifactClassification) {
      this.artifactClassification = artifactClassification;
      return this;
   }

   public MesCoatingConfig setPaintType(final Integer paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesCoatingConfig setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesCoatingConfig setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesCoatingConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "MesCoatingConfig(id="
         + this.getId()
         + ", artifactClassification="
         + this.getArtifactClassification()
         + ", paintType="
         + this.getPaintType()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesCoatingConfig)) {
         return false;
      }

      MesCoatingConfig other = (MesCoatingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintType = this.getPaintType();
         Object other$paintType = other.getPaintType();
         if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
            Object this$measurementManner = this.getMeasurementManner();
            Object other$measurementManner = other.getMeasurementManner();
            if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$artifactClassification = this.getArtifactClassification();
                  Object other$artifactClassification = other.getArtifactClassification();
                  if (this$artifactClassification == null
                     ? other$artifactClassification == null
                     : this$artifactClassification.equals(other$artifactClassification)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesCoatingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $artifactClassification = this.getArtifactClassification();
      result = result * 59 + ($artifactClassification == null ? 43 : $artifactClassification.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesCoatingConfigBuilder {
      private Long id;
      private String artifactClassification;
      private Integer paintType;
      private Integer measurementManner;
      private BigDecimal price;
      private Boolean status;

      MesCoatingConfigBuilder() {
      }

      public MesCoatingConfig.MesCoatingConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesCoatingConfig.MesCoatingConfigBuilder artifactClassification(final String artifactClassification) {
         this.artifactClassification = artifactClassification;
         return this;
      }

      public MesCoatingConfig.MesCoatingConfigBuilder paintType(final Integer paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesCoatingConfig.MesCoatingConfigBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesCoatingConfig.MesCoatingConfigBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesCoatingConfig.MesCoatingConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesCoatingConfig build() {
         return new MesCoatingConfig(this.id, this.artifactClassification, this.paintType, this.measurementManner, this.price, this.status);
      }

      @Override
      public String toString() {
         return "MesCoatingConfig.MesCoatingConfigBuilder(id="
            + this.id
            + ", artifactClassification="
            + this.artifactClassification
            + ", paintType="
            + this.paintType
            + ", measurementManner="
            + this.measurementManner
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ")";
      }
   }
}
