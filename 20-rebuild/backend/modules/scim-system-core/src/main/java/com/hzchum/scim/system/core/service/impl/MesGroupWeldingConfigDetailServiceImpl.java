package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.ComparisonOperatorEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesGroupWeldingConfigDetail;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigDetailService;
import com.hzchum.scim.system.core.mapper.MesGroupWeldingConfigDetailMapper;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesGroupWeldingConfigDetailServiceImpl
   extends ServiceImpl<MesGroupWeldingConfigDetailMapper, MesGroupWeldingConfigDetail>
   implements MesGroupWeldingConfigDetailService {
   @Override
   public Boolean isIntersection(List<MesGroupWeldingConfigDetail> list) {
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            HashMap<String, Integer> values1 = this.maximumAndMinimumValues(list.get(i));

            for (int j = i + 1; j < list.size(); j++) {
               HashMap<String, Integer> values2 = this.maximumAndMinimumValues(list.get(j));
               if (values1.get("minimum") != null && values1.get("maximum") != null && values2.get("minimum") != null && values2.get("maximum") != null) {
                  if (values1.get("maximum") >= values2.get("minimum") && values1.get("minimum") <= values2.get("maximum")) {
                     return Boolean.TRUE;
                  }

                  if ((values1.get("minimum") > values1.get("maximum") || values2.get("minimum") > values2.get("maximum"))
                     && (values1.get("maximum") >= values2.get("minimum") || values1.get("minimum") <= values2.get("maximum"))) {
                     return Boolean.TRUE;
                  }
               } else if (values1.get("maximum") != null && values2.get("minimum") != null && values2.get("maximum") != null) {
                  if (values1.get("maximum") >= values2.get("minimum")) {
                     return Boolean.TRUE;
                  }

                  if (values2.get("minimum") > values2.get("maximum")) {
                     return Boolean.TRUE;
                  }
               } else if (values1.get("minimum") != null && values2.get("minimum") != null && values2.get("maximum") != null) {
                  if (values1.get("minimum") <= values2.get("maximum")) {
                     return Boolean.TRUE;
                  }

                  if (values2.get("minimum") > values2.get("maximum")) {
                     return Boolean.TRUE;
                  }
               } else if (values1.get("minimum") != null && values1.get("maximum") != null && values2.get("maximum") != null) {
                  if (values1.get("minimum") <= values2.get("maximum")) {
                     return Boolean.TRUE;
                  }

                  if (values1.get("minimum") > values1.get("maximum")) {
                     return Boolean.TRUE;
                  }
               } else if (values1.get("minimum") != null && values1.get("maximum") != null && values2.get("minimum") != null) {
                  if (values1.get("maximum") >= values2.get("minimum")) {
                     return Boolean.TRUE;
                  }

                  if (values1.get("minimum") > values1.get("maximum")) {
                     return Boolean.TRUE;
                  }
               } else {
                  if (values1.get("maximum") != null && values2.get("maximum") != null) {
                     return Boolean.TRUE;
                  }

                  if (values1.get("maximum") != null && values2.get("minimum") != null) {
                     if (values1.get("maximum") >= values2.get("minimum")) {
                        return Boolean.TRUE;
                     }
                  } else if (values1.get("minimum") != null && values2.get("maximum") != null) {
                     if (values1.get("minimum") <= values2.get("maximum")) {
                        return Boolean.TRUE;
                     }
                  } else if (values1.get("minimum") != null && values2.get("minimum") != null) {
                     return Boolean.TRUE;
                  }
               }
            }
         }
      }

      MesGroupWeldingConfigDetail detail = list.get(0);
      Preconditions.checkArgument(
         detail.getComparisonOperatorOne() != null && detail.getNumberOne() != null
            || detail.getComparisonOperatorTwo() != null && detail.getNumberTwo() != null,
         "计价范围错误"
      );
      return Boolean.FALSE;
   }

   private HashMap<String, Integer> maximumAndMinimumValues(MesGroupWeldingConfigDetail detail) {
      Integer minimum = null;
      Integer maximum = null;
      Preconditions.checkArgument(
         detail.getComparisonOperatorOne() != null && detail.getNumberOne() != null
            || detail.getComparisonOperatorTwo() != null && detail.getNumberTwo() != null,
         "计价范围错误"
      );
      if (detail.getComparisonOperatorOne() != null && detail.getNumberOne() != null) {
         ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(detail.getComparisonOperatorOne());
         if (operatorEnum != null) {
            switch (operatorEnum) {
               case LESS_THAN:
                  if (maximum == null) {
                     maximum = detail.getNumberOne() - 1;
                  } else if (maximum <= detail.getNumberOne()) {
                     maximum = detail.getNumberOne() - 1;
                  }
                  break;
               case LESS_THAN_EQUAL:
                  if (maximum == null) {
                     maximum = detail.getNumberOne();
                  } else if (maximum <= detail.getNumberOne()) {
                     maximum = detail.getNumberOne();
                  }
                  break;
               case GREATER_THAN:
                  if (minimum == null) {
                     minimum = detail.getNumberOne() + 1;
                  } else if (minimum >= detail.getNumberOne()) {
                     minimum = detail.getNumberOne() + 1;
                  }
                  break;
               case GREATER_THAN_EQUAL:
                  if (minimum == null) {
                     minimum = detail.getNumberOne();
                  } else if (minimum >= detail.getNumberOne()) {
                     minimum = detail.getNumberOne();
                  }
            }
         }
      }

      if (detail.getComparisonOperatorTwo() != null && detail.getNumberTwo() != null) {
         ComparisonOperatorEnum operatorEnum = ComparisonOperatorEnum.getEnum(detail.getComparisonOperatorTwo());
         if (operatorEnum != null) {
            switch (operatorEnum) {
               case LESS_THAN:
                  if (maximum == null) {
                     maximum = detail.getNumberTwo() - 1;
                  } else if (maximum <= detail.getNumberTwo()) {
                     maximum = detail.getNumberTwo() - 1;
                  }
                  break;
               case LESS_THAN_EQUAL:
                  if (maximum == null) {
                     maximum = detail.getNumberTwo();
                  } else if (maximum <= detail.getNumberTwo()) {
                     maximum = detail.getNumberTwo();
                  }
                  break;
               case GREATER_THAN:
                  if (minimum == null) {
                     minimum = detail.getNumberTwo() + 1;
                  } else if (minimum >= detail.getNumberTwo()) {
                     minimum = detail.getNumberTwo() + 1;
                  }
                  break;
               case GREATER_THAN_EQUAL:
                  if (minimum == null) {
                     minimum = detail.getNumberTwo();
                  } else if (minimum >= detail.getNumberTwo()) {
                     minimum = detail.getNumberTwo();
                  }
            }
         }
      }

      HashMap<String, Integer> map = new HashMap<>();
      map.put("minimum", minimum);
      map.put("maximum", maximum);
      return map;
   }
}
