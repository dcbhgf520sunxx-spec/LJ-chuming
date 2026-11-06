package com.ljaps.rebuild.business;

import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Regression for the actual legacy read DTO used by the current V2 editor. */
public class PlanDeliveryDtoProbe {
   private static int checks;
   private static void check(boolean value) { if (!value) throw new AssertionError("Plan delivery DTO regression"); checks++; }
   public static void main(String[] args) {
      PlanArea area = new PlanArea();
      LocalDate start = LocalDate.of(2026, 10, 20), end = start.plusDays(30);
      area.setDeliveryStartDate(start);area.setDeliveryEndDate(end);
      area.setShippingStartDate(start.plusDays(2));area.setShippingEndDate(start.plusDays(4));
      area.setDate(start.plusDays(5));area.setMete(new BigDecimal("2.5"));area.setUnitName("平方米");area.setType(0);
      PlanAreaDTO dto = BeanUtil.copy(area, PlanAreaDTO.class);
      check(start.equals(dto.getDeliveryStartDate()));check(end.equals(dto.getDeliveryEndDate()));
      check(area.getShippingStartDate().equals(dto.getShippedStartDate()));check(area.getShippingEndDate().equals(dto.getShippedEndDate()));
      check(area.getDate().equals(dto.getDate()));check(area.getMete().equals(dto.getBudgetVolume()));
      check(area.getUnitName().equals(dto.getUnit()));check(area.getType().equals(dto.getProductionWay()));
      PlanAreaDTO historical = BeanUtil.copy(new PlanArea(), PlanAreaDTO.class);
      check(historical.getDeliveryStartDate() == null);check(historical.getDeliveryEndDate() == null);
      System.out.println("Plan delivery DTO checks passed: " + checks);
   }
}
