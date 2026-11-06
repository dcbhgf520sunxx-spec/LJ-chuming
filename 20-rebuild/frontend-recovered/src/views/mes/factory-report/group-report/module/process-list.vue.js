import { inject as m } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { createElementVNode as o } from "vue";
import { withDirectives as C } from "vue";
import { unref as i } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { toDisplayString as a } from "vue";
import { Fragment as B } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as E } from "element-plus";
import { o as H } from "../../../../../shared/runtime.js";
const W = { __name: "process-list", emits: ["nesting-task-click"], setup(N, { emit: u }) {
  const g = m("tableData"), h = m("loading"), _ = u;
  function f(r) {
    _("nesting-task-click", r);
  }
  const { maxHeight: w } = H({ paginate: false });
  return (r, c) => {
    const n = D, b = v("common-table"), k = E;
    return d(), x(B, null, [c[0] || (c[0] = o("div", { class: "head-container" }, null, -1)), C((d(), y(b, { "highlight-current-row": "", data: i(g), "return-source-data": "", "row-key": "id", stripe: false, "max-height": i(w) - 15, style: { width: "100%", cursor: "pointer" }, onCurrentChange: f }, { default: l(() => [s(n, { label: "序号", type: "index", align: "center", width: "60" }), s(n, { prop: "process.name", "show-overflow-tooltip": true, label: "工序", width: "80", align: "center" }, { default: l(({ row: e }) => {
      var t;
      return [o("span", null, a((t = e.process) == null ? void 0 : t.name), 1)];
    }), _: 1 }), s(n, { prop: "groups.name", "show-overflow-tooltip": true, label: "班组", "min-width": "100", "header-align": "center" }, { default: l(({ row: e }) => {
      var t, p;
      return [o("span", null, a((t = e.workshop) == null ? void 0 : t.name) + ">" + a((p = e.team) == null ? void 0 : p.name), 1)];
    }), _: 1 }), s(n, { prop: "netWeight", "show-overflow-tooltip": true, label: "产量（件/kg）", width: "140", align: "center" }, { default: l(({ row: e }) => [o("span", null, a(e.inspectionQuantity) + "/" + a(e.netWeight), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[k, i(h)]])], 64);
  };
} };
export {
  W as default
};
