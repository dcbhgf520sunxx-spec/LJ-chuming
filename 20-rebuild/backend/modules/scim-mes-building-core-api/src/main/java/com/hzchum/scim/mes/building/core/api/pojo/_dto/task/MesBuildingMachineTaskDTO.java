package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ProjectDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingMachineTaskDTO", description = "零件工单详情 ")
public class MesBuildingMachineTaskDTO {
   @ApiModelProperty(name = "id", notes = "主键id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "partId", notes = "零件id", value = "零件id")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   private Long partId;
   @ApiModelProperty(name = "project", notes = "项目简单信息", value = "项目简单信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDTO project;
   @ApiModelProperty(name = "monomerName", notes = "单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", notes = "区域编号")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private String areaId;
   @ApiModelProperty(name = "areaName", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量", value = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "productId", notes = "产品id", value = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "length", notes = "长度", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "weight", notes = "重量", value = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "netWeight", notes = "单净重", value = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重", value = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重", value = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重", value = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.svg位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;
   @ApiModelProperty(name = "thick", value = "厚(mm)")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   private Boolean boolCompleteEnum;
   @ApiModelProperty(name = "labelStatus", value = "打标状态", notes = "打标状态")
   @JsonProperty("labelStatus")
   @JSONField(name = "labelStatus")
   private Integer labelStatus;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "completeNetWeight", value = "完成重量", notes = "完成重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;

   public static MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder builder() {
      return new MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder();
   }

   public MesBuildingMachineTaskDTO() {
   }

   public MesBuildingMachineTaskDTO(
      final Long id,
      final Long partId,
      final ProjectDetailDTO project,
      final String monomerName,
      final String areaId,
      final String areaName,
      final Long monomerId,
      final String serialNumber,
      final String specification,
      final String material,
      final Integer quantity,
      final Integer completeQuantity,
      final Long productId,
      final BigDecimal length,
      final BigDecimal weight,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final String picturePath,
      final String thick,
      final Boolean boolCompleteEnum,
      final Integer labelStatus,
      final Long taskOrderId,
      final BigDecimal completeNetWeight
   ) {
      this.id = id;
      this.partId = partId;
      this.project = project;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.quantity = quantity;
      this.completeQuantity = completeQuantity;
      this.productId = productId;
      this.length = length;
      this.weight = weight;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.picturePath = picturePath;
      this.thick = thick;
      this.boolCompleteEnum = boolCompleteEnum;
      this.labelStatus = labelStatus;
      this.taskOrderId = taskOrderId;
      this.completeNetWeight = completeNetWeight;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPartId() {
      return this.partId;
   }

   public ProjectDetailDTO getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getMonomerId() {
      return this.monomerId;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public String getThick() {
      return this.thick;
   }

   public Boolean getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   public Integer getLabelStatus() {
      return this.labelStatus;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   @JsonProperty("id")
   public MesBuildingMachineTaskDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("partId")
   public MesBuildingMachineTaskDTO setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingMachineTaskDTO setProject(final ProjectDetailDTO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingMachineTaskDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingMachineTaskDTO setAreaId(final String areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingMachineTaskDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingMachineTaskDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingMachineTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingMachineTaskDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachineTaskDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachineTaskDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingMachineTaskDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachineTaskDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingMachineTaskDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("weight")
   public MesBuildingMachineTaskDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingMachineTaskDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingMachineTaskDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachineTaskDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingMachineTaskDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("picturePath")
   public MesBuildingMachineTaskDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachineTaskDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public MesBuildingMachineTaskDTO setBoolCompleteEnum(final Boolean boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @JsonProperty("labelStatus")
   public MesBuildingMachineTaskDTO setLabelStatus(final Integer labelStatus) {
      this.labelStatus = labelStatus;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingMachineTaskDTO setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public MesBuildingMachineTaskDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachineTaskDTO(id="
         + this.getId()
         + ", partId="
         + this.getPartId()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", productId="
         + this.getProductId()
         + ", length="
         + this.getLength()
         + ", weight="
         + this.getWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", picturePath="
         + this.getPicturePath()
         + ", thick="
         + this.getThick()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ", labelStatus="
         + this.getLabelStatus()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachineTaskDTO)) {
         return false;
      }

      MesBuildingMachineTaskDTO other = (MesBuildingMachineTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partId = this.getPartId();
         Object other$partId = other.getPartId();
         if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                        Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                        if (this$boolCompleteEnum == null ? other$boolCompleteEnum == null : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                           Object this$labelStatus = this.getLabelStatus();
                           Object other$labelStatus = other.getLabelStatus();
                           if (this$labelStatus == null ? other$labelStatus == null : this$labelStatus.equals(other$labelStatus)) {
                              Object this$taskOrderId = this.getTaskOrderId();
                              Object other$taskOrderId = other.getTaskOrderId();
                              if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$monomerName = this.getMonomerName();
                                    Object other$monomerName = other.getMonomerName();
                                    if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                       Object this$areaId = this.getAreaId();
                                       Object other$areaId = other.getAreaId();
                                       if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                          Object this$areaName = this.getAreaName();
                                          Object other$areaName = other.getAreaName();
                                          if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$length = this.getLength();
                                                      Object other$length = other.getLength();
                                                      if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                         Object this$weight = this.getWeight();
                                                         Object other$weight = other.getWeight();
                                                         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                            Object this$netWeight = this.getNetWeight();
                                                            Object other$netWeight = other.getNetWeight();
                                                            if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                               Object this$grossWeight = this.getGrossWeight();
                                                               Object other$grossWeight = other.getGrossWeight();
                                                               if (this$grossWeight == null
                                                                  ? other$grossWeight == null
                                                                  : this$grossWeight.equals(other$grossWeight)) {
                                                                  Object this$totalNetWeight = this.getTotalNetWeight();
                                                                  Object other$totalNetWeight = other.getTotalNetWeight();
                                                                  if (this$totalNetWeight == null
                                                                     ? other$totalNetWeight == null
                                                                     : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                     Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                     Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                     if (this$totalGrossWeight == null
                                                                        ? other$totalGrossWeight == null
                                                                        : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                        Object this$picturePath = this.getPicturePath();
                                                                        Object other$picturePath = other.getPicturePath();
                                                                        if (this$picturePath == null
                                                                           ? other$picturePath == null
                                                                           : this$picturePath.equals(other$picturePath)) {
                                                                           Object this$thick = this.getThick();
                                                                           Object other$thick = other.getThick();
                                                                           if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                              Object this$completeNetWeight = this.getCompleteNetWeight();
                                                                              Object other$completeNetWeight = other.getCompleteNetWeight();
                                                                              return this$completeNetWeight == null
                                                                                 ? other$completeNetWeight == null
                                                                                 : this$completeNetWeight.equals(other$completeNetWeight);
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
      return other instanceof MesBuildingMachineTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $labelStatus = this.getLabelStatus();
      result = result * 59 + ($labelStatus == null ? 43 : $labelStatus.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      return result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
   }

   public static class MesBuildingMachineTaskDTOBuilder {
      private Long id;
      private Long partId;
      private ProjectDetailDTO project;
      private String monomerName;
      private String areaId;
      private String areaName;
      private Long monomerId;
      private String serialNumber;
      private String specification;
      private String material;
      private Integer quantity;
      private Integer completeQuantity;
      private Long productId;
      private BigDecimal length;
      private BigDecimal weight;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private String picturePath;
      private String thick;
      private Boolean boolCompleteEnum;
      private Integer labelStatus;
      private Long taskOrderId;
      private BigDecimal completeNetWeight;

      MesBuildingMachineTaskDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("partId")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder project(final ProjectDetailDTO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder areaId(final String areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("weight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("picturePath")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder boolCompleteEnum(final Boolean boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      @JsonProperty("labelStatus")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder labelStatus(final Integer labelStatus) {
         this.labelStatus = labelStatus;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      public MesBuildingMachineTaskDTO build() {
         return new MesBuildingMachineTaskDTO(
            this.id,
            this.partId,
            this.project,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.monomerId,
            this.serialNumber,
            this.specification,
            this.material,
            this.quantity,
            this.completeQuantity,
            this.productId,
            this.length,
            this.weight,
            this.netWeight,
            this.grossWeight,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.picturePath,
            this.thick,
            this.boolCompleteEnum,
            this.labelStatus,
            this.taskOrderId,
            this.completeNetWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachineTaskDTO.MesBuildingMachineTaskDTOBuilder(id="
            + this.id
            + ", partId="
            + this.partId
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", productId="
            + this.productId
            + ", length="
            + this.length
            + ", weight="
            + this.weight
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", picturePath="
            + this.picturePath
            + ", thick="
            + this.thick
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ", labelStatus="
            + this.labelStatus
            + ", taskOrderId="
            + this.taskOrderId
            + ", completeNetWeight="
            + this.completeNetWeight
            + ")";
      }
   }
}
