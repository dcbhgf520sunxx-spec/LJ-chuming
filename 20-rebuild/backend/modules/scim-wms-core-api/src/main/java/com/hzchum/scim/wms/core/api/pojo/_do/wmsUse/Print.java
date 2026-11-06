package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

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

@ApiModel(value = "LabelPrint对象", description = "标签打印记录 ")
@Entity
@TableName("wms_print")
@Table(name = "wms_print")
public class Print extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "receiptType", value = "单据类型[ ReceiptTypeEnum ]", notes = "单据类型[ ReceiptTypeEnum ]")
   @JsonProperty("receiptType")
   @JSONField(name = "receiptType")
   @TableField("receipt_type")
   @Column(name = "receipt_type", columnDefinition = "int  COMMENT '单据类型[ ReceiptTypeEnum ]'", nullable = true)
   private Integer receiptType;
   @ApiModelProperty(name = "receiptId", value = "单据ID", notes = "单据ID")
   @JsonProperty("receiptId")
   @JSONField(name = "receiptId")
   @TableField("receipt_id")
   @Column(name = "receipt_id", columnDefinition = "bigint  COMMENT '单据ID'", nullable = true)
   private Long receiptId;
   @ApiModelProperty(name = "receiptSerialNumber", value = "单据编号", notes = "单据编号")
   @JsonProperty("receiptSerialNumber")
   @JSONField(name = "receiptSerialNumber")
   @TableField("receipt_serial_number")
   @Column(name = "receipt_serial_number", columnDefinition = "varchar(255)  COMMENT '单据编号'", nullable = true)
   private String receiptSerialNumber;
   @ApiModelProperty(name = "projectIds", value = "项目ID集", notes = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID集'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "receiptReviewer", value = "单据审核人", notes = "单据审核人")
   @JsonProperty("receiptReviewer")
   @JSONField(name = "receiptReviewer")
   @TableField("receipt_reviewer")
   @Column(name = "receipt_reviewer", columnDefinition = "varchar(255)  COMMENT '单据审核人'", nullable = true)
   private String receiptReviewer;
   @ApiModelProperty(name = "receiptReviewTime", value = "单据创建时间(审核时间)", notes = "单据创建时间(审核时间)")
   @JsonProperty("receiptReviewTime")
   @JSONField(name = "receiptReviewTime")
   @TableField("receipt_review_time")
   @Column(name = "receipt_review_time", columnDefinition = "datetime  COMMENT '单据创建时间(审核时间)'", nullable = true)
   private LocalDateTime receiptReviewTime;
   @ApiModelProperty(name = "boolPrinted", value = "是否已打印(当前所有物料全部打印为true)", notes = "是否已打印(当前所有物料全部打印为true)")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", columnDefinition = "tinyint(1) default '0' COMMENT '是否已打印(当前所有物料全部打印为true)'", nullable = true)
   private Boolean boolPrinted;
   @ApiModelProperty(name = "totalPrintNumber", value = "打印数量", notes = "打印数量")
   @JsonProperty("totalPrintNumber")
   @JSONField(name = "totalPrintNumber")
   @TableField("total_print_number")
   @Column(name = "total_print_number", columnDefinition = "int default '0' COMMENT '打印数量'", nullable = true)
   private Integer totalPrintNumber;
   @ApiModelProperty(name = "totalPrintShareNumber", value = "打印份数", notes = "打印份数")
   @JsonProperty("totalPrintShareNumber")
   @JSONField(name = "totalPrintShareNumber")
   @TableField("total_print_share_number")
   @Column(name = "total_print_share_number", columnDefinition = "int default '0' COMMENT '打印份数'", nullable = true)
   private Integer totalPrintShareNumber;
   @ApiModelProperty(name = "totalNotPrintNumber", value = "未打印份数", notes = "未打印份数")
   @JsonProperty("totalNotPrintNumber")
   @JSONField(name = "totalNotPrintNumber")
   @TableField("total_not_print_number")
   @Column(name = "total_not_print_number", columnDefinition = "int  COMMENT '未打印份数'", nullable = true)
   private Integer totalNotPrintNumber;
   @ApiModelProperty(name = "printerId", value = "打印操作人ID", notes = "打印操作人ID")
   @JsonProperty("printerId")
   @JSONField(name = "printerId")
   @TableField("printer_id")
   @Column(name = "printer_id", columnDefinition = "bigint  COMMENT '打印操作人ID'", nullable = true)
   private Long printerId;
   @ApiModelProperty(name = "containBasicClass", value = "单据所包含基础分类", notes = "单据所包含基础分类")
   @JsonProperty("containBasicClass")
   @JSONField(name = "containBasicClass")
   @TableField("contain_basic_class")
   @Column(name = "contain_basic_class", columnDefinition = "int  COMMENT '单据所包含基础分类'", nullable = true)
   private Integer containBasicClass;
   @ApiModelProperty(name = "type", value = "物料产生类型", notes = "物料产生类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '物料产生类型'", nullable = true)
   private Integer type;

   public static Print.PrintBuilder builder() {
      return new Print.PrintBuilder();
   }

   public Print() {
   }

   public Print(
      final Long id,
      final Integer receiptType,
      final Long receiptId,
      final String receiptSerialNumber,
      final String projectIds,
      final String receiptReviewer,
      final LocalDateTime receiptReviewTime,
      final Boolean boolPrinted,
      final Integer totalPrintNumber,
      final Integer totalPrintShareNumber,
      final Integer totalNotPrintNumber,
      final Long printerId,
      final Integer containBasicClass,
      final Integer type
   ) {
      this.id = id;
      this.receiptType = receiptType;
      this.receiptId = receiptId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.projectIds = projectIds;
      this.receiptReviewer = receiptReviewer;
      this.receiptReviewTime = receiptReviewTime;
      this.boolPrinted = boolPrinted;
      this.totalPrintNumber = totalPrintNumber;
      this.totalPrintShareNumber = totalPrintShareNumber;
      this.totalNotPrintNumber = totalNotPrintNumber;
      this.printerId = printerId;
      this.containBasicClass = containBasicClass;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getReceiptType() {
      return this.receiptType;
   }

   public Long getReceiptId() {
      return this.receiptId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getReceiptReviewer() {
      return this.receiptReviewer;
   }

   public LocalDateTime getReceiptReviewTime() {
      return this.receiptReviewTime;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public Integer getTotalPrintNumber() {
      return this.totalPrintNumber;
   }

   public Integer getTotalPrintShareNumber() {
      return this.totalPrintShareNumber;
   }

   public Integer getTotalNotPrintNumber() {
      return this.totalNotPrintNumber;
   }

   public Long getPrinterId() {
      return this.printerId;
   }

   public Integer getContainBasicClass() {
      return this.containBasicClass;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public Print setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("receiptType")
   public Print setReceiptType(final Integer receiptType) {
      this.receiptType = receiptType;
      return this;
   }

   @JsonProperty("receiptId")
   public Print setReceiptId(final Long receiptId) {
      this.receiptId = receiptId;
      return this;
   }

   @JsonProperty("receiptSerialNumber")
   public Print setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
      return this;
   }

   @JsonProperty("projectIds")
   public Print setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("receiptReviewer")
   public Print setReceiptReviewer(final String receiptReviewer) {
      this.receiptReviewer = receiptReviewer;
      return this;
   }

   @JsonProperty("receiptReviewTime")
   public Print setReceiptReviewTime(final LocalDateTime receiptReviewTime) {
      this.receiptReviewTime = receiptReviewTime;
      return this;
   }

   @JsonProperty("boolPrinted")
   public Print setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("totalPrintNumber")
   public Print setTotalPrintNumber(final Integer totalPrintNumber) {
      this.totalPrintNumber = totalPrintNumber;
      return this;
   }

   @JsonProperty("totalPrintShareNumber")
   public Print setTotalPrintShareNumber(final Integer totalPrintShareNumber) {
      this.totalPrintShareNumber = totalPrintShareNumber;
      return this;
   }

   @JsonProperty("totalNotPrintNumber")
   public Print setTotalNotPrintNumber(final Integer totalNotPrintNumber) {
      this.totalNotPrintNumber = totalNotPrintNumber;
      return this;
   }

   @JsonProperty("printerId")
   public Print setPrinterId(final Long printerId) {
      this.printerId = printerId;
      return this;
   }

   @JsonProperty("containBasicClass")
   public Print setContainBasicClass(final Integer containBasicClass) {
      this.containBasicClass = containBasicClass;
      return this;
   }

   @JsonProperty("type")
   public Print setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "Print(id="
         + this.getId()
         + ", receiptType="
         + this.getReceiptType()
         + ", receiptId="
         + this.getReceiptId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", projectIds="
         + this.getProjectIds()
         + ", receiptReviewer="
         + this.getReceiptReviewer()
         + ", receiptReviewTime="
         + this.getReceiptReviewTime()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", totalPrintNumber="
         + this.getTotalPrintNumber()
         + ", totalPrintShareNumber="
         + this.getTotalPrintShareNumber()
         + ", totalNotPrintNumber="
         + this.getTotalNotPrintNumber()
         + ", printerId="
         + this.getPrinterId()
         + ", containBasicClass="
         + this.getContainBasicClass()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Print)) {
         return false;
      }

      Print other = (Print)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$receiptType = this.getReceiptType();
         Object other$receiptType = other.getReceiptType();
         if (this$receiptType == null ? other$receiptType == null : this$receiptType.equals(other$receiptType)) {
            Object this$receiptId = this.getReceiptId();
            Object other$receiptId = other.getReceiptId();
            if (this$receiptId == null ? other$receiptId == null : this$receiptId.equals(other$receiptId)) {
               Object this$boolPrinted = this.getBoolPrinted();
               Object other$boolPrinted = other.getBoolPrinted();
               if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                  Object this$totalPrintNumber = this.getTotalPrintNumber();
                  Object other$totalPrintNumber = other.getTotalPrintNumber();
                  if (this$totalPrintNumber == null ? other$totalPrintNumber == null : this$totalPrintNumber.equals(other$totalPrintNumber)) {
                     Object this$totalPrintShareNumber = this.getTotalPrintShareNumber();
                     Object other$totalPrintShareNumber = other.getTotalPrintShareNumber();
                     if (this$totalPrintShareNumber == null
                        ? other$totalPrintShareNumber == null
                        : this$totalPrintShareNumber.equals(other$totalPrintShareNumber)) {
                        Object this$totalNotPrintNumber = this.getTotalNotPrintNumber();
                        Object other$totalNotPrintNumber = other.getTotalNotPrintNumber();
                        if (this$totalNotPrintNumber == null ? other$totalNotPrintNumber == null : this$totalNotPrintNumber.equals(other$totalNotPrintNumber)) {
                           Object this$printerId = this.getPrinterId();
                           Object other$printerId = other.getPrinterId();
                           if (this$printerId == null ? other$printerId == null : this$printerId.equals(other$printerId)) {
                              Object this$containBasicClass = this.getContainBasicClass();
                              Object other$containBasicClass = other.getContainBasicClass();
                              if (this$containBasicClass == null ? other$containBasicClass == null : this$containBasicClass.equals(other$containBasicClass)) {
                                 Object this$type = this.getType();
                                 Object other$type = other.getType();
                                 if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                    Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                                    Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                                    if (this$receiptSerialNumber == null
                                       ? other$receiptSerialNumber == null
                                       : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                                       Object this$projectIds = this.getProjectIds();
                                       Object other$projectIds = other.getProjectIds();
                                       if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                          Object this$receiptReviewer = this.getReceiptReviewer();
                                          Object other$receiptReviewer = other.getReceiptReviewer();
                                          if (this$receiptReviewer == null ? other$receiptReviewer == null : this$receiptReviewer.equals(other$receiptReviewer)
                                             )
                                           {
                                             Object this$receiptReviewTime = this.getReceiptReviewTime();
                                             Object other$receiptReviewTime = other.getReceiptReviewTime();
                                             return this$receiptReviewTime == null
                                                ? other$receiptReviewTime == null
                                                : this$receiptReviewTime.equals(other$receiptReviewTime);
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
      return other instanceof Print;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $receiptType = this.getReceiptType();
      result = result * 59 + ($receiptType == null ? 43 : $receiptType.hashCode());
      Object $receiptId = this.getReceiptId();
      result = result * 59 + ($receiptId == null ? 43 : $receiptId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $totalPrintNumber = this.getTotalPrintNumber();
      result = result * 59 + ($totalPrintNumber == null ? 43 : $totalPrintNumber.hashCode());
      Object $totalPrintShareNumber = this.getTotalPrintShareNumber();
      result = result * 59 + ($totalPrintShareNumber == null ? 43 : $totalPrintShareNumber.hashCode());
      Object $totalNotPrintNumber = this.getTotalNotPrintNumber();
      result = result * 59 + ($totalNotPrintNumber == null ? 43 : $totalNotPrintNumber.hashCode());
      Object $printerId = this.getPrinterId();
      result = result * 59 + ($printerId == null ? 43 : $printerId.hashCode());
      Object $containBasicClass = this.getContainBasicClass();
      result = result * 59 + ($containBasicClass == null ? 43 : $containBasicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $receiptReviewer = this.getReceiptReviewer();
      result = result * 59 + ($receiptReviewer == null ? 43 : $receiptReviewer.hashCode());
      Object $receiptReviewTime = this.getReceiptReviewTime();
      return result * 59 + ($receiptReviewTime == null ? 43 : $receiptReviewTime.hashCode());
   }

   public static class PrintBuilder {
      private Long id;
      private Integer receiptType;
      private Long receiptId;
      private String receiptSerialNumber;
      private String projectIds;
      private String receiptReviewer;
      private LocalDateTime receiptReviewTime;
      private Boolean boolPrinted;
      private Integer totalPrintNumber;
      private Integer totalPrintShareNumber;
      private Integer totalNotPrintNumber;
      private Long printerId;
      private Integer containBasicClass;
      private Integer type;

      PrintBuilder() {
      }

      @JsonProperty("id")
      public Print.PrintBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("receiptType")
      public Print.PrintBuilder receiptType(final Integer receiptType) {
         this.receiptType = receiptType;
         return this;
      }

      @JsonProperty("receiptId")
      public Print.PrintBuilder receiptId(final Long receiptId) {
         this.receiptId = receiptId;
         return this;
      }

      @JsonProperty("receiptSerialNumber")
      public Print.PrintBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      @JsonProperty("projectIds")
      public Print.PrintBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("receiptReviewer")
      public Print.PrintBuilder receiptReviewer(final String receiptReviewer) {
         this.receiptReviewer = receiptReviewer;
         return this;
      }

      @JsonProperty("receiptReviewTime")
      public Print.PrintBuilder receiptReviewTime(final LocalDateTime receiptReviewTime) {
         this.receiptReviewTime = receiptReviewTime;
         return this;
      }

      @JsonProperty("boolPrinted")
      public Print.PrintBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("totalPrintNumber")
      public Print.PrintBuilder totalPrintNumber(final Integer totalPrintNumber) {
         this.totalPrintNumber = totalPrintNumber;
         return this;
      }

      @JsonProperty("totalPrintShareNumber")
      public Print.PrintBuilder totalPrintShareNumber(final Integer totalPrintShareNumber) {
         this.totalPrintShareNumber = totalPrintShareNumber;
         return this;
      }

      @JsonProperty("totalNotPrintNumber")
      public Print.PrintBuilder totalNotPrintNumber(final Integer totalNotPrintNumber) {
         this.totalNotPrintNumber = totalNotPrintNumber;
         return this;
      }

      @JsonProperty("printerId")
      public Print.PrintBuilder printerId(final Long printerId) {
         this.printerId = printerId;
         return this;
      }

      @JsonProperty("containBasicClass")
      public Print.PrintBuilder containBasicClass(final Integer containBasicClass) {
         this.containBasicClass = containBasicClass;
         return this;
      }

      @JsonProperty("type")
      public Print.PrintBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public Print build() {
         return new Print(
            this.id,
            this.receiptType,
            this.receiptId,
            this.receiptSerialNumber,
            this.projectIds,
            this.receiptReviewer,
            this.receiptReviewTime,
            this.boolPrinted,
            this.totalPrintNumber,
            this.totalPrintShareNumber,
            this.totalNotPrintNumber,
            this.printerId,
            this.containBasicClass,
            this.type
         );
      }

      @Override
      public String toString() {
         return "Print.PrintBuilder(id="
            + this.id
            + ", receiptType="
            + this.receiptType
            + ", receiptId="
            + this.receiptId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", projectIds="
            + this.projectIds
            + ", receiptReviewer="
            + this.receiptReviewer
            + ", receiptReviewTime="
            + this.receiptReviewTime
            + ", boolPrinted="
            + this.boolPrinted
            + ", totalPrintNumber="
            + this.totalPrintNumber
            + ", totalPrintShareNumber="
            + this.totalPrintShareNumber
            + ", totalNotPrintNumber="
            + this.totalNotPrintNumber
            + ", printerId="
            + this.printerId
            + ", containBasicClass="
            + this.containBasicClass
            + ", type="
            + this.type
            + ")";
      }
   }
}
