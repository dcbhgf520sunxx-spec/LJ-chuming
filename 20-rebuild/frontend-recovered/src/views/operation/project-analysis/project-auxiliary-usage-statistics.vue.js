import { ref as o } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as k } from "vue";
import { createVNode as e } from "vue";
import { ElTableColumn as x } from "element-plus";
import { vLoading as N } from "element-plus";
import C from "./project-outbound-statistics-detail.vue.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const D = { __name: "project-auxiliary-usage-statistics", props: { maxHeight: [Number, String], default: void 0 }, setup(p) {
  const c = o(), m = o(false), l = o(false), i = o({}), n = o("辅材"), d = o([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}]);
  function u(r) {
    n.value = "辅材", i.value = r, l.value = true;
  }
  return (r, a) => {
    const t = x, w = v("common-table"), f = N;
    return s(), b("div", null, [a[1] || (a[1] = g("div", { style: { "font-size": "18px", "font-weight": "bold", "margin-bottom": "6px" } }, "项目辅材领用统计", -1)), _((s(), y(w, { ref_key: "tableRef", ref: c, data: d.value, "max-height": p.maxHeight, "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: u }, { default: k(() => [e(t, { align: "center", label: "序号", type: "index", width: "55" }), e(t, { key: "workshopName", align: "center", "show-overflow-tooltip": "", label: "类别", prop: "createTime" }), e(t, { key: "processName", align: "center", "show-overflow-tooltip": "", label: "单位", prop: "applicantName", "min-width": "120" }), e(t, { key: "deepenMete", prop: "deepenMete", align: "center", "show-overflow-tooltip": "", label: "规格" }), e(t, { key: "processName", align: "center", "show-overflow-tooltip": "", label: "累计出库", prop: "applicantName", "min-width": "120" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "上月" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "本月" })]), _: 1 }, 8, ["data", "max-height"])), [[f, m.value]]), e(C, { visible: l.value, "onUpdate:visible": a[0] || (a[0] = (h) => l.value = h), "detail-data": i.value, showType: n.value }, null, 8, ["visible", "detail-data", "showType"])]);
  };
} };
export {
  D as default
};
