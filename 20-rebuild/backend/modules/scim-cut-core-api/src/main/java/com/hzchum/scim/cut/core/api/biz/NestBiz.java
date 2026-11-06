package com.hzchum.scim.cut.core.api.biz;

import java.util.List;

public interface NestBiz {
   Boolean generateSurplus(List<String> guids);

   Boolean passed(String childGuid);

   Boolean deleteNesting(String guids);

   Boolean deleteNestingByChildGuid(String ChildGuid);
}
