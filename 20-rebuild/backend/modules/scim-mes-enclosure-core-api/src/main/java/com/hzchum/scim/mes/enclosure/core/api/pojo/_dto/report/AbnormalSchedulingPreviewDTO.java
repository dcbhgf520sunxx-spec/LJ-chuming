package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "AbnormalSchedulingPreviewDTO", description = "异常处理排产预览")
public class AbnormalSchedulingPreviewDTO {
   @ApiModelProperty(name = "id", notes = "主键")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
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
   @ApiModelProperty(name = "productId", notes = "产品")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", notes = "产品名")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "length", notes = "产品长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private String length;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "reduceQuantity", notes = "减少数量")
   @JsonProperty("reduceQuantity")
   @JSONField(name = "reduceQuantity")
   private Integer reduceQuantity;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "status", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "issueStatus", notes = "状态 [0 未下发, 1 已下发]")
   @JsonProperty("issueStatus")
   @JSONField(name = "issueStatus")
   private Boolean issueStatus;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "plate", notes = "版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "color", notes = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   private String color;

   public static AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder builder() {
      return new AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder();
   }

   public AbnormalSchedulingPreviewDTO() {
   }

   public AbnormalSchedulingPreviewDTO(
      final Long id,
      final FactoryDetailDO factory,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final String length,
      final Integer productType,
      final Integer schedulingQuantity,
      final Integer taskQuantity,
      final Integer reduceQuantity,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Boolean issueStatus,
      final Long userId,
      final Long productProcessId,
      final String plate,
      final String color
   ) {
      this.id = id;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.productType = productType;
      this.schedulingQuantity = schedulingQuantity;
      this.taskQuantity = taskQuantity;
      this.reduceQuantity = reduceQuantity;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.issueStatus = issueStatus;
      this.userId = userId;
      this.productProcessId = productProcessId;
      this.plate = plate;
      this.color = color;
   }

   public Long getId() {
      return this.id;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
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

   public Long getProductId() {
      return this.productId;
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

   public String getLength() {
      return this.length;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getReduceQuantity() {
      return this.reduceQuantity;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Boolean getIssueStatus() {
      return this.issueStatus;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   @JsonProperty("id")
   public AbnormalSchedulingPreviewDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factory")
   public AbnormalSchedulingPreviewDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AbnormalSchedulingPreviewDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AbnormalSchedulingPreviewDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("project")
   public AbnormalSchedulingPreviewDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AbnormalSchedulingPreviewDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public AbnormalSchedulingPreviewDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("productId")
   public AbnormalSchedulingPreviewDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public AbnormalSchedulingPreviewDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public AbnormalSchedulingPreviewDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AbnormalSchedulingPreviewDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public AbnormalSchedulingPreviewDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("length")
   public AbnormalSchedulingPreviewDTO setLength(final String length) {
      this.length = length;
      return this;
   }

   @JsonProperty("productType")
   public AbnormalSchedulingPreviewDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public AbnormalSchedulingPreviewDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("taskQuantity")
   public AbnormalSchedulingPreviewDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("reduceQuantity")
   public AbnormalSchedulingPreviewDTO setReduceQuantity(final Integer reduceQuantity) {
      this.reduceQuantity = reduceQuantity;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AbnormalSchedulingPreviewDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public AbnormalSchedulingPreviewDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public AbnormalSchedulingPreviewDTO setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("issueStatus")
   public AbnormalSchedulingPreviewDTO setIssueStatus(final Boolean issueStatus) {
      this.issueStatus = issueStatus;
      return this;
   }

   @JsonProperty("userId")
   public AbnormalSchedulingPreviewDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productProcessId")
   public AbnormalSchedulingPreviewDTO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("plate")
   public AbnormalSchedulingPreviewDTO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("color")
   public AbnormalSchedulingPreviewDTO setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalSchedulingPreviewDTO(id="
         + this.getId()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productId="
         + this.getProductId()
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
         + ", productType="
         + this.getProductType()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", reduceQuantity="
         + this.getReduceQuantity()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", issueStatus="
         + this.getIssueStatus()
         + ", userId="
         + this.getUserId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalSchedulingPreviewDTO)) {
         return false;
      }

      AbnormalSchedulingPreviewDTO other = (AbnormalSchedulingPreviewDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$schedulingQuantity = this.getSchedulingQuantity();
               Object other$schedulingQuantity = other.getSchedulingQuantity();
               if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                  Object this$taskQuantity = this.getTaskQuantity();
                  Object other$taskQuantity = other.getTaskQuantity();
                  if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                     Object this$reduceQuantity = this.getReduceQuantity();
                     Object other$reduceQuantity = other.getReduceQuantity();
                     if (this$reduceQuantity == null ? other$reduceQuantity == null : this$reduceQuantity.equals(other$reduceQuantity)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$issueStatus = this.getIssueStatus();
                           Object other$issueStatus = other.getIssueStatus();
                           if (this$issueStatus == null ? other$issueStatus == null : this$issueStatus.equals(other$issueStatus)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$productProcessId = this.getProductProcessId();
                                 Object other$productProcessId = other.getProductProcessId();
                                 if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
                                    Object this$factory = this.getFactory();
                                    Object other$factory = other.getFactory();
                                    if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                       Object this$workshop = this.getWorkshop();
                                       Object other$workshop = other.getWorkshop();
                                       if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                          Object this$productionLine = this.getProductionLine();
                                          Object other$productionLine = other.getProductionLine();
                                          if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
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
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$material = this.getMaterial();
                                                               Object other$material = other.getMaterial();
                                                               if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                     if (this$askCompleteTime == null
                                                                        ? other$askCompleteTime == null
                                                                        : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                        Object this$completeTime = this.getCompleteTime();
                                                                        Object other$completeTime = other.getCompleteTime();
                                                                        if (this$completeTime == null
                                                                           ? other$completeTime == null
                                                                           : this$completeTime.equals(other$completeTime)) {
                                                                           Object this$plate = this.getPlate();
                                                                           Object other$plate = other.getPlate();
                                                                           if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                              Object this$color = this.getColor();
                                                                              Object other$color = other.getColor();
                                                                              return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof AbnormalSchedulingPreviewDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $reduceQuantity = this.getReduceQuantity();
      result = result * 59 + ($reduceQuantity == null ? 43 : $reduceQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $issueStatus = this.getIssueStatus();
      result = result * 59 + ($issueStatus == null ? 43 : $issueStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
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
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   public static class AbnormalSchedulingPreviewDTOBuilder {
      private Long id;
      private FactoryDetailDO factory;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private String length;
      private Integer productType;
      private Integer schedulingQuantity;
      private Integer taskQuantity;
      private Integer reduceQuantity;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Boolean issueStatus;
      private Long userId;
      private Long productProcessId;
      private String plate;
      private String color;

      AbnormalSchedulingPreviewDTOBuilder() {
      }

      @JsonProperty("id")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factory")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("project")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("productId")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("length")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder length(final String length) {
         this.length = length;
         return this;
      }

      @JsonProperty("productType")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("taskQuantity")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("reduceQuantity")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder reduceQuantity(final Integer reduceQuantity) {
         this.reduceQuantity = reduceQuantity;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("issueStatus")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder issueStatus(final Boolean issueStatus) {
         this.issueStatus = issueStatus;
         return this;
      }

      @JsonProperty("userId")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productProcessId")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("plate")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("color")
      public AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public AbnormalSchedulingPreviewDTO build() {
         return new AbnormalSchedulingPreviewDTO(
            this.id,
            this.factory,
            this.workshop,
            this.productionLine,
            this.project,
            this.monomer,
            this.area,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.length,
            this.productType,
            this.schedulingQuantity,
            this.taskQuantity,
            this.reduceQuantity,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.issueStatus,
            this.userId,
            this.productProcessId,
            this.plate,
            this.color
         );
      }

      @Override
      public String toString() {
         return "AbnormalSchedulingPreviewDTO.AbnormalSchedulingPreviewDTOBuilder(id="
            + this.id
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productId="
            + this.productId
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
            + ", productType="
            + this.productType
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", taskQuantity="
            + this.taskQuantity
            + ", reduceQuantity="
            + this.reduceQuantity
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", issueStatus="
            + this.issueStatus
            + ", userId="
            + this.userId
            + ", productProcessId="
            + this.productProcessId
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ")";
      }
   }
}
