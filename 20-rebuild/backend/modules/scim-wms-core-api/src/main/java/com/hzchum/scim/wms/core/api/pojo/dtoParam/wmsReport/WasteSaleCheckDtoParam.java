package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
public class WasteSaleCheckDtoParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "废料销售记录id不能为空!")
   private Long id;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @Max(value = 4L, message = "审核状态有误")
   @Min(value = 2L, message = "审核状态有误!")
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditorRemark", value = "审核人备注", notes = "审核人备注")
   @Size(max = 1000, message = "备注字数太长!")
   private String auditorRemark;
   @Valid
   @NotEmpty(message = "废料明细不能为空!")
   @ApiModelProperty(name = "wasteSaleDetailList", value = "废料销售明细列表", notes = "废料销售明细列表")
   private List<WasteSaleDetailCheckDtoParam> wasteSaleDetailList;

   public static WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder builder() {
      return new WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder();
   }

   public WasteSaleCheckDtoParam() {
   }

   public WasteSaleCheckDtoParam(
      final Long id, final Integer auditStatusEnum, final String auditorRemark, final List<WasteSaleDetailCheckDtoParam> wasteSaleDetailList
   ) {
      this.id = id;
      this.auditStatusEnum = auditStatusEnum;
      this.auditorRemark = auditorRemark;
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public String getAuditorRemark() {
      return this.auditorRemark;
   }

   public List<WasteSaleDetailCheckDtoParam> getWasteSaleDetailList() {
      return this.wasteSaleDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAuditorRemark(final String auditorRemark) {
      this.auditorRemark = auditorRemark;
   }

   public void setWasteSaleDetailList(final List<WasteSaleDetailCheckDtoParam> wasteSaleDetailList) {
      this.wasteSaleDetailList = wasteSaleDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleCheckDtoParam)) {
         return false;
      }

      WasteSaleCheckDtoParam other = (WasteSaleCheckDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$auditorRemark = this.getAuditorRemark();
            Object other$auditorRemark = other.getAuditorRemark();
            if (this$auditorRemark == null ? other$auditorRemark == null : this$auditorRemark.equals(other$auditorRemark)) {
               Object this$wasteSaleDetailList = this.getWasteSaleDetailList();
               Object other$wasteSaleDetailList = other.getWasteSaleDetailList();
               return this$wasteSaleDetailList == null ? other$wasteSaleDetailList == null : this$wasteSaleDetailList.equals(other$wasteSaleDetailList);
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
      return other instanceof WasteSaleCheckDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditorRemark = this.getAuditorRemark();
      result = result * 59 + ($auditorRemark == null ? 43 : $auditorRemark.hashCode());
      Object $wasteSaleDetailList = this.getWasteSaleDetailList();
      return result * 59 + ($wasteSaleDetailList == null ? 43 : $wasteSaleDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "WasteSaleCheckDtoParam(id="
         + this.getId()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditorRemark="
         + this.getAuditorRemark()
         + ", wasteSaleDetailList="
         + this.getWasteSaleDetailList()
         + ")";
   }

   public static class WasteSaleCheckDtoParamBuilder {
      private Long id;
      private Integer auditStatusEnum;
      private String auditorRemark;
      private List<WasteSaleDetailCheckDtoParam> wasteSaleDetailList;

      WasteSaleCheckDtoParamBuilder() {
      }

      public WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder auditorRemark(final String auditorRemark) {
         this.auditorRemark = auditorRemark;
         return this;
      }

      public WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder wasteSaleDetailList(final List<WasteSaleDetailCheckDtoParam> wasteSaleDetailList) {
         this.wasteSaleDetailList = wasteSaleDetailList;
         return this;
      }

      public WasteSaleCheckDtoParam build() {
         return new WasteSaleCheckDtoParam(this.id, this.auditStatusEnum, this.auditorRemark, this.wasteSaleDetailList);
      }

      @Override
      public String toString() {
         return "WasteSaleCheckDtoParam.WasteSaleCheckDtoParamBuilder(id="
            + this.id
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditorRemark="
            + this.auditorRemark
            + ", wasteSaleDetailList="
            + this.wasteSaleDetailList
            + ")";
      }
   }
}
