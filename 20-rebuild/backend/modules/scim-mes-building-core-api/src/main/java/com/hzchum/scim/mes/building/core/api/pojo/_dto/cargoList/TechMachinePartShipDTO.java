package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TechMachinePartShipDTO", description = "直发件发运详情 ")
public class TechMachinePartShipDTO {
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
   @ApiModelProperty("生产车间名称(多个以逗号分隔)")
   private String workshopNames;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "cargoSerialNumber", value = "车次编号", notes = "车次编号")
   private String cargoSerialNumber;
   @ApiModelProperty(name = "actualUserName", value = "过磅人名称", notes = "过磅人名称")
   private String actualUserName;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "supplierName", value = "物流公司名称", notes = "物流公司名称")
   private String supplierName;
   @ApiModelProperty(name = "structureMeasureMode", value = "结构计量方式", notes = "结构计量方式")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "createTime", value = "发运时间", notes = "发运时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "shipTime", value = "发运时间", notes = "发运时间")
   private String shipTime;
   @ApiModelProperty(name = "orderNumber", value = "序号", notes = "序号")
   private Integer orderNumber;
   @ApiModelProperty("构件id")
   private Long artifactId;
   @ApiModelProperty("零件商务id")
   private Long businessId;
   @ApiModelProperty("零件规格")
   private String specification;
   @ApiModelProperty("零件材质")
   private String material;
   @ApiModelProperty("发运总数量")
   private Integer quantity;
   @ApiModelProperty("零件清单总重")
   private BigDecimal totalWeight;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("零件总长度（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty("每根构件上零件的总重量")
   private BigDecimal Weight;
   @ApiModelProperty("每根构件上零件的总长度（mm）")
   private BigDecimal Length;
   @ApiModelProperty("总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "actualTime", value = "过磅日期", notes = "过磅日期")
   private LocalDateTime actualTime;
   @ApiModelProperty(name = "pricingManner", value = "计价方式", notes = "计价方式")
   private Integer pricingManner;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty("入库类型 0普通入库 1回厂返修")
   private Integer warehouseType;

   public static TechMachinePartShipDTO.TechMachinePartShipDTOBuilder builder() {
      return new TechMachinePartShipDTO.TechMachinePartShipDTOBuilder();
   }

   public TechMachinePartShipDTO() {
   }

   public TechMachinePartShipDTO(
      final ProjectInfo project,
      final String projectName,
      final NameInfo monomer,
      final NameInfo area,
      final String name,
      final String serialNumber,
      final String workshopNames,
      final String licensePlate,
      final String cargoSerialNumber,
      final String actualUserName,
      final String userName,
      final String auditUserName,
      final String supplierName,
      final Integer structureMeasureMode,
      final LocalDateTime createTime,
      final String shipTime,
      final Integer orderNumber,
      final Long artifactId,
      final Long businessId,
      final String specification,
      final String material,
      final Integer quantity,
      final BigDecimal totalWeight,
      final BigDecimal unitPrice,
      final BigDecimal totalLength,
      final BigDecimal Weight,
      final BigDecimal Length,
      final BigDecimal totalPrice,
      final LocalDateTime actualTime,
      final Integer pricingManner,
      final Boolean boolAllPartSendDirectly,
      final Integer warehouseType
   ) {
      this.project = project;
      this.projectName = projectName;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.workshopNames = workshopNames;
      this.licensePlate = licensePlate;
      this.cargoSerialNumber = cargoSerialNumber;
      this.actualUserName = actualUserName;
      this.userName = userName;
      this.auditUserName = auditUserName;
      this.supplierName = supplierName;
      this.structureMeasureMode = structureMeasureMode;
      this.createTime = createTime;
      this.shipTime = shipTime;
      this.orderNumber = orderNumber;
      this.artifactId = artifactId;
      this.businessId = businessId;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.totalWeight = totalWeight;
      this.unitPrice = unitPrice;
      this.totalLength = totalLength;
      this.Weight = Weight;
      this.Length = Length;
      this.totalPrice = totalPrice;
      this.actualTime = actualTime;
      this.pricingManner = pricingManner;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.warehouseType = warehouseType;
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

   public String getUserName() {
      return this.userName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public String getSupplierName() {
      return this.supplierName;
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

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getWeight() {
      return this.Weight;
   }

   public BigDecimal getLength() {
      return this.Length;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public LocalDateTime getActualTime() {
      return this.actualTime;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public TechMachinePartShipDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   public TechMachinePartShipDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public TechMachinePartShipDTO setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
      return this;
   }

   public TechMachinePartShipDTO setArea(final NameInfo area) {
      this.area = area;
      return this;
   }

   public TechMachinePartShipDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TechMachinePartShipDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechMachinePartShipDTO setWorkshopNames(final String workshopNames) {
      this.workshopNames = workshopNames;
      return this;
   }

   public TechMachinePartShipDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public TechMachinePartShipDTO setCargoSerialNumber(final String cargoSerialNumber) {
      this.cargoSerialNumber = cargoSerialNumber;
      return this;
   }

   public TechMachinePartShipDTO setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
      return this;
   }

   public TechMachinePartShipDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public TechMachinePartShipDTO setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
      return this;
   }

   public TechMachinePartShipDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public TechMachinePartShipDTO setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
      return this;
   }

   public TechMachinePartShipDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public TechMachinePartShipDTO setShipTime(final String shipTime) {
      this.shipTime = shipTime;
      return this;
   }

   public TechMachinePartShipDTO setOrderNumber(final Integer orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public TechMachinePartShipDTO setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public TechMachinePartShipDTO setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public TechMachinePartShipDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechMachinePartShipDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechMachinePartShipDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechMachinePartShipDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public TechMachinePartShipDTO setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public TechMachinePartShipDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public TechMachinePartShipDTO setWeight(final BigDecimal Weight) {
      this.Weight = Weight;
      return this;
   }

   public TechMachinePartShipDTO setLength(final BigDecimal Length) {
      this.Length = Length;
      return this;
   }

   public TechMachinePartShipDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public TechMachinePartShipDTO setActualTime(final LocalDateTime actualTime) {
      this.actualTime = actualTime;
      return this;
   }

   public TechMachinePartShipDTO setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public TechMachinePartShipDTO setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechMachinePartShipDTO setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartShipDTO)) {
         return false;
      }

      TechMachinePartShipDTO other = (TechMachinePartShipDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureMeasureMode = this.getStructureMeasureMode();
      Object other$structureMeasureMode = other.getStructureMeasureMode();
      if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
         Object this$orderNumber = this.getOrderNumber();
         Object other$orderNumber = other.getOrderNumber();
         if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
            Object this$artifactId = this.getArtifactId();
            Object other$artifactId = other.getArtifactId();
            if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
               Object this$businessId = this.getBusinessId();
               Object other$businessId = other.getBusinessId();
               if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$pricingManner = this.getPricingManner();
                     Object other$pricingManner = other.getPricingManner();
                     if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                        Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                        Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                        if (this$boolAllPartSendDirectly == null
                           ? other$boolAllPartSendDirectly == null
                           : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                           Object this$warehouseType = this.getWarehouseType();
                           Object other$warehouseType = other.getWarehouseType();
                           if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
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
                                                Object this$workshopNames = this.getWorkshopNames();
                                                Object other$workshopNames = other.getWorkshopNames();
                                                if (this$workshopNames == null ? other$workshopNames == null : this$workshopNames.equals(other$workshopNames)) {
                                                   Object this$licensePlate = this.getLicensePlate();
                                                   Object other$licensePlate = other.getLicensePlate();
                                                   if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
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
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
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
                                                                           Object this$specification = this.getSpecification();
                                                                           Object other$specification = other.getSpecification();
                                                                           if (this$specification == null
                                                                              ? other$specification == null
                                                                              : this$specification.equals(other$specification)) {
                                                                              Object this$material = this.getMaterial();
                                                                              Object other$material = other.getMaterial();
                                                                              if (this$material == null
                                                                                 ? other$material == null
                                                                                 : this$material.equals(other$material)) {
                                                                                 Object this$totalWeight = this.getTotalWeight();
                                                                                 Object other$totalWeight = other.getTotalWeight();
                                                                                 if (this$totalWeight == null
                                                                                    ? other$totalWeight == null
                                                                                    : this$totalWeight.equals(other$totalWeight)) {
                                                                                    Object this$unitPrice = this.getUnitPrice();
                                                                                    Object other$unitPrice = other.getUnitPrice();
                                                                                    if (this$unitPrice == null
                                                                                       ? other$unitPrice == null
                                                                                       : this$unitPrice.equals(other$unitPrice)) {
                                                                                       Object this$totalLength = this.getTotalLength();
                                                                                       Object other$totalLength = other.getTotalLength();
                                                                                       if (this$totalLength == null
                                                                                          ? other$totalLength == null
                                                                                          : this$totalLength.equals(other$totalLength)) {
                                                                                          Object this$Weight = this.getWeight();
                                                                                          Object other$Weight = other.getWeight();
                                                                                          if (this$Weight == null
                                                                                             ? other$Weight == null
                                                                                             : this$Weight.equals(other$Weight)) {
                                                                                             Object this$Length = this.getLength();
                                                                                             Object other$Length = other.getLength();
                                                                                             if (this$Length == null
                                                                                                ? other$Length == null
                                                                                                : this$Length.equals(other$Length)) {
                                                                                                Object this$totalPrice = this.getTotalPrice();
                                                                                                Object other$totalPrice = other.getTotalPrice();
                                                                                                if (this$totalPrice == null
                                                                                                   ? other$totalPrice == null
                                                                                                   : this$totalPrice.equals(other$totalPrice)) {
                                                                                                   Object this$actualTime = this.getActualTime();
                                                                                                   Object other$actualTime = other.getActualTime();
                                                                                                   return this$actualTime == null
                                                                                                      ? other$actualTime == null
                                                                                                      : this$actualTime.equals(other$actualTime);
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
      return other instanceof TechMachinePartShipDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
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
      Object $workshopNames = this.getWorkshopNames();
      result = result * 59 + ($workshopNames == null ? 43 : $workshopNames.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $cargoSerialNumber = this.getCargoSerialNumber();
      result = result * 59 + ($cargoSerialNumber == null ? 43 : $cargoSerialNumber.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $shipTime = this.getShipTime();
      result = result * 59 + ($shipTime == null ? 43 : $shipTime.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $Weight = this.getWeight();
      result = result * 59 + ($Weight == null ? 43 : $Weight.hashCode());
      Object $Length = this.getLength();
      result = result * 59 + ($Length == null ? 43 : $Length.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $actualTime = this.getActualTime();
      return result * 59 + ($actualTime == null ? 43 : $actualTime.hashCode());
   }

   @Override
   public String toString() {
      return "TechMachinePartShipDTO(project="
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
         + ", workshopNames="
         + this.getWorkshopNames()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", cargoSerialNumber="
         + this.getCargoSerialNumber()
         + ", actualUserName="
         + this.getActualUserName()
         + ", userName="
         + this.getUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", supplierName="
         + this.getSupplierName()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", createTime="
         + this.getCreateTime()
         + ", shipTime="
         + this.getShipTime()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", artifactId="
         + this.getArtifactId()
         + ", businessId="
         + this.getBusinessId()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalLength="
         + this.getTotalLength()
         + ", Weight="
         + this.getWeight()
         + ", Length="
         + this.getLength()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", actualTime="
         + this.getActualTime()
         + ", pricingManner="
         + this.getPricingManner()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", warehouseType="
         + this.getWarehouseType()
         + ")";
   }

   public static class TechMachinePartShipDTOBuilder {
      private ProjectInfo project;
      private String projectName;
      private NameInfo monomer;
      private NameInfo area;
      private String name;
      private String serialNumber;
      private String workshopNames;
      private String licensePlate;
      private String cargoSerialNumber;
      private String actualUserName;
      private String userName;
      private String auditUserName;
      private String supplierName;
      private Integer structureMeasureMode;
      private LocalDateTime createTime;
      private String shipTime;
      private Integer orderNumber;
      private Long artifactId;
      private Long businessId;
      private String specification;
      private String material;
      private Integer quantity;
      private BigDecimal totalWeight;
      private BigDecimal unitPrice;
      private BigDecimal totalLength;
      private BigDecimal Weight;
      private BigDecimal Length;
      private BigDecimal totalPrice;
      private LocalDateTime actualTime;
      private Integer pricingManner;
      private Boolean boolAllPartSendDirectly;
      private Integer warehouseType;

      TechMachinePartShipDTOBuilder() {
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder workshopNames(final String workshopNames) {
         this.workshopNames = workshopNames;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder cargoSerialNumber(final String cargoSerialNumber) {
         this.cargoSerialNumber = cargoSerialNumber;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder actualUserName(final String actualUserName) {
         this.actualUserName = actualUserName;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder structureMeasureMode(final Integer structureMeasureMode) {
         this.structureMeasureMode = structureMeasureMode;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder shipTime(final String shipTime) {
         this.shipTime = shipTime;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder orderNumber(final Integer orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder Weight(final BigDecimal Weight) {
         this.Weight = Weight;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder Length(final BigDecimal Length) {
         this.Length = Length;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder actualTime(final LocalDateTime actualTime) {
         this.actualTime = actualTime;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechMachinePartShipDTO.TechMachinePartShipDTOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public TechMachinePartShipDTO build() {
         return new TechMachinePartShipDTO(
            this.project,
            this.projectName,
            this.monomer,
            this.area,
            this.name,
            this.serialNumber,
            this.workshopNames,
            this.licensePlate,
            this.cargoSerialNumber,
            this.actualUserName,
            this.userName,
            this.auditUserName,
            this.supplierName,
            this.structureMeasureMode,
            this.createTime,
            this.shipTime,
            this.orderNumber,
            this.artifactId,
            this.businessId,
            this.specification,
            this.material,
            this.quantity,
            this.totalWeight,
            this.unitPrice,
            this.totalLength,
            this.Weight,
            this.Length,
            this.totalPrice,
            this.actualTime,
            this.pricingManner,
            this.boolAllPartSendDirectly,
            this.warehouseType
         );
      }

      @Override
      public String toString() {
         return "TechMachinePartShipDTO.TechMachinePartShipDTOBuilder(project="
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
            + ", workshopNames="
            + this.workshopNames
            + ", licensePlate="
            + this.licensePlate
            + ", cargoSerialNumber="
            + this.cargoSerialNumber
            + ", actualUserName="
            + this.actualUserName
            + ", userName="
            + this.userName
            + ", auditUserName="
            + this.auditUserName
            + ", supplierName="
            + this.supplierName
            + ", structureMeasureMode="
            + this.structureMeasureMode
            + ", createTime="
            + this.createTime
            + ", shipTime="
            + this.shipTime
            + ", orderNumber="
            + this.orderNumber
            + ", artifactId="
            + this.artifactId
            + ", businessId="
            + this.businessId
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", totalWeight="
            + this.totalWeight
            + ", unitPrice="
            + this.unitPrice
            + ", totalLength="
            + this.totalLength
            + ", Weight="
            + this.Weight
            + ", Length="
            + this.Length
            + ", totalPrice="
            + this.totalPrice
            + ", actualTime="
            + this.actualTime
            + ", pricingManner="
            + this.pricingManner
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", warehouseType="
            + this.warehouseType
            + ")";
      }
   }
}
