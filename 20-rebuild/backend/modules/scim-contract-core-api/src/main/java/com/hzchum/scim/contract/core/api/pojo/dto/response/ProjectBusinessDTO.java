package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApiModel("商务信息")
public class ProjectBusinessDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "contractSignBodyId", value = "签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", value = "签订主体")
   private String contractSignBodyName;
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构  4立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "transportMode", notes = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "运输方式 1运送到场 2客户自提")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式  1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureModeList", notes = "围护计量方式列表 1 长度计量 2 面积计量")
   private List<MeasureModeDTOParam> measureModeList;
   @ApiModelProperty(name = "signerId", value = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签约人")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", value = "签约人电话")
   private String signerPhone;
   @ApiModelProperty(name = "signingDate", value = "签约日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signingAddress", value = "签约地址")
   private String signingAddress;
   @ApiModelProperty(name = "isTax", value = "是否含税 1是 0否")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "payType", value = "支付方式  1.对公转账 2 对私转账 4.其他")
   private Integer payType;
   @ApiModelProperty(name = "payTypeDesc", value = "支付方式描述")
   private String payTypeDesc;
   @ApiModelProperty(name = "projectContentList", notes = "项目内容列表")
   private List<ProjectContentDTO> projectContentList;
   @ApiModelProperty("已创建单体数量")
   private Integer monomerQuantity;
   @ApiModelProperty(name = "projectContentNoList", value = "已创建单体(计划)的项目内容no列表")
   private List<Integer> projectContentNoList;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   private String technologyRemark;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Integer structureStatus;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   private Long structureTypeId;
   @ApiModelProperty(name = "structureTypeName", value = "结构类型名称")
   private String structureTypeName;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   private BigDecimal quantityWork;

   public Long getId() {
      return this.id;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getEnclosureTransportMode() {
      return this.enclosureTransportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public List<MeasureModeDTOParam> getMeasureModeList() {
      return this.measureModeList;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public String getSignerPhone() {
      return this.signerPhone;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getSigningAddress() {
      return this.signingAddress;
   }

   public Integer getIsTax() {
      return this.isTax;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getPayType() {
      return this.payType;
   }

   public String getPayTypeDesc() {
      return this.payTypeDesc;
   }

   public List<ProjectContentDTO> getProjectContentList() {
      return this.projectContentList;
   }

   public Integer getMonomerQuantity() {
      return this.monomerQuantity;
   }

   public List<Integer> getProjectContentNoList() {
      return this.projectContentNoList;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public String getStructureTypeName() {
      return this.structureTypeName;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setEnclosureTransportMode(final Integer enclosureTransportMode) {
      this.enclosureTransportMode = enclosureTransportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setMeasureModeList(final List<MeasureModeDTOParam> measureModeList) {
      this.measureModeList = measureModeList;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSigningAddress(final String signingAddress) {
      this.signingAddress = signingAddress;
   }

   public void setIsTax(final Integer isTax) {
      this.isTax = isTax;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setPayType(final Integer payType) {
      this.payType = payType;
   }

   public void setPayTypeDesc(final String payTypeDesc) {
      this.payTypeDesc = payTypeDesc;
   }

   public void setProjectContentList(final List<ProjectContentDTO> projectContentList) {
      this.projectContentList = projectContentList;
   }

   public void setMonomerQuantity(final Integer monomerQuantity) {
      this.monomerQuantity = monomerQuantity;
   }

   public void setProjectContentNoList(final List<Integer> projectContentNoList) {
      this.projectContentNoList = projectContentNoList;
   }

   public void setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
   }

   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
   }

   public void setStructureTypeName(final String structureTypeName) {
      this.structureTypeName = structureTypeName;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBusinessDTO)) {
         return false;
      }

      ProjectBusinessDTO other = (ProjectBusinessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractSignBodyId = this.getContractSignBodyId();
         Object other$contractSignBodyId = other.getContractSignBodyId();
         if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
            Object this$businessType = this.getBusinessType();
            Object other$businessType = other.getBusinessType();
            if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
               Object this$projectType = this.getProjectType();
               Object other$projectType = other.getProjectType();
               if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                  Object this$transportMode = this.getTransportMode();
                  Object other$transportMode = other.getTransportMode();
                  if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
                     Object this$enclosureTransportMode = this.getEnclosureTransportMode();
                     Object other$enclosureTransportMode = other.getEnclosureTransportMode();
                     if (this$enclosureTransportMode == null
                        ? other$enclosureTransportMode == null
                        : this$enclosureTransportMode.equals(other$enclosureTransportMode)) {
                        Object this$structureMeasureMode = this.getStructureMeasureMode();
                        Object other$structureMeasureMode = other.getStructureMeasureMode();
                        if (this$structureMeasureMode == null
                           ? other$structureMeasureMode == null
                           : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                           Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                           Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                           if (this$enclosureMeasureMode == null
                              ? other$enclosureMeasureMode == null
                              : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                              Object this$signerId = this.getSignerId();
                              Object other$signerId = other.getSignerId();
                              if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                                 Object this$isTax = this.getIsTax();
                                 Object other$isTax = other.getIsTax();
                                 if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
                                    Object this$invoiceType = this.getInvoiceType();
                                    Object other$invoiceType = other.getInvoiceType();
                                    if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                       Object this$payType = this.getPayType();
                                       Object other$payType = other.getPayType();
                                       if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                                          Object this$monomerQuantity = this.getMonomerQuantity();
                                          Object other$monomerQuantity = other.getMonomerQuantity();
                                          if (this$monomerQuantity == null ? other$monomerQuantity == null : this$monomerQuantity.equals(other$monomerQuantity)
                                             )
                                           {
                                             Object this$structureStatus = this.getStructureStatus();
                                             Object other$structureStatus = other.getStructureStatus();
                                             if (this$structureStatus == null
                                                ? other$structureStatus == null
                                                : this$structureStatus.equals(other$structureStatus)) {
                                                Object this$structureTypeId = this.getStructureTypeId();
                                                Object other$structureTypeId = other.getStructureTypeId();
                                                if (this$structureTypeId == null
                                                   ? other$structureTypeId == null
                                                   : this$structureTypeId.equals(other$structureTypeId)) {
                                                   Object this$contractSignBodyName = this.getContractSignBodyName();
                                                   Object other$contractSignBodyName = other.getContractSignBodyName();
                                                   if (this$contractSignBodyName == null
                                                      ? other$contractSignBodyName == null
                                                      : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                                      Object this$measureModeList = this.getMeasureModeList();
                                                      Object other$measureModeList = other.getMeasureModeList();
                                                      if (this$measureModeList == null
                                                         ? other$measureModeList == null
                                                         : this$measureModeList.equals(other$measureModeList)) {
                                                         Object this$signerName = this.getSignerName();
                                                         Object other$signerName = other.getSignerName();
                                                         if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                                                            Object this$signerPhone = this.getSignerPhone();
                                                            Object other$signerPhone = other.getSignerPhone();
                                                            if (this$signerPhone == null
                                                               ? other$signerPhone == null
                                                               : this$signerPhone.equals(other$signerPhone)) {
                                                               Object this$signingDate = this.getSigningDate();
                                                               Object other$signingDate = other.getSigningDate();
                                                               if (this$signingDate == null
                                                                  ? other$signingDate == null
                                                                  : this$signingDate.equals(other$signingDate)) {
                                                                  Object this$signingAddress = this.getSigningAddress();
                                                                  Object other$signingAddress = other.getSigningAddress();
                                                                  if (this$signingAddress == null
                                                                     ? other$signingAddress == null
                                                                     : this$signingAddress.equals(other$signingAddress)) {
                                                                     Object this$taxRate = this.getTaxRate();
                                                                     Object other$taxRate = other.getTaxRate();
                                                                     if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                        Object this$payTypeDesc = this.getPayTypeDesc();
                                                                        Object other$payTypeDesc = other.getPayTypeDesc();
                                                                        if (this$payTypeDesc == null
                                                                           ? other$payTypeDesc == null
                                                                           : this$payTypeDesc.equals(other$payTypeDesc)) {
                                                                           Object this$projectContentList = this.getProjectContentList();
                                                                           Object other$projectContentList = other.getProjectContentList();
                                                                           if (this$projectContentList == null
                                                                              ? other$projectContentList == null
                                                                              : this$projectContentList.equals(other$projectContentList)) {
                                                                              Object this$projectContentNoList = this.getProjectContentNoList();
                                                                              Object other$projectContentNoList = other.getProjectContentNoList();
                                                                              if (this$projectContentNoList == null
                                                                                 ? other$projectContentNoList == null
                                                                                 : this$projectContentNoList.equals(other$projectContentNoList)) {
                                                                                 Object this$technologyRemark = this.getTechnologyRemark();
                                                                                 Object other$technologyRemark = other.getTechnologyRemark();
                                                                                 if (this$technologyRemark == null
                                                                                    ? other$technologyRemark == null
                                                                                    : this$technologyRemark.equals(other$technologyRemark)) {
                                                                                    Object this$structureTypeName = this.getStructureTypeName();
                                                                                    Object other$structureTypeName = other.getStructureTypeName();
                                                                                    if (this$structureTypeName == null
                                                                                       ? other$structureTypeName == null
                                                                                       : this$structureTypeName.equals(other$structureTypeName)) {
                                                                                       Object this$quantityWork = this.getQuantityWork();
                                                                                       Object other$quantityWork = other.getQuantityWork();
                                                                                       return this$quantityWork == null
                                                                                          ? other$quantityWork == null
                                                                                          : this$quantityWork.equals(other$quantityWork);
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
      return other instanceof ProjectBusinessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $enclosureTransportMode = this.getEnclosureTransportMode();
      result = result * 59 + ($enclosureTransportMode == null ? 43 : $enclosureTransportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $monomerQuantity = this.getMonomerQuantity();
      result = result * 59 + ($monomerQuantity == null ? 43 : $monomerQuantity.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $measureModeList = this.getMeasureModeList();
      result = result * 59 + ($measureModeList == null ? 43 : $measureModeList.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signerPhone = this.getSignerPhone();
      result = result * 59 + ($signerPhone == null ? 43 : $signerPhone.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signingAddress = this.getSigningAddress();
      result = result * 59 + ($signingAddress == null ? 43 : $signingAddress.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $payTypeDesc = this.getPayTypeDesc();
      result = result * 59 + ($payTypeDesc == null ? 43 : $payTypeDesc.hashCode());
      Object $projectContentList = this.getProjectContentList();
      result = result * 59 + ($projectContentList == null ? 43 : $projectContentList.hashCode());
      Object $projectContentNoList = this.getProjectContentNoList();
      result = result * 59 + ($projectContentNoList == null ? 43 : $projectContentNoList.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $structureTypeName = this.getStructureTypeName();
      result = result * 59 + ($structureTypeName == null ? 43 : $structureTypeName.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBusinessDTO(id="
         + this.getId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", transportMode="
         + this.getTransportMode()
         + ", enclosureTransportMode="
         + this.getEnclosureTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", measureModeList="
         + this.getMeasureModeList()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", signerPhone="
         + this.getSignerPhone()
         + ", signingDate="
         + this.getSigningDate()
         + ", signingAddress="
         + this.getSigningAddress()
         + ", isTax="
         + this.getIsTax()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", payType="
         + this.getPayType()
         + ", payTypeDesc="
         + this.getPayTypeDesc()
         + ", projectContentList="
         + this.getProjectContentList()
         + ", monomerQuantity="
         + this.getMonomerQuantity()
         + ", projectContentNoList="
         + this.getProjectContentNoList()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", structureTypeName="
         + this.getStructureTypeName()
         + ", quantityWork="
         + this.getQuantityWork()
         + ")";
   }
}
