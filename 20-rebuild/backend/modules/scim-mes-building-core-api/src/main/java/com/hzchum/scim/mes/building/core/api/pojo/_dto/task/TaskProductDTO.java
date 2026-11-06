package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "TaskProductDTO", description = "任务跟踪列表")
public class TaskProductDTO {
   @ApiModelProperty(name = "workShopId", notes = "工厂id")
   @JsonProperty("workShopId")
   @JSONField(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "workShopName", value = "工厂名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "id", notes = "产线id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "产线名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "user", value = "生产班组长")
   @JsonProperty("user")
   @JSONField(name = "user")
   private NameInfo user;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskType", notes = "产品类型")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "taskMete", notes = "任务量")
   @JsonProperty("taskMete")
   @JSONField(name = "taskMete")
   private BigDecimal taskMete;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务量(净重)")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务量(毛重)")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeMete", notes = "完成量")
   @JsonProperty("completeMete")
   @JSONField(name = "completeMete")
   private BigDecimal completeMete;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成量(净重)")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成量(毛重)")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "rate", notes = "完成率")
   @JsonProperty("rate")
   @JSONField(name = "rate")
   private BigDecimal rate;
   @ApiModelProperty(name = "startDate", notes = "开始时间")
   @JsonProperty("startDate")
   @JSONField(name = "startDate")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束时间")
   @JsonProperty("endDate")
   @JSONField(name = "endDate")
   private LocalDateTime endDate;

   public static TaskProductDTO.TaskProductDTOBuilder builder() {
      return new TaskProductDTO.TaskProductDTOBuilder();
   }

   public TaskProductDTO() {
   }

   public TaskProductDTO(
      final Long workShopId,
      final String workShopName,
      final Long id,
      final String name,
      final NameInfo user,
      final Integer taskQuantity,
      final Integer taskType,
      final BigDecimal taskMete,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final Integer completeQuantity,
      final BigDecimal completeMete,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal rate,
      final LocalDateTime startDate,
      final LocalDateTime endDate
   ) {
      this.workShopId = workShopId;
      this.workShopName = workShopName;
      this.id = id;
      this.name = name;
      this.user = user;
      this.taskQuantity = taskQuantity;
      this.taskType = taskType;
      this.taskMete = taskMete;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.completeQuantity = completeQuantity;
      this.completeMete = completeMete;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.rate = rate;
      this.startDate = startDate;
      this.endDate = endDate;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getRate() {
      return this.rate;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   @JsonProperty("workShopId")
   public TaskProductDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("workShopName")
   public TaskProductDTO setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
      return this;
   }

   @JsonProperty("id")
   public TaskProductDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TaskProductDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("user")
   public TaskProductDTO setUser(final NameInfo user) {
      this.user = user;
      return this;
   }

   @JsonProperty("taskQuantity")
   public TaskProductDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskType")
   public TaskProductDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("taskMete")
   public TaskProductDTO setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public TaskProductDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public TaskProductDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public TaskProductDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeMete")
   public TaskProductDTO setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public TaskProductDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public TaskProductDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("rate")
   public TaskProductDTO setRate(final BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @JsonProperty("startDate")
   public TaskProductDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   @JsonProperty("endDate")
   public TaskProductDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProductDTO(workShopId="
         + this.getWorkShopId()
         + ", workShopName="
         + this.getWorkShopName()
         + ", id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", user="
         + this.getUser()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskType="
         + this.getTaskType()
         + ", taskMete="
         + this.getTaskMete()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", rate="
         + this.getRate()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProductDTO)) {
         return false;
      }

      TaskProductDTO other = (TaskProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workShopId = this.getWorkShopId();
      Object other$workShopId = other.getWorkShopId();
      if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$taskType = this.getTaskType();
               Object other$taskType = other.getTaskType();
               if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$workShopName = this.getWorkShopName();
                     Object other$workShopName = other.getWorkShopName();
                     if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$user = this.getUser();
                           Object other$user = other.getUser();
                           if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                              Object this$taskMete = this.getTaskMete();
                              Object other$taskMete = other.getTaskMete();
                              if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
                                 Object this$taskNetWeight = this.getTaskNetWeight();
                                 Object other$taskNetWeight = other.getTaskNetWeight();
                                 if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                                    Object this$taskGrossWeight = this.getTaskGrossWeight();
                                    Object other$taskGrossWeight = other.getTaskGrossWeight();
                                    if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                       Object this$completeMete = this.getCompleteMete();
                                       Object other$completeMete = other.getCompleteMete();
                                       if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)) {
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
                                                Object this$rate = this.getRate();
                                                Object other$rate = other.getRate();
                                                if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                                                   Object this$startDate = this.getStartDate();
                                                   Object other$startDate = other.getStartDate();
                                                   if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                      Object this$endDate = this.getEndDate();
                                                      Object other$endDate = other.getEndDate();
                                                      return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof TaskProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   public static class TaskProductDTOBuilder {
      private Long workShopId;
      private String workShopName;
      private Long id;
      private String name;
      private NameInfo user;
      private Integer taskQuantity;
      private Integer taskType;
      private BigDecimal taskMete;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private Integer completeQuantity;
      private BigDecimal completeMete;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal rate;
      private LocalDateTime startDate;
      private LocalDateTime endDate;

      TaskProductDTOBuilder() {
      }

      @JsonProperty("workShopId")
      public TaskProductDTO.TaskProductDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("workShopName")
      public TaskProductDTO.TaskProductDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("id")
      public TaskProductDTO.TaskProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TaskProductDTO.TaskProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("user")
      public TaskProductDTO.TaskProductDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      @JsonProperty("taskQuantity")
      public TaskProductDTO.TaskProductDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskType")
      public TaskProductDTO.TaskProductDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      @JsonProperty("taskMete")
      public TaskProductDTO.TaskProductDTOBuilder taskMete(final BigDecimal taskMete) {
         this.taskMete = taskMete;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public TaskProductDTO.TaskProductDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public TaskProductDTO.TaskProductDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public TaskProductDTO.TaskProductDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeMete")
      public TaskProductDTO.TaskProductDTOBuilder completeMete(final BigDecimal completeMete) {
         this.completeMete = completeMete;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public TaskProductDTO.TaskProductDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public TaskProductDTO.TaskProductDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("rate")
      public TaskProductDTO.TaskProductDTOBuilder rate(final BigDecimal rate) {
         this.rate = rate;
         return this;
      }

      @JsonProperty("startDate")
      public TaskProductDTO.TaskProductDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      @JsonProperty("endDate")
      public TaskProductDTO.TaskProductDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public TaskProductDTO build() {
         return new TaskProductDTO(
            this.workShopId,
            this.workShopName,
            this.id,
            this.name,
            this.user,
            this.taskQuantity,
            this.taskType,
            this.taskMete,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.completeQuantity,
            this.completeMete,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.rate,
            this.startDate,
            this.endDate
         );
      }

      @Override
      public String toString() {
         return "TaskProductDTO.TaskProductDTOBuilder(workShopId="
            + this.workShopId
            + ", workShopName="
            + this.workShopName
            + ", id="
            + this.id
            + ", name="
            + this.name
            + ", user="
            + this.user
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskType="
            + this.taskType
            + ", taskMete="
            + this.taskMete
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeMete="
            + this.completeMete
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", rate="
            + this.rate
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
