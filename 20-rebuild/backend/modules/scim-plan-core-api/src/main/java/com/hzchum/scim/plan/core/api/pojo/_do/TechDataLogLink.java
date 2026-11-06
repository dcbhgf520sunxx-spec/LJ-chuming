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

@ApiModel(value = "TechDataLogLink对象", description = "技术资料日志关联表 ")
@Entity
@TableName("tech_data_log_link")
@Table(name = "tech_data_log_link")
public class TechDataLogLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "logId", value = "日志表id")
   @JsonProperty("logId")
   @JSONField(name = "logId")
   @TableField("log_id")
   @Column(name = "log_id")
   private Long logId;
   @ApiModelProperty(name = "drawingId", value = "资料表id")
   @JsonProperty("drawingId")
   @JSONField(name = "drawingId")
   @TableField("drawing_id")
   @Column(name = "drawing_id")
   private Long drawingId;

   public static TechDataLogLink.TechDataLogLinkBuilder builder() {
      return new TechDataLogLink.TechDataLogLinkBuilder();
   }

   public TechDataLogLink() {
   }

   public TechDataLogLink(final Long id, final Long logId, final Long drawingId) {
      this.id = id;
      this.logId = logId;
      this.drawingId = drawingId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLogId() {
      return this.logId;
   }

   public Long getDrawingId() {
      return this.drawingId;
   }

   @JsonProperty("id")
   public TechDataLogLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("logId")
   public TechDataLogLink setLogId(final Long logId) {
      this.logId = logId;
      return this;
   }

   @JsonProperty("drawingId")
   public TechDataLogLink setDrawingId(final Long drawingId) {
      this.drawingId = drawingId;
      return this;
   }

   @Override
   public String toString() {
      return "TechDataLogLink(id=" + this.getId() + ", logId=" + this.getLogId() + ", drawingId=" + this.getDrawingId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechDataLogLink)) {
         return false;
      }

      TechDataLogLink other = (TechDataLogLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$logId = this.getLogId();
         Object other$logId = other.getLogId();
         if (this$logId == null ? other$logId == null : this$logId.equals(other$logId)) {
            Object this$drawingId = this.getDrawingId();
            Object other$drawingId = other.getDrawingId();
            return this$drawingId == null ? other$drawingId == null : this$drawingId.equals(other$drawingId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechDataLogLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $logId = this.getLogId();
      result = result * 59 + ($logId == null ? 43 : $logId.hashCode());
      Object $drawingId = this.getDrawingId();
      return result * 59 + ($drawingId == null ? 43 : $drawingId.hashCode());
   }

   public static class TechDataLogLinkBuilder {
      private Long id;
      private Long logId;
      private Long drawingId;

      TechDataLogLinkBuilder() {
      }

      @JsonProperty("id")
      public TechDataLogLink.TechDataLogLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("logId")
      public TechDataLogLink.TechDataLogLinkBuilder logId(final Long logId) {
         this.logId = logId;
         return this;
      }

      @JsonProperty("drawingId")
      public TechDataLogLink.TechDataLogLinkBuilder drawingId(final Long drawingId) {
         this.drawingId = drawingId;
         return this;
      }

      public TechDataLogLink build() {
         return new TechDataLogLink(this.id, this.logId, this.drawingId);
      }

      @Override
      public String toString() {
         return "TechDataLogLink.TechDataLogLinkBuilder(id=" + this.id + ", logId=" + this.logId + ", drawingId=" + this.drawingId + ")";
      }
   }
}
