import { ref as v } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as x } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as D } from "vue";
import { unref as n } from "vue";
import { isRef as j } from "vue";
import { ElTag as k } from "element-plus";
import { ElTableColumn as C } from "element-plus";
import { u as I, o as N, ba as T } from "../../../../shared/runtime.js";
import { b as q } from "../../../../modules/project-overview-1b3937a7.js";
const R = { __name: "safety-problem-statistics-detail", props: { visible: { type: Boolean, default: false }, teamData: { type: Object, default: () => {
} }, query: { type: Object }, auxiliaryData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(c, { emit: u }) {
  const m = v([{}, {}]), d = u, a = c, { visible: s, handleClose: f } = I({ emit: d, props: a, field: "visible", showHook: b });
  async function b() {
    var o, i;
    let l = [];
    try {
      const { content: e = [] } = await q({ monomerId: (o = a.teamData.monomer) == null ? void 0 : o.id, areaId: (i = a.teamData.area) == null ? void 0 : i.id, ...a.query, productId: a.teamData.id });
      l = e;
    } catch (e) {
      console.log("获取钢材出入库数据统计详情失败", e);
    } finally {
      m.value = l;
    }
  }
  const { maxHeight: w } = N({ paginate: true });
  function _(l) {
    return T(l, { props: ["quantity", "totalNetWeight"] });
  }
  return (l, o) => {
    const i = k, e = C, y = p("common-table"), g = p("common-drawer");
    return x(), V(g, { ref: "drawerRef", title: "年度一级质量问题统计", modelValue: n(s), "onUpdate:modelValue": o[0] || (o[0] = (h) => j(s) ? s.value = h : null), direction: "rtl", "before-close": n(f), size: "60%" }, { titleAfter: r(() => [t(i, { type: "primary", size: "small" }, { default: r(() => o[1] || (o[1] = [D(" 车间： 一车间 ")])), _: 1, __: [1] })]), content: r(() => [t(y, { ref: "tableRef", data: m.value, "max-height": n(w), style: { width: "100%" }, "show-summary": "", "summary-method": _ }, { default: r(() => [t(e, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(e, { "show-overflow-tooltip": true, prop: "problemName", label: "问题", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "specification", label: "年度", align: "center" }, { default: r(() => [t(e, { "show-overflow-tooltip": true, prop: "material", label: "2024-01", align: "center" }), t(e, { "show-overflow-tooltip": true, prop: "material", label: "2024-02", align: "center" })]), _: 1 }), t(e, { "show-overflow-tooltip": true, prop: "totalProblems", label: "合计", align: "center" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  R as default
};
