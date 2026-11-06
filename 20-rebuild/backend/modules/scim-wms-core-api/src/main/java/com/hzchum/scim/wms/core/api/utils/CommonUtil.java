package com.hzchum.scim.wms.core.api.utils;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.CommonValue;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
   private static RedisTemplate redisTemplate;
   private static final BigDecimal THOUSAND = new BigDecimal("1000");

   @Autowired
   public void setRedisTemplate(RedisTemplate redisTemplate) {
      CommonUtil.redisTemplate = redisTemplate;
   }

   public static String generateSerialNumber(String code, LocalDate localDate, Integer count) {
      count = count + 1;
      return code + "-" + localDate.getYear() + localDate.getMonthValue() + localDate.getDayOfMonth() + "-" + (count < 10 ? "0" + count : count + "");
   }

   public static LocalDateTime getDayLastTime(LocalDateTime localDateTime) {
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String time = df.format(localDateTime);
      time = time + " 23:59:59";
      return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
   }

   public static List<Long> spilt(String value, String segmentation) {
      return Arrays.stream(value.split(segmentation)).map(Long::parseLong).collect(Collectors.toList());
   }

   public static BigDecimal getOutboundMete(
      BigDecimal precision, BigDecimal outQuantity, MaterialInventory materialInventory, BigDecimal freezeMete, BigDecimal freezeTotalQuantity
   ) {
      BigDecimal mete = outQuantity.divide(materialInventory.getQuantity().subtract(freezeTotalQuantity), 20, 4)
         .multiply(materialInventory.getMete().subtract(freezeMete))
         .divide(precision, 0, 4)
         .multiply(precision);
      return outQuantity.divide(materialInventory.getQuantity().subtract(freezeTotalQuantity), 20, 4)
         .multiply(materialInventory.getMete().subtract(freezeMete))
         .divide(precision, 0, 4)
         .multiply(precision);
   }

   public static BigDecimal getStockOutboundMete(BigDecimal outQuantity, BigDecimal availableQuantity, BigDecimal availableMete) {
      Preconditions.checkArgument(
         outQuantity != null && availableQuantity != null && availableMete != null
            && outQuantity.signum() > 0 && availableQuantity.signum() > 0 && availableMete.signum() >= 0
            && outQuantity.compareTo(availableQuantity) <= 0,
         "当前库存量不足,请重新操作"
      );
      // Stock/freeze/outbound store grams at scale 8; the last item retains the exact remainder.
      return outQuantity.compareTo(availableQuantity) == 0
         ? availableMete
         : availableMete.multiply(outQuantity).divide(availableQuantity, 8, RoundingMode.DOWN);
   }

   public static BigDecimal getOutboundMete1(
      BigDecimal precision, BigDecimal outQuantity, MaterialInventory materialInventory, BigDecimal freezeMete, BigDecimal freezeTotalQuantity, Integer scale
   ) {
      BigDecimal availableQuantity = materialInventory.getQuantity().subtract(freezeTotalQuantity);
      BigDecimal availableMete = materialInventory.getMete().subtract(freezeMete);
      // Preserve zero/signed difference callers; physical grams must not use display rounding.
      if (outQuantity.signum() <= 0) {
         return availableMete.multiply(outQuantity).divide(availableQuantity, 8, RoundingMode.DOWN);
      }
      BigDecimal mete = getStockOutboundMete(outQuantity, availableQuantity, availableMete);
      Preconditions.checkArgument(
         !BasicClassEnum.checkIsSteel(materialInventory.getBasicClass()) || mete.signum() > 0,
         "当前出库量低于库存重量保存精度,请调整数量后操作"
      );
      return mete;
   }

   public static void getSpec(MaterialInventory ma, StringBuilder sb) {
      String thickness = ma.getThickness() != null ? ma.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = ma.getWidth() != null ? ma.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = ma.getLength() != null ? ma.getLength().stripTrailingZeros().toPlainString() : null;
      if (BasicClassEnum.STEEL_PLATE.getType().equals(ma.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append("*").append(length);
         if (ma.getSpecification() != null) {
            sb.append(" * ").append(ma.getSpecification());
         }
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(ma.getBasicClass())) {
         sb.append(length);
         if (ma.getSpecification() != null) {
            sb.append(" * ").append(ma.getSpecification());
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(ma.getBasicClass())) {
         sb.append(thickness).append("*").append(width).append(" * ");
         if (ma.getSpecification() != null) {
            sb.append(ma.getSpecification()).append(" * ");
         }

         sb.append(ma.getColor());
      } else if (BasicClassEnum.checkNotSteel(ma.getBasicClass())) {
         if (StrUtil.isNotBlank(ma.getSpecification())) {
            sb.append(ma.getSpecification());
            if (StrUtil.isNotBlank(ma.getColor())) {
               sb.append(" * ").append(ma.getColor());
            }
         } else if (StrUtil.isNotBlank(ma.getColor())) {
            sb.append(ma.getColor());
         }
      }
   }

   public static BigDecimal getSteelCoilLength(String className, BigDecimal width, BigDecimal thickness, BigDecimal mete) {
      width = width.divide(THOUSAND);
      return className.contains("不锈钢")
         ? mete.divide(width.multiply(CommonValue.STAINLESS_STEEL).multiply(thickness), 0, 4)
         : mete.divide(width.multiply(CommonValue.ORDINARY_STEEL).multiply(thickness), 0, 4);
   }

   public static BigDecimal unitConversion(BigDecimal value, String targetUnit, Integer scale) {
      BigDecimal precision = UnitsPrecisionEnum.getByName(targetUnit);
      return value.divide(precision, scale, 4);
   }

   public static BigDecimal getTheoryMete(String className, BigDecimal length, BigDecimal width, BigDecimal thickness, BigDecimal mete, Long classifyId) {
      BigDecimal density = (BigDecimal)redisTemplate.opsForHash().get("wms-hash-steel-density", classifyId.toString());
      if (mete != null) {
         return mete.multiply(length.divide(THOUSAND)).setScale(12, 4);
      }

      length = length.divide(THOUSAND);
      width = width.divide(THOUSAND);
      return density.multiply(thickness).multiply(length).multiply(width).setScale(12, 4);
   }

   public static BigDecimal weightComparison(BigDecimal warehouseMete, BigDecimal operationMete, Measure measure) {
      BigDecimal a;
      BigDecimal b;
      if ("千克".equals(measure.getAccountingUnit()) || "米".equals(measure.getAccountingUnit())) {
         a = warehouseMete.divide(BigDecimal.valueOf(1000L)).setScale(measure.getAccountingPrecision(), 4);
         b = operationMete.divide(BigDecimal.valueOf(1000L)).setScale(measure.getAccountingPrecision(), 4);
      } else if ("吨".equals(measure.getAccountingUnit())) {
         a = warehouseMete.divide(BigDecimal.valueOf(1000000L)).setScale(measure.getAccountingPrecision(), 4);
         b = operationMete.divide(BigDecimal.valueOf(1000000L)).setScale(measure.getAccountingPrecision(), 4);
      } else {
         a = warehouseMete.setScale(measure.getAccountingPrecision(), 4);
         b = operationMete.setScale(measure.getAccountingPrecision(), 4);
      }

      int i = a.compareTo(b);
      if (i == 0) {
         return warehouseMete;
      }

      if (i < 0) {
         Preconditions.checkArgument(false, "操作核算量超出库存核算量[ " + b.subtract(a) + " ]");
      }

      return i > 0 ? operationMete : BigDecimal.ZERO;
   }

   public static StringBuilder checkLicensePlate(String licensePlate) {
      String pattern = "[京津晋冀蒙辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川贵云藏陕甘青宁新][ABCDEFGHJKLMNPQRSTUVWXY]·{1,1}[A-Z0-9]{5,}[挂学警港澳]?";
      Pattern compile = Pattern.compile(pattern);
      Matcher matcher = compile.matcher(licensePlate);
      StringBuilder builder = new StringBuilder(licensePlate);
      if (!matcher.matches()) {
         builder.insert(2, "·");
         Matcher matcher1 = compile.matcher(builder.toString());
         if (!matcher1.matches()) {
            Preconditions.checkArgument(true, "请输入正确的车牌号");
         }
      }

      return builder;
   }

   public static <T> Page<T> getPage(Integer page, Integer size, List<T> value) {
      Page<T> pages = new Page<>(page, size);
      int total = value.size();
      pages.setTotal(total);
      int startIndex = (page - 1) * size;
      int endIndex = Math.min(startIndex + size, total);
      pages.addAll(value.subList(startIndex, endIndex));
      return pages;
   }

   public static String getProjectZeroStr(Long value) {
      if (value < 10L) {
         return "0000" + value;
      } else if (value < 100L) {
         return "000" + value;
      } else if (value < 1000L) {
         return "00" + value;
      } else {
         return value < 10000L ? "0" + value : "" + value;
      }
   }

   public static String getZeroStr(Long value) {
      if (value < 10L) {
         return "000000000" + value;
      } else if (value < 100L) {
         return "00000000" + value;
      } else if (value < 1000L) {
         return "0000000" + value;
      } else if (value < 10000L) {
         return "000000" + value;
      } else if (value < 100000L) {
         return "00000" + value;
      } else if (value < 1000000L) {
         return "0000" + value;
      } else if (value < 10000000L) {
         return "000" + value;
      } else if (value < 100000000L) {
         return "00" + value;
      } else {
         return value < 1000000000L ? "0" + value : "" + value;
      }
   }
}
