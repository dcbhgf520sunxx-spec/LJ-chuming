package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import java.util.List;

public class BasicOutbound {
   private Boolean boolAuxMatToWorkShopWay;
   private Boolean boolGasOutAfterInbound;
   private Boolean boolCanOutToOtherProject;
   private Boolean productionOutBoundShop;
   private Boolean productionOutBoundUser;
   private Boolean workOutBoundUser;
   private Integer outboundType;
   private List<Integer> outboundTypes;
   private Boolean productionOutBoundUserIsRequired;
   private Integer cancelDestination;
   private Integer returnedDestination;
   private Boolean showHalfOut;

   public static BasicOutbound.BasicOutboundBuilder builder() {
      return new BasicOutbound.BasicOutboundBuilder();
   }

   public Boolean getBoolAuxMatToWorkShopWay() {
      return this.boolAuxMatToWorkShopWay;
   }

   public Boolean getBoolGasOutAfterInbound() {
      return this.boolGasOutAfterInbound;
   }

   public Boolean getBoolCanOutToOtherProject() {
      return this.boolCanOutToOtherProject;
   }

   public Boolean getProductionOutBoundShop() {
      return this.productionOutBoundShop;
   }

   public Boolean getProductionOutBoundUser() {
      return this.productionOutBoundUser;
   }

   public Boolean getWorkOutBoundUser() {
      return this.workOutBoundUser;
   }

   public Integer getOutboundType() {
      return this.outboundType;
   }

   public List<Integer> getOutboundTypes() {
      return this.outboundTypes;
   }

   public Boolean getProductionOutBoundUserIsRequired() {
      return this.productionOutBoundUserIsRequired;
   }

   public Integer getCancelDestination() {
      return this.cancelDestination;
   }

   public Integer getReturnedDestination() {
      return this.returnedDestination;
   }

   public Boolean getShowHalfOut() {
      return this.showHalfOut;
   }

   public void setBoolAuxMatToWorkShopWay(final Boolean boolAuxMatToWorkShopWay) {
      this.boolAuxMatToWorkShopWay = boolAuxMatToWorkShopWay;
   }

   public void setBoolGasOutAfterInbound(final Boolean boolGasOutAfterInbound) {
      this.boolGasOutAfterInbound = boolGasOutAfterInbound;
   }

   public void setBoolCanOutToOtherProject(final Boolean boolCanOutToOtherProject) {
      this.boolCanOutToOtherProject = boolCanOutToOtherProject;
   }

   public void setProductionOutBoundShop(final Boolean productionOutBoundShop) {
      this.productionOutBoundShop = productionOutBoundShop;
   }

   public void setProductionOutBoundUser(final Boolean productionOutBoundUser) {
      this.productionOutBoundUser = productionOutBoundUser;
   }

   public void setWorkOutBoundUser(final Boolean workOutBoundUser) {
      this.workOutBoundUser = workOutBoundUser;
   }

   public void setOutboundType(final Integer outboundType) {
      this.outboundType = outboundType;
   }

   public void setOutboundTypes(final List<Integer> outboundTypes) {
      this.outboundTypes = outboundTypes;
   }

   public void setProductionOutBoundUserIsRequired(final Boolean productionOutBoundUserIsRequired) {
      this.productionOutBoundUserIsRequired = productionOutBoundUserIsRequired;
   }

   public void setCancelDestination(final Integer cancelDestination) {
      this.cancelDestination = cancelDestination;
   }

   public void setReturnedDestination(final Integer returnedDestination) {
      this.returnedDestination = returnedDestination;
   }

