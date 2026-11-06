package com.hzchum.scim.business.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "BusinessPrice对象", description = "商务产品计价表 ")
public class BusinessPriceDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id", notes = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "level", value = "分支机构等级", notes = "分支机构等级")
   private Integer level;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private BusinessPriceProjectDTO project;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "pricingName", value = "计价名称", notes = "计价名称")
   private String pricingName;
   @ApiModelProperty(name = "pricingMannerEnum", value = "计价类型", notes = "计价类型")
   private Integer pricingMannerEnum;
   @ApiModelProperty(name = "pricingUnitTypeEnum", value = "计价单位类型 1千克 2吨 ", notes = "计价单位 1千克 2吨")
   private Integer pricingUnitTypeEnum;
   @ApiModelProperty(name = "pricingWeightTypeEnum", value = "(构件)计价重量类型 1净重 2毛重 4图纸重'", notes = "(构件)计价重量类型 1净重 2毛重 4图纸重'")
   private Integer pricingWeightTypeEnum;
   @ApiModelProperty(name = "totalQuantity", value = "总数", notes = "总数")
   private BigDecimal totalQuantity;
   @ApiModelProperty(name = "pricingMete", value = "计价量", notes = "计价量")
   private BigDecimal pricingMete;
   @ApiModelProperty(name = "unitPrice", value = "单价(元/kg/m/m²)", notes = "单价(元/kg/m/m²)")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2已通过 4已驳回", notes = "审核状态 1未审核 2已通过 4已驳回")
   private Integer auditStatus;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "businessPriceDetailList", value = "产品列表", notes = "产品列表")
   private List<BusinessPriceDetailDTO> businessPriceDetailList;

   public static BusinessPriceDTO.BusinessPriceDTOBuilder builder() {
      return new BusinessPriceDTO.BusinessPriceDTOBuilder();
   }

   public BusinessPriceDTO() {
   }

   public BusinessPriceDTO(
      final Long id,
      final Long projectId,
      final Long branchCompanyId,
      final Integer level,
      final BusinessPriceProjectDTO project,
      final Integer productType,
      final String pricingName,
      final Integer pricingMannerEnum,
      final Integer pricingUnitTypeEnum,
      final Integer pricingWeightTypeEnum,
      final BigDecimal totalQuantity,
      final BigDecimal pricingMete,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final String remark,
      final Long createUserId,
      final String createUserName,
      final LocalDateTime createTime,
      final Integer auditStatus,
      final List<BusinessPriceDetailDTO> businessPriceDetailList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.branchCompanyId = branchCompanyId;
      this.level = level;
      this.project = project;
      this.productType = productType;
      this.pricingName = pricingName;
      this.pricingMannerEnum = pricingMannerEnum;
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
      this.totalQuantity = totalQuantity;
      this.pricingMete = pricingMete;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.remark = remark;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.createTime = createTime;
      this.auditStatus = auditStatus;
      this.businessPriceDetailList = businessPriceDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public BusinessPriceProjectDTO getProject() {
      return this.project;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getPricingName() {
      return this.pricingName;
   }

   public Integer getPricingMannerEnum() {
      return this.pricingMannerEnum;
   }

   public Integer getPricingUnitTypeEnum() {
      return this.pricingUnitTypeEnum;
   }

   public Integer getPricingWeightTypeEnum() {
      return this.pricingWeightTypeEnum;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getPricingMete() {
      return this.pricingMete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public List<BusinessPriceDetailDTO> getBusinessPriceDetailList() {
      return this.businessPriceDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setProject(final BusinessPriceProjectDTO project) {
      this.project = project;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setPricingName(final String pricingName) {
      this.pricingName = pricingName;
   }

   public void setPricingMannerEnum(final Integer pricingMannerEnum) {
      this.pricingMannerEnum = pricingMannerEnum;
   }

   public void setPricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
      this.pricingUnitTypeEnum = pricingUnitTypeEnum;
   }

   public void setPricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
      this.pricingWeightTypeEnum = pricingWeightTypeEnum;
   }

   public void setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setPricingMete(final BigDecimal pricingMete) {
      this.pricingMete = pricingMete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setBusinessPriceDetailList(final List<BusinessPriceDetailDTO> businessPriceDetailList) {
      this.businessPriceDetailList = businessPriceDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceDTO)) {
         return false;
      }

      BusinessPriceDTO other = (BusinessPriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$level = this.getLevel();
               Object other$level = other.getLevel();
               if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$pricingMannerEnum = this.getPricingMannerEnum();
                     Object other$pricingMannerEnum = other.getPricingMannerEnum();
                     if (this$pricingMannerEnum == null ? other$pricingMannerEnum == null : this$pricingMannerEnum.equals(other$pricingMannerEnum)) {
                        Object this$pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
                        Object other$pricingUnitTypeEnum = other.getPricingUnitTypeEnum();
                        if (this$pricingUnitTypeEnum == null ? other$pricingUnitTypeEnum == null : this$pricingUnitTypeEnum.equals(other$pricingUnitTypeEnum)) {
                           Object this$pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
                           Object other$pricingWeightTypeEnum = other.getPricingWeightTypeEnum();
                           if (this$pricingWeightTypeEnum == null
                              ? other$pricingWeightTypeEnum == null
                              : this$pricingWeightTypeEnum.equals(other$pricingWeightTypeEnum)) {
                              Object this$createUserId = this.getCreateUserId();
                              Object other$createUserId = other.getCreateUserId();
                              if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$pricingName = this.getPricingName();
                                       Object other$pricingName = other.getPricingName();
                                       if (this$pricingName == null ? other$pricingName == null : this$pricingName.equals(other$pricingName)) {
                                          Object this$totalQuantity = this.getTotalQuantity();
                                          Object other$totalQuantity = other.getTotalQuantity();
                                          if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
                                             Object this$pricingMete = this.getPricingMete();
                                             Object other$pricingMete = other.getPricingMete();
                                             if (this$pricingMete == null ? other$pricingMete == null : this$pricingMete.equals(other$pricingMete)) {
                                                Object this$unitPrice = this.getUnitPrice();
                                                Object other$unitPrice = other.getUnitPrice();
                                                if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                   Object this$totalPrice = this.getTotalPrice();
                                                   Object other$totalPrice = other.getTotalPrice();
                                                   if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$createUserName = this.getCreateUserName();
                                                         Object other$createUserName = other.getCreateUserName();
                                                         if (this$createUserName == null
                                                            ? other$createUserName == null
                                                            : this$createUserName.equals(other$createUserName)) {
                                                            Object this$createTime = this.getCreateTime();
                                                            Object other$createTime = other.getCreateTime();
                                                            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                               Object this$businessPriceDetailList = this.getBusinessPriceDetailList();
                                                               Object other$businessPriceDetailList = other.getBusinessPriceDetailList();
                                                               return this$businessPriceDetailList == null
                                                                  ? other$businessPriceDetailList == null
                                                                  : this$businessPriceDetailList.equals(other$businessPriceDetailList);
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
      return other instanceof BusinessPriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingMannerEnum = this.getPricingMannerEnum();
      result = result * 59 + ($pricingMannerEnum == null ? 43 : $pricingMannerEnum.hashCode());
      Object $pricingUnitTypeEnum = this.getPricingUnitTypeEnum();
      result = result * 59 + ($pricingUnitTypeEnum == null ? 43 : $pricingUnitTypeEnum.hashCode());
      Object $pricingWeightTypeEnum = this.getPricingWeightTypeEnum();
      result = result * 59 + ($pricingWeightTypeEnum == null ? 43 : $pricingWeightTypeEnum.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $pricingName = this.getPricingName();
      result = result * 59 + ($pricingName == null ? 43 : $pricingName.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $pricingMete = this.getPricingMete();
      result = result * 59 + ($pricingMete == null ? 43 : $pricingMete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $businessPriceDetailList = this.getBusinessPriceDetailList();
      return result * 59 + ($businessPriceDetailList == null ? 43 : $businessPriceDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", level="
         + this.getLevel()
         + ", project="
         + this.getProject()
         + ", productType="
         + this.getProductType()
         + ", pricingName="
         + this.getPricingName()
         + ", pricingMannerEnum="
         + this.getPricingMannerEnum()
         + ", pricingUnitTypeEnum="
         + this.getPricingUnitTypeEnum()
         + ", pricingWeightTypeEnum="
         + this.getPricingWeightTypeEnum()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", pricingMete="
         + this.getPricingMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", businessPriceDetailList="
         + this.getBusinessPriceDetailList()
         + ")";
   }

   public static class BusinessPriceDTOBuilder {
      private Long id;
      private Long projectId;
      private Long branchCompanyId;
      private Integer level;
      private BusinessPriceProjectDTO project;
      private Integer productType;
      private String pricingName;
      private Integer pricingMannerEnum;
      private Integer pricingUnitTypeEnum;
      private Integer pricingWeightTypeEnum;
      private BigDecimal totalQuantity;
      private BigDecimal pricingMete;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private String remark;
      private Long createUserId;
      private String createUserName;
      private LocalDateTime createTime;
      private Integer auditStatus;
      private List<BusinessPriceDetailDTO> businessPriceDetailList;

      BusinessPriceDTOBuilder() {
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder project(final BusinessPriceProjectDTO project) {
         this.project = project;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder pricingName(final String pricingName) {
         this.pricingName = pricingName;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder pricingMannerEnum(final Integer pricingMannerEnum) {
         this.pricingMannerEnum = pricingMannerEnum;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder pricingUnitTypeEnum(final Integer pricingUnitTypeEnum) {
         this.pricingUnitTypeEnum = pricingUnitTypeEnum;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder pricingWeightTypeEnum(final Integer pricingWeightTypeEnum) {
         this.pricingWeightTypeEnum = pricingWeightTypeEnum;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder totalQuantity(final BigDecimal totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder pricingMete(final BigDecimal pricingMete) {
         this.pricingMete = pricingMete;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public BusinessPriceDTO.BusinessPriceDTOBuilder businessPriceDetailList(final List<BusinessPriceDetailDTO> businessPriceDetailList) {
         this.businessPriceDetailList = businessPriceDetailList;
         return this;
      }

      public BusinessPriceDTO build() {
         return new BusinessPriceDTO(
            this.id,
            this.projectId,
            this.branchCompanyId,
            this.level,
            this.project,
            this.productType,
            this.pricingName,
            this.pricingMannerEnum,
            this.pricingUnitTypeEnum,
            this.pricingWeightTypeEnum,
            this.totalQuantity,
            this.pricingMete,
            this.unitPrice,
            this.totalPrice,
            this.remark,
            this.createUserId,
            this.createUserName,
            this.createTime,
            this.auditStatus,
            this.businessPriceDetailList
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceDTO.BusinessPriceDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", level="
            + this.level
            + ", project="
            + this.project
            + ", productType="
            + this.productType
            + ", pricingName="
            + this.pricingName
            + ", pricingMannerEnum="
            + this.pricingMannerEnum
            + ", pricingUnitTypeEnum="
            + this.pricingUnitTypeEnum
            + ", pricingWeightTypeEnum="
            + this.pricingWeightTypeEnum
            + ", totalQuantity="
            + this.totalQuantity
            + ", pricingMete="
            + this.pricingMete
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", createTime="
            + this.createTime
            + ", auditStatus="
            + this.auditStatus
            + ", businessPriceDetailList="
            + this.businessPriceDetailList
            + ")";
      }
   }
}
