package com.hzchum.scim.mes.building.core.api.utils;

import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.ComparisonOperatorEnum;
import java.math.BigDecimal;
import java.util.Objects;

public class MaxAndMin {
   public Number min;
   public Number max;

   public static MaxAndMin getMaxAndMin(Integer comparisonOperatorOne, Number numberOne, Integer comparisonOperatorTwo, Number numberTwo) {
      BigDecimal min = null;
      BigDecimal max = null;
      if (comparisonOperatorOne != null && numberOne != null) {
         BigDecimal bdNumberOne = new BigDecimal(numberOne.toString());
         BigDecimal adjustment = BigDecimal.ONE.movePointLeft(8);
         ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(comparisonOperatorOne);
         if (operatorEnum != null) {
            switch (operatorEnum) {
               case LESS_THAN:
                  max = bdNumberOne.subtract(adjustment);
                  break;
               case LESS_THAN_EQUAL:
                  max = bdNumberOne;
                  break;
               case GREATER_THAN:
                  min = bdNumberOne.add(adjustment);
                  break;
               case GREATER_THAN_EQUAL:
                  min = bdNumberOne;
            }
         }
      }

      if (comparisonOperatorTwo != null && numberTwo != null) {
         BigDecimal bdNumberTwo = new BigDecimal(numberTwo.toString());
         BigDecimal adjustment = BigDecimal.ONE.movePointLeft(8);
         ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(comparisonOperatorTwo);
         if (operatorEnum != null) {
            switch (operatorEnum) {
               case LESS_THAN:
                  if (max != null) {
                     if (max.compareTo(bdNumberTwo) <= 0) {
                        max = bdNumberTwo.subtract(adjustment);
                     }
                  } else {
                     max = bdNumberTwo.subtract(adjustment);
                  }
                  break;
               case LESS_THAN_EQUAL:
                  if (max != null) {
                     if (max.compareTo(bdNumberTwo) <= 0) {
                        max = bdNumberTwo;
                     }
                  } else {
                     max = bdNumberTwo;
                  }
                  break;
               case GREATER_THAN:
                  if (min != null) {
                     if (min.compareTo(bdNumberTwo) >= 0) {
                        min = bdNumberTwo.add(adjustment);
                     }
                  } else {
                     min = bdNumberTwo.add(adjustment);
                  }
                  break;
               case GREATER_THAN_EQUAL:
                  if (min != null) {
                     if (min.compareTo(bdNumberTwo) >= 0) {
                        min = bdNumberTwo;
                     }
                  } else {
                     min = bdNumberTwo;
                  }
            }
         }
      }

      if (min != null && max != null) {
         Preconditions.checkArgument(min.compareTo(max) <= 0, "区间最小值不能大于等于区间最大值");
      }

      return new MaxAndMin(min, max);
   }

   public static boolean isValueInRange(Number min, Number max, Number value) {
      if (value == null) {
         return false;
      }

      BigDecimal bdMax = max != null ? new BigDecimal(max.toString()) : null;
      BigDecimal bdMin = min != null ? new BigDecimal(min.toString()) : null;
      BigDecimal bdValue = new BigDecimal(value.toString());
      if (bdMax != null && bdMin != null) {
         if (bdValue.compareTo(bdMin) >= 0 && bdValue.compareTo(bdMax) <= 0) {
            return true;
         }

         if (bdMin.compareTo(bdMax) > 0) {
            return bdValue.compareTo(bdMin) >= 0 || bdValue.compareTo(bdMax) <= 0;
         }
      } else {
         if (bdMax != null) {
            return bdValue.compareTo(bdMax) <= 0;
         }

         if (bdMin != null) {
            return bdValue.compareTo(bdMin) >= 0;
         }
      }

      return false;
   }

