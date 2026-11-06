package com.hzchum.scim.project.core.api.pojo._doModel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "PtojectPurchaseOrderReceivedOperateRecord对象", description = "")
@Entity
@TableName("project_purchase_order_received_operate_record")
@Table(name = "project_purchase_order_received_operate_record")
@org.hibernate.annotations.Table(appliesTo = "project_purchase_order_received_operate_record")
public class ProjectPurchaseOrderReceivedOperateRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "收货创建人", notes = "收货创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '收货创建人'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "收货创建人", notes = "收货创建人")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(255)  COMMENT '收货创建人'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "orderId", value = "采购单id", notes = "采购单id")
   @TableField("order_id")
   @Column(name = "order_id", columnDefinition = "bigint(20)  COMMENT '采购单id'", nullable = true)
   private Long orderId;
   @ApiModelProperty(name = "serialNumber", value = "采购单编号", notes = "采购单编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '采购单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "productType", value = "收货产品类型", notes = "收货产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(5)  COMMENT '收货产品类型'", nullable = true)
   private Integer productType;
   @ApiModelProperty(name = "receivedTime", value = "收货日期", notes = "收货日期")
   @TableField("received_time")
   @Column(name = "received_time", columnDefinition = "datetime  COMMENT '收货日期'", nullable = true)
   private LocalDateTime receivedTime;

   public static ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder builder() {
      return new ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder();
   }

   public ProjectPurchaseOrderReceivedOperateRecord() {
   }

   public ProjectPurchaseOrderReceivedOperateRecord(
      final Long id,
      final Long userId,
      final String userName,
      final Long projectId,
      final Long supplierId,
      final Long orderId,
      final String serialNumber,
      final Integer productType,
      final LocalDateTime receivedTime
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.orderId = orderId;
      this.serialNumber = serialNumber;
      this.productType = productType;
      this.receivedTime = receivedTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getReceivedTime() {
      return this.receivedTime;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectPurchaseOrderReceivedOperateRecord setReceivedTime(final LocalDateTime receivedTime) {
      this.receivedTime = receivedTime;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectPurchaseOrderReceivedOperateRecord(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", orderId="
         + this.getOrderId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", receivedTime="
         + this.getReceivedTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPurchaseOrderReceivedOperateRecord)) {
         return false;
      }

      ProjectPurchaseOrderReceivedOperateRecord other = (ProjectPurchaseOrderReceivedOperateRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$orderId = this.getOrderId();
                  Object other$orderId = other.getOrderId();
                  if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$userName = this.getUserName();
                        Object other$userName = other.getUserName();
                        if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$receivedTime = this.getReceivedTime();
                              Object other$receivedTime = other.getReceivedTime();
                              return this$receivedTime == null ? other$receivedTime == null : this$receivedTime.equals(other$receivedTime);
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
      return other instanceof ProjectPurchaseOrderReceivedOperateRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $receivedTime = this.getReceivedTime();
      return result * 59 + ($receivedTime == null ? 43 : $receivedTime.hashCode());
   }

   public static class ProjectPurchaseOrderReceivedOperateRecordBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long projectId;
      private Long supplierId;
      private Long orderId;
      private String serialNumber;
      private Integer productType;
      private LocalDateTime receivedTime;

      ProjectPurchaseOrderReceivedOperateRecordBuilder() {
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder receivedTime(final LocalDateTime receivedTime) {
         this.receivedTime = receivedTime;
         return this;
      }

      public ProjectPurchaseOrderReceivedOperateRecord build() {
         return new ProjectPurchaseOrderReceivedOperateRecord(
            this.id, this.userId, this.userName, this.projectId, this.supplierId, this.orderId, this.serialNumber, this.productType, this.receivedTime
         );
      }

      @Override
      public String toString() {
         return "ProjectPurchaseOrderReceivedOperateRecord.ProjectPurchaseOrderReceivedOperateRecordBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", orderId="
            + this.orderId
            + ", serialNumber="
            + this.serialNumber
            + ", productType="
            + this.productType
            + ", receivedTime="
            + this.receivedTime
            + ")";
      }
   }
}
