import { ref as p } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as C } from "vue";
import { createBlock as i } from "vue";
import { withCtx as u } from "vue";
import { createCommentVNode as l } from "vue";
import { toDisplayString as f } from "vue";
import { createTextVNode as V } from "vue";
import { createElementVNode as W } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as G } from "element-plus";
import { vLoading as H } from "element-plus";
import { _ as M, uv as $, x as z, xq as c, xr as K, o as F, xs as h, G as R, j$ as y, P as Q, xt as J } from "../../../../shared/runtime.js";
import X from "./module/header.vue.js";
import "../../../../modules/warehouse-project-cascader-17e2b952.js";
const Y = { class: "app-container" }, Z = { key: 0 }, ee = { key: 2 }, te = { __name: "index", setup(ae) {
  const T = { add: false, edit: false, del: false, download: false }, E = p([]), g = p(), d = p(false), k = p({}), N = p(), j = p([...$, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: m, columns: s, CRUD: D } = z({ title: "入库金额调整审批", sort: ["id.desc"], invisibleColumns: [], permission: { ...c }, optShow: { ...T }, crudApi: { ...K } }, g), { maxHeight: P } = F({ paginate: true });
  function A(w, r) {
    N.value = r, k.value = w, d.value = true;
  }
  return D.HOOK.handleRefresh = async (w, { data: r }) => {
    r.content = r.content.map((t) => (t.showSerialNumber = t.adjustSerialNumber, t.reviewable = !!(t.reviewStatus === h.UNREVIEWED.V && R(c.audit)), t));
  }, (w, r) => {
    const t = q, x = _("table-cell-tag"), S = G, O = _("common-button"), B = _("common-table"), I = U("permission"), L = H;
    return a(), v("div", Y, [n(e(X)), C((a(), i(B, { ref_key: "tableRef", ref: g, data: e(m).data, "data-format": j.value, "default-expand-all": false, "expand-row-keys": E.value, "max-height": e(P), "row-key": "id" }, { default: u(() => [n(t, { align: "center", label: "序号", type: "index", width: "60" }), e(s).visible("adjustSerialNumber") ? (a(), i(t, { key: "adjustSerialNumber", "show-overflow-tooltip": true, align: "left", label: "调整单号", "min-width": "160", prop: "adjustSerialNumber" })) : l("", true), e(s).visible("purchaseSN") ? (a(), i(t, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: u(({ row: { sourceRow: o } }) => [n(x, { offset: 10, show: !!o.boolPartyA && !!o.purchaseSN, name: "甲供", type: "partyA" }, null, 8, ["show"]), o.purchaseSN ? (a(), v("span", Z, f(o.purchaseSN), 1)) : l("", true), o.boolPartyA ? (a(), i(S, { key: 1, effect: "dark", size: "default", type: "danger" }, { default: u(() => r[1] || (r[1] = [V("甲供")])), _: 1, __: [1] })) : (a(), v("span", ee, "-"))]), _: 1 })) : l("", true), e(s).visible("serialNumber") ? (a(), i(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" }, { default: u(({ row: { sourceRow: o } }) => {
      var b;
      return [o.inboundWay === e(y).OPENING_RECEIPT.V ? (a(), i(x, { key: 0, name: e(y).VL[o.inboundWay], color: (b = e(y).V[o.inboundWay]) == null ? void 0 : b.COLOR }, null, 8, ["name", "color"])) : l("", true), W("span", null, f(o.serialNumber), 1)];
    }), _: 1 })) : l("", true), e(s).visible("basicClass") ? (a(), i(t, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : l("", true), e(s).visible("projects") ? (a(), i(t, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : l("", true), e(s).visible("supplier.name") ? (a(), i(t, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : l("", true), e(s).visible("applicantName") ? (a(), i(t, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : l("", true), e(s).visible("reviewerName") ? (a(), i(t, { key: "reviewerName", "show-overflow-tooltip": true, align: "center", label: "审核人", "min-width": "100", prop: "reviewerName" })) : l("", true), e(s).visible("createTime") ? (a(), i(t, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "申请时间", prop: "createTime", width: "140" })) : l("", true), e(s).visible("reviewTime") ? (a(), i(t, { key: "reviewTime", "show-overflow-tooltip": true, align: "center", label: "审核时间", prop: "reviewTime", width: "140" })) : l("", true), e(s).visible("reviewStatus") ? (a(), i(t, { key: "reviewStatus", "show-overflow-tooltip": true, align: "center", fixed: "right", label: "审核状态", prop: "reviewStatus", width: "80" }, { default: u(({ row: o }) => [n(S, { type: e(h).V[o.reviewStatus].TAG }, { default: u(() => [V(f(e(h).VL[o.reviewStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : l("", true), e(R)(e(c).detail) ? (a(), i(t, { key: 11, align: "center", fixed: "right", label: "操作", width: "110px" }, { default: u(({ row: { sourceRow: o } }) => [C(n(O, { size: "default", icon: "el-icon-view", type: "primary", onClick: (b) => A(o) }, null, 8, ["onClick"]), [[I, e(c).detail]])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[L, e(m).loading]]), n(e(Q)), n(J, { modelValue: d.value, "onUpdate:modelValue": r[0] || (r[0] = (o) => d.value = o), form: k.value, submitType: N.value, onSuccess: e(m).toQuery }, null, 8, ["modelValue", "form", "submitType", "onSuccess"])]);
  };
} }, re = M(te, [["__scopeId", "data-v-7808ddbb"]]);
export {
  re as default
};
