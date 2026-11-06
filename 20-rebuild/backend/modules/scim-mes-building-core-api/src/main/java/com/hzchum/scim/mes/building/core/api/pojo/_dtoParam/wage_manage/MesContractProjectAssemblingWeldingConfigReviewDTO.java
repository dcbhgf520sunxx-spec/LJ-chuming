package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage;

import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesContractProjectAssemblingWeldingConfigReview;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目装焊配置工价修改审批DTO类")
public class MesContractProjectAssemblingWeldingConfigReviewDTO extends MesContractProjectAssemblingWeldingConfigReview {
   @ApiModelProperty(name = "projectShortName", value = "项目简称", notes = "项目简称")
   private String contractProjectShortName;
   @ApiModelProperty(name = "projectSerialNumber", value = "项目编号", notes = "项目编号")
   private String contractProjectSerialNumber;
   @ApiModelProperty(name = "initiatorName", value = "发起人名称", notes = "发起人名称")
   private String initiatorName;
   @ApiModelProperty(name = "processList", value = "工序列表", notes = "工序列表")
   private List<NameInfo> processList;
   @ApiModelProperty(name = "artifactClassificationName", value = "构件分类名称", notes = "构件分类名称")
   private String artifactClassificationName;
   @ApiModelProperty(name = "oldOrganizationInsidePrice", value = "旧编制内单价(元)", notes = "旧编制内单价(元)")
   private BigDecimal oldOrganizationInsidePrice;
   @ApiModelProperty(name = "oldOrganizationOutsidePrice", value = "旧编制外单价(元)", notes = "旧编制外单价(元)")
   private BigDecimal oldOrganizationOutsidePrice;
   @ApiModelProperty(name = "reviewerName", value = "审批人名称", notes = "审批人名称")
   private String reviewerName;
   @ApiModelProperty(
      name = "pricingManner",
      value = "计价方式(AssemblingWeldingConfigPricingMannerEnum)",
      notes = "计价方式(AssemblingWeldingConfigPricingMannerEnum)"
   )
   private Integer pricingManner;
   @ApiModelProperty(name = "comparisonOperatorOne", value = "比较运算符1(ComparisonOperatorEnum)", notes = "比较运算符1(ComparisonOperatorEnum)")
   private Integer comparisonOperatorOne;
   @ApiModelProperty(name = "numberOne", value = "数字1", notes = "数字1")
   private Integer numberOne;
   @ApiModelProperty(name = "comparisonOperatorTwo", value = "比较运算符2(ComparisonOperatorEnum)", notes = "比较运算符2(ComparisonOperatorEnum)")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty(name = "numberTwo", value = "数字2", notes = "数字2")
   private Integer numberTwo;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   private Integer measurementManner;
   @ApiModelProperty(name = "measurementUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;

   public String getMeasureUnit() {
      if (this.measurementManner != null && StrUtil.isBlank(this.measureUnit)) {
         WageQuotaTypeEnum typeEnum = WageQuotaTypeEnum.getEnumByType(this.measurementManner);
         if (typeEnum != null) {
            switch (typeEnum) {
               case WEIGHT_PRICE:
                  this.measureUnit = "吨";
                  break;
               case LENGTH_PRICE:
                  this.measureUnit = "米";
                  break;
               case QUANTITY_PRICE:
                  this.measureUnit = "张";
            }
         }
      }

      return this.measureUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectAssemblingWeldingConfigReviewDTO)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfigReviewDTO other = (MesContractProjectAssemblingWeldingConfigReviewDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$pricingManner = this.getPricingManner();
      Object other$pricingManner = other.getPricingManner();
      if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
         Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
         Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
         if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
            Object this$numberOne = this.getNumberOne();
            Object other$numberOne = other.getNumberOne();
            if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
               Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
               Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
               if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
                  Object this$numberTwo = this.getNumberTwo();
                  Object other$numberTwo = other.getNumberTwo();
                  if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                     Object this$measurementManner = this.getMeasurementManner();
                     Object other$measurementManner = other.getMeasurementManner();
                     if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                        Object this$contractProjectShortName = this.getContractProjectShortName();
                        Object other$contractProjectShortName = other.getContractProjectShortName();
                        if (this$contractProjectShortName == null
                           ? other$contractProjectShortName == null
                           : this$contractProjectShortName.equals(other$contractProjectShortName)) {
                           Object this$contractProjectSerialNumber = this.getContractProjectSerialNumber();
                           Object other$contractProjectSerialNumber = other.getContractProjectSerialNumber();
                           if (this$contractProjectSerialNumber == null
                              ? other$contractProjectSerialNumber == null
                              : this$contractProjectSerialNumber.equals(other$contractProjectSerialNumber)) {
                              Object this$initiatorName = this.getInitiatorName();
                              Object other$initiatorName = other.getInitiatorName();
                              if (this$initiatorName == null ? other$initiatorName == null : this$initiatorName.equals(other$initiatorName)) {
                                 Object this$processList = this.getProcessList();
                                 Object other$processList = other.getProcessList();
                                 if (this$processList == null ? other$processList == null : this$processList.equals(other$processList)) {
                                    Object this$artifactClassificationName = this.getArtifactClassificationName();
                                    Object other$artifactClassificationName = other.getArtifactClassificationName();
                                    if (this$artifactClassificationName == null
                                       ? other$artifactClassificationName == null
                                       : this$artifactClassificationName.equals(other$artifactClassificationName)) {
                                       Object this$oldOrganizationInsidePrice = this.getOldOrganizationInsidePrice();
                                       Object other$oldOrganizationInsidePrice = other.getOldOrganizationInsidePrice();
                                       if (this$oldOrganizationInsidePrice == null
                                          ? other$oldOrganizationInsidePrice == null
                                          : this$oldOrganizationInsidePrice.equals(other$oldOrganizationInsidePrice)) {
                                          Object this$oldOrganizationOutsidePrice = this.getOldOrganizationOutsidePrice();
                                          Object other$oldOrganizationOutsidePrice = other.getOldOrganizationOutsidePrice();
                                          if (this$oldOrganizationOutsidePrice == null
                                             ? other$oldOrganizationOutsidePrice == null
                                             : this$oldOrganizationOutsidePrice.equals(other$oldOrganizationOutsidePrice)) {
                                             Object this$reviewerName = this.getReviewerName();
                                             Object other$reviewerName = other.getReviewerName();
                                             if (this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                return this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectAssemblingWeldingConfigReviewDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $contractProjectShortName = this.getContractProjectShortName();
      result = result * 59 + ($contractProjectShortName == null ? 43 : $contractProjectShortName.hashCode());
      Object $contractProjectSerialNumber = this.getContractProjectSerialNumber();
      result = result * 59 + ($contractProjectSerialNumber == null ? 43 : $contractProjectSerialNumber.hashCode());
      Object $initiatorName = this.getInitiatorName();
      result = result * 59 + ($initiatorName == null ? 43 : $initiatorName.hashCode());
      Object $processList = this.getProcessList();
      result = result * 59 + ($processList == null ? 43 : $processList.hashCode());
      Object $artifactClassificationName = this.getArtifactClassificationName();
      result = result * 59 + ($artifactClassificationName == null ? 43 : $artifactClassificationName.hashCode());
      Object $oldOrganizationInsidePrice = this.getOldOrganizationInsidePrice();
      result = result * 59 + ($oldOrganizationInsidePrice == null ? 43 : $oldOrganizationInsidePrice.hashCode());
      Object $oldOrganizationOutsidePrice = this.getOldOrganizationOutsidePrice();
      result = result * 59 + ($oldOrganizationOutsidePrice == null ? 43 : $oldOrganizationOutsidePrice.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   public String getContractProjectShortName() {
      return this.contractProjectShortName;
   }

   public String getContractProjectSerialNumber() {
      return this.contractProjectSerialNumber;
   }

   public String getInitiatorName() {
      return this.initiatorName;
   }

   public List<NameInfo> getProcessList() {
      return this.processList;
   }

   public String getArtifactClassificationName() {
      return this.artifactClassificationName;
   }

   public BigDecimal getOldOrganizationInsidePrice() {
      return this.oldOrganizationInsidePrice;
   }

   public BigDecimal getOldOrganizationOutsidePrice() {
      return this.oldOrganizationOutsidePrice;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public Integer getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public Integer getNumberTwo() {
      return this.numberTwo;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public void setContractProjectShortName(final String contractProjectShortName) {
      this.contractProjectShortName = contractProjectShortName;
   }

   public void setContractProjectSerialNumber(final String contractProjectSerialNumber) {
      this.contractProjectSerialNumber = contractProjectSerialNumber;
   }

   public void setInitiatorName(final String initiatorName) {
      this.initiatorName = initiatorName;
   }

   public void setProcessList(final List<NameInfo> processList) {
      this.processList = processList;
   }

   public void setArtifactClassificationName(final String artifactClassificationName) {
      this.artifactClassificationName = artifactClassificationName;
   }

   public void setOldOrganizationInsidePrice(final BigDecimal oldOrganizationInsidePrice) {
      this.oldOrganizationInsidePrice = oldOrganizationInsidePrice;
   }

   public void setOldOrganizationOutsidePrice(final BigDecimal oldOrganizationOutsidePrice) {
      this.oldOrganizationOutsidePrice = oldOrganizationOutsidePrice;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
   }

   public void setNumberOne(final Integer numberOne) {
      this.numberOne = numberOne;
   }

   public void setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
   }

   public void setNumberTwo(final Integer numberTwo) {
      this.numberTwo = numberTwo;
   }

   public void setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfigReviewDTO(super="
         + super.toString()
         + ", contractProjectShortName="
         + this.getContractProjectShortName()
         + ", contractProjectSerialNumber="
         + this.getContractProjectSerialNumber()
         + ", initiatorName="
         + this.getInitiatorName()
         + ", processList="
         + this.getProcessList()
         + ", artifactClassificationName="
         + this.getArtifactClassificationName()
         + ", oldOrganizationInsidePrice="
         + this.getOldOrganizationInsidePrice()
         + ", oldOrganizationOutsidePrice="
         + this.getOldOrganizationOutsidePrice()
         + ", reviewerName="
         + this.getReviewerName()
         + ", pricingManner="
         + this.getPricingManner()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ")";
   }
}
