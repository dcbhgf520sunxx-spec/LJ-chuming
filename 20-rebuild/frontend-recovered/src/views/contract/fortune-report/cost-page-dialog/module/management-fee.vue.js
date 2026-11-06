import { ref as u } from "vue";
import { watch as D } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as T } from "vue";
import { openBlock as k } from "vue";
import { createElementBlock as I } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as F } from "vue";
import { createVNode as a } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as C } from "vue";
import { toDisplayString as l } from "vue";
import { unref as r } from "vue";
import { ElTag as E } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { d as B } from "../../../../../modules/detail-fee-ef8adaab.js";
import { _ as N, t as R, o as S, bV as f, ba as H } from "../../../../../shared/runtime.js";
const M = { class: "app-container" }, O = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, P = { style: { width: "300px" } }, q = { __name: "management-fee", props: { costTypeData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(m) {
  const { decimalPrecision: p } = R(), o = m, y = u(), d = u([]), { maxHeight: b } = S({ paginate: true });
  D(() => {
    var e;
    return (e = o.costTypeData) == null ? void 0 : e.projectId;
  }, (e) => {
    h();
  }, { immediate: true, deep: true });
  async function h() {
    var e;
    try {
      const { content: n } = await B({ projectId: (e = o.costTypeData) == null ? void 0 : e.projectId });
      d.value = n || [];
    } catch (n) {
      console.log("获取管理费失败", n);
    }
  }
  function g(e) {
    return H(e, { props: [["amount", p.value.contract]], toThousandFields: ["amount"] });
  }
  return (e, n) => {
    const v = _("print-table"), x = E, i = V, w = _("common-table"), j = T("permission");
    return k(), I("div", M, [s("div", O, [s("div", P, [F(a(v, { "api-key": "managementFee", params: { projectId: o.costTypeData.projectId }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[j, m.permission.print]])]), a(x, null, { default: c(() => {
      var t;
      return [C("合计（单位：元）：" + l(r(f)((t = o.costTypeData) == null ? void 0 : t.amount)), 1)];
    }), _: 1 })]), a(w, { ref_key: "tableRef", ref: y, data: d.value, "empty-text": "暂无数据", "max-height": r(b), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": g }, { default: c(() => [a(i, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), a(i, { prop: "subject", key: "subject", label: "科目", align: "center" }, { default: c((t) => [s("span", null, l(t.row.subject), 1)]), _: 1 }), a(i, { prop: "amount", key: "amount", label: "总额（元）", align: "center" }, { default: c((t) => [s("span", null, l(r(f)(t.row.amount, r(p).contract)), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]);
  };
} }, A = N(q, [["__scopeId", "data-v-bf77e86f"]]);
export {
  A as default
};
