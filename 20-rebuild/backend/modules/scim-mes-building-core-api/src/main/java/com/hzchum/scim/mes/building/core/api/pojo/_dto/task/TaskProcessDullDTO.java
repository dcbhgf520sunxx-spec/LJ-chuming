package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.ProcessListDetailDTO;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "TaskProcessDullDTO", description = "工序呆滞")
public class TaskProcessDullDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "workshop", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private ProcessListDetailDTO process;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groupList", notes = "生产组")
   @JsonProperty("groupList")
   @JSONField(name = "groupList")
   private List<NameInfo> groupList;
   @ApiModelProperty(name = "team", value = "班组", notes = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDTO team;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "unQuantity", notes = "未完成数量")
   @JsonProperty("unQuantity")
   @JSONField(name = "unQuantity")
   private Integer unQuantity;
   @ApiModelProperty(name = "quantity", notes = "总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;

   public static TaskProcessDullDTO.TaskProcessDullDTOBuilder builder() {
      return new TaskProcessDullDTO.TaskProcessDullDTOBuilder();
   }

   public TaskProcessDullDTO() {
   }

   public TaskProcessDullDTO(
      final ProjectDetailDO project,
      final WorkshopDetailDO workshop,
      final LocalDateTime completeTime,
      final ProcessListDetailDTO process,
      final Integer productType,
      final ProductionLineDetailDO productionLine,
      final List<NameInfo> groupList,
      final IdAndNameDTO team,
      final Integer completeQuantity,
      final Integer unQuantity,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight
   ) {
      this.project = project;
      this.workshop = workshop;
      this.completeTime = completeTime;
      this.process = process;
      this.productType = productType;
      this.productionLine = productionLine;
      this.groupList = groupList;
      this.team = team;
      this.completeQuantity = completeQuantity;
      this.unQuantity = unQuantity;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public ProcessListDetailDTO getProcess() {
      return this.process;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public List<NameInfo> getGroupList() {
      return this.groupList;
   }

   public IdAndNameDTO getTeam() {
      return this.team;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getUnQuantity() {
      return this.unQuantity;
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

   @JsonProperty("project")
   public TaskProcessDullDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshop")
   public TaskProcessDullDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("completeTime")
   public TaskProcessDullDTO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("process")
   public TaskProcessDullDTO setProcess(final ProcessListDetailDTO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("productType")
   public TaskProcessDullDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskProcessDullDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groupList")
   public TaskProcessDullDTO setGroupList(final List<NameInfo> groupList) {
      this.groupList = groupList;
      return this;
   }

   @JsonProperty("team")
   public TaskProcessDullDTO setTeam(final IdAndNameDTO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskProcessDullDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("unQuantity")
   public TaskProcessDullDTO setUnQuantity(final Integer unQuantity) {
      this.unQuantity = unQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public TaskProcessDullDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TaskProcessDullDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TaskProcessDullDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProcessDullDTO(project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", completeTime="
         + this.getCompleteTime()
         + ", process="
         + this.getProcess()
         + ", productType="
         + this.getProductType()
         + ", productionLine="
         + this.getProductionLine()
         + ", groupList="
         + this.getGroupList()
         + ", team="
         + this.getTeam()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", unQuantity="
         + this.getUnQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProcessDullDTO)) {
         return false;
      }

      TaskProcessDullDTO other = (TaskProcessDullDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$unQuantity = this.getUnQuantity();
            Object other$unQuantity = other.getUnQuantity();
            if (this$unQuantity == null ? other$unQuantity == null : this$unQuantity.equals(other$unQuantity)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$workshop = this.getWorkshop();
                     Object other$workshop = other.getWorkshop();
                     if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                        Object this$completeTime = this.getCompleteTime();
                        Object other$completeTime = other.getCompleteTime();
                        if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                           Object this$process = this.getProcess();
                           Object other$process = other.getProcess();
                           if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$groupList = this.getGroupList();
                                 Object other$groupList = other.getGroupList();
                                 if (this$groupList == null ? other$groupList == null : this$groupList.equals(other$groupList)) {
                                    Object this$team = this.getTeam();
                                    Object other$team = other.getTeam();
                                    if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                                       Object this$totalNetWeight = this.getTotalNetWeight();
                                       Object other$totalNetWeight = other.getTotalNetWeight();
                                       if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                          Object this$totalGrossWeight = this.getTotalGrossWeight();
                                          Object other$totalGrossWeight = other.getTotalGrossWeight();
                                          return this$totalGrossWeight == null
                                             ? other$totalGrossWeight == null
                                             : this$totalGrossWeight.equals(other$totalGrossWeight);
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
      return other instanceof TaskProcessDullDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $unQuantity = this.getUnQuantity();
      result = result * 59 + ($unQuantity == null ? 43 : $unQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groupList = this.getGroupList();
      result = result * 59 + ($groupList == null ? 43 : $groupList.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   public static class TaskProcessDullDTOBuilder {
      private ProjectDetailDO project;
      private WorkshopDetailDO workshop;
      private LocalDateTime completeTime;
      private ProcessListDetailDTO process;
      private Integer productType;
      private ProductionLineDetailDO productionLine;
      private List<NameInfo> groupList;
      private IdAndNameDTO team;
      private Integer completeQuantity;
      private Integer unQuantity;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      TaskProcessDullDTOBuilder() {
      }

      @JsonProperty("project")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshop")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("completeTime")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("process")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder process(final ProcessListDetailDTO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("productType")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groupList")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder groupList(final List<NameInfo> groupList) {
         this.groupList = groupList;
         return this;
      }

      @JsonProperty("team")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder team(final IdAndNameDTO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("unQuantity")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder unQuantity(final Integer unQuantity) {
         this.unQuantity = unQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TaskProcessDullDTO build() {
         return new TaskProcessDullDTO(
            this.project,
            this.workshop,
            this.completeTime,
            this.process,
            this.productType,
            this.productionLine,
            this.groupList,
            this.team,
            this.completeQuantity,
            this.unQuantity,
            this.quantity,
            this.totalNetWeight,
            this.totalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "TaskProcessDullDTO.TaskProcessDullDTOBuilder(project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", completeTime="
            + this.completeTime
            + ", process="
            + this.process
            + ", productType="
            + this.productType
            + ", productionLine="
            + this.productionLine
            + ", groupList="
            + this.groupList
            + ", team="
            + this.team
            + ", completeQuantity="
            + this.completeQuantity
            + ", unQuantity="
            + this.unQuantity
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
