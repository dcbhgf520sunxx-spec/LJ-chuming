package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbonrmalTaskDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AbonrmalTaskDTO", description = "异常处理页面返回类")
public class AbnormalTaskDTO {
   @ApiModelProperty(name = "abnormalTaskList", notes = "排产详情")
   @JsonProperty("abnormalTaskList")
   @JSONField(name = "abnormalTaskList")
   private List<AbonrmalTaskDO> abnormalTaskList;
   @ApiModelProperty(name = "handleQuantity", notes = "可操作数")
   @JsonProperty("handleQuantity")
   @JSONField(name = "handleQuantity")
   private Integer handleQuantity;

   public static AbnormalTaskDTO.AbnormalTaskDTOBuilder builder() {
      return new AbnormalTaskDTO.AbnormalTaskDTOBuilder();
   }

   public AbnormalTaskDTO() {
   }

   public AbnormalTaskDTO(final List<AbonrmalTaskDO> abnormalTaskList, final Integer handleQuantity) {
      this.abnormalTaskList = abnormalTaskList;
      this.handleQuantity = handleQuantity;
   }

   public List<AbonrmalTaskDO> getAbnormalTaskList() {
      return this.abnormalTaskList;
   }

   public Integer getHandleQuantity() {
      return this.handleQuantity;
   }

   @JsonProperty("abnormalTaskList")
   public AbnormalTaskDTO setAbnormalTaskList(final List<AbonrmalTaskDO> abnormalTaskList) {
      this.abnormalTaskList = abnormalTaskList;
      return this;
   }

   @JsonProperty("handleQuantity")
   public AbnormalTaskDTO setHandleQuantity(final Integer handleQuantity) {
      this.handleQuantity = handleQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalTaskDTO(abnormalTaskList=" + this.getAbnormalTaskList() + ", handleQuantity=" + this.getHandleQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalTaskDTO)) {
         return false;
      } else {
         AbnormalTaskDTO other = (AbnormalTaskDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$handleQuantity = this.getHandleQuantity();
            Object other$handleQuantity = other.getHandleQuantity();
            if (this$handleQuantity == null ? other$handleQuantity == null : this$handleQuantity.equals(other$handleQuantity)) {
               Object this$abnormalTaskList = this.getAbnormalTaskList();
               Object other$abnormalTaskList = other.getAbnormalTaskList();
               return this$abnormalTaskList == null ? other$abnormalTaskList == null : this$abnormalTaskList.equals(other$abnormalTaskList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $handleQuantity = this.getHandleQuantity();
      result = result * 59 + ($handleQuantity == null ? 43 : $handleQuantity.hashCode());
      Object $abnormalTaskList = this.getAbnormalTaskList();
      return result * 59 + ($abnormalTaskList == null ? 43 : $abnormalTaskList.hashCode());
   }

   public static class AbnormalTaskDTOBuilder {
      private List<AbonrmalTaskDO> abnormalTaskList;
      private Integer handleQuantity;

      AbnormalTaskDTOBuilder() {
      }

      @JsonProperty("abnormalTaskList")
      public AbnormalTaskDTO.AbnormalTaskDTOBuilder abnormalTaskList(final List<AbonrmalTaskDO> abnormalTaskList) {
         this.abnormalTaskList = abnormalTaskList;
         return this;
      }

      @JsonProperty("handleQuantity")
      public AbnormalTaskDTO.AbnormalTaskDTOBuilder handleQuantity(final Integer handleQuantity) {
         this.handleQuantity = handleQuantity;
         return this;
      }

      public AbnormalTaskDTO build() {
         return new AbnormalTaskDTO(this.abnormalTaskList, this.handleQuantity);
      }

      @Override
      public String toString() {
         return "AbnormalTaskDTO.AbnormalTaskDTOBuilder(abnormalTaskList=" + this.abnormalTaskList + ", handleQuantity=" + this.handleQuantity + ")";
      }
   }
}
