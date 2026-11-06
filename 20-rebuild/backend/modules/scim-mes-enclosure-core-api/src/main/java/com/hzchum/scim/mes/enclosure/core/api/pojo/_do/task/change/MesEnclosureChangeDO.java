package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.change;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureChangeDO", description = "零件工单 ")
public class MesEnclosureChangeDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "orderNumber", notes = "任务编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "user", notes = "用户信息")
   @JsonProperty("user")
   @JSONField(name = "user")
   private IdAndNameDO user;
   @ApiModelProperty(name = "createTime", value = "协同时间", notes = "协同时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;

   public static MesEnclosureChangeDO.MesEnclosureChangeDOBuilder builder() {
      return new MesEnclosureChangeDO.MesEnclosureChangeDOBuilder();
   }

   public MesEnclosureChangeDO() {
   }

   public MesEnclosureChangeDO(
      final Long id,
      final String orderNumber,
      final IdAndNameDO user,
      final LocalDateTime createTime,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight,
      final Integer taskTypeEnum,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups
   ) {
      this.id = id;
      this.orderNumber = orderNumber;
      this.user = user;
      this.createTime = createTime;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.taskTypeEnum = taskTypeEnum;
      this.project = project;
      this.monomer = monomer;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
   }

   public Long getId() {
      return this.id;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public IdAndNameDO getUser() {
      return this.user;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
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

   @JsonProperty("id")
   public MesEnclosureChangeDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesEnclosureChangeDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("user")
   public MesEnclosureChangeDO setUser(final IdAndNameDO user) {
      this.user = user;
      return this;
   }

   @JsonProperty("createTime")
   public MesEnclosureChangeDO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureChangeDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureChangeDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureChangeDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesEnclosureChangeDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("project")
   public MesEnclosureChangeDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public MesEnclosureChangeDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureChangeDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureChangeDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureChangeDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureChangeDO(id="
         + this.getId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", user="
         + this.getUser()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureChangeDO)) {
         return false;
      }

      MesEnclosureChangeDO other = (MesEnclosureChangeDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$taskTypeEnum = this.getTaskTypeEnum();
            Object other$taskTypeEnum = other.getTaskTypeEnum();
            if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                  Object this$user = this.getUser();
                  Object other$user = other.getUser();
                  if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$totalNetWeight = this.getTotalNetWeight();
                        Object other$totalNetWeight = other.getTotalNetWeight();
                        if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                           Object this$totalGrossWeight = this.getTotalGrossWeight();
                           Object other$totalGrossWeight = other.getTotalGrossWeight();
                           if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                              Object this$project = this.getProject();
                              Object other$project = other.getProject();
                              if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$workshop = this.getWorkshop();
                                    Object other$workshop = other.getWorkshop();
                                    if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                       Object this$productionLine = this.getProductionLine();
                                       Object other$productionLine = other.getProductionLine();
                                       if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                          Object this$groups = this.getGroups();
                                          Object other$groups = other.getGroups();
                                          return this$groups == null ? other$groups == null : this$groups.equals(other$groups);
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
      return other instanceof MesEnclosureChangeDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      return result * 59 + ($groups == null ? 43 : $groups.hashCode());
   }

   public static class MesEnclosureChangeDOBuilder {
      private Long id;
      private String orderNumber;
      private IdAndNameDO user;
      private LocalDateTime createTime;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;
      private Integer taskTypeEnum;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;

      MesEnclosureChangeDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("user")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder user(final IdAndNameDO user) {
         this.user = user;
         return this;
      }

      @JsonProperty("createTime")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("project")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureChangeDO.MesEnclosureChangeDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      public MesEnclosureChangeDO build() {
         return new MesEnclosureChangeDO(
            this.id,
            this.orderNumber,
            this.user,
            this.createTime,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight,
            this.taskTypeEnum,
            this.project,
            this.monomer,
            this.workshop,
            this.productionLine,
            this.groups
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureChangeDO.MesEnclosureChangeDOBuilder(id="
            + this.id
            + ", orderNumber="
            + this.orderNumber
            + ", user="
            + this.user
            + ", createTime="
            + this.createTime
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ")";
      }
   }
}
