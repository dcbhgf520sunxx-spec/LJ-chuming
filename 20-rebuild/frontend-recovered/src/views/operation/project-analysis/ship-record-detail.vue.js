import { ref as p } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as j } from "vue";
import { createBlock as D } from "vue";
import { withCtx as i } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as W } from "vue";
import { createElementVNode as C } from "vue";
import { unref as s } from "vue";
import { isRef as T } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { u as B, o as E, bZ as R, ch as z, ba as H } from "../../../shared/runtime.js";
import { b as M } from "../../../modules/project-overview-1b3937a7.js";
const O = { class: "head-container" }, L = { __name: "ship-record-detail", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object }, projectId: { type: Number }, detailData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(u, { emit: g }) {
  const f = p([]), b = p(), h = p(), w = p(), v = g, r = u, { visible: d, handleClose: y } = B({ emit: v, props: r, field: "visible", showHook: _ });
  async function _() {
    var t, m;
    let a = [];
    try {
      const { content: n = [] } = await M({ monomerId: (t = r.teamData.monomer) == null ? void 0 : t.id, areaId: (m = r.teamData.area) == null ? void 0 : m.id, ...r.query, productId: r.teamData.id });
      a = n;
    } catch (n) {
      console.log("获取发运记录详情失败", n);
    } finally {
      f.value = a;
    }
  }
  const { maxHeight: I } = E({ paginate: true });
  function N(a) {
    return H(a, { props: ["quantity", "totalNetWeight"] });
  }
  return (a, t) => {
    const m = U, n = c("print-table"), V = c("common-select"), o = q, k = c("common-table"), x = c("common-drawer");
    return j(), D(x, { ref: "drawerRef", title: "发运记录", modelValue: s(d), "onUpdate:modelValue": t[3] || (t[3] = (l) => T(d) ? d.value = l : null), direction: "rtl", "before-close": s(y), "close-on-click-modal": false, size: "60%" }, { titleAfter: i(() => [e(m, { type: "primary", size: "small" }, { default: i(() => [S("日期： " + W(), 1)]), _: 1 })]), titleRight: i(() => [e(n, { "api-key": a.apiKey, params: { ...a.params }, size: "mini", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])]), content: i(() => [C("div", O, [e(s(R), { monomerId: b.value, "onUpdate:monomerId": t[0] || (t[0] = (l) => b.value = l), areaId: h.value, "onUpdate:areaId": t[1] || (t[1] = (l) => h.value = l), needConvert: "", clearable: "", class: "filter-item", "project-id": u.projectId }, null, 8, ["monomerId", "areaId", "project-id"]), e(V, { modelValue: w.value, "onUpdate:modelValue": t[2] || (t[2] = (l) => w.value = l), options: s(z).ENUM, type: "enum", class: "filter-item", placeholder: "完成状态", style: { width: "160px" } }, null, 8, ["modelValue", "options"])]), e(k, { ref: "tableRef", data: f.value, "max-height": s(I), style: { width: "100%" }, "show-summary": "", "summary-method": N }, { default: i(() => [e(o, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(o, { "show-overflow-tooltip": true, prop: "monomerName", label: "单体", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "specification", label: "区域", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "material", label: "类型", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "quantity", label: "编号", align: "center", "min-width": "120" }), e(o, { "show-overflow-tooltip": true, prop: "netWeight", label: "规格", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "长度", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "材质", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "数量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "发运量", align: "center" }), e(o, { "show-overflow-tooltip": true, prop: "totalNetWeight", label: "单净重", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  L as default
};
