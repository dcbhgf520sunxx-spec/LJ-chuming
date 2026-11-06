package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "科目配置", description = "")
@TableName("subject_config")
@Table(name = "subject_config")
public class SubjectConfig implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "subjectId", value = "科目id")
   @JsonProperty("subjectId")
   @JSONField(name = "subjectId")
   @TableField("subject_id")
   @Column(name = "subject_id")
   private Long subjectId;
   @ApiModelProperty(name = "code", value = "代号")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(64) default ''")
   private String code;
   @ApiModelProperty(name = "number", value = "流水号(位数)")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int default 1")
   private Integer number;
   @ApiModelProperty(name = "UUID", value = "系统唯一id")
   @JsonProperty("UUID")
   @JSONField(name = "UUID")
   @TableField("UUID")
   @Column(name = "UUID")
   private String UUID;

   public static SubjectConfig.SubjectConfigBuilder builder() {
      return new SubjectConfig.SubjectConfigBuilder();
   }

   public SubjectConfig() {
   }

   public SubjectConfig(final Long id, final Long subjectId, final String code, final Integer number, final String UUID) {
      this.id = id;
      this.subjectId = subjectId;
      this.code = code;
      this.number = number;
      this.UUID = UUID;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSubjectId() {
      return this.subjectId;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getUUID() {
      return this.UUID;
   }

   @JsonProperty("id")
   public SubjectConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("subjectId")
   public SubjectConfig setSubjectId(final Long subjectId) {
      this.subjectId = subjectId;
      return this;
   }

   @JsonProperty("code")
   public SubjectConfig setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("number")
   public SubjectConfig setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("UUID")
   public SubjectConfig setUUID(final String UUID) {
      this.UUID = UUID;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubjectConfig)) {
         return false;
      }

      SubjectConfig other = (SubjectConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$subjectId = this.getSubjectId();
         Object other$subjectId = other.getSubjectId();
         if (this$subjectId == null ? other$subjectId == null : this$subjectId.equals(other$subjectId)) {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$code = this.getCode();
               Object other$code = other.getCode();
               if (this$code == null ? other$code == null : this$code.equals(other$code)) {
                  Object this$UUID = this.getUUID();
                  Object other$UUID = other.getUUID();
                  return this$UUID == null ? other$UUID == null : this$UUID.equals(other$UUID);
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
      return other instanceof SubjectConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $subjectId = this.getSubjectId();
      result = result * 59 + ($subjectId == null ? 43 : $subjectId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $UUID = this.getUUID();
      return result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
   }

   @Override
   public String toString() {
      return "SubjectConfig(id="
         + this.getId()
         + ", subjectId="
         + this.getSubjectId()
         + ", code="
         + this.getCode()
         + ", number="
         + this.getNumber()
         + ", UUID="
         + this.getUUID()
         + ")";
   }

   public static class SubjectConfigBuilder {
      private Long id;
      private Long subjectId;
      private String code;
      private Integer number;
      private String UUID;

      SubjectConfigBuilder() {
      }

      @JsonProperty("id")
      public SubjectConfig.SubjectConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("subjectId")
      public SubjectConfig.SubjectConfigBuilder subjectId(final Long subjectId) {
         this.subjectId = subjectId;
         return this;
      }

      @JsonProperty("code")
      public SubjectConfig.SubjectConfigBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("number")
      public SubjectConfig.SubjectConfigBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("UUID")
      public SubjectConfig.SubjectConfigBuilder UUID(final String UUID) {
         this.UUID = UUID;
         return this;
      }

      public SubjectConfig build() {
         return new SubjectConfig(this.id, this.subjectId, this.code, this.number, this.UUID);
      }

      @Override
      public String toString() {
         return "SubjectConfig.SubjectConfigBuilder(id="
            + this.id
            + ", subjectId="
            + this.subjectId
            + ", code="
            + this.code
            + ", number="
            + this.number
            + ", UUID="
            + this.UUID
            + ")";
      }
   }
}
