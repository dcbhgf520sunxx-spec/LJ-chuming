package com.hzchum.scim.project.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "ProjectReturnProductMainDTOParam对象", description = "制成品退货主表保存参数")
public class ProjectReturnProductMainDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty("制成品类型")
   private Integer productType;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   private Integer handleMethod;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(购买方)", notes = "分支机构id(购买方)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "warehouseId", value = "存放仓库id", notes = "存放仓库id")
   private Long warehouseId;
   @ApiModelProperty("运费")
   private BigDecimal freight;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("发运产品列表")
   @NotEmpty(message = "产品列表不能为空!")
   private List<ProjectReturnProductChildDTOParam> projectReturnProductChildDTOParamList;
   @ApiModelProperty("退货产品状态 1已发运 2已入库 4未入库")
   private Integer status;
   @ApiModelProperty("附件id列表")
   private List<Long> attachmentIds;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ProjectReturnProductChildDTOParam> getProjectReturnProductChildDTOParamList() {
      return this.projectReturnProductChildDTOParamList;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProjectReturnProductChildDTOParamList(final List<ProjectReturnProductChildDTOParam> projectReturnProductChildDTOParamList) {
      this.projectReturnProductChildDTOParamList = projectReturnProductChildDTOParamList;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductMainDTOParam)) {
         return false;
      }

      ProjectReturnProductMainDTOParam other = (ProjectReturnProductMainDTOParam)o;
      if (!other.canEqual(this)) {
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
               Object this$handleMethod = this.getHandleMethod();
               Object other$handleMethod = other.getHandleMethod();
               if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                  Object this$branchCompanyId = this.getBranchCompanyId();
                  Object other$branchCompanyId = other.getBranchCompanyId();
                  if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$freight = this.getFreight();
                           Object other$freight = other.getFreight();
                           if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                 Object this$projectReturnProductChildDTOParamList = this.getProjectReturnProductChildDTOParamList();
                                 Object other$projectReturnProductChildDTOParamList = other.getProjectReturnProductChildDTOParamList();
                                 if (this$projectReturnProductChildDTOParamList == null
                                    ? other$projectReturnProductChildDTOParamList == null
                                    : this$projectReturnProductChildDTOParamList.equals(other$projectReturnProductChildDTOParamList)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnProductMainDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $projectReturnProductChildDTOParamList = this.getProjectReturnProductChildDTOParamList();
      result = result * 59 + ($projectReturnProductChildDTOParamList == null ? 43 : $projectReturnProductChildDTOParamList.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnProductMainDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", productType="
         + this.getProductType()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", freight="
         + this.getFreight()
         + ", remark="
         + this.getRemark()
         + ", projectReturnProductChildDTOParamList="
         + this.getProjectReturnProductChildDTOParamList()
         + ", status="
         + this.getStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
