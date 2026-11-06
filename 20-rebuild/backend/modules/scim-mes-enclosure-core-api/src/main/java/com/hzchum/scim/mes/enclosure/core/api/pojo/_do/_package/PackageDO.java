package com.hzchum.scim.mes.enclosure.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(description = "包 ")
public class PackageDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("包单号")
   private String serialNumber;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("状态 [0 未装车, 1 已装车, 2发运]")
   private Integer status;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("打印状态 [0 未打印, 1 已打印]")
   private Boolean printType;
   @ApiModelProperty("打印数量")
   private Integer printQuantity;
   @ApiModelProperty("操作人")
   private Long userId;
   @ApiModelProperty("操作人名")
   private String userName;
   @ApiModelProperty("打包日期")
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
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

   public Boolean getPrintType() {
      return this.printType;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPrintType(final Boolean printType) {
      this.printType = printType;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PackageDO)) {
         return false;
      }

      PackageDO other = (PackageDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$printType = this.getPrintType();
               Object other$printType = other.getPrintType();
               if (this$printType == null ? other$printType == null : this$printType.equals(other$printType)) {
                  Object this$printQuantity = this.getPrintQuantity();
                  Object other$printQuantity = other.getPrintQuantity();
                  if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof PackageDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $printType = this.getPrintType();
      result = result * 59 + ($printType == null ? 43 : $printType.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "PackageDO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", status="
         + this.getStatus()
         + ", remark="
         + this.getRemark()
         + ", printType="
         + this.getPrintType()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
