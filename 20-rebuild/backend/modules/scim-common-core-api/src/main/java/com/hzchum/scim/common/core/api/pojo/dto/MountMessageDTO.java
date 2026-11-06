package com.hzchum.scim.common.core.api.pojo.dto;

import java.util.List;

public class MountMessageDTO {
   private List<Integer> basicClass;
   private List<Integer> projectAttribute;
   private List<Integer> outboundType;
   private List<Integer> returnedType;
   private List<Integer> crmTenderApprovalFlowsType;
   private List<Long> workshopId;
   private List<Integer> materialType;
   private List<Integer> inboundWay;

   public List<Integer> getBasicClass() {
      return this.basicClass;
   }

   public List<Integer> getProjectAttribute() {
      return this.projectAttribute;
   }

   public List<Integer> getOutboundType() {
      return this.outboundType;
   }

   public List<Integer> getReturnedType() {
      return this.returnedType;
   }

   public List<Integer> getCrmTenderApprovalFlowsType() {
      return this.crmTenderApprovalFlowsType;
   }

   public List<Long> getWorkshopId() {
      return this.workshopId;
   }

   public List<Integer> getMaterialType() {
      return this.materialType;
   }

   public List<Integer> getInboundWay() {
      return this.inboundWay;
   }

   public void setBasicClass(final List<Integer> basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectAttribute(final List<Integer> projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setOutboundType(final List<Integer> outboundType) {
      this.outboundType = outboundType;
   }

   public void setReturnedType(final List<Integer> returnedType) {
      this.returnedType = returnedType;
   }

   public void setCrmTenderApprovalFlowsType(final List<Integer> crmTenderApprovalFlowsType) {
      this.crmTenderApprovalFlowsType = crmTenderApprovalFlowsType;
   }

   public void setWorkshopId(final List<Long> workshopId) {
      this.workshopId = workshopId;
   }

   public void setMaterialType(final List<Integer> materialType) {
      this.materialType = materialType;
   }

   public void setInboundWay(final List<Integer> inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MountMessageDTO)) {
         return false;
      }

      MountMessageDTO other = (MountMessageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$outboundType = this.getOutboundType();
            Object other$outboundType = other.getOutboundType();
            if (this$outboundType == null ? other$outboundType == null : this$outboundType.equals(other$outboundType)) {
               Object this$returnedType = this.getReturnedType();
               Object other$returnedType = other.getReturnedType();
               if (this$returnedType == null ? other$returnedType == null : this$returnedType.equals(other$returnedType)) {
                  Object this$crmTenderApprovalFlowsType = this.getCrmTenderApprovalFlowsType();
                  Object other$crmTenderApprovalFlowsType = other.getCrmTenderApprovalFlowsType();
                  if (this$crmTenderApprovalFlowsType == null
                     ? other$crmTenderApprovalFlowsType == null
                     : this$crmTenderApprovalFlowsType.equals(other$crmTenderApprovalFlowsType)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                        Object this$materialType = this.getMaterialType();
                        Object other$materialType = other.getMaterialType();
                        if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                           Object this$inboundWay = this.getInboundWay();
                           Object other$inboundWay = other.getInboundWay();
                           return this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay);
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
      return other instanceof MountMessageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $outboundType = this.getOutboundType();
      result = result * 59 + ($outboundType == null ? 43 : $outboundType.hashCode());
      Object $returnedType = this.getReturnedType();
      result = result * 59 + ($returnedType == null ? 43 : $returnedType.hashCode());
      Object $crmTenderApprovalFlowsType = this.getCrmTenderApprovalFlowsType();
      result = result * 59 + ($crmTenderApprovalFlowsType == null ? 43 : $crmTenderApprovalFlowsType.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $inboundWay = this.getInboundWay();
      return result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
   }

   @Override
   public String toString() {
      return "MountMessageDTO(basicClass="
         + this.getBasicClass()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", outboundType="
         + this.getOutboundType()
         + ", returnedType="
         + this.getReturnedType()
         + ", crmTenderApprovalFlowsType="
         + this.getCrmTenderApprovalFlowsType()
         + ", workshopId="
         + this.getWorkshopId()
         + ", materialType="
         + this.getMaterialType()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }
}
