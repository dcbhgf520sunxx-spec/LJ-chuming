package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("技术资料日志响应类 ")
public class TechDataLogDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "operationType", value = "操作类型 1导入 2替换 4删除")
   private Integer operationType;
   @ApiModelProperty(name = "userId", value = "操作人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名字")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注内容")
   private String remark;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;

   public static TechDataLogDTO.TechDataLogDTOBuilder builder() {
      return new TechDataLogDTO.TechDataLogDTOBuilder();
   }

   public TechDataLogDTO() {
   }

   public TechDataLogDTO(
      final Long id, final Integer operationType, final Long userId, final String userName, final String remark, final LocalDateTime createTime
   ) {
      this.id = id;
      this.operationType = operationType;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getOperationType() {
      return this.operationType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOperationType(final Integer operationType) {
      this.operationType = operationType;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechDataLogDTO)) {
         return false;
      }

      TechDataLogDTO other = (TechDataLogDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$operationType = this.getOperationType();
         Object other$operationType = other.getOperationType();
         if (this$operationType == null ? other$operationType == null : this$operationType.equals(other$operationType)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof TechDataLogDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationType = this.getOperationType();
      result = result * 59 + ($operationType == null ? 43 : $operationType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "TechDataLogDTO(id="
         + this.getId()
         + ", operationType="
         + this.getOperationType()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class TechDataLogDTOBuilder {
      private Long id;
      private Integer operationType;
      private Long userId;
      private String userName;
      private String remark;
      private LocalDateTime createTime;

      TechDataLogDTOBuilder() {
      }

      public TechDataLogDTO.TechDataLogDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechDataLogDTO.TechDataLogDTOBuilder operationType(final Integer operationType) {
         this.operationType = operationType;
         return this;
      }

      public TechDataLogDTO.TechDataLogDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechDataLogDTO.TechDataLogDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechDataLogDTO.TechDataLogDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechDataLogDTO.TechDataLogDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public TechDataLogDTO build() {
         return new TechDataLogDTO(this.id, this.operationType, this.userId, this.userName, this.remark, this.createTime);
      }

      @Override
      public String toString() {
         return "TechDataLogDTO.TechDataLogDTOBuilder(id="
            + this.id
            + ", operationType="
            + this.operationType
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
