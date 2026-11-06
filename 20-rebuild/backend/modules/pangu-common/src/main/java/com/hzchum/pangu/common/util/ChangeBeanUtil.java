package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.pojo.ChangeInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ChangeBeanUtil {
   public static List<ChangeInfo> compareFields(Object obj1, Object obj2, String... ignoreArr) {
      try {
         List<ChangeInfo> changeInfos = new ArrayList<>();
         List<String> ignoreList = null;
         if (ignoreArr != null && ignoreArr.length > 0) {
            ignoreList = Arrays.asList(ignoreArr);
         }

         if (obj1.getClass() == obj2.getClass()) {
            Class<?> clazz = obj1.getClass();
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();

            for (PropertyDescriptor pd : pds) {
               String name = pd.getName();
               if (ignoreList == null || !ignoreList.contains(name)) {
                  Method readMethod = pd.getReadMethod();
                  Object o1 = readMethod.invoke(obj1);
                  Object o2 = readMethod.invoke(obj2);
                  if (o1 instanceof Timestamp) {
                     o1 = new Date(((Timestamp)o1).getTime());
                  }

                  if (o2 instanceof Timestamp) {
                     o2 = new Date(((Timestamp)o2).getTime());
                  }

                  Boolean isChange = false;
                  if (o1 == null && o2 == null) {
                     isChange = false;
                  } else if (o1 != null && o2 != null) {
                     isChange = !o1.equals(o2);
                  } else {
                     isChange = true;
                  }

                  changeInfos.add(ChangeInfo.builder().field(name).isChange(isChange).oldData(o1).newData(o2).build());
               }
            }
         }

         return changeInfos;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
}
