import { ref as l } from "vue";
import { inject as b } from "vue";
import { watch as x } from "vue";
import { onMounted as h } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as q } from "vue";
import { withDirectives as C } from "vue";
import { unref as o } from "vue";
import { createBlock as D } from "vue";
import { withCtx as m } from "vue";
import { createVNode as e } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as N } from "vue";
import { Fragment as k } from "vue";
import { ElTableColumn as A } from "element-plus";
import { vLoading as B } from "element-plus";
import { x as F, D as i, P } from "../../../../../../../shared/runtime.js";
import { f as j } from "../../../../../../../modules/index-1f7d934b.js";
const Q = { __name: "management", emits: ["set-to-query"], setup(R, { emit: d }) {
  const p = d, n = l(), { projectId: r } = b("common"), { crud: t } = F({ title: "管理费", crudApi: { get: j }, queryOnPresenterCreated: false }, n), u = { projectId: r.value, type: 2 };
  x(() => r.value, (s) => {
    s && (t.query = u, t.toQuery());
  }, { immediate: true });
  const _ = l([["date", ["parse-time", "{y}-{d}-{m}"]], ["amount", ["to-thousand", i.YUAN]], ["deduct", ["to-thousand", i.YUAN]]]);
  return h(() => {
    p("set-to-query", () => t.toQuery());
  }), (s, U) => {
    const a = A, f = v("common-table"), g = B;
    return c(), q(k, null, [C((c(), D(f, { ref_key: "tableRef", ref: n, data: o(t).data, "data-format": _.value, "empty-text": o(t).emptyText }, { default: m(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "收款日期", prop: "date" }), e(a, { align: "center", label: "凭证号", prop: "voucherNumber" }), e(a, { align: "center", label: "金额（元）", prop: "amount" }), e(a, { align: "center", label: "管理费率", prop: "rate" }, { default: m(({ row: y }) => [w("span", null, N((parseFloat(y.rate) / 100 * 100).toFixed(1)) + " %", 1)]), _: 1 }), e(a, { align: "center", label: "管理费（元）", prop: "deduct" })]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[g, o(t).loading]]), e(P)], 64);
  };
} };
export {
  Q as default
};
