import { ref as b } from "vue";
import { computed as G } from "vue";
import { resolveComponent as d } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as I } from "vue";
import { createBlock as M } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as P } from "vue";
import { toDisplayString as p } from "vue";
import { withDirectives as v } from "vue";
import { unref as o } from "vue";
import { createElementVNode as f } from "vue";
import { isRef as K } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElTooltip as X } from "element-plus";
import { ElPagination as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { u as $ } from "../../../../../../modules/main-material-track-74a129d5.js";
import { u as ee, J as te, o as ae, cO as oe, jl as ne, py as le, pz as ie, pA as se } from "../../../../../../shared/runtime.js";
const ue = { __name: "plate-use-record", props: { visible: { type: Boolean, default: false }, projectId: { type: Number }, info: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(g, { emit: B }) {
  const y = b(), N = B, r = g, { visible: _, handleClose: R } = ee({ emit: N, props: r, field: "visible", showHook: x }), { handleSizeChange: V, handleCurrentChange: S, total: j, setTotalPage: H, queryPage: h } = te({ fetchHook: x }), { maxHeight: E } = ae({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, y), w = b(false), u = b([]), k = G(() => {
    var i, s, n, c;
    return { projectId: r.projectId, basicId: (i = r.info) == null ? void 0 : i.basicId, configId: (s = r.info) == null ? void 0 : s.configId, material: (n = r.info) == null ? void 0 : n.material, thickness: (c = r.info) == null ? void 0 : c.thickness };
  });
  async function x() {
    try {
      w.value = true;
      const { content: i, totalElements: s } = await $({ ...k.value, ...h });
      H(s), u.value = i.map((n, c) => (n.rowId = c + "" + Math.random(), n)), oe(u.value), await ne(u.value, { toSmallest: false, toNum: false, accountingUnit: "kg", accountingPrecision: 2 });
    } catch (i) {
      console.log("获取钢材领用记录失败", i);
    } finally {
      w.value = false;
    }
  }
  return (i, s) => {
    const n = Q, c = d("print-table"), q = d("table-cell-tag"), l = W, A = X, D = d("common-table"), L = Y, U = d("common-drawer"), F = T("permission"), O = T("parse-time"), J = Z;
    return I(), M(U, { ref_key: "drawerRef", ref: y, title: "钢材领用记录", modelValue: o(_), "onUpdate:modelValue": s[0] || (s[0] = (e) => K(_) ? _.value = e : null), direction: "rtl", "before-close": o(R), size: "70%" }, { titleAfter: a(() => [t(n, { effect: "plain", size: "large" }, { default: a(() => {
      var e;
      return [P(" 清单量：" + p((e = g.info) == null ? void 0 : e.listMete) + "kg", 1)];
    }), _: 1 }), t(n, { effect: "plain", size: "large" }, { default: a(() => {
      var e;
      return [P(" 累计领用量：" + p((e = g.info) == null ? void 0 : e.useMete) + "kg", 1)];
    }), _: 1 })]), titleRight: a(() => [v(t(c, { "api-key": "mesMainMaterialTrackUseRecord", params: k.value, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[F, o(le).useRecordPrint]])]), content: a(() => [v((I(), M(D, { data: u.value, "max-height": o(E), style: { width: "100%" } }, { default: a(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }, { default: a(({ row: e, $index: m }) => [t(q, { show: !!e.boolPartyA, name: "甲供", type: "partyA" }, null, 8, ["show"]), f("span", null, p(m + 1), 1)]), _: 1 }), t(l, { prop: "classifyName", "show-overflow-tooltip": true, label: "名称", align: "center", "min-width": "140" }), t(l, { "show-overflow-tooltip": true, label: "规格", align: "center", "min-width": "200" }, { default: a(({ row: e }) => [t(A, { content: o(ie)(e), placement: "left" }, { default: a(() => [f("span", null, p(o(se)(e)), 1)]), _: 2 }, 1032, ["content"])]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "90" }), t(l, { prop: "mete", "show-overflow-tooltip": true, label: "重量(kg)", align: "center", width: "100" }), t(l, { prop: "reviewerName", "show-overflow-tooltip": true, label: "办理人", align: "center", width: "100" }), t(l, { prop: "recipient.name", "show-overflow-tooltip": true, label: "领用人", align: "center", "min-width": "120" }, { default: a(({ row: e }) => {
      var m, C, z;
      return [f("span", null, p((m = e.workshop) != null && m.name ? ((C = e.workshop) == null ? void 0 : C.name) + " > " : "") + p((z = e.recipient) == null ? void 0 : z.name), 1)];
    }), _: 1 }), t(l, { prop: "outboundTime", "show-overflow-tooltip": true, label: "日期", align: "center", width: "120px" }, { default: a(({ row: e }) => [v(f("span", null, null, 512), [[O, { val: e.outboundTime, fmt: "{y}-{m}-{d}" }]])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[J, w.value]]), t(L, { total: o(j), "current-page": o(h).pageNumber, "page-size": o(h).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(V), onCurrentChange: o(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
