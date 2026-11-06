import { ref as c } from "vue";
import { inject as y } from "vue";
import { watch as b } from "vue";
import { onMounted as g } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as v } from "vue";
import { withDirectives as x } from "vue";
import { unref as o } from "vue";
import { createBlock as q } from "vue";
import { withCtx as w } from "vue";
import { createVNode as t } from "vue";
import { Fragment as A } from "vue";
import { ElTableColumn as C } from "element-plus";
import { vLoading as D } from "element-plus";
import { x as k, D as m, P as N } from "../../../../../../../shared/runtime.js";
import { e as P } from "../../../../../../../modules/index-1f7d934b.js";
const F = { __name: "assurance", emits: ["set-to-query"], setup(j, { emit: u }) {
  const d = u, n = c(), { crud: e } = k({ title: "保证金", crudApi: { get: P }, queryOnPresenterCreated: false }, n), { projectId: r } = y("common"), i = { projectId: r.value, type: 1 };
  b(() => r.value, (s) => {
    s && (e.query = i, e.toQuery());
  }, { immediate: true });
  const p = c([["date", ["parse-time", "{y}-{d}-{m}"]], ["amount", ["to-thousand", m.YUAN]], ["deduct", ["to-thousand", m.YUAN]]]);
  return g(() => {
    d("set-to-query", () => e.toQuery());
  }), (s, B) => {
    const a = C, _ = h("common-table"), f = D;
    return l(), v(A, null, [x((l(), q(_, { ref_key: "tableRef", ref: n, data: o(e).data, "data-format": p.value, "empty-text": o(e).emptyText }, { default: w(() => [t(a, { align: "center", label: "序号", type: "index", width: "60" }), t(a, { align: "center", label: "收款日期", prop: "date" }), t(a, { align: "center", label: "凭证号", prop: "voucherNumber" }), t(a, { align: "center", label: "金额（元）", prop: "amount" }), t(a, { align: "center", label: "保证金", prop: "deduct" })]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[f, o(e).loading]]), t(N)], 64);
  };
} };
export {
  F as default
};
