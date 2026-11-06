package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("配套件详情基本信息")
public class TechStandardPartBaseInfo {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "项目")
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("产品id")
   private Long cargoProductId;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "warehouseRecordId", value = "出入库id", notes = "出入库id")
   private Long warehouseRecordId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   private Long packageId;
   @ApiModelProperty(name = "boolWeightTypeEnum", value = "(核算单位)是否重量类型 true是 false否", notes = "(核算单位)是否重量类型 true是 false否")
   private Boolean boolWeightTypeEnum;
   @ApiModelProperty("配套件备注")
   private String remark;
   @ApiModelProperty(name = "createUserNames")
   private String createUserNames;

   public Long getLinkId() {
      return this.linkId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getCargoProductId() {
      return this.cargoProductId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Boolean getBoolWeightTypeEnum() {
      return this.boolWeightTypeEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getCreateUserNames() {
      return this.createUserNames;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCargoProductId(final Long cargoProductId) {
      this.cargoProductId = cargoProductId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setBoolWeightTypeEnum(final Boolean boolWeightTypeEnum) {
      this.boolWeightTypeEnum = boolWeightTypeEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateUserNames(final String createUserNames) {
      this.createUserNames = createUserNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartBaseInfo)) {
         return false;
      }

      TechStandardPartBaseInfo other = (TechStandardPartBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$cargoProductId = this.getCargoProductId();
         Object other$cargoProductId = other.getCargoProductId();
         if (this$cargoProductId == null ? other$cargoProductId == null : this$cargoProductId.equals(other$cargoProductId)) {
            Object this$warehouseRecordId = this.getWarehouseRecordId();
            Object other$warehouseRecordId = other.getWarehouseRecordId();
            if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
               Object this$packageId = this.getPackageId();
               Object other$packageId = other.getPackageId();
               if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                  Object this$boolWeightTypeEnum = this.getBoolWeightTypeEnum();
                  Object other$boolWeightTypeEnum = other.getBoolWeightTypeEnum();
                  if (this$boolWeightTypeEnum == null ? other$boolWeightTypeEnum == null : this$boolWeightTypeEnum.equals(other$boolWeightTypeEnum)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                          Object this$measureUnit = this.getMeasureUnit();
                                          Object other$measureUnit = other.getMeasureUnit();
                                          if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$accountingUnit = this.getAccountingUnit();
                                                Object other$accountingUnit = other.getAccountingUnit();
                                                if (this$accountingUnit == null
                                                   ? other$accountingUnit == null
                                                   : this$accountingUnit.equals(other$accountingUnit)) {
                                                   Object this$remark = this.getRemark();
                                                   Object other$remark = other.getRemark();
                                                   if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                      Object this$createUserNames = this.getCreateUserNames();
                                                      Object other$createUserNames = other.getCreateUserNames();
                                                      return this$createUserNames == null
                                                         ? other$createUserNames == null
                                                         : this$createUserNames.equals(other$createUserNames);
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
      return other instanceof TechStandardPartBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $cargoProductId = this.getCargoProductId();
      result = result * 59 + ($cargoProductId == null ? 43 : $cargoProductId.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $boolWeightTypeEnum = this.getBoolWeightTypeEnum();
      result = result * 59 + ($boolWeightTypeEnum == null ? 43 : $boolWeightTypeEnum.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserNames = this.getCreateUserNames();
      return result * 59 + ($createUserNames == null ? 43 : $createUserNames.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartBaseInfo(linkId="
         + this.getLinkId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", cargoProductId="
         + this.getCargoProductId()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", packageId="
         + this.getPackageId()
         + ", boolWeightTypeEnum="
         + this.getBoolWeightTypeEnum()
         + ", remark="
         + this.getRemark()
         + ", createUserNames="
         + this.getCreateUserNames()
         + ")";
   }
}
