package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ArtifactBasicsDTO对象", description = "构件发运跟踪详情 ")
public class ArtifactBasicsDTO {
   @ApiModelProperty(notes = "发运产品关联id")
   private Long linkId;
   @ApiModelProperty(notes = "是否存在制成品退货")
   private Boolean boolExistReturn;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("区域")
   private NameInfo area;
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
   @ApiModelProperty(name = "supplierName", value = "物流公司名称", notes = "物流公司名称")
   private String supplierName;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "structureMeasureMode", value = "结构计量方式", notes = "结构计量方式")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "shipTime", value = "发运时间", notes = "发运时间")
   private String shipTime;
   @ApiModelProperty(name = "orderNumber", value = "序号", notes = "序号")
   private Integer orderNumber;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;

   public static ArtifactBasicsDTO.ArtifactBasicsDTOBuilder builder() {
      return new ArtifactBasicsDTO.ArtifactBasicsDTOBuilder();
   }

   public ArtifactBasicsDTO() {
   }

   public ArtifactBasicsDTO(
      final Long linkId,
      final Boolean boolExistReturn,
      final ProjectInfo project,
      final String projectName,
      final NameInfo monomer,
      final NameInfo area,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer totalQuantity,
      final BigDecimal weight,
      final BigDecimal totalLength,
      final String workshopNames,
      final String licensePlate,
      final String cargoSerialNumber,
      final String actualUserName,
      final String auditUserName,
      final String supplierName,
      final Integer pricingManner,
      final Integer structureMeasureMode,
      final LocalDateTime createTime,
      final String shipTime,
      final Integer orderNumber,
      final String userName
   ) {
      this.linkId = linkId;
      this.boolExistReturn = boolExistReturn;
      this.project = project;
      this.projectName = projectName;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.totalQuantity = totalQuantity;
      this.weight = weight;
      this.totalLength = totalLength;
      this.workshopNames = workshopNames;
      this.licensePlate = licensePlate;
      this.cargoSerialNumber = cargoSerialNumber;
      this.actualUserName = actualUserName;
      this.auditUserName = auditUserName;
      this.supplierName = supplierName;
      this.pricingManner = pricingManner;
      this.structureMeasureMode = structureMeasureMode;
      this.createTime = createTime;
      this.shipTime = shipTime;
      this.orderNumber = orderNumber;
      this.userName = userName;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public Boolean getBoolExistReturn() {
      return this.boolExistReturn;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getProjectName() {
      return this.projectName;
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

   public String getSupplierName() {
      return this.supplierName;
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

   public String getShipTime() {
      return this.shipTime;
   }

   public Integer getOrderNumber() {
      return this.orderNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public ArtifactBasicsDTO setLinkId(final Long linkId) {
      this.linkId = linkId;
      return this;
   }

   public ArtifactBasicsDTO setBoolExistReturn(final Boolean boolExistReturn) {
      this.boolExistReturn = boolExistReturn;
      return this;
   }

   public ArtifactBasicsDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public ArtifactBasicsDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ArtifactBasicsDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public ArtifactBasicsDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public ArtifactBasicsDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public ArtifactBasicsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ArtifactBasicsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public ArtifactBasicsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public ArtifactBasicsDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public ArtifactBasicsDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public ArtifactBasicsDTO setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public ArtifactBasicsDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public ArtifactBasicsDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public ArtifactBasicsDTO setWorkshopNames(final String workshopNames) {
      this.workshopNames = workshopNames;
      return this;
   }

   public ArtifactBasicsDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public ArtifactBasicsDTO setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
      return this;
   }

   public ArtifactBasicsDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public ArtifactBasicsDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public ArtifactBasicsDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ArtifactBasicsDTO setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public ArtifactBasicsDTO setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   public ArtifactBasicsDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ArtifactBasicsDTO setShipTime(final String shipTime) {
      this.shipTime = shipTime;
      return this;
   }

   public ArtifactBasicsDTO setOrderNumber(final Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public ArtifactBasicsDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactBasicsDTO)) {
         return false;
      }

      ArtifactBasicsDTO other = (ArtifactBasicsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$boolExistReturn = this.getBoolExistReturn();
         Object other$boolExistReturn = other.getBoolExistReturn();
         if (this$boolExistReturn == null ? other$boolExistReturn == null : this$boolExistReturn.equals(other$boolExistReturn)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$pricingManner = this.getPricingManner();
               Object other$pricingManner = other.getPricingManner();
               if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                  Object this$structureMeasureMode = this.getStructureMeasureMode();
                  Object other$structureMeasureMode = other.getStructureMeasureMode();
                  if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                     Object this$orderNumber = this.getOrderNumber();
                     Object other$orderNumber = other.getOrderNumber();
                     if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
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
                                                         if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                            Object this$workshopNames = this.getWorkshopNames();
                                                            Object other$workshopNames = other.getWorkshopNames();
                                                            if (this$workshopNames == null
                                                               ? other$workshopNames == null
                                                               : this$workshopNames.equals(other$workshopNames)) {
                                                               Object this$licensePlate = this.getLicensePlate();
                                                               Object other$licensePlate = other.getLicensePlate();
                                                               if (this$licensePlate == null
                                                                  ? other$licensePlate == null
                                                                  : this$licensePlate.equals(other$licensePlate)) {
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
                                                                           Object this$supplierName = this.getSupplierName();
                                                                           Object other$supplierName = other.getSupplierName();
                                                                           if (this$supplierName == null
                                                                              ? other$supplierName == null
                                                                              : this$supplierName.equals(other$supplierName)) {
                                                                              Object this$createTime = this.getCreateTime();
                                                                              Object other$createTime = other.getCreateTime();
                                                                              if (this$createTime == null
                                                                                 ? other$createTime == null
                                                                                 : this$createTime.equals(other$createTime)) {
                                                                                 Object this$shipTime = this.getShipTime();
                                                                                 Object other$shipTime = other.getShipTime();
                                                                                 if (this$shipTime == null
                                                                                    ? other$shipTime == null
                                                                                    : this$shipTime.equals(other$shipTime)) {
                                                                                    Object this$userName = this.getUserName();
                                                                                    Object other$userName = other.getUserName();
                                                                                    return this$userName == null
                                                                                       ? other$userName == null
                                                                                       : this$userName.equals(other$userName);
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
      return other instanceof ArtifactBasicsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $boolExistReturn = this.getBoolExistReturn();
      result = result * 59 + ($boolExistReturn == null ? 43 : $boolExistReturn.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
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
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $shipTime = this.getShipTime();
      result = result * 59 + ($shipTime == null ? 43 : $shipTime.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactBasicsDTO(linkId="
         + this.getLinkId()
         + ", boolExistReturn="
         + this.getBoolExistReturn()
         + ", project="
         + this.getProject()
         + ", projectName="
         + this.getProjectName()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
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
         + ", supplierName="
         + this.getSupplierName()
         + ", pricingManner="
         + this.getPricingManner()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", createTime="
         + this.getCreateTime()
         + ", shipTime="
         + this.getShipTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class ArtifactBasicsDTOBuilder {
      private Long linkId;
      private Boolean boolExistReturn;
      private ProjectInfo project;
      private String projectName;
      private NameInfo monomer;
      private NameInfo area;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer totalQuantity;
      private BigDecimal weight;
      private BigDecimal totalLength;
      private String workshopNames;
      private String licensePlate;
      private String cargoSerialNumber;
      private String actualUserName;
      private String auditUserName;
      private String supplierName;
      private Integer pricingManner;
      private Integer structureMeasureMode;
      private LocalDateTime createTime;
      private String shipTime;
      private Integer orderNumber;
      private String userName;

      ArtifactBasicsDTOBuilder() {
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder boolExistReturn(final Boolean boolExistReturn) {
         this.boolExistReturn = boolExistReturn;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder workshopNames(final String workshopNames) {
         this.workshopNames = workshopNames;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder cargoSerialNumber(final String cargoSerialNumber) {
         this.cargoSerialNumber = cargoSerialNumber;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder shipTime(final String shipTime) {
         this.shipTime = shipTime;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder orderNumber(final Integer orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public ArtifactBasicsDTO.ArtifactBasicsDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ArtifactBasicsDTO build() {
         return new ArtifactBasicsDTO(
            this.linkId,
            this.boolExistReturn,
            this.project,
            this.projectName,
            this.monomer,
            this.area,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.unitPrice,
            this.totalPrice,
            this.totalQuantity,
            this.weight,
            this.totalLength,
            this.workshopNames,
            this.licensePlate,
            this.cargoSerialNumber,
            this.actualUserName,
            this.auditUserName,
            this.supplierName,
            this.pricingManner,
            this.structureMeasureMode,
            this.createTime,
            this.shipTime,
            this.orderNumber,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "ArtifactBasicsDTO.ArtifactBasicsDTOBuilder(linkId="
            + this.linkId
            + ", boolExistReturn="
            + this.boolExistReturn
            + ", project="
            + this.project
            + ", projectName="
            + this.projectName
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
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
            + ", supplierName="
            + this.supplierName
            + ", pricingManner="
            + this.pricingManner
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", createTime="
            + this.createTime
            + ", shipTime="
            + this.shipTime
            + ", orderNumber="
            + this.orderNumber
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
