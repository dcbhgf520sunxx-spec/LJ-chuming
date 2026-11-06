import { ref as c } from "vue";
import { inject as S } from "vue";
import { computed as C } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as g } from "vue";
import { createBlock as h } from "vue";
import { withCtx as t } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as l } from "vue";
import { withDirectives as y } from "vue";
import { unref as u } from "vue";
import { isRef as M } from "vue";
import { ElTag as O } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { vLoading as P } from "element-plus";
import { l as N, u as A, o as F } from "../../../../../shared/runtime.js";
function Q(i) {
  return N({ module: "bridge", url: "report/inspection/summary/passrate", method: "get", params: i });
}
function $(i) {
  return N({ module: "bridge", url: "report/inspection/summary/review", method: "get", params: i });
}
const W = { get: Q }, G = { __name: "detail", props: { visible: { type: Boolean, default: false }, info: { type: Object }, query: { type: Object } }, emits: ["update:visible"], setup(i, { emit: x }) {
  const b = c(), j = x, s = i, { visible: d, handleClose: q } = A({ emit: j, props: s, field: "visible", showHook: k }), T = S("permission"), D = c([["project", "parse-project"], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: V } = F({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, b), m = c(false), f = c([]), v = C(() => ({ productionLineId: s.info.productionLineId, startDate: s.query.startDate, endDate: s.query.endDate }));
  async function k() {
    try {
      f.value = [], m.value = true;
      const p = await $({ ...v.value });
      f.value = p.map((n, _) => (n.rowId = _ + "" + Math.random(), n));
    } catch (p) {
      console.log("获取质检报表详情", p);
    } finally {
      m.value = false;
    }
  }
  return (p, n) => {
    const _ = O, I = w("print-table"), o = E, L = w("common-table"), R = w("common-drawer"), B = U("permission"), H = P;
    return g(), h(R, { ref_key: "drawerRef", ref: b, title: "产线质检不合格列表", modelValue: u(d), "onUpdate:modelValue": n[0] || (n[0] = (e) => M(d) ? d.value = e : null), direction: "rtl", "before-close": u(q), size: "70%" }, { titleAfter: t(() => [a(_, { size: "large", effect: "plain" }, { default: t(() => [n[1] || (n[1] = z(" 生产线：")), r("span", null, l(i.info.productionLineName), 1)]), _: 1, __: [1] })]), titleRight: t(() => [y(a(I, { "api-key": "bridgeQHSEProductionLineReport", params: { ...v.value }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[B, u(T).print]])]), content: t(() => [y((g(), h(L, { data: f.value, "max-height": u(V), "data-format": D.value, "row-key": "rowId", style: { width: "100%" } }, { default: t(() => [a(o, { label: "序号", type: "index", align: "center", width: "60" }), a(o, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "150" }, { default: t(({ row: e }) => [r("span", null, l(e.project), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "artifactSerialNumber", label: "编号", align: "center" }, { default: t(({ row: e }) => [r("span", null, l(e.artifactSerialNumber), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, prop: "qualityType", label: "问题", align: "center" }, { default: t(({ row: e }) => [r("span", null, l(e.qualityType), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "productUserName", label: "制造人" }, { default: t(({ row: e }) => [r("span", null, l(e.productUserName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "InspectionUserName", label: "检验人" }, { default: t(({ row: e }) => [r("span", null, l(e.InspectionUserName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "processName", label: "工序", width: "120" }, { default: t(({ row: e }) => [r("span", null, l(e.processName), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "quantity", label: "数量", width: "100" }, { default: t(({ row: e }) => [r("span", null, l(e.quantity), 1)]), _: 1 }), a(o, { "show-overflow-tooltip": true, align: "center", prop: "createTime", label: "日期", width: "120" }, { default: t(({ row: e }) => [r("span", null, l(e.createTime), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[H, m.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = Object.freeze(Object.defineProperty({ __proto__: null, default: G }, Symbol.toStringTag, { value: "Module" }));
export {
  G as _,
  W as c,
  X as d
};
