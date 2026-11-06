import { ref as n } from "vue";
import { watch as A } from "vue";
import { provide as b } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as L } from "vue";
import { withDirectives as x } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as o } from "vue";
import { unref as c } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as u } from "vue";
import { createBlock as N } from "vue";
import { withModifiers as O } from "vue";
import { createTextVNode as Q } from "vue";
import { createCommentVNode as S } from "vue";
import { ElTableColumn as U } from "element-plus";
import { ElProgress as H } from "element-plus";
import { g as R } from "../process-detail/detail-drawer.vue.js";
import { _ as z, F as w, o as F, bZ as G, G as $ } from "../../../../../../shared/runtime.js";
import { y as X } from "../../../../../../modules/bridge-86f96a4f.js";
import Z from "../process-detail/index.vue.js";
const J = { class: "head-container" }, K = { __name: "index", props: { processData: { type: Object, default: () => {
} } }, setup(C) {
  const I = n(), y = n([]), m = n(), d = n(), p = n(), g = n([]), v = n(false), D = n([w.BOX, w.CELL, w.MACHINE_PART]), i = C;
  A(() => i.processData.id, (a) => {
    a && f();
  }), b("monomerId", d), b("areaId", p);
  const { maxHeight: j } = F({ extraBox: [".head-container"], paginate: true });
  async function f() {
    try {
      const a = await R({ productType: m.value, monomerId: d.value, areaId: p.value, projectId: i.processData.id });
      y.value = a;
    } catch (a) {
      console.log("获取项目下的工序清单", a);
    }
  }
  function P() {
    f();
  }
  function V() {
    f();
  }
  function T(a) {
    v.value = true, g.value = a;
  }
  return (a, t) => {
    const B = _("common-radio-button"), s = U, E = H, M = _("common-button"), q = _("common-table");
    return h(), L("div", null, [x(l("div", null, t[4] || (t[4] = [l("div", { class: "my-code" }, "点击左边表项目行查看详情", -1)]), 512), [[k, !i.processData.id]]), x(l("div", null, [l("div", J, [o(c(G), { monomerId: d.value, "onUpdate:monomerId": t[0] || (t[0] = (e) => d.value = e), areaId: p.value, "onUpdate:areaId": t[1] || (t[1] = (e) => p.value = e), needConvert: "", clearable: "", "project-id": i.processData.id, onChange: P }, null, 8, ["monomerId", "areaId", "project-id"]), o(B, { modelValue: m.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => m.value = e), options: D.value, showOptionAll: "", type: "enum", size: "default", class: "filter-item", onChange: V }, null, 8, ["modelValue", "options"])]), o(q, { ref_key: "tableRef", ref: I, data: y.value, "empty-text": "暂无数据", "max-height": c(j), "row-key": "id", style: { width: "100%" } }, { default: r(() => [o(s, { prop: "index", label: "序号", align: "center", width: "60px", type: "index" }), o(s, { align: "center", key: "name", prop: "name", "show-overflow-tooltip": true, label: "涉及工序", width: "100px" }, { default: r((e) => [l("span", null, u(e.row.name), 1)]), _: 1 }), o(s, { align: "center", key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "清单数（件）" }, { default: r((e) => [l("span", null, u(e.row.quantity), 1)]), _: 1 }), o(s, { align: "center", key: "mete", prop: "mete", "show-overflow-tooltip": true, label: "清单量（kg）" }, { default: r((e) => [l("span", null, u(e.row.mete), 1)]), _: 1 }), o(s, { align: "center", key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "完成（件）" }, { default: r((e) => [l("span", null, u(e.row.completeQuantity), 1)]), _: 1 }), o(s, { align: "center", key: "rate", prop: "rate", "show-overflow-tooltip": true, label: "完成率", "min-width": "150px" }, { default: r((e) => [o(E, { "text-inside": true, "stroke-width": 26, percentage: (e.row.completeQuantity / e.row.quantity * 100).toFixed(2), status: "success" }, null, 8, ["percentage"])]), _: 1 }), c($)(c(X).detail) ? (h(), N(s, { key: 0, align: "center", "show-overflow-tooltip": true, label: "操作" }, { default: r((e) => [o(M, { type: "primary", size: "default", onClick: O((W) => T(e.row), ["stop"]) }, { default: r(() => t[5] || (t[5] = [Q("查看")])), _: 2, __: [5] }, 1032, ["onClick"])]), _: 1 })) : S("", true)]), _: 1 }, 8, ["data", "max-height"]), o(Z, { visible: v.value, "onUpdate:visible": t[3] || (t[3] = (e) => v.value = e), "project-id": i.processData.id, "detail-data": g.value }, null, 8, ["visible", "project-id", "detail-data"])], 512), [[k, i.processData.id]])]);
  };
} }, le = z(K, [["__scopeId", "data-v-5bce31af"]]);
export {
  le as default
};
