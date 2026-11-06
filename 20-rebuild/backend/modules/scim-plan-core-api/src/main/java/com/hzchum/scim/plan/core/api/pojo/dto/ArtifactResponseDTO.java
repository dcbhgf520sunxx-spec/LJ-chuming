package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ArtifactResponseDTO {
   @ApiModelProperty(name = "pid", value = "序号")
   private Integer pid;
   @ApiModelProperty(name = "id", value = "构件id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "area", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "areaBatchName", value = "批次名称")
   private String areaBatchName;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
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
   @ApiModelProperty(name = "quantity", value = "已采购数量")
   private Integer purchaseQuantity;
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
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private String userName;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停 1进行中")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "numbers", value = "产品序列号")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;
   @ApiModelProperty(name = "smartLineMarkWord", value = "智能生产线标记词")
   private String smartLineMarkWord;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   private Integer artifactType;
   @ApiModelProperty(name = "boolCoatingEnum", value = "是否涂装 true是 false否")
   private Boolean boolCoatingEnum;
   @ApiModelProperty(name = "boolSchedulingEnum", value = "是否可以排产")
   private Boolean boolSchedulingEnum;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   private Integer codingType;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   private Boolean boolSendDirectly;
   @ApiModelProperty("图纸单重")
   private BigDecimal drawingWeight;
   @ApiModelProperty("图纸总重")
   private BigDecimal totalDrawingWeight;
   @ApiModelProperty(name = "surfaceArea", value = "总面积（㎡）")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "printedCode", value = "喷印编码")
   private String printedCode;

   public Integer getPid() {
      return this.pid;
   }

   public Long getId() {
      return this.id;
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

   public String getAreaBatchName() {
      return this.areaBatchName;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getPurchaseQuantity() {
      return this.purchaseQuantity;
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

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   public String getSmartLineMarkWord() {
      return this.smartLineMarkWord;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public Boolean getBoolSchedulingEnum() {
      return this.boolSchedulingEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getTotalDrawingWeight() {
      return this.totalDrawingWeight;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public void setPid(final Integer pid) {
      this.pid = pid;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setPurchaseQuantity(final Integer purchaseQuantity) {
      this.purchaseQuantity = purchaseQuantity;
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

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
   }

   public void setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public void setSmartLineMarkWord(final String smartLineMarkWord) {
      this.smartLineMarkWord = smartLineMarkWord;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setBoolSchedulingEnum(final Boolean boolSchedulingEnum) {
      this.boolSchedulingEnum = boolSchedulingEnum;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setTotalDrawingWeight(final BigDecimal totalDrawingWeight) {
      this.totalDrawingWeight = totalDrawingWeight;
   }

   public void setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
   }

   public void setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactResponseDTO)) {
         return false;
      }

      ArtifactResponseDTO other = (ArtifactResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pid = this.getPid();
      Object other$pid = other.getPid();
      if (this$pid == null ? other$pid == null : this$pid.equals(other$pid)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$purchaseQuantity = this.getPurchaseQuantity();
               Object other$purchaseQuantity = other.getPurchaseQuantity();
               if (this$purchaseQuantity == null ? other$purchaseQuantity == null : this$purchaseQuantity.equals(other$purchaseQuantity)) {
                  Object this$producedQuantity = this.getProducedQuantity();
                  Object other$producedQuantity = other.getProducedQuantity();
                  if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$boolStatusEnum = this.getBoolStatusEnum();
                        Object other$boolStatusEnum = other.getBoolStatusEnum();
                        if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                              Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                              if (this$productionLineTypeEnum == null
                                 ? other$productionLineTypeEnum == null
                                 : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                 Object this$artifactType = this.getArtifactType();
                                 Object other$artifactType = other.getArtifactType();
                                 if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                                    Object this$boolCoatingEnum = this.getBoolCoatingEnum();
                                    Object other$boolCoatingEnum = other.getBoolCoatingEnum();
                                    if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
                                       Object this$boolSchedulingEnum = this.getBoolSchedulingEnum();
                                       Object other$boolSchedulingEnum = other.getBoolSchedulingEnum();
                                       if (this$boolSchedulingEnum == null
                                          ? other$boolSchedulingEnum == null
                                          : this$boolSchedulingEnum.equals(other$boolSchedulingEnum)) {
                                          Object this$codingType = this.getCodingType();
                                          Object other$codingType = other.getCodingType();
                                          if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                                             Object this$structureClassId = this.getStructureClassId();
                                             Object other$structureClassId = other.getStructureClassId();
                                             if (this$structureClassId == null
                                                ? other$structureClassId == null
                                                : this$structureClassId.equals(other$structureClassId)) {
                                                Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                                Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                                if (this$boolAllPartSendDirectly == null
                                                   ? other$boolAllPartSendDirectly == null
                                                   : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                                   Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                   Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                   if (this$boolSendDirectly == null
                                                      ? other$boolSendDirectly == null
                                                      : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                      Object this$project = this.getProject();
                                                      Object other$project = other.getProject();
                                                      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                         Object this$monomer = this.getMonomer();
                                                         Object other$monomer = other.getMonomer();
                                                         if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                                            Object this$area = this.getArea();
                                                            Object other$area = other.getArea();
                                                            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                               Object this$areaBatchName = this.getAreaBatchName();
                                                               Object other$areaBatchName = other.getAreaBatchName();
                                                               if (this$areaBatchName == null
                                                                  ? other$areaBatchName == null
                                                                  : this$areaBatchName.equals(other$areaBatchName)) {
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
                                                                                                Object this$drawingNumber = this.getDrawingNumber();
                                                                                                Object other$drawingNumber = other.getDrawingNumber();
                                                                                                if (this$drawingNumber == null
                                                                                                   ? other$drawingNumber == null
                                                                                                   : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                                   Object this$remark = this.getRemark();
                                                                                                   Object other$remark = other.getRemark();
                                                                                                   if (this$remark == null
                                                                                                      ? other$remark == null
                                                                                                      : this$remark.equals(other$remark)) {
                                                                                                      Object this$userName = this.getUserName();
                                                                                                      Object other$userName = other.getUserName();
                                                                                                      if (this$userName == null
                                                                                                         ? other$userName == null
                                                                                                         : this$userName.equals(other$userName)) {
                                                                                                         Object this$numbers = this.getNumbers();
                                                                                                         Object other$numbers = other.getNumbers();
                                                                                                         if (this$numbers == null
                                                                                                            ? other$numbers == null
                                                                                                            : this$numbers.equals(other$numbers)) {
                                                                                                            Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                                            Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                                            if (this$drawingAndSerialNumber == null
                                                                                                               ? other$drawingAndSerialNumber == null
                                                                                                               : this$drawingAndSerialNumber.equals(
                                                                                                                  other$drawingAndSerialNumber
                                                                                                               )) {
                                                                                                               Object this$smartLineMarkWord = this.getSmartLineMarkWord();
                                                                                                               Object other$smartLineMarkWord = other.getSmartLineMarkWord();
                                                                                                               if (this$smartLineMarkWord == null
                                                                                                                  ? other$smartLineMarkWord == null
                                                                                                                  : this$smartLineMarkWord.equals(
                                                                                                                     other$smartLineMarkWord
                                                                                                                  )) {
                                                                                                                  Object this$drawingWeight = this.getDrawingWeight();
                                                                                                                  Object other$drawingWeight = other.getDrawingWeight();
                                                                                                                  if (this$drawingWeight == null
                                                                                                                     ? other$drawingWeight == null
                                                                                                                     : this$drawingWeight.equals(
                                                                                                                        other$drawingWeight
                                                                                                                     )) {
                                                                                                                     Object this$totalDrawingWeight = this.getTotalDrawingWeight();
                                                                                                                     Object other$totalDrawingWeight = other.getTotalDrawingWeight();
                                                                                                                     if (this$totalDrawingWeight == null
                                                                                                                        ? other$totalDrawingWeight == null
                                                                                                                        : this$totalDrawingWeight.equals(
                                                                                                                           other$totalDrawingWeight
                                                                                                                        )) {
                                                                                                                        Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                                                                        Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                                                                        if (this$totalSurfaceArea == null
                                                                                                                           ? other$totalSurfaceArea == null
                                                                                                                           : this$totalSurfaceArea.equals(
                                                                                                                              other$totalSurfaceArea
                                                                                                                           )) {
                                                                                                                           Object this$printedCode = this.getPrintedCode();
                                                                                                                           Object other$printedCode = other.getPrintedCode();
                                                                                                                           return this$printedCode == null
                                                                                                                              ? other$printedCode == null
                                                                                                                              : this$printedCode.equals(
                                                                                                                                 other$printedCode
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
      return other instanceof ArtifactResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pid = this.getPid();
      result = result * 59 + ($pid == null ? 43 : $pid.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $purchaseQuantity = this.getPurchaseQuantity();
      result = result * 59 + ($purchaseQuantity == null ? 43 : $purchaseQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $boolSchedulingEnum = this.getBoolSchedulingEnum();
      result = result * 59 + ($boolSchedulingEnum == null ? 43 : $boolSchedulingEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
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
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      result = result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
      Object $smartLineMarkWord = this.getSmartLineMarkWord();
      result = result * 59 + ($smartLineMarkWord == null ? 43 : $smartLineMarkWord.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $totalDrawingWeight = this.getTotalDrawingWeight();
      result = result * 59 + ($totalDrawingWeight == null ? 43 : $totalDrawingWeight.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $printedCode = this.getPrintedCode();
      return result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactResponseDTO(pid="
         + this.getPid()
         + ", id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", name="
         + this.getName()
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
         + ", purchaseQuantity="
         + this.getPurchaseQuantity()
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
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", monomerId="
         + this.getMonomerId()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ", smartLineMarkWord="
         + this.getSmartLineMarkWord()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", boolSchedulingEnum="
         + this.getBoolSchedulingEnum()
         + ", codingType="
         + this.getCodingType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", totalDrawingWeight="
         + this.getTotalDrawingWeight()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", printedCode="
         + this.getPrintedCode()
         + ")";
   }
}
