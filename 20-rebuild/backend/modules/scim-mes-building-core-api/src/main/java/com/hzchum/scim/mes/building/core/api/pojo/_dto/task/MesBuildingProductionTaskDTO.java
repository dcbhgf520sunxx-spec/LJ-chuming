package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingProductionTaskDTO", description = "任务清单 ")
public class MesBuildingProductionTaskDTO {
   @ApiModelProperty(name = "orderNumber", notes = "任务工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "project", value = "项目")
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
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "scheduleTime", notes = "排产日期")
   @JsonProperty("scheduleTime")
   @JSONField(name = "scheduleTime")
   private String scheduleTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "taskType", notes = "任务属性")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重(kg)")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重(kg)")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "单面积(m2)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalSurfaceArea", notes = "总面积(m2)")
   private BigDecimal totalSurfaceArea;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成总净重(kg)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成总毛重(kg)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "status", notes = "完成状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "boolCanRevoke", notes = "是否可撤回")
   @JsonProperty("boolCanRevoke")
   @JSONField(name = "boolCanRevoke")
   private Boolean boolCanRevoke;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "artifactName", notes = "构件名称", value = "构件名称")
   @JsonProperty("artifactName")
   @JSONField(name = "artifactName")
   private String artifactName;

   public static MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder builder() {
      return new MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder();
   }

   public MesBuildingProductionTaskDTO() {
   }

   public MesBuildingProductionTaskDTO(
      final String orderNumber,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final String scheduleTime,
      final LocalDateTime completeTime,
      final Integer taskType,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final BigDecimal totalSurfaceArea,
      final Integer completeQuantity,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final Integer status,
      final Boolean boolCanRevoke,
      final Integer inProductionQuantity,
      final Long productId,
      final Long taskId,
      final String artifactName
   ) {
      this.orderNumber = orderNumber;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.scheduleTime = scheduleTime;
      this.completeTime = completeTime;
      this.taskType = taskType;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.totalSurfaceArea = totalSurfaceArea;
      this.completeQuantity = completeQuantity;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.status = status;
      this.boolCanRevoke = boolCanRevoke;
      this.inProductionQuantity = inProductionQuantity;
      this.productId = productId;
      this.taskId = taskId;
      this.artifactName = artifactName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public String getScheduleTime() {
      return this.scheduleTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalSurfaceArea() {
      return this.totalSurfaceArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getBoolCanRevoke() {
      return this.boolCanRevoke;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   @JsonProperty("orderNumber")
   public MesBuildingProductionTaskDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingProductionTaskDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesBuildingProductionTaskDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MesBuildingProductionTaskDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingProductionTaskDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingProductionTaskDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingProductionTaskDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingProductionTaskDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingProductionTaskDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingProductionTaskDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingProductionTaskDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("scheduleTime")
   public MesBuildingProductionTaskDTO setScheduleTime(final String scheduleTime) {
      this.scheduleTime = scheduleTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingProductionTaskDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("taskType")
   public MesBuildingProductionTaskDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProductionTaskDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingProductionTaskDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingProductionTaskDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public MesBuildingProductionTaskDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public MesBuildingProductionTaskDTO setTotalSurfaceArea(final BigDecimal totalSurfaceArea) {
      this.totalSurfaceArea = totalSurfaceArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingProductionTaskDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public MesBuildingProductionTaskDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public MesBuildingProductionTaskDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingProductionTaskDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("boolCanRevoke")
   public MesBuildingProductionTaskDTO setBoolCanRevoke(final Boolean boolCanRevoke) {
      this.boolCanRevoke = boolCanRevoke;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public MesBuildingProductionTaskDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProductionTaskDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProductionTaskDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("artifactName")
   public MesBuildingProductionTaskDTO setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionTaskDTO(orderNumber="
         + this.getOrderNumber()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", scheduleTime="
         + this.getScheduleTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", taskType="
         + this.getTaskType()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalSurfaceArea="
         + this.getTotalSurfaceArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", status="
         + this.getStatus()
         + ", boolCanRevoke="
         + this.getBoolCanRevoke()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", productId="
         + this.getProductId()
         + ", taskId="
         + this.getTaskId()
         + ", artifactName="
         + this.getArtifactName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionTaskDTO)) {
         return false;
      }

      MesBuildingProductionTaskDTO other = (MesBuildingProductionTaskDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskType = this.getTaskType();
      Object other$taskType = other.getTaskType();
      if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$boolCanRevoke = this.getBoolCanRevoke();
                  Object other$boolCanRevoke = other.getBoolCanRevoke();
                  if (this$boolCanRevoke == null ? other$boolCanRevoke == null : this$boolCanRevoke.equals(other$boolCanRevoke)) {
                     Object this$inProductionQuantity = this.getInProductionQuantity();
                     Object other$inProductionQuantity = other.getInProductionQuantity();
                     if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$taskId = this.getTaskId();
                           Object other$taskId = other.getTaskId();
                           if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                              Object this$orderNumber = this.getOrderNumber();
                              Object other$orderNumber = other.getOrderNumber();
                              if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$monomer = this.getMonomer();
                                    Object other$monomer = other.getMonomer();
                                    if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$grossWeight = this.getGrossWeight();
                                                            Object other$grossWeight = other.getGrossWeight();
                                                            if (this$grossWeight == null
                                                               ? other$grossWeight == null
                                                               : this$grossWeight.equals(other$grossWeight)) {
                                                               Object this$scheduleTime = this.getScheduleTime();
                                                               Object other$scheduleTime = other.getScheduleTime();
                                                               if (this$scheduleTime == null
                                                                  ? other$scheduleTime == null
                                                                  : this$scheduleTime.equals(other$scheduleTime)) {
                                                                  Object this$completeTime = this.getCompleteTime();
                                                                  Object other$completeTime = other.getCompleteTime();
                                                                  if (this$completeTime == null
                                                                     ? other$completeTime == null
                                                                     : this$completeTime.equals(other$completeTime)) {
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
                                                                           Object this$surfaceArea = this.getSurfaceArea();
                                                                           Object other$surfaceArea = other.getSurfaceArea();
                                                                           if (this$surfaceArea == null
                                                                              ? other$surfaceArea == null
                                                                              : this$surfaceArea.equals(other$surfaceArea)) {
                                                                              Object this$totalSurfaceArea = this.getTotalSurfaceArea();
                                                                              Object other$totalSurfaceArea = other.getTotalSurfaceArea();
                                                                              if (this$totalSurfaceArea == null
                                                                                 ? other$totalSurfaceArea == null
                                                                                 : this$totalSurfaceArea.equals(other$totalSurfaceArea)) {
                                                                                 Object this$completeNetWeight = this.getCompleteNetWeight();
                                                                                 Object other$completeNetWeight = other.getCompleteNetWeight();
                                                                                 if (this$completeNetWeight == null
                                                                                    ? other$completeNetWeight == null
                                                                                    : this$completeNetWeight.equals(other$completeNetWeight)) {
                                                                                    Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                                                                    Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                                                                    if (this$completeGrossWeight == null
                                                                                       ? other$completeGrossWeight == null
                                                                                       : this$completeGrossWeight.equals(other$completeGrossWeight)) {
                                                                                       Object this$artifactName = this.getArtifactName();
                                                                                       Object other$artifactName = other.getArtifactName();
                                                                                       return this$artifactName == null
                                                                                          ? other$artifactName == null
                                                                                          : this$artifactName.equals(other$artifactName);
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
      return other instanceof MesBuildingProductionTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolCanRevoke = this.getBoolCanRevoke();
      result = result * 59 + ($boolCanRevoke == null ? 43 : $boolCanRevoke.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $scheduleTime = this.getScheduleTime();
      result = result * 59 + ($scheduleTime == null ? 43 : $scheduleTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalSurfaceArea = this.getTotalSurfaceArea();
      result = result * 59 + ($totalSurfaceArea == null ? 43 : $totalSurfaceArea.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $artifactName = this.getArtifactName();
      return result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
   }

   public static class MesBuildingProductionTaskDTOBuilder {
      private String orderNumber;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private String scheduleTime;
      private LocalDateTime completeTime;
      private Integer taskType;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private BigDecimal totalSurfaceArea;
      private Integer completeQuantity;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private Integer status;
      private Boolean boolCanRevoke;
      private Integer inProductionQuantity;
      private Long productId;
      private Long taskId;
      private String artifactName;

      MesBuildingProductionTaskDTOBuilder() {
      }

      @JsonProperty("orderNumber")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("scheduleTime")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder scheduleTime(final String scheduleTime) {
         this.scheduleTime = scheduleTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("taskType")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder totalSurfaceArea(final BigDecimal totalSurfaceArea) {
         this.totalSurfaceArea = totalSurfaceArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("boolCanRevoke")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder boolCanRevoke(final Boolean boolCanRevoke) {
         this.boolCanRevoke = boolCanRevoke;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("artifactName")
      public MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder artifactName(final String artifactName) {
         this.artifactName = artifactName;
         return this;
      }

      public MesBuildingProductionTaskDTO build() {
         return new MesBuildingProductionTaskDTO(
            this.orderNumber,
            this.project,
            this.monomer,
            this.area,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.netWeight,
            this.grossWeight,
            this.scheduleTime,
            this.completeTime,
            this.taskType,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.totalSurfaceArea,
            this.completeQuantity,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.status,
            this.boolCanRevoke,
            this.inProductionQuantity,
            this.productId,
            this.taskId,
            this.artifactName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductionTaskDTO.MesBuildingProductionTaskDTOBuilder(orderNumber="
            + this.orderNumber
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", scheduleTime="
            + this.scheduleTime
            + ", completeTime="
            + this.completeTime
            + ", taskType="
            + this.taskType
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalSurfaceArea="
            + this.totalSurfaceArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", status="
            + this.status
            + ", boolCanRevoke="
            + this.boolCanRevoke
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", productId="
            + this.productId
            + ", taskId="
            + this.taskId
            + ", artifactName="
            + this.artifactName
            + ")";
      }
   }
}
