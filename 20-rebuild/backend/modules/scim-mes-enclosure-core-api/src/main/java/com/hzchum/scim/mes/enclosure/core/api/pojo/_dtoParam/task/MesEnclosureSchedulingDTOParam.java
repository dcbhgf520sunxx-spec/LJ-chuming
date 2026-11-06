package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.IdAndQuantityDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureSchedulingDOParam对象", description = "")
public class MesEnclosureSchedulingDTOParam {
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @NotNull(message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @NotNull(message = "生产线不能为空")
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @NotNull(message = "班组不能为空")
   private Long teamId;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @NotNull(message = "要求完成日期不能为空")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "status", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Boolean status;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "category", notes = "类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "dictionaryId", value = "字典表id")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   private Long dictionaryId;
   @ApiModelProperty(name = "schedulings", notes = "排产信息")
   @JsonProperty("schedulings")
   @JSONField(name = "schedulings")
   private List<IdAndQuantityDTO> schedulings;

   public static MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder builder() {
      return new MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder();
   }

   public MesEnclosureSchedulingDTOParam() {
   }

   public MesEnclosureSchedulingDTOParam(
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long teamId,
      final Long projectId,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Boolean status,
      final Long userId,
      final Integer category,
      final Long dictionaryId,
      final List<IdAndQuantityDTO> schedulings
   ) {
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.projectId = projectId;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.status = status;
      this.userId = userId;
      this.category = category;
      this.dictionaryId = dictionaryId;
      this.schedulings = schedulings;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public List<IdAndQuantityDTO> getSchedulings() {
      return this.schedulings;
   }

   @JsonProperty("factoryId")
   public MesEnclosureSchedulingDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureSchedulingDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureSchedulingDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureSchedulingDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureSchedulingDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureSchedulingDTOParam setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesEnclosureSchedulingDTOParam setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureSchedulingDTOParam setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureSchedulingDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("category")
   public MesEnclosureSchedulingDTOParam setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("dictionaryId")
   public MesEnclosureSchedulingDTOParam setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @JsonProperty("schedulings")
   public MesEnclosureSchedulingDTOParam setSchedulings(final List<IdAndQuantityDTO> schedulings) {
      this.schedulings = schedulings;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSchedulingDTOParam)) {
         return false;
      }

      MesEnclosureSchedulingDTOParam other = (MesEnclosureSchedulingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$productionLineId = this.getProductionLineId();
            Object other$productionLineId = other.getProductionLineId();
            if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$category = this.getCategory();
                           Object other$category = other.getCategory();
                           if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                              Object this$dictionaryId = this.getDictionaryId();
                              Object other$dictionaryId = other.getDictionaryId();
                              if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                 Object this$askCompleteTime = this.getAskCompleteTime();
                                 Object other$askCompleteTime = other.getAskCompleteTime();
                                 if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
                                    Object this$completeTime = this.getCompleteTime();
                                    Object other$completeTime = other.getCompleteTime();
                                    if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
                                       Object this$schedulings = this.getSchedulings();
                                       Object other$schedulings = other.getSchedulings();
                                       return this$schedulings == null ? other$schedulings == null : this$schedulings.equals(other$schedulings);
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
      return other instanceof MesEnclosureSchedulingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $schedulings = this.getSchedulings();
      return result * 59 + ($schedulings == null ? 43 : $schedulings.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureSchedulingDTOParam(factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", projectId="
         + this.getProjectId()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ", category="
         + this.getCategory()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", schedulings="
         + this.getSchedulings()
         + ")";
   }

   public static class MesEnclosureSchedulingDTOParamBuilder {
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long teamId;
      private Long projectId;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Boolean status;
      private Long userId;
      private Integer category;
      private Long dictionaryId;
      private List<IdAndQuantityDTO> schedulings;

      MesEnclosureSchedulingDTOParamBuilder() {
      }

      @JsonProperty("factoryId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("category")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("dictionaryId")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      @JsonProperty("schedulings")
      public MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder schedulings(final List<IdAndQuantityDTO> schedulings) {
         this.schedulings = schedulings;
         return this;
      }

      public MesEnclosureSchedulingDTOParam build() {
         return new MesEnclosureSchedulingDTOParam(
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.teamId,
            this.projectId,
            this.askCompleteTime,
            this.completeTime,
            this.status,
            this.userId,
            this.category,
            this.dictionaryId,
            this.schedulings
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureSchedulingDTOParam.MesEnclosureSchedulingDTOParamBuilder(factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", projectId="
            + this.projectId
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ", category="
            + this.category
            + ", dictionaryId="
            + this.dictionaryId
            + ", schedulings="
            + this.schedulings
            + ")";
      }
   }
}
