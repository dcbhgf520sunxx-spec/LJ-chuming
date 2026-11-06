import { computed as j } from "vue";
import { ref as u } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as H } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { withDirectives as k } from "vue";
import { createBlock as s } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as S } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElTag as L } from "element-plus";
import { vLoading as M } from "element-plus";
import { c as O, m as $ } from "./module/detail.vue.js";
import { _ as z, t as G, x as q, o as F, c3 as p, G as T, P as J } from "../../../../shared/runtime.js";
import { O as r } from "../../../../modules/project-19a12d6b.js";
import K from "./module/header.vue.js";
const Q = { class: "app-container" }, W = { __name: "index", setup(X) {
  const { decimalPrecision: N } = G(), C = { add: false, edit: false, del: false, download: false }, D = j(() => [["project", ["parse-project", { onlyShortName: true }]], ["applyDate", ["parse-time", "{y}-{m}-{d}"]], ["visaAmount", ["to-thousand", N.value.project]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["approveTime", ["parse-time", "{y}-{m}-{d}"]]]), y = u(), d = u(false), f = u({}), g = u("detail"), { crud: c, CRUD: V } = q({ title: "分包签证", sort: [], permission: { ...r }, optShow: { ...C }, crudApi: { ...O }, hasPagination: true }, y), { maxHeight: R } = F({ paginate: true, extraHeight: 40 });
  V.HOOK.handleRefresh = (_, { data: i }) => {
    i.content.forEach((a) => {
      a.imgSrc = a.attachments && a.attachments.map((m) => m.imageUrl);
    });
  };
  function v(_, i) {
    f.value = _, d.value = true, g.value = i;
  }
  return (_, i) => {
    const a = I, m = L, b = h("common-button"), E = h("common-table"), P = H("permission"), A = M;
    return n(), B("div", Q, [t(e(K)), k((n(), s(E, { ref_key: "tableRef", ref: y, data: e(c).data, "data-format": D.value, "empty-text": e(c).emptyText, "max-height": e(R), style: { width: "100%", "margin-top": "10px" }, class: "collection-table", stripe: false, showEmptySymbol: false }, { default: l(() => [t(a, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), t(a, { key: "project", prop: "project", label: "所属项目", align: "center", "min-width": "120" }), t(a, { key: "supplierName", prop: "supplierName", label: "申请单位", align: "center" }), t(a, { key: "subcontractClassName", prop: "subcontractClassName", label: "分类", align: "center" }), t(a, { key: "applyDate", prop: "applyDate", label: "申请日期", align: "center" }), t(a, { key: "visaAmount", prop: "visaAmount", label: "申请签证额", align: "right" }), t(a, { key: "visaReasonName", prop: "visaReasonName", label: "签证原因", align: "center" }), t(a, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center" }, { default: l((o) => [o.row.auditStatus === e(p).REJECT.V ? (n(), s(m, { key: 0, type: "warning" }, { default: l(() => [w(x(e(p).VL[o.row.auditStatus]), 1)]), _: 2 }, 1024)) : (n(), s(m, { key: 1, type: o.row.auditStatus === e(p).PASS.V ? "success" : "primary" }, { default: l(() => [w(x(e(p).VL[o.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 }), t(a, { key: "auditUserName", prop: "auditUserName", label: "审核人", align: "center" }), t(a, { key: "auditTime", prop: "auditTime", label: "审核日期", align: "center" }), t(a, { key: "approverName", prop: "approverName", label: "审批人", align: "center" }), t(a, { key: "approveTime", prop: "approveTime", label: "审批日期", align: "center" }), e(T)([...e(r).detail, ...e(r).audit]) ? (n(), s(a, { key: 0, label: "操作", width: "120px", align: "center" }, { default: l((o) => [k(t(b, { icon: "el-icon-view", type: "primary", size: "default", onClick: (U) => v(o.row, "detail") }, null, 8, ["onClick"]), [[P, e(r).detail]]), o.row.auditStatus === e(p).AUDITING.V && e(T)(e(r).audit) ? (n(), s(b, { key: 0, icon: "el-icon-stamp", type: "primary", size: "default", onClick: (U) => v(o.row, "audit") }, null, 8, ["onClick"])) : S("", true)]), _: 1 })) : S("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[A, e(c).loading]]), t(e($), { modelValue: d.value, "onUpdate:modelValue": i[0] || (i[0] = (o) => d.value = o), currentRow: f.value, showType: g.value, onSuccess: e(c).toQuery, permission: e(r) }, null, 8, ["modelValue", "currentRow", "showType", "onSuccess", "permission"]), t(e(J))]);
  };
} }, oe = z(W, [["__scopeId", "data-v-d42b7912"]]);
export {
  oe as default
};
