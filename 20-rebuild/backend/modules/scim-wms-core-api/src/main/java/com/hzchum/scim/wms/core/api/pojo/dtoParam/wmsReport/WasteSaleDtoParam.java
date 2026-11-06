package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
public class WasteSaleDtoParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "saleDate", value = "出售日期", notes = "出售日期")
   @NotNull(message = "出售日期不能为空!")
   private LocalDate saleDate;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   @NotNull(message = "出售单位不能为空!")
   private Long branchCompanyId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   @NotNull(message = "废料合同id不能为空!")
   private Long contractWasteId;
   @ApiModelProperty(name = "plateNumber", value = "车牌号", notes = "车牌号")
   @NotBlank(message = "车牌号不能为空!")
   @Size(max = 32, message = "车牌号过长!")
   private String plateNumber;
   @ApiModelProperty(name = "creatorRemark", value = "创建人备注", notes = "创建人备注")
   @Size(max = 1000, message = "备注字数太长!")
   private String creatorRemark;
   @Valid
   @NotEmpty(message = "废料明细不能为空!")
   @Size(max = 20, message = "请不要超过20条废料明细!")
   @ApiModelProperty(name = "wasteSaleDetailList", value = "废料销售明细列表", notes = "废料销售明细列表")
   private List<WasteSaleDetailDtoParam> wasteSaleDetailList;

   public static WasteSaleDtoParam.WasteSaleDtoParamBuilder builder() {
      return new WasteSaleDtoParam.WasteSaleDtoParamBuilder();
   }

   public WasteSaleDtoParam() {
   }

   public WasteSaleDtoParam(
      final Long id,
      final LocalDate saleDate,
      final Long branchCompanyId,
      final Long contractWasteId,
      final String plateNumber,
      final String creatorRemark,
      final List<WasteSaleDetailDtoParam> wasteSaleDetailList
   ) {
      this.id = id;
      this.saleDate = saleDate;
      this.branchCompanyId = branchCompanyId;
      this.contractWasteId = contractWasteId;
      this.plateNumber = plateNumber;
      this.creatorRemark = creatorRemark;
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getSaleDate() {
      return this.saleDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getPlateNumber() {
      return this.plateNumber;
   }

   public String getCreatorRemark() {
      return this.creatorRemark;
   }

   public List<WasteSaleDetailDtoParam> getWasteSaleDetailList() {
      return this.wasteSaleDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSaleDate(final LocalDate saleDate) {
      this.saleDate = saleDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setPlateNumber(final String plateNumber) {
      this.plateNumber = plateNumber;
   }

   public void setCreatorRemark(final String creatorRemark) {
      this.creatorRemark = creatorRemark;
   }

   public void setWasteSaleDetailList(final List<WasteSaleDetailDtoParam> wasteSaleDetailList) {
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDtoParam)) {
         return false;
      }

      WasteSaleDtoParam other = (WasteSaleDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$saleDate = this.getSaleDate();
               Object other$saleDate = other.getSaleDate();
               if (this$saleDate == null ? other$saleDate == null : this$saleDate.equals(other$saleDate)) {
                  Object this$plateNumber = this.getPlateNumber();
                  Object other$plateNumber = other.getPlateNumber();
                  if (this$plateNumber == null ? other$plateNumber == null : this$plateNumber.equals(other$plateNumber)) {
                     Object this$creatorRemark = this.getCreatorRemark();
                     Object other$creatorRemark = other.getCreatorRemark();
                     if (this$creatorRemark == null ? other$creatorRemark == null : this$creatorRemark.equals(other$creatorRemark)) {
                        Object this$wasteSaleDetailList = this.getWasteSaleDetailList();
                        Object other$wasteSaleDetailList = other.getWasteSaleDetailList();
                        return this$wasteSaleDetailList == null
                           ? other$wasteSaleDetailList == null
                           : this$wasteSaleDetailList.equals(other$wasteSaleDetailList);
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
      return other instanceof WasteSaleDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $saleDate = this.getSaleDate();
      result = result * 59 + ($saleDate == null ? 43 : $saleDate.hashCode());
      Object $plateNumber = this.getPlateNumber();
      result = result * 59 + ($plateNumber == null ? 43 : $plateNumber.hashCode());
      Object $creatorRemark = this.getCreatorRemark();
      result = result * 59 + ($creatorRemark == null ? 43 : $creatorRemark.hashCode());
      Object $wasteSaleDetailList = this.getWasteSaleDetailList();
      return result * 59 + ($wasteSaleDetailList == null ? 43 : $wasteSaleDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleDtoParam(id="
         + this.getId()
         + ", saleDate="
         + this.getSaleDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", plateNumber="
         + this.getPlateNumber()
         + ", creatorRemark="
         + this.getCreatorRemark()
         + ", wasteSaleDetailList="
         + this.getWasteSaleDetailList()
         + ")";
   }

   public static class WasteSaleDtoParamBuilder {
      private Long id;
      private LocalDate saleDate;
      private Long branchCompanyId;
      private Long contractWasteId;
      private String plateNumber;
      private String creatorRemark;
      private List<WasteSaleDetailDtoParam> wasteSaleDetailList;

      WasteSaleDtoParamBuilder() {
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder saleDate(final LocalDate saleDate) {
         this.saleDate = saleDate;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder plateNumber(final String plateNumber) {
         this.plateNumber = plateNumber;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder creatorRemark(final String creatorRemark) {
         this.creatorRemark = creatorRemark;
         return this;
      }

      public WasteSaleDtoParam.WasteSaleDtoParamBuilder wasteSaleDetailList(final List<WasteSaleDetailDtoParam> wasteSaleDetailList) {
         this.wasteSaleDetailList = wasteSaleDetailList;
         return this;
      }

      public WasteSaleDtoParam build() {
         return new WasteSaleDtoParam(
            this.id, this.saleDate, this.branchCompanyId, this.contractWasteId, this.plateNumber, this.creatorRemark, this.wasteSaleDetailList
         );
      }

      @Override
      public String toString() {
         return "WasteSaleDtoParam.WasteSaleDtoParamBuilder(id="
            + this.id
            + ", saleDate="
            + this.saleDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", contractWasteId="
            + this.contractWasteId
            + ", plateNumber="
            + this.plateNumber
            + ", creatorRemark="
            + this.creatorRemark
            + ", wasteSaleDetailList="
            + this.wasteSaleDetailList
            + ")";
      }
   }
}
