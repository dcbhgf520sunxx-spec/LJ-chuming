package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("班组产量DTO")
public class MesTeamProductionDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("产品")
   private ProductInfo product;
   @ApiModelProperty("核算量")
   private BigDecimal accountingQuantity;
   @ApiModelProperty("定义类型")
   private String defineType;
   @ApiModelProperty("单价(元)")
   private BigDecimal price;
   @ApiModelProperty("总价(元)")
   private BigDecimal totalPrice;
   @ApiModelProperty("生产日期")
   private LocalDateTime productionDate;
   @ApiModelProperty("审批日期")
   private LocalDateTime approvalTime;
   @ApiModelProperty("审批人")
   private NameInfo approvalUser;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getName() {
      return this.name;
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public String getDefineType() {
      return this.defineType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public LocalDateTime getProductionDate() {
      return this.productionDate;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public NameInfo getApprovalUser() {
      return this.approvalUser;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
   }

   public void setDefineType(final String defineType) {
      this.defineType = defineType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setProductionDate(final LocalDateTime productionDate) {
      this.productionDate = productionDate;
   }

   public void setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
   }

   public void setApprovalUser(final NameInfo approvalUser) {
      this.approvalUser = approvalUser;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamProductionDTO)) {
         return false;
      }

      MesTeamProductionDTO other = (MesTeamProductionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$product = this.getProduct();
               Object other$product = other.getProduct();
               if (this$product == null ? other$product == null : this$product.equals(other$product)) {
                  Object this$accountingQuantity = this.getAccountingQuantity();
                  Object other$accountingQuantity = other.getAccountingQuantity();
                  if (this$accountingQuantity == null ? other$accountingQuantity == null : this$accountingQuantity.equals(other$accountingQuantity)) {
                     Object this$defineType = this.getDefineType();
                     Object other$defineType = other.getDefineType();
                     if (this$defineType == null ? other$defineType == null : this$defineType.equals(other$defineType)) {
                        Object this$price = this.getPrice();
                        Object other$price = other.getPrice();
                        if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                           Object this$totalPrice = this.getTotalPrice();
                           Object other$totalPrice = other.getTotalPrice();
                           if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                              Object this$productionDate = this.getProductionDate();
                              Object other$productionDate = other.getProductionDate();
                              if (this$productionDate == null ? other$productionDate == null : this$productionDate.equals(other$productionDate)) {
                                 Object this$approvalTime = this.getApprovalTime();
                                 Object other$approvalTime = other.getApprovalTime();
                                 if (this$approvalTime == null ? other$approvalTime == null : this$approvalTime.equals(other$approvalTime)) {
                                    Object this$approvalUser = this.getApprovalUser();
                                    Object other$approvalUser = other.getApprovalUser();
                                    return this$approvalUser == null ? other$approvalUser == null : this$approvalUser.equals(other$approvalUser);
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
      return other instanceof MesTeamProductionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $defineType = this.getDefineType();
      result = result * 59 + ($defineType == null ? 43 : $defineType.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $productionDate = this.getProductionDate();
      result = result * 59 + ($productionDate == null ? 43 : $productionDate.hashCode());
      Object $approvalTime = this.getApprovalTime();
      result = result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
      Object $approvalUser = this.getApprovalUser();
      return result * 59 + ($approvalUser == null ? 43 : $approvalUser.hashCode());
   }

   @Override
   public String toString() {
      return "MesTeamProductionDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", name="
         + this.getName()
         + ", product="
         + this.getProduct()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", defineType="
         + this.getDefineType()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", productionDate="
         + this.getProductionDate()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", approvalUser="
         + this.getApprovalUser()
         + ")";
   }
}
