package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "EnclosureBasicsDTO对象", description = "围护发运跟踪详情 ")
public class EnclosureBasicsDTO {
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "区域(计划)")
   private NameInfo area;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty(name = "plate", notes = "版型")
   private String plate;
   @ApiModelProperty("单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "length", notes = "单长度(mm)")
   private BigDecimal length;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("总数")
   private Integer totalQuantity;
   @ApiModelProperty(name = "totalArea", notes = "总面积）")
   private BigDecimal totalArea;
   @ApiModelProperty("总长度")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "category", notes = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;
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

   public static EnclosureBasicsDTO.EnclosureBasicsDTOBuilder builder() {
      return new EnclosureBasicsDTO.EnclosureBasicsDTOBuilder();
   }

   public EnclosureBasicsDTO() {
   }

   public EnclosureBasicsDTO(
      final ProjectInfo project,
      final NameInfo area,
      final String name,
      final String serialNumber,
      final String plate,
      final BigDecimal surfaceArea,
      final BigDecimal length,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer totalQuantity,
      final BigDecimal totalArea,
      final BigDecimal totalLength,
      final Integer category,
      final Integer pricingManner,
      final LocalDateTime createTime,
      final String workshopNames,
      final String licensePlate,
      final String cargoSerialNumber,
      final String actualUserName,
      final String auditUserName,
      final String userName,
      final String supplierName
   ) {
      this.project = project;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.plate = plate;
      this.surfaceArea = surfaceArea;
      this.length = length;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.totalQuantity = totalQuantity;
      this.totalArea = totalArea;
      this.totalLength = totalLength;
      this.category = category;
      this.pricingManner = pricingManner;
      this.createTime = createTime;
      this.workshopNames = workshopNames;
      this.licensePlate = licensePlate;
      this.cargoSerialNumber = cargoSerialNumber;
      this.actualUserName = actualUserName;
      this.auditUserName = auditUserName;
      this.userName = userName;
      this.supplierName = supplierName;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getLength() {
      return this.length;
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

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public EnclosureBasicsDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public EnclosureBasicsDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public EnclosureBasicsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public EnclosureBasicsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public EnclosureBasicsDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public EnclosureBasicsDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public EnclosureBasicsDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public EnclosureBasicsDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public EnclosureBasicsDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public EnclosureBasicsDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public EnclosureBasicsDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public EnclosureBasicsDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public EnclosureBasicsDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public EnclosureBasicsDTO setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public EnclosureBasicsDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public EnclosureBasicsDTO setWorkshopNames(final String workshopNames) {
      this.workshopNames = workshopNames;
      return this;
   }

   public EnclosureBasicsDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public EnclosureBasicsDTO setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
      return this;
   }

   public EnclosureBasicsDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public EnclosureBasicsDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public EnclosureBasicsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public EnclosureBasicsDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureBasicsDTO)) {
         return false;
      }

      EnclosureBasicsDTO other = (EnclosureBasicsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$pricingManner = this.getPricingManner();
            Object other$pricingManner = other.getPricingManner();
            if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$plate = this.getPlate();
                           Object other$plate = other.getPlate();
                           if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                              Object this$surfaceArea = this.getSurfaceArea();
                              Object other$surfaceArea = other.getSurfaceArea();
                              if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$unitPrice = this.getUnitPrice();
                                    Object other$unitPrice = other.getUnitPrice();
                                    if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                       Object this$totalPrice = this.getTotalPrice();
                                       Object other$totalPrice = other.getTotalPrice();
                                       if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                          Object this$totalArea = this.getTotalArea();
                                          Object other$totalArea = other.getTotalArea();
                                          if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                             Object this$totalLength = this.getTotalLength();
                                             Object other$totalLength = other.getTotalLength();
                                             if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                   Object this$workshopNames = this.getWorkshopNames();
                                                   Object other$workshopNames = other.getWorkshopNames();
                                                   if (this$workshopNames == null
                                                      ? other$workshopNames == null
                                                      : this$workshopNames.equals(other$workshopNames)) {
                                                      Object this$licensePlate = this.getLicensePlate();
                                                      Object other$licensePlate = other.getLicensePlate();
                                                      if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)
                                                         )
                                                       {
                                                         Object this$cargoSerialNumber = this.getCargoSerialNumber();
                                                         Object other$cargoSerialNumber = other.getCargoSerialNumber();
                                                         if (this$cargoSerialNumber == null
                                                            ? other$cargoSerialNumber == null
                                                            : this$cargoSerialNumber.equals(other$cargoSerialNumber)) {
                                                            Object this$actualUserName = this.getActualUserName();
                                                            Object other$actualUserName = other.getActualUserName();
                                                            if (this$actualUserName == null
                                                               ? other$actualUserName == null
                                                               : this$actualUserName.equals(other$actualUserName)) {
                                                               Object this$auditUserName = this.getAuditUserName();
                                                               Object other$auditUserName = other.getAuditUserName();
                                                               if (this$auditUserName == null
                                                                  ? other$auditUserName == null
                                                                  : this$auditUserName.equals(other$auditUserName)) {
                                                                  Object this$userName = this.getUserName();
                                                                  Object other$userName = other.getUserName();
                                                                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                     Object this$supplierName = this.getSupplierName();
                                                                     Object other$supplierName = other.getSupplierName();
                                                                     return this$supplierName == null
                                                                        ? other$supplierName == null
                                                                        : this$supplierName.equals(other$supplierName);
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
      return other instanceof EnclosureBasicsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
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
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureBasicsDTO(project="
         + this.getProject()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", length="
         + this.getLength()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalLength="
         + this.getTotalLength()
         + ", category="
         + this.getCategory()
         + ", pricingManner="
         + this.getPricingManner()
         + ", createTime="
         + this.getCreateTime()
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
         + ")";
   }

   public static class EnclosureBasicsDTOBuilder {
      private ProjectInfo project;
      private NameInfo area;
      private String name;
      private String serialNumber;
      private String plate;
      private BigDecimal surfaceArea;
      private BigDecimal length;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer totalQuantity;
      private BigDecimal totalArea;
      private BigDecimal totalLength;
      private Integer category;
      private Integer pricingManner;
      private LocalDateTime createTime;
      private String workshopNames;
      private String licensePlate;
      private String cargoSerialNumber;
      private String actualUserName;
      private String auditUserName;
      private String userName;
      private String supplierName;

      EnclosureBasicsDTOBuilder() {
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder workshopNames(final String workshopNames) {
         this.workshopNames = workshopNames;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder cargoSerialNumber(final String cargoSerialNumber) {
         this.cargoSerialNumber = cargoSerialNumber;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public EnclosureBasicsDTO.EnclosureBasicsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public EnclosureBasicsDTO build() {
         return new EnclosureBasicsDTO(
            this.project,
            this.area,
            this.name,
            this.serialNumber,
            this.plate,
            this.surfaceArea,
            this.length,
            this.unitPrice,
            this.totalPrice,
            this.totalQuantity,
            this.totalArea,
            this.totalLength,
            this.category,
            this.pricingManner,
            this.createTime,
            this.workshopNames,
            this.licensePlate,
            this.cargoSerialNumber,
            this.actualUserName,
            this.auditUserName,
            this.userName,
            this.supplierName
         );
      }

      @Override
      public String toString() {
         return "EnclosureBasicsDTO.EnclosureBasicsDTOBuilder(project="
            + this.project
            + ", area="
            + this.area
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", plate="
            + this.plate
            + ", surfaceArea="
            + this.surfaceArea
            + ", length="
            + this.length
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", totalQuantity="
            + this.totalQuantity
            + ", totalArea="
            + this.totalArea
            + ", totalLength="
            + this.totalLength
            + ", category="
            + this.category
            + ", pricingManner="
            + this.pricingManner
            + ", createTime="
            + this.createTime
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
            + ")";
      }
   }
}
