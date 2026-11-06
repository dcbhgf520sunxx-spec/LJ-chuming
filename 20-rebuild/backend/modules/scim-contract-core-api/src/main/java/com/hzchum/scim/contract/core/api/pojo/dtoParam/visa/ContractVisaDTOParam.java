package com.hzchum.scim.contract.core.api.pojo.dtoParam.visa;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@ApiModel(description = "签证 ")
public class ContractVisaDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("id")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Integer id;
   @ApiModelProperty("签证模式 1对内 2对外 前端无需传递")
   private Integer mode;
   @ApiModelProperty("项目id")
   @NotNull(groups = Add.class, message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("签证日期")
   @NotNull(message = "签证日期不能为空")
   private LocalDate visaDate;
   @ApiModelProperty("签证人(申请人)id")
   @NotNull(message = "签证人(申请人)不能为空")
   private Long userId;
   @ApiModelProperty("签证原因id")
   @NotNull(message = "签证原因不能为空")
   private String reasonId;
   @ApiModelProperty("签证额")
   @NotNull(message = "签证额不能为空")
   @DecimalMin(value = "0", groups = {Add.class, Update.class}, message = "签证额不能小于0")
   private BigDecimal visaAmount;
   @ApiModelProperty("监理单位")
   private String supervisionUnit;
   @ApiModelProperty("设计单位")
   private String designUnit;
   @ApiModelProperty("政府监管")
   private String governmentRegulation;
   @ApiModelProperty("备注")
   private String remark;

   public Integer getId() {
      return this.id;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getVisaDate() {
      return this.visaDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getReasonId() {
      return this.reasonId;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public String getSupervisionUnit() {
      return this.supervisionUnit;
   }

   public String getDesignUnit() {
      return this.designUnit;
   }

   public String getGovernmentRegulation() {
      return this.governmentRegulation;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setVisaDate(final LocalDate visaDate) {
      this.visaDate = visaDate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setReasonId(final String reasonId) {
      this.reasonId = reasonId;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setSupervisionUnit(final String supervisionUnit) {
      this.supervisionUnit = supervisionUnit;
   }

   public void setDesignUnit(final String designUnit) {
      this.designUnit = designUnit;
   }

   public void setGovernmentRegulation(final String governmentRegulation) {
      this.governmentRegulation = governmentRegulation;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaDTOParam)) {
         return false;
      }

      ContractVisaDTOParam other = (ContractVisaDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mode = this.getMode();
         Object other$mode = other.getMode();
         if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$visaDate = this.getVisaDate();
                  Object other$visaDate = other.getVisaDate();
                  if (this$visaDate == null ? other$visaDate == null : this$visaDate.equals(other$visaDate)) {
                     Object this$reasonId = this.getReasonId();
                     Object other$reasonId = other.getReasonId();
                     if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                        Object this$visaAmount = this.getVisaAmount();
                        Object other$visaAmount = other.getVisaAmount();
                        if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                           Object this$supervisionUnit = this.getSupervisionUnit();
                           Object other$supervisionUnit = other.getSupervisionUnit();
                           if (this$supervisionUnit == null ? other$supervisionUnit == null : this$supervisionUnit.equals(other$supervisionUnit)) {
                              Object this$designUnit = this.getDesignUnit();
                              Object other$designUnit = other.getDesignUnit();
                              if (this$designUnit == null ? other$designUnit == null : this$designUnit.equals(other$designUnit)) {
                                 Object this$governmentRegulation = this.getGovernmentRegulation();
                                 Object other$governmentRegulation = other.getGovernmentRegulation();
                                 if (this$governmentRegulation == null
                                    ? other$governmentRegulation == null
                                    : this$governmentRegulation.equals(other$governmentRegulation)) {
                                    Object this$remark = this.getRemark();
                                    Object other$remark = other.getRemark();
                                    return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof ContractVisaDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $visaDate = this.getVisaDate();
      result = result * 59 + ($visaDate == null ? 43 : $visaDate.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $supervisionUnit = this.getSupervisionUnit();
      result = result * 59 + ($supervisionUnit == null ? 43 : $supervisionUnit.hashCode());
      Object $designUnit = this.getDesignUnit();
      result = result * 59 + ($designUnit == null ? 43 : $designUnit.hashCode());
      Object $governmentRegulation = this.getGovernmentRegulation();
      result = result * 59 + ($governmentRegulation == null ? 43 : $governmentRegulation.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisaDTOParam(id="
         + this.getId()
         + ", mode="
         + this.getMode()
         + ", projectId="
         + this.getProjectId()
         + ", visaDate="
         + this.getVisaDate()
         + ", userId="
         + this.getUserId()
         + ", reasonId="
         + this.getReasonId()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", supervisionUnit="
         + this.getSupervisionUnit()
         + ", designUnit="
         + this.getDesignUnit()
         + ", governmentRegulation="
         + this.getGovernmentRegulation()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
