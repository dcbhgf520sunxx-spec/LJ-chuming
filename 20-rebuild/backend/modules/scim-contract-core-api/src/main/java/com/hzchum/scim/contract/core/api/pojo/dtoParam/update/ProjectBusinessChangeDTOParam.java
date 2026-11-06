package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.PressureBearingPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProfiledPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.SandwichBoardDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.StructureDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.TrussFloorPlateDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("商务信息 变更类")
public class ProjectBusinessChangeDTOParam {
   @NotNull(message = "合同签订主体id不能为空")
   @ApiModelProperty(name = "contractSignBodyId", value = "签订主体id")
   private Long contractSignBodyId;
   @NotNull(message = "业务类型不能为空")
   @EnumValidator(value = ProjectBusinessTypeEnum.class, message = "业务类型有误!")
   @ApiModelProperty(name = "businessType", value = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @NotNull(message = "项目类型不能为空")
   @EnumValidator(value = ProjectTypeEnum.class, message = "项目类型有误!")
   @ApiModelProperty(name = "projectType", value = "项目类型 1建筑钢结构 2桥梁钢结构  3立体停车库  4围护材料")
   private Integer projectType;
   @NotEmpty(message = "项目内容id不能为空")
   @ApiModelProperty(name = "projectContent", value = "项目内容id列表")
   private List<Long> projectContent;
   @ApiModelProperty(name = "transportMode", value = "运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty(name = "enclosureTransportMode", notes = "围护运输方式 1运送到场 2客户自提")
   private Integer enclosureTransportMode;
   @ApiModelProperty(name = "structureMeasureMode", value = "工程计量方式  1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", value = "围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureModeList", value = "围护计量方式列表 1 长度计量 2 面积计量")
   private List<MeasureModeDTOParam> measureModeList;
   @ApiModelProperty(name = "signingDate", value = "签约日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "signingAddress", value = "签约地址")
   private String signingAddress;
   @ApiModelProperty(name = "isTax", value = "是否含税 1是 0否")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", value = "发票类型 1 增值税专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "taxRate", value = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "payType", value = "支付方式  1.对公转账 2 对私转账 4承兑汇票 8转账支票")
   private Integer payType;
   @ApiModelProperty(name = "payTypeDesc", value = "支付方式描述")
   private String payTypeDesc;
   @ApiModelProperty(name = "structureList", value = "结构件列表")
   private List<StructureDTOParam> structureList;
   @ApiModelProperty(name = "profiledPlateList", value = "压型彩板列表")
   private List<ProfiledPlateDTOParam> profiledPlateList;
   @ApiModelProperty(name = "trussFloorPlateList", value = "桁架楼承板列表")
   private List<TrussFloorPlateDTOParam> trussFloorPlateList;
   @ApiModelProperty(name = "pressureBearingPlateList", value = "压型楼承板列表")
   private List<PressureBearingPlateDTOParam> pressureBearingPlateList;
   @ApiModelProperty(name = "sandwichBoardList", value = "夹芯板列表")
   private List<SandwichBoardDTOParam> sandwichBoardList;
   @ApiModelProperty(name = "technologyRemark", value = "技术要求描述")
   private String technologyRemark;
   @Deprecated
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Integer structureStatus;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   private Long structureTypeId;
   @ApiModelProperty(name = "quantityWork", value = "工程量")
   private BigDecimal quantityWork;

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public List<Long> getProjectContent() {
      return this.projectContent;
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

   public List<StructureDTOParam> getStructureList() {
      return this.structureList;
   }

   public List<ProfiledPlateDTOParam> getProfiledPlateList() {
      return this.profiledPlateList;
   }

   public List<TrussFloorPlateDTOParam> getTrussFloorPlateList() {
      return this.trussFloorPlateList;
   }

   public List<PressureBearingPlateDTOParam> getPressureBearingPlateList() {
      return this.pressureBearingPlateList;
   }

   public List<SandwichBoardDTOParam> getSandwichBoardList() {
      return this.sandwichBoardList;
   }

   public String getTechnologyRemark() {
      return this.technologyRemark;
   }

   @Deprecated
   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public BigDecimal getQuantityWork() {
      return this.quantityWork;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectContent(final List<Long> projectContent) {
      this.projectContent = projectContent;
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

   public void setStructureList(final List<StructureDTOParam> structureList) {
      this.structureList = structureList;
   }

   public void setProfiledPlateList(final List<ProfiledPlateDTOParam> profiledPlateList) {
      this.profiledPlateList = profiledPlateList;
   }

   public void setTrussFloorPlateList(final List<TrussFloorPlateDTOParam> trussFloorPlateList) {
      this.trussFloorPlateList = trussFloorPlateList;
   }

   public void setPressureBearingPlateList(final List<PressureBearingPlateDTOParam> pressureBearingPlateList) {
      this.pressureBearingPlateList = pressureBearingPlateList;
   }

   public void setSandwichBoardList(final List<SandwichBoardDTOParam> sandwichBoardList) {
      this.sandwichBoardList = sandwichBoardList;
   }

   public void setTechnologyRemark(final String technologyRemark) {
      this.technologyRemark = technologyRemark;
   }

   @Deprecated
   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
   }

   public void setQuantityWork(final BigDecimal quantityWork) {
      this.quantityWork = quantityWork;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBusinessChangeDTOParam)) {
         return false;
      }

      ProjectBusinessChangeDTOParam other = (ProjectBusinessChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

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
                     if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                        Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                        Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                        if (this$enclosureMeasureMode == null
                           ? other$enclosureMeasureMode == null
                           : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                           Object this$isTax = this.getIsTax();
                           Object other$isTax = other.getIsTax();
                           if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
                              Object this$invoiceType = this.getInvoiceType();
                              Object other$invoiceType = other.getInvoiceType();
                              if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                 Object this$payType = this.getPayType();
                                 Object other$payType = other.getPayType();
                                 if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                                    Object this$structureStatus = this.getStructureStatus();
                                    Object other$structureStatus = other.getStructureStatus();
                                    if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                                       Object this$structureTypeId = this.getStructureTypeId();
                                       Object other$structureTypeId = other.getStructureTypeId();
                                       if (this$structureTypeId == null ? other$structureTypeId == null : this$structureTypeId.equals(other$structureTypeId)) {
                                          Object this$projectContent = this.getProjectContent();
                                          Object other$projectContent = other.getProjectContent();
                                          if (this$projectContent == null ? other$projectContent == null : this$projectContent.equals(other$projectContent)) {
                                             Object this$measureModeList = this.getMeasureModeList();
                                             Object other$measureModeList = other.getMeasureModeList();
                                             if (this$measureModeList == null
                                                ? other$measureModeList == null
                                                : this$measureModeList.equals(other$measureModeList)) {
                                                Object this$signingDate = this.getSigningDate();
                                                Object other$signingDate = other.getSigningDate();
                                                if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
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
                                                         if (this$payTypeDesc == null ? other$payTypeDesc == null : this$payTypeDesc.equals(other$payTypeDesc)) {
                                                            Object this$structureList = this.getStructureList();
                                                            Object other$structureList = other.getStructureList();
                                                            if (this$structureList == null
                                                               ? other$structureList == null
                                                               : this$structureList.equals(other$structureList)) {
                                                               Object this$profiledPlateList = this.getProfiledPlateList();
                                                               Object other$profiledPlateList = other.getProfiledPlateList();
                                                               if (this$profiledPlateList == null
                                                                  ? other$profiledPlateList == null
                                                                  : this$profiledPlateList.equals(other$profiledPlateList)) {
                                                                  Object this$trussFloorPlateList = this.getTrussFloorPlateList();
                                                                  Object other$trussFloorPlateList = other.getTrussFloorPlateList();
                                                                  if (this$trussFloorPlateList == null
                                                                     ? other$trussFloorPlateList == null
                                                                     : this$trussFloorPlateList.equals(other$trussFloorPlateList)) {
                                                                     Object this$pressureBearingPlateList = this.getPressureBearingPlateList();
                                                                     Object other$pressureBearingPlateList = other.getPressureBearingPlateList();
                                                                     if (this$pressureBearingPlateList == null
                                                                        ? other$pressureBearingPlateList == null
                                                                        : this$pressureBearingPlateList.equals(other$pressureBearingPlateList)) {
                                                                        Object this$sandwichBoardList = this.getSandwichBoardList();
                                                                        Object other$sandwichBoardList = other.getSandwichBoardList();
                                                                        if (this$sandwichBoardList == null
                                                                           ? other$sandwichBoardList == null
                                                                           : this$sandwichBoardList.equals(other$sandwichBoardList)) {
                                                                           Object this$technologyRemark = this.getTechnologyRemark();
                                                                           Object other$technologyRemark = other.getTechnologyRemark();
                                                                           if (this$technologyRemark == null
                                                                              ? other$technologyRemark == null
                                                                              : this$technologyRemark.equals(other$technologyRemark)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectBusinessChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
      Object $projectContent = this.getProjectContent();
      result = result * 59 + ($projectContent == null ? 43 : $projectContent.hashCode());
      Object $measureModeList = this.getMeasureModeList();
      result = result * 59 + ($measureModeList == null ? 43 : $measureModeList.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $signingAddress = this.getSigningAddress();
      result = result * 59 + ($signingAddress == null ? 43 : $signingAddress.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $payTypeDesc = this.getPayTypeDesc();
      result = result * 59 + ($payTypeDesc == null ? 43 : $payTypeDesc.hashCode());
      Object $structureList = this.getStructureList();
      result = result * 59 + ($structureList == null ? 43 : $structureList.hashCode());
      Object $profiledPlateList = this.getProfiledPlateList();
      result = result * 59 + ($profiledPlateList == null ? 43 : $profiledPlateList.hashCode());
      Object $trussFloorPlateList = this.getTrussFloorPlateList();
      result = result * 59 + ($trussFloorPlateList == null ? 43 : $trussFloorPlateList.hashCode());
      Object $pressureBearingPlateList = this.getPressureBearingPlateList();
      result = result * 59 + ($pressureBearingPlateList == null ? 43 : $pressureBearingPlateList.hashCode());
      Object $sandwichBoardList = this.getSandwichBoardList();
      result = result * 59 + ($sandwichBoardList == null ? 43 : $sandwichBoardList.hashCode());
      Object $technologyRemark = this.getTechnologyRemark();
      result = result * 59 + ($technologyRemark == null ? 43 : $technologyRemark.hashCode());
      Object $quantityWork = this.getQuantityWork();
      return result * 59 + ($quantityWork == null ? 43 : $quantityWork.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBusinessChangeDTOParam(contractSignBodyId="
         + this.getContractSignBodyId()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContent="
         + this.getProjectContent()
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
         + ", structureList="
         + this.getStructureList()
         + ", profiledPlateList="
         + this.getProfiledPlateList()
         + ", trussFloorPlateList="
         + this.getTrussFloorPlateList()
         + ", pressureBearingPlateList="
         + this.getPressureBearingPlateList()
         + ", sandwichBoardList="
         + this.getSandwichBoardList()
         + ", technologyRemark="
         + this.getTechnologyRemark()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", quantityWork="
         + this.getQuantityWork()
         + ")";
   }
}
