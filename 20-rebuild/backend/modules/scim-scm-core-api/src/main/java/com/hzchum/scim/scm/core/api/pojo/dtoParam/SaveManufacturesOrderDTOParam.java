package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.scm.core.api.enums.DestinationEnum;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;

public class SaveManufacturesOrderDTOParam {
   private Long id;
   @NotNull(message = "物料种类不能为空")
   private Integer basicClass;
   private String serialNumber;
   private List<Long> projectIds;
   private List<Long> monomerIds;
   private Long branchCompanyId;
   private Long supplierId;
   private Long factoryId;
   private BigDecimal artifactMete;
   private BigDecimal enclosureMete;
   private Integer weightMeasurementMode;
   private String enclUnit;
   private BigDecimal amount;
   private Integer taxRate;
   private Integer logisticsPayerType;
   private Integer drawingDeepening;
   @EnumValidator(value = DestinationEnum.class, message = "请选择目的地")
   private Integer destination;
   private List<Long> attachmentIds;
   private Integer invoiceType;
   private String remark;
   List<AreaDTOParam> list;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public List<Long> getMonomerIds() {
      return this.monomerIds;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public BigDecimal getArtifactMete() {
      return this.artifactMete;
   }

   public BigDecimal getEnclosureMete() {
      return this.enclosureMete;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public String getEnclUnit() {
      return this.enclUnit;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getTaxRate() {
      return this.taxRate;
   }

   public Integer getLogisticsPayerType() {
      return this.logisticsPayerType;
   }

   public Integer getDrawingDeepening() {
      return this.drawingDeepening;
   }

   public Integer getDestination() {
      return this.destination;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AreaDTOParam> getList() {
      return this.list;
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

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   public void setMonomerIds(final List<Long> monomerIds) {
      this.monomerIds = monomerIds;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setArtifactMete(final BigDecimal artifactMete) {
      this.artifactMete = artifactMete;
   }

   public void setEnclosureMete(final BigDecimal enclosureMete) {
      this.enclosureMete = enclosureMete;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setEnclUnit(final String enclUnit) {
      this.enclUnit = enclUnit;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setTaxRate(final Integer taxRate) {
      this.taxRate = taxRate;
   }

   public void setLogisticsPayerType(final Integer logisticsPayerType) {
      this.logisticsPayerType = logisticsPayerType;
   }

   public void setDrawingDeepening(final Integer drawingDeepening) {
      this.drawingDeepening = drawingDeepening;
   }

   public void setDestination(final Integer destination) {
      this.destination = destination;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setList(final List<AreaDTOParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveManufacturesOrderDTOParam)) {
         return false;
      }

      SaveManufacturesOrderDTOParam other = (SaveManufacturesOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                     Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                     if (this$weightMeasurementMode == null
                        ? other$weightMeasurementMode == null
                        : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                        Object this$taxRate = this.getTaxRate();
                        Object other$taxRate = other.getTaxRate();
                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                           Object this$logisticsPayerType = this.getLogisticsPayerType();
                           Object other$logisticsPayerType = other.getLogisticsPayerType();
                           if (this$logisticsPayerType == null ? other$logisticsPayerType == null : this$logisticsPayerType.equals(other$logisticsPayerType)) {
                              Object this$drawingDeepening = this.getDrawingDeepening();
                              Object other$drawingDeepening = other.getDrawingDeepening();
                              if (this$drawingDeepening == null ? other$drawingDeepening == null : this$drawingDeepening.equals(other$drawingDeepening)) {
                                 Object this$destination = this.getDestination();
                                 Object other$destination = other.getDestination();
                                 if (this$destination == null ? other$destination == null : this$destination.equals(other$destination)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$projectIds = this.getProjectIds();
                                          Object other$projectIds = other.getProjectIds();
                                          if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                             Object this$monomerIds = this.getMonomerIds();
                                             Object other$monomerIds = other.getMonomerIds();
                                             if (this$monomerIds == null ? other$monomerIds == null : this$monomerIds.equals(other$monomerIds)) {
                                                Object this$artifactMete = this.getArtifactMete();
                                                Object other$artifactMete = other.getArtifactMete();
                                                if (this$artifactMete == null ? other$artifactMete == null : this$artifactMete.equals(other$artifactMete)) {
                                                   Object this$enclosureMete = this.getEnclosureMete();
                                                   Object other$enclosureMete = other.getEnclosureMete();
                                                   if (this$enclosureMete == null
                                                      ? other$enclosureMete == null
                                                      : this$enclosureMete.equals(other$enclosureMete)) {
                                                      Object this$enclUnit = this.getEnclUnit();
                                                      Object other$enclUnit = other.getEnclUnit();
                                                      if (this$enclUnit == null ? other$enclUnit == null : this$enclUnit.equals(other$enclUnit)) {
                                                         Object this$amount = this.getAmount();
                                                         Object other$amount = other.getAmount();
                                                         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                            Object this$attachmentIds = this.getAttachmentIds();
                                                            Object other$attachmentIds = other.getAttachmentIds();
                                                            if (this$attachmentIds == null
                                                               ? other$attachmentIds == null
                                                               : this$attachmentIds.equals(other$attachmentIds)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$list = this.getList();
                                                                  Object other$list = other.getList();
                                                                  return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof SaveManufacturesOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $logisticsPayerType = this.getLogisticsPayerType();
      result = result * 59 + ($logisticsPayerType == null ? 43 : $logisticsPayerType.hashCode());
      Object $drawingDeepening = this.getDrawingDeepening();
      result = result * 59 + ($drawingDeepening == null ? 43 : $drawingDeepening.hashCode());
      Object $destination = this.getDestination();
      result = result * 59 + ($destination == null ? 43 : $destination.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $monomerIds = this.getMonomerIds();
      result = result * 59 + ($monomerIds == null ? 43 : $monomerIds.hashCode());
      Object $artifactMete = this.getArtifactMete();
      result = result * 59 + ($artifactMete == null ? 43 : $artifactMete.hashCode());
      Object $enclosureMete = this.getEnclosureMete();
      result = result * 59 + ($enclosureMete == null ? 43 : $enclosureMete.hashCode());
      Object $enclUnit = this.getEnclUnit();
      result = result * 59 + ($enclUnit == null ? 43 : $enclUnit.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "SaveManufacturesOrderDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectIds="
         + this.getProjectIds()
         + ", monomerIds="
         + this.getMonomerIds()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", supplierId="
         + this.getSupplierId()
         + ", factoryId="
         + this.getFactoryId()
         + ", artifactMete="
         + this.getArtifactMete()
         + ", enclosureMete="
         + this.getEnclosureMete()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", enclUnit="
         + this.getEnclUnit()
         + ", amount="
         + this.getAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", logisticsPayerType="
         + this.getLogisticsPayerType()
         + ", drawingDeepening="
         + this.getDrawingDeepening()
         + ", destination="
         + this.getDestination()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", remark="
         + this.getRemark()
         + ", list="
         + this.getList()
         + ")";
   }
}
