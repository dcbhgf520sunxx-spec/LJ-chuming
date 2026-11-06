package com.hzchum.pangu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.pangu.common.base.Entity;
import com.hzchum.pangu.common.base.Persistable;
import com.hzchum.pangu.common.base.Versionable;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeDeserializer;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseNovEntity<ID extends Serializable> implements Persistable<ID>, Versionable, Entity {
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT)
   @Column(name = "create_time", nullable = false, columnDefinition = "datetime(6) default CURRENT_TIMESTAMP(6) COMMENT '创建时间'")
   @JsonInclude(Include.NON_NULL)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime createTime;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT_UPDATE)
   @Column(name = "update_time", columnDefinition = "datetime(6) COMMENT '更新时间'")
   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime updateTime;
   @ApiModelProperty(hidden = true)
   @TableLogic(value = "0", delval = "id")
   @TableField(fill = FieldFill.INSERT)
   @Column(name = "delete_enum", nullable = false, columnDefinition = "bigint(20) default 0 COMMENT '逻辑删除'")
   @JsonIgnore
   private Long deleteEnum;
   @ApiModelProperty(hidden = true)
   @Version
   @TableField(fill = FieldFill.INSERT)
   @Column(name = "version", nullable = false, columnDefinition = "int(11) default 1 COMMENT '乐观锁'")
   @JsonIgnore
   private Integer version;

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Long getDeleteEnum() {
      return this.deleteEnum;
   }

   @Override
   public Integer getVersion() {
      return this.version;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @JsonIgnore
   public void setDeleteEnum(final Long deleteEnum) {
      this.deleteEnum = deleteEnum;
   }

   @JsonIgnore
   @Override
   public void setVersion(final Integer version) {
      this.version = version;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BaseNovEntity)) {
         return false;
      }

      BaseNovEntity<?> other = (BaseNovEntity<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$deleteEnum = this.getDeleteEnum();
      Object other$deleteEnum = other.getDeleteEnum();
      if (this$deleteEnum == null ? other$deleteEnum == null : this$deleteEnum.equals(other$deleteEnum)) {
         Object this$version = this.getVersion();
         Object other$version = other.getVersion();
         if (this$version == null ? other$version == null : this$version.equals(other$version)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$updateTime = this.getUpdateTime();
               Object other$updateTime = other.getUpdateTime();
               return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof BaseNovEntity;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $deleteEnum = this.getDeleteEnum();
      result = result * 59 + ($deleteEnum == null ? 43 : $deleteEnum.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "BaseNovEntity(createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", deleteEnum="
         + this.getDeleteEnum()
         + ", version="
         + this.getVersion()
         + ")";
   }
}
