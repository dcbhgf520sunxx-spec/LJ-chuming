package com.hzchum.scim.mes.building.core.api.pojo._doParam.record;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintConfigTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.record.PrintProductTypeEnum;
import io.swagger.annotations.ApiModelProperty;

public class PrintConfigDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("重量 0净重 1毛重 2图纸重 null不显示")
   private Integer weight;
   @ApiModelProperty("显示生产线 1显示 0不显示")
   private Boolean showProductionLine;
   @ApiModelProperty("显示单体 1显示 0不显示")
   private Boolean showMonomer;
   @ApiModelProperty("显示区域 1显示 0不显示")
   private Boolean showArea;
   @ApiModelProperty("显示批次 1显示 0不显示")
   private Boolean showBatch;
   @ApiModelProperty("显示生产日期  1显示 0不显示")
   private Boolean dateInProduced;
   @ApiModelProperty("制造商")
   private String manufacturerName;
   @ApiModelProperty("份数")
   private Integer copiesQuantity;
   @ApiModelProperty("是否打印 全部 1是 0否")
   private Boolean printAll;
   @ApiModelProperty("标签类型")
   @EnumValidator(value = PrintConfigTypeEnum.class, message = "标签类型不支持")
   private Integer type;
   @ApiModelProperty("类型")
   @EnumValidator(value = PrintProductTypeEnum.class, message = "打印类型不支持")
   private Integer printType;
   @ApiModelProperty("显示名称 1显示 0不显示")
   private Boolean showProductName;
   @ApiModelProperty("标签尺寸")
   private Integer labelSize;
   @ApiModelProperty("语言")
   private String language;
   @ApiModelProperty("重量 显示长度 1显示 0不显示")
   private Boolean showLength;
   @ApiModelProperty("显示项目名称 1显示 0不显示")
   private Boolean showProjectName;
   @ApiModelProperty("显示项目编号 1显示 0不显示")
   private Boolean showProjectSerialNumber;
   @ApiModelProperty("显示规格 1显示 0不显示")
   private Boolean showSpecification;
   @ApiModelProperty("显示数量 1显示 0不显示")
   private Boolean showQuantity;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getWeight() {
      return this.weight;
   }

   public Boolean getShowProductionLine() {
      return this.showProductionLine;
   }

   public Boolean getShowMonomer() {
      return this.showMonomer;
   }

   public Boolean getShowArea() {
      return this.showArea;
   }

   public Boolean getShowBatch() {
      return this.showBatch;
   }

   public Boolean getDateInProduced() {
      return this.dateInProduced;
   }

   public String getManufacturerName() {
      return this.manufacturerName;
   }

   public Integer getCopiesQuantity() {
      return this.copiesQuantity;
   }

   public Boolean getPrintAll() {
      return this.printAll;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getPrintType() {
      return this.printType;
   }

   public Boolean getShowProductName() {
      return this.showProductName;
   }

   public Integer getLabelSize() {
      return this.labelSize;
   }

   public String getLanguage() {
      return this.language;
   }

   public Boolean getShowLength() {
      return this.showLength;
   }

   public Boolean getShowProjectName() {
      return this.showProjectName;
   }

   public Boolean getShowProjectSerialNumber() {
      return this.showProjectSerialNumber;
   }

   public Boolean getShowSpecification() {
      return this.showSpecification;
   }

   public Boolean getShowQuantity() {
      return this.showQuantity;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWeight(final Integer weight) {
      this.weight = weight;
   }

   public void setShowProductionLine(final Boolean showProductionLine) {
      this.showProductionLine = showProductionLine;
   }

   public void setShowMonomer(final Boolean showMonomer) {
      this.showMonomer = showMonomer;
   }

   public void setShowArea(final Boolean showArea) {
      this.showArea = showArea;
   }

   public void setShowBatch(final Boolean showBatch) {
      this.showBatch = showBatch;
   }

   public void setDateInProduced(final Boolean dateInProduced) {
      this.dateInProduced = dateInProduced;
   }

   public void setManufacturerName(final String manufacturerName) {
      this.manufacturerName = manufacturerName;
   }

   public void setCopiesQuantity(final Integer copiesQuantity) {
      this.copiesQuantity = copiesQuantity;
   }

   public void setPrintAll(final Boolean printAll) {
      this.printAll = printAll;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setPrintType(final Integer printType) {
      this.printType = printType;
   }

   public void setShowProductName(final Boolean showProductName) {
      this.showProductName = showProductName;
   }

   public void setLabelSize(final Integer labelSize) {
      this.labelSize = labelSize;
   }

   public void setLanguage(final String language) {
      this.language = language;
   }

   public void setShowLength(final Boolean showLength) {
      this.showLength = showLength;
   }

   public void setShowProjectName(final Boolean showProjectName) {
      this.showProjectName = showProjectName;
   }

   public void setShowProjectSerialNumber(final Boolean showProjectSerialNumber) {
      this.showProjectSerialNumber = showProjectSerialNumber;
   }

   public void setShowSpecification(final Boolean showSpecification) {
      this.showSpecification = showSpecification;
   }

   public void setShowQuantity(final Boolean showQuantity) {
      this.showQuantity = showQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintConfigDTOParam)) {
         return false;
      }

      PrintConfigDTOParam other = (PrintConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$weight = this.getWeight();
         Object other$weight = other.getWeight();
         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
            Object this$showProductionLine = this.getShowProductionLine();
            Object other$showProductionLine = other.getShowProductionLine();
            if (this$showProductionLine == null ? other$showProductionLine == null : this$showProductionLine.equals(other$showProductionLine)) {
               Object this$showMonomer = this.getShowMonomer();
               Object other$showMonomer = other.getShowMonomer();
               if (this$showMonomer == null ? other$showMonomer == null : this$showMonomer.equals(other$showMonomer)) {
                  Object this$showArea = this.getShowArea();
                  Object other$showArea = other.getShowArea();
                  if (this$showArea == null ? other$showArea == null : this$showArea.equals(other$showArea)) {
                     Object this$showBatch = this.getShowBatch();
                     Object other$showBatch = other.getShowBatch();
                     if (this$showBatch == null ? other$showBatch == null : this$showBatch.equals(other$showBatch)) {
                        Object this$dateInProduced = this.getDateInProduced();
                        Object other$dateInProduced = other.getDateInProduced();
                        if (this$dateInProduced == null ? other$dateInProduced == null : this$dateInProduced.equals(other$dateInProduced)) {
                           Object this$copiesQuantity = this.getCopiesQuantity();
                           Object other$copiesQuantity = other.getCopiesQuantity();
                           if (this$copiesQuantity == null ? other$copiesQuantity == null : this$copiesQuantity.equals(other$copiesQuantity)) {
                              Object this$printAll = this.getPrintAll();
                              Object other$printAll = other.getPrintAll();
                              if (this$printAll == null ? other$printAll == null : this$printAll.equals(other$printAll)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                    Object this$printType = this.getPrintType();
                                    Object other$printType = other.getPrintType();
                                    if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                                       Object this$showProductName = this.getShowProductName();
                                       Object other$showProductName = other.getShowProductName();
                                       if (this$showProductName == null ? other$showProductName == null : this$showProductName.equals(other$showProductName)) {
                                          Object this$labelSize = this.getLabelSize();
                                          Object other$labelSize = other.getLabelSize();
                                          if (this$labelSize == null ? other$labelSize == null : this$labelSize.equals(other$labelSize)) {
                                             Object this$showLength = this.getShowLength();
                                             Object other$showLength = other.getShowLength();
                                             if (this$showLength == null ? other$showLength == null : this$showLength.equals(other$showLength)) {
                                                Object this$showProjectName = this.getShowProjectName();
                                                Object other$showProjectName = other.getShowProjectName();
                                                if (this$showProjectName == null
                                                   ? other$showProjectName == null
                                                   : this$showProjectName.equals(other$showProjectName)) {
                                                   Object this$showProjectSerialNumber = this.getShowProjectSerialNumber();
                                                   Object other$showProjectSerialNumber = other.getShowProjectSerialNumber();
                                                   if (this$showProjectSerialNumber == null
                                                      ? other$showProjectSerialNumber == null
                                                      : this$showProjectSerialNumber.equals(other$showProjectSerialNumber)) {
                                                      Object this$showSpecification = this.getShowSpecification();
                                                      Object other$showSpecification = other.getShowSpecification();
                                                      if (this$showSpecification == null
                                                         ? other$showSpecification == null
                                                         : this$showSpecification.equals(other$showSpecification)) {
                                                         Object this$showQuantity = this.getShowQuantity();
                                                         Object other$showQuantity = other.getShowQuantity();
                                                         if (this$showQuantity == null
                                                            ? other$showQuantity == null
                                                            : this$showQuantity.equals(other$showQuantity)) {
                                                            Object this$manufacturerName = this.getManufacturerName();
                                                            Object other$manufacturerName = other.getManufacturerName();
                                                            if (this$manufacturerName == null
                                                               ? other$manufacturerName == null
                                                               : this$manufacturerName.equals(other$manufacturerName)) {
                                                               Object this$language = this.getLanguage();
                                                               Object other$language = other.getLanguage();
                                                               return this$language == null ? other$language == null : this$language.equals(other$language);
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
      return other instanceof PrintConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $showProductionLine = this.getShowProductionLine();
      result = result * 59 + ($showProductionLine == null ? 43 : $showProductionLine.hashCode());
      Object $showMonomer = this.getShowMonomer();
      result = result * 59 + ($showMonomer == null ? 43 : $showMonomer.hashCode());
      Object $showArea = this.getShowArea();
      result = result * 59 + ($showArea == null ? 43 : $showArea.hashCode());
      Object $showBatch = this.getShowBatch();
      result = result * 59 + ($showBatch == null ? 43 : $showBatch.hashCode());
      Object $dateInProduced = this.getDateInProduced();
      result = result * 59 + ($dateInProduced == null ? 43 : $dateInProduced.hashCode());
      Object $copiesQuantity = this.getCopiesQuantity();
      result = result * 59 + ($copiesQuantity == null ? 43 : $copiesQuantity.hashCode());
      Object $printAll = this.getPrintAll();
      result = result * 59 + ($printAll == null ? 43 : $printAll.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $showProductName = this.getShowProductName();
      result = result * 59 + ($showProductName == null ? 43 : $showProductName.hashCode());
      Object $labelSize = this.getLabelSize();
      result = result * 59 + ($labelSize == null ? 43 : $labelSize.hashCode());
      Object $showLength = this.getShowLength();
      result = result * 59 + ($showLength == null ? 43 : $showLength.hashCode());
      Object $showProjectName = this.getShowProjectName();
      result = result * 59 + ($showProjectName == null ? 43 : $showProjectName.hashCode());
      Object $showProjectSerialNumber = this.getShowProjectSerialNumber();
      result = result * 59 + ($showProjectSerialNumber == null ? 43 : $showProjectSerialNumber.hashCode());
      Object $showSpecification = this.getShowSpecification();
      result = result * 59 + ($showSpecification == null ? 43 : $showSpecification.hashCode());
      Object $showQuantity = this.getShowQuantity();
      result = result * 59 + ($showQuantity == null ? 43 : $showQuantity.hashCode());
      Object $manufacturerName = this.getManufacturerName();
      result = result * 59 + ($manufacturerName == null ? 43 : $manufacturerName.hashCode());
      Object $language = this.getLanguage();
      return result * 59 + ($language == null ? 43 : $language.hashCode());
   }

   @Override
   public String toString() {
      return "PrintConfigDTOParam(projectId="
         + this.getProjectId()
         + ", weight="
         + this.getWeight()
         + ", showProductionLine="
         + this.getShowProductionLine()
         + ", showMonomer="
         + this.getShowMonomer()
         + ", showArea="
         + this.getShowArea()
         + ", showBatch="
         + this.getShowBatch()
         + ", dateInProduced="
         + this.getDateInProduced()
         + ", manufacturerName="
         + this.getManufacturerName()
         + ", copiesQuantity="
         + this.getCopiesQuantity()
         + ", printAll="
         + this.getPrintAll()
         + ", type="
         + this.getType()
         + ", printType="
         + this.getPrintType()
         + ", showProductName="
         + this.getShowProductName()
         + ", labelSize="
         + this.getLabelSize()
         + ", language="
         + this.getLanguage()
         + ", showLength="
         + this.getShowLength()
         + ", showProjectName="
         + this.getShowProjectName()
         + ", showProjectSerialNumber="
         + this.getShowProjectSerialNumber()
         + ", showSpecification="
         + this.getShowSpecification()
         + ", showQuantity="
         + this.getShowQuantity()
         + ")";
   }
}
