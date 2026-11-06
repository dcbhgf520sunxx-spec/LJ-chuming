package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("出入库记录表")
public class MesBuildingWarehouseRecordDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "factory", value = "工厂")
   private NameInfo factory;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型 2结构4围护8配套件", notes = "产品类型 2结构4围护8配套件")
   private Integer productType;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "type", value = "出入库类型 1入库2出库", notes = "出入库类型 1入库2出库")
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "出入库数量", notes = "出入库数量")
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   private String userName;
   @ApiModelProperty(name = "completeId")
   private Long completeId;
   @ApiModelProperty(name = "createTime", value = "入库时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "总量")
   private BigDecimal mete;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "price", value = "单价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否是直发檩条 true 是 false 否")
   private Boolean boolPurLineSendDirectly;

   public static MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder builder() {
      return new MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder();
   }

   public MesBuildingWarehouseRecordDTO() {
   }

   public MesBuildingWarehouseRecordDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final NameInfo monomer,
      final Long areaId,
      final NameInfo area,
      final Long factoryId,
      final NameInfo factory,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer type,
      final Integer quantity,
      final Long userId,
      final String userName,
      final Long completeId,
      final LocalDateTime createTime,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Boolean boolAllPartSendDirectly,
      final Boolean boolPurLineSendDirectly
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.areaId = areaId;
      this.area = area;
      this.factoryId = factoryId;
      this.factory = factory;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.type = type;
      this.quantity = quantity;
      this.userId = userId;
      this.userName = userName;
      this.completeId = completeId;
      this.createTime = createTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.boolPurLineSendDirectly = boolPurLineSendDirectly;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public NameInfo getFactory() {
      return this.factory;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Integer getType() {
      return this.type;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getCompleteId() {
      return this.completeId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolPurLineSendDirectly() {
      return this.boolPurLineSendDirectly;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactory(final NameInfo factory) {
      this.factory = factory;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCompleteId(final Long completeId) {
      this.completeId = completeId;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolPurLineSendDirectly(final Boolean boolPurLineSendDirectly) {
      this.boolPurLineSendDirectly = boolPurLineSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseRecordDTO)) {
         return false;
      }

      MesBuildingWarehouseRecordDTO other = (MesBuildingWarehouseRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$userId = this.getUserId();
                                 Object other$userId = other.getUserId();
                                 if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                    Object this$completeId = this.getCompleteId();
                                    Object other$completeId = other.getCompleteId();
                                    if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                                       Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                       Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                       if (this$boolAllPartSendDirectly == null
                                          ? other$boolAllPartSendDirectly == null
                                          : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                          Object this$boolPurLineSendDirectly = this.getBoolPurLineSendDirectly();
                                          Object other$boolPurLineSendDirectly = other.getBoolPurLineSendDirectly();
                                          if (this$boolPurLineSendDirectly == null
                                             ? other$boolPurLineSendDirectly == null
                                             : this$boolPurLineSendDirectly.equals(other$boolPurLineSendDirectly)) {
                                             Object this$monomer = this.getMonomer();
                                             Object other$monomer = other.getMonomer();
                                             if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                Object this$area = this.getArea();
                                                Object other$area = other.getArea();
                                                if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                   Object this$factory = this.getFactory();
                                                   Object other$factory = other.getFactory();
                                                   if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                                      Object this$name = this.getName();
                                                      Object other$name = other.getName();
                                                      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$material = this.getMaterial();
                                                               Object other$material = other.getMaterial();
                                                               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                  Object this$userName = this.getUserName();
                                                                  Object other$userName = other.getUserName();
                                                                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                                     Object this$createTime = this.getCreateTime();
                                                                     Object other$createTime = other.getCreateTime();
                                                                     if (this$createTime == null
                                                                        ? other$createTime == null
                                                                        : this$createTime.equals(other$createTime)) {
                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                        if (this$measureUnit == null
                                                                           ? other$measureUnit == null
                                                                           : this$measureUnit.equals(other$measureUnit)) {
                                                                           Object this$accountingUnit = this.getAccountingUnit();
                                                                           Object other$accountingUnit = other.getAccountingUnit();
                                                                           if (this$accountingUnit == null
                                                                              ? other$accountingUnit == null
                                                                              : this$accountingUnit.equals(other$accountingUnit)) {
                                                                              Object this$mete = this.getMete();
                                                                              Object other$mete = other.getMete();
                                                                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                 Object this$unitPrice = this.getUnitPrice();
                                                                                 Object other$unitPrice = other.getUnitPrice();
                                                                                 if (this$unitPrice == null
                                                                                    ? other$unitPrice == null
                                                                                    : this$unitPrice.equals(other$unitPrice)) {
                                                                                    Object this$totalPrice = this.getTotalPrice();
                                                                                    Object other$totalPrice = other.getTotalPrice();
                                                                                    return this$totalPrice == null
                                                                                       ? other$totalPrice == null
                                                                                       : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof MesBuildingWarehouseRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolPurLineSendDirectly = this.getBoolPurLineSendDirectly();
      result = result * 59 + ($boolPurLineSendDirectly == null ? 43 : $boolPurLineSendDirectly.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseRecordDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", factoryId="
         + this.getFactoryId()
         + ", factory="
         + this.getFactory()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", completeId="
         + this.getCompleteId()
         + ", createTime="
         + this.getCreateTime()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolPurLineSendDirectly="
         + this.getBoolPurLineSendDirectly()
         + ")";
   }

   public static class MesBuildingWarehouseRecordDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private NameInfo monomer;
      private Long areaId;
      private NameInfo area;
      private Long factoryId;
      private NameInfo factory;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer type;
      private Integer quantity;
      private Long userId;
      private String userName;
      private Long completeId;
      private LocalDateTime createTime;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Boolean boolAllPartSendDirectly;
      private Boolean boolPurLineSendDirectly;

      MesBuildingWarehouseRecordDTOBuilder() {
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder factory(final NameInfo factory) {
         this.factory = factory;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder boolPurLineSendDirectly(final Boolean boolPurLineSendDirectly) {
         this.boolPurLineSendDirectly = boolPurLineSendDirectly;
         return this;
      }

      public MesBuildingWarehouseRecordDTO build() {
         return new MesBuildingWarehouseRecordDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.monomer,
            this.areaId,
            this.area,
            this.factoryId,
            this.factory,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.type,
            this.quantity,
            this.userId,
            this.userName,
            this.completeId,
            this.createTime,
            this.measureUnit,
            this.accountingUnit,
            this.mete,
            this.unitPrice,
            this.totalPrice,
            this.boolAllPartSendDirectly,
            this.boolPurLineSendDirectly
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseRecordDTO.MesBuildingWarehouseRecordDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", factoryId="
            + this.factoryId
            + ", factory="
            + this.factory
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", completeId="
            + this.completeId
            + ", createTime="
            + this.createTime
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", boolPurLineSendDirectly="
            + this.boolPurLineSendDirectly
            + ")";
      }
   }
}
