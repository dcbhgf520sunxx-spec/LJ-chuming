package com.hzchum.scim.cut.core.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

public class TechMachinePartDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "零件名称")
   private String name;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id")
   private Long areaId;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type")
   private Integer relationType;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "usedQuantity", value = "已使用量")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity")
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number")
   private String drawingNumber;
   @ApiModelProperty(name = "thick", value = "厚")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick")
   private String thick;
   @ApiModelProperty(name = "path", value = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField(value = "path", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "path")
   private String path;
   @ApiModelProperty(name = "nestingState", value = "排套状态")
   @JsonProperty("nestingState")
   @JSONField(name = "nestingState")
   @TableField("nesting_state")
   @Column(name = "nesting_state")
   private Integer nestingState;
   @TableField(exist = false)
   @ApiModelProperty(name = "areaName", value = "区域名")
   private String areaName;
   @TableField(exist = false)
   @ApiModelProperty(name = "monomerName", value = "单体名")
   private String monomerName;
   @TableField(exist = false)
   @ApiModelProperty(name = "projectName", value = "项目名")
   private String projectName;
   @ApiModelProperty("钢材配置id")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private Long steelId;
   @ApiModelProperty("钢材厚度/规格")
   @Column
   @TableField(updateStrategy = FieldStrategy.IGNORED)
   private String steelSpec;
   @ApiModelProperty(name = "areaType", value = "区域制造类型 0自制 1外包")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type")
   private Integer areaType;

   TechMachinePartDTO(
      final Long id,
      final String name,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Boolean boolStatusEnum,
      final Integer relationType,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final Integer type,
      final String remark,
      final Long userId,
      final Integer usedQuantity,
      final Integer producedQuantity,
      final String drawingNumber,
      final String thick,
      final String path,
      final Integer nestingState,
      final String areaName,
      final String monomerName,
      final String projectName,
      final Long steelId,
      final String steelSpec,
      final Integer areaType
   ) {
      this.id = id;
      this.name = name;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.boolStatusEnum = boolStatusEnum;
      this.relationType = relationType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.type = type;
      this.remark = remark;
      this.userId = userId;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.drawingNumber = drawingNumber;
      this.thick = thick;
      this.path = path;
      this.nestingState = nestingState;
      this.areaName = areaName;
      this.monomerName = monomerName;
      this.projectName = projectName;
      this.steelId = steelId;
      this.steelSpec = steelSpec;
      this.areaType = areaType;
   }

   public static TechMachinePartDTO.TechMachinePartDTOBuilder builder() {
      return new TechMachinePartDTO.TechMachinePartDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
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

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
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

   public String getThick() {
      return this.thick;
   }

   public String getPath() {
      return this.path;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("monomerId")
   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @JsonProperty("areaId")
   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   @JsonProperty("boolStatusEnum")
   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   @JsonProperty("relationType")
   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("length")
   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   @JsonProperty("material")
   public void setMaterial(final String material) {
      this.material = material;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("netWeight")
   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   @JsonProperty("totalNetWeight")
   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   @JsonProperty("grossWeight")
   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   @JsonProperty("totalGrossWeight")
   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   @JsonProperty("type")
   public void setType(final Integer type) {
      this.type = type;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @JsonProperty("userId")
   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @JsonProperty("usedQuantity")
   public void setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
   }

   @JsonProperty("producedQuantity")
   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   @JsonProperty("drawingNumber")
   public void setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
   }

   @JsonProperty("thick")
   public void setThick(final String thick) {
      this.thick = thick;
   }

   @JsonProperty("path")
   public void setPath(final String path) {
      this.path = path;
   }

   @JsonProperty("nestingState")
   public void setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
   }

   @JsonProperty("areaType")
   public void setAreaType(final Integer areaType) {
      this.areaType = areaType;
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
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$boolStatusEnum = this.getBoolStatusEnum();
                  Object other$boolStatusEnum = other.getBoolStatusEnum();
                  if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                     Object this$relationType = this.getRelationType();
                     Object other$relationType = other.getRelationType();
                     if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$usedQuantity = this.getUsedQuantity();
                                 Object other$usedQuantity = other.getUsedQuantity();
                                 if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                    Object this$producedQuantity = this.getProducedQuantity();
                                    Object other$producedQuantity = other.getProducedQuantity();
                                    if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                       Object this$nestingState = this.getNestingState();
                                       Object other$nestingState = other.getNestingState();
                                       if (this$nestingState == null ? other$nestingState == null : this$nestingState.equals(other$nestingState)) {
                                          Object this$steelId = this.getSteelId();
                                          Object other$steelId = other.getSteelId();
                                          if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                             Object this$areaType = this.getAreaType();
                                             Object other$areaType = other.getAreaType();
                                             if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                                                                     if (this$grossWeight == null
                                                                        ? other$grossWeight == null
                                                                        : this$grossWeight.equals(other$grossWeight)) {
                                                                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                        if (this$totalGrossWeight == null
                                                                           ? other$totalGrossWeight == null
                                                                           : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$drawingNumber = this.getDrawingNumber();
                                                                              Object other$drawingNumber = other.getDrawingNumber();
                                                                              if (this$drawingNumber == null
                                                                                 ? other$drawingNumber == null
                                                                                 : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                 Object this$thick = this.getThick();
                                                                                 Object other$thick = other.getThick();
                                                                                 if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                                    Object this$path = this.getPath();
                                                                                    Object other$path = other.getPath();
                                                                                    if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                                                                       Object this$areaName = this.getAreaName();
                                                                                       Object other$areaName = other.getAreaName();
                                                                                       if (this$areaName == null
                                                                                          ? other$areaName == null
                                                                                          : this$areaName.equals(other$areaName)) {
                                                                                          Object this$monomerName = this.getMonomerName();
                                                                                          Object other$monomerName = other.getMonomerName();
                                                                                          if (this$monomerName == null
                                                                                             ? other$monomerName == null
                                                                                             : this$monomerName.equals(other$monomerName)) {
                                                                                             Object this$projectName = this.getProjectName();
                                                                                             Object other$projectName = other.getProjectName();
                                                                                             if (this$projectName == null
                                                                                                ? other$projectName == null
                                                                                                : this$projectName.equals(other$projectName)) {
                                                                                                Object this$steelSpec = this.getSteelSpec();
                                                                                                Object other$steelSpec = other.getSteelSpec();
                                                                                                return this$steelSpec == null
                                                                                                   ? other$steelSpec == null
                                                                                                   : this$steelSpec.equals(other$steelSpec);
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   @Override
   public String toString() {
      return "TechMachinePartDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", relationType="
         + this.getRelationType()
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
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", thick="
         + this.getThick()
         + ", path="
         + this.getPath()
         + ", nestingState="
         + this.getNestingState()
         + ", areaName="
         + this.getAreaName()
         + ", monomerName="
         + this.getMonomerName()
         + ", projectName="
         + this.getProjectName()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", areaType="
         + this.getAreaType()
         + ")";
   }

   public static class TechMachinePartDTOBuilder {
      private Long id;
      private String name;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Boolean boolStatusEnum;
      private Integer relationType;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private Integer type;
      private String remark;
      private Long userId;
      private Integer usedQuantity;
      private Integer producedQuantity;
      private String drawingNumber;
      private String thick;
      private String path;
      private Integer nestingState;
      private String areaName;
      private String monomerName;
      private String projectName;
      private Long steelId;
      private String steelSpec;
      private Integer areaType;

      TechMachinePartDTOBuilder() {
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("projectId")
      public TechMachinePartDTO.TechMachinePartDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechMachinePartDTO.TechMachinePartDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public TechMachinePartDTO.TechMachinePartDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public TechMachinePartDTO.TechMachinePartDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("relationType")
      public TechMachinePartDTO.TechMachinePartDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechMachinePartDTO.TechMachinePartDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechMachinePartDTO.TechMachinePartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public TechMachinePartDTO.TechMachinePartDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TechMachinePartDTO.TechMachinePartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public TechMachinePartDTO.TechMachinePartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public TechMachinePartDTO.TechMachinePartDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TechMachinePartDTO.TechMachinePartDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TechMachinePartDTO.TechMachinePartDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TechMachinePartDTO.TechMachinePartDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("type")
      public TechMachinePartDTO.TechMachinePartDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public TechMachinePartDTO.TechMachinePartDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechMachinePartDTO.TechMachinePartDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("usedQuantity")
      public TechMachinePartDTO.TechMachinePartDTOBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public TechMachinePartDTO.TechMachinePartDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("drawingNumber")
      public TechMachinePartDTO.TechMachinePartDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("thick")
      public TechMachinePartDTO.TechMachinePartDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("path")
      public TechMachinePartDTO.TechMachinePartDTOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("nestingState")
      public TechMachinePartDTO.TechMachinePartDTOBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public TechMachinePartDTO.TechMachinePartDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("areaType")
      public TechMachinePartDTO.TechMachinePartDTOBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      public TechMachinePartDTO build() {
         return new TechMachinePartDTO(
            this.id,
            this.name,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.boolStatusEnum,
            this.relationType,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.type,
            this.remark,
            this.userId,
            this.usedQuantity,
            this.producedQuantity,
            this.drawingNumber,
            this.thick,
            this.path,
            this.nestingState,
            this.areaName,
            this.monomerName,
            this.projectName,
            this.steelId,
            this.steelSpec,
            this.areaType
         );
      }

      @Override
      public String toString() {
         return "TechMachinePartDTO.TechMachinePartDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", relationType="
            + this.relationType
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", drawingNumber="
            + this.drawingNumber
            + ", thick="
            + this.thick
            + ", path="
            + this.path
            + ", nestingState="
            + this.nestingState
            + ", areaName="
            + this.areaName
            + ", monomerName="
            + this.monomerName
            + ", projectName="
            + this.projectName
            + ", steelId="
            + this.steelId
            + ", steelSpec="
            + this.steelSpec
            + ", areaType="
            + this.areaType
            + ")";
      }
   }
}
