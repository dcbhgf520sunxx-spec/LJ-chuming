package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task;

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

@ApiModel(value = "MesEnclosureTaskOrderArtifact对象", description = "")
@Entity
@TableName("mes_enclosure_task_order_artifact")
@Table(name = "mes_enclosure_task_order_artifact")
public class MesEnclosureTaskOrderArtifact extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '0' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskOlderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOlderId")
   @JSONField(name = "taskOlderId")
   @TableField("task_older_id")
   @Column(name = "task_older_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'", nullable = false)
   private Long taskOlderId;
   @ApiModelProperty(name = "taskOlderTypesettingId", value = "任务工单型材套料id", notes = "任务工单型材套料id")
   @JsonProperty("taskOlderTypesettingId")
   @JSONField(name = "taskOlderTypesettingId")
   @TableField("task_older_typesetting_id")
   @Column(name = "task_older_typesetting_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'")
   private Long taskOlderTypesettingId;
   @ApiModelProperty(name = "xmlFilePath", value = "构件信息xml路径", notes = "构件信息xml路径")
   @JsonProperty("xmlFilePath")
   @JSONField(name = "xmlFilePath")
   @TableField("xml_file_path")
   @Column(name = "xml_file_path", columnDefinition = "varchar(500)  COMMENT '构件信息xml路径'")
   private Long xmlFilePath;

   public static MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder builder() {
      return new MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder();
   }

   public MesEnclosureTaskOrderArtifact() {
   }

   public MesEnclosureTaskOrderArtifact(final Long id, final Long productId, final Long taskOlderId, final Long taskOlderTypesettingId, final Long xmlFilePath) {
      this.id = id;
      this.productId = productId;
      this.taskOlderId = taskOlderId;
      this.taskOlderTypesettingId = taskOlderTypesettingId;
      this.xmlFilePath = xmlFilePath;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskOlderId() {
      return this.taskOlderId;
   }

   public Long getTaskOlderTypesettingId() {
      return this.taskOlderTypesettingId;
   }

   public Long getXmlFilePath() {
      return this.xmlFilePath;
   }

   @JsonProperty("id")
   public MesEnclosureTaskOrderArtifact setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureTaskOrderArtifact setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskOlderId")
   public MesEnclosureTaskOrderArtifact setTaskOlderId(final Long taskOlderId) {
      this.taskOlderId = taskOlderId;
      return this;
   }

   @JsonProperty("taskOlderTypesettingId")
   public MesEnclosureTaskOrderArtifact setTaskOlderTypesettingId(final Long taskOlderTypesettingId) {
      this.taskOlderTypesettingId = taskOlderTypesettingId;
      return this;
   }

   @JsonProperty("xmlFilePath")
   public MesEnclosureTaskOrderArtifact setXmlFilePath(final Long xmlFilePath) {
      this.xmlFilePath = xmlFilePath;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderArtifact(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", taskOlderId="
         + this.getTaskOlderId()
         + ", taskOlderTypesettingId="
         + this.getTaskOlderTypesettingId()
         + ", xmlFilePath="
         + this.getXmlFilePath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderArtifact)) {
         return false;
      }

      MesEnclosureTaskOrderArtifact other = (MesEnclosureTaskOrderArtifact)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$taskOlderId = this.getTaskOlderId();
            Object other$taskOlderId = other.getTaskOlderId();
            if (this$taskOlderId == null ? other$taskOlderId == null : this$taskOlderId.equals(other$taskOlderId)) {
               Object this$taskOlderTypesettingId = this.getTaskOlderTypesettingId();
               Object other$taskOlderTypesettingId = other.getTaskOlderTypesettingId();
               if (this$taskOlderTypesettingId == null
                  ? other$taskOlderTypesettingId == null
                  : this$taskOlderTypesettingId.equals(other$taskOlderTypesettingId)) {
                  Object this$xmlFilePath = this.getXmlFilePath();
                  Object other$xmlFilePath = other.getXmlFilePath();
                  return this$xmlFilePath == null ? other$xmlFilePath == null : this$xmlFilePath.equals(other$xmlFilePath);
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
      return other instanceof MesEnclosureTaskOrderArtifact;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskOlderId = this.getTaskOlderId();
      result = result * 59 + ($taskOlderId == null ? 43 : $taskOlderId.hashCode());
      Object $taskOlderTypesettingId = this.getTaskOlderTypesettingId();
      result = result * 59 + ($taskOlderTypesettingId == null ? 43 : $taskOlderTypesettingId.hashCode());
      Object $xmlFilePath = this.getXmlFilePath();
      return result * 59 + ($xmlFilePath == null ? 43 : $xmlFilePath.hashCode());
   }

   public static class MesEnclosureTaskOrderArtifactBuilder {
      private Long id;
      private Long productId;
      private Long taskOlderId;
      private Long taskOlderTypesettingId;
      private Long xmlFilePath;

      MesEnclosureTaskOrderArtifactBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskOlderId")
      public MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder taskOlderId(final Long taskOlderId) {
         this.taskOlderId = taskOlderId;
         return this;
      }

      @JsonProperty("taskOlderTypesettingId")
      public MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder taskOlderTypesettingId(final Long taskOlderTypesettingId) {
         this.taskOlderTypesettingId = taskOlderTypesettingId;
         return this;
      }

      @JsonProperty("xmlFilePath")
      public MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder xmlFilePath(final Long xmlFilePath) {
         this.xmlFilePath = xmlFilePath;
         return this;
      }

      public MesEnclosureTaskOrderArtifact build() {
         return new MesEnclosureTaskOrderArtifact(this.id, this.productId, this.taskOlderId, this.taskOlderTypesettingId, this.xmlFilePath);
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderArtifact.MesEnclosureTaskOrderArtifactBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", taskOlderId="
            + this.taskOlderId
            + ", taskOlderTypesettingId="
            + this.taskOlderTypesettingId
            + ", xmlFilePath="
            + this.xmlFilePath
            + ")";
      }
   }
}
