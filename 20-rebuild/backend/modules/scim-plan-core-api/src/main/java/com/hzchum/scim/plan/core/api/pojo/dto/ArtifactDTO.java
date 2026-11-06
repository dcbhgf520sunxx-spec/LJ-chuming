package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("构件信息类")
public class ArtifactDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "areaBatch", value = "批次")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "businessId", value = "商务id")
   private Long businessId;
   @ApiModelProperty(name = "上传人", value = "上传人")
   private NameInfo user;
   @ApiModelProperty(name = "构件类型", value = "构件类型")
   private NameInfo structureClassify;
   @ApiModelProperty(name = "machinePartDTOList", value = "零件列表")
   private List<TechMachinePartDTO> machinePartDTOList;
   @ApiModelProperty("组立号列表")
   List<String> assembleSerialNumbers;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   private String printedCode;
   @ApiModelProperty(name = "userName", value = "上传人")
   private String userName;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
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

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public NameInfo getStructureClassify() {
      return this.structureClassify;
   }

   public List<TechMachinePartDTO> getMachinePartDTOList() {
      return this.machinePartDTOList;
   }

   public List<String> getAssembleSerialNumbers() {
      return this.assembleSerialNumbers;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
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

   public void setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
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

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   public void setStructureClassify(final NameInfo structureClassify) {
      this.structureClassify = structureClassify;
   }

   public void setMachinePartDTOList(final List<TechMachinePartDTO> machinePartDTOList) {
      this.machinePartDTOList = machinePartDTOList;
   }

   public void setAssembleSerialNumbers(final List<String> assembleSerialNumbers) {
      this.assembleSerialNumbers = assembleSerialNumbers;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactDTO)) {
         return false;
      }

      ArtifactDTO other = (ArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolStatusEnum = this.getBoolStatusEnum();
         Object other$boolStatusEnum = other.getBoolStatusEnum();
         if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$businessId = this.getBusinessId();
               Object other$businessId = other.getBusinessId();
               if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$areaBatch = this.getAreaBatch();
                              Object other$areaBatch = other.getAreaBatch();
                              if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                if (this$totalNetWeight == null
                                                   ? other$totalNetWeight == null
                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                      Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                      Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                      if (this$totalGrossWeight == null
                                                         ? other$totalGrossWeight == null
                                                         : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                         Object this$surfaceArea = this.getSurfaceArea();
                                                         Object other$surfaceArea = other.getSurfaceArea();
                                                         if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                            Object this$drawingNumber = this.getDrawingNumber();
                                                            Object other$drawingNumber = other.getDrawingNumber();
                                                            if (this$drawingNumber == null
                                                               ? other$drawingNumber == null
                                                               : this$drawingNumber.equals(other$drawingNumber)) {
                                                               Object this$remark = this.getRemark();
                                                               Object other$remark = other.getRemark();
                                                               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                  Object this$user = this.getUser();
                                                                  Object other$user = other.getUser();
                                                                  if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                                                                     Object this$structureClassify = this.getStructureClassify();
                                                                     Object other$structureClassify = other.getStructureClassify();
                                                                     if (this$structureClassify == null
                                                                        ? other$structureClassify == null
                                                                        : this$structureClassify.equals(other$structureClassify)) {
                                                                        Object this$machinePartDTOList = this.getMachinePartDTOList();
                                                                        Object other$machinePartDTOList = other.getMachinePartDTOList();
                                                                        if (this$machinePartDTOList == null
                                                                           ? other$machinePartDTOList == null
                                                                           : this$machinePartDTOList.equals(other$machinePartDTOList)) {
                                                                           Object this$assembleSerialNumbers = this.getAssembleSerialNumbers();
                                                                           Object other$assembleSerialNumbers = other.getAssembleSerialNumbers();
                                                                           if (this$assembleSerialNumbers == null
                                                                              ? other$assembleSerialNumbers == null
                                                                              : this$assembleSerialNumbers.equals(other$assembleSerialNumbers)) {
                                                                              Object this$printedCode = this.getPrintedCode();
                                                                              Object other$printedCode = other.getPrintedCode();
                                                                              if (this$printedCode == null
                                                                                 ? other$printedCode == null
                                                                                 : this$printedCode.equals(other$printedCode)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $structureClassify = this.getStructureClassify();
      result = result * 59 + ($structureClassify == null ? 43 : $structureClassify.hashCode());
      Object $machinePartDTOList = this.getMachinePartDTOList();
      result = result * 59 + ($machinePartDTOList == null ? 43 : $machinePartDTOList.hashCode());
      Object $assembleSerialNumbers = this.getAssembleSerialNumbers();
      result = result * 59 + ($assembleSerialNumbers == null ? 43 : $assembleSerialNumbers.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", businessId="
         + this.getBusinessId()
         + ", user="
         + this.getUser()
         + ", structureClassify="
         + this.getStructureClassify()
         + ", machinePartDTOList="
         + this.getMachinePartDTOList()
         + ", assembleSerialNumbers="
         + this.getAssembleSerialNumbers()
         + ", printedCode="
         + this.getPrintedCode()
         + ", userName="
         + this.getUserName()
         + ")";
   }
}
