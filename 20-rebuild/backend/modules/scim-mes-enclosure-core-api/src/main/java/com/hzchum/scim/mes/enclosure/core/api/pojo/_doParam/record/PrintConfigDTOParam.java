package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.record;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.enclosure.core.api.enums.record.PrintConfigTypeEnum;
import com.hzchum.scim.mes.enclosure.core.api.enums.record.PrintProductTypeEnum;
import io.swagger.annotations.ApiModelProperty;

public class PrintConfigDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("重量 0净重 1毛重 null不显示")
   private Integer weight;
   @ApiModelProperty("显示生产线 1显示 0不显示")
   private Boolean showProductionLine;
   @ApiModelProperty("显示单体 1显示 0不显示")
   private Boolean showMonomer;
   @ApiModelProperty("显示区域 1显示 0不显示")
   private Boolean showArea;
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
                                    Object this$manufacturerName = this.getManufacturerName();
                                    Object other$manufacturerName = other.getManufacturerName();
                                    return this$manufacturerName == null
                                       ? other$manufacturerName == null
                                       : this$manufacturerName.equals(other$manufacturerName);
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
      Object $manufacturerName = this.getManufacturerName();
      return result * 59 + ($manufacturerName == null ? 43 : $manufacturerName.hashCode());
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
         + ")";
   }
}
