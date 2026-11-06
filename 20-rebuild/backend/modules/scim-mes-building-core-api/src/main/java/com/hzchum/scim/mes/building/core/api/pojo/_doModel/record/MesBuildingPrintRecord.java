package com.hzchum.scim.mes.building.core.api.pojo._doModel.record;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPrintRecord对象", description = "打印记录")
@Entity
@TableName("mes_building_print_record")
@Table(name = "mes_building_print_record")
public class MesBuildingPrintRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "relateId", value = "关联id type:1 任务id 2 辅材id 3包id", notes = "关联id type:1 任务id 2 辅材id 3包id")
   @JsonProperty("relateId")
   @JSONField(name = "relateId")
   @TableField("relate_id")
   @Column(name = "relate_id", columnDefinition = "bigint(20)  COMMENT '关联id type:1 任务id 2 辅材id 3包id'", nullable = false)
   private Long relateId;
   @ApiModelProperty(name = "type", value = "打印类型", notes = "打印类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '打印类型'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "userId", value = "打印用户id", notes = "打印用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '打印用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "打印用户名称", notes = "打印用户名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '打印用户名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "startTime", value = "开始时间", notes = "开始时间")
   @JsonProperty("startTime")
   @JSONField(name = "startTime")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime  COMMENT '开始时间'", nullable = false)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "结束时间", notes = "结束时间")
   @JsonProperty("endTime")
   @JSONField(name = "endTime")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime  COMMENT '结束时间'", nullable = false)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "numbers", value = "码号列表", notes = "码号列表")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   @TableField("numbers")
   @Column(name = "numbers", columnDefinition = "varchar(1024)  COMMENT '码号列表'", nullable = true)
   private String numbers;

   public static MesBuildingPrintRecord.MesBuildingPrintRecordBuilder builder() {
      return new MesBuildingPrintRecord.MesBuildingPrintRecordBuilder();
   }

   public MesBuildingPrintRecord() {
   }

   public MesBuildingPrintRecord(
      final Long id,
      final Long relateId,
      final Integer type,
      final BigDecimal quantity,
      final Long userId,
      final String userName,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final String numbers
   ) {
      this.id = id;
      this.relateId = relateId;
      this.type = type;
      this.quantity = quantity;
      this.userId = userId;
      this.userName = userName;
      this.startTime = startTime;
      this.endTime = endTime;
      this.numbers = numbers;
   }

   public Long getId() {
      return this.id;
   }

   public Long getRelateId() {
      return this.relateId;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public String getNumbers() {
      return this.numbers;
   }

   @JsonProperty("id")
   public MesBuildingPrintRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("relateId")
   public MesBuildingPrintRecord setRelateId(final Long relateId) {
      this.relateId = relateId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingPrintRecord setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingPrintRecord setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingPrintRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingPrintRecord setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("startTime")
   public MesBuildingPrintRecord setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   @JsonProperty("endTime")
   public MesBuildingPrintRecord setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   @JsonProperty("numbers")
   public MesBuildingPrintRecord setNumbers(final String numbers) {
      this.numbers = numbers;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPrintRecord(id="
         + this.getId()
         + ", relateId="
         + this.getRelateId()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", numbers="
         + this.getNumbers()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPrintRecord)) {
         return false;
      }

      MesBuildingPrintRecord other = (MesBuildingPrintRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$relateId = this.getRelateId();
         Object other$relateId = other.getRelateId();
         if (this$relateId == null ? other$relateId == null : this$relateId.equals(other$relateId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$startTime = this.getStartTime();
                        Object other$startTime = other.getStartTime();
                        if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                           Object this$endTime = this.getEndTime();
                           Object other$endTime = other.getEndTime();
                           if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                              Object this$numbers = this.getNumbers();
                              Object other$numbers = other.getNumbers();
                              return this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPrintRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $relateId = this.getRelateId();
      result = result * 59 + ($relateId == null ? 43 : $relateId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $numbers = this.getNumbers();
      return result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
   }

   public static class MesBuildingPrintRecordBuilder {
      private Long id;
      private Long relateId;
      private Integer type;
      private BigDecimal quantity;
      private Long userId;
      private String userName;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private String numbers;

      MesBuildingPrintRecordBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("relateId")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder relateId(final Long relateId) {
         this.relateId = relateId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("startTime")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      @JsonProperty("endTime")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      @JsonProperty("numbers")
      public MesBuildingPrintRecord.MesBuildingPrintRecordBuilder numbers(final String numbers) {
         this.numbers = numbers;
         return this;
      }

      public MesBuildingPrintRecord build() {
         return new MesBuildingPrintRecord(
            this.id, this.relateId, this.type, this.quantity, this.userId, this.userName, this.startTime, this.endTime, this.numbers
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPrintRecord.MesBuildingPrintRecordBuilder(id="
            + this.id
            + ", relateId="
            + this.relateId
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", numbers="
            + this.numbers
            + ")";
      }
   }
}
