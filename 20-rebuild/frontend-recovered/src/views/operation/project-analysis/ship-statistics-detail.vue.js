import { ref as m } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as N } from "vue";
import { createBlock as D } from "vue";
import { withCtx as d } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as j } from "vue";
import { unref as s } from "vue";
import { isRef as S } from "vue";
import { ElTableColumn as C } from "element-plus";
import { u as U, o as B, bZ as M, ch as R, ba as q } from "../../../shared/runtime.js";
import { b as E } from "../../../modules/project-overview-1b3937a7.js";
const H = { class: "head-container" }, O = { __name: "ship-statistics-detail", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object }, projectId: { type: Number } }, emits: ["update:visible"], setup(u, { emit: v }) {
  const f = m([]), b = m(), h = m(), w = m(), g = v, r = u, { visible: c, handleClose: y } = U({ emit: g, props: r, field: "visible", showHook: _ });
  async function _() {
    var t, i;
    let a = [];
    try {
      const { content: n = [] } = await E({ monomerId: (t = r.teamData.monomer) == null ? void 0 : t.id, areaId: (i = r.teamData.area) == null ? void 0 : i.id, ...r.query, productId: r.teamData.id });
      a = n;
    } catch (n) {
      console.log("获取发运统计详情失败", n);
    } finally {
      f.value = a;
    }
  }
  const { maxHeight: I } = B({ paginate: true });
  function V(a) {
    return q(a, { props: ["quantity", "totalNetWeight"] });
  }
  return (a, t) => {
    const i = p("print-table"), n = p("common-select"), o = C, k = p("common-table"), x = p("common-drawer");
    return N(), D(x, { ref: "drawerRef", title: "发运统计详情", modelValue: s(c), "onUpdate:modelValue": t[3] || (t[3] = (l) => S(c) ? c.value = l : null), direction: "rtl", "before-close": s(y), "close-on-click-modal": false, size: "60%" }, { titleRight: d(() => [e(i, { "api-key": a.apiKey, params: { ...a.params }, size: "mini", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])]), content: d(() => [j("div", H, [e(s(M), { monomerId: h.value, "onUpdate:monomerId": t[0] || (t[0] = (l) => h.value = l), areaId: w.value, "onUpdate:areaId": t[1] || (t[1] = (l) => w.value = l), needConvert: "", clearable: "", class: "filter-item", "project-id": u.projectId }, null, 8, ["monomerId", "areaId", "project-id"]), e(n, { modelValue: b.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => b.value = l), options: s(R).ENUM, type: "enum", class: "filter-item", placeholder: "完成状态", style: { width: "160px" } }, null, 8, ["modelValue", "options"])]), e(k, { ref: "tableRef", data: f.value, "max-height": s(I), style: { width: "100%" }, "show-summary": "", "summary-method": V }, { default: d(() => [e(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "shipDate", label: "发运日期", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "carNumber", label: "车牌/船牌号", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "carModel", label: "车型", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "unit", label: "单位", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "theoryNetWeight", label: "理论重量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "overNetWeight", label: "过磅重量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "loss", label: "差值", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
