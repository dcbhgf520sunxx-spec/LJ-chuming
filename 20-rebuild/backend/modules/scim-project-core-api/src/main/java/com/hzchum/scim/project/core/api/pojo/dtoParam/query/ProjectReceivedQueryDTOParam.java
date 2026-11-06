package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("可退货记录查询类")
public class ProjectReceivedQueryDTOParam {
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty("批次id")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "monomerOrArea", value = "单体区域名称", notes = "单体区域名称")
   private String monomerOrArea;
   @ApiModelProperty(name = "receivedTime", value = "收货时间")
   List<LocalDateTime> receivedTime;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "purchaseSn", value = "采购合同号", notes = "采购合同号")
   private String purchaseSn;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   private String specification;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "userName", value = "收货人", notes = "收货人")
   private String userName;

   ProjectReceivedQueryDTOParam(
      final Integer productType,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long enclosurePlanId,
      final String monomerOrArea,
      final List<LocalDateTime> receivedTime,
      final Long supplierId,
      final String purchaseSn,
      final String specification,
      final String name,
      final String serialNumber,
      final String userName
   ) {
      this.productType = productType;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.monomerOrArea = monomerOrArea;
      this.receivedTime = receivedTime;
      this.supplierId = supplierId;
      this.purchaseSn = purchaseSn;
      this.specification = specification;
      this.name = name;
      this.serialNumber = serialNumber;
      this.userName = userName;
   }

   public static ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder builder() {
      return new ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder();
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public String getMonomerOrArea() {
      return this.monomerOrArea;
   }

   public List<LocalDateTime> getReceivedTime() {
      return this.receivedTime;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setMonomerOrArea(final String monomerOrArea) {
      this.monomerOrArea = monomerOrArea;
   }

   public void setReceivedTime(final List<LocalDateTime> receivedTime) {
      this.receivedTime = receivedTime;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedQueryDTOParam)) {
         return false;
      }

      ProjectReceivedQueryDTOParam other = (ProjectReceivedQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$enclosurePlanId = this.getEnclosurePlanId();
                  Object other$enclosurePlanId = other.getEnclosurePlanId();
                  if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$monomerOrArea = this.getMonomerOrArea();
                        Object other$monomerOrArea = other.getMonomerOrArea();
                        if (this$monomerOrArea == null ? other$monomerOrArea == null : this$monomerOrArea.equals(other$monomerOrArea)) {
                           Object this$receivedTime = this.getReceivedTime();
                           Object other$receivedTime = other.getReceivedTime();
                           if (this$receivedTime == null ? other$receivedTime == null : this$receivedTime.equals(other$receivedTime)) {
                              Object this$purchaseSn = this.getPurchaseSn();
                              Object other$purchaseSn = other.getPurchaseSn();
                              if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$userName = this.getUserName();
                                          Object other$userName = other.getUserName();
                                          return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivedQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $monomerOrArea = this.getMonomerOrArea();
      result = result * 59 + ($monomerOrArea == null ? 43 : $monomerOrArea.hashCode());
      Object $receivedTime = this.getReceivedTime();
      result = result * 59 + ($receivedTime == null ? 43 : $receivedTime.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivedQueryDTOParam(productType="
         + this.getProductType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", monomerOrArea="
         + this.getMonomerOrArea()
         + ", receivedTime="
         + this.getReceivedTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", specification="
         + this.getSpecification()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class ProjectReceivedQueryDTOParamBuilder {
      private Integer productType;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long enclosurePlanId;
      private String monomerOrArea;
      private List<LocalDateTime> receivedTime;
      private Long supplierId;
      private String purchaseSn;
      private String specification;
      private String name;
      private String serialNumber;
      private String userName;

      ProjectReceivedQueryDTOParamBuilder() {
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder monomerOrArea(final String monomerOrArea) {
         this.monomerOrArea = monomerOrArea;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder receivedTime(final List<LocalDateTime> receivedTime) {
         this.receivedTime = receivedTime;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectReceivedQueryDTOParam build() {
         return new ProjectReceivedQueryDTOParam(
            this.productType,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.enclosurePlanId,
            this.monomerOrArea,
            this.receivedTime,
            this.supplierId,
            this.purchaseSn,
            this.specification,
            this.name,
            this.serialNumber,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivedQueryDTOParam.ProjectReceivedQueryDTOParamBuilder(productType="
            + this.productType
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", monomerOrArea="
            + this.monomerOrArea
            + ", receivedTime="
            + this.receivedTime
            + ", supplierId="
            + this.supplierId
            + ", purchaseSn="
            + this.purchaseSn
            + ", specification="
            + this.specification
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