   public void setShowHalfOut(final Boolean showHalfOut) {
      this.showHalfOut = showHalfOut;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicOutbound)) {
         return false;
      }

      BasicOutbound other = (BasicOutbound)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolAuxMatToWorkShopWay = this.getBoolAuxMatToWorkShopWay();
      Object other$boolAuxMatToWorkShopWay = other.getBoolAuxMatToWorkShopWay();
      if (this$boolAuxMatToWorkShopWay == null ? other$boolAuxMatToWorkShopWay == null : this$boolAuxMatToWorkShopWay.equals(other$boolAuxMatToWorkShopWay)) {
         Object this$boolGasOutAfterInbound = this.getBoolGasOutAfterInbound();
         Object other$boolGasOutAfterInbound = other.getBoolGasOutAfterInbound();
         if (this$boolGasOutAfterInbound == null ? other$boolGasOutAfterInbound == null : this$boolGasOutAfterInbound.equals(other$boolGasOutAfterInbound)) {
            Object this$boolCanOutToOtherProject = this.getBoolCanOutToOtherProject();
            Object other$boolCanOutToOtherProject = other.getBoolCanOutToOtherProject();
            if (this$boolCanOutToOtherProject == null
               ? other$boolCanOutToOtherProject == null
               : this$boolCanOutToOtherProject.equals(other$boolCanOutToOtherProject)) {
               Object this$productionOutBoundShop = this.getProductionOutBoundShop();
               Object other$productionOutBoundShop = other.getProductionOutBoundShop();
               if (this$productionOutBoundShop == null
                  ? other$productionOutBoundShop == null
                  : this$productionOutBoundShop.equals(other$productionOutBoundShop)) {
                  Object this$productionOutBoundUser = this.getProductionOutBoundUser();
                  Object other$productionOutBoundUser = other.getProductionOutBoundUser();
                  if (this$productionOutBoundUser == null
                     ? other$productionOutBoundUser == null
                     : this$productionOutBoundUser.equals(other$productionOutBoundUser)) {
                     Object this$workOutBoundUser = this.getWorkOutBoundUser();
                     Object other$workOutBoundUser = other.getWorkOutBoundUser();
                     if (this$workOutBoundUser == null ? other$workOutBoundUser == null : this$workOutBoundUser.equals(other$workOutBoundUser)) {
                        Object this$outboundType = this.getOutboundType();
                        Object other$outboundType = other.getOutboundType();
                        if (this$outboundType == null ? other$outboundType == null : this$outboundType.equals(other$outboundType)) {
                           Object this$productionOutBoundUserIsRequired = this.getProductionOutBoundUserIsRequired();
                           Object other$productionOutBoundUserIsRequired = other.getProductionOutBoundUserIsRequired();
                           if (this$productionOutBoundUserIsRequired == null
                              ? other$productionOutBoundUserIsRequired == null
                              : this$productionOutBoundUserIsRequired.equals(other$productionOutBoundUserIsRequired)) {
                              Object this$cancelDestination = this.getCancelDestination();
                              Object other$cancelDestination = other.getCancelDestination();
                              if (this$cancelDestination == null ? other$cancelDestination == null : this$cancelDestination.equals(other$cancelDestination)) {
                                 Object this$returnedDestination = this.getReturnedDestination();
                                 Object other$returnedDestination = other.getReturnedDestination();
                                 if (this$returnedDestination == null
                                    ? other$returnedDestination == null
                                    : this$returnedDestination.equals(other$returnedDestination)) {
                                    Object this$showHalfOut = this.getShowHalfOut();
                                    Object other$showHalfOut = other.getShowHalfOut();
                                    if (this$showHalfOut == null ? other$showHalfOut == null : this$showHalfOut.equals(other$showHalfOut)) {
                                       Object this$outboundTypes = this.getOutboundTypes();
                                       Object other$outboundTypes = other.getOutboundTypes();
                                       return this$outboundTypes == null ? other$outboundTypes == null : this$outboundTypes.equals(other$outboundTypes);
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
      return other instanceof BasicOutbound;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolAuxMatToWorkShopWay = this.getBoolAuxMatToWorkShopWay();
      result = result * 59 + ($boolAuxMatToWorkShopWay == null ? 43 : $boolAuxMatToWorkShopWay.hashCode());
      Object $boolGasOutAfterInbound = this.getBoolGasOutAfterInbound();
      result = result * 59 + ($boolGasOutAfterInbound == null ? 43 : $boolGasOutAfterInbound.hashCode());
      Object $boolCanOutToOtherProject = this.getBoolCanOutToOtherProject();
      result = result * 59 + ($boolCanOutToOtherProject == null ? 43 : $boolCanOutToOtherProject.hashCode());
      Object $productionOutBoundShop = this.getProductionOutBoundShop();
      result = result * 59 + ($productionOutBoundShop == null ? 43 : $productionOutBoundShop.hashCode());
      Object $productionOutBoundUser = this.getProductionOutBoundUser();
      result = result * 59 + ($productionOutBoundUser == null ? 43 : $productionOutBoundUser.hashCode());
      Object $workOutBoundUser = this.getWorkOutBoundUser();
      result = result * 59 + ($workOutBoundUser == null ? 43 : $workOutBoundUser.hashCode());
      Object $outboundType = this.getOutboundType();
      result = result * 59 + ($outboundType == null ? 43 : $outboundType.hashCode());
      Object $productionOutBoundUserIsRequired = this.getProductionOutBoundUserIsRequired();
      result = result * 59 + ($productionOutBoundUserIsRequired == null ? 43 : $productionOutBoundUserIsRequired.hashCode());
      Object $cancelDestination = this.getCancelDestination();
      result = result * 59 + ($cancelDestination == null ? 43 : $cancelDestination.hashCode());
      Object $returnedDestination = this.getReturnedDestination();
      result = result * 59 + ($returnedDestination == null ? 43 : $returnedDestination.hashCode());
      Object $showHalfOut = this.getShowHalfOut();
      result = result * 59 + ($showHalfOut == null ? 43 : $showHalfOut.hashCode());
      Object $outboundTypes = this.getOutboundTypes();
      return result * 59 + ($outboundTypes == null ? 43 : $outboundTypes.hashCode());
   }

   @Override
   public String toString() {
      return "BasicOutbound(boolAuxMatToWorkShopWay="
         + this.getBoolAuxMatToWorkShopWay()
         + ", boolGasOutAfterInbound="
         + this.getBoolGasOutAfterInbound()
         + ", boolCanOutToOtherProject="
         + this.getBoolCanOutToOtherProject()
         + ", productionOutBoundShop="
         + this.getProductionOutBoundShop()
         + ", productionOutBoundUser="
         + this.getProductionOutBoundUser()
         + ", workOutBoundUser="
         + this.getWorkOutBoundUser()
         + ", outboundType="
         + this.getOutboundType()
         + ", outboundTypes="
         + this.getOutboundTypes()
         + ", productionOutBoundUserIsRequired="
         + this.getProductionOutBoundUserIsRequired()
         + ", cancelDestination="
         + this.getCancelDestination()
         + ", returnedDestination="
         + this.getReturnedDestination()
         + ", showHalfOut="
         + this.getShowHalfOut()
         + ")";
   }

   public BasicOutbound(
      final Boolean boolAuxMatToWorkShopWay,
      final Boolean boolGasOutAfterInbound,
      final Boolean boolCanOutToOtherProject,
      final Boolean productionOutBoundShop,
      final Boolean productionOutBoundUser,
      final Boolean workOutBoundUser,
      final Integer outboundType,
      final List<Integer> outboundTypes,
      final Boolean productionOutBoundUserIsRequired,
      final Integer cancelDestination,
      final Integer returnedDestination,
      final Boolean showHalfOut
   ) {
      this.boolAuxMatToWorkShopWay = boolAuxMatToWorkShopWay;
      this.boolGasOutAfterInbound = boolGasOutAfterInbound;
      this.boolCanOutToOtherProject = boolCanOutToOtherProject;
      this.productionOutBoundShop = productionOutBoundShop;
      this.productionOutBoundUser = productionOutBoundUser;
      this.workOutBoundUser = workOutBoundUser;
      this.outboundType = outboundType;
      this.outboundTypes = outboundTypes;
      this.productionOutBoundUserIsRequired = productionOutBoundUserIsRequired;
      this.cancelDestination = cancelDestination;
      this.returnedDestination = returnedDestination;
      this.showHalfOut = showHalfOut;
   }

   public BasicOutbound() {
   }

   public static class BasicOutboundBuilder {
      private Boolean boolAuxMatToWorkShopWay;
      private Boolean boolGasOutAfterInbound;
      private Boolean boolCanOutToOtherProject;
      private Boolean productionOutBoundShop;
      private Boolean productionOutBoundUser;
      private Boolean workOutBoundUser;
      private Integer outboundType;
      private List<Integer> outboundTypes;
      private Boolean productionOutBoundUserIsRequired;
      private Integer cancelDestination;
      private Integer returnedDestination;
      private Boolean showHalfOut;

      BasicOutboundBuilder() {
      }

      public BasicOutbound.BasicOutboundBuilder boolAuxMatToWorkShopWay(final Boolean boolAuxMatToWorkShopWay) {
         this.boolAuxMatToWorkShopWay = boolAuxMatToWorkShopWay;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder boolGasOutAfterInbound(final Boolean boolGasOutAfterInbound) {
         this.boolGasOutAfterInbound = boolGasOutAfterInbound;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder boolCanOutToOtherProject(final Boolean boolCanOutToOtherProject) {
         this.boolCanOutToOtherProject = boolCanOutToOtherProject;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder productionOutBoundShop(final Boolean productionOutBoundShop) {
         this.productionOutBoundShop = productionOutBoundShop;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder productionOutBoundUser(final Boolean productionOutBoundUser) {
         this.productionOutBoundUser = productionOutBoundUser;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder workOutBoundUser(final Boolean workOutBoundUser) {
         this.workOutBoundUser = workOutBoundUser;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder outboundType(final Integer outboundType) {
         this.outboundType = outboundType;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder outboundTypes(final List<Integer> outboundTypes) {
         this.outboundTypes = outboundTypes;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder productionOutBoundUserIsRequired(final Boolean productionOutBoundUserIsRequired) {
         this.productionOutBoundUserIsRequired = productionOutBoundUserIsRequired;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder cancelDestination(final Integer cancelDestination) {
         this.cancelDestination = cancelDestination;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder returnedDestination(final Integer returnedDestination) {
         this.returnedDestination = returnedDestination;
         return this;
      }

      public BasicOutbound.BasicOutboundBuilder showHalfOut(final Boolean showHalfOut) {
         this.showHalfOut = showHalfOut;
         return this;
      }

      public BasicOutbound build() {
         return new BasicOutbound(
            this.boolAuxMatToWorkShopWay,
            this.boolGasOutAfterInbound,
            this.boolCanOutToOtherProject,
            this.productionOutBoundShop,
            this.productionOutBoundUser,
            this.workOutBoundUser,
            this.outboundType,
            this.outboundTypes,
            this.productionOutBoundUserIsRequired,
            this.cancelDestination,
            this.returnedDestination,
            this.showHalfOut
         );
      }

      @Override
      public String toString() {
         return "BasicOutbound.BasicOutboundBuilder(boolAuxMatToWorkShopWay="
            + this.boolAuxMatToWorkShopWay
            + ", boolGasOutAfterInbound="
            + this.boolGasOutAfterInbound
            + ", boolCanOutToOtherProject="
            + this.boolCanOutToOtherProject
            + ", productionOutBoundShop="
            + this.productionOutBoundShop
            + ", productionOutBoundUser="
            + this.productionOutBoundUser
            + ", workOutBoundUser="
            + this.workOutBoundUser
            + ", outboundType="
            + this.outboundType
            + ", outboundTypes="
            + this.outboundTypes
            + ", productionOutBoundUserIsRequired="
            + this.productionOutBoundUserIsRequired
            + ", cancelDestination="
            + this.cancelDestination
            + ", returnedDestination="
            + this.returnedDestination
            + ", showHalfOut="
            + this.showHalfOut
            + ")";
      }
   }
}
