package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MachinePartSchedulingUnProductionParam", description = "")
public class MachinePartSchedulingUnProductionDO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "needId")
   @JsonProperty("needId")
   @JSONField(name = "needId")
   private Long needId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "取消生产数量", notes = "取消生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "useId", value = "用户id", notes = "用户id")
   @JsonProperty("useId")
   @JSONField(name = "useId")
   private Long useId;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号")
   @JsonProperty("artifactSerialNumber")
   @JSONField(name = "artifactSerialNumber")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "user", value = "操作人", notes = "操作人")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;

   public static MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder builder() {
      return new MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder();
   }

   public MachinePartSchedulingUnProductionDO() {
   }

   public MachinePartSchedulingUnProductionDO(
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final Long needId,
      final Long productId,
      final Integer quantity,
      final Long useId,
      final String artifactSerialNumber,
      final String serialNumber,
      final String specification,
      final String material,
      final LocalDateTime askCompleteTime,
      final IdAndNameDO user,
      final Integer taskTypeEnum,
      final Long taskId
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.needId = needId;
      this.productId = productId;
      this.quantity = quantity;
      this.useId = useId;
      this.artifactSerialNumber = artifactSerialNumber;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.askCompleteTime = askCompleteTime;
      this.user = user;
      this.taskTypeEnum = taskTypeEnum;
      this.taskId = taskId;
   }

   public Long getId() {
      return this.id;
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

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public Long getNeedId() {
      return this.needId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUseId() {
      return this.useId;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
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

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   @JsonProperty("id")
   public MachinePartSchedulingUnProductionDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public MachinePartSchedulingUnProductionDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MachinePartSchedulingUnProductionDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public MachinePartSchedulingUnProductionDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("workshop")
   public MachinePartSchedulingUnProductionDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MachinePartSchedulingUnProductionDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MachinePartSchedulingUnProductionDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("needId")
   public MachinePartSchedulingUnProductionDO setNeedId(final Long needId) {
      this.needId = needId;
      return this;
   }

   @JsonProperty("productId")
   public MachinePartSchedulingUnProductionDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartSchedulingUnProductionDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("useId")
   public MachinePartSchedulingUnProductionDO setUseId(final Long useId) {
      this.useId = useId;
      return this;
   }

   @JsonProperty("artifactSerialNumber")
   public MachinePartSchedulingUnProductionDO setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
      return this;
   }

   @JsonProperty("serialNumber")
   public MachinePartSchedulingUnProductionDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MachinePartSchedulingUnProductionDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("material")
   public MachinePartSchedulingUnProductionDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MachinePartSchedulingUnProductionDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("user")
   public MachinePartSchedulingUnProductionDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MachinePartSchedulingUnProductionDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("taskId")
   public MachinePartSchedulingUnProductionDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartSchedulingUnProductionDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", needId="
         + this.getNeedId()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", useId="
         + this.getUseId()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", user="
         + this.getUser()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", taskId="
         + this.getTaskId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartSchedulingUnProductionDO)) {
         return false;
      }

      MachinePartSchedulingUnProductionDO other = (MachinePartSchedulingUnProductionDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$needId = this.getNeedId();
         Object other$needId = other.getNeedId();
         if (this$needId == null ? other$needId == null : this$needId.equals(other$needId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$useId = this.getUseId();
                  Object other$useId = other.getUseId();
                  if (this$useId == null ? other$useId == null : this$useId.equals(other$useId)) {
                     Object this$taskTypeEnum = this.getTaskTypeEnum();
                     Object other$taskTypeEnum = other.getTaskTypeEnum();
                     if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                        Object this$taskId = this.getTaskId();
                        Object other$taskId = other.getTaskId();
                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$area = this.getArea();
                                 Object other$area = other.getArea();
                                 if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                    Object this$workshop = this.getWorkshop();
                                    Object other$workshop = other.getWorkshop();
                                    if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                       Object this$productionLine = this.getProductionLine();
                                       Object other$productionLine = other.getProductionLine();
                                       if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                          Object this$groups = this.getGroups();
                                          Object other$groups = other.getGroups();
                                          if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
                                             Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                                             Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                                             if (this$artifactSerialNumber == null
                                                ? other$artifactSerialNumber == null
                                                : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$material = this.getMaterial();
                                                      Object other$material = other.getMaterial();
                                                      if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                         Object this$askCompleteTime = this.getAskCompleteTime();
                                                         Object other$askCompleteTime = other.getAskCompleteTime();
                                                         if (this$askCompleteTime == null
                                                            ? other$askCompleteTime == null
                                                            : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                            Object this$user = this.getUser();
                                                            Object other$user = other.getUser();
                                                            return this$user == null ? other$user == null : this$user.equals(other$user);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartSchedulingUnProductionDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $needId = this.getNeedId();
      result = result * 59 + ($needId == null ? 43 : $needId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $useId = this.getUseId();
      result = result * 59 + ($useId == null ? 43 : $useId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $user = this.getUser();
      return result * 59 + ($user == null ? 43 : $user.hashCode());
   }

   public static class MachinePartSchedulingUnProductionDOBuilder {
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private Long needId;
      private Long productId;
      private Integer quantity;
      private Long useId;
      private String artifactSerialNumber;
      private String serialNumber;
      private String specification;
      private String material;
      private LocalDateTime askCompleteTime;
      private IdAndNameDO user;
      private Integer taskTypeEnum;
      private Long taskId;

      MachinePartSchedulingUnProductionDOBuilder() {
      }

      @JsonProperty("id")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("workshop")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("needId")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder needId(final Long needId) {
         this.needId = needId;
         return this;
      }

      @JsonProperty("productId")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("useId")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder useId(final Long useId) {
         this.useId = useId;
         return this;
      }

      @JsonProperty("artifactSerialNumber")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder artifactSerialNumber(final String artifactSerialNumber) {
         this.artifactSerialNumber = artifactSerialNumber;
         return this;
      }

      @JsonProperty("serialNumber")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("material")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("user")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("taskId")
      public MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MachinePartSchedulingUnProductionDO build() {
         return new MachinePartSchedulingUnProductionDO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.workshop,
            this.productionLine,
            this.groups,
            this.needId,
            this.productId,
            this.quantity,
            this.useId,
            this.artifactSerialNumber,
            this.serialNumber,
            this.specification,
            this.material,
            this.askCompleteTime,
            this.user,
            this.taskTypeEnum,
            this.taskId
         );
      }

      @Override
      public String toString() {
         return "MachinePartSchedulingUnProductionDO.MachinePartSchedulingUnProductionDOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", needId="
            + this.needId
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", useId="
            + this.useId
            + ", artifactSerialNumber="
            + this.artifactSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", user="
            + this.user
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", taskId="
            + this.taskId
            + ")";
      }
   }
}
