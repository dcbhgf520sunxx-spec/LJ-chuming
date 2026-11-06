package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class InboundDTOParam {
   private Long id;
   private Integer basicClass;
   private LogisticsOrder logistics;
   private Long purchaseId;
   private String projectIds;
   private String licensePlate;
   private String shipmentNumber;
   private BigDecimal loadingWeight;
   private BigDecimal inboundTotalWeight;
   private String serialNumber;
   private Integer supplyType;
   private Integer reviewStatus;
   private String approvalComments;
   List<InboundDetailDTOParam> list;
   private String projectId;
   private String cause;
   private Inbound inbound;
   private List<InboundDetail> inboundDetails;
   @ApiModelProperty(name = "入库审核修改金额专用类")
   private List<InboundDetailMoneyDTOParam> inboundDetailMoneyDTOParams;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   private Boolean boolNestSurplus;
   private Long mesWorkshopId;
   private LocalDateTime clickTime;
   private Long loginUserId;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public LogisticsOrder getLogistics() {
      return this.logistics;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public BigDecimal getInboundTotalWeight() {
      return this.inboundTotalWeight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getSupplyType() {
      return this.supplyType;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public List<InboundDetailDTOParam> getList() {
      return this.list;
   }

   public String getProjectId() {
      return this.projectId;
   }

   public String getCause() {
      return this.cause;
   }

   public Inbound getInbound() {
      return this.inbound;
   }

   public List<InboundDetail> getInboundDetails() {
      return this.inboundDetails;
   }

   public List<InboundDetailMoneyDTOParam> getInboundDetailMoneyDTOParams() {
      return this.inboundDetailMoneyDTOParams;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public Long getMesWorkshopId() {
      return this.mesWorkshopId;
   }

   public LocalDateTime getClickTime() {
      return this.clickTime;
   }

   public Long getLoginUserId() {
      return this.loginUserId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setLogistics(final LogisticsOrder logistics) {
      this.logistics = logistics;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setInboundTotalWeight(final BigDecimal inboundTotalWeight) {
      this.inboundTotalWeight = inboundTotalWeight;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplyType(final Integer supplyType) {
      this.supplyType = supplyType;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setList(final List<InboundDetailDTOParam> list) {
      this.list = list;
   }

   public void setProjectId(final String projectId) {
      this.projectId = projectId;
   }

   public void setCause(final String cause) {
      this.cause = cause;
   }

   public void setInbound(final Inbound inbound) {
      this.inbound = inbound;
   }

   public void setInboundDetails(final List<InboundDetail> inboundDetails) {
      this.inboundDetails = inboundDetails;
   }

   public void setInboundDetailMoneyDTOParams(final List<InboundDetailMoneyDTOParam> inboundDetailMoneyDTOParams) {
      this.inboundDetailMoneyDTOParams = inboundDetailMoneyDTOParams;
   }

   public void setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
   }

   public void setMesWorkshopId(final Long mesWorkshopId) {
      this.mesWorkshopId = mesWorkshopId;
   }

   public void setClickTime(final LocalDateTime clickTime) {
      this.clickTime = clickTime;
   }

   public void setLoginUserId(final Long loginUserId) {
      this.loginUserId = loginUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDTOParam)) {
         return false;
      }

      InboundDTOParam other = (InboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$supplyType = this.getSupplyType();
               Object other$supplyType = other.getSupplyType();
               if (this$supplyType == null ? other$supplyType == null : this$supplyType.equals(other$supplyType)) {
                  Object this$reviewStatus = this.getReviewStatus();
                  Object other$reviewStatus = other.getReviewStatus();
                  if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                     Object this$boolNestSurplus = this.getBoolNestSurplus();
                     Object other$boolNestSurplus = other.getBoolNestSurplus();
                     if (this$boolNestSurplus == null ? other$boolNestSurplus == null : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                        Object this$mesWorkshopId = this.getMesWorkshopId();
                        Object other$mesWorkshopId = other.getMesWorkshopId();
                        if (this$mesWorkshopId == null ? other$mesWorkshopId == null : this$mesWorkshopId.equals(other$mesWorkshopId)) {
                           Object this$loginUserId = this.getLoginUserId();
                           Object other$loginUserId = other.getLoginUserId();
                           if (this$loginUserId == null ? other$loginUserId == null : this$loginUserId.equals(other$loginUserId)) {
                              Object this$logistics = this.getLogistics();
                              Object other$logistics = other.getLogistics();
                              if (this$logistics == null ? other$logistics == null : this$logistics.equals(other$logistics)) {
                                 Object this$projectIds = this.getProjectIds();
                                 Object other$projectIds = other.getProjectIds();
                                 if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                    Object this$licensePlate = this.getLicensePlate();
                                    Object other$licensePlate = other.getLicensePlate();
                                    if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                       Object this$shipmentNumber = this.getShipmentNumber();
                                       Object other$shipmentNumber = other.getShipmentNumber();
                                       if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                          Object this$loadingWeight = this.getLoadingWeight();
                                          Object other$loadingWeight = other.getLoadingWeight();
                                          if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                             Object this$inboundTotalWeight = this.getInboundTotalWeight();
                                             Object other$inboundTotalWeight = other.getInboundTotalWeight();
                                             if (this$inboundTotalWeight == null
                                                ? other$inboundTotalWeight == null
                                                : this$inboundTotalWeight.equals(other$inboundTotalWeight)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$approvalComments = this.getApprovalComments();
                                                   Object other$approvalComments = other.getApprovalComments();
                                                   if (this$approvalComments == null
                                                      ? other$approvalComments == null
                                                      : this$approvalComments.equals(other$approvalComments)) {
                                                      Object this$list = this.getList();
                                                      Object other$list = other.getList();
                                                      if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                         Object this$projectId = this.getProjectId();
                                                         Object other$projectId = other.getProjectId();
                                                         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                                                            Object this$cause = this.getCause();
                                                            Object other$cause = other.getCause();
                                                            if (this$cause == null ? other$cause == null : this$cause.equals(other$cause)) {
                                                               Object this$inbound = this.getInbound();
                                                               Object other$inbound = other.getInbound();
                                                               if (this$inbound == null ? other$inbound == null : this$inbound.equals(other$inbound)) {
                                                                  Object this$inboundDetails = this.getInboundDetails();
                                                                  Object other$inboundDetails = other.getInboundDetails();
                                                                  if (this$inboundDetails == null
                                                                     ? other$inboundDetails == null
                                                                     : this$inboundDetails.equals(other$inboundDetails)) {
                                                                     Object this$inboundDetailMoneyDTOParams = this.getInboundDetailMoneyDTOParams();
                                                                     Object other$inboundDetailMoneyDTOParams = other.getInboundDetailMoneyDTOParams();
                                                                     if (this$inboundDetailMoneyDTOParams == null
                                                                        ? other$inboundDetailMoneyDTOParams == null
                                                                        : this$inboundDetailMoneyDTOParams.equals(other$inboundDetailMoneyDTOParams)) {
                                                                        Object this$clickTime = this.getClickTime();
                                                                        Object other$clickTime = other.getClickTime();
                                                                        return this$clickTime == null
                                                                           ? other$clickTime == null
                                                                           : this$clickTime.equals(other$clickTime);
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
      return other instanceof InboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $supplyType = this.getSupplyType();
      result = result * 59 + ($supplyType == null ? 43 : $supplyType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $mesWorkshopId = this.getMesWorkshopId();
      result = result * 59 + ($mesWorkshopId == null ? 43 : $mesWorkshopId.hashCode());
      Object $loginUserId = this.getLoginUserId();
      result = result * 59 + ($loginUserId == null ? 43 : $loginUserId.hashCode());
      Object $logistics = this.getLogistics();
      result = result * 59 + ($logistics == null ? 43 : $logistics.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $inboundTotalWeight = this.getInboundTotalWeight();
      result = result * 59 + ($inboundTotalWeight == null ? 43 : $inboundTotalWeight.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $cause = this.getCause();
      result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
      Object $inbound = this.getInbound();
      result = result * 59 + ($inbound == null ? 43 : $inbound.hashCode());
      Object $inboundDetails = this.getInboundDetails();
      result = result * 59 + ($inboundDetails == null ? 43 : $inboundDetails.hashCode());
      Object $inboundDetailMoneyDTOParams = this.getInboundDetailMoneyDTOParams();
      result = result * 59 + ($inboundDetailMoneyDTOParams == null ? 43 : $inboundDetailMoneyDTOParams.hashCode());
      Object $clickTime = this.getClickTime();
      return result * 59 + ($clickTime == null ? 43 : $clickTime.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", logistics="
         + this.getLogistics()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", projectIds="
         + this.getProjectIds()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", inboundTotalWeight="
         + this.getInboundTotalWeight()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplyType="
         + this.getSupplyType()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", list="
         + this.getList()
         + ", projectId="
         + this.getProjectId()
         + ", cause="
         + this.getCause()
         + ", inbound="
         + this.getInbound()
         + ", inboundDetails="
         + this.getInboundDetails()
         + ", inboundDetailMoneyDTOParams="
         + this.getInboundDetailMoneyDTOParams()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ", mesWorkshopId="
         + this.getMesWorkshopId()
         + ", clickTime="
         + this.getClickTime()
         + ", loginUserId="
         + this.getLoginUserId()
         + ")";
   }
}
