package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingTaskOrderTypesetting对象", description = "")
@Entity
@TableName("mes_building_task_order_typesetting")
@Table(name = "mes_building_task_order_typesetting", indexes = @Index(name = "productId_index", columnList = "product_id"))
public class MesBuildingTaskOrderTypesetting extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "taksTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taksTypeEnum")
   @JSONField(name = "taksTypeEnum")
   @TableField("taks_type_enum")
   @Column(name = "taks_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taksTypeEnum;
   @ApiModelProperty(name = "taskOlderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOlderId")
   @JSONField(name = "taskOlderId")
   @TableField("task_older_id")
   @Column(name = "task_older_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'", nullable = false)
   private Long taskOlderId;
   @ApiModelProperty(name = "filePath", value = "pnc文件路径")
   @JsonProperty("filePath")
   @JSONField(name = "filePath")
   @TableField("file_path")
   @Column(name = "file_path", columnDefinition = "varchar(500)  COMMENT 'pnc文件路径'")
   private String filePath;
   @ApiModelProperty(name = "sequence", value = "顺序", notes = "顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11) default '0' COMMENT '工序顺序'")
   private Integer sequence;
   @ApiModelProperty(name = "boolLoadingEnum", value = "上料状态", notes = "上料状态")
   @JsonProperty("boolLoadingEnum")
   @JSONField(name = "boolLoadingEnum")
   @TableField("bool_loading_enum")
   @Column(name = "bool_loading_enum", columnDefinition = "tinyint(1) default '0' COMMENT '上料状态 [0 未上料, 1 已上料]'")
   private Boolean boolLoadingEnum;

   public static MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder builder() {
      return new MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder();
   }

   public MesBuildingTaskOrderTypesetting() {
   }

   public MesBuildingTaskOrderTypesetting(
      final Long id,
      final Long productId,
      final Integer taksTypeEnum,
      final Long taskOlderId,
      final String filePath,
      final Integer sequence,
      final Boolean boolLoadingEnum
   ) {
      this.id = id;
      this.productId = productId;
      this.taksTypeEnum = taksTypeEnum;
      this.taskOlderId = taskOlderId;
      this.filePath = filePath;
      this.sequence = sequence;
      this.boolLoadingEnum = boolLoadingEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaksTypeEnum() {
      return this.taksTypeEnum;
   }

   public Long getTaskOlderId() {
      return this.taskOlderId;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Boolean getBoolLoadingEnum() {
      return this.boolLoadingEnum;
   }

   @JsonProperty("id")
   public MesBuildingTaskOrderTypesetting setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskOrderTypesetting setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taksTypeEnum")
   public MesBuildingTaskOrderTypesetting setTaksTypeEnum(final Integer taksTypeEnum) {
      this.taksTypeEnum = taksTypeEnum;
      return this;
   }

   @JsonProperty("taskOlderId")
   public MesBuildingTaskOrderTypesetting setTaskOlderId(final Long taskOlderId) {
      this.taskOlderId = taskOlderId;
      return this;
   }

   @JsonProperty("filePath")
   public MesBuildingTaskOrderTypesetting setFilePath(final String filePath) {
      this.filePath = filePath;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingTaskOrderTypesetting setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("boolLoadingEnum")
   public MesBuildingTaskOrderTypesetting setBoolLoadingEnum(final Boolean boolLoadingEnum) {
      this.boolLoadingEnum = boolLoadingEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskOrderTypesetting(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", taksTypeEnum="
         + this.getTaksTypeEnum()
         + ", taskOlderId="
         + this.getTaskOlderId()
         + ", filePath="
         + this.getFilePath()
         + ", sequence="
         + this.getSequence()
         + ", boolLoadingEnum="
         + this.getBoolLoadingEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderTypesetting)) {
         return false;
      }

      MesBuildingTaskOrderTypesetting other = (MesBuildingTaskOrderTypesetting)o;
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
            Object this$taksTypeEnum = this.getTaksTypeEnum();
            Object other$taksTypeEnum = other.getTaksTypeEnum();
            if (this$taksTypeEnum == null ? other$taksTypeEnum == null : this$taksTypeEnum.equals(other$taksTypeEnum)) {
               Object this$taskOlderId = this.getTaskOlderId();
               Object other$taskOlderId = other.getTaskOlderId();
               if (this$taskOlderId == null ? other$taskOlderId == null : this$taskOlderId.equals(other$taskOlderId)) {
                  Object this$sequence = this.getSequence();
                  Object other$sequence = other.getSequence();
                  if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
                     Object this$boolLoadingEnum = this.getBoolLoadingEnum();
                     Object other$boolLoadingEnum = other.getBoolLoadingEnum();
                     if (this$boolLoadingEnum == null ? other$boolLoadingEnum == null : this$boolLoadingEnum.equals(other$boolLoadingEnum)) {
                        Object this$filePath = this.getFilePath();
                        Object other$filePath = other.getFilePath();
                        return this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrderTypesetting;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taksTypeEnum = this.getTaksTypeEnum();
      result = result * 59 + ($taksTypeEnum == null ? 43 : $taksTypeEnum.hashCode());
      Object $taskOlderId = this.getTaskOlderId();
      result = result * 59 + ($taskOlderId == null ? 43 : $taskOlderId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $boolLoadingEnum = this.getBoolLoadingEnum();
      result = result * 59 + ($boolLoadingEnum == null ? 43 : $boolLoadingEnum.hashCode());
      Object $filePath = this.getFilePath();
      return result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
   }

   public static class MesBuildingTaskOrderTypesettingBuilder {
      private Long id;
      private Long productId;
      private Integer taksTypeEnum;
      private Long taskOlderId;
      private String filePath;
      private Integer sequence;
      private Boolean boolLoadingEnum;

      MesBuildingTaskOrderTypesettingBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taksTypeEnum")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder taksTypeEnum(final Integer taksTypeEnum) {
         this.taksTypeEnum = taksTypeEnum;
         return this;
      }

      @JsonProperty("taskOlderId")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder taskOlderId(final Long taskOlderId) {
         this.taskOlderId = taskOlderId;
         return this;
      }

      @JsonProperty("filePath")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder filePath(final String filePath) {
         this.filePath = filePath;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("boolLoadingEnum")
      public MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder boolLoadingEnum(final Boolean boolLoadingEnum) {
         this.boolLoadingEnum = boolLoadingEnum;
         return this;
      }

      public MesBuildingTaskOrderTypesetting build() {
         return new MesBuildingTaskOrderTypesetting(
            this.id, this.productId, this.taksTypeEnum, this.taskOlderId, this.filePath, this.sequence, this.boolLoadingEnum
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderTypesetting.MesBuildingTaskOrderTypesettingBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", taksTypeEnum="
            + this.taksTypeEnum
            + ", taskOlderId="
            + this.taskOlderId
            + ", filePath="
            + this.filePath
            + ", sequence="
            + this.sequence
            + ", boolLoadingEnum="
            + this.boolLoadingEnum
            + ")";
      }
   }
}
