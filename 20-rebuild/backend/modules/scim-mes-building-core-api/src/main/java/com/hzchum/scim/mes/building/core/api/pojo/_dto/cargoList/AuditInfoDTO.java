package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.cargoList.SupplierPriceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("审核信息")
public class AuditInfoDTO {
   @ApiModelProperty("发运id")
   @JsonInclude(Include.NON_NULL)
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目的简称")
   private String shortName;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty("业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty("结构计量方式 1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty("围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty("管理费=合同额*管理费率")
   private BigDecimal managementFee;
   @ApiModelProperty("累计发货额")
   private BigDecimal totalDeliveryAmount;
   @ApiModelProperty("累计已收款")
   private BigDecimal totalCollectionAmount;
   @ApiModelProperty("可用余额=累计已收款-管理费-累计发货额")
   private BigDecimal availableAmount;
   @ApiModelProperty("安全余额=(合同额-累计发货额)*0.3")
   private BigDecimal safeAmount;
   @ApiModelProperty("本次发货额")
   private BigDecimal deliveryAmount;
   @ApiModelProperty("合同应收=合同额-已收款")
   private BigDecimal contractReceivableAmount;
   @ApiModelProperty("开票应收=已开票总额-已收款")
   private BigDecimal billingReceivableAmount;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("装车人")
   private String loadUserName;
   @ApiModelProperty("装车时间")
   private LocalDateTime loadTime;
   @ApiModelProperty("过磅人名称")
   private String actualUserName;
   @ApiModelProperty("过磅时间")
   private LocalDateTime actualTime;
   @ApiModelProperty(name = "actualWeight", value = "过磅净量", notes = "过磅净量")
   private BigDecimal actualWeight;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty("物流供应商")
   private SupplierPriceInfo supplier;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty("司机姓名")
   private String driverName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("过磅拍照图片")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty(name = "addressRegionalFullName", notes = "收货地址")
   private String addressRegionalFullName;
   @ApiModelProperty("运输工具类型")
   private Integer meansConveyanceEnum;
   @ApiModelProperty("备注")
   private String remark;

   public static AuditInfoDTO.AuditInfoDTOBuilder builder() {
      return new AuditInfoDTO.AuditInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public BigDecimal getManagementFee() {
      return this.managementFee;
   }

   public BigDecimal getTotalDeliveryAmount() {
      return this.totalDeliveryAmount;
   }

   public BigDecimal getTotalCollectionAmount() {
      return this.totalCollectionAmount;
   }

   public BigDecimal getAvailableAmount() {
      return this.availableAmount;
   }

   public BigDecimal getSafeAmount() {
      return this.safeAmount;
   }

   public BigDecimal getDeliveryAmount() {
      return this.deliveryAmount;
   }

   public BigDecimal getContractReceivableAmount() {
      return this.contractReceivableAmount;
   }

   public BigDecimal getBillingReceivableAmount() {
      return this.billingReceivableAmount;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getLoadUserName() {
      return this.loadUserName;
   }

   public LocalDateTime getLoadTime() {
      return this.loadTime;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public LocalDateTime getActualTime() {
      return this.actualTime;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public SupplierPriceInfo getSupplier() {
      return this.supplier;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public String getAddressRegionalFullName() {
      return this.addressRegionalFullName;
   }

   public Integer getMeansConveyanceEnum() {
      return this.meansConveyanceEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
   }

   public void setTotalDeliveryAmount(final BigDecimal totalDeliveryAmount) {
      this.totalDeliveryAmount = totalDeliveryAmount;
   }

   public void setTotalCollectionAmount(final BigDecimal totalCollectionAmount) {
      this.totalCollectionAmount = totalCollectionAmount;
   }

   public void setAvailableAmount(final BigDecimal availableAmount) {
      this.availableAmount = availableAmount;
   }

   public void setSafeAmount(final BigDecimal safeAmount) {
      this.safeAmount = safeAmount;
   }

   public void setDeliveryAmount(final BigDecimal deliveryAmount) {
      this.deliveryAmount = deliveryAmount;
   }

   public void setContractReceivableAmount(final BigDecimal contractReceivableAmount) {
      this.contractReceivableAmount = contractReceivableAmount;
   }

   public void setBillingReceivableAmount(final BigDecimal billingReceivableAmount) {
      this.billingReceivableAmount = billingReceivableAmount;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setLoadUserName(final String loadUserName) {
      this.loadUserName = loadUserName;
   }

   public void setLoadTime(final LocalDateTime loadTime) {
      this.loadTime = loadTime;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setSupplier(final SupplierPriceInfo supplier) {
      this.supplier = supplier;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   public void setAddressRegionalFullName(final String addressRegionalFullName) {
      this.addressRegionalFullName = addressRegionalFullName;
   }

   public void setMeansConveyanceEnum(final Integer meansConveyanceEnum) {
      this.meansConveyanceEnum = meansConveyanceEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditInfoDTO)) {
         return false;
      }

      AuditInfoDTO other = (AuditInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
               Object this$structureMeasureMode = this.getStructureMeasureMode();
               Object other$structureMeasureMode = other.getStructureMeasureMode();
               if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                  Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                  Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                  if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                     Object this$meansConveyanceEnum = this.getMeansConveyanceEnum();
                     Object other$meansConveyanceEnum = other.getMeansConveyanceEnum();
                     if (this$meansConveyanceEnum == null ? other$meansConveyanceEnum == null : this$meansConveyanceEnum.equals(other$meansConveyanceEnum)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$shortName = this.getShortName();
                                 Object other$shortName = other.getShortName();
                                 if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                    Object this$contractAmount = this.getContractAmount();
                                    Object other$contractAmount = other.getContractAmount();
                                    if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                       Object this$managementFee = this.getManagementFee();
                                       Object other$managementFee = other.getManagementFee();
                                       if (this$managementFee == null ? other$managementFee == null : this$managementFee.equals(other$managementFee)) {
                                          Object this$totalDeliveryAmount = this.getTotalDeliveryAmount();
                                          Object other$totalDeliveryAmount = other.getTotalDeliveryAmount();
                                          if (this$totalDeliveryAmount == null
                                             ? other$totalDeliveryAmount == null
                                             : this$totalDeliveryAmount.equals(other$totalDeliveryAmount)) {
                                             Object this$totalCollectionAmount = this.getTotalCollectionAmount();
                                             Object other$totalCollectionAmount = other.getTotalCollectionAmount();
                                             if (this$totalCollectionAmount == null
                                                ? other$totalCollectionAmount == null
                                                : this$totalCollectionAmount.equals(other$totalCollectionAmount)) {
                                                Object this$availableAmount = this.getAvailableAmount();
                                                Object other$availableAmount = other.getAvailableAmount();
                                                if (this$availableAmount == null
                                                   ? other$availableAmount == null
                                                   : this$availableAmount.equals(other$availableAmount)) {
                                                   Object this$safeAmount = this.getSafeAmount();
                                                   Object other$safeAmount = other.getSafeAmount();
                                                   if (this$safeAmount == null ? other$safeAmount == null : this$safeAmount.equals(other$safeAmount)) {
                                                      Object this$deliveryAmount = this.getDeliveryAmount();
                                                      Object other$deliveryAmount = other.getDeliveryAmount();
                                                      if (this$deliveryAmount == null
                                                         ? other$deliveryAmount == null
                                                         : this$deliveryAmount.equals(other$deliveryAmount)) {
                                                         Object this$contractReceivableAmount = this.getContractReceivableAmount();
                                                         Object other$contractReceivableAmount = other.getContractReceivableAmount();
                                                         if (this$contractReceivableAmount == null
                                                            ? other$contractReceivableAmount == null
                                                            : this$contractReceivableAmount.equals(other$contractReceivableAmount)) {
                                                            Object this$billingReceivableAmount = this.getBillingReceivableAmount();
                                                            Object other$billingReceivableAmount = other.getBillingReceivableAmount();
                                                            if (this$billingReceivableAmount == null
                                                               ? other$billingReceivableAmount == null
                                                               : this$billingReceivableAmount.equals(other$billingReceivableAmount)) {
                                                               Object this$licensePlate = this.getLicensePlate();
                                                               Object other$licensePlate = other.getLicensePlate();
                                                               if (this$licensePlate == null
                                                                  ? other$licensePlate == null
                                                                  : this$licensePlate.equals(other$licensePlate)) {
                                                                  Object this$loadUserName = this.getLoadUserName();
                                                                  Object other$loadUserName = other.getLoadUserName();
                                                                  if (this$loadUserName == null
                                                                     ? other$loadUserName == null
                                                                     : this$loadUserName.equals(other$loadUserName)) {
                                                                     Object this$loadTime = this.getLoadTime();
                                                                     Object other$loadTime = other.getLoadTime();
                                                                     if (this$loadTime == null ? other$loadTime == null : this$loadTime.equals(other$loadTime)) {
                                                                        Object this$actualUserName = this.getActualUserName();
                                                                        Object other$actualUserName = other.getActualUserName();
                                                                        if (this$actualUserName == null
                                                                           ? other$actualUserName == null
                                                                           : this$actualUserName.equals(other$actualUserName)) {
                                                                           Object this$actualTime = this.getActualTime();
                                                                           Object other$actualTime = other.getActualTime();
                                                                           if (this$actualTime == null
                                                                              ? other$actualTime == null
                                                                              : this$actualTime.equals(other$actualTime)) {
                                                                              Object this$actualWeight = this.getActualWeight();
                                                                              Object other$actualWeight = other.getActualWeight();
                                                                              if (this$actualWeight == null
                                                                                 ? other$actualWeight == null
                                                                                 : this$actualWeight.equals(other$actualWeight)) {
                                                                                 Object this$auditUserName = this.getAuditUserName();
                                                                                 Object other$auditUserName = other.getAuditUserName();
                                                                                 if (this$auditUserName == null
                                                                                    ? other$auditUserName == null
                                                                                    : this$auditUserName.equals(other$auditUserName)) {
                                                                                    Object this$supplier = this.getSupplier();
                                                                                    Object other$supplier = other.getSupplier();
                                                                                    if (this$supplier == null
                                                                                       ? other$supplier == null
                                                                                       : this$supplier.equals(other$supplier)) {
                                                                                       Object this$supplierName = this.getSupplierName();
                                                                                       Object other$supplierName = other.getSupplierName();
                                                                                       if (this$supplierName == null
                                                                                          ? other$supplierName == null
                                                                                          : this$supplierName.equals(other$supplierName)) {
                                                                                          Object this$driverName = this.getDriverName();
                                                                                          Object other$driverName = other.getDriverName();
                                                                                          if (this$driverName == null
                                                                                             ? other$driverName == null
                                                                                             : this$driverName.equals(other$driverName)) {
                                                                                             Object this$driverPhone = this.getDriverPhone();
                                                                                             Object other$driverPhone = other.getDriverPhone();
                                                                                             if (this$driverPhone == null
                                                                                                ? other$driverPhone == null
                                                                                                : this$driverPhone.equals(other$driverPhone)) {
                                                                                                Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                                                Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                                                if (this$attachmentDTOS == null
                                                                                                   ? other$attachmentDTOS == null
                                                                                                   : this$attachmentDTOS.equals(other$attachmentDTOS)) {
                                                                                                   Object this$addressRegionalFullName = this.getAddressRegionalFullName();
                                                                                                   Object other$addressRegionalFullName = other.getAddressRegionalFullName();
                                                                                                   if (this$addressRegionalFullName == null
                                                                                                      ? other$addressRegionalFullName == null
                                                                                                      : this$addressRegionalFullName.equals(
                                                                                                         other$addressRegionalFullName
                                                                                                      )) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      return this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark);
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
      return other instanceof AuditInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $meansConveyanceEnum = this.getMeansConveyanceEnum();
      result = result * 59 + ($meansConveyanceEnum == null ? 43 : $meansConveyanceEnum.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $managementFee = this.getManagementFee();
      result = result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
      Object $totalDeliveryAmount = this.getTotalDeliveryAmount();
      result = result * 59 + ($totalDeliveryAmount == null ? 43 : $totalDeliveryAmount.hashCode());
      Object $totalCollectionAmount = this.getTotalCollectionAmount();
      result = result * 59 + ($totalCollectionAmount == null ? 43 : $totalCollectionAmount.hashCode());
      Object $availableAmount = this.getAvailableAmount();
      result = result * 59 + ($availableAmount == null ? 43 : $availableAmount.hashCode());
      Object $safeAmount = this.getSafeAmount();
      result = result * 59 + ($safeAmount == null ? 43 : $safeAmount.hashCode());
      Object $deliveryAmount = this.getDeliveryAmount();
      result = result * 59 + ($deliveryAmount == null ? 43 : $deliveryAmount.hashCode());
      Object $contractReceivableAmount = this.getContractReceivableAmount();
      result = result * 59 + ($contractReceivableAmount == null ? 43 : $contractReceivableAmount.hashCode());
      Object $billingReceivableAmount = this.getBillingReceivableAmount();
      result = result * 59 + ($billingReceivableAmount == null ? 43 : $billingReceivableAmount.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $loadUserName = this.getLoadUserName();
      result = result * 59 + ($loadUserName == null ? 43 : $loadUserName.hashCode());
      Object $loadTime = this.getLoadTime();
      result = result * 59 + ($loadTime == null ? 43 : $loadTime.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $actualTime = this.getActualTime();
      result = result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $addressRegionalFullName = this.getAddressRegionalFullName();
      result = result * 59 + ($addressRegionalFullName == null ? 43 : $addressRegionalFullName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "AuditInfoDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", projectId="
         + this.getProjectId()
         + ", contractAmount="
         + this.getContractAmount()
         + ", businessType="
         + this.getBusinessType()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", managementFee="
         + this.getManagementFee()
         + ", totalDeliveryAmount="
         + this.getTotalDeliveryAmount()
         + ", totalCollectionAmount="
         + this.getTotalCollectionAmount()
         + ", availableAmount="
         + this.getAvailableAmount()
         + ", safeAmount="
         + this.getSafeAmount()
         + ", deliveryAmount="
         + this.getDeliveryAmount()
         + ", contractReceivableAmount="
         + this.getContractReceivableAmount()
         + ", billingReceivableAmount="
         + this.getBillingReceivableAmount()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", loadUserName="
         + this.getLoadUserName()
         + ", loadTime="
         + this.getLoadTime()
         + ", actualUserName="
         + this.getActualUserName()
         + ", actualTime="
         + this.getActualTime()
         + ", actualWeight="
         + this.getActualWeight()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", supplier="
         + this.getSupplier()
         + ", supplierName="
         + this.getSupplierName()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", addressRegionalFullName="
         + this.getAddressRegionalFullName()
         + ", meansConveyanceEnum="
         + this.getMeansConveyanceEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public AuditInfoDTO() {
   }

   public AuditInfoDTO(
      final Long id,
      final ProjectInfo project,
      final String serialNumber,
      final String name,
      final String shortName,
      final Long projectId,
      final BigDecimal contractAmount,
      final Integer businessType,
      final Integer structureMeasureMode,
      final Integer enclosureMeasureMode,
      final BigDecimal managementFee,
      final BigDecimal totalDeliveryAmount,
      final BigDecimal totalCollectionAmount,
      final BigDecimal availableAmount,
      final BigDecimal safeAmount,
      final BigDecimal deliveryAmount,
      final BigDecimal contractReceivableAmount,
      final BigDecimal billingReceivableAmount,
      final String licensePlate,
      final String loadUserName,
      final LocalDateTime loadTime,
      final String actualUserName,
      final LocalDateTime actualTime,
      final BigDecimal actualWeight,
      final String auditUserName,
      final SupplierPriceInfo supplier,
      final String supplierName,
      final String driverName,
      final String driverPhone,
      final List<AttachmentDTO> attachmentDTOS,
      final String addressRegionalFullName,
      final Integer meansConveyanceEnum,
      final String remark
   ) {
      this.id = id;
      this.project = project;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.projectId = projectId;
      this.contractAmount = contractAmount;
      this.businessType = businessType;
      this.structureMeasureMode = structureMeasureMode;
      this.enclosureMeasureMode = enclosureMeasureMode;
      this.managementFee = managementFee;
      this.totalDeliveryAmount = totalDeliveryAmount;
      this.totalCollectionAmount = totalCollectionAmount;
      this.availableAmount = availableAmount;
      this.safeAmount = safeAmount;
      this.deliveryAmount = deliveryAmount;
      this.contractReceivableAmount = contractReceivableAmount;
      this.billingReceivableAmount = billingReceivableAmount;
      this.licensePlate = licensePlate;
      this.loadUserName = loadUserName;
      this.loadTime = loadTime;
      this.actualUserName = actualUserName;
      this.actualTime = actualTime;
      this.actualWeight = actualWeight;
      this.auditUserName = auditUserName;
      this.supplier = supplier;
      this.supplierName = supplierName;
      this.driverName = driverName;
      this.driverPhone = driverPhone;
      this.attachmentDTOS = attachmentDTOS;
      this.addressRegionalFullName = addressRegionalFullName;
      this.meansConveyanceEnum = meansConveyanceEnum;
      this.remark = remark;
   }

   public static class AuditInfoDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private String serialNumber;
      private String name;
      private String shortName;
      private Long projectId;
      private BigDecimal contractAmount;
      private Integer businessType;
      private Integer structureMeasureMode;
      private Integer enclosureMeasureMode;
      private BigDecimal managementFee;
      private BigDecimal totalDeliveryAmount;
      private BigDecimal totalCollectionAmount;
      private BigDecimal availableAmount;
      private BigDecimal safeAmount;
      private BigDecimal deliveryAmount;
      private BigDecimal contractReceivableAmount;
      private BigDecimal billingReceivableAmount;
      private String licensePlate;
      private String loadUserName;
      private LocalDateTime loadTime;
      private String actualUserName;
      private LocalDateTime actualTime;
      private BigDecimal actualWeight;
      private String auditUserName;
      private SupplierPriceInfo supplier;
      private String supplierName;
      private String driverName;
      private String driverPhone;
      private List<AttachmentDTO> attachmentDTOS;
      private String addressRegionalFullName;
      private Integer meansConveyanceEnum;
      private String remark;

      AuditInfoDTOBuilder() {
      }

      public AuditInfoDTO.AuditInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder enclosureMeasureMode(final Integer enclosureMeasureMode) {
         this.enclosureMeasureMode = enclosureMeasureMode;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder totalDeliveryAmount(final BigDecimal totalDeliveryAmount) {
         this.totalDeliveryAmount = totalDeliveryAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder totalCollectionAmount(final BigDecimal totalCollectionAmount) {
         this.totalCollectionAmount = totalCollectionAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder availableAmount(final BigDecimal availableAmount) {
         this.availableAmount = availableAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder safeAmount(final BigDecimal safeAmount) {
         this.safeAmount = safeAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder deliveryAmount(final BigDecimal deliveryAmount) {
         this.deliveryAmount = deliveryAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder contractReceivableAmount(final BigDecimal contractReceivableAmount) {
         this.contractReceivableAmount = contractReceivableAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder billingReceivableAmount(final BigDecimal billingReceivableAmount) {
         this.billingReceivableAmount = billingReceivableAmount;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder loadUserName(final String loadUserName) {
         this.loadUserName = loadUserName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder loadTime(final LocalDateTime loadTime) {
         this.loadTime = loadTime;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder actualTime(final LocalDateTime actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder actualWeight(final BigDecimal actualWeight) {
         this.actualWeight = actualWeight;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder supplier(final SupplierPriceInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder addressRegionalFullName(final String addressRegionalFullName) {
         this.addressRegionalFullName = addressRegionalFullName;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder meansConveyanceEnum(final Integer meansConveyanceEnum) {
         this.meansConveyanceEnum = meansConveyanceEnum;
         return this;
      }

      public AuditInfoDTO.AuditInfoDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public AuditInfoDTO build() {
         return new AuditInfoDTO(
            this.id,
            this.project,
            this.serialNumber,
            this.name,
            this.shortName,
            this.projectId,
            this.contractAmount,
            this.businessType,
            this.structureMeasureMode,
            this.enclosureMeasureMode,
            this.managementFee,
            this.totalDeliveryAmount,
            this.totalCollectionAmount,
            this.availableAmount,
            this.safeAmount,
            this.deliveryAmount,
            this.contractReceivableAmount,
            this.billingReceivableAmount,
            this.licensePlate,
            this.loadUserName,
            this.loadTime,
            this.actualUserName,
            this.actualTime,
            this.actualWeight,
            this.auditUserName,
            this.supplier,
            this.supplierName,
            this.driverName,
            this.driverPhone,
            this.attachmentDTOS,
            this.addressRegionalFullName,
            this.meansConveyanceEnum,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "AuditInfoDTO.AuditInfoDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", projectId="
            + this.projectId
            + ", contractAmount="
            + this.contractAmount
            + ", businessType="
            + this.businessType
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", enclosureMeasureMode="
            + this.enclosureMeasureMode
            + ", managementFee="
            + this.managementFee
            + ", totalDeliveryAmount="
            + this.totalDeliveryAmount
            + ", totalCollectionAmount="
            + this.totalCollectionAmount
            + ", availableAmount="
            + this.availableAmount
            + ", safeAmount="
            + this.safeAmount
            + ", deliveryAmount="
            + this.deliveryAmount
            + ", contractReceivableAmount="
            + this.contractReceivableAmount
            + ", billingReceivableAmount="
            + this.billingReceivableAmount
            + ", licensePlate="
            + this.licensePlate
            + ", loadUserName="
            + this.loadUserName
            + ", loadTime="
            + this.loadTime
            + ", actualUserName="
            + this.actualUserName
            + ", actualTime="
            + this.actualTime
            + ", actualWeight="
            + this.actualWeight
            + ", auditUserName="
            + this.auditUserName
            + ", supplier="
            + this.supplier
            + ", supplierName="
            + this.supplierName
            + ", driverName="
            + this.driverName
            + ", driverPhone="
            + this.driverPhone
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", addressRegionalFullName="
            + this.addressRegionalFullName
            + ", meansConveyanceEnum="
            + this.meansConveyanceEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
