package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "计划管理-项目执行动态DTO类")
public class ProjectExecutionDynamicsDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目简称")
   private String projectShortName;
   @ApiModelProperty("结构类型")
   private Integer structureType;
   @ApiModelProperty("合同量(吨)")
   private BigDecimal contractWeight;
   @ApiModelProperty("深化量(吨)")
   private BigDecimal deepenWeight;
   @ApiModelProperty("排产量(吨)")
   private BigDecimal schedulingWeight;
   @ApiModelProperty("生产量(吨)")
   private BigDecimal producedWeight;
   @ApiModelProperty("未生产量(吨)")
   private BigDecimal notProducedWeight;
   @ApiModelProperty("发货量(吨)")
   private BigDecimal deliveryWeight;
   @ApiModelProperty("安装量(吨)")
   private BigDecimal installWeight;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public Integer getStructureType() {
      return this.structureType;
   }

   public BigDecimal getContractWeight() {
      return this.contractWeight;
   }

   public BigDecimal getDeepenWeight() {
      return this.deepenWeight;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public BigDecimal getProducedWeight() {
      return this.producedWeight;
   }

   public BigDecimal getNotProducedWeight() {
      return this.notProducedWeight;
   }

   public BigDecimal getDeliveryWeight() {
      return this.deliveryWeight;
   }

   public BigDecimal getInstallWeight() {
      return this.installWeight;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setStructureType(final Integer structureType) {
      this.structureType = structureType;
   }

   public void setContractWeight(final BigDecimal contractWeight) {
      this.contractWeight = contractWeight;
   }

   public void setDeepenWeight(final BigDecimal deepenWeight) {
      this.deepenWeight = deepenWeight;
   }

   public void setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
   }

   public void setProducedWeight(final BigDecimal producedWeight) {
      this.producedWeight = producedWeight;
   }

   public void setNotProducedWeight(final BigDecimal notProducedWeight) {
      this.notProducedWeight = notProducedWeight;
   }

   public void setDeliveryWeight(final BigDecimal deliveryWeight) {
      this.deliveryWeight = deliveryWeight;
   }

   public void setInstallWeight(final BigDecimal installWeight) {
      this.installWeight = installWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectExecutionDynamicsDTO)) {
         return false;
      }

      ProjectExecutionDynamicsDTO other = (ProjectExecutionDynamicsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$structureType = this.getStructureType();
         Object other$structureType = other.getStructureType();
         if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
            Object this$projectSerialNumber = this.getProjectSerialNumber();
            Object other$projectSerialNumber = other.getProjectSerialNumber();
            if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
               Object this$projectShortName = this.getProjectShortName();
               Object other$projectShortName = other.getProjectShortName();
               if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                  Object this$contractWeight = this.getContractWeight();
                  Object other$contractWeight = other.getContractWeight();
                  if (this$contractWeight == null ? other$contractWeight == null : this$contractWeight.equals(other$contractWeight)) {
                     Object this$deepenWeight = this.getDeepenWeight();
                     Object other$deepenWeight = other.getDeepenWeight();
                     if (this$deepenWeight == null ? other$deepenWeight == null : this$deepenWeight.equals(other$deepenWeight)) {
                        Object this$schedulingWeight = this.getSchedulingWeight();
                        Object other$schedulingWeight = other.getSchedulingWeight();
                        if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
                           Object this$producedWeight = this.getProducedWeight();
                           Object other$producedWeight = other.getProducedWeight();
                           if (this$producedWeight == null ? other$producedWeight == null : this$producedWeight.equals(other$producedWeight)) {
                              Object this$notProducedWeight = this.getNotProducedWeight();
                              Object other$notProducedWeight = other.getNotProducedWeight();
                              if (this$notProducedWeight == null ? other$notProducedWeight == null : this$notProducedWeight.equals(other$notProducedWeight)) {
                                 Object this$deliveryWeight = this.getDeliveryWeight();
                                 Object other$deliveryWeight = other.getDeliveryWeight();
                                 if (this$deliveryWeight == null ? other$deliveryWeight == null : this$deliveryWeight.equals(other$deliveryWeight)) {
                                    Object this$installWeight = this.getInstallWeight();
                                    Object other$installWeight = other.getInstallWeight();
                                    return this$installWeight == null ? other$installWeight == null : this$installWeight.equals(other$installWeight);
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
      return other instanceof ProjectExecutionDynamicsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $contractWeight = this.getContractWeight();
      result = result * 59 + ($contractWeight == null ? 43 : $contractWeight.hashCode());
      Object $deepenWeight = this.getDeepenWeight();
      result = result * 59 + ($deepenWeight == null ? 43 : $deepenWeight.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $producedWeight = this.getProducedWeight();
      result = result * 59 + ($producedWeight == null ? 43 : $producedWeight.hashCode());
      Object $notProducedWeight = this.getNotProducedWeight();
      result = result * 59 + ($notProducedWeight == null ? 43 : $notProducedWeight.hashCode());
      Object $deliveryWeight = this.getDeliveryWeight();
      result = result * 59 + ($deliveryWeight == null ? 43 : $deliveryWeight.hashCode());
      Object $installWeight = this.getInstallWeight();
      return result * 59 + ($installWeight == null ? 43 : $installWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectExecutionDynamicsDTO(projectId="
         + this.getProjectId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", structureType="
         + this.getStructureType()
         + ", contractWeight="
         + this.getContractWeight()
         + ", deepenWeight="
         + this.getDeepenWeight()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", producedWeight="
         + this.getProducedWeight()
         + ", notProducedWeight="
         + this.getNotProducedWeight()
         + ", deliveryWeight="
         + this.getDeliveryWeight()
         + ", installWeight="
         + this.getInstallWeight()
         + ")";
   }
}