   public static Boolean isTwoRegionIntersection(Number oneMin, Number oneMax, Number twoMin, Number twoMax) {
      Preconditions.checkArgument((oneMin != null || oneMax != null) && (twoMin != null || twoMax != null), "区间1或区间2不能为空");
      BigDecimal bdOneMin = oneMin != null ? new BigDecimal(oneMin.toString()) : null;
      BigDecimal bdOneMax = oneMax != null ? new BigDecimal(oneMax.toString()) : null;
      BigDecimal bdTwoMin = twoMin != null ? new BigDecimal(twoMin.toString()) : null;
      BigDecimal bdTwoMax = twoMax != null ? new BigDecimal(twoMax.toString()) : null;
      if (bdOneMin != null && bdOneMax != null && bdTwoMin != null && bdTwoMax != null) {
         return bdOneMin.compareTo(bdOneMax) <= 0 && bdTwoMin.compareTo(bdTwoMax) <= 0
            ? bdOneMax.compareTo(bdTwoMin) >= 0 && bdOneMin.compareTo(bdTwoMax) <= 0
            : bdOneMax.compareTo(bdTwoMin) >= 0 || bdOneMin.compareTo(bdTwoMax) <= 0;
      } else if (bdOneMax != null && bdTwoMin != null && bdTwoMax != null) {
         return bdOneMax.compareTo(bdTwoMin) >= 0 ? true : bdTwoMin.compareTo(bdTwoMax) > 0;
      } else if (bdOneMin != null && bdTwoMin != null && bdTwoMax != null) {
         return bdOneMin.compareTo(bdTwoMax) <= 0 ? true : bdTwoMin.compareTo(bdTwoMax) > 0;
      } else if (bdOneMin != null && bdOneMax != null && bdTwoMax != null) {
         return bdOneMin.compareTo(bdTwoMax) <= 0 ? true : bdOneMin.compareTo(bdOneMax) > 0;
      } else if (bdOneMin != null && bdOneMax != null && bdTwoMin != null) {
         return bdOneMax.compareTo(bdTwoMin) >= 0 ? true : bdOneMin.compareTo(bdOneMax) > 0;
      } else if (bdOneMax != null && bdTwoMax != null) {
         return true;
      } else if (bdOneMax != null && bdTwoMin != null) {
         return bdOneMax.compareTo(bdTwoMin) >= 0;
      } else {
         return bdOneMin != null && bdTwoMax != null ? bdOneMin.compareTo(bdTwoMax) <= 0 : bdOneMin != null && bdTwoMin != null;
      }
   }

   public static String getRangeDescription(Integer comparisonOperatorOne, Number numberOne, Integer comparisonOperatorTwo, Number numberTwo) {
      StringBuilder rangeDescription = new StringBuilder();
      if (comparisonOperatorOne != null && numberOne != null) {
         rangeDescription.append(new BigDecimal(numberOne.toString()).stripTrailingZeros().toPlainString());
         if (Objects.equals(ComparisonOperatorEnum.GREATER_THAN.getType(), comparisonOperatorOne)) {
            rangeDescription.append(ComparisonOperatorEnum.LESS_THAN.getSymbol());
         }

         if (Objects.equals(ComparisonOperatorEnum.GREATER_THAN_EQUAL.getType(), comparisonOperatorOne)) {
            rangeDescription.append(ComparisonOperatorEnum.LESS_THAN_EQUAL.getSymbol());
         }
      }

      rangeDescription.append("x");
      if (comparisonOperatorTwo != null && numberTwo != null) {
         rangeDescription.append(ComparisonOperatorEnum.getSymbolByType(comparisonOperatorTwo))
            .append(new BigDecimal(numberTwo.toString()).stripTrailingZeros().toPlainString());
      }

      return rangeDescription.toString().equals("x") ? null : rangeDescription.toString();
   }

   public Number getMin() {
      return this.min;
   }

   public Number getMax() {
      return this.max;
   }

   public void setMin(final Number min) {
      this.min = min;
   }

   public void setMax(final Number max) {
      this.max = max;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MaxAndMin)) {
         return false;
      } else {
         MaxAndMin other = (MaxAndMin)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$min = this.getMin();
            Object other$min = other.getMin();
            if (this$min == null ? other$min == null : this$min.equals(other$min)) {
               Object this$max = this.getMax();
               Object other$max = other.getMax();
               return this$max == null ? other$max == null : this$max.equals(other$max);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaxAndMin;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $min = this.getMin();
      result = result * 59 + ($min == null ? 43 : $min.hashCode());
      Object $max = this.getMax();
      return result * 59 + ($max == null ? 43 : $max.hashCode());
   }

   @Override
   public String toString() {
      return "MaxAndMin(min=" + this.getMin() + ", max=" + this.getMax() + ")";
   }

   public MaxAndMin() {
   }

   public MaxAndMin(final Number min, final Number max) {
      this.min = min;
      this.max = max;
   }
}
