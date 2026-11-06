package com.hzchum.scim.contract.core.api.pojo.dtoParam.visa;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(description = "签证 ")
public class ContractCheckDTOParam {
   @ApiModelProperty(notes = "签证结算记录id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(notes = "发运审核状态 2通过 4不通过")
   @EnumValidator(value = CheckStatusEnum.class, message = "审核状态类型不正确")
   @NotNull(message = "审核状态类型不支持")
   private Integer status;
   @ApiModelProperty("附件")
   private List<Long> attachmentIds;
   @ApiModelProperty("附件备注")
   private String attachmentRemark;

   public Long getId() {
      return this.id;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAttachmentRemark() {
      return this.attachmentRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentRemark(final String attachmentRemark) {
      this.attachmentRemark = attachmentRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCheckDTOParam)) {
         return false;
      }

      ContractCheckDTOParam other = (ContractCheckDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$attachmentIds = this.getAttachmentIds();
            Object other$attachmentIds = other.getAttachmentIds();
            if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
               Object this$attachmentRemark = this.getAttachmentRemark();
               Object other$attachmentRemark = other.getAttachmentRemark();
               return this$attachmentRemark == null ? other$attachmentRemark == null : this$attachmentRemark.equals(other$attachmentRemark);
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
      return other instanceof ContractCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentRemark = this.getAttachmentRemark();
      return result * 59 + ($attachmentRemark == null ? 43 : $attachmentRemark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCheckDTOParam(id="
         + this.getId()
         + ", status="
         + this.getStatus()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentRemark="
         + this.getAttachmentRemark()
         + ")";
   }
}
