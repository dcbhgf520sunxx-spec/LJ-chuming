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
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesContractProjectCoatingConfigLink对象", description = "项目涂装配置关联表")
@Entity
@TableName("mes_contract_project_coating_config_link")
@Table(name = "mes_contract_project_coating_config_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_coating_config_link", comment = "项目涂装配置关联表")
public class MesContractProjectCoatingConfigLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long contractProjectId;
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
   @Column(name = "measurement_manner", columnDefinition = "int(11)  COMMENT '计量方式(WageQuotaTypeEnum)'", nullable = true)
   private Integer measurementManner;
   @ApiModelProperty(name = "price", value = "单价(元/吨)", notes = "单价(元/吨)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元/吨)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态(0: 关闭, 1: 开启)", notes = "状态(0: 关闭, 1: 开启)")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态(0: 关闭, 1: 开启)'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "thickness", value = "标准厚度(微米)")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "int(11) COMMENT '标准厚度(微米)'")
   private Integer thickness;
   @ApiModelProperty(name = "outThickness", value = "超标厚度(微米)")
   @JsonProperty("outThickness")
   @JSONField(name = "outThickness")
   @TableField("out_thickness")
   @Column(name = "out_thickness", columnDefinition = "int(11) COMMENT '超标厚度'")
   private Integer outThickness;
   @ApiModelProperty(name = "unitPrice", value = "标准单价(元)")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "outUnitPrice", value = "超标单价(元)")
   @JsonProperty("outUnitPrice")
   @JSONField(name = "outUnitPrice")
   @TableField("out_unit_price")
   @Column(name = "out_unit_price", columnDefinition = "decimal(10,2)  COMMENT '单价(元)'")
   private BigDecimal outUnitPrice;

   public static MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder builder() {
      return new MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder();
   }

   public MesContractProjectCoatingConfigLink() {
   }

   public MesContractProjectCoatingConfigLink(
      final Long id,
      final Long contractProjectId,
      final String artifactClassification,
      final Integer paintType,
      final Integer measurementManner,
      final BigDecimal price,
      final Boolean status,
      final Integer thickness,
      final Integer outThickness,
      final BigDecimal unitPrice,
      final BigDecimal outUnitPrice
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.artifactClassification = artifactClassification;
      this.paintType = paintType;
      this.measurementManner = measurementManner;
      this.price = price;
      this.status = status;
      this.thickness = thickness;
      this.outThickness = outThickness;
      this.unitPrice = unitPrice;
      this.outUnitPrice = outUnitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
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

   public Integer getThickness() {
      return this.thickness;
   }

   public Integer getOutThickness() {
      return this.outThickness;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getOutUnitPrice() {
      return this.outUnitPrice;
   }

   public MesContractProjectCoatingConfigLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectCoatingConfigLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectCoatingConfigLink setArtifactClassification(final String artifactClassification) {
      this.artifactClassification = artifactClassification;
      return this;
   }

   public MesContractProjectCoatingConfigLink setPaintType(final Integer paintType) {
      this.paintType = paintType;
      return this;
   }

   public MesContractProjectCoatingConfigLink setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
      return this;
   }

   public MesContractProjectCoatingConfigLink setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesContractProjectCoatingConfigLink setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("thickness")
   public MesContractProjectCoatingConfigLink setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("outThickness")
   public MesContractProjectCoatingConfigLink setOutThickness(final Integer outThickness) {
      this.outThickness = outThickness;
      return this;
   }

   @JsonProperty("unitPrice")
   public MesContractProjectCoatingConfigLink setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("outUnitPrice")
   public MesContractProjectCoatingConfigLink setOutUnitPrice(final BigDecimal outUnitPrice) {
      this.outUnitPrice = outUnitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectCoatingConfigLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
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
         + ", thickness="
         + this.getThickness()
         + ", outThickness="
         + this.getOutThickness()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", outUnitPrice="
         + this.getOutUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectCoatingConfigLink)) {
         return false;
      }

      MesContractProjectCoatingConfigLink other = (MesContractProjectCoatingConfigLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
            Object this$paintType = this.getPaintType();
            Object other$paintType = other.getPaintType();
            if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
               Object this$measurementManner = this.getMeasurementManner();
               Object other$measurementManner = other.getMeasurementManner();
               if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$thickness = this.getThickness();
                     Object other$thickness = other.getThickness();
                     if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                        Object this$outThickness = this.getOutThickness();
                        Object other$outThickness = other.getOutThickness();
                        if (this$outThickness == null ? other$outThickness == null : this$outThickness.equals(other$outThickness)) {
                           Object this$artifactClassification = this.getArtifactClassification();
                           Object other$artifactClassification = other.getArtifactClassification();
                           if (this$artifactClassification == null
                              ? other$artifactClassification == null
                              : this$artifactClassification.equals(other$artifactClassification)) {
                              Object this$price = this.getPrice();
                              Object other$price = other.getPrice();
                              if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                 Object this$unitPrice = this.getUnitPrice();
                                 Object other$unitPrice = other.getUnitPrice();
                                 if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                    Object this$outUnitPrice = this.getOutUnitPrice();
                                    Object other$outUnitPrice = other.getOutUnitPrice();
                                    return this$outUnitPrice == null ? other$outUnitPrice == null : this$outUnitPrice.equals(other$outUnitPrice);
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
      return other instanceof MesContractProjectCoatingConfigLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $artifactClassification = this.getArtifactClassification();
      result = result * 59 + ($artifactClassification == null ? 43 : $artifactClassification.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $outUnitPrice = this.getOutUnitPrice();
      return result * 59 + ($outUnitPrice == null ? 43 : $outUnitPrice.hashCode());
   }

   public static class MesContractProjectCoatingConfigLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private String artifactClassification;
      private Integer paintType;
      private Integer measurementManner;
      private BigDecimal price;
      private Boolean status;
      private Integer thickness;
      private Integer outThickness;
      private BigDecimal unitPrice;
      private BigDecimal outUnitPrice;

      MesContractProjectCoatingConfigLinkBuilder() {
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder artifactClassification(final String artifactClassification) {
         this.artifactClassification = artifactClassification;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder paintType(final Integer paintType) {
         this.paintType = paintType;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder measurementManner(final Integer measurementManner) {
         this.measurementManner = measurementManner;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("thickness")
      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("outThickness")
      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder outThickness(final Integer outThickness) {
         this.outThickness = outThickness;
         return this;
      }

      @JsonProperty("unitPrice")
      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("outUnitPrice")
      public MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder outUnitPrice(final BigDecimal outUnitPrice) {
         this.outUnitPrice = outUnitPrice;
         return this;
      }

      public MesContractProjectCoatingConfigLink build() {
         return new MesContractProjectCoatingConfigLink(
            this.id,
            this.contractProjectId,
            this.artifactClassification,
            this.paintType,
            this.measurementManner,
            this.price,
            this.status,
            this.thickness,
            this.outThickness,
            this.unitPrice,
            this.outUnitPrice
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectCoatingConfigLink.MesContractProjectCoatingConfigLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
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
            + ", thickness="
            + this.thickness
            + ", outThickness="
            + this.outThickness
            + ", unitPrice="
            + this.unitPrice
            + ", outUnitPrice="
            + this.outUnitPrice
            + ")";
      }
   }
}
