import { ref as o } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as g } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as y } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as e } from "vue";
import { ElTableColumn as x } from "element-plus";
import { vLoading as C } from "element-plus";
import N from "./project-outbound-statistics-detail.vue.js";
import "../../../shared/runtime.js";
import "../../../modules/project-overview-1b3937a7.js";
const D = { __name: "project-steel-usage-statistics", props: { maxHeight: [Number, String], default: void 0 }, setup(p) {
  const c = o(), m = o(false), a = o(false), i = o({}), n = o("钢材"), d = o([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}]);
  function u(r) {
    n.value = "钢材", i.value = r, a.value = true;
  }
  return (r, l) => {
    const t = x, w = v("common-table"), f = C;
    return s(), b("div", null, [l[1] || (l[1] = g("div", { style: { "font-size": "18px", "font-weight": "bold", "margin-bottom": "6px" } }, "项目钢材领用统计", -1)), k((s(), y(w, { ref_key: "tableRef", ref: c, data: d.value, "max-height": p.maxHeight, "highlight-current-row": "", style: { width: "100%", cursor: "pointer" }, onRowClick: u }, { default: _(() => [e(t, { align: "center", label: "序号", type: "index", width: "55" }), e(t, { key: "workshopName", align: "center", "show-overflow-tooltip": "", label: "类别", prop: "createTime" }), e(t, { key: "processName", align: "center", "show-overflow-tooltip": "", label: "单位", prop: "applicantName", "min-width": "120" }), e(t, { key: "deepenMete", prop: "deepenMete", align: "center", "show-overflow-tooltip": "", label: "清单量" }), e(t, { key: "processName", align: "center", "show-overflow-tooltip": "", label: "累计出库率", prop: "applicantName", "min-width": "120" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "累计出库" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "上月" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "本月" }), e(t, { key: "totalComplete", prop: "unit", align: "center", "show-overflow-tooltip": "", label: "差异率" })]), _: 1 }, 8, ["data", "max-height"])), [[f, m.value]]), e(N, { visible: a.value, "onUpdate:visible": l[0] || (l[0] = (h) => a.value = h), "detail-data": i.value, showType: n.value }, null, 8, ["visible", "detail-data", "showType"])]);
  };
} };
export {
  D as default
};
