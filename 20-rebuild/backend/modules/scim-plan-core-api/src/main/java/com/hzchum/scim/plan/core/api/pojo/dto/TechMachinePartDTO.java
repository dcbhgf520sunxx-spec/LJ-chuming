package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("零构件清单列表-构件的零件列表类")
public class TechMachinePartDTO {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "id", value = "构件id")
   private Long artifactId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("零构件关联id")
   private Long linkId;
   @ApiModelProperty(name = "structureType", value = "结构类型")
   private String structureType;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "relationType", value = "关联类型 2普通零件 8配套件 16翼腹板 18部件")
   private Integer relationType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "(本区域本构件)使用的该零件总数量")
   private Integer quantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "linkQuantity", value = "零构件比例")
   private Integer linkQuantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "thick", value = "厚")
   private String thick;
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "usedQuantity", value = "已使用量")
   private Integer usedQuantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   private String drawingNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停 1进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人名称")
   private String userName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("钢材配置id")
   private Long steelId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("钢材厚度/规格")
   private String steelSpec;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否排产 TRUE是 false 否")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty(name = "boolProcess", value = "是否有工序 true是 false否")
   private Boolean boolProcess;
   @ApiModelProperty(name = "boolHaveHole", value = "是否有孔 true 有孔 false 无孔")
   private Boolean boolHaveHole;
   @ApiModelProperty(name = "holeNumber", value = "孔的数量")
   private Long holeNumber;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "picturePath", value = "dxf图片路径")
   private String picturePath;
   @ApiModelProperty(name = "totalSurfaceArea", value = "总面积(m²)")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "assembleMachinePartDTOList", value = "部件的零件列表")
   private List<TechMachinePartDTO> assembleMachinePartDTOList;

   public Long getId() {
      return this.id;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public String getStructureType() {
      return this.structureType;
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

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Integer getLinkQuantity() {
      return this.linkQuantity;
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

   public String getThick() {
      return this.thick;
   }

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public Boolean getBoolHaveHole() {
      return this.boolHaveHole;
   }

   public Long getHoleNumber() {
      return this.holeNumber;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public List<TechMachinePartDTO> getAssembleMachinePartDTOList() {
      return this.assembleMachinePartDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setStructureType(final String structureType) {
      this.structureType = structureType;
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

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   public void setLinkQuantity(final Integer linkQuantity) {
      this.linkQuantity = linkQuantity;
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

   public void setThick(final String thick) {
      this.thick = thick;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setBoolHaveHole(final Boolean boolHaveHole) {
      this.boolHaveHole = boolHaveHole;
   }

   public void setHoleNumber(final Long holeNumber) {
      this.holeNumber = holeNumber;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
   }

   public void setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
   }

   public void setAssembleMachinePartDTOList(final List<TechMachinePartDTO> assembleMachinePartDTOList) {
      this.assembleMachinePartDTOList = assembleMachinePartDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechMachinePartDTO)) {
         return false;
      }

      TechMachinePartDTO other = (TechMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactId = this.getArtifactId();
         Object other$artifactId = other.getArtifactId();
         if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
            Object this$linkId = this.getLinkId();
            Object other$linkId = other.getLinkId();
            if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
               Object this$relationType = this.getRelationType();
               Object other$relationType = other.getRelationType();
               if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$linkQuantity = this.getLinkQuantity();
                        Object other$linkQuantity = other.getLinkQuantity();
                        if (this$linkQuantity == null ? other$linkQuantity == null : this$linkQuantity.equals(other$linkQuantity)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$usedQuantity = this.getUsedQuantity();
                              Object other$usedQuantity = other.getUsedQuantity();
                              if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                 Object this$producedQuantity = this.getProducedQuantity();
                                 Object other$producedQuantity = other.getProducedQuantity();
                                 if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                    Object this$boolStatusEnum = this.getBoolStatusEnum();
                                    Object other$boolStatusEnum = other.getBoolStatusEnum();
                                    if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                                       Object this$userId = this.getUserId();
                                       Object other$userId = other.getUserId();
                                       if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                          Object this$steelId = this.getSteelId();
                                          Object other$steelId = other.getSteelId();
                                          if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                             Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                             Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                             if (this$boolSchedulingEnum == null
                                                ? other$boolSchedulingEnum == null
                                                : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                                Object this$boolProcess = this.getBoolProcess();
                                                Object other$boolProcess = other.getBoolProcess();
                                                if (this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess)) {
                                                   Object this$boolHaveHole = this.getBoolHaveHole();
                                                   Object other$boolHaveHole = other.getBoolHaveHole();
                                                   if (this$boolHaveHole == null ? other$boolHaveHole == null : this$boolHaveHole.equals(other$boolHaveHole)) {
                                                      Object this$holeNumber = this.getHoleNumber();
                                                      Object other$holeNumber = other.getHoleNumber();
                                                      if (this$holeNumber == null ? other$holeNumber == null : this$holeNumber.equals(other$holeNumber)) {
                                                         Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                         Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                         if (this$boolSendDirectly == null
                                                            ? other$boolSendDirectly == null
                                                            : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                            Object this$structureType = this.getStructureType();
                                                            Object other$structureType = other.getStructureType();
                                                            if (this$structureType == null
                                                               ? other$structureType == null
                                                               : this$structureType.equals(other$structureType)) {
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
                                                                        Object this$length = this.getLength();
                                                                        Object other$length = other.getLength();
                                                                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                           Object this$material = this.getMaterial();
                                                                           Object other$material = other.getMaterial();
                                                                           if (this$material == null
                                                                              ? other$material == null
                                                                              : this$material.equals(other$material)) {
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
                                                                                    Object this$grossWeight = this.getGrossWeight();
                                                                                    Object other$grossWeight = other.getGrossWeight();
                                                                                    if (this$grossWeight == null
                                                                                       ? other$grossWeight == null
                                                                                       : this$grossWeight.equals(other$grossWeight)) {
                                                                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                       if (this$totalGrossWeight == null
                                                                                          ? other$totalGrossWeight == null
                                                                                          : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                          Object this$surfaceArea = this.getSurfaceArea();
                                                                                          Object other$surfaceArea = other.getSurfaceArea();
                                                                                          if (this$surfaceArea == null
                                                                                             ? other$surfaceArea == null
                                                                                             : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                             Object this$thick = this.getThick();
                                                                                             Object other$thick = other.getThick();
                                                                                             if (this$thick == null
                                                                                                ? other$thick == null
                                                                                                : this$thick.equals(other$thick)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                if (this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark)) {
                                                                                                   Object this$drawingNumber = this.getDrawingNumber();
                                                                                                   Object other$drawingNumber = other.getDrawingNumber();
                                                                                                   if (this$drawingNumber == null
                                                                                                      ? other$drawingNumber == null
                                                                                                      : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                                      Object this$userName = this.getUserName();
                                                                                                      Object other$userName = other.getUserName();
                                                                                                      if (this$userName == null
                                                                                                         ? other$userName == null
                                                                                                         : this$userName.equals(other$userName)) {
                                                                                                         Object this$steelSpec = this.getSteelSpec();
                                                                                                         Object other$steelSpec = other.getSteelSpec();
                                                                                                         if (this$steelSpec == null
                                                                                                            ? other$steelSpec == null
                                                                                                            : this$steelSpec.equals(other$steelSpec)) {
                                                                                                            Object this$picturePath = this.getPicturePath();
                                                                                                            Object other$picturePath = other.getPicturePath();
                                                                                                            if (this$picturePath == null
                                                                                                               ? other$picturePath == null
                                                                                                               : this$picturePath.equals(other$picturePath)) {
                                                                                                               Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                                                               Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                                                               if (this$totalSurfaceArea == null
                                                                                                                  ? other$totalSurfaceArea == null
                                                                                                                  : this$totalSurfaceArea.equals(
                                                                                                                     other$totalSurfaceArea
                                                                                                                  )) {
                                                                                                                  Object this$assembleMachinePartDTOList = this.getAssembleMachinePartDTOList();
                                                                                                                  Object other$assembleMachinePartDTOList = other.getAssembleMachinePartDTOList();
                                                                                                                  return this$assembleMachinePartDTOList
                                                                                                                        == null
                                                                                                                     ? other$assembleMachinePartDTOList == null
                                                                                                                     : this$assembleMachinePartDTOList.equals(
                                                                                                                        other$assembleMachinePartDTOList
                                                                                                                     );
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
      return other instanceof TechMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $linkQuantity = this.getLinkQuantity();
      result = result * 59 + ($linkQuantity == null ? 43 : $linkQuantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $boolHaveHole = this.getBoolHaveHole();
      result = result * 59 + ($boolHaveHole == null ? 43 : $boolHaveHole.hashCode());
      Object $holeNumber = this.getHoleNumber();
      result = result * 59 + ($holeNumber == null ? 43 : $holeNumber.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
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
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $assembleMachinePartDTOList = this.getAssembleMachinePartDTOList();
      return result * 59 + ($assembleMachinePartDTOList == null ? 43 : $assembleMachinePartDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechMachinePartDTO(id="
         + this.getId()
         + ", artifactId="
         + this.getArtifactId()
         + ", linkId="
         + this.getLinkId()
         + ", structureType="
         + this.getStructureType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", relationType="
         + this.getRelationType()
         + ", productType="
         + this.getProductType()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", linkQuantity="
         + this.getLinkQuantity()
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
         + ", thick="
         + this.getThick()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", boolProcess="
         + this.getBoolProcess()
         + ", boolHaveHole="
         + this.getBoolHaveHole()
         + ", holeNumber="
         + this.getHoleNumber()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", picturePath="
         + this.getPicturePath()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", assembleMachinePartDTOList="
         + this.getAssembleMachinePartDTOList()
         + ")";
   }
}
