package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

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

@ApiModel(value = "MesBuildingSinglePartArtifactWarehouseLink对象", description = "可上报产品与入库详情关联表")
@Entity
@TableName("mes_building_single_part_artifact_warehouse_link")
@Table(name = "mes_building_single_part_artifact_warehouse_link")
@org.hibernate.annotations.Table(appliesTo = "mes_building_single_part_artifact_warehouse_link", comment = "可上报产品与入库详情关联表")
public class MesBuildingSinglePartArtifactWarehouseLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "warehouseId", value = "入库详情表id", notes = "入库详情表id")
   @JsonProperty("warehouseId")
   @JSONField(name = "warehouseId")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '入库详情表id'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "reportQuantity", value = "上报数量", notes = "上报数量")
   @JsonProperty("reportQuantity")
   @JSONField(name = "reportQuantity")
   @TableField("report_quantity")
   @Column(name = "report_quantity", columnDefinition = "int(11) default '0' COMMENT '上报数量'", nullable = true)
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportUserId", value = "上报人", notes = "上报人")
   @JsonProperty("reportUserId")
   @JSONField(name = "reportUserId")
   @TableField("report_user_id")
   @Column(name = "report_user_id", columnDefinition = "bigint(20)  COMMENT '上报人'", nullable = true)
   private Long reportUserId;
   @ApiModelProperty(name = "boolAssist", value = "是否是外协构件 0:否 1:是", notes = "是否是外协构件 0:否 1:是")
   @JsonProperty("boolAssist")
   @JSONField(name = "boolAssist")
   @TableField("bool_assist")
   @Column(name = "bool_assist", columnDefinition = "tinyint(1) default '0' COMMENT '是否是外协构件 0:否 1:是'", nullable = true)
   private Boolean boolAssist;
   @ApiModelProperty(name = "warehousingType", value = "外协产品类型 0:非及入及出  1:及入及出", notes = "外协产品类型 0:非及入及出  1:及入及出")
   @JsonProperty("warehousingType")
   @JSONField(name = "warehousingType")
   @TableField("warehousing_type")
   @Column(name = "warehousing_type", columnDefinition = "int(11)  COMMENT '外协产品类型 0:非及入及出  1:及入及出'", nullable = true)
   private Integer warehousingType;
   @ApiModelProperty(name = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '一物一码号'", nullable = true)
   private Integer number;

   public static MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder builder() {
      return new MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder();
   }

   public MesBuildingSinglePartArtifactWarehouseLink() {
   }

   public MesBuildingSinglePartArtifactWarehouseLink(
      final Long id,
      final Long warehouseId,
      final Long productId,
      final Integer reportQuantity,
      final Long reportUserId,
      final Boolean boolAssist,
      final Integer warehousingType,
      final Integer number
   ) {
      this.id = id;
      this.warehouseId = warehouseId;
      this.productId = productId;
      this.reportQuantity = reportQuantity;
      this.reportUserId = reportUserId;
      this.boolAssist = boolAssist;
      this.warehousingType = warehousingType;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public Long getReportUserId() {
      return this.reportUserId;
   }

   public Boolean getBoolAssist() {
      return this.boolAssist;
   }

   public Integer getWarehousingType() {
      return this.warehousingType;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesBuildingSinglePartArtifactWarehouseLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("warehouseId")
   public MesBuildingSinglePartArtifactWarehouseLink setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSinglePartArtifactWarehouseLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("reportQuantity")
   public MesBuildingSinglePartArtifactWarehouseLink setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   @JsonProperty("reportUserId")
   public MesBuildingSinglePartArtifactWarehouseLink setReportUserId(final Long reportUserId) {
      this.reportUserId = reportUserId;
      return this;
   }

   @JsonProperty("boolAssist")
   public MesBuildingSinglePartArtifactWarehouseLink setBoolAssist(final Boolean boolAssist) {
      this.boolAssist = boolAssist;
      return this;
   }

   @JsonProperty("warehousingType")
   public MesBuildingSinglePartArtifactWarehouseLink setWarehousingType(final Integer warehousingType) {
      this.warehousingType = warehousingType;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingSinglePartArtifactWarehouseLink setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSinglePartArtifactWarehouseLink(id="
         + this.getId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", productId="
         + this.getProductId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportUserId="
         + this.getReportUserId()
         + ", boolAssist="
         + this.getBoolAssist()
         + ", warehousingType="
         + this.getWarehousingType()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSinglePartArtifactWarehouseLink)) {
         return false;
      }

      MesBuildingSinglePartArtifactWarehouseLink other = (MesBuildingSinglePartArtifactWarehouseLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$reportQuantity = this.getReportQuantity();
               Object other$reportQuantity = other.getReportQuantity();
               if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                  Object this$reportUserId = this.getReportUserId();
                  Object other$reportUserId = other.getReportUserId();
                  if (this$reportUserId == null ? other$reportUserId == null : this$reportUserId.equals(other$reportUserId)) {
                     Object this$boolAssist = this.getBoolAssist();
                     Object other$boolAssist = other.getBoolAssist();
                     if (this$boolAssist == null ? other$boolAssist == null : this$boolAssist.equals(other$boolAssist)) {
                        Object this$warehousingType = this.getWarehousingType();
                        Object other$warehousingType = other.getWarehousingType();
                        if (this$warehousingType == null ? other$warehousingType == null : this$warehousingType.equals(other$warehousingType)) {
                           Object this$number = this.getNumber();
                           Object other$number = other.getNumber();
                           return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof MesBuildingSinglePartArtifactWarehouseLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportUserId = this.getReportUserId();
      result = result * 59 + ($reportUserId == null ? 43 : $reportUserId.hashCode());
      Object $boolAssist = this.getBoolAssist();
      result = result * 59 + ($boolAssist == null ? 43 : $boolAssist.hashCode());
      Object $warehousingType = this.getWarehousingType();
      result = result * 59 + ($warehousingType == null ? 43 : $warehousingType.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class MesBuildingSinglePartArtifactWarehouseLinkBuilder {
      private Long id;
      private Long warehouseId;
      private Long productId;
      private Integer reportQuantity;
      private Long reportUserId;
      private Boolean boolAssist;
      private Integer warehousingType;
      private Integer number;

      MesBuildingSinglePartArtifactWarehouseLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("warehouseId")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("reportQuantity")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      @JsonProperty("reportUserId")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder reportUserId(final Long reportUserId) {
         this.reportUserId = reportUserId;
         return this;
      }

      @JsonProperty("boolAssist")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder boolAssist(final Boolean boolAssist) {
         this.boolAssist = boolAssist;
         return this;
      }

      @JsonProperty("warehousingType")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder warehousingType(final Integer warehousingType) {
         this.warehousingType = warehousingType;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingSinglePartArtifactWarehouseLink build() {
         return new MesBuildingSinglePartArtifactWarehouseLink(
            this.id, this.warehouseId, this.productId, this.reportQuantity, this.reportUserId, this.boolAssist, this.warehousingType, this.number
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSinglePartArtifactWarehouseLink.MesBuildingSinglePartArtifactWarehouseLinkBuilder(id="
            + this.id
            + ", warehouseId="
            + this.warehouseId
            + ", productId="
            + this.productId
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportUserId="
            + this.reportUserId
            + ", boolAssist="
            + this.boolAssist
            + ", warehousingType="
            + this.warehousingType
            + ", number="
            + this.number
            + ")";
      }
   }
}
