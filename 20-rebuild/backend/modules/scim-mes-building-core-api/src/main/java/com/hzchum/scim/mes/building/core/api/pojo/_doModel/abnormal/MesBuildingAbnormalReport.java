package com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal;

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

@ApiModel(value = "MesBuildingAbnormalReport对象", description = "")
@Entity
@TableName("mes_building_abnormal_report")
@Table(name = "mes_building_abnormal_report")
public class MesBuildingAbnormalReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "abnormalId", value = "异常id", notes = "异常id")
   @JsonProperty("abnormalId")
   @JSONField(name = "abnormalId")
   @TableField("abnormal_id")
   @Column(name = "abnormal_id", columnDefinition = "bigint(20)  COMMENT '异常id'", nullable = false)
   private Long abnormalId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "减少数量", notes = "减少数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '减少数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "reportId", value = "变更后数量", notes = "变更后数量")
   @JsonProperty("reportId")
   @JSONField(name = "reportId")
   @TableField("report_id")
   @Column(name = "report_id", columnDefinition = "bigint(11)  COMMENT '变更后数量'", nullable = false)
   private Long reportId;
   @ApiModelProperty(name = "type", value = "类型 [1 排产异常, 2 生产异常]", notes = "类型 [1 排产异常, 2 生产异常]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '类型 [1 排产异常, 2 生产异常]'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "reportType", value = "上报类型", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @TableField("report_type")
   @Column(name = "report_type", columnDefinition = "int(11)  COMMENT '上报类型'", nullable = true)
   private Integer reportType;
   @ApiModelProperty(name = "userId", value = "变更人", notes = "变更人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '变更人'", nullable = false)
   private Long userId;

   public static MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder builder() {
      return new MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder();
   }

   public MesBuildingAbnormalReport() {
   }

   public MesBuildingAbnormalReport(
      final Long id,
      final Long abnormalId,
      final Long productId,
      final Integer productType,
      final Integer quantity,
      final Long reportId,
      final Integer type,
      final Integer reportType,
      final Long userId
   ) {
      this.id = id;
      this.abnormalId = abnormalId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.reportId = reportId;
      this.type = type;
      this.reportType = reportType;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAbnormalId() {
      return this.abnormalId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getReportId() {
      return this.reportId;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingAbnormalReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("abnormalId")
   public MesBuildingAbnormalReport setAbnormalId(final Long abnormalId) {
      this.abnormalId = abnormalId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingAbnormalReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingAbnormalReport setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAbnormalReport setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("reportId")
   public MesBuildingAbnormalReport setReportId(final Long reportId) {
      this.reportId = reportId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingAbnormalReport setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingAbnormalReport setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingAbnormalReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAbnormalReport(id="
         + this.getId()
         + ", abnormalId="
         + this.getAbnormalId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", reportId="
         + this.getReportId()
         + ", type="
         + this.getType()
         + ", reportType="
         + this.getReportType()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAbnormalReport)) {
         return false;
      }

      MesBuildingAbnormalReport other = (MesBuildingAbnormalReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$abnormalId = this.getAbnormalId();
         Object other$abnormalId = other.getAbnormalId();
         if (this$abnormalId == null ? other$abnormalId == null : this$abnormalId.equals(other$abnormalId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$reportId = this.getReportId();
                     Object other$reportId = other.getReportId();
                     if (this$reportId == null ? other$reportId == null : this$reportId.equals(other$reportId)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$reportType = this.getReportType();
                           Object other$reportType = other.getReportType();
                           if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof MesBuildingAbnormalReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $abnormalId = this.getAbnormalId();
      result = result * 59 + ($abnormalId == null ? 43 : $abnormalId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportId = this.getReportId();
      result = result * 59 + ($reportId == null ? 43 : $reportId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingAbnormalReportBuilder {
      private Long id;
      private Long abnormalId;
      private Long productId;
      private Integer productType;
      private Integer quantity;
      private Long reportId;
      private Integer type;
      private Integer reportType;
      private Long userId;

      MesBuildingAbnormalReportBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("abnormalId")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder abnormalId(final Long abnormalId) {
         this.abnormalId = abnormalId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("reportId")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder reportId(final Long reportId) {
         this.reportId = reportId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingAbnormalReport build() {
         return new MesBuildingAbnormalReport(
            this.id, this.abnormalId, this.productId, this.productType, this.quantity, this.reportId, this.type, this.reportType, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAbnormalReport.MesBuildingAbnormalReportBuilder(id="
            + this.id
            + ", abnormalId="
            + this.abnormalId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", reportId="
            + this.reportId
            + ", type="
            + this.type
            + ", reportType="
            + this.reportType
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
