package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.PaintThicknessDO;

public interface PaintThicknessBiz {
   Boolean savePaintThickness(PaintThicknessDO paintThicknessDO);

   PaintThicknessDO getPaintThicknessConfig();

   ListVO listPaintArtyFactList();
}
