package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "PlantConvert对象", description = "钢板转换单")
@Entity
@TableName("wms_plant_convert")
@Table(name = "wms_plant_convert")
public class WmsPlantConvert extends BaseEntity {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "materialInventoryId", value = "物料池ID整板id")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_Inventory_id")
   @Column(name = "material_Inventory_id")
   private Long materialInventoryId;
   @ApiModelProperty(name = "receiptSerialNumber", value = "单据编号")
   @JsonProperty("receiptSerialNumber")
   @JSONField(name = "receiptSerialNumber")
   @TableField("receipt_serial_number")
   @Column(name = "receipt_serial_number")
   private String receiptSerialNumber;
   @ApiModelProperty(name = "outboundId", value = "出库单ID")
   @JsonProperty("outboundId")
   @JSONField(name = "outboundId")
   @TableField("outbound_id")
   @Column(name = "outbound_id")
   private Long outboundId;
   @ApiModelProperty(name = "outSerialNumber", value = "审核出库单编号")
   @JsonProperty("outSerialNumber")
   @JSONField(name = "outSerialNumber")
   @TableField("out_serial_number")
   @Column(name = "out_serial_number")
   private String outSerialNumber;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "projectIds", value = "项目IDs")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids")
   private String projectIds;
   @ApiModelProperty(name = "taskOrderNumber", value = "零件工单号")
   @JsonProperty("taskOrderNumber")
   @JSONField(name = "taskOrderNumber")
   @TableField("task_order_number")
   @Column(name = "task_order_number", columnDefinition = "varchar(2550)  COMMENT ''", nullable = true)
   private String taskOrderNumber;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id")
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name")
   private String reviewerName;
   @ApiModelProperty(name = "reviewTime", value = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time")
   private LocalDateTime reviewTime;

   public static WmsPlantConvert.WmsPlantConvertBuilder builder() {
      return new WmsPlantConvert.WmsPlantConvertBuilder();
   }

   public WmsPlantConvert() {
   }

   public WmsPlantConvert(
      final Long id,
      final Long materialInventoryId,
      final String receiptSerialNumber,
      final Long outboundId,
      final String outSerialNumber,
      final Integer basicClass,
      final String projectIds,
      final String taskOrderNumber,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime
   ) {
      this.id = id;
      this.materialInventoryId = materialInventoryId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.outboundId = outboundId;
      this.outSerialNumber = outSerialNumber;
      this.basicClass = basicClass;
      this.projectIds = projectIds;
      this.taskOrderNumber = taskOrderNumber;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutSerialNumber() {
      return this.outSerialNumber;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public WmsPlantConvert setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public WmsPlantConvert setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   @JsonProperty("receiptSerialNumber")
   public WmsPlantConvert setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
      return this;
   }

   @JsonProperty("outboundId")
   public WmsPlantConvert setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   @JsonProperty("outSerialNumber")
   public WmsPlantConvert setOutSerialNumber(final String outSerialNumber) {
      this.outSerialNumber = outSerialNumber;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsPlantConvert setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("projectIds")
   public WmsPlantConvert setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("taskOrderNumber")
   public WmsPlantConvert setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
      return this;
   }

   @JsonProperty("reviewerId")
   public WmsPlantConvert setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public WmsPlantConvert setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("reviewTime")
   public WmsPlantConvert setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @Override
   public String toString() {
      return "WmsPlantConvert(id="
         + this.getId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", outboundId="
         + this.getOutboundId()
         + ", outSerialNumber="
         + this.getOutSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectIds="
         + this.getProjectIds()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPlantConvert)) {
         return false;
      }

      WmsPlantConvert other = (WmsPlantConvert)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$outboundId = this.getOutboundId();
            Object other$outboundId = other.getOutboundId();
            if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$reviewerId = this.getReviewerId();
                  Object other$reviewerId = other.getReviewerId();
                  if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                     Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                     Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                     if (this$receiptSerialNumber == null ? other$receiptSerialNumber == null : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                        Object this$outSerialNumber = this.getOutSerialNumber();
                        Object other$outSerialNumber = other.getOutSerialNumber();
                        if (this$outSerialNumber == null ? other$outSerialNumber == null : this$outSerialNumber.equals(other$outSerialNumber)) {
                           Object this$projectIds = this.getProjectIds();
                           Object other$projectIds = other.getProjectIds();
                           if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                              Object this$taskOrderNumber = this.getTaskOrderNumber();
                              Object other$taskOrderNumber = other.getTaskOrderNumber();
                              if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                                 Object this$reviewerName = this.getReviewerName();
                                 Object other$reviewerName = other.getReviewerName();
                                 if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                    Object this$reviewTime = this.getReviewTime();
                                    Object other$reviewTime = other.getReviewTime();
                                    return this$reviewTime == null ? other$reviewTime == null : this$reviewTime.equals(other$reviewTime);
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
      return other instanceof WmsPlantConvert;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $outSerialNumber = this.getOutSerialNumber();
      result = result * 59 + ($outSerialNumber == null ? 43 : $outSerialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      return result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
   }

   public static class WmsPlantConvertBuilder {
      private Long id;
      private Long materialInventoryId;
      private String receiptSerialNumber;
      private Long outboundId;
      private String outSerialNumber;
      private Integer basicClass;
      private String projectIds;
      private String taskOrderNumber;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;

      WmsPlantConvertBuilder() {
      }

      public WmsPlantConvert.WmsPlantConvertBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public WmsPlantConvert.WmsPlantConvertBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      @JsonProperty("receiptSerialNumber")
      public WmsPlantConvert.WmsPlantConvertBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      @JsonProperty("outboundId")
      public WmsPlantConvert.WmsPlantConvertBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      @JsonProperty("outSerialNumber")
      public WmsPlantConvert.WmsPlantConvertBuilder outSerialNumber(final String outSerialNumber) {
         this.outSerialNumber = outSerialNumber;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsPlantConvert.WmsPlantConvertBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("projectIds")
      public WmsPlantConvert.WmsPlantConvertBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("taskOrderNumber")
      public WmsPlantConvert.WmsPlantConvertBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      @JsonProperty("reviewerId")
      public WmsPlantConvert.WmsPlantConvertBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public WmsPlantConvert.WmsPlantConvertBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("reviewTime")
      public WmsPlantConvert.WmsPlantConvertBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public WmsPlantConvert build() {
         return new WmsPlantConvert(
            this.id,
            this.materialInventoryId,
            this.receiptSerialNumber,
            this.outboundId,
            this.outSerialNumber,
            this.basicClass,
            this.projectIds,
            this.taskOrderNumber,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime
         );
      }

      @Override
      public String toString() {
         return "WmsPlantConvert.WmsPlantConvertBuilder(id="
            + this.id
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", outboundId="
            + this.outboundId
            + ", outSerialNumber="
            + this.outSerialNumber
            + ", basicClass="
            + this.basicClass
            + ", projectIds="
            + this.projectIds
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ")";
      }
   }
}
