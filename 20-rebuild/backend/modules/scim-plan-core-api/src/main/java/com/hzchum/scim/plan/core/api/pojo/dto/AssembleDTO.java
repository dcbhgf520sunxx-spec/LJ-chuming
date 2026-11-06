package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("组立清单类")
public class AssembleDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "configName", value = "部件配置名称")
   private String configName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "areaBatch", value = "批次")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "producedQuantity", value = "已生产")
   private Integer producedQuantity;
   @ApiModelProperty(name = "usedQuantity", value = "已使用")
   private Integer usedQuantity;
   @ApiModelProperty(name = "assembleDetailDTOList", value = "腹板翼板列表")
   private List<AssembleMachinePartDTO> detailDTOList;
   @ApiModelProperty(name = "artifactDTOList", value = "构件列表")
   private List<AssembleArtifactDTO> artifactDTOList;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userId", value = "导入人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "导入人")
   private String userName;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getConfigName() {
      return this.configName;
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

   public String getStructureType() {
      return this.structureType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public List<AssembleMachinePartDTO> getDetailDTOList() {
      return this.detailDTOList;
   }

   public List<AssembleArtifactDTO> getArtifactDTOList() {
      return this.artifactDTOList;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setConfigName(final String configName) {
      this.configName = configName;
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

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setDetailDTOList(final List<AssembleMachinePartDTO> detailDTOList) {
      this.detailDTOList = detailDTOList;
   }

   public void setArtifactDTOList(final List<AssembleArtifactDTO> artifactDTOList) {
      this.artifactDTOList = artifactDTOList;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleDTO)) {
         return false;
      }

      AssembleDTO other = (AssembleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$usedQuantity = this.getUsedQuantity();
               Object other$usedQuantity = other.getUsedQuantity();
               if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                        Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                        if (this$boolSchedulingEnum == null ? other$boolSchedulingEnum == null : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                           Object this$boolProcess = this.getBoolProcess();
                           Object other$boolProcess = other.getBoolProcess();
                           if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                              Object this$boolSendDirectly = this.getBoolSendDirectly();
                              Object other$boolSendDirectly = other.getBoolSendDirectly();
                              if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$configName = this.getConfigName();
                                    Object other$configName = other.getConfigName();
                                    if (this$configName == null ? other$configName == null : this$configName.equals(other$configName)) {
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
                                                   Object this$structureType = this.getStructureType();
                                                   Object other$structureType = other.getStructureType();
                                                   if (this$structureType == null
                                                      ? other$structureType == null
                                                      : this$structureType.equals(other$structureType)) {
                                                      Object this$serialNumber = this.getSerialNumber();
                                                      Object other$serialNumber = other.getSerialNumber();
                                                      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)
                                                         )
                                                       {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$specification = this.getSpecification();
                                                               Object other$specification = other.getSpecification();
                                                               if (this$specification == null
                                                                  ? other$specification == null
                                                                  : this$specification.equals(other$specification)) {
                                                                  Object this$material = this.getMaterial();
                                                                  Object other$material = other.getMaterial();
                                                                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                     Object this$netWeight = this.getNetWeight();
                                                                     Object other$netWeight = other.getNetWeight();
                                                                     if (this$netWeight == null
                                                                        ? other$netWeight == null
                                                                        : this$netWeight.equals(other$netWeight)) {
                                                                        Object this$totalNetWeight = this.getTotalNetWeight();
                                                                        Object other$totalNetWeight = other.getTotalNetWeight();
                                                                        if (this$totalNetWeight == null
                                                                           ? other$totalNetWeight == null
                                                                           : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                           Object this$drawingNumber = this.getDrawingNumber();
                                                                           Object other$drawingNumber = other.getDrawingNumber();
                                                                           if (this$drawingNumber == null
                                                                              ? other$drawingNumber == null
                                                                              : this$drawingNumber.equals(other$drawingNumber)) {
                                                                              Object this$detailDTOList = this.getDetailDTOList();
                                                                              Object other$detailDTOList = other.getDetailDTOList();
                                                                              if (this$detailDTOList == null
                                                                                 ? other$detailDTOList == null
                                                                                 : this$detailDTOList.equals(other$detailDTOList)) {
                                                                                 Object this$artifactDTOList = this.getArtifactDTOList();
                                                                                 Object other$artifactDTOList = other.getArtifactDTOList();
                                                                                 if (this$artifactDTOList == null
                                                                                    ? other$artifactDTOList == null
                                                                                    : this$artifactDTOList.equals(other$artifactDTOList)) {
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
      return other instanceof AssembleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $configName = this.getConfigName();
      result = result * 59 + ($configName == null ? 43 : $configName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $detailDTOList = this.getDetailDTOList();
      result = result * 59 + ($detailDTOList == null ? 43 : $detailDTOList.hashCode());
      Object $artifactDTOList = this.getArtifactDTOList();
      result = result * 59 + ($artifactDTOList == null ? 43 : $artifactDTOList.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", configName="
         + this.getConfigName()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", structureType="
         + this.getStructureType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", remark="
         + this.getRemark()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", detailDTOList="
         + this.getDetailDTOList()
         + ", artifactDTOList="
         + this.getArtifactDTOList()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ")";
   }
}
