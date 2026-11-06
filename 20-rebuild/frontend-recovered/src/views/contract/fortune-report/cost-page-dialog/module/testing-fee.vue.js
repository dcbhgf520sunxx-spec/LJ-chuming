import { ref as d } from "vue";
import { computed as N } from "vue";
import { watch as j } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as k } from "vue";
import { openBlock as D } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as P } from "vue";
import { createVNode as o } from "vue";
import { withCtx as y } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as S } from "vue";
import { unref as p } from "vue";
import { ElTag as C } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { h as B } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as E, t as R, o as H, bV as L, ba as M } from "../../../../../shared/runtime.js";
const O = { class: "app-container" }, q = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, z = { style: { width: "300px" } }, A = { __name: "testing-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(m) {
  const { decimalPrecision: n } = R(), r = m, h = d(), i = d([]), { maxHeight: g } = H({ paginate: true }), v = N(() => [["amount", ["to-thousand", n.value.contract]], ["mete", "to-thousand"], ["averagePrice", ["to-thousand", n.value.contract]]]);
  j(() => r.costTypeData.projectId, (e) => {
    w();
  }, { immediate: true, deep: true });
  function b(e) {
    return M(e, { props: [["amount", n.value.contract]], toThousandFields: ["to-thousand"] });
  }
  async function w() {
    try {
      const { content: e = [] } = await B({ projectId: r.costTypeData.projectId });
      if (e.length > 0) {
        const c = e.map((t) => Number(t.amount));
        let s = 0;
        c.every((t) => isNaN(t)) || (s = c.reduce((t, a) => {
          const l = Number(a);
          return isNaN(l) ? t : t + a;
        }, 0)), e[0].averagePrice = e[0].mete ? s / e[0].mete : s;
      }
      i.value = e || [];
    } catch (e) {
      console.log("检测费用", e);
    }
  }
  function x({ row: e, column: c, rowIndex: s, columnIndex: t }) {
    if (t === 3 || t === 4) return s === 0 ? { rowspan: i.value.length, colspan: 1 } : { rowspan: 0, colspan: 0 };
  }
  return (e, c) => {
    const s = _("print-table"), t = C, a = V, l = _("common-table"), T = k("permission");
    return D(), F("div", O, [f("div", q, [f("div", z, [P(o(s, { "api-key": "testingFee", params: { projectId: r.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[T, m.permission.print]])]), o(t, null, { default: y(() => {
      var u;
      return [I("合计（单位：元）：" + S(p(L)((u = r.costTypeData) == null ? void 0 : u.amount, p(n).contract)), 1)];
    }), _: 1 })]), o(l, { ref_key: "tableRef", ref: h, data: i.value, "empty-text": "暂无数据", "max-height": p(g), "row-key": "id", style: { width: "100%" }, "show-summary": "", "data-format": v.value, "summary-method": b, "span-method": x }, { default: y(() => [o(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(a, { prop: "testingFeeTypeName", key: "testingFeeTypeName", label: "科目", align: "center" }), o(a, { prop: "amount", key: "amount", label: "总额", align: "center" }), o(a, { prop: "mete", key: "mete", label: "累计产量（吨）", align: "center" }), o(a, { prop: "averagePrice", key: "averagePrice", label: "平均单价（元/吨）", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])]);
  };
} }, Q = E(A, [["__scopeId", "data-v-6ec0f096"]]);
export {
  Q as default
};
