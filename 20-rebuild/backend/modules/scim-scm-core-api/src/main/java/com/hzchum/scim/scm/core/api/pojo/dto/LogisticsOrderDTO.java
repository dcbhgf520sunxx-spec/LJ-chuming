package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class LogisticsOrderDTO {
   private Long id;
   private Integer basicClass;
   private Integer purchaseType;
   private Integer invoiceType;
   @ApiModelProperty(name = "logisticsTransportType", value = "物流运输方式,参考枚举[LogisticsTransportTypeEnum]")
   private Integer logisticsTransportType;
   private String serialNumber;
   private String shipmentNumber;
   private BriefIdAndSNDTO inboundReceipt;
   private BriefIdAndSNDTO purchaseOrder;
   private String licensePlate;
   private String projectIds;
   private List<ProjectInfo> projects;
   private BigDecimal loadingWeight;
   private Integer taxRate;
   private BigDecimal freight;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private String remark;
   private Long supplierId;
   private String supplierName;
   private Integer inboundReviewStatus;
   private String applicantName;
   private LocalDateTime userUpdateTime;
   private LocalDateTime createTime;

   public static LogisticsOrderDTO.LogisticsOrderDTOBuilder builder() {
      return new LogisticsOrderDTO.LogisticsOrderDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public BriefIdAndSNDTO getInboundReceipt() {
      return this.inboundReceipt;
   }

   public BriefIdAndSNDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public Integer getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getInboundReviewStatus() {
      return this.inboundReviewStatus;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setInboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
      this.inboundReceipt = inboundReceipt;
   }

   public void setPurchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setTaxRate(final Integer taxRate) {
      this.taxRate = taxRate;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setInboundReviewStatus(final Integer inboundReviewStatus) {
      this.inboundReviewStatus = inboundReviewStatus;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsOrderDTO)) {
         return false;
      }

      LogisticsOrderDTO other = (LogisticsOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$purchaseType = this.getPurchaseType();
            Object other$purchaseType = other.getPurchaseType();
            if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$logisticsTransportType = this.getLogisticsTransportType();
                  Object other$logisticsTransportType = other.getLogisticsTransportType();
                  if (this$logisticsTransportType == null
                     ? other$logisticsTransportType == null
                     : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                     Object this$taxRate = this.getTaxRate();
                     Object other$taxRate = other.getTaxRate();
                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$inboundReviewStatus = this.getInboundReviewStatus();
                           Object other$inboundReviewStatus = other.getInboundReviewStatus();
                           if (this$inboundReviewStatus == null
                              ? other$inboundReviewStatus == null
                              : this$inboundReviewStatus.equals(other$inboundReviewStatus)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$shipmentNumber = this.getShipmentNumber();
                                 Object other$shipmentNumber = other.getShipmentNumber();
                                 if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                    Object this$inboundReceipt = this.getInboundReceipt();
                                    Object other$inboundReceipt = other.getInboundReceipt();
                                    if (this$inboundReceipt == null ? other$inboundReceipt == null : this$inboundReceipt.equals(other$inboundReceipt)) {
                                       Object this$purchaseOrder = this.getPurchaseOrder();
                                       Object other$purchaseOrder = other.getPurchaseOrder();
                                       if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                                          Object this$licensePlate = this.getLicensePlate();
                                          Object other$licensePlate = other.getLicensePlate();
                                          if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                             Object this$projectIds = this.getProjectIds();
                                             Object other$projectIds = other.getProjectIds();
                                             if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                Object this$projects = this.getProjects();
                                                Object other$projects = other.getProjects();
                                                if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                   Object this$loadingWeight = this.getLoadingWeight();
                                                   Object other$loadingWeight = other.getLoadingWeight();
                                                   if (this$loadingWeight == null
                                                      ? other$loadingWeight == null
                                                      : this$loadingWeight.equals(other$loadingWeight)) {
                                                      Object this$freight = this.getFreight();
                                                      Object other$freight = other.getFreight();
                                                      if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                                         Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                         Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                         if (this$amountExcludingVAT == null
                                                            ? other$amountExcludingVAT == null
                                                            : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                                            Object this$inputVAT = this.getInputVAT();
                                                            Object other$inputVAT = other.getInputVAT();
                                                            if (this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$supplierName = this.getSupplierName();
                                                                  Object other$supplierName = other.getSupplierName();
                                                                  if (this$supplierName == null
                                                                     ? other$supplierName == null
                                                                     : this$supplierName.equals(other$supplierName)) {
                                                                     Object this$applicantName = this.getApplicantName();
                                                                     Object other$applicantName = other.getApplicantName();
                                                                     if (this$applicantName == null
                                                                        ? other$applicantName == null
                                                                        : this$applicantName.equals(other$applicantName)) {
                                                                        Object this$userUpdateTime = this.getUserUpdateTime();
                                                                        Object other$userUpdateTime = other.getUserUpdateTime();
                                                                        if (this$userUpdateTime == null
                                                                           ? other$userUpdateTime == null
                                                                           : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                           Object this$createTime = this.getCreateTime();
                                                                           Object other$createTime = other.getCreateTime();
                                                                           return this$createTime == null
                                                                              ? other$createTime == null
                                                                              : this$createTime.equals(other$createTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LogisticsOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $inboundReviewStatus = this.getInboundReviewStatus();
      result = result * 59 + ($inboundReviewStatus == null ? 43 : $inboundReviewStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $inboundReceipt = this.getInboundReceipt();
      result = result * 59 + ($inboundReceipt == null ? 43 : $inboundReceipt.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsOrderDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", inboundReceipt="
         + this.getInboundReceipt()
         + ", purchaseOrder="
         + this.getPurchaseOrder()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", projectIds="
         + this.getProjectIds()
         + ", projects="
         + this.getProjects()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", taxRate="
         + this.getTaxRate()
         + ", freight="
         + this.getFreight()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", remark="
         + this.getRemark()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", inboundReviewStatus="
         + this.getInboundReviewStatus()
         + ", applicantName="
         + this.getApplicantName()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public LogisticsOrderDTO(
      final Long id,
      final Integer basicClass,
      final Integer purchaseType,
      final Integer invoiceType,
      final Integer logisticsTransportType,
      final String serialNumber,
      final String shipmentNumber,
      final BriefIdAndSNDTO inboundReceipt,
      final BriefIdAndSNDTO purchaseOrder,
      final String licensePlate,
      final String projectIds,
      final List<ProjectInfo> projects,
      final BigDecimal loadingWeight,
      final Integer taxRate,
      final BigDecimal freight,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final String remark,
      final Long supplierId,
      final String supplierName,
      final Integer inboundReviewStatus,
      final String applicantName,
      final LocalDateTime userUpdateTime,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.purchaseType = purchaseType;
      this.invoiceType = invoiceType;
      this.logisticsTransportType = logisticsTransportType;
      this.serialNumber = serialNumber;
      this.shipmentNumber = shipmentNumber;
      this.inboundReceipt = inboundReceipt;
      this.purchaseOrder = purchaseOrder;
      this.licensePlate = licensePlate;
      this.projectIds = projectIds;
      this.projects = projects;
      this.loadingWeight = loadingWeight;
      this.taxRate = taxRate;
      this.freight = freight;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.remark = remark;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.inboundReviewStatus = inboundReviewStatus;
      this.applicantName = applicantName;
      this.userUpdateTime = userUpdateTime;
      this.createTime = createTime;
   }

   public LogisticsOrderDTO() {
   }

   public static class LogisticsOrderDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Integer purchaseType;
      private Integer invoiceType;
      private Integer logisticsTransportType;
      private String serialNumber;
      private String shipmentNumber;
      private BriefIdAndSNDTO inboundReceipt;
      private BriefIdAndSNDTO purchaseOrder;
      private String licensePlate;
      private String projectIds;
      private List<ProjectInfo> projects;
      private BigDecimal loadingWeight;
      private Integer taxRate;
      private BigDecimal freight;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private String remark;
      private Long supplierId;
      private String supplierName;
      private Integer inboundReviewStatus;
      private String applicantName;
      private LocalDateTime userUpdateTime;
      private LocalDateTime createTime;

      LogisticsOrderDTOBuilder() {
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder purchaseType(final Integer purchaseType) {
         this.purchaseType = purchaseType;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder logisticsTransportType(final Integer logisticsTransportType) {
         this.logisticsTransportType = logisticsTransportType;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder inboundReceipt(final BriefIdAndSNDTO inboundReceipt) {
         this.inboundReceipt = inboundReceipt;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder purchaseOrder(final BriefIdAndSNDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder taxRate(final Integer taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder inboundReviewStatus(final Integer inboundReviewStatus) {
         this.inboundReviewStatus = inboundReviewStatus;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      public LogisticsOrderDTO.LogisticsOrderDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public LogisticsOrderDTO build() {
         return new LogisticsOrderDTO(
            this.id,
            this.basicClass,
            this.purchaseType,
            this.invoiceType,
            this.logisticsTransportType,
            this.serialNumber,
            this.shipmentNumber,
            this.inboundReceipt,
            this.purchaseOrder,
            this.licensePlate,
            this.projectIds,
            this.projects,
            this.loadingWeight,
            this.taxRate,
            this.freight,
            this.amountExcludingVAT,
            this.inputVAT,
            this.remark,
            this.supplierId,
            this.supplierName,
            this.inboundReviewStatus,
            this.applicantName,
            this.userUpdateTime,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "LogisticsOrderDTO.LogisticsOrderDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", purchaseType="
            + this.purchaseType
            + ", invoiceType="
            + this.invoiceType
            + ", logisticsTransportType="
            + this.logisticsTransportType
            + ", serialNumber="
            + this.serialNumber
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", inboundReceipt="
            + this.inboundReceipt
            + ", purchaseOrder="
            + this.purchaseOrder
            + ", licensePlate="
            + this.licensePlate
            + ", projectIds="
            + this.projectIds
            + ", projects="
            + this.projects
            + ", loadingWeight="
            + this.loadingWeight
            + ", taxRate="
            + this.taxRate
            + ", freight="
            + this.freight
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", remark="
            + this.remark
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", inboundReviewStatus="
            + this.inboundReviewStatus
            + ", applicantName="
            + this.applicantName
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
