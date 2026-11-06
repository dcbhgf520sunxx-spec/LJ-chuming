import { ref as V } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as k } from "vue";
import { createBlock as N } from "vue";
import { withCtx as c } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { createElementVNode as S } from "vue";
import { toDisplayString as u } from "vue";
import { isRef as q } from "vue";
import { ElTableColumn as B } from "element-plus";
import { ElPagination as H } from "element-plus";
import { u as I, J as P, o as E } from "../../../../../../shared/runtime.js";
import { b as L } from "../../../../../../modules/project-overview-1b3937a7.js";
const O = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object } }, emits: ["update:visible"], setup(h, { emit: b }) {
  const d = V([]), _ = b, o = h, { visible: i, handleClose: w } = I({ emit: _, props: o, field: "visible", showHook: g }), { handleSizeChange: y, handleCurrentChange: v, total: C, setTotalPage: x, queryPage: s } = P({ fetchHook: g });
  async function g() {
    var n, e;
    let p = [];
    try {
      const { content: l = [], totalElements: m } = await L({ monomerId: (n = o.teamData.monomer) == null ? void 0 : n.id, areaId: (e = o.teamData.area) == null ? void 0 : e.id, ...o.query, productId: o.teamData.id, ...s });
      x(m), p = l;
    } catch (l) {
      console.log("获取班组任务详情失败", l);
    } finally {
      d.value = p;
    }
  }
  const { maxHeight: z } = E({ paginate: true });
  return (p, n) => {
    const e = B, l = f("common-table"), m = H, D = f("common-drawer");
    return k(), N(D, { ref: "drawerRef", title: "班组任务详情", modelValue: t(i), "onUpdate:modelValue": n[0] || (n[0] = (r) => q(i) ? i.value = r : null), direction: "rtl", "before-close": t(w), size: 1e3 }, { content: c(() => [a(l, { ref: "tableRef", data: d.value, "max-height": t(z), style: { width: "100%" } }, { default: c(() => [a(e, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(e, { "show-overflow-tooltip": true, prop: "productionLine", label: "产线>班组", align: "center" }, { default: c(({ row: r }) => [S("span", null, u(r.workshop.name) + ">" + u(r.productionLine.name) + ">" + u(r.groupName), 1)]), _: 1 }), a(e, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), a(e, { "show-overflow-tooltip": true, prop: "quantity", label: "任务数", align: "center" }), a(e, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "完成数", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), a(m, { total: t(C), "current-page": t(s).pageNumber, "page-size": t(s).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: t(y), onCurrentChange: t(v) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
