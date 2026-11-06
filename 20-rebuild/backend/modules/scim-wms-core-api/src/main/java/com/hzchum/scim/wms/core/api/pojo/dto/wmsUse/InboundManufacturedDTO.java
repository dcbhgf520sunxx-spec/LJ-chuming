package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class InboundManufacturedDTO {
   @ApiModelProperty("采购订单")
   private BriefPurchaseOrderDTO purchaseOrder;
   @ApiModelProperty("制成品入库单ID")
   private Long id;
   @ApiModelProperty("采购物料基础类型")
   private Integer basicClass;
   @ApiModelProperty("制成品入库单号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("物流单号")
   private String shipmentNumber;
   @ApiModelProperty("过磅重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty("审核状态")
   private Integer reviewStatus;
   @ApiModelProperty("物流订单")
   private LogisticsOrder logisticsOrder;
   @ApiModelProperty("审批的日志ID")
   private Long approveRecordId;
   @ApiModelProperty("审批日志信息")
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
   @ApiModelProperty("申请人ID")
   private Long applicantId;
   @ApiModelProperty("申请人名称")
   private String applicantName;
   @ApiModelProperty("入库日期  创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("累计入库额")
   private BigDecimal sumAmount;
   @ApiModelProperty("累计入库量")
   private BigDecimal sumLoadingWeight;
   @ApiModelProperty("采购单号")
   private String purchaseSN;
   @ApiModelProperty("采购单ID")
   private Long purchaseId;
   @ApiModelProperty("供应商")
   private Supplier supplier;
   @ApiModelProperty("项目信息")
   private List<ProjectInfo> projects;
   @ApiModelProperty("入库详情")
   private List<InboundDetailManufacturedDTO> list;
   @ApiModelProperty("审核通过时间")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty("入库金额[不含税]")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty("入库金额[含税]")
   private BigDecimal amount;

   public static InboundManufacturedDTO.InboundManufacturedDTOBuilder builder() {
      return new InboundManufacturedDTO.InboundManufacturedDTOBuilder();
   }

   public BriefPurchaseOrderDTO getPurchaseOrder() {
      return this.purchaseOrder;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LogisticsOrder getLogisticsOrder() {
      return this.logisticsOrder;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTOS() {
      return this.wmsApproveRecordFlowDTOS;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BigDecimal getSumAmount() {
      return this.sumAmount;
   }

   public BigDecimal getSumLoadingWeight() {
      return this.sumLoadingWeight;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public Supplier getSupplier() {
      return this.supplier;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public List<InboundDetailManufacturedDTO> getList() {
      return this.list;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setPurchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
      this.purchaseOrder = purchaseOrder;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setLogisticsOrder(final LogisticsOrder logisticsOrder) {
      this.logisticsOrder = logisticsOrder;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSumAmount(final BigDecimal sumAmount) {
      this.sumAmount = sumAmount;
   }

   public void setSumLoadingWeight(final BigDecimal sumLoadingWeight) {
      this.sumLoadingWeight = sumLoadingWeight;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setSupplier(final Supplier supplier) {
      this.supplier = supplier;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setList(final List<InboundDetailManufacturedDTO> list) {
      this.list = list;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundManufacturedDTO)) {
         return false;
      }

      InboundManufacturedDTO other = (InboundManufacturedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$approveRecordId = this.getApproveRecordId();
               Object other$approveRecordId = other.getApproveRecordId();
               if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$purchaseId = this.getPurchaseId();
                     Object other$purchaseId = other.getPurchaseId();
                     if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                        Object this$purchaseOrder = this.getPurchaseOrder();
                        Object other$purchaseOrder = other.getPurchaseOrder();
                        if (this$purchaseOrder == null ? other$purchaseOrder == null : this$purchaseOrder.equals(other$purchaseOrder)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$licensePlate = this.getLicensePlate();
                              Object other$licensePlate = other.getLicensePlate();
                              if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                 Object this$shipmentNumber = this.getShipmentNumber();
                                 Object other$shipmentNumber = other.getShipmentNumber();
                                 if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                    Object this$loadingWeight = this.getLoadingWeight();
                                    Object other$loadingWeight = other.getLoadingWeight();
                                    if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                                       Object this$logisticsOrder = this.getLogisticsOrder();
                                       Object other$logisticsOrder = other.getLogisticsOrder();
                                       if (this$logisticsOrder == null ? other$logisticsOrder == null : this$logisticsOrder.equals(other$logisticsOrder)) {
                                          Object this$wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
                                          Object other$wmsApproveRecordFlowDTOS = other.getWmsApproveRecordFlowDTOS();
                                          if (this$wmsApproveRecordFlowDTOS == null
                                             ? other$wmsApproveRecordFlowDTOS == null
                                             : this$wmsApproveRecordFlowDTOS.equals(other$wmsApproveRecordFlowDTOS)) {
                                             Object this$applicantName = this.getApplicantName();
                                             Object other$applicantName = other.getApplicantName();
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$sumAmount = this.getSumAmount();
                                                   Object other$sumAmount = other.getSumAmount();
                                                   if (this$sumAmount == null ? other$sumAmount == null : this$sumAmount.equals(other$sumAmount)) {
                                                      Object this$sumLoadingWeight = this.getSumLoadingWeight();
                                                      Object other$sumLoadingWeight = other.getSumLoadingWeight();
                                                      if (this$sumLoadingWeight == null
                                                         ? other$sumLoadingWeight == null
                                                         : this$sumLoadingWeight.equals(other$sumLoadingWeight)) {
                                                         Object this$purchaseSN = this.getPurchaseSN();
                                                         Object other$purchaseSN = other.getPurchaseSN();
                                                         if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                                            Object this$supplier = this.getSupplier();
                                                            Object other$supplier = other.getSupplier();
                                                            if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                               Object this$projects = this.getProjects();
                                                               Object other$projects = other.getProjects();
                                                               if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                                                                  Object this$list = this.getList();
                                                                  Object other$list = other.getList();
                                                                  if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                                     Object this$reviewPassTime = this.getReviewPassTime();
                                                                     Object other$reviewPassTime = other.getReviewPassTime();
                                                                     if (this$reviewPassTime == null
                                                                        ? other$reviewPassTime == null
                                                                        : this$reviewPassTime.equals(other$reviewPassTime)) {
                                                                        Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                        Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                        if (this$amountExcludingVat == null
                                                                           ? other$amountExcludingVat == null
                                                                           : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                           Object this$amount = this.getAmount();
                                                                           Object other$amount = other.getAmount();
                                                                           return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
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
      return other instanceof InboundManufacturedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $purchaseOrder = this.getPurchaseOrder();
      result = result * 59 + ($purchaseOrder == null ? 43 : $purchaseOrder.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $logisticsOrder = this.getLogisticsOrder();
      result = result * 59 + ($logisticsOrder == null ? 43 : $logisticsOrder.hashCode());
      Object $wmsApproveRecordFlowDTOS = this.getWmsApproveRecordFlowDTOS();
      result = result * 59 + ($wmsApproveRecordFlowDTOS == null ? 43 : $wmsApproveRecordFlowDTOS.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $sumAmount = this.getSumAmount();
      result = result * 59 + ($sumAmount == null ? 43 : $sumAmount.hashCode());
      Object $sumLoadingWeight = this.getSumLoadingWeight();
      result = result * 59 + ($sumLoadingWeight == null ? 43 : $sumLoadingWeight.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "InboundManufacturedDTO(purchaseOrder="
         + this.getPurchaseOrder()
         + ", id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", logisticsOrder="
         + this.getLogisticsOrder()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsApproveRecordFlowDTOS="
         + this.getWmsApproveRecordFlowDTOS()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", createTime="
         + this.getCreateTime()
         + ", sumAmount="
         + this.getSumAmount()
         + ", sumLoadingWeight="
         + this.getSumLoadingWeight()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", supplier="
         + this.getSupplier()
         + ", projects="
         + this.getProjects()
         + ", list="
         + this.getList()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", amount="
         + this.getAmount()
         + ")";
   }

   public InboundManufacturedDTO(
      final BriefPurchaseOrderDTO purchaseOrder,
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final String licensePlate,
      final String shipmentNumber,
      final BigDecimal loadingWeight,
      final Integer reviewStatus,
      final LogisticsOrder logisticsOrder,
      final Long approveRecordId,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime createTime,
      final BigDecimal sumAmount,
      final BigDecimal sumLoadingWeight,
      final String purchaseSN,
      final Long purchaseId,
      final Supplier supplier,
      final List<ProjectInfo> projects,
      final List<InboundDetailManufacturedDTO> list,
      final LocalDateTime reviewPassTime,
      final BigDecimal amountExcludingVat,
      final BigDecimal amount
   ) {
      this.purchaseOrder = purchaseOrder;
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.loadingWeight = loadingWeight;
      this.reviewStatus = reviewStatus;
      this.logisticsOrder = logisticsOrder;
      this.approveRecordId = approveRecordId;
      this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.createTime = createTime;
      this.sumAmount = sumAmount;
      this.sumLoadingWeight = sumLoadingWeight;
      this.purchaseSN = purchaseSN;
      this.purchaseId = purchaseId;
      this.supplier = supplier;
      this.projects = projects;
      this.list = list;
      this.reviewPassTime = reviewPassTime;
      this.amountExcludingVat = amountExcludingVat;
      this.amount = amount;
   }

   public InboundManufacturedDTO() {
   }

   public static class InboundManufacturedDTOBuilder {
      private BriefPurchaseOrderDTO purchaseOrder;
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private String licensePlate;
      private String shipmentNumber;
      private BigDecimal loadingWeight;
      private Integer reviewStatus;
      private LogisticsOrder logisticsOrder;
      private Long approveRecordId;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime createTime;
      private BigDecimal sumAmount;
      private BigDecimal sumLoadingWeight;
      private String purchaseSN;
      private Long purchaseId;
      private Supplier supplier;
      private List<ProjectInfo> projects;
      private List<InboundDetailManufacturedDTO> list;
      private LocalDateTime reviewPassTime;
      private BigDecimal amountExcludingVat;
      private BigDecimal amount;

      InboundManufacturedDTOBuilder() {
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder purchaseOrder(final BriefPurchaseOrderDTO purchaseOrder) {
         this.purchaseOrder = purchaseOrder;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder loadingWeight(final BigDecimal loadingWeight) {
         this.loadingWeight = loadingWeight;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder logisticsOrder(final LogisticsOrder logisticsOrder) {
         this.logisticsOrder = logisticsOrder;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder wmsApproveRecordFlowDTOS(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTOS) {
         this.wmsApproveRecordFlowDTOS = wmsApproveRecordFlowDTOS;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder sumAmount(final BigDecimal sumAmount) {
         this.sumAmount = sumAmount;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder sumLoadingWeight(final BigDecimal sumLoadingWeight) {
         this.sumLoadingWeight = sumLoadingWeight;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder supplier(final Supplier supplier) {
         this.supplier = supplier;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder projects(final List<ProjectInfo> projects) {
         this.projects = projects;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder list(final List<InboundDetailManufacturedDTO> list) {
         this.list = list;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public InboundManufacturedDTO.InboundManufacturedDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundManufacturedDTO build() {
         return new InboundManufacturedDTO(
            this.purchaseOrder,
            this.id,
            this.basicClass,
            this.serialNumber,
            this.licensePlate,
            this.shipmentNumber,
            this.loadingWeight,
            this.reviewStatus,
            this.logisticsOrder,
            this.approveRecordId,
            this.wmsApproveRecordFlowDTOS,
            this.applicantId,
            this.applicantName,
            this.createTime,
            this.sumAmount,
            this.sumLoadingWeight,
            this.purchaseSN,
            this.purchaseId,
            this.supplier,
            this.projects,
            this.list,
            this.reviewPassTime,
            this.amountExcludingVat,
            this.amount
         );
      }

      @Override
      public String toString() {
         return "InboundManufacturedDTO.InboundManufacturedDTOBuilder(purchaseOrder="
            + this.purchaseOrder
            + ", id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", licensePlate="
            + this.licensePlate
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", loadingWeight="
            + this.loadingWeight
            + ", reviewStatus="
            + this.reviewStatus
            + ", logisticsOrder="
            + this.logisticsOrder
            + ", approveRecordId="
            + this.approveRecordId
            + ", wmsApproveRecordFlowDTOS="
            + this.wmsApproveRecordFlowDTOS
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", createTime="
            + this.createTime
            + ", sumAmount="
            + this.sumAmount
            + ", sumLoadingWeight="
            + this.sumLoadingWeight
            + ", purchaseSN="
            + this.purchaseSN
            + ", purchaseId="
            + this.purchaseId
            + ", supplier="
            + this.supplier
            + ", projects="
            + this.projects
            + ", list="
            + this.list
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", amount="
            + this.amount
            + ")";
      }
   }
}
