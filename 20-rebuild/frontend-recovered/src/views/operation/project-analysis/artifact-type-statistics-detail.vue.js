import { ref as m } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as x } from "vue";
import { createBlock as j } from "vue";
import { withCtx as d } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as D } from "vue";
import { unref as i } from "vue";
import { isRef as S } from "vue";
import { ElTableColumn as W } from "element-plus";
import { u as C, o as U, bZ as q, ch as B, ba as R } from "../../../shared/runtime.js";
import { b as E } from "../../../modules/project-overview-1b3937a7.js";
const H = { class: "head-container" }, O = { __name: "artifact-type-statistics-detail", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object }, projectId: { type: Number } }, emits: ["update:visible"], setup(u, { emit: g }) {
  const f = m([]), b = m(), w = m(), h = m(), v = g, r = u, { visible: c, handleClose: y } = C({ emit: v, props: r, field: "visible", showHook: _ });
  async function _() {
    var t, s;
    let a = [];
    try {
      const { content: n = [] } = await E({ monomerId: (t = r.teamData.monomer) == null ? void 0 : t.id, areaId: (s = r.teamData.area) == null ? void 0 : s.id, ...r.query, productId: r.teamData.id });
      a = n;
    } catch (n) {
      console.log("获取构件类型统计详情记录失败", n);
    } finally {
      f.value = a;
    }
  }
  const { maxHeight: I } = U({ paginate: true });
  function N(a) {
    return R(a, { props: ["quantity", "totalNetWeight"] });
  }
  return (a, t) => {
    const s = p("print-table"), n = p("common-select"), o = W, V = p("common-table"), k = p("common-drawer");
    return x(), j(k, { ref: "drawerRef", title: "构件类型统计", modelValue: i(c), "onUpdate:modelValue": t[3] || (t[3] = (l) => S(c) ? c.value = l : null), direction: "rtl", "close-on-click-modal": false, "before-close": i(y), size: "60%" }, { titleRight: d(() => [e(s, { "api-key": a.apiKey, params: { ...a.params }, size: "mini", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])]), content: d(() => [D("div", H, [e(i(q), { monomerId: b.value, "onUpdate:monomerId": t[0] || (t[0] = (l) => b.value = l), areaId: w.value, "onUpdate:areaId": t[1] || (t[1] = (l) => w.value = l), needConvert: "", clearable: "", class: "filter-item", "project-id": u.projectId }, null, 8, ["monomerId", "areaId", "project-id"]), e(n, { modelValue: h.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => h.value = l), options: i(B).ENUM, type: "enum", class: "filter-item", placeholder: "完成状态", style: { width: "160px" } }, null, 8, ["modelValue", "options"])]), e(V, { ref: "tableRef", data: f.value, "max-height": i(I), style: { width: "100%" }, "show-summary": "", "summary-method": N }, { default: d(() => [e(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "monomerName", label: "单体", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "区域", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "类型", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "编号", align: "center", "min-width": "120" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "规格", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "数量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "单净重", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
