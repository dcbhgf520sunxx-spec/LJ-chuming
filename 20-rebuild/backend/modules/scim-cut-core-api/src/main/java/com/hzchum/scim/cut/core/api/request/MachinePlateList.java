package com.hzchum.scim.cut.core.api.request;

import com.hzchum.scim.cut.core.api.pojo._do.CutMachine;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MachinePlateList", description = "设备+钢板")
public class MachinePlateList {
   private CutMachine cutMachine;
   private Integer plateNum;
   private BigDecimal plateWeight;
   private Integer finishNum;
   private BigDecimal finishWeight;
   private Integer finishPartNum;
   private BigDecimal finishPartWeight;
   private Integer cutState;

   public CutMachine getCutMachine() {
      return this.cutMachine;
   }

   public Integer getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getPlateWeight() {
      return this.plateWeight;
   }

   public Integer getFinishNum() {
      return this.finishNum;
   }

   public BigDecimal getFinishWeight() {
      return this.finishWeight;
   }

   public Integer getFinishPartNum() {
      return this.finishPartNum;
   }

   public BigDecimal getFinishPartWeight() {
      return this.finishPartWeight;
   }

   public Integer getCutState() {
      return this.cutState;
   }

   public void setCutMachine(final CutMachine cutMachine) {
      this.cutMachine = cutMachine;
   }

   public void setPlateNum(final Integer plateNum) {
      this.plateNum = plateNum;
   }

   public void setPlateWeight(final BigDecimal plateWeight) {
      this.plateWeight = plateWeight;
   }

   public void setFinishNum(final Integer finishNum) {
      this.finishNum = finishNum;
   }

   public void setFinishWeight(final BigDecimal finishWeight) {
      this.finishWeight = finishWeight;
   }

   public void setFinishPartNum(final Integer finishPartNum) {
      this.finishPartNum = finishPartNum;
   }

   public void setFinishPartWeight(final BigDecimal finishPartWeight) {
      this.finishPartWeight = finishPartWeight;
   }

   public void setCutState(final Integer cutState) {
      this.cutState = cutState;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePlateList)) {
         return false;
      }

      MachinePlateList other = (MachinePlateList)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$plateNum = this.getPlateNum();
      Object other$plateNum = other.getPlateNum();
      if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
         Object this$finishNum = this.getFinishNum();
         Object other$finishNum = other.getFinishNum();
         if (this$finishNum == null ? other$finishNum == null : this$finishNum.equals(other$finishNum)) {
            Object this$finishPartNum = this.getFinishPartNum();
            Object other$finishPartNum = other.getFinishPartNum();
            if (this$finishPartNum == null ? other$finishPartNum == null : this$finishPartNum.equals(other$finishPartNum)) {
               Object this$cutState = this.getCutState();
               Object other$cutState = other.getCutState();
               if (this$cutState == null ? other$cutState == null : this$cutState.equals(other$cutState)) {
                  Object this$cutMachine = this.getCutMachine();
                  Object other$cutMachine = other.getCutMachine();
                  if (this$cutMachine == null ? other$cutMachine == null : this$cutMachine.equals(other$cutMachine)) {
                     Object this$plateWeight = this.getPlateWeight();
                     Object other$plateWeight = other.getPlateWeight();
                     if (this$plateWeight == null ? other$plateWeight == null : this$plateWeight.equals(other$plateWeight)) {
                        Object this$finishWeight = this.getFinishWeight();
                        Object other$finishWeight = other.getFinishWeight();
                        if (this$finishWeight == null ? other$finishWeight == null : this$finishWeight.equals(other$finishWeight)) {
                           Object this$finishPartWeight = this.getFinishPartWeight();
                           Object other$finishPartWeight = other.getFinishPartWeight();
                           return this$finishPartWeight == null ? other$finishPartWeight == null : this$finishPartWeight.equals(other$finishPartWeight);
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
      return other instanceof MachinePlateList;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $finishNum = this.getFinishNum();
      result = result * 59 + ($finishNum == null ? 43 : $finishNum.hashCode());
      Object $finishPartNum = this.getFinishPartNum();
      result = result * 59 + ($finishPartNum == null ? 43 : $finishPartNum.hashCode());
      Object $cutState = this.getCutState();
      result = result * 59 + ($cutState == null ? 43 : $cutState.hashCode());
      Object $cutMachine = this.getCutMachine();
      result = result * 59 + ($cutMachine == null ? 43 : $cutMachine.hashCode());
      Object $plateWeight = this.getPlateWeight();
      result = result * 59 + ($plateWeight == null ? 43 : $plateWeight.hashCode());
      Object $finishWeight = this.getFinishWeight();
      result = result * 59 + ($finishWeight == null ? 43 : $finishWeight.hashCode());
      Object $finishPartWeight = this.getFinishPartWeight();
      return result * 59 + ($finishPartWeight == null ? 43 : $finishPartWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePlateList(cutMachine="
         + this.getCutMachine()
         + ", plateNum="
         + this.getPlateNum()
         + ", plateWeight="
         + this.getPlateWeight()
         + ", finishNum="
         + this.getFinishNum()
         + ", finishWeight="
         + this.getFinishWeight()
         + ", finishPartNum="
         + this.getFinishPartNum()
         + ", finishPartWeight="
         + this.getFinishPartWeight()
         + ", cutState="
         + this.getCutState()
         + ")";
   }
}
