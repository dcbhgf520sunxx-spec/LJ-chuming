package com.hzchum.scim.mes.building.core.api.pojo._doModel._package;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPackage对象", description = "包")
@Entity
@TableName("mes_building_package")
@Table(name = "mes_building_package", indexes = @Index(name = "serialNumberIndex", columnList = "serial_number,project_id"))
public class MesBuildingPackage extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "serialNumber", value = "包单号", notes = "包单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '包单号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "status", value = "状态 [0 未装车, 1 已装车 2 发运 4 取消发运]", notes = "状态 [0 未装车, 1 已装车 2 发运 4 取消发运]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态 [0 未装车, 1 已装车 2 发运 4 取消发运]'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "warehouseId", value = "存储库位id", notes = "存储库位id")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20) COMMENT '存储库为id'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "printType", value = "打印状态 [0 未打印, 1 已打印]", notes = "打印状态 [0 未打印, 1 已打印]")
   @JsonProperty("printType")
   @JSONField(name = "printType")
   @TableField("print_type")
   @Column(name = "print_type", columnDefinition = "tinyint(1) default '0' COMMENT '打印状态 [0 未打印, 1 已打印]'", nullable = false)
   private Boolean printType;
   @ApiModelProperty(name = "printQuantity", value = "打印数量", notes = "打印数量")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '打印数量'", nullable = false)
   private BigDecimal printQuantity;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人", notes = "操作人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '操作人'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "category")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT ''", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "printTime")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime printTime;
   @ApiModelProperty(name = "attachmentIds", value = "附件ids", notes = "附件ids")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(256)  COMMENT '操作人'", nullable = true)
   private String attachmentIds;

   public static MesBuildingPackage.MesBuildingPackageBuilder builder() {
      return new MesBuildingPackage.MesBuildingPackageBuilder();
   }

   public MesBuildingPackage() {
   }

   public MesBuildingPackage(
      final Long id,
      final Long projectId,
      final String serialNumber,
      final Integer productType,
      final Integer status,
      final String remark,
      final Long warehouseId,
      final Boolean printType,
      final BigDecimal printQuantity,
      final Long userId,
      final String userName,
      final Integer category,
      final LocalDateTime printTime,
      final String attachmentIds
   ) {
      this.id = id;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.productType = productType;
      this.status = status;
      this.remark = remark;
      this.warehouseId = warehouseId;
      this.printType = printType;
      this.printQuantity = printQuantity;
      this.userId = userId;
      this.userName = userName;
      this.category = category;
      this.printTime = printTime;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Boolean getPrintType() {
      return this.printType;
   }

   public BigDecimal getPrintQuantity() {
      return this.printQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getCategory() {
      return this.category;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   @JsonProperty("id")
   public MesBuildingPackage setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingPackage setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingPackage setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingPackage setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingPackage setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingPackage setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public MesBuildingPackage setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   @JsonProperty("printType")
   public MesBuildingPackage setPrintType(final Boolean printType) {
      this.printType = printType;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingPackage setPrintQuantity(final BigDecimal printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingPackage setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingPackage setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("category")
   public MesBuildingPackage setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("printTime")
   public MesBuildingPackage setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @JsonProperty("attachmentIds")
   public MesBuildingPackage setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPackage(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", status="
         + this.getStatus()
         + ", remark="
         + this.getRemark()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", printType="
         + this.getPrintType()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", category="
         + this.getCategory()
         + ", printTime="
         + this.getPrintTime()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackage)) {
         return false;
      }

      MesBuildingPackage other = (MesBuildingPackage)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$warehouseId = this.getWarehouseId();
                  Object other$warehouseId = other.getWarehouseId();
                  if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                     Object this$printType = this.getPrintType();
                     Object other$printType = other.getPrintType();
                     if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$category = this.getCategory();
                           Object other$category = other.getCategory();
                           if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$printQuantity = this.getPrintQuantity();
                                    Object other$printQuantity = other.getPrintQuantity();
                                    if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$printTime = this.getPrintTime();
                                          Object other$printTime = other.getPrintTime();
                                          if (this$printTime == null ? other$printTime == null : this$printTime.equals(other$printTime)) {
                                             Object this$attachmentIds = this.getAttachmentIds();
                                             Object other$attachmentIds = other.getAttachmentIds();
                                             return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof MesBuildingPackage;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class MesBuildingPackageBuilder {
      private Long id;
      private Long projectId;
      private String serialNumber;
      private Integer productType;
      private Integer status;
      private String remark;
      private Long warehouseId;
      private Boolean printType;
      private BigDecimal printQuantity;
      private Long userId;
      private String userName;
      private Integer category;
      private LocalDateTime printTime;
      private String attachmentIds;

      MesBuildingPackageBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPackage.MesBuildingPackageBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingPackage.MesBuildingPackageBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingPackage.MesBuildingPackageBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingPackage.MesBuildingPackageBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingPackage.MesBuildingPackageBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingPackage.MesBuildingPackageBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingPackage.MesBuildingPackageBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      @JsonProperty("printType")
      public MesBuildingPackage.MesBuildingPackageBuilder printType(final Boolean printType) {
         this.printType = printType;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingPackage.MesBuildingPackageBuilder printQuantity(final BigDecimal printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingPackage.MesBuildingPackageBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingPackage.MesBuildingPackageBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("category")
      public MesBuildingPackage.MesBuildingPackageBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("printTime")
      public MesBuildingPackage.MesBuildingPackageBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      @JsonProperty("attachmentIds")
      public MesBuildingPackage.MesBuildingPackageBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public MesBuildingPackage build() {
         return new MesBuildingPackage(
            this.id,
            this.projectId,
            this.serialNumber,
            this.productType,
            this.status,
            this.remark,
            this.warehouseId,
            this.printType,
            this.printQuantity,
            this.userId,
            this.userName,
            this.category,
            this.printTime,
            this.attachmentIds
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPackage.MesBuildingPackageBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", serialNumber="
            + this.serialNumber
            + ", productType="
            + this.productType
            + ", status="
            + this.status
            + ", remark="
            + this.remark
            + ", warehouseId="
            + this.warehouseId
            + ", printType="
            + this.printType
            + ", printQuantity="
            + this.printQuantity
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", category="
            + this.category
            + ", printTime="
            + this.printTime
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
