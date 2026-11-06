package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo.vo.MachineSpecificationVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("构件规格未修正DTO类")
public class TechArtifactSpecUncorrectedDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "oldName", value = "原名称")
   private String oldName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号编号")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "oldSpecification", value = "原来规格", notes = "原来规格")
   private String oldSpecification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty("原构件种类表Id")
   private Long oldStructureClassId;
   @ApiModelProperty(name = "oldStructureClassName", value = "原构件种类表名称", notes = "原构件种类表名称")
   private String oldStructureClassName;
   @ApiModelProperty(name = "oldSpecPrefix", value = "原规格前缀", notes = "原规格前缀")
   private String oldSpecPrefix;
   @ApiModelProperty(name = "boolAmendStatus", value = "修正状态 1已修正 0未修正", notes = "修正状态 1已修正 0未修正")
   private Boolean boolAmendStatus;
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id", notes = "构件审核表Id")
   private Long artifactRecordId;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   private Long artifactId;
   @ApiModelProperty(name = "plJudge", value = "判断是否需要重组", notes = "判断是否需要重组")
   private Boolean plJudge;
   @ApiModelProperty(name = "partAmendStatus", value = "修正状态 true已修正 null未修正", notes = "修正状态 true已修正 null未修正")
   private Boolean partAmendStatus;
   @ApiModelProperty("修正后构件种类表Id")
   private Long newStructureClassId;
   @ApiModelProperty(name = "newSpecification", value = "修正规格", notes = "修正规格")
   private String newSpecification;
   @ApiModelProperty(name = "newSpecPrefix", value = "修正规格前缀", notes = "修正规格前缀")
   private String newSpecPrefix;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件新规格")
   private List<MachineSpecificationVO> machineSpecifications;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getOldName() {
      return this.oldName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getOldSpecification() {
      return this.oldSpecification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getOldStructureClassId() {
      return this.oldStructureClassId;
   }

   public String getOldStructureClassName() {
      return this.oldStructureClassName;
   }

   public String getOldSpecPrefix() {
      return this.oldSpecPrefix;
   }

   public Boolean getBoolAmendStatus() {
      return this.boolAmendStatus;
   }

   public Long getArtifactRecordId() {
      return this.artifactRecordId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Boolean getPlJudge() {
      return this.plJudge;
   }

   public Boolean getPartAmendStatus() {
      return this.partAmendStatus;
   }

   public Long getNewStructureClassId() {
      return this.newStructureClassId;
   }

   public String getNewSpecification() {
      return this.newSpecification;
   }

   public String getNewSpecPrefix() {
      return this.newSpecPrefix;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<MachineSpecificationVO> getMachineSpecifications() {
      return this.machineSpecifications;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setOldName(final String oldName) {
      this.oldName = oldName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setOldSpecification(final String oldSpecification) {
      this.oldSpecification = oldSpecification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setOldStructureClassId(final Long oldStructureClassId) {
      this.oldStructureClassId = oldStructureClassId;
   }

   public void setOldStructureClassName(final String oldStructureClassName) {
      this.oldStructureClassName = oldStructureClassName;
   }

   public void setOldSpecPrefix(final String oldSpecPrefix) {
      this.oldSpecPrefix = oldSpecPrefix;
   }

   public void setBoolAmendStatus(final Boolean boolAmendStatus) {
      this.boolAmendStatus = boolAmendStatus;
   }

   public void setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setPlJudge(final Boolean plJudge) {
      this.plJudge = plJudge;
   }

   public void setPartAmendStatus(final Boolean partAmendStatus) {
      this.partAmendStatus = partAmendStatus;
   }

   public void setNewStructureClassId(final Long newStructureClassId) {
      this.newStructureClassId = newStructureClassId;
   }

   public void setNewSpecification(final String newSpecification) {
      this.newSpecification = newSpecification;
   }

   public void setNewSpecPrefix(final String newSpecPrefix) {
      this.newSpecPrefix = newSpecPrefix;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setMachineSpecifications(final List<MachineSpecificationVO> machineSpecifications) {
      this.machineSpecifications = machineSpecifications;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactSpecUncorrectedDTO)) {
         return false;
      }

      TechArtifactSpecUncorrectedDTO other = (TechArtifactSpecUncorrectedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$oldStructureClassId = this.getOldStructureClassId();
                     Object other$oldStructureClassId = other.getOldStructureClassId();
                     if (this$oldStructureClassId == null ? other$oldStructureClassId == null : this$oldStructureClassId.equals(other$oldStructureClassId)) {
                        Object this$boolAmendStatus = this.getBoolAmendStatus();
                        Object other$boolAmendStatus = other.getBoolAmendStatus();
                        if (this$boolAmendStatus == null ? other$boolAmendStatus == null : this$boolAmendStatus.equals(other$boolAmendStatus)) {
                           Object this$artifactRecordId = this.getArtifactRecordId();
                           Object other$artifactRecordId = other.getArtifactRecordId();
                           if (this$artifactRecordId == null ? other$artifactRecordId == null : this$artifactRecordId.equals(other$artifactRecordId)) {
                              Object this$artifactId = this.getArtifactId();
                              Object other$artifactId = other.getArtifactId();
                              if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                                 Object this$plJudge = this.getPlJudge();
                                 Object other$plJudge = other.getPlJudge();
                                 if (this$plJudge == null ? other$plJudge == null : this$plJudge.equals(other$plJudge)) {
                                    Object this$partAmendStatus = this.getPartAmendStatus();
                                    Object other$partAmendStatus = other.getPartAmendStatus();
                                    if (this$partAmendStatus == null ? other$partAmendStatus == null : this$partAmendStatus.equals(other$partAmendStatus)) {
                                       Object this$newStructureClassId = this.getNewStructureClassId();
                                       Object other$newStructureClassId = other.getNewStructureClassId();
                                       if (this$newStructureClassId == null
                                          ? other$newStructureClassId == null
                                          : this$newStructureClassId.equals(other$newStructureClassId)) {
                                          Object this$oldName = this.getOldName();
                                          Object other$oldName = other.getOldName();
                                          if (this$oldName == null ? other$oldName == null : this$oldName.equals(other$oldName)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                                Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                                if (this$artifactSerialNumber == null
                                                   ? other$artifactSerialNumber == null
                                                   : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                                   Object this$oldSpecification = this.getOldSpecification();
                                                   Object other$oldSpecification = other.getOldSpecification();
                                                   if (this$oldSpecification == null
                                                      ? other$oldSpecification == null
                                                      : this$oldSpecification.equals(other$oldSpecification)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$oldStructureClassName = this.getOldStructureClassName();
                                                            Object other$oldStructureClassName = other.getOldStructureClassName();
                                                            if (this$oldStructureClassName == null
                                                               ? other$oldStructureClassName == null
                                                               : this$oldStructureClassName.equals(other$oldStructureClassName)) {
                                                               Object this$oldSpecPrefix = this.getOldSpecPrefix();
                                                               Object other$oldSpecPrefix = other.getOldSpecPrefix();
                                                               if (this$oldSpecPrefix == null
                                                                  ? other$oldSpecPrefix == null
                                                                  : this$oldSpecPrefix.equals(other$oldSpecPrefix)) {
                                                                  Object this$newSpecification = this.getNewSpecification();
                                                                  Object other$newSpecification = other.getNewSpecification();
                                                                  if (this$newSpecification == null
                                                                     ? other$newSpecification == null
                                                                     : this$newSpecification.equals(other$newSpecification)) {
                                                                     Object this$newSpecPrefix = this.getNewSpecPrefix();
                                                                     Object other$newSpecPrefix = other.getNewSpecPrefix();
                                                                     if (this$newSpecPrefix == null
                                                                        ? other$newSpecPrefix == null
                                                                        : this$newSpecPrefix.equals(other$newSpecPrefix)) {
                                                                        Object this$numbers = this.getNumbers();
                                                                        Object other$numbers = other.getNumbers();
                                                                        if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
                                                                           Object this$machineSpecifications = this.getMachineSpecifications();
                                                                           Object other$machineSpecifications = other.getMachineSpecifications();
                                                                           if (this$machineSpecifications == null
                                                                              ? other$machineSpecifications == null
                                                                              : this$machineSpecifications.equals(other$machineSpecifications)) {
                                                                              Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                              Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                              return this$drawingAndSerialNumber == null
                                                                                 ? other$drawingAndSerialNumber == null
                                                                                 : this$drawingAndSerialNumber.equals(other$drawingAndSerialNumber);
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
      return other instanceof TechArtifactSpecUncorrectedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $oldStructureClassId = this.getOldStructureClassId();
      result = result * 59 + ($oldStructureClassId == null ? 43 : $oldStructureClassId.hashCode());
      Object $boolAmendStatus = this.getBoolAmendStatus();
      result = result * 59 + ($boolAmendStatus == null ? 43 : $boolAmendStatus.hashCode());
      Object $artifactRecordId = this.getArtifactRecordId();
      result = result * 59 + ($artifactRecordId == null ? 43 : $artifactRecordId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $plJudge = this.getPlJudge();
      result = result * 59 + ($plJudge == null ? 43 : $plJudge.hashCode());
      Object $partAmendStatus = this.getPartAmendStatus();
      result = result * 59 + ($partAmendStatus == null ? 43 : $partAmendStatus.hashCode());
      Object $newStructureClassId = this.getNewStructureClassId();
      result = result * 59 + ($newStructureClassId == null ? 43 : $newStructureClassId.hashCode());
      Object $oldName = this.getOldName();
      result = result * 59 + ($oldName == null ? 43 : $oldName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $oldSpecification = this.getOldSpecification();
      result = result * 59 + ($oldSpecification == null ? 43 : $oldSpecification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $oldStructureClassName = this.getOldStructureClassName();
      result = result * 59 + ($oldStructureClassName == null ? 43 : $oldStructureClassName.hashCode());
      Object $oldSpecPrefix = this.getOldSpecPrefix();
      result = result * 59 + ($oldSpecPrefix == null ? 43 : $oldSpecPrefix.hashCode());
      Object $newSpecification = this.getNewSpecification();
      result = result * 59 + ($newSpecification == null ? 43 : $newSpecification.hashCode());
      Object $newSpecPrefix = this.getNewSpecPrefix();
      result = result * 59 + ($newSpecPrefix == null ? 43 : $newSpecPrefix.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $machineSpecifications = this.getMachineSpecifications();
      result = result * 59 + ($machineSpecifications == null ? 43 : $machineSpecifications.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactSpecUncorrectedDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", oldName="
         + this.getOldName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", oldSpecification="
         + this.getOldSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", oldStructureClassId="
         + this.getOldStructureClassId()
         + ", oldStructureClassName="
         + this.getOldStructureClassName()
         + ", oldSpecPrefix="
         + this.getOldSpecPrefix()
         + ", boolAmendStatus="
         + this.getBoolAmendStatus()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ", artifactId="
         + this.getArtifactId()
         + ", plJudge="
         + this.getPlJudge()
         + ", partAmendStatus="
         + this.getPartAmendStatus()
         + ", newStructureClassId="
         + this.getNewStructureClassId()
         + ", newSpecification="
         + this.getNewSpecification()
         + ", newSpecPrefix="
         + this.getNewSpecPrefix()
         + ", numbers="
         + this.getNumbers()
         + ", machineSpecifications="
         + this.getMachineSpecifications()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }
}
