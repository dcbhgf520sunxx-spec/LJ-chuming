package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.util.List;

public class InstantMessageHintDTO {
   private Long id;
   private Integer type;
   private String typeName;
   private String expireTime;
   private String classifyCode;
   private String classifyName;
   private String spec;
   private BigDecimal inventoryRequirements;
   private BigDecimal inventory;
   private String unit;
   private String dateTimeStr;
   private String createUser;
   private String serialNumber;
   private String supplier;
   private String basicClass;
   private BigDecimal freezeMete;
   private BigDecimal thickness;
   private String material;
   private BigDecimal returnMete;
   private String team;
   private BigDecimal applyMete;
   private String oldSerialNumber;
   private Long factoryId;
   private List<Long> workshopId;

   public static InstantMessageHintDTO.InstantMessageHintDTOBuilder builder() {
      return new InstantMessageHintDTO.InstantMessageHintDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getExpireTime() {
      return this.expireTime;
   }

   public String getClassifyCode() {
      return this.classifyCode;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpec() {
      return this.spec;
   }

   public BigDecimal getInventoryRequirements() {
      return this.inventoryRequirements;
   }

   public BigDecimal getInventory() {
      return this.inventory;
   }

   public String getUnit() {
      return this.unit;
   }

   public String getDateTimeStr() {
      return this.dateTimeStr;
   }

   public String getCreateUser() {
      return this.createUser;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplier() {
      return this.supplier;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public BigDecimal getFreezeMete() {
      return this.freezeMete;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getReturnMete() {
      return this.returnMete;
   }

   public String getTeam() {
      return this.team;
   }

   public BigDecimal getApplyMete() {
      return this.applyMete;
   }

   public String getOldSerialNumber() {
      return this.oldSerialNumber;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public List<Long> getWorkshopId() {
      return this.workshopId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setExpireTime(final String expireTime) {
      this.expireTime = expireTime;
   }

   public void setClassifyCode(final String classifyCode) {
      this.classifyCode = classifyCode;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setInventoryRequirements(final BigDecimal inventoryRequirements) {
      this.inventoryRequirements = inventoryRequirements;
   }

   public void setInventory(final BigDecimal inventory) {
      this.inventory = inventory;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setDateTimeStr(final String dateTimeStr) {
      this.dateTimeStr = dateTimeStr;
   }

   public void setCreateUser(final String createUser) {
      this.createUser = createUser;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplier(final String supplier) {
      this.supplier = supplier;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setFreezeMete(final BigDecimal freezeMete) {
      this.freezeMete = freezeMete;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setReturnMete(final BigDecimal returnMete) {
      this.returnMete = returnMete;
   }

   public void setTeam(final String team) {
      this.team = team;
   }

   public void setApplyMete(final BigDecimal applyMete) {
      this.applyMete = applyMete;
   }

   public void setOldSerialNumber(final String oldSerialNumber) {
      this.oldSerialNumber = oldSerialNumber;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWorkshopId(final List<Long> workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InstantMessageHintDTO)) {
         return false;
      }

      InstantMessageHintDTO other = (InstantMessageHintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$typeName = this.getTypeName();
               Object other$typeName = other.getTypeName();
               if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
                  Object this$expireTime = this.getExpireTime();
                  Object other$expireTime = other.getExpireTime();
                  if (this$expireTime == null ? other$expireTime == null : this$expireTime.equals(other$expireTime)) {
                     Object this$classifyCode = this.getClassifyCode();
                     Object other$classifyCode = other.getClassifyCode();
                     if (this$classifyCode == null ? other$classifyCode == null : this$classifyCode.equals(other$classifyCode)) {
                        Object this$classifyName = this.getClassifyName();
                        Object other$classifyName = other.getClassifyName();
                        if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                           Object this$spec = this.getSpec();
                           Object other$spec = other.getSpec();
                           if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                              Object this$inventoryRequirements = this.getInventoryRequirements();
                              Object other$inventoryRequirements = other.getInventoryRequirements();
                              if (this$inventoryRequirements == null
                                 ? other$inventoryRequirements == null
                                 : this$inventoryRequirements.equals(other$inventoryRequirements)) {
                                 Object this$inventory = this.getInventory();
                                 Object other$inventory = other.getInventory();
                                 if (this$inventory == null ? other$inventory == null : this$inventory.equals(other$inventory)) {
                                    Object this$unit = this.getUnit();
                                    Object other$unit = other.getUnit();
                                    if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                       Object this$dateTimeStr = this.getDateTimeStr();
                                       Object other$dateTimeStr = other.getDateTimeStr();
                                       if (this$dateTimeStr == null ? other$dateTimeStr == null : this$dateTimeStr.equals(other$dateTimeStr)) {
                                          Object this$createUser = this.getCreateUser();
                                          Object other$createUser = other.getCreateUser();
                                          if (this$createUser == null ? other$createUser == null : this$createUser.equals(other$createUser)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$supplier = this.getSupplier();
                                                Object other$supplier = other.getSupplier();
                                                if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                                                   Object this$basicClass = this.getBasicClass();
                                                   Object other$basicClass = other.getBasicClass();
                                                   if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                                                      Object this$freezeMete = this.getFreezeMete();
                                                      Object other$freezeMete = other.getFreezeMete();
                                                      if (this$freezeMete == null ? other$freezeMete == null : this$freezeMete.equals(other$freezeMete)) {
                                                         Object this$thickness = this.getThickness();
                                                         Object other$thickness = other.getThickness();
                                                         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                            Object this$material = this.getMaterial();
                                                            Object other$material = other.getMaterial();
                                                            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                               Object this$returnMete = this.getReturnMete();
                                                               Object other$returnMete = other.getReturnMete();
                                                               if (this$returnMete == null
                                                                  ? other$returnMete == null
                                                                  : this$returnMete.equals(other$returnMete)) {
                                                                  Object this$team = this.getTeam();
                                                                  Object other$team = other.getTeam();
                                                                  if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                                                     Object this$applyMete = this.getApplyMete();
                                                                     Object other$applyMete = other.getApplyMete();
                                                                     if (this$applyMete == null
                                                                        ? other$applyMete == null
                                                                        : this$applyMete.equals(other$applyMete)) {
                                                                        Object this$oldSerialNumber = this.getOldSerialNumber();
                                                                        Object other$oldSerialNumber = other.getOldSerialNumber();
                                                                        if (this$oldSerialNumber == null
                                                                           ? other$oldSerialNumber == null
                                                                           : this$oldSerialNumber.equals(other$oldSerialNumber)) {
                                                                           Object this$workshopId = this.getWorkshopId();
                                                                           Object other$workshopId = other.getWorkshopId();
                                                                           return this$workshopId == null
                                                                              ? other$workshopId == null
                                                                              : this$workshopId.equals(other$workshopId);
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
      return other instanceof InstantMessageHintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $expireTime = this.getExpireTime();
      result = result * 59 + ($expireTime == null ? 43 : $expireTime.hashCode());
      Object $classifyCode = this.getClassifyCode();
      result = result * 59 + ($classifyCode == null ? 43 : $classifyCode.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $inventoryRequirements = this.getInventoryRequirements();
      result = result * 59 + ($inventoryRequirements == null ? 43 : $inventoryRequirements.hashCode());
      Object $inventory = this.getInventory();
      result = result * 59 + ($inventory == null ? 43 : $inventory.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $dateTimeStr = this.getDateTimeStr();
      result = result * 59 + ($dateTimeStr == null ? 43 : $dateTimeStr.hashCode());
      Object $createUser = this.getCreateUser();
      result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $freezeMete = this.getFreezeMete();
      result = result * 59 + ($freezeMete == null ? 43 : $freezeMete.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $returnMete = this.getReturnMete();
      result = result * 59 + ($returnMete == null ? 43 : $returnMete.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $applyMete = this.getApplyMete();
      result = result * 59 + ($applyMete == null ? 43 : $applyMete.hashCode());
      Object $oldSerialNumber = this.getOldSerialNumber();
      result = result * 59 + ($oldSerialNumber == null ? 43 : $oldSerialNumber.hashCode());
      Object $workshopId = this.getWorkshopId();
      return result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
   }

   @Override
   public String toString() {
      return "InstantMessageHintDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", typeName="
         + this.getTypeName()
         + ", expireTime="
         + this.getExpireTime()
         + ", classifyCode="
         + this.getClassifyCode()
         + ", classifyName="
         + this.getClassifyName()
         + ", spec="
         + this.getSpec()
         + ", inventoryRequirements="
         + this.getInventoryRequirements()
         + ", inventory="
         + this.getInventory()
         + ", unit="
         + this.getUnit()
         + ", dateTimeStr="
         + this.getDateTimeStr()
         + ", createUser="
         + this.getCreateUser()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplier="
         + this.getSupplier()
         + ", basicClass="
         + this.getBasicClass()
         + ", freezeMete="
         + this.getFreezeMete()
         + ", thickness="
         + this.getThickness()
         + ", material="
         + this.getMaterial()
         + ", returnMete="
         + this.getReturnMete()
         + ", team="
         + this.getTeam()
         + ", applyMete="
         + this.getApplyMete()
         + ", oldSerialNumber="
         + this.getOldSerialNumber()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }

   public InstantMessageHintDTO(
      final Long id,
      final Integer type,
      final String typeName,
      final String expireTime,
      final String classifyCode,
      final String classifyName,
      final String spec,
      final BigDecimal inventoryRequirements,
      final BigDecimal inventory,
      final String unit,
      final String dateTimeStr,
      final String createUser,
      final String serialNumber,
      final String supplier,
      final String basicClass,
      final BigDecimal freezeMete,
      final BigDecimal thickness,
      final String material,
      final BigDecimal returnMete,
      final String team,
      final BigDecimal applyMete,
      final String oldSerialNumber,
      final Long factoryId,
      final List<Long> workshopId
   ) {
      this.id = id;
      this.type = type;
      this.typeName = typeName;
      this.expireTime = expireTime;
      this.classifyCode = classifyCode;
      this.classifyName = classifyName;
      this.spec = spec;
      this.inventoryRequirements = inventoryRequirements;
      this.inventory = inventory;
      this.unit = unit;
      this.dateTimeStr = dateTimeStr;
      this.createUser = createUser;
      this.serialNumber = serialNumber;
      this.supplier = supplier;
      this.basicClass = basicClass;
      this.freezeMete = freezeMete;
      this.thickness = thickness;
      this.material = material;
      this.returnMete = returnMete;
      this.team = team;
      this.applyMete = applyMete;
      this.oldSerialNumber = oldSerialNumber;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
   }

   public InstantMessageHintDTO() {
   }

   public static class InstantMessageHintDTOBuilder {
      private Long id;
      private Integer type;
      private String typeName;
      private String expireTime;
      private String classifyCode;
      private String classifyName;
      private String spec;
      private BigDecimal inventoryRequirements;
      private BigDecimal inventory;
      private String unit;
      private String dateTimeStr;
      private String createUser;
      private String serialNumber;
      private String supplier;
      private String basicClass;
      private BigDecimal freezeMete;
      private BigDecimal thickness;
      private String material;
      private BigDecimal returnMete;
      private String team;
      private BigDecimal applyMete;
      private String oldSerialNumber;
      private Long factoryId;
      private List<Long> workshopId;

      InstantMessageHintDTOBuilder() {
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder expireTime(final String expireTime) {
         this.expireTime = expireTime;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder classifyCode(final String classifyCode) {
         this.classifyCode = classifyCode;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder inventoryRequirements(final BigDecimal inventoryRequirements) {
         this.inventoryRequirements = inventoryRequirements;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder inventory(final BigDecimal inventory) {
         this.inventory = inventory;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder dateTimeStr(final String dateTimeStr) {
         this.dateTimeStr = dateTimeStr;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder createUser(final String createUser) {
         this.createUser = createUser;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder supplier(final String supplier) {
         this.supplier = supplier;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder basicClass(final String basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder freezeMete(final BigDecimal freezeMete) {
         this.freezeMete = freezeMete;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder returnMete(final BigDecimal returnMete) {
         this.returnMete = returnMete;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder team(final String team) {
         this.team = team;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder applyMete(final BigDecimal applyMete) {
         this.applyMete = applyMete;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder oldSerialNumber(final String oldSerialNumber) {
         this.oldSerialNumber = oldSerialNumber;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public InstantMessageHintDTO.InstantMessageHintDTOBuilder workshopId(final List<Long> workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InstantMessageHintDTO build() {
         return new InstantMessageHintDTO(
            this.id,
            this.type,
            this.typeName,
            this.expireTime,
            this.classifyCode,
            this.classifyName,
            this.spec,
            this.inventoryRequirements,
            this.inventory,
            this.unit,
            this.dateTimeStr,
            this.createUser,
            this.serialNumber,
            this.supplier,
            this.basicClass,
            this.freezeMete,
            this.thickness,
            this.material,
            this.returnMete,
            this.team,
            this.applyMete,
            this.oldSerialNumber,
            this.factoryId,
            this.workshopId
         );
      }

      @Override
      public String toString() {
         return "InstantMessageHintDTO.InstantMessageHintDTOBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", typeName="
            + this.typeName
            + ", expireTime="
            + this.expireTime
            + ", classifyCode="
            + this.classifyCode
            + ", classifyName="
            + this.classifyName
            + ", spec="
            + this.spec
            + ", inventoryRequirements="
            + this.inventoryRequirements
            + ", inventory="
            + this.inventory
            + ", unit="
            + this.unit
            + ", dateTimeStr="
            + this.dateTimeStr
            + ", createUser="
            + this.createUser
            + ", serialNumber="
            + this.serialNumber
            + ", supplier="
            + this.supplier
            + ", basicClass="
            + this.basicClass
            + ", freezeMete="
            + this.freezeMete
            + ", thickness="
            + this.thickness
            + ", material="
            + this.material
            + ", returnMete="
            + this.returnMete
            + ", team="
            + this.team
            + ", applyMete="
            + this.applyMete
            + ", oldSerialNumber="
            + this.oldSerialNumber
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ")";
      }
   }
}
