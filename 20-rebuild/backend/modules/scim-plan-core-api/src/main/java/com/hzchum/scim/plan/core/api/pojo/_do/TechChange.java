package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechChange对象", description = "技术变更表 ")
@Entity
@TableName("tech_change")
@Table(name = "tech_change")
public class TechChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @Column
   private Long projectId;
   @ApiModelProperty("单体id")
   @Column
   private Long monomerId;
   @ApiModelProperty("区域id")
   @Column
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty("产品id")
   @Column
   private Long productId;
   @ApiModelProperty("产品名称")
   @Column
   private String productName;
   @ApiModelProperty("产品编号")
   @Column
   private String serialNumber;
   @ApiModelProperty("产品分类 1零件 2构件 4围护 8配套件 16组立")
   @Column
   private Integer productType;
   @ApiModelProperty("变更原因")
   @Column
   private Long reasonId;
   @ApiModelProperty("变更信息 构件")
   @Column
   private String changeInfo;
   @ApiModelProperty("变更用户id")
   @Column
   private Long userId;
   @ApiModelProperty("变更用户id")
   @Column
   private String userName;
   @ApiModelProperty("描述")
   @Column
   private String changeRemark;
   @ApiModelProperty("附件id字符串")
   @Column
   private String attachments;

   public static TechChange.TechChangeBuilder builder() {
      return new TechChange.TechChangeBuilder();
   }

   public TechChange() {
   }

   public TechChange(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long productId,
      final String productName,
      final String serialNumber,
      final Integer productType,
      final Long reasonId,
      final String changeInfo,
      final Long userId,
      final String userName,
      final String changeRemark,
      final String attachments
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.productId = productId;
      this.productName = productName;
      this.serialNumber = serialNumber;
      this.productType = productType;
      this.reasonId = reasonId;
      this.changeInfo = changeInfo;
      this.userId = userId;
      this.userName = userName;
      this.changeRemark = changeRemark;
      this.attachments = attachments;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getReasonId() {
      return this.reasonId;
   }

   public String getChangeInfo() {
      return this.changeInfo;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public TechChange setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechChange setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechChange setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechChange setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechChange setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   public TechChange setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechChange setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   public TechChange setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechChange setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechChange setReasonId(final Long reasonId) {
      this.reasonId = reasonId;
      return this;
   }

   public TechChange setChangeInfo(final String changeInfo) {
      this.changeInfo = changeInfo;
      return this;
   }

   public TechChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechChange setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public TechChange setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
      return this;
   }

   public TechChange setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   @Override
   public String toString() {
      return "TechChange(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", productId="
         + this.getProductId()
         + ", productName="
         + this.getProductName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", reasonId="
         + this.getReasonId()
         + ", changeInfo="
         + this.getChangeInfo()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChange)) {
         return false;
      }

      TechChange other = (TechChange)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$reasonId = this.getReasonId();
                           Object other$reasonId = other.getReasonId();
                           if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$productName = this.getProductName();
                                 Object other$productName = other.getProductName();
                                 if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$changeInfo = this.getChangeInfo();
                                       Object other$changeInfo = other.getChangeInfo();
                                       if (this$changeInfo == null ? other$changeInfo == null : this$changeInfo.equals(other$changeInfo)) {
                                          Object this$userName = this.getUserName();
                                          Object other$userName = other.getUserName();
                                          if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                             Object this$changeRemark = this.getChangeRemark();
                                             Object other$changeRemark = other.getChangeRemark();
                                             if (this$changeRemark == null ? other$changeRemark == null : this$changeRemark.equals(other$changeRemark)) {
                                                Object this$attachments = this.getAttachments();
                                                Object other$attachments = other.getAttachments();
                                                return this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $changeInfo = this.getChangeInfo();
      result = result * 59 + ($changeInfo == null ? 43 : $changeInfo.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   public static class TechChangeBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long productId;
      private String productName;
      private String serialNumber;
      private Integer productType;
      private Long reasonId;
      private String changeInfo;
      private Long userId;
      private String userName;
      private String changeRemark;
      private String attachments;

      TechChangeBuilder() {
      }

      public TechChange.TechChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChange.TechChangeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechChange.TechChangeBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechChange.TechChangeBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechChange.TechChangeBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public TechChange.TechChangeBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechChange.TechChangeBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      public TechChange.TechChangeBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChange.TechChangeBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechChange.TechChangeBuilder reasonId(final Long reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public TechChange.TechChangeBuilder changeInfo(final String changeInfo) {
         this.changeInfo = changeInfo;
         return this;
      }

      public TechChange.TechChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechChange.TechChangeBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechChange.TechChangeBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechChange.TechChangeBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public TechChange build() {
         return new TechChange(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.productId,
            this.productName,
            this.serialNumber,
            this.productType,
            this.reasonId,
            this.changeInfo,
            this.userId,
            this.userName,
            this.changeRemark,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "TechChange.TechChangeBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", productId="
            + this.productId
            + ", productName="
            + this.productName
            + ", serialNumber="
            + this.serialNumber
            + ", productType="
            + this.productType
            + ", reasonId="
            + this.reasonId
            + ", changeInfo="
            + this.changeInfo
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", changeRemark="
            + this.changeRemark
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
