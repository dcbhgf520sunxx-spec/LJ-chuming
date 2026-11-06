import { ref as j } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as P } from "vue";
import { createBlock as S } from "vue";
import { withCtx as d } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as N } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElPagination as B } from "element-plus";
import { l as s, u as H, J as I, o as L } from "../../../../../../shared/runtime.js";
function O(e) {
  return s({ module: "bridge", url: "kanban/project/year/page", method: "get", params: e });
}
function A(e) {
  return s({ module: "bridge", url: "kanban/project/process/summary", method: "get", params: e });
}
function G(e) {
  return s({ module: "bridge", url: "kanban/project/process/summary/detail/page", method: "get", params: e });
}
function T(e) {
  return s({ module: "bridge", url: "kanban/project/group/task/detail/page", method: "get", params: e });
}
const J = { get: O }, E = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object } }, emits: ["update:visible"], setup(e, { emit: _ }) {
  const b = j([]), y = _, n = e, { visible: u, handleClose: w } = H({ emit: y, props: n, field: "visible", showHook: f }), { handleSizeChange: v, handleCurrentChange: C, total: x, setTotalPage: k, queryPage: c } = I({ fetchHook: f });
  async function f() {
    var r, t;
    let p = [];
    try {
      const { content: l = [], totalElements: m } = await T({ monomerId: (r = n.teamData.monomer) == null ? void 0 : r.id, areaId: (t = n.teamData.area) == null ? void 0 : t.id, ...n.query, productId: n.teamData.id, ...c });
      k(m), p = l;
    } catch (l) {
      console.log("获取班组任务详情失败", l);
    } finally {
      b.value = p;
    }
  }
  const { maxHeight: D } = L({ paginate: true });
  return (p, r) => {
    const t = q, l = h("common-table"), m = B, z = h("common-drawer");
    return P(), S(z, { ref: "drawerRef", title: "班组任务详情", modelValue: a(u), "onUpdate:modelValue": r[0] || (r[0] = (i) => N(u) ? u.value = i : null), direction: "rtl", "before-close": a(w), size: 1e3 }, { content: d(() => [o(l, { ref: "tableRef", data: b.value, "max-height": a(D), style: { width: "100%" } }, { default: d(() => [o(t, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(t, { "show-overflow-tooltip": true, prop: "productionLine", label: "产线>班组", align: "center" }, { default: d(({ row: i }) => [V("span", null, g(i.workshop.name) + ">" + g(i.productionLine.name) + ">" + g(i.groupName), 1)]), _: 1 }), o(t, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), o(t, { "show-overflow-tooltip": true, prop: "quantity", label: "任务数", align: "center" }), o(t, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "完成数", align: "center" })]), _: 1 }, 8, ["data", "max-height"]), o(m, { total: a(x), "current-page": a(c).pageNumber, "page-size": a(c).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(v), onCurrentChange: a(C) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Q = Object.freeze(Object.defineProperty({ __proto__: null, default: E }, Symbol.toStringTag, { value: "Module" }));
export {
  E as _,
  G as a,
  J as c,
  Q as d,
  A as g
};
