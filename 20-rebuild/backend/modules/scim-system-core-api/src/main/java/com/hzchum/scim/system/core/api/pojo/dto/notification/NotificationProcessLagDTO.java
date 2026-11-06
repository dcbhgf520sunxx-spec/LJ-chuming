package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "NotificationProcessLagDTO", description = "工序滞后数据")
public class NotificationProcessLagDTO {
   @ApiModelProperty(name = "createTime", value = "消息创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "dataId", value = "数据id")
   private Long dataId;

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public NotificationProcessLagDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public NotificationProcessLagDTO setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   @Override
   public String toString() {
      return "NotificationProcessLagDTO(createTime=" + this.getCreateTime() + ", dataId=" + this.getDataId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof NotificationProcessLagDTO)) {
         return false;
      } else {
         NotificationProcessLagDTO other = (NotificationProcessLagDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$dataId = this.getDataId();
            Object other$dataId = other.getDataId();
            if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof NotificationProcessLagDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }
}
