package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "外购收货操作记录", description = "外购收货操作记录 ")
public class ProjectReceivedOperateRecordDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "收货创建人", notes = "收货创建人")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "收货创建人", notes = "收货创建人")
   private String userName;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "projectId", value = "项目", notes = "项目")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目", notes = "项目")
   private String projectName;
   @ApiModelProperty(name = "orderId", value = "采购单id", notes = "采购单id")
   private Long orderId;
   @ApiModelProperty(name = "orderSerialNumber", value = "采购单编号", notes = "采购单编号")
   private String orderSerialNumber;
   @ApiModelProperty(name = "productType", value = "收货产品类型", notes = "收货产品类型")
   private Integer productType;
   @ApiModelProperty(name = "receivedTime", value = "收货日期", notes = "收货日期")
   private LocalDateTime receivedTime;

   public static ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder builder() {
      return new ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder();
   }

   public ProjectReceivedOperateRecordDTO() {
   }

   public ProjectReceivedOperateRecordDTO(
      final Long id,
      final Long userId,
      final String userName,
      final Long supplierId,
      final String supplierName,
      final Long projectId,
      final String projectName,
      final Long orderId,
      final String orderSerialNumber,
      final Integer productType,
      final LocalDateTime receivedTime
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectId = projectId;
      this.projectName = projectName;
      this.orderId = orderId;
      this.orderSerialNumber = orderSerialNumber;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getOrderSerialNumber() {
      return this.orderSerialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getReceivedTime() {
      return this.receivedTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setOrderSerialNumber(final String orderSerialNumber) {
      this.orderSerialNumber = orderSerialNumber;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setReceivedTime(final LocalDateTime receivedTime) {
      this.receivedTime = receivedTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedOperateRecordDTO)) {
         return false;
      }

      ProjectReceivedOperateRecordDTO other = (ProjectReceivedOperateRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$orderId = this.getOrderId();
                  Object other$orderId = other.getOrderId();
                  if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$userName = this.getUserName();
                        Object other$userName = other.getUserName();
                        if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                              Object this$projectName = this.getProjectName();
                              Object other$projectName = other.getProjectName();
                              if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                 Object this$orderSerialNumber = this.getOrderSerialNumber();
                                 Object other$orderSerialNumber = other.getOrderSerialNumber();
                                 if (this$orderSerialNumber == null ? other$orderSerialNumber == null : this$orderSerialNumber.equals(other$orderSerialNumber)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivedOperateRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $orderSerialNumber = this.getOrderSerialNumber();
      result = result * 59 + ($orderSerialNumber == null ? 43 : $orderSerialNumber.hashCode());
      Object $receivedTime = this.getReceivedTime();
      return result * 59 + ($receivedTime == null ? 43 : $receivedTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedOperateRecordDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", orderId="
         + this.getOrderId()
         + ", orderSerialNumber="
         + this.getOrderSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", receivedTime="
         + this.getReceivedTime()
         + ")";
   }

   public static class ProjectReceivedOperateRecordDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long supplierId;
      private String supplierName;
      private Long projectId;
      private String projectName;
      private Long orderId;
      private String orderSerialNumber;
      private Integer productType;
      private LocalDateTime receivedTime;

      ProjectReceivedOperateRecordDTOBuilder() {
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder orderSerialNumber(final String orderSerialNumber) {
         this.orderSerialNumber = orderSerialNumber;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder receivedTime(final LocalDateTime receivedTime) {
         this.receivedTime = receivedTime;
         return this;
      }

      public ProjectReceivedOperateRecordDTO build() {
         return new ProjectReceivedOperateRecordDTO(
            this.id,
            this.userId,
            this.userName,
            this.supplierId,
            this.supplierName,
            this.projectId,
            this.projectName,
            this.orderId,
            this.orderSerialNumber,
            this.productType,
            this.receivedTime
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivedOperateRecordDTO.ProjectReceivedOperateRecordDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", orderId="
            + this.orderId
            + ", orderSerialNumber="
            + this.orderSerialNumber
            + ", productType="
            + this.productType
            + ", receivedTime="
            + this.receivedTime
            + ")";
      }
   }
}
