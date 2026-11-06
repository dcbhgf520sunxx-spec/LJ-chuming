import { ref as g } from "vue";
import { inject as _ } from "vue";
import { computed as O } from "vue";
import { watch as Q } from "vue";
import { resolveComponent as p } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as M } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as e } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as F } from "vue";
import { withDirectives as G } from "vue";
import { unref as a } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as J } from "vue";
import { isRef as L } from "vue";
import { Fragment as W } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElPagination as X } from "element-plus";
import { a as Y, _ as Z } from "./detail-drawer.vue.js";
import { u as ee, J as te, o as oe, ba as ae } from "../../../../../../shared/runtime.js";
import { y as le } from "../../../../../../modules/bridge-86f96a4f.js";
const ne = { style: { display: "flex" } }, ue = { __name: "index", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, projectId: { type: Number } }, emits: ["update:visible"], setup(y, { emit: C }) {
  const x = C, v = g([]), c = g(false), b = g({}), n = y, D = _("monomerId"), k = _("areaId"), u = O(() => ({ productType: n.detailData.productType, projectId: n.projectId })), { visible: s, handleClose: h } = ee({ emit: x, props: n, field: "visible", showHook: d }), { handleSizeChange: I, handleCurrentChange: z, total: V, setTotalPage: j, queryPage: m } = te({ fetchHook: d });
  Q(() => s.value, (l) => {
    l && d();
  }, { deep: true });
  async function d() {
    let l = [];
    try {
      const { content: t = [], totalElements: f } = await Y({ processId: n.detailData.id, monomerId: D.value, areaId: k.value, ...u.value, ...m });
      j(f), l = t;
    } catch (t) {
      console.log("获取工序的生产明细失败", t);
    } finally {
      v.value = l;
    }
  }
  const { maxHeight: P } = oe({ paginate: true });
  function S(l) {
    c.value = true, b.value = l;
  }
  function q(l) {
    return ae(l, { props: ["quantity"] });
  }
  return (l, t) => {
    const f = p("print-table"), N = p("common-button"), o = A, T = K, E = p("common-table"), R = X, B = p("common-dialog"), H = $("permission");
    return M(), U(W, null, [e(B, { ref: "drawerRef", modelValue: a(s), "onUpdate:modelValue": t[0] || (t[0] = (i) => L(s) ? s.value = i : null), direction: "rtl", fullscreen: "", title: `${n.detailData.name}工序生产明细`, "before-close": a(h), "show-close": false, "close-on-click-modal": false, top: "10vh" }, { titleRight: r(() => [F("div", ne, [G(e(f, { "api-key": "bridgeProjectOverviewList", params: { ...u.value, processId: n.detailData.id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[H, a(le).print]]), e(N, { size: "default", style: { "margin-left": "8px" }, onClick: a(h) }, { default: r(() => t[2] || (t[2] = [w("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: r(() => [e(E, { ref: "tableRef", data: v.value, "max-height": a(P) + 115, "show-summary": "", "summary-method": q, style: { width: "100%" } }, { default: r(() => [e(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "length", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "单重（kg）", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "清单数", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "completeQuantity", label: "完成数", align: "center" }, { default: r(({ row: i }) => [e(T, { style: { cursor: "pointer" }, onClick: (ie) => S(i) }, { default: r(() => [w(J(i.completeQuantity), 1)]), _: 2 }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), e(R, { total: a(V), "current-page": a(m).pageNumber, "page-size": a(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(I), onCurrentChange: a(z) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "title", "before-close"]), e(Z, { visible: c.value, "onUpdate:visible": t[1] || (t[1] = (i) => c.value = i), query: u.value, "team-data": b.value }, null, 8, ["visible", "query", "team-data"])], 64);
  };
} };
export {
  ue as default
};
