package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "CutTaskPart对象", description = "")
@Entity
@TableName("cut_task_part")
@Table(name = "cut_task_part")
public class CutTaskPart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cutTaskId")
   @JsonProperty("cutTaskId")
   @JSONField(name = "cutTaskId")
   @TableField("cut_task_id")
   @Column(name = "cut_task_id", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String cutTaskId;
   @ApiModelProperty(name = "partId")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   @TableField("part_id")
   @Column(name = "part_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long partId;
   @ApiModelProperty(name = "state")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state", columnDefinition = "varchar(255) default '0' COMMENT ''", nullable = true)
   private String state;

   public static CutTaskPart.CutTaskPartBuilder builder() {
      return new CutTaskPart.CutTaskPartBuilder();
   }

   public CutTaskPart() {
   }

   public CutTaskPart(final Long id, final String cutTaskId, final Long partId, final String state) {
      this.id = id;
      this.cutTaskId = cutTaskId;
      this.partId = partId;
      this.state = state;
   }

   public Long getId() {
      return this.id;
   }

   public String getCutTaskId() {
      return this.cutTaskId;
   }

   public Long getPartId() {
      return this.partId;
   }

   public String getState() {
      return this.state;
   }

   @JsonProperty("id")
   public CutTaskPart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cutTaskId")
   public CutTaskPart setCutTaskId(final String cutTaskId) {
      this.cutTaskId = cutTaskId;
      return this;
   }

   @JsonProperty("partId")
   public CutTaskPart setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("state")
   public CutTaskPart setState(final String state) {
      this.state = state;
      return this;
   }

   @Override
   public String toString() {
      return "CutTaskPart(id=" + this.getId() + ", cutTaskId=" + this.getCutTaskId() + ", partId=" + this.getPartId() + ", state=" + this.getState() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutTaskPart)) {
         return false;
      }

      CutTaskPart other = (CutTaskPart)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partId = this.getPartId();
         Object other$partId = other.getPartId();
         if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
            Object this$cutTaskId = this.getCutTaskId();
            Object other$cutTaskId = other.getCutTaskId();
            if (this$cutTaskId == null ? other$cutTaskId == null : this$cutTaskId.equals(other$cutTaskId)) {
               Object this$state = this.getState();
               Object other$state = other.getState();
               return this$state == null ? other$state == null : this$state.equals(other$state);
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
      return other instanceof CutTaskPart;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $cutTaskId = this.getCutTaskId();
      result = result * 59 + ($cutTaskId == null ? 43 : $cutTaskId.hashCode());
      Object $state = this.getState();
      return result * 59 + ($state == null ? 43 : $state.hashCode());
   }

   public static class CutTaskPartBuilder {
      private Long id;
      private String cutTaskId;
      private Long partId;
      private String state;

      CutTaskPartBuilder() {
      }

      @JsonProperty("id")
      public CutTaskPart.CutTaskPartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cutTaskId")
      public CutTaskPart.CutTaskPartBuilder cutTaskId(final String cutTaskId) {
         this.cutTaskId = cutTaskId;
         return this;
      }

      @JsonProperty("partId")
      public CutTaskPart.CutTaskPartBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("state")
      public CutTaskPart.CutTaskPartBuilder state(final String state) {
         this.state = state;
         return this;
      }

      public CutTaskPart build() {
         return new CutTaskPart(this.id, this.cutTaskId, this.partId, this.state);
      }

      @Override
      public String toString() {
         return "CutTaskPart.CutTaskPartBuilder(id=" + this.id + ", cutTaskId=" + this.cutTaskId + ", partId=" + this.partId + ", state=" + this.state + ")";
      }
   }
}
