import { ref as p } from "vue";
import { inject as V } from "vue";
import { watch as A } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as j } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { withDirectives as P } from "vue";
import { createBlock as m } from "vue";
import { withCtx as k } from "vue";
import { createCommentVNode as v } from "vue";
import { Fragment as I } from "vue";
import { ElDatePicker as T } from "element-plus";
import { ElTableColumn as B } from "element-plus";
import { vLoading as M } from "element-plus";
import { _ as Q, x as S, D as g, lo as Y, P as q } from "../../../../../../../shared/runtime.js";
import F from "../../../components/purchase-select.vue.js";
import { b as R } from "../../../../../../../modules/index-1f7d934b.js";
const E = { class: "header" }, O = { class: "table" }, H = { __name: "use-detail", setup(K) {
  const _ = p(), { crud: o, CRUD: f } = S({ title: "支出明细", queryOnPresenterCreated: false, crudApi: { get: R } }, _), { projectId: i, projectManagerName: h, contractSignBodyName: c, projectAttribute: C } = V("common"), s = /* @__PURE__ */ new Date(), u = p([new Date(s.getFullYear(), s.getMonth(), 1).getTime(), new Date(s.getFullYear(), s.getMonth() + 1, 0).getTime()]), t = p({ projectId: i.value, supplierId: void 0, supplierNumber: void 0 });
  f.HOOK.beforeToQuery = () => {
    t.value.startTime = u.value[0], t.value.endTime = u.value[1];
  };
  const x = p([["date", ["parse-time", "{y}-{d}-{m}"]], ["amount", ["to-thousand", g.YUAN]], ["signBodyPayAmount", ["to-thousand", g.YUAN]], ["projectManagerPayAmount", ["to-thousand", g.YUAN]]]);
  return A(() => i.value, (y) => {
    y && (o.query = t.value, o.toQuery());
  }, { immediate: true }), (y, r) => {
    const D = T, l = B, N = U("common-table"), w = M;
    return d(), j(I, null, [b("div", E, [a(D, { modelValue: u.value, "onUpdate:modelValue": r[0] || (r[0] = (n) => u.value = n), "end-placeholder": "结束时间", "range-separator": "至", "start-placeholder": "开始时间", type: "daterange", "value-format": "x", onChange: e(o).toQuery }, null, 8, ["modelValue", "onChange"]), a(Y, { modelValue: t.value.supplierId, "onUpdate:modelValue": r[1] || (r[1] = (n) => t.value.supplierId = n), "basic-class": t.value.basicClass, type: t.value.purchaseType, class: "filter-item", clearable: "", filterable: "", mode: "contain", placeholder: "筛选供应商", style: { width: "200px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "basic-class", "type", "onChange"]), a(F, { modelValue: t.value.orderId, "onUpdate:modelValue": r[2] || (r[2] = (n) => t.value.orderId = n), clearable: true, "project-id": e(i), style: { width: "300px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "project-id", "onChange"])]), b("div", O, [P((d(), m(N, { ref_key: "tableRef", ref: _, data: e(o).data, "data-format": x.value, "empty-text": e(o).emptyText, "summary-method": () => {
    }, "show-sumary": "" }, { default: k(() => [a(l, { align: "center", label: "序号", type: "index", width: "60" }), a(l, { align: "center", label: "日期", prop: "date" }), a(l, { align: "center", label: "供应商", prop: "supplier.supplierName" }), a(l, { align: "center", label: "采购合同号", prop: "supplierNumber" }), a(l, { align: "center", label: "凭证号", prop: "voucherNumber" }), a(l, { align: "center", label: "审批编号", prop: "approvalNumber" }), a(l, { align: "center", label: "支付金额", prop: "amount" }), e(c) && e(C) === 2 ? (d(), m(l, { key: 0, label: e(c), align: "center", prop: "signBodyPayAmount" }, null, 8, ["label"])) : v("", true), e(c) ? (d(), m(l, { key: 1, label: e(h), align: "center", prop: "projectManagerPayAmount" }, null, 8, ["label"])) : v("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text"])), [[w, e(o).loading]]), a(q)])], 64);
  };
} }, W = Q(H, [["__scopeId", "data-v-406af044"]]);
export {
  W as default
};
