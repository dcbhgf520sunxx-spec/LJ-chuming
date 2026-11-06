package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechDataLog对象", description = "技术资料日志表 ")
@Entity
@TableName("tech_data_log")
@Table(name = "tech_data_log")
public class TechDataLog extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "operationType", value = "操作类型 1导入 2替换 4删除")
   @JsonProperty("operationType")
   @JSONField(name = "operationType")
   @TableField("operation_type")
   @Column(name = "operation_type")
   private Integer operationType;
   @ApiModelProperty(name = "userId", value = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名字")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注内容")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;

   public static TechDataLog.TechDataLogBuilder builder() {
      return new TechDataLog.TechDataLogBuilder();
   }

   public TechDataLog() {
   }

   public TechDataLog(final Long id, final Integer operationType, final Long userId, final String userName, final String remark) {
      this.id = id;
      this.operationType = operationType;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
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

   @JsonProperty("id")
   public TechDataLog setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("operationType")
   public TechDataLog setOperationType(final Integer operationType) {
      this.operationType = operationType;
      return this;
   }

   @JsonProperty("userId")
   public TechDataLog setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public TechDataLog setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("remark")
   public TechDataLog setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechDataLog(id="
         + this.getId()
         + ", operationType="
         + this.getOperationType()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechDataLog)) {
         return false;
      }

      TechDataLog other = (TechDataLog)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechDataLog;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationType = this.getOperationType();
      result = result * 59 + ($operationType == null ? 43 : $operationType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechDataLogBuilder {
      private Long id;
      private Integer operationType;
      private Long userId;
      private String userName;
      private String remark;

      TechDataLogBuilder() {
      }

      @JsonProperty("id")
      public TechDataLog.TechDataLogBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("operationType")
      public TechDataLog.TechDataLogBuilder operationType(final Integer operationType) {
         this.operationType = operationType;
         return this;
      }

      @JsonProperty("userId")
      public TechDataLog.TechDataLogBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public TechDataLog.TechDataLogBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("remark")
      public TechDataLog.TechDataLogBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechDataLog build() {
         return new TechDataLog(this.id, this.operationType, this.userId, this.userName, this.remark);
      }

      @Override
      public String toString() {
         return "TechDataLog.TechDataLogBuilder(id="
            + this.id
            + ", operationType="
            + this.operationType
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
