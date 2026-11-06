package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "BoxBasicsDTO对象", description = "分段发运跟踪详情 ")
public class BoxBasicsDTO {
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("区域")
   private NameInfo area;
   @ApiModelProperty("生产车间名称(多个以逗号分隔)")
   private String workshopNames;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "cargoSerialNumber", value = "车次编号", notes = "车次编号")
   private String cargoSerialNumber;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   private String actualUserName;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "supplierName", value = "物流公司名称", notes = "物流公司名称")
   private String supplierName;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("总数")
   private Integer totalQuantity;
   @ApiModelProperty("总重（t）")
   private BigDecimal weight;
   @ApiModelProperty("总长度(米)")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "structureMeasureMode", value = "结构计量方式", notes = "结构计量方式")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;

   public static BoxBasicsDTO.BoxBasicsDTOBuilder builder() {
      return new BoxBasicsDTO.BoxBasicsDTOBuilder();
   }

   public BoxBasicsDTO() {
   }

   public BoxBasicsDTO(
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final String workshopNames,
      final String licensePlate,
      final String cargoSerialNumber,
      final String actualUserName,
      final String auditUserName,
      final String userName,
      final String supplierName,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer totalQuantity,
      final BigDecimal weight,
      final BigDecimal totalLength,
      final Integer pricingManner,
      final Integer structureMeasureMode,
      final LocalDateTime createTime
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.workshopNames = workshopNames;
      this.licensePlate = licensePlate;
      this.cargoSerialNumber = cargoSerialNumber;
      this.actualUserName = actualUserName;
      this.auditUserName = auditUserName;
      this.userName = userName;
      this.supplierName = supplierName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.totalQuantity = totalQuantity;
      this.weight = weight;
      this.totalLength = totalLength;
      this.pricingManner = pricingManner;
      this.structureMeasureMode = structureMeasureMode;
      this.createTime = createTime;
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

   public String getWorkshopNames() {
      return this.workshopNames;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getCargoSerialNumber() {
      return this.cargoSerialNumber;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BoxBasicsDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public BoxBasicsDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public BoxBasicsDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public BoxBasicsDTO setWorkshopNames(final String workshopNames) {
      this.workshopNames = workshopNames;
      return this;
   }

   public BoxBasicsDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public BoxBasicsDTO setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
      return this;
   }

   public BoxBasicsDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public BoxBasicsDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public BoxBasicsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public BoxBasicsDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public BoxBasicsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public BoxBasicsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public BoxBasicsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public BoxBasicsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public BoxBasicsDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public BoxBasicsDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public BoxBasicsDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public BoxBasicsDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public BoxBasicsDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public BoxBasicsDTO setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public BoxBasicsDTO setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   public BoxBasicsDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoxBasicsDTO)) {
         return false;
      }

      BoxBasicsDTO other = (BoxBasicsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$pricingManner = this.getPricingManner();
         Object other$pricingManner = other.getPricingManner();
         if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
            Object this$structureMeasureMode = this.getStructureMeasureMode();
            Object other$structureMeasureMode = other.getStructureMeasureMode();
            if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$workshopNames = this.getWorkshopNames();
                        Object other$workshopNames = other.getWorkshopNames();
                        if (this$workshopNames == null ? other$workshopNames == null : this$workshopNames.equals(other$workshopNames)) {
                           Object this$licensePlate = this.getLicensePlate();
                           Object other$licensePlate = other.getLicensePlate();
                           if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                              Object this$cargoSerialNumber = this.getCargoSerialNumber();
                              Object other$cargoSerialNumber = other.getCargoSerialNumber();
                              if (this$cargoSerialNumber == null ? other$cargoSerialNumber == null : this$cargoSerialNumber.equals(other$cargoSerialNumber)) {
                                 Object this$actualUserName = this.getActualUserName();
                                 Object other$actualUserName = other.getActualUserName();
                                 if (this$actualUserName == null ? other$actualUserName == null : this$actualUserName.equals(other$actualUserName)) {
                                    Object this$auditUserName = this.getAuditUserName();
                                    Object other$auditUserName = other.getAuditUserName();
                                    if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$supplierName = this.getSupplierName();
                                          Object other$supplierName = other.getSupplierName();
                                          if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                             Object this$name = this.getName();
                                             Object other$name = other.getName();
                                             if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$totalPrice = this.getTotalPrice();
                                                            Object other$totalPrice = other.getTotalPrice();
                                                            if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                               Object this$weight = this.getWeight();
                                                               Object other$weight = other.getWeight();
                                                               if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                  Object this$totalLength = this.getTotalLength();
                                                                  Object other$totalLength = other.getTotalLength();
                                                                  if (this$totalLength == null
                                                                     ? other$totalLength == null
                                                                     : this$totalLength.equals(other$totalLength)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BoxBasicsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workshopNames = this.getWorkshopNames();
      result = result * 59 + ($workshopNames == null ? 43 : $workshopNames.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $cargoSerialNumber = this.getCargoSerialNumber();
      result = result * 59 + ($cargoSerialNumber == null ? 43 : $cargoSerialNumber.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "BoxBasicsDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshopNames="
         + this.getWorkshopNames()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", cargoSerialNumber="
         + this.getCargoSerialNumber()
         + ", actualUserName="
         + this.getActualUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", userName="
         + this.getUserName()
         + ", supplierName="
         + this.getSupplierName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", weight="
         + this.getWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", pricingManner="
         + this.getPricingManner()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class BoxBasicsDTOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private String workshopNames;
      private String licensePlate;
      private String cargoSerialNumber;
      private String actualUserName;
      private String auditUserName;
      private String userName;
      private String supplierName;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer totalQuantity;
      private BigDecimal weight;
      private BigDecimal totalLength;
      private Integer pricingManner;
      private Integer structureMeasureMode;
      private LocalDateTime createTime;

      BoxBasicsDTOBuilder() {
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder workshopNames(final String workshopNames) {
         this.workshopNames = workshopNames;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder cargoSerialNumber(final String cargoSerialNumber) {
         this.cargoSerialNumber = cargoSerialNumber;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public BoxBasicsDTO.BoxBasicsDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BoxBasicsDTO build() {
         return new BoxBasicsDTO(
            this.project,
            this.monomer,
            this.area,
            this.workshopNames,
            this.licensePlate,
            this.cargoSerialNumber,
            this.actualUserName,
            this.auditUserName,
            this.userName,
            this.supplierName,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.unitPrice,
            this.totalPrice,
            this.totalQuantity,
            this.weight,
            this.totalLength,
            this.pricingManner,
            this.structureMeasureMode,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "BoxBasicsDTO.BoxBasicsDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshopNames="
            + this.workshopNames
            + ", licensePlate="
            + this.licensePlate
            + ", cargoSerialNumber="
            + this.cargoSerialNumber
            + ", actualUserName="
            + this.actualUserName
            + ", auditUserName="
            + this.auditUserName
            + ", userName="
            + this.userName
            + ", supplierName="
            + this.supplierName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", totalQuantity="
            + this.totalQuantity
            + ", weight="
            + this.weight
            + ", totalLength="
            + this.totalLength
            + ", pricingManner="
            + this.pricingManner
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
