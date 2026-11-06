package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TaskProcessProductDTO", description = "")
public class TaskProcessProductDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "name", value = "产品名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "weight", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private BigDecimal weight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeGrossWeight", notes = "已完成量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "已完成量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数量")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "unGrossWeight", notes = "未完成量(毛重)")
   @JsonProperty("unGrossWeight")
   @JSONField(name = "unGrossWeight")
   private BigDecimal unGrossWeight;
   @ApiModelProperty(name = "unNetWeight", notes = "未完成量(净重)")
   @JsonProperty("unNetWeight")
   @JSONField(name = "unNetWeight")
   private BigDecimal unNetWeight;
   @ApiModelProperty(name = "completeDate", notes = "完成时间")
   @JsonProperty("completeDate")
   @JSONField(name = "completeDate")
   private LocalDateTime completeDate;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "groupName", notes = "生产组")
   @JsonProperty("groupName")
   @JSONField(name = "groupName")
   private String groupName;
   @ApiModelProperty(name = "picturePath", notes = "图片地址")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;

   public static TaskProcessProductDTO.TaskProcessProductDTOBuilder builder() {
      return new TaskProcessProductDTO.TaskProcessProductDTOBuilder();
   }

   public TaskProcessProductDTO() {
   }

   public TaskProcessProductDTO(
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final ProductionLineDetailDO productionLine,
      final WorkshopDetailDO workshop,
      final String name,
      final BigDecimal length,
      final String material,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal weight,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final Integer completeQuantity,
      final BigDecimal completeGrossWeight,
      final BigDecimal completeNetWeight,
      final Integer unQuantity,
      final BigDecimal unGrossWeight,
      final BigDecimal unNetWeight,
      final LocalDateTime completeDate,
      final Integer status,
      final String groupName,
      final String picturePath
   ) {
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.productionLine = productionLine;
      this.workshop = workshop;
      this.name = name;
      this.length = length;
      this.material = material;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.weight = weight;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.completeQuantity = completeQuantity;
      this.completeGrossWeight = completeGrossWeight;
      this.completeNetWeight = completeNetWeight;
      this.unQuantity = unQuantity;
      this.unGrossWeight = unGrossWeight;
      this.unNetWeight = unNetWeight;
      this.completeDate = completeDate;
      this.status = status;
      this.groupName = groupName;
      this.picturePath = picturePath;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
   }

   public BigDecimal getUnGrossWeight() {
      return this.unGrossWeight;
   }

   public BigDecimal getUnNetWeight() {
      return this.unNetWeight;
   }

   public LocalDateTime getCompleteDate() {
      return this.completeDate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getGroupName() {
      return this.groupName;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   @JsonProperty("project")
   public TaskProcessProductDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public TaskProcessProductDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public TaskProcessProductDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public TaskProcessProductDTO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskProcessProductDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("workshop")
   public TaskProcessProductDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("name")
   public TaskProcessProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("length")
   public TaskProcessProductDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public TaskProcessProductDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("serialNumber")
   public TaskProcessProductDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TaskProcessProductDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public TaskProcessProductDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("weight")
   public TaskProcessProductDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("grossWeight")
   public TaskProcessProductDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("netWeight")
   public TaskProcessProductDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TaskProcessProductDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TaskProcessProductDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskProcessProductDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskProcessProductDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskProcessProductDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("unQuantity")
   public TaskProcessProductDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("unGrossWeight")
   public TaskProcessProductDTO setUnGrossWeight(final BigDecimal unGrossWeight) {
      this.unGrossWeight = unGrossWeight;
      return this;
   }

   @JsonProperty("unNetWeight")
   public TaskProcessProductDTO setUnNetWeight(final BigDecimal unNetWeight) {
      this.unNetWeight = unNetWeight;
      return this;
   }

   @JsonProperty("completeDate")
   public TaskProcessProductDTO setCompleteDate(final LocalDateTime completeDate) {
      this.completeDate = completeDate;
      return this;
   }

   @JsonProperty("status")
   public TaskProcessProductDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("groupName")
   public TaskProcessProductDTO setGroupName(final String groupName) {
      this.groupName = groupName;
      return this;
   }

   @JsonProperty("picturePath")
   public TaskProcessProductDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProcessProductDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", productionLine="
         + this.getProductionLine()
         + ", workshop="
         + this.getWorkshop()
         + ", name="
         + this.getName()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", weight="
         + this.getWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", unGrossWeight="
         + this.getUnGrossWeight()
         + ", unNetWeight="
         + this.getUnNetWeight()
         + ", completeDate="
         + this.getCompleteDate()
         + ", status="
         + this.getStatus()
         + ", groupName="
         + this.getGroupName()
         + ", picturePath="
         + this.getPicturePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProcessProductDTO)) {
         return false;
      }

      TaskProcessProductDTO other = (TaskProcessProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$unQuantity = this.getUnQuantity();
            Object other$unQuantity = other.getUnQuantity();
            if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
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
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$weight = this.getWeight();
                                                   Object other$weight = other.getWeight();
                                                   if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                      Object this$grossWeight = this.getGrossWeight();
                                                      Object other$grossWeight = other.getGrossWeight();
                                                      if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                            Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                            if (this$totalGrossWeight == null
                                                               ? other$totalGrossWeight == null
                                                               : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                               Object this$totalNetWeight = this.getTotalNetWeight();
                                                               Object other$totalNetWeight = other.getTotalNetWeight();
                                                               if (this$totalNetWeight == null
                                                                  ? other$totalNetWeight == null
                                                                  : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                  Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                                                  Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                                                  if (this$completeGrossWeight == null
                                                                     ? other$completeGrossWeight == null
                                                                     : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                                                     Object this$completeNetWeight = this.getCompleteNetWeight();
                                                                     Object other$completeNetWeight = other.getCompleteNetWeight();
                                                                     if (this$completeNetWeight == null
                                                                        ? other$completeNetWeight == null
                                                                        : this$completeNetWeight.equals(other$completeNetWeight)) {
                                                                        Object this$unGrossWeight = this.getUnGrossWeight();
                                                                        Object other$unGrossWeight = other.getUnGrossWeight();
                                                                        if (this$unGrossWeight == null
                                                                           ? other$unGrossWeight == null
                                                                           : this$unGrossWeight.equals(other$unGrossWeight)) {
                                                                           Object this$unNetWeight = this.getUnNetWeight();
                                                                           Object other$unNetWeight = other.getUnNetWeight();
                                                                           if (this$unNetWeight == null
                                                                              ? other$unNetWeight == null
                                                                              : this$unNetWeight.equals(other$unNetWeight)) {
                                                                              Object this$completeDate = this.getCompleteDate();
                                                                              Object other$completeDate = other.getCompleteDate();
                                                                              if (this$completeDate == null
                                                                                 ? other$completeDate == null
                                                                                 : this$completeDate.equals(other$completeDate)) {
                                                                                 Object this$groupName = this.getGroupName();
                                                                                 Object other$groupName = other.getGroupName();
                                                                                 if (this$groupName == null
                                                                                    ? other$groupName == null
                                                                                    : this$groupName.equals(other$groupName)) {
                                                                                    Object this$picturePath = this.getPicturePath();
                                                                                    Object other$picturePath = other.getPicturePath();
                                                                                    return this$picturePath == null
                                                                                       ? other$picturePath == null
                                                                                       : this$picturePath.equals(other$picturePath);
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
      return other instanceof TaskProcessProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $unGrossWeight = this.getUnGrossWeight();
      result = result * 59 + ($unGrossWeight == null ? 43 : $unGrossWeight.hashCode());
      Object $unNetWeight = this.getUnNetWeight();
      result = result * 59 + ($unNetWeight == null ? 43 : $unNetWeight.hashCode());
      Object $completeDate = this.getCompleteDate();
      result = result * 59 + ($completeDate == null ? 43 : $completeDate.hashCode());
      Object $groupName = this.getGroupName();
      result = result * 59 + ($groupName == null ? 43 : $groupName.hashCode());
      Object $picturePath = this.getPicturePath();
      return result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
   }

   public static class TaskProcessProductDTOBuilder {
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private ProductionLineDetailDO productionLine;
      private WorkshopDetailDO workshop;
      private String name;
      private BigDecimal length;
      private String material;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal weight;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private Integer completeQuantity;
      private BigDecimal completeGrossWeight;
      private BigDecimal completeNetWeight;
      private Integer unQuantity;
      private BigDecimal unGrossWeight;
      private BigDecimal unNetWeight;
      private LocalDateTime completeDate;
      private Integer status;
      private String groupName;
      private String picturePath;

      TaskProcessProductDTOBuilder() {
      }

      @JsonProperty("project")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("workshop")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("name")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("length")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("serialNumber")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("weight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("grossWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("netWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("unQuantity")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("unGrossWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder unGrossWeight(final BigDecimal unGrossWeight) {
         this.unGrossWeight = unGrossWeight;
         return this;
      }

      @JsonProperty("unNetWeight")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder unNetWeight(final BigDecimal unNetWeight) {
         this.unNetWeight = unNetWeight;
         return this;
      }

      @JsonProperty("completeDate")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder completeDate(final LocalDateTime completeDate) {
         this.completeDate = completeDate;
         return this;
      }

      @JsonProperty("status")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("groupName")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder groupName(final String groupName) {
         this.groupName = groupName;
         return this;
      }

      @JsonProperty("picturePath")
      public TaskProcessProductDTO.TaskProcessProductDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      public TaskProcessProductDTO build() {
         return new TaskProcessProductDTO(
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.productionLine,
            this.workshop,
            this.name,
            this.length,
            this.material,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.weight,
            this.grossWeight,
            this.netWeight,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.completeQuantity,
            this.completeGrossWeight,
            this.completeNetWeight,
            this.unQuantity,
            this.unGrossWeight,
            this.unNetWeight,
            this.completeDate,
            this.status,
            this.groupName,
            this.picturePath
         );
      }

      @Override
      public String toString() {
         return "TaskProcessProductDTO.TaskProcessProductDTOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", productionLine="
            + this.productionLine
            + ", workshop="
            + this.workshop
            + ", name="
            + this.name
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", weight="
            + this.weight
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", unQuantity="
            + this.unQuantity
            + ", unGrossWeight="
            + this.unGrossWeight
            + ", unNetWeight="
            + this.unNetWeight
            + ", completeDate="
            + this.completeDate
            + ", status="
            + this.status
            + ", groupName="
            + this.groupName
            + ", picturePath="
            + this.picturePath
            + ")";
      }
   }
}
