package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingSinglePartArtifactPrintRecord对象", description = "打印历史记录 ")
@Entity
@TableName("mes_building_single_part_artifact_print_record")
@Table(name = "mes_building_single_part_artifact_print_record")
public class MesBuildingSinglePartArtifactPrintRecord extends BaseEntity<Long> {
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
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "workshop_id", value = "车间id", notes = "车间id")
   @JsonProperty("workshop_id")
   @JSONField(name = "workshop_id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "task_id", value = "任务id", notes = "任务id")
   @JsonProperty("task_id")
   @JSONField(name = "task_id")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = true)
   private Long taskId;
   @ApiModelProperty(name = "printUserId", value = "打印人ID", notes = "打印人ID")
   @JsonProperty("printUserId")
   @JSONField(name = "printUserId")
   @TableField("print_user_id")
   @Column(name = "print_user_id", columnDefinition = "bigint(20)  COMMENT '打印人ID'", nullable = true)
   private Long printUserId;
   @ApiModelProperty(name = "printQuantity", value = "数量", notes = "数量")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = true)
   private Integer printQuantity;
   @ApiModelProperty(name = "printTime")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime printTime;
   @ApiModelProperty(name = "number")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '一物一码号'", nullable = true)
   private Integer number;

   public static MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder builder() {
      return new MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder();
   }

   public MesBuildingSinglePartArtifactPrintRecord() {
   }

   public MesBuildingSinglePartArtifactPrintRecord(
      final Long id,
      final Long productId,
      final Long workshopId,
      final Long taskId,
      final Long printUserId,
      final Integer printQuantity,
      final LocalDateTime printTime,
      final Integer number
   ) {
      this.id = id;
      this.productId = productId;
      this.workshopId = workshopId;
      this.taskId = taskId;
      this.printUserId = printUserId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getPrintUserId() {
      return this.printUserId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesBuildingSinglePartArtifactPrintRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSinglePartArtifactPrintRecord setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("workshop_id")
   public MesBuildingSinglePartArtifactPrintRecord setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("task_id")
   public MesBuildingSinglePartArtifactPrintRecord setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("printUserId")
   public MesBuildingSinglePartArtifactPrintRecord setPrintUserId(final Long printUserId) {
      this.printUserId = printUserId;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingSinglePartArtifactPrintRecord setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("printTime")
   public MesBuildingSinglePartArtifactPrintRecord setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingSinglePartArtifactPrintRecord setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSinglePartArtifactPrintRecord(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskId="
         + this.getTaskId()
         + ", printUserId="
         + this.getPrintUserId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSinglePartArtifactPrintRecord)) {
         return false;
      }

      MesBuildingSinglePartArtifactPrintRecord other = (MesBuildingSinglePartArtifactPrintRecord)o;
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
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$taskId = this.getTaskId();
               Object other$taskId = other.getTaskId();
               if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                  Object this$printUserId = this.getPrintUserId();
                  Object other$printUserId = other.getPrintUserId();
                  if (this$printUserId == null ? other$printUserId == null : this$printUserId.equals(other$printUserId)) {
                     Object this$printQuantity = this.getPrintQuantity();
                     Object other$printQuantity = other.getPrintQuantity();
                     if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                        Object this$number = this.getNumber();
                        Object other$number = other.getNumber();
                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                           Object this$printTime = this.getPrintTime();
                           Object other$printTime = other.getPrintTime();
                           return this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSinglePartArtifactPrintRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $printUserId = this.getPrintUserId();
      result = result * 59 + ($printUserId == null ? 43 : $printUserId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   public static class MesBuildingSinglePartArtifactPrintRecordBuilder {
      private Long id;
      private Long productId;
      private Long workshopId;
      private Long taskId;
      private Long printUserId;
      private Integer printQuantity;
      private LocalDateTime printTime;
      private Integer number;

      MesBuildingSinglePartArtifactPrintRecordBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("workshop_id")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("task_id")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("printUserId")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder printUserId(final Long printUserId) {
         this.printUserId = printUserId;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("printTime")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingSinglePartArtifactPrintRecord build() {
         return new MesBuildingSinglePartArtifactPrintRecord(
            this.id, this.productId, this.workshopId, this.taskId, this.printUserId, this.printQuantity, this.printTime, this.number
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSinglePartArtifactPrintRecord.MesBuildingSinglePartArtifactPrintRecordBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", workshopId="
            + this.workshopId
            + ", taskId="
            + this.taskId
            + ", printUserId="
            + this.printUserId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ", number="
            + this.number
            + ")";
      }
   }
}
