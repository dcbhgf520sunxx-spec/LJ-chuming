import { computed as $ } from "vue";
import { ref as p } from "vue";
import { provide as W } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as X } from "vue";
import { createBlock as a } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as l } from "vue";
import { createSlots as M } from "vue";
import { withModifiers as P } from "vue";
import { resolveDynamicComponent as Y } from "vue";
import { nextTick as x } from "vue";
import { ElTableColumn as Z } from "element-plus";
import { InfoFilled as ee } from "@element-plus/icons-vue";
import { ElIcon as te } from "element-plus";
import { ElTooltip as oe } from "element-plus";
import { vLoading as ne } from "element-plus";
import { c as ae } from "../../../../modules/payment-list-f26a95c8.js";
import { L as m } from "../../../../modules/project-19a12d6b.js";
import { _ as le, t as ie, x as se, o as re, br as ue, iF as B, G as d, P as ce, i as me } from "../../../../shared/runtime.js";
import pe from "./module/header.vue.js";
import de from "./module/invoice-record.vue.js";
import fe from "./module/payment-record.vue.js";
import ve from "./module/payment-application/index.vue.js";
import _e from "./module/settle-form.vue.js";
import "../../../../modules/payment-ledger-cb1d373c.js";
import "../../../../modules/payment-application-18cdaf45.js";
import "./module/payment-application/form.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
import "./module/payment-application/detail.vue.js";
const ye = { class: "app-container" }, be = { style: { display: "inline-block" } }, he = ["onClick"], ge = { style: { display: "inline-block" } }, ke = ["onClick"], we = { __name: "index", setup(Ce) {
  const { decimalPrecision: g } = ie(), U = { add: false, edit: false, del: false, download: false }, L = $(() => D.value === "invoice" ? de : fe), A = p(), z = p(), b = p(false), k = p(false), S = p("add"), F = $(() => [["signDate", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["paymentRate", ["to-fixed", 2]], ["invoiceRate", ["to-fixed", 2]], ["amount", ["to-thousand", g.value.project]], ["paymentAmount", ["to-thousand", g.value.project]], ["invoiceAmount", ["to-thousand", g.value.project]]]), { crud: w, columns: u, CRUD: H } = se({ title: "付款申请", sort: [], permission: { ...m }, crudApi: { ...ae }, invisibleColumns: [], optShow: { ...U } }, A), { maxHeight: O } = re({ paginate: true }), v = p({}), h = p(void 0), D = p(""), C = p(false);
  W("orderId", h), H.HOOK.handleRefresh = (c, { data: i }) => {
    i.content.forEach((t) => {
      t.paymentRate = t.amount ? (t.paymentAmount || 0) / (t.amount || 0) * 100 : 0, t.invoiceRate = t.amount ? (t.invoiceAmount || 0) / (t.amount || 0) * 100 : 0;
    });
  };
  function N(c, i) {
    d(m.detail) && (v.value = c, D.value = i, h.value = c.id, x(() => {
      C.value = true;
    }));
  }
  function q(c) {
    v.value = c, h.value = c.id, x(() => {
      b.value = true;
    });
  }
  function G(c) {
    S.value = me(c.settlementInfo) ? "edit" : "add", v.value = c, h.value = c.id, x(() => {
      k.value = true;
    });
  }
  return (c, i) => {
    const t = Z, T = ee, E = te, j = oe, I = R("common-button"), K = R("common-table"), Q = R("common-drawer"), J = ne;
    return n(), V("div", ye, [r(e(pe), { ref_key: "headerRef", ref: z }, null, 512), X((n(), a(K, { ref_key: "tableRef", ref: A, "data-format": F.value, data: e(w).data, style: { width: "100%" }, "max-height": e(O) }, { default: s(() => [r(t, { label: "序号", type: "index", align: "center", width: "60" }, { default: s(({ row: o, $index: _ }) => [r(ue, { show: o.boolSettlementStatus === !!e(B).SETTLED.V, name: "已结算", color: "#f56c6c" }, null, 8, ["show"]), f("span", null, y(_ + 1), 1)]), _: 1 }), e(u).visible("serialNumber") ? (n(), a(t, { "show-overflow-tooltip": "", key: "serialNumber", prop: "serialNumber", label: "订单编号", align: "center" })) : l("", true), e(u).visible("signDate") ? (n(), a(t, { "show-overflow-tooltip": "", key: "signDate", prop: "signDate", label: "签订日期", align: "center", width: "100" })) : l("", true), e(u).visible("project") ? (n(), a(t, { "show-overflow-tooltip": "", key: "project", prop: "project", label: "所属项目", "min-width": "130" })) : l("", true), e(u).visible("supplierName") ? (n(), a(t, { "show-overflow-tooltip": "", key: "supplierName", prop: "supplierName", label: "分包单位", "min-width": "110" })) : l("", true), e(u).visible("amount") ? (n(), a(t, { prop: "amount", key: "amount", label: "合同额", align: "right", "show-overflow-tooltip": "" })) : l("", true), e(u).visible("settlementAmount") ? (n(), a(t, { prop: "settlementAmount", key: "settlementAmount", label: "结算额", align: "right", "show-overflow-tooltip": "" })) : l("", true), e(u).visible("subcontractClassName") ? (n(), a(t, { "show-overflow-tooltip": "", key: "subcontractClassName", prop: "subcontractClassName", label: "分类" })) : l("", true), e(u).visible("paymentAmount") ? (n(), a(t, { prop: "paymentAmount", key: "paymentAmount", label: "付款额", align: "right", "show-overflow-tooltip": "" }, M({ default: s(({ row: o }) => [e(d)(e(m).paymentManage.get) ? (n(), V("div", { key: 0, type: "warning", class: "clickable", onClick: P((_) => N(o, "payment"), ["stop"]) }, y(o.paymentAmount), 9, he)) : l("", true)]), _: 2 }, [e(d)(e(m).detail) ? { name: "header", fn: s(() => [r(j, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: s(() => [f("div", be, [i[3] || (i[3] = f("span", null, "付款额 ", -1)), r(E, null, { default: s(() => [r(T)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : l("", true), e(u).visible("paymentRate") ? (n(), a(t, { key: "paymentRate", prop: "paymentRate", label: "付款比例", align: "center", width: "80" }, { default: s(({ row: o }) => [f("span", null, y(o.paymentRate) + "%", 1)]), _: 1 })) : l("", true), e(u).visible("invoiceAmount") ? (n(), a(t, { prop: "invoiceAmount", key: "invoiceAmount", label: "收票额", align: "right", "min-width": "120", "show-overflow-tooltip": "" }, M({ default: s(({ row: o }) => [e(d)(e(m).invoice) ? (n(), V("div", { key: 0, class: "clickable", onClick: P((_) => N(o, "invoice"), ["stop"]) }, y(o.invoiceAmount), 9, ke)) : l("", true)]), _: 2 }, [e(d)(e(m).detail) ? { name: "header", fn: s(() => [r(j, { effect: "light", placement: "top", content: "点击行可以查看详情" }, { default: s(() => [f("div", ge, [i[4] || (i[4] = f("span", null, "收票额 ", -1)), r(E, null, { default: s(() => [r(T)]), _: 1 })])]), _: 1 })]), key: "0" } : void 0]), 1024)) : l("", true), e(u).visible("invoiceRate") ? (n(), a(t, { key: "invoiceRate", prop: "invoiceRate", label: "收票比例", align: "center", width: "80" }, { default: s(({ row: o }) => [f("span", null, y(o.invoiceRate) + "%", 1)]), _: 1 })) : l("", true), e(d)([...e(m).settle, ...e(m).paymentManage.get]) ? (n(), a(t, { key: 11, label: "操作", width: "120px", align: "center" }, { default: s(({ row: o }) => [e(d)(e(m).paymentManage.get) ? (n(), a(I, { key: 0, type: "primary", icon: "el-icon-plus", size: "default", onClick: (_) => q(o) }, null, 8, ["onClick"])) : l("", true), o.boolSettlementStatus !== !!e(B).SETTLED.V && !o.unCheckSettlementCount && e(d)(e(m).settle) ? (n(), a(I, { key: 1, type: "success", icon: "el-icon-money", size: "default", onClick: (_) => G(o) }, null, 8, ["onClick"])) : l("", true)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[J, e(w).loading]]), r(e(ce)), (n(), a(Y(L.value), { modelValue: C.value, "onUpdate:modelValue": i[0] || (i[0] = (o) => C.value = o), permission: e(m), "detail-info": v.value }, null, 8, ["modelValue", "permission", "detail-info"])), r(Q, { ref: "drawerRef", "show-close": true, size: "80%", title: "付款申请记录", "append-to-body": "", modelValue: b.value, "onUpdate:modelValue": i[1] || (i[1] = (o) => b.value = o), "close-on-click-modal": false }, { content: s(() => [r(e(ve), { visibleValue: b.value, "detail-info": v.value }, null, 8, ["visibleValue", "detail-info"])]), _: 1 }, 8, ["modelValue"]), r(e(_e), { modelValue: k.value, "onUpdate:modelValue": i[2] || (i[2] = (o) => k.value = o), "detail-info": v.value, onSuccess: e(w).toQuery, showType: S.value }, null, 8, ["modelValue", "detail-info", "onSuccess", "showType"])]);
  };
} }, Be = le(we, [["__scopeId", "data-v-21fd0a0c"]]);
export {
  Be as default
};
